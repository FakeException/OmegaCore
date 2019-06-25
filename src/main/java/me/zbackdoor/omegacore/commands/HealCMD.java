package me.zbackdoor.omegacore.commands;

import me.zbackdoor.omegacore.permissions.Permissions;
import me.zbackdoor.omegacore.resources.yml.Language;
import me.zbackdoor.omegacore.system.register.command.OmegaCommand;
import me.zbackdoor.omegacore.system.util.Players;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

public class HealCMD extends OmegaCommand {

    public HealCMD() {
        this.setAliases("heal");
        this.setDescription("Heal you!");
        this.setUsage("/heal");
        this.setPermission(Permissions.HEAL_PERM);
        this.setPermissionDenyMessage(Language.CMD_NO_PERM.getMessage());
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        if (args.length > 1) {
            Players.sendMessage(player, Language.CMD_INCORRECT_USAGE.getMessage("{usage}", this.getUsage(), "{args}", "&3Player &bName"));
        } else if (args.length == 0) {
            if (player.getHealth() == 20) {
                Players.sendMessage(player, Language.HEAL_MSG_ALREADY_HEALED.getMessage());
            } else if (player.getGameMode().equals(GameMode.CREATIVE) || player.getGameMode().equals(GameMode.SPECTATOR)){
                Players.sendMessage(player, Language.HEAL_GAMEMODE.getMessage());
            } else {
                player.setHealth(20);
                player.setFoodLevel(20);
                player.setFireTicks(0);
                for (PotionEffect effect : player.getActivePotionEffects()) {
                    player.removePotionEffect(effect.getType());
                }
                Players.sendMessage(player, Language.HEAL_MSG.getMessage());
            }
        } else {
            Player target = Bukkit.getPlayerExact(args[0]);
            if (target == null) {
                Players.sendMessage(player, Language.CMD_PLAYER_NOT_ONLINE.getMessage("{player}", args[0]));
            } else if (target.getHealth() == 20) {
                Players.sendMessage(player, Language.HEAL_MSG_ALREADY_HEALED_OTHER.getMessage("{player}", target.getName()));
            } else if (target.getGameMode().equals(GameMode.CREATIVE) || target.getGameMode().equals(GameMode.SPECTATOR)) {
                Players.sendMessage(player, Language.HEAL_GAMEMODE_OTHER.getMessage("{player}", target.getName()));
            } else {
                Players.sendMessage(player, Language.HEAL_MSG_OTHER.getMessage("{player}", target.getName()));
                Players.sendMessage(target, Language.HEAL_MSG.getMessage());
                target.setHealth(20);
                target.setFoodLevel(20);
                target.setFireTicks(0);
                for (PotionEffect effect : target.getActivePotionEffects()) {
                    target.removePotionEffect(effect.getType());
                }
            }
        }
    }
}