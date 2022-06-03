// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.model.ModelEnderCrystal;
import net.minecraft.client.model.ModelBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.item.EntityEnderCrystal;

public class RenderEnderCrystal extends Render<EntityEnderCrystal>
{
    private static final /* synthetic */ ResourceLocation ENDER_CRYSTAL_TEXTURES;
    private final /* synthetic */ ModelBase modelEnderCrystalNoBase;
    private final /* synthetic */ ModelBase modelEnderCrystal;
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityEnderCrystal lllllllllllllIIIlIllIlIlllIIIIIl) {
        return RenderEnderCrystal.ENDER_CRYSTAL_TEXTURES;
    }
    
    public RenderEnderCrystal(final RenderManager lllllllllllllIIIlIllIlIlllllIlIl) {
        super(lllllllllllllIIIlIllIlIlllllIlIl);
        this.modelEnderCrystal = new ModelEnderCrystal(0.0f, true);
        this.modelEnderCrystalNoBase = new ModelEnderCrystal(0.0f, false);
        this.shadowSize = 0.5f;
    }
    
    static {
        ENDER_CRYSTAL_TEXTURES = new ResourceLocation("textures/entity/endercrystal/endercrystal.png");
    }
    
    @Override
    public boolean shouldRender(final EntityEnderCrystal lllllllllllllIIIlIllIlIllIlllIIl, final ICamera lllllllllllllIIIlIllIlIllIlllIII, final double lllllllllllllIIIlIllIlIllIllIIIl, final double lllllllllllllIIIlIllIlIllIllIllI, final double lllllllllllllIIIlIllIlIllIllIlIl) {
        return super.shouldRender(lllllllllllllIIIlIllIlIllIlllIIl, lllllllllllllIIIlIllIlIllIlllIII, lllllllllllllIIIlIllIlIllIllIIIl, lllllllllllllIIIlIllIlIllIllIllI, lllllllllllllIIIlIllIlIllIllIlIl) || lllllllllllllIIIlIllIlIllIlllIIl.getBeamTarget() != null;
    }
    
    @Override
    public void doRender(final EntityEnderCrystal lllllllllllllIIIlIllIlIlllIlIIIl, final double lllllllllllllIIIlIllIlIllllIIIII, final double lllllllllllllIIIlIllIlIlllIIllll, final double lllllllllllllIIIlIllIlIlllIIlllI, final float lllllllllllllIIIlIllIlIlllIIllIl, final float lllllllllllllIIIlIllIlIlllIIllII) {
        final float lllllllllllllIIIlIllIlIlllIllIll = lllllllllllllIIIlIllIlIlllIlIIIl.innerRotation + lllllllllllllIIIlIllIlIlllIIllII;
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)lllllllllllllIIIlIllIlIllllIIIII, (float)lllllllllllllIIIlIllIlIlllIIllll, (float)lllllllllllllIIIlIllIlIlllIIlllI);
        this.bindTexture(RenderEnderCrystal.ENDER_CRYSTAL_TEXTURES);
        float lllllllllllllIIIlIllIlIlllIllIlI = MathHelper.sin(lllllllllllllIIIlIllIlIlllIllIll * 0.2f) / 2.0f + 0.5f;
        lllllllllllllIIIlIllIlIlllIllIlI += lllllllllllllIIIlIllIlIlllIllIlI * lllllllllllllIIIlIllIlIlllIllIlI;
        if (this.renderOutlines) {
            GlStateManager.enableColorMaterial();
            GlStateManager.enableOutlineMode(this.getTeamColor(lllllllllllllIIIlIllIlIlllIlIIIl));
        }
        if (lllllllllllllIIIlIllIlIlllIlIIIl.shouldShowBottom()) {
            this.modelEnderCrystal.render(lllllllllllllIIIlIllIlIlllIlIIIl, 0.0f, lllllllllllllIIIlIllIlIlllIllIll * 3.0f, lllllllllllllIIIlIllIlIlllIllIlI * 0.2f, 0.0f, 0.0f, 0.0625f);
        }
        else {
            this.modelEnderCrystalNoBase.render(lllllllllllllIIIlIllIlIlllIlIIIl, 0.0f, lllllllllllllIIIlIllIlIlllIllIll * 3.0f, lllllllllllllIIIlIllIlIlllIllIlI * 0.2f, 0.0f, 0.0f, 0.0625f);
        }
        if (this.renderOutlines) {
            GlStateManager.disableOutlineMode();
            GlStateManager.disableColorMaterial();
        }
        GlStateManager.popMatrix();
        final BlockPos lllllllllllllIIIlIllIlIlllIllIIl = lllllllllllllIIIlIllIlIlllIlIIIl.getBeamTarget();
        if (lllllllllllllIIIlIllIlIlllIllIIl != null) {
            this.bindTexture(RenderDragon.ENDERCRYSTAL_BEAM_TEXTURES);
            final float lllllllllllllIIIlIllIlIlllIllIII = lllllllllllllIIIlIllIlIlllIllIIl.getX() + 0.5f;
            final float lllllllllllllIIIlIllIlIlllIlIlll = lllllllllllllIIIlIllIlIlllIllIIl.getY() + 0.5f;
            final float lllllllllllllIIIlIllIlIlllIlIllI = lllllllllllllIIIlIllIlIlllIllIIl.getZ() + 0.5f;
            final double lllllllllllllIIIlIllIlIlllIlIlIl = lllllllllllllIIIlIllIlIlllIllIII - lllllllllllllIIIlIllIlIlllIlIIIl.posX;
            final double lllllllllllllIIIlIllIlIlllIlIlII = lllllllllllllIIIlIllIlIlllIlIlll - lllllllllllllIIIlIllIlIlllIlIIIl.posY;
            final double lllllllllllllIIIlIllIlIlllIlIIll = lllllllllllllIIIlIllIlIlllIlIllI - lllllllllllllIIIlIllIlIlllIlIIIl.posZ;
            RenderDragon.renderCrystalBeams(lllllllllllllIIIlIllIlIllllIIIII + lllllllllllllIIIlIllIlIlllIlIlIl, lllllllllllllIIIlIllIlIlllIIllll - 0.3 + lllllllllllllIIIlIllIlIlllIllIlI * 0.4f + lllllllllllllIIIlIllIlIlllIlIlII, lllllllllllllIIIlIllIlIlllIIlllI + lllllllllllllIIIlIllIlIlllIlIIll, lllllllllllllIIIlIllIlIlllIIllII, lllllllllllllIIIlIllIlIlllIllIII, lllllllllllllIIIlIllIlIlllIlIlll, lllllllllllllIIIlIllIlIlllIlIllI, lllllllllllllIIIlIllIlIlllIlIIIl.innerRotation, lllllllllllllIIIlIllIlIlllIlIIIl.posX, lllllllllllllIIIlIllIlIlllIlIIIl.posY, lllllllllllllIIIlIllIlIlllIlIIIl.posZ);
        }
        super.doRender(lllllllllllllIIIlIllIlIlllIlIIIl, lllllllllllllIIIlIllIlIllllIIIII, lllllllllllllIIIlIllIlIlllIIllll, lllllllllllllIIIlIllIlIlllIIlllI, lllllllllllllIIIlIllIlIlllIIllIl, lllllllllllllIIIlIllIlIlllIIllII);
    }
}
