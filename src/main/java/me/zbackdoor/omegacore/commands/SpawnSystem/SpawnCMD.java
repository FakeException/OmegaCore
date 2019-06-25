package me.zbackdoor.omegacore.commands.SpawnSystem;

import me.zbackdoor.omegacore.OmegaCore;
import me.zbackdoor.omegacore.permissions.Permissions;
import me.zbackdoor.omegacore.resources.yml.Language;
import me.zbackdoor.omegacore.system.register.command.OmegaCommand;
import me.zbackdoor.omegacore.system.util.Players;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCMD extends OmegaCommand {

    public SpawnCMD() {
        this.setAliases("spawn");
        this.setDescription("Spawn Command");
        this.setUsage("/spawn");
        this.setPermission(Permissions.SPAWN_PERM);
        this.setPermissionDenyMessage(Language.CMD_NO_PERM.getMessage());
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        if (args.length == 0) {
            if (OmegaCore.spawnConfig.isPathNull("Spawn")) {
                Players.sendMessage(player, Language.SPAWN_NOT_FOUND.getMessage());
            } else {
                Location loc = OmegaCore.spawnConfig.getLocation("Spawn");
                player.teleport(loc);
                Players.sendMessage(player, Language.SPAWN.getMessage());
            }
        } else {
            Players.sendMessage(player, Language.CMD_INCORRECT_USAGE.getMessage("{usage}", this.getUsage(), "{args}", ""));
        }
    }
}
