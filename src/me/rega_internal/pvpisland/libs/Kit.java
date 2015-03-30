package me.rega_internal.pvpisland.libs;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

public interface Kit
{
	public Material getIcon();

	public String getDisplayName();

	public String[] getDescription();

	public ItemStack[] getItems();

	public ItemStack[] getArmor();

	public PotionEffect[] getPotions();

	public Ability getAbility();
}
