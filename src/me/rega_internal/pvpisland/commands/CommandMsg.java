package me.rega_internal.pvpisland.commands;

import me.rega_internal.pvpisland.Main;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandMsg implements CommandExecutor
{
	Main plugin;

	public CommandMsg(Main main)
	{
		this.plugin = main;
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		if (command.getName().equalsIgnoreCase("msg"))
		{
			if (!(sender instanceof Player))
			{
				if (args.length == 0)
				{
					sender.sendMessage(this.plugin.strings.prefix() + this.plugin.strings.usage("msg <player> <message>"));
				}
				else
				{
					Player target = Bukkit.getPlayer(args[0]);
					String message = StringUtils.join(args, ' ', 1, args.length);

					this.plugin.playerMethods.message(target, "&7<Console -> " + target.getName() + "> " + message);
					sender.sendMessage("<Console -> " + target.getName() + "> " + message);
				}
				return true;
			}
			else
			{
				Player player = (Player) sender;
				if (args.length == 0)
				{
					this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + this.plugin.strings.usage("msg <player> <message>"));
				}
				else
				{
					Player target = Bukkit.getPlayer(args[0]);

					if (args.length == 1)
					{
						this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&cPlease define a message.");
					}
					else
					{
						String message = StringUtils.join(args, ' ', 1, args.length);
						this.plugin.playerMethods.message(target, "&7<" + player.getName() + " -> " + target.getName() + "> " + message);
						this.plugin.playerMethods.message(player, "&7<" + player.getName() + " -> " + target.getName() + "> " + message);
						this.plugin.lists.lastMessaged.put(player.getName(), target.getName());
						this.plugin.lists.lastMessaged.put(target.getName(), player.getName());
					}
				}
			}
		}
		else if (command.getName().equalsIgnoreCase("r"))
		{
			if (!(sender instanceof Player))
			{
				sender.sendMessage(this.plugin.strings.consoleSender("r"));
				return false;
			}
			else
			{
				Player player = (Player) sender;
				if (args.length == 0)
				{
					this.plugin.playerMethods.message(player, "&cUsage: /r <message>");
				}
				else
				{
					Player target = Bukkit.getPlayer(this.plugin.lists.lastMessaged.get(player.getName()));

					String message = StringUtils.join(args, ' ', 0, args.length);
					this.plugin.playerMethods.message(target, "&7<" + player.getName() + " -> " + target.getName() + "> " + message);
					this.plugin.playerMethods.message(player, "&7<" + player.getName() + " -> " + target.getName() + "> " + message);
				}
			}
		}
		return true;
	}
}
