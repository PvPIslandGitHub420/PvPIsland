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

public class PoseidonKitAbility implements Listener
{
	Main plugin;

	public PoseidonKitAbility(Main main)
	{
		this.plugin = main;
	}

	@EventHandler
	public void useWaterbukkit(PlayerInteractEvent event)
	{
		Player player = event.getPlayer();
		if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)
		{
			if (player.getItemInHand().getType() == Material.WATER_BUCKET)
			{
				if (this.plugin.lists.kit.containsKey(player.getName()) || this.plugin.lists.kit.get(player.getName()).equalsIgnoreCase("Poseidon"))
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

							this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&aYou now have a 7 second out of water combat boost");
							player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 150, 1));
							player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 150, 1));
							player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 150, 1));
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

	// @EventHandler
	// public void water(PlayerMoveEvent e)
	// {
	// Player player = e.getPlayer();
	//
	// if (this.plugin.lists.kit.containsKey(player.getName()) &&
	// this.plugin.lists.kit.get(player.getName()).equalsIgnoreCase("Poseidon"))
	// {
	//
	// Material m = e.getPlayer().getLocation().getBlock().getType();
	// if (m == Material.STATIONARY_WATER || m == Material.WATER)
	// {
	//
	// player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION,
	// 100, 0));
	// player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE,
	// 100, 0));
	// player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 3));
	// player.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING,
	// 100, 5));
	// player.addPotionEffect(new
	// PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 2));
	// player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING,
	// 100, 1));
	// }
	//
	// }
	// }
}
