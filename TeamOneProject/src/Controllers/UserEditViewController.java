/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 *
 * @author Owner
 */
public class UserEditViewController extends EditViewControllerBase {

    // <editor-fold defaultstate="collapsed" desc="Member Variables"> 
    /**
     *
     */
    public User model;

    /**
     *
     */
    public DefaultComboBoxModel<Person> personModel;

    private final UserFactory userFactory;
    private final PersonFactory personFactory;
    private UserEditView view;
    private DefaultListModel<User> listModel;

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Constructors"> 
    /**
     *
     */
    public UserEditViewController() {
        userFactory = new UserFactory();
        personFactory = new PersonFactory();
    }

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Methods"> 
    /**
     *
     * @param model
     * @param listModel
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

    /**
     *
     */
    @Override
    public void executeSave() {
        doSave();
        view.dispose();
    }

    /**
     *
     */
    @Override
    public void executeApply() {
        doSave();
    }

    /**
     *
     */
    @Override
    public void executeCancel() {
        view.dispose();
    }

    /**
     *
     */
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
