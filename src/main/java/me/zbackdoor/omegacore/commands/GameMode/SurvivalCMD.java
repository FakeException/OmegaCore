package me.zbackdoor.omegacore.commands.GameMode;

import me.zbackdoor.omegacore.permissions.Permissions;
import me.zbackdoor.omegacore.resources.yml.Language;
import me.zbackdoor.omegacore.system.register.command.OmegaCommand;
import me.zbackdoor.omegacore.system.util.Players;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SurvivalCMD extends OmegaCommand {

    public SurvivalCMD() {
        this.setAliases("0", "s");
        this.setPermission(Permissions.GAMEMODE_SURVIVAL_PERM);
        this.setPermissionDenyMessage(Language.CMD_NO_PERM.getMessage());
        this.setDescription("Gamemode Survival Command");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        if (args.length == 0) {
            player.setGameMode(GameMode.SURVIVAL);
            Players.sendMessage(player, Language.SURVIVAL_GAMEMODE.getMessage());
        } else {
            Player target = Bukkit.getPlayerExact(args[0]);
            if (target == null) {
                Players.sendMessage(player, Language.CMD_PLAYER_NOT_ONLINE.getMessage("{player}", args[0]));
            } else {
                target.setGameMode(GameMode.SURVIVAL);
                Players.sendMessage(player, Language.SURVIVAL_OTHER.getMessage("{player}", target.getName()));
                Players.sendMessage(target, Language.SURVIVAL_TARGET.getMessage());
            }
        }
    }
}
