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

import javax.swing.JOptionPane;

/**
 * Used to handle exceptions gracefully and provide feedback to the user.
 *
 * @author Patrick Sewell
 */
public final class ExceptionHandler {

    private ExceptionHandler() {
    }

    /**
     * Displays exception text to the user in a popup dialog.
     *
     * @param e The exception containing information about why an operation
     * failed
     */
    public static final void handleException(Exception e) {
        System.out.println(e.toString());
        JOptionPane.showMessageDialog(null, e.toString(), "Exception Message", JOptionPane.INFORMATION_MESSAGE);
    }
}
