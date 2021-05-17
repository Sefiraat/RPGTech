package io.github.sefiraat.rpgtech.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import co.aikar.commands.bukkit.contexts.OnlinePlayer;
import io.github.sefiraat.rpgtech.RPGTech;
import io.github.sefiraat.rpgtech.finals.Messages;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static io.github.sefiraat.rpgtech.misc.utils.PlayerData.setMasteryLevel;

@CommandAlias("RPGTech|rt")
@Description("RPGTech Main")
public class Commands extends BaseCommand {

    public final RPGTech parent;

    public Commands(RPGTech parent) {
        this.parent = parent;
    }

    @Default
    public void onDefault(CommandSender sender) {
        if (sender instanceof Player) {
            sender.sendMessage(Messages.MESSAGE_COMMAND_SUBCOMMAND);
        }
    }

    @Subcommand("SetMasteryLevel")
    @CommandPermission("RPGTech.Admin")
    public class onSetLevel extends BaseCommand {
        @Subcommand("Mining")
        @CommandPermission("RPGTech.Admin")
        @CommandCompletion("@players @MAST_MINING @range:1-100")
        public void onSetMining(CommandSender sender, OnlinePlayer player, @Values("@MAST_MINING") String mastery, Integer level) {
            setMasteryLevel(parent, player.getPlayer(), "MINING", mastery, level);
            sender.sendMessage(Messages.messageMasteryLevelSet("MINING", mastery, level));
        }
    }

}
