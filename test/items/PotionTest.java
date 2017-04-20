/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import App.Player;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jonas
 */
public class PotionTest {
    
    public PotionTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testGetName() {
        System.out.println("getName");
        Potion instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Potion instance = null;
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        Potion instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetHpRestore() {
        System.out.println("getHpRestore");
        Potion instance = null;
        int expResult = 0;
        int result = instance.getHpRestore();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetHpRestore() {
        System.out.println("setHpRestore");
        int hpRestore = 0;
        Potion instance = null;
        instance.setHpRestore(hpRestore);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetUsable() {
        System.out.println("getUsable");
        Potion instance = null;
        boolean expResult = false;
        boolean result = instance.getUsable();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetUsable() {
        System.out.println("setUsable");
        boolean usable = false;
        Potion instance = null;
        instance.setUsable(usable);
        fail("The test case is a prototype.");
    }

    @Test
    public void testUse() {
        System.out.println("use");
        Player player = null;
        Potion instance = null;
        instance.use(player);
        fail("The test case is a prototype.");
    }

    @Test
    public void testEquipable() {
        System.out.println("equipable");
        Potion instance = null;
        boolean expResult = false;
        boolean result = instance.equipable();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testEquip() {
        System.out.println("equip");
        Player player = null;
        Potion instance = null;
        instance.equip(player);
        fail("The test case is a prototype.");
    }
    
}
