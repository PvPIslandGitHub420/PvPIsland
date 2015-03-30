package me.rega_internal.pvpisland.commands;

import me.rega_internal.pvpisland.Main;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class CommandSpawn implements CommandExecutor
{
	Main plugin;
	public static Location loc = null;

	public CommandSpawn(Main main)
	{
		this.plugin = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if (cmd.getName().equalsIgnoreCase("spawn"))
		{
			if (!(sender instanceof Player))
			{
				sender.sendMessage(this.plugin.strings.consoleSender("spawn"));
				return false;
			} else
			{
				Player player = (Player) sender;
				if (!this.plugin.lists.kit.containsKey(player.getName()))
				{
					this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&7Teleported to spawn.");
					player.teleport(this.plugin.locations.getSpawn());
					this.plugin.playerMethods.clear(player);
					this.plugin.playerMethods.clearKit(player);
					player.getInventory().setItem(0, this.plugin.items.getKitSelector());
					player.getInventory().setItem(8, this.plugin.items.getShop());
					player.getInventory().setItem(5, this.plugin.items.getParticles());
					player.getInventory().setItem(4, this.plugin.items.getOptions());
					if (player.isInsideVehicle())
					{
						Horse horse = (Horse) player.getVehicle();
						horse.remove();
					}
				} else
				{
					this.plugin.lists.teleporting.add(player.getName());
					loc = player.getLocation();
					this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&7Teleporting in &b5 seconds&7. Do not move.");
					this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&c&lWarning: &7Your kit will be cleared!");
					new BukkitRunnable()
					{
						public void run()
						{
							if (plugin.lists.teleporting.contains(player.getName()))
							{
								if (player.isInsideVehicle())
								{
									Horse horse = (Horse) player.getVehicle();
									horse.remove();
								}
								plugin.lists.teleporting.remove(player.getName());
								plugin.playerMethods.message(player, plugin.strings.prefix() + "&7Teleported to spawn.");
								player.teleport(plugin.locations.getSpawn());
								plugin.playerMethods.clear(player);
								plugin.playerMethods.clearKit(player);
								player.getInventory().setItem(0, plugin.items.getKitSelector());
								player.getInventory().setItem(5, plugin.items.getParticles());
								player.getInventory().setItem(8, plugin.items.getShop());
								player.getInventory().setItem(4, plugin.items.getOptions());
							}
						}
					}.runTaskLater(this.plugin, 20 * 5);
					;
				}
			}
		} else if (cmd.getName().equalsIgnoreCase("setspawn"))
		{
			if (!(sender instanceof Player))
			{
				sender.sendMessage(this.plugin.strings.consoleSender("setspawn"));
				return false;
			} else
			{
				Player player = (Player) sender;
				if (!player.hasPermission(this.plugin.strings.permissionPrefix("command.setspawn")))
				{
					this.plugin.playerMethods.message(player, this.plugin.strings.noPermission());
				} else
				{
					this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&aSpawn has been set at your current location.");
					this.plugin.getConfig().set("Locations.Spawn.World", player.getWorld().getName());
					this.plugin.getConfig().set("Locations.Spawn.X", player.getLocation().getX());
					this.plugin.getConfig().set("Locations.Spawn.Y", player.getLocation().getY());
					this.plugin.getConfig().set("Locations.Spawn.Z", player.getLocation().getZ());
					this.plugin.getConfig().set("Locations.Spawn.Yaw", player.getLocation().getYaw());
					this.plugin.getConfig().set("Locations.Spawn.Pitch", player.getLocation().getPitch());
					this.plugin.saveConfig();
				}
			}
		}
		return true;
	}
}
