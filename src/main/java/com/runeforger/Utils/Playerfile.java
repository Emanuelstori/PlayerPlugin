package com.runeforger.Utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.runeforger.models.Adventurer;
import org.bukkit.plugin.Plugin;

import com.runeforger.RuneForger;

public class Playerfile {
    Plugin plugin = RuneForger.getPlugin(RuneForger.class);

    public void create(String uuid, String fileName) {
    }

    public String createFolder(String name) {
        File folder = new File(plugin.getDataFolder() + File.separator + "Players", name);
        if (!folder.exists()) {
            try {
                folder.mkdirs();
                return folder.getAbsolutePath();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return null;
            }
        }
        return null;
    }
    public void createJsonAdventurer(Adventurer adventurer, String path){
        try {
            System.out.println(path);
            ObjectMapper mapper = new ObjectMapper();
            //ERRO LOGO ABAIXO
            String json = mapper.writeValueAsString(adventurer);

            FileWriter file = new FileWriter(path + "\\playerData.json");
            file.write(json);
            file.close();

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
