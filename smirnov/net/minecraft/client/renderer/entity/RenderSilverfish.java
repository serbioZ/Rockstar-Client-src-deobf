// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelSilverfish;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.monster.EntitySilverfish;

public class RenderSilverfish extends RenderLiving<EntitySilverfish>
{
    private static final /* synthetic */ ResourceLocation SILVERFISH_TEXTURES;
    
    @Override
    protected float getDeathMaxRotation(final EntitySilverfish lllllllllllllIIIIlIIIlllIlIllllI) {
        return 180.0f;
    }
    
    static {
        SILVERFISH_TEXTURES = new ResourceLocation("textures/entity/silverfish.png");
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntitySilverfish lllllllllllllIIIIlIIIlllIlIlllII) {
        return RenderSilverfish.SILVERFISH_TEXTURES;
    }
    
    public RenderSilverfish(final RenderManager lllllllllllllIIIIlIIIlllIllIIIII) {
        super(lllllllllllllIIIIlIIIlllIllIIIII, new ModelSilverfish(), 0.3f);
    }
}
