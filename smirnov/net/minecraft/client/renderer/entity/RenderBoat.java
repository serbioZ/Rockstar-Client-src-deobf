// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.util.math.MathHelper;
import net.minecraft.client.model.ModelBoat;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.IMultipassModel;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.item.EntityBoat;

public class RenderBoat extends Render<EntityBoat>
{
    protected /* synthetic */ ModelBase modelBoat;
    private static final /* synthetic */ ResourceLocation[] BOAT_TEXTURES;
    
    static {
        BOAT_TEXTURES = new ResourceLocation[] { new ResourceLocation("textures/entity/boat/boat_oak.png"), new ResourceLocation("textures/entity/boat/boat_spruce.png"), new ResourceLocation("textures/entity/boat/boat_birch.png"), new ResourceLocation("textures/entity/boat/boat_jungle.png"), new ResourceLocation("textures/entity/boat/boat_acacia.png"), new ResourceLocation("textures/entity/boat/boat_darkoak.png") };
    }
    
    @Override
    public void renderMultipass(final EntityBoat lllllllllllIIIIlIlIlllIlllIlllll, final double lllllllllllIIIIlIlIlllIlllIllllI, final double lllllllllllIIIIlIlIlllIlllIlIllI, final double lllllllllllIIIIlIlIlllIlllIlIlIl, final float lllllllllllIIIIlIlIlllIlllIlIlII, final float lllllllllllIIIIlIlIlllIlllIlIIll) {
        GlStateManager.pushMatrix();
        this.setupTranslation(lllllllllllIIIIlIlIlllIlllIllllI, lllllllllllIIIIlIlIlllIlllIlIllI, lllllllllllIIIIlIlIlllIlllIlIlIl);
        this.setupRotation(lllllllllllIIIIlIlIlllIlllIlllll, lllllllllllIIIIlIlIlllIlllIlIlII, lllllllllllIIIIlIlIlllIlllIlIIll);
        this.bindEntityTexture(lllllllllllIIIIlIlIlllIlllIlllll);
        ((IMultipassModel)this.modelBoat).renderMultipass(lllllllllllIIIIlIlIlllIlllIlllll, lllllllllllIIIIlIlIlllIlllIlIIll, 0.0f, -0.1f, 0.0f, 0.0f, 0.0625f);
        GlStateManager.popMatrix();
    }
    
    public void setupTranslation(final double lllllllllllIIIIlIlIlllIllllIllll, final double lllllllllllIIIIlIlIlllIlllllIIIl, final double lllllllllllIIIIlIlIlllIlllllIIII) {
        GlStateManager.translate((float)lllllllllllIIIIlIlIlllIllllIllll, (float)lllllllllllIIIIlIlIlllIlllllIIIl + 0.375f, (float)lllllllllllIIIIlIlIlllIlllllIIII);
    }
    
    @Override
    public void doRender(final EntityBoat lllllllllllIIIIlIlIllllIIIIIllII, final double lllllllllllIIIIlIlIllllIIIIIlIll, final double lllllllllllIIIIlIlIllllIIIIIlIlI, final double lllllllllllIIIIlIlIllllIIIIIlIIl, final float lllllllllllIIIIlIlIllllIIIIIlIII, final float lllllllllllIIIIlIlIllllIIIIIlllI) {
        GlStateManager.pushMatrix();
        this.setupTranslation(lllllllllllIIIIlIlIllllIIIIIlIll, lllllllllllIIIIlIlIllllIIIIIlIlI, lllllllllllIIIIlIlIllllIIIIIlIIl);
        this.setupRotation(lllllllllllIIIIlIlIllllIIIIIllII, lllllllllllIIIIlIlIllllIIIIIlIII, lllllllllllIIIIlIlIllllIIIIIlllI);
        this.bindEntityTexture(lllllllllllIIIIlIlIllllIIIIIllII);
        if (this.renderOutlines) {
            GlStateManager.enableColorMaterial();
            GlStateManager.enableOutlineMode(this.getTeamColor(lllllllllllIIIIlIlIllllIIIIIllII));
        }
        this.modelBoat.render(lllllllllllIIIIlIlIllllIIIIIllII, lllllllllllIIIIlIlIllllIIIIIlllI, 0.0f, -0.1f, 0.0f, 0.0f, 0.0625f);
        if (this.renderOutlines) {
            GlStateManager.disableOutlineMode();
            GlStateManager.disableColorMaterial();
        }
        GlStateManager.popMatrix();
        super.doRender(lllllllllllIIIIlIlIllllIIIIIllII, lllllllllllIIIIlIlIllllIIIIIlIll, lllllllllllIIIIlIlIllllIIIIIlIlI, lllllllllllIIIIlIlIllllIIIIIlIIl, lllllllllllIIIIlIlIllllIIIIIlIII, lllllllllllIIIIlIlIllllIIIIIlllI);
    }
    
    public RenderBoat(final RenderManager lllllllllllIIIIlIlIllllIIIIlllII) {
        super(lllllllllllIIIIlIlIllllIIIIlllII);
        this.modelBoat = new ModelBoat();
        this.shadowSize = 0.5f;
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityBoat lllllllllllIIIIlIlIlllIllllIlIlI) {
        return RenderBoat.BOAT_TEXTURES[lllllllllllIIIIlIlIlllIllllIlIlI.getBoatType().ordinal()];
    }
    
    @Override
    public boolean isMultipass() {
        return true;
    }
    
    public void setupRotation(final EntityBoat lllllllllllIIIIlIlIllllIIIIIIIII, final float lllllllllllIIIIlIlIlllIlllllllll, final float lllllllllllIIIIlIlIlllIllllllIIl) {
        GlStateManager.rotate(180.0f - lllllllllllIIIIlIlIlllIlllllllll, 0.0f, 1.0f, 0.0f);
        final float lllllllllllIIIIlIlIlllIlllllllIl = lllllllllllIIIIlIlIllllIIIIIIIII.getTimeSinceHit() - lllllllllllIIIIlIlIlllIllllllIIl;
        float lllllllllllIIIIlIlIlllIlllllllII = lllllllllllIIIIlIlIllllIIIIIIIII.getDamageTaken() - lllllllllllIIIIlIlIlllIllllllIIl;
        if (lllllllllllIIIIlIlIlllIlllllllII < 0.0f) {
            lllllllllllIIIIlIlIlllIlllllllII = 0.0f;
        }
        if (lllllllllllIIIIlIlIlllIlllllllIl > 0.0f) {
            GlStateManager.rotate(MathHelper.sin(lllllllllllIIIIlIlIlllIlllllllIl) * lllllllllllIIIIlIlIlllIlllllllIl * lllllllllllIIIIlIlIlllIlllllllII / 10.0f * lllllllllllIIIIlIlIllllIIIIIIIII.getForwardDirection(), 1.0f, 0.0f, 0.0f);
        }
        GlStateManager.scale(-1.0f, -1.0f, 1.0f);
    }
}
