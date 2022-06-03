// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelChicken;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.passive.EntityChicken;

public class RenderChicken extends RenderLiving<EntityChicken>
{
    private static final /* synthetic */ ResourceLocation CHICKEN_TEXTURES;
    
    static {
        CHICKEN_TEXTURES = new ResourceLocation("textures/entity/chicken.png");
    }
    
    @Override
    protected float handleRotationFloat(final EntityChicken lllllllllllIllIlllllIIIllIIlllII, final float lllllllllllIllIlllllIIIllIIlIlll) {
        final float lllllllllllIllIlllllIIIllIIllIlI = lllllllllllIllIlllllIIIllIIlllII.oFlap + (lllllllllllIllIlllllIIIllIIlllII.wingRotation - lllllllllllIllIlllllIIIllIIlllII.oFlap) * lllllllllllIllIlllllIIIllIIlIlll;
        final float lllllllllllIllIlllllIIIllIIllIIl = lllllllllllIllIlllllIIIllIIlllII.oFlapSpeed + (lllllllllllIllIlllllIIIllIIlllII.destPos - lllllllllllIllIlllllIIIllIIlllII.oFlapSpeed) * lllllllllllIllIlllllIIIllIIlIlll;
        return (MathHelper.sin(lllllllllllIllIlllllIIIllIIllIlI) + 1.0f) * lllllllllllIllIlllllIIIllIIllIIl;
    }
    
    public RenderChicken(final RenderManager lllllllllllIllIlllllIIIllIlIIllI) {
        super(lllllllllllIllIlllllIIIllIlIIllI, new ModelChicken(), 0.3f);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityChicken lllllllllllIllIlllllIIIllIlIIIlI) {
        return RenderChicken.CHICKEN_TEXTURES;
    }
}
