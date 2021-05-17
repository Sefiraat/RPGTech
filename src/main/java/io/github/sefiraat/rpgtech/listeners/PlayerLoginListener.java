package io.github.sefiraat.rpgtech.listeners;

import io.github.sefiraat.rpgtech.RPGTech;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import javax.annotation.Nonnull;

import static io.github.sefiraat.rpgtech.misc.config.PlayerData.setupPlayerData;

public class PlayerLoginListener implements Listener {

    final RPGTech parent;

    public PlayerLoginListener(@Nonnull RPGTech plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        parent = plugin;
    }

    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent e) {
        setupPlayerData(parent, e.getPlayer());
    }
}
