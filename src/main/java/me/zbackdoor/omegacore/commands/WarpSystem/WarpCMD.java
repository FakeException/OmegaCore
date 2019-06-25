package me.zbackdoor.omegacore.commands.WarpSystem;

import me.zbackdoor.omegacore.OmegaCore;
import me.zbackdoor.omegacore.permissions.Permissions;
import me.zbackdoor.omegacore.resources.yml.Language;
import me.zbackdoor.omegacore.system.register.command.OmegaCommand;
import me.zbackdoor.omegacore.system.util.Players;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WarpCMD extends OmegaCommand {

    public WarpCMD() {
        this.setAliases("warp");
        this.setPermission(Permissions.WARP_PERM);
        this.setDescription("Warp Command");
        this.setPermissionDenyMessage(Language.CMD_NO_PERM.getMessage());
        this.setUsage("/warp");
    }

    public final void execute(final CommandSender sender, final String[] arg) {
        Player p = (Player) sender;
        if (arg.length == 1) {
            if (OmegaCore.warpsConfig.getConfig().getString("Warps." + arg[0]) != null) {

                Location warploc = OmegaCore.warpsConfig.getLocation("Warps." + arg[0]);
                p.teleport(warploc);
                Players.sendMessage(p, Language.WARP_TP.getMessage("{warp}", arg[0]));
            } else {
                Players.sendMessage(p, Language.WARP_NOT_FOUND.getMessage());
            }
        } else {
            Players.sendMessage(p, Language.CMD_INCORRECT_USAGE.getMessage("{usage}", getUsage(), "{args}", "&3<Name>"));
        }
    }
}