package com.guest_dc.soundreload;

import net.minecraft.client.Minecraft;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ClientProxy extends CommonProxy {

    @Override
    public void reloadSounds() {
        // Schedule a task to run on the next client tick
        FMLCommonHandler.instance().bus().register(this);
    }

    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event) {
        // Only run once
        Minecraft.getMinecraft().refreshResources();
        System.out.println("[SoundReloadFix] Reloaded resources to fix sound init race condition.");

        // Unregister after running once
        FMLCommonHandler.instance().bus().unregister(this);
    }
}
