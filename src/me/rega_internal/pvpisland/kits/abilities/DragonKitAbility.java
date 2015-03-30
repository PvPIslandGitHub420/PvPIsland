package me.rega_internal.pvpisland.kits.abilities;

import java.util.ArrayList;
import java.util.List;

import me.rega_internal.pvpisland.Main;
import me.rega_internal.pvpisland.libs.ParticleEffect;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class DragonKitAbility implements Listener
{
	Main plugin;
	List<String> flying = new ArrayList<String>();

	public DragonKitAbility(Main main)
	{
		this.plugin = main;
	}

	@EventHandler
	public void dragonFly(PlayerInteractEvent event)
	{
		Player player = event.getPlayer();
		if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)
		{
			if (player.getItemInHand().getType() == Material.FEATHER)
			{
				if (this.plugin.lists.kit.containsKey(player.getName()) || this.plugin.lists.kit.get(player.getName()).equalsIgnoreCase("Dragon"))
				{
					if (this.plugin.lists.cooldown.containsKey(player.getName()))
					{
						event.setCancelled(true);
						this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&cYou are still on cooldown.");
					}
					else
					{
						if (!this.plugin.playerMethods.isInSpawn(player))
						{
							/******************* COOLDOWN *******************/
							this.plugin.lists.cooldown.put(player.getName(), 30);
							/******************* COOLDOWN *******************/

							player.getWorld().playSound(player.getLocation(), Sound.ENDERDRAGON_WINGS, 10, 1);
							player.setVelocity(new Vector(0, 2.5, 0));
							ParticleEffect.SPELL_WITCH.display((float) 0, (float) 0, (float) 0, (float) 0.3, 20, player.getLocation(), (float) 10);
							flying.add(player.getName());

							/******************* COOLDOWN *******************/
							new BukkitRunnable()
							{
								public void run()
								{
									if (plugin.lists.kit.containsKey(player.getName()) && plugin.lists.cooldown.containsKey(player.getName()))
									{
										plugin.lists.cooldown.remove(player.getName());
										plugin.playerMethods.message(player, plugin.strings.prefix() + "&cYou are no longer on cooldown.");
									}
								}
							}.runTaskLater(this.plugin, 20 * 30);
							/******************* COOLDOWN *******************/
						}
					}
				}
			}
		}
	}

	@EventHandler
	public void onPlayerDamage(EntityDamageEvent e)
	{
		if (e.getEntity() instanceof Player)
		{
			Player p = (Player) e.getEntity();
			if (e.getCause() == DamageCause.FALL)
			{
				if (this.plugin.lists.kit.containsKey(p.getName()))
				{
					if (flying.contains(p.getName()))
					{
						flying.remove(p.getName());
						e.setDamage(10);
						for (Entity e1 : p.getNearbyEntities(7, 7, 7))
						{
							if (e1 instanceof Player)
							{
								Player p2 = (Player) e1;
								p2.setVelocity(new Vector(0, 1, 0));
								p2.setFireTicks(20 * 15);
								p.getWorld().playSound(p.getLocation(), Sound.ENDERDRAGON_GROWL, 10, 1);
							}
						}
					}
				}
			}
		}
	}
}
