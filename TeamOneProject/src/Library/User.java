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
public class User extends LibraryBase {

    // <editor-fold defaultstate="collapsed" desc="Member Variables">   
    /**
     *
     */
    public Long personId;

    /**
     *
     */
    public String userName;

    /**
     *
     */
    public String password;

    /**
     *
     */
    public String securityQuestion1;

    /**
     *
     */
    public String securityAnswer1;

    /**
     *
     */
    public String securityQuestion2;

    /**
     *
     */
    public String securityAnswer2;

    /**
     *
     */
    public Boolean isAdministrator;

    /**
     *
     */
    public Boolean isAccountLocked;

    /**
     *
     */
    public String selectedTheme;

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Constructors"> 
    /**
     * This constructor is used for creating new objects
     */
    public User() {
        super();
    }

    /**
     * This constructor is used for mapping existing objects
     *
     * @param id
     * @param personId
     * @param userName
     * @param password
     * @param securityQuestion1
     * @param securityAnswer1
     * @param securityQuestion2
     * @param securityAnswer2
     * @param isAdministrator
     * @param isAccountLocked
     * @param selectedTheme
     */
    public User(Long id,
            Long personId,
            String userName,
            String password,
            String securityQuestion1,
            String securityAnswer1,
            String securityQuestion2,
            String securityAnswer2,
            Boolean isAdministrator,
            Boolean isAccountLocked,
            String selectedTheme) {
        super(id);
        this.personId = personId;
        this.userName = userName;
        this.password = password;
        this.securityQuestion1 = securityQuestion1;
        this.securityAnswer1 = securityAnswer1;
        this.securityQuestion2 = securityQuestion2;
        this.securityAnswer2 = securityAnswer2;
        this.isAdministrator = isAdministrator;
        this.isAccountLocked = isAccountLocked;
        this.selectedTheme = selectedTheme;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Methods"> 
    @Override
    public String toString() {
        return DalFields.USER_NAME + ": " + userName + ", "
                + DalFields.IS_ADMINISTRATOR + ": " + isAdministrator + ", "
                + DalFields.IS_ACCOUNT_LOCKED + ": " + isAccountLocked;
    }

    /**
     *
     * @return
     */
    @Override
    public HashMap<String, String> toHashMap() {
        HashMap<String, String> map = new HashMap<>();

        map.put(DalFields.ID, id.toString());
        map.put(DalFields.PERSON_ID, personId.toString());
        map.put(DalFields.USER_NAME, userName);
        map.put(DalFields.PASSWORD, password);
        map.put(DalFields.SECURITY_QUESTION_1, securityQuestion1);
        map.put(DalFields.SECURITY_ANSWER_1, securityAnswer1);
        map.put(DalFields.SECURITY_QUESTION_2, securityQuestion2);
        map.put(DalFields.SECURITY_ANSWER_2, securityAnswer2);
        map.put(DalFields.IS_ADMINISTRATOR, isAdministrator.toString());
        map.put(DalFields.IS_ACCOUNT_LOCKED, isAccountLocked.toString());
        map.put(DalFields.SELECTED_THEME, selectedTheme);

        return map;
    }

    // </editor-fold>   
}
