package me.rega_internal.pvpisland.listeners;

import me.rega_internal.pvpisland.Main;
import net.md_5.bungee.api.ChatColor;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class ChatListeners implements Listener
{
	Main plugin;

	public ChatListeners(Main main)
	{
		this.plugin = main;
	}

	@EventHandler
	public void staffChat(AsyncPlayerChatEvent event)
	{
		Player player = event.getPlayer();
		if (this.plugin.lists.staffChat.contains(player.getName()))
		{
			for (Player players : Bukkit.getOnlinePlayers())
			{
				if (players.hasPermission(this.plugin.strings.permissionPrefix("command.staffchat")))
				{
					this.plugin.playerMethods.message(players, "&8[&4&lStaffChat&8] &7" + player.getName() + "&4: &f" + event.getMessage());
					event.setCancelled(true);
				}
			}
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void chatMuted(AsyncPlayerChatEvent event)
	{
		Player player = event.getPlayer();
		if (StringUtils.containsIgnoreCase(event.getMessage(), ".com") || StringUtils.containsIgnoreCase(event.getMessage(), ".org") || StringUtils.containsIgnoreCase(event.getMessage(), ".net"))
		{
			event.setCancelled(true);
			this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&cYou may not post links.");
		}

		if (this.plugin.lists.chatColors.containsKey(player.getName()))
		{
			if (this.plugin.lists.chatColors.get(player.getName()).equalsIgnoreCase("red"))
			{
				event.setMessage(ChatColor.RED + event.getMessage());
			}
			if (this.plugin.lists.chatColors.get(player.getName()).equalsIgnoreCase("darkred"))
			{
				event.setMessage(ChatColor.DARK_RED + event.getMessage());
			}
			if (this.plugin.lists.chatColors.get(player.getName()).equalsIgnoreCase("blue"))
			{
				event.setMessage(ChatColor.BLUE + event.getMessage()); // <---
			}
			if (this.plugin.lists.chatColors.get(player.getName()).equalsIgnoreCase("darkblue"))
			{
				event.setMessage(ChatColor.DARK_BLUE + event.getMessage());
			}
			if (this.plugin.lists.chatColors.get(player.getName()).equalsIgnoreCase("aqua"))
			{
				event.setMessage(ChatColor.AQUA + event.getMessage());
			}
			if (this.plugin.lists.chatColors.get(player.getName()).equalsIgnoreCase("green"))
			{
				event.setMessage(ChatColor.DARK_GREEN + event.getMessage());
			}
			if (this.plugin.lists.chatColors.get(player.getName()).equalsIgnoreCase("lightgreen"))
			{
				event.setMessage(ChatColor.GREEN + event.getMessage());
			}
			if (this.plugin.lists.chatColors.get(player.getName()).equalsIgnoreCase("pink"))
			{
				event.setMessage(ChatColor.LIGHT_PURPLE + event.getMessage());

			}
			if (this.plugin.lists.chatColors.get(player.getName()).equalsIgnoreCase("purple"))
			{
				event.setMessage(ChatColor.DARK_PURPLE + event.getMessage());
			}
			if (this.plugin.lists.chatColors.get(player.getName()).equalsIgnoreCase("white"))
			{
				event.setMessage(ChatColor.WHITE + event.getMessage());
			}
			if (this.plugin.lists.chatColors.get(player.getName()).equalsIgnoreCase("yellow"))
			{
				event.setMessage(ChatColor.YELLOW + event.getMessage());
			}
			if (this.plugin.lists.chatColors.get(player.getName()).equalsIgnoreCase("gold"))
			{
				event.setMessage(ChatColor.GOLD + event.getMessage());
			}
		}

		if (!player.hasPermission(this.plugin.strings.permissionPrefix("command.globalmute")))
		{
			if (this.plugin.booleans.chatMuted)
			{
				event.setCancelled(true);
				this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&cYou may not send messages in chat while the global mute is on.");
			}
		}
	}

	@EventHandler
	public void spam(AsyncPlayerChatEvent event)
	{
		Player player = event.getPlayer();

		if (this.plugin.lists.chatCooldown.contains(player.getName()) && !this.plugin.lists.staffChat.contains(player.getName()) && !player.hasPermission("pvpisland.spam.bypass"))
		{
			this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&6You may only talk once every 1.5 seconds.");
			event.setCancelled(true);
		}
		else
		{
			this.plugin.lists.chatCooldown.add(player.getName());
			new BukkitRunnable()
			{
				public void run()
				{
					plugin.lists.chatCooldown.remove(player.getName());
				}
			}.runTaskLater(this.plugin, (long) (20 * 1.5));
		}
	}

	@EventHandler
	public void doCommands(org.bukkit.event.player.PlayerCommandPreprocessEvent event)
	{
		Player player = event.getPlayer();
		if (event.getMessage().startsWith("pl") || event.getMessage().startsWith("/pl"))
		{
			if (!player.hasPermission(this.plugin.strings.permissionPrefix("plugins.view")))
			{
				event.setCancelled(true);
				this.plugin.playerMethods.message(player, "&fPlugins (1): &aPvPIslandKits");
				return;
			}
		}

		if (event.getMessage().startsWith("bukkit") || event.getMessage().startsWith("/bukkit"))
		{
			player.sendMessage(this.plugin.strings.noPermission());
			event.setCancelled(true);
		}

		if (event.getMessage().startsWith("spigot") || event.getMessage().startsWith("/spigot"))
		{
			player.sendMessage(this.plugin.strings.noPermission());
			event.setCancelled(true);
		}
	}
}
