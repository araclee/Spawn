package ru.quaberon.mudules.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.quaberon.Core;

public class Spawn implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {

            sender.sendMessage(ChatColor.YELLOW + "INFO: " + ChatColor.WHITE + "Spawn: " + ChatColor.GRAY + "команду может использовать только игрок.");

            return true;
        }

        Player player = (Player) sender;

        if (args.length != 1) {

            Location location = (Location) Core.getInstance().settingsConfiguration.get("spawn-location");

            player.teleport(location);

            player.sendActionBar(ChatColor.YELLOW + "INFO: " + ChatColor.WHITE + "Spawn: " + ChatColor.GRAY + "Вы были телепортированы на спавн");

            return true;
        }

        return false;
    }
}
