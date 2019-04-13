package me.potentia.client.command;

import me.potentia.client.module.Modules;
import me.potentia.client.util.ChatUtils;
import me.potentia.client.module.Module;

public class CommandVanish extends Command {


    @Override
    public boolean onCommand(String command, String[] args) {
        Module vanish = Modules.getById("vanish");
        Modules.toggle(vanish.getId());
        ChatUtils.printMessage(ChatUtils.toggledMsg(vanish));
        return false;
    }

    @Override
    public String getUsage() {
        return "vanish";
    }

    @Override
    public String getDescription() {
        return "Used to do the godmode exploit";
    }
}
