package me.yusuf.xenoncat.module;

public enum Category {
	COMBAT("Combat"), MOVEMENT("Movement"), PLAYER("Player"), RENDER("Render"), EXPLOIT("Exploit");

	public String name;
	public int moduleIndex;
	
	Category(String name){
		this.name = name;
	}
}
