package pricedown.scorchedsurvival;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
import pricedown.scorchedsurvival.listeners.BedNerf;
import pricedown.scorchedsurvival.listeners.FirstJoin;
import pricedown.scorchedsurvival.tasks.NotifyTimeOfDay;

public final class Scorched_survival extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().info("[Scorched] Plugin loaded.");

        // Listeners
        new FirstJoin(this);
        new BedNerf(this);

        // Events
        BukkitTask notifyTimeOfDay = new NotifyTimeOfDay().runTaskTimer(this, 10, 10);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("[Scorched] Plugin unloaded.");
    }
}
