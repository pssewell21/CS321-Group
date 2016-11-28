/*
 * Copyright 2016 AUTHORS. Patrick S Sewell, Paul M Dyer, Taehyeok Lee, 
 * Benjamin C Ferguson, Hyunki J KIm Permission is granted to copy, distribute 
 * and/or modify this document under the terms of the GNU Free Documentation 
 * License, Version 1.3, (3 November 2008) or any later version published by 
 * the Free Software Foundation; with no Invariant Sections, with no 
 * Front-Cover Texts, and with no Back-Cover Texts. A copy of the license 
 * can be found at http://www.gnu.org/copyleft/fdl.html
 */
package Common;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Owner
 */
public class UserSettingsTest {
    
    public UserSettingsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setSelectedTheme method, of class UserSettings.
     */
    @Test
    public void testSetSelectedTheme() {
        System.out.println("setSelectedTheme");
        String theme = "Dark Theme";
        UserSettings.setSelectedTheme(theme);
        
        Class clazz = UserSettings.selectedTheme.getClass();
        assertTrue(clazz.getName().equals("Themes.DarkTheme"));
        
        theme = "Light Theme";
        UserSettings.setSelectedTheme(theme);
        
        clazz = UserSettings.selectedTheme.getClass();
        assertTrue(clazz.getName().equals("Themes.LightTheme"));
    }
}
