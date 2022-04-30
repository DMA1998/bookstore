package com.mykh.bookstore.registration.email;

import javax.validation.Payload;

public @interface ValidEmail {

    String message() default "Invalid email";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
