package me.phelix.project;

import me.phelix.project.cmds.GetStats;
import me.phelix.project.cmds.ReloadConfig;
import me.phelix.project.cmds.AddLvlExp;
import me.phelix.project.cmds.ResetStats;
import me.phelix.project.events.Join;
import me.phelix.project.events.LevelChange;
import me.phelix.project.utils.LevelData;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private LevelData levelData;
    public void onEnable(){

        levelData = new LevelData(this);
        getConfig().options().copyDefaults(true);
        saveConfig();

        registerCommands();
        registerEvents();

    }

    public void onDisable(){
        saveConfig();
    }

    private void registerCommands(){
        getCommand("reloadconfig").setExecutor(new ReloadConfig(this));
        getCommand("stats").setExecutor(new GetStats(levelData, this));
        getCommand("exp").setExecutor(new AddLvlExp(levelData, this));
        getCommand("level").setExecutor(new AddLvlExp(levelData, this));
        getCommand("resetstats").setExecutor(new ResetStats(this, levelData));

    }

    private void registerEvents(){
        Bukkit.getServer().getPluginManager().registerEvents(new Join(this, levelData), this);
        Bukkit.getServer().getPluginManager().registerEvents(new LevelChange(levelData, this), this);
    }
}
