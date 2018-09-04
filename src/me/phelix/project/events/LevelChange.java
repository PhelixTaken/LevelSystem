package me.phelix.project.events;

import me.phelix.project.utils.LevelData;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.plugin.Plugin;

public class LevelChange  implements Listener {

    private LevelData levelData;
    private Plugin plugin;
    public LevelChange(LevelData lvlData, Plugin main) { this.levelData = lvlData; this.plugin = main; }

    @EventHandler
    public void onMine(BlockBreakEvent e){
        Player p = e.getPlayer();
        levelData.setMineChange(p);
        int xp = levelData.getMineExp(p);
        int add = levelData.setExp(p);

         if(!(p.getItemInHand().getType() == Material.DIAMOND_SWORD || p.getItemInHand().getType() == Material.GOLD_SWORD
                || p.getItemInHand().getType() == Material.IRON_SWORD || p.getItemInHand().getType()
                == Material.STONE_SWORD || p.getItemInHand().getType() == Material.WOOD_SWORD))
             {
                 if(!(e.getBlock().getType() == Material.LONG_GRASS || e.getBlock().getType() == Material.DOUBLE_PLANT)){
                     plugin.getConfig().set("Players." + p.getUniqueId().toString() + ".Name: " + p.getName() + ".EXP.Mining", xp + add);
                     plugin.saveConfig();
                     p.sendMessage(add + "");
                 }
             }
         }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){
        Player p = e.getPlayer();
        levelData.setChatChange(p);
        int xp = levelData.getChatExp(p);
        int add = levelData.setExp(p);
        plugin.getConfig().set("Players." + p.getUniqueId().toString() + ".Name: " + p.getName() + ".EXP.Chat", xp + add);
        plugin.saveConfig();
        p.sendMessage(add + "");
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e){
        if(e.getDamager() instanceof Player){
            Player p = (Player) e.getDamager();
            levelData.setDamageChange(p);
            int xp = levelData.getDamageExp(p);
            int add = levelData.setExp(p);
            plugin.getConfig().set("Players." + p.getUniqueId().toString() + ".Name: " + p.getName() + ".EXP.Damage", xp + add);
            p.sendMessage(add + "");
            plugin.saveConfig();
        }
    }

    @EventHandler
    public void onFish(PlayerFishEvent e){
        Player p = e.getPlayer();
        levelData.setFishingChange(p);
        int xp = levelData.getMineExp(p);
        int add = levelData.setExp(p);
        if(e.getState() == PlayerFishEvent.State.CAUGHT_FISH) {
            plugin.getConfig().set("Players." + p.getUniqueId().toString() + ".Name: " + p.getName() + ".EXP.Mining", xp + add);
            plugin.saveConfig();
            p.sendMessage(add + "");
        }
    }
}
