// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerSheepWool;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelSheep2;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.passive.EntitySheep;

public class RenderSheep extends RenderLiving<EntitySheep>
{
    private static final /* synthetic */ ResourceLocation SHEARED_SHEEP_TEXTURES;
    
    @Override
    protected ResourceLocation getEntityTexture(final EntitySheep lllllllllllIIllIIIllIlIIlIlIllll) {
        return RenderSheep.SHEARED_SHEEP_TEXTURES;
    }
    
    static {
        SHEARED_SHEEP_TEXTURES = new ResourceLocation("textures/entity/sheep/sheep.png");
    }
    
    public RenderSheep(final RenderManager lllllllllllIIllIIIllIlIIlIllIIIl) {
        super(lllllllllllIIllIIIllIlIIlIllIIIl, new ModelSheep2(), 0.7f);
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerSheepWool(this));
    }
}
