package me.rega_internal.pvpisland.commands;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import me.rega_internal.pvpisland.Main;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandWho implements CommandExecutor
{
	Main plugin;

	public CommandWho(Main main)
	{
		this.plugin = main;
	}

	@SuppressWarnings("rawtypes")
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		if (command.getName().equalsIgnoreCase("who"))
		{
			if (!(sender instanceof Player))
			{
				sender.sendMessage("There are " + Bukkit.getOnlinePlayers().size() + " online.");
				return true;
			}

			Player player = (Player) sender;
			List<String> players = new ArrayList<String>();
			for (Player p : Bukkit.getOnlinePlayers())
				players.add(p.getDisplayName());

			StringBuilder stringBuilder = new StringBuilder();
			for (Object lObject = players.iterator(); ((Iterator) lObject).hasNext();)
			{
				String item = (String) ((Iterator) lObject).next();
				if (stringBuilder.length() > 0)
				{
					stringBuilder.append("§8, ");
				}
				stringBuilder.append(item);
			}
			String result = stringBuilder.toString();

			this.plugin.playerMethods.message(player, "&8[&4Owner&8, &bDev&8, &cAdmin&8, &5&oMod+&8, &5Mod&8, &eTrial-Mod&8]");
			this.plugin.playerMethods.message(player, "&8[&d&oCaptain&8, &9Pirate&8, &6Cadet&8, &aSailor&8]");
			this.plugin.playerMethods.message(player, "&8(&7" + Bukkit.getOnlinePlayers().size() + "&8/&7" + Bukkit.getMaxPlayers() + "&8) [" + result + "&8]");

			players.clear();
		}
		return true;
	}
}
