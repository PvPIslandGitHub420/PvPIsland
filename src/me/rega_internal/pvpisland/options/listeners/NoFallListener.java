package me.rega_internal.pvpisland.options.listeners;

import me.rega_internal.pvpisland.Main;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class NoFallListener implements Listener
{
	Main plugin;

	public NoFallListener(Main main)
	{
		this.plugin = main;
	}

	@EventHandler
	public void nofall(EntityDamageEvent event)
	{
		if (event.getEntity() instanceof Player)
		{
			Player player = (Player) event.getEntity();
			if (event.getCause() == DamageCause.FALL)
			{
				if (this.plugin.lists.optionNoJump.contains(player.getName()))
				{
					event.setCancelled(true);
				}
			}
		}
	}
}
