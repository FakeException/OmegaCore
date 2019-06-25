package me.zbackdoor.omegacore.commands;

import me.zbackdoor.omegacore.permissions.Permissions;
import me.zbackdoor.omegacore.resources.yml.Language;
import me.zbackdoor.omegacore.system.register.command.OmegaCommand;
import me.zbackdoor.omegacore.system.util.Players;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NightCMD extends OmegaCommand {

    public NightCMD() {
        this.setAliases("night");
        this.setPermission(Permissions.NIGHT_PERM);
        this.setPermissionDenyMessage(Language.CMD_NO_PERM.getMessage());
        this.setDescription("Night Command");
        this.setUsage("/night");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        player.getWorld().setTime(13000);
        Players.sendMessage(player, Language.NIGHT.getMessage());
    }
}
