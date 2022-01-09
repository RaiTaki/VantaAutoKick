package xyz.raitaki.VantaAutoKick;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class KickHandler {

    private HashMap<Player, Location> playerlocations = new HashMap<>();
    @Getter public HashMap<Player, WordHandler> wordhandlers = new HashMap<>();


    public void run(){
        new BukkitRunnable(){
            @Override
            public void run() {
                for(Player p : Bukkit.getOnlinePlayers()){
                    if(isPlayerInList(p)){
                        if(isPlayerMoved(p)){
                            WordHandler wordHandler = new WordHandler();
                            wordHandler.setP(p);
                            wordHandler.start();
                            wordhandlers.put(p, wordHandler);
                        }
                        putLocationToList(p);
                    }
                    else{
                        putLocationToList(p);
                    }
                }
            }
        }.runTaskTimer(Main.getInstance(), 20*5,20*5*60);
    }

    private boolean isPlayerMoved(Player p){
        Location ploc = this.setThingsToZero(p.getLocation());

        Location listloc = playerlocations.get(p);
        return ploc.equals(listloc);
    }

    private boolean isPlayerInList(Player p){
        return playerlocations.containsKey(p);
    }

    private void putLocationToList(Player p){
        Location loc = this.setThingsToZero(p.getLocation());

        playerlocations.put(p,loc);
    }

    private Location setThingsToZero(Location loc){
        Location locc = loc.clone();
        locc.setYaw(0);
        locc.setPitch(0);

        return locc;
    }

    public boolean isPlayerInWordList(Player p){
        return wordhandlers.containsKey(p);
    }

    public WordHandler getPlayerWordHandler(Player p){
        return wordhandlers.get(p);
    }

}
