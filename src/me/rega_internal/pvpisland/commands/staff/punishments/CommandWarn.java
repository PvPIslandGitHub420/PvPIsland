package me.rega_internal.pvpisland.commands.staff.punishments;

import me.rega_internal.pvpisland.Main;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandWarn implements CommandExecutor
{

	Main plugin;

	public CommandWarn(Main main)
	{
		this.plugin = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String String, String[] args)
	{
		if (cmd.getName().equalsIgnoreCase("warn"))
		{
			if (!(sender instanceof Player))
			{
				sender.sendMessage(this.plugin.strings.consoleSender("warn"));
				return false;
			}
			else
			{
				Player p = (Player) sender;
				if (p.hasPermission(this.plugin.strings.permissionPrefix("command.warn")))
				{
					if (args.length < 1)
					{
						this.plugin.playerMethods.message(p, this.plugin.strings.prefix() + this.plugin.strings.usage("warn <player> <reason>"));
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
								this.plugin.playerMethods.message(p, this.plugin.strings.prefix() + "&cYou can not warn yourself!");
							}
							else
							{
								for (Player p3 : Bukkit.getOnlinePlayers())
								{
									if (p3.hasPermission("pvpisland.command.warn"))
									{
										this.plugin.playerMethods.message(p3, "&8&l[&c&l!&8&l] &6" + p.getName() + " &6warned " + p2.getName() + " &6for " + str + "&6.");
									}
								}
								p2.sendMessage(" ");
								this.plugin.playerMethods.message(p2, "&8&l[&c&l!&8&l] &6You were warned by a staff member for: &7" + str + " &8&l[&c&l!&8&l]");
								this.plugin.playerMethods.message(p2, "&8&l[&c&l!&8&l] &dPlease review the rules too avoid being banned. &8&l[&c&l!&8&l]");
								p2.sendMessage(" ");
							}
						}
					}
				}
				else
				{
					p.sendMessage(this.plugin.strings.noPermission());
				}
			}
		}
		return false;

	}
}
