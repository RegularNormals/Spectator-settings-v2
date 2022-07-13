package me.regularnormals.spectatorsettings;

import me.regularnormals.spectatorsettings.commands.Fly;
import me.regularnormals.spectatorsettings.commands.speed5;
import me.regularnormals.spectatorsettings.commands.speedDefault;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginCommand("Speed5").setExecutor(new speed5(this));
        getServer().getPluginCommand("Fly").setExecutor(new Fly(this));
        getServer().getPluginCommand("SpeedDefault").setExecutor(new speedDefault(this));
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
