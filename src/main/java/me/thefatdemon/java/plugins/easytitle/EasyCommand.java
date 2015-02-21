package me.thefatdemon.java.plugins.easytitle;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Created by thefatdemon.
 */
public class EasyCommand implements CommandExecutor {
    private final EasyTitlePlugin plugin;

    public EasyCommand(EasyTitlePlugin easyTitlePlugin) {
        this.plugin = easyTitlePlugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!commandSender.hasPermission("easytitle.admin")){
            commandSender.sendMessage(ChatColor.RED + "[ET] You Cannot");
            return false;
        }

        plugin.reloadConfig();

        commandSender.sendMessage(ChatColor.GOLD + "[ET] Reloaded Config");
        return true;
    }
}
