/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import Controllers.LogOnViewController;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * 
 * @author pssew
 */
public class Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LogOnViewController c = new LogOnViewController();

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }

            c.load();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            ExceptionHandler.handleException(e);
        }
    }
}
