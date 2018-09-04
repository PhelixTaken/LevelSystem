package me.phelix.project.cmds;

import me.phelix.project.utils.LevelData;
import me.phelix.project.utils.Message;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.Map;

public class ResetStats implements CommandExecutor {

    private Plugin plugin;
    private LevelData levelData;
    public ResetStats(Plugin main, LevelData levelData1) { this.plugin = main; this.levelData = levelData1; }

    private Map<Player, Boolean> confirm = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {

        if(!(sender instanceof Player)){
            sender.sendMessage(Message.noPlayer);
            return true;
        }

        Player p = (Player) sender;

        if(!p.hasPermission("p.resetstats")){
            p.sendMessage(Message.noPerm);
            return true;
        }

        if(cmd.getName().equalsIgnoreCase("resetstats")) {
            if(args.length == 0) {
                if (confirm.containsKey(true)) {
                    p.sendMessage(ChatColor.RED + "Please use the command " + ChatColor.WHITE + "/resetstats confirm " + ChatColor.RED + "to confirm!");
                    confirm.put(p, false);
                    return true;
                }
            }
            if(args.length == 1){
            if (args[1].equalsIgnoreCase("confirm")) {
                if (confirm.containsKey(false)) {
                    levelData.resetStats(p);
                    confirm.put(p, true);
                    return true;
                }
            }
            }
        }
            return true;

        }
}
