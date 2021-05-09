package io.github.sefiraat.rpgtech.timers;

import io.github.sefiraat.rpgtech.RPGTech;

import java.io.IOException;
import java.util.TimerTask;

public class TimerSave extends TimerTask {

    public final RPGTech parent;

    public TimerSave(RPGTech parent) {
        this.parent = parent;
    }

    public void run() {
        try {
            parent.getInstance().getRpgCorePlayerConfig().save(parent.getRpgCorePlayerConfigFile());
            parent.getLogger().info("RPGTech Player data saved");
        } catch (IOException e) {
            parent.getLogger().warning("Unable to save " + parent.getInstance().getRpgCorePlayerConfig().getName());
        }
    }
}