package me.zbackdoor.omegacore.commands.KillallArgs;

import me.zbackdoor.omegacore.permissions.Permissions;
import me.zbackdoor.omegacore.resources.yml.Language;
import me.zbackdoor.omegacore.system.register.command.OmegaCommand;
import me.zbackdoor.omegacore.system.util.Players;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class All extends OmegaCommand {

    public All() {
        this.setAliases("al", "all");
        this.setPermission(Permissions.KILLALL_PERM);
        this.setPermissionDenyMessage(Language.CMD_NO_PERM.getMessage());
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;

        World world = player.getWorld();

        world.getEntities().forEach(entity -> {
            if (!(entity instanceof Player)) {
                entity.remove();
            }
        });

        Players.sendMessage(player, Language.KILLALL.getMessage());
    }
}
