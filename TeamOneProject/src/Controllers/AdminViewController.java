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

import Common.ExceptionHandler;
import Views.AdminView;
import java.sql.SQLException;

/**
 * The controller that handles interaction between the view and library.
 *
 * @author Patrick Sewell
 */
public class AdminViewController {
    // <editor-fold defaultstate="collapsed" desc="Member Variables"> 

    private AdminView view;

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Constructors"> 
    /**
     * Initializes the controller.
     */
    public AdminViewController() {
    }

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Methods"> 
    /**
     * Loads the AdminView.
     */
    public void load() {
        view = new AdminView(this);
    }

    /**
     * Loads the Person list view.
     */
    public void executeNavigatePersonList() {
        try {
            PersonListViewController p = new PersonListViewController();
            p.load();
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            ExceptionHandler.handleException(e);
        }
    }

    /**
     * Loads the User list view.
     */
    public void executeNavigateUserList() {
        try {
            UserListViewController t = new UserListViewController();
            t.load();
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            ExceptionHandler.handleException(e);
        }
    }

    /**
     * Loads the Account list view.
     */
    public void executeNavigateAccountList() {
        try {
            AccountListViewController t = new AccountListViewController();
            t.load();
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            ExceptionHandler.handleException(e);
        }
    }

    /**
     * Loads the AccountPersonMap list view.
     */
    public void executeNavigateAccountPersonMapList() {
        try {
            AccountPersonMapListViewController t = new AccountPersonMapListViewController();
            t.load();
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            ExceptionHandler.handleException(e);
        }
    }

    /**
     * Exits the application.
     */
    public void executeQuit() {
        System.exit(0);
    }

    // </editor-fold> 
}
