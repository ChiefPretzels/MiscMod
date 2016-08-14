package com.chief.miscmod;

import com.chief.miscmod.blocks.MiscModBlocks;
import com.chief.miscmod.client.gui.ModGuiConfig;
import com.chief.miscmod.handler.ConfigurationHandler;
import com.chief.miscmod.handler.CraftingHandler;
import com.chief.miscmod.handler.EventHandler;
import com.chief.miscmod.proxy.IProxy;
import com.chief.miscmod.reference.Reference;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class MiscMod {
	
	@Instance(Reference.MOD_ID)
	public static MiscMod instance;
	public static EventHandler eventHook = new EventHandler();
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static IProxy proxy;
	
	//Network handling, mod config, items and blocks
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		MinecraftForge.EVENT_BUS.register(eventHook);
		MiscModBlocks.init();
		ConfigurationHandler.init(event.getSuggestedConfigurationFile());
	}
	//Register GUI's tiles entities, crafting recipes, general event handlers
	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		CraftingHandler.init();
	}
	//run stuff after other mod inits
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
	
}
