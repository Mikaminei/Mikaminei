package de.mikaminei.mikaminei;

import de.mikaminei.mikaminei.commands.*;
import de.mikaminei.mikaminei.events.Events;
import de.mikaminei.mikaminei.items.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Mikaminei extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new Events(), this);
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("feed").setExecutor(new FeedCommand());
        getCommand("mobparty").setExecutor(new MobPartyCommand());
        getCommand("wandoftruth").setExecutor(new WandOfTruthCommand());
        getCommand("explosivewand").setExecutor(new ExplosiveWandCommand());
        ItemManager.init();
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[MIKAMINEI]: Plugin is enabled!");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[MIKAMINEI]: Plugin is disabled!");
    }
}
