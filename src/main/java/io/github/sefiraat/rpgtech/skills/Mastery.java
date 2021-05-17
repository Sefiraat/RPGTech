package io.github.sefiraat.rpgtech.skills;

import io.github.sefiraat.rpgtech.misc.utils.enums.*;

public class Mastery {

    private final EnumSkillType skillType;

    private final Integer level;
    public Integer getLevel() {
        return level;
    }

    public Mastery(EnumSkillType skillType, Integer level) {
        this.skillType = skillType;
        this.level = level;
    }

}
