// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntitySpellcasterIllager;
import net.minecraft.util.EnumHandSide;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelIllager;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.monster.EntityMob;

public class RenderEvoker extends RenderLiving<EntityMob>
{
    private static final /* synthetic */ ResourceLocation field_191338_a;
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityMob lllllllllllIIIIIIIlIIIlllIlIllII) {
        return RenderEvoker.field_191338_a;
    }
    
    @Override
    protected void preRenderCallback(final EntityMob lllllllllllIIIIIIIlIIIlllIlIlIIl, final float lllllllllllIIIIIIIlIIIlllIlIlIII) {
        final float lllllllllllIIIIIIIlIIIlllIlIIlll = 0.9375f;
        GlStateManager.scale(0.9375f, 0.9375f, 0.9375f);
    }
    
    static {
        field_191338_a = new ResourceLocation("textures/entity/illager/evoker.png");
    }
    
    public RenderEvoker(final RenderManager lllllllllllIIIIIIIlIIIlllIlIlllI) {
        super(lllllllllllIIIIIIIlIIIlllIlIlllI, new ModelIllager(0.0f, 0.0f, 64, 64), 0.5f);
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerHeldItem(this) {
            @Override
            protected void func_191361_a(final EnumHandSide lllllllllllIIIIlllllllIIIlIlIIII) {
                ((ModelIllager)this.livingEntityRenderer.getMainModel()).func_191216_a(lllllllllllIIIIlllllllIIIlIlIIII).postRender(0.0625f);
            }
            
            @Override
            public void doRenderLayer(final EntityLivingBase lllllllllllIIIIlllllllIIIlIllIll, final float lllllllllllIIIIlllllllIIIllIIIll, final float lllllllllllIIIIlllllllIIIllIIIlI, final float lllllllllllIIIIlllllllIIIllIIIIl, final float lllllllllllIIIIlllllllIIIlIlIlll, final float lllllllllllIIIIlllllllIIIlIlllll, final float lllllllllllIIIIlllllllIIIlIlIlIl, final float lllllllllllIIIIlllllllIIIlIlllIl) {
                if (((EntitySpellcasterIllager)lllllllllllIIIIlllllllIIIlIllIll).func_193082_dl()) {
                    super.doRenderLayer(lllllllllllIIIIlllllllIIIlIllIll, lllllllllllIIIIlllllllIIIllIIIll, lllllllllllIIIIlllllllIIIllIIIlI, lllllllllllIIIIlllllllIIIllIIIIl, lllllllllllIIIIlllllllIIIlIlIlll, lllllllllllIIIIlllllllIIIlIlllll, lllllllllllIIIIlllllllIIIlIlIlIl, lllllllllllIIIIlllllllIIIlIlllIl);
                }
            }
        });
    }
}
