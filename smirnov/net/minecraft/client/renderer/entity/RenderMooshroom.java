// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerMooshroomMushroom;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelCow;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.passive.EntityMooshroom;

public class RenderMooshroom extends RenderLiving<EntityMooshroom>
{
    private static final /* synthetic */ ResourceLocation MOOSHROOM_TEXTURES;
    
    public RenderMooshroom(final RenderManager lllllllllllIlllIIlllIIllllIIIIIl) {
        super(lllllllllllIlllIIlllIIllllIIIIIl, new ModelCow(), 0.7f);
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerMooshroomMushroom(this));
    }
    
    static {
        MOOSHROOM_TEXTURES = new ResourceLocation("textures/entity/cow/mooshroom.png");
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityMooshroom lllllllllllIlllIIlllIIlllIllllII) {
        return RenderMooshroom.MOOSHROOM_TEXTURES;
    }
    
    @Override
    public ModelCow getMainModel() {
        return (ModelCow)super.getMainModel();
    }
}
