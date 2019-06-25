package me.zbackdoor.omegacore.resources.yml;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import me.zbackdoor.omegacore.OmegaCore;
import me.zbackdoor.omegacore.resources.ResourceType;
import me.zbackdoor.omegacore.resources.Resources;
import me.zbackdoor.omegacore.system.resource.yml.ResourceYaml;
import me.zbackdoor.omegacore.system.util.Messages;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Language {

    PREFIX("prefix", "&3Omega&bCore &7➜"),

    CMD_NO_PERM("command.no-permission", "{prefix} &7You don't have the permission for that command."),

    CMD_INCORRECT_USAGE("command.incorrect-usage", "{prefix} &cIncorrect usage please use &b{usage} {args}"),

    CMD_RELOAD_COMPLETE("command.reload-complete-msg", "{prefix} &7Plugin successfully reloaded."),

    CMD_PLAYER_NOT_ONLINE("command.player-not-online", "{prefix} &b{player} &3is not &bOnline!"),

    FLY_ENABLED("messages.fly.fly-enabled", "{prefix} &3Your fly has been &bEnabled!"),

    FLY_DISABLED("messages.fly.fly-disabled", "{prefix} &3Your fly has been &bDisabled!"),

    FLY_ENABLED_OTHER("messages.fly.fly-enabled-other-sender", "{prefix} &3Fly enabled for &b{player}!"),

    FLY_DISABLED_OTHER("messages.fly.fly-disabled-other-sender","{prefix} &3Fly disabled for &b{player}!"),

    FLY_ENABLED_OTHER_TARGET("messages.fly.fly-enabled-other-target", "{prefix} &3Your fly has been enabled by &b{player}!"),

    FLY_DISABLED_OTHER_TARGET("messages.fly.fly-disabled-other-target","{prefix} &3Your fly has been disabled by &b{player}!"),

    HEAL_MSG("messages.heal.healed-msg", "{prefix} &3You''ve been healed!"),

    HEAL_MSG_ALREADY_HEALED("messages.heal.already-healed", "{prefix} &3You already have max health!"),

    HEAL_MSG_OTHER("messages.heal.healed-msg-other", "{prefix} &3You''ve healed &b{player}!"),

    HEAL_MSG_ALREADY_HEALED_OTHER("messages.heal.already-healed-other", "{prefix} &b{player} &3already has max health!"),

    HEAL_GAMEMODE("messages.heal.isnt-gamemode-survival-adventure", "{prefix} &bYou have to be in &3Survival &bor &3Adventure &bmode!"),

    HEAL_GAMEMODE_OTHER("messages.heal.isnt-gamemode-survival-adventure-other", "{prefix} &b{player} &3need to be in &3Survival &bor &3Adventure &bmode!"),

    FEED_MSG("messages.feed.feed-msg", "{prefix} &3You''ve been feeded!"),

    FEED_OTHER("messages.feed.feed-msg-other", "{prefix} &3You''ve feeded &b{player}!"),

    FEED_ALREADY("messages.feed.already-feeded", "{prefix} &3You already have max feed!"),

    FEED_ALREADY_OTHER("messages.feed.already-feeded-other", "{prefix} &b{player} &3already has max feed!"),

    GAMEMODE_USAGE("messages.gamemode.usage", "{prefix} &3Available Game &bModes: &3Creative&b, &3Survival&b, &3Adventure&b, &3Spectator"),

    CREATIVE_GAMEMODE("messages.gamemode.creative", "{prefix} &3Game&bMode &3changed to &bCreative!"),

    SURVIVAL_GAMEMODE("messages.gamemode.survival", "{prefix} &3Game&bMode &3changed to &bSurvival!"),

    ADVENTURE_GAMEMODE("messages.gamemode.adventure", "{prefix} &3Game&bMode &3changed to &bAdventure!"),

    SPECTATOR_GAMEMODE("messages.gamemode.spectator", "{prefix} &3Game&bMode &3changed to &bSpectator!"),

    CREATIVE_OTHER("messages.gamemode.creative-other", "{prefix} &3GameMode modified to &bCreative &3for &b{player}"),

    SURVIVAL_OTHER("messages.gamemode.survival-other", "{prefix} &3GameMode modified to &bSurvival &3for &b{player}"),

    ADVENTURE_OTHER("messages.gamemode.adventure-other", "{prefix} &3GameMode modified to &bAdventure &3for &b{player}"),

    SPECTATOR_OTHER("messages.gamemode.spectator-other", "{prefix} &3GameMode modified to &bSpectator &3for &b{player}"),

    CREATIVE_TARGET("messages.gamemode.creative-other-target", "{prefix} &3Your GameMode has been changed to &bCreative"),

    SURVIVAL_TARGET("messages.gamemode.survival-other-target", "{prefix} &3Your GameMode has been changed to &bSurvival"),

    ADVENTURE_TARGET("messages.gamemode.adventure-other-target", "{prefix} &3Your GameMode has been changed to &bAdventure"),

    SPECTATOR_TARGET("messages.gamemode.spectator-other-target", "{prefix} &3Your GameMode has been changed to &bSpectator"),

    SETHOME_MSG("messages.homesConfig.sethome", "{prefix} &3Home successfully &bSetted!"),

    HOME_MSG("messages.homesConfig.home", "{prefix} &3Teleported to your &bHome!"),

    HOME_NOT_FOUND("messages.homesConfig.home-notfound", "{prefix} &3First set your home with &b/sethome"),

    SETSPAWN("messages.spawnConfig.setspawn", "{prefix} &3Spawn successfully &bSetted!"),

    SPAWN("messages.spawnConfig.spawnConfig", "{prefix} &3Teleported to the &bSpawn!"),

    SPAWN_NOT_FOUND("messages.spawnConfig.spawnConfig-notfound", "{prefix} &3No spawnConfig has yet been set!"),

    KILLALL("messages.killall.killall", "{prefix} &3Killed the &bEntities!"),

    SUN("messages.weather.sun", "{prefix} &3Weather changed to &bSun!"),

    RAIN("messages.weather.rain", "{prefix} &3Weather changed to &bStorm!"),

    TPALL("messages.teleport.tpall", "{prefix} &3Teleported all the players to you!"),

    TPHERE("messages.teleport.tphere", "{prefix} &3Teleported &b{target} &3to you!"),

    EXPIRED("messages.teleport.expired", "{prefix} &3Teleport request from &b{player} &3has expired!"),

    NO_TELEPORT("messages.teleport.tpa-no-teleport", "{prefix} &3No teleport requests from {player}"),

    ALREADY_TELEPORT("messages.teleport.already-tpa", "{prefix} &3You already sent a teleport request to &b{target}"),

    SELF("messages.teleport.self", "{prefix} &3You cannot teleport to yourself!"),

    SETWARP("messages.warpsConfig.setwarp", "{prefix} &3Successfully setted the warp &b{warp}&3!"),

    WARP_EXISTS("messages.warpsConfig.already-exists", "{prefix} &cWarp Already Exists!"),

    WARP_NOT_FOUND("messages.warpsConfig.not-found", "{prefix} &cWarp not found!"),

    WARP_TP("messages.warpsConfig.teleported", "{prefix} &3Successfully teleported to the warp &b{warp}&3!"),

    DAY("messages.time.day", "{prefix} &3Time changed to &bDay!"),

    NIGHT("messages.time.night", "{prefix} &3Time changed to &bNight!"),

    WALK_SPEED("messages.speed.walk-speed", "{prefix} &3Set walk speed to &b{value}"),

    FLY_SPEED("messages.speed.fly-speed", "{prefix} &3Set fly speed to &b{value}"),

    TPA_DENY("messages.teleport.tpa-deny", "{prefix} &3Tpa from &b{player} denied!"),

    TPA_DENY_OTHER("messages.teleport.tpa-deny-other", "{prefix} &b{target} &3denied your teleport request!")

    ;

    public static ResourceYaml getLocale() {
        return (ResourceYaml) Resources.get().getResource(ResourceType.LANGUAGE);
    }

    private final String path;
    private final List<String> def;

    /**
     * @param path the path pointing to the message.
     * @param def  default value in case message is missing or null.
     */
    Language(String path, String... def) {
        this.path = path;
        this.def = Messages.colour(def);
    }

    /**
     * @return yaml path pointing to the message.
     */
    public String getPath() {
        return path;
    }

    public static void saveFile() {
        OmegaCore.getResourceProvider().saveResource(Language.getLocale());
    }

    /**
     * @return default value in case message is missing or {@code null}.
     */
    public List<String> getDefault() {
        return def;
    }

    public static String getPrefix() {
        return Language.PREFIX.getMessage().get(0);
    }

    /**
     * @return list of messages or {@link Language#def} if missing.
     */
    public List<String> getMessage(Object... rep) {
        List<String> replacements = Stream.of(rep)
                .map(String::valueOf)
                .collect(Collectors.toList());

        List<String> unreplaced;

        if (getLocale().getConfiguration().isString(path)) {
            unreplaced = Lists.newArrayList(getLocale().getString(path, def.get(0)));
        } else {
            unreplaced = getLocale().getConfiguration().getStringList(path);
        }

        // Use the default if the returned is empty.
        if (unreplaced.isEmpty()) {
            unreplaced = def;
        }

        // Not replacing anything if the message is the prefix.
        if (this == PREFIX) {
            return unreplaced;
        }

        Map<String, String> replace = Maps.newHashMap();
        List<String> replaced = Lists.newArrayList();

        // Replacements list acting as a key-value map:
        // key1, value1, key2, value2, key3, value3, etc..
        List<String> temp = Lists.newArrayList(replacements);
        temp.add("{prefix}");
        temp.add(Language.PREFIX.getMessage().get(0)); // No need to check length.

        // Convert key-value list to map.
        for (int i = 0; i < temp.size() - 1; i += 2) {
            replace.put(temp.get(i), temp.get(i + 1));
        }

        // Finally, replace.
        for (String s : unreplaced) {
            for (Map.Entry<String, String> r : replace.entrySet()) {
                s = s.replace(r.getKey(), r.getValue());
            }

            replaced.add(s);
        }

        return Messages.colour(replaced);
    }
}