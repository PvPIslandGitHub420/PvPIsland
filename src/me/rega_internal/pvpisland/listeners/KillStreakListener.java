package me.rega_internal.pvpisland.listeners;

import java.util.HashMap;
import java.util.Map;

import me.rega_internal.pvpisland.Main;
import me.rega_internal.pvpisland.libs.Item;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

public class KillStreakListener implements Listener
{
	Main plugin;
	Map<String, Integer> playerKillsForLife = new HashMap<String, Integer>();

	public KillStreakListener(Main main)
	{
		this.plugin = main;
	}

	@EventHandler
	public void killstreak(PlayerDeathEvent event)
	{
		Player player = event.getEntity().getKiller();
		if (!playerKillsForLife.containsKey(player.getName()))
		{
			playerKillsForLife.put(player.getName(), 1);
		} else
		{
			playerKillsForLife.put(player.getName(), playerKillsForLife.get(player.getName()) + 1);
		}
		if (playerKillsForLife.containsKey(event.getEntity().getName()))
			playerKillsForLife.remove(event.getEntity().getName());
		int kills = playerKillsForLife.get(player.getName());

		if (kills >= 3)
		{
			if (kills == 5)
			{
				this.plugin.serverMethods.broadcast(this.plugin.strings.prefix() + "&b" + player.getName() + " &7is " + "&bKilling Spree(5)" + "&7!");
				player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 3600, 2));
				this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&7Awarded Strength 2 for 3 Min!");
			} else if (kills == 10)
			{
				this.plugin.serverMethods.broadcast(this.plugin.strings.prefix() + "&b" + player.getName() + " &7is " + "&bRampage(10)" + "&7!");
				this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&7Awarded One Frag Grenade - 3 hearts of damage!");
				// Grenade here
			} else if (kills == 15)
			{
				this.plugin.serverMethods.broadcast(this.plugin.strings.prefix() + "&b" + player.getName() + " &7is " + "&bUnstoppable(15)" + "&7!");
				player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 4800, 1));
				player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 4800, 2));
				this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&7Awarded Strength 1, Speed 2 for 4 Min!");

			} else if (kills == 20)
			{
				this.plugin.serverMethods.broadcast(this.plugin.strings.prefix() + "&b" + player.getName() + " &7is " + "&bDominating(20)" + "&7!");
				// Smoke Bomb Here and 2 Grenades
				this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&7Awarded a Smoke Bomb and 2 Grenades!");

			} else if (kills == 35)
			{
				this.plugin.serverMethods.broadcast(this.plugin.strings.prefix() + "&b" + player.getName() + " &7is " + "&bGodlike(35)" + "&7!");
				this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&7Awarded 2 Smoke Bombs, 3 Grenades, and 1 Instant Health!");
				ItemStack item = new ItemStack(Material.POTION, 1);
				Potion pot = new Potion(1); 
				pot.setType(PotionType.INSTANT_HEAL);
				pot.setHasExtendedDuration(true);
				pot.setSplash(true);
				pot.apply(item);
				player.getInventory().addItem(item);
				
				// 2 Smoke Bomb, 3 Grenade

			} else if (kills == 50)
			{
				this.plugin.serverMethods.broadcast(this.plugin.strings.prefix() + "&b" + player.getName() + " &7is " + "&bLegendary(50)" + "&7!");
				player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 4800, 2));
				this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&7Awarded Strength 2 for 4 Min, 5 Instant Healths, and 12 GApples!");
				player.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 1));
				ItemStack item = new ItemStack(Material.POTION, 5);
				Potion pot = new Potion(1); 
				pot.setType(PotionType.INSTANT_HEAL);
				pot.setHasExtendedDuration(true);
				pot.setSplash(true);
				pot.apply(item);
				player.getInventory().addItem(item);

			} else if (kills == 75)
			{
				this.plugin.serverMethods.broadcast(this.plugin.strings.prefix() + "&b" + player.getName() + "&7is an &bExterminator(75)" + "&7!");
				// 4 FlashBangs, 2 Smokes, and 8 Grenades
				player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1200, 4));
				this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&7Awarded Strength 4 for 1 Min!");
			} else if (kills == 100)
			{
				this.plugin.serverMethods.broadcast(this.plugin.strings.prefix() + "&b" + player.getName() + "&7is causing a &Killpocalypse(100)" + "&7!");
				this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&7Awarded New Armor and new Sword plus a lil special something c:!");
				ItemStack h = new Item(new ItemStack(Material.DIAMOND_HELMET)).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4).enchantment(Enchantment.DURABILITY, 3).setName("&9&l100KS Helmet").build();
				ItemStack c = new Item(new ItemStack(Material.DIAMOND_CHESTPLATE)).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4).enchantment(Enchantment.DURABILITY, 3).setName("&9&l100KS Chestplate").build();
				ItemStack l = new Item(new ItemStack(Material.DIAMOND_LEGGINGS)).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4).enchantment(Enchantment.DURABILITY, 3).setName("&9&l100KS Pants").build();
				ItemStack b = new Item(new ItemStack(Material.DIAMOND_BOOTS)).enchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4).enchantment(Enchantment.DURABILITY, 3).setName("&9&l100KS Boots").build();
				ItemStack sword = new Item(new ItemStack(Material.DIAMOND_SWORD)).enchantment(Enchantment.DAMAGE_ALL, 3).enchantment(Enchantment.DURABILITY, 10).setName("100KS Sword").build();
				player.getInventory().setItem(0, sword);
				player.getInventory().setHelmet(h);
				player.getInventory().setChestplate(c);
				player.getInventory().setLeggings(l);
				player.getInventory().setBoots(b);
				player.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 1 , (short) 1));

			} else if (kills == 125)
			{
				this.plugin.serverMethods.broadcast(this.plugin.strings.prefix() + "&b" + player.getName() + "&7is a &bKillimanjaro(125)" + "&7!");
				this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&7Awarded some $45,000!");
				this.plugin.economy.depositPlayer(player, 45000.0D);

			} else if (kills == 150)
			{
				this.plugin.serverMethods.broadcast(this.plugin.strings.prefix() + "&b" + player.getName() + "&7is a &bKillionaire(150)" + "&7!");
				this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&7Awarded 2 God Apples and 1 Damage Pot!");
				player.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE , 2, (short) 1));
				ItemStack item = new ItemStack(Material.POTION, 1);
				Potion pot = new Potion(1); 
				pot.setType(PotionType.INSTANT_DAMAGE);
				pot.setHasExtendedDuration(true);
				pot.setSplash(true);
				pot.apply(item);
				player.getInventory().addItem(item);

			} else if (kills == 200)
			{
				this.plugin.serverMethods.broadcast(this.plugin.strings.prefix() + "&b" + player.getName() + "&7is on a &bRiot(200)" + "&7!");
				this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&7Awarded OP sword and Damage Potions!");
				ItemStack item = new ItemStack(Material.POTION, 5);
				Potion pot = new Potion(1); 
				pot.setType(PotionType.INSTANT_DAMAGE);
				pot.setHasExtendedDuration(true);
				pot.setSplash(true);
				pot.apply(item);
				player.getInventory().addItem(item);
				ItemStack sword = new Item(new ItemStack(Material.DIAMOND_SWORD)).enchantment(Enchantment.DAMAGE_ALL, 5).enchantment(Enchantment.DURABILITY, 10).enchantment(Enchantment.FIRE_ASPECT, 1).setName("200KS OP Sword").build();
				player.getInventory().setItem(0, sword);

			} else if (kills >= 215)
			{
				this.plugin.serverMethods.broadcast(this.plugin.strings.prefix() + "&b" + player.getName() + "&7is such a &bF****G BAD A**(215+) &7WE CANT COUNT HIS KILLS" + "&7!");
				this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&7Keep Going buddy, at 500 kills you will be awarded 1/2 a Million dollars");

			}else if (kills == 500){
				this.plugin.serverMethods.broadcast(this.plugin.strings.prefix() + "&b" + player.getName() + "&7is now the &bPresident(500)" + "&7!");
				this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&7Awarded 1/2 a Million dollars!");
				this.plugin.economy.depositPlayer(player, 500000.0D);
				
				
			}
		}
	}
}