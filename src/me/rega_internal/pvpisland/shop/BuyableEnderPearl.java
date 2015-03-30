package me.rega_internal.pvpisland.shop;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import me.rega_internal.pvpisland.libs.Item;
import me.rega_internal.pvpisland.libs.Shop;

public class BuyableEnderPearl implements Shop
{
	public Material getIcon()
	{
		return Material.ENDER_PEARL;
	}

	public ItemStack unpurchasedIcon()
	{
		return new Item(new ItemStack(Material.INK_SACK, 1, (short) 8)).setName(ChatColor.GREEN + "Purchase for $500").build();
	}

	/** Unused */
	public ItemStack purchasedIcon()
	{
		return new Item(new ItemStack(Material.INK_SACK, 1, (short) 10)).setName(ChatColor.GREEN + "Purchased").build();
	}

	public String getDisplayName()
	{
		return "Enderpearls";
	}

	public String[] getDescription()
	{
		return new String[]
		{ "Purchase 4 Enderpearls to use during battles." };
	}
}
