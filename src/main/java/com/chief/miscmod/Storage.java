package com.chief.miscmod;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

public class Storage implements Capability.IStorage<IThirst> 
{

	@Override
	public NBTBase writeNBT(Capability<IThirst> capability, IThirst instance, EnumFacing side)
	{
		return null;
	}

	@Override
	public void readNBT(Capability<IThirst> capability, IThirst instance, EnumFacing side, NBTBase nbt)
	{
		
	}

}
