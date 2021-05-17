package io.github.sefiraat.rpgtech.misc.config;

import io.github.sefiraat.rpgtech.RPGTech;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;

import static io.github.sefiraat.rpgtech.finals.Config.*;

public class PlayerData {

    private PlayerData() {
        throw new IllegalStateException("Utility class");
    }

    public static void setupPlayerData(RPGTech plugin, Player p) {
        FileConfiguration c = plugin.getInstance().getRpgCorePlayerConfig();
        for (String s : getMasterySectionsMining()) {
            String configString = p.getUniqueId().toString() + "." + MASTERY + "." + SKILL_MINING + "." + s;
            if (!c.contains(configString)) {
                c.set(configString + "." + LVL, 0);
                c.set(configString + "." + XP, 0);
            }
        }
    }

    public static Integer getCurrentMasteryExp(RPGTech plugin, Player p, String skillType, String masteryType) {
        String cPlayerString = p.getUniqueId().toString() + "." + MASTERY + "." + skillType + "." + masteryType + "." + XP;
        return plugin.getInstance().getRpgCorePlayerConfig().getInt(cPlayerString);
    }

    public static Integer getCurrentMasteryLevel(RPGTech plugin, Player p, String skillType, String masteryType) {
        String cPlayerString = p.getUniqueId().toString() + "." + MASTERY + "." + skillType + "." + masteryType + "." + LVL;
        return plugin.getInstance().getRpgCorePlayerConfig().getInt(cPlayerString);
    }

    public static void setCurrentMasteryExp(RPGTech plugin, Player p, String skillType, String masteryType, Integer exp) {
        String cPlayerString = p.getUniqueId().toString() + "." + MASTERY + "." + skillType + "." + masteryType + "." + XP;
        plugin.getInstance().getRpgCorePlayerConfig().set(cPlayerString, exp);
    }

    public static void setCurrentMasteryLevel(RPGTech plugin, Player p, String skillType, String masteryType, Integer level) {
        String cPlayerString = p.getUniqueId().toString() + "." + MASTERY + "." + skillType + "." + masteryType + "." + LVL;
        plugin.getInstance().getRpgCorePlayerConfig().set(cPlayerString, level);
    }

    private static List<String> getMasterySectionsMining() {
        return Arrays.asList(
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
        );
    }

}
