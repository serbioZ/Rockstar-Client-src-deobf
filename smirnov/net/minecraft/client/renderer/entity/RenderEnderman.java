// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.layers.LayerHeldBlock;
import net.minecraft.client.renderer.entity.layers.LayerEndermanEyes;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelEnderman;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import java.util.Random;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.monster.EntityEnderman;

public class RenderEnderman extends RenderLiving<EntityEnderman>
{
    private static final /* synthetic */ ResourceLocation ENDERMAN_TEXTURES;
    private final /* synthetic */ Random rnd;
    
    @Override
    public void doRender(final EntityEnderman lllllllllllllllIIIllllIllIlIlIlI, double lllllllllllllllIIIllllIllIlIlIIl, final double lllllllllllllllIIIllllIllIllIIlI, double lllllllllllllllIIIllllIllIlIIlll, final float lllllllllllllllIIIllllIllIllIIII, final float lllllllllllllllIIIllllIllIlIllll) {
        final IBlockState lllllllllllllllIIIllllIllIlIlllI = lllllllllllllllIIIllllIllIlIlIlI.getHeldBlockState();
        final ModelEnderman lllllllllllllllIIIllllIllIlIllIl = this.getMainModel();
        lllllllllllllllIIIllllIllIlIllIl.isCarrying = (lllllllllllllllIIIllllIllIlIlllI != null);
        lllllllllllllllIIIllllIllIlIllIl.isAttacking = lllllllllllllllIIIllllIllIlIlIlI.isScreaming();
        if (lllllllllllllllIIIllllIllIlIlIlI.isScreaming()) {
            final double lllllllllllllllIIIllllIllIlIllII = 0.02;
            lllllllllllllllIIIllllIllIlIlIIl += this.rnd.nextGaussian() * 0.02;
            lllllllllllllllIIIllllIllIlIIlll += this.rnd.nextGaussian() * 0.02;
        }
        super.doRender(lllllllllllllllIIIllllIllIlIlIlI, lllllllllllllllIIIllllIllIlIlIIl, lllllllllllllllIIIllllIllIllIIlI, (double)lllllllllllllllIIIllllIllIlIIlll, lllllllllllllllIIIllllIllIllIIII, lllllllllllllllIIIllllIllIlIllll);
    }
    
    @Override
    public ModelEnderman getMainModel() {
        return (ModelEnderman)super.getMainModel();
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityEnderman lllllllllllllllIIIllllIllIlIIIII) {
        return RenderEnderman.ENDERMAN_TEXTURES;
    }
    
    static {
        ENDERMAN_TEXTURES = new ResourceLocation("textures/entity/enderman/enderman.png");
    }
    
    public RenderEnderman(final RenderManager lllllllllllllllIIIllllIlllIIIIll) {
        super(lllllllllllllllIIIllllIlllIIIIll, new ModelEnderman(0.0f), 0.5f);
        this.rnd = new Random();
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerEndermanEyes(this));
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerHeldBlock(this));
    }
}
