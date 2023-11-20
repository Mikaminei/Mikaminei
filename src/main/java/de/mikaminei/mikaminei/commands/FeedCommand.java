package de.mikaminei.mikaminei.commands;

import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class FeedCommand implements CommandExecutor {
    
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "§e§l(!) §eOnly Players can use that command!");
            return true;
        }
        Player player = (Player) sender;
        
        // /feed
        if (cmd.getName().equalsIgnoreCase("feed")) {
            player.setFoodLevel(20);
            player.sendMessage(ChatColor.GREEN + "§e§l(!) §eSaturation is now at 20");
            return true;
        }
        return true;
    }
}
