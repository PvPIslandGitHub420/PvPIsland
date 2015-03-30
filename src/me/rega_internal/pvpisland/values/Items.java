package me.rega_internal.pvpisland.values;

import me.rega_internal.pvpisland.Main;
import me.rega_internal.pvpisland.libs.Item;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Items
{
	Main plugin;

	public Items(Main main)
	{
		this.plugin = main;
	}

	public ItemStack getKitSelector()
	{
		return new Item(new ItemStack(Material.ENCHANTED_BOOK)).setName("&a&lKit Selector").build();
	}

	public ItemStack getShop()
	{
		return new Item(new ItemStack(Material.GOLD_INGOT)).setName("&e&lShop").build();
	}

	public ItemStack getOptions()
	{
		return new Item(new ItemStack(Material.ENCHANTMENT_TABLE)).setName("&c&lOptions &7(Donors Only)").build();
	}
	public ItemStack getParticles()
	{
		return new Item(new ItemStack(Material.SEEDS)).setName("&b&lParticles &7(Donors Only)").build();
	}

}
