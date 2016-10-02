/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import Controllers.TestDataController;
import DataAccess.JavaDB;
import java.sql.SQLException;

/**
 *
 * @author pssew
 */
public class Application 
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // Open the connection to the database when the application is launched
        JavaDB.openConnection();
        
        TestDataController c = new TestDataController();
        
        try
        {
            c.Run();
        }
        catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e)
        {
            ExceptionHandler.HandleException(e);
        }
        finally
        {
            // Close the connection to the database when closing the application
            JavaDB.closeConnection();
        }
    }   
}
