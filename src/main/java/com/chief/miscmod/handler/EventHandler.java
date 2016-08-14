package com.chief.miscmod.handler;

import org.apache.logging.log4j.Logger;

import com.chief.miscmod.IThirst;
import com.chief.miscmod.SimpleCapabilityProvider;
import com.chief.miscmod.client.gui.ThirstGui;
import com.chief.miscmod.reference.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;



public class EventHandler {
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onRenderGameOverlayEvent(RenderGameOverlayEvent event)
	{
		int width = event.getResolution().getScaledWidth();
		int height = event.getResolution().getScaledHeight();
		if (event.getType() != null)
		{
			if (event.getType().equals(ElementType.FOOD))
			{
				if (Minecraft.getMinecraft().thePlayer != null && !Minecraft.getMinecraft().thePlayer.isRidingHorse())
				{
					 ThirstGui.renderThirst(width, height);
				}
			}
		}
	}
	
	@CapabilityInject(IThirst.class)
	static Capability<IThirst> THIRST_CAP = null;
	
	public static ICapabilityProvider createProvider()
	{
		return new SimpleCapabilityProvider<IThirst>(THIRST_CAP, null);
	}
	
	@SubscribeEvent
	public void onAttachCapabilitiesEvent(AttachCapabilitiesEvent.Entity event)
	{
		if (event.getEntity() == Minecraft.getMinecraft().thePlayer)
		{
			event.addCapability(new ResourceLocation(Reference.MOD_ID, "Thirst"), createProvider());
		}
		
	}
}
