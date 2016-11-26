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

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author afro2
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({Controllers.PersonListViewControllerTest.class, Controllers.AtmViewControllerTest.class, Controllers.PersonEditViewControllerTest.class, Controllers.AccountPersonMapListViewControllerTest.class, Controllers.AccountPersonMapEditViewControllerTest.class, Controllers.LogOnViewControllerTest.class, Controllers.AccountListViewControllerTest.class, Controllers.UserEditViewControllerTest.class, Controllers.ListViewControllerBaseTest.class, Controllers.AdminViewControllerTest.class, Controllers.EditViewControllerBaseTest.class, Controllers.UserListViewControllerTest.class, Controllers.AccountEditViewControllerTest.class})
public class ControllersSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
