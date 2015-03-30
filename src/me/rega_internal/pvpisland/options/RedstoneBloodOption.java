package me.rega_internal.pvpisland.options;

import me.rega_internal.pvpisland.libs.Item;
import me.rega_internal.pvpisland.libs.Option;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

public class RedstoneBloodOption implements Option
{
	public Material getIcon()
	{
		return Material.REDSTONE;
	}

	public String getDisplayName()
	{
		return "Blood";
	}

	public String[] getDescription()
	{
		return new String[] { "Get a bonus blood effect when hitting someone!" };
	}

	public PotionEffect[] getPotions()
	{
		return null;
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
