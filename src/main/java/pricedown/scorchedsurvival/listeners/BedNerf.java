package pricedown.scorchedsurvival.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import pricedown.scorchedsurvival.Scorched_survival;

import static org.bukkit.event.player.PlayerBedEnterEvent.BedEnterResult.OK;
import static pricedown.scorchedsurvival.tasks.NotifyTimeOfDay.isDay;

public class BedNerf implements Listener {

    public BedNerf(Scorched_survival plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void onBedEnter(PlayerBedEnterEvent event) {
        Player player = event.getPlayer();
        if (event.getBedEnterResult() == OK) {
            player.setHealthScale(0.1);
            player.setHealthScaled(true);
            player.setHealth(1.0);
        }
    }

    @EventHandler
    public void onBedLeave(PlayerBedLeaveEvent event) {
        Player player = event.getPlayer();
        player.setHealthScale(1);
        player.setHealthScaled(false);
        if (isDay()) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 200, 0));
        }
    }
}
