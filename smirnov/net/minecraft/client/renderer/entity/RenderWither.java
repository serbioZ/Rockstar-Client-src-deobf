// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerWitherAura;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelWither;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.boss.EntityWither;

public class RenderWither extends RenderLiving<EntityWither>
{
    private static final /* synthetic */ ResourceLocation WITHER_TEXTURES;
    private static final /* synthetic */ ResourceLocation INVULNERABLE_WITHER_TEXTURES;
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityWither llllllllllllIIIIIIIIlIIIIIlIllII) {
        final int llllllllllllIIIIIIIIlIIIIIlIllIl = llllllllllllIIIIIIIIlIIIIIlIllII.getInvulTime();
        return (llllllllllllIIIIIIIIlIIIIIlIllIl > 0 && (llllllllllllIIIIIIIIlIIIIIlIllIl > 80 || llllllllllllIIIIIIIIlIIIIIlIllIl / 5 % 2 != 1)) ? RenderWither.INVULNERABLE_WITHER_TEXTURES : RenderWither.WITHER_TEXTURES;
    }
    
    public RenderWither(final RenderManager llllllllllllIIIIIIIIlIIIIIllIlII) {
        super(llllllllllllIIIIIIIIlIIIIIllIlII, new ModelWither(0.0f), 1.0f);
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerWitherAura(this));
    }
    
    @Override
    protected void preRenderCallback(final EntityWither llllllllllllIIIIIIIIlIIIIIlIIlIl, final float llllllllllllIIIIIIIIlIIIIIlIIIII) {
        float llllllllllllIIIIIIIIlIIIIIlIIIll = 2.0f;
        final int llllllllllllIIIIIIIIlIIIIIlIIIlI = llllllllllllIIIIIIIIlIIIIIlIIlIl.getInvulTime();
        if (llllllllllllIIIIIIIIlIIIIIlIIIlI > 0) {
            llllllllllllIIIIIIIIlIIIIIlIIIll -= (llllllllllllIIIIIIIIlIIIIIlIIIlI - llllllllllllIIIIIIIIlIIIIIlIIIII) / 220.0f * 0.5f;
        }
        GlStateManager.scale(llllllllllllIIIIIIIIlIIIIIlIIIll, llllllllllllIIIIIIIIlIIIIIlIIIll, llllllllllllIIIIIIIIlIIIIIlIIIll);
    }
    
    static {
        INVULNERABLE_WITHER_TEXTURES = new ResourceLocation("textures/entity/wither/wither_invulnerable.png");
        WITHER_TEXTURES = new ResourceLocation("textures/entity/wither/wither.png");
    }
}
