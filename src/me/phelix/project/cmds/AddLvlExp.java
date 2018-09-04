package me.phelix.project.cmds;

import me.phelix.project.utils.LevelData;
import me.phelix.project.utils.Message;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class AddLvlExp implements CommandExecutor {

    private LevelData levelData;
    private Plugin plugin;
    public AddLvlExp(LevelData levelData1, Plugin main) { this.levelData = levelData1; this.plugin = main; }


    public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(Message.noPlayer);
            return true;
        }

        Player p = (Player) sender;
        if(!p.hasPermission("p.setstats")){
            p.sendMessage(Message.noPerm);
            return true;
        }
        String number = args[2];
        Integer value = Integer.valueOf(number).intValue();
        if (cmd.getName().equalsIgnoreCase("exp")) {
            if (args[0].equalsIgnoreCase("add")) {
                if(value >= 10000){
                    p.sendMessage(Message.warningHighExp);
                }
                if (args[1].equalsIgnoreCase("mine")) {
                    levelData.addMineExpInt(p, value);
                    levelData.setMineChange(p);
                    plugin.saveConfig();
                    return true;
                }
                if(args[1].equalsIgnoreCase("chat")){
                    levelData.addChatExpInt(p, value);
                    levelData.setChatChange(p);
                    plugin.saveConfig();
                    return true;
                }
                if(args[1].equalsIgnoreCase("damage")){
                    levelData.addDamageExpInt(p, value);
                    levelData.setDamageChange(p);
                    plugin.saveConfig();
                    return true;
                }
                if(args[1].equalsIgnoreCase("fishing")){
                    levelData.addFishingExpLvl(p, value);
                    levelData.setFishingChange(p);
                    plugin.saveConfig();
                    return true;
                }
            }
        }

        if(cmd.getName().equalsIgnoreCase("level")) {
            if (args[0].equalsIgnoreCase("add")) {
                if (args[1].equalsIgnoreCase("mine")) {
                    levelData.addMineLvlInt(p, value);
                    plugin.saveConfig();
                    return true;
                }
                if (args[1].equalsIgnoreCase("chat")) {
                    levelData.addChatLvlInt(p, value);
                    plugin.saveConfig();
                    return true;
                }
                if (args[1].equalsIgnoreCase("damage")) {
                    levelData.addDamageLvlInt(p, value);
                    plugin.saveConfig();
                    return true;
                }
                if (args[1].equalsIgnoreCase("fishing")) {
                    levelData.addFishingLvlInt(p, value);
                    plugin.saveConfig();
                    return true;
                }
            }
        }
        return true;
    }
}
