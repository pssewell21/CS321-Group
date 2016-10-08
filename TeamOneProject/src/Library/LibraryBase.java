/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

import UI.Common.IdGenerator;
import java.math.BigInteger;

/**
 *
 * @author Owner
 */
public abstract class LibraryBase 
{
    protected BigInteger Id;
    
    protected LibraryBase()
    {
        Id = IdGenerator.NewId();
    }
}
