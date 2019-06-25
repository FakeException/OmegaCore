package me.zbackdoor.omegacore.commands;

import me.zbackdoor.omegacore.permissions.Permissions;
import me.zbackdoor.omegacore.resources.yml.Language;
import me.zbackdoor.omegacore.system.register.command.OmegaCommand;
import me.zbackdoor.omegacore.system.util.Players;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DayCMD extends OmegaCommand {

    public DayCMD() {
        this.setAliases("day");
        this.setPermission(Permissions.DAY_PERM);
        this.setPermissionDenyMessage(Language.CMD_NO_PERM.getMessage());
        this.setDescription("Day Command");
        this.setUsage("/day");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        player.getWorld().setTime(1000);
        Players.sendMessage(player, Language.DAY.getMessage());
    }
}
