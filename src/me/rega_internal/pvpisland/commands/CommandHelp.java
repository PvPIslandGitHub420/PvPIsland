package me.rega_internal.pvpisland.commands;

import me.rega_internal.pvpisland.Main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHelp implements CommandExecutor
{
	Main plugin;

	public CommandHelp(Main main)
	{
		this.plugin = main;
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		if (command.getName().equalsIgnoreCase("help"))
		{
			if (!(sender instanceof Player))
			{
				sender.sendMessage(this.plugin.strings.consoleSender("help"));
				return false;
			} else
			{
				Player player = (Player) sender;
				if (args.length != 1)
				{
					this.plugin.playerMethods.message(player, "&7&m-------&r&8[&bHelp&8]&7&m-------");
					this.plugin.playerMethods.message(player, "&8» &7/seekit <player> &8- &7See another player's kit.");
					this.plugin.playerMethods.message(player, "&8» &7/report <player> <reason> &8- &7Report players for breaking the rules.");
					this.plugin.playerMethods.message(player, "&8» &7/msg <player> <message>&8- &7Privately message someone.");
					this.plugin.playerMethods.message(player, "&8» &7/suicide &8 &7Kills yourself.");
					this.plugin.playerMethods.message(player, "&8» &7/who &8- &7See who is online.");
					this.plugin.playerMethods.message(player, "&8» &7/rank <rank> &8- &7See information on donor ranks.");
					this.plugin.playerMethods.message(player, "&8» &7/pvpisland &8- &7Info on the PvPIsland plugin");
					this.plugin.playerMethods.message(player, "&8» &7/kit &8- &7Open the kit selection GUI(inventory)");
				} else
				{
					if (args[0].equalsIgnoreCase("staff"))
					{
						if (this.plugin.playerMethods.isStaff(player))
						{
							this.plugin.playerMethods.message(player, "&7&m-------&r&8[&cStaff Help&8]&7&m-------");
							this.plugin.playerMethods.message(player, "&8» &7/admin &8- &7Toggle between invisibility and visiblity.");
							this.plugin.playerMethods.message(player, "&8» &7/clearchat &8- &7Clear the global chat.");
							this.plugin.playerMethods.message(player, "&8» &7/clearkit &8- &7Clear your current kit.");
							this.plugin.playerMethods.message(player, "&8» &7/build &8- &7Toggle between building and not building.");
							this.plugin.playerMethods.message(player, "&8» &7/globalmute &8- &7Mute the whole chat.");
							this.plugin.playerMethods.message(player, "&8» &7/warn &8- &7Give a player a warning.");
							this.plugin.playerMethods.message(player, "&8» &7/welcome &8- &7Globally welcome a player.");
							this.plugin.playerMethods.message(player, "&8» &7/staffchat &8- &7Talk privately to all online staff.");
							this.plugin.playerMethods.message(player, "&8» &7/invsee &8- &7Open the inventory of a player");
							
						} else
						{
							this.plugin.playerMethods.message(player, this.plugin.strings.noPermission());
						}
					} else if (args[0].equalsIgnoreCase("donor"))
					{
						if (this.plugin.playerMethods.isDonor(player) || this.plugin.playerMethods.isStaff(player))
						{
							this.plugin.playerMethods.message(player, "&7&m-------&r&8[&aDonor Help&8]&7&m-------");
							this.plugin.playerMethods.message(player, "&8» &7/soup &8- &7Open a chest to obtain more soup.");
							this.plugin.playerMethods.message(player, "&8» &7/repair &8- &7Repair your armor so it doesn't break!");
							this.plugin.playerMethods.message(player, "&8» &7/chatcolor <color>:off:list &8- &7Change the color of your chat");
							
							
							
							
							this.plugin.playerMethods.message(player, "&8» &7/help host &8- &7View the commands to host events.");
							
						} else
						{
							this.plugin.playerMethods.message(player, this.plugin.strings.noPermission());
						}
					} else if (args[0].equalsIgnoreCase("host"))
					{

					} else
					{
						this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + this.plugin.strings.noSubCommand());
					}
				}
			}
		}
		return true;
	}
}
