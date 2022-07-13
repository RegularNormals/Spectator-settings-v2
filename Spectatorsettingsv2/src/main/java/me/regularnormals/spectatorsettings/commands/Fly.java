package me.regularnormals.spectatorsettings.commands;

import me.regularnormals.spectatorsettings.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Fly implements CommandExecutor {

    private final Main main;

    public Fly(Main main) {
        this.main = main;
    }

    private ArrayList<Player> list_of_flying_players = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.isOp() || player.hasPermission("SpectatorSettings.Admin") || player.hasPermission("SpectatorSettings.Spectator")) {
                flyMethod(player);
            }else
                player.sendMessage(ChatColor.DARK_RED + "Permission denied, Contact staff if you believe this is incorrect!");
            return true;
        }         main.getLogger().info("You must be a player to fly, sorry you will fly one day :(");
        return true;
    }

    private void flyMethod(Player player) {
        if (list_of_flying_players.contains(player)) {
            list_of_flying_players.remove(player);
            player.setAllowFlight(false);
            player.sendMessage(ChatColor.AQUA + "Flight Has been disabled");
        } else if (!list_of_flying_players.contains(player)) {
            list_of_flying_players.add(player);
            player.setAllowFlight(true);
            player.sendMessage(ChatColor.AQUA + "You may Now Fly :)");
        }

    }
}


