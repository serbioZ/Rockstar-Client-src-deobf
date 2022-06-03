// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.entity.Entity;

public class RenderSnowball<T extends Entity> extends Render<T>
{
    private final /* synthetic */ RenderItem itemRenderer;
    protected final /* synthetic */ Item item;
    
    public RenderSnowball(final RenderManager llllllllllllIIIIlIIlllIIlllIIlII, final Item llllllllllllIIIIlIIlllIIlllIIIll, final RenderItem llllllllllllIIIIlIIlllIIlllIIllI) {
        super(llllllllllllIIIIlIIlllIIlllIIlII);
        this.item = llllllllllllIIIIlIIlllIIlllIIIll;
        this.itemRenderer = llllllllllllIIIIlIIlllIIlllIIllI;
    }
    
    public ItemStack getStackToRender(final T llllllllllllIIIIlIIlllIIllIIlIlI) {
        return new ItemStack(this.item);
    }
    
    @Override
    public void doRender(final T llllllllllllIIIIlIIlllIIllIlIIlI, final double llllllllllllIIIIlIIlllIIllIlIIIl, final double llllllllllllIIIIlIIlllIIllIlIIII, final double llllllllllllIIIIlIIlllIIllIIllll, final float llllllllllllIIIIlIIlllIIllIlIlIl, final float llllllllllllIIIIlIIlllIIllIlIlII) {
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)llllllllllllIIIIlIIlllIIllIlIIIl, (float)llllllllllllIIIIlIIlllIIllIlIIII, (float)llllllllllllIIIIlIIlllIIllIIllll);
        GlStateManager.enableRescaleNormal();
        GlStateManager.rotate(-RenderManager.playerViewY, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(((this.renderManager.options.thirdPersonView == 2) ? -1 : 1) * RenderManager.playerViewX, 1.0f, 0.0f, 0.0f);
        GlStateManager.rotate(180.0f, 0.0f, 1.0f, 0.0f);
        this.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
        if (this.renderOutlines) {
            GlStateManager.enableColorMaterial();
            GlStateManager.enableOutlineMode(this.getTeamColor(llllllllllllIIIIlIIlllIIllIlIIlI));
        }
        this.itemRenderer.renderItem(this.getStackToRender(llllllllllllIIIIlIIlllIIllIlIIlI), ItemCameraTransforms.TransformType.GROUND);
        if (this.renderOutlines) {
            GlStateManager.disableOutlineMode();
            GlStateManager.disableColorMaterial();
        }
        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        super.doRender(llllllllllllIIIIlIIlllIIllIlIIlI, llllllllllllIIIIlIIlllIIllIlIIIl, llllllllllllIIIIlIIlllIIllIlIIII, llllllllllllIIIIlIIlllIIllIIllll, llllllllllllIIIIlIIlllIIllIlIlIl, llllllllllllIIIIlIIlllIIllIlIlII);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity llllllllllllIIIIlIIlllIIllIIIlll) {
        return TextureMap.LOCATION_BLOCKS_TEXTURE;
    }
}
