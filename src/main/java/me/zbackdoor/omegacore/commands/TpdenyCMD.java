package me.zbackdoor.omegacore.commands;

import me.zbackdoor.omegacore.permissions.Permissions;
import me.zbackdoor.omegacore.resources.yml.Language;
import me.zbackdoor.omegacore.system.register.command.OmegaCommand;
import me.zbackdoor.omegacore.system.util.Players;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TpdenyCMD extends OmegaCommand {

    public TpdenyCMD() {
        this.setAliases("tpdeny");
        this.setDescription("Tpdeny Command");
        this.setUsage("/tpdeny");
        this.setPermission(Permissions.TPDENY_PERM);
        this.setPermissionDenyMessage(Language.CMD_NO_PERM.getMessage());
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;

        if (args.length == 0) {
            Players.sendMessage(player, Language.CMD_INCORRECT_USAGE.getMessage("{usage}", this.getUsage(), "{args}", "Player"));
        } else if (args.length == 1) {
            Player target = Bukkit.getPlayerExact(args[0]);

            try {
                if (player != target) {
                    if (TpaCMD.tpa.contains(player) && TpaCMD.tpa.contains(target)) {
                        Players.sendMessage(player, Language.TPA_DENY.getMessage("{player}", target.getName()));
                        Players.sendMessage(target, Language.TPA_DENY_OTHER.getMessage("{target}", player.getName()));

                        TpaCMD.tpa.remove(target);
                        TpaCMD.tpa.remove(player);
                    } else {
                        Players.sendMessage(player, Language.NO_TELEPORT.getMessage("{player}", target.getName()));
                    }
                } else {
                    Players.sendMessage(player, Language.SELF.getMessage());
                }
            } catch (Exception e) {
                Players.sendMessage(player, Language.CMD_PLAYER_NOT_ONLINE.getMessage("{player}", args[0]));
            }
        } else {
            Players.sendMessage(player, Language.CMD_INCORRECT_USAGE.getMessage("{usage}", this.getUsage(), "{args}", "Player"));
        }
    }
}
