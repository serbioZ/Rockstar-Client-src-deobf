// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.client.renderer.entity.layers.LayerIronGolemFlower;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelIronGolem;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.monster.EntityIronGolem;

public class RenderIronGolem extends RenderLiving<EntityIronGolem>
{
    private static final /* synthetic */ ResourceLocation IRON_GOLEM_TEXTURES;
    
    @Override
    protected void rotateCorpse(final EntityIronGolem lllllllllllllIIllIIlIIIIIlIIIlll, final float lllllllllllllIIllIIlIIIIIlIIIllI, final float lllllllllllllIIllIIlIIIIIlIIllIl, final float lllllllllllllIIllIIlIIIIIlIIIlII) {
        super.rotateCorpse(lllllllllllllIIllIIlIIIIIlIIIlll, lllllllllllllIIllIIlIIIIIlIIIllI, lllllllllllllIIllIIlIIIIIlIIllIl, lllllllllllllIIllIIlIIIIIlIIIlII);
        if (lllllllllllllIIllIIlIIIIIlIIIlll.limbSwingAmount >= 0.01) {
            final float lllllllllllllIIllIIlIIIIIlIIlIll = 13.0f;
            final float lllllllllllllIIllIIlIIIIIlIIlIlI = lllllllllllllIIllIIlIIIIIlIIIlll.limbSwing - lllllllllllllIIllIIlIIIIIlIIIlll.limbSwingAmount * (1.0f - lllllllllllllIIllIIlIIIIIlIIIlII) + 6.0f;
            final float lllllllllllllIIllIIlIIIIIlIIlIIl = (Math.abs(lllllllllllllIIllIIlIIIIIlIIlIlI % 13.0f - 6.5f) - 3.25f) / 3.25f;
            GlStateManager.rotate(6.5f * lllllllllllllIIllIIlIIIIIlIIlIIl, 0.0f, 0.0f, 1.0f);
        }
    }
    
    static {
        IRON_GOLEM_TEXTURES = new ResourceLocation("textures/entity/iron_golem.png");
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityIronGolem lllllllllllllIIllIIlIIIIIlIllIIl) {
        return RenderIronGolem.IRON_GOLEM_TEXTURES;
    }
    
    public RenderIronGolem(final RenderManager lllllllllllllIIllIIlIIIIIlIllIll) {
        super(lllllllllllllIIllIIlIIIIIlIllIll, new ModelIronGolem(), 0.5f);
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerIronGolemFlower(this));
    }
}
