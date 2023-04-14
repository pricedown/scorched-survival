package pricedown.scorchedsurvival.utilities;

import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.*;
import org.bukkit.potion.PotionEffect;

import java.util.List;

public class ItemCreator {

    public enum PotionTypes {DRINK,SPLASH,LINGERING}

    public static ItemStack tool(String name, Material material, int durability, Enchantment enchantment, int level, int count, boolean hideEnchants) {
        ItemStack item = new ItemStack(material, count);
        Damageable dmg = (Damageable) item.getItemMeta();
        assert dmg != null;

        if (name != null)
            dmg.setDisplayName(name);
        if (durability > 0)
            dmg.setDamage(item.getType().getMaxDurability()-durability);
        if (enchantment != null)
            dmg.addEnchant(enchantment,level, true);
        if (hideEnchants)
            dmg.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        item.setItemMeta(dmg);
        return item;
    }

    public static ItemStack potion(String name, PotionTypes type, List<PotionEffect> effects, Color color) {
        ItemStack item = new ItemStack(Material.POTION);
        switch (type) {
            case DRINK:
                item = new ItemStack(Material.POTION);
                break;
            case SPLASH:
                item = new ItemStack(Material.SPLASH_POTION);
                break;
            case LINGERING:
                item = new ItemStack(Material.LINGERING_POTION);
                break;
        }
        PotionMeta meta = (PotionMeta) item.getItemMeta();
        assert meta != null;
        for (PotionEffect effect : effects) {
            meta.addCustomEffect(effect, false);
        }
        meta.setColor(color);

        if (name != null)
            meta.setDisplayName(name);

        item.setItemMeta(meta);
        return item;
    }
}
