// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.misc;

import ru.rockstar.api.utils.notifications.NotificationPublisher;
import ru.rockstar.api.utils.notifications.NotificationType;
import ru.rockstar.Main;
import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.gui.GuiPlayerTabOverlay;
import ru.rockstar.api.event.event.EventUpdate;
import ru.rockstar.client.features.Category;
import ru.rockstar.api.event.EventTarget;
import net.minecraft.network.play.server.SPacketPlayerListItem;
import ru.rockstar.api.event.event.EventReceivePacket;
import ru.rockstar.client.features.Feature;

public class StaffAlert extends Feature
{
    public /* synthetic */ boolean isJoined;
    
    @EventTarget
    public void onReceivePacket(final EventReceivePacket llllllllllllIIIlIllIllIlIlIIlIlI) {
        if (llllllllllllIIIlIllIllIlIlIIlIlI.getPacket() instanceof SPacketPlayerListItem) {
            final SPacketPlayerListItem llllllllllllIIIlIllIllIlIlIIllII = (SPacketPlayerListItem)llllllllllllIIIlIllIllIlIlIIlIlI.getPacket();
            if (llllllllllllIIIlIllIllIlIlIIllII.getAction() == SPacketPlayerListItem.Action.UPDATE_LATENCY) {
                this.isJoined = true;
            }
        }
    }
    
    public StaffAlert() {
        super("StaffAlert", "\u041e\u043f\u043e\u0432\u0435\u0449\u0430\u0435\u0442 \u043e \u043c\u043e\u0434\u0435\u0440\u0435/\u0445\u0435\u043b\u043f\u0435\u0440\u0435 \u043d\u0430 \u0441\u0435\u0440\u0432\u0435\u0440\u0435", 0, Category.MISC);
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate llllllllllllIIIlIllIllIlIlIIIlII) {
        for (final EntityPlayer llllllllllllIIIlIllIllIlIlIIIIll : GuiPlayerTabOverlay.getPlayers()) {
            if (llllllllllllIIIlIllIllIlIlIIIIll != null && llllllllllllIIIlIllIllIlIlIIIIll != StaffAlert.mc.player && (llllllllllllIIIlIllIllIlIlIIIIll.getDisplayName().getUnformattedText().contains("HELPER") || llllllllllllIIIlIllIllIlIlIIIIll.getDisplayName().getUnformattedText().contains("SHELPER-1") || llllllllllllIIIlIllIllIlIlIIIIll.getDisplayName().getUnformattedText().contains("SHELPER") || llllllllllllIIIlIllIllIlIlIIIIll.getDisplayName().getUnformattedText().contains("SHELPER-2") || llllllllllllIIIlIllIllIlIlIIIIll.getDisplayName().getUnformattedText().contains("MODER") || llllllllllllIIIlIllIllIlIlIIIIll.getDisplayName().getUnformattedText().contains("J.MODER")) && llllllllllllIIIlIllIllIlIlIIIIll.ticksExisted < 10 && this.isJoined) {
                Main.msg(ChatFormatting.RED + "Staff " + ChatFormatting.UNDERLINE + llllllllllllIIIlIllIllIlIlIIIIll.getName() + ChatFormatting.WHITE + " was connected to server, or teleported!", true);
                NotificationPublisher.queue("Staff Alert", ChatFormatting.RED + "Staff " + ChatFormatting.UNDERLINE + llllllllllllIIIlIllIllIlIlIIIIll.getName() + ChatFormatting.WHITE + " was connected to server, or teleported!", NotificationType.WARNING);
                this.isJoined = false;
            }
        }
    }
}
