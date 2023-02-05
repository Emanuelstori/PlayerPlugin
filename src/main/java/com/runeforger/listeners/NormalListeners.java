package com.runeforger.listeners;

import com.runeforger.api.AdventurerApi;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.runeforger.Utils.Playerfile;

public class NormalListeners implements Listener {
  @EventHandler
  public void PlayerJoin(PlayerJoinEvent e) {
    Player player = e.getPlayer();
    new Playerfile().createFolder(player.getUniqueId().toString());

    player.sendMessage("Bem vindo");



  }
}
