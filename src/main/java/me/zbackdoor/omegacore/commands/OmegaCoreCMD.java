package me.zbackdoor.omegacore.commands;

import me.zbackdoor.omegacore.OmegaCore;
import me.zbackdoor.omegacore.permissions.Permissions;
import me.zbackdoor.omegacore.resources.yml.Language;
import me.zbackdoor.omegacore.system.register.command.OmegaCommand;
import org.bukkit.command.CommandSender;

public class OmegaCoreCMD extends OmegaCommand {

    public OmegaCoreCMD() {
        this.setAliases("omegacore", "oc");
        this.setDescription("OmegaCore Info command");
        this.setPermission(Permissions.INFO_PERM);
        this.setPermissionDenyMessage(Language.CMD_NO_PERM.getMessage());
        this.setAllowConsole(true);
        this.setChildren(new ReloadCMD());
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        sender.sendMessage("§3§m--------------------------------------------");
        sender.sendMessage("");
        sender.sendMessage("§3Plugin §bVersion: §3" + OmegaCore.getPlugin(plugin.getClass()).getDescription().getVersion());
        sender.sendMessage("§3Developer: §bzBackDo_or_");
        sender.sendMessage("");
        sender.sendMessage("§3§m--------------------------------------------");
    }
}
