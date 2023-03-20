package com.it_academy.final_proj.fitness.web.filter;

import com.it_academy.final_proj.fitness.core.dto.user.UserTokenCreate;
import com.it_academy.final_proj.fitness.db.entity.UserEntity;
import com.it_academy.final_proj.fitness.service.api.IAccountService;
import com.it_academy.final_proj.fitness.web.utils.JwtTokenHandler;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import static org.apache.logging.log4j.util.Strings.isEmpty;

@Component
public class JwtFilter extends OncePerRequestFilter {

	private final IAccountService accountService;
	private final JwtTokenHandler jwtHandler;

	public JwtFilter(IAccountService accountService, JwtTokenHandler jwtHandler) {
		this.accountService = accountService;
		this.jwtHandler = jwtHandler;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request,
	                                HttpServletResponse response,
	                                FilterChain chain)
			throws ServletException, IOException {

		final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
		if (isEmpty(header) || !header.startsWith("Bearer ")) {
			chain.doFilter(request, response);
			return;
		}

		final String token = header.split(" ")[1].trim();
		if (!jwtHandler.validate(token)) {
			chain.doFilter(request, response);
			return;
		}

		UserEntity user = accountService.getUserByMail(jwtHandler.getMail(token));
		UserTokenCreate userTokenCreate = new UserTokenCreate(user.getMail(), user.getRole().name(), user.getFio());


		UsernamePasswordAuthenticationToken
				authentication = new UsernamePasswordAuthenticationToken(
				userTokenCreate, null,
				userTokenCreate.getAuthorities());

		authentication.setDetails(
				new WebAuthenticationDetailsSource().buildDetails(request)
		);

		SecurityContextHolder.getContext().setAuthentication(authentication);
		chain.doFilter(request, response);
	}
}

