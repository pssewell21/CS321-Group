/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

/**
 *
 * @author Owner
 */
public interface ISqlGenerator 
{
    public String GenerateSelect();
    
    public String GenerateInsert();
    
    public String GenerateUpdate();
    
    public String GenerateDelete();
}
