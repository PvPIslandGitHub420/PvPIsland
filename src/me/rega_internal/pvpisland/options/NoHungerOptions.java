package me.rega_internal.pvpisland.options;

import me.rega_internal.pvpisland.libs.Item;
import me.rega_internal.pvpisland.libs.Option;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class NoHungerOptions implements Option
{
	public Material getIcon()
	{
		return Material.COOKED_CHICKEN;
	}

	public String getDisplayName()
	{
		return "No Hunger";
	}

	public String[] getDescription()
	{
		return new String[] { "Disable your hunger so you don't have to eat!" };
	}

	public PotionEffect[] getPotions()
	{
		return new PotionEffect[] { new PotionEffect(PotionEffectType.SATURATION, Integer.MAX_VALUE, 99) };
	}
	
	public ItemStack disabledIcon()
	{
		return new Item(new ItemStack(Material.INK_SACK, 1, (short) 8)).setName(ChatColor.RED + "Disabled").build();
	}

	public ItemStack enabledIcon()
	{
		return new Item(new ItemStack(Material.INK_SACK, 1, (short) 10)).setName(ChatColor.GREEN + "Enabled").build();
	}
}
