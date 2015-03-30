package me.rega_internal.pvpisland.commands;

import me.rega_internal.pvpisland.Main;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandReport implements CommandExecutor
{
	Main plugin;

	public CommandReport(Main main)
	{
		this.plugin = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String String, String[] args)
	{
		if (cmd.getName().equalsIgnoreCase("report"))
		{
			if (!(sender instanceof Player))
			{
				sender.sendMessage(this.plugin.strings.consoleSender("report"));
				return false;
			}
			else
			{
				Player p = (Player) sender;
				if (args.length < 1)
				{
					this.plugin.playerMethods.message(p, this.plugin.strings.prefix() + this.plugin.strings.usage("report <player> <reason>"));
				}
				else if (args.length == 1)
				{
					this.plugin.playerMethods.message(p, this.plugin.strings.prefix() + "&cPlease include a message.");
				}
				else if (args.length > 1)
				{
					Player p2 = Bukkit.getPlayer(args[0]);
					if (p2 == null)
					{
						this.plugin.playerMethods.message(p, this.plugin.strings.prefix() + "&cPlayer not found.");
					}
					else
					{
						String str = StringUtils.join(args, ' ', 1, args.length);
						if (p2.getName().equalsIgnoreCase(p.getName()))
						{
							this.plugin.playerMethods.message(p, this.plugin.strings.prefix() + "&cYou can not report yourself!");
						}
						else
						{
							for (Player p3 : Bukkit.getOnlinePlayers())
							{
								if (this.plugin.playerMethods.isStaff(p3))
								{
									this.plugin.playerMethods.message(p3, "&8&l[&c&l!&8&l] &6" + p.getName() + " &6made a report against &6" + p2.getName() + " &6for " + str + "&6.");
								}
							}
						}
					}
				}
			}
		}
		return false;
	}
}
