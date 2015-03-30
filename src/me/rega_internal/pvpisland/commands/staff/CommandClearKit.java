package me.rega_internal.pvpisland.commands.staff;

import me.rega_internal.pvpisland.Main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;

public class CommandClearKit implements CommandExecutor
{
	Main plugin;

	public CommandClearKit(Main main)
	{
		this.plugin = main;
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		if (command.getName().equalsIgnoreCase("ck"))
		{
			if (!(sender instanceof Player))
			{
				sender.sendMessage(this.plugin.strings.consoleSender("ck"));
				return false;
			}

			Player player = (Player) sender;
			if (player.hasPermission(this.plugin.strings.permissionPrefix("command.clearkit")))
			{
				if (!this.plugin.lists.kit.containsKey(player.getName()))
				{
					this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&cYou do not have a kit selected.");
				}
				else
				{
					this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&7Your current kit has been removed.");
					this.plugin.playerMethods.clearKit(player);
					this.plugin.playerMethods.clear(player);
					player.getInventory().setItem(0, plugin.items.getKitSelector());
					player.getInventory().setItem(8, plugin.items.getShop());
					player.getInventory().setItem(4, plugin.items.getOptions());
					player.getInventory().setItem(5, plugin.items.getParticles());
					if (player.isInsideVehicle())
					{
						Horse horse = (Horse) player.getVehicle();
						horse.remove();
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
