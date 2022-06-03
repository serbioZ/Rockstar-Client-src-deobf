// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.tileentity;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.GlStateManager;
import shadersmod.client.Shaders;
import optifine.Config;
import java.util.List;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tileentity.TileEntityBeacon;

public class TileEntityBeaconRenderer extends TileEntitySpecialRenderer<TileEntityBeacon>
{
    public static final /* synthetic */ ResourceLocation TEXTURE_BEACON_BEAM;
    
    static {
        TEXTURE_BEACON_BEAM = new ResourceLocation("textures/entity/beacon_beam.png");
    }
    
    @Override
    public void func_192841_a(final TileEntityBeacon llllllllllllIllIIIIllllIIIlllIII, final double llllllllllllIllIIIIllllIIIllIlll, final double llllllllllllIllIIIIllllIIIllIllI, final double llllllllllllIllIIIIllllIIIlIllIl, final float llllllllllllIllIIIIllllIIIllIlII, final int llllllllllllIllIIIIllllIIIllIIll, final float llllllllllllIllIIIIllllIIIllIIlI) {
        this.renderBeacon(llllllllllllIllIIIIllllIIIllIlll, llllllllllllIllIIIIllllIIIllIllI, llllllllllllIllIIIIllllIIIlIllIl, llllllllllllIllIIIIllllIIIllIlII, llllllllllllIllIIIIllllIIIlllIII.shouldBeamRender(), llllllllllllIllIIIIllllIIIlllIII.getBeamSegments(), (double)llllllllllllIllIIIIllllIIIlllIII.getWorld().getTotalWorldTime());
    }
    
    public void renderBeacon(final double llllllllllllIllIIIIllllIIIIlllll, final double llllllllllllIllIIIIllllIIIIlIIlI, final double llllllllllllIllIIIIllllIIIIlIIIl, final double llllllllllllIllIIIIllllIIIIlIIII, final double llllllllllllIllIIIIllllIIIIIllll, final List<TileEntityBeacon.BeamSegment> llllllllllllIllIIIIllllIIIIllIlI, final double llllllllllllIllIIIIllllIIIIllIIl) {
        if (llllllllllllIllIIIIllllIIIIIllll > 0.0 && llllllllllllIllIIIIllllIIIIllIlI.size() > 0) {
            if (Config.isShaders()) {
                Shaders.beginBeacon();
            }
            GlStateManager.alphaFunc(516, 0.1f);
            this.bindTexture(TileEntityBeaconRenderer.TEXTURE_BEACON_BEAM);
            if (llllllllllllIllIIIIllllIIIIIllll > 0.0) {
                GlStateManager.disableFog();
                int llllllllllllIllIIIIllllIIIIllIII = 0;
                for (int llllllllllllIllIIIIllllIIIIlIlll = 0; llllllllllllIllIIIIllllIIIIlIlll < llllllllllllIllIIIIllllIIIIllIlI.size(); ++llllllllllllIllIIIIllllIIIIlIlll) {
                    final TileEntityBeacon.BeamSegment llllllllllllIllIIIIllllIIIIlIllI = llllllllllllIllIIIIllllIIIIllIlI.get(llllllllllllIllIIIIllllIIIIlIlll);
                    renderBeamSegment(llllllllllllIllIIIIllllIIIIlllll, llllllllllllIllIIIIllllIIIIlIIlI, llllllllllllIllIIIIllllIIIIlIIIl, llllllllllllIllIIIIllllIIIIlIIII, llllllllllllIllIIIIllllIIIIIllll, llllllllllllIllIIIIllllIIIIllIIl, llllllllllllIllIIIIllllIIIIllIII, llllllllllllIllIIIIllllIIIIlIllI.getHeight(), llllllllllllIllIIIIllllIIIIlIllI.getColors());
                    llllllllllllIllIIIIllllIIIIllIII += llllllllllllIllIIIIllllIIIIlIllI.getHeight();
                }
                GlStateManager.enableFog();
            }
            if (Config.isShaders()) {
                Shaders.endBeacon();
            }
        }
    }
    
    @Override
    public boolean isGlobalRenderer(final TileEntityBeacon llllllllllllIllIIIIlllIllIIIlIll) {
        return true;
    }
    
    public static void renderBeamSegment(final double llllllllllllIllIIIIlllIllIlIllIl, final double llllllllllllIllIIIIlllIllIlIllII, final double llllllllllllIllIIIIlllIlllIIllII, final double llllllllllllIllIIIIlllIlllIIlIll, final double llllllllllllIllIIIIlllIllIlIlIIl, final double llllllllllllIllIIIIlllIlllIIlIIl, final int llllllllllllIllIIIIlllIlllIIlIII, final int llllllllllllIllIIIIlllIlllIIIlll, final float[] llllllllllllIllIIIIlllIlllIIIllI, final double llllllllllllIllIIIIlllIlllIIIlIl, final double llllllllllllIllIIIIlllIllIlIIIll) {
        final int llllllllllllIllIIIIlllIlllIIIIll = llllllllllllIllIIIIlllIlllIIlIII + llllllllllllIllIIIIlllIlllIIIlll;
        GlStateManager.glTexParameteri(3553, 10242, 10497);
        GlStateManager.glTexParameteri(3553, 10243, 10497);
        GlStateManager.disableLighting();
        GlStateManager.disableCull();
        GlStateManager.disableBlend();
        GlStateManager.depthMask(true);
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        final Tessellator llllllllllllIllIIIIlllIlllIIIIlI = Tessellator.getInstance();
        final BufferBuilder llllllllllllIllIIIIlllIlllIIIIIl = llllllllllllIllIIIIlllIlllIIIIlI.getBuffer();
        final double llllllllllllIllIIIIlllIlllIIIIII = llllllllllllIllIIIIlllIlllIIlIIl + llllllllllllIllIIIIlllIlllIIlIll;
        final double llllllllllllIllIIIIlllIllIllllll = (llllllllllllIllIIIIlllIlllIIIlll < 0) ? llllllllllllIllIIIIlllIlllIIIIII : (-llllllllllllIllIIIIlllIlllIIIIII);
        final double llllllllllllIllIIIIlllIllIlllllI = MathHelper.frac(llllllllllllIllIIIIlllIllIllllll * 0.2 - MathHelper.floor(llllllllllllIllIIIIlllIllIllllll * 0.1));
        final float llllllllllllIllIIIIlllIllIllllIl = llllllllllllIllIIIIlllIlllIIIllI[0];
        final float llllllllllllIllIIIIlllIllIllllII = llllllllllllIllIIIIlllIlllIIIllI[1];
        final float llllllllllllIllIIIIlllIllIlllIll = llllllllllllIllIIIIlllIlllIIIllI[2];
        double llllllllllllIllIIIIlllIllIlllIlI = llllllllllllIllIIIIlllIlllIIIIII * 0.025 * -1.5;
        double llllllllllllIllIIIIlllIllIlllIIl = 0.5 + Math.cos(llllllllllllIllIIIIlllIllIlllIlI + 2.356194490192345) * llllllllllllIllIIIIlllIlllIIIlIl;
        double llllllllllllIllIIIIlllIllIlllIII = 0.5 + Math.sin(llllllllllllIllIIIIlllIllIlllIlI + 2.356194490192345) * llllllllllllIllIIIIlllIlllIIIlIl;
        double llllllllllllIllIIIIlllIllIllIlll = 0.5 + Math.cos(llllllllllllIllIIIIlllIllIlllIlI + 0.7853981633974483) * llllllllllllIllIIIIlllIlllIIIlIl;
        double llllllllllllIllIIIIlllIllIllIllI = 0.5 + Math.sin(llllllllllllIllIIIIlllIllIlllIlI + 0.7853981633974483) * llllllllllllIllIIIIlllIlllIIIlIl;
        double llllllllllllIllIIIIlllIllIllIlIl = 0.5 + Math.cos(llllllllllllIllIIIIlllIllIlllIlI + 3.9269908169872414) * llllllllllllIllIIIIlllIlllIIIlIl;
        double llllllllllllIllIIIIlllIllIllIlII = 0.5 + Math.sin(llllllllllllIllIIIIlllIllIlllIlI + 3.9269908169872414) * llllllllllllIllIIIIlllIlllIIIlIl;
        double llllllllllllIllIIIIlllIllIllIIll = 0.5 + Math.cos(llllllllllllIllIIIIlllIllIlllIlI + 5.497787143782138) * llllllllllllIllIIIIlllIlllIIIlIl;
        double llllllllllllIllIIIIlllIllIllIIlI = 0.5 + Math.sin(llllllllllllIllIIIIlllIllIlllIlI + 5.497787143782138) * llllllllllllIllIIIIlllIlllIIIlIl;
        double llllllllllllIllIIIIlllIllIllIIIl = 0.0;
        double llllllllllllIllIIIIlllIllIllIIII = 1.0;
        double llllllllllllIllIIIIlllIllIlIllll = -1.0 + llllllllllllIllIIIIlllIllIlllllI;
        final double llllllllllllIllIIIIlllIllIlIlllI = llllllllllllIllIIIIlllIlllIIIlll * llllllllllllIllIIIIlllIllIlIlIIl * (0.5 / llllllllllllIllIIIIlllIlllIIIlIl) + llllllllllllIllIIIIlllIllIlIllll;
        llllllllllllIllIIIIlllIlllIIIIIl.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
        llllllllllllIllIIIIlllIlllIIIIIl.pos(llllllllllllIllIIIIlllIllIlIllIl + llllllllllllIllIIIIlllIllIlllIIl, llllllllllllIllIIIIlllIllIlIllII + llllllllllllIllIIIIlllIlllIIIIll, llllllllllllIllIIIIlllIlllIIllII + llllllllllllIllIIIIlllIllIlllIII).tex(1.0, llllllllllllIllIIIIlllIllIlIlllI).color(llllllllllllIllIIIIlllIllIllllIl, llllllllllllIllIIIIlllIllIllllII, llllllllllllIllIIIIlllIllIlllIll, 1.0f).endVertex();
        llllllllllllIllIIIIlllIlllIIIIIl.pos(llllllllllllIllIIIIlllIllIlIllIl + llllllllllllIllIIIIlllIllIlllIIl, llllllllllllIllIIIIlllIllIlIllII + llllllllllllIllIIIIlllIlllIIlIII, llllllllllllIllIIIIlllIlllIIllII + llllllllllllIllIIIIlllIllIlllIII).tex(1.0, llllllllllllIllIIIIlllIllIlIllll).color(llllllllllllIllIIIIlllIllIllllIl, llllllllllllIllIIIIlllIllIllllII, llllllllllllIllIIIIlllIllIlllIll, 1.0f).endVertex();
        llllllllllllIllIIIIlllIlllIIIIIl.pos(llllllllllllIllIIIIlllIllIlIllIl + llllllllllllIllIIIIlllIllIllIlll, llllllllllllIllIIIIlllIllIlIllII + llllllllllllIllIIIIlllIlllIIlIII, llllllllllllIllIIIIlllIlllIIllII + llllllllllllIllIIIIlllIllIllIllI).tex(0.0, llllllllllllIllIIIIlllIllIlIllll).color(llllllllllllIllIIIIlllIllIllllIl, llllllllllllIllIIIIlllIllIllllII, llllllllllllIllIIIIlllIllIlllIll, 1.0f).endVertex();
        llllllllllllIllIIIIlllIlllIIIIIl.pos(llllllllllllIllIIIIlllIllIlIllIl + llllllllllllIllIIIIlllIllIllIlll, llllllllllllIllIIIIlllIllIlIllII + llllllllllllIllIIIIlllIlllIIIIll, llllllllllllIllIIIIlllIlllIIllII + llllllllllllIllIIIIlllIllIllIllI).tex(0.0, llllllllllllIllIIIIlllIllIlIlllI).color(llllllllllllIllIIIIlllIllIllllIl, llllllllllllIllIIIIlllIllIllllII, llllllllllllIllIIIIlllIllIlllIll, 1.0f).endVertex();
        llllllllllllIllIIIIlllIlllIIIIIl.pos(llllllllllllIllIIIIlllIllIlIllIl + llllllllllllIllIIIIlllIllIllIIll, llllllllllllIllIIIIlllIllIlIllII + llllllllllllIllIIIIlllIlllIIIIll, llllllllllllIllIIIIlllIlllIIllII + llllllllllllIllIIIIlllIllIllIIlI).tex(1.0, llllllllllllIllIIIIlllIllIlIlllI).color(llllllllllllIllIIIIlllIllIllllIl, llllllllllllIllIIIIlllIllIllllII, llllllllllllIllIIIIlllIllIlllIll, 1.0f).endVertex();
        llllllllllllIllIIIIlllIlllIIIIIl.pos(llllllllllllIllIIIIlllIllIlIllIl + llllllllllllIllIIIIlllIllIllIIll, llllllllllllIllIIIIlllIllIlIllII + llllllllllllIllIIIIlllIlllIIlIII, llllllllllllIllIIIIlllIlllIIllII + llllllllllllIllIIIIlllIllIllIIlI).tex(1.0, llllllllllllIllIIIIlllIllIlIllll).color(llllllllllllIllIIIIlllIllIllllIl, llllllllllllIllIIIIlllIllIllllII, llllllllllllIllIIIIlllIllIlllIll, 1.0f).endVertex();
        llllllllllllIllIIIIlllIlllIIIIIl.pos(llllllllllllIllIIIIlllIllIlIllIl + llllllllllllIllIIIIlllIllIllIlIl, llllllllllllIllIIIIlllIllIlIllII + llllllllllllIllIIIIlllIlllIIlIII, llllllllllllIllIIIIlllIlllIIllII + llllllllllllIllIIIIlllIllIllIlII).tex(0.0, llllllllllllIllIIIIlllIllIlIllll).color(llllllllllllIllIIIIlllIllIllllIl, llllllllllllIllIIIIlllIllIllllII, llllllllllllIllIIIIlllIllIlllIll, 1.0f).endVertex();
        llllllllllllIllIIIIlllIlllIIIIIl.pos(llllllllllllIllIIIIlllIllIlIllIl + llllllllllllIllIIIIlllIllIllIlIl, llllllllllllIllIIIIlllIllIlIllII + llllllllllllIllIIIIlllIlllIIIIll, llllllllllllIllIIIIlllIlllIIllII + llllllllllllIllIIIIlllIllIllIlII).tex(0.0, llllllllllllIllIIIIlllIllIlIlllI).color(llllllllllllIllIIIIlllIllIllllIl, llllllllllllIllIIIIlllIllIllllII, llllllllllllIllIIIIlllIllIlllIll, 1.0f).endVertex();
        llllllllllllIllIIIIlllIlllIIIIIl.pos(llllllllllllIllIIIIlllIllIlIllIl + llllllllllllIllIIIIlllIllIllIlll, llllllllllllIllIIIIlllIllIlIllII + llllllllllllIllIIIIlllIlllIIIIll, llllllllllllIllIIIIlllIlllIIllII + llllllllllllIllIIIIlllIllIllIllI).tex(1.0, llllllllllllIllIIIIlllIllIlIlllI).color(llllllllllllIllIIIIlllIllIllllIl, llllllllllllIllIIIIlllIllIllllII, llllllllllllIllIIIIlllIllIlllIll, 1.0f).endVertex();
        llllllllllllIllIIIIlllIlllIIIIIl.pos(llllllllllllIllIIIIlllIllIlIllIl + llllllllllllIllIIIIlllIllIllIlll, llllllllllllIllIIIIlllIllIlIllII + llllllllllllIllIIIIlllIlllIIlIII, llllllllllllIllIIIIlllIlllIIllII + llllllllllllIllIIIIlllIllIllIllI).tex(1.0, llllllllllllIllIIIIlllIllIlIllll).color(llllllllllllIllIIIIlllIllIllllIl, llllllllllllIllIIIIlllIllIllllII, llllllllllllIllIIIIlllIllIlllIll, 1.0f).endVertex();
        llllllllllllIllIIIIlllIlllIIIIIl.pos(llllllllllllIllIIIIlllIllIlIllIl + llllllllllllIllIIIIlllIllIllIIll, llllllllllllIllIIIIlllIllIlIllII + llllllllllllIllIIIIlllIlllIIlIII, llllllllllllIllIIIIlllIlllIIllII + llllllllllllIllIIIIlllIllIllIIlI).tex(0.0, llllllllllllIllIIIIlllIllIlIllll).color(llllllllllllIllIIIIlllIllIllllIl, llllllllllllIllIIIIlllIllIllllII, llllllllllllIllIIIIlllIllIlllIll, 1.0f).endVertex();
        llllllllllllIllIIIIlllIlllIIIIIl.pos(llllllllllllIllIIIIlllIllIlIllIl + llllllllllllIllIIIIlllIllIllIIll, llllllllllllIllIIIIlllIllIlIllII + llllllllllllIllIIIIlllIlllIIIIll, llllllllllllIllIIIIlllIlllIIllII + llllllllllllIllIIIIlllIllIllIIlI).tex(0.0, llllllllllllIllIIIIlllIllIlIlllI).color(llllllllllllIllIIIIlllIllIllllIl, llllllllllllIllIIIIlllIllIllllII, llllllllllllIllIIIIlllIllIlllIll, 1.0f).endVertex();
        llllllllllllIllIIIIlllIlllIIIIIl.pos(llllllllllllIllIIIIlllIllIlIllIl + llllllllllllIllIIIIlllIllIllIlIl, llllllllllllIllIIIIlllIllIlIllII + llllllllllllIllIIIIlllIlllIIIIll, llllllllllllIllIIIIlllIlllIIllII + llllllllllllIllIIIIlllIllIllIlII).tex(1.0, llllllllllllIllIIIIlllIllIlIlllI).color(llllllllllllIllIIIIlllIllIllllIl, llllllllllllIllIIIIlllIllIllllII, llllllllllllIllIIIIlllIllIlllIll, 1.0f).endVertex();
        llllllllllllIllIIIIlllIlllIIIIIl.pos(llllllllllllIllIIIIlllIllIlIllIl + llllllllllllIllIIIIlllIllIllIlIl, llllllllllllIllIIIIlllIllIlIllII + llllllllllllIllIIIIlllIlllIIlIII, llllllllllllIllIIIIlllIlllIIllII + llllllllllllIllIIIIlllIllIllIlII).tex(1.0, llllllllllllIllIIIIlllIllIlIllll).color(llllllllllllIllIIIIlllIllIllllIl, llllllllllllIllIIIIlllIllIllllII, llllllllllllIllIIIIlllIllIlllIll, 1.0f).endVertex();
        llllllllllllIllIIIIlllIlllIIIIIl.pos(llllllllllllIllIIIIlllIllIlIllIl + llllllllllllIllIIIIlllIllIlllIIl, llllllllllllIllIIIIlllIllIlIllII + llllllllllllIllIIIIlllIlllIIlIII, llllllllllllIllIIIIlllIlllIIllII + llllllllllllIllIIIIlllIllIlllIII).tex(0.0, llllllllllllIllIIIIlllIllIlIllll).color(llllllllllllIllIIIIlllIllIllllIl, llllllllllllIllIIIIlllIllIllllII, llllllllllllIllIIIIlllIllIlllIll, 1.0f).endVertex();
        llllllllllllIllIIIIlllIlllIIIIIl.pos(llllllllllllIllIIIIlllIllIlIllIl + llllllllllllIllIIIIlllIllIlllIIl, llllllllllllIllIIIIlllIllIlIllII + llllllllllllIllIIIIlllIlllIIIIll, llllllllllllIllIIIIlllIlllIIllII + llllllllllllIllIIIIlllIllIlllIII).tex(0.0, llllllllllllIllIIIIlllIllIlIlllI).color(llllllllllllIllIIIIlllIllIllllIl, llllllllllllIllIIIIlllIllIllllII, llllllllllllIllIIIIlllIllIlllIll, 1.0f).endVertex();
        llllllllllllIllIIIIlllIlllIIIIlI.draw();
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.depthMask(false);
        llllllllllllIllIIIIlllIllIlllIlI = 0.5 - llllllllllllIllIIIIlllIllIlIIIll;
        llllllllllllIllIIIIlllIllIlllIIl = 0.5 - llllllllllllIllIIIIlllIllIlIIIll;
        llllllllllllIllIIIIlllIllIlllIII = 0.5 + llllllllllllIllIIIIlllIllIlIIIll;
        llllllllllllIllIIIIlllIllIllIlll = 0.5 - llllllllllllIllIIIIlllIllIlIIIll;
        llllllllllllIllIIIIlllIllIllIllI = 0.5 - llllllllllllIllIIIIlllIllIlIIIll;
        llllllllllllIllIIIIlllIllIllIlIl = 0.5 + llllllllllllIllIIIIlllIllIlIIIll;
        llllllllllllIllIIIIlllIllIllIlII = 0.5 + llllllllllllIllIIIIlllIllIlIIIll;
        llllllllllllIllIIIIlllIllIllIIll = 0.5 + llllllllllllIllIIIIlllIllIlIIIll;
        llllllllllllIllIIIIlllIllIllIIlI = 0.0;
        llllllllllllIllIIIIlllIllIllIIIl = 1.0;
        llllllllllllIllIIIIlllIllIllIIII = -1.0 + llllllllllllIllIIIIlllIllIlllllI;
        llllllllllllIllIIIIlllIllIlIllll = llllllllllllIllIIIIlllIlllIIIlll * llllllllllllIllIIIIlllIllIlIlIIl + llllllllllllIllIIIIlllIllIllIIII;
        llllllllllllIllIIIIlllIlllIIIIIl.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
        llllllllllllIllIIIIlllIlllIIIIIl.pos(llllllllllllIllIIIIlllIllIlIllIl + llllllllllllIllIIIIlllIllIlllIlI, llllllllllllIllIIIIlllIllIlIllII + llllllllllllIllIIIIlllIlllIIIIll, llllllllllllIllIIIIlllIlllIIllII + llllllllllllIllIIIIlllIllIlllIIl).tex(1.0, llllllllllllIllIIIIlllIllIlIllll).color(llllllllllllIllIIIIlllIllIllllIl, llllllllllllIllIIIIlllIllIllllII, llllllllllllIllIIIIlllIllIlllIll, 0.125f).endVertex();
        llllllllllllIllIIIIlllIlllIIIIIl.pos(llllllllllllIllIIIIlllIllIlIllIl + llllllllllllIllIIIIlllIllIlllIlI, llllllllllllIllIIIIlllIllIlIllII + llllllllllllIllIIIIlllIlllIIlIII, llllllllllllIllIIIIlllIlllIIllII + llllllllllllIllIIIIlllIllIlllIIl).tex(1.0, llllllllllllIllIIIIlllIllIllIIII).color(llllllllllllIllIIIIlllIllIllllIl, llllllllllllIllIIIIlllIllIllllII, llllllllllllIllIIIIlllIllIlllIll, 0.125f).endVertex();
        llllllllllllIllIIIIlllIlllIIIIIl.pos(llllllllllllIllIIIIlllIllIlIllIl + llllllllllllIllIIIIlllIllIlllIII, llllllllllllIllIIIIlllIllIlIllII + llllllllllllIllIIIIlllIlllIIlIII, llllllllllllIllIIIIlllIlllIIllII + llllllllllllIllIIIIlllIllIllIlll).tex(0.0, llllllllllllIllIIIIlllIllIllIIII).color(llllllllllllIllIIIIlllIllIllllIl, llllllllllllIllIIIIlllIllIllllII, llllllllllllIllIIIIlllIllIlllIll, 0.125f).endVertex();
        llllllllllllIllIIIIlllIlllIIIIIl.pos(llllllllllllIllIIIIlllIllIlIllIl + llllllllllllIllIIIIlllIllIlllIII, llllllllllllIllIIIIlllIllIlIllII + llllllllllllIllIIIIlllIlllIIIIll, llllllllllllIllIIIIlllIlllIIllII + llllllllllllIllIIIIlllIllIllIlll).tex(0.0, llllllllllllIllIIIIlllIllIlIllll).color(llllllllllllIllIIIIlllIllIllllIl, llllllllllllIllIIIIlllIllIllllII, llllllllllllIllIIIIlllIllIlllIll, 0.125f).endVertex();
        llllllllllllIllIIIIlllIlllIIIIIl.pos(llllllllllllIllIIIIlllIllIlIllIl + llllllllllllIllIIIIlllIllIllIlII, llllllllllllIllIIIIlllIllIlIllII + llllllllllllIllIIIIlllIlllIIIIll, llllllllllllIllIIIIlllIlllIIllII + llllllllllllIllIIIIlllIllIllIIll).tex(1.0, llllllllllllIllIIIIlllIllIlIllll).color(llllllllllllIllIIIIlllIllIllllIl, llllllllllllIllIIIIlllIllIllllII, llllllllllllIllIIIIlllIllIlllIll, 0.125f).endVertex();
        llllllllllllIllIIIIlllIlllIIIIIl.pos(llllllllllllIllIIIIlllIllIlIllIl + llllllllllllIllIIIIlllIllIllIlII, llllllllllllIllIIIIlllIllIlIllII + llllllllllllIllIIIIlllIlllIIlIII, llllllllllllIllIIIIlllIlllIIllII + llllllllllllIllIIIIlllIllIllIIll).tex(1.0, llllllllllllIllIIIIlllIllIllIIII).color(llllllllllllIllIIIIlllIllIllllIl, llllllllllllIllIIIIlllIllIllllII, llllllllllllIllIIIIlllIllIlllIll, 0.125f).endVertex();
        llllllllllllIllIIIIlllIlllIIIIIl.pos(llllllllllllIllIIIIlllIllIlIllIl + llllllllllllIllIIIIlllIllIllIllI, llllllllllllIllIIIIlllIllIlIllII + llllllllllllIllIIIIlllIlllIIlIII, llllllllllllIllIIIIlllIlllIIllII + llllllllllllIllIIIIlllIllIllIlIl).tex(0.0, llllllllllllIllIIIIlllIllIllIIII).color(llllllllllllIllIIIIlllIllIllllIl, llllllllllllIllIIIIlllIllIllllII, llllllllllllIllIIIIlllIllIlllIll, 0.125f).endVertex();
        llllllllllllIllIIIIlllIlllIIIIIl.pos(llllllllllllIllIIIIlllIllIlIllIl + llllllllllllIllIIIIlllIllIllIllI, llllllllllllIllIIIIlllIllIlIllII + llllllllllllIllIIIIlllIlllIIIIll, llllllllllllIllIIIIlllIlllIIllII + llllllllllllIllIIIIlllIllIllIlIl).tex(0.0, llllllllllllIllIIIIlllIllIlIllll).color(llllllllllllIllIIIIlllIllIllllIl, llllllllllllIllIIIIlllIllIllllII, llllllllllllIllIIIIlllIllIlllIll, 0.125f).endVertex();
        llllllllllllIllIIIIlllIlllIIIIIl.pos(llllllllllllIllIIIIlllIllIlIllIl + llllllllllllIllIIIIlllIllIlllIII, llllllllllllIllIIIIlllIllIlIllII + llllllllllllIllIIIIlllIlllIIIIll, llllllllllllIllIIIIlllIlllIIllII + llllllllllllIllIIIIlllIllIllIlll).tex(1.0, llllllllllllIllIIIIlllIllIlIllll).color(llllllllllllIllIIIIlllIllIllllIl, llllllllllllIllIIIIlllIllIllllII, llllllllllllIllIIIIlllIllIlllIll, 0.125f).endVertex();
        llllllllllllIllIIIIlllIlllIIIIIl.pos(llllllllllllIllIIIIlllIllIlIllIl + llllllllllllIllIIIIlllIllIlllIII, llllllllllllIllIIIIlllIllIlIllII + llllllllllllIllIIIIlllIlllIIlIII, llllllllllllIllIIIIlllIlllIIllII + llllllllllllIllIIIIlllIllIllIlll).tex(1.0, llllllllllllIllIIIIlllIllIllIIII).color(llllllllllllIllIIIIlllIllIllllIl, llllllllllllIllIIIIlllIllIllllII, llllllllllllIllIIIIlllIllIlllIll, 0.125f).endVertex();
        llllllllllllIllIIIIlllIlllIIIIIl.pos(llllllllllllIllIIIIlllIllIlIllIl + llllllllllllIllIIIIlllIllIllIlII, llllllllllllIllIIIIlllIllIlIllII + llllllllllllIllIIIIlllIlllIIlIII, llllllllllllIllIIIIlllIlllIIllII + llllllllllllIllIIIIlllIllIllIIll).tex(0.0, llllllllllllIllIIIIlllIllIllIIII).color(llllllllllllIllIIIIlllIllIllllIl, llllllllllllIllIIIIlllIllIllllII, llllllllllllIllIIIIlllIllIlllIll, 0.125f).endVertex();
        llllllllllllIllIIIIlllIlllIIIIIl.pos(llllllllllllIllIIIIlllIllIlIllIl + llllllllllllIllIIIIlllIllIllIlII, llllllllllllIllIIIIlllIllIlIllII + llllllllllllIllIIIIlllIlllIIIIll, llllllllllllIllIIIIlllIlllIIllII + llllllllllllIllIIIIlllIllIllIIll).tex(0.0, llllllllllllIllIIIIlllIllIlIllll).color(llllllllllllIllIIIIlllIllIllllIl, llllllllllllIllIIIIlllIllIllllII, llllllllllllIllIIIIlllIllIlllIll, 0.125f).endVertex();
        llllllllllllIllIIIIlllIlllIIIIIl.pos(llllllllllllIllIIIIlllIllIlIllIl + llllllllllllIllIIIIlllIllIllIllI, llllllllllllIllIIIIlllIllIlIllII + llllllllllllIllIIIIlllIlllIIIIll, llllllllllllIllIIIIlllIlllIIllII + llllllllllllIllIIIIlllIllIllIlIl).tex(1.0, llllllllllllIllIIIIlllIllIlIllll).color(llllllllllllIllIIIIlllIllIllllIl, llllllllllllIllIIIIlllIllIllllII, llllllllllllIllIIIIlllIllIlllIll, 0.125f).endVertex();
        llllllllllllIllIIIIlllIlllIIIIIl.pos(llllllllllllIllIIIIlllIllIlIllIl + llllllllllllIllIIIIlllIllIllIllI, llllllllllllIllIIIIlllIllIlIllII + llllllllllllIllIIIIlllIlllIIlIII, llllllllllllIllIIIIlllIlllIIllII + llllllllllllIllIIIIlllIllIllIlIl).tex(1.0, llllllllllllIllIIIIlllIllIllIIII).color(llllllllllllIllIIIIlllIllIllllIl, llllllllllllIllIIIIlllIllIllllII, llllllllllllIllIIIIlllIllIlllIll, 0.125f).endVertex();
        llllllllllllIllIIIIlllIlllIIIIIl.pos(llllllllllllIllIIIIlllIllIlIllIl + llllllllllllIllIIIIlllIllIlllIlI, llllllllllllIllIIIIlllIllIlIllII + llllllllllllIllIIIIlllIlllIIlIII, llllllllllllIllIIIIlllIlllIIllII + llllllllllllIllIIIIlllIllIlllIIl).tex(0.0, llllllllllllIllIIIIlllIllIllIIII).color(llllllllllllIllIIIIlllIllIllllIl, llllllllllllIllIIIIlllIllIllllII, llllllllllllIllIIIIlllIllIlllIll, 0.125f).endVertex();
        llllllllllllIllIIIIlllIlllIIIIIl.pos(llllllllllllIllIIIIlllIllIlIllIl + llllllllllllIllIIIIlllIllIlllIlI, llllllllllllIllIIIIlllIllIlIllII + llllllllllllIllIIIIlllIlllIIIIll, llllllllllllIllIIIIlllIlllIIllII + llllllllllllIllIIIIlllIllIlllIIl).tex(0.0, llllllllllllIllIIIIlllIllIlIllll).color(llllllllllllIllIIIIlllIllIllllIl, llllllllllllIllIIIIlllIllIllllII, llllllllllllIllIIIIlllIllIlllIll, 0.125f).endVertex();
        llllllllllllIllIIIIlllIlllIIIIlI.draw();
        GlStateManager.enableLighting();
        GlStateManager.enableTexture2D();
        GlStateManager.depthMask(true);
    }
    
    public static void renderBeamSegment(final double llllllllllllIllIIIIllllIIIIIIIIl, final double llllllllllllIllIIIIlllIlllllIlll, final double llllllllllllIllIIIIlllIlllllIllI, final double llllllllllllIllIIIIlllIllllllllI, final double llllllllllllIllIIIIlllIlllllllIl, final double llllllllllllIllIIIIlllIlllllllII, final int llllllllllllIllIIIIlllIllllllIll, final int llllllllllllIllIIIIlllIllllllIlI, final float[] llllllllllllIllIIIIlllIlllllIIII) {
        renderBeamSegment(llllllllllllIllIIIIllllIIIIIIIIl, llllllllllllIllIIIIlllIlllllIlll, llllllllllllIllIIIIlllIlllllIllI, llllllllllllIllIIIIlllIllllllllI, llllllllllllIllIIIIlllIlllllllIl, llllllllllllIllIIIIlllIlllllllII, llllllllllllIllIIIIlllIllllllIll, llllllllllllIllIIIIlllIllllllIlI, llllllllllllIllIIIIlllIlllllIIII, 0.2, 0.25);
    }
}
