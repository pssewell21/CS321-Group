/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Library.TestData;
import Library.TestDataFactory;
import Views.TestDataEditView;

/**
 *
 * @author Owner
 */
public class TestDataEditViewController {
   
    // <editor-fold defaultstate="collapsed" desc="Member Variables"> 
    
    public TestData model;
    public TestDataEditView view;

    public boolean isNew;

    TestDataFactory factory;
    
    // </editor-fold> 
    
    // <editor-fold defaultstate="collapsed" desc="Constructors"> 

    public TestDataEditViewController() {
        factory = new TestDataFactory();
    }
    
    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc="Methods"> 
    
    public void load(TestData model) {
        if (model != null) {
            this.model = model;
            isNew = false;
        } else {
            this.model = new TestData();
            isNew = true;
        }

        view = new TestDataEditView(this);

        view.setDeleteEnabled(!isNew);
    }

    public void executeSave() {
        doSave();
        view.dispose();
    }

    public void executeApply() {
        doSave();
        isNew = false;
        view.setDeleteEnabled(true);
    }

    public void executeCancel() {
        view.dispose();
    }

    public void executeDelete() {
        //TODO: Add confirmation prompt
        factory.executeDelete(model.toHashMap());
        view.dispose();
    }

    private void doSave() {
        if (isNew) {
            factory.executeInsert(model.toHashMap());
        } else {
            factory.executeUpdate(model.toHashMap());
        }
    }
    
    // </editor-fold> 
}
