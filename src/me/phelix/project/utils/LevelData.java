package me.phelix.project.utils;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.concurrent.ThreadLocalRandom;

public class LevelData {

    private Plugin plugin;
    public LevelData(Plugin main) { this.plugin = main; }

//    public Integer getAverageExp(Player p){
//       return plugin.getConfig().getInt("Players." + p.getUniqueId().toString() + ".EXP");
//    }
//
//    public Integer getAverageLevel(Player p){
//        return plugin.getConfig().getInt("Players." + p.getUniqueId().toString() + ".Levels");
//    }

    public Integer getMineExp(Player p){
        return plugin.getConfig().getInt("Players." + p.getUniqueId().toString() + ".Name: " + p.getName() + ".EXP.Mining");
    }

    public Integer getMineLevel(Player p){
        return plugin.getConfig().getInt("Players." + p.getUniqueId().toString() + ".Name: " + p.getName() + ".Level.Mining");
    }

    public Integer getChatExp(Player p){
        return plugin.getConfig().getInt("Players." + p.getUniqueId().toString() + ".Name: " + p.getName() + ".EXP.Chat");
    }

    public Integer getChatLevel(Player p){
        return plugin.getConfig().getInt("Players." + p.getUniqueId().toString() + ".Name: " + p.getName() + ".Level.Chat");
    }

    public Integer getDamageExp(Player p){
        return plugin.getConfig().getInt("Players." + p.getUniqueId().toString() + ".Name: " + p.getName() + ".EXP.Damage");
    }

    public Integer getDamageLevel(Player p){
        return plugin.getConfig().getInt("Players." + p.getUniqueId().toString() + ".Name: " + p.getName() + ".Level.Damage");
    }

    public Integer getFishingExp(Player p){
        return plugin.getConfig().getInt("Players." + p.getUniqueId().toString() + ".Name: " + p.getName() + ".EXP.Fishing");
    }

    public Integer getFishingLevel(Player p){
        return plugin.getConfig().getInt("Players." + p.getUniqueId().toString() + ".Name: " + p.getName() + ".Level.Fishing");
    }

    public Integer setExp(Player p){
       return ThreadLocalRandom.current().nextInt(5, 15 + 1);
    }

    public void setMineChange(Player p) {
        int formula = (getMineLevel(p) * 5) + 30;
        while (getMineExp(p) >= formula) {
                plugin.getConfig().set("Players." + p.getUniqueId().toString() + ".Name: " + p.getName() + ".EXP.Mining", getMineExp(p) -  formula);
                plugin.getConfig().set("Players." + p.getUniqueId().toString() + ".Name: " + p.getName() + ".Level.Mining", getMineLevel(p) + 1);
                plugin.saveConfig();
            }
        }

    public void setChatChange(Player p){
        int formula = (getChatLevel(p) * 5) + 30;
        while (getChatExp(p) >= formula){
            plugin.getConfig().set("Players." + p.getUniqueId().toString() + ".Name: " + p.getName() + ".EXP.Chat", getChatExp(p) - formula);
            plugin.getConfig().set("Players." + p.getUniqueId().toString() + ".Name: " + p.getName() + ".Level.Chat", getChatLevel(p) + 1);
            plugin.saveConfig();
        }
    }

    public void setDamageChange(Player p){
        int formula = (getDamageLevel(p) * 5) + 30;
        while (getDamageExp(p) >= formula){
            plugin.getConfig().set("Players." + p.getUniqueId().toString() + ".Name: " + p.getName() + ".EXP.Damage", getDamageExp(p) - formula);
            plugin.getConfig().set("Players." + p.getUniqueId().toString() + ".Name: " + p.getName() + ".Level.Damage", getDamageLevel(p) + 1);
            plugin.saveConfig();
        }
    }

    public void setFishingChange(Player p){
        int formula = (getFishingLevel(p) * 5) + 30;
        while (getFishingExp(p) >= formula){
            plugin.getConfig().set("Players." + p.getUniqueId().toString() + ".Name: " + p.getName() + ".EXP.Fishing", getFishingExp(p) - formula);
            plugin.getConfig().set("Players." + p.getUniqueId().toString() + ".Name: " + p.getName() + ".Level.Fishing", getFishingLevel(p) + 1);
            plugin.saveConfig();
        }
    }

    public void setAllChanges(Player p){
        setMineChange(p);
        setChatChange(p);
        setDamageChange(p);
        setFishingChange(p);
    }

    public void addMineExpInt(Player p, int i){
        int xp = getMineExp(p);
        plugin.getConfig().set("Players." + p.getUniqueId().toString() + ".Name: " + p.getName() + ".EXP.Mining", xp + i);
    }

    public void addMineLvlInt(Player p, int i){
        int lvl = getMineLevel(p);
        plugin.getConfig().set("Players." + p.getUniqueId().toString() + ".Name: " + p.getName() + ".Level.Mining", lvl + i);
    }

    public void addChatExpInt(Player p, int i){
        int lvl = getChatExp(p);
        plugin.getConfig().set("Players." + p.getUniqueId().toString() + ".Name: " + p.getName() + ".EXP.Chat", lvl + i);
    }

    public void addChatLvlInt(Player p, int i){
        int lvl = getChatLevel(p);
        plugin.getConfig().set("Players." + p.getUniqueId().toString() + ".Name: " + p.getName() + ".Level.Chat", lvl + i);
    }

    public void addDamageExpInt(Player p, int i){
        int xp = getDamageExp(p);
        plugin.getConfig().set("Players." + p.getUniqueId().toString() + ".Name: " + p.getName() + ".EXP.Damage", xp + i);
    }

    public void addDamageLvlInt(Player p, int i){
        int lvl = getDamageLevel(p);
        plugin.getConfig().set("Players." + p.getUniqueId().toString() + ".Name: " + p.getName() + ".Level.Damage", lvl + i);
    }

    public void addFishingExpLvl(Player p, int i){
        int xp = getFishingExp(p);
        plugin.getConfig().set("Players." + p.getUniqueId().toString() + ".Name: " + p.getName() + ".EXP.Fishing", xp + i);
    }

    public void addFishingLvlInt(Player p, int i){
        int lvl = getFishingLevel(p);
        plugin.getConfig().set("Players." + p.getUniqueId().toString() + ".Name: " + p.getName() + ".Level.Fishing", lvl + i);
    }

    public void resetStats(Player p){
        plugin.getConfig().set("Players." + p.getUniqueId().toString() + ".Name: " + p.getName() + ".EXP.Mining", 0);
        plugin.getConfig().set("Players." + p.getUniqueId().toString() + ".Name: " + p.getName() + ".EXP.Chat", 0);
        plugin.getConfig().set("Players." + p.getUniqueId().toString() + ".Name: " + p.getName() + ".EXP.Damage", 0);
        plugin.getConfig().set("Players." + p.getUniqueId().toString() + ".Name: " + p.getName() + ".EXP.Fishing", 0);
        plugin.getConfig().set("Players." + p.getUniqueId().toString() + ".Name: " + p.getName() + ".Level.Mining", 0);
        plugin.getConfig().set("Players." + p.getUniqueId().toString() + ".Name: " + p.getName() + ".Level.Chat", 0);
        plugin.getConfig().set("Players." + p.getUniqueId().toString() + ".Name: " + p.getName() + ".Level.Damage", 0);
        plugin.getConfig().set("Players." + p.getUniqueId().toString() + ".Name: " + p.getName() + ".Level.Fishing", 0);
    }

}
