package me.rega_internal.pvpisland.commands;

import me.rega_internal.pvpisland.Main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandDonator implements CommandExecutor
{
	Main plugin;

	public CommandDonator(Main main)
	{
		this.plugin = main;
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		if (command.getName().equalsIgnoreCase("rank"))
		{
			if (!(sender instanceof Player))
			{
				sender.sendMessage(this.plugin.strings.consoleSender("rank"));
				return false;
			}
			else
			{
				Player p = (Player) sender;
				if (args.length != 1)
				{
					this.plugin.playerMethods.message(p, this.plugin.strings.prefix() + this.plugin.strings.usage("rank <rank>"));
				}
				else if (args.length == 1)
				{
					if (args[0].equalsIgnoreCase("vip"))
					{
						this.plugin.playerMethods.message(p, this.plugin.strings.prefix() + "&aVIP - &7the $5 Donation Rank");
						this.plugin.playerMethods.message(p, this.plugin.strings.prefix() + "&aOffers Kits: &7backpacker, creator, gladiator, grandpa, sling and suprise");
						this.plugin.playerMethods.message(p, this.plugin.strings.prefix() + "&aCommands: &7/chatcolor");
						this.plugin.playerMethods.message(p, this.plugin.strings.prefix() + "&aCan Host: &7LMS, Sumo, ROD, OITC, and Parkour");
					}
					else if (args[0].equalsIgnoreCase("mvp"))
					{
						this.plugin.playerMethods.message(p, this.plugin.strings.prefix() + "&9MVP - &7the $10 Donation Rank");
						this.plugin.playerMethods.message(p, this.plugin.strings.prefix() + "&9Offers Kits: &7All &aVIP &7kits + earthbender, flamethrower, leech, panic, slime, timelord, and virus");
						this.plugin.playerMethods.message(p, this.plugin.strings.prefix() + "&9Commands: &7/seekit and /chatcolor");
						this.plugin.playerMethods.message(p, this.plugin.strings.prefix() + "&9Can Host: &7LMS, Sumo, ROD, OITC, and Parkour");
					}
					else if (args[0].equalsIgnoreCase("pro"))
					{
						this.plugin.playerMethods.message(p, this.plugin.strings.prefix() + "&6Pro - &7the $20 Donation Rank");
						this.plugin.playerMethods.message(p, this.plugin.strings.prefix() + "&6Offers Kits: &7All &aVIP&7+&9MVP &7kits + grendadier, jesus, mario, psycho, superman, theif, and viper");
						this.plugin.playerMethods.message(p, this.plugin.strings.prefix() + "&6Commands: &7/seekit and /chatcolor");
						this.plugin.playerMethods.message(p, this.plugin.strings.prefix() + "&6Can Host: &7LMS, Sumo, ROD, OITC, and Parkour");
					}
					else if (args[0].equalsIgnoreCase("master"))
					{
						this.plugin.playerMethods.message(p, this.plugin.strings.prefix() + "&2Master - &7the $30 Donation Rank");
						this.plugin.playerMethods.message(p, this.plugin.strings.prefix() + "&2Offers Kits: &7All &aVIP&7+&9MVP+&6Pro &7kits + flash, gambler, neptune, rider, snail, stopper, and teleporter");
						this.plugin.playerMethods.message(p, this.plugin.strings.prefix() + "&2Commands: &7/seekit and /chatcolor");
						this.plugin.playerMethods.message(p, this.plugin.strings.prefix() + "&2Can Host: &7LMS, Sumo, ROD, OITC, Parkour and Brackets");
					}
					else if (args[0].equalsIgnoreCase("imperial"))
					{
						this.plugin.playerMethods.message(p, this.plugin.strings.prefix() + "&dImperial - &7the $50 Donation Rank");
						this.plugin.playerMethods.message(p, this.plugin.strings.prefix() + "&dOffers Kits: &7ALL KITS!");
						this.plugin.playerMethods.message(p, this.plugin.strings.prefix() + "&aCommands: &7/seekit and /chatcolor");
						this.plugin.playerMethods.message(p, this.plugin.strings.prefix() + "&aCan Host: &7All Mini-Games");
					}
					else
					{
						this.plugin.playerMethods.message(p, this.plugin.strings.prefix() + this.plugin.strings.noSubCommand());
					}
				}
			}
		}
		return false;
	}
}
