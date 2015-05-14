package com.YunusKayne.PetRock.handler;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import sun.rmi.log.LogHandler;

import com.YunusKayne.PetRock.reference.Reference;
import com.YunusKayne.PetRock.utility.LogHelper;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ConfigHandler
{
	public static Configuration configuration;
	
	public static void init(File configFile)
	{
		if(configuration == null)
		{
			configuration = new Configuration(configFile);
			LogHelper.info("Configuration Loaded!");
			loadConfiguration();
		}
	}
	
	@SubscribeEvent
	public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
	{
		if(event.modID.equalsIgnoreCase(Reference.MOD_ID))
		{
			LogHelper.info("Configuration Loaded!");
			loadConfiguration();
		}
	}
	
	private static void loadConfiguration()
	{
		//This is a config example :)
		//boolean booleanVariable = configuration.get(Configuration.CATEGORY_GENERAL, "configValue", true, "This is a test config Value").getBoolean(true);
		
		if(configuration.hasChanged())
		{
			LogHelper.info("Configuration Saved!");
			configuration.save();
		}
	}
}