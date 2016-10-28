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
public class TestDataEditViewController 
{
    public TestData model;
    public TestDataEditView view;
        
    public String action;
    
    TestDataFactory factory;
    
    public TestDataEditViewController()
    {
        factory = new TestDataFactory();
    }
    
    public void load(TestData model)
    {
        if (model != null)
        {
            // load the existing model
            action = "Update";
        }
        else
        {
            this.model = new TestData();
            action = "Insert";
        }
        
        view = new TestDataEditView(this);
    }
    
    public void executeSave()
    {
        if ("Insert".equals(action))
        {
            factory.executeInsert(model.toHashMap());
        }
    }
}
