package me.rega_internal.pvpisland.libs;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class Item
{
	ItemStack itemStack;
	String name;
	String[] lore;
	Color color;
	boolean unbreakable;

	public Item(ItemStack item)
	{
		this.itemStack = item;
	}

	public Item setName(String s)
	{
		this.name = s;
		return this;
	}

	public Item setLore(String[] s)
	{
		this.lore = s;
		return this;
	}

	public Item setColor(Color c)
	{
		this.color = c;
		return this;
	}

	public Color getColor()
	{
		return this.color;
	}

	public Item enchantment(Enchantment e, int i)
	{
		this.itemStack.addUnsafeEnchantment(e, i);
		return this;
	}

	public void unbreakable()
	{
		this.unbreakable = true;
	}

	public boolean isUnbreakable()
	{
		if (this.unbreakable = true)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public ItemStack build()
	{
		List<String> l = new ArrayList<String>();
		if (this.color != null)
		{
			LeatherArmorMeta lam = (LeatherArmorMeta) this.itemStack.getItemMeta();
			lam.setColor(getColor());
			if (this.name != null) lam.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.name));
			if (this.lore != null)
			{
				for (String s : this.lore)
				{
					l.add(ChatColor.translateAlternateColorCodes('&', s));
					lam.setLore(l);
				}
			}
			this.itemStack.setItemMeta(lam);
		}
		else
		{
			ItemMeta meta = this.itemStack.getItemMeta();
			if (this.name != null) meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.name));
			if (this.lore != null)
			{
				for (String s : this.lore)
				{
					l.add(ChatColor.translateAlternateColorCodes('&', s));
					meta.setLore(l);
				}
			}
			this.itemStack.setItemMeta(meta);
		}
		l.clear();
		return this.itemStack;
	}
}
