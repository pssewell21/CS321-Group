/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Common;

import java.math.BigInteger;
import java.util.Random;

/**
 *
 * @author Owner
 */
public final class IdGenerator 
{
    private static final int MAX_BIT_LENGTH = 16;
    
    private IdGenerator()
    {        
    }
    
    public static BigInteger NewId()
    {
        Random random = new Random();
        BigInteger zero = new BigInteger("0");
        
        do
        {
            BigInteger id = new BigInteger(MAX_BIT_LENGTH, random);
                        
            if (id.compareTo(zero) > 0)
            {
                return id;
            }                     
        } while (true);
    }
}
