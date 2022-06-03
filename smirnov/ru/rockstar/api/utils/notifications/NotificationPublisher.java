// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.utils.notifications;

import net.minecraft.util.text.TextFormatting;
import ru.rockstar.api.utils.render.DrawHelper;
import java.awt.Color;
import net.minecraft.client.renderer.GlStateManager;
import ru.rockstar.api.utils.render.Shifting;
import ru.rockstar.api.utils.render.AnimationHelper;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.Minecraft;
import ru.rockstar.client.features.Feature;
import ru.rockstar.client.features.impl.display.Notifications;
import ru.rockstar.Main;
import ru.rockstar.api.utils.font.FontRenderer;
import ru.rockstar.api.utils.font.CFont;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.List;
import ru.rockstar.api.utils.Helper;

public final class NotificationPublisher implements Helper
{
    private static final /* synthetic */ List<Notification> notifications;
    
    static {
        notifications = new CopyOnWriteArrayList<Notification>();
    }
    
    public static void queue(final String llllllllllIlllIIIllllllIlIIIlIll, final String llllllllllIlllIIIllllllIlIIIIllI, final NotificationType llllllllllIlllIIIllllllIlIIIlIIl) {
        final FontRenderer llllllllllIlllIIIllllllIlIIIlIII = NotificationPublisher.mc.neverlose500_16;
        NotificationPublisher.notifications.add(new Notification(llllllllllIlllIIIllllllIlIIIlIll, llllllllllIlllIIIllllllIlIIIIllI, llllllllllIlllIIIllllllIlIIIlIIl, llllllllllIlllIIIllllllIlIIIlIII));
    }
    
    public static void publish() {
        if (Main.featureDirector.getFeatureByClass(Notifications.class).isToggled()) {
            final ScaledResolution llllllllllIlllIIIllllllIlIlIIlII = new ScaledResolution(Minecraft.getMinecraft());
            final int llllllllllIlllIIIllllllIlIlIIIll = llllllllllIlllIIIllllllIlIlIIlII.getScaledHeight();
            final int llllllllllIlllIIIllllllIlIlIIIlI = llllllllllIlllIIIllllllIlIlIIlII.getScaledWidth();
            int llllllllllIlllIIIllllllIlIlIIIIl = llllllllllIlllIIIllllllIlIlIIIll - 60;
            for (final Notification llllllllllIlllIIIllllllIlIlIIIII : NotificationPublisher.notifications) {
                final Shifting llllllllllIlllIIIllllllIlIIlllll = llllllllllIlllIIIllllllIlIlIIIII.getTranslate();
                final int llllllllllIlllIIIllllllIlIIllllI = llllllllllIlllIIIllllllIlIlIIIII.getWidth();
                if (!llllllllllIlllIIIllllllIlIlIIIII.getTimer().elapsed(llllllllllIlllIIIllllllIlIlIIIII.getTime())) {
                    llllllllllIlllIIIllllllIlIlIIIII.scissorBoxWidth = AnimationHelper.animate(llllllllllIlllIIIllllllIlIIllllI, llllllllllIlllIIIllllllIlIlIIIII.scissorBoxWidth, 0.05 * Minecraft.getSystemTime() / 5.0);
                    Shifting.interpolate(llllllllllIlllIIIllllllIlIlIIIlI - llllllllllIlllIIIllllllIlIIllllI, llllllllllIlllIIIllllllIlIlIIIIl, 0.015);
                }
                else {
                    llllllllllIlllIIIllllllIlIlIIIII.scissorBoxWidth = AnimationHelper.animate(0.0, llllllllllIlllIIIllllllIlIlIIIII.scissorBoxWidth, 0.05 * Minecraft.getSystemTime() / 4.0);
                    if (llllllllllIlllIIIllllllIlIlIIIII.scissorBoxWidth < 1.0) {
                        NotificationPublisher.notifications.remove(llllllllllIlllIIIllllllIlIlIIIII);
                    }
                    llllllllllIlllIIIllllllIlIlIIIIl += 30;
                }
                final float llllllllllIlllIIIllllllIlIIlllIl = (float)llllllllllIlllIIIllllllIlIIlllll.getX();
                final float llllllllllIlllIIIllllllIlIIlllII = (float)llllllllllIlllIIIllllllIlIIlllll.getY();
                GlStateManager.pushMatrix();
                GlStateManager.disableBlend();
                DrawHelper.drawGlowRoundedRect(llllllllllIlllIIIllllllIlIIlllIl - 92.0f, llllllllllIlllIIIllllllIlIIlllII, (float)llllllllllIlllIIIllllllIlIlIIIlI, llllllllllIlllIIIllllllIlIIlllII + 28.0f, new Color(35, 34, 34, 220).getRGB(), 5.0f, 5.0f);
                final String llllllllllIlllIIIllllllIlIIllIll = " (" + llllllllllIlllIIIllllllIlIlIIIII.getTimer().getElapsedTime() / 5L + "s)";
                NotificationPublisher.mc.mntsb_18.drawStringWithShadow(TextFormatting.BOLD + llllllllllIlllIIIllllllIlIlIIIII.getTitle(), llllllllllIlllIIIllllllIlIIlllIl - 70.0f + 5.0f, llllllllllIlllIIIllllllIlIIlllII + 7.0f, -1);
                NotificationPublisher.mc.mntsb.drawStringWithShadow(llllllllllIlllIIIllllllIlIlIIIII.getContent(), llllllllllIlllIIIllllllIlIIlllIl - 70.0f + 5.0f, llllllllllIlllIIIllllllIlIIlllII + 17.0f, new Color(245, 245, 245).getRGB());
                DrawHelper.drawCircle(llllllllllIlllIIIllllllIlIIlllIl - 78.0f, llllllllllIlllIIIllllllIlIIlllII + 14.0f, 0.0f, 360.0f, 7.0f, 3.0f, false, new Color(52, 52, 52, 220));
                DrawHelper.drawCircle(llllllllllIlllIIIllllllIlIIlllIl - 78.0f, llllllllllIlllIIIllllllIlIIlllII + 14.0f, 10.0f, (float)(400L - llllllllllIlllIIIllllllIlIlIIIII.getTimer().getElapsedTime() / 5L), 7.0f, 3.0f, false, new Color(255, 255, 255, 220));
                GlStateManager.popMatrix();
                if (NotificationPublisher.notifications.size() > 1) {
                    llllllllllIlllIIIllllllIlIlIIIIl -= 35;
                }
            }
        }
    }
}
