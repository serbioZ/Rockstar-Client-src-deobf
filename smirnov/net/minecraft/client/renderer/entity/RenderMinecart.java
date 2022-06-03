// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.client.model.ModelMinecart;
import net.minecraft.client.Minecraft;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.Vec3d;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.item.EntityMinecart;

public class RenderMinecart<T extends EntityMinecart> extends Render<T>
{
    private static final /* synthetic */ ResourceLocation MINECART_TEXTURES;
    protected /* synthetic */ ModelBase modelMinecart;
    
    @Override
    public void doRender(final T lllllllllllIIlllIIlIIIlIllIlllll, double lllllllllllIIlllIIlIIIlIllIllllI, double lllllllllllIIlllIIlIIIlIllIlllIl, double lllllllllllIIlllIIlIIIlIllIlllII, float lllllllllllIIlllIIlIIIlIllIllIll, final float lllllllllllIIlllIIlIIIlIllIllIlI) {
        GlStateManager.pushMatrix();
        this.bindEntityTexture(lllllllllllIIlllIIlIIIlIllIlllll);
        long lllllllllllIIlllIIlIIIlIllllIIlI = lllllllllllIIlllIIlIIIlIllIlllll.getEntityId() * 493286711L;
        lllllllllllIIlllIIlIIIlIllllIIlI = lllllllllllIIlllIIlIIIlIllllIIlI * lllllllllllIIlllIIlIIIlIllllIIlI * 4392167121L + lllllllllllIIlllIIlIIIlIllllIIlI * 98761L;
        final float lllllllllllIIlllIIlIIIlIllllIIIl = (((lllllllllllIIlllIIlIIIlIllllIIlI >> 16 & 0x7L) + 0.5f) / 8.0f - 0.5f) * 0.004f;
        final float lllllllllllIIlllIIlIIIlIllllIIII = (((lllllllllllIIlllIIlIIIlIllllIIlI >> 20 & 0x7L) + 0.5f) / 8.0f - 0.5f) * 0.004f;
        final float lllllllllllIIlllIIlIIIlIlllIllll = (((lllllllllllIIlllIIlIIIlIllllIIlI >> 24 & 0x7L) + 0.5f) / 8.0f - 0.5f) * 0.004f;
        GlStateManager.translate(lllllllllllIIlllIIlIIIlIllllIIIl, lllllllllllIIlllIIlIIIlIllllIIII, lllllllllllIIlllIIlIIIlIlllIllll);
        final double lllllllllllIIlllIIlIIIlIlllIlllI = lllllllllllIIlllIIlIIIlIllIlllll.lastTickPosX + (lllllllllllIIlllIIlIIIlIllIlllll.posX - lllllllllllIIlllIIlIIIlIllIlllll.lastTickPosX) * lllllllllllIIlllIIlIIIlIllIllIlI;
        final double lllllllllllIIlllIIlIIIlIlllIllIl = lllllllllllIIlllIIlIIIlIllIlllll.lastTickPosY + (lllllllllllIIlllIIlIIIlIllIlllll.posY - lllllllllllIIlllIIlIIIlIllIlllll.lastTickPosY) * lllllllllllIIlllIIlIIIlIllIllIlI;
        final double lllllllllllIIlllIIlIIIlIlllIllII = lllllllllllIIlllIIlIIIlIllIlllll.lastTickPosZ + (lllllllllllIIlllIIlIIIlIllIlllll.posZ - lllllllllllIIlllIIlIIIlIllIlllll.lastTickPosZ) * lllllllllllIIlllIIlIIIlIllIllIlI;
        final double lllllllllllIIlllIIlIIIlIlllIlIll = 0.30000001192092896;
        final Vec3d lllllllllllIIlllIIlIIIlIlllIlIlI = lllllllllllIIlllIIlIIIlIllIlllll.getPos(lllllllllllIIlllIIlIIIlIlllIlllI, lllllllllllIIlllIIlIIIlIlllIllIl, lllllllllllIIlllIIlIIIlIlllIllII);
        float lllllllllllIIlllIIlIIIlIlllIlIIl = lllllllllllIIlllIIlIIIlIllIlllll.prevRotationPitch + (lllllllllllIIlllIIlIIIlIllIlllll.rotationPitch - lllllllllllIIlllIIlIIIlIllIlllll.prevRotationPitch) * lllllllllllIIlllIIlIIIlIllIllIlI;
        if (lllllllllllIIlllIIlIIIlIlllIlIlI != null) {
            Vec3d lllllllllllIIlllIIlIIIlIlllIlIII = lllllllllllIIlllIIlIIIlIllIlllll.getPosOffset(lllllllllllIIlllIIlIIIlIlllIlllI, lllllllllllIIlllIIlIIIlIlllIllIl, lllllllllllIIlllIIlIIIlIlllIllII, 0.30000001192092896);
            Vec3d lllllllllllIIlllIIlIIIlIlllIIlll = lllllllllllIIlllIIlIIIlIllIlllll.getPosOffset(lllllllllllIIlllIIlIIIlIlllIlllI, lllllllllllIIlllIIlIIIlIlllIllIl, lllllllllllIIlllIIlIIIlIlllIllII, -0.30000001192092896);
            if (lllllllllllIIlllIIlIIIlIlllIlIII == null) {
                lllllllllllIIlllIIlIIIlIlllIlIII = lllllllllllIIlllIIlIIIlIlllIlIlI;
            }
            if (lllllllllllIIlllIIlIIIlIlllIIlll == null) {
                lllllllllllIIlllIIlIIIlIlllIIlll = lllllllllllIIlllIIlIIIlIlllIlIlI;
            }
            lllllllllllIIlllIIlIIIlIllIllllI += lllllllllllIIlllIIlIIIlIlllIlIlI.xCoord - lllllllllllIIlllIIlIIIlIlllIlllI;
            lllllllllllIIlllIIlIIIlIllIlllIl += (lllllllllllIIlllIIlIIIlIlllIlIII.yCoord + lllllllllllIIlllIIlIIIlIlllIIlll.yCoord) / 2.0 - lllllllllllIIlllIIlIIIlIlllIllIl;
            lllllllllllIIlllIIlIIIlIllIlllII += lllllllllllIIlllIIlIIIlIlllIlIlI.zCoord - lllllllllllIIlllIIlIIIlIlllIllII;
            Vec3d lllllllllllIIlllIIlIIIlIlllIIllI = lllllllllllIIlllIIlIIIlIlllIIlll.addVector(-lllllllllllIIlllIIlIIIlIlllIlIII.xCoord, -lllllllllllIIlllIIlIIIlIlllIlIII.yCoord, -lllllllllllIIlllIIlIIIlIlllIlIII.zCoord);
            if (lllllllllllIIlllIIlIIIlIlllIIllI.lengthVector() != 0.0) {
                lllllllllllIIlllIIlIIIlIlllIIllI = lllllllllllIIlllIIlIIIlIlllIIllI.normalize();
                lllllllllllIIlllIIlIIIlIllIllIll = (float)(Math.atan2(lllllllllllIIlllIIlIIIlIlllIIllI.zCoord, lllllllllllIIlllIIlIIIlIlllIIllI.xCoord) * 180.0 / 3.141592653589793);
                lllllllllllIIlllIIlIIIlIlllIlIIl = (float)(Math.atan(lllllllllllIIlllIIlIIIlIlllIIllI.yCoord) * 73.0);
            }
        }
        GlStateManager.translate((float)lllllllllllIIlllIIlIIIlIllIllllI, (float)lllllllllllIIlllIIlIIIlIllIlllIl + 0.375f, (float)lllllllllllIIlllIIlIIIlIllIlllII);
        GlStateManager.rotate(180.0f - lllllllllllIIlllIIlIIIlIllIllIll, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(-lllllllllllIIlllIIlIIIlIlllIlIIl, 0.0f, 0.0f, 1.0f);
        final float lllllllllllIIlllIIlIIIlIlllIIlIl = lllllllllllIIlllIIlIIIlIllIlllll.getRollingAmplitude() - lllllllllllIIlllIIlIIIlIllIllIlI;
        float lllllllllllIIlllIIlIIIlIlllIIlII = lllllllllllIIlllIIlIIIlIllIlllll.getDamage() - lllllllllllIIlllIIlIIIlIllIllIlI;
        if (lllllllllllIIlllIIlIIIlIlllIIlII < 0.0f) {
            lllllllllllIIlllIIlIIIlIlllIIlII = 0.0f;
        }
        if (lllllllllllIIlllIIlIIIlIlllIIlIl > 0.0f) {
            GlStateManager.rotate(MathHelper.sin(lllllllllllIIlllIIlIIIlIlllIIlIl) * lllllllllllIIlllIIlIIIlIlllIIlIl * lllllllllllIIlllIIlIIIlIlllIIlII / 10.0f * lllllllllllIIlllIIlIIIlIllIlllll.getRollingDirection(), 1.0f, 0.0f, 0.0f);
        }
        final int lllllllllllIIlllIIlIIIlIlllIIIll = lllllllllllIIlllIIlIIIlIllIlllll.getDisplayTileOffset();
        if (this.renderOutlines) {
            GlStateManager.enableColorMaterial();
            GlStateManager.enableOutlineMode(this.getTeamColor(lllllllllllIIlllIIlIIIlIllIlllll));
        }
        final IBlockState lllllllllllIIlllIIlIIIlIlllIIIlI = lllllllllllIIlllIIlIIIlIllIlllll.getDisplayTile();
        if (lllllllllllIIlllIIlIIIlIlllIIIlI.getRenderType() != EnumBlockRenderType.INVISIBLE) {
            GlStateManager.pushMatrix();
            this.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            final float lllllllllllIIlllIIlIIIlIlllIIIIl = 0.75f;
            GlStateManager.scale(0.75f, 0.75f, 0.75f);
            GlStateManager.translate(-0.5f, (lllllllllllIIlllIIlIIIlIlllIIIll - 8) / 16.0f, 0.5f);
            this.renderCartContents(lllllllllllIIlllIIlIIIlIllIlllll, lllllllllllIIlllIIlIIIlIllIllIlI, lllllllllllIIlllIIlIIIlIlllIIIlI);
            GlStateManager.popMatrix();
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            this.bindEntityTexture(lllllllllllIIlllIIlIIIlIllIlllll);
        }
        GlStateManager.scale(-1.0f, -1.0f, 1.0f);
        this.modelMinecart.render(lllllllllllIIlllIIlIIIlIllIlllll, 0.0f, 0.0f, -0.1f, 0.0f, 0.0f, 0.0625f);
        GlStateManager.popMatrix();
        if (this.renderOutlines) {
            GlStateManager.disableOutlineMode();
            GlStateManager.disableColorMaterial();
        }
        super.doRender(lllllllllllIIlllIIlIIIlIllIlllll, lllllllllllIIlllIIlIIIlIllIllllI, lllllllllllIIlllIIlIIIlIllIlllIl, lllllllllllIIlllIIlIIIlIllIlllII, lllllllllllIIlllIIlIIIlIllIllIll, lllllllllllIIlllIIlIIIlIllIllIlI);
    }
    
    protected void renderCartContents(final T lllllllllllIIlllIIlIIIlIllIIIIlI, final float lllllllllllIIlllIIlIIIlIllIIIlII, final IBlockState lllllllllllIIlllIIlIIIlIllIIIIIl) {
        GlStateManager.pushMatrix();
        Minecraft.getMinecraft().getBlockRendererDispatcher().renderBlockBrightness(lllllllllllIIlllIIlIIIlIllIIIIIl, lllllllllllIIlllIIlIIIlIllIIIIlI.getBrightness());
        GlStateManager.popMatrix();
    }
    
    public RenderMinecart(final RenderManager lllllllllllIIlllIIlIIIllIIIlIIII) {
        super(lllllllllllIIlllIIlIIIllIIIlIIII);
        this.modelMinecart = new ModelMinecart();
        this.shadowSize = 0.5f;
    }
    
    static {
        MINECART_TEXTURES = new ResourceLocation("textures/entity/minecart.png");
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final T lllllllllllIIlllIIlIIIlIllIIlIIl) {
        return RenderMinecart.MINECART_TEXTURES;
    }
}
