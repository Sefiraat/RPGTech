package io.github.sefiraat.rpgtech.skills;

import io.github.sefiraat.rpgtech.misc.utils.enums.EnumMasteryTypeMining;
import io.github.sefiraat.rpgtech.misc.utils.enums.EnumSkillType;

import java.util.EnumMap;
import java.util.Map;

public class Skill {

    private final EnumSkillType skillType;
    private final EnumMap<EnumMasteryTypeMining, Mastery> masteries = new EnumMap<>(EnumMasteryTypeMining.class);

    public EnumSkillType getSkillType() {
        return skillType;
    }

    public Map<EnumMasteryTypeMining, Mastery> getMasteries() {
        return masteries;
    }

    public Integer getLevel() {
        double level = 0D;
        double count = 0D;
        for (Map.Entry<EnumMasteryTypeMining, Mastery> entry : masteries.entrySet()) {
            count++;
            level = level + entry.getValue().getLevel();
        }
        level = Math.floor(level / count);
        return (int) level;
    }

    public Skill(EnumSkillType skillType) {
        this.skillType = skillType;
    }

}
