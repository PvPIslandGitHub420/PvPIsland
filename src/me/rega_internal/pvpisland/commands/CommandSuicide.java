	package me.rega_internal.pvpisland.commands;

import me.rega_internal.pvpisland.Main;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSuicide implements CommandExecutor
{
	Main plugin;

	public CommandSuicide(Main main)
	{
		this.plugin = main;
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		if (command.getName().equalsIgnoreCase("suicide"))
		{
			if (!(sender instanceof Player))
			{
				sender.sendMessage(this.plugin.strings.consoleSender("suicide"));
				return true;
			}

			Player player = (Player) sender;
			if (player.getGameMode() == GameMode.CREATIVE)
			{
				this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&cYou may not commit suicide in Creative mode.");
			}
			else
			{
				this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&7You committed suicide.");
				player.setHealth(0);
			}
		}
		return true;
	}

}
