// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.monster.EntityZombie;

public class RenderZombie extends RenderBiped<EntityZombie>
{
    private static final /* synthetic */ ResourceLocation ZOMBIE_TEXTURES;
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityZombie llllllllllIlllIlIIllIlIlIlllIIll) {
        return RenderZombie.ZOMBIE_TEXTURES;
    }
    
    public RenderZombie(final RenderManager llllllllllIlllIlIIllIlIlIllllIIl) {
        super(llllllllllIlllIlIIllIlIlIllllIIl, new ModelZombie(), 0.5f);
        final LayerBipedArmor llllllllllIlllIlIIllIlIlIllllIII = new LayerBipedArmor(this) {
            @Override
            protected void initArmor() {
                this.modelLeggings = (T)new ModelZombie(0.5f, true);
                this.modelArmor = (T)new ModelZombie(1.0f, true);
            }
        };
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(llllllllllIlllIlIIllIlIlIllllIII);
    }
    
    static {
        ZOMBIE_TEXTURES = new ResourceLocation("textures/entity/zombie/zombie.png");
    }
}
