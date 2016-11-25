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
public class User extends LibraryBase {

    // <editor-fold defaultstate="collapsed" desc="Member Variables">   
    /**
     *
     */
    public Long PersonId;

    /**
     *
     */
    public String UserName;

    /**
     *
     */
    public String Password;

    /**
     *
     */
    public String SecurityQuestion1;

    /**
     *
     */
    public String SecurityAnswer1;

    /**
     *
     */
    public String SecurityQuestion2;

    /**
     *
     */
    public String SecurityAnswer2;

    /**
     *
     */
    public Boolean IsAdministrator;

    /**
     *
     */
    public Boolean IsAccountLocked;

    /**
     *
     */
    public String SelectedTheme;

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
        PersonId = personId;
        UserName = userName;
        Password = password;
        SecurityQuestion1 = securityQuestion1;
        SecurityAnswer1 = securityAnswer1;
        SecurityQuestion2 = securityQuestion2;
        SecurityAnswer2 = securityAnswer2;
        IsAdministrator = isAdministrator;
        IsAccountLocked = isAccountLocked;
        SelectedTheme = selectedTheme;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Methods"> 
    @Override
    public String toString() {
        return DalFields.USER_NAME + ": " + UserName + ", "
                + DalFields.IS_ADMINISTRATOR + ": " + IsAdministrator + ", "
                + DalFields.IS_ACCOUNT_LOCKED + ": " + IsAccountLocked;
    }

    /**
     *
     * @return
     */
    @Override
    public HashMap<String, String> toHashMap() {
        HashMap<String, String> map = new HashMap<>();

        map.put(DalFields.ID, Id.toString());
        map.put(DalFields.PERSON_ID, PersonId.toString());
        map.put(DalFields.USER_NAME, UserName);
        map.put(DalFields.PASSWORD, Password);
        map.put(DalFields.SECURITY_QUESTION_1, SecurityQuestion1);
        map.put(DalFields.SECURITY_ANSWER_1, SecurityAnswer1);
        map.put(DalFields.SECURITY_QUESTION_2, SecurityQuestion2);
        map.put(DalFields.SECURITY_ANSWER_2, SecurityAnswer2);
        map.put(DalFields.IS_ADMINISTRATOR, IsAdministrator.toString());
        map.put(DalFields.IS_ACCOUNT_LOCKED, IsAccountLocked.toString());
        map.put(DalFields.SELECTED_THEME, SelectedTheme);

        return map;
    }

    // </editor-fold>   
}
