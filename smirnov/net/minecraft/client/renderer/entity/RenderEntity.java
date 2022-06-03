// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.client.renderer.GlStateManager;
import javax.annotation.Nullable;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;

public class RenderEntity extends Render<Entity>
{
    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(final Entity lllllllllllIlllIlIlIlIllIlllIlll) {
        return null;
    }
    
    @Override
    public void doRender(final Entity lllllllllllIlllIlIlIlIlllIIIIlIl, final double lllllllllllIlllIlIlIlIllIlllllIl, final double lllllllllllIlllIlIlIlIlllIIIIIll, final double lllllllllllIlllIlIlIlIlllIIIIIlI, final float lllllllllllIlllIlIlIlIllIllllIlI, final float lllllllllllIlllIlIlIlIllIllllIIl) {
        GlStateManager.pushMatrix();
        Render.renderOffsetAABB(lllllllllllIlllIlIlIlIlllIIIIlIl.getEntityBoundingBox(), lllllllllllIlllIlIlIlIllIlllllIl - lllllllllllIlllIlIlIlIlllIIIIlIl.lastTickPosX, lllllllllllIlllIlIlIlIlllIIIIIll - lllllllllllIlllIlIlIlIlllIIIIlIl.lastTickPosY, lllllllllllIlllIlIlIlIlllIIIIIlI - lllllllllllIlllIlIlIlIlllIIIIlIl.lastTickPosZ);
        GlStateManager.popMatrix();
        super.doRender(lllllllllllIlllIlIlIlIlllIIIIlIl, lllllllllllIlllIlIlIlIllIlllllIl, lllllllllllIlllIlIlIlIlllIIIIIll, lllllllllllIlllIlIlIlIlllIIIIIlI, lllllllllllIlllIlIlIlIllIllllIlI, lllllllllllIlllIlIlIlIllIllllIIl);
    }
    
    public RenderEntity(final RenderManager lllllllllllIlllIlIlIlIlllIIIlllI) {
        super(lllllllllllIlllIlIlIlIlllIIIlllI);
    }
}
