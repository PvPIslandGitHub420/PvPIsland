package me.rega_internal.pvpisland.commands.staff;

import me.rega_internal.pvpisland.Main;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandClearChat implements CommandExecutor
{
	Main plugin;

	public CommandClearChat(Main main)
	{
		this.plugin = main;
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		if (command.getName().equalsIgnoreCase("clearchat"))
		{
			if (!(sender instanceof Player))
			{
				for (int i = 0; i < 201; i++)
					Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.strings.prefix() + "&7The chat has been cleared by &4Console&7."));
				return true;
			}

			Player player = (Player) sender;
			if (!player.hasPermission(this.plugin.strings.permissionPrefix("command.clearchat")))
			{
				this.plugin.playerMethods.message(player, this.plugin.strings.noPermission());
			}
			else
			{
				for (int i = 0; i < 201; i++)
					Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.strings.prefix() + "&7The chat has been cleared by " + player.getDisplayName() + "&7."));
			}
		}
		return true;
	}

}
