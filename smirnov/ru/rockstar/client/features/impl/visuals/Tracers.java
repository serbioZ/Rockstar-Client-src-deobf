// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.visuals;

import ru.rockstar.api.event.EventTarget;
import net.minecraft.util.math.Vec3d;
import ru.rockstar.api.utils.render.DrawHelper;
import ru.rockstar.api.utils.friend.FriendManager;
import ru.rockstar.Main;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;
import ru.rockstar.api.event.event.Event3D;
import ru.rockstar.client.ui.settings.Setting;
import java.awt.Color;
import ru.rockstar.client.features.Category;
import ru.rockstar.client.ui.settings.impl.ColorSetting;
import ru.rockstar.client.ui.settings.impl.NumberSetting;
import ru.rockstar.client.ui.settings.impl.BooleanSetting;
import ru.rockstar.client.features.Feature;

public class Tracers extends Feature
{
    public static /* synthetic */ BooleanSetting friend;
    public static /* synthetic */ NumberSetting width;
    public static /* synthetic */ ColorSetting colorGlobal;
    public static /* synthetic */ BooleanSetting onlyPlayer;
    public static /* synthetic */ BooleanSetting seeOnly;
    
    public Tracers() {
        super("Tracers", "\u041f\u043e\u043a\u0430\u0437\u044b\u0432\u0430\u0435\u0442 \u043b\u0438\u043d\u0438\u044e \u043a \u0438\u0433\u0440\u043e\u043a\u0430\u043c", 0, Category.VISUALS);
        Tracers.friend = new BooleanSetting("Friend Highlight", true, () -> true);
        Tracers.colorGlobal = new ColorSetting("Tracers Color", new Color(16777215).getRGB(), () -> true);
        Tracers.width = new NumberSetting("Tracers Width", 1.5f, 0.1f, 5.0f, 0.1f, () -> true);
        this.addSettings(Tracers.colorGlobal, Tracers.friend, Tracers.seeOnly, Tracers.onlyPlayer, Tracers.width);
    }
    
    static {
        Tracers.onlyPlayer = new BooleanSetting("Only Player", true, () -> true);
        Tracers.seeOnly = new BooleanSetting("See Only", false, () -> true);
    }
    
    public static double angleDifference(final float llllllllllllIIlIllllIIIllIIIllll, final float llllllllllllIIlIllllIIIllIIIlIll) {
        float llllllllllllIIlIllllIIIllIIIllIl = Math.abs(llllllllllllIIlIllllIIIllIIIllll - llllllllllllIIlIllllIIIllIIIlIll) % 360.0f;
        if (llllllllllllIIlIllllIIIllIIIllIl > 180.0f) {
            llllllllllllIIlIllllIIIllIIIllIl = 360.0f - llllllllllllIIlIllllIIIllIIIllIl;
        }
        return llllllllllllIIlIllllIIIllIIIllIl;
    }
    
    @EventTarget
    public void onEvent3D(final Event3D llllllllllllIIlIllllIIIlIlllIlll) {
        final Color llllllllllllIIlIllllIIIlIllllllI = new Color(Tracers.colorGlobal.getColorValue());
        for (final Entity llllllllllllIIlIllllIIIlIlllllIl : Tracers.mc.world.loadedEntityList) {
            if (llllllllllllIIlIllllIIIlIlllllIl != Tracers.mc.player) {
                if (Tracers.onlyPlayer.getBoolValue() && !(llllllllllllIIlIllllIIIlIlllllIl instanceof EntityPlayer)) {
                    continue;
                }
                if (Tracers.seeOnly.getBoolValue() && !canSeeEntityAtFov(llllllllllllIIlIllllIIIlIlllllIl, 150.0f)) {
                    return;
                }
                final boolean llllllllllllIIlIllllIIIlIlllllII = Tracers.mc.gameSettings.viewBobbing;
                Tracers.mc.gameSettings.viewBobbing = false;
                Tracers.mc.entityRenderer.setupCameraTransform(llllllllllllIIlIllllIIIlIlllIlll.getPartialTicks(), 0);
                Tracers.mc.gameSettings.viewBobbing = llllllllllllIIlIllllIIIlIlllllII;
                final double n = llllllllllllIIlIllllIIIlIlllllIl.lastTickPosX + (llllllllllllIIlIllllIIIlIlllllIl.posX - llllllllllllIIlIllllIIIlIlllllIl.lastTickPosX) * llllllllllllIIlIllllIIIlIlllIlll.getPartialTicks();
                Tracers.mc.getRenderManager();
                final double llllllllllllIIlIllllIIIlIllllIll = n - RenderManager.renderPosX;
                final double n2 = llllllllllllIIlIllllIIIlIlllllIl.lastTickPosY + (llllllllllllIIlIllllIIIlIlllllIl.posY - llllllllllllIIlIllllIIIlIlllllIl.lastTickPosY) * llllllllllllIIlIllllIIIlIlllIlll.getPartialTicks();
                Tracers.mc.getRenderManager();
                final double llllllllllllIIlIllllIIIlIllllIlI = n2 - RenderManager.renderPosY - 1.0;
                final double n3 = llllllllllllIIlIllllIIIlIlllllIl.lastTickPosZ + (llllllllllllIIlIllllIIIlIlllllIl.posZ - llllllllllllIIlIllllIIIlIlllllIl.lastTickPosZ) * llllllllllllIIlIllllIIIlIlllIlll.getPartialTicks();
                Tracers.mc.getRenderManager();
                final double llllllllllllIIlIllllIIIlIllllIIl = n3 - RenderManager.renderPosZ;
                GlStateManager.blendFunc(770, 771);
                GlStateManager.enable(3042);
                GlStateManager.enable(2848);
                GlStateManager.glLineWidth(Tracers.width.getNumberValue());
                GlStateManager.disable(3553);
                GlStateManager.disable(2929);
                GlStateManager.depthMask(false);
                final FriendManager friendManager = Main.instance.friendManager;
                if (FriendManager.isFriend(llllllllllllIIlIllllIIIlIlllllIl.getName()) && Tracers.friend.getBoolValue()) {
                    DrawHelper.glColor(new Color(0, 255, 0));
                }
                else {
                    DrawHelper.glColor(new Color(Tracers.colorGlobal.getColorValue()));
                }
                GlStateManager.glBegin(3);
                final Vec3d llllllllllllIIlIllllIIIlIllllIII = new Vec3d(0.0, 0.0, 1.0).rotatePitch((float)(-Math.toRadians(Tracers.mc.player.rotationPitch))).rotateYaw((float)(-Math.toRadians(Tracers.mc.player.rotationYaw)));
                GlStateManager.glVertex3d(llllllllllllIIlIllllIIIlIllllIII.xCoord, Tracers.mc.player.getEyeHeight() + llllllllllllIIlIllllIIIlIllllIII.yCoord, llllllllllllIIlIllllIIIlIllllIII.zCoord);
                GlStateManager.glVertex3d(llllllllllllIIlIllllIIIlIllllIll, llllllllllllIIlIllllIIIlIllllIlI + 1.1, llllllllllllIIlIllllIIIlIllllIIl);
                GlStateManager.glEnd();
                GlStateManager.enable(3553);
                GlStateManager.disable(2848);
                GlStateManager.enable(2929);
                GlStateManager.depthMask(true);
                GlStateManager.disable(3042);
                GlStateManager.resetColor();
            }
        }
    }
    
    public static boolean canSeeEntityAtFov(final Entity llllllllllllIIlIllllIIIllIIllllI, final float llllllllllllIIlIllllIIIllIIlllIl) {
        final double llllllllllllIIlIllllIIIllIIlllII = llllllllllllIIlIllllIIIllIIllllI.posX - Tracers.mc.player.posX;
        final double llllllllllllIIlIllllIIIllIIllIll = llllllllllllIIlIllllIIIllIIllllI.posZ - Tracers.mc.player.posZ;
        final float llllllllllllIIlIllllIIIllIIllIlI = (float)(Math.toDegrees(Math.atan2(llllllllllllIIlIllllIIIllIIllIll, llllllllllllIIlIllllIIIllIIlllII)) - 90.0);
        final double llllllllllllIIlIllllIIIllIIllIIl = angleDifference(llllllllllllIIlIllllIIIllIIllIlI, Tracers.mc.player.rotationYaw);
        return llllllllllllIIlIllllIIIllIIllIIl <= llllllllllllIIlIllllIIIllIIlllIl;
    }
}
