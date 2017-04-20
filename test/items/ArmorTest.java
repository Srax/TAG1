/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import Enteties.Player;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jonas
 */
public class ArmorTest {

    public ArmorTest() {
    }

    @Before
    public void setUp() {
        Iitem spaceSuit = new Armor("Space Suit", "Standard issued space suit", 1);
    }

    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Armor a = new Armor();
        a.setName(name);
        //  fail("The test case is a prototype.");
    }

    @Test
    public void testGetName() {
        System.out.println("getName");
        Armor instance = new Armor("Space Suit", "Standard issued space suit", 1);
        String expResult = "Space Suit";
        String result = instance.getName();
        assertEquals(expResult, result);
        //   fail("The test case is a prototype.");
    }

    @Test
    public void testSetDefense() {
        System.out.println("setDefense");
        int defense = 1;
        Armor instance = new Armor();
        instance.setDefense(defense);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testGetDefense() {
        System.out.println("getDefense");
        Armor instance = new Armor("Space Suit", "Standard issued space suit", 1);
        int expResult = 1;
        int result = instance.getDefense();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

//    @Test
//    public void testToString() {
//        System.out.println("toString");
//        Armor instance = new Armor();
//        String expResult = "";
//        String result = instance.toString();
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Armor instance = new Armor("Space Suit", "Standard issued space suit", 1);

        String expResult = "Standard issued space suit";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testSetUsable() {
        System.out.println("setUsable");
        boolean usable = true;
        Armor instance = new Armor();
        instance.setUsable(usable);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testGetUsable() {
        System.out.println("getUsable");
        Armor instance = new Armor("Space Suit", "Standard issued space suit", 1);

        boolean expResult = false;
        boolean result = instance.getUsable();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

//    @Test
//    public void testUse() {
//        System.out.println("use");
//        Player player = null;
//        Armor instance = new Armor();
//        instance.use(player);
//        fail("The test case is a prototype.");
//    }
    @Test
    public void testEquipable() {
        System.out.println("equipable");
        Armor instance = new Armor();
        boolean expResult = true;
        boolean result = instance.equipable();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

//    @Test
//    public void testEquip() {
//        System.out.println("equip");
//        Player player = null;
//        Armor instance = new Armor();
//        instance.equip(player);
//        fail("The test case is a prototype.");
//    }
//    
}
