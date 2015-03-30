package me.rega_internal.pvpisland.commands.staff;

import me.rega_internal.pvpisland.Main;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class CommandInvsee implements CommandExecutor
{
	Main plugin;

	public CommandInvsee(Main main)
	{
		this.plugin = main;
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		if (command.getName().equalsIgnoreCase("invsee")) 
		{
			if (!(sender instanceof Player))
			{
				sender.sendMessage(this.plugin.strings.consoleSender("invsee"));
				return false;
			}

			Player player = (Player) sender;
			if (player.hasPermission(this.plugin.strings.permissionPrefix("command.invsee")))
			{
				if (args.length != 1)
				{
					this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + this.plugin.strings.usage("invsee <player>"));
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
						Inventory inv = Bukkit.createInventory(target, 36, "Inventory of " + target.getName());

						inv.setContents(target.getInventory().getContents());

						player.openInventory(inv);
					}
				}
			}
			else
			{
				this.plugin.playerMethods.message(player, this.plugin.strings.noPermission());
			}
		}
		return true;
	}
}
