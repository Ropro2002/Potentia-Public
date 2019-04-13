package me.potentia.client.command;

import me.potentia.client.module.Module;
import me.potentia.client.module.Modules;
import me.potentia.client.util.ChatUtils;

public class CommandSpeed extends Command {

    @Override
    public boolean onCommand(String command, String[] args) {
        Module walkspeed = Modules.getById("speed");
        if (args.length > 1) {
            walkspeed.getSettings().put("speed", args[1]);
            ChatUtils.printMessage(ChatUtils.coloredString("Updated speed.", "red"));

        } else {
            Modules.toggle(walkspeed.getId());
            ChatUtils.printMessage(ChatUtils.toggledMsg(walkspeed));
        }
        return false;
    }

    @Override
    public String getUsage() {
        return "speed [speed] and speed to enable";
    }

    @Override
    public String getDescription() {
        return "Increase or decrease walking speed";
    }

}
