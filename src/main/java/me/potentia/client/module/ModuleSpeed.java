package me.potentia.client.module;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;

public class ModuleSpeed extends Module {
    Minecraft mc;

    public ModuleSpeed(String name) {
        super(name);
        this.getSettings().put("speed", "1");
    }

    @Override
    public void onEnable() {
        mc = Minecraft.getMinecraft();
    }

    @Override
    public void onDisable() {
    }

    @Override
    public void onTick(ClientTickEvent event) {
        if((mc.player.moveForward != 0 || mc.player.moveStrafing != 0)
                && !mc.player.isSneaking() && mc.player.onGround) {
            mc.player.motionX *= Double.parseDouble(this.getSettings().get("speed"));
            mc.player.motionZ *= Double.parseDouble(this.getSettings().get("speed"));
        }
    }

}
