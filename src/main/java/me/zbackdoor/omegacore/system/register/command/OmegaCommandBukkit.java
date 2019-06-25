package me.zbackdoor.omegacore.system.register.command;

import me.zbackdoor.omegacore.system.util.logging.StaticLog;
import me.zbackdoor.omegacore.system.util.reflect.Reflection;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.SimpleCommandMap;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @author zBackDo_or_
 */
public class OmegaCommandBukkit extends Command {

    private static final Field COMMAND_MAP = Reflection.getField(Bukkit.getServer().getClass(), "commandMap");

    public static SimpleCommandMap getCommandMap() {
        return Reflection.getFieldValue(COMMAND_MAP, Bukkit.getServer());
    }

    private final OmegaCommand command;

    protected OmegaCommandBukkit(OmegaCommand command) {
        super(command.getName(), command.getDescription(), command.getUsage(), command.getAliases());

        this.command = command;
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        try {
            command.executeCalled(sender, args);
        } catch (Exception e) {
            StaticLog.error("An exception occurred when executing the command &c" + label + "&r:");
            StaticLog.exception(e);
            return false;
        }
        return true;
    }

    @Override
    public List<String> tabComplete(CommandSender sender, String alias, String[] args) throws IllegalArgumentException {
        List<String> result = command.tabCalled(sender, alias, args);

        if (result == null) {
            // Fallback to builtin
            result = super.tabComplete(sender, alias, args);
        }

        return result;
    }

    /**
     * @return the internal command.
     */
    public OmegaCommand getCommand() {
        return command;
    }
}