// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerCreeperCharge;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelCreeper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.monster.EntityCreeper;

public class RenderCreeper extends RenderLiving<EntityCreeper>
{
    private static final /* synthetic */ ResourceLocation CREEPER_TEXTURES;
    
    public RenderCreeper(final RenderManager lllllllllllIlIlIlIIlllIlIllIlIll) {
        super(lllllllllllIlIlIlIIlllIlIllIlIll, new ModelCreeper(), 0.5f);
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerCreeperCharge(this));
    }
    
    static {
        CREEPER_TEXTURES = new ResourceLocation("textures/entity/creeper/creeper.png");
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityCreeper lllllllllllIlIlIlIIlllIlIlIIIllI) {
        return RenderCreeper.CREEPER_TEXTURES;
    }
    
    @Override
    protected int getColorMultiplier(final EntityCreeper lllllllllllIlIlIlIIlllIlIlIlIIII, final float lllllllllllIlIlIlIIlllIlIlIIllll, final float lllllllllllIlIlIlIIlllIlIlIIlIlI) {
        final float lllllllllllIlIlIlIIlllIlIlIIllIl = lllllllllllIlIlIlIIlllIlIlIlIIII.getCreeperFlashIntensity(lllllllllllIlIlIlIIlllIlIlIIlIlI);
        if ((int)(lllllllllllIlIlIlIIlllIlIlIIllIl * 10.0f) % 2 == 0) {
            return 0;
        }
        int lllllllllllIlIlIlIIlllIlIlIIllII = (int)(lllllllllllIlIlIlIIlllIlIlIIllIl * 0.2f * 255.0f);
        lllllllllllIlIlIlIIlllIlIlIIllII = MathHelper.clamp(lllllllllllIlIlIlIIlllIlIlIIllII, 0, 255);
        return lllllllllllIlIlIlIIlllIlIlIIllII << 24 | 0x30FFFFFF;
    }
    
    @Override
    protected void preRenderCallback(final EntityCreeper lllllllllllIlIlIlIIlllIlIllIIIIl, final float lllllllllllIlIlIlIIlllIlIlIllIlI) {
        float lllllllllllIlIlIlIIlllIlIlIlllll = lllllllllllIlIlIlIIlllIlIllIIIIl.getCreeperFlashIntensity(lllllllllllIlIlIlIIlllIlIlIllIlI);
        final float lllllllllllIlIlIlIIlllIlIlIllllI = 1.0f + MathHelper.sin(lllllllllllIlIlIlIIlllIlIlIlllll * 100.0f) * lllllllllllIlIlIlIIlllIlIlIlllll * 0.01f;
        lllllllllllIlIlIlIIlllIlIlIlllll = MathHelper.clamp(lllllllllllIlIlIlIIlllIlIlIlllll, 0.0f, 1.0f);
        lllllllllllIlIlIlIIlllIlIlIlllll *= lllllllllllIlIlIlIIlllIlIlIlllll;
        lllllllllllIlIlIlIIlllIlIlIlllll *= lllllllllllIlIlIlIIlllIlIlIlllll;
        final float lllllllllllIlIlIlIIlllIlIlIlllIl = (1.0f + lllllllllllIlIlIlIIlllIlIlIlllll * 0.4f) * lllllllllllIlIlIlIIlllIlIlIllllI;
        final float lllllllllllIlIlIlIIlllIlIlIlllII = (1.0f + lllllllllllIlIlIlIIlllIlIlIlllll * 0.1f) / lllllllllllIlIlIlIIlllIlIlIllllI;
        GlStateManager.scale(lllllllllllIlIlIlIIlllIlIlIlllIl, lllllllllllIlIlIlIIlllIlIlIlllII, lllllllllllIlIlIlIIlllIlIlIlllIl);
    }
}
