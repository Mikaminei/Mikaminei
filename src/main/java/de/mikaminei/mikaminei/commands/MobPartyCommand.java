package de.mikaminei.mikaminei.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class MobPartyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§e§l(!) §eOnly players can use that command!");
            return true;
        }
        Player player = (Player) sender;
        
        // /mobparty cow 5
        if (cmd.getName().equalsIgnoreCase("mobparty")) {
            if (args.length >= 2) {
                try {
                    EntityType entity = EntityType.valueOf(args[0].toUpperCase());
                    int amount = Integer.parseInt(args[1]);
                    for (int i = 0; i < amount; i++) {
                        player.getWorld().spawnEntity(player.getLocation(), entity);
                    }
                } catch (IllegalArgumentException e) {
                    player.sendMessage("§c§l(!) §cThat is not a valid entity!");
                }
            } else {
                player.sendMessage("§c§l(!) §c/mobparty <mob> <amount>");
            }
            return true;
        }
        return true;
    }
}
