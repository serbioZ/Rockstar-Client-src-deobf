// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelVex;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.monster.EntityVex;

public class RenderVex extends RenderBiped<EntityVex>
{
    private static final /* synthetic */ ResourceLocation field_191343_a;
    private static final /* synthetic */ ResourceLocation field_191344_j;
    private /* synthetic */ int field_191345_k;
    
    static {
        field_191343_a = new ResourceLocation("textures/entity/illager/vex.png");
        field_191344_j = new ResourceLocation("textures/entity/illager/vex_charging.png");
    }
    
    public RenderVex(final RenderManager lllllllllllIlIIIIlllIlIIIIIlllIl) {
        super(lllllllllllIlIIIIlllIlIIIIIlllIl, new ModelVex(), 0.3f);
        this.field_191345_k = ((ModelVex)this.mainModel).func_191228_a();
    }
    
    @Override
    public void doRender(final EntityVex lllllllllllIlIIIIlllIlIIIIIIIlIl, final double lllllllllllIlIIIIlllIlIIIIIIllII, final double lllllllllllIlIIIIlllIlIIIIIIlIll, final double lllllllllllIlIIIIlllIlIIIIIIIIlI, final float lllllllllllIlIIIIlllIlIIIIIIIIIl, final float lllllllllllIlIIIIlllIlIIIIIIIIII) {
        final int lllllllllllIlIIIIlllIlIIIIIIIlll = ((ModelVex)this.mainModel).func_191228_a();
        if (lllllllllllIlIIIIlllIlIIIIIIIlll != this.field_191345_k) {
            this.mainModel = new ModelVex();
            this.field_191345_k = lllllllllllIlIIIIlllIlIIIIIIIlll;
        }
        super.doRender(lllllllllllIlIIIIlllIlIIIIIIIlIl, lllllllllllIlIIIIlllIlIIIIIIllII, lllllllllllIlIIIIlllIlIIIIIIlIll, lllllllllllIlIIIIlllIlIIIIIIIIlI, lllllllllllIlIIIIlllIlIIIIIIIIIl, lllllllllllIlIIIIlllIlIIIIIIIIII);
    }
    
    @Override
    protected void preRenderCallback(final EntityVex lllllllllllIlIIIIlllIIllllllllIl, final float lllllllllllIlIIIIlllIIllllllllII) {
        GlStateManager.scale(0.4f, 0.4f, 0.4f);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityVex lllllllllllIlIIIIlllIlIIIIIllIII) {
        return lllllllllllIlIIIIlllIlIIIIIllIII.func_190647_dj() ? RenderVex.field_191344_j : RenderVex.field_191343_a;
    }
}
