package io.github.sefiraat.rpgtech.finals;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;

public class Colors {

    private Colors() {
        throw new IllegalStateException("Utility class");
    }

    public static ChatColor getColor(Material m) {
        switch(m) {
            // Mining
            case STONE: return ChatColor.of("#8E8E8E");
            case COAL_ORE: return ChatColor.of("#525252");
            case IRON_ORE: return ChatColor.of("#EAB1E6");
            case GOLD_ORE: return ChatColor.of("#EED261");
            case REDSTONE_ORE: return ChatColor.of("#D32323");
            case LAPIS_ORE: return ChatColor.of("#487AE4");
            case EMERALD_ORE: return ChatColor.of("#2B9723");
            case DIAMOND_ORE: return ChatColor.of("#3BBFB5");
            case NETHERRACK: return ChatColor.of("#5C0A0A");
            case NETHER_QUARTZ_ORE: return ChatColor.of("#DCEDEF");
            case NETHER_GOLD_ORE: return ChatColor.of("#EDE962");
            case ANCIENT_DEBRIS: return ChatColor.of("#846A40");
            case END_STONE: return ChatColor.of("#F6F896");
            // Digging
            case GRASS_BLOCK: return ChatColor.of("#86B846");
            case DIRT: return ChatColor.of("#91893F");
            case COARSE_DIRT: return ChatColor.of("#767031");
            case PODZOL: return ChatColor.of("#4B460B");
            case MYCELIUM: return ChatColor.of("#744F85");
            case SAND: return ChatColor.of("#EDE287");
            case RED_SAND: return ChatColor.of("#D79153");
            case SOUL_SAND: return ChatColor.of("#553314");
            case GRAVEL: return ChatColor.of("#838383");
            case CLAY: return ChatColor.of("#7E9B98");
            // Lumbering
            case OAK_LOG: return ChatColor.of("#976F24");
            case SPRUCE_LOG: return ChatColor.of("#63450D");
            case BIRCH_LOG: return ChatColor.of("#F0D199");
            case JUNGLE_LOG: return ChatColor.of("#D28F16");
            case ACACIA_LOG: return ChatColor.of("#DFBF8E");
            case DARK_OAK_LOG: return ChatColor.of("#45300F");
            case CRIMSON_STEM: return ChatColor.of("#841D33");
            case WARPED_STEM: return ChatColor.of("#3E9E61");
            case MUSHROOM_STEM: return ChatColor.of("#F3DFF2");
            // Farming
            case WHEAT: return ChatColor.of("CEC436");
            case BEETROOTS: return ChatColor.of("#7B165F");
            case CARROT: return ChatColor.of("#F39B33");
            case POTATO: return ChatColor.of("#E7C989");
            case MELON: return ChatColor.of("#9DE789");
            case PUMPKIN: return ChatColor.of("#DE7F20");
            case BAMBOO: return ChatColor.of("#8CE03C");
            case COCOA: return ChatColor.of("#8B540F");
            case SUGAR_CANE: return ChatColor.of("#94E859");
            case SWEET_BERRY_BUSH: return ChatColor.of("#CF2615");
            case CACTUS: return ChatColor.of("#21A425");
            case KELP_PLANT: return ChatColor.of("#52A054");
            case NETHER_WART: return ChatColor.of("#A83F1F");
            case CHORUS_PLANT: return ChatColor.of("#C048D4");
            case CRIMSON_FUNGUS: return ChatColor.of("#954C37");
            //
            default: return ChatColor.of("#BBBBBB");
        }
    }

}
