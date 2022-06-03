// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityGuardian;
import net.minecraft.util.ResourceLocation;

public class RenderElderGuardian extends RenderGuardian
{
    private static final /* synthetic */ ResourceLocation GUARDIAN_ELDER_TEXTURE;
    
    static {
        GUARDIAN_ELDER_TEXTURE = new ResourceLocation("textures/entity/guardian_elder.png");
    }
    
    public RenderElderGuardian(final RenderManager lllllllllllIIlIllIIllIIIIIIllIll) {
        super(lllllllllllIIlIllIIllIIIIIIllIll);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityGuardian lllllllllllIIlIllIIllIIIIIIlIllI) {
        return RenderElderGuardian.GUARDIAN_ELDER_TEXTURE;
    }
    
    @Override
    protected void preRenderCallback(final EntityGuardian lllllllllllIIlIllIIllIIIIIIllIIl, final float lllllllllllIIlIllIIllIIIIIIllIII) {
        GlStateManager.scale(2.35f, 2.35f, 2.35f);
    }
}
