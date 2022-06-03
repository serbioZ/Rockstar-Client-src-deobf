// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.util.EnumHandSide;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelIllager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.monster.EntityIllusionIllager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.monster.EntityMob;

public class RenderIllusionIllager extends RenderLiving<EntityMob>
{
    private static final /* synthetic */ ResourceLocation field_193121_a;
    
    @Override
    public void doRender(final EntityMob lllllllllllIlIIIIllllIlIlIllIIII, final double lllllllllllIlIIIIllllIlIlIlIllll, final double lllllllllllIlIIIIllllIlIlIlIIlII, final double lllllllllllIlIIIIllllIlIlIlIIIll, final float lllllllllllIlIIIIllllIlIlIlIIIlI, final float lllllllllllIlIIIIllllIlIlIlIlIll) {
        if (lllllllllllIlIIIIllllIlIlIllIIII.isInvisible()) {
            final Vec3d[] lllllllllllIlIIIIllllIlIlIlIlIlI = ((EntityIllusionIllager)lllllllllllIlIIIIllllIlIlIllIIII).func_193098_a(lllllllllllIlIIIIllllIlIlIlIlIll);
            final float lllllllllllIlIIIIllllIlIlIlIlIIl = this.handleRotationFloat(lllllllllllIlIIIIllllIlIlIllIIII, lllllllllllIlIIIIllllIlIlIlIlIll);
            for (int lllllllllllIlIIIIllllIlIlIlIlIII = 0; lllllllllllIlIIIIllllIlIlIlIlIII < lllllllllllIlIIIIllllIlIlIlIlIlI.length; ++lllllllllllIlIIIIllllIlIlIlIlIII) {
                super.doRender(lllllllllllIlIIIIllllIlIlIllIIII, lllllllllllIlIIIIllllIlIlIlIllll + lllllllllllIlIIIIllllIlIlIlIlIlI[lllllllllllIlIIIIllllIlIlIlIlIII].xCoord + MathHelper.cos(lllllllllllIlIIIIllllIlIlIlIlIII + lllllllllllIlIIIIllllIlIlIlIlIIl * 0.5f) * 0.025, lllllllllllIlIIIIllllIlIlIlIIlII + lllllllllllIlIIIIllllIlIlIlIlIlI[lllllllllllIlIIIIllllIlIlIlIlIII].yCoord + MathHelper.cos(lllllllllllIlIIIIllllIlIlIlIlIII + lllllllllllIlIIIIllllIlIlIlIlIIl * 0.75f) * 0.0125, lllllllllllIlIIIIllllIlIlIlIIIll + lllllllllllIlIIIIllllIlIlIlIlIlI[lllllllllllIlIIIIllllIlIlIlIlIII].zCoord + MathHelper.cos(lllllllllllIlIIIIllllIlIlIlIlIII + lllllllllllIlIIIIllllIlIlIlIlIIl * 0.7f) * 0.025, lllllllllllIlIIIIllllIlIlIlIIIlI, lllllllllllIlIIIIllllIlIlIlIlIll);
            }
        }
        else {
            super.doRender(lllllllllllIlIIIIllllIlIlIllIIII, lllllllllllIlIIIIllllIlIlIlIllll, lllllllllllIlIIIIllllIlIlIlIIlII, lllllllllllIlIIIIllllIlIlIlIIIll, lllllllllllIlIIIIllllIlIlIlIIIlI, lllllllllllIlIIIIllllIlIlIlIlIll);
        }
    }
    
    @Override
    protected boolean func_193115_c(final EntityMob lllllllllllIlIIIIllllIlIlIIIllIl) {
        return true;
    }
    
    static {
        field_193121_a = new ResourceLocation("textures/entity/illager/illusionist.png");
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityMob lllllllllllIlIIIIllllIlIllIIIIlI) {
        return RenderIllusionIllager.field_193121_a;
    }
    
    @Override
    protected void preRenderCallback(final EntityMob lllllllllllIlIIIIllllIlIlIllllll, final float lllllllllllIlIIIIllllIlIlIlllllI) {
        final float lllllllllllIlIIIIllllIlIlIllllIl = 0.9375f;
        GlStateManager.scale(0.9375f, 0.9375f, 0.9375f);
    }
    
    @Override
    public void renderName(final EntityMob lllllllllllIlIIIIllllIlIlIIlIIlI, final double lllllllllllIlIIIIllllIlIlIIlIllI, final double lllllllllllIlIIIIllllIlIlIIlIIII, final double lllllllllllIlIIIIllllIlIlIIlIlII) {
        super.renderName(lllllllllllIlIIIIllllIlIlIIlIIlI, lllllllllllIlIIIIllllIlIlIIlIllI, lllllllllllIlIIIIllllIlIlIIlIIII, lllllllllllIlIIIIllllIlIlIIlIlII);
    }
    
    public RenderIllusionIllager(final RenderManager lllllllllllIlIIIIllllIlIllIIIllI) {
        super(lllllllllllIlIIIIllllIlIllIIIllI, new ModelIllager(0.0f, 0.0f, 64, 64), 0.5f);
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerHeldItem(this) {
            @Override
            protected void func_191361_a(final EnumHandSide lllllllllllIllIllIIIlIllIlllIlIl) {
                ((ModelIllager)this.livingEntityRenderer.getMainModel()).func_191216_a(lllllllllllIllIllIIIlIllIlllIlIl).postRender(0.0625f);
            }
            
            @Override
            public void doRenderLayer(final EntityLivingBase lllllllllllIllIllIIIlIlllIIIIIII, final float lllllllllllIllIllIIIlIllIlllllll, final float lllllllllllIllIllIIIlIllIllllllI, final float lllllllllllIllIllIIIlIllIlllllIl, final float lllllllllllIllIllIIIlIllIlllllII, final float lllllllllllIllIllIIIlIlllIIIIlII, final float lllllllllllIllIllIIIlIlllIIIIIll, final float lllllllllllIllIllIIIlIlllIIIIIlI) {
                if (((EntityIllusionIllager)lllllllllllIllIllIIIlIlllIIIIIII).func_193082_dl() || ((EntityIllusionIllager)lllllllllllIllIllIIIlIlllIIIIIII).func_193096_dj()) {
                    super.doRenderLayer(lllllllllllIllIllIIIlIlllIIIIIII, lllllllllllIllIllIIIlIllIlllllll, lllllllllllIllIllIIIlIllIllllllI, lllllllllllIllIllIIIlIllIlllllIl, lllllllllllIllIllIIIlIllIlllllII, lllllllllllIllIllIIIlIlllIIIIlII, lllllllllllIllIllIIIlIlllIIIIIll, lllllllllllIllIllIIIlIlllIIIIIlI);
                }
            }
        });
        ((ModelIllager)this.getMainModel()).field_193775_b.showModel = true;
    }
}
