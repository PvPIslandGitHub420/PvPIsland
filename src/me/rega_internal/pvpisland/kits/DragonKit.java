package me.rega_internal.pvpisland.kits;

import me.rega_internal.pvpisland.libs.Ability;
import me.rega_internal.pvpisland.libs.Item;
import me.rega_internal.pvpisland.libs.Kit;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

public class DragonKit implements Kit
{
	public Material getIcon()
	{
		return Material.DRAGON_EGG;
	}

	public String getDisplayName()
	{
		return "Dragon";
	}

	public String[] getDescription()
	{
		return new String[] { "Fly in the sky and release your mighty roar!" };
	}

	public ItemStack[] getItems()
	{
		ItemStack sword = new Item(new ItemStack(Material.DIAMOND_SWORD)).enchantment(Enchantment.DAMAGE_ALL, 1).setName("&fSword").build();
		ItemStack wing = new Item(new ItemStack(Material.FEATHER, 1)).setName("&fWing").build();
		ItemStack gapple = new Item(new ItemStack(Material.GOLDEN_APPLE, 8)).setName("&fGolden Apple").build();
		ItemStack steak = new Item(new ItemStack(Material.COOKED_BEEF, 16)).setName("&fSteak").build();
		return new ItemStack[] { sword, wing, gapple, steak };
	}

	public ItemStack[] getArmor()
	{
		ItemStack h = new Item(new ItemStack(Material.DIAMOND_HELMET)).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).setName("&fHelmet").build();
		ItemStack c = new Item(new ItemStack(Material.DIAMOND_CHESTPLATE)).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).setName("&fChestplate").build();
		ItemStack l = new Item(new ItemStack(Material.DIAMOND_LEGGINGS)).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).setName("&fPants").build();
		ItemStack b = new Item(new ItemStack(Material.DIAMOND_BOOTS)).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).enchantment(Enchantment.PROTECTION_FALL, 2).setName("&fBoots").build();
		return new ItemStack[] { b, l, c, h };
	}

	public Ability getAbility()
	{
		return Ability.DRAGON;
	}

	public PotionEffect[] getPotions()
	{
		return null;
	}
}
