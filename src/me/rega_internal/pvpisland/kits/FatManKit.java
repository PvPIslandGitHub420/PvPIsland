package me.rega_internal.pvpisland.kits;

import me.rega_internal.pvpisland.libs.Ability;
import me.rega_internal.pvpisland.libs.Item;
import me.rega_internal.pvpisland.libs.Kit;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

public class FatManKit implements Kit
{
	public Material getIcon()
	{
		return Material.CAKE;
	}

	public String getDisplayName()
	{
		return "Fatman";
	}

	public String[] getDescription()
	{
		return new String[] { "Throw your mom's homemade cakes at people!" };
	}

	public ItemStack[] getItems()
	{
		ItemStack sword = new Item(new ItemStack(Material.DIAMOND_SWORD)).enchantment(Enchantment.DAMAGE_ALL, 1).setName("&fSword").build();
		ItemStack wing = new Item(new ItemStack(Material.FURNACE, 1)).setName("&fOven").build();
		ItemStack gapple = new Item(new ItemStack(Material.GOLDEN_APPLE, 8)).setName("&fGolden Apple").build();
		ItemStack steak = new Item(new ItemStack(Material.COOKED_BEEF, 16)).setName("&fSteak").build();
		return new ItemStack[] { sword, wing, gapple, steak };
	}

	public ItemStack[] getArmor()
	{
		ItemStack h = new Item(new ItemStack(Material.DIAMOND_HELMET)).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).setName("&fHelmet").build();
		ItemStack c = new Item(new ItemStack(Material.DIAMOND_CHESTPLATE)).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).enchantment(Enchantment.PROTECTION_EXPLOSIONS, 2).enchantment(Enchantment.DURABILITY, 1).setName("&fChestplate").build();
		ItemStack l = new Item(new ItemStack(Material.DIAMOND_LEGGINGS)).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).setName("&fPants").build();
		ItemStack b = new Item(new ItemStack(Material.DIAMOND_BOOTS)).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).setName("&fBoots").build();
		return new ItemStack[] { b, l, c, h };
	}

	public Ability getAbility()
	{
		return Ability.FATMAN;
	}

	public PotionEffect[] getPotions()
	{
		return null;
	}

}
