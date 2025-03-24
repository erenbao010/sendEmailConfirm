package com.sendEmailSpringBoot.demo.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AgeValidator implements ConstraintValidator<AgeValidation, String> {

    private static final String pattern = "yyyy-MM-dd";
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    private int min;

    @Override
    public boolean isValid(String dateStr, ConstraintValidatorContext context) {
        if (dateStr == null || dateStr.trim().isEmpty()) {
            System.out.println("❌ Date is null or empty");
            return false;
        }
        Date date;
        try {
            date = simpleDateFormat.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("❌ Invalid date format: " + dateStr);
            return false;
        }
        Calendar birthCalendar = Calendar.getInstance();
        birthCalendar.setTime(date);
        Calendar today = Calendar.getInstance();
        int age = today.get(Calendar.YEAR) - birthCalendar.get(Calendar.YEAR);
        if (today.get(Calendar.DAY_OF_YEAR) < birthCalendar.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }
        System.out.println("📌 Birthdate: " + birthCalendar.getTime() + " - Age: " + age);
        return age >= 18;
    }

    @Override
    public void initialize(AgeValidation ageValidation) {
        ConstraintValidator.super.initialize(ageValidation);
        min = ageValidation.min();
    }
}

