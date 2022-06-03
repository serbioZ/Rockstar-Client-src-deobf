// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.monster.EntityPigZombie;

public class RenderPigZombie extends RenderBiped<EntityPigZombie>
{
    private static final /* synthetic */ ResourceLocation ZOMBIE_PIGMAN_TEXTURE;
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityPigZombie llllllllllIllllIIIIIlllllIIlIlII) {
        return RenderPigZombie.ZOMBIE_PIGMAN_TEXTURE;
    }
    
    public RenderPigZombie(final RenderManager llllllllllIllllIIIIIlllllIIllIII) {
        super(llllllllllIllllIIIIIlllllIIllIII, new ModelZombie(), 0.5f);
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerBipedArmor(this) {
            @Override
            protected void initArmor() {
                this.modelLeggings = (T)new ModelZombie(0.5f, true);
                this.modelArmor = (T)new ModelZombie(1.0f, true);
            }
        });
    }
    
    static {
        ZOMBIE_PIGMAN_TEXTURE = new ResourceLocation("textures/entity/zombie_pigman.png");
    }
}
