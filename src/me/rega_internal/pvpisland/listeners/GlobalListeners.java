package me.rega_internal.pvpisland.listeners;

import me.rega_internal.pvpisland.Main;
import me.rega_internal.pvpisland.commands.CommandSpawn;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class GlobalListeners implements Listener
{
	Main plugin;

	public GlobalListeners(Main main)
	{
		this.plugin = main;
	}

	@EventHandler
	public void noWeather(WeatherChangeEvent e)
	{
		e.getWorld().setWeatherDuration(0);
	}

	@EventHandler
	public void click(InventoryClickEvent event)
	{
		if (event.getInventory().getTitle().startsWith("Inventory of"))
			event.setCancelled(true);
		if (event.getInventory().getTitle().startsWith("Options"))
			event.setCancelled(true);
		if (event.getInventory().getTitle().startsWith("Kit"))
			event.setCancelled(true);
	}

	@EventHandler
	public void pickup(PlayerPickupItemEvent event)
	{
		if (!this.plugin.lists.kit.containsKey(event.getPlayer().getName()))
		{
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void drop(PlayerDropItemEvent event)
	{
		Player player = event.getPlayer();
		if (!this.plugin.lists.kit.containsKey(player.getName()))
		{
			event.setCancelled(true);
		} else
		{
			new BukkitRunnable()
			{
				public void run()
				{
					event.getItemDrop().remove();
				}
			}.runTaskLater(this.plugin, 20 * 10);
		}
	}

	@EventHandler
	public void noHunger(FoodLevelChangeEvent event)
	{
		if (!this.plugin.lists.kit.containsKey(event.getEntity().getName()))
		{
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void moveWhileTeleporting(PlayerMoveEvent event)
	{
		Player player = event.getPlayer();
		if (this.plugin.lists.teleporting.contains(player.getName()))
		{
			if (player.getLocation().getX() != CommandSpawn.loc.getX() || player.getLocation().getY() != CommandSpawn.loc.getY() || player.getLocation().getZ() != CommandSpawn.loc.getZ())
			{
				this.plugin.lists.teleporting.remove(player.getName());
				plugin.playerMethods.message(player, plugin.strings.prefix() + "&7Teleportation cancelled.");
			}
		}
	}

	@EventHandler
	public void arrow(ProjectileHitEvent event)
	{
		event.getEntity().remove();
	}

	@EventHandler
	public void explode(EntityExplodeEvent event)
	{
		event.blockList().clear();
	}

	@EventHandler
	public void use(PlayerInteractEvent event)
	{
		if (event.getClickedBlock().getType() == Material.CHEST || event.getClickedBlock().getType() == Material.TRAPPED_CHEST || event.getClickedBlock().getType() == Material.WORKBENCH
				|| event.getClickedBlock().getType() == Material.FURNACE || event.getClickedBlock().getType() == Material.BURNING_FURNACE
				|| event.getClickedBlock().getType() == Material.BREWING_STAND)
		{
			event.setCancelled(true);
		}

		if (event.getClickedBlock().getType() == Material.ENDER_CHEST | event.getClickedBlock().getType() == Material.ANVIL || event.getClickedBlock().getType() == Material.ENCHANTMENT_TABLE)
		{
			if (!this.plugin.lists.kit.containsKey(event.getPlayer().getName()))
			{
				event.setCancelled(true);
				this.plugin.playerMethods.message(event.getPlayer(), this.plugin.strings.prefix() + "&cPlease select a kit to open this.");
			}
		}
	}
}
