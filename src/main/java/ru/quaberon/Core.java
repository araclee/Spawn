package ru.quaberon;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import ru.quaberon.mudules.commands.SetSpawn;
import ru.quaberon.mudules.commands.Spawn;

import java.io.File;
import java.io.IOException;

public final class Core extends JavaPlugin {

    private static Core plugin;

    public static Core getInstance() {return plugin;}

    public File settings = new File(getDataFolder()+File.separator+"settings.yml");

    public FileConfiguration settingsConfiguration = YamlConfiguration.loadConfiguration(settings);

    @Override
    public void onEnable() {

        plugin = this;

        getCommand("setspawn").setExecutor(new SetSpawn());

        getCommand("spawn").setExecutor(new Spawn());

        Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "INFO: " + ChatColor.WHITE + "Spawn: " + ChatColor.GREEN + "enabled.");

        if (!this.settings.exists()) {

            try {

                settingsConfiguration.save(settings);

            } catch (IOException e) {

                e.printStackTrace();

            }

        }

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
