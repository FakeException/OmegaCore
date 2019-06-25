package me.zbackdoor.omegacore.commands.WarpSystem;

import me.zbackdoor.omegacore.OmegaCore;
import me.zbackdoor.omegacore.permissions.Permissions;
import me.zbackdoor.omegacore.resources.yml.Language;
import me.zbackdoor.omegacore.system.inventory.ClickableItem;
import me.zbackdoor.omegacore.system.inventory.OmegaInventory;
import me.zbackdoor.omegacore.system.inventory.content.InventoryContents;
import me.zbackdoor.omegacore.system.inventory.content.InventoryProvider;
import me.zbackdoor.omegacore.system.inventory.content.Pagination;
import me.zbackdoor.omegacore.system.inventory.content.SlotIterator;
import me.zbackdoor.omegacore.system.register.command.OmegaCommand;
import me.zbackdoor.omegacore.system.util.ItemBuilder;
import me.zbackdoor.omegacore.system.util.Players;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WarpsCMD extends OmegaCommand implements InventoryProvider {

    public WarpsCMD() {
        this.setAliases("warpsConfig");
        this.setDescription("Warps Command");
        this.setPermissionDenyMessage(Language.CMD_NO_PERM.getMessage());
        this.setUsage("/warpsConfig");
        this.setPermission(Permissions.WARPS_PERM);
    }

    public static final OmegaInventory inv = OmegaInventory.builder()
            .id("warpsGUI")
            .closeable(true)
            .provider(new WarpsCMD())
            .title("§bWarps")
            .size(3, 9)
            .build();

    @Override
    public void init(Player player, InventoryContents contents) {
        if (OmegaCore.warpsConfig.getConfig().getConfigurationSection("Warps") != null) {
            Pagination pagination = contents.pagination();

            ClickableItem[] items = new ClickableItem[OmegaCore.warpsConfig.getConfig().getConfigurationSection("Warps").getKeys(false).size()];

            for (int i = 0; i < items.length; i++) {
                String name = OmegaCore.warpsConfig.getConfig().getConfigurationSection("Warps").getKeys(false).iterator().next();
                items[i] = ClickableItem.of(new ItemBuilder(Material.GRASS).setDisplayName(ChatColor.DARK_GREEN + name).build(), e -> {
                    player.teleport(OmegaCore.warpsConfig.getLocation("Warps." + name));
                    Players.sendMessage(player, Language.WARP_TP.getMessage("{warp}", name));
                });
            }

            pagination.setItems(items);
            pagination.setItemsPerPage(7);

            pagination.addToIterator(contents.newIterator(SlotIterator.Type.HORIZONTAL, 1, 1));

            contents.fillBorders(ClickableItem.empty(new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayName("").build()));

            contents.set(2, 3, ClickableItem.of(new ItemBuilder(Material.ARROW).setDisplayName("§3Back").build(),
                    e -> inv.open(player, pagination.previous().getPage())));
            contents.set(2, 5, ClickableItem.of(new ItemBuilder(Material.ARROW).setDisplayName("§3Next").build(),
                    e -> inv.open(player, pagination.next().getPage())));

        } else {
            player.sendMessage("§cNo warps have been created yet!");
        }
    }

    @Override
    public void update(Player player, InventoryContents contents) {

    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        inv.open(player);
    }
}
