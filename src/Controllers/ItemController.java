/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Boundry.Boundry;
import Enteties.Player;
import items.Iitem;

/**
 *
 * @author Stanislav
 */
public class ItemController {

    Boundry b = new Boundry();

    /**
     * This method allows the player to pick up an object from the rooms loot
     * array and moves it to the players inventory array
     *
     * @param player
     */
    public void pickUpItem(Player player) {

        b.chooseItemToPick();
        String choice = b.chooseAction();

        // To pickup Gold, because the gold is a integer, and the items are of the type Iitem, so two diffrent methods to pickup were nessesary
        if (choice.equalsIgnoreCase("space dollars") && player.getCurrentRoom().getGold() > 0 || choice.equalsIgnoreCase("money") && player.getCurrentRoom().getGold() > 0) {
            int gold = player.getCurrentRoom().getGold();

            player.setBank(gold);
            b.playSound(b.coinSound);
            player.getCurrentRoom().setGold(0);
            b.youPickedUp();
            System.out.println(gold + " Space Dollars\n");

        } else {
            //Checks for existing items in Room object
            Iitem itemToMove = player.getCurrentRoom().moveFromRoomToInventory(choice);

            if (itemToMove == null) {
                b.nothingHappend();

            } else {
                // Moves the item in the rool to the player Inventory
                player.addItemToInventory(itemToMove);
                b.youPickedUp();
                System.out.println(itemToMove + "\n");

            }
        }
    }

    /**
     * This method allows the player to drop an object and and move it from the
     * players inventory array into the currentRooms loot array.
     *
     * @param player
     */
    public void dropItem(Player player) {
        player.showInventory();
        b.chooseItemToDrop();
        String choice = b.chooseAction();

        //Tries to check for the Item name in inventory objects
        Iitem itemToMove = player.MoveFromInventoryToRoom(choice);
        //If not found
        if (itemToMove == null) {
            b.nothingHappend();
            //If found it moves the item.
        } else {
            player.getCurrentRoom().add(itemToMove);

        }

    }

    /**
     * Runs method for using items in the Inventory Class
     *
     * @param player
     */
    public void useItem(Player player) {
        b.chooseItemToUse();
        String choice = b.chooseAction();
        player.useItem(choice, player);
    }

    /**
     * Searches player inventory for chosen item, and runs the equip method in
     * Player class.
     *
     * @param player
     */
    public void equipItem(Player player) {
        b.witchItemToEquip();
        String choice = b.chooseAction();
        player.checkInventoryAndEquip(choice);

    }

    /**
     * Searches player equipped items, for chosen item, and runs the unequip
     * method in Player class
     *
     * @param player
     */
    public void unEquipItem(Player player) {
        b.witchItemToUnequip(player);
        String choice = b.chooseAction();
        player.checkEquippedItemAndUnequip(choice);
    }
}
