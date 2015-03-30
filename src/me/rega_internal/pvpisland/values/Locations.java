package me.rega_internal.pvpisland.values;

import me.rega_internal.pvpisland.Main;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class Locations
{
	Main plugin;

	public Locations(Main main)
	{
		this.plugin = main;
	}

	public Location convert(String world, double x, double y, double z, float yaw, float pitch)
	{
		return new Location(Bukkit.getWorld(world), x, y, z, yaw, pitch);
	}

	public Location getSpawn()
	{
		String prefix = "Locations.Spawn.";
		return convert(this.plugin.getConfig().getString(prefix + "World"), this.plugin.getConfig().getDouble(prefix + "X"), this.plugin.getConfig().getDouble(prefix + "Y"), this.plugin.getConfig().getDouble(prefix + "Z"), this.plugin.getConfig().getInt(prefix + "Yaw"), this.plugin.getConfig()
				.getInt(prefix + "Pitch"));
	}
}
