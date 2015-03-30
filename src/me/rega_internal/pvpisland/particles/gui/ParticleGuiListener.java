package me.rega_internal.pvpisland.particles.gui;

import me.rega_internal.pvpisland.Main;
import me.rega_internal.pvpisland.libs.ParticleEffect;
import me.rega_internal.pvpisland.particles.EnderFeetParticle;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class ParticleGuiListener implements Listener
{
	Main plugin;

	public ParticleGuiListener(Main main)
	{
		this.plugin = main;
	}

	@EventHandler
	public void click(PlayerInteractEvent event)
	{
		Player p = event.getPlayer();
		if (p.getItemInHand().getType() == Material.SEEDS)
		{
			if (event.getAction() == Action.RIGHT_CLICK_AIR || (event.getAction() == Action.RIGHT_CLICK_BLOCK))
			{
				if (this.plugin.playerMethods.isDonor(p) || this.plugin.playerMethods.isStaff(p))
				{
					event.setCancelled(true);
					p.chat("/particles");

				}
				else
				{
					event.setCancelled(true);
					this.plugin.playerMethods.message(p, this.plugin.strings.prefix() + "&cPlease donate to obtain these features.");
				}
			}
		}
	}

	@EventHandler
	public void click(InventoryClickEvent event)
	{
		Player player = (Player) event.getWhoClicked();
		if (event.getInventory().getTitle().equalsIgnoreCase("Particles"))
		{
			event.setCancelled(true);
			if (event.getSlot() == 18)
			{
				if (this.plugin.lists.hasParticle.contains(player.getName()))
				{
					this.plugin.lists.hasParticle.remove(player.getName());
					this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&cEnderFeet Particle is now disabled");
					event.getInventory().setItem(18, new EnderFeetParticle().disabledIcon());
				}
				else
				{
					this.plugin.lists.hasParticle.add(player.getName());
					this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&aEnderFeet Particle is now enabled");
					event.getInventory().setItem(18, new EnderFeetParticle().enabledIcon());
					this.display(player);
				}
			}

		}
	}

	public void display(Player player)
	{
		new BukkitRunnable()
		{
			public void run()
			{
				if (plugin.lists.hasParticle.contains(player.getName()))
				{
					ParticleEffect.PORTAL.display(0, (float) 0.3, 0, (float) 0.2, 40, player.getLocation(), 20);
				}
			}
		}.runTaskTimer(this.plugin, 0, 10);
	}
}
