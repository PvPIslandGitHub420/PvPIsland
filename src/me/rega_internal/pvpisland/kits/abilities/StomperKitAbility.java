package me.rega_internal.pvpisland.kits.abilities;

import java.util.List;

import me.rega_internal.pvpisland.Main;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class StomperKitAbility implements Listener
{
	Main plugin;

	public StomperKitAbility(Main main)
	{
		this.plugin = main;
	}

	@EventHandler
	public void onPlayerDamage(EntityDamageEvent e)
	{
		if (e.getEntity() instanceof Player)
		{
			Player p = (Player) e.getEntity();
			if (this.plugin.lists.kit.containsKey(p.getName()) && this.plugin.lists.kit.get(p.getName()).equalsIgnoreCase("stomper"))
			{
				if (e.getCause().equals(DamageCause.FALL) && p.getFallDistance() > 3)
				{
					if (!this.plugin.playerMethods.isInSpawn(p))
					{
						List<Entity> nearby = p.getNearbyEntities(5, 5, 5);
						for (Entity tmp : nearby)
							if (tmp instanceof Player)
							{
								Player t = Bukkit.getPlayer(((Player) tmp).getName());
								if (t.isSneaking())
								{
									t.damage((double) 10, p);
									if (e.getDamage() >= t.getHealth())
									{
										t.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.strings.prefix() + "&7You were stomped by &c" + p.getName() + "&7!"));
										p.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.strings.prefix() + "&7You stomped &c" + t.getName() + "&7!"));
									}
								}
								else
								{
									t.damage(e.getDamage() * 2.3, p);
									if (e.getDamage() >= t.getHealth())
									{
										t.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.strings.prefix() + "&7You were stomped by &c" + p.getName() + "&7!"));
										p.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.strings.prefix() + "&7You stomped &c" + t.getName() + "&7!"));
									}
								}
							}
						e.setDamage(4);
					}
				}
			}
		}
	}
}
