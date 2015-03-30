package me.rega_internal.pvpisland.commands.staff;

import me.rega_internal.pvpisland.Main;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandAdmin implements CommandExecutor
{
	Main plugin;

	public CommandAdmin(Main main)
	{
		this.plugin = main;
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		if (command.getName().equalsIgnoreCase("admin"))
		{
			if (!(sender instanceof Player))
			{
				sender.sendMessage(this.plugin.strings.consoleSender("admin"));
				return false;
			}

			Player player = (Player) sender;
			if (!player.hasPermission(this.plugin.strings.permissionPrefix("command.admin")))
			{
				this.plugin.playerMethods.message(player, this.plugin.strings.noPermission());
			}
			else
			{
				if (!this.plugin.lists.adminMode.contains(player.getName()))
				{
					this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&dYou are now invisible to Trial-Moderators and below.");
					this.plugin.lists.adminMode.add(player.getName());
					this.plugin.playerMethods.clear(player);
					this.plugin.playerMethods.clearKit(player);
					player.setGameMode(GameMode.CREATIVE);
					for (Player players : Bukkit.getOnlinePlayers())
					{
						if (!this.plugin.playerMethods.isStaff(players))
						{
							players.hidePlayer(players);
						}
					}
				}
				else
				{
					this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&dYou are no longer invisible.");
					this.plugin.lists.adminMode.remove(player.getName());
					this.plugin.playerMethods.clear(player);
					this.plugin.playerMethods.clearKit(player);
					for (Player players : Bukkit.getOnlinePlayers())
					{
						players.showPlayer(player);
					}
				}
			}
		}
		return true;
	}
}
