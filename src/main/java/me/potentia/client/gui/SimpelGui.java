package me.potentia.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;

public class SimpelGui extends Gui {

    public SimpelGui(Minecraft mc) {
        ScaledResolution scaled = new ScaledResolution(mc);
        int width = scaled.getScaledWidth();
        int height = scaled.getScaledHeight();

        drawString(mc.fontRenderer, "Potentia client", 2, 40, Integer.parseInt("FF5555", 16));
        drawString(mc.fontRenderer, "public b1", 2, 50, Integer.parseInt("FF5555", 16));
    }
}
