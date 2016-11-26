/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Library.TestData;
import Library.TestDataFactory;
import Views.TestDataListView;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author pssew
 */
public class TestDataListViewController extends ListViewControllerBase {

    // <editor-fold defaultstate="collapsed" desc="Member Variables"> 
    /**
     *
     */
    public DefaultListModel<TestData> listModel;

    private final TestDataFactory factory;
    private TestDataListView view;

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Constructors"> 

    /**
     *
     */
    public TestDataListViewController() {
        factory = new TestDataFactory();
    }

    // </editor-fold> 
    // <editor-fold defaultstate="collapsed" desc="Methods"> 

    /**
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public void load() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        loadModel();

        view = new TestDataListView(this);
    }

    /**
     *
     */
    public void executeAdd() {
        TestDataEditViewController controller = new TestDataEditViewController();
        controller.load(null, listModel);
    }

    /**
     *
     * @param item
     */
    public void executeEdit(TestData item) {
        TestDataEditViewController controller = new TestDataEditViewController();
        controller.load(item, listModel);
    }

    private void loadModel() {
        HashMap<String, String> criteria = new HashMap<>();

        List<TestData> result = factory.executeSelect(criteria);

        listModel = new DefaultListModel<>();
        for (Object item : result) {
            listModel.addElement((TestData) item);
        }
    }

    // </editor-fold> 
}
