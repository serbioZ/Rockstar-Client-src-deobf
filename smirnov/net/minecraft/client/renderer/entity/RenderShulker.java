// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.entity;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.entity.EntityLiving;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelShulker;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.monster.EntityShulker;

public class RenderShulker extends RenderLiving<EntityShulker>
{
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing;
    public static final /* synthetic */ ResourceLocation[] SHULKER_ENDERGOLEM_TEXTURE;
    
    public RenderShulker(final RenderManager lllllllllllllIlllIllIIlIIlIlIlIl) {
        super(lllllllllllllIlllIllIIlIIlIlIlIl, new ModelShulker(), 0.0f);
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new HeadLayer((HeadLayer)null));
    }
    
    @Override
    protected void rotateCorpse(final EntityShulker lllllllllllllIlllIllIIIllllllIII, final float lllllllllllllIlllIllIIIlllllllII, final float lllllllllllllIlllIllIIIlllllIllI, final float lllllllllllllIlllIllIIIlllllIlIl) {
        super.rotateCorpse(lllllllllllllIlllIllIIIllllllIII, lllllllllllllIlllIllIIIlllllllII, lllllllllllllIlllIllIIIlllllIllI, lllllllllllllIlllIllIIIlllllIlIl);
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllllIlllIllIIIllllllIII.getAttachmentFacing().ordinal()]) {
            case 6: {
                GlStateManager.translate(0.5f, 0.5f, 0.0f);
                GlStateManager.rotate(90.0f, 1.0f, 0.0f, 0.0f);
                GlStateManager.rotate(90.0f, 0.0f, 0.0f, 1.0f);
                break;
            }
            case 5: {
                GlStateManager.translate(-0.5f, 0.5f, 0.0f);
                GlStateManager.rotate(90.0f, 1.0f, 0.0f, 0.0f);
                GlStateManager.rotate(-90.0f, 0.0f, 0.0f, 1.0f);
                break;
            }
            case 3: {
                GlStateManager.translate(0.0f, 0.5f, -0.5f);
                GlStateManager.rotate(90.0f, 1.0f, 0.0f, 0.0f);
                break;
            }
            case 4: {
                GlStateManager.translate(0.0f, 0.5f, 0.5f);
                GlStateManager.rotate(90.0f, 1.0f, 0.0f, 0.0f);
                GlStateManager.rotate(180.0f, 0.0f, 0.0f, 1.0f);
                break;
            }
            case 2: {
                GlStateManager.translate(0.0f, 1.0f, 0.0f);
                GlStateManager.rotate(180.0f, 1.0f, 0.0f, 0.0f);
                break;
            }
        }
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = RenderShulker.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final double lllllllllllllIlllIllIIIllIllllIl = (Object)new int[EnumFacing.values().length];
        try {
            lllllllllllllIlllIllIIIllIllllIl[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIlllIllIIIllIllllIl[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIlllIllIIIllIllllIl[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllIlllIllIIIllIllllIl[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllllIlllIllIIIllIllllIl[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllllIlllIllIIIllIllllIl[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return RenderShulker.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)lllllllllllllIlllIllIIIllIllllIl;
    }
    
    @Override
    public void doRender(final EntityShulker lllllllllllllIlllIllIIlIIIllIIlI, final double lllllllllllllIlllIllIIlIIIllllll, final double lllllllllllllIlllIllIIlIIIlllllI, final double lllllllllllllIlllIllIIlIIIlIllll, final float lllllllllllllIlllIllIIlIIIllllII, final float lllllllllllllIlllIllIIlIIIlllIll) {
        final int lllllllllllllIlllIllIIlIIIlllIlI = lllllllllllllIlllIllIIlIIIllIIlI.getClientTeleportInterp();
        if (lllllllllllllIlllIllIIlIIIlllIlI > 0 && lllllllllllllIlllIllIIlIIIllIIlI.isAttachedToBlock()) {
            final BlockPos lllllllllllllIlllIllIIlIIIlllIIl = lllllllllllllIlllIllIIlIIIllIIlI.getAttachmentPos();
            final BlockPos lllllllllllllIlllIllIIlIIIlllIII = lllllllllllllIlllIllIIlIIIllIIlI.getOldAttachPos();
            double lllllllllllllIlllIllIIlIIIllIlll = (lllllllllllllIlllIllIIlIIIlllIlI - lllllllllllllIlllIllIIlIIIlllIll) / 6.0;
            lllllllllllllIlllIllIIlIIIllIlll *= lllllllllllllIlllIllIIlIIIllIlll;
            final double lllllllllllllIlllIllIIlIIIllIllI = (lllllllllllllIlllIllIIlIIIlllIIl.getX() - lllllllllllllIlllIllIIlIIIlllIII.getX()) * lllllllllllllIlllIllIIlIIIllIlll;
            final double lllllllllllllIlllIllIIlIIIllIlIl = (lllllllllllllIlllIllIIlIIIlllIIl.getY() - lllllllllllllIlllIllIIlIIIlllIII.getY()) * lllllllllllllIlllIllIIlIIIllIlll;
            final double lllllllllllllIlllIllIIlIIIllIlII = (lllllllllllllIlllIllIIlIIIlllIIl.getZ() - lllllllllllllIlllIllIIlIIIlllIII.getZ()) * lllllllllllllIlllIllIIlIIIllIlll;
            super.doRender(lllllllllllllIlllIllIIlIIIllIIlI, lllllllllllllIlllIllIIlIIIllllll - lllllllllllllIlllIllIIlIIIllIllI, lllllllllllllIlllIllIIlIIIlllllI - lllllllllllllIlllIllIIlIIIllIlIl, lllllllllllllIlllIllIIlIIIlIllll - lllllllllllllIlllIllIIlIIIllIlII, lllllllllllllIlllIllIIlIIIllllII, lllllllllllllIlllIllIIlIIIlllIll);
        }
        else {
            super.doRender(lllllllllllllIlllIllIIlIIIllIIlI, lllllllllllllIlllIllIIlIIIllllll, lllllllllllllIlllIllIIlIIIlllllI, lllllllllllllIlllIllIIlIIIlIllll, lllllllllllllIlllIllIIlIIIllllII, lllllllllllllIlllIllIIlIIIlllIll);
        }
    }
    
    static {
        SHULKER_ENDERGOLEM_TEXTURE = new ResourceLocation[] { new ResourceLocation("textures/entity/shulker/shulker_white.png"), new ResourceLocation("textures/entity/shulker/shulker_orange.png"), new ResourceLocation("textures/entity/shulker/shulker_magenta.png"), new ResourceLocation("textures/entity/shulker/shulker_light_blue.png"), new ResourceLocation("textures/entity/shulker/shulker_yellow.png"), new ResourceLocation("textures/entity/shulker/shulker_lime.png"), new ResourceLocation("textures/entity/shulker/shulker_pink.png"), new ResourceLocation("textures/entity/shulker/shulker_gray.png"), new ResourceLocation("textures/entity/shulker/shulker_silver.png"), new ResourceLocation("textures/entity/shulker/shulker_cyan.png"), new ResourceLocation("textures/entity/shulker/shulker_purple.png"), new ResourceLocation("textures/entity/shulker/shulker_blue.png"), new ResourceLocation("textures/entity/shulker/shulker_brown.png"), new ResourceLocation("textures/entity/shulker/shulker_green.png"), new ResourceLocation("textures/entity/shulker/shulker_red.png"), new ResourceLocation("textures/entity/shulker/shulker_black.png") };
    }
    
    @Override
    public boolean shouldRender(final EntityShulker lllllllllllllIlllIllIIlIIIIlIIII, final ICamera lllllllllllllIlllIllIIlIIIIIllll, final double lllllllllllllIlllIllIIlIIIIllIII, final double lllllllllllllIlllIllIIlIIIIlIlll, final double lllllllllllllIlllIllIIlIIIIlIllI) {
        if (super.shouldRender(lllllllllllllIlllIllIIlIIIIlIIII, lllllllllllllIlllIllIIlIIIIIllll, lllllllllllllIlllIllIIlIIIIllIII, lllllllllllllIlllIllIIlIIIIlIlll, lllllllllllllIlllIllIIlIIIIlIllI)) {
            return true;
        }
        if (lllllllllllllIlllIllIIlIIIIlIIII.getClientTeleportInterp() > 0 && lllllllllllllIlllIllIIlIIIIlIIII.isAttachedToBlock()) {
            final BlockPos lllllllllllllIlllIllIIlIIIIlIlIl = lllllllllllllIlllIllIIlIIIIlIIII.getOldAttachPos();
            final BlockPos lllllllllllllIlllIllIIlIIIIlIlII = lllllllllllllIlllIllIIlIIIIlIIII.getAttachmentPos();
            final Vec3d lllllllllllllIlllIllIIlIIIIlIIll = new Vec3d(lllllllllllllIlllIllIIlIIIIlIlII.getX(), lllllllllllllIlllIllIIlIIIIlIlII.getY(), lllllllllllllIlllIllIIlIIIIlIlII.getZ());
            final Vec3d lllllllllllllIlllIllIIlIIIIlIIlI = new Vec3d(lllllllllllllIlllIllIIlIIIIlIlIl.getX(), lllllllllllllIlllIllIIlIIIIlIlIl.getY(), lllllllllllllIlllIllIIlIIIIlIlIl.getZ());
            if (lllllllllllllIlllIllIIlIIIIIllll.isBoundingBoxInFrustum(new AxisAlignedBB(lllllllllllllIlllIllIIlIIIIlIIlI.xCoord, lllllllllllllIlllIllIIlIIIIlIIlI.yCoord, lllllllllllllIlllIllIIlIIIIlIIlI.zCoord, lllllllllllllIlllIllIIlIIIIlIIll.xCoord, lllllllllllllIlllIllIIlIIIIlIIll.yCoord, lllllllllllllIlllIllIIlIIIIlIIll.zCoord))) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    protected void preRenderCallback(final EntityShulker lllllllllllllIlllIllIIIlllllIIlI, final float lllllllllllllIlllIllIIIlllllIIIl) {
        final float lllllllllllllIlllIllIIIlllllIIII = 0.999f;
        GlStateManager.scale(0.999f, 0.999f, 0.999f);
    }
    
    @Override
    public ModelShulker getMainModel() {
        return (ModelShulker)super.getMainModel();
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityShulker lllllllllllllIlllIllIIlIIIIIIlIl) {
        return RenderShulker.SHULKER_ENDERGOLEM_TEXTURE[lllllllllllllIlllIllIIlIIIIIIlIl.func_190769_dn().getMetadata()];
    }
    
    class HeadLayer implements LayerRenderer<EntityShulker>
    {
        private HeadLayer() {
        }
        
        static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
            final int[] $switch_TABLE$net$minecraft$util$EnumFacing = HeadLayer.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
            if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
                return $switch_TABLE$net$minecraft$util$EnumFacing;
            }
            final Exception lllllllllllllIlIlllllllIllllllIl = (Object)new int[EnumFacing.values().length];
            try {
                lllllllllllllIlIlllllllIllllllIl[EnumFacing.DOWN.ordinal()] = true;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                lllllllllllllIlIlllllllIllllllIl[EnumFacing.EAST.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                lllllllllllllIlIlllllllIllllllIl[EnumFacing.NORTH.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                lllllllllllllIlIlllllllIllllllIl[EnumFacing.SOUTH.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            try {
                lllllllllllllIlIlllllllIllllllIl[EnumFacing.UP.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
            try {
                lllllllllllllIlIlllllllIllllllIl[EnumFacing.WEST.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError6) {}
            return HeadLayer.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)lllllllllllllIlIlllllllIllllllIl;
        }
        
        @Override
        public void doRenderLayer(final EntityShulker lllllllllllllIlIllllllllIIlIIIII, final float lllllllllllllIlIllllllllIIIlllll, final float lllllllllllllIlIllllllllIIIllllI, final float lllllllllllllIlIllllllllIIIlllIl, final float lllllllllllllIlIllllllllIIIlllII, final float lllllllllllllIlIllllllllIIIlIlIl, final float lllllllllllllIlIllllllllIIIllIlI, final float lllllllllllllIlIllllllllIIIllIIl) {
            GlStateManager.pushMatrix();
            switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllllIlIllllllllIIlIIIII.getAttachmentFacing().ordinal()]) {
                case 6: {
                    GlStateManager.rotate(90.0f, 0.0f, 0.0f, 1.0f);
                    GlStateManager.rotate(90.0f, 1.0f, 0.0f, 0.0f);
                    GlStateManager.translate(1.0f, -1.0f, 0.0f);
                    GlStateManager.rotate(180.0f, 0.0f, 1.0f, 0.0f);
                    break;
                }
                case 5: {
                    GlStateManager.rotate(-90.0f, 0.0f, 0.0f, 1.0f);
                    GlStateManager.rotate(90.0f, 1.0f, 0.0f, 0.0f);
                    GlStateManager.translate(-1.0f, -1.0f, 0.0f);
                    GlStateManager.rotate(180.0f, 0.0f, 1.0f, 0.0f);
                    break;
                }
                case 3: {
                    GlStateManager.rotate(90.0f, 1.0f, 0.0f, 0.0f);
                    GlStateManager.translate(0.0f, -1.0f, -1.0f);
                    break;
                }
                case 4: {
                    GlStateManager.rotate(180.0f, 0.0f, 0.0f, 1.0f);
                    GlStateManager.rotate(90.0f, 1.0f, 0.0f, 0.0f);
                    GlStateManager.translate(0.0f, -1.0f, 1.0f);
                    break;
                }
                case 2: {
                    GlStateManager.rotate(180.0f, 1.0f, 0.0f, 0.0f);
                    GlStateManager.translate(0.0f, -2.0f, 0.0f);
                    break;
                }
            }
            final ModelRenderer lllllllllllllIlIllllllllIIIllIII = RenderShulker.this.getMainModel().head;
            lllllllllllllIlIllllllllIIIllIII.rotateAngleY = lllllllllllllIlIllllllllIIIlIlIl * 0.017453292f;
            lllllllllllllIlIllllllllIIIllIII.rotateAngleX = lllllllllllllIlIllllllllIIIllIlI * 0.017453292f;
            RenderShulker.this.bindTexture(RenderShulker.SHULKER_ENDERGOLEM_TEXTURE[lllllllllllllIlIllllllllIIlIIIII.func_190769_dn().getMetadata()]);
            lllllllllllllIlIllllllllIIIllIII.render(lllllllllllllIlIllllllllIIIllIIl);
            GlStateManager.popMatrix();
        }
        
        @Override
        public boolean shouldCombineTextures() {
            return false;
        }
    }
}
