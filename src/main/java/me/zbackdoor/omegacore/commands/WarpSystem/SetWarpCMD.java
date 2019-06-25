package me.zbackdoor.omegacore.commands.WarpSystem;

import me.zbackdoor.omegacore.OmegaCore;
import me.zbackdoor.omegacore.permissions.Permissions;
import me.zbackdoor.omegacore.resources.yml.Language;
import me.zbackdoor.omegacore.system.register.command.OmegaCommand;
import me.zbackdoor.omegacore.system.util.Players;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetWarpCMD extends OmegaCommand {

    public SetWarpCMD() {
        this.setAliases("setwarp");
        this.setPermission(Permissions.SETWARP_PERM);
        this.setPermissionDenyMessage(Language.CMD_NO_PERM.getMessage());
        this.setDescription("Setwarp Command");
        this.setUsage("/setwarp");
    }

    public final void execute(final CommandSender sender, final String[] arg) {
        Player player = (Player) sender;
        if (arg.length == 1) {
            if (!OmegaCore.warpsConfig.getConfig().contains("Warps." + arg[0])) {
                Location loc = new Location(player.getLocation().getWorld(), player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ(), player.getLocation().getYaw(), player.getLocation().getPitch());
                OmegaCore.warpsConfig.setLocation("Warps." + arg[0], loc);
                OmegaCore.warpsConfig.saveConfig();

                Players.sendMessage(player, Language.SETWARP.getMessage("{warp}", arg[0]));
            } else {
                Players.sendMessage(player, Language.WARP_EXISTS.getMessage());
            }
        } else {
            Players.sendMessage(player, Language.CMD_INCORRECT_USAGE.getMessage("{usage}", getUsage(), "{args}", "&3<Name>"));
        }
    }
}