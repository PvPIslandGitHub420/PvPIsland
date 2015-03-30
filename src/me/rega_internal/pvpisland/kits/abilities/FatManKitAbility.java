package me.rega_internal.pvpisland.kits.abilities;

import java.util.HashSet;

import me.rega_internal.pvpisland.Main;
import me.rega_internal.pvpisland.libs.ParticleEffect;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class FatManKitAbility implements Listener
{
	Main plugin;

	public FatManKitAbility(Main main)
	{
		this.plugin = main;
	}

	@EventHandler
	public void charizard(PlayerInteractEvent event)
	{
		Player player = event.getPlayer();
		if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)
		{
			if (player.getItemInHand().getType() == Material.FURNACE)
			{
				if (this.plugin.lists.kit.containsKey(player.getName()) || this.plugin.lists.kit.get(player.getName()).equalsIgnoreCase("Fatman"))
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

							player.getWorld().playSound(player.getLocation(), Sound.BURP, 10, 1);
							for (int j = 0; j < 30; j++)
							{
								@SuppressWarnings("deprecation")
								Location localLocation = player.getTargetBlock((HashSet<Byte>) null, j).getLocation();
								ParticleEffect.FIREWORKS_SPARK.display(0, 0, 0, (float) 0.01, 1, localLocation, 20);
								for (Player localPlayer2 : Bukkit.getOnlinePlayers())
								{
									if ((localPlayer2 != player) && (localPlayer2.getLocation().distance(localLocation) < 2.0D))
									{
										localPlayer2.getWorld().createExplosion(localPlayer2.getLocation(), 4);
									}
								}
							}
							Entity cake = (Entity) player.getWorld().dropItemNaturally(player.getEyeLocation(), new ItemStack(Material.CAKE));
							cake.setVelocity(player.getLocation().getDirection().multiply(1.5));
							new BukkitRunnable()
							{
								public void run()
								{
									cake.remove();
								}
							}.runTaskLater(this.plugin, 20);

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
}
