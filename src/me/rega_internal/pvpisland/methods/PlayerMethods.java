package me.rega_internal.pvpisland.methods;

import me.rega_internal.pvpisland.Main;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import com.sk89q.worldguard.protection.regions.ProtectedRegion;

public class PlayerMethods
{
	Main plugin;

	public PlayerMethods(Main main)
	{
		this.plugin = main;
	}

	public void message(Player player, String string)
	{
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', string));
	}

	public void clear(Player player)
	{
		player.getInventory().clear();
		player.getInventory().setArmorContents(null);
		for (PotionEffect pe : player.getActivePotionEffects())
			player.removePotionEffect(pe.getType());
		player.setFoodLevel(20);
		player.setHealth(20);
		player.setFireTicks(0);
		player.setExp(0);
		player.setLevel(0);
		player.setGameMode(GameMode.ADVENTURE);
	}

	public void clearForKit(Player player)
	{
		for (ItemStack items : player.getInventory().getContents())
		{
			if (items == this.plugin.items.getKitSelector() || items == this.plugin.items.getOptions() || items == this.plugin.items.getParticles() || items == this.plugin.items.getShop())
			{
				player.getInventory().removeItem(items);
			}
		}
		player.updateInventory();
		player.getInventory().setArmorContents(null);
		for (PotionEffect pe : player.getActivePotionEffects())
			player.removePotionEffect(pe.getType());
		player.setFoodLevel(20);
		player.setHealth(20);
		player.setFireTicks(0);
		player.setExp(0);
		player.setLevel(0);
		player.setGameMode(GameMode.ADVENTURE);
	}

	public void clearKit(Player player)
	{
		this.plugin.lists.kit.remove(player.getName());
		this.plugin.lists.cooldown.remove(player.getName());
		this.plugin.lists.optionJesus.remove(player.getName());
		this.plugin.lists.optionBlood.remove(player.getName());
		this.plugin.lists.optionNoHunger.remove(player.getName());
		this.plugin.lists.optionNoJump.remove(player.getName());
	}

	@SuppressWarnings("deprecation")
	public double getBalance(Player player)
	{
		return this.plugin.economy.getBalance(player.getName());
	}

	public String getRank(Player player)
	{
		return this.plugin.permissions.getPrimaryGroup(player);
	}

	public boolean isStaff(Player player)
	{
		if (this.plugin.strings.getStaffRanks().contains(getRank(player)))
		{
			return true;
		} else
		{
			return false;
		}
	}

	public boolean isDonor(Player player)
	{
		if (this.plugin.strings.getDonorRanks().contains(getRank(player)))
		{
			return true;
		} else
		{
			return false;
		}
	}

	public boolean isInSpawn(Player player)
	{
		ProtectedRegion spawn = this.plugin.getWorldGuard().getRegionManager(player.getWorld()).getRegion("spawn");
		if (spawn.contains(player.getLocation().getBlockX(), player.getLocation().getBlockY(), player.getLocation().getBlockZ()))
		{
			return true;
		} else
		{
			return false;
		}
	}
}
