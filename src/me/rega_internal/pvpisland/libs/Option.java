package me.rega_internal.pvpisland.libs;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

public interface Option
{
	public Material getIcon();

	public ItemStack disabledIcon();

	public ItemStack enabledIcon();

	public String getDisplayName();

	public String[] getDescription();

	public PotionEffect[] getPotions();
}
