// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerHeldItemWitch;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.model.ModelWitch;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.monster.EntityWitch;

public class RenderWitch extends RenderLiving<EntityWitch>
{
    private static final /* synthetic */ ResourceLocation WITCH_TEXTURES;
    
    @Override
    public void doRender(final EntityWitch lllllllllllIIlllIlIIlllIIlIlllII, final double lllllllllllIIlllIlIIlllIIlIllIll, final double lllllllllllIIlllIlIIlllIIllIIIIl, final double lllllllllllIIlllIlIIlllIIlIllIIl, final float lllllllllllIIlllIlIIlllIIlIllIII, final float lllllllllllIIlllIlIIlllIIlIllllI) {
        ((ModelWitch)this.mainModel).holdingItem = !lllllllllllIIlllIlIIlllIIlIlllII.getHeldItemMainhand().func_190926_b();
        super.doRender(lllllllllllIIlllIlIIlllIIlIlllII, lllllllllllIIlllIlIIlllIIlIllIll, lllllllllllIIlllIlIIlllIIllIIIIl, lllllllllllIIlllIlIIlllIIlIllIIl, lllllllllllIIlllIlIIlllIIlIllIII, lllllllllllIIlllIlIIlllIIlIllllI);
    }
    
    @Override
    protected void preRenderCallback(final EntityWitch lllllllllllIIlllIlIIlllIIlIlIIIl, final float lllllllllllIIlllIlIIlllIIlIlIIII) {
        final float lllllllllllIIlllIlIIlllIIlIIllll = 0.9375f;
        GlStateManager.scale(0.9375f, 0.9375f, 0.9375f);
    }
    
    public RenderWitch(final RenderManager lllllllllllIIlllIlIIlllIIllIllll) {
        super(lllllllllllIIlllIlIIlllIIllIllll, new ModelWitch(0.0f), 0.5f);
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerHeldItemWitch(this));
    }
    
    static {
        WITCH_TEXTURES = new ResourceLocation("textures/entity/witch.png");
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityWitch lllllllllllIIlllIlIIlllIIlIlIlIl) {
        return RenderWitch.WITCH_TEXTURES;
    }
    
    @Override
    public ModelWitch getMainModel() {
        return (ModelWitch)super.getMainModel();
    }
    
    @Override
    public void transformHeldFull3DItemLayer() {
        GlStateManager.translate(0.0f, 0.1875f, 0.0f);
    }
}
