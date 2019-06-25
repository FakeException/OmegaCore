package me.zbackdoor.omegacore;

import lombok.Getter;
import lombok.Setter;
import me.zbackdoor.omegacore.commands.*;
import me.zbackdoor.omegacore.commands.GameMode.GmCMD;
import me.zbackdoor.omegacore.commands.GameMode.morealiases.Gma;
import me.zbackdoor.omegacore.commands.GameMode.morealiases.Gmc;
import me.zbackdoor.omegacore.commands.GameMode.morealiases.Gms;
import me.zbackdoor.omegacore.commands.HomeSystem.HomeCMD;
import me.zbackdoor.omegacore.commands.HomeSystem.SethomeCMD;
import me.zbackdoor.omegacore.commands.SpawnSystem.SetspawnCMD;
import me.zbackdoor.omegacore.commands.SpawnSystem.SpawnCMD;
import me.zbackdoor.omegacore.commands.WarpSystem.SetWarpCMD;
import me.zbackdoor.omegacore.commands.WarpSystem.WarpCMD;
import me.zbackdoor.omegacore.commands.WarpSystem.WarpsCMD;
import me.zbackdoor.omegacore.listeners.SpawnEvents;
import me.zbackdoor.omegacore.resources.Resources;
import me.zbackdoor.omegacore.system.OmegaPlugin;
import me.zbackdoor.omegacore.utils.TemporaryConfig;
import org.bukkit.Bukkit;

@Getter
@Setter
public class OmegaCore extends OmegaPlugin {

    public static TemporaryConfig homesConfig;
    public static TemporaryConfig spawnConfig;
    public static TemporaryConfig warpsConfig;
    private static OmegaCore instance;

    @Override
    public void enable() {
        instance = this;
        this.register(Resources.class, OmegaCoreCMD.class, FlyCMD.class, HealCMD.class, FeedCMD.class, GmCMD.class, Gmc.class, Gma.class, Gms.class);
        homesConfig = new TemporaryConfig("plugins/OmegaCore", "Data/Homes.yml", this);
        homesConfig.saveConfig();
        this.register(SethomeCMD.class, HomeCMD.class);
        spawnConfig = new TemporaryConfig("plugins/OmegaCore", "Data/Spawn.yml", this);
        spawnConfig.saveConfig();
        this.register(SetspawnCMD.class, SpawnCMD.class);
        warpsConfig = new TemporaryConfig("plugins/OmegaCore", "Data/Warps.yml", this);
        warpsConfig.saveConfig();
        this.register(SetWarpCMD.class, WarpCMD.class);
        this.register(KillallCMD.class, SunCMD.class, RainCMD.class, DayCMD.class, NightCMD.class,
                TpallCMD.class, TphereCMD.class, TpaCMD.class, TpacceptCMD.class, TpdenyCMD.class, WarpsCMD.class, InvseeCMD.class, BroadcastCMD.class);
        registerListeners();
        Bukkit.getConsoleSender().sendMessage("§3§m------------------------------------------------------------");
        console.info("§bPlugin §3Enabled!");
        Bukkit.getConsoleSender().sendMessage("§3§m------------------------------------------------------------");
    }

    @Override
    public void disable() {
        Bukkit.getConsoleSender().sendMessage("§3§m------------------------------------------------------------");
        console.info("§bPlugin §3Disabled!");
        Bukkit.getConsoleSender().sendMessage("§3§m------------------------------------------------------------");
    }

    private void registerListeners() {
        Bukkit.getPluginManager().registerEvents(new SpawnEvents(), this);
    }

    public static OmegaCore getInstance() {
        return instance;
    }
}
