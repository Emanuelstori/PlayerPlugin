package com.runeforger.Utils;

import java.io.File;

import org.bukkit.plugin.Plugin;

import com.runeforger.RuneForger;

public class Playerfile {
    Plugin plugin = RuneForger.getPlugin(RuneForger.class);

    public void create(String uuid, String fileName) {
    }

    public void createFolder(String name) {
        File folder = new File(plugin.getDataFolder() + File.separator + "Players", name);
        if (!folder.exists()) {
            try {
                folder.mkdirs();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
