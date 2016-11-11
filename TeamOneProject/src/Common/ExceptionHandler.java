/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import javax.swing.JOptionPane;

/**
 *
 * @author pssew
 */
public final class ExceptionHandler {

    private ExceptionHandler() {
    }

    /**
     *
     * @param e
     */
    public static void handleException(Exception e) {
        System.out.println(e.toString());
        JOptionPane.showMessageDialog(null, e.toString(), "Exception Message", JOptionPane.INFORMATION_MESSAGE);
    }
}
