/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

import java.util.HashMap;

/**
 *
 * @author Owner
 */
public interface ISqlGenerator 
{
    public String generateSelect(HashMap<String, String> criteria);
    
    public String generateInsert(HashMap<String, String> criteria);
    
    public String generateUpdate(HashMap<String, String> criteria);
    
    public String generateDelete(HashMap<String, String> criteria);
}
