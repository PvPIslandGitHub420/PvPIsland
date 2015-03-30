package me.rega_internal.pvpisland.kits.abilities;

import me.rega_internal.pvpisland.Main;

import org.bukkit.Material;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Horse.Color;
import org.bukkit.entity.Horse.Variant;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.vehicle.VehicleExitEvent;
import org.bukkit.inventory.HorseInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class RiderKitAbility implements Listener
{
	Main plugin;

	public RiderKitAbility(Main main)
	{
		this.plugin = main;
	}

	public static void spawnHorse(Player player)
	{
		Horse horse = (Horse) player.getWorld().spawn(player.getLocation(), Horse.class);
		horse.getInventory().setArmor(new ItemStack(Material.DIAMOND_BARDING));
		horse.getInventory().setSaddle(new ItemStack(Material.SADDLE));
		horse.setAdult();
		horse.setTamed(true);
		horse.setColor(Color.WHITE);
		horse.setCustomName(player.getDisplayName() + "'s Mighty Steed");
		horse.setOwner(player);
		horse.setVariant(Variant.HORSE);
		horse.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 99));
		horse.setPassenger(player);
	}

	@EventHandler
	public void getOff(VehicleExitEvent event)
	{
		Player player = (Player) event.getExited();
		if (event.getVehicle() instanceof Horse) if (this.plugin.lists.kit.containsKey(player.getName()) && this.plugin.lists.kit.get(player.getName()).equalsIgnoreCase("Rider")) event.setCancelled(true);
	}

	@EventHandler
	public void inv(InventoryClickEvent event)
	{
		if (event.getInventory() instanceof HorseInventory) if (event.getInventory().getTitle().endsWith("Steed")) event.setCancelled(true);
	}

	@EventHandler
	public void death(PlayerDeathEvent event)
	{
		Player player = event.getEntity();
		if (player.isInsideVehicle())
		{
			Horse horse = (Horse) player.getVehicle();
			horse.remove();
		}
	}

	@EventHandler
	public void quit(PlayerQuitEvent event)
	{
		Player player = event.getPlayer();
		if (player.isInsideVehicle())
		{
			Horse horse = (Horse) player.getVehicle();
			horse.remove();
		}
	}
}
