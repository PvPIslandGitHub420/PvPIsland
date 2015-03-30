package me.rega_internal.pvpisland.listeners;

import java.text.DecimalFormat;
import java.util.Random;

import me.rega_internal.pvpisland.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class DeathListeners implements Listener
{
	Main plugin;

	public DeathListeners(Main main)
	{
		this.plugin = main;
	}

	@EventHandler
	public void sniper(EntityDamageByEntityEvent event)
	{
		if ((event.getEntity() instanceof Player))
		{
			Player player = (Player) event.getEntity();
			if ((event.getDamager() instanceof Arrow))
			{
				Arrow arrow = (Arrow) event.getDamager();
				if ((arrow.getShooter() instanceof Player))
				{
					Player shooter = (Player) arrow.getShooter();
					DecimalFormat df = new DecimalFormat("#");
					double blocks = player.getLocation().distance(shooter.getLocation());

					if (blocks >= 50.0D)
					{
						Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&6&o" + shooter.getName() + " sniped " + player.getName() + " at " + df.format(blocks) + " blocks away!"));
						player.damage(event.getDamage() * 100.0D);
						this.plugin.economy.depositPlayer(shooter, 75.0D);
						this.plugin.playerMethods.message(shooter, this.plugin.strings.prefix() + "&7You received an extra &c$75.0 &7for sniping " + player.getName() + "&7!");
					} else if (blocks >= 20.0D)
					{
						this.plugin.playerMethods.message(shooter, "&7You have hit " + player.getName() + " at " + df.format(blocks) + " blocks. (Hit them at 50+ for an instant kill!)");
					}

					this.plugin.playerMethods.message(shooter, this.plugin.strings.prefix() + "&7" + player.getName() + " now has &c" + new DecimalFormat("#").format(player.getHealth()) + " &7❤");
				}
			}
		}
	}

	@EventHandler
	public void items(PlayerDeathEvent event)
	{
	if (!this.plugin.lists.kit.containsKey(event.getEntity().getName()))
	{
		event.getDrops().clear();
	}

		}
			

	

	@SuppressWarnings("deprecation")
	@EventHandler
	public void death(PlayerDeathEvent event)
	{
		Player player = (Player) event.getEntity();
		this.plugin.lists.kit.remove(player.getName());
		this.plugin.lists.cooldown.remove(player.getName());
		this.plugin.lists.teleporting.remove(player.getName());
		this.plugin.lists.optionJesus.remove(player.getName());
		this.plugin.lists.optionBlood.remove(player.getName());
		this.plugin.lists.optionNoHunger.remove(player.getName());
		this.plugin.lists.optionNoJump.remove(player.getName());
		this.plugin.lists.killsFromLife.remove(player.getName());
		this.plugin.lists.NoLog.remove(player.getName());

		if (player.getKiller() instanceof Player)
		{
			Player killer = player.getKiller();

			Random r = new Random();
			int percentage = r.nextInt(100 - 50) + 50;
			this.plugin.economy.depositPlayer(killer.getName(), percentage);
			this.plugin.playerMethods.message(killer, this.plugin.strings.prefix() + "&7You killed &c" + player.getName() + " &7and got &c$" + percentage + "&7!");

			if (this.plugin.lists.optionNoJump.contains(killer.getName()))
			{
				this.plugin.economy.depositPlayer(killer.getName(), 25);
				this.plugin.playerMethods.message(killer, this.plugin.strings.prefix() + "&7+&c$50 &7for getting a kill using &cNo Jump&7.");
			}
			this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&7You were killed by &c" + killer.getName() + " &7with &c" + new DecimalFormat("#").format(killer.getHealth())
					+ " &7❤");
			this.plugin.serverMethods.scoreboard(killer);
		}
	}

	@EventHandler
	public void respawn(PlayerRespawnEvent event)
	{
		this.plugin.serverMethods.scoreboard(event.getPlayer());

		new BukkitRunnable()
		{
			public void run()
			{
				Player p = event.getPlayer();

				p.teleport(plugin.locations.getSpawn());

				event.getPlayer().getInventory().setItem(0, plugin.items.getKitSelector());
				event.getPlayer().getInventory().setItem(8, plugin.items.getShop());
				event.getPlayer().getInventory().setItem(5, plugin.items.getParticles());
				p.getInventory().setItem(4, plugin.items.getOptions());
			}
		}.runTaskLater(this.plugin, 5);
	}
}
