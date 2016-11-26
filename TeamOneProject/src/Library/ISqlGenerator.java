/*
 * Copyright 2016 AUTHORS. Patrick S Sewell, Paul M Dyer, Taehyeok Lee, 
 * Benjamin C Ferguson, Hyunki J KIm Permission is granted to copy, distribute 
 * and/or modify this document under the terms of the GNU Free Documentation 
 * License, Version 1.3, (3 November 2008) or any later version published by 
 * the Free Software Foundation; with no Invariant Sections, with no 
 * Front-Cover Texts, and with no Back-Cover Texts. A copy of the license 
 * can be found at http://www.gnu.org/copyleft/fdl.html
 */
package Library;

import java.util.HashMap;

/**
 *
 * @author Patrick Sewell
 */
public interface ISqlGenerator {

    /**
     * Generates a select SQL command based on the criteria passed in.
     * @param criteria The criteria to filter the select by
     * @return The SQL command to be executed
     */
    public String generateSelectCommand(HashMap<String, String> criteria);

    /**
     * Generates an insert SQL command based on the criteria passed in.
     * @param criteria The criteria to create the command with
     * @return The SQL command to be executed
     */
    public String generateInsertCommand(HashMap<String, String> criteria);

    /**
     * Generates an update SQL command based on the criteria passed in.
     * @param criteria The criteria to create the command with
     * @return The SQL command to be executed
     */
    public String generateUpdateCommand(HashMap<String, String> criteria);

    /**
     * Generates a delete SQL command based on the criteria passed in.
     * @param criteria The criteria to create the command with
     * @return The SQL command to be executed
     */
    public String generateDeleteCommand(HashMap<String, String> criteria);
}
