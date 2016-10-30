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
public interface ISqlGenerator {

    public String generateSelectCommand(HashMap<String, String> criteria);

    public String generateInsertCommand(HashMap<String, String> criteria);

    public String generateUpdateCommand(HashMap<String, String> criteria);

    public String generateDeleteCommand(HashMap<String, String> criteria);
}
