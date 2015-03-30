package me.rega_internal.pvpisland.commands.staff;

import me.rega_internal.pvpisland.Main;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandBuild implements CommandExecutor
{
	Main plugin;

	public CommandBuild(Main main)
	{
		this.plugin = main;
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		if (command.getName().equalsIgnoreCase("build"))
		{
			if (!(sender instanceof Player))
			{
				sender.sendMessage(this.plugin.strings.consoleSender("build"));
				return false;
			}

			Player player = (Player) sender;
			if (!player.hasPermission(this.plugin.strings.permissionPrefix("command.build")))
			{
				this.plugin.playerMethods.message(player, this.plugin.strings.noPermission());
			}
			else
			{
				if (args.length != 1)
				{
					if (!this.plugin.lists.buildMode.contains(player.getName()))
					{
						this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&dYou are now able to build.");
						this.plugin.lists.buildMode.add(player.getName());
						this.plugin.playerMethods.clear(player);
						this.plugin.playerMethods.clearKit(player);
						player.setGameMode(GameMode.CREATIVE);
					}
					else
					{
						this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&dYou may no longer build.");
						this.plugin.lists.buildMode.remove(player.getName());
						this.plugin.playerMethods.clear(player);
						this.plugin.playerMethods.clearKit(player);
					}
				}
				else
				{
					Player target = Bukkit.getPlayer(args[0]);
					if (target == null)
					{
						this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&dPlayer not found.");
					}
					else
					{
						if (player.hasPermission(this.plugin.strings.permissionPrefix("command.build.others")))
						{
							if (!this.plugin.lists.buildMode.contains(target.getName()))
							{
								this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&d" + target.getName() + " is now able to build.");
								this.plugin.playerMethods.message(target, this.plugin.strings.prefix() + "&dYou are now able to build.");
								this.plugin.lists.buildMode.add(target.getName());
								this.plugin.playerMethods.clear(target);
								this.plugin.playerMethods.clearKit(target);
								player.setGameMode(GameMode.CREATIVE);
							}
							else
							{
								this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&d" + target.getName() + " may no longer build.");
								this.plugin.playerMethods.message(target, this.plugin.strings.prefix() + "&dYou may no longer build.");
								this.plugin.lists.buildMode.remove(target.getName());
								this.plugin.playerMethods.clear(target);
								this.plugin.playerMethods.clearKit(target);
							}
						}
						else
						{
							this.plugin.playerMethods.message(player, this.plugin.strings.noPermission());
						}
					}
				}
			}
		}
		return true;
	}
}
