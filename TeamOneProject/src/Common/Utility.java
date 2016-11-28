/*
 * Copyright 2016 AUTHORS. Patrick S Sewell, Paul M Dyer, Taehyeok Lee, 
 * Benjamin C Ferguson, Hyunki J KIm Permission is granted to copy, distribute 
 * and/or modify this document under the terms of the GNU Free Documentation 
 * License, Version 1.3, (3 November 2008) or any later version published by 
 * the Free Software Foundation; with no Invariant Sections, with no 
 * Front-Cover Texts, and with no Back-Cover Texts. A copy of the license 
 * can be found at http://www.gnu.org/copyleft/fdl.html
 */
package Common;

import java.io.File;
import java.sql.Timestamp;

/**
 * Utility methods to perform validation of data and other common operations.
 *
 * @author Patrick Sewell
 */
public final class Utility {

    private Utility() {
    }

    /**
     * Checks if the string is not null and is not empty.
     *
     * @param string The string to check
     * @return The value describing if the string has a value
     */
    public static final boolean hasValue(String string) {
        if (string == null) {
            return false;
        }

        return !string.isEmpty();
    }

    /**
     * Checks if the string is a number.
     *
     * @param string The string to check
     * @return The value describing if the string is a number
     */
    public static boolean isNumeric(String string) {
        if (string == null) {
            return false;
        }
        
        return string.matches("-?\\d+(\\.\\d+)?");
    }

    /**
     * Checks if the string is a positive integer.
     *
     * @param string The string to check
     * @return The value describing if the string is a positive integer
     */
    public static boolean isPositiveInteger(String string) {
        if (string == null) {
            return false;
        }
        
        return string.matches("\\d+");
    }

    /**
     * Checks if the string is a valid date.
     *
     * Taken from
     * http://stackoverflow.com/questions/11480542/fastest-way-to-tell-if-a-string-is-a-valid-date
     * and adapted for use in our application
     *
     * @param dateString The string to check
     * @return The value describing if the string is a valid date
     */
    public static boolean isValidDate(String dateString) {
        if (dateString == null || dateString.length() != "yyyy-MM-dd".length() || dateString.charAt(4) != '-' || dateString.charAt(7) != '-') {
            return false;
        }

        int year = Integer.parseInt(dateString.substring(0, 4));
        int month = Integer.parseInt(dateString.substring(5, 7));
        int day = Integer.parseInt(dateString.substring(8, 10));

        // leap years calculation not valid before 1581
        boolean yearOk = (year >= 1581) && (year <= 2500);
        boolean monthOk = (month >= 1) && (month <= 12);
        boolean dayOk = (day >= 1) && (day <= daysInMonth(year, month));

        return (yearOk && monthOk && dayOk);
    }
    
    /**
     * Checks if the string is a valid social security number.
     * @param ssnString the string to check
     * @return The value that describes if the string is a valid social security number.
     */
    public static boolean isValidSocialSecurityNumber(String ssnString) {
        if (ssnString == null) {
            return false;
        }
        
        return ssnString.matches("^\\d{3}-\\d{2}-\\d{4}$");
    }

    /**
     * Gets the current time.
     *
     * @return The current time
     */
    public static final Timestamp getCurrentTime() {
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * Deletes files and folders recursively from a specified location.
     *
     * Taken from
     * http://stackoverflow.com/questions/20281835/how-to-delete-a-folder-with-files-using-java
     * and adapted for use in our application
     *
     * @param element The file or folder to delete
     * @return The value indicating the the deletion was successful
     */
    public static boolean deleteFile(File element) {
        if (element == null) {
            return false;
        }
        
        if (element.isDirectory()) {
            for (File sub : element.listFiles()) {
                deleteFile(sub);
            }
        }

        return element.delete();
    }

    // Taken from http://stackoverflow.com/questions/11480542/fastest-way-to-tell-if-a-string-is-a-valid-date
    // and adapted for use in our application
    private static int daysInMonth(int year, int month) {
        int daysInMonth;
        switch (month) {
            case 1: // fall through
            case 3: // fall through
            case 5: // fall through
            case 7: // fall through
            case 8: // fall through
            case 10: // fall through
            case 12:
                daysInMonth = 31;
                break;
            case 2:
                if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
                    daysInMonth = 29;
                } else {
                    daysInMonth = 28;
                }
                break;
            default:
                // returns 30 even for nonexistant months 
                daysInMonth = 30;
        }

        return daysInMonth;
    }
}
