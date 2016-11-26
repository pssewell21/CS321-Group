/*
 * Copyright 2016 AUTHORS. Patrick S Sewell, Paul M Dyer, Taehyeok Lee, 
 * Benjamin C Ferguson, Hyunki J KIm Permission is granted to copy, distribute 
 * and/or modify this document under the terms of the GNU Free Documentation 
 * License, Version 1.3, (3 November 2008) or any later version published by 
 * the Free Software Foundation; with no Invariant Sections, with no 
 * Front-Cover Texts, and with no Back-Cover Texts. A copy of the license 
 * can be found at http://www.gnu.org/copyleft/fdl.html
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
 * @author Patrick Sewell
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
