package me.zbackdoor.omegacore.commands.HomeSystem;

import me.zbackdoor.omegacore.OmegaCore;
import me.zbackdoor.omegacore.permissions.Permissions;
import me.zbackdoor.omegacore.resources.yml.Language;
import me.zbackdoor.omegacore.system.register.command.OmegaCommand;
import me.zbackdoor.omegacore.system.util.Players;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HomeCMD extends OmegaCommand {

    public HomeCMD() {
        this.setAliases("home");
        this.setDescription("Home Command");
        this.setUsage("/home");
        this.setPermission(Permissions.HOME_PERM);
        this.setPermissionDenyMessage(Language.CMD_NO_PERM.getMessage());
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        if (args.length == 0) {
            if (OmegaCore.homesConfig.isPathNull("Homes." + player.getUniqueId())) {
                Players.sendMessage(player, Language.HOME_NOT_FOUND.getMessage());
            } else {
                Location loc = OmegaCore.homesConfig.getLocation("Homes." + player.getUniqueId());
                player.teleport(loc);
                Players.sendMessage(player, Language.HOME_MSG.getMessage());
            }
        } else {
            Players.sendMessage(player, Language.CMD_INCORRECT_USAGE.getMessage("{usage}", this.getUsage(), "{args}", ""));
        }
    }
}
