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
     * @param player
     */
    public void pickUpItem(Player player) {

        b.chooseItemToPick();
        String choice = b.chooseAction();

        if (choice.equalsIgnoreCase("space dollars") && player.getCurrentRoom().getGold() > 0 || choice.equalsIgnoreCase("money") && player.getCurrentRoom().getGold() > 0) {
            int gold = player.getCurrentRoom().getGold();

            player.setBank(gold);
            b.playSound(b.coinSound);
            player.getCurrentRoom().setGold(0);
            b.youPickedUp(); System.out.println(gold + " Space Doallars\n");

        } else {

            Iitem itemToMove = player.getCurrentRoom().moveFromRoomToInventory(choice);

            if (itemToMove == null) {
                b.nothingHappend();

            } else {
                player.addItemToInventory(itemToMove);
                b.youPickedUp(); System.out.println(itemToMove+"\n");

            }
        }
    }

    /**
     * This method allows the player to drop an object and and move it from the
     * players inventory array into the currentRooms loot array.
     * @param player
     */
    public void dropItem(Player player) {
        player.showInventory();
        b.chooseItemToDrop();
        String choice = b.chooseAction();
        Iitem itemToMove = player.MoveFromInventoryToRoom(choice);
        if (itemToMove == null) {
            b.nothingHappend();
        } else {
            player.getCurrentRoom().add(itemToMove);

        }

    }

    /**
     * Runs method for using items in the Inventory Class
     * @param player
     */
    public void useItem(Player player) {
        b.chooseItemToUse();
        String choice = b.chooseAction();
        player.useItem(choice, player);
    }

    /**
     *
     * @param player
     */
    public void equipItem(Player player) {
        b.witchItemToEquip();
        String choice = b.chooseAction();
        player.checkInventoryAndEquip(choice);
    }

    /**
     *
     * @param player
     */
    public void unEquipItem(Player player) {
        b.witchItemToUnequip(player);
        String choice = b.chooseAction();
        player.checkEquippedItemAndUnequip(choice);
    }
}
