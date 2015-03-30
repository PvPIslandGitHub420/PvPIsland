package me.rega_internal.pvpisland.particles;

import me.rega_internal.pvpisland.libs.Item;
import me.rega_internal.pvpisland.libs.Particle;
import me.rega_internal.pvpisland.libs.ParticleEffect;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class EnderFeetParticle implements Particle
{
	public Material getIcon()
	{
		return Material.DRAGON_EGG;
	}

	public String getDisplayName()
	{
		return "EnderFeet";
	}

	public String[] getDescription()
	{
		return new String[] { "Ender particles appear when you walk" };
	}

	public ItemStack disabledIcon()
	{
		return new Item(new ItemStack(Material.INK_SACK, 1, (short) 8)).setName(ChatColor.RED + "Disabled").build();
	}

	public ItemStack enabledIcon()
	{
		return new Item(new ItemStack(Material.INK_SACK, 1, (short) 10)).setName(ChatColor.GREEN + "Enabled").build();
	}

	public ParticleEffect getParticle()
	{
		return null;
	}
}
