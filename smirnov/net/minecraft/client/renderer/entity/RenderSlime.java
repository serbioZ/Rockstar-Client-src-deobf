// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerSlimeGel;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelSlime;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.monster.EntitySlime;

public class RenderSlime extends RenderLiving<EntitySlime>
{
    private static final /* synthetic */ ResourceLocation SLIME_TEXTURES;
    
    @Override
    protected ResourceLocation getEntityTexture(final EntitySlime lllllllllllIIllIIIlIllIIlIllIIII) {
        return RenderSlime.SLIME_TEXTURES;
    }
    
    @Override
    public void doRender(final EntitySlime lllllllllllIIllIIIlIllIIllIIlIlI, final double lllllllllllIIllIIIlIllIIllIlIIII, final double lllllllllllIIllIIIlIllIIllIIllll, final double lllllllllllIIllIIIlIllIIllIIIlll, final float lllllllllllIIllIIIlIllIIllIIllIl, final float lllllllllllIIllIIIlIllIIllIIIlIl) {
        this.shadowSize = 0.25f * lllllllllllIIllIIIlIllIIllIIlIlI.getSlimeSize();
        super.doRender(lllllllllllIIllIIIlIllIIllIIlIlI, lllllllllllIIllIIIlIllIIllIlIIII, lllllllllllIIllIIIlIllIIllIIllll, lllllllllllIIllIIIlIllIIllIIIlll, lllllllllllIIllIIIlIllIIllIIllIl, lllllllllllIIllIIIlIllIIllIIIlIl);
    }
    
    public RenderSlime(final RenderManager lllllllllllIIllIIIlIllIIllIllIlI) {
        super(lllllllllllIIllIIIlIllIIllIllIlI, new ModelSlime(16), 0.25f);
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerSlimeGel(this));
    }
    
    static {
        SLIME_TEXTURES = new ResourceLocation("textures/entity/slime/slime.png");
    }
    
    @Override
    protected void preRenderCallback(final EntitySlime lllllllllllIIllIIIlIllIIlIllIlll, final float lllllllllllIIllIIIlIllIIlIllIllI) {
        final float lllllllllllIIllIIIlIllIIlIlllIll = 0.999f;
        GlStateManager.scale(0.999f, 0.999f, 0.999f);
        final float lllllllllllIIllIIIlIllIIlIlllIlI = (float)lllllllllllIIllIIIlIllIIlIllIlll.getSlimeSize();
        final float lllllllllllIIllIIIlIllIIlIlllIIl = (lllllllllllIIllIIIlIllIIlIllIlll.prevSquishFactor + (lllllllllllIIllIIIlIllIIlIllIlll.squishFactor - lllllllllllIIllIIIlIllIIlIllIlll.prevSquishFactor) * lllllllllllIIllIIIlIllIIlIllIllI) / (lllllllllllIIllIIIlIllIIlIlllIlI * 0.5f + 1.0f);
        final float lllllllllllIIllIIIlIllIIlIlllIII = 1.0f / (lllllllllllIIllIIIlIllIIlIlllIIl + 1.0f);
        GlStateManager.scale(lllllllllllIIllIIIlIllIIlIlllIII * lllllllllllIIllIIIlIllIIlIlllIlI, 1.0f / lllllllllllIIllIIIlIllIIlIlllIII * lllllllllllIIllIIIlIllIIlIlllIlI, lllllllllllIIllIIIlIllIIlIlllIII * lllllllllllIIllIIIlIllIIlIlllIlI);
    }
}
