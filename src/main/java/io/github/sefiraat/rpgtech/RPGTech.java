package io.github.sefiraat.rpgtech;

import co.aikar.commands.PaperCommandManager;
import com.google.common.collect.ImmutableList;
import io.github.sefiraat.rpgtech.commands.Commands;
import io.github.sefiraat.rpgtech.listeners.PlayerLoginListener;
import io.github.sefiraat.rpgtech.listeners.SkillExpListeners;
import io.github.sefiraat.rpgtech.listeners.SkillTriggerListener;
import io.github.sefiraat.rpgtech.misc.config.ConfigGeneral;
import io.github.sefiraat.rpgtech.timers.TimerSave;
import org.bstats.bukkit.Metrics;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.JavaPluginLoader;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Timer;

public class RPGTech extends JavaPlugin {

    private RPGTech instance;
    private File rpgCorePlayerConfigFile;
    private FileConfiguration rpgCorePlayerConfig;
    private PaperCommandManager commandManager;
    private final Timer repeater = new Timer();
    private boolean isUnitTest = false;
    private ConfigGeneral rpgConfig;
    private final Random random = new Random();


    public File getRpgCorePlayerConfigFile() {
        return rpgCorePlayerConfigFile;
    }
    public FileConfiguration getRpgCorePlayerConfig() {
        return rpgCorePlayerConfig;
    }
    public PaperCommandManager getCommandManager() {
        return commandManager;
    }
    public RPGTech getInstance() {
        return instance;
    }
    public ConfigGeneral getRpgConfig() {
        return rpgConfig;
    }
    public Random getRandom() {
        return random;
    }

    public RPGTech() {
        super();
    }

    protected RPGTech(JavaPluginLoader loader, PluginDescriptionFile description, File dataFolder, File file) {
        super(loader, description, dataFolder, file);
        isUnitTest = true;
    }

    @Override
    public void onEnable() {

        getLogger().info("########################################");
        getLogger().info("");
        getLogger().info("                 RPGTech                ");
        getLogger().info("              Version 1.0.0             ");
        getLogger().info("");
        getLogger().info("           Created by Sefiraat          ");
        getLogger().info("");
        getLogger().info("########################################");

        instance = this;

        saveDefaultConfig();
        createRPGPlayerConfig();
        rpgConfig = new ConfigGeneral(this.getInstance());
        registerCommands();

        repeater.schedule(new TimerSave(this.getInstance()),0, 30000);

        new PlayerLoginListener(this.getInstance());
        new SkillExpListeners(this.getInstance());
        new SkillTriggerListener(this.getInstance());

        if (!isUnitTest) {
            int pluginId = 11304;
            Metrics metrics = new Metrics(this, pluginId);
        }

    }

    @Override
    public void onDisable() {
        saveRPGPlayerConfig();
    }

    private void registerCommands() {
        commandManager = new PaperCommandManager(this.getInstance());
        commandManager.registerCommand(new Commands(this.getInstance()));

        commandManager.getCommandCompletions().registerCompletion("MAST_MINING", c ->  ImmutableList.of(
                "STONE",
                "COAL_ORE",
                "IRON_ORE",
                "GOLD_ORE",
                "REDSTONE_ORE",
                "LAPIS_ORE",
                "EMERALD_ORE",
                "DIAMOND_ORE",
                "NETHERRACK",
                "NETHER_QUARTZ_ORE",
                "NETHER_GOLD_ORE",
                "ANCIENT_DEBRIS",
                "END_STONE"
        ));

    }

    private void createRPGPlayerConfig() {
        rpgCorePlayerConfigFile = new File(getDataFolder(), "player_data.yml");
        if (!rpgCorePlayerConfigFile.exists()) {
            rpgCorePlayerConfigFile.getParentFile().mkdirs();
            saveResource("player_data.yml", false);
        }
        rpgCorePlayerConfig = new YamlConfiguration();
        try {
            rpgCorePlayerConfig.load(rpgCorePlayerConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public void saveRPGPlayerConfig() {
        try {
            rpgCorePlayerConfig.save(rpgCorePlayerConfigFile);
        } catch (IOException e) {
            this.getLogger().warning("Unable to save " + rpgCorePlayerConfigFile.getName());
        }
    }

}
