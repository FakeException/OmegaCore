package me.zbackdoor.omegacore.commands;

import me.zbackdoor.omegacore.permissions.Permissions;
import me.zbackdoor.omegacore.resources.yml.Language;
import me.zbackdoor.omegacore.system.register.command.OmegaCommand;
import me.zbackdoor.omegacore.system.util.Players;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCMD extends OmegaCommand {

    public FlyCMD() {
        this.setAliases("fly");
        this.setDescription("Lets you fly!");
        this.setUsage("/fly");
        this.setPermission(Permissions.FLY_PERM);
        this.setPermissionDenyMessage(Language.CMD_NO_PERM.getMessage());
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        if (args.length > 1) {
            Players.sendMessage(player, Language.CMD_INCORRECT_USAGE.getMessage("{usage}", this.getUsage(), "{args}", "&3Player &bName"));
        } else if (args.length == 0 && player.getAllowFlight()) {
            player.setAllowFlight(false);
            Players.sendMessage(player, Language.FLY_DISABLED.getMessage());
        } else if (args.length == 0 && !player.getAllowFlight()) {
            player.setAllowFlight(true);
            Players.sendMessage(player, Language.FLY_ENABLED.getMessage());
        } else {
            Player target = Bukkit.getPlayerExact(args[0]);
            if (target == null) {
                Players.sendMessage(player, Language.CMD_PLAYER_NOT_ONLINE.getMessage("{player}", args[0]));
            } else if (target.getAllowFlight()){
                Players.sendMessage(player, Language.FLY_DISABLED_OTHER.getMessage("{player}", target.getName()));
                Players.sendMessage(target, Language.FLY_DISABLED_OTHER_TARGET.getMessage("{player}", player.getName()));
                target.setAllowFlight(false);
            } else {
                Players.sendMessage(player, Language.FLY_ENABLED_OTHER.getMessage("{player}", target.getName()));
                Players.sendMessage(target, Language.FLY_ENABLED_OTHER_TARGET.getMessage("{player}", player.getName()));
                target.setAllowFlight(true);
            }
        }
    }
}