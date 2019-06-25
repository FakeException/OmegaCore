package me.zbackdoor.omegacore.commands;

import me.zbackdoor.omegacore.permissions.Permissions;
import me.zbackdoor.omegacore.resources.yml.Language;
import me.zbackdoor.omegacore.system.register.command.OmegaCommand;
import me.zbackdoor.omegacore.system.util.Players;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TphereCMD extends OmegaCommand {

    public TphereCMD() {
        this.setAliases("tphere");
        this.setPermission(Permissions.TPHERE_PERM);
        this.setPermissionDenyMessage(Language.CMD_NO_PERM.getMessage());
        this.setDescription("Tphere Command");
        this.setUsage("/tphere");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;

        if (args.length == 0) {
            Players.sendMessage(player, Language.CMD_INCORRECT_USAGE.getMessage("{usage}", this.getUsage(), "{args}", "Target"));
        } else if (args.length == 1) {
            Player target = Bukkit.getPlayerExact(args[0]);

            try {
                target.teleport(player.getLocation());
                Players.sendMessage(player, Language.TPHERE.getMessage("{target}", target.getName()));
            } catch (Exception e) {
                Players.sendMessage(player, Language.CMD_PLAYER_NOT_ONLINE.getMessage("{player}", args[0]));
            }
        } else {
            Players.sendMessage(player, Language.CMD_INCORRECT_USAGE.getMessage("{usage}", this.getUsage(), "{args}", "Target"));
        }
    }
}
