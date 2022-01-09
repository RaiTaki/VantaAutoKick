package xyz.raitaki.VantaAutoKick;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Events implements Listener {

    @EventHandler
    public void chatEvent(AsyncPlayerChatEvent event){
        if(Main.getKickHandler().isPlayerInWordList(event.getPlayer())){
            Main.getKickHandler().getPlayerWordHandler(event.getPlayer()).setPword(event.getMessage());
            event.setCancelled(true);
        }
    }
}
