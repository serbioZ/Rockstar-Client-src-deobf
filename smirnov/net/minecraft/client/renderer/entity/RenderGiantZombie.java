// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.monster.EntityGiantZombie;

public class RenderGiantZombie extends RenderLiving<EntityGiantZombie>
{
    private final /* synthetic */ float scale;
    private static final /* synthetic */ ResourceLocation ZOMBIE_TEXTURES;
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityGiantZombie lllllllllllIllllIIIIllIlllllIlll) {
        return RenderGiantZombie.ZOMBIE_TEXTURES;
    }
    
    @Override
    protected void preRenderCallback(final EntityGiantZombie lllllllllllIllllIIIIllIllllllIll, final float lllllllllllIllllIIIIllIllllllIlI) {
        GlStateManager.scale(this.scale, this.scale, this.scale);
    }
    
    @Override
    public void transformHeldFull3DItemLayer() {
        GlStateManager.translate(0.0f, 0.1875f, 0.0f);
    }
    
    static {
        ZOMBIE_TEXTURES = new ResourceLocation("textures/entity/zombie/zombie.png");
    }
    
    public RenderGiantZombie(final RenderManager lllllllllllIllllIIIIlllIIIIIIIll, final float lllllllllllIllllIIIIlllIIIIIIIlI) {
        super(lllllllllllIllllIIIIlllIIIIIIIll, new ModelZombie(), 0.5f * lllllllllllIllllIIIIlllIIIIIIIlI);
        this.scale = lllllllllllIllllIIIIlllIIIIIIIlI;
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerHeldItem(this));
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerBipedArmor(this) {
            @Override
            protected void initArmor() {
                this.modelLeggings = (T)new ModelZombie(0.5f, true);
                this.modelArmor = (T)new ModelZombie(1.0f, true);
            }
        });
    }
}
