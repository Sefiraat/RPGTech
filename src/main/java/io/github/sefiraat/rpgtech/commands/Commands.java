package io.github.sefiraat.rpgtech.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Description;
import io.github.sefiraat.rpgtech.RPGTech;
import io.github.sefiraat.rpgtech.finals.Messages;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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
}
