# FitnessStudio
URL'ы приложения:

- /api/v1/users/registration (POST) Самостоятельная регистрация пользователя (доступ без авторизации)
- /api/v1/users/verification (GET) Верификация самостоятельно зарегистрированного пользователя (доступ без авторизации)
- /api/v1/users/login (POST) Вход (доступ без авторизации)
- /api/v1/users/me (GET) Пользователь получает информацию "о себе" (доступ Role -> USER)


- /api/v1/users (POST) Добавление нового пользователя (доступ Role -> ADMIN)
- /api/v1/users (GET) Получить страницу пользователей. Параметры URL: page - номер страницы (по умолчанию 0)
                                                                      size - размер страницы (по умолчанию 20)
                                                       (доступ Role -> ADMIN)
- /api/v1/users/{uuid} (GET) Получить информацию о конкретном пользователе по UUID. Переменная пути - uuid пользователя
                                                       (доступ Role -> ADMIN)
- /api/v1/users/{uuid}/dt_update/{dt_update} (PUT) Обновить пользователя. Переменные пути: 
                                                                            uuid - id пользователя, которого нужно изменить
                                                                            dt_update - дата последнего изменеия пользователя (формат long) (доступ Role -> ADMIN)
                                                        
                                                       
                                                                            

- /api/v1/product (POST) Добавление нового продукта. (доступ Role -> ADMIN)
- /api/v1/product (GET) Получить страницу продуктов. Параметры URL: page - номер страницы (по умолчанию 0)
                                                                    size - размер страницы (по умолчанию 20)
                                                       (доступ без авторизации)
- /api/v1/product/{uuid}/dt_update/{dt_update} (PUT) Обновить продукт. Переменные пути: 
                                                                            uuid - id продукта, который нужно изменить
                                                                            dt_update - дата последнего изменеия продукта (формат long)  (доступ Role -> ADMIN)
                                                        
                                                       
- /api/v1/recipe (POST) Добавление нового рецепта. (доступ Role -> ADMIN)
- /api/v1/recipe (GET) Получить страницу рецептов. Параметры URL:   page - номер страницы (по умолчанию 0)
                                                                    size - размер страницы (по умолчанию 20)
                                                       (доступ без авторизации)
- /api/v1/recipe/{uuid}/dt_update/{dt_update} (PUT) Обновить рецепт. Переменные пути: 
                                                                            uuid - id рецепта, который нужно изменить
                                                                            dt_update - дата последнего изменеия рецепта (формат long)  (доступ Role -> ADMIN)
                                                        
                                                       
