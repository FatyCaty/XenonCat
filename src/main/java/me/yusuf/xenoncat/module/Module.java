package me.yusuf.xenoncat.module;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;

public class Module {
	
	public String name, desc;
	private int key;
	private Category category;
	public boolean toggled;
	public net.minecraft.client.Minecraft mc;
	
	public Module(String name, String desc, Category category) {
		super();
		this.name = name;
		this.desc = desc;
		this.category = category;
		this.key = 0;
		this.toggled = false;
	}

	public String getDescription() {
		return desc;
	}

	public void setDescription(String desc) {
		this.desc = desc;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public boolean isToggled() {
		return toggled;
	}

	public void setToggled(boolean toggled) {
		this.toggled = toggled;
	}
	
	public void toggle() {
		this.toggled = !this.toggled;
		
		
		if(this.toggled) {
			this.onEnable();
		}else {
			this.onDisable();
		}
	}
	
	public void onEnable(){
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	public void onDisable(){
		MinecraftForge.EVENT_BUS.unregister(this);
	}
	
	public String getName() {
		return this.name;
	}
	
	public Category getCategory(){
		return this.category;
	}
	
}
