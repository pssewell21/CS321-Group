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

import javax.swing.ImageIcon;
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
public class ImageIconScalerTest {
    
    public ImageIconScalerTest() {
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
     * Test of getScaledImage method, of class ImageIconScaler.
     */
    @Test
    public void testGetScaledImage() {
        System.out.println("getScaledImage");
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/Resources/logo.png"));
        int w = 66;
        int h = 66;
        ImageIcon result = ImageIconScaler.getScaledImage(imageIcon, w, h);
        
        assertTrue(result.getIconWidth() == w && imageIcon.getIconWidth() != w);
        assertTrue(result.getIconHeight() == h && imageIcon.getIconHeight() != h);
    }
}
