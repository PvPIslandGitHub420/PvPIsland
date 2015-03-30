package me.rega_internal.pvpisland.commands;

import me.rega_internal.pvpisland.Main;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class CommandPvPIsland implements CommandExecutor
{
	Main plugin;

	public CommandPvPIsland(Main main)
	{
		this.plugin = main;
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		if (command.getName().equalsIgnoreCase("pvpisland"))
		{
			if (!(sender instanceof Player))
			{
				sender.sendMessage(this.plugin.strings.consoleSender("pvpisland"));
				return false;
			}
			else
			{
				Player player = (Player) sender;
				if (args.length != 1)
				{
					this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + this.plugin.strings.usage("pvpisland <info:reload:restart>"));
				}
				else
				{
					if (args[0].equalsIgnoreCase("restart"))
					{
						if (player.hasPermission(this.plugin.strings.permissionPrefix("restart")))
						{
							for (Player players : Bukkit.getOnlinePlayers())
							{
								players.kickPlayer(ChatColor.RED + "The server is " + ChatColor.WHITE + "restarting" + ChatColor.RED + ".\nCome back soon!");
							}
							new BukkitRunnable()
							{
								public void run()
								{
									plugin.getServer().shutdown();
								}
							}.runTaskLater(this.plugin, 20);
						}
						else
						{
							this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&cYou do not have permission for this command.");
						}
					}
					if (args[0].equalsIgnoreCase("reload"))
					{
						if (player.hasPermission(this.plugin.strings.permissionPrefix("reload")))
						{
							this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&aConfig file reloaded.");
							this.plugin.reloadConfig();
						}
						else
						{
							this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&cYou do not have permission for this command.");
						}
					}
					else if (args[0].equalsIgnoreCase("info"))
					{
						this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&7Plugin \"&bPvPIslandKits&7\"");
						this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&7Created by: &bLegitDeveloper &7& &bPvPIslandDev");
						this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&7Copyright &b(c) &72015 PvPIsland.com Dev Team");
					}
					else if (args[0].equalsIgnoreCase("nyancat"))
					{
						if (player.isOp())
						{
							if (this.plugin.lists.nyanCat.contains(player.getName()))
							{
								this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&cSad Nyan Cat :(");
								this.plugin.lists.nyanCat.remove(player.getName());
							}
							else
							{
								this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&aNYAN NYAN NYAN NYAN NYAN NYANNYANNYANNYANNYAN NYANNYAN");
								this.plugin.lists.nyanCat.add(player.getName());
							}
						}
					}
					else
					{
						this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + this.plugin.strings.noSubCommand());
					}
				}
			}
		}
		return true;
	}
}
