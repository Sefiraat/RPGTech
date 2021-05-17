package io.github.sefiraat.rpgtech.misc.utils;

import io.github.sefiraat.rpgtech.RPGTech;
import org.bukkit.entity.Player;
import scala.Int;

import javax.annotation.Nullable;

public class PlayerData {

    private PlayerData() {
        throw new IllegalStateException("Utility class");
    }

    @Nullable
    public static int getMasteryLevel(RPGTech plugin, Player player, String skill, String mastery) {
        return plugin.getRpgCorePlayerConfig().getInt(player.getUniqueId().toString() + ".MASTERY_LEVELS." + skill + "." + mastery + ".LEVEL");
    }

    public static void setMasteryLevel(RPGTech plugin, Player player, String skill, String mastery, Integer level) {
        plugin.getRpgCorePlayerConfig().set(player.getUniqueId().toString() + ".MASTERY_LEVELS." + skill + "." + mastery + ".LEVEL", level);
    }

}
