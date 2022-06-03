// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelCow;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.passive.EntityCow;

public class RenderCow extends RenderLiving<EntityCow>
{
    private static final /* synthetic */ ResourceLocation COW_TEXTURES;
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityCow lllllllllllIlllllIIIIlIlllIIIlll) {
        return RenderCow.COW_TEXTURES;
    }
    
    static {
        COW_TEXTURES = new ResourceLocation("textures/entity/cow/cow.png");
    }
    
    public RenderCow(final RenderManager lllllllllllIlllllIIIIlIlllIIlIIl) {
        super(lllllllllllIlllllIIIIlIlllIIlIIl, new ModelCow(), 0.7f);
    }
}
