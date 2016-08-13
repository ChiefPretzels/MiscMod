package com.chief.miscmod.handler;

import com.chief.miscmod.blocks.MiscModBlocks;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CraftingHandler 
{
	public static void init()
	{
		addCraftingRec();
		addSmeltingRec();
	}
	
	public static void addCraftingRec()
	{
		// Shaped recipes
		GameRegistry.addRecipe(new ItemStack(MiscModBlocks.SLAGFURNACE_OFF), new Object[]{"SFS", "S S", "SFS", 'S', Blocks.COBBLESTONE, 'F', Blocks.FURNACE});
	}
	
	public static void addSmeltingRec()
	{
		
	}
}
