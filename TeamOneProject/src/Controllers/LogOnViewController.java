/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Common.UserSettings;
import Common.Utility;
import Database.DatabaseProvisioner;
import Library.DalFields;
import Library.User;
import Library.UserFactory;
import Views.LogOnView;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Owner
 */
public class LogOnViewController {

    // <editor-fold defaultstate="collapsed" desc="Member Variables"> 
    private final UserFactory factory;
    private LogOnView view;

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Constructors"> 

    /**
     *
     */
    public LogOnViewController() {
        factory = new UserFactory();
    }

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Methods"> 

    /**
     *
     */
    public void load() {
        view = new LogOnView(this);
    }

    /**
     *
     * @param userName
     * @param password
     * @return
     */
    public boolean executeLogOn(String userName, String password) {
        HashMap<String, String> criteria = new HashMap<>();
        criteria.put(DalFields.USER_NAME, userName);

        // Will return a list of 0 or 1 items
        List<User> result = factory.executeSelect(criteria);

        if (result.isEmpty()) {
            return false;
        }

        User user = result.get(0);

        if (user.password.equals(password)) {
            if (Utility.hasValue(user.selectedTheme)) {
                UserSettings.setSelectedTheme(user.selectedTheme);
            }

            if (user.isAdministrator) {
                AdminViewController c = new AdminViewController();
                c.load();
            } else if (!user.isAdministrator) {
                AtmViewController c = new AtmViewController();
                c.load(user);
            } else {
                System.out.println("IsAdministrator is NULL.");
            }

            view.dispose();

            return true;
        }

        return false;
    }

    /**
     *
     */
    public void executeProvisionDatabase() {
        //TODO: Add confirmation box with warning
        DatabaseProvisioner.provisionDatabase();
    }

    /**
     *
     */
    public void executeDeleteDatabase() {
        //TODO: Add confirmation box with warning
        DatabaseProvisioner.deleteDatabase();
    }

    // </editor-fold> 
}
