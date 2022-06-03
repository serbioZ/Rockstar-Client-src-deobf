// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelMagmaCube;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.monster.EntityMagmaCube;

public class RenderMagmaCube extends RenderLiving<EntityMagmaCube>
{
    private static final /* synthetic */ ResourceLocation MAGMA_CUBE_TEXTURES;
    
    static {
        MAGMA_CUBE_TEXTURES = new ResourceLocation("textures/entity/slime/magmacube.png");
    }
    
    public RenderMagmaCube(final RenderManager lllllllllllIIIIlllIlIllIIlIIllIl) {
        super(lllllllllllIIIIlllIlIllIIlIIllIl, new ModelMagmaCube(), 0.25f);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityMagmaCube lllllllllllIIIIlllIlIllIIlIIlIIl) {
        return RenderMagmaCube.MAGMA_CUBE_TEXTURES;
    }
    
    @Override
    protected void preRenderCallback(final EntityMagmaCube lllllllllllIIIIlllIlIllIIlIIIIlI, final float lllllllllllIIIIlllIlIllIIIllllII) {
        final int lllllllllllIIIIlllIlIllIIlIIIIII = lllllllllllIIIIlllIlIllIIlIIIIlI.getSlimeSize();
        final float lllllllllllIIIIlllIlIllIIIllllll = (lllllllllllIIIIlllIlIllIIlIIIIlI.prevSquishFactor + (lllllllllllIIIIlllIlIllIIlIIIIlI.squishFactor - lllllllllllIIIIlllIlIllIIlIIIIlI.prevSquishFactor) * lllllllllllIIIIlllIlIllIIIllllII) / (lllllllllllIIIIlllIlIllIIlIIIIII * 0.5f + 1.0f);
        final float lllllllllllIIIIlllIlIllIIIlllllI = 1.0f / (lllllllllllIIIIlllIlIllIIIllllll + 1.0f);
        GlStateManager.scale(lllllllllllIIIIlllIlIllIIIlllllI * lllllllllllIIIIlllIlIllIIlIIIIII, 1.0f / lllllllllllIIIIlllIlIllIIIlllllI * lllllllllllIIIIlllIlIllIIlIIIIII, lllllllllllIIIIlllIlIllIIIlllllI * lllllllllllIIIIlllIlIllIIlIIIIII);
    }
}
