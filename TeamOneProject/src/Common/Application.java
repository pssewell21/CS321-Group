/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import Common.AesEncryptionSandbox;
import Common.ExceptionHandler;
import Controllers.TestDataListViewController;
import Database.DatabaseProvisioner;

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
            //DatabaseProvisioner.provisionDatabase();
            c.load();
            s.run();
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }
    }
}
