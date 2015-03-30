package me.rega_internal.pvpisland.values;

import java.util.ArrayList;
import java.util.List;
import me.rega_internal.pvpisland.Main;

public class Strings
{
	Main plugin;

	public Strings(Main main)
	{
		this.plugin = main;
	}

	public String prefix()
	{
		return "&8&l[&b&lPvPIsland&8&l] ";
	}

	public String noPermission()
	{
		return "Unknown command. Type \"/help\" for help.";
	}

	public String consoleSender(String command)
	{
		return "You must be a player to run /" + command + ".";
	}

	public String usage(String usage)
	{
		return "&cUnknown usage. Try \"/" + usage + "\"";
	}

	public String permissionPrefix(String string)
	{
		return "pvpisland." + string;
	}

	public String noSubCommand()
	{
		return "&cThat sub-command does not exist.";
	}

	public List<String> getStaffRanks()
	{
		List<String> ranks = new ArrayList<String>();
		ranks.add("Owner");
		ranks.add("Dev");
		ranks.add("Admin");
		ranks.add("Mod+");
		ranks.add("Mod");
		return ranks;
	}

	public List<String> getDonorRanks()
	{
		List<String> ranks = new ArrayList<String>();
		ranks.add("Captain");
		ranks.add("Pirate");
		ranks.add("Cadet");
		ranks.add("Sailor");
		return ranks;
	}
}
