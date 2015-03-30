package me.rega_internal.pvpisland.kits.abilities;

import me.rega_internal.pvpisland.Main;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

public class FishermanKitAbility implements Listener
{
	Main plugin;

	public FishermanKitAbility(Main main)
	{
		this.plugin = main;
	}

	@EventHandler
	public void fish(PlayerFishEvent event)
	{
		Player player = event.getPlayer();
		Player caught = (Player) event.getCaught();

		if (this.plugin.lists.kit.containsKey(player.getName()) && this.plugin.lists.kit.get(player.getName()).equalsIgnoreCase("fisherman"))
		{
			if (!this.plugin.playerMethods.isInSpawn(player) && !this.plugin.playerMethods.isInSpawn(caught))
			{
				caught.teleport(player.getLocation());
				this.plugin.playerMethods.message(caught, this.plugin.strings.prefix() + ChatColor.GRAY + "You were reeled in by " + ChatColor.RED + player.getName() + "&7.");
				this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + ChatColor.GRAY + "You reeled " + ChatColor.RED + caught.getName() + " &7in.");
			}
		}
	}
}
