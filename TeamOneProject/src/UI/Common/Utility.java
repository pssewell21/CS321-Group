/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Common;

/**
 *
 * @author pssew
 */
public final class Utility 
{
    public static boolean isNullOrEmpty(String string)
    {
        if (string == null)
        {
            return true;
        }
        
        return string.isEmpty();
    }
}
