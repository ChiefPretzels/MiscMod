package com.chief.miscmod;

import javax.annotation.Nullable;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class SimpleCapabilityProvider<HANDLER> implements ICapabilitySerializable<NBTBase> 
{
	private final HANDLER instance;
	private final Capability<HANDLER> capability;
	private final EnumFacing facing;
	
	public SimpleCapabilityProvider(Capability<HANDLER> capability, @Nullable EnumFacing facing)
	{
		this(capability, facing, capability.getDefaultInstance());
	}
	
	public SimpleCapabilityProvider(Capability<HANDLER> capability, @Nullable EnumFacing facing, HANDLER instance)
	{
		this.capability = capability;
		this.instance = instance;
		this.facing = facing;
	}
	
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Nullable
	public <T> T getCapability(Capability<T> capability, EnumFacing facing)
	{
		if (capability == getCapability())
		{
			return getCapability().cast(getInstance());
		}
		
		return null;
	}
	
	public final HANDLER getInstance()
	{
		return instance;
	}
	
	public final Capability<HANDLER> getCapability()
	{
		return capability;
	}
	
	@Nullable
	public final EnumFacing getFacing()
	{
		return facing;
	}
	
	@Override
	public NBTBase serializeNBT() {
		return getCapability().writeNBT(getInstance(), getFacing());
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		getCapability().readNBT(getInstance(), getFacing(), nbt);
		
	}
}
