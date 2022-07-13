package me.regularnormals.spectatorsettings.commands;

import me.regularnormals.spectatorsettings.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

public class speedDefault implements CommandExecutor {
    private final Main main;

    public speedDefault(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            Player player = (Player) sender;

            if(player.isOp() || player.hasPermission("SpectatorSettings.Admin") || player.hasPermission("SpectatorSettings.Spectator")){
                player.removePotionEffect(PotionEffectType.SPEED);
                player.sendMessage(ChatColor.AQUA + "Your speed has been changed (Set to Default)");
            } else{
                player.sendMessage(ChatColor.DARK_RED + "Permission denied, Contact staff if you believe this is incorrect!");
            }
        }else {main.getLogger().info("you have to be a player to decrease speed sorry:(, Otherwise computer go brrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
            return true;
        }



        return true;
    }
}
