package com.example.auctionsite.annotation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailAppValidator.class)
public @interface EmailApp {

    String message() default "Email is not valid!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
