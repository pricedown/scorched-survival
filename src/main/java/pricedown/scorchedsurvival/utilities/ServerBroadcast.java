package pricedown.scorchedsurvival.utilities;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ServerBroadcast {
    public static void serverBroadcast(ChatMessageType type, String message) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.spigot().sendMessage(type, new TextComponent(message));
        }
    }
}
