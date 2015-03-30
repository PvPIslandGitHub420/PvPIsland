package me.rega_internal.pvpisland.listeners;

import java.util.Random;

import me.rega_internal.pvpisland.Main;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class NyanNyanNyanNyanNyanNyanNyan implements Listener
{
	Main plugin;

	public NyanNyanNyanNyanNyanNyanNyan(Main main)
	{
		this.plugin = main;
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void MotherFuckingNyanCat(PlayerMoveEvent event)
	{
		Player player = event.getPlayer();
		if (player.isOp() && player.isFlying())
		{
			if (this.plugin.lists.nyanCat.contains(player.getName()))
			{
				Random random = new Random();
				int index = random.nextInt(10);

				Block block1 = player.getLocation().getBlock().getRelative(BlockFace.SOUTH);
				Block block2 = player.getLocation().add(0, 1, 0).getBlock().getRelative(BlockFace.SOUTH);

				if (block1.getType() == Material.AIR)
				{
					block1.setType(new ItemStack(Material.STAINED_GLASS_PANE, 1).getType());
					block1.setData((byte) index);
				}
				if (block2.getType() == Material.AIR)
				{
					block2.setType(new ItemStack(Material.STAINED_GLASS_PANE, 1).getType());
					block2.setData((byte) index);
				}

				new BukkitRunnable()
				{
					public void run()
					{
						block1.setType(Material.AIR);
						block2.setType(Material.AIR);
					}
				}.runTaskLater(this.plugin, 20 * 2);
			}
		}
	}
}
