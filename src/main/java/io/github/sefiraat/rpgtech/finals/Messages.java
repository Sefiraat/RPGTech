package io.github.sefiraat.rpgtech.finals;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;

import static io.github.sefiraat.rpgtech.finals.Colors.getColor;

public final class Messages {

    private Messages() {
        throw new IllegalStateException("Utility class");
    }

    // ConfigGeneral
    public static final String PREFIX = "" + ChatColor.GRAY + "[RPGTech] ";
    public static final String SUFFIX = "" + ChatColor.GRAY + "";

    public static final String WARNING = "" + ChatColor.YELLOW;
    public static final String LEVELUP = "" + ChatColor.GOLD;
    public static final String ERROR = "" + ChatColor.RED;
    public static final String NOTICE = "" + ChatColor.WHITE;
    public static final String PASSIVE = "" + ChatColor.GRAY;
    public static final String SUCCESS = "" + ChatColor.GREEN;

    public static String getFriendlyBlockName(Material m) {
        switch (m) {
            case STONE:
                return "Stone";
            case COAL_ORE:
                return "Coal";
            case IRON_ORE:
                return "Iron";
            case GOLD_ORE:
                return "Gold";
            case REDSTONE_ORE:
                return "Redstone";
            case LAPIS_ORE:
                return "Lapis";
            case EMERALD_ORE:
                return "Emerald";
            case DIAMOND_ORE:
                return "Diamond";
            case NETHERRACK:
                return "Netherrack";
            case NETHER_QUARTZ_ORE:
                return "Quartz";
            case NETHER_GOLD_ORE:
                return "Nether Gold";
            case ANCIENT_DEBRIS:
                return "Debris";
            case END_STONE:
                return "End Stone";
            case GRASS_BLOCK:
                return "Grass";
            case DIRT:
                return "Dirt";
            case COARSE_DIRT:
                return "Coarse Dirt";
            case PODZOL:
                return "Podzol";
            case MYCELIUM:
                return "Mycelium";
            case SAND:
                return "Sand";
            case RED_SAND:
                return "Red Sand";
            case SOUL_SAND:
                return "Soul Sand";
            case GRAVEL:
                return "Gravel";
            case CLAY:
                return "Clay";
            case OAK_LOG:
                return "Oak";
            case SPRUCE_LOG:
                return "Spruce";
            case BIRCH_LOG:
                return "Birch";
            case JUNGLE_LOG:
                return "Jungle";
            case ACACIA_LOG:
                return "Acacia";
            case DARK_OAK_LOG:
                return "Dark Oak";
            case CRIMSON_STEM:
                return "Crimson Fungus";
            case WARPED_STEM:
                return "Warped Fungus";
            case MUSHROOM_STEM:
                return "Mushroom";
            case WHEAT:
                return "Wheat";
            case BEETROOTS:
                return "Beetroot";
            case CARROT:
                return "Carrot";
            case POTATO:
                return "Potato";
            case MELON:
                return "Melon";
            case PUMPKIN:
                return "Pumpkin";
            case BAMBOO:
                return "Bamboo";
            case COCOA:
                return "Cocoa";
            case SUGAR_CANE:
                return "Sugar Cane";
            case SWEET_BERRY_BUSH:
                return "Sweet Berry";
            case CACTUS:
                return "Cactus";
            case KELP_PLANT:
                return "Kelp";
            case NETHER_WART:
                return "Nether Wart";
            case CHORUS_PLANT:
                return "Chorus";
            case CRIMSON_FUNGUS:
                return "Nether Fungus";
            default:
                throw new IllegalStateException("Unexpected value: " + m.toString());
        }
    }

    // Commands
    public static final String MESSAGE_COMMAND_SUBCOMMAND = PREFIX + NOTICE + "Please select a valid sub command";

    public static String messageMasteryLevelSet(String skill, String mastery, Integer level) {
        return PREFIX + SUCCESS + "[" + skill + "] - [" + mastery + "] Set to level : " + level;
    }

    // Events
    public static String messageMasteryLevel(Material m, int currentLevel) {
        return PREFIX + LEVELUP  + "Your " + ChatColor.BOLD + getColor(m) + getFriendlyBlockName(m) + ChatColor.BOLD + LEVELUP + " mastery has leveled up to " + (currentLevel + 1) + "/100";
    }

    public static String messageMasteryGain(Material m, int currentXP, int requiredXP) {
        return PREFIX + PASSIVE + "You have gained " + getColor(m) + getFriendlyBlockName(m) + PASSIVE +" mastery. " +  currentXP + "/" + requiredXP;
    }
}
