// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRabbit;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.passive.EntityRabbit;

public class RenderRabbit extends RenderLiving<EntityRabbit>
{
    private static final /* synthetic */ ResourceLocation SALT;
    private static final /* synthetic */ ResourceLocation GOLD;
    private static final /* synthetic */ ResourceLocation WHITE_SPLOTCHED;
    private static final /* synthetic */ ResourceLocation TOAST;
    private static final /* synthetic */ ResourceLocation BROWN;
    private static final /* synthetic */ ResourceLocation BLACK;
    private static final /* synthetic */ ResourceLocation CAERBANNOG;
    private static final /* synthetic */ ResourceLocation WHITE;
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityRabbit llllllllllllllIIlIIlIIllIIIlllII) {
        final String llllllllllllllIIlIIlIIllIIIllIll = TextFormatting.getTextWithoutFormattingCodes(llllllllllllllIIlIIlIIllIIIlllII.getName());
        if (llllllllllllllIIlIIlIIllIIIllIll != null && "Toast".equals(llllllllllllllIIlIIlIIllIIIllIll)) {
            return RenderRabbit.TOAST;
        }
        switch (llllllllllllllIIlIIlIIllIIIlllII.getRabbitType()) {
            default: {
                return RenderRabbit.BROWN;
            }
            case 1: {
                return RenderRabbit.WHITE;
            }
            case 2: {
                return RenderRabbit.BLACK;
            }
            case 3: {
                return RenderRabbit.WHITE_SPLOTCHED;
            }
            case 4: {
                return RenderRabbit.GOLD;
            }
            case 5: {
                return RenderRabbit.SALT;
            }
            case 99: {
                return RenderRabbit.CAERBANNOG;
            }
        }
    }
    
    public RenderRabbit(final RenderManager llllllllllllllIIlIIlIIllIIlIIIII) {
        super(llllllllllllllIIlIIlIIllIIlIIIII, new ModelRabbit(), 0.3f);
    }
    
    static {
        BROWN = new ResourceLocation("textures/entity/rabbit/brown.png");
        WHITE = new ResourceLocation("textures/entity/rabbit/white.png");
        BLACK = new ResourceLocation("textures/entity/rabbit/black.png");
        GOLD = new ResourceLocation("textures/entity/rabbit/gold.png");
        SALT = new ResourceLocation("textures/entity/rabbit/salt.png");
        WHITE_SPLOTCHED = new ResourceLocation("textures/entity/rabbit/white_splotched.png");
        TOAST = new ResourceLocation("textures/entity/rabbit/toast.png");
        CAERBANNOG = new ResourceLocation("textures/entity/rabbit/caerbannog.png");
    }
}
