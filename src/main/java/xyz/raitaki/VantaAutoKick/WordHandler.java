package xyz.raitaki.VantaAutoKick;

import lombok.Setter;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

public class WordHandler {

    private String pword  = "";
    private String word   = "";
    @Setter private Player p;

    public void start(){
        Random rn = new Random();
        int range = 999999 - 500000 + 1;
        int randomNum =  rn.nextInt(range) + 500000;
        word = String.valueOf(randomNum);
        p.sendMessage(ChatColor.GREEN + word + ChatColor.GRAY + " Sayısını doğru girmemeniz durumunda sunucudan atılacaksınız!");

        new BukkitRunnable(){
            @Override
            public void run() {
                if(!word.equalsIgnoreCase(pword)) p.kickPlayer("Sayıyı doğru sürede girmediğiniz için sunucudan atıldınız.");
            }
        }.runTaskLater(Main.getInstance(), 20*30);
    }

    public void setPword(String string){
        pword = string;
        if(pword.equalsIgnoreCase(word)){
            p.sendMessage(ChatColor.GRAY + "Sayıyı doğru şekilde girdiniz, atılma durumu iptal edildi.");
            Main.getKickHandler().getWordhandlers().remove(p);
        }else{
            p.sendMessage(ChatColor.RED + "Sayıyı yanlış girdiniz!");
        }
    }

}
