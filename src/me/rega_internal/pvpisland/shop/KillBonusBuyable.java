package me.rega_internal.pvpisland.shop;

import me.rega_internal.pvpisland.libs.Item;
import me.rega_internal.pvpisland.libs.Shop;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

public class KillBonusBuyable implements Shop
{
	
	public Material getIcon()
	{
		return Material.SKULL;
	}

	public String getDisplayName()
	{
		return "Kill Bonus";
	}

	public String[] getDescription()
	{
		return new String[] { "Get Strength and Nausa for 5 seconds" , " after murdering someone" };
	}

	public PotionEffect[] getPotions()
	{
		return null;
		
	}

	public ItemStack unpurchasedIcon()
	{
		return new Item(new ItemStack(Material.INK_SACK, 1, (short) 8)).setName(ChatColor.RED + "Not Purchased").build();
	}

	public ItemStack purchasedIcon()
	{
		return new Item(new ItemStack(Material.INK_SACK, 1, (short) 10)).setName(ChatColor.GREEN + "Purchased").build();
	}

}
