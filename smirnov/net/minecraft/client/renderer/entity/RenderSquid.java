// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelSquid;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.passive.EntitySquid;

public class RenderSquid extends RenderLiving<EntitySquid>
{
    private static final /* synthetic */ ResourceLocation SQUID_TEXTURES;
    
    static {
        SQUID_TEXTURES = new ResourceLocation("textures/entity/squid.png");
    }
    
    public RenderSquid(final RenderManager llllllllllIlllllllllIIIlIlIIIlII) {
        super(llllllllllIlllllllllIIIlIlIIIlII, new ModelSquid(), 0.7f);
    }
    
    @Override
    protected void rotateCorpse(final EntitySquid llllllllllIlllllllllIIIlIIllIlIl, final float llllllllllIlllllllllIIIlIIlllIlI, final float llllllllllIlllllllllIIIlIIlllIIl, final float llllllllllIlllllllllIIIlIIlllIII) {
        final float llllllllllIlllllllllIIIlIIllIlll = llllllllllIlllllllllIIIlIIllIlIl.prevSquidPitch + (llllllllllIlllllllllIIIlIIllIlIl.squidPitch - llllllllllIlllllllllIIIlIIllIlIl.prevSquidPitch) * llllllllllIlllllllllIIIlIIlllIII;
        final float llllllllllIlllllllllIIIlIIllIllI = llllllllllIlllllllllIIIlIIllIlIl.prevSquidYaw + (llllllllllIlllllllllIIIlIIllIlIl.squidYaw - llllllllllIlllllllllIIIlIIllIlIl.prevSquidYaw) * llllllllllIlllllllllIIIlIIlllIII;
        GlStateManager.translate(0.0f, 0.5f, 0.0f);
        GlStateManager.rotate(180.0f - llllllllllIlllllllllIIIlIIlllIIl, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(llllllllllIlllllllllIIIlIIllIlll, 1.0f, 0.0f, 0.0f);
        GlStateManager.rotate(llllllllllIlllllllllIIIlIIllIllI, 0.0f, 1.0f, 0.0f);
        GlStateManager.translate(0.0f, -1.2f, 0.0f);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntitySquid llllllllllIlllllllllIIIlIlIIIIlI) {
        return RenderSquid.SQUID_TEXTURES;
    }
    
    @Override
    protected float handleRotationFloat(final EntitySquid llllllllllIlllllllllIIIlIIlIllIl, final float llllllllllIlllllllllIIIlIIlIllII) {
        return llllllllllIlllllllllIIIlIIlIllIl.lastTentacleAngle + (llllllllllIlllllllllIIIlIIlIllIl.tentacleAngle - llllllllllIlllllllllIIIlIIlIllIl.lastTentacleAngle) * llllllllllIlllllllllIIIlIIlIllII;
    }
}
