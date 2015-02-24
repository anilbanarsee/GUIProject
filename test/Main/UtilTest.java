/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class UtilTest {
    
    public UtilTest() {
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
     * Test of scaleImage method, of class Util.
     */
    @Test
    public void testScaleImage() {
        System.out.println("scaleImage");
        int WIDTH = 0;
        int HEIGHT = 0;
        String filename = "";
        BufferedImage expResult = null;
        BufferedImage result = Util.scaleImage(WIDTH, HEIGHT, filename);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of makeTransparent method, of class Util.
     */
    @Test
    public void testMakeTransparent() {
        System.out.println("makeTransparent");
        BufferedImage img = null;
        BufferedImage expResult = null;
        BufferedImage result = Util.makeTransparent(img);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of makeWhiteTransparent method, of class Util.
     */
    @Test
    public void testMakeWhiteTransparent() {
        System.out.println("makeWhiteTransparent");
        BufferedImage image = null;
        Image expResult = null;
        Image result = Util.makeWhiteTransparent(image);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFont method, of class Util.
     */
    @Test
    public void testGetFont() {
        System.out.println("getFont");
        String filepath = "";
        int size = 0;
        Font expResult = null;
        Font result = Util.getFont(filepath, size);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWeatherFont method, of class Util.
     */
    @Test
    public void testGetWeatherFont() {
        System.out.println("getWeatherFont");
        int size = 0;
        Font expResult = null;
        Font result = Util.getWeatherFont(size);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNextDays method, of class Util.
     */
    @Test
    public void testGetNextDays() {
        System.out.println("getNextDays");
        int n = 0;
        Util instance = new Util();
        String[] days = instance.getNextDays(4);
        System.out.println(Arrays.toString(days));
    }
    
}
