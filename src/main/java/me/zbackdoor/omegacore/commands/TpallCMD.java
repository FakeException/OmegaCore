package me.zbackdoor.omegacore.commands;

import me.zbackdoor.omegacore.permissions.Permissions;
import me.zbackdoor.omegacore.resources.yml.Language;
import me.zbackdoor.omegacore.system.register.command.OmegaCommand;
import me.zbackdoor.omegacore.system.util.Players;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TpallCMD extends OmegaCommand {

    public TpallCMD() {
        this.setAliases("tpall");
        this.setUsage("/tpall");
        this.setDescription("Tpall Command");
        this.setPermission(Permissions.TPALL_PERM);
        this.setPermissionDenyMessage(Language.CMD_NO_PERM.getMessage());
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        Players.teleport(Bukkit.getOnlinePlayers(), player.getLocation());

        Players.sendMessage(player, Language.TPALL.getMessage());
    }
}
