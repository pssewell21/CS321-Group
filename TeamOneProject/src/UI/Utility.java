/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

/**
 *
 * @author pssew
 */
public final class Utility {
    
    private Utility() {
    }

    public static boolean hasValue(String string) {
        if (string == null) {
            return false;
        }

        return !string.isEmpty();
    }
}
