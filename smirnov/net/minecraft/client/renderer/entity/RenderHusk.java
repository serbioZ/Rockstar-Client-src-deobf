// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.util.ResourceLocation;

public class RenderHusk extends RenderZombie
{
    private static final /* synthetic */ ResourceLocation HUSK_ZOMBIE_TEXTURES;
    
    static {
        HUSK_ZOMBIE_TEXTURES = new ResourceLocation("textures/entity/zombie/husk.png");
    }
    
    public RenderHusk(final RenderManager lllllllllllllIIlllllIlIIlIIlllII) {
        super(lllllllllllllIIlllllIlIIlIIlllII);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityZombie lllllllllllllIIlllllIlIIlIIIllII) {
        return RenderHusk.HUSK_ZOMBIE_TEXTURES;
    }
    
    @Override
    protected void preRenderCallback(final EntityZombie lllllllllllllIIlllllIlIIlIIlIIII, final float lllllllllllllIIlllllIlIIlIIIllll) {
        final float lllllllllllllIIlllllIlIIlIIlIIlI = 1.0625f;
        GlStateManager.scale(1.0625f, 1.0625f, 1.0625f);
        super.preRenderCallback(lllllllllllllIIlllllIlIIlIIlIIII, lllllllllllllIIlllllIlIIlIIIllll);
    }
}
