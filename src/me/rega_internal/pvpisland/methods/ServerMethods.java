package me.rega_internal.pvpisland.methods;

import java.text.DecimalFormat;
import java.util.logging.Level;

import me.rega_internal.pvpisland.Main;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public class ServerMethods
{
	Main plugin;

	public ServerMethods(Main main)
	{
		this.plugin = main;
	}

	public void broadcast(String string)
	{
		Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', string));
	}

	public void log(Level level, String string)
	{
		Bukkit.getLogger().log(level, string);
	}

	public boolean isTool(ItemStack itemStack)
	{
		if (Enchantment.DURABILITY.canEnchantItem(itemStack))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@SuppressWarnings("deprecation")
	public void scoreboard(Player player)
	{
		Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();

		Objective sidebar = scoreboard.registerNewObjective("sideBar", "dummy");
		sidebar.setDisplaySlot(DisplaySlot.SIDEBAR);
		sidebar.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&b&lPvPIsland&7&l.&b&lcom"));

		Score players = sidebar.getScore(ChatColor.translateAlternateColorCodes('&', "&7&lPlayers"));
		Score kills = sidebar.getScore(ChatColor.translateAlternateColorCodes('&', "&7&lKills"));
		Score deaths = sidebar.getScore(ChatColor.translateAlternateColorCodes('&', "&7&lDeaths"));
		Score balance = sidebar.getScore(ChatColor.translateAlternateColorCodes('&', "&7&lBalance"));

		players.setScore(Bukkit.getOnlinePlayers().size());
		kills.setScore(0);
		deaths.setScore(0);
		balance.setScore(Integer.parseInt(new DecimalFormat("#").format(this.plugin.economy.getBalance(player.getName()))));

		Objective health = scoreboard.registerNewObjective("showHealth", "health");
		health.setDisplaySlot(DisplaySlot.BELOW_NAME);
		health.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c❤"));

		player.setScoreboard(scoreboard);
		player.setHealth(player.getHealth());
	}
}
