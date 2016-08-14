package com.chief.miscmod.client.gui;

import com.chief.miscmod.client.player.Thirst;
import com.chief.miscmod.utility.LogHelper;

import javafx.event.Event;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ThirstGui {
	public static Minecraft mc = Minecraft.getMinecraft();
	public static int updateCounter;
	public static EntityPlayer player;
	
	public static void renderThirst(int rWidth, int rHeight)
	{
		LogHelper.error("Entered renderThirst function");
		// TODO: Change the for-loop to accomodate for less than 10 thirst bars
		bind(new ResourceLocation("miscmod:textures/gui/thirstBar.png"));
		GuiIngame ingameGUI = mc.ingameGUI;
		updateCounter = mc.ingameGUI.getUpdateCounter();
		LogHelper.error("Setting thirstLevel variable with nbt data from player");
		int thirstLevel;

		int[] eTextureStart = new int[] {1, 1};// Empty waterdrop texture position start {x, y}
		int[] eTextureEnd = new int[] {7, 9};// Empty waterdrop texture position end {x, y}
		int[] hTextureStart = new int[] {17, 1};// half waterdrop texture start {x, y}
		int[] hTextureEnd = new int[] {23, 9};// half waterdrop texture end {x, y}
		int[] fTextureStart = new int[] {9, 9};// Waterdrop texture start {x, y}
		int[] fTextureEnd = new int[] {15, 9};// Waterdrop texture end {x, y}
		
		
		for (int i = 0; i < 10; i++)
		{	
			int width = ((rWidth / 2) + 91) - (i * 8) - 9;
			int height = rHeight - 49;
			ingameGUI.drawTexturedModalRect(width, height, eTextureStart[0], eTextureStart[1], eTextureEnd[0], eTextureEnd[1]);
		}
		
		
		int forTemp = 1;
		int counter = 1;
		boolean isThirstOdd = false;
		/*
		if (thirstLevel % 2 == 1) 
		{
			forTemp = thirstLevel - 1;
			isThirstOdd = !isThirstOdd;
		}
		
		for (int i = 0; i < forTemp; i++)
		{
			int width = ((rWidth / 2) + 91) - (i * 8) - 9;
			int height = rHeight - 49;
			ingameGUI.drawTexturedModalRect(width, height, fTextureStart[0], fTextureStart[1], fTextureEnd[0], fTextureEnd[1]);
			counter = i;
		}
		
		if (isThirstOdd)
		{
			int width = ((rWidth / 2) + 91) - (counter * 8) - 9;
			int height = rHeight - 49;
			ingameGUI.drawTexturedModalRect(width, height, hTextureStart[0], hTextureStart[1], hTextureEnd[0], hTextureEnd[1]);			
		}
		*/
		

		
		bind(Gui.ICONS);
	}
	
	private static void bind(ResourceLocation res)
	{
		mc.getMinecraft().getTextureManager().bindTexture(res);
	}
}
