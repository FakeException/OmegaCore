package me.zbackdoor.omegacore.commands;

import me.zbackdoor.omegacore.permissions.Permissions;
import me.zbackdoor.omegacore.resources.yml.Language;
import me.zbackdoor.omegacore.system.register.command.OmegaCommand;
import me.zbackdoor.omegacore.system.util.Players;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SunCMD extends OmegaCommand {

    public SunCMD() {
        this.setAliases("sun", "sunny");
        this.setPermission(Permissions.RAIN_PERM);
        this.setPermissionDenyMessage(Language.CMD_NO_PERM.getMessage());
        this.setDescription("Sun Command");
        this.setUsage("/sun");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        if (player.getWorld().hasStorm()) {
            player.getWorld().setStorm(false);
        }
        Players.sendMessage(player, Language.SUN.getMessage());
    }
}
