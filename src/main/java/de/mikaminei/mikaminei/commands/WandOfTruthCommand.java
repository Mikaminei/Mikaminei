package de.mikaminei.mikaminei.commands;

import de.mikaminei.mikaminei.items.ItemManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class WandOfTruthCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§e§l(!) §eOnly players can use that command!");
            return true;
        }
        Player player = (Player) sender;
        
        // /wand
        if (cmd.getName().equalsIgnoreCase("wandoftruth")) {
            player.getInventory().addItem(ItemManager.wandOfTruth);
        }
        return true;
    }
}
