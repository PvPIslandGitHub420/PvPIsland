package me.rega_internal.pvpisland.particles.gui;

import me.rega_internal.pvpisland.Main;
import me.rega_internal.pvpisland.libs.Item;
import me.rega_internal.pvpisland.libs.Particle;
import me.rega_internal.pvpisland.particles.EnderFeetParticle;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class CommandParticles implements CommandExecutor
{
	Main plugin;

	public CommandParticles(Main main)
	{
		this.plugin = main;
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		Player player = (Player) sender;
		if (command.getName().equalsIgnoreCase("particles"))
		{
			if (!(sender instanceof Player))
			{
				sender.sendMessage(this.plugin.strings.consoleSender("particles"));
				return false;
			}
			else
			{
				if (this.plugin.playerMethods.isDonor(player) || this.plugin.playerMethods.isStaff(player))
				{
					Inventory particles = Bukkit.createInventory(player, 36, "Particles");

					ItemStack placeholder = new Item(new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15)).setName(" ").build();

					for (int i = 0; i < 9; i++)
						particles.setItem(i, placeholder);
					for (int i = 27; i < 36; i++)
						particles.setItem(i, placeholder);

					Particle p1 = new EnderFeetParticle();
					particles.addItem(new Item(new ItemStack(p1.getIcon(), 1)).setName(ChatColor.GOLD.toString() + ChatColor.BOLD + p1.getDisplayName()).setLore(p1.getDescription()).build());
					if (this.plugin.lists.hasParticle.contains(player.getName()))
					{
						particles.setItem(18, p1.enabledIcon());
					}
					else
					{
						particles.setItem(18, p1.disabledIcon());
					}
					player.openInventory(particles);

				}
			}
		}
		return true;
	}
}
