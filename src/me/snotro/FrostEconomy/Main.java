package me.snotro.FrostEconomy;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;

public class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    //If no place in config. Create One.
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if (!getConfig().contains(e.getPlayer().getUniqueId().toString() + ".SnoCoins")) {
            getConfig().set(e.getPlayer().getUniqueId().toString() + ".SnoCoins", 300);
            saveConfig();
        }
    }

    //Add Methods
    public void Add(Player player, String m) {
        int integer = Integer.parseInt(m);
        getConfig().set((player.getUniqueId().toString() + ".Coins"), getConfig().getInt(player.getUniqueId().toString() + ".Coins") + integer);
        saveConfig();
    }

    //Remove Method
    public void Remove(Player player, String m) {
        int integer = Integer.parseInt(m);
        getConfig().set((player.getUniqueId().toString() + ".Coins"), getConfig().getInt(player.getUniqueId().toString() + ".Coins") - integer);
        saveConfig();
    }
}




