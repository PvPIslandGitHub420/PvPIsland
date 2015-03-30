package me.rega_internal.pvpisland.kits;

import me.rega_internal.pvpisland.libs.Ability;
import me.rega_internal.pvpisland.libs.Item;
import me.rega_internal.pvpisland.libs.Kit;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

public class ArcherKit implements Kit
{
	public Material getIcon()
	{
		return Material.BOW;
	}

	public String getDisplayName()
	{
		return "Archer";
	}

	public String[] getDescription()
	{
		return new String[] { "Just your average ranged kit." };
	}

	public ItemStack[] getItems()
	{
		ItemStack sword = new Item(new ItemStack(Material.DIAMOND_SWORD)).enchantment(Enchantment.DAMAGE_ALL, 1).enchantment(Enchantment.KNOCKBACK, 1).setName("&fSword").build();
		ItemStack bow = new Item(new ItemStack(Material.BOW)).enchantment(Enchantment.ARROW_DAMAGE, 8).enchantment(Enchantment.ARROW_INFINITE, 1).setName("&fBow").build();
		ItemStack gapple = new Item(new ItemStack(Material.GOLDEN_APPLE, 8)).setName("&fGolden Apple").build();
		ItemStack steak = new Item(new ItemStack(Material.COOKED_BEEF, 16)).setName("&fSteak").build();
		ItemStack arrow = new Item(new ItemStack(Material.ARROW)).setName("&fArrow").build();
		return new ItemStack[] { sword, bow, gapple, steak, arrow };
	}

	public ItemStack[] getArmor()
	{
		ItemStack h = new Item(new ItemStack(Material.DIAMOND_HELMET)).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).setName("&fHelmet").build();
		ItemStack c = new Item(new ItemStack(Material.DIAMOND_CHESTPLATE)).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).setName("&fChestplate").build();
		ItemStack l = new Item(new ItemStack(Material.DIAMOND_LEGGINGS)).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).setName("&fPants").build();
		ItemStack b = new Item(new ItemStack(Material.DIAMOND_BOOTS)).enchantment(Enchantment.PROTECTION_PROJECTILE, 1).setName("&fBoots").build();
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
