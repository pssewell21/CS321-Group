/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Controllers.TestDataListViewController;

/**
 *
 * @author pssew
 */
public class Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AesEncryptionSandbox s = new AesEncryptionSandbox();

        // Open the connection to the database when the application is launched
        TestDataListViewController c = new TestDataListViewController();

        try {
            s.run();
            c.load();
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }
    }
}
