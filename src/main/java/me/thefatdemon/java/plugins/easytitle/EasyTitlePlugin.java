package me.thefatdemon.java.plugins.easytitle;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by TheFatDemon.
 */
public class EasyTitlePlugin extends JavaPlugin {

    @Override
    public void onEnable(){
        getLogger().info("Starting EasyTitle");

        FileConfiguration config = getConfig();

        saveDefaultConfig();

        saveConfig();

        if (config.getString("config.largetitle.text").equals("")){
            config.set("config.largetitle.text", "Change Me");
        }

        if (config.getString("config.smalltitle.text").equals("")){
            config.set("config.smalltitle.text", "Change Me too");
        }

        if (ChatColor.valueOf(config.getString("config.largetitle.color").toUpperCase()) != null){
            config.set("config.largetitle.color", "GOLD");
        }

        if (ChatColor.valueOf(config.getString("config.smalltitle.color").toUpperCase()) != null){
            config.set("config.smalltitle.color", "GOLD");
        }

        saveConfig();

        getServer().getPluginManager().registerEvents(new EasyListener(this), this);

        getCommand("easytitle").setExecutor(new EasyCommand(this));

        getLogger().info("EasyTitle Has been enabled.");
    }

    @Override
    public void onDisable(){
        getLogger().info("Disabling EasyTitle");
        reloadConfig();
        saveConfig();
        getLogger().info("Disabled EasyTitle");
    }
}
