/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import java.io.File;
import java.sql.Timestamp;

/**
 *
 * @author pssew
 */
public final class Utility {

    private Utility() {
    }

    /**
     *
     * @param string
     * @return
     */
    public static final boolean hasValue(String string) {
        if (string == null) {
            return false;
        }

        return !string.isEmpty();
    }

    /**
     *
     * @param string
     * @return
     */
    public static boolean isNumeric(String string) {
        return string.matches("-?\\d+(\\.\\d+)?");
    }

    /**
     * Taken from http://stackoverflow.com/questions/11480542/fastest-way-to-tell-if-a-string-is-a-valid-date
     * and adapted for use in our application
     *
     * @param dateString
     * @return
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
     *
     * @return
     */
    public static final Timestamp getCurrentTime() {
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * Taken from http://stackoverflow.com/questions/20281835/how-to-delete-a-folder-with-files-using-java
     * and adapted for use in our application
     * @param element
     */
    public static void deleteFile(File element) {
        if (element.isDirectory()) {
            for (File sub : element.listFiles()) {
                deleteFile(sub);
            }
        }
        element.delete();
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
