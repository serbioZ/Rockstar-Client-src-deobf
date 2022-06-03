// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.monster.EntityCaveSpider;

public class RenderCaveSpider extends RenderSpider<EntityCaveSpider>
{
    private static final /* synthetic */ ResourceLocation CAVE_SPIDER_TEXTURES;
    
    static {
        CAVE_SPIDER_TEXTURES = new ResourceLocation("textures/entity/spider/cave_spider.png");
    }
    
    @Override
    protected void preRenderCallback(final EntityCaveSpider lllllllllllIIlIlIIIlIllIllIlIlII, final float lllllllllllIIlIlIIIlIllIllIlIIll) {
        GlStateManager.scale(0.7f, 0.7f, 0.7f);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityCaveSpider lllllllllllIIlIlIIIlIllIllIlIIIl) {
        return RenderCaveSpider.CAVE_SPIDER_TEXTURES;
    }
    
    public RenderCaveSpider(final RenderManager lllllllllllIIlIlIIIlIllIllIlIllI) {
        super(lllllllllllIIlIlIIIlIllIllIlIllI);
        this.shadowSize *= 0.7f;
    }
}
