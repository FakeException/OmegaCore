package me.zbackdoor.omegacore.commands.GameMode;

import me.zbackdoor.omegacore.permissions.Permissions;
import me.zbackdoor.omegacore.resources.yml.Language;
import me.zbackdoor.omegacore.system.register.command.OmegaCommand;
import me.zbackdoor.omegacore.system.util.Players;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GmCMD extends OmegaCommand {

    public GmCMD() {
        this.setAliases("gm");
        this.setPermission(Permissions.GAMEMODE_PERM);
        this.setPermissionDenyMessage(Language.CMD_NO_PERM.getMessage());
        this.setDescription("Gamemode Command");
        this.setUsage("/gm");
        this.setChildren(new CreativeCMD(), new SurvivalCMD(), new AdventureCMD(), new SpectatorCMD());
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        Players.sendMessage(player, Language.GAMEMODE_USAGE.getMessage());
    }
}
