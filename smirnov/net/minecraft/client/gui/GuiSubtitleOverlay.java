// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import com.google.common.collect.Lists;
import net.minecraft.client.audio.SoundEventAccessor;
import net.minecraft.client.audio.ISound;
import java.util.Iterator;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.Minecraft;
import java.util.List;
import net.minecraft.client.audio.ISoundEventListener;

public class GuiSubtitleOverlay extends Gui implements ISoundEventListener
{
    private final /* synthetic */ List<Subtitle> subtitles;
    private /* synthetic */ boolean enabled;
    private final /* synthetic */ Minecraft client;
    
    public void renderSubtitles(final ScaledResolution llllllllllllIIIIIlllIllIIllIlIlI) {
        if (!this.enabled && this.client.gameSettings.showSubtitles) {
            this.client.getSoundHandler().addListener(this);
            this.enabled = true;
        }
        else if (this.enabled && !this.client.gameSettings.showSubtitles) {
            this.client.getSoundHandler().removeListener(this);
            this.enabled = false;
        }
        if (this.enabled && !this.subtitles.isEmpty()) {
            GlStateManager.pushMatrix();
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            final Vec3d llllllllllllIIIIIlllIllIlIIIIIIl = new Vec3d(this.client.player.posX, this.client.player.posY + this.client.player.getEyeHeight(), this.client.player.posZ);
            final Vec3d llllllllllllIIIIIlllIllIlIIIIIII = new Vec3d(0.0, 0.0, -1.0).rotatePitch(-this.client.player.rotationPitch * 0.017453292f).rotateYaw(-this.client.player.rotationYaw * 0.017453292f);
            final Vec3d llllllllllllIIIIIlllIllIIlllllll = new Vec3d(0.0, 1.0, 0.0).rotatePitch(-this.client.player.rotationPitch * 0.017453292f).rotateYaw(-this.client.player.rotationYaw * 0.017453292f);
            final Vec3d llllllllllllIIIIIlllIllIIllllllI = llllllllllllIIIIIlllIllIlIIIIIII.crossProduct(llllllllllllIIIIIlllIllIIlllllll);
            int llllllllllllIIIIIlllIllIIlllllIl = 0;
            int llllllllllllIIIIIlllIllIIlllllII = 0;
            final Iterator<Subtitle> llllllllllllIIIIIlllIllIIllllIll = this.subtitles.iterator();
            while (llllllllllllIIIIIlllIllIIllllIll.hasNext()) {
                final Subtitle llllllllllllIIIIIlllIllIIllllIlI = llllllllllllIIIIIlllIllIIllllIll.next();
                if (llllllllllllIIIIIlllIllIIllllIlI.getStartTime() + 3000L <= Minecraft.getSystemTime()) {
                    llllllllllllIIIIIlllIllIIllllIll.remove();
                }
                else {
                    llllllllllllIIIIIlllIllIIlllllII = Math.max(llllllllllllIIIIIlllIllIIlllllII, Minecraft.fontRendererObj.getStringWidth(llllllllllllIIIIIlllIllIIllllIlI.getString()));
                }
            }
            llllllllllllIIIIIlllIllIIlllllII = llllllllllllIIIIIlllIllIIlllllII + Minecraft.fontRendererObj.getStringWidth("<") + Minecraft.fontRendererObj.getStringWidth(" ") + Minecraft.fontRendererObj.getStringWidth(">") + Minecraft.fontRendererObj.getStringWidth(" ");
            for (final Subtitle llllllllllllIIIIIlllIllIIllllIIl : this.subtitles) {
                final int llllllllllllIIIIIlllIllIIllllIII = 255;
                final String llllllllllllIIIIIlllIllIIlllIlll = llllllllllllIIIIIlllIllIIllllIIl.getString();
                final Vec3d llllllllllllIIIIIlllIllIIlllIllI = llllllllllllIIIIIlllIllIIllllIIl.getLocation().subtract(llllllllllllIIIIIlllIllIlIIIIIIl).normalize();
                final double llllllllllllIIIIIlllIllIIlllIlIl = -llllllllllllIIIIIlllIllIIllllllI.dotProduct(llllllllllllIIIIIlllIllIIlllIllI);
                final double llllllllllllIIIIIlllIllIIlllIlII = -llllllllllllIIIIIlllIllIlIIIIIII.dotProduct(llllllllllllIIIIIlllIllIIlllIllI);
                final boolean llllllllllllIIIIIlllIllIIlllIIll = llllllllllllIIIIIlllIllIIlllIlII > 0.5;
                final int llllllllllllIIIIIlllIllIIlllIIlI = llllllllllllIIIIIlllIllIIlllllII / 2;
                final int llllllllllllIIIIIlllIllIIlllIIIl = Minecraft.fontRendererObj.FONT_HEIGHT;
                final int llllllllllllIIIIIlllIllIIlllIIII = llllllllllllIIIIIlllIllIIlllIIIl / 2;
                final float llllllllllllIIIIIlllIllIIllIllll = 1.0f;
                final int llllllllllllIIIIIlllIllIIllIlllI = Minecraft.fontRendererObj.getStringWidth(llllllllllllIIIIIlllIllIIlllIlll);
                final int llllllllllllIIIIIlllIllIIllIllIl = MathHelper.floor(MathHelper.clampedLerp(255.0, 75.0, (Minecraft.getSystemTime() - llllllllllllIIIIIlllIllIIllllIIl.getStartTime()) / 3000.0f));
                final int llllllllllllIIIIIlllIllIIllIllII = llllllllllllIIIIIlllIllIIllIllIl << 16 | llllllllllllIIIIIlllIllIIllIllIl << 8 | llllllllllllIIIIIlllIllIIllIllIl;
                GlStateManager.pushMatrix();
                GlStateManager.translate(llllllllllllIIIIIlllIllIIllIlIlI.getScaledWidth() - llllllllllllIIIIIlllIllIIlllIIlI * 1.0f - 2.0f, llllllllllllIIIIIlllIllIIllIlIlI.getScaledHeight() - 30 - llllllllllllIIIIIlllIllIIlllllIl * (llllllllllllIIIIIlllIllIIlllIIIl + 1) * 1.0f, 0.0f);
                GlStateManager.scale(1.0f, 1.0f, 1.0f);
                Gui.drawRect(-llllllllllllIIIIIlllIllIIlllIIlI - 1, -llllllllllllIIIIIlllIllIIlllIIII - 1, llllllllllllIIIIIlllIllIIlllIIlI + 1, llllllllllllIIIIIlllIllIIlllIIII + 1, -872415232);
                GlStateManager.enableBlend();
                if (!llllllllllllIIIIIlllIllIIlllIIll) {
                    if (llllllllllllIIIIIlllIllIIlllIlIl > 0.0) {
                        Minecraft.fontRendererObj.drawString(">", (float)(llllllllllllIIIIIlllIllIIlllIIlI - Minecraft.fontRendererObj.getStringWidth(">")), (float)(-llllllllllllIIIIIlllIllIIlllIIII), llllllllllllIIIIIlllIllIIllIllII - 16777216);
                    }
                    else if (llllllllllllIIIIIlllIllIIlllIlIl < 0.0) {
                        Minecraft.fontRendererObj.drawString("<", (float)(-llllllllllllIIIIIlllIllIIlllIIlI), (float)(-llllllllllllIIIIIlllIllIIlllIIII), llllllllllllIIIIIlllIllIIllIllII - 16777216);
                    }
                }
                Minecraft.fontRendererObj.drawString(llllllllllllIIIIIlllIllIIlllIlll, (float)(-llllllllllllIIIIIlllIllIIllIlllI / 2), (float)(-llllllllllllIIIIIlllIllIIlllIIII), llllllllllllIIIIIlllIllIIllIllII - 16777216);
                GlStateManager.popMatrix();
                ++llllllllllllIIIIIlllIllIIlllllIl;
            }
            GlStateManager.disableBlend();
            GlStateManager.popMatrix();
        }
    }
    
    @Override
    public void soundPlay(final ISound llllllllllllIIIIIlllIllIIlIIIlll, final SoundEventAccessor llllllllllllIIIIIlllIllIIlIIlIll) {
        if (llllllllllllIIIIIlllIllIIlIIlIll.getSubtitle() != null) {
            final String llllllllllllIIIIIlllIllIIlIIlIlI = llllllllllllIIIIIlllIllIIlIIlIll.getSubtitle().getFormattedText();
            if (!this.subtitles.isEmpty()) {
                for (final Subtitle llllllllllllIIIIIlllIllIIlIIlIIl : this.subtitles) {
                    if (llllllllllllIIIIIlllIllIIlIIlIIl.getString().equals(llllllllllllIIIIIlllIllIIlIIlIlI)) {
                        llllllllllllIIIIIlllIllIIlIIlIIl.refresh(new Vec3d(llllllllllllIIIIIlllIllIIlIIIlll.getXPosF(), llllllllllllIIIIIlllIllIIlIIIlll.getYPosF(), llllllllllllIIIIIlllIllIIlIIIlll.getZPosF()));
                        return;
                    }
                }
            }
            this.subtitles.add(new Subtitle(llllllllllllIIIIIlllIllIIlIIlIlI, new Vec3d(llllllllllllIIIIIlllIllIIlIIIlll.getXPosF(), llllllllllllIIIIIlllIllIIlIIIlll.getYPosF(), llllllllllllIIIIIlllIllIIlIIIlll.getZPosF())));
        }
    }
    
    public GuiSubtitleOverlay(final Minecraft llllllllllllIIIIIlllIllIlIIllllI) {
        this.subtitles = (List<Subtitle>)Lists.newArrayList();
        this.client = llllllllllllIIIIIlllIllIlIIllllI;
    }
    
    public class Subtitle
    {
        private final /* synthetic */ String subtitle;
        private /* synthetic */ long startTime;
        private /* synthetic */ Vec3d location;
        
        public Vec3d getLocation() {
            return this.location;
        }
        
        public void refresh(final Vec3d llllllllllIllllIlIlIlIlIlllIlllI) {
            this.location = llllllllllIllllIlIlIlIlIlllIlllI;
            this.startTime = Minecraft.getSystemTime();
        }
        
        public String getString() {
            return this.subtitle;
        }
        
        public long getStartTime() {
            return this.startTime;
        }
        
        public Subtitle(final String llllllllllIllllIlIlIlIlIlllllllI, final Vec3d llllllllllIllllIlIlIlIllIIIIIIIl) {
            this.subtitle = llllllllllIllllIlIlIlIlIlllllllI;
            this.location = llllllllllIllllIlIlIlIllIIIIIIIl;
            this.startTime = Minecraft.getSystemTime();
        }
    }
}
