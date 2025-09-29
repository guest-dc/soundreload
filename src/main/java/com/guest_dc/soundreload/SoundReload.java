package com.guest_dc.soundreload;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.SidedProxy;

@Mod(modid = SoundReload.MOD_ID, version = SoundReload.VERSION)
public class SoundReload {
    public static final String MOD_ID = "soundreload";
    public static final String VERSION = "1.0";

    @SidedProxy(clientSide = "com.guest_dc.soundreload.ClientProxy",
            serverSide = "com.guest_dc.soundreload.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.reloadSounds();
    }
}
