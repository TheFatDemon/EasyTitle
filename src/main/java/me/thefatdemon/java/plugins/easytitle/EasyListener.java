package me.thefatdemon.java.plugins.easytitle;

import be.maximvdw.titlemotd.ui.Title;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Created by TheFatDemon.
 */
public class EasyListener implements Listener {
    private final EasyTitlePlugin plugin;

    public EasyListener(EasyTitlePlugin easyTitlePlugin) {
        this.plugin = easyTitlePlugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        Title title = new Title(plugin.getConfig().getString("config.largetitle.text"),plugin.getConfig().getString("config.smalltitle.text"));
        title.setTitleColor(org.bukkit.ChatColor.valueOf(plugin.getConfig().getString("config.largetitle.color").toUpperCase()));
        title.setSubtitleColor(org.bukkit.ChatColor.valueOf(plugin.getConfig().getString("config.smalltitle.color").toUpperCase()));
        title.send(player);
    }
}
