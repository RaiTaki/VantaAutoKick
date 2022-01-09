package xyz.raitaki.VantaAutoKick;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Getter private static Main instance;
    @Getter private static KickHandler kickHandler;

    @Override
    public void onEnable() {
        instance = this;
        kickHandler = new KickHandler();
        kickHandler.run();
        Bukkit.getPluginManager().registerEvents(new Events(), this);
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
