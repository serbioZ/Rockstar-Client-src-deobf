// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.layers.LayerSpiderEyes;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelSpider;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.monster.EntitySpider;

public class RenderSpider<T extends EntitySpider> extends RenderLiving<T>
{
    private static final /* synthetic */ ResourceLocation SPIDER_TEXTURES;
    
    @Override
    protected ResourceLocation getEntityTexture(final T lllllllllllIIlllllIlIllllIlIIIII) {
        return RenderSpider.SPIDER_TEXTURES;
    }
    
    public RenderSpider(final RenderManager lllllllllllIIlllllIlIllllIlIIllI) {
        super(lllllllllllIIlllllIlIllllIlIIllI, new ModelSpider(), 1.0f);
        this.addLayer(new LayerSpiderEyes(this));
    }
    
    @Override
    protected float getDeathMaxRotation(final T lllllllllllIIlllllIlIllllIlIIIlI) {
        return 180.0f;
    }
    
    static {
        SPIDER_TEXTURES = new ResourceLocation("textures/entity/spider/spider.png");
    }
}
