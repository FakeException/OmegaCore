package me.zbackdoor.omegacore.commands;

import me.zbackdoor.omegacore.permissions.Permissions;
import me.zbackdoor.omegacore.resources.yml.Language;
import me.zbackdoor.omegacore.system.register.command.OmegaCommand;
import me.zbackdoor.omegacore.system.util.Players;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InvseeCMD extends OmegaCommand {

    public InvseeCMD() {
        this.setAliases("invsee", "inventorysee");
        this.setPermissionDenyMessage(Language.CMD_NO_PERM.getMessage());
        this.setPermission(Permissions.INVSEE_PERM);
        this.setUsage("/invsee");
        this.setDescription("Invsee Command");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;

        if (args.length == 0) {
            player.openInventory(player.getInventory());
        } else if (args.length == 1) {
            Player target = Bukkit.getPlayerExact(args[0]);
            try {
                player.openInventory(target.getInventory());
            } catch (Exception e) {
                Players.sendMessage(player, Language.CMD_PLAYER_NOT_ONLINE.getMessage("{player}", args[0]));
            }
        } else {
            Players.sendMessage(player, Language.CMD_INCORRECT_USAGE.getMessage("{usage}", this.getUsage(), "{args}", "&bTarget"));
        }
    }
}
