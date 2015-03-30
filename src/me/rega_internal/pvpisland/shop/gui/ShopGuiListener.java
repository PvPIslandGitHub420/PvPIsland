package me.rega_internal.pvpisland.shop.gui;

import me.rega_internal.pvpisland.Main;
import me.rega_internal.pvpisland.libs.Item;
import me.rega_internal.pvpisland.shop.DoubleJumpBuyable;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class ShopGuiListener implements Listener
{

	Main plugin;

	public ShopGuiListener(Main main)
	{
		this.plugin = main;
	}

	@EventHandler
	public void click(PlayerInteractEvent event)
	{
		Player p = event.getPlayer();
		if (p.getItemInHand().getType() == Material.GOLD_INGOT)
		{
			if (event.getAction() == Action.RIGHT_CLICK_AIR || (event.getAction() == Action.RIGHT_CLICK_BLOCK))
			{
				event.setCancelled(true);
				p.chat("/shop");
			}
		}
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void click(InventoryClickEvent event)
	{
		Player player = (Player) event.getWhoClicked();
		if (event.getInventory().getTitle().equalsIgnoreCase("Shop"))
		{
			event.setCancelled(true);
			if (event.getSlot() == 18)
			{
				if (this.plugin.economy.getBalance(player.getName()) < 1500.0D)
				{
					this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&cYou do not have enough money to purchase this.");
				} else
				{
					this.plugin.lists.shopDoubleJump.add(player.getName());
					this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&aDouble Jump succesfully purchased for $1500!");
					event.getInventory().setItem(18, new DoubleJumpBuyable().purchasedIcon());
					this.plugin.economy.withdrawPlayer(player, 1500.0D);
				}
			}

			if (event.getSlot() == 19)
			{
				if (this.plugin.economy.getBalance(player.getName()) < 500.0D)
				{
					this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&cYou do not have enough money to purchase this.");
				} else
				{
					player.getInventory().addItem(new Item(new ItemStack(Material.ENDER_PEARL, 4)).setName("&dEnder Pearl").build());
					this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&aYou purchased 4 Ender Pearls for $500.");
					this.plugin.economy.withdrawPlayer(player, 500.0D);
				}
			}

			if (event.getSlot() == 20)
			{
				if (this.plugin.economy.getBalance(player.getName()) < 750.0D)
				{
					this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&cYou do not have enough money to purchase this.");
				} else
				{
					player.getInventory().addItem(new Item(new ItemStack(Material.STICK, 1)).setName("&cGrandpa Stick").enchantment(Enchantment.KNOCKBACK, 4).build());
					this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&aYou purchased a Grandpa Stick for $750.");
					this.plugin.economy.withdrawPlayer(player, 750.0D);
				}
			}
		}
	}
}
