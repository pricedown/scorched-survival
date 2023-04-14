package pricedown.scorchedsurvival.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import pricedown.scorchedsurvival.Scorched_survival;
import pricedown.scorchedsurvival.items.Kits;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Spawning implements Listener {

    public static int SPAWN_RADIUS = 6500;
    private Scorched_survival mainClass;
    private static World world = Objects.requireNonNull(Bukkit.getWorld("world"));

    public Spawning(Scorched_survival plugin) {
        mainClass = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void wildernessSpawn(PlayerRespawnEvent event) {
        Location location = getSafeLocation();
        world.getChunkAt(location).load();
        event.setRespawnLocation(getSafeLocation());
        Bukkit.getScheduler().runTaskLater(mainClass, task -> { wildernessBonus(event.getPlayer());}, 1L);
    }

    public void wildernessBonus(Player player) {
        // Blindness, Invisibility   2 sec
        // Haste, Resistance        30 sec
        player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS,40, 1));
        player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY,40, 1));
        player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING,600, 1));
        player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,600, 1));

        for (ItemStack itemStack : Kits.wildernessKit) {
            player.getInventory().addItem(itemStack);
        }
    }

    private static int getRandom(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
    public static Location getSafeLocation() {
        List<Material> unsafeBlocks = new ArrayList<Material>();
        unsafeBlocks.add(Material.WATER);
        unsafeBlocks.add(Material.LAVA);
        unsafeBlocks.add(Material.COBWEB);
        unsafeBlocks.add(Material.POWDER_SNOW);

        int locX, locY, locZ;

        boolean ok;
        do {
            locX = getRandom(-SPAWN_RADIUS, SPAWN_RADIUS);
            locZ = getRandom(-SPAWN_RADIUS, SPAWN_RADIUS);
            locY = world.getHighestBlockYAt(locX, locZ);

            ok = true;
            for (Material block : unsafeBlocks) {
                if (world.getBlockAt(new Location(Bukkit.getWorld("world"), locX, locY - 1, locZ)).getType().equals(block))
                    ok = false;
            }
        } while (!ok);

        return new Location(Bukkit.getWorld("world"), locX, locY, locZ);
    }
}
