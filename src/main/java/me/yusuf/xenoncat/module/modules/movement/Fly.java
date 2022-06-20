package me.yusuf.xenoncat.module.modules.movement;

import me.yusuf.xenoncat.module.Category;
import me.yusuf.xenoncat.module.Module;
import me.yusuf.xenoncat.util.Refrence;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;

//@Mod.EventBusSubscriber(modid = Refrence.MOD_ID, Bus = Bus.FORGE)
public class Fly extends Module {
    public Fly() {
        super("Fly", "Makes you fly", Category.MOVEMENT);
        this.setKey(Keyboard.KEY_G);
        //MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public void onDisable() {
        Minecraft.getMinecraft().player.capabilities.isFlying = false;
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event){
        if(this.isToggled()){
            Minecraft.getMinecraft().player.capabilities.isFlying = true;

        }
    }
}
