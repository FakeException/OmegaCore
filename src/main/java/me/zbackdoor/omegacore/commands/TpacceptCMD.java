package me.zbackdoor.omegacore.commands;

import me.zbackdoor.omegacore.permissions.Permissions;
import me.zbackdoor.omegacore.resources.yml.Language;
import me.zbackdoor.omegacore.system.register.command.OmegaCommand;
import me.zbackdoor.omegacore.system.util.Players;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class TpacceptCMD extends OmegaCommand {

    public TpacceptCMD() {
        this.setAliases("tpaccept");
        this.setPermission(Permissions.TPACCEPT_PERM);
        this.setPermissionDenyMessage(Language.CMD_NO_PERM.getMessage());
        this.setDescription("Tpaccept Command");
        this.setUsage("tpaccept");
    }

    private ArrayList<String> messages = new ArrayList<>(Language.getLocale().getStringList("messages.teleport.tpa-accepted"));
    private ArrayList<String> messages2 = new ArrayList<>(Language.getLocale().getStringList("messages.teleport.tpa-accepted-other"));

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;

        if (args.length == 0) {
            Players.sendMessage(player, Language.CMD_INCORRECT_USAGE.getMessage("{usage}", this.getUsage(), "{args}", "Target"));
        } else if (args.length == 1) {
            Player target = Bukkit.getPlayerExact(args[0]);

            try {
                if (player != target) {
                    if (TpaCMD.tpa.contains(player) && TpaCMD.tpa.contains(target)) {
                        target.teleport(player);
                        Players.sendMessage(player, messages.stream().map(s -> s.replace("{player}", target.getName())).collect(Collectors.toList()));
                        Players.sendMessage(target, messages2.stream().map(s -> s.replace("{target}", player.getName())).collect(Collectors.toList()));

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
            Players.sendMessage(player, Language.CMD_INCORRECT_USAGE.getMessage("{usage}", this.getUsage(), "{args}", "Target"));
        }
    }
}
