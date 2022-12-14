package com.kiritokirigami5.files;

import com.kiritokirigami5.utils.Colorize;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Config {

    private static File file;
    private static FileConfiguration customFile;

    public static void setup(){

        file = new File(Bukkit.getServer().getPluginManager().getPlugin("IADirectionalBlocks").getDataFolder(), "config.yml");

        if(!file.exists()){
            try {
                file.createNewFile();
                System.out.println(Colorize.colorize("&7[&9IADirectionalBlocks&7] &aDefault config.yml created!"));
            }catch (IOException e){
                //oops
            }
        }
        customFile = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration get(){
        return customFile;
    }

    public static void save(){
        try {
            customFile.save(file);
        }catch (IOException e){
            System.out.println("Couldn't save file!");
        }
    }

    public static void reload(){
        customFile = YamlConfiguration.loadConfiguration(file);
    }
}
