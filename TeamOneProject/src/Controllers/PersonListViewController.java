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

import Library.Person;
import Library.PersonFactory;
import Views.PersonListView;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 * The controller that handles interaction between the view and library.
 *
 * @author Patrick Sewell
 */
public class PersonListViewController extends ListViewControllerBase {

    // <editor-fold defaultstate="collapsed" desc="Member Variables"> 
    /**
     * The listModel that holds objects displayed in the listView.
     */
    public DefaultListModel<Person> listModel;

    private final PersonFactory factory;
    private PersonListView view;

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Constructors"> 
    /**
     * Initializes the controller.
     */
    public PersonListViewController() {
        factory = new PersonFactory();
    }

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Methods"> 
    /**
     * Sets the listModel, and opens the view.
     *
     * @throws SQLException If an SQL error occurs
     * @throws ClassNotFoundException If a Class cannot be found
     * @throws InstantiationException If an object cannot be instantiated
     * @throws IllegalAccessException If access cannot be given
     */
    public void load() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        loadModel();

        view = new PersonListView(this);
    }

    /**
     * Opens the edit view to create a new object.
     */
    public void executeAdd() {
        PersonEditViewController controller = new PersonEditViewController();
        controller.load(null, listModel);
    }

    /**
     * Opens the edit view to modify an existing object.
     *
     * @param item The object to be modified
     */
    public void executeEdit(Person item) {
        PersonEditViewController controller = new PersonEditViewController();
        controller.load(item, listModel);
    }

    private void loadModel() {
        HashMap<String, String> criteria = new HashMap<>();

        List<Person> result = factory.executeSelect(criteria);

        listModel = new DefaultListModel<>();
        for (Object item : result) {
            listModel.addElement((Person) item);
        }
    }

    // </editor-fold>
}
