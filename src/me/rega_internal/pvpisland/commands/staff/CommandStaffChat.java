package me.rega_internal.pvpisland.commands.staff;

import me.rega_internal.pvpisland.Main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandStaffChat implements CommandExecutor
{
	Main plugin;

	public CommandStaffChat(Main main)
	{
		this.plugin = main;
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		if (command.getName().equalsIgnoreCase("staffchat"))
		{
			if (!(sender instanceof Player))
			{
				sender.sendMessage(this.plugin.strings.consoleSender("staffchat"));

				return false;
			}
			else
			{
				Player player = (Player) sender;
				if (player.hasPermission("command.staffchat"))
				{
					if (!this.plugin.lists.staffChat.contains(player.getName()))
					{
						this.plugin.lists.staffChat.add(player.getName());
						this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&aStaff chat has been enabled.");
					}
					else
					{
						this.plugin.lists.staffChat.remove(player.getName());
						this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&cStaff chat has been disabled.");
					}
				}
				else
				{
					this.plugin.playerMethods.message(player, this.plugin.strings.noPermission());
				}
			}
		}
		return true;

	}
}
