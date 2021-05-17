package io.github.sefiraat.rpgtech.misc.utils;

import io.github.sefiraat.rpgtech.RPGTech;
import io.github.sefiraat.rpgtech.misc.utils.enums.EnumBlockBreakType;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;

import java.util.List;
import java.util.Random;

import static io.github.sefiraat.rpgtech.finals.General.BLOCK_PLACED;

public class Misc {

    private Misc() {
        throw new IllegalStateException("Utility class");
    }

    public static EnumBlockBreakType getEventType(Material m) {
        switch (m) {
            case STONE:
            case COAL_ORE:
            case IRON_ORE:
            case GOLD_ORE:
            case REDSTONE_ORE:
            case LAPIS_ORE:
            case EMERALD_ORE:
            case DIAMOND_ORE:
            case NETHERRACK:
            case NETHER_QUARTZ_ORE:
            case NETHER_GOLD_ORE:
            case ANCIENT_DEBRIS:
            case END_STONE:
                return EnumBlockBreakType.MINING;
            case GRASS_BLOCK:
            case DIRT:
            case COARSE_DIRT:
            case PODZOL:
            case MYCELIUM:
            case SAND:
            case RED_SAND:
            case SOUL_SAND:
            case GRAVEL:
            case CLAY:
                return EnumBlockBreakType.DIGGING;
            case OAK_LOG:
            case SPRUCE_LOG:
            case BIRCH_LOG:
            case JUNGLE_LOG:
            case ACACIA_LOG:
            case DARK_OAK_LOG:
            case CRIMSON_STEM:
            case WARPED_STEM:
            case MUSHROOM_STEM:
                return EnumBlockBreakType.LUMBERING;
            case WHEAT:
            case BEETROOTS:
            case CARROT:
            case POTATO:
            case MELON:
            case PUMPKIN:
            case BAMBOO:
            case COCOA:
            case SUGAR_CANE:
            case SWEET_BERRY_BUSH:
            case CACTUS:
            case KELP_PLANT:
            case NETHER_WART_BLOCK:
            case CHORUS_PLANT:
            case CRIMSON_FUNGUS:
                return EnumBlockBreakType.FARMING;
            default:
                return EnumBlockBreakType.NOTHING;
        }
    }

    public static Material getMergedMaterialType(Material material) {
        // Merge materials on same-types (Like Stone/Granite etc.)
        switch (material) {
            case GRANITE:
            case ANDESITE:
            case DIORITE:
            case SANDSTONE:
                return Material.STONE;
            case OAK_WOOD:
            case STRIPPED_OAK_LOG:
            case STRIPPED_OAK_WOOD:
                return Material.OAK_LOG;
            case SPRUCE_WOOD:
            case STRIPPED_SPRUCE_LOG:
            case STRIPPED_SPRUCE_WOOD:
                return Material.SPRUCE_LOG;
            case BIRCH_WOOD:
            case STRIPPED_BIRCH_LOG:
            case STRIPPED_BIRCH_WOOD:
                return Material.BIRCH_LOG;
            case JUNGLE_WOOD:
            case STRIPPED_JUNGLE_LOG:
            case STRIPPED_JUNGLE_WOOD:
                return Material.JUNGLE_LOG;
            case ACACIA_WOOD:
            case STRIPPED_ACACIA_LOG:
            case STRIPPED_ACACIA_WOOD:
                return Material.ACACIA_LOG;
            case DARK_OAK_WOOD:
            case STRIPPED_DARK_OAK_LOG:
            case STRIPPED_DARK_OAK_WOOD:
                return Material.DARK_OAK_LOG;
            case CRIMSON_HYPHAE:
            case STRIPPED_CRIMSON_STEM:
            case STRIPPED_CRIMSON_HYPHAE:
                return Material.CRIMSON_STEM;
            case WARPED_HYPHAE:
            case STRIPPED_WARPED_STEM:
            case STRIPPED_WARPED_HYPHAE:
                return Material.WARPED_STEM;
            case RED_MUSHROOM_BLOCK:
            case BROWN_MUSHROOM_BLOCK:
                return Material.MUSHROOM_STEM;
            case CRIMSON_FUNGUS:
            case WARPED_FUNGUS:
                return Material.CRIMSON_FUNGUS;
            default:
                return material;
        }
    }

    public static Boolean checkEventTool(EnumBlockBreakType breakEventType, Material tool) {
        switch (breakEventType) {
            case MINING: {
                switch (tool) {
                    case WOODEN_PICKAXE:
                    case STONE_PICKAXE:
                    case IRON_PICKAXE:
                    case GOLDEN_PICKAXE:
                    case DIAMOND_PICKAXE:
                    case NETHERITE_PICKAXE:
                        return true;
                    default:
                        return false;
                }
            }
            case DIGGING: {
                switch (tool) {
                    case WOODEN_SHOVEL:
                    case STONE_SHOVEL:
                    case IRON_SHOVEL:
                    case GOLDEN_SHOVEL:
                    case DIAMOND_SHOVEL:
                    case NETHERITE_SHOVEL:
                        return true;
                    default:
                        return false;
                }
            }
            case LUMBERING: {
                switch (tool) {
                    case WOODEN_AXE:
                    case STONE_AXE:
                    case IRON_AXE:
                    case GOLDEN_AXE:
                    case DIAMOND_AXE:
                    case NETHERITE_AXE:
                        return true;
                    default:
                        return false;
                }
            }
            case FARMING: {
                switch (tool) {
                    case WOODEN_HOE:
                    case STONE_HOE:
                    case IRON_HOE:
                    case GOLDEN_HOE:
                    case DIAMOND_HOE:
                    case NETHERITE_HOE:
                        return true;
                    default:
                        return false;
                }
            }
            default: {
                return false;
            }
        }
    }

    public static boolean isPlacedBlock(Block b) {
        boolean isPlaced = false;
        List<MetadataValue> metaDataValues = b.getMetadata(BLOCK_PLACED);
        if (!metaDataValues.isEmpty()) {
            isPlaced = true;
        }
        return isPlaced;
    }

    public static void setPlacedBlock(RPGTech plugin, Block b) {
        b.setMetadata(BLOCK_PLACED, new FixedMetadataValue(plugin, b));
    }

    public static boolean isEventAllowed(RPGTech plugin, Player player, Block brokenBlock) {

        Material material = getMergedMaterialType(brokenBlock.getType());
        Material heldTool = player.getInventory().getItemInMainHand().getType();
        EnumBlockBreakType eventType = getEventType(material);

        boolean toolCorrect = checkEventTool(eventType, heldTool);
        boolean toolRequired = plugin.getRpgConfig().isRequireCorrectTool();
        boolean placedAllowed = plugin.getRpgConfig().isAllowPlacedBlocks();
        boolean placedBlock = isPlacedBlock(brokenBlock);

        return (placedAllowed || !placedBlock) && (!toolRequired || toolCorrect);
    }

    public static int getRandBetween(int low, int high) {
        Random r = new Random();
        return r.nextInt(high-low) + low;
    }

    /**
     * @param min Minimum value
     * @param max Maximum value.  Must be greater than min.
     * @return Integer between min and max, inclusive.
     * @see java.util.Random#nextInt(int)
     */
    public static int randInt(Random r, int min, int max) {
        int randomNum = r.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public static boolean isBetween(int x, int lower, int upper) {
        return lower <= x && x <= upper;
    }

    public static int niceRound(double Number, int RoundTo) {
        return (int) (Math.ceil(Number * Math.pow(RoundTo, -Math.floor(Math.log10(Number)))) / Math.pow(RoundTo, -Math.floor(Math.log10(Number))));
    }
}
