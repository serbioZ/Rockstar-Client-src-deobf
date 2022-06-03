// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.layers.LayerCustomHead;
import net.minecraft.client.model.ModelVillager;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.passive.EntityVillager;

public class RenderVillager extends RenderLiving<EntityVillager>
{
    private static final /* synthetic */ ResourceLocation LIBRARIAN_VILLAGER_TEXTURES;
    private static final /* synthetic */ ResourceLocation FARMER_VILLAGER_TEXTURES;
    private static final /* synthetic */ ResourceLocation PRIEST_VILLAGER_TEXTURES;
    private static final /* synthetic */ ResourceLocation VILLAGER_TEXTURES;
    private static final /* synthetic */ ResourceLocation SMITH_VILLAGER_TEXTURES;
    private static final /* synthetic */ ResourceLocation BUTCHER_VILLAGER_TEXTURES;
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityVillager lllllllllllIIlllllIllllllIlIlIll) {
        switch (lllllllllllIIlllllIllllllIlIlIll.getProfession()) {
            case 0: {
                return RenderVillager.FARMER_VILLAGER_TEXTURES;
            }
            case 1: {
                return RenderVillager.LIBRARIAN_VILLAGER_TEXTURES;
            }
            case 2: {
                return RenderVillager.PRIEST_VILLAGER_TEXTURES;
            }
            case 3: {
                return RenderVillager.SMITH_VILLAGER_TEXTURES;
            }
            case 4: {
                return RenderVillager.BUTCHER_VILLAGER_TEXTURES;
            }
            default: {
                return RenderVillager.VILLAGER_TEXTURES;
            }
        }
    }
    
    static {
        VILLAGER_TEXTURES = new ResourceLocation("textures/entity/villager/villager.png");
        FARMER_VILLAGER_TEXTURES = new ResourceLocation("textures/entity/villager/farmer.png");
        LIBRARIAN_VILLAGER_TEXTURES = new ResourceLocation("textures/entity/villager/librarian.png");
        PRIEST_VILLAGER_TEXTURES = new ResourceLocation("textures/entity/villager/priest.png");
        SMITH_VILLAGER_TEXTURES = new ResourceLocation("textures/entity/villager/smith.png");
        BUTCHER_VILLAGER_TEXTURES = new ResourceLocation("textures/entity/villager/butcher.png");
    }
    
    @Override
    protected void preRenderCallback(final EntityVillager lllllllllllIIlllllIllllllIlIIllI, final float lllllllllllIIlllllIllllllIlIIlIl) {
        float lllllllllllIIlllllIllllllIlIIlII = 0.9375f;
        if (lllllllllllIIlllllIllllllIlIIllI.getGrowingAge() < 0) {
            lllllllllllIIlllllIllllllIlIIlII *= 0.5;
            this.shadowSize = 0.25f;
        }
        else {
            this.shadowSize = 0.5f;
        }
        GlStateManager.scale(lllllllllllIIlllllIllllllIlIIlII, lllllllllllIIlllllIllllllIlIIlII, lllllllllllIIlllllIllllllIlIIlII);
    }
    
    @Override
    public ModelVillager getMainModel() {
        return (ModelVillager)super.getMainModel();
    }
    
    public RenderVillager(final RenderManager lllllllllllIIlllllIllllllIllIIlI) {
        super(lllllllllllIIlllllIllllllIllIIlI, new ModelVillager(0.0f), 0.5f);
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerCustomHead(this.getMainModel().villagerHead));
    }
}
