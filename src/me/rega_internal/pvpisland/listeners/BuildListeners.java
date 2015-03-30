package me.rega_internal.pvpisland.listeners;

import me.rega_internal.pvpisland.Main;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BuildListeners implements Listener
{
	Main plugin;

	public BuildListeners(Main main)
	{
		this.plugin = main;
	}

	@EventHandler
	public void build(BlockBreakEvent event)
	{
		Player player = event.getPlayer();
		if (!this.plugin.lists.buildMode.contains(player.getName())) event.setCancelled(true);
	}

	@EventHandler
	public void build(BlockPlaceEvent event)
	{
		Player player = event.getPlayer();
		if (!this.plugin.lists.buildMode.contains(player.getName())) event.setCancelled(true);
	}
}
