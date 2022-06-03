// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.client.renderer.entity.layers.LayerElytra;
import net.minecraft.client.renderer.entity.layers.LayerCustomHead;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.EntityLiving;

public class RenderBiped<T extends EntityLiving> extends RenderLiving<T>
{
    private static final /* synthetic */ ResourceLocation DEFAULT_RES_LOC;
    
    static {
        DEFAULT_RES_LOC = new ResourceLocation("textures/entity/steve.png");
    }
    
    public RenderBiped(final RenderManager lllllllllllllIllIlIIlIlIIIIIllII, final ModelBiped lllllllllllllIllIlIIlIlIIIIIllll, final float lllllllllllllIllIlIIlIlIIIIIlllI) {
        super(lllllllllllllIllIlIIlIlIIIIIllII, lllllllllllllIllIlIIlIlIIIIIllll, lllllllllllllIllIlIIlIlIIIIIlllI);
        this.addLayer(new LayerCustomHead(lllllllllllllIllIlIIlIlIIIIIllll.bipedHead));
        this.addLayer(new LayerElytra(this));
        this.addLayer(new LayerHeldItem(this));
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final T lllllllllllllIllIlIIlIlIIIIIlIII) {
        return RenderBiped.DEFAULT_RES_LOC;
    }
    
    @Override
    public void transformHeldFull3DItemLayer() {
        GlStateManager.translate(0.0f, 0.1875f, 0.0f);
    }
}
