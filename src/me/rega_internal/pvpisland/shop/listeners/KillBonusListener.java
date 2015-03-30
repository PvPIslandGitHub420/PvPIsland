package me.rega_internal.pvpisland.shop.listeners;

import me.rega_internal.pvpisland.Main;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class KillBonusListener implements Listener
{

	Main plugin;

	public KillBonusListener(Main main)
	{
		this.plugin = main;
	}


	@EventHandler
	public void death(PlayerDeathEvent event)
	{
		Player killer = event.getEntity().getKiller();
		if (this.plugin.lists.shopKillBonus.contains(killer.getName())){
		
		killer.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 100, 2));
		killer.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 100, 3));
		this.plugin.playerMethods.message(killer, this.plugin.strings.prefix() + "&6Kill Bonus Activated!");

	}
	}
}
