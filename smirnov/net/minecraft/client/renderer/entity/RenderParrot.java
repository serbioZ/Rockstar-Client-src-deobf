// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelParrot;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.passive.EntityParrot;

public class RenderParrot extends RenderLiving<EntityParrot>
{
    public static final /* synthetic */ ResourceLocation[] field_192862_a;
    
    private float func_192861_b(final EntityParrot llllllllllllIIIllIlIlIlIIlIlllll, final float llllllllllllIIIllIlIlIlIIllIIIlI) {
        final float llllllllllllIIIllIlIlIlIIllIIIIl = llllllllllllIIIllIlIlIlIIlIlllll.field_192011_bE + (llllllllllllIIIllIlIlIlIIlIlllll.field_192008_bB - llllllllllllIIIllIlIlIlIIlIlllll.field_192011_bE) * llllllllllllIIIllIlIlIlIIllIIIlI;
        final float llllllllllllIIIllIlIlIlIIllIIIII = llllllllllllIIIllIlIlIlIIlIlllll.field_192010_bD + (llllllllllllIIIllIlIlIlIIlIlllll.field_192009_bC - llllllllllllIIIllIlIlIlIIlIlllll.field_192010_bD) * llllllllllllIIIllIlIlIlIIllIIIlI;
        return (MathHelper.sin(llllllllllllIIIllIlIlIlIIllIIIIl) + 1.0f) * llllllllllllIIIllIlIlIlIIllIIIII;
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityParrot llllllllllllIIIllIlIlIlIIlllIIll) {
        return RenderParrot.field_192862_a[llllllllllllIIIllIlIlIlIIlllIIll.func_191998_ds()];
    }
    
    static {
        field_192862_a = new ResourceLocation[] { new ResourceLocation("textures/entity/parrot/parrot_red_blue.png"), new ResourceLocation("textures/entity/parrot/parrot_blue.png"), new ResourceLocation("textures/entity/parrot/parrot_green.png"), new ResourceLocation("textures/entity/parrot/parrot_yellow_blue.png"), new ResourceLocation("textures/entity/parrot/parrot_grey.png") };
    }
    
    public float handleRotationFloat(final EntityParrot llllllllllllIIIllIlIlIlIIllIlIlI, final float llllllllllllIIIllIlIlIlIIllIllII) {
        return this.func_192861_b(llllllllllllIIIllIlIlIlIIllIlIlI, llllllllllllIIIllIlIlIlIIllIllII);
    }
    
    public RenderParrot(final RenderManager llllllllllllIIIllIlIlIlIIllllIII) {
        super(llllllllllllIIIllIlIlIlIIllllIII, new ModelParrot(), 0.3f);
    }
}
