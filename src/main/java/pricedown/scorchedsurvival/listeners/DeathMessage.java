package pricedown.scorchedsurvival.listeners;

import net.md_5.bungee.api.ChatMessageType;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import pricedown.scorchedsurvival.Scorched_survival;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

import static pricedown.scorchedsurvival.utilities.ServerBroadcast.serverBroadcast;

public class DeathMessage implements Listener {

    public DeathMessage(Scorched_survival plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void deathMessage(PlayerDeathEvent event) {
        Player player = event.getEntity();
        long secondsLived = player.getStatistic(Statistic.TIME_SINCE_DEATH)/20;
        long hours = TimeUnit.SECONDS.toHours(secondsLived);
        long minutes = TimeUnit.SECONDS.toMinutes(secondsLived) - TimeUnit.HOURS.toMinutes(hours);
        long seconds = secondsLived - TimeUnit.HOURS.toSeconds(hours) - TimeUnit.MINUTES.toSeconds(minutes);

        String message = ChatColor.GOLD
                + event.getEntity().getDisplayName() + " lived for " + hours + ":" + minutes + ":" + seconds + ".";
        serverBroadcast(ChatMessageType.CHAT, message);
    }
}
