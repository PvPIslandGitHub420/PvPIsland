package me.rega_internal.pvpisland.commands;

import me.rega_internal.pvpisland.Main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Repairable;
import org.bukkit.scheduler.BukkitRunnable;

public class CommandRepair implements CommandExecutor
{
	Main plugin;

	public CommandRepair(Main main)
	{
		this.plugin = main;
	}

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		if (command.getName().equalsIgnoreCase("repair"))
		{
			if (!(sender instanceof Player))
			{
				sender.sendMessage(this.plugin.strings.consoleSender("repair"));
				return false;
			}
			else
			{
				Player player = (Player) sender;
				if (this.plugin.economy.getBalance(player.getName()) >= 75.0D)
				{
					if (!this.plugin.lists.repairCooldown.contains(player.getName()))
					{
						this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&6Your items have been repaired for $75.00");
						this.plugin.economy.withdrawPlayer(player.getName(), 75.0D);
						this.plugin.lists.repairCooldown.add(player.getName());
						if (player.getInventory().getContents() != null)
						{
							for (ItemStack item : player.getInventory().getContents())
							{
								if (item instanceof Repairable) item.setDurability((short) -1000);
							}
						}
						if (player.getEquipment().getArmorContents() != null)
						{
							for (ItemStack armor : player.getEquipment().getArmorContents())
							{
								if (armor instanceof Repairable) armor.setDurability((short) -1000);
							}
						}
						new BukkitRunnable()
						{
							public void run()
							{
								plugin.lists.repairCooldown.remove(player.getName());
								plugin.playerMethods.message(player, plugin.strings.prefix() + "&aYou may now use \"/repair\"");
							}
						}.runTaskLater(this.plugin, 20 * 60);
					}
					else
					{
						this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&cRepair is still on cooldown.");
					}
				}
				else
				{
					this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&cYou do not have enough money!");
				}
			}
		}
		return true;
	}
}
