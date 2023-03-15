package com.it_academy.final_proj.fitness.util.generators;

import java.util.concurrent.ThreadLocalRandom;

public class VerificationCodeGenerator {

	public static String generate(){
		ThreadLocalRandom random = ThreadLocalRandom.current();
		return String.valueOf(random.nextLong());
	}
}
