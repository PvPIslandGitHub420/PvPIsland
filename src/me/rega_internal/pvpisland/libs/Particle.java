package me.rega_internal.pvpisland.libs;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public interface Particle
{
	public Material getIcon();

	public String getDisplayName();

	public String[] getDescription();

	public ParticleEffect getParticle();

	public ItemStack disabledIcon();

	public ItemStack enabledIcon();
}
