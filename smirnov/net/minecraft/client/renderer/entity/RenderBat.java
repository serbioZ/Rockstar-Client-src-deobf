// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBat;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.passive.EntityBat;

public class RenderBat extends RenderLiving<EntityBat>
{
    private static final /* synthetic */ ResourceLocation BAT_TEXTURES;
    
    @Override
    protected void preRenderCallback(final EntityBat lllllllllllIIIIIIIIIlIlIIllIIIII, final float lllllllllllIIIIIIIIIlIlIIlIlllll) {
        GlStateManager.scale(0.35f, 0.35f, 0.35f);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityBat lllllllllllIIIIIIIIIlIlIIllIIIlI) {
        return RenderBat.BAT_TEXTURES;
    }
    
    @Override
    protected void rotateCorpse(final EntityBat lllllllllllIIIIIIIIIlIlIIlIlIIll, final float lllllllllllIIIIIIIIIlIlIIlIlIlll, final float lllllllllllIIIIIIIIIlIlIIlIlIIIl, final float lllllllllllIIIIIIIIIlIlIIlIlIIII) {
        if (lllllllllllIIIIIIIIIlIlIIlIlIIll.getIsBatHanging()) {
            GlStateManager.translate(0.0f, -0.1f, 0.0f);
        }
        else {
            GlStateManager.translate(0.0f, MathHelper.cos(lllllllllllIIIIIIIIIlIlIIlIlIlll * 0.3f) * 0.1f, 0.0f);
        }
        super.rotateCorpse(lllllllllllIIIIIIIIIlIlIIlIlIIll, lllllllllllIIIIIIIIIlIlIIlIlIlll, lllllllllllIIIIIIIIIlIlIIlIlIIIl, lllllllllllIIIIIIIIIlIlIIlIlIIII);
    }
    
    static {
        BAT_TEXTURES = new ResourceLocation("textures/entity/bat.png");
    }
    
    public RenderBat(final RenderManager lllllllllllIIIIIIIIIlIlIIllIIllI) {
        super(lllllllllllIIIIIIIIIlIlIIllIIllI, new ModelBat(), 0.25f);
    }
}
