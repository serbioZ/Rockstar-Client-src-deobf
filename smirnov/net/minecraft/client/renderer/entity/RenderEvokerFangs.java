// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelEvokerFangs;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.projectile.EntityEvokerFangs;

public class RenderEvokerFangs extends Render<EntityEvokerFangs>
{
    private static final /* synthetic */ ResourceLocation field_191329_a;
    private final /* synthetic */ ModelEvokerFangs field_191330_f;
    
    public RenderEvokerFangs(final RenderManager llllllllllllIlIIIlIlllIllIIlIlIl) {
        super(llllllllllllIlIIIlIlllIllIIlIlIl);
        this.field_191330_f = new ModelEvokerFangs();
    }
    
    static {
        field_191329_a = new ResourceLocation("textures/entity/illager/fangs.png");
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityEvokerFangs llllllllllllIlIIIlIlllIlIlllIlIl) {
        return RenderEvokerFangs.field_191329_a;
    }
    
    @Override
    public void doRender(final EntityEvokerFangs llllllllllllIlIIIlIlllIlIlllllll, final double llllllllllllIlIIIlIlllIlIllllllI, final double llllllllllllIlIIIlIlllIllIIIIlll, final double llllllllllllIlIIIlIlllIllIIIIllI, final float llllllllllllIlIIIlIlllIllIIIIlIl, final float llllllllllllIlIIIlIlllIlIllllIlI) {
        final float llllllllllllIlIIIlIlllIllIIIIIll = llllllllllllIlIIIlIlllIlIlllllll.func_190550_a(llllllllllllIlIIIlIlllIlIllllIlI);
        if (llllllllllllIlIIIlIlllIllIIIIIll != 0.0f) {
            float llllllllllllIlIIIlIlllIllIIIIIlI = 2.0f;
            if (llllllllllllIlIIIlIlllIllIIIIIll > 0.9f) {
                llllllllllllIlIIIlIlllIllIIIIIlI *= (float)((1.0 - llllllllllllIlIIIlIlllIllIIIIIll) / 0.10000000149011612);
            }
            GlStateManager.pushMatrix();
            GlStateManager.disableCull();
            GlStateManager.enableAlpha();
            this.bindEntityTexture(llllllllllllIlIIIlIlllIlIlllllll);
            GlStateManager.translate((float)llllllllllllIlIIIlIlllIlIllllllI, (float)llllllllllllIlIIIlIlllIllIIIIlll, (float)llllllllllllIlIIIlIlllIllIIIIllI);
            GlStateManager.rotate(90.0f - llllllllllllIlIIIlIlllIlIlllllll.rotationYaw, 0.0f, 1.0f, 0.0f);
            GlStateManager.scale(-llllllllllllIlIIIlIlllIllIIIIIlI, -llllllllllllIlIIIlIlllIllIIIIIlI, llllllllllllIlIIIlIlllIllIIIIIlI);
            final float llllllllllllIlIIIlIlllIllIIIIIIl = 0.03125f;
            GlStateManager.translate(0.0f, -0.626f, 0.0f);
            this.field_191330_f.render(llllllllllllIlIIIlIlllIlIlllllll, llllllllllllIlIIIlIlllIllIIIIIll, 0.0f, 0.0f, llllllllllllIlIIIlIlllIlIlllllll.rotationYaw, llllllllllllIlIIIlIlllIlIlllllll.rotationPitch, 0.03125f);
            GlStateManager.popMatrix();
            GlStateManager.enableCull();
            super.doRender(llllllllllllIlIIIlIlllIlIlllllll, llllllllllllIlIIIlIlllIlIllllllI, llllllllllllIlIIIlIlllIllIIIIlll, llllllllllllIlIIIlIlllIllIIIIllI, llllllllllllIlIIIlIlllIllIIIIlIl, llllllllllllIlIIIlIlllIlIllllIlI);
        }
    }
}
