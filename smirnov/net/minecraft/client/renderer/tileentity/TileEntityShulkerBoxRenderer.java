// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.entity.RenderShulker;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockShulkerBox;
import net.minecraft.util.EnumFacing;
import net.minecraft.client.model.ModelShulker;
import net.minecraft.tileentity.TileEntityShulkerBox;

public class TileEntityShulkerBoxRenderer extends TileEntitySpecialRenderer<TileEntityShulkerBox>
{
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing;
    private final /* synthetic */ ModelShulker field_191285_a;
    
    @Override
    public void func_192841_a(final TileEntityShulkerBox llllllllllllIIIIlllIllIlIIIIIlll, final double llllllllllllIIIIlllIllIlIIIlIIIl, final double llllllllllllIIIIlllIllIlIIIlIIII, final double llllllllllllIIIIlllIllIlIIIIIlII, final float llllllllllllIIIIlllIllIlIIIIlllI, final int llllllllllllIIIIlllIllIlIIIIllIl, final float llllllllllllIIIIlllIllIlIIIIllII) {
        EnumFacing llllllllllllIIIIlllIllIlIIIIlIll = EnumFacing.UP;
        if (llllllllllllIIIIlllIllIlIIIIIlll.hasWorldObj()) {
            final IBlockState llllllllllllIIIIlllIllIlIIIIlIlI = this.getWorld().getBlockState(llllllllllllIIIIlllIllIlIIIIIlll.getPos());
            if (llllllllllllIIIIlllIllIlIIIIlIlI.getBlock() instanceof BlockShulkerBox) {
                llllllllllllIIIIlllIllIlIIIIlIll = llllllllllllIIIIlllIllIlIIIIlIlI.getValue(BlockShulkerBox.field_190957_a);
            }
        }
        GlStateManager.enableDepth();
        GlStateManager.depthFunc(515);
        GlStateManager.depthMask(true);
        GlStateManager.disableCull();
        if (llllllllllllIIIIlllIllIlIIIIllIl >= 0) {
            this.bindTexture(TileEntityShulkerBoxRenderer.DESTROY_STAGES[llllllllllllIIIIlllIllIlIIIIllIl]);
            GlStateManager.matrixMode(5890);
            GlStateManager.pushMatrix();
            GlStateManager.scale(4.0f, 4.0f, 1.0f);
            GlStateManager.translate(0.0625f, 0.0625f, 0.0625f);
            GlStateManager.matrixMode(5888);
        }
        else {
            this.bindTexture(RenderShulker.SHULKER_ENDERGOLEM_TEXTURE[llllllllllllIIIIlllIllIlIIIIIlll.func_190592_s().getMetadata()]);
        }
        GlStateManager.pushMatrix();
        GlStateManager.enableRescaleNormal();
        if (llllllllllllIIIIlllIllIlIIIIllIl < 0) {
            GlStateManager.color(1.0f, 1.0f, 1.0f, llllllllllllIIIIlllIllIlIIIIllII);
        }
        GlStateManager.translate((float)llllllllllllIIIIlllIllIlIIIlIIIl + 0.5f, (float)llllllllllllIIIIlllIllIlIIIlIIII + 1.5f, (float)llllllllllllIIIIlllIllIlIIIIIlII + 0.5f);
        GlStateManager.scale(1.0f, -1.0f, -1.0f);
        GlStateManager.translate(0.0f, 1.0f, 0.0f);
        final float llllllllllllIIIIlllIllIlIIIIlIIl = 0.9995f;
        GlStateManager.scale(0.9995f, 0.9995f, 0.9995f);
        GlStateManager.translate(0.0f, -1.0f, 0.0f);
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[llllllllllllIIIIlllIllIlIIIIlIll.ordinal()]) {
            case 1: {
                GlStateManager.translate(0.0f, 2.0f, 0.0f);
                GlStateManager.rotate(180.0f, 1.0f, 0.0f, 0.0f);
                break;
            }
            case 3: {
                GlStateManager.translate(0.0f, 1.0f, 1.0f);
                GlStateManager.rotate(90.0f, 1.0f, 0.0f, 0.0f);
                GlStateManager.rotate(180.0f, 0.0f, 0.0f, 1.0f);
                break;
            }
            case 4: {
                GlStateManager.translate(0.0f, 1.0f, -1.0f);
                GlStateManager.rotate(90.0f, 1.0f, 0.0f, 0.0f);
                break;
            }
            case 5: {
                GlStateManager.translate(-1.0f, 1.0f, 0.0f);
                GlStateManager.rotate(90.0f, 1.0f, 0.0f, 0.0f);
                GlStateManager.rotate(-90.0f, 0.0f, 0.0f, 1.0f);
                break;
            }
            case 6: {
                GlStateManager.translate(1.0f, 1.0f, 0.0f);
                GlStateManager.rotate(90.0f, 1.0f, 0.0f, 0.0f);
                GlStateManager.rotate(90.0f, 0.0f, 0.0f, 1.0f);
                break;
            }
        }
        this.field_191285_a.base.render(0.0625f);
        GlStateManager.translate(0.0f, -llllllllllllIIIIlllIllIlIIIIIlll.func_190585_a(llllllllllllIIIIlllIllIlIIIIlllI) * 0.5f, 0.0f);
        GlStateManager.rotate(270.0f * llllllllllllIIIIlllIllIlIIIIIlll.func_190585_a(llllllllllllIIIIlllIllIlIIIIlllI), 0.0f, 1.0f, 0.0f);
        this.field_191285_a.lid.render(0.0625f);
        GlStateManager.enableCull();
        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        if (llllllllllllIIIIlllIllIlIIIIllIl >= 0) {
            GlStateManager.matrixMode(5890);
            GlStateManager.popMatrix();
            GlStateManager.matrixMode(5888);
        }
    }
    
    public TileEntityShulkerBoxRenderer(final ModelShulker llllllllllllIIIIlllIllIlIIIllllI) {
        this.field_191285_a = llllllllllllIIIIlllIllIlIIIllllI;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = TileEntityShulkerBoxRenderer.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final long llllllllllllIIIIlllIllIIlllIllIl = (Object)new int[EnumFacing.values().length];
        try {
            llllllllllllIIIIlllIllIIlllIllIl[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllIIIIlllIllIIlllIllIl[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllIIIIlllIllIIlllIllIl[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllIIIIlllIllIIlllIllIl[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            llllllllllllIIIIlllIllIIlllIllIl[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            llllllllllllIIIIlllIllIIlllIllIl[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return TileEntityShulkerBoxRenderer.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)llllllllllllIIIIlllIllIIlllIllIl;
    }
}
