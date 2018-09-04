package me.phelix.project.cmds;

import me.phelix.project.utils.Message;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class ReloadConfig implements CommandExecutor {

    private Plugin plugin;
    public ReloadConfig(Plugin main) { this.plugin = main; }

    public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args){

        if(!(sender instanceof Player)){
            sender.sendMessage(Message.noPlayer);
            return false;
        }
        Player p = (Player) sender;

        if(!p.hasPermission("p.reloadconfig")){
            p.sendMessage(Message.noPerm);
            return true;
        }

        if(cmd.getName().equalsIgnoreCase("reloadconfig")){
            plugin.reloadConfig();
            p.sendMessage(ChatColor.GREEN + "Config has been successfully reloaded!");
            return true;
        } else {
            p.sendMessage(ChatColor.RED + "Failed to reload the config, check the console!");
            return true;
        }
    }
}
