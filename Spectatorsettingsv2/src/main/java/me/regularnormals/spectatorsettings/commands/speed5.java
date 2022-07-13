package me.regularnormals.spectatorsettings.commands;

import me.regularnormals.spectatorsettings.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class speed5 implements CommandExecutor {
        private final Main main;

    public speed5(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            Player player = (Player) sender;

            if(player.isOp() || player.hasPermission("SpectatorSettings.Admin") || player.hasPermission("SpectatorSettings.Spectator")) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 5, true));
                player.sendMessage(ChatColor.AQUA + "Your speed has been changed (Set to 5)");
            } else {
                player.sendMessage(ChatColor.DARK_RED + "Permission denied, Contact staff if you believe this is incorrect!");
            }
        }else {main.getLogger().info("you have to be a player to increase speed sorry:(, Otherwise computer go brrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
            return true;
        }



        return true;
    }
}
