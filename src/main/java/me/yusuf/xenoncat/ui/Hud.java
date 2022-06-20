package me.yusuf.xenoncat.ui;

import java.awt.Color;
import java.util.Collections;
import java.util.Comparator;

import me.yusuf.xenoncat.Main;
import me.yusuf.xenoncat.module.ModuleManager;
import me.yusuf.xenoncat.util.Refrence;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Hud extends Gui{
	
	private Minecraft mc = Minecraft.getMinecraft();
	
	/*
	public static class ModuleComparator implements Comparator<Module>{

		@Override
		public int compare(Module o1, Module o2) {
			
			
			if(Minecraft.getMinecraft().fontRenderer.getStringWidth(o1.getName()) > Minecraft.getMinecraft().fontRenderer.getStringWidth(o2.getName())) {
				return -1;
			}
			if(Minecraft.getMinecraft().fontRenderer.getStringWidth(o1.getName()) > Minecraft.getMinecraft().fontRenderer.getStringWidth(o2.getName())) {
				return 1;
			}
			return 0;
			
		}
		
	}
	*/
	
	//private final ResourceLocation logoWatermark = new ResourceLocation(Refrence.MOD_ID, "textures/XenonCatLogo.png");
	
	@SubscribeEvent
	public void renderOverlay(RenderGameOverlayEvent event) {
		//Collections.sort(Main.moduleManager.modules, new ModuleComparator());
		ScaledResolution sr = new ScaledResolution(mc);
		FontRenderer fr = mc.fontRenderer;
		/*
		if(event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
			//mc.renderEngine.bindTexture(logoWatermark);
			//drawScaledCustomSizeModalRect(-2, 20, 0, 0, 50, 50, 50, 50, 50, 50);
		}*/
		
		if(event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
			if(ModuleManager.getModule("AmogusHUD").isToggled()){
				fr.drawStringWithShadow("A", 2, 1, rainbow(1));
				fr.drawString("mogus Client (Sussy Edition)", 8, 1, -1);
			}else{
				fr.drawStringWithShadow("X", 2, 1, rainbow(1));
				fr.drawString("enonCat ^._.^", 8, 1, -1);
			}
		}
		
		if(event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
			int y = 2;
			
			final int[] counter = {0};
			
			for(me.yusuf.xenoncat.module.Module mod : me.yusuf.xenoncat.Main.moduleManager.getModuleList()) {
				if(!mod.getName().equalsIgnoreCase("") && mod.isToggled()) {
					fr.drawStringWithShadow(mod.getName(), sr.getScaledWidth() - fr.getStringWidth(mod.getName()) - 2, y, rainbow(counter[0]));
					y += fr.FONT_HEIGHT;
					counter[0]++;
				}
			}
		}
			
	}
		
	
	public static int rainbow(int delay) {
		double rs = Math.ceil((System.currentTimeMillis() + delay) / 20.0);
		rs %= 360;
		return (Color.HSBtoRGB((float) (rs / 360.0f), 0.5f, 1f));
	}
}
