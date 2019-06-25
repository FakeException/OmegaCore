package me.zbackdoor.omegacore.commands;

import me.zbackdoor.omegacore.permissions.Permissions;
import me.zbackdoor.omegacore.resources.yml.Language;
import me.zbackdoor.omegacore.system.register.command.OmegaCommand;
import me.zbackdoor.omegacore.system.util.Players;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BroadcastCMD extends OmegaCommand {

    public BroadcastCMD() {
        this.setAliases("broadcast", "bc");
        this.setUsage("/broadcast");
        this.setDescription("Broadcast Command");
        this.setPermission(Permissions.BROADCAST_PERM);
        this.setPermissionDenyMessage(Language.CMD_NO_PERM.getMessage());
    }

    private String msg2;

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;

        if (args.length == 0) {
            Players.sendMessage(player, Language.CMD_INCORRECT_USAGE.getMessage("{usage}", this.getUsage(), "{args}", "Message"));
        } else {
            for (String arg : args) {
                this.msg2 = (this.msg2 + arg + " ");
            }

            Bukkit.getOnlinePlayers().forEach(p -> Players.sendMessage(p, Language.getPrefix() + msg2));

            this.msg2 = " ";
        }
    }
}
