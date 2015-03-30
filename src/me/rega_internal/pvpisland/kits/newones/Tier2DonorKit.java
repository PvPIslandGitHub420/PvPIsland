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

public class Tier2DonorKit implements Kit
{
	public Material getIcon()
	{
		return Material.CHAINMAIL_CHESTPLATE;
	}

	public String getDisplayName()
	{
		return "Cadet";
	}

	public String[] getDescription()
	{
		return new String[] { "$10 Cadet Kit." };
	}

	public ItemStack[] getItems()
	{
		ItemStack sword = new Item(new ItemStack(Material.DIAMOND_SWORD)).enchantment(Enchantment.DAMAGE_ALL, 3).enchantment(Enchantment.FIRE_ASPECT, 1).setName("&6&lCadet Sword").build();
		ItemStack bow = new Item(new ItemStack(Material.BOW)).enchantment(Enchantment.ARROW_DAMAGE, 3).enchantment(Enchantment.DURABILITY, 1).setName("&6&lCadet Bow").build();
		ItemStack gapple = new Item(new ItemStack(Material.GOLDEN_APPLE, 64)).setName("&fGolden Apple").build();
		ItemStack gapple2 = new Item(new ItemStack(Material.GOLDEN_APPLE, 1, (short) 1)).setName("&bGod Apple").build();
		@SuppressWarnings("deprecation")
		Potion potion = new Potion(PotionType.INSTANT_HEAL, 2, true, false);
		ItemStack pot = potion.toItemStack(6);
		ItemStack steak = new Item(new ItemStack(Material.COOKED_BEEF, 8)).setName("&fSteak").build();
		ItemStack arrow = new Item(new ItemStack(Material.ARROW, 64)).setName("&fArrow").build();
		return new ItemStack[] { sword, bow, gapple2, gapple, steak, arrow, pot };
	}

	public ItemStack[] getArmor()
	{
		ItemStack h = new Item(new ItemStack(Material.DIAMOND_HELMET)).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).enchantment(Enchantment.DURABILITY, 2).setName("&6&lCadet Helmet").build();
		ItemStack c = new Item(new ItemStack(Material.DIAMOND_CHESTPLATE)).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).enchantment(Enchantment.DURABILITY, 2).setName("&6&lCadet Chestplate").build();
		ItemStack l = new Item(new ItemStack(Material.DIAMOND_LEGGINGS)).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).enchantment(Enchantment.DURABILITY, 2).setName("&6&lCadet Pants").build();
		ItemStack b = new Item(new ItemStack(Material.DIAMOND_BOOTS)).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3).enchantment(Enchantment.DURABILITY, 2).setName("&6&lCadet Boots").build();
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
