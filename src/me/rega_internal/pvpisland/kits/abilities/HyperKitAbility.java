package me.rega_internal.pvpisland.kits.abilities;

import me.rega_internal.pvpisland.Main;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class HyperKitAbility implements Listener
{
	Main plugin;

	public HyperKitAbility(Main main)
	{
		this.plugin = main;
	}

	@EventHandler
	public void useSugar(PlayerInteractEvent event)
	{
		Player player = event.getPlayer();
		if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)
		{
			if (player.getItemInHand().getType() == Material.SUGAR)
			{
				if (this.plugin.lists.kit.containsKey(player.getName()) || this.plugin.lists.kit.get(player.getName()).equalsIgnoreCase("Hyper"))
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

							player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20 * 10, 1));
							player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 20 * 10, 1));

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
