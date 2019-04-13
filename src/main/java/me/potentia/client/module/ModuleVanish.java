package me.potentia.client.module;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.network.play.client.CPacketVehicleMove;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;

public class ModuleVanish extends Module {
	Minecraft mc;
	Entity entity;
	
	public ModuleVanish(String name) {
		super(name);
	}

	@Override
	public void onEnable() {
		mc = Minecraft.getMinecraft();
		if (mc.player.getRidingEntity() != null) {
			entity = mc.player.getRidingEntity();
			mc.player.dismountRidingEntity();
			mc.world.removeEntity(entity);
		}
	}

	@Override
	public void onDisable() {
	}

	@Override
	public void onTick(ClientTickEvent event) {
		if (entity != null) {
			try {
				entity.posX = mc.player.posX;
				entity.posY = mc.player.posY;
				entity.posZ = mc.player.posZ;
				mc.getConnection().sendPacket(new CPacketVehicleMove(entity));
			} catch (Exception e1) {}
		}
	}
}
