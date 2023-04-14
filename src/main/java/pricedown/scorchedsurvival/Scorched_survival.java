package pricedown.scorchedsurvival;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import pricedown.scorchedsurvival.listeners.FirstJoin;

public final class Scorched_survival extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().info("[Scorched] Plugin loaded.");

        new FirstJoin(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("[Scorched] Plugin unloaded.");
    }
}
