// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.utils;

import net.minecraft.network.Packet;
import net.minecraft.client.gui.ScaledResolution;
import ru.rockstar.api.utils.world.TimerHelper;
import java.util.Random;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.Minecraft;

public interface Helper
{
    public static final /* synthetic */ Minecraft mc = Minecraft.getMinecraft();
    
    default void sendPacket(final Packet<?> lllllllllllllIlIIIIIlIlllllIlIII) {
        Helper.mc.player.connection.sendPacket(lllllllllllllIlIIIIIlIlllllIlIII);
    }
}
