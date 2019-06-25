package me.zbackdoor.omegacore.commands;

import me.zbackdoor.omegacore.permissions.Permissions;
import me.zbackdoor.omegacore.resources.Resources;
import me.zbackdoor.omegacore.resources.yml.Language;
import me.zbackdoor.omegacore.system.register.command.OmegaCommand;
import me.zbackdoor.omegacore.system.util.Players;
import org.bukkit.command.CommandSender;

public class ReloadCMD extends OmegaCommand {

    ReloadCMD() {
        this.setAliases("reload", "rl");
        this.setPermission(Permissions.RELOAD_PERM);
        this.setAllowConsole(true);
        this.setPermissionDenyMessage(Language.CMD_NO_PERM.getMessage());
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Resources.get().register();
        Players.sendMessage(sender, Language.CMD_RELOAD_COMPLETE.getMessage());
    }
}
