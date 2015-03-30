package me.rega_internal.pvpisland.options.listeners;

import me.rega_internal.pvpisland.Main;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class JesusListener implements Listener
{
	Main plugin;

	public JesusListener(Main main)
	{
		this.plugin = main;
	}

	@EventHandler
	public void walkWater(PlayerMoveEvent event)
	{
		Player player = event.getPlayer();
		if (this.plugin.lists.optionJesus.contains(player.getName()))
		{
			Location loc = player.getLocation().add(0, -1, 0);
			Location loc1 = player.getLocation().add(-1, -1, 0);
			Location loc2 = player.getLocation().add(1, -1, 0);
			Location loc3 = player.getLocation().add(0, -1, -1);
			Location loc4 = player.getLocation().add(0, -1, 1);

			Material block = loc.getBlock().getType();
			Material block2 = loc1.getBlock().getType();
			Material block3 = loc2.getBlock().getType();
			Material block4 = loc3.getBlock().getType();
			Material block5 = loc4.getBlock().getType();
			if (block == Material.WATER || block == Material.STATIONARY_WATER || block2 == Material.WATER || block2 == Material.STATIONARY_WATER || block3 == Material.WATER || block3 == Material.STATIONARY_WATER || block4 == Material.WATER || block4 == Material.STATIONARY_WATER
					|| block5 == Material.WATER || block5 == Material.STATIONARY_WATER)
			{
				loc.getBlock().setType(Material.PACKED_ICE);
				loc1.getBlock().setType(Material.PACKED_ICE);
				loc2.getBlock().setType(Material.PACKED_ICE);
				loc3.getBlock().setType(Material.PACKED_ICE);
				loc4.getBlock().setType(Material.PACKED_ICE);
			}

			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
			{
				public void run()
				{
					if (block == Material.WATER || block == Material.STATIONARY_WATER || block2 == Material.WATER || block2 == Material.STATIONARY_WATER || block3 == Material.WATER || block3 == Material.STATIONARY_WATER || block4 == Material.WATER || block4 == Material.STATIONARY_WATER
							|| block5 == Material.WATER || block5 == Material.STATIONARY_WATER)
					{
						loc.getBlock().setType(Material.WATER);
						loc1.getBlock().setType(Material.WATER);
						loc2.getBlock().setType(Material.WATER);
						loc3.getBlock().setType(Material.WATER);
						loc4.getBlock().setType(Material.WATER);
					}
				}
			}, 3 * 20);
		}
	}
}
