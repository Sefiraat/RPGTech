package io.github.sefiraat.rpgtech.listeners;

import io.github.sefiraat.rpgtech.RPGTech;
import io.github.sefiraat.rpgtech.finals.Messages;
import io.github.sefiraat.rpgtech.misc.utils.Exp;
import io.github.sefiraat.rpgtech.misc.utils.enums.EnumBlockBreakType;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import javax.annotation.Nonnull;

import static io.github.sefiraat.rpgtech.finals.Config.MASTERY;
import static io.github.sefiraat.rpgtech.finals.Config.XP;
import static io.github.sefiraat.rpgtech.finals.Messages.messageMasteryGain;
import static io.github.sefiraat.rpgtech.misc.config.PlayerData.*;
import static io.github.sefiraat.rpgtech.misc.utils.Misc.*;

public class SkillExpListeners implements Listener {

    final RPGTech parent;

    public SkillExpListeners(@Nonnull RPGTech plugin) {
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
            giveExp(player, eventType, material);
            checkIfLeveled(player, eventType.toString(), material);
        }
    }

    private void giveExp(Player player, EnumBlockBreakType eventType, Material material) {
        FileConfiguration c = parent.getInstance().getRpgCorePlayerConfig();
        String cPlayerString = player.getUniqueId().toString() + "." + MASTERY + "." + eventType.toString() + "." + material + "." + XP;
        Integer currentExp = c.getInt(cPlayerString);
        Integer dueExp = parent.getConfig().getInt("SKILLS." + eventType.toString() + ".EXP_VALUES." + material.toString());
        c.set(cPlayerString, currentExp + dueExp);
    }

    private void checkIfLeveled(Player player, String skillType, Material m) {
        Integer currentLevel = getCurrentMasteryLevel(parent, player, skillType, m.toString());
        Integer currentExp = getCurrentMasteryExp(parent, player, skillType, m.toString());
        if(currentLevel < 100) {
            int requiredExp = (int) Exp.levelToExp(parent,currentLevel + 1);
            if (currentExp >= requiredExp) {
                setCurrentMasteryExp(parent, player, skillType, m.toString(), 0);
                setCurrentMasteryLevel(parent, player, skillType, m.toString(), currentLevel + 1);
                requiredExp = (int) Exp.levelToExp(parent,currentLevel + 2);
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(messageMasteryGain(m, 0, requiredExp)));
                player.sendMessage(Messages.messageMasteryLevel(m,currentLevel + 1));
            } else {
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(messageMasteryGain(m, currentExp, requiredExp)));
            }
        }
    }




}
