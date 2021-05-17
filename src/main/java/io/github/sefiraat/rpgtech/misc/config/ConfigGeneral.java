package io.github.sefiraat.rpgtech.misc.config;

import io.github.sefiraat.rpgtech.RPGTech;

public class ConfigGeneral {

    // GENERAL

    private boolean requireCorrectTool;
    private boolean allowPlacedBlocks;
    private double expBaseVal;
    private double expGrowthVal;

    public boolean isAllowPlacedBlocks() {
        return allowPlacedBlocks;
    }
    public boolean isRequireCorrectTool() {
        return requireCorrectTool;
    }
    public double getExpGrowthVal() {
        return expGrowthVal;
    }
    public double getExpBaseVal() {
        return expBaseVal;
    }

    // MINING

    private int miningSkillLevelDoubleDrop;
    private int miningSkillLevelHastyPick1;
    private int miningSkillLevelHastyPick2;
    private int miningSkillLevelHastyPick3;
    private int miningSkillLevelHastyPick4;
    private int miningSkillLevelLuckyPick1;
    private int miningSkillLevelLuckyPick2;
    private int miningSkillLevelLuckyPick3;
    private int miningSkillLevelLuckyPick4;
    private int miningSkillLevelPickCrafting1;
    private int miningSkillLevelPickCrafting2;
    private int miningSkillLevelPickCrafting3;
    private int miningSkillLevelPickCrafting4;
    private int miningSkillLevelPickCrafting5;
    private int miningSkillLevelXPGain1;
    private int miningSkillLevelArtifacts1;
    private int miningSkillLevelArtifacts2;
    private int miningSkillLevelPickRepair1;
    private int miningSkillLevelPack1;

    public int getMiningSkillLevelDoubleDrop() {
        return miningSkillLevelDoubleDrop;
    }
    public int getMiningSkillLevelHastyPick1() {
        return miningSkillLevelHastyPick1;
    }
    public int getMiningSkillLevelHastyPick2() {
        return miningSkillLevelHastyPick2;
    }
    public int getMiningSkillLevelHastyPick3() {
        return miningSkillLevelHastyPick3;
    }
    public int getMiningSkillLevelHastyPick4() {
        return miningSkillLevelHastyPick4;
    }
    public int getMiningSkillLevelLuckyPick1() {
        return miningSkillLevelLuckyPick1;
    }
    public int getMiningSkillLevelLuckyPick2() {
        return miningSkillLevelLuckyPick2;
    }
    public int getMiningSkillLevelLuckyPick3() {
        return miningSkillLevelLuckyPick3;
    }
    public int getMiningSkillLevelLuckyPick4() {
        return miningSkillLevelLuckyPick4;
    }
    public int getMiningSkillLevelPickCrafting1() {
        return miningSkillLevelPickCrafting1;
    }
    public int getMiningSkillLevelPickCrafting2() {
        return miningSkillLevelPickCrafting2;
    }
    public int getMiningSkillLevelPickCrafting3() {
        return miningSkillLevelPickCrafting3;
    }
    public int getMiningSkillLevelPickCrafting4() {
        return miningSkillLevelPickCrafting4;
    }
    public int getMiningSkillLevelPickCrafting5() {
        return miningSkillLevelPickCrafting5;
    }
    public int getMiningSkillLevelXPGain1() {
        return miningSkillLevelXPGain1;
    }
    public int getMiningSkillLevelArtifacts1() {
        return miningSkillLevelArtifacts1;
    }
    public int getMiningSkillLevelArtifacts2() {
        return miningSkillLevelArtifacts2;
    }
    public int getMiningSkillLevelPickRepair1() {
        return miningSkillLevelPickRepair1;
    }
    public int getMiningSkillLevelPack1() {
        return miningSkillLevelPack1;
    }

    public ConfigGeneral(RPGTech plugin) {
        loadGeneral(plugin);
        loadMining(plugin);
    }

    private void loadGeneral(RPGTech plugin) {
        requireCorrectTool = plugin.getConfig().getBoolean("GENERAL.REQUIRE_CORRECT_TOOL");
        allowPlacedBlocks = plugin.getConfig().getBoolean("GENERAL.ALLOW_PLACED_BLOCKS");
        expBaseVal = plugin.getConfig().getDouble("LEVELING.EXP_BASE");
        expGrowthVal = plugin.getConfig().getDouble("LEVELING.EXP_GROWTH");
    }

    private void loadMining(RPGTech plugin) {
        miningSkillLevelDoubleDrop = plugin.getConfig().getInt("SKILLS.MINING.LEVELS.DOUBLE_DROP_1");
        miningSkillLevelHastyPick1 = plugin.getConfig().getInt("SKILLS.MINING.LEVELS.HASTY_PICK_1");
        miningSkillLevelHastyPick2 = plugin.getConfig().getInt("SKILLS.MINING.LEVELS.HASTY_PICK_2");
        miningSkillLevelHastyPick3 = plugin.getConfig().getInt("SKILLS.MINING.LEVELS.HASTY_PICK_3");
        miningSkillLevelHastyPick4 = plugin.getConfig().getInt("SKILLS.MINING.LEVELS.HASTY_PICK_4");
        miningSkillLevelLuckyPick1 = plugin.getConfig().getInt("SKILLS.MINING.LEVELS.LUCKY_PICK_1");
        miningSkillLevelLuckyPick2 = plugin.getConfig().getInt("SKILLS.MINING.LEVELS.LUCKY_PICK_2");
        miningSkillLevelLuckyPick3 = plugin.getConfig().getInt("SKILLS.MINING.LEVELS.LUCKY_PICK_3");
        miningSkillLevelLuckyPick4 = plugin.getConfig().getInt("SKILLS.MINING.LEVELS.LUCKY_PICK_4");
        miningSkillLevelPickCrafting1 = plugin.getConfig().getInt("SKILLS.MINING.LEVELS.PICK_CRAFTING_1");
        miningSkillLevelPickCrafting2 = plugin.getConfig().getInt("SKILLS.MINING.LEVELS.PICK_CRAFTING_2");
        miningSkillLevelPickCrafting3 = plugin.getConfig().getInt("SKILLS.MINING.LEVELS.PICK_CRAFTING_3");
        miningSkillLevelPickCrafting4 = plugin.getConfig().getInt("SKILLS.MINING.LEVELS.PICK_CRAFTING_4");
        miningSkillLevelPickCrafting5 = plugin.getConfig().getInt("SKILLS.MINING.LEVELS.PICK_CRAFTING_5");
        miningSkillLevelXPGain1 = plugin.getConfig().getInt("SKILLS.MINING.LEVELS.XP_GAIN_1");
        miningSkillLevelArtifacts1 = plugin.getConfig().getInt("SKILLS.MINING.LEVELS.ARTIFACTS_1");
        miningSkillLevelArtifacts2 = plugin.getConfig().getInt("SKILLS.MINING.LEVELS.ARTIFACTS_2");
        miningSkillLevelPickRepair1 = plugin.getConfig().getInt("SKILLS.MINING.LEVELS.PICK_REPAIR");
        miningSkillLevelPack1 = plugin.getConfig().getInt("SKILLS.MINING.LEVELS.PACK_1");
    }

}
