// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.monster.EntityVindicator;
import net.minecraft.util.EnumHandSide;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelIllager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.monster.EntityMob;

public class RenderVindicator extends RenderLiving<EntityMob>
{
    private static final /* synthetic */ ResourceLocation field_191357_a;
    
    static {
        field_191357_a = new ResourceLocation("textures/entity/illager/vindicator.png");
    }
    
    @Override
    public void doRender(final EntityMob lllllllllllllIllIIIllllllIIllIlI, final double lllllllllllllIllIIIllllllIIllIIl, final double lllllllllllllIllIIIllllllIIllIII, final double lllllllllllllIllIIIllllllIIlIIII, final float lllllllllllllIllIIIllllllIIIllll, final float lllllllllllllIllIIIllllllIIlIlIl) {
        super.doRender(lllllllllllllIllIIIllllllIIllIlI, lllllllllllllIllIIIllllllIIllIIl, lllllllllllllIllIIIllllllIIllIII, lllllllllllllIllIIIllllllIIlIIII, lllllllllllllIllIIIllllllIIIllll, lllllllllllllIllIIIllllllIIlIlIl);
    }
    
    public RenderVindicator(final RenderManager lllllllllllllIllIIIllllllIlIIlIl) {
        super(lllllllllllllIllIIIllllllIlIIlIl, new ModelIllager(0.0f, 0.0f, 64, 64), 0.5f);
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerHeldItem(this) {
            @Override
            protected void func_191361_a(final EnumHandSide llllllllllIlllIllIIlIllIlIIIlIIl) {
                ((ModelIllager)this.livingEntityRenderer.getMainModel()).func_191216_a(llllllllllIlllIllIIlIllIlIIIlIIl).postRender(0.0625f);
            }
            
            @Override
            public void doRenderLayer(final EntityLivingBase llllllllllIlllIllIIlIllIlIIlIllI, final float llllllllllIlllIllIIlIllIlIIllllI, final float llllllllllIlllIllIIlIllIlIIlllIl, final float llllllllllIlllIllIIlIllIlIIlIIll, final float llllllllllIlllIllIIlIllIlIIlIIlI, final float llllllllllIlllIllIIlIllIlIIlIIIl, final float llllllllllIlllIllIIlIllIlIIlIIII, final float llllllllllIlllIllIIlIllIlIIIllll) {
                if (((EntityVindicator)llllllllllIlllIllIIlIllIlIIlIllI).func_190639_o()) {
                    super.doRenderLayer(llllllllllIlllIllIIlIllIlIIlIllI, llllllllllIlllIllIIlIllIlIIllllI, llllllllllIlllIllIIlIllIlIIlllIl, llllllllllIlllIllIIlIllIlIIlIIll, llllllllllIlllIllIIlIllIlIIlIIlI, llllllllllIlllIllIIlIllIlIIlIIIl, llllllllllIlllIllIIlIllIlIIlIIII, llllllllllIlllIllIIlIllIlIIIllll);
                }
            }
        });
    }
    
    @Override
    protected void preRenderCallback(final EntityMob lllllllllllllIllIIIllllllIIIlIIl, final float lllllllllllllIllIIIllllllIIIlIII) {
        final float lllllllllllllIllIIIllllllIIIIlll = 0.9375f;
        GlStateManager.scale(0.9375f, 0.9375f, 0.9375f);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityMob lllllllllllllIllIIIllllllIIIllII) {
        return RenderVindicator.field_191357_a;
    }
}
