// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelHorse;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.passive.EntitySkeletonHorse;
import net.minecraft.entity.passive.EntityZombieHorse;
import net.minecraft.entity.passive.EntityMule;
import net.minecraft.entity.passive.EntityDonkey;
import com.google.common.collect.Maps;
import net.minecraft.util.ResourceLocation;
import java.util.Map;
import net.minecraft.entity.passive.AbstractHorse;

public class RenderAbstractHorse extends RenderLiving<AbstractHorse>
{
    private final /* synthetic */ float field_191360_j;
    private static final /* synthetic */ Map<Class<?>, ResourceLocation> field_191359_a;
    
    @Override
    protected ResourceLocation getEntityTexture(final AbstractHorse lllllllllllIIllIlIlIIlIlIllIIIlI) {
        return RenderAbstractHorse.field_191359_a.get(lllllllllllIIllIlIlIIlIlIllIIIlI.getClass());
    }
    
    static {
        (field_191359_a = Maps.newHashMap()).put(EntityDonkey.class, new ResourceLocation("textures/entity/horse/donkey.png"));
        RenderAbstractHorse.field_191359_a.put(EntityMule.class, new ResourceLocation("textures/entity/horse/mule.png"));
        RenderAbstractHorse.field_191359_a.put(EntityZombieHorse.class, new ResourceLocation("textures/entity/horse/horse_zombie.png"));
        RenderAbstractHorse.field_191359_a.put(EntitySkeletonHorse.class, new ResourceLocation("textures/entity/horse/horse_skeleton.png"));
    }
    
    @Override
    protected void preRenderCallback(final AbstractHorse lllllllllllIIllIlIlIIlIlIllIlIIl, final float lllllllllllIIllIlIlIIlIlIllIIlIl) {
        GlStateManager.scale(this.field_191360_j, this.field_191360_j, this.field_191360_j);
        super.preRenderCallback(lllllllllllIIllIlIlIIlIlIllIlIIl, lllllllllllIIllIlIlIIlIlIllIIlIl);
    }
    
    public RenderAbstractHorse(final RenderManager lllllllllllIIllIlIlIIlIlIllllIIl) {
        this(lllllllllllIIllIlIlIIlIlIllllIIl, 1.0f);
    }
    
    public RenderAbstractHorse(final RenderManager lllllllllllIIllIlIlIIlIlIlllIIlI, final float lllllllllllIIllIlIlIIlIlIlllIIIl) {
        super(lllllllllllIIllIlIlIIlIlIlllIIlI, new ModelHorse(), 0.75f);
        this.field_191360_j = lllllllllllIIllIlIlIIlIlIlllIIIl;
    }
}
