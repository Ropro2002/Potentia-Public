package me.potentia.client.listener;

import me.potentia.client.util.ChatUtils;

import me.potentia.client.command.Command;
import me.potentia.client.command.Commands;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.ITextComponent.Serializer;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ClientChatListener {
	@SubscribeEvent
	public static void onClientChat(ClientChatEvent event) {
		String[] args = event.getMessage().split(" ");
		if (args[0].startsWith(Commands.getPrefix())) {
			try {
				Minecraft.getMinecraft().ingameGUI.getChatGUI().addToSentMessages(event.getOriginalMessage());
				event.setCanceled(true);
				if (Commands.getRegistered().containsKey(args[0].replace(Commands.getPrefix(), ""))) {
					Command command = Commands.getRegistered().get(args[0].replace(Commands.getPrefix(), ""));
					if (command.onCommand(args[0], args)) {
						ChatUtils.printMessage(Serializer.fromJsonLenient("{\"text\":\"Usage: " + Commands.getPrefix() + command.getUsage() + "\",\"color\":\"red\"}"));
					}
				} else {
					ChatUtils.printMessage(Serializer.fromJsonLenient("{\"text\":\"Unknown command. Type \\\"" + Commands.getPrefix() + "help\\\" for help.\",\"color\":\"red\"}"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
