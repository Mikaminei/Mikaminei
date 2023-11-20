package de.mikaminei.mikaminei.items;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {
    
    public static ItemStack wandOfTruth;
    public static ItemStack explosiveWand;
    
    public static void init() {
        createWandOfTruth();
        createExplosiveWand();
    }
    
    private static void createWandOfTruth() {
        ItemStack item = new ItemStack(Material.STICK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setUnbreakable(true);
        meta.setDisplayName("§6Wand of Truth");
        List<String> lore = new ArrayList<>();
        lore.add("§7Answers your question");
        lore.add("§7with yes or no.");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        item.setItemMeta(meta);
        wandOfTruth = item;
    }
    
    private static void createExplosiveWand() {
        ItemStack item = new ItemStack(Material.STICK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setUnbreakable(true);
        meta.setDisplayName("§6Explosive Wand");
        List<String> lore = new ArrayList<>();
        lore.add("§73...");
        lore.add("§72...");
        lore.add("§71...");
        lore.add("§7KABOOM!");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        item.setItemMeta(meta);
        explosiveWand = item;
    }
}
