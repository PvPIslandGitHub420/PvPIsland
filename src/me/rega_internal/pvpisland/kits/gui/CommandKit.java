package me.rega_internal.pvpisland.kits.gui;

import me.rega_internal.pvpisland.Main;
import me.rega_internal.pvpisland.kits.newones.DefaultKitNew;
import me.rega_internal.pvpisland.kits.newones.Tier1DonorKitNew;
import me.rega_internal.pvpisland.kits.newones.Tier2DonorKit;
import me.rega_internal.pvpisland.kits.newones.Tier3DonorKit;
import me.rega_internal.pvpisland.kits.newones.Tier4DonorKit;
import me.rega_internal.pvpisland.libs.Item;
import me.rega_internal.pvpisland.libs.Kit;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class CommandKit implements CommandExecutor
{
	Main plugin;

	public CommandKit(Main main)
	{
		this.plugin = main;
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		if (command.getName().equalsIgnoreCase("kit"))
		{
			if (!(sender instanceof Player))
			{
				sender.sendMessage(this.plugin.strings.consoleSender("kit"));
				return false;
			}
			else
			{
				Player player = (Player) sender;
				if (this.plugin.lists.kit.containsKey(player.getName()))
				{
					this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&cYou already have a kit selected!");
				}
				else
				{
					Inventory inv = Bukkit.createInventory(player, 27, "Kit Selector");

					ItemStack placeholder = new Item(new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15)).setName(" ").build();

					for (int i = 0; i < 10; i++)
						inv.setItem(i, placeholder);
					for (int i = 17; i < 27; i++)
						inv.setItem(i, placeholder);

					Kit k1 = new DefaultKitNew();
					inv.setItem(11, new Item(new ItemStack(k1.getIcon(), 1)).setName(ChatColor.WHITE.toString() + ChatColor.BOLD + k1.getDisplayName()).setLore(k1.getDescription()).build());
					Kit k5 = new Tier1DonorKitNew();
					inv.setItem(12, new Item(new ItemStack(k5.getIcon(), 1)).setName(ChatColor.GREEN.toString() + ChatColor.BOLD + k5.getDisplayName()).setLore(k5.getDescription()).build());
					Kit k2 = new Tier2DonorKit();
					inv.setItem(13, new Item(new ItemStack(k2.getIcon(), 1)).setName(ChatColor.GOLD.toString() + ChatColor.BOLD + k2.getDisplayName()).setLore(k2.getDescription()).build());
					Kit k3 = new Tier3DonorKit();
					inv.setItem(14, new Item(new ItemStack(k3.getIcon(), 1)).setName(ChatColor.BLUE.toString() + ChatColor.BOLD + k3.getDisplayName()).setLore(k3.getDescription()).build());
					Kit k4 = new Tier4DonorKit();
					inv.setItem(15, new Item(new ItemStack(k4.getIcon(), 1)).setName(ChatColor.LIGHT_PURPLE.toString() + ChatColor.BOLD.toString() + ChatColor.ITALIC + k4.getDisplayName()).setLore(k4.getDescription()).build());

					// Kit k1 = new DefaultKit();
					// inv.addItem(new Item(new ItemStack(k1.getIcon(),
					// 1)).setName(ChatColor.GOLD.toString() + ChatColor.BOLD +
					// k1.getDisplayName()).setLore(k1.getDescription()).build());
					//
					// Kit k2 = new ArcherKit();
					// inv.addItem(new Item(new ItemStack(k2.getIcon(),
					// 1)).setName(ChatColor.GOLD.toString() + ChatColor.BOLD +
					// k2.getDisplayName()).setLore(k2.getDescription()).build());
					//
					// Kit k3 = new RiderKit();
					// inv.addItem(new Item(new ItemStack(k3.getIcon(),
					// 1)).setName(ChatColor.GOLD.toString() + ChatColor.BOLD +
					// k3.getDisplayName()).setLore(k3.getDescription()).build());
					//
					// Kit k4 = new StomperKit();
					// inv.addItem(new Item(new ItemStack(k4.getIcon(),
					// 1)).setName(ChatColor.GOLD.toString() + ChatColor.BOLD +
					// k4.getDisplayName()).setLore(k4.getDescription()).build());
					//
					// Kit k5 = new FishermanKit();
					// inv.addItem(new Item(new ItemStack(k5.getIcon(),
					// 1)).setName(ChatColor.GOLD.toString() + ChatColor.BOLD +
					// k5.getDisplayName()).setLore(k5.getDescription()).build());
					//
					// Kit k6 = new SwitcherKit();
					// inv.addItem(new Item(new ItemStack(k6.getIcon(),
					// 1)).setName(ChatColor.GOLD.toString() + ChatColor.BOLD +
					// k6.getDisplayName()).setLore(k6.getDescription()).build());
					//
					// Kit k7 = new HyperKit();
					// inv.addItem(new Item(new ItemStack(k7.getIcon(),
					// 1)).setName(ChatColor.GOLD.toString() + ChatColor.BOLD +
					// k7.getDisplayName()).setLore(k7.getDescription()).build());
					//
					// Kit k8 = new PoseidonKit();
					// inv.addItem(new Item(new ItemStack(k8.getIcon(),
					// 1)).setName(ChatColor.GOLD.toString() + ChatColor.BOLD +
					// k8.getDisplayName()).setLore(k8.getDescription()).build());
					//
					// Kit k9 = new DragonKit();
					// inv.addItem(new Item(new ItemStack(k9.getIcon(),
					// 1)).setName(ChatColor.GOLD.toString() + ChatColor.BOLD +
					// k9.getDisplayName()).setLore(k9.getDescription()).build());
					//
					// Kit k10 = new SpikeKit();
					// inv.addItem(new Item(new ItemStack(k10.getIcon(),
					// 1)).setName(ChatColor.GOLD.toString() + ChatColor.BOLD +
					// k10.getDisplayName()).setLore(k10.getDescription()).build());
					//
					// Kit k11 = new CharizardKit();
					// inv.addItem(new Item(new ItemStack(k11.getIcon(),
					// 1)).setName(ChatColor.GOLD.toString() + ChatColor.BOLD +
					// k11.getDisplayName()).setLore(k11.getDescription()).build());
					//
					// Kit k12 = new FatManKit();
					// inv.addItem(new Item(new ItemStack(k12.getIcon(),
					// 1)).setName(ChatColor.GOLD.toString() + ChatColor.BOLD +
					// k12.getDisplayName()).setLore(k12.getDescription()).build());
					//
					// Kit k13 = new HermitKit();
					// inv.addItem(new Item(new ItemStack(k13.getIcon(),
					// 1)).setName(ChatColor.GOLD.toString() + ChatColor.BOLD +
					// k13.getDisplayName()).setLore(k13.getDescription()).build());

					player.openInventory(inv);
				}
			}
		}
		return true;
	}
}
