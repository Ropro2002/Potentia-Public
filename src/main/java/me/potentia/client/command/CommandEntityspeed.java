package me.potentia.client.command;

import me.potentia.client.module.Modules;
import me.potentia.client.util.ChatUtils;
import me.potentia.client.module.Module;

public class CommandEntityspeed extends Command {

    @Override
    public boolean onCommand(String command, String[] args) {
        Module entityspeed = Modules.getById("entityspeed");
        if (args.length > 1) {
            entityspeed.getSettings().put("entityspeed", args[1]);
            ChatUtils.printMessage(ChatUtils.coloredString("Updated entity speed.", "red"));

        } else {
            Modules.toggle(entityspeed.getId());
            ChatUtils.printMessage(ChatUtils.toggledMsg(entityspeed));
        }
        return false;
    }

    @Override
    public String getUsage() {
        return "entityspeed [speed] and entityspeed to enable";
    }

    @Override
    public String getDescription() {
        return "Used to speed up your entity";
    }

}
