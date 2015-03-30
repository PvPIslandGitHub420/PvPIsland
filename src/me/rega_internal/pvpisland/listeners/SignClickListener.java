package me.rega_internal.pvpisland.listeners;

import java.util.ArrayList;
import java.util.List;

import me.rega_internal.pvpisland.Main;
import me.rega_internal.pvpisland.kits.newones.DefaultKitNew;
import me.rega_internal.pvpisland.libs.Kit;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class SignClickListener implements Listener
{
	Main plugin;

	public SignClickListener(Main main)
	{
		this.plugin = main;
	}

	List<String> cooldown = new ArrayList<String>();

	@EventHandler
	public void sign(PlayerInteractEvent e)
	{
		Player p = e.getPlayer();
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.LEFT_CLICK_BLOCK)
		{
			if (e.getClickedBlock().getType() == Material.WALL_SIGN || e.getClickedBlock().getType() == Material.SIGN_POST)
			{
				Sign sign = (Sign) e.getClickedBlock().getState();
				if (sign.getLine(0).equalsIgnoreCase(ChatColor.GREEN + "Free God Apple"))
				{
					if (this.cooldown.contains(p.getName()))
					{
						e.setCancelled(true);
						this.plugin.playerMethods.message(p, this.plugin.strings.prefix() + "&cYou can't recieve another god apple right now!");
					}
					else
					{
						this.cooldown.add(p.getName());

						ItemStack gapple = new ItemStack(Material.GOLDEN_APPLE, 1, (short) 1);
						p.getInventory().addItem(gapple);
					}
					new BukkitRunnable()
					{

						public void run()
						{
							if (cooldown.contains(p.getName()) && cooldown.contains(p.getName()))
							{
								cooldown.remove(p.getName());
							}
						}
					}.runTaskLater(this.plugin, (20 * 60) * 60);
				}
			}
		}
	}

	@EventHandler
	public void signchange4(SignChangeEvent e)
	{
		if (e.getLine(0).equalsIgnoreCase("cum"))
		{
			e.setLine(0, org.bukkit.ChatColor.BLACK.toString() + ChatColor.BOLD.toString() + ChatColor.UNDERLINE + "KIT");
			e.setLine(2, ChatColor.WHITE.toString() + ChatColor.BOLD + "Default");
		}
	}

	@EventHandler
	public void sign69(PlayerInteractEvent e)
	{
		Player p = e.getPlayer();
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.LEFT_CLICK_BLOCK)
		{
			if (e.getClickedBlock().getType() == Material.WALL_SIGN || e.getClickedBlock().getType() == Material.SIGN_POST)
			{
				Sign sign = (Sign) e.getClickedBlock().getState();
				if (sign.getLine(2).equalsIgnoreCase(ChatColor.WHITE.toString() + ChatColor.BOLD + "Default"))
				{
					if (this.plugin.lists.kit.containsKey(p.getName()))
					{
						e.setCancelled(true);
						this.plugin.playerMethods.message(p, this.plugin.strings.prefix() + "&cYou already have a kit selected.");
					}
					else
					{
						this.plugin.playerMethods.message(p, this.plugin.strings.prefix() + "&7You selected kit &bDefault&7.");
						this.plugin.lists.kit.put(p.getName(), "Default");
						this.plugin.playerMethods.clear(p);

						Kit kit = new DefaultKitNew();
						p.getInventory().setArmorContents(kit.getArmor());
						for (ItemStack items : kit.getItems())
							p.getInventory().addItem(items);
					}
				}
			}
		}
	}
}
