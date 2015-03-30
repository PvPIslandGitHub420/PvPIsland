package me.rega_internal.pvpisland.shop;

import me.rega_internal.pvpisland.libs.Item;
import me.rega_internal.pvpisland.libs.Shop;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class BuyableGrandpaStick implements Shop
{
	public Material getIcon()
	{
		return Material.STICK;
	}

	public ItemStack unpurchasedIcon()
	{
		return new Item(new ItemStack(Material.INK_SACK, 1, (short) 8)).setName(ChatColor.GREEN + "Purchase for $750").build();
	}

	/** Unused */
	public ItemStack purchasedIcon()
	{
		return new Item(new ItemStack(Material.INK_SACK, 1, (short) 10)).setName(ChatColor.GREEN + "Purchased").build();
	}

	public String getDisplayName()
	{
		return "Grandpa Stick";
	}

	public String[] getDescription()
	{
		return new String[]
		{ "Knock people off cliffs or into lava!" };
	}
}
