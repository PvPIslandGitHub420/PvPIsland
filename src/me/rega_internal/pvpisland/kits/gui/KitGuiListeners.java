package me.rega_internal.pvpisland.kits.gui;

import me.rega_internal.pvpisland.Main;
import me.rega_internal.pvpisland.kits.newones.DefaultKitNew;
import me.rega_internal.pvpisland.kits.newones.Tier1DonorKitNew;
import me.rega_internal.pvpisland.kits.newones.Tier2DonorKit;
import me.rega_internal.pvpisland.kits.newones.Tier3DonorKit;
import me.rega_internal.pvpisland.kits.newones.Tier4DonorKit;
import me.rega_internal.pvpisland.libs.Item;
import me.rega_internal.pvpisland.libs.Kit;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class KitGuiListeners implements Listener
{
	Main plugin;

	public KitGuiListeners(Main main)
	{
		this.plugin = main;
	}

	@EventHandler
	public void click(PlayerInteractEvent event)
	{
		Player p = event.getPlayer();
		if (p.getItemInHand().getType() == Material.ENCHANTED_BOOK)
		{
			if (event.getAction() == Action.RIGHT_CLICK_AIR || (event.getAction() == Action.RIGHT_CLICK_BLOCK))
			{
				event.setCancelled(true);
				p.chat("/kit");
			}
		}
		if (p.getItemInHand().getType() == Material.GOLD_INGOT)
		{
			if (event.getAction() == Action.RIGHT_CLICK_AIR || (event.getAction() == Action.RIGHT_CLICK_BLOCK))
			{
				event.setCancelled(true);
				p.chat("/shop");
			}
		}
	}

	@EventHandler
	public void click(InventoryClickEvent event)
	{
		Player player = (Player) event.getWhoClicked();
		if (event.getInventory().getTitle().equalsIgnoreCase("Kit Selector"))
		{
			event.setCancelled(true);

			if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.WHITE.toString() + ChatColor.BOLD + "Default"))
			{
				player.closeInventory();
				this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&7You selected kit &bDefault&7.");
				this.plugin.lists.kit.put(player.getName(), "Default");
				this.plugin.playerMethods.clearForKit(player);

				Kit kit = new DefaultKitNew();
				player.getInventory().setArmorContents(kit.getArmor());
				for (ItemStack items : kit.getItems())
					player.getInventory().addItem(items);
			}

			if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN.toString() + ChatColor.BOLD + "Sailor"))
			{
				if (!player.hasPermission(this.plugin.strings.permissionPrefix("kit.sailor")))
				{
					display(player, "Sailor");
				} else
				{
					player.closeInventory();
					this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&7You selected kit &bSailor&7.");
					this.plugin.lists.kit.put(player.getName(), "Sailor");
					this.plugin.playerMethods.clearForKit(player);

					Kit kit = new Tier1DonorKitNew();
					player.getInventory().setArmorContents(kit.getArmor());
					for (ItemStack items : kit.getItems())
						player.getInventory().addItem(items);
				}
			}

			if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD.toString() + ChatColor.BOLD + "Cadet"))
			{
				if (!player.hasPermission(this.plugin.strings.permissionPrefix("kit.cadet")))
				{
					display(player, "Cadet");
				} else
				{
					player.closeInventory();
					this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&7You selected kit &bCadet&7.");
					this.plugin.lists.kit.put(player.getName(), "Cadet");
					this.plugin.playerMethods.clearForKit(player);

					Kit kit = new Tier2DonorKit();
					player.getInventory().setArmorContents(kit.getArmor());
					for (ItemStack items : kit.getItems())
						player.getInventory().addItem(items);
				}
			}

			if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.BLUE.toString() + ChatColor.BOLD + "Pirate"))
			{
				if (!player.hasPermission(this.plugin.strings.permissionPrefix("kit.pirate")))
				{
					display(player, "Pirate");
				} else
				{
					player.closeInventory();
					this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&7You selected kit &bPirate&7.");
					this.plugin.lists.kit.put(player.getName(), "Pirate");
					this.plugin.playerMethods.clearForKit(player);

					Kit kit = new Tier3DonorKit();
					player.getInventory().setArmorContents(kit.getArmor());
					for (ItemStack items : kit.getItems())
						player.getInventory().addItem(items);
				}
			}

			if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.LIGHT_PURPLE.toString() + ChatColor.BOLD.toString() + ChatColor.ITALIC + "Captain"))
			{
				if (!player.hasPermission(this.plugin.strings.permissionPrefix("kit.captain")))
				{
					display(player, "Captain");
				} else
				{
					player.closeInventory();
					this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&7You selected kit &bCaptain&7.");
					this.plugin.lists.kit.put(player.getName(), "Captain");
					this.plugin.playerMethods.clearForKit(player);

					Kit kit = new Tier4DonorKit();
					player.getInventory().setArmorContents(kit.getArmor());
					for (ItemStack items : kit.getItems())
						player.getInventory().addItem(items);
				}
			}
		}
	}

	private void display(Player player, String kit)
	{
		Inventory inv = Bukkit.createInventory(player, 36, "Kit " + kit);

		ItemStack placeholder = new Item(new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15)).setName(" ").build();

		for (int i = 0; i < 9; i++)
			inv.setItem(i, placeholder);
		for (int i = 27; i < 36; i++)
			inv.setItem(i, placeholder);

		if (kit.equalsIgnoreCase("sailor"))
		{
			Kit k = new Tier1DonorKitNew();
			for (ItemStack items : k.getItems())
				inv.addItem(items);
			for (ItemStack armor : k.getArmor())
				inv.addItem(armor);
		} else if (kit.equalsIgnoreCase("cadet"))
		{
			Kit k = new Tier2DonorKit();
			for (ItemStack items : k.getItems())
				inv.addItem(items);
			for (ItemStack armor : k.getArmor())
				inv.addItem(armor);
		} else if (kit.equalsIgnoreCase("pirate"))
		{
			Kit k = new Tier3DonorKit();
			for (ItemStack items : k.getItems())
				inv.addItem(items);
			for (ItemStack armor : k.getArmor())
				inv.addItem(armor);
		} else if (kit.equalsIgnoreCase("captain"))
		{
			Kit k = new Tier4DonorKit();
			for (ItemStack items : k.getItems())
				inv.addItem(items);
			for (ItemStack armor : k.getArmor())
				inv.addItem(armor);
		}

		player.openInventory(inv);
	}
}