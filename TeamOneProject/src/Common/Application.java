/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import Controllers.LogOnViewController;

/**
 *
 * @author pssew
 */
public class Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AesEncryption s = new AesEncryption();

        // Open the connection to the database when the application is launched
        //TestDataListViewController c = new TestDataListViewController();
        LogOnViewController m = new LogOnViewController();

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            
            s.run();
            //c.load();
            m.load();
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }
    }
}
