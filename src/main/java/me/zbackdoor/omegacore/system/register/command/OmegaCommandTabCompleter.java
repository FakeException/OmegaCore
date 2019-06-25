package me.zbackdoor.omegacore.system.register.command;

import org.bukkit.command.CommandSender;

import java.util.List;

/**
 * @author zBackDo_or_
 */
public interface OmegaCommandTabCompleter {

    /**
     * @param sender tab sender.
     * @param alias  alias of the command being tabbed.
     * @param args   arguments passed.
     * @return list of tab complete suggestions.
     */
    List<String> tabComplete(CommandSender sender, String alias, String[] args);

}