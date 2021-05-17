package io.github.sefiraat.rpgtech.skills;

import io.github.sefiraat.rpgtech.RPGTech;
import io.github.sefiraat.rpgtech.misc.utils.PlayerData;
import io.github.sefiraat.rpgtech.misc.utils.enums.EnumMasteryTypeMining;
import io.github.sefiraat.rpgtech.misc.utils.enums.EnumSkillType;
import org.bukkit.entity.Player;

import java.util.EnumMap;

public class SkillProfile {

    private final RPGTech plugin;
    private final Player player;
    private final EnumMap<EnumSkillType, Skill> skills = new EnumMap<>(EnumSkillType.class);

    public Player getPlayer() {
        return player;
    }

    public EnumMap<EnumSkillType, Skill> getSkills() {
        return skills;
    }

    public SkillProfile(Player player, RPGTech plugin) {
        this.plugin = plugin;
        this.player = player;
        loadSkillProfile();
    }

    private void loadSkillProfile() {
        setupSkillMining();
    }

    private void setupSkillMining() {
        EnumSkillType type = EnumSkillType.MINING;
        Skill skill = new Skill(type);

        for (EnumMasteryTypeMining mastery : EnumMasteryTypeMining.values()) {
            skill.getMasteries().put(EnumMasteryTypeMining.STONE, new Mastery(type, PlayerData.getMasteryLevel(plugin, player, "MINING", mastery.toString())));
            skills.put(type, skill);
        }
    }


}
