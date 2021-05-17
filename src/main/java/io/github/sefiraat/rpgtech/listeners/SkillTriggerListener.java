package io.github.sefiraat.rpgtech.listeners;

import io.github.sefiraat.rpgtech.RPGTech;
import io.github.sefiraat.rpgtech.misc.utils.enums.EnumBlockBreakType;
import io.github.sefiraat.rpgtech.misc.utils.enums.EnumSkillType;
import io.github.sefiraat.rpgtech.skills.Skill;
import io.github.sefiraat.rpgtech.skills.SkillProfile;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import scala.Int;

import javax.annotation.Nonnull;

import java.util.Collection;

import static io.github.sefiraat.rpgtech.finals.Colors.getColor;
import static io.github.sefiraat.rpgtech.misc.utils.Misc.*;

public class SkillTriggerListener implements Listener {

    final RPGTech parent;

    public SkillTriggerListener(@Nonnull RPGTech plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        parent = plugin;
    }

    @EventHandler
    public void onBreakBlock(BlockBreakEvent event) {

        Block brokenBlock = event.getBlock();
        Player player = event.getPlayer();

        Material material = getMergedMaterialType(brokenBlock.getType());
        EnumBlockBreakType eventType = getEventType(material);

        if (isEventAllowed(parent, player, brokenBlock) && eventType != EnumBlockBreakType.NOTHING) {
            SkillProfile profile = new SkillProfile(event.getPlayer(), parent);
            switch (eventType) {
                case MINING:
                    skillCheckMining(event, profile);
                    break;
                case DIGGING:
                    skillCheckDigging(event);
                    break;
                case LUMBERING:
                    skillCheckLumbering(event);
                    break;
                case FARMING:
                    skillCheckFarming(event);
                    break;
            }
        }
    }

    private void skillCheckMining(BlockBreakEvent event, SkillProfile profile) {
        Skill miningSkill = profile.getSkills().get(EnumSkillType.MINING);
        Integer miningLevel = miningSkill.getLevel();
        profile.getPlayer().sendMessage("LEVEL: " + miningLevel);
        if (miningLevel >= 5) {
            skillMiningDoubleDrop(event, miningLevel);
        }
    }

    private void skillMiningDoubleDrop(BlockBreakEvent event, int skillLevel) {
        if(randInt(parent.getRandom(), 1, 100) < skillLevel) {
            Block b = event.getBlock();
            Player p = event.getPlayer();
            Collection<ItemStack> Drops = b.getDrops(p.getInventory().getItemInMainHand());
            Location loc = b.getLocation().add(0.5,0.5,0.5);
            int Red = getColor(b.getType()).getColor().getRed();
            int Green = getColor(b.getType()).getColor().getGreen();
            int Blue = getColor(b.getType()).getColor().getBlue();

            for(ItemStack i : Drops) {
                p.getWorld().dropItem(loc, i);
            }

            Particle.DustOptions dustOptions = new Particle.DustOptions(Color.fromRGB(Red, Green, Blue), 1);
            p.getWorld().spawnParticle(Particle.REDSTONE, loc, 20, 0.2, 0.2, 0.2, 0.5, dustOptions);
        }
    }

    private void skillCheckDigging(BlockBreakEvent event) {

    }

    private void skillCheckLumbering(BlockBreakEvent event) {

    }

    private void skillCheckFarming(BlockBreakEvent event) {

    }
}
