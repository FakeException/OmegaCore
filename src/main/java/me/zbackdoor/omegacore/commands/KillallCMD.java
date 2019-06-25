package me.zbackdoor.omegacore.commands;

import me.zbackdoor.omegacore.commands.KillallArgs.*;
import me.zbackdoor.omegacore.permissions.Permissions;
import me.zbackdoor.omegacore.resources.yml.Language;
import me.zbackdoor.omegacore.system.register.command.OmegaCommand;
import me.zbackdoor.omegacore.system.util.Players;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KillallCMD extends OmegaCommand {

    public KillallCMD() {
        this.setAliases("killall", "killal");
        this.setUsage("/killall");
        this.setDescription("Killall Command");
        this.setPermission(Permissions.KILLALL_PERM);
        this.setChildren(new All(), new Animals(), new ArmorStands(), new Mobs(), new Monsters(), new Animals(), new me.zbackdoor.omegacore.commands.KillallArgs.Players());
        this.setPermissionDenyMessage(Language.CMD_NO_PERM.getMessage());
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;

        Players.sendMessage(player, Language.CMD_INCORRECT_USAGE.getMessage("{usage}", this.getUsage(), "{args}", "&3{&bAll, Animals, ArmorStands, Mobs, Monsters, Players&3}"));
    }
}