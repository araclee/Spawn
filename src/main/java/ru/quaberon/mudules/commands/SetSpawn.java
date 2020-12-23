package ru.quaberon.mudules.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.quaberon.Core;

import java.io.IOException;

public class SetSpawn implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {

            sender.sendMessage(ChatColor.YELLOW + "INFO: " + ChatColor.WHITE + "Spawn: " + ChatColor.GRAY + "команду может использовать только игрок.");

            return true;
        }

        Player player = (Player) sender;

        if (args.length != 1) {

            Location location = player.getLocation();

            try {

                Core.getInstance().settingsConfiguration.set("spawn-location", location);

                Core.getInstance().settingsConfiguration.save(Core.getInstance().settings);

            } catch (IOException e) {

                e.printStackTrace();

            }

            player.sendMessage(ChatColor.YELLOW + "INFO: " + ChatColor.WHITE + "Spawn: " + ChatColor.GRAY + "локация сохранена.");

            return true;
        }

        return false;
    }
}
