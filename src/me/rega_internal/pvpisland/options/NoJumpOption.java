package me.rega_internal.pvpisland.options;

import me.rega_internal.pvpisland.libs.Item;
import me.rega_internal.pvpisland.libs.Option;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class NoJumpOption implements Option
{
	public Material getIcon()
	{
		return Material.DIAMOND_BOOTS;
	}

	public String getDisplayName()
	{
		return "No Jump";
	}

	public String[] getDescription()
	{
		return new String[] { "Try to fight other players without jumping.", "Each kill with this option awards a $25 bonus." };
	}

	public PotionEffect[] getPotions()
	{
		return new PotionEffect[] { new PotionEffect(PotionEffectType.JUMP, 999999, -5) };
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
