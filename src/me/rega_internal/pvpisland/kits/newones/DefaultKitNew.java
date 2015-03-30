package me.rega_internal.pvpisland.kits.newones;

import me.rega_internal.pvpisland.libs.Ability;
import me.rega_internal.pvpisland.libs.Item;
import me.rega_internal.pvpisland.libs.Kit;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

public class DefaultKitNew implements Kit
{
	public Material getIcon()
	{
		return Material.LEATHER_CHESTPLATE;
	}

	public String getDisplayName()
	{
		return "Default";
	}

	public String[] getDescription()
	{
		return new String[] { "The most basic kit." };
	}

	public ItemStack[] getItems()
	{
		ItemStack sword = new Item(new ItemStack(Material.DIAMOND_SWORD)).setName("&fDefault Sword").build();
		ItemStack bow = new Item(new ItemStack(Material.BOW)).setName("&fBow").build();
		ItemStack gapple = new Item(new ItemStack(Material.GOLDEN_APPLE, 4)).setName("&fGolden Apple").build();
		ItemStack steak = new Item(new ItemStack(Material.COOKED_BEEF, 5)).setName("&fSteak").build();
		ItemStack arrow = new Item(new ItemStack(Material.ARROW, 64)).setName("&fArrow").build();
		return new ItemStack[] { sword, bow, gapple, steak, arrow };
	}

	public ItemStack[] getArmor()
	{
		ItemStack h = new Item(new ItemStack(Material.DIAMOND_HELMET)).setName("&fDefault Helmet").build();
		ItemStack c = new Item(new ItemStack(Material.DIAMOND_CHESTPLATE)).setName("&fDefault Chestplate").build();
		ItemStack l = new Item(new ItemStack(Material.DIAMOND_LEGGINGS)).setName("&fDefault Pants").build();
		ItemStack b = new Item(new ItemStack(Material.DIAMOND_BOOTS)).setName("&fDefault Boots").build();
		return new ItemStack[] { b, l, c, h };
	}

	public Ability getAbility()
	{
		return Ability.NONE;
	}

	public PotionEffect[] getPotions()
	{
		return null;
	}
}
