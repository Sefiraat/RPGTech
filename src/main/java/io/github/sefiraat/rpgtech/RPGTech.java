package io.github.sefiraat.rpgtech;

import co.aikar.commands.PaperCommandManager;
import io.github.sefiraat.rpgtech.commands.Commands;
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
import java.util.Timer;

public class RPGTech extends JavaPlugin {

    private RPGTech instance;
    private File rpgCorePlayerConfigFile;
    private FileConfiguration rpgCorePlayerConfig;
    private PaperCommandManager commandManager;
    private final Timer repeater = new Timer();
    private boolean isUnitTest = false;


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
        createDankStorageConfig();
        registerCommands();

        repeater.schedule(new TimerSave(this.getInstance()),0, 30000);

        if (!isUnitTest) {
            int pluginId = 11208;
            Metrics metrics = new Metrics(this, pluginId);
        }

    }

    @Override
    public void onDisable() {
        saveDankStorageConfig();
    }

    private void registerCommands() {
        commandManager = new PaperCommandManager(this.getInstance());
        commandManager.registerCommand(new Commands(this.getInstance()));
    }

    private void createDankStorageConfig() {
        rpgCorePlayerConfigFile = new File(getDataFolder(), "DankStorages.yml");
        if (!rpgCorePlayerConfigFile.exists()) {
            rpgCorePlayerConfigFile.getParentFile().mkdirs();
            saveResource("DankStorages.yml", false);
        }
        rpgCorePlayerConfig = new YamlConfiguration();
        try {
            rpgCorePlayerConfig.load(rpgCorePlayerConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public void saveDankStorageConfig() {
        try {
            rpgCorePlayerConfig.save(rpgCorePlayerConfigFile);
        } catch (IOException e) {
            this.getLogger().warning("Unable to save " + rpgCorePlayerConfigFile.getName());
        }
    }

}
