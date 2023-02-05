package com.runeforger.commands;

import com.runeforger.Utils.CryptographUtil;
import com.runeforger.api.AdventurerApi;
import com.runeforger.models.Adventurer;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NormalCommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            if (command.getName().equalsIgnoreCase("login")) {
                System.out.println("Login Command");
                if (args.length == 1) {
                    System.out.println("Login Command");
                    Adventurer adventurer = AdventurerApi.getAdventurer(player.getUniqueId().toString());

                    System.out.println(adventurer.getPassword());
                    boolean ok = true;

                    if (ok) {
                        //AdventurerCacheService.getInstance().addSession(player.getUniqueId().toString());
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&lLogado com sucesso."));
                    } else
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4&lSenha incorreta."));
                } else
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                            "&4&lPara logar utilize o comando /login <senha>."));

            }
            // Verifica se o comando é "login"
            if (command.getName().equalsIgnoreCase("register")) {
                // Implementação do comando login
            }
        }
        return true;
    }
}
