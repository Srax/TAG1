/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import Enteties.Room;
import Enteties.Player;
import MonsterTypes.Monster;
import items.Armor;
import items.Iitem;
import items.Weapon;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jonas
 */
public class PlayerTest {
    Player p;
    
    public PlayerTest() {
    }
    
    @Before
    public void setUp() {
        p = new Player();
    }

    @Test
    public void testGetCurrentRoom() {
        System.out.println("getCurrentRoom");
        Player instance = new Player();
        Room expResult = null;
        Room result = instance.getCurrentRoom();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetEquippedWeapon() {
        System.out.println("getEquippedWeapon");
        Player instance = new Player();
        Weapon expResult = null;
        Weapon result = instance.getEquippedWeapon();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetEquippedArmor() {
        System.out.println("getEquippedArmor");
        Player instance = new Player();
        Armor expResult = null;
        Armor result = instance.getEquippedArmor();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetDmg() {
        System.out.println("getDmg");
        Player instance = new Player();
        int expResult = 0;
        int result = instance.getDmg();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetCurrentRoom() {
        System.out.println("setCurrentRoom");
        Room currentRoom = null;
        Player instance = new Player();
        instance.setCurrentRoom(currentRoom);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetEquippedWeapon() {
        System.out.println("setEquippedWeapon");
        Weapon equippedWeapon = null;
        Player instance = new Player();
        instance.setEquippedWeapon(equippedWeapon);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetEquippedArmor() {
        System.out.println("setEquippedArmor");
        Armor equippedArmor = null;
        Player instance = new Player();
        instance.setEquippedArmor(equippedArmor);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetDmg() {
        System.out.println("setDmg");
        int dmg = 0;
        Player instance = new Player();
        instance.setDmg(dmg);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetLastRoom() {
        System.out.println("getLastRoom");
        Player instance = new Player();
        Room expResult = null;
        Room result = instance.getLastRoom();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetLastRoom() {
        System.out.println("setLastRoom");
        Room lastRoom = null;
        Player instance = new Player();
        instance.setLastRoom(lastRoom);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        Player instance = new Player();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetName() {
        System.out.println("getName");
        Player instance = new Player();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Player instance = new Player();
        instance.setName(name);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetHp() {
        System.out.println("getHp");
        Player instance = new Player();
        int expResult = 0;
        int result = instance.getHp();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetHp() {
        System.out.println("setHp");
        int hp = 0;
        Player instance = new Player();
        instance.setHp(hp);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetBank() {
        System.out.println("getBank");
        Player instance = new Player();
        int expResult = 0;
        int result = instance.getBank();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetBank() {
        System.out.println("setBank");
        int bank = 0;
        Player instance = new Player();
        instance.setBank(bank);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetDef() {
        System.out.println("getDef");
        Player instance = new Player();
        int expResult = 0;
        int result = instance.getDef();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetDef() {
        System.out.println("setDef");
        int def = 0;
        Player instance = new Player();
        instance.setDef(def);
        fail("The test case is a prototype.");
    }

    
    @Test
    public void testAddItemToInventory() {
        System.out.println("addItemToInventory");
        Iitem item = null;
        Player instance = new Player();
        instance.addItemToInventory(item);
        fail("The test case is a prototype.");
    }

    @Test
    public void testShowInventory() {
        System.out.println("showInventory");
        Player instance = new Player();
        instance.showInventory();
        fail("The test case is a prototype.");
    }

    @Test
    public void testMoveFromInventoryToRoom() {
        System.out.println("MoveFromInventoryToRoom");
        String item = "";
        Player instance = new Player();
        Iitem expResult = null;
        Iitem result = instance.MoveFromInventoryToRoom(item);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testUseItem() {
        System.out.println("useItem");
        String item = "";
        Player player = null;
        Player instance = new Player();
        instance.useItem(item, player);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCheckInventoryAndEquip() {
        System.out.println("checkInventoryAndEquip");
        String item = "";
        Player instance = new Player();
        instance.checkInventoryAndEquip(item);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCheckEquippedItemAndUnequip() {
        System.out.println("checkEquippedItemAndUnequip");
        String item = "";
        Player instance = new Player();
        instance.checkEquippedItemAndUnequip(item);
        fail("The test case is a prototype.");
    }
    
}
