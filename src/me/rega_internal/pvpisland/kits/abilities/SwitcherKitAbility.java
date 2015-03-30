package me.rega_internal.pvpisland.kits.abilities;

import me.rega_internal.pvpisland.Main;
import me.rega_internal.pvpisland.libs.Item;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class SwitcherKitAbility implements Listener
{
	Main plugin;

	public SwitcherKitAbility(Main main)
	{
		this.plugin = main;
	}

	@EventHandler
	public void throwSnowball(ProjectileLaunchEvent event)
	{
		if (event.getEntity() instanceof Snowball)
		{
			Snowball snowball = (Snowball) event.getEntity();
			if (snowball.getShooter() instanceof Player)
			{
				Player player = (Player) snowball.getShooter();
				if (this.plugin.lists.kit.containsKey(player.getName()) && this.plugin.lists.kit.get(player.getName()).equalsIgnoreCase("Switcher"))
				{
					if (this.plugin.lists.cooldown.containsKey(player.getName()))
					{
						event.setCancelled(true);
						player.getInventory().addItem(new Item(new ItemStack(Material.SNOW_BALL)).setName("&fSwitcher Ball").build());
						this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&cYou are still on cooldown.");
					}
					else
					{
						if (!this.plugin.playerMethods.isInSpawn(player))
						{
							/******************* COOLDOWN *******************/
							this.plugin.lists.cooldown.put(player.getName(), 30);
							/******************* COOLDOWN *******************/

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
							}.runTaskLater(this.plugin, 20 * 10);
							/******************* COOLDOWN *******************/
						}
						else
						{
							event.setCancelled(true);
							player.getInventory().addItem(new Item(new ItemStack(Material.SNOW_BALL)).setName("&fSwitcher Ball").build());
						}
					}
				}
			}
		}
	}

	@EventHandler
	public void hitSnowball(EntityDamageByEntityEvent event)
	{
		if (event.getEntity() instanceof Player)
		{
			Player player = (Player) event.getEntity();
			if (event.getDamager() instanceof Snowball)
			{
				Snowball snowball = (Snowball) event.getDamager();
				if (snowball.getShooter() instanceof Player)
				{
					Player shooter = (Player) snowball.getShooter();
					if (this.plugin.lists.kit.containsKey(shooter.getName()) && this.plugin.lists.kit.get(shooter.getName()).equalsIgnoreCase("Switcher"))
					{
						if (!this.plugin.playerMethods.isInSpawn(shooter) && !this.plugin.playerMethods.isInSpawn(player))
						{
							Location pL = player.getLocation();
							Location sL = shooter.getLocation();
							shooter.teleport(pL, TeleportCause.PLUGIN);
							player.teleport(sL, TeleportCause.PLUGIN);
							this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&7You have switched places with &c" + shooter.getName() + "&7.");
							this.plugin.playerMethods.message(shooter, this.plugin.strings.prefix() + "&7You have switched places with &c" + player.getName() + "&7.");
						}
					}
				}
			}
		}
	}
}
