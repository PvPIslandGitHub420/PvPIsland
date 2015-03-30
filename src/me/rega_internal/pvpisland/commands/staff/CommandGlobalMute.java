package me.rega_internal.pvpisland.commands.staff;

import me.rega_internal.pvpisland.Main;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandGlobalMute implements CommandExecutor
{
	Main plugin;

	public CommandGlobalMute(Main main)
	{
		this.plugin = main;
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		if (command.getName().equalsIgnoreCase("globalmute"))
		{
			if (!(sender instanceof Player))
			{
				if (!this.plugin.booleans.chatMuted)
				{
					this.plugin.booleans.chatMuted = true;
					Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&bThe global chat has been &b&omuted &bby " + "Console" + "&b."));
				}
				else
				{
					this.plugin.booleans.chatMuted = false;
					Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&bThe global chat has been &b&oun-muted &bby " + "Console" + "&b."));
				}
				return true;
			}
			else
			{
				Player player = (Player) sender;
				if (!player.hasPermission(this.plugin.strings.permissionPrefix("command.globalmute")))
				{
					this.plugin.playerMethods.message(player, this.plugin.strings.noPermission());
				}
				else
				{
					if (!this.plugin.booleans.chatMuted)
					{
						this.plugin.booleans.chatMuted = true;
						Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&bThe global chat has been &b&omuted &bby " + player.getName() + "&b."));
					}
					else
					{
						this.plugin.booleans.chatMuted = false;
						Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&bThe global chat has been &b&oun-muted &bby " + player.getName() + "&b."));
					}
				}
			}
		}
		return true;
	}
}
