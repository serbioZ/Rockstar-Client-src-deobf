// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.entity.EntityLiving;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.entity.layers.LayerEnderDragonDeath;
import net.minecraft.client.renderer.entity.layers.LayerEnderDragonEyes;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelDragon;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.boss.EntityDragon;

public class RenderDragon extends RenderLiving<EntityDragon>
{
    private static final /* synthetic */ ResourceLocation DRAGON_TEXTURES;
    public static final /* synthetic */ ResourceLocation ENDERCRYSTAL_BEAM_TEXTURES;
    private static final /* synthetic */ ResourceLocation DRAGON_EXPLODING_TEXTURES;
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityDragon lllllllllllIlIIIIIIlIIlIlllllllI) {
        return RenderDragon.DRAGON_TEXTURES;
    }
    
    @Override
    protected void renderModel(final EntityDragon lllllllllllIlIIIIIIlIIllIlllIIll, final float lllllllllllIlIIIIIIlIIllIlllIIlI, final float lllllllllllIlIIIIIIlIIllIlllIIIl, final float lllllllllllIlIIIIIIlIIllIllIIlll, final float lllllllllllIlIIIIIIlIIllIllIllll, final float lllllllllllIlIIIIIIlIIllIllIlllI, final float lllllllllllIlIIIIIIlIIllIllIIlII) {
        if (lllllllllllIlIIIIIIlIIllIlllIIll.deathTicks > 0) {
            final float lllllllllllIlIIIIIIlIIllIllIllII = lllllllllllIlIIIIIIlIIllIlllIIll.deathTicks / 200.0f;
            GlStateManager.depthFunc(515);
            GlStateManager.enableAlpha();
            GlStateManager.alphaFunc(516, lllllllllllIlIIIIIIlIIllIllIllII);
            this.bindTexture(RenderDragon.DRAGON_EXPLODING_TEXTURES);
            this.mainModel.render(lllllllllllIlIIIIIIlIIllIlllIIll, lllllllllllIlIIIIIIlIIllIlllIIlI, lllllllllllIlIIIIIIlIIllIlllIIIl, lllllllllllIlIIIIIIlIIllIllIIlll, lllllllllllIlIIIIIIlIIllIllIllll, lllllllllllIlIIIIIIlIIllIllIlllI, lllllllllllIlIIIIIIlIIllIllIIlII);
            GlStateManager.alphaFunc(516, 0.1f);
            GlStateManager.depthFunc(514);
        }
        this.bindEntityTexture(lllllllllllIlIIIIIIlIIllIlllIIll);
        this.mainModel.render(lllllllllllIlIIIIIIlIIllIlllIIll, lllllllllllIlIIIIIIlIIllIlllIIlI, lllllllllllIlIIIIIIlIIllIlllIIIl, lllllllllllIlIIIIIIlIIllIllIIlll, lllllllllllIlIIIIIIlIIllIllIllll, lllllllllllIlIIIIIIlIIllIllIlllI, lllllllllllIlIIIIIIlIIllIllIIlII);
        if (lllllllllllIlIIIIIIlIIllIlllIIll.hurtTime > 0) {
            GlStateManager.depthFunc(514);
            GlStateManager.disableTexture2D();
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
            GlStateManager.color(1.0f, 0.0f, 0.0f, 0.5f);
            this.mainModel.render(lllllllllllIlIIIIIIlIIllIlllIIll, lllllllllllIlIIIIIIlIIllIlllIIlI, lllllllllllIlIIIIIIlIIllIlllIIIl, lllllllllllIlIIIIIIlIIllIllIIlll, lllllllllllIlIIIIIIlIIllIllIllll, lllllllllllIlIIIIIIlIIllIllIlllI, lllllllllllIlIIIIIIlIIllIllIIlII);
            GlStateManager.enableTexture2D();
            GlStateManager.disableBlend();
            GlStateManager.depthFunc(515);
        }
    }
    
    public RenderDragon(final RenderManager lllllllllllIlIIIIIIlIIlllIIlIIlI) {
        super(lllllllllllIlIIIIIIlIIlllIIlIIlI, new ModelDragon(0.0f), 0.5f);
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerEnderDragonEyes(this));
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerEnderDragonDeath());
    }
    
    @Override
    public void doRender(final EntityDragon lllllllllllIlIIIIIIlIIllIlIlIIIl, final double lllllllllllIlIIIIIIlIIllIlIlIIII, final double lllllllllllIlIIIIIIlIIllIlIIllll, final double lllllllllllIlIIIIIIlIIllIlIIlllI, final float lllllllllllIlIIIIIIlIIllIlIIllIl, final float lllllllllllIlIIIIIIlIIllIlIIllII) {
        super.doRender(lllllllllllIlIIIIIIlIIllIlIlIIIl, lllllllllllIlIIIIIIlIIllIlIlIIII, lllllllllllIlIIIIIIlIIllIlIIllll, lllllllllllIlIIIIIIlIIllIlIIlllI, lllllllllllIlIIIIIIlIIllIlIIllIl, lllllllllllIlIIIIIIlIIllIlIIllII);
        if (lllllllllllIlIIIIIIlIIllIlIlIIIl.healingEnderCrystal != null) {
            this.bindTexture(RenderDragon.ENDERCRYSTAL_BEAM_TEXTURES);
            float lllllllllllIlIIIIIIlIIllIlIlIIll = MathHelper.sin((lllllllllllIlIIIIIIlIIllIlIlIIIl.healingEnderCrystal.ticksExisted + lllllllllllIlIIIIIIlIIllIlIIllII) * 0.2f) / 2.0f + 0.5f;
            lllllllllllIlIIIIIIlIIllIlIlIIll = (lllllllllllIlIIIIIIlIIllIlIlIIll * lllllllllllIlIIIIIIlIIllIlIlIIll + lllllllllllIlIIIIIIlIIllIlIlIIll) * 0.2f;
            renderCrystalBeams(lllllllllllIlIIIIIIlIIllIlIlIIII, lllllllllllIlIIIIIIlIIllIlIIllll, lllllllllllIlIIIIIIlIIllIlIIlllI, lllllllllllIlIIIIIIlIIllIlIIllII, lllllllllllIlIIIIIIlIIllIlIlIIIl.posX + (lllllllllllIlIIIIIIlIIllIlIlIIIl.prevPosX - lllllllllllIlIIIIIIlIIllIlIlIIIl.posX) * (1.0f - lllllllllllIlIIIIIIlIIllIlIIllII), lllllllllllIlIIIIIIlIIllIlIlIIIl.posY + (lllllllllllIlIIIIIIlIIllIlIlIIIl.prevPosY - lllllllllllIlIIIIIIlIIllIlIlIIIl.posY) * (1.0f - lllllllllllIlIIIIIIlIIllIlIIllII), lllllllllllIlIIIIIIlIIllIlIlIIIl.posZ + (lllllllllllIlIIIIIIlIIllIlIlIIIl.prevPosZ - lllllllllllIlIIIIIIlIIllIlIlIIIl.posZ) * (1.0f - lllllllllllIlIIIIIIlIIllIlIIllII), lllllllllllIlIIIIIIlIIllIlIlIIIl.ticksExisted, lllllllllllIlIIIIIIlIIllIlIlIIIl.healingEnderCrystal.posX, lllllllllllIlIIIIIIlIIllIlIlIIll + lllllllllllIlIIIIIIlIIllIlIlIIIl.healingEnderCrystal.posY, lllllllllllIlIIIIIIlIIllIlIlIIIl.healingEnderCrystal.posZ);
        }
    }
    
    public static void renderCrystalBeams(final double lllllllllllIlIIIIIIlIIllIIllIIIl, final double lllllllllllIlIIIIIIlIIllIIllIIII, final double lllllllllllIlIIIIIIlIIllIIlIllll, final float lllllllllllIlIIIIIIlIIllIIlIlllI, final double lllllllllllIlIIIIIIlIIllIIIlIlII, final double lllllllllllIlIIIIIIlIIllIIlIllII, final double lllllllllllIlIIIIIIlIIllIIlIlIll, final int lllllllllllIlIIIIIIlIIllIIIlIIIl, final double lllllllllllIlIIIIIIlIIllIIlIlIIl, final double lllllllllllIlIIIIIIlIIllIIIIllll, final double lllllllllllIlIIIIIIlIIllIIIIlllI) {
        final float lllllllllllIlIIIIIIlIIllIIlIIllI = (float)(lllllllllllIlIIIIIIlIIllIIlIlIIl - lllllllllllIlIIIIIIlIIllIIIlIlII);
        final float lllllllllllIlIIIIIIlIIllIIlIIlIl = (float)(lllllllllllIlIIIIIIlIIllIIIIllll - 1.0 - lllllllllllIlIIIIIIlIIllIIlIllII);
        final float lllllllllllIlIIIIIIlIIllIIlIIlII = (float)(lllllllllllIlIIIIIIlIIllIIIIlllI - lllllllllllIlIIIIIIlIIllIIlIlIll);
        final float lllllllllllIlIIIIIIlIIllIIlIIIll = MathHelper.sqrt(lllllllllllIlIIIIIIlIIllIIlIIllI * lllllllllllIlIIIIIIlIIllIIlIIllI + lllllllllllIlIIIIIIlIIllIIlIIlII * lllllllllllIlIIIIIIlIIllIIlIIlII);
        final float lllllllllllIlIIIIIIlIIllIIlIIIlI = MathHelper.sqrt(lllllllllllIlIIIIIIlIIllIIlIIllI * lllllllllllIlIIIIIIlIIllIIlIIllI + lllllllllllIlIIIIIIlIIllIIlIIlIl * lllllllllllIlIIIIIIlIIllIIlIIlIl + lllllllllllIlIIIIIIlIIllIIlIIlII * lllllllllllIlIIIIIIlIIllIIlIIlII);
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)lllllllllllIlIIIIIIlIIllIIllIIIl, (float)lllllllllllIlIIIIIIlIIllIIllIIII + 2.0f, (float)lllllllllllIlIIIIIIlIIllIIlIllll);
        GlStateManager.rotate((float)(-Math.atan2(lllllllllllIlIIIIIIlIIllIIlIIlII, lllllllllllIlIIIIIIlIIllIIlIIllI)) * 57.295776f - 90.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate((float)(-Math.atan2(lllllllllllIlIIIIIIlIIllIIlIIIll, lllllllllllIlIIIIIIlIIllIIlIIlIl)) * 57.295776f - 90.0f, 1.0f, 0.0f, 0.0f);
        final Tessellator lllllllllllIlIIIIIIlIIllIIlIIIIl = Tessellator.getInstance();
        final BufferBuilder lllllllllllIlIIIIIIlIIllIIlIIIII = lllllllllllIlIIIIIIlIIllIIlIIIIl.getBuffer();
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableCull();
        GlStateManager.shadeModel(7425);
        final float lllllllllllIlIIIIIIlIIllIIIlllll = 0.0f - (lllllllllllIlIIIIIIlIIllIIIlIIIl + lllllllllllIlIIIIIIlIIllIIlIlllI) * 0.01f;
        final float lllllllllllIlIIIIIIlIIllIIIllllI = MathHelper.sqrt(lllllllllllIlIIIIIIlIIllIIlIIllI * lllllllllllIlIIIIIIlIIllIIlIIllI + lllllllllllIlIIIIIIlIIllIIlIIlIl * lllllllllllIlIIIIIIlIIllIIlIIlIl + lllllllllllIlIIIIIIlIIllIIlIIlII * lllllllllllIlIIIIIIlIIllIIlIIlII) / 32.0f - (lllllllllllIlIIIIIIlIIllIIIlIIIl + lllllllllllIlIIIIIIlIIllIIlIlllI) * 0.01f;
        lllllllllllIlIIIIIIlIIllIIlIIIII.begin(5, DefaultVertexFormats.POSITION_TEX_COLOR);
        final int lllllllllllIlIIIIIIlIIllIIIlllIl = 8;
        for (int lllllllllllIlIIIIIIlIIllIIIlllII = 0; lllllllllllIlIIIIIIlIIllIIIlllII <= 8; ++lllllllllllIlIIIIIIlIIllIIIlllII) {
            final float lllllllllllIlIIIIIIlIIllIIIllIll = MathHelper.sin(lllllllllllIlIIIIIIlIIllIIIlllII % 8 * 6.2831855f / 8.0f) * 0.75f;
            final float lllllllllllIlIIIIIIlIIllIIIllIlI = MathHelper.cos(lllllllllllIlIIIIIIlIIllIIIlllII % 8 * 6.2831855f / 8.0f) * 0.75f;
            final float lllllllllllIlIIIIIIlIIllIIIllIIl = lllllllllllIlIIIIIIlIIllIIIlllII % 8 / 8.0f;
            lllllllllllIlIIIIIIlIIllIIlIIIII.pos(lllllllllllIlIIIIIIlIIllIIIllIll * 0.2f, lllllllllllIlIIIIIIlIIllIIIllIlI * 0.2f, 0.0).tex(lllllllllllIlIIIIIIlIIllIIIllIIl, lllllllllllIlIIIIIIlIIllIIIlllll).color(0, 0, 0, 255).endVertex();
            lllllllllllIlIIIIIIlIIllIIlIIIII.pos(lllllllllllIlIIIIIIlIIllIIIllIll, lllllllllllIlIIIIIIlIIllIIIllIlI, lllllllllllIlIIIIIIlIIllIIlIIIlI).tex(lllllllllllIlIIIIIIlIIllIIIllIIl, lllllllllllIlIIIIIIlIIllIIIllllI).color(255, 255, 255, 255).endVertex();
        }
        lllllllllllIlIIIIIIlIIllIIlIIIIl.draw();
        GlStateManager.enableCull();
        GlStateManager.shadeModel(7424);
        RenderHelper.enableStandardItemLighting();
        GlStateManager.popMatrix();
    }
    
    static {
        ENDERCRYSTAL_BEAM_TEXTURES = new ResourceLocation("textures/entity/endercrystal/endercrystal_beam.png");
        DRAGON_EXPLODING_TEXTURES = new ResourceLocation("textures/entity/enderdragon/dragon_exploding.png");
        DRAGON_TEXTURES = new ResourceLocation("textures/entity/enderdragon/dragon.png");
    }
    
    @Override
    protected void rotateCorpse(final EntityDragon lllllllllllIlIIIIIIlIIlllIIIlIlI, final float lllllllllllIlIIIIIIlIIlllIIIlIIl, final float lllllllllllIlIIIIIIlIIlllIIIlIII, final float lllllllllllIlIIIIIIlIIlllIIIIIIl) {
        final float lllllllllllIlIIIIIIlIIlllIIIIllI = (float)lllllllllllIlIIIIIIlIIlllIIIlIlI.getMovementOffsets(7, lllllllllllIlIIIIIIlIIlllIIIIIIl)[0];
        final float lllllllllllIlIIIIIIlIIlllIIIIlIl = (float)(lllllllllllIlIIIIIIlIIlllIIIlIlI.getMovementOffsets(5, lllllllllllIlIIIIIIlIIlllIIIIIIl)[1] - lllllllllllIlIIIIIIlIIlllIIIlIlI.getMovementOffsets(10, lllllllllllIlIIIIIIlIIlllIIIIIIl)[1]);
        GlStateManager.rotate(-lllllllllllIlIIIIIIlIIlllIIIIllI, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(lllllllllllIlIIIIIIlIIlllIIIIlIl * 10.0f, 1.0f, 0.0f, 0.0f);
        GlStateManager.translate(0.0f, 0.0f, 1.0f);
        if (lllllllllllIlIIIIIIlIIlllIIIlIlI.deathTime > 0) {
            float lllllllllllIlIIIIIIlIIlllIIIIlII = (lllllllllllIlIIIIIIlIIlllIIIlIlI.deathTime + lllllllllllIlIIIIIIlIIlllIIIIIIl - 1.0f) / 20.0f * 1.6f;
            lllllllllllIlIIIIIIlIIlllIIIIlII = MathHelper.sqrt(lllllllllllIlIIIIIIlIIlllIIIIlII);
            if (lllllllllllIlIIIIIIlIIlllIIIIlII > 1.0f) {
                lllllllllllIlIIIIIIlIIlllIIIIlII = 1.0f;
            }
            GlStateManager.rotate(lllllllllllIlIIIIIIlIIlllIIIIlII * this.getDeathMaxRotation(lllllllllllIlIIIIIIlIIlllIIIlIlI), 0.0f, 0.0f, 1.0f);
        }
    }
}
