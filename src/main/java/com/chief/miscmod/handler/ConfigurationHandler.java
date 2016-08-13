package com.chief.miscmod.handler;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.chief.miscmod.reference.Reference;

import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.client.config.IConfigElement;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ConfigurationHandler 
{
	
	public static Configuration configuration;
	// Config values
	public static int furnaceFuelUsage = 200;
	
	public static void init(File configFile)
	{
		// Create the configration object from the given configuration file
		if (configuration == null)
		{
			configuration = new Configuration(configFile);			
		}
		loadConfiguration();
	}
	
	@SubscribeEvent
	public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
	{
		if (event.getModID().equalsIgnoreCase(Reference.MOD_ID))
		{
			// Re-sync config
			loadConfiguration();
		}
		
	}
	
	public static void loadConfiguration()
	{
		configuration.load();
		
		furnaceFuelUsage = configuration.getInt("Fuel Usage:", configuration.CATEGORY_GENERAL, 200, 0, 102400, "How many fuel units to consume per item");
		
		if (configuration.hasChanged())
		{
			configuration.save();
		}
	}
}
