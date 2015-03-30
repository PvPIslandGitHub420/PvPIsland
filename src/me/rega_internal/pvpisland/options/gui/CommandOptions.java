package me.rega_internal.pvpisland.options.gui;

import me.rega_internal.pvpisland.Main;
import me.rega_internal.pvpisland.libs.Item;
import me.rega_internal.pvpisland.libs.Option;
import me.rega_internal.pvpisland.options.JesusOption;
import me.rega_internal.pvpisland.options.NoHungerOptions;
import me.rega_internal.pvpisland.options.NoJumpOption;
import me.rega_internal.pvpisland.options.RedstoneBloodOption;
//import me.rega_internal.pvpisland.options.RedstoneBloodOption;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class CommandOptions implements CommandExecutor
{
	Main plugin;

	public CommandOptions(Main main)
	{
		this.plugin = main;
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		Player player = (Player) sender;
		if (command.getName().equalsIgnoreCase("Options"))
		{
			if (!(sender instanceof Player))
			{
				sender.sendMessage(this.plugin.strings.consoleSender("Options"));
				return false;
			}
			else
			{
				if (this.plugin.playerMethods.isDonor(player) || this.plugin.playerMethods.isStaff(player))
				{
					Inventory options = Bukkit.createInventory(player, 36, "Options");

					ItemStack placeholder = new Item(new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15)).setName(" ").build();

					for (int i = 0; i < 9; i++)
						options.setItem(i, placeholder);
					for (int i = 27; i < 36; i++)
						options.setItem(i, placeholder);

					Option o1 = new NoJumpOption();
					options.addItem(new Item(new ItemStack(o1.getIcon(), 1)).setName(ChatColor.GOLD.toString() + ChatColor.BOLD + o1.getDisplayName()).setLore(o1.getDescription()).build());
					if (this.plugin.lists.optionNoJump.contains(player.getName()))
					{
						options.setItem(18, o1.enabledIcon());
					}
					else
					{
						options.setItem(18, o1.disabledIcon());
					}

					Option o2 = new RedstoneBloodOption();
					options.addItem(new Item(new ItemStack(o2.getIcon(), 1)).setName(ChatColor.GOLD.toString() + ChatColor.BOLD + o2.getDisplayName()).setLore(o2.getDescription()).build());
					if (this.plugin.lists.optionBlood.contains(player.getName()))
					{
						options.setItem(19, o1.enabledIcon());
					}
					else
					{
						options.setItem(19, o1.disabledIcon());
					}

					Option o3 = new NoHungerOptions();
					options.addItem(new Item(new ItemStack(o3.getIcon(), 1)).setName(ChatColor.GOLD.toString() + ChatColor.BOLD + o3.getDisplayName()).setLore(o3.getDescription()).build());
					if (this.plugin.lists.optionNoHunger.contains(player.getName()))
					{
						options.setItem(20, o3.enabledIcon());
					}
					else
					{
						options.setItem(20, o3.disabledIcon());
					}

					player.openInventory(options);

					Option o4 = new JesusOption();
					options.addItem(new Item(new ItemStack(o4.getIcon(), 1)).setName(ChatColor.GOLD.toString() + ChatColor.BOLD + o4.getDisplayName()).setLore(o4.getDescription()).build());
					if (this.plugin.lists.optionJesus.contains(player.getName()))
					{
						options.setItem(21, o4.enabledIcon());
					}
					else
					{
						options.setItem(21, o4.disabledIcon());
					}

					player.openInventory(options);
				}
			}
		}
		return true;
	}
}
