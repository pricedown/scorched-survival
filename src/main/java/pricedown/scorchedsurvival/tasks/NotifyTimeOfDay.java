package pricedown.scorchedsurvival.tasks;

import net.md_5.bungee.api.ChatMessageType;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Objects;

import static pricedown.scorchedsurvival.utilities.ServerBroadcast.serverBroadcast;

public class NotifyTimeOfDay extends BukkitRunnable {
    private boolean wasDay = isDay();
    @Override
    public void run() {
        boolean isDay = isDay();
        if (wasDay != isDay) {
            if (isDay) {
                serverBroadcast(ChatMessageType.ACTION_BAR, "§7It turns day.");
            }
            else {
                serverBroadcast(ChatMessageType.ACTION_BAR, "§8It turns night.");
            }

            wasDay = isDay;
        }
    }
    public static boolean isDay() {
        long time = Objects.requireNonNull(Bukkit.getWorld("world")).getTime();
        return  (time >= 23459 || time < 12542);
    }
}
