// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.utils.other;

import java.util.Iterator;
import java.util.List;
import java.util.Collection;
import org.lwjgl.input.Mouse;
import java.util.Random;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import com.google.common.collect.Lists;
import org.lwjgl.opengl.GL11;
import java.util.concurrent.CopyOnWriteArrayList;

public class ParticleEngine
{
    public /* synthetic */ float lastMouseX;
    public /* synthetic */ float lastMouseY;
    public /* synthetic */ CopyOnWriteArrayList<Particle> particles;
    
    public void drawBorderedCircle(final double llllllllllllllllIIlIIIIIlllIllll, final double llllllllllllllllIIlIIIIIllllIIll, final float llllllllllllllllIIlIIIIIlllIllIl, final int llllllllllllllllIIlIIIIIllllIIIl, final int llllllllllllllllIIlIIIIIllllIIII) {
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(2848);
        GL11.glPushMatrix();
        GL11.glScalef(0.1f, 0.1f, 0.1f);
        drawCircle(llllllllllllllllIIlIIIIIlllIllll * 10.0, llllllllllllllllIIlIIIIIllllIIll * 10.0, llllllllllllllllIIlIIIIIlllIllIl * 10.0f, llllllllllllllllIIlIIIIIllllIIII);
        GL11.glScalef(5.0f, 5.0f, 5.0f);
        GL11.glPopMatrix();
        GL11.glEnable(3553);
        GL11.glDisable(2848);
    }
    
    public static void drawLine(final double llllllllllllllllIIlIIIIlIIlIIIII, final double llllllllllllllllIIlIIIIlIIlIIlIl, final double llllllllllllllllIIlIIIIlIIIllllI, final double llllllllllllllllIIlIIIIlIIlIIIll, final float llllllllllllllllIIlIIIIlIIlIIIlI, final int llllllllllllllllIIlIIIIlIIIllIll) {
        enableRender2D();
        setColor(llllllllllllllllIIlIIIIlIIIllIll);
        GL11.glLineWidth(llllllllllllllllIIlIIIIlIIlIIIlI);
        GL11.glBegin(1);
        GL11.glVertex2d(llllllllllllllllIIlIIIIlIIlIIIII, llllllllllllllllIIlIIIIlIIlIIlIl);
        GL11.glVertex2d(llllllllllllllllIIlIIIIlIIIllllI, llllllllllllllllIIlIIIIlIIlIIIll);
        GL11.glEnd();
        disableRender2D();
    }
    
    public ParticleEngine() {
        this.particles = (CopyOnWriteArrayList<Particle>)Lists.newCopyOnWriteArrayList();
    }
    
    public static void setColor(final int llllllllllllllllIIlIIIIlIIllIllI) {
        final float llllllllllllllllIIlIIIIlIIllIlIl = (llllllllllllllllIIlIIIIlIIllIllI >> 24 & 0xFF) / 255.0f;
        final float llllllllllllllllIIlIIIIlIIllIlII = (llllllllllllllllIIlIIIIlIIllIllI >> 16 & 0xFF) / 255.0f;
        final float llllllllllllllllIIlIIIIlIIllIIll = (llllllllllllllllIIlIIIIlIIllIllI >> 8 & 0xFF) / 255.0f;
        final float llllllllllllllllIIlIIIIlIIllIIlI = (llllllllllllllllIIlIIIIlIIllIllI & 0xFF) / 255.0f;
        GL11.glColor4f(llllllllllllllllIIlIIIIlIIllIlII, llllllllllllllllIIlIIIIlIIllIIll, llllllllllllllllIIlIIIIlIIllIIlI, (llllllllllllllllIIlIIIIlIIllIlIl == 0.0f) ? 1.0f : llllllllllllllllIIlIIIIlIIllIlIl);
    }
    
    public static void drawCircle(final double llllllllllllllllIIlIIIIlIlIIIIll, final double llllllllllllllllIIlIIIIlIlIIlIll, final float llllllllllllllllIIlIIIIlIlIIlIlI, final int llllllllllllllllIIlIIIIlIlIIlIIl) {
        final float llllllllllllllllIIlIIIIlIlIIlIII = (llllllllllllllllIIlIIIIlIlIIlIIl >> 24 & 0xFF) / 255.0f;
        final float llllllllllllllllIIlIIIIlIlIIIlll = (llllllllllllllllIIlIIIIlIlIIlIIl >> 16 & 0xFF) / 255.0f;
        final float llllllllllllllllIIlIIIIlIlIIIllI = (llllllllllllllllIIlIIIIlIlIIlIIl >> 8 & 0xFF) / 255.0f;
        final float llllllllllllllllIIlIIIIlIlIIIlIl = (llllllllllllllllIIlIIIIlIlIIlIIl & 0xFF) / 255.0f;
        GL11.glColor4f(llllllllllllllllIIlIIIIlIlIIIlll, llllllllllllllllIIlIIIIlIlIIIllI, llllllllllllllllIIlIIIIlIlIIIlIl, llllllllllllllllIIlIIIIlIlIIlIII);
        GL11.glBegin(9);
        for (int llllllllllllllllIIlIIIIlIlIIIlII = 0; llllllllllllllllIIlIIIIlIlIIIlII <= 360; ++llllllllllllllllIIlIIIIlIlIIIlII) {
            GL11.glVertex2d(llllllllllllllllIIlIIIIlIlIIIIll + Math.sin(llllllllllllllllIIlIIIIlIlIIIlII * 1.141526 / 180.0) * 12.0, llllllllllllllllIIlIIIIlIlIIlIll + Math.cos(llllllllllllllllIIlIIIIlIlIIIlII * 1.141526 / 180.0) * 12.0);
        }
        GL11.glEnd();
    }
    
    public static void disableRender2D() {
        GL11.glDisable(3042);
        GL11.glEnable(2884);
        GL11.glEnable(3553);
        GL11.glDisable(2848);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.shadeModel(7424);
        GlStateManager.disableBlend();
        GlStateManager.enableTexture2D();
    }
    
    public static void enableRender2D() {
        GL11.glEnable(3042);
        GL11.glDisable(2884);
        GL11.glDisable(3553);
        GL11.glEnable(2848);
        GL11.glBlendFunc(770, 771);
        GL11.glLineWidth(1.0f);
    }
    
    public void render() {
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        final ScaledResolution llllllllllllllllIIlIIIIlIIIIlllI = new ScaledResolution(Minecraft.getMinecraft());
        final float llllllllllllllllIIlIIIIlIIIIllIl = 0.0f;
        final float llllllllllllllllIIlIIIIlIIIIllII = 0.0f;
        while (this.particles.size() < llllllllllllllllIIlIIIIlIIIIlllI.getScaledWidth() / 8.0f) {
            this.particles.add(new Particle(llllllllllllllllIIlIIIIlIIIIlllI, new Random().nextFloat() + 1.0f, new Random().nextFloat() * 5.0f + 5.0f));
        }
        final List<Particle> llllllllllllllllIIlIIIIlIIIIlIll = (List<Particle>)Lists.newArrayList();
        final int llllllllllllllllIIlIIIIlIIIIlIlI = 52;
        final int llllllllllllllllIIlIIIIlIIIIlIIl = -570425345;
        for (final Particle llllllllllllllllIIlIIIIlIIIIIlll : this.particles) {
            final double llllllllllllllllIIlIIIIlIIIIIllI = llllllllllllllllIIlIIIIlIIIIIlll.x + Math.sin(llllllllllllllllIIlIIIIlIIIIIlll.ticks / 2.0f) * 50.0 + -llllllllllllllllIIlIIIIlIIIIllIl / 5.0f * Mouse.getX();
            final double llllllllllllllllIIlIIIIlIIIIIlIl = llllllllllllllllIIlIIIIlIIIIIlll.ticks * llllllllllllllllIIlIIIIlIIIIIlll.speed * llllllllllllllllIIlIIIIlIIIIIlll.ticks / 10.0f + -llllllllllllllllIIlIIIIlIIIIllII / 5.0f;
            if (llllllllllllllllIIlIIIIlIIIIIlIl < llllllllllllllllIIlIIIIlIIIIlllI.getScaledHeight()) {
                if (llllllllllllllllIIlIIIIlIIIIIlll.opacity < llllllllllllllllIIlIIIIlIIIIlIlI) {
                    final Particle particle = llllllllllllllllIIlIIIIlIIIIIlll;
                    particle.opacity += 2.0f;
                }
                if (llllllllllllllllIIlIIIIlIIIIIlll.opacity > llllllllllllllllIIlIIIIlIIIIlIlI) {
                    llllllllllllllllIIlIIIIlIIIIIlll.opacity = (float)llllllllllllllllIIlIIIIlIIIIlIlI;
                }
                GlStateManager.enableBlend();
                this.drawBorderedCircle(llllllllllllllllIIlIIIIlIIIIIllI, llllllllllllllllIIlIIIIlIIIIIlIl, llllllllllllllllIIlIIIIlIIIIIlll.radius * llllllllllllllllIIlIIIIlIIIIIlll.opacity / llllllllllllllllIIlIIIIlIIIIlIlI, llllllllllllllllIIlIIIIlIIIIlIIl, llllllllllllllllIIlIIIIlIIIIlIIl);
            }
            llllllllllllllllIIlIIIIlIIIIIlll.ticks += (float)0.05;
            if (llllllllllllllllIIlIIIIlIIIIIlIl > llllllllllllllllIIlIIIIlIIIIlllI.getScaledHeight() || llllllllllllllllIIlIIIIlIIIIIlIl < 0.0 || llllllllllllllllIIlIIIIlIIIIIllI > llllllllllllllllIIlIIIIlIIIIlllI.getScaledWidth() || llllllllllllllllIIlIIIIlIIIIIllI < 0.0) {
                llllllllllllllllIIlIIIIlIIIIlIll.add(llllllllllllllllIIlIIIIlIIIIIlll);
            }
        }
        this.particles.removeAll(llllllllllllllllIIlIIIIlIIIIlIll);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        this.lastMouseX = (float)Mouse.getX();
        this.lastMouseY = (float)Mouse.getY();
    }
}
