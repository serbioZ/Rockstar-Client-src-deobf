// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerCustomHead;
import net.minecraft.client.renderer.entity.layers.LayerElytra;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.client.model.ModelArmorStandArmor;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelArmorStand;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.item.EntityArmorStand;

public class RenderArmorStand extends RenderLivingBase<EntityArmorStand>
{
    public static final /* synthetic */ ResourceLocation TEXTURE_ARMOR_STAND;
    
    static {
        TEXTURE_ARMOR_STAND = new ResourceLocation("textures/entity/armorstand/wood.png");
    }
    
    @Override
    protected boolean canRenderName(final EntityArmorStand llllllllllllIlIlIIlIIIIllIllIIll) {
        return llllllllllllIlIlIIlIIIIllIllIIll.getAlwaysRenderNameTag();
    }
    
    @Override
    public void doRender(final EntityArmorStand llllllllllllIlIlIIlIIIIllIlIIIll, final double llllllllllllIlIlIIlIIIIllIlIlIIl, final double llllllllllllIlIlIIlIIIIllIlIlIII, final double llllllllllllIlIlIIlIIIIllIlIIIII, final float llllllllllllIlIlIIlIIIIllIIlllll, final float llllllllllllIlIlIIlIIIIllIlIIlIl) {
        if (llllllllllllIlIlIIlIIIIllIlIIIll.hasMarker()) {
            this.renderMarker = true;
        }
        super.doRender(llllllllllllIlIlIIlIIIIllIlIIIll, llllllllllllIlIlIIlIIIIllIlIlIIl, llllllllllllIlIlIIlIIIIllIlIlIII, llllllllllllIlIlIIlIIIIllIlIIIII, llllllllllllIlIlIIlIIIIllIIlllll, llllllllllllIlIlIIlIIIIllIlIIlIl);
        if (llllllllllllIlIlIIlIIIIllIlIIIll.hasMarker()) {
            this.renderMarker = false;
        }
    }
    
    @Override
    public ModelArmorStand getMainModel() {
        return (ModelArmorStand)super.getMainModel();
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityArmorStand llllllllllllIlIlIIlIIIIlllIIlIII) {
        return RenderArmorStand.TEXTURE_ARMOR_STAND;
    }
    
    public RenderArmorStand(final RenderManager llllllllllllIlIlIIlIIIIlllIIlIll) {
        super(llllllllllllIlIlIIlIIIIlllIIlIll, new ModelArmorStand(), 0.0f);
        final LayerBipedArmor llllllllllllIlIlIIlIIIIlllIIllIl = new LayerBipedArmor(this) {
            @Override
            protected void initArmor() {
                this.modelLeggings = (T)new ModelArmorStandArmor(0.5f);
                this.modelArmor = (T)new ModelArmorStandArmor(1.0f);
            }
        };
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(llllllllllllIlIlIIlIIIIlllIIllIl);
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerHeldItem(this));
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerElytra(this));
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerCustomHead(this.getMainModel().bipedHead));
    }
    
    @Override
    protected void rotateCorpse(final EntityArmorStand llllllllllllIlIlIIlIIIIllIlllIlI, final float llllllllllllIlIlIIlIIIIllIlllllI, final float llllllllllllIlIlIIlIIIIllIllllIl, final float llllllllllllIlIlIIlIIIIllIlllIII) {
        GlStateManager.rotate(180.0f - llllllllllllIlIlIIlIIIIllIllllIl, 0.0f, 1.0f, 0.0f);
        final float llllllllllllIlIlIIlIIIIllIlllIll = llllllllllllIlIlIIlIIIIllIlllIlI.world.getTotalWorldTime() - llllllllllllIlIlIIlIIIIllIlllIlI.punchCooldown + llllllllllllIlIlIIlIIIIllIlllIII;
        if (llllllllllllIlIlIIlIIIIllIlllIll < 5.0f) {
            GlStateManager.rotate(MathHelper.sin(llllllllllllIlIlIIlIIIIllIlllIll / 1.5f * 3.1415927f) * 3.0f, 0.0f, 1.0f, 0.0f);
        }
    }
}
