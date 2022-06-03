// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.init.Items;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityFireball;

public class RenderFireball extends Render<EntityFireball>
{
    private final /* synthetic */ float scale;
    
    public RenderFireball(final RenderManager llllllllllIllllIIlIlllIlIIIIllll, final float llllllllllIllllIIlIlllIlIIIIlllI) {
        super(llllllllllIllllIIlIlllIlIIIIllll);
        this.scale = llllllllllIllllIIlIlllIlIIIIlllI;
    }
    
    @Override
    public void doRender(final EntityFireball llllllllllIllllIIlIlllIIlllllIII, final double llllllllllIllllIIlIlllIIlllIIllI, final double llllllllllIllllIIlIlllIIllllIllI, final double llllllllllIllllIIlIlllIIlllIIlII, final float llllllllllIllllIIlIlllIIlllIIIll, final float llllllllllIllllIIlIlllIIlllIIIlI) {
        GlStateManager.pushMatrix();
        this.bindEntityTexture(llllllllllIllllIIlIlllIIlllllIII);
        GlStateManager.translate((float)llllllllllIllllIIlIlllIIlllIIllI, (float)llllllllllIllllIIlIlllIIllllIllI, (float)llllllllllIllllIIlIlllIIlllIIlII);
        GlStateManager.enableRescaleNormal();
        GlStateManager.scale(this.scale, this.scale, this.scale);
        final TextureAtlasSprite llllllllllIllllIIlIlllIIllllIIlI = Minecraft.getMinecraft().getRenderItem().getItemModelMesher().getParticleIcon(Items.FIRE_CHARGE);
        final Tessellator llllllllllIllllIIlIlllIIllllIIIl = Tessellator.getInstance();
        final BufferBuilder llllllllllIllllIIlIlllIIllllIIII = llllllllllIllllIIlIlllIIllllIIIl.getBuffer();
        final float llllllllllIllllIIlIlllIIlllIllll = llllllllllIllllIIlIlllIIllllIIlI.getMinU();
        final float llllllllllIllllIIlIlllIIlllIlllI = llllllllllIllllIIlIlllIIllllIIlI.getMaxU();
        final float llllllllllIllllIIlIlllIIlllIllIl = llllllllllIllllIIlIlllIIllllIIlI.getMinV();
        final float llllllllllIllllIIlIlllIIlllIllII = llllllllllIllllIIlIlllIIllllIIlI.getMaxV();
        final float llllllllllIllllIIlIlllIIlllIlIll = 1.0f;
        final float llllllllllIllllIIlIlllIIlllIlIlI = 0.5f;
        final float llllllllllIllllIIlIlllIIlllIlIIl = 0.25f;
        GlStateManager.rotate(180.0f - RenderManager.playerViewY, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(((this.renderManager.options.thirdPersonView == 2) ? -1 : 1) * -RenderManager.playerViewX, 1.0f, 0.0f, 0.0f);
        if (this.renderOutlines) {
            GlStateManager.enableColorMaterial();
            GlStateManager.enableOutlineMode(this.getTeamColor(llllllllllIllllIIlIlllIIlllllIII));
        }
        llllllllllIllllIIlIlllIIllllIIII.begin(7, DefaultVertexFormats.POSITION_TEX_NORMAL);
        llllllllllIllllIIlIlllIIllllIIII.pos(-0.5, -0.25, 0.0).tex(llllllllllIllllIIlIlllIIlllIllll, llllllllllIllllIIlIlllIIlllIllII).normal(0.0f, 1.0f, 0.0f).endVertex();
        llllllllllIllllIIlIlllIIllllIIII.pos(0.5, -0.25, 0.0).tex(llllllllllIllllIIlIlllIIlllIlllI, llllllllllIllllIIlIlllIIlllIllII).normal(0.0f, 1.0f, 0.0f).endVertex();
        llllllllllIllllIIlIlllIIllllIIII.pos(0.5, 0.75, 0.0).tex(llllllllllIllllIIlIlllIIlllIlllI, llllllllllIllllIIlIlllIIlllIllIl).normal(0.0f, 1.0f, 0.0f).endVertex();
        llllllllllIllllIIlIlllIIllllIIII.pos(-0.5, 0.75, 0.0).tex(llllllllllIllllIIlIlllIIlllIllll, llllllllllIllllIIlIlllIIlllIllIl).normal(0.0f, 1.0f, 0.0f).endVertex();
        llllllllllIllllIIlIlllIIllllIIIl.draw();
        if (this.renderOutlines) {
            GlStateManager.disableOutlineMode();
            GlStateManager.disableColorMaterial();
        }
        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        super.doRender(llllllllllIllllIIlIlllIIlllllIII, llllllllllIllllIIlIlllIIlllIIllI, llllllllllIllllIIlIlllIIllllIllI, llllllllllIllllIIlIlllIIlllIIlII, llllllllllIllllIIlIlllIIlllIIIll, llllllllllIllllIIlIlllIIlllIIIlI);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityFireball llllllllllIllllIIlIlllIIllIlIllI) {
        return TextureMap.LOCATION_BLOCKS_TEXTURE;
    }
}
