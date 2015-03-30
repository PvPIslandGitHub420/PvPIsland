package me.rega_internal.pvpisland.commands;

import me.rega_internal.pvpisland.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSeeKit implements CommandExecutor
{
	Main plugin;

	public CommandSeeKit(Main main)
	{
		this.plugin = main;
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		if (command.getName().equalsIgnoreCase("seekit"))
		{
			if (!(sender instanceof Player))
			{
				sender.sendMessage(this.plugin.strings.consoleSender("seekit"));
				return false;
			}
			else
			{
				Player player = (Player) sender;
				if (args.length != 1)
				{
					this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + this.plugin.strings.usage("seekit <player>"));
				}
				else
				{
					if (args.length == 1)
					{

						Player p2 = Bukkit.getPlayer(args[0]);
						if (p2 == null)
						{
							this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + ChatColor.RED + "Player not found.");
						}
						if (!this.plugin.lists.kit.containsKey(p2.getName()))
						{
							this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + ChatColor.RED + "That player does not have a kit selected");
						}
						else
						{
							this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + ChatColor.GOLD + p2.getName() + "'s Kit: " + (this.plugin.lists.kit.get(p2.getName())));
						}
					}
				}
			}

		}

		return true;
	}

}
