package me.rega_internal.pvpisland.commands.staff;

import me.rega_internal.pvpisland.Main;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandWelcome implements CommandExecutor
{
	Main plugin;

	public CommandWelcome(Main main)
	{
		this.plugin = main;
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		if (command.getName().equalsIgnoreCase("welcome"))
		{
			if (!(sender instanceof Player))
			{
				sender.sendMessage(this.plugin.strings.consoleSender("welcome"));
				return false;
			}
			else
			{
				Player player = (Player) sender;
				if (!player.hasPermission(this.plugin.strings.permissionPrefix("command.welcome")))
				{
					this.plugin.playerMethods.message(player, this.plugin.strings.noPermission());
				}
				else
				{
					if (args.length != 1)
					{
						this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + this.plugin.strings.usage("welcome <player>"));
					}
					else
					{
						Player target = Bukkit.getPlayer(args[0]);
						this.plugin.serverMethods.broadcast("&8&l> " + player.getDisplayName() + " &7&owelcomes you &7to the server, " + target.getDisplayName() + "&7!");
					}
				}
			}
		}
		return true;
	}
}
