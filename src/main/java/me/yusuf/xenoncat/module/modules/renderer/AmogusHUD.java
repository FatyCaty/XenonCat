package me.yusuf.xenoncat.module.modules.renderer;

import me.yusuf.xenoncat.module.Category;
import me.yusuf.xenoncat.module.Module;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

public class AmogusHUD extends Module {
    public AmogusHUD(){
        super("AmogusHUD", "Amogusified Hud!", Category.RENDER);
        this.setKey(Keyboard.KEY_I);
    }

}
