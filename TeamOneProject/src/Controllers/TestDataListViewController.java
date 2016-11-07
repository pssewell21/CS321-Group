/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

//import Library.DalFields;
//import Library.LibraryBase;
import Library.LibraryBase;
import Library.TestData;
import Library.TestDataFactory;
import Views.TestDataListView;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.DefaultListModel;
//import java.util.Random;

/**
 *
 * @author pssew
 */
public class TestDataListViewController extends ListViewControllerBase{

    // <editor-fold defaultstate="collapsed" desc="Member Variables"> 
    
    public List<TestData> model;
    public TestDataListView view;
    
    public DefaultListModel<TestData> listModel;
    
    // </editor-fold> 
    
    // <editor-fold defaultstate="collapsed" desc="Constructors"> 

    public TestDataListViewController() {
        model = new ArrayList<>();
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Methods"> 

    public <T> void load() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        TestDataFactory factory = new TestDataFactory();
        HashMap<String, String> criteria = new HashMap<>();
        
        model = factory.executeSelect(criteria);

        listModel = new DefaultListModel<>();
        for (Object item : model) {
            listModel.addElement((TestData) item);
        }
        
        view = new TestDataListView(this);
    }

    public void executeAdd() {
        TestDataEditViewController controller = new TestDataEditViewController();
        controller.load(null);
    }

    public void executeEdit(TestData item) {
        TestDataEditViewController controller = new TestDataEditViewController();
        controller.load(item);
    }
    
    // </editor-fold> 
    
    // <editor-fold defaultstate="collapsed" desc="Reference Code from Prototyping (Need to eventually remove)"> 
    
//    TODO: Remove this reference code before final turn in for project
//    public void load() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
//        TestDataFactory factory = new TestDataFactory();
//        HashMap<String, String> criteria = new HashMap<>();

//        List<TestData> testDataList = factory.executeSelect(criteria);
//        displayResults(testDataList);
//        
//        criteria = new HashMap<>();
//        criteria.put(DalFields.LOOKUPKEY, "testKeyNew");
//        criteria.put(DalFields.VALUE, "valNew"); 
//        
//        factory.executeInsert(criteria);
//        
//        criteria = new HashMap<>();
//        testDataList = factory.executeSelect(criteria);
//        displayResults(testDataList);
//        
//        criteria = new HashMap<>();
//        criteria.put(DalFields.ID, "7530223542991451589");
//        criteria.put(DalFields.LOOKUPKEY, "testKeyNewFromUpdate!");
//        criteria.put(DalFields.VALUE, "valNewFromUpdate!");
//        
//        factory.executeUpdate(criteria);
//        
//        criteria = new HashMap<>();
//        testDataList = factory.executeSelect(criteria);
//        displayResults(testDataList);
//        
//        criteria = new HashMap<>();
//        criteria.put(DalFields.ID, "4");
//        
//        factory.executeDelete(criteria);
//        
//        criteria = new HashMap<>();
//        model = factory.executeSelect(criteria);
//
//        listModel = new DefaultListModel<>();
//        for (TestData item : model) {
//            listModel.addElement(item);
//        }

//    private void displayResults(List<TestData> testDataList)
//    {
//        if (!testDataList.isEmpty())
//        {
//            for (LibraryBase testData : testDataList)
//            {
//                System.out.println(testData.toString());
//            }
//        }
//        else
//        {
//            System.out.println("No results returned");
//        }
//    }
    
    // </editor-fold> 
}
