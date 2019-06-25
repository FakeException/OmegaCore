package me.zbackdoor.omegacore.commands.HomeSystem;

import me.zbackdoor.omegacore.OmegaCore;
import me.zbackdoor.omegacore.permissions.Permissions;
import me.zbackdoor.omegacore.resources.yml.Language;
import me.zbackdoor.omegacore.system.register.command.OmegaCommand;
import me.zbackdoor.omegacore.system.util.Players;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SethomeCMD extends OmegaCommand {

    public SethomeCMD() {
        this.setAliases("sethome");
        this.setDescription("Sethome Command");
        this.setUsage("/sethome");
        this.setPermission(Permissions.SETHOME_PERM);
        this.setPermissionDenyMessage(Language.CMD_NO_PERM.getMessage());
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        Location loc = new Location(player.getLocation().getWorld(), player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ(), player.getLocation().getYaw(), player.getLocation().getPitch());
        OmegaCore.homesConfig.setLocation("Homes." + player.getUniqueId().toString(), loc);
        OmegaCore.homesConfig.saveConfig();
        Players.sendMessage(player, Language.SETHOME_MSG.getMessage());
    }
}
