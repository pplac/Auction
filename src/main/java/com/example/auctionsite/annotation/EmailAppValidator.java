package com.example.auctionsite.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailAppValidator implements ConstraintValidator<EmailApp, String> {


    @Override
    public boolean isValid(String emailApp, ConstraintValidatorContext constraintValidatorContext) {

        final Pattern emailAppPattern = Pattern.compile("/^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$/");
        final Matcher matcher = emailAppPattern.matcher(emailApp);


        return matcher.find();
    }
}
