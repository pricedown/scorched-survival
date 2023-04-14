package pricedown.scorchedsurvival.items;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

import static pricedown.scorchedsurvival.utilities.ItemCreator.tool;

public class Kits {
    public static List<ItemStack> wildernessKit;

    public static void setKits() {
        setWildernessKit();
    }

    private static void setWildernessKit() {
        wildernessKit = new ArrayList<>();
        wildernessKit.add(tool((String) null, Material.WOODEN_AXE, 5, Enchantment.VANISHING_CURSE, 1,1,false));
        wildernessKit.add(tool((String) null, Material.WOODEN_PICKAXE, 3, Enchantment.VANISHING_CURSE, 1,1,false));
        wildernessKit.add(tool((String) null, Material.DIAMOND_SHOVEL, 0, Enchantment.VANISHING_CURSE, 1,1,false));
        wildernessKit.add(tool((String) null, Material.SALMON, 0, null, 0,32,false));
        wildernessKit.add(tool((String) null, Material.TORCH, 0, Enchantment.VANISHING_CURSE, 0,16,false));
        wildernessKit.add(tool((String) null, Material.SADDLE, 0, null, 0,1,false));
        wildernessKit.add(tool((String) null, Material.ENDER_PEARL, 0, null, 0,1,false));
    }
}
