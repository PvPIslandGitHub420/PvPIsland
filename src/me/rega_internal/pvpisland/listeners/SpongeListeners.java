package me.rega_internal.pvpisland.listeners;

import me.rega_internal.pvpisland.Main;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class SpongeListeners implements Listener
{
	Main plugin;

	public SpongeListeners(Main main)
	{
		this.plugin = main;
	}

	@EventHandler
	public void onEntityDamage(EntityDamageEvent event)
	{
		if ((event.getEntity() instanceof Player))
		{
			Player player = (Player) event.getEntity();
			if ((!this.plugin.lists.spongeFallDmg.contains(player.getName())) || (!event.getCause().equals(EntityDamageEvent.DamageCause.FALL))) { return; }
			event.setCancelled(true);
			this.plugin.lists.spongeFallDmg.remove(player.getName());
		}
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event)
	{
		Player player = event.getPlayer();
		Location standBlock = player.getWorld().getBlockAt(player.getLocation().add(0.0D, -0.1D, 0.0D)).getLocation();
		int xblock = 0;
		double xvel = 0.0D;
		int yblock = -1;
		double yvel = 0.0D;
		int zblock = 0;
		double zvel = 0.0D;
		if (standBlock.getBlock().getTypeId() == 19)
		{
			this.plugin.lists.spongeFallDmg.add(player.getName());
			while (standBlock.getBlock().getLocation().add(xblock, -1.0D, 0.0D).getBlock().getType().equals(Material.SPONGE))
			{
				xblock--;
				xvel += 0.8D;
			}
			while (standBlock.getBlock().getLocation().add(0.0D, yblock, 0.0D).getBlock().getType().equals(Material.SPONGE))
			{
				yblock--;
				yvel += 1.0D;
			}
			while (standBlock.getBlock().getLocation().add(0.0D, -1.0D, zblock).getBlock().getType().equals(Material.SPONGE))
			{
				zblock--;
				zvel += 0.8D;
			}
			xblock = 0;
			zblock = 0;
			while (standBlock.getBlock().getLocation().add(xblock, -1.0D, 0.0D).getBlock().getType().equals(Material.SPONGE))
			{
				xblock++;
				xvel -= 0.8D;
			}
			while (standBlock.getBlock().getLocation().add(0.0D, -1.0D, zblock).getBlock().getType().equals(Material.SPONGE))
			{
				zblock++;
				zvel -= 0.8D;
			}
			if (standBlock.getBlock().getLocation().add(0.0D, -1.0D, 0.0D).getBlock().getType().equals(Material.SPONGE))
			{
				player.setVelocity(new Vector(xvel, yvel, zvel));
			}
		}
		if ((xvel == 0.0D) && (yvel == 0.0D) && (zvel == 0.0D)) { return; }

	}
}
