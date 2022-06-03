// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.model.ModelLlamaSpit;
import net.minecraft.entity.projectile.EntityLlamaSpit;

public class RenderLlamaSpit extends Render<EntityLlamaSpit>
{
    private final /* synthetic */ ModelLlamaSpit field_191334_f;
    private static final /* synthetic */ ResourceLocation field_191333_a;
    
    @Override
    public void doRender(final EntityLlamaSpit llllllllllllIIllIIlIlIlllIIIlIll, final double llllllllllllIIllIIlIlIlllIIlIIIl, final double llllllllllllIIllIIlIlIlllIIlIIII, final double llllllllllllIIllIIlIlIlllIIIlIII, final float llllllllllllIIllIIlIlIlllIIIlllI, final float llllllllllllIIllIIlIlIlllIIIllIl) {
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)llllllllllllIIllIIlIlIlllIIlIIIl, (float)llllllllllllIIllIIlIlIlllIIlIIII + 0.15f, (float)llllllllllllIIllIIlIlIlllIIIlIII);
        GlStateManager.rotate(llllllllllllIIllIIlIlIlllIIIlIll.prevRotationYaw + (llllllllllllIIllIIlIlIlllIIIlIll.rotationYaw - llllllllllllIIllIIlIlIlllIIIlIll.prevRotationYaw) * llllllllllllIIllIIlIlIlllIIIllIl - 90.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(llllllllllllIIllIIlIlIlllIIIlIll.prevRotationPitch + (llllllllllllIIllIIlIlIlllIIIlIll.rotationPitch - llllllllllllIIllIIlIlIlllIIIlIll.prevRotationPitch) * llllllllllllIIllIIlIlIlllIIIllIl, 0.0f, 0.0f, 1.0f);
        this.bindEntityTexture(llllllllllllIIllIIlIlIlllIIIlIll);
        if (this.renderOutlines) {
            GlStateManager.enableColorMaterial();
            GlStateManager.enableOutlineMode(this.getTeamColor(llllllllllllIIllIIlIlIlllIIIlIll));
        }
        this.field_191334_f.render(llllllllllllIIllIIlIlIlllIIIlIll, llllllllllllIIllIIlIlIlllIIIllIl, 0.0f, -0.1f, 0.0f, 0.0f, 0.0625f);
        if (this.renderOutlines) {
            GlStateManager.disableOutlineMode();
            GlStateManager.disableColorMaterial();
        }
        GlStateManager.popMatrix();
        super.doRender(llllllllllllIIllIIlIlIlllIIIlIll, llllllllllllIIllIIlIlIlllIIlIIIl, llllllllllllIIllIIlIlIlllIIlIIII, llllllllllllIIllIIlIlIlllIIIlIII, llllllllllllIIllIIlIlIlllIIIlllI, llllllllllllIIllIIlIlIlllIIIllIl);
    }
    
    static {
        field_191333_a = new ResourceLocation("textures/entity/llama/spit.png");
    }
    
    public RenderLlamaSpit(final RenderManager llllllllllllIIllIIlIlIlllIIlllIl) {
        super(llllllllllllIIllIIlIlIlllIIlllIl);
        this.field_191334_f = new ModelLlamaSpit();
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityLlamaSpit llllllllllllIIllIIlIlIlllIIIIlII) {
        return RenderLlamaSpit.field_191333_a;
    }
}
