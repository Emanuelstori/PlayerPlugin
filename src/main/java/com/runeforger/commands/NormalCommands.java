package com.runeforger.commands;

import com.runeforger.Utils.CryptographUtil;
import com.runeforger.Utils.Playerfile;
import com.runeforger.api.AdventurerApi;
import com.runeforger.models.Adventurer;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class NormalCommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            if (command.getName().equalsIgnoreCase("login")) {
                System.out.println("Login Command");
                if (args.length == 1) {
                    System.out.println("Login Command");
                    System.out.println(player.getUniqueId().toString());
                    System.out.println(args[0]);

                    Adventurer adventurer = AdventurerApi.loginAdventurer(player.getName(), args[0]);

                    adventurer.getUuid();

                    boolean resultCheck = false;

                    if(adventurer.getNick() != null){
                        System.out.println("Diferente de null");
                        resultCheck = true;
                    }

                    if (resultCheck) {
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
                System.out.println("Register Command");
                if (args.length == 2) {
                    if(args[0].toString().equals(args[1].toString())){
                        System.out.println(args[0]);

                        Adventurer adventurer = AdventurerApi.registerAdventurer(player.getUniqueId().toString(),player.getName(), args[0], player.getDisplayName(), "Player");

                        adventurer.getUuid();

                        boolean resultCheck = false;

                        if(adventurer.getNick() != null){
                            System.out.println("Diferente de null");
                            resultCheck = true;
                        }

                        if (resultCheck) {
                            String path = new Playerfile().createFolder(player.getUniqueId().toString());
                            System.out.println("criando Json");
                            new Playerfile().createJsonAdventurer(adventurer, path);
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&lLogado com sucesso."));
                        } else
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4&lSenha incorreta."));
                    }

                } else
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                            "&4&lPara logar utilize o comando /login <senha>."));

            }
        }
        return true;
    }
}
