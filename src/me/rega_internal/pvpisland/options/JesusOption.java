package me.rega_internal.pvpisland.options;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import me.rega_internal.pvpisland.libs.Item;
import me.rega_internal.pvpisland.libs.Option;

public class JesusOption implements Option
{
	public Material getIcon()
	{
		return Material.PACKED_ICE;
	}

	public String getDisplayName()
	{
		return "Frozen";
	}

	public String[] getDescription()
	{
		return new String[] { "Water changes to ice when you walk on it." };
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
