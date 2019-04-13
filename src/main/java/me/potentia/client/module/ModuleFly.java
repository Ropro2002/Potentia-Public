package me.potentia.client.module;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;

public class ModuleFly extends Module {
    Minecraft mc;

    public ModuleFly(String name) {
        super(name);
    }

    @Override
    public void onEnable() {
        mc = Minecraft.getMinecraft();
        mc.player.capabilities.isFlying = true;
        if (mc.player.capabilities.isCreativeMode) return;
        mc.player.capabilities.allowFlying = true;

    }

    @Override
    public void onDisable() {
        mc.player.capabilities.isFlying = false;
        if (mc.player.capabilities.isCreativeMode) return;
        mc.player.capabilities.allowFlying = false;
    }

    @Override
    public void onTick(ClientTickEvent event) {
        mc.player.capabilities.isFlying = true;
        if (mc.player.capabilities.isCreativeMode) return;
        mc.player.capabilities.allowFlying = true;
    }

}
