// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.utils.render;

import net.minecraft.client.renderer.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraft.client.renderer.RenderHelper;
import ru.rockstar.client.features.impl.display.ClickGUI;
import java.util.Random;
import ru.rockstar.api.utils.shader.ShaderShell;
import ru.rockstar.api.utils.combat.KillAuraHelper;
import ru.rockstar.client.features.impl.combat.KillAura;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.shader.Shader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.entity.Entity;
import ru.rockstar.client.features.impl.display.ArreyList;
import java.nio.FloatBuffer;
import java.text.NumberFormat;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.Tessellator;
import java.awt.Color;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.shader.ShaderGroup;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import java.util.HashMap;
import net.minecraft.util.math.Vec3d;
import net.minecraft.client.shader.Framebuffer;
import ru.rockstar.api.utils.Helper;

public class DrawHelper implements Helper
{
    private static /* synthetic */ int lastScaleWidth;
    private static /* synthetic */ Framebuffer buffer;
    private static final /* synthetic */ Vec3d LIGHT0_POS;
    private static /* synthetic */ HashMap<Integer, Integer> shadowCache;
    private static /* synthetic */ int lastScale;
    private static final /* synthetic */ Vec3d LIGHT1_POS;
    private static /* synthetic */ ResourceLocation shader;
    private static /* synthetic */ int time;
    protected static /* synthetic */ float zLevel;
    public static /* synthetic */ HashMap<Integer, Integer> blurSpotCache;
    private static /* synthetic */ Minecraft mc;
    private static /* synthetic */ ShaderGroup blurShader;
    private static /* synthetic */ int lastScaleHeight;
    private static final /* synthetic */ Frustum frustrum;
    
    public static void enableStandardItemLighting() {
        GlStateManager.enableLighting();
        GlStateManager.enableLight(0);
        GlStateManager.enableLight(1);
        GlStateManager.enableColorMaterial();
        GlStateManager.colorMaterial(1032, 5634);
        GlStateManager.glLight(16384, 4611, setColorBuffer(DrawHelper.LIGHT0_POS.xCoord, DrawHelper.LIGHT0_POS.yCoord, DrawHelper.LIGHT0_POS.zCoord, 0.0));
        final float lllllllllllIIIlIIllIIIIIIIIllllI = 0.6f;
        GlStateManager.glLight(16384, 4609, setColorBuffer(0.6000000238418579, 0.6000000238418579, 0.6000000238418579, 1.0));
        GlStateManager.glLight(16384, 4608, setColorBuffer(0.0, 0.0, 0.0, 1.0));
        GlStateManager.glLight(16384, 4610, setColorBuffer(0.0, 0.0, 0.0, 1.0));
        GlStateManager.glLight(16385, 4611, setColorBuffer(DrawHelper.LIGHT1_POS.xCoord, DrawHelper.LIGHT1_POS.yCoord, DrawHelper.LIGHT1_POS.zCoord, 0.0));
        GlStateManager.glLight(16385, 4609, setColorBuffer(0.6000000238418579, 0.6000000238418579, 0.6000000238418579, 1.0));
        GlStateManager.glLight(16385, 4608, setColorBuffer(0.0, 0.0, 0.0, 1.0));
        GlStateManager.glLight(16385, 4610, setColorBuffer(0.0, 0.0, 0.0, 1.0));
        GlStateManager.shadeModel(7424);
        final float lllllllllllIIIlIIllIIIIIIIIlllIl = 0.4f;
        GlStateManager.glLightModel(2899, setColorBuffer(0.4000000059604645, 0.4000000059604645, 0.4000000059604645, 1.0));
    }
    
    public static void blurAreaBoarder(final float lllllllllllIIIlIIllIIIlIllllIIIl, final float lllllllllllIIIlIIllIIIlIlllIIlIl, final float lllllllllllIIIlIIllIIIlIlllIIlII, final float lllllllllllIIIlIIllIIIlIlllIIIll, final float lllllllllllIIIlIIllIIIlIlllIIIlI, final float lllllllllllIIIlIIllIIIlIlllIllII, final float lllllllllllIIIlIIllIIIlIlllIIIII) {
        final ScaledResolution lllllllllllIIIlIIllIIIlIlllIlIlI = new ScaledResolution(DrawHelper.mc);
        final int lllllllllllIIIlIIllIIIlIlllIlIIl = ScaledResolution.getScaleFactor();
        final int lllllllllllIIIlIIllIIIlIlllIlIII = lllllllllllIIIlIIllIIIlIlllIlIlI.getScaledWidth();
        final int lllllllllllIIIlIIllIIIlIlllIIlll = lllllllllllIIIlIIllIIIlIlllIlIlI.getScaledHeight();
        if (DrawHelper.lastScale != lllllllllllIIIlIIllIIIlIlllIlIIl || DrawHelper.lastScaleWidth != lllllllllllIIIlIIllIIIlIlllIlIII || DrawHelper.lastScaleHeight != lllllllllllIIIlIIllIIIlIlllIIlll || DrawHelper.buffer == null || DrawHelper.blurShader == null) {
            inShaderFBO();
        }
        DrawHelper.lastScale = lllllllllllIIIlIIllIIIlIlllIlIIl;
        DrawHelper.lastScaleWidth = lllllllllllIIIlIIllIIIlIlllIlIII;
        DrawHelper.lastScaleHeight = lllllllllllIIIlIIllIIIlIlllIIlll;
        GL11.glScissor((int)(lllllllllllIIIlIIllIIIlIllllIIIl * lllllllllllIIIlIIllIIIlIlllIlIIl), (int)(DrawHelper.mc.displayHeight - lllllllllllIIIlIIllIIIlIlllIIlIl * lllllllllllIIIlIIllIIIlIlllIlIIl - lllllllllllIIIlIIllIIIlIlllIIIll * lllllllllllIIIlIIllIIIlIlllIlIIl) + 1, (int)(lllllllllllIIIlIIllIIIlIlllIIlII * lllllllllllIIIlIIllIIIlIlllIlIIl), (int)(lllllllllllIIIlIIllIIIlIlllIIIll * lllllllllllIIIlIIllIIIlIlllIlIIl));
        GL11.glEnable(3089);
        shaderConfigFix(lllllllllllIIIlIIllIIIlIlllIIIlI, lllllllllllIIIlIIllIIIlIlllIllII, lllllllllllIIIlIIllIIIlIlllIIIII);
        DrawHelper.buffer.bindFramebuffer(true);
        DrawHelper.blurShader.loadShaderGroup(DrawHelper.mc.timer.renderPartialTicks);
        DrawHelper.mc.getFramebuffer().bindFramebuffer(true);
        GL11.glDisable(3089);
    }
    
    public static void staticJelloCircle1() {
        final double lllllllllllIIIlIIlIllllIlllIlllI = 0.8 * (1.0 + Math.sin(6.283185307179586 * (DrawHelper.time * 0.3)));
        final double lllllllllllIIIlIIlIllllIlllIllIl = DrawHelper.mc.player.width;
        final double lllllllllllIIIlIIlIllllIlllIllII = DrawHelper.mc.player.lastTickPosX + (DrawHelper.mc.player.posX - DrawHelper.mc.player.lastTickPosX) * DrawHelper.mc.timer.renderPartialTicks - DrawHelper.mc.getRenderManager().viewerPosX;
        final double lllllllllllIIIlIIlIllllIlllIlIll = DrawHelper.mc.player.lastTickPosY + (DrawHelper.mc.player.posY - DrawHelper.mc.player.lastTickPosY) * DrawHelper.mc.timer.renderPartialTicks - DrawHelper.mc.getRenderManager().viewerPosY;
        final double lllllllllllIIIlIIlIllllIlllIlIlI = DrawHelper.mc.player.lastTickPosZ + (DrawHelper.mc.player.posZ - DrawHelper.mc.player.lastTickPosZ) * DrawHelper.mc.timer.renderPartialTicks - DrawHelper.mc.getRenderManager().viewerPosZ;
        GlStateManager.enableBlend();
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(2848);
        GlStateManager.disableTexture2D();
        GlStateManager.disableAlpha();
        GL11.glLineWidth(1.2f);
        GL11.glShadeModel(7425);
        GL11.glDisable(2884);
        GL11.glBegin(5);
        for (int lllllllllllIIIlIIlIllllIlllIlIIl = 0; lllllllllllIIIlIIlIllllIlllIlIIl < 361; ++lllllllllllIIIlIIlIllllIlllIlIIl) {
            color(setAlpha(ClientHelper.getClientColor(), (int)(255.0 * (1.3 - lllllllllllIIIlIIlIllllIlllIlllI))));
            final double lllllllllllIIIlIIlIllllIlllIlIII = lllllllllllIIIlIIlIllllIlllIllII + Math.cos(Math.toRadians(lllllllllllIIIlIIlIllllIlllIlIIl)) * 0.7;
            final double lllllllllllIIIlIIlIllllIlllIIlll = lllllllllllIIIlIIlIllllIlllIlIlI - Math.sin(Math.toRadians(lllllllllllIIIlIIlIllllIlllIlIIl)) * 0.7;
            GL11.glVertex3d(lllllllllllIIIlIIlIllllIlllIllII + Math.cos(Math.toRadians(lllllllllllIIIlIIlIllllIlllIlIIl)) * lllllllllllIIIlIIlIllllIlllIllIl, lllllllllllIIIlIIlIllllIlllIlIll + 0.1, lllllllllllIIIlIIlIllllIlllIlIlI - Math.sin(Math.toRadians(lllllllllllIIIlIIlIllllIlllIlIIl)) * lllllllllllIIIlIIlIllllIlllIllIl);
            color(setAlpha(ClientHelper.getClientColor(), 0));
            GL11.glVertex3d(lllllllllllIIIlIIlIllllIlllIllII + Math.cos(Math.toRadians(lllllllllllIIIlIIlIllllIlllIlIIl)) * lllllllllllIIIlIIlIllllIlllIllIl, lllllllllllIIIlIIlIllllIlllIlIll + 0.1 + 0.13 * lllllllllllIIIlIIlIllllIlllIlllI, lllllllllllIIIlIIlIllllIlllIlIlI - Math.sin(Math.toRadians(lllllllllllIIIlIIlIllllIlllIlIIl)) * lllllllllllIIIlIIlIllllIlllIllIl);
        }
        GL11.glEnd();
        GL11.glBegin(2);
        for (int lllllllllllIIIlIIlIllllIlllIIllI = 0; lllllllllllIIIlIIlIllllIlllIIllI < 365; ++lllllllllllIIIlIIlIllllIlllIIllI) {
            color(ClientHelper.getClientColor());
            GL11.glVertex3d(lllllllllllIIIlIIlIllllIlllIllII + Math.cos(Math.toRadians(lllllllllllIIIlIIlIllllIlllIIllI)) * lllllllllllIIIlIIlIllllIlllIllIl, lllllllllllIIIlIIlIllllIlllIlIll + 0.1, lllllllllllIIIlIIlIllllIlllIlIlI - Math.sin(Math.toRadians(lllllllllllIIIlIIlIllllIlllIIllI)) * lllllllllllIIIlIIlIllllIlllIllIl);
        }
        GL11.glEnd();
        GlStateManager.enableAlpha();
        GL11.glShadeModel(7424);
        GL11.glDisable(2848);
        GL11.glEnable(2884);
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.resetColor();
    }
    
    public static final void color(Color lllllllllllIIIlIIlIlllllIIlIlIll) {
        if (lllllllllllIIIlIIlIlllllIIlIlIll == null) {
            lllllllllllIIIlIIlIlllllIIlIlIll = Color.white;
        }
        color(lllllllllllIIIlIIlIlllllIIlIlIll.getRed() / 255.0f, lllllllllllIIIlIIlIlllllIIlIlIll.getGreen() / 255.0f, lllllllllllIIIlIIlIlllllIIlIlIll.getBlue() / 255.0f, lllllllllllIIIlIIlIlllllIIlIlIll.getAlpha() / 255.0f);
    }
    
    public static void drawGradientRectBetter(final float lllllllllllIIIlIIllIIIIllIlIlllI, final float lllllllllllIIIlIIllIIIIllIllIIll, final float lllllllllllIIIlIIllIIIIllIllIIlI, final float lllllllllllIIIlIIllIIIIllIllIIIl, final int lllllllllllIIIlIIllIIIIllIlIlIlI, final int lllllllllllIIIlIIllIIIIllIlIllll) {
        drawGradientRect1(lllllllllllIIIlIIllIIIIllIlIlllI, lllllllllllIIIlIIllIIIIllIllIIll, lllllllllllIIIlIIllIIIIllIlIlllI + lllllllllllIIIlIIllIIIIllIllIIlI, lllllllllllIIIlIIllIIIIllIllIIll + lllllllllllIIIlIIllIIIIllIllIIIl, lllllllllllIIIlIIllIIIIllIlIlIlI, lllllllllllIIIlIIllIIIIllIlIllll);
    }
    
    static {
        DrawHelper.mc = Minecraft.getMinecraft();
        frustrum = new Frustum();
        LIGHT0_POS = new Vec3d(0.20000000298023224, 1.0, -0.699999988079071).normalize();
        LIGHT1_POS = new Vec3d(-0.20000000298023224, 1.0, 0.699999988079071).normalize();
        DrawHelper.shadowCache = new HashMap<Integer, Integer>();
        DrawHelper.shader = new ResourceLocation("shaders/post/blur.json");
        DrawHelper.blurSpotCache = new HashMap<Integer, Integer>();
    }
    
    public static void drawNewRect(double lllllllllllIIIlIIlIlllIlllllIlIl, double lllllllllllIIIlIIlIlllIlllllIlII, double lllllllllllIIIlIIlIlllIlllllIIll, double lllllllllllIIIlIIlIlllIlllllIIlI, final int lllllllllllIIIlIIlIlllIlllllIIIl) {
        if (lllllllllllIIIlIIlIlllIlllllIlIl < lllllllllllIIIlIIlIlllIlllllIIll) {
            final double lllllllllllIIIlIIlIlllIlllllllIl = lllllllllllIIIlIIlIlllIlllllIlIl;
            lllllllllllIIIlIIlIlllIlllllIlIl = lllllllllllIIIlIIlIlllIlllllIIll;
            lllllllllllIIIlIIlIlllIlllllIIll = lllllllllllIIIlIIlIlllIlllllllIl;
        }
        if (lllllllllllIIIlIIlIlllIlllllIlII < lllllllllllIIIlIIlIlllIlllllIIlI) {
            final double lllllllllllIIIlIIlIlllIlllllllII = lllllllllllIIIlIIlIlllIlllllIlII;
            lllllllllllIIIlIIlIlllIlllllIlII = lllllllllllIIIlIIlIlllIlllllIIlI;
            lllllllllllIIIlIIlIlllIlllllIIlI = lllllllllllIIIlIIlIlllIlllllllII;
        }
        final float lllllllllllIIIlIIlIlllIllllllIll = (lllllllllllIIIlIIlIlllIlllllIIIl >> 24 & 0xFF) / 255.0f;
        final float lllllllllllIIIlIIlIlllIllllllIlI = (lllllllllllIIIlIIlIlllIlllllIIIl >> 16 & 0xFF) / 255.0f;
        final float lllllllllllIIIlIIlIlllIllllllIIl = (lllllllllllIIIlIIlIlllIlllllIIIl >> 8 & 0xFF) / 255.0f;
        final float lllllllllllIIIlIIlIlllIllllllIII = (lllllllllllIIIlIIlIlllIlllllIIIl & 0xFF) / 255.0f;
        final Tessellator lllllllllllIIIlIIlIlllIlllllIlll = Tessellator.getInstance();
        final BufferBuilder lllllllllllIIIlIIlIlllIlllllIllI = lllllllllllIIIlIIlIlllIlllllIlll.getBuffer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.color(lllllllllllIIIlIIlIlllIllllllIlI, lllllllllllIIIlIIlIlllIllllllIIl, lllllllllllIIIlIIlIlllIllllllIII, lllllllllllIIIlIIlIlllIllllllIll);
        lllllllllllIIIlIIlIlllIlllllIllI.begin(7, DefaultVertexFormats.POSITION);
        lllllllllllIIIlIIlIlllIlllllIllI.pos(lllllllllllIIIlIIlIlllIlllllIlIl, lllllllllllIIIlIIlIlllIlllllIIlI, 0.0).endVertex();
        lllllllllllIIIlIIlIlllIlllllIllI.pos(lllllllllllIIIlIIlIlllIlllllIIll, lllllllllllIIIlIIlIlllIlllllIIlI, 0.0).endVertex();
        lllllllllllIIIlIIlIlllIlllllIllI.pos(lllllllllllIIIlIIlIlllIlllllIIll, lllllllllllIIIlIIlIlllIlllllIlII, 0.0).endVertex();
        lllllllllllIIIlIIlIlllIlllllIllI.pos(lllllllllllIIIlIIlIlllIlllllIlIl, lllllllllllIIIlIIlIlllIlllllIlII, 0.0).endVertex();
        lllllllllllIIIlIIlIlllIlllllIlll.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }
    
    public static int fade(final int lllllllllllIIIlIIlIlllIIlllIlIIl, final int lllllllllllIIIlIIlIlllIIllllIIII, final float lllllllllllIIIlIIlIlllIIlllIIlll) {
        final float lllllllllllIIIlIIlIlllIIlllIlllI = 1.0f - lllllllllllIIIlIIlIlllIIlllIIlll;
        final int lllllllllllIIIlIIlIlllIIlllIllIl = (int)((lllllllllllIIIlIIlIlllIIlllIlIIl >> 16 & 0xFF) * lllllllllllIIIlIIlIlllIIlllIlllI + (lllllllllllIIIlIIlIlllIIllllIIII >> 16 & 0xFF) * lllllllllllIIIlIIlIlllIIlllIIlll);
        final int lllllllllllIIIlIIlIlllIIlllIllII = (int)((lllllllllllIIIlIIlIlllIIlllIlIIl >> 8 & 0xFF) * lllllllllllIIIlIIlIlllIIlllIlllI + (lllllllllllIIIlIIlIlllIIllllIIII >> 8 & 0xFF) * lllllllllllIIIlIIlIlllIIlllIIlll);
        final int lllllllllllIIIlIIlIlllIIlllIlIll = (int)((lllllllllllIIIlIIlIlllIIlllIlIIl & 0xFF) * lllllllllllIIIlIIlIlllIIlllIlllI + (lllllllllllIIIlIIlIlllIIllllIIII & 0xFF) * lllllllllllIIIlIIlIlllIIlllIIlll);
        final int lllllllllllIIIlIIlIlllIIlllIlIlI = (int)((lllllllllllIIIlIIlIlllIIlllIlIIl >> 24 & 0xFF) * lllllllllllIIIlIIlIlllIIlllIlllI + (lllllllllllIIIlIIlIlllIIllllIIII >> 24 & 0xFF) * lllllllllllIIIlIIlIlllIIlllIIlll);
        return (lllllllllllIIIlIIlIlllIIlllIlIlI & 0xFF) << 24 | (lllllllllllIIIlIIlIlllIIlllIllIl & 0xFF) << 16 | (lllllllllllIIIlIIlIlllIIlllIllII & 0xFF) << 8 | (lllllllllllIIIlIIlIlllIIlllIlIll & 0xFF);
    }
    
    public static void setColor(final int lllllllllllIIIlIIlIlllllllllIlIl) {
        GL11.glColor4ub((byte)(lllllllllllIIIlIIlIlllllllllIlIl >> 16 & 0xFF), (byte)(lllllllllllIIIlIIlIlllllllllIlIl >> 8 & 0xFF), (byte)(lllllllllllIIIlIIlIlllllllllIlIl & 0xFF), (byte)(lllllllllllIIIlIIlIlllllllllIlIl >> 24 & 0xFF));
    }
    
    public static void drawBoundingBox(final AxisAlignedBB lllllllllllIIIlIIllIIIIIIllIlIIl) {
        GL11.glBegin(7);
        GL11.glVertex3d(lllllllllllIIIlIIllIIIIIIllIlIIl.minX, lllllllllllIIIlIIllIIIIIIllIlIIl.minY, lllllllllllIIIlIIllIIIIIIllIlIIl.minZ);
        GL11.glVertex3d(lllllllllllIIIlIIllIIIIIIllIlIIl.minX, lllllllllllIIIlIIllIIIIIIllIlIIl.maxY, lllllllllllIIIlIIllIIIIIIllIlIIl.minZ);
        GL11.glVertex3d(lllllllllllIIIlIIllIIIIIIllIlIIl.maxX, lllllllllllIIIlIIllIIIIIIllIlIIl.minY, lllllllllllIIIlIIllIIIIIIllIlIIl.minZ);
        GL11.glVertex3d(lllllllllllIIIlIIllIIIIIIllIlIIl.maxX, lllllllllllIIIlIIllIIIIIIllIlIIl.maxY, lllllllllllIIIlIIllIIIIIIllIlIIl.minZ);
        GL11.glVertex3d(lllllllllllIIIlIIllIIIIIIllIlIIl.maxX, lllllllllllIIIlIIllIIIIIIllIlIIl.minY, lllllllllllIIIlIIllIIIIIIllIlIIl.maxZ);
        GL11.glVertex3d(lllllllllllIIIlIIllIIIIIIllIlIIl.maxX, lllllllllllIIIlIIllIIIIIIllIlIIl.maxY, lllllllllllIIIlIIllIIIIIIllIlIIl.maxZ);
        GL11.glVertex3d(lllllllllllIIIlIIllIIIIIIllIlIIl.minX, lllllllllllIIIlIIllIIIIIIllIlIIl.minY, lllllllllllIIIlIIllIIIIIIllIlIIl.maxZ);
        GL11.glVertex3d(lllllllllllIIIlIIllIIIIIIllIlIIl.minX, lllllllllllIIIlIIllIIIIIIllIlIIl.maxY, lllllllllllIIIlIIllIIIIIIllIlIIl.maxZ);
        GL11.glVertex3d(lllllllllllIIIlIIllIIIIIIllIlIIl.maxX, lllllllllllIIIlIIllIIIIIIllIlIIl.maxY, lllllllllllIIIlIIllIIIIIIllIlIIl.minZ);
        GL11.glVertex3d(lllllllllllIIIlIIllIIIIIIllIlIIl.maxX, lllllllllllIIIlIIllIIIIIIllIlIIl.minY, lllllllllllIIIlIIllIIIIIIllIlIIl.minZ);
        GL11.glVertex3d(lllllllllllIIIlIIllIIIIIIllIlIIl.minX, lllllllllllIIIlIIllIIIIIIllIlIIl.maxY, lllllllllllIIIlIIllIIIIIIllIlIIl.minZ);
        GL11.glVertex3d(lllllllllllIIIlIIllIIIIIIllIlIIl.minX, lllllllllllIIIlIIllIIIIIIllIlIIl.minY, lllllllllllIIIlIIllIIIIIIllIlIIl.minZ);
        GL11.glVertex3d(lllllllllllIIIlIIllIIIIIIllIlIIl.minX, lllllllllllIIIlIIllIIIIIIllIlIIl.maxY, lllllllllllIIIlIIllIIIIIIllIlIIl.maxZ);
        GL11.glVertex3d(lllllllllllIIIlIIllIIIIIIllIlIIl.minX, lllllllllllIIIlIIllIIIIIIllIlIIl.minY, lllllllllllIIIlIIllIIIIIIllIlIIl.maxZ);
        GL11.glVertex3d(lllllllllllIIIlIIllIIIIIIllIlIIl.maxX, lllllllllllIIIlIIllIIIIIIllIlIIl.maxY, lllllllllllIIIlIIllIIIIIIllIlIIl.maxZ);
        GL11.glVertex3d(lllllllllllIIIlIIllIIIIIIllIlIIl.maxX, lllllllllllIIIlIIllIIIIIIllIlIIl.minY, lllllllllllIIIlIIllIIIIIIllIlIIl.maxZ);
        GL11.glVertex3d(lllllllllllIIIlIIllIIIIIIllIlIIl.minX, lllllllllllIIIlIIllIIIIIIllIlIIl.maxY, lllllllllllIIIlIIllIIIIIIllIlIIl.minZ);
        GL11.glVertex3d(lllllllllllIIIlIIllIIIIIIllIlIIl.maxX, lllllllllllIIIlIIllIIIIIIllIlIIl.maxY, lllllllllllIIIlIIllIIIIIIllIlIIl.minZ);
        GL11.glVertex3d(lllllllllllIIIlIIllIIIIIIllIlIIl.maxX, lllllllllllIIIlIIllIIIIIIllIlIIl.maxY, lllllllllllIIIlIIllIIIIIIllIlIIl.maxZ);
        GL11.glVertex3d(lllllllllllIIIlIIllIIIIIIllIlIIl.minX, lllllllllllIIIlIIllIIIIIIllIlIIl.maxY, lllllllllllIIIlIIllIIIIIIllIlIIl.maxZ);
        GL11.glVertex3d(lllllllllllIIIlIIllIIIIIIllIlIIl.minX, lllllllllllIIIlIIllIIIIIIllIlIIl.maxY, lllllllllllIIIlIIllIIIIIIllIlIIl.minZ);
        GL11.glVertex3d(lllllllllllIIIlIIllIIIIIIllIlIIl.minX, lllllllllllIIIlIIllIIIIIIllIlIIl.maxY, lllllllllllIIIlIIllIIIIIIllIlIIl.maxZ);
        GL11.glVertex3d(lllllllllllIIIlIIllIIIIIIllIlIIl.maxX, lllllllllllIIIlIIllIIIIIIllIlIIl.maxY, lllllllllllIIIlIIllIIIIIIllIlIIl.maxZ);
        GL11.glVertex3d(lllllllllllIIIlIIllIIIIIIllIlIIl.maxX, lllllllllllIIIlIIllIIIIIIllIlIIl.maxY, lllllllllllIIIlIIllIIIIIIllIlIIl.minZ);
        GL11.glVertex3d(lllllllllllIIIlIIllIIIIIIllIlIIl.minX, lllllllllllIIIlIIllIIIIIIllIlIIl.minY, lllllllllllIIIlIIllIIIIIIllIlIIl.minZ);
        GL11.glVertex3d(lllllllllllIIIlIIllIIIIIIllIlIIl.maxX, lllllllllllIIIlIIllIIIIIIllIlIIl.minY, lllllllllllIIIlIIllIIIIIIllIlIIl.minZ);
        GL11.glVertex3d(lllllllllllIIIlIIllIIIIIIllIlIIl.maxX, lllllllllllIIIlIIllIIIIIIllIlIIl.minY, lllllllllllIIIlIIllIIIIIIllIlIIl.maxZ);
        GL11.glVertex3d(lllllllllllIIIlIIllIIIIIIllIlIIl.minX, lllllllllllIIIlIIllIIIIIIllIlIIl.minY, lllllllllllIIIlIIllIIIIIIllIlIIl.maxZ);
        GL11.glVertex3d(lllllllllllIIIlIIllIIIIIIllIlIIl.minX, lllllllllllIIIlIIllIIIIIIllIlIIl.minY, lllllllllllIIIlIIllIIIIIIllIlIIl.minZ);
        GL11.glVertex3d(lllllllllllIIIlIIllIIIIIIllIlIIl.minX, lllllllllllIIIlIIllIIIIIIllIlIIl.minY, lllllllllllIIIlIIllIIIIIIllIlIIl.maxZ);
        GL11.glVertex3d(lllllllllllIIIlIIllIIIIIIllIlIIl.maxX, lllllllllllIIIlIIllIIIIIIllIlIIl.minY, lllllllllllIIIlIIllIIIIIIllIlIIl.maxZ);
        GL11.glVertex3d(lllllllllllIIIlIIllIIIIIIllIlIIl.maxX, lllllllllllIIIlIIllIIIIIIllIlIIl.minY, lllllllllllIIIlIIllIIIIIIllIlIIl.minZ);
        GL11.glVertex3d(lllllllllllIIIlIIllIIIIIIllIlIIl.minX, lllllllllllIIIlIIllIIIIIIllIlIIl.minY, lllllllllllIIIlIIllIIIIIIllIlIIl.minZ);
        GL11.glVertex3d(lllllllllllIIIlIIllIIIIIIllIlIIl.minX, lllllllllllIIIlIIllIIIIIIllIlIIl.maxY, lllllllllllIIIlIIllIIIIIIllIlIIl.minZ);
        GL11.glVertex3d(lllllllllllIIIlIIllIIIIIIllIlIIl.minX, lllllllllllIIIlIIllIIIIIIllIlIIl.minY, lllllllllllIIIlIIllIIIIIIllIlIIl.maxZ);
        GL11.glVertex3d(lllllllllllIIIlIIllIIIIIIllIlIIl.minX, lllllllllllIIIlIIllIIIIIIllIlIIl.maxY, lllllllllllIIIlIIllIIIIIIllIlIIl.maxZ);
        GL11.glVertex3d(lllllllllllIIIlIIllIIIIIIllIlIIl.maxX, lllllllllllIIIlIIllIIIIIIllIlIIl.minY, lllllllllllIIIlIIllIIIIIIllIlIIl.maxZ);
        GL11.glVertex3d(lllllllllllIIIlIIllIIIIIIllIlIIl.maxX, lllllllllllIIIlIIllIIIIIIllIlIIl.maxY, lllllllllllIIIlIIllIIIIIIllIlIIl.maxZ);
        GL11.glVertex3d(lllllllllllIIIlIIllIIIIIIllIlIIl.maxX, lllllllllllIIIlIIllIIIIIIllIlIIl.minY, lllllllllllIIIlIIllIIIIIIllIlIIl.minZ);
        GL11.glVertex3d(lllllllllllIIIlIIllIIIIIIllIlIIl.maxX, lllllllllllIIIlIIllIIIIIIllIlIIl.maxY, lllllllllllIIIlIIllIIIIIIllIlIIl.minZ);
        GL11.glVertex3d(lllllllllllIIIlIIllIIIIIIllIlIIl.minX, lllllllllllIIIlIIllIIIIIIllIlIIl.maxY, lllllllllllIIIlIIllIIIIIIllIlIIl.maxZ);
        GL11.glVertex3d(lllllllllllIIIlIIllIIIIIIllIlIIl.minX, lllllllllllIIIlIIllIIIIIIllIlIIl.minY, lllllllllllIIIlIIllIIIIIIllIlIIl.maxZ);
        GL11.glVertex3d(lllllllllllIIIlIIllIIIIIIllIlIIl.minX, lllllllllllIIIlIIllIIIIIIllIlIIl.maxY, lllllllllllIIIlIIllIIIIIIllIlIIl.minZ);
        GL11.glVertex3d(lllllllllllIIIlIIllIIIIIIllIlIIl.minX, lllllllllllIIIlIIllIIIIIIllIlIIl.minY, lllllllllllIIIlIIllIIIIIIllIlIIl.minZ);
        GL11.glVertex3d(lllllllllllIIIlIIllIIIIIIllIlIIl.maxX, lllllllllllIIIlIIllIIIIIIllIlIIl.maxY, lllllllllllIIIlIIllIIIIIIllIlIIl.minZ);
        GL11.glVertex3d(lllllllllllIIIlIIllIIIIIIllIlIIl.maxX, lllllllllllIIIlIIllIIIIIIllIlIIl.minY, lllllllllllIIIlIIllIIIIIIllIlIIl.minZ);
        GL11.glVertex3d(lllllllllllIIIlIIllIIIIIIllIlIIl.maxX, lllllllllllIIIlIIllIIIIIIllIlIIl.maxY, lllllllllllIIIlIIllIIIIIIllIlIIl.maxZ);
        GL11.glVertex3d(lllllllllllIIIlIIllIIIIIIllIlIIl.maxX, lllllllllllIIIlIIllIIIIIIllIlIIl.minY, lllllllllllIIIlIIllIIIIIIllIlIIl.maxZ);
        GL11.glEnd();
    }
    
    public static int getColor(final Color lllllllllllIIIlIIlIlllIlIIIlIIlI) {
        return getColor(lllllllllllIIIlIIlIlllIlIIIlIIlI.getRed(), lllllllllllIIIlIIlIlllIlIIIlIIlI.getGreen(), lllllllllllIIIlIIlIlllIlIIIlIIlI.getBlue(), lllllllllllIIIlIIlIlllIlIIIlIIlI.getAlpha());
    }
    
    public static Color astolfoColors1(final float lllllllllllIIIlIIlIlllllIIllIIIl, final float lllllllllllIIIlIIlIlllllIIllIIII) {
        float lllllllllllIIIlIIlIlllllIIllIIll;
        float lllllllllllIIIlIIlIlllllIIllIIlI;
        for (lllllllllllIIIlIIlIlllllIIllIIll = 3500.0f, lllllllllllIIIlIIlIlllllIIllIIlI = System.currentTimeMillis() % (int)lllllllllllIIIlIIlIlllllIIllIIll + (lllllllllllIIIlIIlIlllllIIllIIII - lllllllllllIIIlIIlIlllllIIllIIIl) * 12.0f; lllllllllllIIIlIIlIlllllIIllIIlI > lllllllllllIIIlIIlIlllllIIllIIll; lllllllllllIIIlIIlIlllllIIllIIlI -= lllllllllllIIIlIIlIlllllIIllIIll) {}
        lllllllllllIIIlIIlIlllllIIllIIlI /= lllllllllllIIIlIIlIlllllIIllIIll;
        if (lllllllllllIIIlIIlIlllllIIllIIlI > 0.5) {
            lllllllllllIIIlIIlIlllllIIllIIlI = 0.5f - (lllllllllllIIIlIIlIlllllIIllIIlI - 0.5f);
        }
        lllllllllllIIIlIIlIlllllIIllIIlI += 0.5f;
        return new Color(lllllllllllIIIlIIlIlllllIIllIIlI, 0.4f, 1.0f);
    }
    
    public static Color rainbowCol(final float lllllllllllIIIlIIlIllIlllllllIII, final float lllllllllllIIIlIIlIllIllllllIlll, final float lllllllllllIIIlIIlIllIllllllIllI, final float lllllllllllIIIlIIlIllIlllllllIll) {
        float lllllllllllIIIlIIlIllIlllllllIlI;
        float lllllllllllIIIlIIlIllIlllllllIIl;
        for (lllllllllllIIIlIIlIllIlllllllIlI = 1800.0f, lllllllllllIIIlIIlIllIlllllllIIl = System.currentTimeMillis() % (int)lllllllllllIIIlIIlIllIlllllllIlI + (lllllllllllIIIlIIlIllIllllllIlll - lllllllllllIIIlIIlIllIlllllllIII) * lllllllllllIIIlIIlIllIlllllllIll; lllllllllllIIIlIIlIllIlllllllIIl > lllllllllllIIIlIIlIllIlllllllIlI; lllllllllllIIIlIIlIllIlllllllIIl -= lllllllllllIIIlIIlIllIlllllllIlI) {}
        lllllllllllIIIlIIlIllIlllllllIIl /= lllllllllllIIIlIIlIllIlllllllIlI;
        if (lllllllllllIIIlIIlIllIlllllllIIl > 5.0f) {
            lllllllllllIIIlIIlIllIlllllllIIl = 5.0f - (lllllllllllIIIlIIlIllIlllllllIIl - 5.0f);
        }
        lllllllllllIIIlIIlIllIlllllllIIl += 5.0f;
        return Color.getHSBColor(lllllllllllIIIlIIlIllIlllllllIIl, lllllllllllIIIlIIlIllIllllllIllI, 1.0f);
    }
    
    public static void glColor(final int lllllllllllIIIlIIlIlllllIIlIIlIl) {
        final float lllllllllllIIIlIIlIlllllIIlIIlII = (lllllllllllIIIlIIlIlllllIIlIIlIl >> 24 & 0xFF) / 255.0f;
        final float lllllllllllIIIlIIlIlllllIIlIIIll = (lllllllllllIIIlIIlIlllllIIlIIlIl >> 16 & 0xFF) / 255.0f;
        final float lllllllllllIIIlIIlIlllllIIlIIIlI = (lllllllllllIIIlIIlIlllllIIlIIlIl >> 8 & 0xFF) / 255.0f;
        final float lllllllllllIIIlIIlIlllllIIlIIIIl = (lllllllllllIIIlIIlIlllllIIlIIlIl & 0xFF) / 255.0f;
        GL11.glColor4f(lllllllllllIIIlIIlIlllllIIlIIIll, lllllllllllIIIlIIlIlllllIIlIIIlI, lllllllllllIIIlIIlIlllllIIlIIIIl, lllllllllllIIIlIIlIlllllIIlIIlII);
    }
    
    public static int getColor(final int lllllllllllIIIlIIlIlllIlIIIllllI, final int lllllllllllIIIlIIlIlllIlIIIlllIl, final int lllllllllllIIIlIIlIlllIlIIIlIlll, final int lllllllllllIIIlIIlIlllIlIIIlIllI) {
        int lllllllllllIIIlIIlIlllIlIIIllIlI = 0;
        lllllllllllIIIlIIlIlllIlIIIllIlI |= lllllllllllIIIlIIlIlllIlIIIlIllI << 24;
        lllllllllllIIIlIIlIlllIlIIIllIlI |= lllllllllllIIIlIIlIlllIlIIIllllI << 16;
        lllllllllllIIIlIIlIlllIlIIIllIlI |= lllllllllllIIIlIIlIlllIlIIIlllIl << 8;
        return lllllllllllIIIlIIlIlllIlIIIllIlI |= lllllllllllIIIlIIlIlllIlIIIlIlll;
    }
    
    public static Color getRainbow(final int lllllllllllIIIlIIlIlllIllIlIllII, final int lllllllllllIIIlIIlIlllIllIlIlIII) {
        float lllllllllllIIIlIIlIlllIllIlIlIlI = (float)((System.currentTimeMillis() + lllllllllllIIIlIIlIlllIllIlIllII) % lllllllllllIIIlIIlIlllIllIlIlIII);
        lllllllllllIIIlIIlIlllIllIlIlIlI /= lllllllllllIIIlIIlIlllIllIlIlIII;
        return Color.getHSBColor(lllllllllllIIIlIIlIlllIllIlIlIlI, 0.7f, 1.0f);
    }
    
    public static void color228(final int lllllllllllIIIlIIllIIIIIIlIIIllI) {
        GL11.glColor4ub((byte)(lllllllllllIIIlIIllIIIIIIlIIIllI >> 16 & 0xFF), (byte)(lllllllllllIIIlIIllIIIIIIlIIIllI >> 8 & 0xFF), (byte)(lllllllllllIIIlIIllIIIIIIlIIIllI & 0xFF), (byte)(lllllllllllIIIlIIllIIIIIIlIIIllI >> 24 & 0xFF));
    }
    
    public static void glColor(final int lllllllllllIIIlIIllIIIIIllIIIllI, final int lllllllllllIIIlIIllIIIIIllIIIlIl) {
        final float lllllllllllIIIlIIllIIIIIllIIIlII = (lllllllllllIIIlIIllIIIIIllIIIllI >> 16 & 0xFF) / 255.0f;
        final float lllllllllllIIIlIIllIIIIIllIIIIll = (lllllllllllIIIlIIllIIIIIllIIIllI >> 8 & 0xFF) / 255.0f;
        final float lllllllllllIIIlIIllIIIIIllIIIIlI = (lllllllllllIIIlIIllIIIIIllIIIllI & 0xFF) / 255.0f;
        GlStateManager.color(lllllllllllIIIlIIllIIIIIllIIIlII, lllllllllllIIIlIIllIIIIIllIIIIll, lllllllllllIIIlIIllIIIIIllIIIIlI, lllllllllllIIIlIIllIIIIIllIIIlIl / 255.0f);
    }
    
    public static void drawCircle(final float lllllllllllIIIlIIllIIIIlIIllllIl, final float lllllllllllIIIlIIllIIIIlIlIIlIlI, float lllllllllllIIIlIIllIIIIlIIlllIll, float lllllllllllIIIlIIllIIIIlIIlllIlI, final float lllllllllllIIIlIIllIIIIlIIlllIIl, final float lllllllllllIIIlIIllIIIIlIlIIIllI, final boolean lllllllllllIIIlIIllIIIIlIIllIlll, final Color lllllllllllIIIlIIllIIIIlIlIIIlII) {
        GlStateManager.color(0.0f, 0.0f, 0.0f, 0.0f);
        if (lllllllllllIIIlIIllIIIIlIIlllIll > lllllllllllIIIlIIllIIIIlIIlllIlI) {
            final float lllllllllllIIIlIIllIIIIlIIlllllI = lllllllllllIIIlIIllIIIIlIIlllIlI;
            lllllllllllIIIlIIllIIIIlIIlllIlI = (float)lllllllllllIIIlIIllIIIIlIIlllIll;
            lllllllllllIIIlIIllIIIIlIIlllIll = lllllllllllIIIlIIllIIIIlIIlllllI;
        }
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        setColor(lllllllllllIIIlIIllIIIIlIlIIIlII.getRGB());
        GL11.glEnable(2848);
        GL11.glLineWidth(lllllllllllIIIlIIllIIIIlIlIIIllI);
        GL11.glBegin(3);
        for (float lllllllllllIIIlIIllIIIIlIIllllll = lllllllllllIIIlIIllIIIIlIIlllIlI; lllllllllllIIIlIIllIIIIlIIllllll >= lllllllllllIIIlIIllIIIIlIIlllIll; lllllllllllIIIlIIllIIIIlIIllllll -= 4.0f) {
            final float lllllllllllIIIlIIllIIIIlIlIIIIIl = (float)(Math.cos(lllllllllllIIIlIIllIIIIlIIllllll * 3.141592653589793 / 180.0) * lllllllllllIIIlIIllIIIIlIIlllIIl * 1.0);
            final float lllllllllllIIIlIIllIIIIlIlIIIIll = (float)(Math.sin(lllllllllllIIIlIIllIIIIlIIllllll * 3.141592653589793 / 180.0) * lllllllllllIIIlIIllIIIIlIIlllIIl * 1.0);
            GL11.glVertex2f(lllllllllllIIIlIIllIIIIlIIllllIl + lllllllllllIIIlIIllIIIIlIlIIIIIl, lllllllllllIIIlIIllIIIIlIlIIlIlI + lllllllllllIIIlIIllIIIIlIlIIIIll);
        }
        GL11.glEnd();
        GL11.glDisable(2848);
        GL11.glEnable(2848);
        GL11.glBegin(lllllllllllIIIlIIllIIIIlIIllIlll ? 6 : 3);
        for (float lllllllllllIIIlIIllIIIIlIIllllll = lllllllllllIIIlIIllIIIIlIIlllIlI; lllllllllllIIIlIIllIIIIlIIllllll >= lllllllllllIIIlIIllIIIIlIIlllIll; lllllllllllIIIlIIllIIIIlIIllllll -= 4.0f) {
            final float lllllllllllIIIlIIllIIIIlIlIIIIII = (float)Math.cos(lllllllllllIIIlIIllIIIIlIIllllll * 3.141592653589793 / 180.0) * lllllllllllIIIlIIllIIIIlIIlllIIl;
            final float lllllllllllIIIlIIllIIIIlIlIIIIlI = (float)Math.sin(lllllllllllIIIlIIllIIIIlIIllllll * 3.141592653589793 / 180.0) * lllllllllllIIIlIIllIIIIlIIlllIIl;
            GL11.glVertex2f(lllllllllllIIIlIIllIIIIlIIllllIl + lllllllllllIIIlIIllIIIIlIlIIIIII, lllllllllllIIIlIIllIIIIlIlIIlIlI + lllllllllllIIIlIIllIIIIlIlIIIIlI);
        }
        GL11.glEnd();
        GL11.glDisable(2848);
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }
    
    public static void renderBlurredShadow(double lllllllllllIIIlIIllIIIlIllIIIIll, double lllllllllllIIIlIIllIIIlIllIIIIlI, double lllllllllllIIIlIIllIIIlIllIIIIIl, double lllllllllllIIIlIIllIIIlIllIIIIII, final int lllllllllllIIIlIIllIIIlIllIIlIll, final Color lllllllllllIIIlIIllIIIlIlIlllllI) {
        GlStateManager.alphaFunc(516, 0.01f);
        lllllllllllIIIlIIllIIIlIllIIIIIl += lllllllllllIIIlIIllIIIlIllIIlIll * 2;
        lllllllllllIIIlIIllIIIlIllIIIIII += lllllllllllIIIlIIllIIIlIllIIlIll * 2;
        lllllllllllIIIlIIllIIIlIllIIIIll -= lllllllllllIIIlIIllIIIlIllIIlIll;
        lllllllllllIIIlIIllIIIlIllIIIIlI -= (String)(double)lllllllllllIIIlIIllIIIlIllIIlIll;
        final float lllllllllllIIIlIIllIIIlIllIIlIIl = (float)(lllllllllllIIIlIIllIIIlIllIIIIll - 0.25);
        final float lllllllllllIIIlIIllIIIlIllIIlIII = (float)(lllllllllllIIIlIIllIIIlIllIIIIlI + 0.25);
        final int lllllllllllIIIlIIllIIIlIllIIIlll = (int)(lllllllllllIIIlIIllIIIlIllIIIIIl * lllllllllllIIIlIIllIIIlIllIIIIII + lllllllllllIIIlIIllIIIlIllIIIIIl + lllllllllllIIIlIIllIIIlIlIlllllI.hashCode() * lllllllllllIIIlIIllIIIlIllIIlIll + lllllllllllIIIlIIllIIIlIllIIlIll);
        GL11.glEnable(3553);
        GL11.glDisable(2884);
        GL11.glEnable(3008);
        GL11.glEnable(3042);
        int lllllllllllIIIlIIllIIIlIllIIIllI = -1;
        if (DrawHelper.shadowCache.containsKey(lllllllllllIIIlIIllIIIlIllIIIlll)) {
            lllllllllllIIIlIIllIIIlIllIIIllI = DrawHelper.shadowCache.get(lllllllllllIIIlIIllIIIlIllIIIlll);
            GlStateManager.bindTexture(lllllllllllIIIlIIllIIIlIllIIIllI);
        }
        else {
            lllllllllllIIIlIIllIIIlIllIIIIIl = MathHelper.clamp(lllllllllllIIIlIIllIIIlIllIIIIIl, 0.01, lllllllllllIIIlIIllIIIlIllIIIIIl);
            lllllllllllIIIlIIllIIIlIllIIIIII = MathHelper.clamp(lllllllllllIIIlIIllIIIlIllIIIIII, 0.01, lllllllllllIIIlIIllIIIlIllIIIIII);
            final BufferedImage lllllllllllIIIlIIllIIIlIllIIIlIl = new BufferedImage((int)lllllllllllIIIlIIllIIIlIllIIIIIl, (int)lllllllllllIIIlIIllIIIlIllIIIIII, 2);
            final Graphics lllllllllllIIIlIIllIIIlIllIIIlII = lllllllllllIIIlIIllIIIlIllIIIlIl.getGraphics();
            lllllllllllIIIlIIllIIIlIllIIIlII.setColor(lllllllllllIIIlIIllIIIlIlIlllllI);
            lllllllllllIIIlIIllIIIlIllIIIlII.fillRect(lllllllllllIIIlIIllIIIlIllIIlIll, lllllllllllIIIlIIllIIIlIllIIlIll, (int)lllllllllllIIIlIIllIIIlIllIIIIIl - lllllllllllIIIlIIllIIIlIllIIlIll * 2, (int)lllllllllllIIIlIIllIIIlIllIIIIII - lllllllllllIIIlIIllIIIlIllIIlIll * 2);
            lllllllllllIIIlIIllIIIlIllIIIlII.dispose();
        }
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glBegin(7);
        GL11.glTexCoord2f(0.0f, 0.0f);
        GL11.glVertex2f(lllllllllllIIIlIIllIIIlIllIIlIIl, lllllllllllIIIlIIllIIIlIllIIlIII);
        GL11.glTexCoord2f(0.0f, 1.0f);
        GL11.glVertex2f(lllllllllllIIIlIIllIIIlIllIIlIIl, lllllllllllIIIlIIllIIIlIllIIlIII + (int)lllllllllllIIIlIIllIIIlIllIIIIII);
        GL11.glTexCoord2f(1.0f, 1.0f);
        GL11.glVertex2f(lllllllllllIIIlIIllIIIlIllIIlIIl + (int)lllllllllllIIIlIIllIIIlIllIIIIIl, lllllllllllIIIlIIllIIIlIllIIlIII + (int)lllllllllllIIIlIIllIIIlIllIIIIII);
        GL11.glTexCoord2f(1.0f, 0.0f);
        GL11.glVertex2f(lllllllllllIIIlIIllIIIlIllIIlIIl + (int)lllllllllllIIIlIIllIIIlIllIIIIIl, lllllllllllIIIlIIllIIIlIllIIlIII);
        GL11.glEnd();
        GL11.glDisable(3553);
    }
    
    public static Color astolfoColor(final int lllllllllllIIIlIIlIlllIIIllIIlIl, final int lllllllllllIIIlIIlIlllIIIllIlIII) {
        float lllllllllllIIIlIIlIlllIIIllIIlll;
        float lllllllllllIIIlIIlIlllIIIllIIllI;
        for (lllllllllllIIIlIIlIlllIIIllIIlll = 2900.0f, lllllllllllIIIlIIlIlllIIIllIIllI = System.currentTimeMillis() % (int)lllllllllllIIIlIIlIlllIIIllIIlll + (float)((lllllllllllIIIlIIlIlllIIIllIlIII - lllllllllllIIIlIIlIlllIIIllIIlIl) * 9); lllllllllllIIIlIIlIlllIIIllIIllI > lllllllllllIIIlIIlIlllIIIllIIlll; lllllllllllIIIlIIlIlllIIIllIIllI -= lllllllllllIIIlIIlIlllIIIllIIlll) {}
        lllllllllllIIIlIIlIlllIIIllIIllI /= lllllllllllIIIlIIlIlllIIIllIIlll;
        if (lllllllllllIIIlIIlIlllIIIllIIllI > 0.5) {
            lllllllllllIIIlIIlIlllIIIllIIllI = 0.5f - (lllllllllllIIIlIIlIlllIIIllIIllI - 0.5f);
        }
        lllllllllllIIIlIIlIlllIIIllIIllI += 0.5f;
        return new Color(lllllllllllIIIlIIlIlllIIIllIIllI, 0.5f, 1.0f);
    }
    
    public static void disableSmoothLine() {
        GL11.glEnable(3553);
        GL11.glEnable(2929);
        GL11.glDisable(3042);
        GL11.glEnable(3008);
        GL11.glDepthMask(true);
        GL11.glCullFace(1029);
        GL11.glDisable(2848);
        GL11.glHint(3154, 4352);
        GL11.glHint(3155, 4352);
    }
    
    public static void drawBorder(final float lllllllllllIIIlIIllIIIIlllIlllIl, final float lllllllllllIIIlIIllIIIIllllIIlII, final float lllllllllllIIIlIIllIIIIllllIIIll, final float lllllllllllIIIlIIllIIIIlllIllIlI, final float lllllllllllIIIlIIllIIIIllllIIIIl, final int lllllllllllIIIlIIllIIIIlllIllIII, final int lllllllllllIIIlIIllIIIIlllIlIlll, final boolean lllllllllllIIIlIIllIIIIlllIlIllI) {
        drawRect(lllllllllllIIIlIIllIIIIlllIlllIl - (lllllllllllIIIlIIllIIIIlllIlIllI ? 0.0f : lllllllllllIIIlIIllIIIIllllIIIIl), lllllllllllIIIlIIllIIIIllllIIlII - (lllllllllllIIIlIIllIIIIlllIlIllI ? 0.0f : lllllllllllIIIlIIllIIIIllllIIIIl), lllllllllllIIIlIIllIIIIllllIIIll + (lllllllllllIIIlIIllIIIIlllIlIllI ? 0.0f : lllllllllllIIIlIIllIIIIllllIIIIl), lllllllllllIIIlIIllIIIIlllIllIlI + (lllllllllllIIIlIIllIIIIlllIlIllI ? 0.0f : lllllllllllIIIlIIllIIIIllllIIIIl), lllllllllllIIIlIIllIIIIlllIlIlll);
        drawRect(lllllllllllIIIlIIllIIIIlllIlllIl + (lllllllllllIIIlIIllIIIIlllIlIllI ? lllllllllllIIIlIIllIIIIllllIIIIl : 0.0f), lllllllllllIIIlIIllIIIIllllIIlII + (lllllllllllIIIlIIllIIIIlllIlIllI ? lllllllllllIIIlIIllIIIIllllIIIIl : 0.0f), lllllllllllIIIlIIllIIIIllllIIIll - (lllllllllllIIIlIIllIIIIlllIlIllI ? lllllllllllIIIlIIllIIIIllllIIIIl : 0.0f), lllllllllllIIIlIIllIIIIlllIllIlI - (lllllllllllIIIlIIllIIIIlllIlIllI ? lllllllllllIIIlIIllIIIIllllIIIIl : 0.0f), lllllllllllIIIlIIllIIIIlllIllIII);
    }
    
    public static Color blend(final Color lllllllllllIIIlIIlIlllIIlIlIIIIl, final Color lllllllllllIIIlIIlIlllIIlIlIllII, final double lllllllllllIIIlIIlIlllIIlIlIlIll) {
        final float lllllllllllIIIlIIlIlllIIlIlIlIlI = (float)lllllllllllIIIlIIlIlllIIlIlIlIll;
        final float lllllllllllIIIlIIlIlllIIlIlIlIIl = 1.0f - lllllllllllIIIlIIlIlllIIlIlIlIlI;
        final float[] lllllllllllIIIlIIlIlllIIlIlIlIII = new float[3];
        final float[] lllllllllllIIIlIIlIlllIIlIlIIlll = new float[3];
        lllllllllllIIIlIIlIlllIIlIlIIIIl.getColorComponents(lllllllllllIIIlIIlIlllIIlIlIlIII);
        lllllllllllIIIlIIlIlllIIlIlIllII.getColorComponents(lllllllllllIIIlIIlIlllIIlIlIIlll);
        float lllllllllllIIIlIIlIlllIIlIlIIllI = lllllllllllIIIlIIlIlllIIlIlIlIII[0] * lllllllllllIIIlIIlIlllIIlIlIlIlI + lllllllllllIIIlIIlIlllIIlIlIIlll[0] * lllllllllllIIIlIIlIlllIIlIlIlIIl;
        float lllllllllllIIIlIIlIlllIIlIlIIlIl = lllllllllllIIIlIIlIlllIIlIlIlIII[1] * lllllllllllIIIlIIlIlllIIlIlIlIlI + lllllllllllIIIlIIlIlllIIlIlIIlll[1] * lllllllllllIIIlIIlIlllIIlIlIlIIl;
        float lllllllllllIIIlIIlIlllIIlIlIIlII = lllllllllllIIIlIIlIlllIIlIlIlIII[2] * lllllllllllIIIlIIlIlllIIlIlIlIlI + lllllllllllIIIlIIlIlllIIlIlIIlll[2] * lllllllllllIIIlIIlIlllIIlIlIlIIl;
        if (lllllllllllIIIlIIlIlllIIlIlIIllI < 0.0f) {
            lllllllllllIIIlIIlIlllIIlIlIIllI = 0.0f;
        }
        else if (lllllllllllIIIlIIlIlllIIlIlIIllI > 255.0f) {
            lllllllllllIIIlIIlIlllIIlIlIIllI = 255.0f;
        }
        if (lllllllllllIIIlIIlIlllIIlIlIIlIl < 0.0f) {
            lllllllllllIIIlIIlIlllIIlIlIIlIl = 0.0f;
        }
        else if (lllllllllllIIIlIIlIlllIIlIlIIlIl > 255.0f) {
            lllllllllllIIIlIIlIlllIIlIlIIlIl = 255.0f;
        }
        if (lllllllllllIIIlIIlIlllIIlIlIIlII < 0.0f) {
            lllllllllllIIIlIIlIlllIIlIlIIlII = 0.0f;
        }
        else if (lllllllllllIIIlIIlIlllIIlIlIIlII > 255.0f) {
            lllllllllllIIIlIIlIlllIIlIlIIlII = 255.0f;
        }
        Color lllllllllllIIIlIIlIlllIIlIlIIIll = null;
        try {
            lllllllllllIIIlIIlIlllIIlIlIIIll = new Color(lllllllllllIIIlIIlIlllIIlIlIIllI, lllllllllllIIIlIIlIlllIIlIlIIlIl, lllllllllllIIIlIIlIlllIIlIlIIlII);
        }
        catch (IllegalArgumentException lllllllllllIIIlIIlIlllIIlIlIIIlI) {
            final byte lllllllllllIIIlIIlIlllIIlIIlIlIl = (byte)NumberFormat.getNumberInstance();
        }
        return lllllllllllIIIlIIlIlllIIlIlIIIll;
    }
    
    public static Color astolfoColors12(final int lllllllllllIIIlIIlIlllIIIIlIllIl, final int lllllllllllIIIlIIlIlllIIIIlIlIII) {
        float lllllllllllIIIlIIlIlllIIIIlIlIll;
        float lllllllllllIIIlIIlIlllIIIIlIlIlI;
        for (lllllllllllIIIlIIlIlllIIIIlIlIll = 2900.0f, lllllllllllIIIlIIlIlllIIIIlIlIlI = System.currentTimeMillis() % (int)lllllllllllIIIlIIlIlllIIIIlIlIll + (float)((lllllllllllIIIlIIlIlllIIIIlIlIII - lllllllllllIIIlIIlIlllIIIIlIllIl) * 9); lllllllllllIIIlIIlIlllIIIIlIlIlI > lllllllllllIIIlIIlIlllIIIIlIlIll; lllllllllllIIIlIIlIlllIIIIlIlIlI -= lllllllllllIIIlIIlIlllIIIIlIlIll) {}
        lllllllllllIIIlIIlIlllIIIIlIlIlI /= lllllllllllIIIlIIlIlllIIIIlIlIll;
        if (lllllllllllIIIlIIlIlllIIIIlIlIlI > 0.5) {
            lllllllllllIIIlIIlIlllIIIIlIlIlI = 0.5f - (lllllllllllIIIlIIlIlllIIIIlIlIlI - 0.5f);
        }
        lllllllllllIIIlIIlIlllIIIIlIlIlI += 0.5f;
        return new Color(lllllllllllIIIlIIlIlllIIIIlIlIlI, 0.5f, 1.0f);
    }
    
    public static void drawGradientRect1(final double lllllllllllIIIlIIllIIIIllIIIlIII, final double lllllllllllIIIlIIllIIIIllIIlIlll, final double lllllllllllIIIlIIllIIIIllIIlIllI, final double lllllllllllIIIlIIllIIIIllIIlIlIl, final int lllllllllllIIIlIIllIIIIllIIlIlII, final int lllllllllllIIIlIIllIIIIllIIlIIll) {
        final float lllllllllllIIIlIIllIIIIllIIlIIlI = (lllllllllllIIIlIIllIIIIllIIlIlII >> 24 & 0xFF) / 255.0f;
        final float lllllllllllIIIlIIllIIIIllIIlIIIl = (lllllllllllIIIlIIllIIIIllIIlIlII >> 16 & 0xFF) / 255.0f;
        final float lllllllllllIIIlIIllIIIIllIIlIIII = (lllllllllllIIIlIIllIIIIllIIlIlII >> 8 & 0xFF) / 255.0f;
        final float lllllllllllIIIlIIllIIIIllIIIllll = (lllllllllllIIIlIIllIIIIllIIlIlII & 0xFF) / 255.0f;
        final float lllllllllllIIIlIIllIIIIllIIIlllI = (lllllllllllIIIlIIllIIIIllIIlIIll >> 24 & 0xFF) / 255.0f;
        final float lllllllllllIIIlIIllIIIIllIIIllIl = (lllllllllllIIIlIIllIIIIllIIlIIll >> 16 & 0xFF) / 255.0f;
        final float lllllllllllIIIlIIllIIIIllIIIllII = (lllllllllllIIIlIIllIIIIllIIlIIll >> 8 & 0xFF) / 255.0f;
        final float lllllllllllIIIlIIllIIIIllIIIlIll = (lllllllllllIIIlIIllIIIIllIIlIIll & 0xFF) / 255.0f;
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.shadeModel(7425);
        final Tessellator lllllllllllIIIlIIllIIIIllIIIlIlI = Tessellator.getInstance();
        final BufferBuilder lllllllllllIIIlIIllIIIIllIIIlIIl = lllllllllllIIIlIIllIIIIllIIIlIlI.getBuffer();
        lllllllllllIIIlIIllIIIIllIIIlIIl.begin(7, DefaultVertexFormats.POSITION_COLOR);
        lllllllllllIIIlIIllIIIIllIIIlIIl.pos(lllllllllllIIIlIIllIIIIllIIIlIII, lllllllllllIIIlIIllIIIIllIIlIlll, DrawHelper.gui.zLevel).color(lllllllllllIIIlIIllIIIIllIIlIIIl, lllllllllllIIIlIIllIIIIllIIlIIII, lllllllllllIIIlIIllIIIIllIIIllll, lllllllllllIIIlIIllIIIIllIIlIIlI).endVertex();
        lllllllllllIIIlIIllIIIIllIIIlIIl.pos(lllllllllllIIIlIIllIIIIllIIIlIII, lllllllllllIIIlIIllIIIIllIIlIlIl, DrawHelper.gui.zLevel).color(lllllllllllIIIlIIllIIIIllIIlIIIl, lllllllllllIIIlIIllIIIIllIIlIIII, lllllllllllIIIlIIllIIIIllIIIllll, lllllllllllIIIlIIllIIIIllIIlIIlI).endVertex();
        lllllllllllIIIlIIllIIIIllIIIlIIl.pos(lllllllllllIIIlIIllIIIIllIIlIllI, lllllllllllIIIlIIllIIIIllIIlIlIl, DrawHelper.gui.zLevel).color(lllllllllllIIIlIIllIIIIllIIIllIl, lllllllllllIIIlIIllIIIIllIIIllII, lllllllllllIIIlIIllIIIIllIIIlIll, lllllllllllIIIlIIllIIIIllIIIlllI).endVertex();
        lllllllllllIIIlIIllIIIIllIIIlIIl.pos(lllllllllllIIIlIIllIIIIllIIlIllI, lllllllllllIIIlIIllIIIIllIIlIlll, DrawHelper.gui.zLevel).color(lllllllllllIIIlIIllIIIIllIIIllIl, lllllllllllIIIlIIllIIIIllIIIllII, lllllllllllIIIlIIllIIIIllIIIlIll, lllllllllllIIIlIIllIIIIllIIIlllI).endVertex();
        lllllllllllIIIlIIllIIIIllIIIlIlI.draw();
        GlStateManager.shadeModel(7424);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
    }
    
    private static FloatBuffer setColorBuffer(final double lllllllllllIIIlIIllIIIIIIIIlIllI, final double lllllllllllIIIlIIllIIIIIIIIlIIIl, final double lllllllllllIIIlIIllIIIIIIIIlIlII, final double lllllllllllIIIlIIllIIIIIIIIIllll) {
        return setColorBuffer((float)lllllllllllIIIlIIllIIIIIIIIlIllI, (float)lllllllllllIIIlIIllIIIIIIIIlIIIl, (float)lllllllllllIIIlIIllIIIIIIIIlIlII, (float)lllllllllllIIIlIIllIIIIIIIIIllll);
    }
    
    public static int color(final int lllllllllllIIIlIIlIlllIlllIIIIll, final int lllllllllllIIIlIIlIlllIllIlllllI, final int lllllllllllIIIlIIlIlllIlllIIIIIl, int lllllllllllIIIlIIlIlllIllIllllII) {
        lllllllllllIIIlIIlIlllIllIllllII = 255;
        return new Color(lllllllllllIIIlIIlIlllIlllIIIIll, lllllllllllIIIlIIlIlllIllIlllllI, lllllllllllIIIlIIlIlllIlllIIIIIl, lllllllllllIIIlIIlIlllIllIllllII).getRGB();
    }
    
    public static void glColor(final int lllllllllllIIIlIIllIIIIIlIllIIlI, final float lllllllllllIIIlIIllIIIIIlIllIllI) {
        final float lllllllllllIIIlIIllIIIIIlIllIlIl = (lllllllllllIIIlIIllIIIIIlIllIIlI >> 16 & 0xFF) / 255.0f;
        final float lllllllllllIIIlIIllIIIIIlIllIlII = (lllllllllllIIIlIIllIIIIIlIllIIlI >> 8 & 0xFF) / 255.0f;
        final float lllllllllllIIIlIIllIIIIIlIllIIll = (lllllllllllIIIlIIllIIIIIlIllIIlI & 0xFF) / 255.0f;
        GlStateManager.color(lllllllllllIIIlIIllIIIIIlIllIlIl, lllllllllllIIIlIIllIIIIIlIllIlII, lllllllllllIIIlIIllIIIIIlIllIIll, lllllllllllIIIlIIllIIIIIlIllIllI);
    }
    
    public static void drawBorderedRect(final double lllllllllllIIIlIIlIlllllIlIIIIIl, final double lllllllllllIIIlIIlIlllllIlIIlIII, final double lllllllllllIIIlIIlIlllllIIllllll, final double lllllllllllIIIlIIlIlllllIIlllllI, final double lllllllllllIIIlIIlIlllllIIllllIl, final int lllllllllllIIIlIIlIlllllIIllllII, final int lllllllllllIIIlIIlIlllllIIlllIll, final boolean lllllllllllIIIlIIlIlllllIlIIIIlI) {
        drawRect(lllllllllllIIIlIIlIlllllIlIIIIIl - (lllllllllllIIIlIIlIlllllIlIIIIlI ? 0.0 : lllllllllllIIIlIIlIlllllIIllllIl), lllllllllllIIIlIIlIlllllIlIIlIII - (lllllllllllIIIlIIlIlllllIlIIIIlI ? 0.0 : lllllllllllIIIlIIlIlllllIIllllIl), lllllllllllIIIlIIlIlllllIIllllll + (lllllllllllIIIlIIlIlllllIlIIIIlI ? 0.0 : lllllllllllIIIlIIlIlllllIIllllIl), lllllllllllIIIlIIlIlllllIIlllllI + (lllllllllllIIIlIIlIlllllIlIIIIlI ? 0.0 : lllllllllllIIIlIIlIlllllIIllllIl), lllllllllllIIIlIIlIlllllIIlllIll);
        drawRect(lllllllllllIIIlIIlIlllllIlIIIIIl + (lllllllllllIIIlIIlIlllllIlIIIIlI ? lllllllllllIIIlIIlIlllllIIllllIl : 0.0), lllllllllllIIIlIIlIlllllIlIIlIII + (lllllllllllIIIlIIlIlllllIlIIIIlI ? lllllllllllIIIlIIlIlllllIIllllIl : 0.0), lllllllllllIIIlIIlIlllllIIllllll - (lllllllllllIIIlIIlIlllllIlIIIIlI ? lllllllllllIIIlIIlIlllllIIllllIl : 0.0), lllllllllllIIIlIIlIlllllIIlllllI - (lllllllllllIIIlIIlIlllllIlIIIIlI ? lllllllllllIIIlIIlIlllllIIllllIl : 0.0), lllllllllllIIIlIIlIlllllIIllllII);
    }
    
    public static double interpolate(final double lllllllllllIIIlIIlIllllIIIlIIlIl, final double lllllllllllIIIlIIlIllllIIIlIIlll, final double lllllllllllIIIlIIlIllllIIIlIIllI) {
        return lllllllllllIIIlIIlIllllIIIlIIlll + (lllllllllllIIIlIIlIllllIIIlIIlIl - lllllllllllIIIlIIlIllllIIIlIIlll) * lllllllllllIIIlIIlIllllIIIlIIllI;
    }
    
    public static void enableSmoothLine(final float lllllllllllIIIlIIllIIIIIIIIIllIl) {
        GL11.glDisable(3008);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(3553);
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GL11.glEnable(2884);
        GL11.glEnable(2848);
        GL11.glHint(3154, 4354);
        GL11.glHint(3155, 4354);
        GL11.glLineWidth(lllllllllllIIIlIIllIIIIIIIIIllIl);
    }
    
    public static void drawRoundedRect99(final double lllllllllllIIIlIIlIlllllllIlIIIl, final double lllllllllllIIIlIIlIlllllllIlIlIl, final double lllllllllllIIIlIIlIlllllllIIllll, final double lllllllllllIIIlIIlIlllllllIlIIll, final int lllllllllllIIIlIIlIlllllllIIllIl) {
        drawRect(lllllllllllIIIlIIlIlllllllIlIIIl + 0.5, lllllllllllIIIlIIlIlllllllIlIlIl, lllllllllllIIIlIIlIlllllllIIllll - 0.5, lllllllllllIIIlIIlIlllllllIlIlIl + 0.5, lllllllllllIIIlIIlIlllllllIIllIl);
        drawRect(lllllllllllIIIlIIlIlllllllIlIIIl + 0.5, lllllllllllIIIlIIlIlllllllIlIIll - 0.5, lllllllllllIIIlIIlIlllllllIIllll - 0.5, lllllllllllIIIlIIlIlllllllIlIIll, lllllllllllIIIlIIlIlllllllIIllIl);
        drawRect(lllllllllllIIIlIIlIlllllllIlIIIl, lllllllllllIIIlIIlIlllllllIlIlIl + 0.5, lllllllllllIIIlIIlIlllllllIIllll, lllllllllllIIIlIIlIlllllllIlIIll - 0.5, lllllllllllIIIlIIlIlllllllIIllIl);
    }
    
    public static int astolfo(final int lllllllllllIIIlIIlIlllIIlIIIllII, final int lllllllllllIIIlIIlIlllIIlIIIlIll) {
        float lllllllllllIIIlIIlIlllIIlIIIlllI;
        float lllllllllllIIIlIIlIlllIIlIIIllIl;
        for (lllllllllllIIIlIIlIlllIIlIIIlllI = ArreyList.time.getNumberValue() * 1000.0f, lllllllllllIIIlIIlIlllIIlIIIllIl = (float)(System.currentTimeMillis() % (int)lllllllllllIIIlIIlIlllIIlIIIlllI + (lllllllllllIIIlIIlIlllIIlIIIllII - lllllllllllIIIlIIlIlllIIlIIIlIll) * 9L); lllllllllllIIIlIIlIlllIIlIIIllIl > lllllllllllIIIlIIlIlllIIlIIIlllI; lllllllllllIIIlIIlIlllIIlIIIllIl -= lllllllllllIIIlIIlIlllIIlIIIlllI) {}
        lllllllllllIIIlIIlIlllIIlIIIllIl /= lllllllllllIIIlIIlIlllIIlIIIlllI;
        if (lllllllllllIIIlIIlIlllIIlIIIllIl > 0.5) {
            lllllllllllIIIlIIlIlllIIlIIIllIl = 0.5f - (lllllllllllIIIlIIlIlllIIlIIIllIl - 0.5f);
        }
        lllllllllllIIIlIIlIlllIIlIIIllIl += 0.5f;
        return Color.HSBtoRGB(lllllllllllIIIlIIlIlllIIlIIIllIl, 0.6f, 1.0f);
    }
    
    public static int getTeamColor(final Entity lllllllllllIIIlIIlIlllIIIIllIlIl) {
        int lllllllllllIIIlIIlIlllIIIIllIlII = -1;
        if (lllllllllllIIIlIIlIlllIIIIllIlIl.getDisplayName().getUnformattedText().equalsIgnoreCase("\u0420\u0457\u0421\u2014\u0420\u2026f[\u0420\u0457\u0421\u2014\u0420\u2026cR\u0420\u0457\u0421\u2014\u0420\u2026f]\u0420\u0457\u0421\u2014\u0420\u2026c" + lllllllllllIIIlIIlIlllIIIIllIlIl.getName())) {
            lllllllllllIIIlIIlIlllIIIIllIlII = getColor(new Color(255, 60, 60));
        }
        else if (lllllllllllIIIlIIlIlllIIIIllIlIl.getDisplayName().getUnformattedText().equalsIgnoreCase("\u0420\u0457\u0421\u2014\u0420\u2026f[\u0420\u0457\u0421\u2014\u0420\u20269B\u0420\u0457\u0421\u2014\u0420\u2026f]\u0420\u0457\u0421\u2014\u0420\u20269" + lllllllllllIIIlIIlIlllIIIIllIlIl.getName())) {
            lllllllllllIIIlIIlIlllIIIIllIlII = getColor(new Color(60, 60, 255));
        }
        else if (lllllllllllIIIlIIlIlllIIIIllIlIl.getDisplayName().getUnformattedText().equalsIgnoreCase("\u0420\u0457\u0421\u2014\u0420\u2026f[\u0420\u0457\u0421\u2014\u0420\u2026eY\u0420\u0457\u0421\u2014\u0420\u2026f]\u0420\u0457\u0421\u2014\u0420\u2026e" + lllllllllllIIIlIIlIlllIIIIllIlIl.getName())) {
            lllllllllllIIIlIIlIlllIIIIllIlII = getColor(new Color(255, 255, 60));
        }
        else if (lllllllllllIIIlIIlIlllIIIIllIlIl.getDisplayName().getUnformattedText().equalsIgnoreCase("\u0420\u0457\u0421\u2014\u0420\u2026f[\u0420\u0457\u0421\u2014\u0420\u2026aG\u0420\u0457\u0421\u2014\u0420\u2026f]\u0420\u0457\u0421\u2014\u0420\u2026a" + lllllllllllIIIlIIlIlllIIIIllIlIl.getName())) {
            lllllllllllIIIlIIlIlllIIIIllIlII = getColor(new Color(60, 255, 60));
        }
        else {
            lllllllllllIIIlIIlIlllIIIIllIlII = getColor(new Color(255, 255, 255));
        }
        return lllllllllllIIIlIIlIlllIIIIllIlII;
    }
    
    public static int astolfoColors4(final float lllllllllllIIIlIIlIlllIIIIlIIIII, final float lllllllllllIIIlIIlIlllIIIIIllIlI, final float lllllllllllIIIlIIlIlllIIIIIllIIl) {
        float lllllllllllIIIlIIlIlllIIIIIlllIl;
        float lllllllllllIIIlIIlIlllIIIIIlllII;
        for (lllllllllllIIIlIIlIlllIIIIIlllIl = 1800.0f, lllllllllllIIIlIIlIlllIIIIIlllII = System.currentTimeMillis() % (int)lllllllllllIIIlIIlIlllIIIIIlllIl + (lllllllllllIIIlIIlIlllIIIIIllIlI - lllllllllllIIIlIIlIlllIIIIlIIIII) * 12.0f; lllllllllllIIIlIIlIlllIIIIIlllII > lllllllllllIIIlIIlIlllIIIIIlllIl; lllllllllllIIIlIIlIlllIIIIIlllII -= lllllllllllIIIlIIlIlllIIIIIlllIl) {}
        lllllllllllIIIlIIlIlllIIIIIlllII /= lllllllllllIIIlIIlIlllIIIIIlllIl;
        if (lllllllllllIIIlIIlIlllIIIIIlllII > 0.5) {
            lllllllllllIIIlIIlIlllIIIIIlllII = 0.5f - (lllllllllllIIIlIIlIlllIIIIIlllII - 0.5f);
        }
        lllllllllllIIIlIIlIlllIIIIIlllII += 0.5f;
        return Color.HSBtoRGB(lllllllllllIIIlIIlIlllIIIIIlllII, lllllllllllIIIlIIlIlllIIIIIllIIl, 1.0f);
    }
    
    public static Color getColorWithOpacity(final Color lllllllllllIIIlIIlIllllIlIIllIIl, final int lllllllllllIIIlIIlIllllIlIIllIII) {
        return new Color(lllllllllllIIIlIIlIllllIlIIllIIl.getRed(), lllllllllllIIIlIIlIllllIlIIllIIl.getGreen(), lllllllllllIIIlIIlIllllIlIIllIIl.getBlue(), lllllllllllIIIlIIlIllllIlIIllIII);
    }
    
    public static Color getGradientOffset(final Color lllllllllllIIIlIIlIlllIlIlIIlIll, final Color lllllllllllIIIlIIlIlllIlIlIIlIlI, double lllllllllllIIIlIIlIlllIlIlIIlIIl) {
        if (lllllllllllIIIlIIlIlllIlIlIIlIIl > 1.0) {
            final double lllllllllllIIIlIIlIlllIlIlIlIIIl = lllllllllllIIIlIIlIlllIlIlIIlIIl % 1.0;
            final int lllllllllllIIIlIIlIlllIlIlIlIIII = (int)lllllllllllIIIlIIlIlllIlIlIIlIIl;
            lllllllllllIIIlIIlIlllIlIlIIlIIl = ((lllllllllllIIIlIIlIlllIlIlIlIIII % 2 == 0) ? lllllllllllIIIlIIlIlllIlIlIlIIIl : (1.0 - lllllllllllIIIlIIlIlllIlIlIlIIIl));
        }
        final double lllllllllllIIIlIIlIlllIlIlIIllll = 1.0 - lllllllllllIIIlIIlIlllIlIlIIlIIl;
        final int lllllllllllIIIlIIlIlllIlIlIIlllI = (int)(lllllllllllIIIlIIlIlllIlIlIIlIll.getRed() * lllllllllllIIIlIIlIlllIlIlIIllll + lllllllllllIIIlIIlIlllIlIlIIlIlI.getRed() * lllllllllllIIIlIIlIlllIlIlIIlIIl);
        final int lllllllllllIIIlIIlIlllIlIlIIllIl = (int)(lllllllllllIIIlIIlIlllIlIlIIlIll.getGreen() * lllllllllllIIIlIIlIlllIlIlIIllll + lllllllllllIIIlIIlIlllIlIlIIlIlI.getGreen() * lllllllllllIIIlIIlIlllIlIlIIlIIl);
        final int lllllllllllIIIlIIlIlllIlIlIIllII = (int)(lllllllllllIIIlIIlIlllIlIlIIlIll.getBlue() * lllllllllllIIIlIIlIlllIlIlIIllll + lllllllllllIIIlIIlIlllIlIlIIlIlI.getBlue() * lllllllllllIIIlIIlIlllIlIlIIlIIl);
        return new Color(lllllllllllIIIlIIlIlllIlIlIIlllI, lllllllllllIIIlIIlIlllIlIlIIllIl, lllllllllllIIIlIIlIlllIlIlIIllII);
    }
    
    public static void drawCircle3D(final TileEntity lllllllllllIIIlIIllIIIlIIllIlIll, final double lllllllllllIIIlIIllIIIlIIlllIlII, final float lllllllllllIIIlIIllIIIlIIlllIIll, final int lllllllllllIIIlIIllIIIlIIllIlIIl, final float lllllllllllIIIlIIllIIIlIIlllIIIl, final int lllllllllllIIIlIIllIIIlIIllIIlll) {
        GL11.glPushMatrix();
        GL11.glDisable(3553);
        GL11.glEnable(2848);
        GL11.glHint(3154, 4354);
        GL11.glDisable(2929);
        GL11.glLineWidth(lllllllllllIIIlIIllIIIlIIlllIIIl);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(2929);
        GL11.glBegin(3);
        final double n = lllllllllllIIIlIIllIIIlIIllIlIll.getPos().getX();
        DrawHelper.mc.getRenderManager();
        final double lllllllllllIIIlIIllIIIlIIllIllll = n - RenderManager.renderPosX;
        final double n2 = lllllllllllIIIlIIllIIIlIIllIlIll.getPos().getY();
        DrawHelper.mc.getRenderManager();
        final double lllllllllllIIIlIIllIIIlIIllIlllI = n2 - RenderManager.renderPosY;
        final double n3 = lllllllllllIIIlIIllIIIlIIllIlIll.getPos().getZ();
        DrawHelper.mc.getRenderManager();
        final double lllllllllllIIIlIIllIIIlIIllIllIl = n3 - RenderManager.renderPosZ;
        setColor(lllllllllllIIIlIIllIIIlIIllIIlll);
        for (int lllllllllllIIIlIIllIIIlIIllIllII = 0; lllllllllllIIIlIIllIIIlIIllIllII <= lllllllllllIIIlIIllIIIlIIllIlIIl; ++lllllllllllIIIlIIllIIIlIIllIllII) {
            GL11.glVertex3d(lllllllllllIIIlIIllIIIlIIllIllll + lllllllllllIIIlIIllIIIlIIlllIlII * Math.cos(lllllllllllIIIlIIllIIIlIIllIllII * 6.2831855f / lllllllllllIIIlIIllIIIlIIllIlIIl), lllllllllllIIIlIIllIIIlIIllIlllI, lllllllllllIIIlIIllIIIlIIllIllIl + lllllllllllIIIlIIllIIIlIIlllIlII * Math.sin(lllllllllllIIIlIIllIIIlIIllIllII * 6.2831855f / lllllllllllIIIlIIllIIIlIIllIlIIl));
        }
        GL11.glEnd();
        GL11.glDepthMask(true);
        GL11.glDisable(3042);
        GL11.glEnable(2929);
        GL11.glDisable(2848);
        GL11.glEnable(2929);
        GL11.glEnable(3553);
        GL11.glPopMatrix();
    }
    
    public static int getColor2(final Color lllllllllllIIIlIIllIIIllIIlIIlll) {
        return getColor(lllllllllllIIIlIIllIIIllIIlIIlll.getRed(), lllllllllllIIIlIIllIIIllIIlIIlll.getGreen(), lllllllllllIIIlIIllIIIllIIlIIlll.getBlue(), lllllllllllIIIlIIllIIIllIIlIIlll.getAlpha());
    }
    
    public static void disableStandardItemLighting() {
        GlStateManager.disableLighting();
        GlStateManager.disableLight(0);
        GlStateManager.disableLight(1);
        GlStateManager.disableColorMaterial();
    }
    
    public static Color TwoColoreffect(final Color lllllllllllIIIlIIlIlllIIlIIIIIll, final Color lllllllllllIIIlIIlIlllIIlIIIIIlI, final double lllllllllllIIIlIIlIlllIIlIIIIIIl) {
        final double lllllllllllIIIlIIlIlllIIlIIIIIII = lllllllllllIIIlIIlIlllIIlIIIIIIl / 4.0 % 1.0;
        final float lllllllllllIIIlIIlIlllIIIlllllll = MathHelper.clamp((float)Math.sin(18.84955592153876 * lllllllllllIIIlIIlIlllIIlIIIIIII) / 2.0f + 0.5f, 0.0f, 1.0f);
        return new Color(lerp(lllllllllllIIIlIIlIlllIIlIIIIIll.getRed() / 255.0f, lllllllllllIIIlIIlIlllIIlIIIIIlI.getRed() / 255.0f, lllllllllllIIIlIIlIlllIIIlllllll), lerp(lllllllllllIIIlIIlIlllIIlIIIIIll.getGreen() / 255.0f, lllllllllllIIIlIIlIlllIIlIIIIIlI.getGreen() / 255.0f, lllllllllllIIIlIIlIlllIIIlllllll), lerp(lllllllllllIIIlIIlIlllIIlIIIIIll.getBlue() / 255.0f, lllllllllllIIIlIIlIlllIIlIIIIIlI.getBlue() / 255.0f, lllllllllllIIIlIIlIlllIIIlllllll));
    }
    
    public static void putVertex3d(final Vec3d lllllllllllIIIlIIlIllllIIIIllIII) {
        GL11.glVertex3d(lllllllllllIIIlIIlIllllIIIIllIII.xCoord, lllllllllllIIIlIIlIllllIIIIllIII.yCoord, lllllllllllIIIlIIlIllllIIIIllIII.zCoord);
    }
    
    public static int getColor(final int lllllllllllIIIlIIlIlllIlIIIIlIlI, final int lllllllllllIIIlIIlIlllIlIIIIlIll) {
        return getColor(lllllllllllIIIlIIlIlllIlIIIIlIlI, lllllllllllIIIlIIlIlllIlIIIIlIlI, lllllllllllIIIlIIlIlllIlIIIIlIlI, lllllllllllIIIlIIlIlllIlIIIIlIll);
    }
    
    public static void drawLinesAroundPlayer(final Entity lllllllllllIIIlIIllIIIIIIlIlllIl, final double lllllllllllIIIlIIllIIIIIIlIlIIIl, final float lllllllllllIIIlIIllIIIIIIlIlIIII, final int lllllllllllIIIlIIllIIIIIIlIllIlI, final float lllllllllllIIIlIIllIIIIIIlIllIIl, final int lllllllllllIIIlIIllIIIIIIlIIllIl) {
        GL11.glPushMatrix();
        enableGL2D3();
        GL11.glDisable(3553);
        GL11.glEnable(2848);
        GL11.glHint(3154, 4354);
        GL11.glDisable(2929);
        GL11.glLineWidth(lllllllllllIIIlIIllIIIIIIlIllIIl);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(2929);
        GL11.glBegin(3);
        final RenderManager lllllllllllIIIlIIllIIIIIIlIlIlll = Minecraft.getMinecraft().getRenderManager();
        final double lllllllllllIIIlIIllIIIIIIlIlIllI = lllllllllllIIIlIIllIIIIIIlIlllIl.lastTickPosX + (lllllllllllIIIlIIllIIIIIIlIlllIl.posX - lllllllllllIIIlIIllIIIIIIlIlllIl.lastTickPosX) * lllllllllllIIIlIIllIIIIIIlIlIIII - lllllllllllIIIlIIllIIIIIIlIlIlll.viewerPosX;
        final double lllllllllllIIIlIIllIIIIIIlIlIlIl = lllllllllllIIIlIIllIIIIIIlIlllIl.lastTickPosY + (lllllllllllIIIlIIllIIIIIIlIlllIl.posY - lllllllllllIIIlIIllIIIIIIlIlllIl.lastTickPosY) * lllllllllllIIIlIIllIIIIIIlIlIIII - lllllllllllIIIlIIllIIIIIIlIlIlll.viewerPosY;
        final double lllllllllllIIIlIIllIIIIIIlIlIlII = lllllllllllIIIlIIllIIIIIIlIlllIl.lastTickPosZ + (lllllllllllIIIlIIllIIIIIIlIlllIl.posZ - lllllllllllIIIlIIllIIIIIIlIlllIl.lastTickPosZ) * lllllllllllIIIlIIllIIIIIIlIlIIII - lllllllllllIIIlIIllIIIIIIlIlIlll.viewerPosZ;
        color228(lllllllllllIIIlIIllIIIIIIlIIllIl);
        for (int lllllllllllIIIlIIllIIIIIIlIlIIll = 0; lllllllllllIIIlIIllIIIIIIlIlIIll <= lllllllllllIIIlIIllIIIIIIlIllIlI; ++lllllllllllIIIlIIllIIIIIIlIlIIll) {
            GL11.glVertex3d(lllllllllllIIIlIIllIIIIIIlIlIllI + lllllllllllIIIlIIllIIIIIIlIlIIIl * Math.cos(lllllllllllIIIlIIllIIIIIIlIlIIll * 6.283185307179586 / lllllllllllIIIlIIllIIIIIIlIllIlI), lllllllllllIIIlIIllIIIIIIlIlIlIl, lllllllllllIIIlIIllIIIIIIlIlIlII + lllllllllllIIIlIIllIIIIIIlIlIIIl * Math.sin(lllllllllllIIIlIIllIIIIIIlIlIIll * 6.283185307179586 / lllllllllllIIIlIIllIIIIIIlIllIlI));
        }
        GL11.glEnd();
        GL11.glDepthMask(true);
        GL11.glDisable(3042);
        GL11.glEnable(2929);
        GL11.glDisable(2848);
        GL11.glEnable(2929);
        GL11.glEnable(3553);
        disableGL2D3();
        GL11.glPopMatrix();
    }
    
    public static void drawPolygonPart(final double lllllllllllIIIlIIlIllllllIIlIlII, final double lllllllllllIIIlIIlIllllllIlIIllI, final int lllllllllllIIIlIIlIllllllIIlIIlI, final int lllllllllllIIIlIIlIllllllIIlIIIl, final int lllllllllllIIIlIIlIllllllIlIIIll, final int lllllllllllIIIlIIlIllllllIlIIIlI) {
        final float lllllllllllIIIlIIlIllllllIlIIIIl = (lllllllllllIIIlIIlIllllllIlIIIll >> 24 & 0xFF) / 255.0f;
        final float lllllllllllIIIlIIlIllllllIlIIIII = (lllllllllllIIIlIIlIllllllIlIIIll >> 16 & 0xFF) / 255.0f;
        final float lllllllllllIIIlIIlIllllllIIlllll = (lllllllllllIIIlIIlIllllllIlIIIll >> 8 & 0xFF) / 255.0f;
        final float lllllllllllIIIlIIlIllllllIIllllI = (lllllllllllIIIlIIlIllllllIlIIIll & 0xFF) / 255.0f;
        final float lllllllllllIIIlIIlIllllllIIlllIl = (lllllllllllIIIlIIlIllllllIlIIIlI >> 24 & 0xFF) / 255.0f;
        final float lllllllllllIIIlIIlIllllllIIlllII = (lllllllllllIIIlIIlIllllllIlIIIlI >> 16 & 0xFF) / 255.0f;
        final float lllllllllllIIIlIIlIllllllIIllIll = (lllllllllllIIIlIIlIllllllIlIIIlI >> 8 & 0xFF) / 255.0f;
        final float lllllllllllIIIlIIlIllllllIIllIlI = (lllllllllllIIIlIIlIllllllIlIIIlI & 0xFF) / 255.0f;
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.shadeModel(7425);
        final Tessellator lllllllllllIIIlIIlIllllllIIllIIl = Tessellator.getInstance();
        final BufferBuilder lllllllllllIIIlIIlIllllllIIllIII = lllllllllllIIIlIIlIllllllIIllIIl.getBuffer();
        lllllllllllIIIlIIlIllllllIIllIII.begin(6, DefaultVertexFormats.POSITION_COLOR);
        lllllllllllIIIlIIlIllllllIIllIII.pos(lllllllllllIIIlIIlIllllllIIlIlII, lllllllllllIIIlIIlIllllllIlIIllI, 0.0).color(lllllllllllIIIlIIlIllllllIlIIIII, lllllllllllIIIlIIlIllllllIIlllll, lllllllllllIIIlIIlIllllllIIllllI, lllllllllllIIIlIIlIllllllIlIIIIl).endVertex();
        final double lllllllllllIIIlIIlIllllllIIlIlll = 6.283185307179586;
        for (int lllllllllllIIIlIIlIllllllIIlIllI = lllllllllllIIIlIIlIllllllIIlIIIl * 90; lllllllllllIIIlIIlIllllllIIlIllI <= lllllllllllIIIlIIlIllllllIIlIIIl * 90 + 90; ++lllllllllllIIIlIIlIllllllIIlIllI) {
            final double lllllllllllIIIlIIlIllllllIIlIlIl = 6.283185307179586 * lllllllllllIIIlIIlIllllllIIlIllI / 360.0 + Math.toRadians(180.0);
            lllllllllllIIIlIIlIllllllIIllIII.pos(lllllllllllIIIlIIlIllllllIIlIlII + Math.sin(lllllllllllIIIlIIlIllllllIIlIlIl) * lllllllllllIIIlIIlIllllllIIlIIlI, lllllllllllIIIlIIlIllllllIlIIllI + Math.cos(lllllllllllIIIlIIlIllllllIIlIlIl) * lllllllllllIIIlIIlIllllllIIlIIlI, 0.0).color(lllllllllllIIIlIIlIllllllIIlllII, lllllllllllIIIlIIlIllllllIIllIll, lllllllllllIIIlIIlIllllllIIllIlI, lllllllllllIIIlIIlIllllllIIlllIl).endVertex();
        }
        lllllllllllIIIlIIlIllllllIIllIIl.draw();
        GlStateManager.shadeModel(7424);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
    }
    
    public static void drawEntityBox(final Entity lllllllllllIIIlIIllIIIlIIlIlIIII, final Color lllllllllllIIIlIIllIIIlIIlIllIII, final boolean lllllllllllIIIlIIllIIIlIIlIlIlll, final float lllllllllllIIIlIIllIIIlIIlIlIllI) {
        GlStateManager.pushMatrix();
        GlStateManager.blendFunc(770, 771);
        GL11.glEnable(3042);
        GlStateManager.glLineWidth(2.0f);
        GlStateManager.disableTexture2D();
        GL11.glDisable(2929);
        GlStateManager.depthMask(false);
        final double n = lllllllllllIIIlIIllIIIlIIlIlIIII.lastTickPosX + (lllllllllllIIIlIIllIIIlIIlIlIIII.posX - lllllllllllIIIlIIllIIIlIIlIlIIII.lastTickPosX) * DrawHelper.mc.timer.renderPartialTicks;
        DrawHelper.mc.getRenderManager();
        final double lllllllllllIIIlIIllIIIlIIlIlIlIl = n - RenderManager.renderPosX;
        final double n2 = lllllllllllIIIlIIllIIIlIIlIlIIII.lastTickPosY + (lllllllllllIIIlIIllIIIlIIlIlIIII.posY - lllllllllllIIIlIIllIIIlIIlIlIIII.lastTickPosY) * DrawHelper.mc.timer.renderPartialTicks;
        DrawHelper.mc.getRenderManager();
        final double lllllllllllIIIlIIllIIIlIIlIlIlII = n2 - RenderManager.renderPosY;
        final double n3 = lllllllllllIIIlIIllIIIlIIlIlIIII.lastTickPosZ + (lllllllllllIIIlIIllIIIlIIlIlIIII.posZ - lllllllllllIIIlIIllIIIlIIlIlIIII.lastTickPosZ) * DrawHelper.mc.timer.renderPartialTicks;
        DrawHelper.mc.getRenderManager();
        final double lllllllllllIIIlIIllIIIlIIlIlIIll = n3 - RenderManager.renderPosZ;
        final AxisAlignedBB lllllllllllIIIlIIllIIIlIIlIlIIlI = lllllllllllIIIlIIllIIIlIIlIlIIII.getEntityBoundingBox();
        final AxisAlignedBB lllllllllllIIIlIIllIIIlIIlIlIIIl = new AxisAlignedBB(lllllllllllIIIlIIllIIIlIIlIlIIlI.minX - lllllllllllIIIlIIllIIIlIIlIlIIII.posX + lllllllllllIIIlIIllIIIlIIlIlIlIl - 0.05, lllllllllllIIIlIIllIIIlIIlIlIIlI.minY - lllllllllllIIIlIIllIIIlIIlIlIIII.posY + lllllllllllIIIlIIllIIIlIIlIlIlII, lllllllllllIIIlIIllIIIlIIlIlIIlI.minZ - lllllllllllIIIlIIllIIIlIIlIlIIII.posZ + lllllllllllIIIlIIllIIIlIIlIlIIll - 0.05, lllllllllllIIIlIIllIIIlIIlIlIIlI.maxX - lllllllllllIIIlIIllIIIlIIlIlIIII.posX + lllllllllllIIIlIIllIIIlIIlIlIlIl + 0.05, lllllllllllIIIlIIllIIIlIIlIlIIlI.maxY - lllllllllllIIIlIIllIIIlIIlIlIIII.posY + lllllllllllIIIlIIllIIIlIIlIlIlII + 0.15, lllllllllllIIIlIIllIIIlIIlIlIIlI.maxZ - lllllllllllIIIlIIllIIIlIIlIlIIII.posZ + lllllllllllIIIlIIllIIIlIIlIlIIll + 0.05);
        GlStateManager.glLineWidth(2.0f);
        GL11.glEnable(2848);
        GlStateManager.color(lllllllllllIIIlIIllIIIlIIlIllIII.getRed() / 255.0f, lllllllllllIIIlIIllIIIlIIlIllIII.getGreen() / 255.0f, lllllllllllIIIlIIllIIIlIIlIllIII.getBlue() / 255.0f, lllllllllllIIIlIIllIIIlIIlIlIllI);
        if (lllllllllllIIIlIIllIIIlIIlIlIlll) {
            drawColorBox(lllllllllllIIIlIIllIIIlIIlIlIIIl, lllllllllllIIIlIIllIIIlIIlIllIII.getRed() / 255.0f, lllllllllllIIIlIIllIIIlIIlIllIII.getGreen() / 255.0f, lllllllllllIIIlIIllIIIlIIlIllIII.getBlue() / 255.0f, lllllllllllIIIlIIllIIIlIIlIlIllI);
            GlStateManager.color(0.0f, 0.0f, 0.0f, 0.5f);
        }
        drawSelectionBoundingBox(lllllllllllIIIlIIllIIIlIIlIlIIIl);
        GlStateManager.glLineWidth(2.0f);
        GlStateManager.enableTexture2D();
        GL11.glEnable(2929);
        GlStateManager.depthMask(true);
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }
    
    public static final void color(final double lllllllllllIIIlIIlIlllllIIIlIlll, final double lllllllllllIIIlIIlIlllllIIIlIllI, final double lllllllllllIIIlIIlIlllllIIIlIlIl, final double lllllllllllIIIlIIlIlllllIIIlIIII) {
        GL11.glColor4d(lllllllllllIIIlIIlIlllllIIIlIlll, lllllllllllIIIlIIlIlllllIIIlIllI, lllllllllllIIIlIIlIlllllIIIlIlIl, lllllllllllIIIlIIlIlllllIIIlIIII);
    }
    
    public static void drawOutlineRect(final float lllllllllllIIIlIIllIIIlIIIlllIlI, final float lllllllllllIIIlIIllIIIlIIIlllIIl, final float lllllllllllIIIlIIllIIIlIIIlllIII, final float lllllllllllIIIlIIllIIIlIIIllIIII, final Color lllllllllllIIIlIIllIIIlIIIllIllI, final Color lllllllllllIIIlIIllIIIlIIIlIlllI) {
        drawRect(lllllllllllIIIlIIllIIIlIIIlllIlI, lllllllllllIIIlIIllIIIlIIIlllIIl, lllllllllllIIIlIIllIIIlIIIlllIlI + lllllllllllIIIlIIllIIIlIIIlllIII, lllllllllllIIIlIIllIIIlIIIlllIIl + lllllllllllIIIlIIllIIIlIIIllIIII, lllllllllllIIIlIIllIIIlIIIllIllI.getRGB());
        final int lllllllllllIIIlIIllIIIlIIIllIlII = lllllllllllIIIlIIllIIIlIIIlIlllI.getRGB();
        drawRect(lllllllllllIIIlIIllIIIlIIIlllIlI - 1.0f, lllllllllllIIIlIIllIIIlIIIlllIIl, lllllllllllIIIlIIllIIIlIIIlllIlI, lllllllllllIIIlIIllIIIlIIIlllIIl + lllllllllllIIIlIIllIIIlIIIllIIII, lllllllllllIIIlIIllIIIlIIIllIlII);
        drawRect(lllllllllllIIIlIIllIIIlIIIlllIlI + lllllllllllIIIlIIllIIIlIIIlllIII, lllllllllllIIIlIIllIIIlIIIlllIIl, lllllllllllIIIlIIllIIIlIIIlllIlI + lllllllllllIIIlIIllIIIlIIIlllIII + 1.0f, lllllllllllIIIlIIllIIIlIIIlllIIl + lllllllllllIIIlIIllIIIlIIIllIIII, lllllllllllIIIlIIllIIIlIIIllIlII);
        drawRect(lllllllllllIIIlIIllIIIlIIIlllIlI - 1.0f, lllllllllllIIIlIIllIIIlIIIlllIIl - 1.0f, lllllllllllIIIlIIllIIIlIIIlllIlI + lllllllllllIIIlIIllIIIlIIIlllIII + 1.0f, lllllllllllIIIlIIllIIIlIIIlllIIl, lllllllllllIIIlIIllIIIlIIIllIlII);
        drawRect(lllllllllllIIIlIIllIIIlIIIlllIlI - 1.0f, lllllllllllIIIlIIllIIIlIIIlllIIl + lllllllllllIIIlIIllIIIlIIIllIIII, lllllllllllIIIlIIllIIIlIIIlllIlI + lllllllllllIIIlIIllIIIlIIIlllIII + 1.0f, lllllllllllIIIlIIllIIIlIIIlllIIl + lllllllllllIIIlIIllIIIlIIIllIIII + 1.0f, lllllllllllIIIlIIllIIIlIIIllIlII);
    }
    
    public static void drawRoundedRect1(final double lllllllllllIIIlIIlIllllIlIIIIlll, final double lllllllllllIIIlIIlIllllIlIIIIIIl, final double lllllllllllIIIlIIlIllllIlIIIIlIl, final double lllllllllllIIIlIIlIllllIIlllllll, final int lllllllllllIIIlIIlIllllIlIIIIIll) {
        drawRect(lllllllllllIIIlIIlIllllIlIIIIlll + 0.5, lllllllllllIIIlIIlIllllIlIIIIIIl, lllllllllllIIIlIIlIllllIlIIIIlIl - 0.5, lllllllllllIIIlIIlIllllIlIIIIIIl + 0.5, lllllllllllIIIlIIlIllllIlIIIIIll);
        drawRect(lllllllllllIIIlIIlIllllIlIIIIlll + 0.5, lllllllllllIIIlIIlIllllIIlllllll - 0.5, lllllllllllIIIlIIlIllllIlIIIIlIl - 0.5, lllllllllllIIIlIIlIllllIIlllllll, lllllllllllIIIlIIlIllllIlIIIIIll);
        drawRect(lllllllllllIIIlIIlIllllIlIIIIlll, lllllllllllIIIlIIlIllllIlIIIIIIl + 0.5, lllllllllllIIIlIIlIllllIlIIIIlIl, lllllllllllIIIlIIlIllllIIlllllll - 0.5, lllllllllllIIIlIIlIllllIlIIIIIll);
    }
    
    public static void blockEsp(final BlockPos lllllllllllIIIlIIllIIIIIlIIlIlIl, final Color lllllllllllIIIlIIllIIIIIlIIIlllI, final boolean lllllllllllIIIlIIllIIIIIlIIIllIl) {
        final double n = lllllllllllIIIlIIllIIIIIlIIlIlIl.getX();
        DrawHelper.mc.getRenderManager();
        final double lllllllllllIIIlIIllIIIIIlIIlIIlI = n - RenderManager.renderPosX;
        final double n2 = lllllllllllIIIlIIllIIIIIlIIlIlIl.getY();
        DrawHelper.mc.getRenderManager();
        final double lllllllllllIIIlIIllIIIIIlIIlIIIl = n2 - RenderManager.renderPosY;
        final double n3 = lllllllllllIIIlIIllIIIIIlIIlIlIl.getZ();
        DrawHelper.mc.getRenderManager();
        final double lllllllllllIIIlIIllIIIIIlIIlIIII = n3 - RenderManager.renderPosZ;
        GL11.glPushMatrix();
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(3042);
        GL11.glLineWidth(2.0f);
        GL11.glDisable(3553);
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GlStateManager.color(lllllllllllIIIlIIllIIIIIlIIIlllI.getRed() / 255.0f, lllllllllllIIIlIIllIIIIIlIIIlllI.getGreen() / 255.0f, lllllllllllIIIlIIllIIIIIlIIIlllI.getBlue() / 255.0f, 0.15f);
        drawColorBox(new AxisAlignedBB(lllllllllllIIIlIIllIIIIIlIIlIIlI, lllllllllllIIIlIIllIIIIIlIIlIIIl, lllllllllllIIIlIIllIIIIIlIIlIIII, lllllllllllIIIlIIllIIIIIlIIlIIlI + 1.0, lllllllllllIIIlIIllIIIIIlIIlIIIl + 1.0, lllllllllllIIIlIIllIIIIIlIIlIIII + 1.0), 0.0f, 0.0f, 0.0f, 0.0f);
        if (lllllllllllIIIlIIllIIIIIlIIIllIl) {
            GlStateManager.color(0.0f, 0.0f, 0.0f, 0.5f);
            drawSelectionBoundingBox(new AxisAlignedBB(lllllllllllIIIlIIllIIIIIlIIlIIlI, lllllllllllIIIlIIllIIIIIlIIlIIIl, lllllllllllIIIlIIllIIIIIlIIlIIII, lllllllllllIIIlIIllIIIIIlIIlIIlI + 1.0, lllllllllllIIIlIIllIIIIIlIIlIIIl + 1.0, lllllllllllIIIlIIllIIIIIlIIlIIII + 1.0));
        }
        GL11.glLineWidth(2.0f);
        GL11.glEnable(3553);
        GL11.glEnable(2929);
        GL11.glDepthMask(true);
        GL11.glDisable(3042);
        GL11.glPopMatrix();
    }
    
    public static Color fade(final Color lllllllllllIIIlIIlIlllIIlllllllI, final int lllllllllllIIIlIIlIlllIIllllllIl, final int lllllllllllIIIlIIlIlllIIllllllII) {
        final float[] lllllllllllIIIlIIlIlllIlIIIIIIII = new float[3];
        Color.RGBtoHSB(lllllllllllIIIlIIlIlllIIlllllllI.getRed(), lllllllllllIIIlIIlIlllIIlllllllI.getGreen(), lllllllllllIIIlIIlIlllIIlllllllI.getBlue(), lllllllllllIIIlIIlIlllIlIIIIIIII);
        float lllllllllllIIIlIIlIlllIIllllllll = Math.abs((System.currentTimeMillis() % 2000L / 1000.0f + lllllllllllIIIlIIlIlllIIllllllIl / (float)lllllllllllIIIlIIlIlllIIllllllII * 2.0f) % 2.0f - 1.0f);
        lllllllllllIIIlIIlIlllIIllllllll = 0.5f + 0.5f * lllllllllllIIIlIIlIlllIIllllllll;
        lllllllllllIIIlIIlIlllIlIIIIIIII[2] = lllllllllllIIIlIIlIlllIIllllllll % 2.0f;
        return new Color(Color.HSBtoRGB(lllllllllllIIIlIIlIlllIlIIIIIIII[0], lllllllllllIIIlIIlIlllIlIIIIIIII[1], lllllllllllIIIlIIlIlllIlIIIIIIII[2]));
    }
    
    public static Color setAlpha(final Color lllllllllllIIIlIIlIllllIlIIlllll, int lllllllllllIIIlIIlIllllIlIIlllII) {
        lllllllllllIIIlIIlIllllIlIIlllII = (byte)MathHelper.clamp(lllllllllllIIIlIIlIllllIlIIlllII, 0, 255);
        return new Color(lllllllllllIIIlIIlIllllIlIIlllll.getRed(), lllllllllllIIIlIIlIllllIlIIlllll.getGreen(), lllllllllllIIIlIIlIllllIlIIlllll.getBlue(), lllllllllllIIIlIIlIllllIlIIlllII);
    }
    
    public static Color astolfoColors5(final float lllllllllllIIIlIIlIlllIIIIIIlIlI, final float lllllllllllIIIlIIlIlllIIIIIIllll, final float lllllllllllIIIlIIlIlllIIIIIIlIII, final float lllllllllllIIIlIIlIlllIIIIIIIlll) {
        float lllllllllllIIIlIIlIlllIIIIIIllII;
        float lllllllllllIIIlIIlIlllIIIIIIlIll;
        for (lllllllllllIIIlIIlIlllIIIIIIllII = 1800.0f, lllllllllllIIIlIIlIlllIIIIIIlIll = System.currentTimeMillis() % (int)lllllllllllIIIlIIlIlllIIIIIIllII + (lllllllllllIIIlIIlIlllIIIIIIllll - lllllllllllIIIlIIlIlllIIIIIIlIlI) * lllllllllllIIIlIIlIlllIIIIIIIlll; lllllllllllIIIlIIlIlllIIIIIIlIll > lllllllllllIIIlIIlIlllIIIIIIllII; lllllllllllIIIlIIlIlllIIIIIIlIll -= lllllllllllIIIlIIlIlllIIIIIIllII) {}
        lllllllllllIIIlIIlIlllIIIIIIlIll /= lllllllllllIIIlIIlIlllIIIIIIllII;
        if (lllllllllllIIIlIIlIlllIIIIIIlIll > 0.5) {
            lllllllllllIIIlIIlIlllIIIIIIlIll = 0.5f - (lllllllllllIIIlIIlIlllIIIIIIlIll - 0.5f);
        }
        lllllllllllIIIlIIlIlllIIIIIIlIll += 0.5f;
        return Color.getHSBColor(lllllllllllIIIlIIlIlllIIIIIIlIll, lllllllllllIIIlIIlIlllIIIIIIlIII, 1.0f);
    }
    
    public static void drawCircle(final float lllllllllllIIIlIIllIIIlIlIlIIlIl, final float lllllllllllIIIlIIllIIIlIlIlIIlII, final float lllllllllllIIIlIIllIIIlIlIlIIIll, final int lllllllllllIIIlIIllIIIlIlIlIIIlI) {
        final float lllllllllllIIIlIIllIIIlIlIlIlIlI = (lllllllllllIIIlIIllIIIlIlIlIIIlI >> 24 & 0xFF) / 255.0f;
        final float lllllllllllIIIlIIllIIIlIlIlIlIIl = (lllllllllllIIIlIIllIIIlIlIlIIIlI >> 16 & 0xFF) / 255.0f;
        final float lllllllllllIIIlIIllIIIlIlIlIlIII = (lllllllllllIIIlIIllIIIlIlIlIIIlI >> 8 & 0xFF) / 255.0f;
        final float lllllllllllIIIlIIllIIIlIlIlIIlll = (lllllllllllIIIlIIllIIIlIlIlIIIlI & 0xFF) / 255.0f;
        GL11.glColor4f(lllllllllllIIIlIIllIIIlIlIlIlIIl, lllllllllllIIIlIIllIIIlIlIlIlIII, lllllllllllIIIlIIllIIIlIlIlIIlll, lllllllllllIIIlIIllIIIlIlIlIlIlI);
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(2848);
        GL11.glPushMatrix();
        GL11.glLineWidth(1.0f);
        GL11.glBegin(9);
        for (int lllllllllllIIIlIIllIIIlIlIlIIllI = 0; lllllllllllIIIlIIllIIIlIlIlIIllI <= 360; ++lllllllllllIIIlIIllIIIlIlIlIIllI) {
            GL11.glVertex2d(lllllllllllIIIlIIllIIIlIlIlIIlIl + Math.sin(lllllllllllIIIlIIllIIIlIlIlIIllI * 3.141592653589793 / 180.0) * lllllllllllIIIlIIllIIIlIlIlIIIll, lllllllllllIIIlIIllIIIlIlIlIIlII + Math.cos(lllllllllllIIIlIIllIIIlIlIlIIllI * 3.141592653589793 / 180.0) * lllllllllllIIIlIIllIIIlIlIlIIIll);
        }
        GL11.glEnd();
        GL11.glPopMatrix();
        GL11.glEnable(3553);
        GL11.glDisable(2848);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
    }
    
    public static void drawGradientSideways(final double lllllllllllIIIlIIlIlllIIIlIlIIll, final double lllllllllllIIIlIIlIlllIIIlIlIIlI, final double lllllllllllIIIlIIlIlllIIIlIIIIll, final double lllllllllllIIIlIIlIlllIIIlIlIIII, final int lllllllllllIIIlIIlIlllIIIlIIIIIl, final int lllllllllllIIIlIIlIlllIIIlIIlllI) {
        final float lllllllllllIIIlIIlIlllIIIlIIllIl = (lllllllllllIIIlIIlIlllIIIlIIIIIl >> 24 & 0xFF) / 255.0f;
        final float lllllllllllIIIlIIlIlllIIIlIIllII = (lllllllllllIIIlIIlIlllIIIlIIIIIl >> 16 & 0xFF) / 255.0f;
        final float lllllllllllIIIlIIlIlllIIIlIIlIll = (lllllllllllIIIlIIlIlllIIIlIIIIIl >> 8 & 0xFF) / 255.0f;
        final float lllllllllllIIIlIIlIlllIIIlIIlIlI = (lllllllllllIIIlIIlIlllIIIlIIIIIl & 0xFF) / 255.0f;
        final float lllllllllllIIIlIIlIlllIIIlIIlIIl = (lllllllllllIIIlIIlIlllIIIlIIlllI >> 24 & 0xFF) / 255.0f;
        final float lllllllllllIIIlIIlIlllIIIlIIlIII = (lllllllllllIIIlIIlIlllIIIlIIlllI >> 16 & 0xFF) / 255.0f;
        final float lllllllllllIIIlIIlIlllIIIlIIIlll = (lllllllllllIIIlIIlIlllIIIlIIlllI >> 8 & 0xFF) / 255.0f;
        final float lllllllllllIIIlIIlIlllIIIlIIIllI = (lllllllllllIIIlIIlIlllIIIlIIlllI & 0xFF) / 255.0f;
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(2848);
        GL11.glShadeModel(7425);
        GL11.glPushMatrix();
        GL11.glBegin(7);
        GL11.glColor4f(lllllllllllIIIlIIlIlllIIIlIIllII, lllllllllllIIIlIIlIlllIIIlIIlIll, lllllllllllIIIlIIlIlllIIIlIIlIlI, lllllllllllIIIlIIlIlllIIIlIIllIl);
        GL11.glVertex2d(lllllllllllIIIlIIlIlllIIIlIlIIll, lllllllllllIIIlIIlIlllIIIlIlIIlI);
        GL11.glVertex2d(lllllllllllIIIlIIlIlllIIIlIlIIll, lllllllllllIIIlIIlIlllIIIlIlIIII);
        GL11.glColor4f(lllllllllllIIIlIIlIlllIIIlIIlIII, lllllllllllIIIlIIlIlllIIIlIIIlll, lllllllllllIIIlIIlIlllIIIlIIIllI, lllllllllllIIIlIIlIlllIIIlIIlIIl);
        GL11.glVertex2d(lllllllllllIIIlIIlIlllIIIlIIIIll, lllllllllllIIIlIIlIlllIIIlIlIIII);
        GL11.glVertex2d(lllllllllllIIIlIIlIlllIIIlIIIIll, lllllllllllIIIlIIlIlllIIIlIlIIlI);
        GL11.glEnd();
        GL11.glPopMatrix();
        GL11.glEnable(3553);
        GL11.glDisable(3042);
    }
    
    public static void endSmooth() {
        GL11.glDisable(2848);
        GL11.glDisable(2881);
        GL11.glEnable(2832);
    }
    
    public static void drawSmoothRectBetter(final float lllllllllllIIIlIIllIIIIlllIIIlII, final float lllllllllllIIIlIIllIIIIllIlllllI, final float lllllllllllIIIlIIllIIIIllIllllIl, final float lllllllllllIIIlIIllIIIIllIllllII, final int lllllllllllIIIlIIllIIIIllIlllIll) {
        drawSmoothRect1(lllllllllllIIIlIIllIIIIlllIIIlII, lllllllllllIIIlIIllIIIIllIlllllI, lllllllllllIIIlIIllIIIIlllIIIlII + lllllllllllIIIlIIllIIIIllIllllIl, lllllllllllIIIlIIllIIIIllIlllllI + lllllllllllIIIlIIllIIIIllIllllII, lllllllllllIIIlIIllIIIIllIlllIll);
    }
    
    private static void shaderConfigFix(final float lllllllllllIIIlIIllIIIlIllllllll, final float lllllllllllIIIlIIllIIIllIIIIIIIl, final float lllllllllllIIIlIIllIIIllIIIIIIII) {
        DrawHelper.blurShader.getShaders().get(0).getShaderManager().getShaderUniform("Radius").set(lllllllllllIIIlIIllIIIlIllllllll);
        DrawHelper.blurShader.getShaders().get(1).getShaderManager().getShaderUniform("Radius").set(lllllllllllIIIlIIllIIIlIllllllll);
        DrawHelper.blurShader.getShaders().get(0).getShaderManager().getShaderUniform("BlurDir").set(lllllllllllIIIlIIllIIIllIIIIIIIl, lllllllllllIIIlIIllIIIllIIIIIIII);
        DrawHelper.blurShader.getShaders().get(1).getShaderManager().getShaderUniform("BlurDir").set(lllllllllllIIIlIIllIIIllIIIIIIII, lllllllllllIIIlIIllIIIllIIIIIIIl);
    }
    
    public static void disableGL2D() {
        GL11.glEnable(3553);
        GL11.glEnable(2929);
        GL11.glDisable(2848);
        GL11.glHint(3154, 4352);
        GL11.glHint(3155, 4352);
    }
    
    public static int getColor(final int lllllllllllIIIlIIlIlllIlIIlIlIIl, final int lllllllllllIIIlIIlIlllIlIIlIIlIl, final int lllllllllllIIIlIIlIlllIlIIlIIlll) {
        return getColor(lllllllllllIIIlIIlIlllIlIIlIlIIl, lllllllllllIIIlIIlIlllIlIIlIIlIl, lllllllllllIIIlIIlIlllIlIIlIIlll, 255);
    }
    
    public static void drawImage(final ResourceLocation lllllllllllIIIlIIlIlllllllllllIl, final float lllllllllllIIIlIIllIIIIIIIIIIIll, final float lllllllllllIIIlIIlIllllllllllIll, final float lllllllllllIIIlIIllIIIIIIIIIIIIl, final float lllllllllllIIIlIIlIllllllllllIIl, final Color lllllllllllIIIlIIlIlllllllllllll) {
        final ScaledResolution lllllllllllIIIlIIlIllllllllllllI = new ScaledResolution(Minecraft.getMinecraft());
        GL11.glDisable(2929);
        GL11.glEnable(3042);
        GL11.glDepthMask(false);
        OpenGlHelper.glBlendFunc(770, 771, 1, 0);
        setColor(lllllllllllIIIlIIlIlllllllllllll.getRGB());
        Minecraft.getMinecraft().getTextureManager().bindTexture(lllllllllllIIIlIIlIlllllllllllIl);
        Gui.drawModalRectWithCustomSizedTexture(lllllllllllIIIlIIllIIIIIIIIIIIll, lllllllllllIIIlIIlIllllllllllIll, 0.0f, 0.0f, lllllllllllIIIlIIllIIIIIIIIIIIIl, lllllllllllIIIlIIlIllllllllllIIl, lllllllllllIIIlIIllIIIIIIIIIIIIl, lllllllllllIIIlIIlIllllllllllIIl);
        GL11.glDepthMask(true);
        GL11.glDisable(3042);
        GL11.glEnable(2929);
    }
    
    public static void drawRectWithGlow(final double lllllllllllIIIlIIlIllllllllIIIll, final double lllllllllllIIIlIIlIllllllllIIIlI, final double lllllllllllIIIlIIlIllllllllIlIIl, final double lllllllllllIIIlIIlIllllllllIIIII, final double lllllllllllIIIlIIlIllllllllIIlll, final double lllllllllllIIIlIIlIllllllllIIllI, final Color lllllllllllIIIlIIlIlllllllIlllIl) {
        for (float lllllllllllIIIlIIlIllllllllIIlII = 1.0f; lllllllllllIIIlIIlIllllllllIIlII < lllllllllllIIIlIIlIllllllllIIlll; lllllllllllIIIlIIlIllllllllIIlII += 0.5f) {
            drawRoundedRect99(lllllllllllIIIlIIlIllllllllIIIll - (lllllllllllIIIlIIlIllllllllIIlll - lllllllllllIIIlIIlIllllllllIIlII), lllllllllllIIIlIIlIllllllllIIIlI - (lllllllllllIIIlIIlIllllllllIIlll - lllllllllllIIIlIIlIllllllllIIlII), lllllllllllIIIlIIlIllllllllIlIIl + (lllllllllllIIIlIIlIllllllllIIlll - lllllllllllIIIlIIlIllllllllIIlII), lllllllllllIIIlIIlIllllllllIIIII + (lllllllllllIIIlIIlIllllllllIIlll - lllllllllllIIIlIIlIllllllllIIlII), injectAlpha(lllllllllllIIIlIIlIlllllllIlllIl, (int)Math.round(lllllllllllIIIlIIlIllllllllIIlII * lllllllllllIIIlIIlIllllllllIIllI)).getRGB());
        }
    }
    
    public static int astolfoColors(final int lllllllllllIIIlIIlIlllIIIlllIlIl, final int lllllllllllIIIlIIlIlllIIIlllIlII) {
        float lllllllllllIIIlIIlIlllIIIlllIIlI;
        float lllllllllllIIIlIIlIlllIIIlllIIll;
        for (lllllllllllIIIlIIlIlllIIIlllIIlI = 2900.0f, lllllllllllIIIlIIlIlllIIIlllIIll = System.currentTimeMillis() % (int)lllllllllllIIIlIIlIlllIIIlllIIlI + (float)((lllllllllllIIIlIIlIlllIIIlllIlII - lllllllllllIIIlIIlIlllIIIlllIlIl) * 9); lllllllllllIIIlIIlIlllIIIlllIIll > lllllllllllIIIlIIlIlllIIIlllIIlI; lllllllllllIIIlIIlIlllIIIlllIIll -= lllllllllllIIIlIIlIlllIIIlllIIlI) {}
        if ((lllllllllllIIIlIIlIlllIIIlllIIll /= lllllllllllIIIlIIlIlllIIIlllIIlI) > 0.5) {
            lllllllllllIIIlIIlIlllIIIlllIIll = 0.5f - (lllllllllllIIIlIIlIlllIIIlllIIll - 0.5f);
        }
        return Color.HSBtoRGB(lllllllllllIIIlIIlIlllIIIlllIIll += 0.5f, 0.5f, 1.0f);
    }
    
    public static void drawColorBox(final AxisAlignedBB lllllllllllIIIlIIllIIIIIIlllIIlI, final float lllllllllllIIIlIIllIIIIIIlllIIIl, final float lllllllllllIIIlIIllIIIIIIlllIlll, final float lllllllllllIIIlIIllIIIIIIllIllll, final float lllllllllllIIIlIIllIIIIIIlllIlIl) {
        final Tessellator lllllllllllIIIlIIllIIIIIIlllIlII = Tessellator.getInstance();
        final BufferBuilder lllllllllllIIIlIIllIIIIIIlllIIll = lllllllllllIIIlIIllIIIIIIlllIlII.getBuffer();
        lllllllllllIIIlIIllIIIIIIlllIIll.begin(7, DefaultVertexFormats.POSITION_TEX);
        lllllllllllIIIlIIllIIIIIIlllIIll.pos(lllllllllllIIIlIIllIIIIIIlllIIlI.minX, lllllllllllIIIlIIllIIIIIIlllIIlI.minY, lllllllllllIIIlIIllIIIIIIlllIIlI.minZ).color(lllllllllllIIIlIIllIIIIIIlllIIIl, lllllllllllIIIlIIllIIIIIIlllIlll, lllllllllllIIIlIIllIIIIIIllIllll, lllllllllllIIIlIIllIIIIIIlllIlIl).endVertex();
        lllllllllllIIIlIIllIIIIIIlllIIll.pos(lllllllllllIIIlIIllIIIIIIlllIIlI.minX, lllllllllllIIIlIIllIIIIIIlllIIlI.maxY, lllllllllllIIIlIIllIIIIIIlllIIlI.minZ).color(lllllllllllIIIlIIllIIIIIIlllIIIl, lllllllllllIIIlIIllIIIIIIlllIlll, lllllllllllIIIlIIllIIIIIIllIllll, lllllllllllIIIlIIllIIIIIIlllIlIl).endVertex();
        lllllllllllIIIlIIllIIIIIIlllIIll.pos(lllllllllllIIIlIIllIIIIIIlllIIlI.maxX, lllllllllllIIIlIIllIIIIIIlllIIlI.minY, lllllllllllIIIlIIllIIIIIIlllIIlI.minZ).color(lllllllllllIIIlIIllIIIIIIlllIIIl, lllllllllllIIIlIIllIIIIIIlllIlll, lllllllllllIIIlIIllIIIIIIllIllll, lllllllllllIIIlIIllIIIIIIlllIlIl).endVertex();
        lllllllllllIIIlIIllIIIIIIlllIIll.pos(lllllllllllIIIlIIllIIIIIIlllIIlI.maxX, lllllllllllIIIlIIllIIIIIIlllIIlI.maxY, lllllllllllIIIlIIllIIIIIIlllIIlI.minZ).color(lllllllllllIIIlIIllIIIIIIlllIIIl, lllllllllllIIIlIIllIIIIIIlllIlll, lllllllllllIIIlIIllIIIIIIllIllll, lllllllllllIIIlIIllIIIIIIlllIlIl).endVertex();
        lllllllllllIIIlIIllIIIIIIlllIIll.pos(lllllllllllIIIlIIllIIIIIIlllIIlI.maxX, lllllllllllIIIlIIllIIIIIIlllIIlI.minY, lllllllllllIIIlIIllIIIIIIlllIIlI.maxZ).color(lllllllllllIIIlIIllIIIIIIlllIIIl, lllllllllllIIIlIIllIIIIIIlllIlll, lllllllllllIIIlIIllIIIIIIllIllll, lllllllllllIIIlIIllIIIIIIlllIlIl).endVertex();
        lllllllllllIIIlIIllIIIIIIlllIIll.pos(lllllllllllIIIlIIllIIIIIIlllIIlI.maxX, lllllllllllIIIlIIllIIIIIIlllIIlI.maxY, lllllllllllIIIlIIllIIIIIIlllIIlI.maxZ).color(lllllllllllIIIlIIllIIIIIIlllIIIl, lllllllllllIIIlIIllIIIIIIlllIlll, lllllllllllIIIlIIllIIIIIIllIllll, lllllllllllIIIlIIllIIIIIIlllIlIl).endVertex();
        lllllllllllIIIlIIllIIIIIIlllIIll.pos(lllllllllllIIIlIIllIIIIIIlllIIlI.minX, lllllllllllIIIlIIllIIIIIIlllIIlI.minY, lllllllllllIIIlIIllIIIIIIlllIIlI.maxZ).color(lllllllllllIIIlIIllIIIIIIlllIIIl, lllllllllllIIIlIIllIIIIIIlllIlll, lllllllllllIIIlIIllIIIIIIllIllll, lllllllllllIIIlIIllIIIIIIlllIlIl).endVertex();
        lllllllllllIIIlIIllIIIIIIlllIIll.pos(lllllllllllIIIlIIllIIIIIIlllIIlI.minX, lllllllllllIIIlIIllIIIIIIlllIIlI.maxY, lllllllllllIIIlIIllIIIIIIlllIIlI.maxZ).color(lllllllllllIIIlIIllIIIIIIlllIIIl, lllllllllllIIIlIIllIIIIIIlllIlll, lllllllllllIIIlIIllIIIIIIllIllll, lllllllllllIIIlIIllIIIIIIlllIlIl).endVertex();
        lllllllllllIIIlIIllIIIIIIlllIlII.draw();
        lllllllllllIIIlIIllIIIIIIlllIIll.begin(7, DefaultVertexFormats.POSITION_TEX);
        lllllllllllIIIlIIllIIIIIIlllIIll.pos(lllllllllllIIIlIIllIIIIIIlllIIlI.maxX, lllllllllllIIIlIIllIIIIIIlllIIlI.maxY, lllllllllllIIIlIIllIIIIIIlllIIlI.minZ).color(lllllllllllIIIlIIllIIIIIIlllIIIl, lllllllllllIIIlIIllIIIIIIlllIlll, lllllllllllIIIlIIllIIIIIIllIllll, lllllllllllIIIlIIllIIIIIIlllIlIl).endVertex();
        lllllllllllIIIlIIllIIIIIIlllIIll.pos(lllllllllllIIIlIIllIIIIIIlllIIlI.maxX, lllllllllllIIIlIIllIIIIIIlllIIlI.minY, lllllllllllIIIlIIllIIIIIIlllIIlI.minZ).color(lllllllllllIIIlIIllIIIIIIlllIIIl, lllllllllllIIIlIIllIIIIIIlllIlll, lllllllllllIIIlIIllIIIIIIllIllll, lllllllllllIIIlIIllIIIIIIlllIlIl).endVertex();
        lllllllllllIIIlIIllIIIIIIlllIIll.pos(lllllllllllIIIlIIllIIIIIIlllIIlI.minX, lllllllllllIIIlIIllIIIIIIlllIIlI.maxY, lllllllllllIIIlIIllIIIIIIlllIIlI.minZ).color(lllllllllllIIIlIIllIIIIIIlllIIIl, lllllllllllIIIlIIllIIIIIIlllIlll, lllllllllllIIIlIIllIIIIIIllIllll, lllllllllllIIIlIIllIIIIIIlllIlIl).endVertex();
        lllllllllllIIIlIIllIIIIIIlllIIll.pos(lllllllllllIIIlIIllIIIIIIlllIIlI.minX, lllllllllllIIIlIIllIIIIIIlllIIlI.minY, lllllllllllIIIlIIllIIIIIIlllIIlI.minZ).color(lllllllllllIIIlIIllIIIIIIlllIIIl, lllllllllllIIIlIIllIIIIIIlllIlll, lllllllllllIIIlIIllIIIIIIllIllll, lllllllllllIIIlIIllIIIIIIlllIlIl).endVertex();
        lllllllllllIIIlIIllIIIIIIlllIIll.pos(lllllllllllIIIlIIllIIIIIIlllIIlI.minX, lllllllllllIIIlIIllIIIIIIlllIIlI.maxY, lllllllllllIIIlIIllIIIIIIlllIIlI.maxZ).color(lllllllllllIIIlIIllIIIIIIlllIIIl, lllllllllllIIIlIIllIIIIIIlllIlll, lllllllllllIIIlIIllIIIIIIllIllll, lllllllllllIIIlIIllIIIIIIlllIlIl).endVertex();
        lllllllllllIIIlIIllIIIIIIlllIIll.pos(lllllllllllIIIlIIllIIIIIIlllIIlI.minX, lllllllllllIIIlIIllIIIIIIlllIIlI.minY, lllllllllllIIIlIIllIIIIIIlllIIlI.maxZ).color(lllllllllllIIIlIIllIIIIIIlllIIIl, lllllllllllIIIlIIllIIIIIIlllIlll, lllllllllllIIIlIIllIIIIIIllIllll, lllllllllllIIIlIIllIIIIIIlllIlIl).endVertex();
        lllllllllllIIIlIIllIIIIIIlllIIll.pos(lllllllllllIIIlIIllIIIIIIlllIIlI.maxX, lllllllllllIIIlIIllIIIIIIlllIIlI.maxY, lllllllllllIIIlIIllIIIIIIlllIIlI.maxZ).color(lllllllllllIIIlIIllIIIIIIlllIIIl, lllllllllllIIIlIIllIIIIIIlllIlll, lllllllllllIIIlIIllIIIIIIllIllll, lllllllllllIIIlIIllIIIIIIlllIlIl).endVertex();
        lllllllllllIIIlIIllIIIIIIlllIIll.pos(lllllllllllIIIlIIllIIIIIIlllIIlI.maxX, lllllllllllIIIlIIllIIIIIIlllIIlI.minY, lllllllllllIIIlIIllIIIIIIlllIIlI.maxZ).color(lllllllllllIIIlIIllIIIIIIlllIIIl, lllllllllllIIIlIIllIIIIIIlllIlll, lllllllllllIIIlIIllIIIIIIllIllll, lllllllllllIIIlIIllIIIIIIlllIlIl).endVertex();
        lllllllllllIIIlIIllIIIIIIlllIlII.draw();
        lllllllllllIIIlIIllIIIIIIlllIIll.begin(7, DefaultVertexFormats.POSITION_TEX);
        lllllllllllIIIlIIllIIIIIIlllIIll.pos(lllllllllllIIIlIIllIIIIIIlllIIlI.minX, lllllllllllIIIlIIllIIIIIIlllIIlI.maxY, lllllllllllIIIlIIllIIIIIIlllIIlI.minZ).color(lllllllllllIIIlIIllIIIIIIlllIIIl, lllllllllllIIIlIIllIIIIIIlllIlll, lllllllllllIIIlIIllIIIIIIllIllll, lllllllllllIIIlIIllIIIIIIlllIlIl).endVertex();
        lllllllllllIIIlIIllIIIIIIlllIIll.pos(lllllllllllIIIlIIllIIIIIIlllIIlI.maxX, lllllllllllIIIlIIllIIIIIIlllIIlI.maxY, lllllllllllIIIlIIllIIIIIIlllIIlI.minZ).color(lllllllllllIIIlIIllIIIIIIlllIIIl, lllllllllllIIIlIIllIIIIIIlllIlll, lllllllllllIIIlIIllIIIIIIllIllll, lllllllllllIIIlIIllIIIIIIlllIlIl).endVertex();
        lllllllllllIIIlIIllIIIIIIlllIIll.pos(lllllllllllIIIlIIllIIIIIIlllIIlI.maxX, lllllllllllIIIlIIllIIIIIIlllIIlI.maxY, lllllllllllIIIlIIllIIIIIIlllIIlI.maxZ).color(lllllllllllIIIlIIllIIIIIIlllIIIl, lllllllllllIIIlIIllIIIIIIlllIlll, lllllllllllIIIlIIllIIIIIIllIllll, lllllllllllIIIlIIllIIIIIIlllIlIl).endVertex();
        lllllllllllIIIlIIllIIIIIIlllIIll.pos(lllllllllllIIIlIIllIIIIIIlllIIlI.minX, lllllllllllIIIlIIllIIIIIIlllIIlI.maxY, lllllllllllIIIlIIllIIIIIIlllIIlI.maxZ).color(lllllllllllIIIlIIllIIIIIIlllIIIl, lllllllllllIIIlIIllIIIIIIlllIlll, lllllllllllIIIlIIllIIIIIIllIllll, lllllllllllIIIlIIllIIIIIIlllIlIl).endVertex();
        lllllllllllIIIlIIllIIIIIIlllIIll.pos(lllllllllllIIIlIIllIIIIIIlllIIlI.minX, lllllllllllIIIlIIllIIIIIIlllIIlI.maxY, lllllllllllIIIlIIllIIIIIIlllIIlI.minZ).color(lllllllllllIIIlIIllIIIIIIlllIIIl, lllllllllllIIIlIIllIIIIIIlllIlll, lllllllllllIIIlIIllIIIIIIllIllll, lllllllllllIIIlIIllIIIIIIlllIlIl).endVertex();
        lllllllllllIIIlIIllIIIIIIlllIIll.pos(lllllllllllIIIlIIllIIIIIIlllIIlI.minX, lllllllllllIIIlIIllIIIIIIlllIIlI.maxY, lllllllllllIIIlIIllIIIIIIlllIIlI.maxZ).color(lllllllllllIIIlIIllIIIIIIlllIIIl, lllllllllllIIIlIIllIIIIIIlllIlll, lllllllllllIIIlIIllIIIIIIllIllll, lllllllllllIIIlIIllIIIIIIlllIlIl).endVertex();
        lllllllllllIIIlIIllIIIIIIlllIIll.pos(lllllllllllIIIlIIllIIIIIIlllIIlI.maxX, lllllllllllIIIlIIllIIIIIIlllIIlI.maxY, lllllllllllIIIlIIllIIIIIIlllIIlI.maxZ).color(lllllllllllIIIlIIllIIIIIIlllIIIl, lllllllllllIIIlIIllIIIIIIlllIlll, lllllllllllIIIlIIllIIIIIIllIllll, lllllllllllIIIlIIllIIIIIIlllIlIl).endVertex();
        lllllllllllIIIlIIllIIIIIIlllIIll.pos(lllllllllllIIIlIIllIIIIIIlllIIlI.maxX, lllllllllllIIIlIIllIIIIIIlllIIlI.maxY, lllllllllllIIIlIIllIIIIIIlllIIlI.minZ).color(lllllllllllIIIlIIllIIIIIIlllIIIl, lllllllllllIIIlIIllIIIIIIlllIlll, lllllllllllIIIlIIllIIIIIIllIllll, lllllllllllIIIlIIllIIIIIIlllIlIl).endVertex();
        lllllllllllIIIlIIllIIIIIIlllIlII.draw();
        lllllllllllIIIlIIllIIIIIIlllIIll.begin(7, DefaultVertexFormats.POSITION_TEX);
        lllllllllllIIIlIIllIIIIIIlllIIll.pos(lllllllllllIIIlIIllIIIIIIlllIIlI.minX, lllllllllllIIIlIIllIIIIIIlllIIlI.minY, lllllllllllIIIlIIllIIIIIIlllIIlI.minZ).color(lllllllllllIIIlIIllIIIIIIlllIIIl, lllllllllllIIIlIIllIIIIIIlllIlll, lllllllllllIIIlIIllIIIIIIllIllll, lllllllllllIIIlIIllIIIIIIlllIlIl).endVertex();
        lllllllllllIIIlIIllIIIIIIlllIIll.pos(lllllllllllIIIlIIllIIIIIIlllIIlI.maxX, lllllllllllIIIlIIllIIIIIIlllIIlI.minY, lllllllllllIIIlIIllIIIIIIlllIIlI.minZ).color(lllllllllllIIIlIIllIIIIIIlllIIIl, lllllllllllIIIlIIllIIIIIIlllIlll, lllllllllllIIIlIIllIIIIIIllIllll, lllllllllllIIIlIIllIIIIIIlllIlIl).endVertex();
        lllllllllllIIIlIIllIIIIIIlllIIll.pos(lllllllllllIIIlIIllIIIIIIlllIIlI.maxX, lllllllllllIIIlIIllIIIIIIlllIIlI.minY, lllllllllllIIIlIIllIIIIIIlllIIlI.maxZ).color(lllllllllllIIIlIIllIIIIIIlllIIIl, lllllllllllIIIlIIllIIIIIIlllIlll, lllllllllllIIIlIIllIIIIIIllIllll, lllllllllllIIIlIIllIIIIIIlllIlIl).endVertex();
        lllllllllllIIIlIIllIIIIIIlllIIll.pos(lllllllllllIIIlIIllIIIIIIlllIIlI.minX, lllllllllllIIIlIIllIIIIIIlllIIlI.minY, lllllllllllIIIlIIllIIIIIIlllIIlI.maxZ).color(lllllllllllIIIlIIllIIIIIIlllIIIl, lllllllllllIIIlIIllIIIIIIlllIlll, lllllllllllIIIlIIllIIIIIIllIllll, lllllllllllIIIlIIllIIIIIIlllIlIl).endVertex();
        lllllllllllIIIlIIllIIIIIIlllIIll.pos(lllllllllllIIIlIIllIIIIIIlllIIlI.minX, lllllllllllIIIlIIllIIIIIIlllIIlI.minY, lllllllllllIIIlIIllIIIIIIlllIIlI.minZ).color(lllllllllllIIIlIIllIIIIIIlllIIIl, lllllllllllIIIlIIllIIIIIIlllIlll, lllllllllllIIIlIIllIIIIIIllIllll, lllllllllllIIIlIIllIIIIIIlllIlIl).endVertex();
        lllllllllllIIIlIIllIIIIIIlllIIll.pos(lllllllllllIIIlIIllIIIIIIlllIIlI.minX, lllllllllllIIIlIIllIIIIIIlllIIlI.minY, lllllllllllIIIlIIllIIIIIIlllIIlI.maxZ).color(lllllllllllIIIlIIllIIIIIIlllIIIl, lllllllllllIIIlIIllIIIIIIlllIlll, lllllllllllIIIlIIllIIIIIIllIllll, lllllllllllIIIlIIllIIIIIIlllIlIl).endVertex();
        lllllllllllIIIlIIllIIIIIIlllIIll.pos(lllllllllllIIIlIIllIIIIIIlllIIlI.maxX, lllllllllllIIIlIIllIIIIIIlllIIlI.minY, lllllllllllIIIlIIllIIIIIIlllIIlI.maxZ).color(lllllllllllIIIlIIllIIIIIIlllIIIl, lllllllllllIIIlIIllIIIIIIlllIlll, lllllllllllIIIlIIllIIIIIIllIllll, lllllllllllIIIlIIllIIIIIIlllIlIl).endVertex();
        lllllllllllIIIlIIllIIIIIIlllIIll.pos(lllllllllllIIIlIIllIIIIIIlllIIlI.maxX, lllllllllllIIIlIIllIIIIIIlllIIlI.minY, lllllllllllIIIlIIllIIIIIIlllIIlI.minZ).color(lllllllllllIIIlIIllIIIIIIlllIIIl, lllllllllllIIIlIIllIIIIIIlllIlll, lllllllllllIIIlIIllIIIIIIllIllll, lllllllllllIIIlIIllIIIIIIlllIlIl).endVertex();
        lllllllllllIIIlIIllIIIIIIlllIlII.draw();
        lllllllllllIIIlIIllIIIIIIlllIIll.begin(7, DefaultVertexFormats.POSITION_TEX);
        lllllllllllIIIlIIllIIIIIIlllIIll.pos(lllllllllllIIIlIIllIIIIIIlllIIlI.minX, lllllllllllIIIlIIllIIIIIIlllIIlI.minY, lllllllllllIIIlIIllIIIIIIlllIIlI.minZ).color(lllllllllllIIIlIIllIIIIIIlllIIIl, lllllllllllIIIlIIllIIIIIIlllIlll, lllllllllllIIIlIIllIIIIIIllIllll, lllllllllllIIIlIIllIIIIIIlllIlIl).endVertex();
        lllllllllllIIIlIIllIIIIIIlllIIll.pos(lllllllllllIIIlIIllIIIIIIlllIIlI.minX, lllllllllllIIIlIIllIIIIIIlllIIlI.maxY, lllllllllllIIIlIIllIIIIIIlllIIlI.minZ).color(lllllllllllIIIlIIllIIIIIIlllIIIl, lllllllllllIIIlIIllIIIIIIlllIlll, lllllllllllIIIlIIllIIIIIIllIllll, lllllllllllIIIlIIllIIIIIIlllIlIl).endVertex();
        lllllllllllIIIlIIllIIIIIIlllIIll.pos(lllllllllllIIIlIIllIIIIIIlllIIlI.minX, lllllllllllIIIlIIllIIIIIIlllIIlI.minY, lllllllllllIIIlIIllIIIIIIlllIIlI.maxZ).color(lllllllllllIIIlIIllIIIIIIlllIIIl, lllllllllllIIIlIIllIIIIIIlllIlll, lllllllllllIIIlIIllIIIIIIllIllll, lllllllllllIIIlIIllIIIIIIlllIlIl).endVertex();
        lllllllllllIIIlIIllIIIIIIlllIIll.pos(lllllllllllIIIlIIllIIIIIIlllIIlI.minX, lllllllllllIIIlIIllIIIIIIlllIIlI.maxY, lllllllllllIIIlIIllIIIIIIlllIIlI.maxZ).color(lllllllllllIIIlIIllIIIIIIlllIIIl, lllllllllllIIIlIIllIIIIIIlllIlll, lllllllllllIIIlIIllIIIIIIllIllll, lllllllllllIIIlIIllIIIIIIlllIlIl).endVertex();
        lllllllllllIIIlIIllIIIIIIlllIIll.pos(lllllllllllIIIlIIllIIIIIIlllIIlI.maxX, lllllllllllIIIlIIllIIIIIIlllIIlI.minY, lllllllllllIIIlIIllIIIIIIlllIIlI.maxZ).color(lllllllllllIIIlIIllIIIIIIlllIIIl, lllllllllllIIIlIIllIIIIIIlllIlll, lllllllllllIIIlIIllIIIIIIllIllll, lllllllllllIIIlIIllIIIIIIlllIlIl).endVertex();
        lllllllllllIIIlIIllIIIIIIlllIIll.pos(lllllllllllIIIlIIllIIIIIIlllIIlI.maxX, lllllllllllIIIlIIllIIIIIIlllIIlI.maxY, lllllllllllIIIlIIllIIIIIIlllIIlI.maxZ).color(lllllllllllIIIlIIllIIIIIIlllIIIl, lllllllllllIIIlIIllIIIIIIlllIlll, lllllllllllIIIlIIllIIIIIIllIllll, lllllllllllIIIlIIllIIIIIIlllIlIl).endVertex();
        lllllllllllIIIlIIllIIIIIIlllIIll.pos(lllllllllllIIIlIIllIIIIIIlllIIlI.maxX, lllllllllllIIIlIIllIIIIIIlllIIlI.minY, lllllllllllIIIlIIllIIIIIIlllIIlI.minZ).color(lllllllllllIIIlIIllIIIIIIlllIIIl, lllllllllllIIIlIIllIIIIIIlllIlll, lllllllllllIIIlIIllIIIIIIllIllll, lllllllllllIIIlIIllIIIIIIlllIlIl).endVertex();
        lllllllllllIIIlIIllIIIIIIlllIIll.pos(lllllllllllIIIlIIllIIIIIIlllIIlI.maxX, lllllllllllIIIlIIllIIIIIIlllIIlI.maxY, lllllllllllIIIlIIllIIIIIIlllIIlI.minZ).color(lllllllllllIIIlIIllIIIIIIlllIIIl, lllllllllllIIIlIIllIIIIIIlllIlll, lllllllllllIIIlIIllIIIIIIllIllll, lllllllllllIIIlIIllIIIIIIlllIlIl).endVertex();
        lllllllllllIIIlIIllIIIIIIlllIlII.draw();
        lllllllllllIIIlIIllIIIIIIlllIIll.begin(7, DefaultVertexFormats.POSITION_TEX);
        lllllllllllIIIlIIllIIIIIIlllIIll.pos(lllllllllllIIIlIIllIIIIIIlllIIlI.minX, lllllllllllIIIlIIllIIIIIIlllIIlI.maxY, lllllllllllIIIlIIllIIIIIIlllIIlI.maxZ).color(lllllllllllIIIlIIllIIIIIIlllIIIl, lllllllllllIIIlIIllIIIIIIlllIlll, lllllllllllIIIlIIllIIIIIIllIllll, lllllllllllIIIlIIllIIIIIIlllIlIl).endVertex();
        lllllllllllIIIlIIllIIIIIIlllIIll.pos(lllllllllllIIIlIIllIIIIIIlllIIlI.minX, lllllllllllIIIlIIllIIIIIIlllIIlI.minY, lllllllllllIIIlIIllIIIIIIlllIIlI.maxZ).color(lllllllllllIIIlIIllIIIIIIlllIIIl, lllllllllllIIIlIIllIIIIIIlllIlll, lllllllllllIIIlIIllIIIIIIllIllll, lllllllllllIIIlIIllIIIIIIlllIlIl).endVertex();
        lllllllllllIIIlIIllIIIIIIlllIIll.pos(lllllllllllIIIlIIllIIIIIIlllIIlI.minX, lllllllllllIIIlIIllIIIIIIlllIIlI.maxY, lllllllllllIIIlIIllIIIIIIlllIIlI.minZ).color(lllllllllllIIIlIIllIIIIIIlllIIIl, lllllllllllIIIlIIllIIIIIIlllIlll, lllllllllllIIIlIIllIIIIIIllIllll, lllllllllllIIIlIIllIIIIIIlllIlIl).endVertex();
        lllllllllllIIIlIIllIIIIIIlllIIll.pos(lllllllllllIIIlIIllIIIIIIlllIIlI.minX, lllllllllllIIIlIIllIIIIIIlllIIlI.minY, lllllllllllIIIlIIllIIIIIIlllIIlI.minZ).color(lllllllllllIIIlIIllIIIIIIlllIIIl, lllllllllllIIIlIIllIIIIIIlllIlll, lllllllllllIIIlIIllIIIIIIllIllll, lllllllllllIIIlIIllIIIIIIlllIlIl).endVertex();
        lllllllllllIIIlIIllIIIIIIlllIIll.pos(lllllllllllIIIlIIllIIIIIIlllIIlI.maxX, lllllllllllIIIlIIllIIIIIIlllIIlI.maxY, lllllllllllIIIlIIllIIIIIIlllIIlI.minZ).color(lllllllllllIIIlIIllIIIIIIlllIIIl, lllllllllllIIIlIIllIIIIIIlllIlll, lllllllllllIIIlIIllIIIIIIllIllll, lllllllllllIIIlIIllIIIIIIlllIlIl).endVertex();
        lllllllllllIIIlIIllIIIIIIlllIIll.pos(lllllllllllIIIlIIllIIIIIIlllIIlI.maxX, lllllllllllIIIlIIllIIIIIIlllIIlI.minY, lllllllllllIIIlIIllIIIIIIlllIIlI.minZ).color(lllllllllllIIIlIIllIIIIIIlllIIIl, lllllllllllIIIlIIllIIIIIIlllIlll, lllllllllllIIIlIIllIIIIIIllIllll, lllllllllllIIIlIIllIIIIIIlllIlIl).endVertex();
        lllllllllllIIIlIIllIIIIIIlllIIll.pos(lllllllllllIIIlIIllIIIIIIlllIIlI.maxX, lllllllllllIIIlIIllIIIIIIlllIIlI.maxY, lllllllllllIIIlIIllIIIIIIlllIIlI.maxZ).color(lllllllllllIIIlIIllIIIIIIlllIIIl, lllllllllllIIIlIIllIIIIIIlllIlll, lllllllllllIIIlIIllIIIIIIllIllll, lllllllllllIIIlIIllIIIIIIlllIlIl).endVertex();
        lllllllllllIIIlIIllIIIIIIlllIIll.pos(lllllllllllIIIlIIllIIIIIIlllIIlI.maxX, lllllllllllIIIlIIllIIIIIIlllIIlI.minY, lllllllllllIIIlIIllIIIIIIlllIIlI.maxZ).color(lllllllllllIIIlIIllIIIIIIlllIIIl, lllllllllllIIIlIIllIIIIIIlllIlll, lllllllllllIIIlIIllIIIIIIllIllll, lllllllllllIIIlIIllIIIIIIlllIlIl).endVertex();
        lllllllllllIIIlIIllIIIIIIlllIlII.draw();
    }
    
    public static void scissorRect(final float lllllllllllIIIlIIllIIIllIIIlIlII, final float lllllllllllIIIlIIllIIIllIIIIllIl, final float lllllllllllIIIlIIllIIIllIIIlIIlI, final double lllllllllllIIIlIIllIIIllIIIlIIIl) {
        final ScaledResolution lllllllllllIIIlIIllIIIllIIIlIIII = new ScaledResolution(DrawHelper.mc);
        final int lllllllllllIIIlIIllIIIllIIIIllll = ScaledResolution.getScaleFactor();
        GL11.glScissor((int)(lllllllllllIIIlIIllIIIllIIIlIlII * lllllllllllIIIlIIllIIIllIIIIllll), (int)(((float)lllllllllllIIIlIIllIIIllIIIlIIII.getScaledHeight() - lllllllllllIIIlIIllIIIllIIIlIIIl) * (float)lllllllllllIIIlIIllIIIllIIIIllll), (int)((lllllllllllIIIlIIllIIIllIIIlIIlI - lllllllllllIIIlIIllIIIllIIIlIlII) * lllllllllllIIIlIIllIIIllIIIIllll), (int)((lllllllllllIIIlIIllIIIllIIIlIIIl - lllllllllllIIIlIIllIIIllIIIIllIl) * (float)lllllllllllIIIlIIllIIIllIIIIllll));
    }
    
    public static void blockEspFrame(final BlockPos lllllllllllIIIlIIlIllIllllIlIIII, final float lllllllllllIIIlIIlIllIllllIIlIII, final float lllllllllllIIIlIIlIllIllllIIlllI, final float lllllllllllIIIlIIlIllIllllIIllIl) {
        final double n = lllllllllllIIIlIIlIllIllllIlIIII.getX();
        DrawHelper.mc.getRenderManager();
        final double lllllllllllIIIlIIlIllIllllIIllII = n - RenderManager.renderPosX;
        final double n2 = lllllllllllIIIlIIlIllIllllIlIIII.getY();
        DrawHelper.mc.getRenderManager();
        final double lllllllllllIIIlIIlIllIllllIIlIll = n2 - RenderManager.renderPosY;
        final double n3 = lllllllllllIIIlIIlIllIllllIlIIII.getZ();
        DrawHelper.mc.getRenderManager();
        final double lllllllllllIIIlIIlIllIllllIIlIlI = n3 - RenderManager.renderPosZ;
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(3042);
        GL11.glLineWidth(2.0f);
        GL11.glDisable(3553);
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GlStateManager.color(lllllllllllIIIlIIlIllIllllIIlIII, lllllllllllIIIlIIlIllIllllIIlllI, lllllllllllIIIlIIlIllIllllIIllIl, 1.0f);
        drawSelectionBoundingBox(new AxisAlignedBB(lllllllllllIIIlIIlIllIllllIIllII, lllllllllllIIIlIIlIllIllllIIlIll, lllllllllllIIIlIIlIllIllllIIlIlI, lllllllllllIIIlIIlIllIllllIIllII + 1.0, lllllllllllIIIlIIlIllIllllIIlIll + 1.0, lllllllllllIIIlIIlIllIllllIIlIlI + 1.0));
        GL11.glEnable(3553);
        GL11.glEnable(2929);
        GL11.glDepthMask(true);
        GL11.glDisable(3042);
    }
    
    public static Color getHealthColor(final EntityLivingBase lllllllllllIIIlIIlIlllIllIIIlIlI) {
        final float lllllllllllIIIlIIlIlllIllIIIlllI = lllllllllllIIIlIIlIlllIllIIIlIlI.getHealth();
        final float[] lllllllllllIIIlIIlIlllIllIIIllIl = { 0.0f, 0.15f, 0.55f, 0.7f, 0.9f };
        final Color[] lllllllllllIIIlIIlIlllIllIIIllII = { new Color(133, 0, 0), Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN };
        final float lllllllllllIIIlIIlIlllIllIIIlIll = lllllllllllIIIlIIlIlllIllIIIlllI / lllllllllllIIIlIIlIlllIllIIIlIlI.getMaxHealth();
        return (lllllllllllIIIlIIlIlllIllIIIlllI >= 0.0f) ? blendColors(lllllllllllIIIlIIlIlllIllIIIllIl, lllllllllllIIIlIIlIlllIllIIIllII, lllllllllllIIIlIIlIlllIllIIIlIll).brighter() : lllllllllllIIIlIIlIlllIllIIIllII[0];
    }
    
    public static void glColor(final Color lllllllllllIIIlIIllIIIIIllIlIlIl, final float lllllllllllIIIlIIllIIIIIllIIllll) {
        final float lllllllllllIIIlIIllIIIIIllIlIIll = lllllllllllIIIlIIllIIIIIllIlIlIl.getRed() / 255.0f;
        final float lllllllllllIIIlIIllIIIIIllIlIIlI = lllllllllllIIIlIIllIIIIIllIlIlIl.getGreen() / 255.0f;
        final float lllllllllllIIIlIIllIIIIIllIlIIIl = lllllllllllIIIlIIllIIIIIllIlIlIl.getBlue() / 255.0f;
        GlStateManager.color(lllllllllllIIIlIIllIIIIIllIlIIll, lllllllllllIIIlIIllIIIIIllIlIIlI, lllllllllllIIIlIIllIIIIIllIlIIIl, lllllllllllIIIlIIllIIIIIllIIllll);
    }
    
    public static void scissorRect1(final float lllllllllllIIIlIIllIIIIlllllllll, final float lllllllllllIIIlIIllIIIIllllllllI, final float lllllllllllIIIlIIllIIIIlllllllIl, final double lllllllllllIIIlIIllIIIlIIIIIIIlI) {
        final ScaledResolution lllllllllllIIIlIIllIIIlIIIIIIIIl = new ScaledResolution(DrawHelper.mc);
        final int lllllllllllIIIlIIllIIIlIIIIIIIII = ScaledResolution.getScaleFactor();
        GL11.glScissor((int)(lllllllllllIIIlIIllIIIIlllllllll * lllllllllllIIIlIIllIIIlIIIIIIIII), (int)(((float)lllllllllllIIIlIIllIIIlIIIIIIIIl.getScaledHeight() - lllllllllllIIIlIIllIIIlIIIIIIIlI) * (float)lllllllllllIIIlIIllIIIlIIIIIIIII), (int)((lllllllllllIIIlIIllIIIIlllllllIl - lllllllllllIIIlIIllIIIIlllllllll) * lllllllllllIIIlIIllIIIlIIIIIIIII), (int)((lllllllllllIIIlIIllIIIlIIIIIIIlI - lllllllllllIIIlIIllIIIIllllllllI) * (float)lllllllllllIIIlIIllIIIlIIIIIIIII));
    }
    
    public static void drawGlow(final double lllllllllllIIIlIIlIlllllllIIIllI, final double lllllllllllIIIlIIlIllllllIllllll, final double lllllllllllIIIlIIlIllllllIlllllI, final double lllllllllllIIIlIIlIllllllIllllIl, final int lllllllllllIIIlIIlIlllllllIIIIlI) {
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.shadeModel(7425);
        drawVGradientRect((float)(int)lllllllllllIIIlIIlIlllllllIIIllI, (float)(int)lllllllllllIIIlIIlIllllllIllllll, (float)(int)lllllllllllIIIlIIlIllllllIlllllI, (float)(int)(lllllllllllIIIlIIlIllllllIllllll + (lllllllllllIIIlIIlIllllllIllllIl - lllllllllllIIIlIIlIllllllIllllll) / 2.0), setAlpha(new Color(lllllllllllIIIlIIlIlllllllIIIIlI), 0).getRGB(), lllllllllllIIIlIIlIlllllllIIIIlI);
        drawVGradientRect((float)(int)lllllllllllIIIlIIlIlllllllIIIllI, (float)(int)(lllllllllllIIIlIIlIllllllIllllll + (lllllllllllIIIlIIlIllllllIllllIl - lllllllllllIIIlIIlIllllllIllllll) / 2.0), (float)(int)lllllllllllIIIlIIlIllllllIlllllI, (float)(int)lllllllllllIIIlIIlIllllllIllllIl, lllllllllllIIIlIIlIlllllllIIIIlI, setAlpha(new Color(lllllllllllIIIlIIlIlllllllIIIIlI), 0).getRGB());
        final int lllllllllllIIIlIIlIlllllllIIIIIl = (int)((lllllllllllIIIlIIlIllllllIllllIl - lllllllllllIIIlIIlIllllllIllllll) / 2.0);
        drawPolygonPart(lllllllllllIIIlIIlIlllllllIIIllI, lllllllllllIIIlIIlIllllllIllllll + (lllllllllllIIIlIIlIllllllIllllIl - lllllllllllIIIlIIlIllllllIllllll) / 2.0, lllllllllllIIIlIIlIlllllllIIIIIl, 0, lllllllllllIIIlIIlIlllllllIIIIlI, setAlpha(new Color(lllllllllllIIIlIIlIlllllllIIIIlI), 0).getRGB());
        drawPolygonPart(lllllllllllIIIlIIlIlllllllIIIllI, lllllllllllIIIlIIlIllllllIllllll + (lllllllllllIIIlIIlIllllllIllllIl - lllllllllllIIIlIIlIllllllIllllll) / 2.0, lllllllllllIIIlIIlIlllllllIIIIIl, 1, lllllllllllIIIlIIlIlllllllIIIIlI, setAlpha(new Color(lllllllllllIIIlIIlIlllllllIIIIlI), 0).getRGB());
        drawPolygonPart(lllllllllllIIIlIIlIllllllIlllllI, lllllllllllIIIlIIlIllllllIllllll + (lllllllllllIIIlIIlIllllllIllllIl - lllllllllllIIIlIIlIllllllIllllll) / 2.0, lllllllllllIIIlIIlIlllllllIIIIIl, 2, lllllllllllIIIlIIlIlllllllIIIIlI, setAlpha(new Color(lllllllllllIIIlIIlIlllllllIIIIlI), 0).getRGB());
        drawPolygonPart(lllllllllllIIIlIIlIllllllIlllllI, lllllllllllIIIlIIlIllllllIllllll + (lllllllllllIIIlIIlIllllllIllllIl - lllllllllllIIIlIIlIllllllIllllll) / 2.0, lllllllllllIIIlIIlIlllllllIIIIIl, 3, lllllllllllIIIlIIlIlllllllIIIIlI, setAlpha(new Color(lllllllllllIIIlIIlIlllllllIIIIlI), 0).getRGB());
        GlStateManager.shadeModel(7424);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
    }
    
    public static float lerp(final float lllllllllllIIIlIIlIllIllllIllIlI, final float lllllllllllIIIlIIlIllIllllIlllII, final float lllllllllllIIIlIIlIllIllllIllIll) {
        return lllllllllllIIIlIIlIllIllllIllIlI + lllllllllllIIIlIIlIllIllllIllIll * (lllllllllllIIIlIIlIllIllllIlllII - lllllllllllIIIlIIlIllIllllIllIlI);
    }
    
    public static void drawRectWithEdge(final double lllllllllllIIIlIIllIIIIIllllIllI, final double lllllllllllIIIlIIllIIIIIllllIlIl, final double lllllllllllIIIlIIllIIIIIlllllIll, final double lllllllllllIIIlIIllIIIIIllllIIll, final Color lllllllllllIIIlIIllIIIIIllllIIlI, final Color lllllllllllIIIlIIllIIIIIlllllIII) {
        drawRect(lllllllllllIIIlIIllIIIIIllllIllI, lllllllllllIIIlIIllIIIIIllllIlIl, lllllllllllIIIlIIllIIIIIllllIllI + lllllllllllIIIlIIllIIIIIlllllIll, lllllllllllIIIlIIllIIIIIllllIlIl + lllllllllllIIIlIIllIIIIIllllIIll, lllllllllllIIIlIIllIIIIIllllIIlI.getRGB());
        final int lllllllllllIIIlIIllIIIIIllllIlll = lllllllllllIIIlIIllIIIIIlllllIII.getRGB();
        drawRect(lllllllllllIIIlIIllIIIIIllllIllI - 1.0, lllllllllllIIIlIIllIIIIIllllIlIl, lllllllllllIIIlIIllIIIIIllllIllI, lllllllllllIIIlIIllIIIIIllllIlIl + lllllllllllIIIlIIllIIIIIllllIIll, lllllllllllIIIlIIllIIIIIllllIlll);
        drawRect(lllllllllllIIIlIIllIIIIIllllIllI + lllllllllllIIIlIIllIIIIIlllllIll, lllllllllllIIIlIIllIIIIIllllIlIl, lllllllllllIIIlIIllIIIIIllllIllI + lllllllllllIIIlIIllIIIIIlllllIll + 1.0, lllllllllllIIIlIIllIIIIIllllIlIl + lllllllllllIIIlIIllIIIIIllllIIll, lllllllllllIIIlIIllIIIIIllllIlll);
        drawRect(lllllllllllIIIlIIllIIIIIllllIllI - 1.0, lllllllllllIIIlIIllIIIIIllllIlIl - 1.0, lllllllllllIIIlIIllIIIIIllllIllI + lllllllllllIIIlIIllIIIIIlllllIll + 1.0, lllllllllllIIIlIIllIIIIIllllIlIl, lllllllllllIIIlIIllIIIIIllllIlll);
        drawRect(lllllllllllIIIlIIllIIIIIllllIllI - 1.0, lllllllllllIIIlIIllIIIIIllllIlIl + lllllllllllIIIlIIllIIIIIllllIIll, lllllllllllIIIlIIllIIIIIllllIllI + lllllllllllIIIlIIllIIIIIlllllIll + 1.0, lllllllllllIIIlIIllIIIIIllllIlIl + lllllllllllIIIlIIllIIIIIllllIIll + 1.0, lllllllllllIIIlIIllIIIIIllllIlll);
    }
    
    public static Color getHealthColor2(final float lllllllllllIIIlIIlIlllIlIllllIll, final float lllllllllllIIIlIIlIlllIlIlllllll) {
        final float[] lllllllllllIIIlIIlIlllIlIllllllI = { 0.0f, 0.5f, 1.0f };
        final Color[] lllllllllllIIIlIIlIlllIlIlllllIl = { new Color(108, 0, 0), new Color(255, 51, 0), Color.GREEN };
        final float lllllllllllIIIlIIlIlllIlIlllllII = lllllllllllIIIlIIlIlllIlIllllIll / lllllllllllIIIlIIlIlllIlIlllllll;
        return blendColors(lllllllllllIIIlIIlIlllIlIllllllI, lllllllllllIIIlIIlIlllIlIlllllIl, lllllllllllIIIlIIlIlllIlIlllllII).brighter();
    }
    
    public static Color injectAlpha(final Color lllllllllllIIIlIIllIIIlIIlIIIlIl, final int lllllllllllIIIlIIllIIIlIIlIIIIlI) {
        return new Color(lllllllllllIIIlIIllIIIlIIlIIIlIl.getRed(), lllllllllllIIIlIIllIIIlIIlIIIlIl.getGreen(), lllllllllllIIIlIIllIIIlIIlIIIlIl.getBlue(), lllllllllllIIIlIIllIIIlIIlIIIIlI);
    }
    
    public static int[] getFractionIndicies(final float[] lllllllllllIIIlIIlIlllIIllIIIIlI, final float lllllllllllIIIlIIlIlllIIlIllllIl) {
        final int[] lllllllllllIIIlIIlIlllIIlIllllll = new int[2];
        int lllllllllllIIIlIIlIlllIIllIIIIII;
        for (lllllllllllIIIlIIlIlllIIllIIIIII = 0; lllllllllllIIIlIIlIlllIIllIIIIII < lllllllllllIIIlIIlIlllIIllIIIIlI.length && lllllllllllIIIlIIlIlllIIllIIIIlI[lllllllllllIIIlIIlIlllIIllIIIIII] <= lllllllllllIIIlIIlIlllIIlIllllIl; ++lllllllllllIIIlIIlIlllIIllIIIIII) {}
        if (lllllllllllIIIlIIlIlllIIllIIIIII >= lllllllllllIIIlIIlIlllIIllIIIIlI.length) {
            lllllllllllIIIlIIlIlllIIllIIIIII = lllllllllllIIIlIIlIlllIIllIIIIlI.length - 1;
        }
        lllllllllllIIIlIIlIlllIIlIllllll[0] = lllllllllllIIIlIIlIlllIIllIIIIII - 1;
        lllllllllllIIIlIIlIlllIIlIllllll[1] = lllllllllllIIIlIIlIlllIIllIIIIII;
        return lllllllllllIIIlIIlIlllIIlIllllll;
    }
    
    public static int getColor1(final int lllllllllllIIIlIIllIIIIIlIlIlIll) {
        return getColor(lllllllllllIIIlIIllIIIIIlIlIlIll, lllllllllllIIIlIIllIIIIIlIlIlIll, lllllllllllIIIlIIllIIIIIlIlIlIll, 255);
    }
    
    public static void drawSkeetRectWithoutBorder(final float lllllllllllIIIlIIllIIIIlllIIllIl, final float lllllllllllIIIlIIllIIIIlllIlIIII, final float lllllllllllIIIlIIllIIIIlllIIllll, final float lllllllllllIIIlIIllIIIIlllIIlllI) {
        drawSmoothRect1(lllllllllllIIIlIIllIIIIlllIIllIl - 41.0f, lllllllllllIIIlIIllIIIIlllIlIIII - 61.0f, lllllllllllIIIlIIllIIIIlllIIllll + 41.0f, lllllllllllIIIlIIllIIIIlllIIlllI + 61.0f, new Color(48, 48, 48, 255).getRGB());
        drawSmoothRect1(lllllllllllIIIlIIllIIIIlllIIllIl - 40.0f, lllllllllllIIIlIIllIIIIlllIlIIII - 60.0f, lllllllllllIIIlIIllIIIIlllIIllll + 40.0f, lllllllllllIIIlIIllIIIIlllIIlllI + 60.0f, new Color(17, 17, 17, 255).getRGB());
    }
    
    public static boolean isInViewFrustrum(final Entity lllllllllllIIIlIIlIllllIIIlIIIII) {
        return isInViewFrustrum(lllllllllllIIIlIIlIllllIIIlIIIII.getEntityBoundingBox()) || lllllllllllIIIlIIlIllllIIIlIIIII.ignoreFrustumCheck;
    }
    
    public static void staticJelloCircle() {
        if (KillAuraHelper.canAttack(KillAura.target) && KillAura.target.getHealth() > 0.0f && DrawHelper.mc.player.getDistanceToEntity(KillAura.target) <= KillAura.range.getNumberValue() && !KillAura.target.isDead) {
            final double lllllllllllIIIlIIlIlllllIIIIIlll = 0.8 * (1.0 + Math.sin(6.283185307179586 * (DrawHelper.time * 0.3)));
            final double lllllllllllIIIlIIlIlllllIIIIIllI = KillAura.target.width;
            final double lllllllllllIIIlIIlIlllllIIIIIlIl = KillAura.target.lastTickPosX + (KillAura.target.posX - KillAura.target.lastTickPosX) * DrawHelper.mc.timer.renderPartialTicks - DrawHelper.mc.getRenderManager().viewerPosX;
            final double lllllllllllIIIlIIlIlllllIIIIIlII = KillAura.target.lastTickPosY + (KillAura.target.posY - KillAura.target.lastTickPosY) * DrawHelper.mc.timer.renderPartialTicks - DrawHelper.mc.getRenderManager().viewerPosY;
            final double lllllllllllIIIlIIlIlllllIIIIIIll = KillAura.target.lastTickPosZ + (KillAura.target.posZ - KillAura.target.lastTickPosZ) * DrawHelper.mc.timer.renderPartialTicks - DrawHelper.mc.getRenderManager().viewerPosZ;
            GlStateManager.enableBlend();
            GL11.glBlendFunc(770, 771);
            GL11.glEnable(2848);
            GlStateManager.disableDepth();
            GlStateManager.disableTexture2D();
            GlStateManager.disableAlpha();
            GL11.glLineWidth(1.2f);
            GL11.glShadeModel(7425);
            GL11.glDisable(2884);
            GL11.glBegin(5);
            for (int lllllllllllIIIlIIlIlllllIIIIIIlI = 0; lllllllllllIIIlIIlIlllllIIIIIIlI < 361; ++lllllllllllIIIlIIlIlllllIIIIIIlI) {
                color(setAlpha(astolfoColors45((float)(lllllllllllIIIlIIlIlllllIIIIIIlI - lllllllllllIIIlIIlIlllllIIIIIIlI + 1), (float)lllllllllllIIIlIIlIlllllIIIIIIlI, 50.0f, 10.0f), (int)(255.0 * (1.3 - lllllllllllIIIlIIlIlllllIIIIIlll))));
                final double lllllllllllIIIlIIlIlllllIIIIIIIl = lllllllllllIIIlIIlIlllllIIIIIlIl + Math.cos(Math.toRadians(lllllllllllIIIlIIlIlllllIIIIIIlI)) * 0.7;
                final double lllllllllllIIIlIIlIlllllIIIIIIII = lllllllllllIIIlIIlIlllllIIIIIIll - Math.sin(Math.toRadians(lllllllllllIIIlIIlIlllllIIIIIIlI)) * 0.7;
                GL11.glVertex3d(lllllllllllIIIlIIlIlllllIIIIIlIl + Math.cos(Math.toRadians(lllllllllllIIIlIIlIlllllIIIIIIlI)) * lllllllllllIIIlIIlIlllllIIIIIllI, lllllllllllIIIlIIlIlllllIIIIIlII + 0.05, lllllllllllIIIlIIlIlllllIIIIIIll - Math.sin(Math.toRadians(lllllllllllIIIlIIlIlllllIIIIIIlI)) * lllllllllllIIIlIIlIlllllIIIIIllI);
                color(setAlpha(astolfoColors45((float)(lllllllllllIIIlIIlIlllllIIIIIIlI - lllllllllllIIIlIIlIlllllIIIIIIlI + 1), (float)lllllllllllIIIlIIlIlllllIIIIIIlI, 50.0f, 10.0f), 0));
                GL11.glVertex3d(lllllllllllIIIlIIlIlllllIIIIIlIl + Math.cos(Math.toRadians(lllllllllllIIIlIIlIlllllIIIIIIlI)) * lllllllllllIIIlIIlIlllllIIIIIllI, lllllllllllIIIlIIlIlllllIIIIIlII + 0.05 + 0.13 * lllllllllllIIIlIIlIlllllIIIIIlll, lllllllllllIIIlIIlIlllllIIIIIIll - Math.sin(Math.toRadians(lllllllllllIIIlIIlIlllllIIIIIIlI)) * lllllllllllIIIlIIlIlllllIIIIIllI);
            }
            GL11.glEnd();
            GL11.glBegin(2);
            for (int lllllllllllIIIlIIlIllllIllllllll = 0; lllllllllllIIIlIIlIllllIllllllll < 365; ++lllllllllllIIIlIIlIllllIllllllll) {
                setColor(astolfoColors45((float)(lllllllllllIIIlIIlIllllIllllllll - lllllllllllIIIlIIlIllllIllllllll + 15), (float)lllllllllllIIIlIIlIllllIllllllll, 50.0f, 10.0f).getRGB());
                GL11.glVertex3d(lllllllllllIIIlIIlIlllllIIIIIlIl + Math.cos(Math.toRadians(lllllllllllIIIlIIlIllllIllllllll)) * lllllllllllIIIlIIlIlllllIIIIIllI, lllllllllllIIIlIIlIlllllIIIIIlII + 0.05, lllllllllllIIIlIIlIlllllIIIIIIll - Math.sin(Math.toRadians(lllllllllllIIIlIIlIllllIllllllll)) * lllllllllllIIIlIIlIlllllIIIIIllI);
            }
            GL11.glEnd();
            GlStateManager.enableAlpha();
            GL11.glShadeModel(7424);
            GL11.glDisable(2848);
            GL11.glEnable(2884);
            GlStateManager.enableTexture2D();
            GlStateManager.enableDepth();
            GlStateManager.disableBlend();
            GlStateManager.resetColor();
        }
    }
    
    public static int darker(final int lllllllllllIIIlIIllIIIIlIlIlllIl, final float lllllllllllIIIlIIllIIIIlIlIlllII) {
        final int lllllllllllIIIlIIllIIIIlIllIIIIl = (int)((lllllllllllIIIlIIllIIIIlIlIlllIl >> 16 & 0xFF) * lllllllllllIIIlIIllIIIIlIlIlllII);
        final int lllllllllllIIIlIIllIIIIlIllIIIII = (int)((lllllllllllIIIlIIllIIIIlIlIlllIl >> 8 & 0xFF) * lllllllllllIIIlIIllIIIIlIlIlllII);
        final int lllllllllllIIIlIIllIIIIlIlIlllll = (int)((lllllllllllIIIlIIllIIIIlIlIlllIl & 0xFF) * lllllllllllIIIlIIllIIIIlIlIlllII);
        final int lllllllllllIIIlIIllIIIIlIlIllllI = lllllllllllIIIlIIllIIIIlIlIlllIl >> 24 & 0xFF;
        return (lllllllllllIIIlIIllIIIIlIllIIIIl & 0xFF) << 16 | (lllllllllllIIIlIIllIIIIlIllIIIII & 0xFF) << 8 | (lllllllllllIIIlIIllIIIIlIlIlllll & 0xFF) | (lllllllllllIIIlIIllIIIIlIlIllllI & 0xFF) << 24;
    }
    
    public static Vec3d getRenderPos(double lllllllllllIIIlIIlIllllIIIIlIIII, double lllllllllllIIIlIIlIllllIIIIIllll, double lllllllllllIIIlIIlIllllIIIIlIIIl) {
        DrawHelper.mc.getRenderManager();
        lllllllllllIIIlIIlIllllIIIIlIIII -= (RenderManager.renderPosX != 0.0);
        final double n = lllllllllllIIIlIIlIllllIIIIIllll;
        DrawHelper.mc.getRenderManager();
        lllllllllllIIIlIIlIllllIIIIIllll = n - RenderManager.renderPosY;
        final double n2 = lllllllllllIIIlIIlIllllIIIIlIIIl;
        DrawHelper.mc.getRenderManager();
        lllllllllllIIIlIIlIllllIIIIlIIIl = n2 - RenderManager.renderPosZ;
        return new Vec3d(lllllllllllIIIlIIlIllllIIIIlIIII ? 1 : 0, lllllllllllIIIlIIlIllllIIIIIllll, lllllllllllIIIlIIlIllllIIIIlIIIl);
    }
    
    public static void drawCompleteImage(final double lllllllllllIIIlIIllIIIllIIIllllI, final double lllllllllllIIIlIIllIIIllIIIlllIl, final double lllllllllllIIIlIIllIIIllIIIlllII, final double lllllllllllIIIlIIllIIIllIIIlllll) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)lllllllllllIIIlIIllIIIllIIIllllI, (float)lllllllllllIIIlIIllIIIllIIIlllIl, 0.0f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glBegin(7);
        GL11.glTexCoord2f(0.0f, 0.0f);
        GL11.glVertex3f(0.0f, 0.0f, 0.0f);
        GL11.glTexCoord2f(0.0f, 1.0f);
        GL11.glVertex3f(0.0f, (float)lllllllllllIIIlIIllIIIllIIIlllll, 0.0f);
        GL11.glTexCoord2f(1.0f, 1.0f);
        GL11.glVertex3f((float)lllllllllllIIIlIIllIIIllIIIlllII, (float)lllllllllllIIIlIIllIIIllIIIlllll, 0.0f);
        GL11.glTexCoord2f(1.0f, 0.0f);
        GL11.glVertex3f((float)lllllllllllIIIlIIllIIIllIIIlllII, 0.0f, 0.0f);
        GL11.glEnd();
        GL11.glPopMatrix();
    }
    
    public static Color rainbow(final int lllllllllllIIIlIIlIlllIllIllIlll, final float lllllllllllIIIlIIlIlllIllIllIllI, final float lllllllllllIIIlIIlIlllIllIllIlIl) {
        double lllllllllllIIIlIIlIlllIllIllIlII = Math.ceil((double)((System.currentTimeMillis() + lllllllllllIIIlIIlIlllIllIllIlll) / 16L));
        lllllllllllIIIlIIlIlllIllIllIlII %= 360.0;
        return Color.getHSBColor((float)(lllllllllllIIIlIIlIlllIllIllIlII / 360.0), lllllllllllIIIlIIlIlllIllIllIllI, lllllllllllIIIlIIlIlllIllIllIlIl);
    }
    
    private static boolean isInViewFrustrum(final AxisAlignedBB lllllllllllIIIlIIlIllllIIIIllIll) {
        final Entity lllllllllllIIIlIIlIllllIIIIlllII = Minecraft.getMinecraft().getRenderViewEntity();
        DrawHelper.frustrum.setPosition(lllllllllllIIIlIIlIllllIIIIlllII.posX, lllllllllllIIIlIIlIllllIIIIlllII.posY, lllllllllllIIIlIIlIllllIIIIlllII.posZ);
        return DrawHelper.frustrum.isBoundingBoxInFrustum(lllllllllllIIIlIIlIllllIIIIllIll);
    }
    
    public static void drawRect(double lllllllllllIIIlIIlIlllIlllIlIIlI, double lllllllllllIIIlIIlIlllIlllIlIIIl, double lllllllllllIIIlIIlIlllIlllIlIIII, double lllllllllllIIIlIIlIlllIlllIIllll, final int lllllllllllIIIlIIlIlllIlllIIlllI) {
        if (lllllllllllIIIlIIlIlllIlllIlIIlI < lllllllllllIIIlIIlIlllIlllIlIIII) {
            final double lllllllllllIIIlIIlIlllIlllIllIlI = lllllllllllIIIlIIlIlllIlllIlIIlI;
            lllllllllllIIIlIIlIlllIlllIlIIlI = lllllllllllIIIlIIlIlllIlllIlIIII;
            lllllllllllIIIlIIlIlllIlllIlIIII = lllllllllllIIIlIIlIlllIlllIllIlI;
        }
        if (lllllllllllIIIlIIlIlllIlllIlIIIl < lllllllllllIIIlIIlIlllIlllIIllll) {
            final double lllllllllllIIIlIIlIlllIlllIllIIl = lllllllllllIIIlIIlIlllIlllIlIIIl;
            lllllllllllIIIlIIlIlllIlllIlIIIl = lllllllllllIIIlIIlIlllIlllIIllll;
            lllllllllllIIIlIIlIlllIlllIIllll = lllllllllllIIIlIIlIlllIlllIllIIl;
        }
        final float lllllllllllIIIlIIlIlllIlllIllIII = (lllllllllllIIIlIIlIlllIlllIIlllI >> 24 & 0xFF) / 255.0f;
        final float lllllllllllIIIlIIlIlllIlllIlIlll = (lllllllllllIIIlIIlIlllIlllIIlllI >> 16 & 0xFF) / 255.0f;
        final float lllllllllllIIIlIIlIlllIlllIlIllI = (lllllllllllIIIlIIlIlllIlllIIlllI >> 8 & 0xFF) / 255.0f;
        final float lllllllllllIIIlIIlIlllIlllIlIlIl = (lllllllllllIIIlIIlIlllIlllIIlllI & 0xFF) / 255.0f;
        final Tessellator lllllllllllIIIlIIlIlllIlllIlIlII = Tessellator.getInstance();
        final BufferBuilder lllllllllllIIIlIIlIlllIlllIlIIll = lllllllllllIIIlIIlIlllIlllIlIlII.getBuffer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.color(lllllllllllIIIlIIlIlllIlllIlIlll, lllllllllllIIIlIIlIlllIlllIlIllI, lllllllllllIIIlIIlIlllIlllIlIlIl, lllllllllllIIIlIIlIlllIlllIllIII);
        lllllllllllIIIlIIlIlllIlllIlIIll.begin(7, DefaultVertexFormats.POSITION);
        lllllllllllIIIlIIlIlllIlllIlIIll.pos(lllllllllllIIIlIIlIlllIlllIlIIlI, lllllllllllIIIlIIlIlllIlllIIllll, 0.0).endVertex();
        lllllllllllIIIlIIlIlllIlllIlIIll.pos(lllllllllllIIIlIIlIlllIlllIlIIII, lllllllllllIIIlIIlIlllIlllIIllll, 0.0).endVertex();
        lllllllllllIIIlIIlIlllIlllIlIIll.pos(lllllllllllIIIlIIlIlllIlllIlIIII, lllllllllllIIIlIIlIlllIlllIlIIIl, 0.0).endVertex();
        lllllllllllIIIlIIlIlllIlllIlIIll.pos(lllllllllllIIIlIIlIlllIlllIlIIlI, lllllllllllIIIlIIlIlllIlllIlIIIl, 0.0).endVertex();
        lllllllllllIIIlIIlIlllIlllIlIlII.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }
    
    public static void drawGlowRoundedRect(final float lllllllllllIIIlIIllIIIlIIIlIIIIl, final float lllllllllllIIIlIIllIIIlIIIlIIIII, final float lllllllllllIIIlIIllIIIlIIIIlllll, final float lllllllllllIIIlIIllIIIlIIIIllllI, final int lllllllllllIIIlIIllIIIlIIIIlllIl, final float lllllllllllIIIlIIllIIIlIIIIlllII, final float lllllllllllIIIlIIllIIIlIIIIllIll) {
        GL11.glPushMatrix();
        GL11.glEnable(3042);
        GL11.glDisable(3008);
        final float lllllllllllIIIlIIllIIIlIIIIllIlI = (lllllllllllIIIlIIllIIIlIIIIlllIl >> 24 & 0xFF) / 255.0f;
        final float lllllllllllIIIlIIllIIIlIIIIllIIl = (lllllllllllIIIlIIllIIIlIIIIlllIl >> 16 & 0xFF) / 255.0f;
        final float lllllllllllIIIlIIllIIIlIIIIllIII = (lllllllllllIIIlIIllIIIlIIIIlllIl >> 8 & 0xFF) / 255.0f;
        final float lllllllllllIIIlIIllIIIlIIIIlIlll = (lllllllllllIIIlIIllIIIlIIIIlllIl & 0xFF) / 255.0f;
        ShaderShell.ROUNDED_RECT.attach();
        ShaderShell.ROUNDED_RECT.set4F("color", lllllllllllIIIlIIllIIIlIIIIllIIl, lllllllllllIIIlIIllIIIlIIIIllIII, lllllllllllIIIlIIllIIIlIIIIlIlll, lllllllllllIIIlIIllIIIlIIIIllIlI);
        ShaderShell.ROUNDED_RECT.set2F("resolution", (float)Minecraft.getMinecraft().displayWidth, (float)Minecraft.getMinecraft().displayHeight);
        ShaderShell.ROUNDED_RECT.set2F("center", (lllllllllllIIIlIIllIIIlIIIlIIIIl + (lllllllllllIIIlIIllIIIlIIIIlllll - lllllllllllIIIlIIllIIIlIIIlIIIIl) / 2.0f) * 2.0f, (lllllllllllIIIlIIllIIIlIIIlIIIII + (lllllllllllIIIlIIllIIIlIIIIllllI - lllllllllllIIIlIIllIIIlIIIlIIIII) / 2.0f) * 2.0f);
        ShaderShell.ROUNDED_RECT.set2F("dst", (lllllllllllIIIlIIllIIIlIIIIlllll - lllllllllllIIIlIIllIIIlIIIlIIIIl - lllllllllllIIIlIIllIIIlIIIIlllII) * 2.0f, (lllllllllllIIIlIIllIIIlIIIIllllI - lllllllllllIIIlIIllIIIlIIIlIIIII - lllllllllllIIIlIIllIIIlIIIIlllII) * 2.0f);
        ShaderShell.ROUNDED_RECT.set1F("radius", lllllllllllIIIlIIllIIIlIIIIlllII);
        ShaderShell.ROUNDED_RECT.set1F("force", lllllllllllIIIlIIllIIIlIIIIllIll);
        GL11.glBegin(7);
        GL11.glVertex2d((double)lllllllllllIIIlIIllIIIlIIIIlllll, (double)lllllllllllIIIlIIllIIIlIIIlIIIII);
        GL11.glVertex2d((double)lllllllllllIIIlIIllIIIlIIIlIIIIl, (double)lllllllllllIIIlIIllIIIlIIIlIIIII);
        GL11.glVertex2d((double)lllllllllllIIIlIIllIIIlIIIlIIIIl, (double)lllllllllllIIIlIIllIIIlIIIIllllI);
        GL11.glVertex2d((double)lllllllllllIIIlIIllIIIlIIIIlllll, (double)lllllllllllIIIlIIllIIIlIIIIllllI);
        GL11.glEnd();
        ShaderShell.ROUNDED_RECT.detach();
        GL11.glEnable(3008);
        GL11.glDisable(3042);
        GL11.glPopMatrix();
    }
    
    public static void inShaderFBO() {
        try {
            (DrawHelper.blurShader = new ShaderGroup(DrawHelper.mc.getTextureManager(), DrawHelper.mc.getResourceManager(), DrawHelper.mc.getFramebuffer(), DrawHelper.shader)).createBindFramebuffers(DrawHelper.mc.displayWidth, DrawHelper.mc.displayHeight);
            DrawHelper.buffer = DrawHelper.blurShader.mainFramebuffer;
        }
        catch (Exception lllllllllllIIIlIIllIIIllIIIIIlll) {
            lllllllllllIIIlIIllIIIllIIIIIlll.printStackTrace();
        }
    }
    
    public static void enableGUIStandardItemLighting() {
        GlStateManager.pushMatrix();
        GlStateManager.rotate(-30.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(165.0f, 1.0f, 0.0f, 0.0f);
        enableStandardItemLighting();
        GlStateManager.popMatrix();
    }
    
    public static Color rainbow2(final int lllllllllllIIIlIIlIlllIllIIllllI, final float lllllllllllIIIlIIlIlllIllIIlllIl, final float lllllllllllIIIlIIlIlllIllIIlllII) {
        double lllllllllllIIIlIIlIlllIllIIlllll = Math.ceil((double)((System.currentTimeMillis() + lllllllllllIIIlIIlIlllIllIIllllI) / 16L));
        lllllllllllIIIlIIlIlllIllIIlllll %= 360.0;
        return Color.getHSBColor((float)(lllllllllllIIIlIIlIlllIllIIlllll / 360.0), lllllllllllIIIlIIlIlllIllIIlllIl, lllllllllllIIIlIIlIlllIllIIlllII);
    }
    
    public static void disableGL2D3() {
        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glEnable(2929);
        GL11.glDisable(2848);
        GL11.glHint(3154, 4352);
        GL11.glHint(3155, 4352);
    }
    
    public static void glColor(final Color lllllllllllIIIlIIllIIIIIlllIIlIl) {
        final float lllllllllllIIIlIIllIIIIIlllIlIIl = lllllllllllIIIlIIllIIIIIlllIIlIl.getRed() / 255.0f;
        final float lllllllllllIIIlIIllIIIIIlllIlIII = lllllllllllIIIlIIllIIIIIlllIIlIl.getGreen() / 255.0f;
        final float lllllllllllIIIlIIllIIIIIlllIIlll = lllllllllllIIIlIIllIIIIIlllIIlIl.getBlue() / 255.0f;
        final float lllllllllllIIIlIIllIIIIIlllIIllI = lllllllllllIIIlIIllIIIIIlllIIlIl.getAlpha() / 255.0f;
        GlStateManager.color(lllllllllllIIIlIIllIIIIIlllIlIIl, lllllllllllIIIlIIllIIIIIlllIlIII, lllllllllllIIIlIIllIIIIIlllIIlll, lllllllllllIIIlIIllIIIIIlllIIllI);
    }
    
    public static void drawSelectionBoundingBox(final AxisAlignedBB lllllllllllIIIlIIllIIIIIlIIIIllI) {
        final Tessellator lllllllllllIIIlIIllIIIIIlIIIIlIl = Tessellator.getInstance();
        final BufferBuilder lllllllllllIIIlIIllIIIIIlIIIIlII = lllllllllllIIIlIIllIIIIIlIIIIlIl.getBuffer();
        lllllllllllIIIlIIllIIIIIlIIIIlII.begin(3, DefaultVertexFormats.POSITION);
        lllllllllllIIIlIIllIIIIIlIIIIlII.pos(lllllllllllIIIlIIllIIIIIlIIIIllI.minX, lllllllllllIIIlIIllIIIIIlIIIIllI.minY, lllllllllllIIIlIIllIIIIIlIIIIllI.minZ).endVertex();
        lllllllllllIIIlIIllIIIIIlIIIIlII.pos(lllllllllllIIIlIIllIIIIIlIIIIllI.maxX, lllllllllllIIIlIIllIIIIIlIIIIllI.minY, lllllllllllIIIlIIllIIIIIlIIIIllI.minZ).endVertex();
        lllllllllllIIIlIIllIIIIIlIIIIlII.pos(lllllllllllIIIlIIllIIIIIlIIIIllI.maxX, lllllllllllIIIlIIllIIIIIlIIIIllI.minY, lllllllllllIIIlIIllIIIIIlIIIIllI.maxZ).endVertex();
        lllllllllllIIIlIIllIIIIIlIIIIlII.pos(lllllllllllIIIlIIllIIIIIlIIIIllI.minX, lllllllllllIIIlIIllIIIIIlIIIIllI.minY, lllllllllllIIIlIIllIIIIIlIIIIllI.maxZ).endVertex();
        lllllllllllIIIlIIllIIIIIlIIIIlII.pos(lllllllllllIIIlIIllIIIIIlIIIIllI.minX, lllllllllllIIIlIIllIIIIIlIIIIllI.minY, lllllllllllIIIlIIllIIIIIlIIIIllI.minZ).endVertex();
        lllllllllllIIIlIIllIIIIIlIIIIlIl.draw();
        lllllllllllIIIlIIllIIIIIlIIIIlII.begin(3, DefaultVertexFormats.POSITION);
        lllllllllllIIIlIIllIIIIIlIIIIlII.pos(lllllllllllIIIlIIllIIIIIlIIIIllI.minX, lllllllllllIIIlIIllIIIIIlIIIIllI.maxY, lllllllllllIIIlIIllIIIIIlIIIIllI.minZ).endVertex();
        lllllllllllIIIlIIllIIIIIlIIIIlII.pos(lllllllllllIIIlIIllIIIIIlIIIIllI.maxX, lllllllllllIIIlIIllIIIIIlIIIIllI.maxY, lllllllllllIIIlIIllIIIIIlIIIIllI.minZ).endVertex();
        lllllllllllIIIlIIllIIIIIlIIIIlII.pos(lllllllllllIIIlIIllIIIIIlIIIIllI.maxX, lllllllllllIIIlIIllIIIIIlIIIIllI.maxY, lllllllllllIIIlIIllIIIIIlIIIIllI.maxZ).endVertex();
        lllllllllllIIIlIIllIIIIIlIIIIlII.pos(lllllllllllIIIlIIllIIIIIlIIIIllI.minX, lllllllllllIIIlIIllIIIIIlIIIIllI.maxY, lllllllllllIIIlIIllIIIIIlIIIIllI.maxZ).endVertex();
        lllllllllllIIIlIIllIIIIIlIIIIlII.pos(lllllllllllIIIlIIllIIIIIlIIIIllI.minX, lllllllllllIIIlIIllIIIIIlIIIIllI.maxY, lllllllllllIIIlIIllIIIIIlIIIIllI.minZ).endVertex();
        lllllllllllIIIlIIllIIIIIlIIIIlIl.draw();
        lllllllllllIIIlIIllIIIIIlIIIIlII.begin(1, DefaultVertexFormats.POSITION);
        lllllllllllIIIlIIllIIIIIlIIIIlII.pos(lllllllllllIIIlIIllIIIIIlIIIIllI.minX, lllllllllllIIIlIIllIIIIIlIIIIllI.minY, lllllllllllIIIlIIllIIIIIlIIIIllI.minZ).endVertex();
        lllllllllllIIIlIIllIIIIIlIIIIlII.pos(lllllllllllIIIlIIllIIIIIlIIIIllI.minX, lllllllllllIIIlIIllIIIIIlIIIIllI.maxY, lllllllllllIIIlIIllIIIIIlIIIIllI.minZ).endVertex();
        lllllllllllIIIlIIllIIIIIlIIIIlII.pos(lllllllllllIIIlIIllIIIIIlIIIIllI.maxX, lllllllllllIIIlIIllIIIIIlIIIIllI.minY, lllllllllllIIIlIIllIIIIIlIIIIllI.minZ).endVertex();
        lllllllllllIIIlIIllIIIIIlIIIIlII.pos(lllllllllllIIIlIIllIIIIIlIIIIllI.maxX, lllllllllllIIIlIIllIIIIIlIIIIllI.maxY, lllllllllllIIIlIIllIIIIIlIIIIllI.minZ).endVertex();
        lllllllllllIIIlIIllIIIIIlIIIIlII.pos(lllllllllllIIIlIIllIIIIIlIIIIllI.maxX, lllllllllllIIIlIIllIIIIIlIIIIllI.minY, lllllllllllIIIlIIllIIIIIlIIIIllI.maxZ).endVertex();
        lllllllllllIIIlIIllIIIIIlIIIIlII.pos(lllllllllllIIIlIIllIIIIIlIIIIllI.maxX, lllllllllllIIIlIIllIIIIIlIIIIllI.maxY, lllllllllllIIIlIIllIIIIIlIIIIllI.maxZ).endVertex();
        lllllllllllIIIlIIllIIIIIlIIIIlII.pos(lllllllllllIIIlIIllIIIIIlIIIIllI.minX, lllllllllllIIIlIIllIIIIIlIIIIllI.minY, lllllllllllIIIlIIllIIIIIlIIIIllI.maxZ).endVertex();
        lllllllllllIIIlIIllIIIIIlIIIIlII.pos(lllllllllllIIIlIIllIIIIIlIIIIllI.minX, lllllllllllIIIlIIllIIIIIlIIIIllI.maxY, lllllllllllIIIlIIllIIIIIlIIIIllI.maxZ).endVertex();
        lllllllllllIIIlIIllIIIIIlIIIIlIl.draw();
    }
    
    public static Color blendColors(final float[] lllllllllllIIIlIIlIlllIIllIllIII, final Color[] lllllllllllIIIlIIlIlllIIllIIlllI, final float lllllllllllIIIlIIlIlllIIllIlIllI) {
        if (lllllllllllIIIlIIlIlllIIllIllIII == null) {
            throw new IllegalArgumentException("Fractions can't be null");
        }
        if (lllllllllllIIIlIIlIlllIIllIIlllI == null) {
            throw new IllegalArgumentException("Colours can't be null");
        }
        if (lllllllllllIIIlIIlIlllIIllIllIII.length != lllllllllllIIIlIIlIlllIIllIIlllI.length) {
            throw new IllegalArgumentException("Fractions and colours must have equal number of elements");
        }
        final int[] lllllllllllIIIlIIlIlllIIllIlIlIl = getFractionIndicies(lllllllllllIIIlIIlIlllIIllIllIII, lllllllllllIIIlIIlIlllIIllIlIllI);
        final float[] lllllllllllIIIlIIlIlllIIllIlIlII = { lllllllllllIIIlIIlIlllIIllIllIII[lllllllllllIIIlIIlIlllIIllIlIlIl[0]], lllllllllllIIIlIIlIlllIIllIllIII[lllllllllllIIIlIIlIlllIIllIlIlIl[1]] };
        final Color[] lllllllllllIIIlIIlIlllIIllIlIIll = { lllllllllllIIIlIIlIlllIIllIIlllI[lllllllllllIIIlIIlIlllIIllIlIlIl[0]], lllllllllllIIIlIIlIlllIIllIIlllI[lllllllllllIIIlIIlIlllIIllIlIlIl[1]] };
        final float lllllllllllIIIlIIlIlllIIllIlIIlI = lllllllllllIIIlIIlIlllIIllIlIlII[1] - lllllllllllIIIlIIlIlllIIllIlIlII[0];
        final float lllllllllllIIIlIIlIlllIIllIlIIIl = lllllllllllIIIlIIlIlllIIllIlIllI - lllllllllllIIIlIIlIlllIIllIlIlII[0];
        final float lllllllllllIIIlIIlIlllIIllIlIIII = lllllllllllIIIlIIlIlllIIllIlIIIl / lllllllllllIIIlIIlIlllIIllIlIIlI;
        return blend(lllllllllllIIIlIIlIlllIIllIlIIll[0], lllllllllllIIIlIIlIlllIIllIlIIll[1], 1.0f - lllllllllllIIIlIIlIlllIIllIlIIII);
    }
    
    public static int getRandomColor() {
        final char[] lllllllllllIIIlIIlIlllIlIlllIIll = "012345678".toCharArray();
        String lllllllllllIIIlIIlIlllIlIlllIIlI = "0x";
        for (int lllllllllllIIIlIIlIlllIlIlllIIIl = 0; lllllllllllIIIlIIlIlllIlIlllIIIl < 6; ++lllllllllllIIIlIIlIlllIlIlllIIIl) {
            lllllllllllIIIlIIlIlllIlIlllIIlI = String.valueOf(lllllllllllIIIlIIlIlllIlIlllIIlI) + lllllllllllIIIlIIlIlllIlIlllIIll[new Random().nextInt(lllllllllllIIIlIIlIlllIlIlllIIll.length)];
        }
        return Integer.decode(lllllllllllIIIlIIlIlllIlIlllIIlI);
    }
    
    public static Color astolfoColors45(final float lllllllllllIIIlIIlIllIlllllIllII, final float lllllllllllIIIlIIlIllIlllllIIlIl, final float lllllllllllIIIlIIlIllIlllllIlIlI, final float lllllllllllIIIlIIlIllIlllllIlIIl) {
        float lllllllllllIIIlIIlIllIlllllIlIII;
        float lllllllllllIIIlIIlIllIlllllIIlll;
        for (lllllllllllIIIlIIlIllIlllllIlIII = 1800.0f, lllllllllllIIIlIIlIllIlllllIIlll = System.currentTimeMillis() % (int)lllllllllllIIIlIIlIllIlllllIlIII + (lllllllllllIIIlIIlIllIlllllIIlIl - lllllllllllIIIlIIlIllIlllllIllII) * lllllllllllIIIlIIlIllIlllllIlIIl; lllllllllllIIIlIIlIllIlllllIIlll > lllllllllllIIIlIIlIllIlllllIlIII; lllllllllllIIIlIIlIllIlllllIIlll -= lllllllllllIIIlIIlIllIlllllIlIII) {}
        lllllllllllIIIlIIlIllIlllllIIlll /= lllllllllllIIIlIIlIllIlllllIlIII;
        if (lllllllllllIIIlIIlIllIlllllIIlll > 0.5) {
            lllllllllllIIIlIIlIllIlllllIIlll = 0.5f - (lllllllllllIIIlIIlIllIlllllIIlll - 0.5f);
        }
        lllllllllllIIIlIIlIllIlllllIIlll += 0.5f;
        return Color.getHSBColor(lllllllllllIIIlIIlIllIlllllIIlll, lllllllllllIIIlIIlIllIlllllIlIlI, 1.0f);
    }
    
    public static void drawFilledCircle(final int lllllllllllIIIlIIlIllllIlIlIlIlI, final int lllllllllllIIIlIIlIllllIlIllIIlI, final float lllllllllllIIIlIIlIllllIlIllIIIl, final Color lllllllllllIIIlIIlIllllIlIlIIlll) {
        final int lllllllllllIIIlIIlIllllIlIlIllll = 50;
        final double lllllllllllIIIlIIlIllllIlIlIlllI = 6.283185307179586 / lllllllllllIIIlIIlIllllIlIlIllll;
        GL11.glPushAttrib(8192);
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(2848);
        GL11.glBegin(6);
        for (int lllllllllllIIIlIIlIllllIlIlIllIl = 0; lllllllllllIIIlIIlIllllIlIlIllIl < lllllllllllIIIlIIlIllllIlIlIllll; ++lllllllllllIIIlIIlIllllIlIlIllIl) {
            final float lllllllllllIIIlIIlIllllIlIlIllII = (float)(lllllllllllIIIlIIlIllllIlIllIIIl * Math.sin(lllllllllllIIIlIIlIllllIlIlIllIl * lllllllllllIIIlIIlIllllIlIlIlllI));
            final float lllllllllllIIIlIIlIllllIlIlIlIll = (float)(lllllllllllIIIlIIlIllllIlIllIIIl * Math.cos(lllllllllllIIIlIIlIllllIlIlIllIl * lllllllllllIIIlIIlIllllIlIlIlllI));
            GL11.glColor4f(lllllllllllIIIlIIlIllllIlIlIIlll.getRed() / 255.0f, lllllllllllIIIlIIlIllllIlIlIIlll.getGreen() / 255.0f, lllllllllllIIIlIIlIllllIlIlIIlll.getBlue() / 255.0f, lllllllllllIIIlIIlIllllIlIlIIlll.getAlpha() / 255.0f);
            GL11.glVertex2f(lllllllllllIIIlIIlIllllIlIlIlIlI + lllllllllllIIIlIIlIllllIlIlIllII, lllllllllllIIIlIIlIllllIlIllIIlI + lllllllllllIIIlIIlIllllIlIlIlIll);
        }
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glEnd();
        GL11.glPopAttrib();
    }
    
    public static Color astolfo(final boolean lllllllllllIIIlIIllIIIIlIIlIllIl, final int lllllllllllIIIlIIllIIIIlIIlIllII) {
        final float lllllllllllIIIlIIllIIIIlIIlIlIll = lllllllllllIIIlIIllIIIIlIIlIllIl ? (ClickGUI.speed.getNumberValue() * 100.0f) : 200.0f;
        float lllllllllllIIIlIIllIIIIlIIlIlIlI = (float)(System.currentTimeMillis() % (int)lllllllllllIIIlIIllIIIIlIIlIlIll + lllllllllllIIIlIIllIIIIlIIlIllII);
        if (lllllllllllIIIlIIllIIIIlIIlIlIlI > lllllllllllIIIlIIllIIIIlIIlIlIll) {
            lllllllllllIIIlIIllIIIIlIIlIlIlI -= lllllllllllIIIlIIllIIIIlIIlIlIll;
        }
        lllllllllllIIIlIIllIIIIlIIlIlIlI /= lllllllllllIIIlIIllIIIIlIIlIlIll;
        if (lllllllllllIIIlIIllIIIIlIIlIlIlI > 0.5f) {
            lllllllllllIIIlIIllIIIIlIIlIlIlI = 0.5f - (lllllllllllIIIlIIllIIIIlIIlIlIlI - 0.5f);
        }
        lllllllllllIIIlIIllIIIIlIIlIlIlI += 0.5f;
        return Color.getHSBColor(lllllllllllIIIlIIllIIIIlIIlIlIlI, 0.4f, 1.0f);
    }
    
    public static void drawSkeetButton(final float lllllllllllIIIlIIllIIIIlllllIIIl, final float lllllllllllIIIlIIllIIIIlllllIlII, final float lllllllllllIIIlIIllIIIIlllllIIll, final float lllllllllllIIIlIIllIIIIllllIlllI) {
        drawSmoothRect(lllllllllllIIIlIIllIIIIlllllIIIl - 31.0f, lllllllllllIIIlIIllIIIIlllllIlII - 43.0f, lllllllllllIIIlIIllIIIIlllllIIll + 31.0f, lllllllllllIIIlIIllIIIIllllIlllI - 30.0f, new Color(0, 0, 0, 255).getRGB());
        drawSmoothRect(lllllllllllIIIlIIllIIIIlllllIIIl - 30.5f, lllllllllllIIIlIIllIIIIlllllIlII - 42.5f, lllllllllllIIIlIIllIIIIlllllIIll + 30.5f, lllllllllllIIIlIIllIIIIllllIlllI - 30.5f, new Color(45, 45, 45, 255).getRGB());
        drawGradientRect((int)lllllllllllIIIlIIllIIIIlllllIIIl - 30, (int)lllllllllllIIIlIIllIIIIlllllIlII - 42, lllllllllllIIIlIIllIIIIlllllIIll + 30.0f, lllllllllllIIIlIIllIIIIllllIlllI - 31.0f, new Color(48, 48, 48, 255).getRGB(), new Color(19, 19, 19, 255).getRGB());
    }
    
    public static int toRGBA(final int lllllllllllIIIlIIlIlllIlIIllllII, final int lllllllllllIIIlIIlIlllIlIIllllll, final int lllllllllllIIIlIIlIlllIlIIlllllI, final int lllllllllllIIIlIIlIlllIlIIllllIl) {
        return (lllllllllllIIIlIIlIlllIlIIllllII << 16) + (lllllllllllIIIlIIlIlllIlIIllllll << 8) + (lllllllllllIIIlIIlIlllIlIIlllllI << 0) + (lllllllllllIIIlIIlIlllIlIIllllIl << 24);
    }
    
    public static int rainbowNew(final int lllllllllllIIIlIIllIIIIlIIIIlIII, final float lllllllllllIIIlIIllIIIIlIIIIIlll, final float lllllllllllIIIlIIllIIIIlIIIIIllI) {
        double lllllllllllIIIlIIllIIIIlIIIIlIIl = Math.ceil((double)((System.currentTimeMillis() + lllllllllllIIIlIIllIIIIlIIIIlIII) / 16L));
        lllllllllllIIIlIIllIIIIlIIIIlIIl %= 360.0;
        return Color.getHSBColor((float)(lllllllllllIIIlIIllIIIIlIIIIlIIl / 360.0), lllllllllllIIIlIIllIIIIlIIIIIlll, lllllllllllIIIlIIllIIIIlIIIIIllI).getRGB();
    }
    
    public static final void drawSmoothRect(final float lllllllllllIIIlIIlIllllIllIIIIIl, final float lllllllllllIIIlIIlIllllIllIIIlIl, final float lllllllllllIIIlIIlIllllIlIllllll, final float lllllllllllIIIlIIlIllllIllIIIIll, final int lllllllllllIIIlIIlIllllIlIllllIl) {
        GL11.glEnable(3042);
        GL11.glEnable(2848);
        drawRect(lllllllllllIIIlIIlIllllIllIIIIIl, lllllllllllIIIlIIlIllllIllIIIlIl, lllllllllllIIIlIIlIllllIlIllllll, lllllllllllIIIlIIlIllllIllIIIIll, lllllllllllIIIlIIlIllllIlIllllIl);
        GL11.glScalef(0.5f, 0.5f, 0.5f);
        drawRect(lllllllllllIIIlIIlIllllIllIIIIIl * 2.0f - 1.0f, lllllllllllIIIlIIlIllllIllIIIlIl * 2.0f, lllllllllllIIIlIIlIllllIllIIIIIl * 2.0f, lllllllllllIIIlIIlIllllIllIIIIll * 2.0f - 1.0f, lllllllllllIIIlIIlIllllIlIllllIl);
        drawRect(lllllllllllIIIlIIlIllllIllIIIIIl * 2.0f, lllllllllllIIIlIIlIllllIllIIIlIl * 2.0f - 1.0f, lllllllllllIIIlIIlIllllIlIllllll * 2.0f, lllllllllllIIIlIIlIllllIllIIIlIl * 2.0f, lllllllllllIIIlIIlIllllIlIllllIl);
        drawRect(lllllllllllIIIlIIlIllllIlIllllll * 2.0f, lllllllllllIIIlIIlIllllIllIIIlIl * 2.0f, lllllllllllIIIlIIlIllllIlIllllll * 2.0f + 1.0f, lllllllllllIIIlIIlIllllIllIIIIll * 2.0f - 1.0f, lllllllllllIIIlIIlIllllIlIllllIl);
        drawRect(lllllllllllIIIlIIlIllllIllIIIIIl * 2.0f, lllllllllllIIIlIIlIllllIllIIIIll * 2.0f - 1.0f, lllllllllllIIIlIIlIllllIlIllllll * 2.0f, lllllllllllIIIlIIlIllllIllIIIIll * 2.0f, lllllllllllIIIlIIlIllllIlIllllIl);
        GL11.glDisable(3042);
        GL11.glScalef(2.0f, 2.0f, 2.0f);
    }
    
    public static int reAlpha(final int lllllllllllIIIlIIlIlllIlIllIIIIl, final float lllllllllllIIIlIIlIlllIlIllIIIII) {
        final Color lllllllllllIIIlIIlIlllIlIllIIlIl = new Color(lllllllllllIIIlIIlIlllIlIllIIIIl);
        final float lllllllllllIIIlIIlIlllIlIllIIlII = 0.003921569f * lllllllllllIIIlIIlIlllIlIllIIlIl.getRed();
        final float lllllllllllIIIlIIlIlllIlIllIIIll = 0.003921569f * lllllllllllIIIlIIlIlllIlIllIIlIl.getGreen();
        final float lllllllllllIIIlIIlIlllIlIllIIIlI = 0.003921569f * lllllllllllIIIlIIlIlllIlIllIIlIl.getBlue();
        return new Color(lllllllllllIIIlIIlIlllIlIllIIlII, lllllllllllIIIlIIlIlllIlIllIIIll, lllllllllllIIIlIIlIlllIlIllIIIlI, lllllllllllIIIlIIlIlllIlIllIIIII).getRGB();
    }
    
    public static int getColor(final int lllllllllllIIIlIIlIlllIlIIIlIIII) {
        return getColor(lllllllllllIIIlIIlIlllIlIIIlIIII, lllllllllllIIIlIIlIlllIlIIIlIIII, lllllllllllIIIlIIlIlllIlIIIlIIII, 255);
    }
    
    public static void drawVGradientRect(final float lllllllllllIIIlIIlIlllllIlllIIIl, final float lllllllllllIIIlIIlIlllllIllIIIII, final float lllllllllllIIIlIIlIlllllIlIlllll, final float lllllllllllIIIlIIlIlllllIllIlllI, final int lllllllllllIIIlIIlIlllllIlIlllIl, final int lllllllllllIIIlIIlIlllllIlIlllII) {
        final float lllllllllllIIIlIIlIlllllIllIlIll = (lllllllllllIIIlIIlIlllllIlIlllIl >> 24 & 0xFF) / 255.0f;
        final float lllllllllllIIIlIIlIlllllIllIlIlI = (lllllllllllIIIlIIlIlllllIlIlllIl >> 16 & 0xFF) / 255.0f;
        final float lllllllllllIIIlIIlIlllllIllIlIIl = (lllllllllllIIIlIIlIlllllIlIlllIl >> 8 & 0xFF) / 255.0f;
        final float lllllllllllIIIlIIlIlllllIllIlIII = (lllllllllllIIIlIIlIlllllIlIlllIl & 0xFF) / 255.0f;
        final float lllllllllllIIIlIIlIlllllIllIIlll = (lllllllllllIIIlIIlIlllllIlIlllII >> 24 & 0xFF) / 255.0f;
        final float lllllllllllIIIlIIlIlllllIllIIllI = (lllllllllllIIIlIIlIlllllIlIlllII >> 16 & 0xFF) / 255.0f;
        final float lllllllllllIIIlIIlIlllllIllIIlIl = (lllllllllllIIIlIIlIlllllIlIlllII >> 8 & 0xFF) / 255.0f;
        final float lllllllllllIIIlIIlIlllllIllIIlII = (lllllllllllIIIlIIlIlllllIlIlllII & 0xFF) / 255.0f;
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.shadeModel(7425);
        final Tessellator lllllllllllIIIlIIlIlllllIllIIIll = Tessellator.getInstance();
        final BufferBuilder lllllllllllIIIlIIlIlllllIllIIIlI = lllllllllllIIIlIIlIlllllIllIIIll.getBuffer();
        lllllllllllIIIlIIlIlllllIllIIIlI.begin(7, DefaultVertexFormats.POSITION_COLOR);
        lllllllllllIIIlIIlIlllllIllIIIlI.pos(lllllllllllIIIlIIlIlllllIlIlllll, lllllllllllIIIlIIlIlllllIllIIIII, 0.0).color(lllllllllllIIIlIIlIlllllIllIlIlI, lllllllllllIIIlIIlIlllllIllIlIIl, lllllllllllIIIlIIlIlllllIllIlIII, lllllllllllIIIlIIlIlllllIllIlIll).endVertex();
        lllllllllllIIIlIIlIlllllIllIIIlI.pos(lllllllllllIIIlIIlIlllllIlllIIIl, lllllllllllIIIlIIlIlllllIllIIIII, 0.0).color(lllllllllllIIIlIIlIlllllIllIlIlI, lllllllllllIIIlIIlIlllllIllIlIIl, lllllllllllIIIlIIlIlllllIllIlIII, lllllllllllIIIlIIlIlllllIllIlIll).endVertex();
        lllllllllllIIIlIIlIlllllIllIIIlI.pos(lllllllllllIIIlIIlIlllllIlllIIIl, lllllllllllIIIlIIlIlllllIllIlllI, 0.0).color(lllllllllllIIIlIIlIlllllIllIIllI, lllllllllllIIIlIIlIlllllIllIIlIl, lllllllllllIIIlIIlIlllllIllIIlII, lllllllllllIIIlIIlIlllllIllIIlll).endVertex();
        lllllllllllIIIlIIlIlllllIllIIIlI.pos(lllllllllllIIIlIIlIlllllIlIlllll, lllllllllllIIIlIIlIlllllIllIlllI, 0.0).color(lllllllllllIIIlIIlIlllllIllIIllI, lllllllllllIIIlIIlIlllllIllIIlIl, lllllllllllIIIlIIlIlllllIllIIlII, lllllllllllIIIlIIlIlllllIllIIlll).endVertex();
        lllllllllllIIIlIIlIlllllIllIIIll.draw();
        GlStateManager.shadeModel(7424);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
    }
    
    public static void glColor(final int lllllllllllIIIlIIllIIIIlIIIllIII, final int lllllllllllIIIlIIllIIIIlIIIlIIll, final int lllllllllllIIIlIIllIIIIlIIIlIIlI, final int lllllllllllIIIlIIllIIIIlIIIlIIIl) {
        GlStateManager.color(lllllllllllIIIlIIllIIIIlIIIllIII / 255.0f, lllllllllllIIIlIIllIIIIlIIIlIIll / 255.0f, lllllllllllIIIlIIllIIIIlIIIlIIlI / 255.0f, lllllllllllIIIlIIllIIIIlIIIlIIIl / 255.0f);
    }
    
    public static void drawRoundedRect2(final double lllllllllllIIIlIIlIllllIIllllIII, final double lllllllllllIIIlIIlIllllIIlllIlll, final double lllllllllllIIIlIIlIllllIIlllIIII, final double lllllllllllIIIlIIlIllllIIlllIlIl, final int lllllllllllIIIlIIlIllllIIlllIlII, final int lllllllllllIIIlIIlIllllIIllIlllI) {
        drawRect(lllllllllllIIIlIIlIllllIIllllIII + 0.5, lllllllllllIIIlIIlIllllIIlllIlll, lllllllllllIIIlIIlIllllIIlllIIII - 0.5, lllllllllllIIIlIIlIllllIIlllIlll + 0.5, lllllllllllIIIlIIlIllllIIllIlllI);
        drawRect(lllllllllllIIIlIIlIllllIIllllIII + 0.5, lllllllllllIIIlIIlIllllIIlllIlIl - 0.5, lllllllllllIIIlIIlIllllIIlllIIII - 0.5, lllllllllllIIIlIIlIllllIIlllIlIl, lllllllllllIIIlIIlIllllIIllIlllI);
        drawRect(lllllllllllIIIlIIlIllllIIllllIII, lllllllllllIIIlIIlIllllIIlllIlll + 0.5, lllllllllllIIIlIIlIllllIIlllIIII, lllllllllllIIIlIIlIllllIIlllIlIl - 0.5, lllllllllllIIIlIIlIllllIIllIlllI);
    }
    
    public static int getHealthColor(final float lllllllllllIIIlIIlIlllIllIIllIII, final float lllllllllllIIIlIIlIlllIllIIlIlll) {
        return Color.HSBtoRGB(Math.max(0.0f, Math.min(lllllllllllIIIlIIlIlllIllIIllIII, lllllllllllIIIlIIlIlllIllIIlIlll) / lllllllllllIIIlIIlIlllIllIIlIlll) / 3.0f, 1.0f, 0.8f) | 0xFF000000;
    }
    
    public static void drawEntityOnScreen(final double lllllllllllIIIlIIllIIIIIIIlIllII, final double lllllllllllIIIlIIllIIIIIIIllIlll, final double lllllllllllIIIlIIllIIIIIIIllIllI, final float lllllllllllIIIlIIllIIIIIIIlIlIIl, final float lllllllllllIIIlIIllIIIIIIIlIlIII, final EntityLivingBase lllllllllllIIIlIIllIIIIIIIllIIll) {
        GlStateManager.enableColorMaterial();
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)lllllllllllIIIlIIllIIIIIIIlIllII, (float)lllllllllllIIIlIIllIIIIIIIllIlll, 50.0f);
        GlStateManager.scale((float)(-lllllllllllIIIlIIllIIIIIIIllIllI), (float)lllllllllllIIIlIIllIIIIIIIllIllI, (float)lllllllllllIIIlIIllIIIIIIIllIllI);
        GlStateManager.rotate(180.0f, 0.0f, 0.0f, 1.0f);
        final float lllllllllllIIIlIIllIIIIIIIllIIlI = lllllllllllIIIlIIllIIIIIIIllIIll.renderYawOffset;
        final float lllllllllllIIIlIIllIIIIIIIllIIIl = lllllllllllIIIlIIllIIIIIIIllIIll.rotationYaw;
        final float lllllllllllIIIlIIllIIIIIIIllIIII = lllllllllllIIIlIIllIIIIIIIllIIll.rotationPitch;
        final float lllllllllllIIIlIIllIIIIIIIlIllll = lllllllllllIIIlIIllIIIIIIIllIIll.prevRotationYawHead;
        final float lllllllllllIIIlIIllIIIIIIIlIlllI = lllllllllllIIIlIIllIIIIIIIllIIll.rotationYawHead;
        GlStateManager.rotate(135.0f, 0.0f, 1.0f, 0.0f);
        RenderHelper.enableStandardItemLighting();
        GlStateManager.rotate(-135.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(-(float)Math.atan(lllllllllllIIIlIIllIIIIIIIlIlIII / 40.0f) * 20.0f, 1.0f, 0.0f, 0.0f);
        lllllllllllIIIlIIllIIIIIIIllIIll.renderYawOffset = (float)Math.atan(lllllllllllIIIlIIllIIIIIIIlIlIIl / 40.0f) * 20.0f;
        lllllllllllIIIlIIllIIIIIIIllIIll.rotationYaw = (float)Math.atan(lllllllllllIIIlIIllIIIIIIIlIlIIl / 40.0f) * 40.0f;
        lllllllllllIIIlIIllIIIIIIIllIIll.rotationPitch = -(float)Math.atan(lllllllllllIIIlIIllIIIIIIIlIlIII / 40.0f) * 20.0f;
        lllllllllllIIIlIIllIIIIIIIllIIll.rotationYawHead = lllllllllllIIIlIIllIIIIIIIllIIll.rotationYaw;
        lllllllllllIIIlIIllIIIIIIIllIIll.prevRotationYawHead = lllllllllllIIIlIIllIIIIIIIllIIll.rotationYaw;
        GlStateManager.translate(0.0f, 0.0f, 0.0f);
        final RenderManager lllllllllllIIIlIIllIIIIIIIlIllIl = Minecraft.getMinecraft().getRenderManager();
        lllllllllllIIIlIIllIIIIIIIlIllIl.setPlayerViewY(180.0f);
        lllllllllllIIIlIIllIIIIIIIlIllIl.setRenderShadow(false);
        lllllllllllIIIlIIllIIIIIIIlIllIl.doRenderEntity(lllllllllllIIIlIIllIIIIIIIllIIll, 0.0, 0.0, 0.0, 0.0f, 1.0f, false);
        lllllllllllIIIlIIllIIIIIIIlIllIl.setRenderShadow(true);
        lllllllllllIIIlIIllIIIIIIIllIIll.renderYawOffset = lllllllllllIIIlIIllIIIIIIIllIIlI;
        lllllllllllIIIlIIllIIIIIIIllIIll.rotationYaw = lllllllllllIIIlIIllIIIIIIIllIIIl;
        lllllllllllIIIlIIllIIIIIIIllIIll.rotationPitch = lllllllllllIIIlIIllIIIIIIIllIIII;
        lllllllllllIIIlIIllIIIIIIIllIIll.prevRotationYawHead = lllllllllllIIIlIIllIIIIIIIlIllll;
        lllllllllllIIIlIIllIIIIIIIllIIll.rotationYawHead = lllllllllllIIIlIIllIIIIIIIlIlllI;
        GlStateManager.popMatrix();
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableRescaleNormal();
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.disableTexture2D();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
    }
    
    public static void enableGL2D() {
        GL11.glDisable(2929);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glDepthMask(true);
        GL11.glEnable(2848);
        GL11.glHint(3154, 4354);
        GL11.glHint(3155, 4354);
    }
    
    public static int fadeColor(final int lllllllllllIIIlIIllIIIIlIIlIIIlI, final int lllllllllllIIIlIIllIIIIlIIlIIIIl, float lllllllllllIIIlIIllIIIIlIIIlllIl) {
        if (lllllllllllIIIlIIllIIIIlIIIlllIl > 1.0f) {
            lllllllllllIIIlIIllIIIIlIIIlllIl = 1.0f - lllllllllllIIIlIIllIIIIlIIIlllIl % 1.0f;
        }
        return fade(lllllllllllIIIlIIllIIIIlIIlIIIlI, lllllllllllIIIlIIllIIIIlIIlIIIIl, lllllllllllIIIlIIllIIIIlIIIlllIl);
    }
    
    public static void drawCircle3D(final Entity lllllllllllIIIlIIllIIIlIlIIIlIII, final double lllllllllllIIIlIIllIIIlIlIIlIIIl, final float lllllllllllIIIlIIllIIIlIlIIIIllI, final int lllllllllllIIIlIIllIIIlIlIIIIlIl, final float lllllllllllIIIlIIllIIIlIlIIIlllI, final int lllllllllllIIIlIIllIIIlIlIIIllIl) {
        GL11.glPushMatrix();
        GL11.glDisable(3553);
        GL11.glEnable(2848);
        GL11.glHint(3154, 4354);
        GL11.glDisable(2929);
        GL11.glLineWidth(lllllllllllIIIlIIllIIIlIlIIIlllI);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(2929);
        GL11.glBegin(3);
        final double n = lllllllllllIIIlIIllIIIlIlIIIlIII.lastTickPosX + (lllllllllllIIIlIIllIIIlIlIIIlIII.posX - lllllllllllIIIlIIllIIIlIlIIIlIII.lastTickPosX) * lllllllllllIIIlIIllIIIlIlIIIIllI;
        DrawHelper.mc.getRenderManager();
        final double lllllllllllIIIlIIllIIIlIlIIIllII = n - RenderManager.renderPosX;
        final double n2 = lllllllllllIIIlIIllIIIlIlIIIlIII.lastTickPosY + (lllllllllllIIIlIIllIIIlIlIIIlIII.posY - lllllllllllIIIlIIllIIIlIlIIIlIII.lastTickPosY) * lllllllllllIIIlIIllIIIlIlIIIIllI;
        DrawHelper.mc.getRenderManager();
        final double lllllllllllIIIlIIllIIIlIlIIIlIll = n2 - RenderManager.renderPosY;
        final double n3 = lllllllllllIIIlIIllIIIlIlIIIlIII.lastTickPosZ + (lllllllllllIIIlIIllIIIlIlIIIlIII.posZ - lllllllllllIIIlIIllIIIlIlIIIlIII.lastTickPosZ) * lllllllllllIIIlIIllIIIlIlIIIIllI;
        DrawHelper.mc.getRenderManager();
        final double lllllllllllIIIlIIllIIIlIlIIIlIlI = n3 - RenderManager.renderPosZ;
        setColor(lllllllllllIIIlIIllIIIlIlIIIllIl);
        for (int lllllllllllIIIlIIllIIIlIlIIIlIIl = 0; lllllllllllIIIlIIllIIIlIlIIIlIIl <= lllllllllllIIIlIIllIIIlIlIIIIlIl; ++lllllllllllIIIlIIllIIIlIlIIIlIIl) {
            GL11.glVertex3d(lllllllllllIIIlIIllIIIlIlIIIllII + lllllllllllIIIlIIllIIIlIlIIlIIIl * Math.cos(lllllllllllIIIlIIllIIIlIlIIIlIIl * 6.2831855f / lllllllllllIIIlIIllIIIlIlIIIIlIl), lllllllllllIIIlIIllIIIlIlIIIlIll, lllllllllllIIIlIIllIIIlIlIIIlIlI + lllllllllllIIIlIIllIIIlIlIIlIIIl * Math.sin(lllllllllllIIIlIIllIIIlIlIIIlIIl * 6.2831855f / lllllllllllIIIlIIllIIIlIlIIIIlIl));
        }
        GL11.glEnd();
        GL11.glDepthMask(true);
        GL11.glDisable(3042);
        GL11.glEnable(2929);
        GL11.glDisable(2848);
        GL11.glEnable(2929);
        GL11.glEnable(3553);
        GL11.glPopMatrix();
    }
    
    public static void enableGL2D3() {
        GL11.glDisable(2929);
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glDepthMask(true);
        GL11.glEnable(2848);
        GL11.glHint(3154, 4354);
        GL11.glHint(3155, 4354);
    }
    
    public static void startSmooth() {
        GL11.glEnable(2848);
        GL11.glEnable(2881);
        GL11.glEnable(2832);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glHint(3154, 4354);
        GL11.glHint(3155, 4354);
        GL11.glHint(3153, 4354);
    }
    
    public static void prepareScissorBox(final float lllllllllllIIIlIIlIllllIIllIIlll, final float lllllllllllIIIlIIlIllllIIllIIllI, final float lllllllllllIIIlIIlIllllIIlIlllll, final float lllllllllllIIIlIIlIllllIIlIllllI) {
        final ScaledResolution lllllllllllIIIlIIlIllllIIllIIIll = new ScaledResolution(Minecraft.getMinecraft());
        final int lllllllllllIIIlIIlIllllIIllIIIlI = ScaledResolution.getScaleFactor();
        GL11.glScissor((int)(lllllllllllIIIlIIlIllllIIllIIlll * lllllllllllIIIlIIlIllllIIllIIIlI), (int)((lllllllllllIIIlIIlIllllIIllIIIll.getScaledHeight() - lllllllllllIIIlIIlIllllIIlIllllI) * lllllllllllIIIlIIlIllllIIllIIIlI), (int)((lllllllllllIIIlIIlIllllIIlIlllll - lllllllllllIIIlIIlIllllIIllIIlll) * lllllllllllIIIlIIlIllllIIllIIIlI), (int)((lllllllllllIIIlIIlIllllIIlIllllI - lllllllllllIIIlIIlIllllIIllIIllI) * lllllllllllIIIlIIlIllllIIllIIIlI));
    }
    
    public static void renderItem(final ItemStack lllllllllllIIIlIIlIllllIlIIIllll, final int lllllllllllIIIlIIlIllllIlIIIlllI, final int lllllllllllIIIlIIlIllllIlIIIllIl) {
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.enableDepth();
        RenderHelper.enableGUIStandardItemLighting();
        Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(lllllllllllIIIlIIlIllllIlIIIllll, lllllllllllIIIlIIlIllllIlIIIlllI, lllllllllllIIIlIIlIllllIlIIIllIl);
        final RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
        Minecraft.getMinecraft();
        renderItem.renderItemOverlays(Minecraft.fontRendererObj, lllllllllllIIIlIIlIllllIlIIIllll, lllllllllllIIIlIIlIllllIlIIIlllI, lllllllllllIIIlIIlIllllIlIIIllIl);
        RenderHelper.disableStandardItemLighting();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.disableDepth();
    }
    
    public static void drawRect2(final double lllllllllllIIIlIIllIIIIIlIlIIlIl, final double lllllllllllIIIlIIllIIIIIlIlIIlII, final double lllllllllllIIIlIIllIIIIIlIIllllI, final double lllllllllllIIIlIIllIIIIIlIIlllIl, final int lllllllllllIIIlIIllIIIIIlIIlllII) {
        drawRect(lllllllllllIIIlIIllIIIIIlIlIIlIl, lllllllllllIIIlIIllIIIIIlIlIIlII, lllllllllllIIIlIIllIIIIIlIlIIlIl + lllllllllllIIIlIIllIIIIIlIIllllI, lllllllllllIIIlIIllIIIIIlIlIIlII + lllllllllllIIIlIIllIIIIIlIIlllIl, lllllllllllIIIlIIllIIIIIlIIlllII);
    }
    
    public static void drawGradientRect(final double lllllllllllIIIlIIlIllllIIlIIlIll, final double lllllllllllIIIlIIlIllllIIlIIlIlI, final double lllllllllllIIIlIIlIllllIIIlllIIl, final double lllllllllllIIIlIIlIllllIIIlllIII, final int lllllllllllIIIlIIlIllllIIIllIlll, final int lllllllllllIIIlIIlIllllIIIllIllI) {
        final float lllllllllllIIIlIIlIllllIIlIIIlIl = (lllllllllllIIIlIIlIllllIIIllIlll >> 24 & 0xFF) / 255.0f;
        final float lllllllllllIIIlIIlIllllIIlIIIlII = (lllllllllllIIIlIIlIllllIIIllIlll >> 16 & 0xFF) / 255.0f;
        final float lllllllllllIIIlIIlIllllIIlIIIIll = (lllllllllllIIIlIIlIllllIIIllIlll >> 8 & 0xFF) / 255.0f;
        final float lllllllllllIIIlIIlIllllIIlIIIIlI = (lllllllllllIIIlIIlIllllIIIllIlll & 0xFF) / 255.0f;
        final float lllllllllllIIIlIIlIllllIIlIIIIIl = (lllllllllllIIIlIIlIllllIIIllIllI >> 24 & 0xFF) / 255.0f;
        final float lllllllllllIIIlIIlIllllIIlIIIIII = (lllllllllllIIIlIIlIllllIIIllIllI >> 16 & 0xFF) / 255.0f;
        final float lllllllllllIIIlIIlIllllIIIllllll = (lllllllllllIIIlIIlIllllIIIllIllI >> 8 & 0xFF) / 255.0f;
        final float lllllllllllIIIlIIlIllllIIIlllllI = (lllllllllllIIIlIIlIllllIIIllIllI & 0xFF) / 255.0f;
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.shadeModel(7425);
        final Tessellator lllllllllllIIIlIIlIllllIIIllllIl = Tessellator.getInstance();
        final BufferBuilder lllllllllllIIIlIIlIllllIIIllllII = lllllllllllIIIlIIlIllllIIIllllIl.getBuffer();
        lllllllllllIIIlIIlIllllIIIllllII.begin(7, DefaultVertexFormats.POSITION_COLOR);
        lllllllllllIIIlIIlIllllIIIllllII.pos(lllllllllllIIIlIIlIllllIIIlllIIl, lllllllllllIIIlIIlIllllIIlIIlIlI, DrawHelper.zLevel).color(lllllllllllIIIlIIlIllllIIlIIIlII, lllllllllllIIIlIIlIllllIIlIIIIll, lllllllllllIIIlIIlIllllIIlIIIIlI, lllllllllllIIIlIIlIllllIIlIIIlIl).endVertex();
        lllllllllllIIIlIIlIllllIIIllllII.pos(lllllllllllIIIlIIlIllllIIlIIlIll, lllllllllllIIIlIIlIllllIIlIIlIlI, DrawHelper.zLevel).color(lllllllllllIIIlIIlIllllIIlIIIlII, lllllllllllIIIlIIlIllllIIlIIIIll, lllllllllllIIIlIIlIllllIIlIIIIlI, lllllllllllIIIlIIlIllllIIlIIIlIl).endVertex();
        lllllllllllIIIlIIlIllllIIIllllII.pos(lllllllllllIIIlIIlIllllIIlIIlIll, lllllllllllIIIlIIlIllllIIIlllIII, DrawHelper.zLevel).color(lllllllllllIIIlIIlIllllIIlIIIIII, lllllllllllIIIlIIlIllllIIIllllll, lllllllllllIIIlIIlIllllIIIlllllI, lllllllllllIIIlIIlIllllIIlIIIIIl).endVertex();
        lllllllllllIIIlIIlIllllIIIllllII.pos(lllllllllllIIIlIIlIllllIIIlllIIl, lllllllllllIIIlIIlIllllIIIlllIII, DrawHelper.zLevel).color(lllllllllllIIIlIIlIllllIIlIIIIII, lllllllllllIIIlIIlIllllIIIllllll, lllllllllllIIIlIIlIllllIIIlllllI, lllllllllllIIIlIIlIllllIIlIIIIIl).endVertex();
        lllllllllllIIIlIIlIllllIIIllllIl.draw();
        GlStateManager.shadeModel(7424);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
    }
    
    public static void drawSmoothRect1(final float lllllllllllIIIlIIllIIIIlIlllIIll, final float lllllllllllIIIlIIllIIIIlIllIllIl, final float lllllllllllIIIlIIllIIIIlIlllIIIl, final float lllllllllllIIIlIIllIIIIlIllIlIll, final int lllllllllllIIIlIIllIIIIlIllIlIlI) {
        GL11.glEnable(3042);
        GL11.glEnable(2848);
        drawRect(lllllllllllIIIlIIllIIIIlIlllIIll, lllllllllllIIIlIIllIIIIlIllIllIl, lllllllllllIIIlIIllIIIIlIlllIIIl, lllllllllllIIIlIIllIIIIlIllIlIll, lllllllllllIIIlIIllIIIIlIllIlIlI);
        GL11.glScalef(0.5f, 0.5f, 0.5f);
        drawRect(lllllllllllIIIlIIllIIIIlIlllIIll * 2.0f - 1.0f, lllllllllllIIIlIIllIIIIlIllIllIl * 2.0f, lllllllllllIIIlIIllIIIIlIlllIIll * 2.0f, lllllllllllIIIlIIllIIIIlIllIlIll * 2.0f - 1.0f, lllllllllllIIIlIIllIIIIlIllIlIlI);
        drawRect(lllllllllllIIIlIIllIIIIlIlllIIll * 2.0f, lllllllllllIIIlIIllIIIIlIllIllIl * 2.0f - 1.0f, lllllllllllIIIlIIllIIIIlIlllIIIl * 2.0f, lllllllllllIIIlIIllIIIIlIllIllIl * 2.0f, lllllllllllIIIlIIllIIIIlIllIlIlI);
        drawRect(lllllllllllIIIlIIllIIIIlIlllIIIl * 2.0f, lllllllllllIIIlIIllIIIIlIllIllIl * 2.0f, lllllllllllIIIlIIllIIIIlIlllIIIl * 2.0f + 1.0f, lllllllllllIIIlIIllIIIIlIllIlIll * 2.0f - 1.0f, lllllllllllIIIlIIllIIIIlIllIlIlI);
        drawRect(lllllllllllIIIlIIllIIIIlIlllIIll * 2.0f, lllllllllllIIIlIIllIIIIlIllIlIll * 2.0f - 1.0f, lllllllllllIIIlIIllIIIIlIlllIIIl * 2.0f, lllllllllllIIIlIIllIIIIlIllIlIll * 2.0f, lllllllllllIIIlIIllIIIIlIllIlIlI);
        GL11.glDisable(2848);
        GL11.glDisable(3042);
        GL11.glScalef(2.0f, 2.0f, 2.0f);
    }
    
    public static int toRGBA(final float lllllllllllIIIlIIlIlllIlIIllIlII, final float lllllllllllIIIlIIlIlllIlIIllIIll, final float lllllllllllIIIlIIlIlllIlIIllIIlI, final float lllllllllllIIIlIIlIlllIlIIllIIIl) {
        return toRGBA((int)(lllllllllllIIIlIIlIlllIlIIllIlII * 255.0f), (int)(lllllllllllIIIlIIlIlllIlIIllIIll * 255.0f), (int)(lllllllllllIIIlIIlIlllIlIIllIIlI * 255.0f), (int)(lllllllllllIIIlIIlIlllIlIIllIIIl * 255.0f));
    }
    
    public static void drawRoundedRect(final float lllllllllllIIIlIIlIllllIllIlIIIl, final float lllllllllllIIIlIIlIllllIllIlIIII, final float lllllllllllIIIlIIlIllllIllIlIlIl, final float lllllllllllIIIlIIlIllllIllIIlllI, final int lllllllllllIIIlIIlIllllIllIIllIl, final Color lllllllllllIIIlIIlIllllIllIlIIlI) {
        Gui.drawRect((int)lllllllllllIIIlIIlIllllIllIlIIIl + lllllllllllIIIlIIlIllllIllIIllIl, (int)lllllllllllIIIlIIlIllllIllIlIIII, (int)lllllllllllIIIlIIlIllllIllIlIlIl - lllllllllllIIIlIIlIllllIllIIllIl, (int)lllllllllllIIIlIIlIllllIllIIlllI, lllllllllllIIIlIIlIllllIllIlIIlI.getRGB());
        Gui.drawRect((int)lllllllllllIIIlIIlIllllIllIlIIIl, (int)lllllllllllIIIlIIlIllllIllIlIIII + lllllllllllIIIlIIlIllllIllIIllIl, (int)lllllllllllIIIlIIlIllllIllIlIlIl, (int)lllllllllllIIIlIIlIllllIllIIlllI - lllllllllllIIIlIIlIllllIllIIllIl, lllllllllllIIIlIIlIllllIllIlIIlI.getRGB());
        drawFilledCircle((int)lllllllllllIIIlIIlIllllIllIlIIIl + lllllllllllIIIlIIlIllllIllIIllIl, (int)lllllllllllIIIlIIlIllllIllIlIIII + lllllllllllIIIlIIlIllllIllIIllIl, (float)lllllllllllIIIlIIlIllllIllIIllIl, lllllllllllIIIlIIlIllllIllIlIIlI);
        drawFilledCircle((int)lllllllllllIIIlIIlIllllIllIlIlIl - lllllllllllIIIlIIlIllllIllIIllIl, (int)lllllllllllIIIlIIlIllllIllIlIIII + lllllllllllIIIlIIlIllllIllIIllIl, (float)lllllllllllIIIlIIlIllllIllIIllIl, lllllllllllIIIlIIlIllllIllIlIIlI);
        drawFilledCircle((int)lllllllllllIIIlIIlIllllIllIlIlIl - lllllllllllIIIlIIlIllllIllIIllIl, (int)lllllllllllIIIlIIlIllllIllIIlllI - lllllllllllIIIlIIlIllllIllIIllIl, (float)lllllllllllIIIlIIlIllllIllIIllIl, lllllllllllIIIlIIlIllllIllIlIIlI);
        drawFilledCircle((int)lllllllllllIIIlIIlIllllIllIlIIIl + lllllllllllIIIlIIlIllllIllIIllIl, (int)lllllllllllIIIlIIlIllllIllIIlllI - lllllllllllIIIlIIlIllllIllIIllIl, (float)lllllllllllIIIlIIlIllllIllIIllIl, lllllllllllIIIlIIlIllllIllIlIIlI);
    }
    
    public static void glColor(final Color lllllllllllIIIlIIllIIIIIllIllllI, final int lllllllllllIIIlIIllIIIIIllIllIll) {
        glColor(lllllllllllIIIlIIllIIIIIllIllllI, lllllllllllIIIlIIllIIIIIllIllIll / 255.0f);
    }
    
    public static class Colors
    {
        static {
            RAINBOW = Integer.MIN_VALUE;
            WHITE = DrawHelper.toRGBA(255, 255, 255, 255);
            BLACK = DrawHelper.toRGBA(0, 0, 0, 255);
            RED = DrawHelper.toRGBA(255, 0, 0, 255);
            GREEN = DrawHelper.toRGBA(0, 255, 0, 255);
            BLUE = DrawHelper.toRGBA(0, 0, 255, 255);
            ORANGE = DrawHelper.toRGBA(255, 128, 0, 255);
            PURPLE = DrawHelper.toRGBA(163, 73, 163, 255);
            GRAY = DrawHelper.toRGBA(127, 127, 127, 255);
            DARK_RED = DrawHelper.toRGBA(64, 0, 0, 255);
            YELLOW = DrawHelper.toRGBA(255, 255, 0, 255);
        }
    }
}
