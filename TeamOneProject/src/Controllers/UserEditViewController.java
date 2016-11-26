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
import Library.User;
import Library.UserFactory;
import Views.UserEditView;
import java.util.HashMap;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

/**
 * The controller that handles interaction between the view and library.
 *
 * @author Patrick Sewell
 */
public class UserEditViewController extends EditViewControllerBase {

    // <editor-fold defaultstate="collapsed" desc="Member Variables"> 
    /**
     * The object to be created or edited.
     */
    public User model;

    /**
     * The list of Persons to be selected from in the view.
     */
    public DefaultComboBoxModel<Person> personModel;

    private final UserFactory userFactory;
    private final PersonFactory personFactory;
    private UserEditView view;
    private DefaultListModel<User> listModel;

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Constructors"> 
    /**
     * Initializes the controller.
     */
    public UserEditViewController() {
        userFactory = new UserFactory();
        personFactory = new PersonFactory();
    }

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Methods"> 
    /**
     * Sets the model, and listModels, and opens the view.
     *
     * @param model The object to be edited
     * @param listModel The list of objects from the list view
     */
    public void load(User model, DefaultListModel<User> listModel) {
        if (model != null) {
            this.model = model;
            isNew = false;
        } else {
            this.model = new User();
            isNew = true;
        }

        this.listModel = listModel;

        HashMap<String, String> criteria = new HashMap<>();
        List<Person> result = personFactory.executeSelect(criteria);
        Person[] personArray = result.toArray(new Person[]{});
        personModel = new DefaultComboBoxModel<>(personArray);
        Person selectedPerson = null;

        for (Person item : result) {
            if (model != null && item.id.equals(model.personId)) {
                selectedPerson = item;
                break;
            }
        }

        view = new UserEditView(this, selectedPerson);

        view.setDeleteEnabled(!isNew);
    }

    @Override
    public void executeSave() {
        doSave();
        view.dispose();
    }

    @Override
    public void executeApply() {
        doSave();
    }

    @Override
    public void executeCancel() {
        view.dispose();
    }

    @Override
    public void executeDelete() {
        //TODO: Add confirmation prompt
        boolean successful = userFactory.executeDelete(model.toHashMap());

        if (successful) {
            listModel.removeElement(model);
            view.dispose();
        }
    }

    private void doSave() {

        if (isNew) {
            boolean successful = userFactory.executeInsert(model.toHashMap());

            if (successful) {
                listModel.addElement(model);
                isNew = false;
                view.setDeleteEnabled(true);
            }
        } else {
            boolean successful = userFactory.executeUpdate(model.toHashMap());

            if (!successful) {
                //TODO: rollback changes in some way
            }
        }
    }

    // </editor-fold> 
}
