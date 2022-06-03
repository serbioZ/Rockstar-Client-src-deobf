// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelPolarBear;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.monster.EntityPolarBear;

public class RenderPolarBear extends RenderLiving<EntityPolarBear>
{
    private static final /* synthetic */ ResourceLocation POLAR_BEAR_TEXTURE;
    
    @Override
    protected void preRenderCallback(final EntityPolarBear lllllllllllIllIlIlIIIllIIlIllllI, final float lllllllllllIllIlIlIIIllIIlIlllIl) {
        GlStateManager.scale(1.2f, 1.2f, 1.2f);
        super.preRenderCallback(lllllllllllIllIlIlIIIllIIlIllllI, lllllllllllIllIlIlIIIllIIlIlllIl);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityPolarBear lllllllllllIllIlIlIIIllIIllllIII) {
        return RenderPolarBear.POLAR_BEAR_TEXTURE;
    }
    
    static {
        POLAR_BEAR_TEXTURE = new ResourceLocation("textures/entity/bear/polarbear.png");
    }
    
    public RenderPolarBear(final RenderManager lllllllllllIllIlIlIIIllIIlllllII) {
        super(lllllllllllIllIlIlIIIllIIlllllII, new ModelPolarBear(), 0.7f);
    }
    
    @Override
    public void doRender(final EntityPolarBear lllllllllllIllIlIlIIIllIIllIllll, final double lllllllllllIllIlIlIIIllIIllIIlll, final double lllllllllllIllIlIlIIIllIIllIIllI, final double lllllllllllIllIlIlIIIllIIllIIlIl, final float lllllllllllIllIlIlIIIllIIllIlIll, final float lllllllllllIllIlIlIIIllIIllIlIlI) {
        super.doRender(lllllllllllIllIlIlIIIllIIllIllll, lllllllllllIllIlIlIIIllIIllIIlll, lllllllllllIllIlIlIIIllIIllIIllI, lllllllllllIllIlIlIIIllIIllIIlIl, lllllllllllIllIlIlIIIllIIllIlIll, lllllllllllIllIlIlIIIllIIllIlIlI);
    }
}
