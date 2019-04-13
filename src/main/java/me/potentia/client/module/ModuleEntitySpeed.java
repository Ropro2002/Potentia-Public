package me.potentia.client.module;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.passive.EntityLlama;
import net.minecraft.util.MovementInput;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;

public class ModuleEntitySpeed extends Module {

	private double speed = 1;

	public ModuleEntitySpeed(String name) {
		super(name);
		this.getSettings().put("entityspeed", "1");
	}

	@Override
	public void onEnable() {
		try {
			speed = Double.parseDouble(this.getSettings().get("entityspeed"));
		} catch (Exception e) {
			speed = 1;
		}
	}

	@Override
	public void onDisable() {
	}

	@Override
	public void onTick(ClientTickEvent event) {
		try {
			Minecraft mc = Minecraft.getMinecraft();
			if (mc.player.getRidingEntity() != null) {
				Entity theEntity = mc.player.getRidingEntity();
				speedEntity(theEntity, speed);
			}
		} catch (Exception e1) {
		}
	}

	private static void speedEntity(Entity entity, Double speed) {
		Minecraft mc = Minecraft.getMinecraft();
		if (entity instanceof EntityLlama) {
			entity.rotationYaw = mc.player.rotationYaw;
			((EntityLlama) entity).rotationYawHead = mc.player.rotationYawHead;
		}
		MovementInput movementInput = mc.player.movementInput;
		double forward = movementInput.moveForward;
		double strafe = movementInput.moveStrafe;
		float yaw = mc.player.rotationYaw;
		if ((forward == 0.0D) && (strafe == 0.0D)) {
			entity.motionX = 0.0D;
			entity.motionZ = 0.0D;
		} else {
			if (forward != 0.0D) {
				if (strafe > 0.0D) {
					yaw += (forward > 0.0D ? -45 : 45);
				} else if (strafe < 0.0D) {
					yaw += (forward > 0.0D ? 45 : -45);
				}
				strafe = 0.0D;
				if (forward > 0.0D) {
					forward = 1.0D;
				} else if (forward < 0.0D) {
					forward = -1.0D;
				}
			}
			entity.motionX = (forward * speed * Math.cos(Math.toRadians(yaw + 90.0F)) + strafe * speed * Math.sin(Math.toRadians(yaw + 90.0F)));
			entity.motionZ = (forward * speed * Math.sin(Math.toRadians(yaw + 90.0F)) - strafe * speed * Math.cos(Math.toRadians(yaw + 90.0F)));
			if (entity instanceof EntityMinecart) {
				EntityMinecart em = (EntityMinecart) entity;
				em.setVelocity((forward * speed * Math.cos(Math.toRadians(yaw + 90.0F)) + strafe * speed * Math.sin(Math.toRadians(yaw + 90.0F))), em.motionY, (forward * speed * Math.sin(Math.toRadians(yaw + 90.0F)) - strafe * speed * Math.cos(Math.toRadians(yaw + 90.0F))));
			}
		}
	}

}
