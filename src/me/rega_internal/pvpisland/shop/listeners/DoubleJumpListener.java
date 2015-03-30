package me.rega_internal.pvpisland.shop.listeners;

import me.rega_internal.pvpisland.Main;

import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;

public class DoubleJumpListener implements Listener
{

	Main plugin;

	public DoubleJumpListener(Main main)
	{
		this.plugin = main;
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerFly(PlayerToggleFlightEvent e)
	{
		Player p = e.getPlayer();
		if (this.plugin.lists.shopDoubleJump.contains(p.getName()))
		{
			if (p.getGameMode() != GameMode.CREATIVE) return;
			e.setCancelled(true);
			p.setAllowFlight(false);
			p.setFlying(false);
			p.setVelocity(p.getLocation().getDirection().multiply(1.5D).setY(0.9D));
			p.playEffect(p.getLocation(), Effect.BLAZE_SHOOT, 15);
		}
	}

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e)
	{
		Player p = e.getPlayer();
		if (this.plugin.lists.shopDoubleJump.contains(p.getName()))
		{
			if ((e.getPlayer().getGameMode() != GameMode.CREATIVE) && (p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() != Material.AIR))
			{
				p.setAllowFlight(true);
			}
		}
	}
}