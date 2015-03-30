package me.rega_internal.pvpisland.shop.gui;

import me.rega_internal.pvpisland.Main;
import me.rega_internal.pvpisland.libs.Item;
import me.rega_internal.pvpisland.libs.Shop;
import me.rega_internal.pvpisland.shop.BuyableEnderPearl;
import me.rega_internal.pvpisland.shop.BuyableGrandpaStick;
import me.rega_internal.pvpisland.shop.DoubleJumpBuyable;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class CommandShop implements CommandExecutor
{

	Main plugin;

	public CommandShop(Main main)
	{
		this.plugin = main;
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		Player player = (Player) sender;
		if (command.getName().equalsIgnoreCase("shop"))
		{
			if (!(sender instanceof Player))
			{
				sender.sendMessage(this.plugin.strings.consoleSender("shop"));
				return false;
			} else
			{
				Inventory shop = Bukkit.createInventory(player, 36, "Shop");

				ItemStack placeholder = new Item(new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15)).setName(" ").build();

				for (int i = 0; i < 9; i++)
					shop.setItem(i, placeholder);
				for (int i = 27; i < 36; i++)
					shop.setItem(i, placeholder);

				Shop s1 = new DoubleJumpBuyable();
				shop.addItem(new Item(new ItemStack(s1.getIcon(), 1)).setName(ChatColor.GOLD.toString() + ChatColor.BOLD + s1.getDisplayName()).setLore(s1.getDescription()).build());
				if (this.plugin.lists.shopDoubleJump.contains(player.getName()))
				{
					shop.setItem(18, s1.purchasedIcon());
				} else
				{
					shop.setItem(18, s1.unpurchasedIcon());
				}

				Shop s3 = new BuyableEnderPearl();
				shop.addItem(new Item(new ItemStack(s3.getIcon(), 1)).setName(ChatColor.GOLD.toString() + ChatColor.BOLD + s3.getDisplayName()).setLore(s3.getDescription()).build());
				shop.setItem(19, s3.unpurchasedIcon());

				Shop s4 = new BuyableGrandpaStick();
				shop.addItem(new Item(new ItemStack(s4.getIcon(), 1)).setName(ChatColor.GOLD.toString() + ChatColor.BOLD + s4.getDisplayName()).setLore(s4.getDescription()).build());
				shop.setItem(20, s4.unpurchasedIcon());

				player.openInventory(shop);
			}
		}
		return true;
	}

}
