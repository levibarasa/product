/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atvanta.util;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
/**
 *
 * @author Levi
 */
public class Validator {
 public static boolean validateList(List listToValidate) {
        return listToValidate != null && listToValidate.size() > 0;
    }

    public static boolean validateObject(Object objectToValidate) {
        return objectToValidate != null;
    }

    public static boolean validateBlankString(String str) {
        return str != null && !str.equalsIgnoreCase("");
    }

    public static boolean validateListFirstObject(List listToValidate) {
        return listToValidate != null && listToValidate.size() > 0 && listToValidate.get(0) != null;
    }

    public static boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = str.charAt(i);
            if (c <= '/' || c >= ':') {
                return false;
            }
        }
        return true;
    }

    public static Date getZeroTimeDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static int getUserIDFromToken(String token) {
        return Integer.parseInt(token);
    }   
}
