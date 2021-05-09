package io.github.sefiraat.rpgtech.finals;

import net.md_5.bungee.api.ChatColor;

public final class Messages {

    private Messages() {
        throw new IllegalStateException("Utility class");
    }

    // General
    public static final String PREFIX = "" + ChatColor.GRAY + "[DankTech] ";
    public static final String SUFFIX = "" + ChatColor.GRAY + "";

    public static final String WARNING = "" + ChatColor.YELLOW;
    public static final String ERROR = "" + ChatColor.RED;
    public static final String NOTICE = "" + ChatColor.WHITE;
    public static final String PASSIVE = "" + ChatColor.GRAY;
    public static final String SUCCESS = "" + ChatColor.GREEN;


    // Commands
    public static final String MESSAGE_COMMAND_SUBCOMMAND = PREFIX + NOTICE + "Please select a valid sub command";


}
