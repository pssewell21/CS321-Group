/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import java.sql.Timestamp;

/**
 *
 * @author pssew
 */
public final class Utility {
    
    private Utility() {
    }

    public static final boolean hasValue(String string) {
        if (string == null) {
            return false;
        }

        return !string.isEmpty();
    }
    
    public static final Timestamp getCurrentTime() {
        return new Timestamp(System.currentTimeMillis());   
    }    
}
