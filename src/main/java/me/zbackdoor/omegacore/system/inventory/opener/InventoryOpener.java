package me.zbackdoor.omegacore.system.inventory.opener;

import me.zbackdoor.omegacore.system.inventory.content.InventoryContents;
import me.zbackdoor.omegacore.system.inventory.ClickableItem;
import me.zbackdoor.omegacore.system.inventory.OmegaInventory;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

public interface InventoryOpener {

    Inventory open(OmegaInventory inv, Player player);
    boolean supports(InventoryType type);

    default void fill(Inventory handle, InventoryContents contents) {
        ClickableItem[][] items = contents.all();

        for(int row = 0; row < items.length; row++) {
            for(int column = 0; column < items[row].length; column++) {
                if(items[row][column] != null)
                    handle.setItem(9 * row + column, items[row][column].getItem());
            }
        }
    }

}
