// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerWolfCollar;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelWolf;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.passive.EntityWolf;

public class RenderWolf extends RenderLiving<EntityWolf>
{
    private static final /* synthetic */ ResourceLocation ANRGY_WOLF_TEXTURES;
    private static final /* synthetic */ ResourceLocation TAMED_WOLF_TEXTURES;
    private static final /* synthetic */ ResourceLocation WOLF_TEXTURES;
    
    @Override
    protected float handleRotationFloat(final EntityWolf lllllllllllIllIIIlIIIIlIlIIlIIIl, final float lllllllllllIllIIIlIIIIlIlIIlIIlI) {
        return lllllllllllIllIIIlIIIIlIlIIlIIIl.getTailRotation();
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityWolf lllllllllllIllIIIlIIIIlIIlllIllI) {
        if (lllllllllllIllIIIlIIIIlIIlllIllI.isTamed()) {
            return RenderWolf.TAMED_WOLF_TEXTURES;
        }
        return lllllllllllIllIIIlIIIIlIIlllIllI.isAngry() ? RenderWolf.ANRGY_WOLF_TEXTURES : RenderWolf.WOLF_TEXTURES;
    }
    
    @Override
    public void doRender(final EntityWolf lllllllllllIllIIIlIIIIlIIlllllll, final double lllllllllllIllIIIlIIIIlIlIIIIllI, final double lllllllllllIllIIIlIIIIlIlIIIIlIl, final double lllllllllllIllIIIlIIIIlIIlllllII, final float lllllllllllIllIIIlIIIIlIlIIIIIll, final float lllllllllllIllIIIlIIIIlIlIIIIIlI) {
        if (lllllllllllIllIIIlIIIIlIIlllllll.isWolfWet()) {
            final float lllllllllllIllIIIlIIIIlIlIIIIIIl = lllllllllllIllIIIlIIIIlIIlllllll.getBrightness() * lllllllllllIllIIIlIIIIlIIlllllll.getShadingWhileWet(lllllllllllIllIIIlIIIIlIlIIIIIlI);
            GlStateManager.color(lllllllllllIllIIIlIIIIlIlIIIIIIl, lllllllllllIllIIIlIIIIlIlIIIIIIl, lllllllllllIllIIIlIIIIlIlIIIIIIl);
        }
        super.doRender(lllllllllllIllIIIlIIIIlIIlllllll, lllllllllllIllIIIlIIIIlIlIIIIllI, lllllllllllIllIIIlIIIIlIlIIIIlIl, lllllllllllIllIIIlIIIIlIIlllllII, lllllllllllIllIIIlIIIIlIlIIIIIll, lllllllllllIllIIIlIIIIlIlIIIIIlI);
    }
    
    public RenderWolf(final RenderManager lllllllllllIllIIIlIIIIlIlIIlIllI) {
        super(lllllllllllIllIIIlIIIIlIlIIlIllI, new ModelWolf(), 0.5f);
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerWolfCollar(this));
    }
    
    static {
        WOLF_TEXTURES = new ResourceLocation("textures/entity/wolf/wolf.png");
        TAMED_WOLF_TEXTURES = new ResourceLocation("textures/entity/wolf/wolf_tame.png");
        ANRGY_WOLF_TEXTURES = new ResourceLocation("textures/entity/wolf/wolf_angry.png");
    }
}
