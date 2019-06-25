package me.zbackdoor.omegacore.commands.SpawnSystem;

import me.zbackdoor.omegacore.OmegaCore;
import me.zbackdoor.omegacore.permissions.Permissions;
import me.zbackdoor.omegacore.resources.yml.Language;
import me.zbackdoor.omegacore.system.register.command.OmegaCommand;
import me.zbackdoor.omegacore.system.util.Players;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetspawnCMD extends OmegaCommand {

    public SetspawnCMD() {
        this.setAliases("setspawn");
        this.setDescription("Setspawn Command");
        this.setUsage("/setspawn");
        this.setPermission(Permissions.SETSPAWN_PERM);
        this.setPermissionDenyMessage(Language.CMD_NO_PERM.getMessage());
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        Location loc = new Location(player.getLocation().getWorld(), player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ(), player.getLocation().getYaw(), player.getLocation().getPitch());
        OmegaCore.spawnConfig.setLocation("Spawn", loc);
        OmegaCore.spawnConfig.saveConfig();
        Players.sendMessage(player, Language.SETSPAWN.getMessage());
    }
}
