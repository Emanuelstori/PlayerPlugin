package com.runeforger;

import com.runeforger.commands.NormalCommands;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.runeforger.Player.PlayerManager;
import com.runeforger.listeners.NormalListeners;

public final class RuneForger extends JavaPlugin implements Listener {
    public PlayerManager playerManager;

    @Override
    public void onEnable() {

        // Listeners
        getServer().getPluginManager().registerEvents(new NormalListeners(), this);

        // Commands
        this.getCommand("login").setExecutor(new NormalCommands());
        this.getCommand("register").setExecutor(new NormalCommands());
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
