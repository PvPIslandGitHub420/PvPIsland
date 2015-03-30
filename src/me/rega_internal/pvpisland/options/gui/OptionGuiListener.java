package me.rega_internal.pvpisland.options.gui;

import me.rega_internal.pvpisland.Main;
import me.rega_internal.pvpisland.options.JesusOption;
import me.rega_internal.pvpisland.options.NoHungerOptions;
import me.rega_internal.pvpisland.options.NoJumpOption;
import me.rega_internal.pvpisland.options.RedstoneBloodOption;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class OptionGuiListener implements Listener
{

	Main plugin;

	public OptionGuiListener(Main main)
	{
		this.plugin = main;
	}

	@EventHandler
	public void click(PlayerInteractEvent event)
	{
		Player p = event.getPlayer();
		if (p.getItemInHand().getType() == Material.ENCHANTMENT_TABLE)
		{
			if (event.getAction() == Action.RIGHT_CLICK_AIR || (event.getAction() == Action.RIGHT_CLICK_BLOCK))
			{
				if (this.plugin.playerMethods.isDonor(p) || this.plugin.playerMethods.isStaff(p))
				{
					event.setCancelled(true);
					p.chat("/options");
				}
				else
				{
					event.setCancelled(true);
					this.plugin.playerMethods.message(p, this.plugin.strings.prefix() + "&cPlease donate to obtain these features.");
				}
			}
		}
	}

	@EventHandler
	public void click(InventoryClickEvent event)
	{
		Player player = (Player) event.getWhoClicked();
		if (event.getInventory().getTitle().equalsIgnoreCase("Options"))
		{
			event.setCancelled(true);
			if (event.getSlot() == 18)
			{
				if (this.plugin.lists.optionNoJump.contains(player.getName()))
				{
					this.plugin.lists.optionNoJump.remove(player.getName());
					this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&cNo jump is now disabled. ");
					event.getInventory().setItem(18, new NoJumpOption().disabledIcon());
					player.removePotionEffect(PotionEffectType.JUMP);
				}
				else
				{
					this.plugin.lists.optionNoJump.add(player.getName());
					this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&aNo jump is now enabled. ");
					event.getInventory().setItem(18, new NoJumpOption().enabledIcon());
					for (PotionEffect pe : new NoJumpOption().getPotions())
						player.addPotionEffect(pe);
				}
			}
			if (event.getSlot() == 19)
			{
				if (this.plugin.lists.optionBlood.contains(player.getName()))
				{
					this.plugin.lists.optionBlood.remove(player.getName());
					this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&cBlood is now disabled. ");
					event.getInventory().setItem(19, new RedstoneBloodOption().disabledIcon());
				}
				else
				{
					this.plugin.lists.optionBlood.add(player.getName());
					this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&aBlood is now enabled. ");
					event.getInventory().setItem(19, new RedstoneBloodOption().enabledIcon());
				}
			}
			if (event.getSlot() == 20)
			{
				if (this.plugin.lists.optionNoHunger.contains(player.getName()))
				{
					this.plugin.lists.optionNoHunger.remove(player.getName());
					this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&cNo Hunger is now disabled. ");
					event.getInventory().setItem(20, new NoHungerOptions().disabledIcon());
					player.removePotionEffect(PotionEffectType.SATURATION);
				}
				else
				{
					this.plugin.lists.optionNoHunger.add(player.getName());
					this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&aNo Hunger is now enabled. ");
					event.getInventory().setItem(20, new NoHungerOptions().enabledIcon());
					for (PotionEffect pe : new NoHungerOptions().getPotions())
						player.addPotionEffect(pe);
				}
			}
			if (event.getSlot() == 21)
			{
				if (this.plugin.lists.optionJesus.contains(player.getName()))
				{
					this.plugin.lists.optionJesus.remove(player.getName());
					this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&cFrozen is now disabled. ");
					event.getInventory().setItem(21, new JesusOption().disabledIcon());
				}
				else
				{
					this.plugin.lists.optionJesus.add(player.getName());
					this.plugin.playerMethods.message(player, this.plugin.strings.prefix() + "&aFrozen is now enabled. ");
					event.getInventory().setItem(21, new JesusOption().enabledIcon());
				}
			}
		}
	}
}
