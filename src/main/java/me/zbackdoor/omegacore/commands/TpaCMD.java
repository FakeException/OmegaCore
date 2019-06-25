package me.zbackdoor.omegacore.commands;

import me.zbackdoor.omegacore.OmegaCore;
import me.zbackdoor.omegacore.permissions.Permissions;
import me.zbackdoor.omegacore.resources.yml.Language;
import me.zbackdoor.omegacore.system.register.command.OmegaCommand;
import me.zbackdoor.omegacore.system.util.Players;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class TpaCMD extends OmegaCommand {

    public TpaCMD() {
        this.setAliases("tpa");
        this.setPermissionDenyMessage(Language.CMD_NO_PERM.getMessage());
        this.setPermission(Permissions.TPA_PERM);
        this.setDescription("Tpa Command");
        this.setUsage("/tpa");
    }

    static Set<Player> tpa = new LinkedHashSet<>();
    private ArrayList<String> messages = new ArrayList<>(Language.getLocale().getStringList("messages.teleport.tpa-request"));
    private ArrayList<String> messages2 = new ArrayList<>(Language.getLocale().getStringList("messages.teleport.tpa-request-other"));

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;

        if (args.length == 0) {
            Players.sendMessage(player, Language.CMD_INCORRECT_USAGE.getMessage("{usage}", this.getUsage(), "{args}", "Target"));
        } else if (args.length == 1) {
            Player target = Bukkit.getPlayerExact(args[0]);

            if (hasDuplicate(player) || hasDuplicate(target)) {
                Language.ALREADY_TELEPORT.getMessage("{player}", target.getName());
            } else

            try {
                if (player != target) {
                    Players.sendMessage(player, messages.stream().map(s -> s.replace("{target}", target.getName())).collect(Collectors.toList()));
                    Players.sendMessage(target, messages2.stream().map(s -> s.replace("{player}", player.getName())).collect(Collectors.toList()));
                    tpa.add(target);
                    tpa.add(player);

                    Bukkit.getScheduler().scheduleSyncDelayedTask(OmegaCore.getInstance(), () -> {
                        if ((tpa.contains(target)) && (!tpa.contains(player))) {
                            tpa.remove(target);
                            tpa.remove(player);
                            Players.sendMessage(target, Language.EXPIRED.getMessage("{player}", target.getName()));
                        }

                    }, 600L);
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

    private boolean hasDuplicate(Player item) {
        return !tpa.add(item);
    }
}
