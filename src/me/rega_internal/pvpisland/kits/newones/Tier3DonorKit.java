package me.rega_internal.pvpisland.kits.newones;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionType;

import me.rega_internal.pvpisland.libs.Ability;
import me.rega_internal.pvpisland.libs.Item;
import me.rega_internal.pvpisland.libs.Kit;

public class Tier3DonorKit implements Kit
{
	public Material getIcon()
	{
		return Material.IRON_CHESTPLATE;
	}

	public String getDisplayName()
	{
		return "Pirate";
	}

	public String[] getDescription()
	{
		return new String[] { "$20 Pirate Kit." };
	}

	public ItemStack[] getItems()
	{
		ItemStack sword = new Item(new ItemStack(Material.DIAMOND_SWORD)).enchantment(Enchantment.DAMAGE_ALL, 4).enchantment(Enchantment.FIRE_ASPECT, 2).setName("&9&lPirate Sword").build();
		ItemStack bow = new Item(new ItemStack(Material.BOW)).enchantment(Enchantment.ARROW_DAMAGE, 4).enchantment(Enchantment.DURABILITY, 2).enchantment(Enchantment.ARROW_FIRE, 2).setName("&9&lPirate Bow").build();
		ItemStack gapple = new Item(new ItemStack(Material.GOLDEN_APPLE, 128)).setName("&fGolden Apple").build();
		ItemStack gapple2 = new Item(new ItemStack(Material.GOLDEN_APPLE, 3, (short) 1)).setName("&bGod Apple").build();
		@SuppressWarnings("deprecation")
		Potion potion = new Potion(PotionType.INSTANT_HEAL, 2, true, false);
		ItemStack pot = potion.toItemStack(9);
		ItemStack steak = new Item(new ItemStack(Material.COOKED_BEEF, 5)).setName("&fSteak").build();
		ItemStack arrow = new Item(new ItemStack(Material.ARROW, 64)).setName("&fArrow").build();
		return new ItemStack[] { sword, bow, gapple2, gapple, steak, arrow, pot };
	}

	public ItemStack[] getArmor()
	{
		ItemStack h = new Item(new ItemStack(Material.DIAMOND_HELMET)).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4).enchantment(Enchantment.DURABILITY, 3).setName("&9&lPirate Helmet").build();
		ItemStack c = new Item(new ItemStack(Material.DIAMOND_CHESTPLATE)).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4).enchantment(Enchantment.DURABILITY, 3).setName("&9&lPirate Chestplate").build();
		ItemStack l = new Item(new ItemStack(Material.DIAMOND_LEGGINGS)).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4).enchantment(Enchantment.DURABILITY, 3).setName("&9&lPirate Pants").build();
		ItemStack b = new Item(new ItemStack(Material.DIAMOND_BOOTS)).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4).enchantment(Enchantment.DURABILITY, 3).enchantment(Enchantment.DEPTH_STRIDER, 2).setName("&9&lPirate Boots").build();
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
