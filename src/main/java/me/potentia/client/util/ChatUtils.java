package me.potentia.client.util;

import me.potentia.client.module.Modules;
import me.potentia.client.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.ITextComponent.Serializer;

public class ChatUtils {
	
	public static void printMessage(ChatType type, ITextComponent message) {
		Minecraft.getMinecraft().ingameGUI.addChatMessage(type, message);
	}
	
	public static void printMessage(ITextComponent message) {
		printMessage(ChatType.SYSTEM, message);
	}
	
	public static ITextComponent coloredString(String message, String color) {
		return Serializer.jsonToComponent("{\"text\":\"" + message + "\",\"color\":\"" + color + "\"}");
	}
	
	public static ITextComponent toggledMsg(Module module) {
		return coloredString(module.getDisplayName() + " has been " + (Modules.isEnabled(module.getId()) ? "enabled" : "disabled"), "red");
	}
}
