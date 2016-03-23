package com.richardcsantana.utils;

import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by richardsantana on 23/03/16.
 */
@Component
public class PersonalDateProvider implements DateTimeProvider{
    @Override
    public Calendar getNow() {
        return GregorianCalendar.getInstance();
    }
}
