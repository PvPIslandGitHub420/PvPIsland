package me.rega_internal.pvpisland.commands;

import me.rega_internal.pvpisland.Main;
import me.rega_internal.pvpisland.libs.Item;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class CommandSoup implements CommandExecutor
{
	Main plugin;

	public CommandSoup(Main main)
	{
		this.plugin = main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if (cmd.getName().equalsIgnoreCase("soup"))
		{
			if (!(sender instanceof Player))
			{
				sender.sendMessage(this.plugin.strings.consoleSender("soup"));
				return false;
			}
			else
			{
				Player p = (Player) sender;
				if (p.hasPermission(this.plugin.strings.permissionPrefix("command.soup")))
				{
					if (!this.plugin.lists.soupCooldown.contains(p.getName()))
					{
						this.plugin.lists.soupCooldown.add(p.getName());
						Inventory inv = Bukkit.createInventory(p, 36, "Refill");

						for (int i = 0; i < 37; i++)
							inv.addItem(new Item(new ItemStack(Material.MUSHROOM_SOUP, 1)).setName("&fSoup").build());

						p.openInventory(inv);
						new BukkitRunnable()
						{
							public void run()
							{
								plugin.lists.soupCooldown.remove(p.getName());
								plugin.playerMethods.message(p, plugin.strings.prefix() + "&aYou may now use \"/soup\"");
							}
						}.runTaskLater(this.plugin, 20 * 30);
					}
					else
					{
						this.plugin.playerMethods.message(p, this.plugin.strings.prefix() + "&cSoup is still on cooldown.");
					}
				}
				else
				{
					this.plugin.playerMethods.message(p, this.plugin.strings.noPermission());
				}
			}
		}
		return true;
	}
}
