package me.zbackdoor.omegacore.listeners;

import me.zbackdoor.omegacore.OmegaCore;
import me.zbackdoor.omegacore.resources.yml.Config;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class SpawnEvents implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        if (Config.SPAWN_ON_JOIN.getAsBoolean() && !OmegaCore.spawnConfig.isPathNull("Spawn")) {
            p.teleport(OmegaCore.spawnConfig.getLocation("Spawn"));
        }
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent event) {
        Player p = event.getPlayer();
        if (Config.SPAWN_ON_DEATH.getAsBoolean() && !OmegaCore.spawnConfig.isPathNull("Spawn")) {
            p.teleport(OmegaCore.spawnConfig.getLocation("Spawn"));
        }
    }
}
