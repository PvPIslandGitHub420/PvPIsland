package me.rega_internal.pvpisland.commands.staff.punishments;

import java.util.Date;

import me.rega_internal.pvpisland.Main;
import net.md_5.bungee.api.ChatColor;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandBan implements CommandExecutor
{
	Main plugin;

	public CommandBan(Main main)
	{
		this.plugin = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String String, String[] args)
	{
		if (cmd.getName().equalsIgnoreCase("ban"))
		{
			if (!(sender instanceof Player))
			{
				sender.sendMessage(this.plugin.strings.consoleSender("ban"));
				return false;
			}
			else
			{
				Player p = (Player) sender;
				if (p.hasPermission(this.plugin.strings.permissionPrefix("command.ban")))
				{
					if (args.length < 1)
					{
						this.plugin.playerMethods.message(p, this.plugin.strings.prefix() + this.plugin.strings.usage("ban <player> <reason>"));
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
								this.plugin.playerMethods.message(p, this.plugin.strings.prefix() + "&cYou can not ban yourself!");
							}
							else
							{
								this.plugin.serverMethods.broadcast("&8&l[&c&l!&8&l] &6" + p.getName() + " &6banned " + p2.getName() + " &6for " + str + "&6.");
								p2.kickPlayer(ChatColor.translateAlternateColorCodes('&', "&8&l[&b&lPvPIsland&7&l.&b&lcom&8&l]&r\n\n&7You have been &c&lbanned &7for: \"&6" + str + "&7\"\n&7Banned by: &6" + p.getName() + "\n&7Time of Kick: &6" + new Date().toString()));
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
