package me.phelix.project.cmds;

import me.phelix.project.utils.LevelData;
import me.phelix.project.utils.Message;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class GetStats implements CommandExecutor {

    private LevelData levelData;
    private Plugin plugin;
    public GetStats(LevelData levelData, Plugin main) { this.levelData = levelData; this.plugin = main; }

    public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args){

        if(!(sender instanceof Player)){
            sender.sendMessage(Message.noPlayer);
            return true;
        }

        if(cmd.getName().equalsIgnoreCase("stats")){
            Player p = (Player) sender;

            if(args.length == 0){
                levelData.setAllChanges(p);
                p.sendMessage(ChatColor.YELLOW + "Mining Skill: " + ChatColor.GREEN + levelData.getMineExp(p) + ChatColor.BLUE + "XP " + ChatColor.GREEN + levelData.getMineLevel(p) + ChatColor.BLUE + " Level");
                p.sendMessage(ChatColor.YELLOW + "Chat Skill: " + ChatColor.GREEN + levelData.getChatExp(p) + ChatColor.BLUE + "XP " + ChatColor.GREEN + levelData.getChatLevel(p) + ChatColor.BLUE + " Level");
                p.sendMessage(ChatColor.YELLOW + "Damage Skill: " + ChatColor.GREEN + levelData.getDamageExp(p) + ChatColor.BLUE + "XP " + ChatColor.GREEN + levelData.getDamageLevel(p) + ChatColor.BLUE + " Level");
                p.sendMessage(ChatColor.YELLOW + "Fishing Skill: " + ChatColor.GREEN + levelData.getFishingExp(p) + ChatColor.BLUE + "XP " + ChatColor.GREEN + levelData.getFishingLevel(p) + ChatColor.BLUE + " Level");
                plugin.reloadConfig();
                return true;
            }
            Player t = Bukkit.getServer().getPlayer(args[0]);
            if(t == null){
                p.sendMessage(args[0] + Message.noOnlineP);
                return true;
            }
            if(args.length == 1){
                levelData.setAllChanges(t);
                p.sendMessage(ChatColor.AQUA + t.getName());
                p.sendMessage(ChatColor.YELLOW + "Mining Skill: " + ChatColor.GREEN + levelData.getMineExp(t) + ChatColor.BLUE + "XP " + ChatColor.GREEN + levelData.getMineLevel(t) + ChatColor.BLUE + " Level");
                p.sendMessage(ChatColor.YELLOW + "Chat Skill: " + ChatColor.GREEN + levelData.getChatExp(t) + ChatColor.BLUE + "XP " + ChatColor.GREEN + levelData.getChatLevel(t) + ChatColor.BLUE + " Level");
                p.sendMessage(ChatColor.YELLOW + "Damage Skill: " + ChatColor.GREEN + levelData.getDamageExp(t) + ChatColor.BLUE + "XP " + ChatColor.GREEN + levelData.getDamageLevel(t) + ChatColor.BLUE + " Level");
                p.sendMessage(ChatColor.YELLOW + "Fishing Skill: " + ChatColor.GREEN + levelData.getFishingExp(t) + ChatColor.BLUE + "XP " + ChatColor.GREEN + levelData.getFishingLevel(t) + ChatColor.BLUE + " Level");
                return true;
            }
        }return true;
    }
}
