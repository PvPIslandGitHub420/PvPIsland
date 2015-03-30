package me.rega_internal.pvpisland.options.listeners;

import me.rega_internal.pvpisland.Main;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class BloodListener implements Listener
{
	Main plugin;

	public BloodListener(Main main)
	{
		this.plugin = main;
	}

	@EventHandler
	public void bl00d(EntityDamageByEntityEvent event)
	{
		if (event.getDamager() instanceof Player)
		{
			Player dmgr = (Player) event.getDamager();
			if (this.plugin.lists.optionBlood.contains(dmgr.getName()))
			{
				dmgr.playEffect(((Player) event.getEntity()).getLocation().add(0, 1.5, 0), Effect.STEP_SOUND, Material.REDSTONE_BLOCK);
			}
		}
	}
}
