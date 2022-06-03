// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelEnderMite;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.monster.EntityEndermite;

public class RenderEndermite extends RenderLiving<EntityEndermite>
{
    private static final /* synthetic */ ResourceLocation ENDERMITE_TEXTURES;
    
    @Override
    protected float getDeathMaxRotation(final EntityEndermite lllllllllllIIIlIIlllIIIllIlIlIIl) {
        return 180.0f;
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityEndermite lllllllllllIIIlIIlllIIIllIlIIlll) {
        return RenderEndermite.ENDERMITE_TEXTURES;
    }
    
    public RenderEndermite(final RenderManager lllllllllllIIIlIIlllIIIllIlIllIl) {
        super(lllllllllllIIIlIIlllIIIllIlIllIl, new ModelEnderMite(), 0.3f);
    }
    
    static {
        ENDERMITE_TEXTURES = new ResourceLocation("textures/entity/endermite.png");
    }
}
