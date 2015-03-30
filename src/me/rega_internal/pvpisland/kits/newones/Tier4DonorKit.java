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

public class Tier4DonorKit implements Kit
{
	public Material getIcon()
	{
		return Material.DIAMOND_CHESTPLATE;
	}

	public String getDisplayName()
	{
		return "Captain";
	}

	public String[] getDescription()
	{
		return new String[] { "$30 Captain Kit." };
	}

	public ItemStack[] getItems()
	{
		ItemStack sword = new Item(new ItemStack(Material.DIAMOND_SWORD)).enchantment(Enchantment.DAMAGE_ALL, 6).setName("&d&l&oCaptain Sword").build();
		ItemStack bow = new Item(new ItemStack(Material.BOW)).enchantment(Enchantment.ARROW_DAMAGE, 4).enchantment(Enchantment.DURABILITY, 2).enchantment(Enchantment.ARROW_FIRE, 2).setName("&d&l&oCaptain Bow").build();
		ItemStack gapple = new Item(new ItemStack(Material.GOLDEN_APPLE, 128)).setName("&fGolden Apple").build();
		ItemStack gapple2 = new Item(new ItemStack(Material.GOLDEN_APPLE, 4, (short) 1)).setName("&bGod Apple").build();
		@SuppressWarnings("deprecation")
		Potion potion = new Potion(PotionType.INSTANT_HEAL, 2, true, false);
		ItemStack pot = potion.toItemStack(9);
		ItemStack steak = new Item(new ItemStack(Material.COOKED_BEEF, 5)).setName("&fSteak").build();
		ItemStack arrow = new Item(new ItemStack(Material.ARROW, 64)).setName("&fArrow").build();
		return new ItemStack[] { sword, bow, gapple2, gapple, steak, arrow, pot };
	}

	public ItemStack[] getArmor()
	{
		ItemStack h = new Item(new ItemStack(Material.DIAMOND_HELMET)).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4).enchantment(Enchantment.DURABILITY, 3).enchantment(Enchantment.THORNS, 1).setName("&d&l&oCaptain Helmet").build();
		ItemStack c = new Item(new ItemStack(Material.DIAMOND_CHESTPLATE)).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4).enchantment(Enchantment.DURABILITY, 3).enchantment(Enchantment.THORNS, 1).setName("&d&l&oCaptain Chestplate").build();
		ItemStack l = new Item(new ItemStack(Material.DIAMOND_LEGGINGS)).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4).enchantment(Enchantment.DURABILITY, 3).enchantment(Enchantment.THORNS, 1).setName("&d&l&oCaptain Pants").build();
		ItemStack b = new Item(new ItemStack(Material.DIAMOND_BOOTS)).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4).enchantment(Enchantment.DURABILITY, 3).enchantment(Enchantment.THORNS, 1).enchantment(Enchantment.DEPTH_STRIDER, 3).setName("&d&l&oCaptain Boots").build();
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
