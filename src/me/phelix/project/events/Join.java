package me.phelix.project.events;

import me.phelix.project.utils.LevelData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

public class Join implements Listener {

    private Plugin plugin;
    private LevelData levelData;
    public Join(Plugin main, LevelData levelData1) { this.plugin = main; this.levelData = levelData1; }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if(!plugin.getConfig().contains("Players." + p.getUniqueId().toString() + p.getName())){
            levelData.resetStats(p);
            plugin.saveConfig();
        }
    }
}
