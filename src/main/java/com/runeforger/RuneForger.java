package com.runeforger;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.runeforger.Player.PlayerManager;
import com.runeforger.listeners.NormalListeners;

public final class RuneForger extends JavaPlugin implements Listener {
    private static RuneForger instance;

    public RuneForger main;
    public PlayerManager playerManager;

    public static RuneForger getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {

        // Listeners
        getServer().getPluginManager().registerEvents(new NormalListeners(), this);

        // Manager
        playerManager = new PlayerManager();
        
        if (!this.getDataFolder().exists()) {
            try {
                this.getDataFolder().mkdir();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
