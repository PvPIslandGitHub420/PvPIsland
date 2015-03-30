package me.rega_internal.pvpisland.kits.newones;

import me.rega_internal.pvpisland.libs.Ability;
import me.rega_internal.pvpisland.libs.Item;
import me.rega_internal.pvpisland.libs.Kit;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionType;

public class Tier1DonorKitNew implements Kit
{
	public Material getIcon()
	{
		return Material.GOLD_CHESTPLATE;
	}

	public String getDisplayName()
	{
		return "Sailor";
	}

	public String[] getDescription()
	{
		return new String[] { "$5 Sailor Kit." };
	}

	@SuppressWarnings("deprecation")
	public ItemStack[] getItems()
	{
		ItemStack sword = new Item(new ItemStack(Material.DIAMOND_SWORD)).enchantment(Enchantment.DAMAGE_ALL, 2).setName("&a&lSailor Sword").build();
		ItemStack bow = new Item(new ItemStack(Material.BOW)).enchantment(Enchantment.ARROW_DAMAGE, 2).enchantment(Enchantment.DURABILITY, 1).setName("&a&lSailor Bow").build();
		Potion potion = new Potion(PotionType.INSTANT_HEAL, 1, true, false);
		ItemStack pot = potion.toItemStack(3);
		ItemStack gapple = new Item(new ItemStack(Material.GOLDEN_APPLE, 32)).setName("&fGolden Apple").build();
		ItemStack steak = new Item(new ItemStack(Material.COOKED_BEEF, 5)).setName("&fSteak").build();
		ItemStack arrow = new Item(new ItemStack(Material.ARROW, 64)).setName("&fArrow").build();
		return new ItemStack[] { sword, bow, pot, gapple, steak, arrow };
	}

	public ItemStack[] getArmor()
	{
		ItemStack h = new Item(new ItemStack(Material.DIAMOND_HELMET)).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).enchantment(Enchantment.DURABILITY, 1).setName("&a&lSailor Helmet").build();
		ItemStack c = new Item(new ItemStack(Material.DIAMOND_CHESTPLATE)).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).enchantment(Enchantment.DURABILITY, 1).setName("&a&lSailor Chestplate").build();
		ItemStack l = new Item(new ItemStack(Material.DIAMOND_LEGGINGS)).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).enchantment(Enchantment.DURABILITY, 1).setName("&a&lSailor Pants").build();
		ItemStack b = new Item(new ItemStack(Material.DIAMOND_BOOTS)).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).enchantment(Enchantment.DURABILITY, 1).setName("&a&lSailor Boots").build();
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
