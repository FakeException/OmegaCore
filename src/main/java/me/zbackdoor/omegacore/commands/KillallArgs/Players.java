package me.zbackdoor.omegacore.commands.KillallArgs;

import me.zbackdoor.omegacore.permissions.Permissions;
import me.zbackdoor.omegacore.resources.yml.Language;
import me.zbackdoor.omegacore.system.register.command.OmegaCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Players extends OmegaCommand {

    public Players() {
        this.setAliases("players", "player");
        this.setPermission(Permissions.KILLALL_PERM);
        this.setPermissionDenyMessage(Language.CMD_NO_PERM.getMessage());
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;

        Bukkit.getOnlinePlayers().forEach(players -> players.setHealth(0));

        me.zbackdoor.omegacore.system.util.Players.sendMessage(player, Language.KILLALL.getMessage());
    }
}
