/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Library.TestData;
import Library.TestDataFactory;
import Views.TestDataEditView;
import javax.swing.DefaultListModel;

/**
 *
 * @author Owner
 */
public class TestDataEditViewController extends EditViewControllerBase{
   
    // <editor-fold defaultstate="collapsed" desc="Member Variables"> 

    /**
     *
     */
        
    public TestData model;

    /**
     *
     */
    public TestDataEditView view;

    /**
     *
     */
    public TestDataFactory factory;
    
    private DefaultListModel<TestData> listModel;
    
    // </editor-fold> 
    
    // <editor-fold defaultstate="collapsed" desc="Constructors"> 

    /**
     *
     */

    public TestDataEditViewController() {
        factory = new TestDataFactory();
    }
    
    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc="Methods"> 

    /**
     *
     * @param model
     * @param listModel
     */
    
    public void load (TestData model, DefaultListModel<TestData> listModel) {
        if (model != null) {
            this.model = model;
            isNew = false;
        } else {
            this.model = new TestData();
            isNew = true;
        }
        
        this.listModel = listModel;

        view = new TestDataEditView(this);

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
        isNew = false;
        view.setDeleteEnabled(true);
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
        factory.executeDelete(model.toHashMap());
        listModel.removeElement(model);
        view.dispose();
    }

    private void doSave() {
        if (isNew) {
            factory.executeInsert(model.toHashMap());
            listModel.addElement(model);
        } else {
            factory.executeUpdate(model.toHashMap());
        }
        
    }
    
    // </editor-fold> 
}
