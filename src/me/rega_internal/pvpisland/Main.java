package me.rega_internal.pvpisland;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import me.rega_internal.pvpisland.commands.CommandChatColor;
import me.rega_internal.pvpisland.commands.CommandDonator;
import me.rega_internal.pvpisland.commands.CommandHelp;
import me.rega_internal.pvpisland.commands.CommandMsg;
import me.rega_internal.pvpisland.commands.CommandPvPIsland;
import me.rega_internal.pvpisland.commands.CommandRepair;
import me.rega_internal.pvpisland.commands.CommandReport;
import me.rega_internal.pvpisland.commands.CommandSeeKit;
import me.rega_internal.pvpisland.commands.CommandSoup;
import me.rega_internal.pvpisland.commands.CommandSpawn;
import me.rega_internal.pvpisland.commands.CommandSuicide;
import me.rega_internal.pvpisland.commands.CommandWho;
import me.rega_internal.pvpisland.commands.staff.CommandAdmin;
import me.rega_internal.pvpisland.commands.staff.CommandBuild;
import me.rega_internal.pvpisland.commands.staff.CommandClearChat;
import me.rega_internal.pvpisland.commands.staff.CommandClearKit;
import me.rega_internal.pvpisland.commands.staff.CommandGlobalMute;
import me.rega_internal.pvpisland.commands.staff.CommandInvsee;
import me.rega_internal.pvpisland.commands.staff.CommandStaffChat;
import me.rega_internal.pvpisland.commands.staff.CommandWelcome;
import me.rega_internal.pvpisland.commands.staff.punishments.CommandBan;
import me.rega_internal.pvpisland.commands.staff.punishments.CommandKick;
import me.rega_internal.pvpisland.commands.staff.punishments.CommandWarn;
import me.rega_internal.pvpisland.kits.abilities.CharizardKitAbility;
import me.rega_internal.pvpisland.kits.abilities.DragonKitAbility;
import me.rega_internal.pvpisland.kits.abilities.FatManKitAbility;
import me.rega_internal.pvpisland.kits.abilities.FishermanKitAbility;
import me.rega_internal.pvpisland.kits.abilities.HyperKitAbility;
import me.rega_internal.pvpisland.kits.abilities.PoseidonKitAbility;
import me.rega_internal.pvpisland.kits.abilities.RiderKitAbility;
import me.rega_internal.pvpisland.kits.abilities.SpikeKitAbility;
import me.rega_internal.pvpisland.kits.abilities.StomperKitAbility;
import me.rega_internal.pvpisland.kits.abilities.SwitcherKitAbility;
import me.rega_internal.pvpisland.kits.gui.CommandKit;
import me.rega_internal.pvpisland.kits.gui.KitGuiListeners;
import me.rega_internal.pvpisland.listeners.BuildListeners;
import me.rega_internal.pvpisland.listeners.ChatListeners;
import me.rega_internal.pvpisland.listeners.DeathListeners;
import me.rega_internal.pvpisland.listeners.GlobalListeners;
import me.rega_internal.pvpisland.listeners.JoinQuitListener;
import me.rega_internal.pvpisland.listeners.KillStreakListener;
import me.rega_internal.pvpisland.listeners.NyanNyanNyanNyanNyanNyanNyan;
import me.rega_internal.pvpisland.listeners.SignClickListener;
import me.rega_internal.pvpisland.listeners.SpongeListeners;
import me.rega_internal.pvpisland.methods.PlayerMethods;
import me.rega_internal.pvpisland.methods.ServerMethods;
import me.rega_internal.pvpisland.options.gui.CommandOptions;
import me.rega_internal.pvpisland.options.gui.OptionGuiListener;
import me.rega_internal.pvpisland.options.listeners.BloodListener;
import me.rega_internal.pvpisland.options.listeners.JesusListener;
import me.rega_internal.pvpisland.options.listeners.NoFallListener;
import me.rega_internal.pvpisland.particles.gui.CommandParticles;
import me.rega_internal.pvpisland.particles.gui.ParticleGuiListener;
import me.rega_internal.pvpisland.shop.gui.CommandShop;
import me.rega_internal.pvpisland.shop.gui.ShopGuiListener;
import me.rega_internal.pvpisland.shop.listeners.DoubleJumpListener;
import me.rega_internal.pvpisland.shop.listeners.KillBonusListener;
import me.rega_internal.pvpisland.values.Booleans;
import me.rega_internal.pvpisland.values.Items;
import me.rega_internal.pvpisland.values.Lists;
import me.rega_internal.pvpisland.values.Locations;
import me.rega_internal.pvpisland.values.Strings;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;

public class Main extends JavaPlugin
{
	public Economy economy = null;
	public Permission permissions = null;
	public Chat chat = null;
	public Strings strings = null;
	public Lists lists = null;
	public Booleans booleans = null;
	public PlayerMethods playerMethods = null;
	public ServerMethods serverMethods = null;
	public Items items = null;
	public Locations locations = null;

	public void onEnable()
	{
		strings = new Strings(this);
		lists = new Lists(this);
		booleans = new Booleans(this);
		playerMethods = new PlayerMethods(this);
		serverMethods = new ServerMethods(this);
		items = new Items(this);
		locations = new Locations(this);
		setupEconomy();
		setupPermissions();
		setupChat();

		setupConfigs();
		setupCommands();
		setupListeners();
	}

	public void onDisable()
	{
		lists.clear();
		booleans.chatMuted = false;
	}

	private void setupCommands()
	{
		/** Staff Commands */
		getCommand("admin").setExecutor(new CommandAdmin(this));
		getCommand("clearchat").setExecutor(new CommandClearChat(this));
		getCommand("ck").setExecutor(new CommandClearKit(this));
		getCommand("build").setExecutor(new CommandBuild(this));
		getCommand("globalmute").setExecutor(new CommandGlobalMute(this));
		getCommand("warn").setExecutor(new CommandWarn(this));
		getCommand("welcome").setExecutor(new CommandWelcome(this));
		getCommand("staffchat").setExecutor(new CommandStaffChat(this));
		getCommand("invsee").setExecutor(new CommandInvsee(this));
		getCommand("setspawn").setExecutor(new CommandSpawn(this));
		getCommand("kick").setExecutor(new CommandKick(this));
		getCommand("ban").setExecutor(new CommandBan(this));

		/** Donor Commands */
		getCommand("chatcolor").setExecutor(new CommandChatColor(this));
		getCommand("options").setExecutor(new CommandOptions(this));
		getCommand("shop").setExecutor(new CommandShop(this));
		getCommand("particles").setExecutor(new CommandParticles(this));

		/** Player Commands */
		getCommand("rank").setExecutor(new CommandDonator(this));
		getCommand("help").setExecutor(new CommandHelp(this));
		getCommand("who").setExecutor(new CommandWho(this));
		getCommand("msg").setExecutor(new CommandMsg(this));
		getCommand("r").setExecutor(new CommandMsg(this));
		getCommand("suicide").setExecutor(new CommandSuicide(this));
		getCommand("soup").setExecutor(new CommandSoup(this));
		getCommand("pvpisland").setExecutor(new CommandPvPIsland(this));
		getCommand("seekit").setExecutor(new CommandSeeKit(this));
		getCommand("report").setExecutor(new CommandReport(this));
		getCommand("repair").setExecutor(new CommandRepair(this));
		getCommand("kit").setExecutor(new CommandKit(this));
		getCommand("spawn").setExecutor(new CommandSpawn(this));
	}

	private void setupListeners()
	{
		/** Regular Listeners */
		getServer().getPluginManager().registerEvents(new ChatListeners(this), this);
		getServer().getPluginManager().registerEvents(new DeathListeners(this), this);
		getServer().getPluginManager().registerEvents(new JoinQuitListener(this), this);
		getServer().getPluginManager().registerEvents(new SpongeListeners(this), this);
		getServer().getPluginManager().registerEvents(new GlobalListeners(this), this);
		getServer().getPluginManager().registerEvents(new BuildListeners(this), this);
		getServer().getPluginManager().registerEvents(new KitGuiListeners(this), this);
		getServer().getPluginManager().registerEvents(new OptionGuiListener(this), this);
		getServer().getPluginManager().registerEvents(new ShopGuiListener(this), this);
		getServer().getPluginManager().registerEvents(new ParticleGuiListener(this), this);
		getServer().getPluginManager().registerEvents(new NyanNyanNyanNyanNyanNyanNyan(this), this);
		getServer().getPluginManager().registerEvents(new SignClickListener(this), this);
		getServer().getPluginManager().registerEvents(new KillStreakListener(this), this);

		/** Kits */
		getServer().getPluginManager().registerEvents(new RiderKitAbility(this), this);
		getServer().getPluginManager().registerEvents(new StomperKitAbility(this), this);
		getServer().getPluginManager().registerEvents(new FishermanKitAbility(this), this);
		getServer().getPluginManager().registerEvents(new SwitcherKitAbility(this), this);
		getServer().getPluginManager().registerEvents(new HyperKitAbility(this), this);
		getServer().getPluginManager().registerEvents(new PoseidonKitAbility(this), this);
		getServer().getPluginManager().registerEvents(new DragonKitAbility(this), this);
		getServer().getPluginManager().registerEvents(new SpikeKitAbility(this), this);
		getServer().getPluginManager().registerEvents(new CharizardKitAbility(this), this);
		getServer().getPluginManager().registerEvents(new FatManKitAbility(this), this);

		/** Options */
		getServer().getPluginManager().registerEvents(new BloodListener(this), this);
		getServer().getPluginManager().registerEvents(new NoFallListener(this), this);
		getServer().getPluginManager().registerEvents(new JesusListener(this), this);

		/** Shop */
		getServer().getPluginManager().registerEvents(new DoubleJumpListener(this), this);
		getServer().getPluginManager().registerEvents(new KillBonusListener(this), this);

	}

	private void setupConfigs()
	{
		File config = new File(getDataFolder(), "config.yml");
		if (!config.exists())
		{
			/** MOTD */
			getConfig().createSection("InGame-MOTD");
			List<String> motd = new ArrayList<String>();
			motd.add("&8&l[&b&lPvPIsland&8&l] &7Welcome to &bPvPIsland&7!");
			motd.add("&8&l[&b&lPvPIsland&8&l] &7There are currently &b{playersOnline} &7players online.");
			motd.add("&8&l[&b&lPvPIsland&8&l] &7You have &b${balance} &7in your account.");
			getConfig().set("InGame-MOTD", motd);

			/** Spawn */
			getConfig().addDefault("Locations.Spawn.World", "world");
			getConfig().addDefault("Locations.Spawn.X", 0.5);
			getConfig().addDefault("Locations.Spawn.Y", 128);
			getConfig().addDefault("Locations.Spawn.Z", 0.5);
			getConfig().addDefault("Locations.Spawn.Yaw", 0.0);
			getConfig().addDefault("Locations.Spawn.Pitch", 0.0);

			getConfig().options().copyDefaults(true);
			saveConfig();
		}
		else
		{
			saveConfig();
		}
	}

	private boolean setupEconomy()
	{
		if (getServer().getPluginManager().getPlugin("Vault") == null) return false;
		RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
		if (rsp == null) return false;
		economy = rsp.getProvider();
		return economy != null;
	}

	private boolean setupPermissions()
	{
		if (getServer().getPluginManager().getPlugin("Vault") == null) return false;
		RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
		permissions = rsp.getProvider();
		return permissions != null;
	}

	private boolean setupChat()
	{
		if (getServer().getPluginManager().getPlugin("Vault") == null) return false;
		RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
		chat = rsp.getProvider();
		return chat != null;
	}

	public WorldGuardPlugin getWorldGuard()
	{
		Plugin plugin = getServer().getPluginManager().getPlugin("WorldGuard");
		if (plugin == null || !(plugin instanceof WorldGuardPlugin)) { return null; }
		return (WorldGuardPlugin) plugin;
	}
}
