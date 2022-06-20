package me.yusuf.xenoncat.module;

import java.util.ArrayList;
import java.util.List;

import me.yusuf.xenoncat.Main;
import me.yusuf.xenoncat.module.modules.exploit.NoFall;
import me.yusuf.xenoncat.module.modules.movement.Fly;
import me.yusuf.xenoncat.module.modules.renderer.AmogusHUD;

public class ModuleManager {
	
	public static ArrayList<Module> modules;
	
	public ModuleManager() {
		(modules = new ArrayList<Module>()).clear();
		
		
		
		
		//Combat
		
		//Exploit
		this.modules.add(new NoFall());

		//Movement
		this.modules.add(new Fly());


		//Player

		//Renderer
		this.modules.add(new AmogusHUD());


	}
	
	public static Module getModule(String name) {
		for(Module m : modules) {
			if(m.getName().equalsIgnoreCase(name)) {
				return m;
			}
		}
		
		return null;
	}
	
	public ArrayList<Module> getModuleList(){
		return this.modules;
		
	}
	
	public static List<Module> getModulesByCategory(Category c){
		List<Module> modules = new ArrayList<Module>();
		for(Module m : Main.moduleManager.modules) {
			modules.add(m);
		}
		return modules;
		
	}
	
}
