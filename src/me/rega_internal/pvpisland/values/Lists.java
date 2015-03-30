package me.rega_internal.pvpisland.values;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.rega_internal.pvpisland.Main;

public class Lists
{
	Main plugin;

	public Map<String, String> kit = new HashMap<String, String>();
	public Map<String, Integer> cooldown = new HashMap<String, Integer>();
	public Map<String, String> lastMessaged = new HashMap<String, String>();
	public Map<String, String> chatColors = new HashMap<String, String>();

	public List<String> chatCooldown = new ArrayList<String>();
	public List<String> adminMode = new ArrayList<String>();
	public List<String> buildMode = new ArrayList<String>();
	public List<String> staffChat = new ArrayList<String>();
	public List<String> teleporting = new ArrayList<String>();
	public List<String> spongeFallDmg = new ArrayList<String>();
	public List<String> soupCooldown = new ArrayList<String>();
	public List<String> repairCooldown = new ArrayList<String>();
	public List<String> NoLog = new ArrayList<String>();

	public List<String> optionNoJump = new ArrayList<String>();
	public List<String> optionBlood = new ArrayList<String>();
	public List<String> optionNoHunger = new ArrayList<String>();
	public List<String> optionJesus = new ArrayList<String>();

	public List<String> hasParticle = new ArrayList<String>();

	public List<String> shopDoubleJump = new ArrayList<String>();
	public List<String> shopKillBonus = new ArrayList<String>();

	public List<String> nyanCat = new ArrayList<String>();

	public Map<String, Integer> killsFromLife = new HashMap<String, Integer>();

	public Lists(Main main)
	{
		this.plugin = main;
	}

	public void clear()
	{
		kit.clear();
		cooldown.clear();
		chatCooldown.clear();
		buildMode.clear();
		adminMode.clear();
		staffChat.clear();
		teleporting.clear();
		lastMessaged.clear();
		chatColors.clear();
		spongeFallDmg.clear();
		soupCooldown.clear();
		repairCooldown.clear();
		optionNoJump.clear();
		optionBlood.clear();
		optionNoHunger.clear();
		optionJesus.clear();
		nyanCat.clear();
	}
}
