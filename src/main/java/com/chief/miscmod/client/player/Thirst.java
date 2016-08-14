package com.chief.miscmod.client.player;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

public class Thirst implements ICapabilityProvider
{
	public EntityPlayer player;
	public int thirstLevel;// The level of the thirst in half-waterdrops
	public int timer;// Timer to calculate when the player gets negative effects from being at 0 thirst
	public float thirstExhaustion;// int to count the timer until decrementation of the thirst bar
	public float thirstSaturation;// Thirst level above the regular thirst, exactly like hunger. Can only go as high as 5/10	
	
	public Thirst(EntityPlayer player)
	{
		this.thirstLevel = 20;
		this.thirstSaturation = 10;
		this.player = player;
		
		readData();
	}
	
	public void onTick()
	{
		boolean isPeaceful = player.worldObj.getDifficulty().getDifficultyId() < 1;
		
		if (thirstExhaustion > 5F)
		{
			thirstExhaustion = 0;
			if (thirstSaturation > 0F) { thirstSaturation = Math.max(thirstSaturation - 1F, 0); }
			else if (!isPeaceful) { thirstLevel = Math.max(thirstLevel - 1, 0); }
		}
		
		this.writeData();
	}
	
	public void readData()
	{
		if (player != null) 
		{
			NBTTagCompound oldnbt = player.getEntityData();
			NBTTagCompound nbt = oldnbt.getCompoundTag("MiscMod");
			if (nbt.hasKey("level")) {
				thirstLevel = nbt.getInteger("level");
				thirstSaturation = nbt.getFloat("saturation");
				timer = nbt.getInteger("timer");
				thirstExhaustion = nbt.getInteger("exhaustion");
			}
			else
			{
				nbt.setInteger("level", 20);
				nbt.setFloat("saturation", 10);
				nbt.setFloat("exhaustion", 0);
				nbt.setInteger("timer", 0);
			}
		}
	}

	public void writeData()
	{
		if (player != null) 
		{
			NBTTagCompound oldNBT = player.getEntityData();
			NBTTagCompound nbt = oldNBT.getCompoundTag("MiscMod");
			if (!oldNBT.hasKey("MiscMod")) {
				oldNBT.setTag("MiscMod", nbt);
			}
			nbt.setInteger("level", thirstLevel);
			nbt.setFloat("saturation", thirstSaturation);
			nbt.setFloat("exhaustion", thirstExhaustion);
			nbt.setInteger("timer", timer);
		} 
	}
	
	public void calculateExhaustion(EntityPlayer player)
	{
		float movement = player.isRiding() ? 0 : player.getAIMoveSpeed();
		if (movement > 0)
		{
			if (player.isSprinting()) { addExhaustion(0.1F * movement * 0.018F); }
			else if (player.isSneaking()) { addExhaustion(0.001F * movement * 0.018F); }
			else { addExhaustion(0.01F * movement * 0.018F); }
		}
	}
	
	public void addExhaustion(float exh)
	{
		thirstExhaustion = Math.min(thirstExhaustion + exh, 40F);
	}

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		
		return false;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		
		return null;
	}
	
}
