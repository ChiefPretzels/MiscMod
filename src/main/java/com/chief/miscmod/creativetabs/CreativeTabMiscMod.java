package com.chief.miscmod.creativetabs;

import com.chief.miscmod.blocks.MiscModBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabMiscMod 
{
	public static final CreativeTabs tabMiscMod = new CreativeTabs("tabMiscMod")
			{
				@Override
				public Item getTabIconItem()
				{
					return Item.getItemFromBlock(MiscModBlocks.SLAGFURNACE_OFF);
				}
			};
}
