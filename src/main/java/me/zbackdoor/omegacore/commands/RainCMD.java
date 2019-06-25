package me.zbackdoor.omegacore.commands;

import me.zbackdoor.omegacore.permissions.Permissions;
import me.zbackdoor.omegacore.resources.yml.Language;
import me.zbackdoor.omegacore.system.register.command.OmegaCommand;
import me.zbackdoor.omegacore.system.util.Players;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RainCMD extends OmegaCommand {

    public RainCMD() {
        this.setAliases("rain", "storm");
        this.setPermission(Permissions.RAIN_PERM);
        this.setPermissionDenyMessage(Language.CMD_NO_PERM.getMessage());
        this.setDescription("Rain Command");
        this.setUsage("/rain");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        if (!player.getWorld().hasStorm()) {
            player.getWorld().setStorm(true);
        }
        Players.sendMessage(player, Language.RAIN.getMessage());
    }
}
