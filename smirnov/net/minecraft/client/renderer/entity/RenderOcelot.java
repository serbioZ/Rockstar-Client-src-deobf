// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelOcelot;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.passive.EntityOcelot;

public class RenderOcelot extends RenderLiving<EntityOcelot>
{
    private static final /* synthetic */ ResourceLocation SIAMESE_OCELOT_TEXTURES;
    private static final /* synthetic */ ResourceLocation RED_OCELOT_TEXTURES;
    private static final /* synthetic */ ResourceLocation OCELOT_TEXTURES;
    private static final /* synthetic */ ResourceLocation BLACK_OCELOT_TEXTURES;
    
    public RenderOcelot(final RenderManager lllllllllllllllIlIlIIIIllllIllII) {
        super(lllllllllllllllIlIlIIIIllllIllII, new ModelOcelot(), 0.4f);
    }
    
    @Override
    protected void preRenderCallback(final EntityOcelot lllllllllllllllIlIlIIIIllllIIIIl, final float lllllllllllllllIlIlIIIIllllIIIII) {
        super.preRenderCallback(lllllllllllllllIlIlIIIIllllIIIIl, lllllllllllllllIlIlIIIIllllIIIII);
        if (lllllllllllllllIlIlIIIIllllIIIIl.isTamed()) {
            GlStateManager.scale(0.8f, 0.8f, 0.8f);
        }
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityOcelot lllllllllllllllIlIlIIIIllllIIlll) {
        switch (lllllllllllllllIlIlIIIIllllIIlll.getTameSkin()) {
            default: {
                return RenderOcelot.OCELOT_TEXTURES;
            }
            case 1: {
                return RenderOcelot.BLACK_OCELOT_TEXTURES;
            }
            case 2: {
                return RenderOcelot.RED_OCELOT_TEXTURES;
            }
            case 3: {
                return RenderOcelot.SIAMESE_OCELOT_TEXTURES;
            }
        }
    }
    
    static {
        BLACK_OCELOT_TEXTURES = new ResourceLocation("textures/entity/cat/black.png");
        OCELOT_TEXTURES = new ResourceLocation("textures/entity/cat/ocelot.png");
        RED_OCELOT_TEXTURES = new ResourceLocation("textures/entity/cat/red.png");
        SIAMESE_OCELOT_TEXTURES = new ResourceLocation("textures/entity/cat/siamese.png");
    }
}
