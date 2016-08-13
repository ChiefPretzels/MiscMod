package com.chief.miscmod.blocks;

import com.chief.miscmod.blocks.tileentity.TileEntitySlagFurnace;
import com.chief.miscmod.creativetabs.CreativeTabMiscMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MiscModBlocks
{
	
	public static Block SLAGFURNACE_OFF; // Currently not smelting
	public static Block SLAGFURNACE_ON; // Currently smelting
	
	public static void init()
	{
		SLAGFURNACE_OFF = new SlagFurnace(false).setRegistryName("slagFurnace_off").setUnlocalizedName("slagFurnace_off").setCreativeTab(CreativeTabMiscMod.tabMiscMod).setHardness(5.0F).setResistance(5.0F);
		SLAGFURNACE_ON = new SlagFurnace(true).setRegistryName("slagFurnace_on").setUnlocalizedName("slagFurnace_on").setHardness(5.0F).setResistance(5.0F).setLightLevel(0.7F);
	}
	
	public static void register()
	{
		registerBlock(SLAGFURNACE_OFF);
		registerBlock(SLAGFURNACE_ON);
	}
	
	public static void registerRenders()
	{
		registerRender(SLAGFURNACE_OFF);
		registerRender(SLAGFURNACE_ON);
	}
	
	public static void registerBlock(Block block)
	{
		GameRegistry.register(block);
		ItemBlock item = new ItemBlock(block);
		item.setRegistryName(block.getRegistryName());
		GameRegistry.register(item);
	}
	
	public static void registerRender(Block block)
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
	}
}
