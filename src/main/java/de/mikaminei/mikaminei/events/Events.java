package de.mikaminei.mikaminei.events;

import de.mikaminei.mikaminei.items.ItemManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.Random;

public class Events implements Listener {
    
    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.sendMessage("§d§l(!) §dWelcome to the server :)");
    }
    
    @EventHandler
    public static void onPlayerWalk(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        int x = player.getLocation().getBlockX();
        int y = player.getLocation().getBlockY();
        int z = player.getLocation().getBlockZ();
        
        Material block = player.getWorld().getBlockAt(x, y - 1, z).getType();
        if (block == Material.CRAFTING_TABLE) {
            player.sendMessage("§e§l(!) §eYou are standing on a Crafting Table!");
        }
    }
    
    @EventHandler
    public static void onRightClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (event.getItem() != null) {
                if (event.getItem().getItemMeta().equals(ItemManager.wandOfTruth.getItemMeta())) {
                    Random random = new Random();
                    if (random.nextBoolean()) {
                        player.sendActionBar("§a§lYES");
                    } else {
                        player.sendActionBar("§c§lNO");
                    }
                } else if (event.getItem().getItemMeta().equals(ItemManager.explosiveWand.getItemMeta()) && event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                    player.getWorld().createExplosion(event.getInteractionPoint(), 2.0f);
                    player.sendMessage("§c§l(!) §c3... 2... 1... KABOOM!");
                }
            }
        }
    }
}
