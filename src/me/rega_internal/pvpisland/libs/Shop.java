package me.rega_internal.pvpisland.libs;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public interface Shop
{
	public Material getIcon();

	public ItemStack unpurchasedIcon();

	public ItemStack purchasedIcon();

	public String getDisplayName();

	public String[] getDescription();
}
