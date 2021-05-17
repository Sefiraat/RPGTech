package io.github.sefiraat.rpgtech.misc.utils;

import io.github.sefiraat.rpgtech.RPGTech;

public class Exp {

    private Exp() {
        throw new IllegalStateException("Utility class");
    }

    public static int level(RPGTech plugin, double exp) {

        int i = 0;
        double testExp = (plugin.getRpgConfig().getExpBaseVal());

        while ( i < 100 ) {
            if (testExp > exp) {
                return i;
            }
            testExp = testExp + testExp * plugin.getRpgConfig().getExpGrowthVal();
            i++;
        }

        return 100;
    }

    public static double levelToExp(RPGTech plugin, int level) {
        if(level == 1)
            return plugin.getRpgConfig().getExpBaseVal();
        else {
            double prev = levelToExp(plugin,level-1);
            return prev + prev * plugin.getRpgConfig().getExpGrowthVal();
        }
    }

    public static double levelToTotalExp(RPGTech plugin, int level) {
        if(level == 1)
            return plugin.getRpgConfig().getExpBaseVal();
        else {
            return levelToTotalExp(plugin,level-1) + levelToExp(plugin,level-1) * (1 + plugin.getRpgConfig().getExpGrowthVal());
        }
    }
}
