package me.rega_internal.pvpisland.commands;

import me.rega_internal.pvpisland.Main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandChatColor implements CommandExecutor
{
	Main plugin;

	public CommandChatColor(Main main)
	{
		this.plugin = main;
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	{
		if (command.getName().equalsIgnoreCase("chatcolor"))
		{
			if (!(sender instanceof Player))
			{
				sender.sendMessage(this.plugin.strings.consoleSender("chatcolor"));
				return false;
			}
			else
			{
				Player player = (Player) sender;
				if (args.length != 1)
				{
					this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + this.plugin.strings.usage("chatcolor <color>:off:list"));
				}
				else
				{
					if (this.plugin.playerMethods.isDonor(player) || this.plugin.playerMethods.isStaff(player))
					{
						if (args[0].equalsIgnoreCase("off"))
						{
							if (this.plugin.lists.chatColors.containsKey(player.getName()))
							{
								this.plugin.lists.chatColors.remove(player.getName());
								this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&7ChatColor disabled");

							}
							else
							{
								this.plugin.playerMethods.message(player, this.plugin.strings.noPermission());
							}
						}
						else if (args[0].equalsIgnoreCase("red"))
						{
							
							this.plugin.lists.chatColors.put(player.getName(), "red");

							this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&7You have selected &cred&7!");
						}
						else if (args[0].equalsIgnoreCase("green"))
						{
							this.plugin.lists.chatColors.put(player.getName(), "green");
							this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&7You have selected &2green&7!");
						}
						else if (args[0].equalsIgnoreCase("blue"))
						{
							this.plugin.lists.chatColors.put(player.getName(), "blue");
							this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&7You have selected &9blue&7!");
						}
						else if (args[0].equalsIgnoreCase("pink"))
						{
							this.plugin.lists.chatColors.put(player.getName(), "pink");
							this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&7You have selected &dpink&7!");
						}
						else if (args[0].equalsIgnoreCase("darkblue"))
						{
							this.plugin.lists.chatColors.put(player.getName(), "darkblue");
							this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&7You have selected &1blue&7!");
						}
						else if (args[0].equalsIgnoreCase("aqua"))
						{
							this.plugin.lists.chatColors.put(player.getName(), "aqua");
							this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&7You have selected &baqua&7!");
						}
						else if (args[0].equalsIgnoreCase("purple"))
						{
							this.plugin.lists.chatColors.put(player.getName(), "purple");
							this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&7You have selected &5purple&7!");
						}
						else if (args[0].equalsIgnoreCase("yellow"))
						{
							this.plugin.lists.chatColors.put(player.getName(), "yellow");
							this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&7You have selected &eyellow&7!");
						}
						else if (args[0].equalsIgnoreCase("lightgreen"))
						{
							this.plugin.lists.chatColors.put(player.getName(), "lightgreen");
							this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&7You have selected &alight green&7!");
						}
						else if (args[0].equalsIgnoreCase("darkred"))
						{
							this.plugin.lists.chatColors.put(player.getName(), "darkred");
							this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&7You have selected &4dark red&7!");
						}
						else if (args[0].equalsIgnoreCase("gold"))
						{
							this.plugin.lists.chatColors.put(player.getName(), "gold");
							this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&7You have selected &6gold&7!");

						}
						else if (args[0].equalsIgnoreCase("white"))
						{
							this.plugin.lists.chatColors.put(player.getName(), "white");
							this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&7You have selected &fwhite&7!");
						}
						else if (args[0].equalsIgnoreCase("list"))
						{
							this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&7-=-=-&8[&6ChatColors&8]&7-=-=-");
							this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&fWhite");
							this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&6Gold");
							this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&eYellow");
							this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&5Purple");
							this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&dPink");
							this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&4Darkred");
							this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&cRed");
							this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&bAqua");
							this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&9Blue");
							this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&1Darkblue");
							this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&2Green");
							this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&aLightgreen");

						}
						else
						{
							this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&cThat is not a valid color.");

						}
					}
					else
					{
						this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + this.plugin.strings.noPermission());
					}
				}
			}
		}
		return true;
	}
}
