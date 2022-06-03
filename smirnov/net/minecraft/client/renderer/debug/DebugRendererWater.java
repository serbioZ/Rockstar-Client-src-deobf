// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.debug;

import net.minecraft.block.state.IBlockState;
import net.minecraft.world.World;
import net.minecraft.block.properties.IProperty;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.BlockLiquid;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class DebugRendererWater implements DebugRenderer.IDebugRenderer
{
    private /* synthetic */ double zo;
    private /* synthetic */ double yo;
    private /* synthetic */ EntityPlayer player;
    private final /* synthetic */ Minecraft minecraft;
    private /* synthetic */ double xo;
    
    public DebugRendererWater(final Minecraft llllllllllllIIlIllIIlIIIIIlIIIIl) {
        this.minecraft = llllllllllllIIlIllIIlIIIIIlIIIIl;
    }
    
    @Override
    public void render(final float llllllllllllIIlIllIIlIIIIIIIlIII, final long llllllllllllIIlIllIIlIIIIIIlIlII) {
        this.player = this.minecraft.player;
        this.xo = this.player.lastTickPosX + (this.player.posX - this.player.lastTickPosX) * llllllllllllIIlIllIIlIIIIIIIlIII;
        this.yo = this.player.lastTickPosY + (this.player.posY - this.player.lastTickPosY) * llllllllllllIIlIllIIlIIIIIIIlIII;
        this.zo = this.player.lastTickPosZ + (this.player.posZ - this.player.lastTickPosZ) * llllllllllllIIlIllIIlIIIIIIIlIII;
        final BlockPos llllllllllllIIlIllIIlIIIIIIlIIll = this.minecraft.player.getPosition();
        final World llllllllllllIIlIllIIlIIIIIIlIIlI = this.minecraft.player.world;
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.color(0.0f, 1.0f, 0.0f, 0.75f);
        GlStateManager.disableTexture2D();
        GlStateManager.glLineWidth(6.0f);
        for (final BlockPos llllllllllllIIlIllIIlIIIIIIlIIIl : BlockPos.getAllInBox(llllllllllllIIlIllIIlIIIIIIlIIll.add(-10, -10, -10), llllllllllllIIlIllIIlIIIIIIlIIll.add(10, 10, 10))) {
            final IBlockState llllllllllllIIlIllIIlIIIIIIlIIII = llllllllllllIIlIllIIlIIIIIIlIIlI.getBlockState(llllllllllllIIlIllIIlIIIIIIlIIIl);
            if (llllllllllllIIlIllIIlIIIIIIlIIII.getBlock() == Blocks.WATER || llllllllllllIIlIllIIlIIIIIIlIIII.getBlock() == Blocks.FLOWING_WATER) {
                final double llllllllllllIIlIllIIlIIIIIIIllll = BlockLiquid.func_190972_g(llllllllllllIIlIllIIlIIIIIIlIIII, llllllllllllIIlIllIIlIIIIIIlIIlI, llllllllllllIIlIllIIlIIIIIIlIIIl);
                RenderGlobal.renderFilledBox(new AxisAlignedBB(llllllllllllIIlIllIIlIIIIIIlIIIl.getX() + 0.01f, llllllllllllIIlIllIIlIIIIIIlIIIl.getY() + 0.01f, llllllllllllIIlIllIIlIIIIIIlIIIl.getZ() + 0.01f, llllllllllllIIlIllIIlIIIIIIlIIIl.getX() + 0.99f, llllllllllllIIlIllIIlIIIIIIIllll, llllllllllllIIlIllIIlIIIIIIlIIIl.getZ() + 0.99f).offset(-this.xo, -this.yo, -this.zo), 1.0f, 1.0f, 1.0f, 0.2f);
            }
        }
        for (final BlockPos llllllllllllIIlIllIIlIIIIIIIlllI : BlockPos.getAllInBox(llllllllllllIIlIllIIlIIIIIIlIIll.add(-10, -10, -10), llllllllllllIIlIllIIlIIIIIIlIIll.add(10, 10, 10))) {
            final IBlockState llllllllllllIIlIllIIlIIIIIIIllIl = llllllllllllIIlIllIIlIIIIIIlIIlI.getBlockState(llllllllllllIIlIllIIlIIIIIIIlllI);
            if (llllllllllllIIlIllIIlIIIIIIIllIl.getBlock() == Blocks.WATER || llllllllllllIIlIllIIlIIIIIIIllIl.getBlock() == Blocks.FLOWING_WATER) {
                final Integer llllllllllllIIlIllIIlIIIIIIIllII = llllllllllllIIlIllIIlIIIIIIIllIl.getValue((IProperty<Integer>)BlockLiquid.LEVEL);
                final double llllllllllllIIlIllIIlIIIIIIIlIll = (llllllllllllIIlIllIIlIIIIIIIllII > 7) ? 0.9 : (1.0 - 0.11 * llllllllllllIIlIllIIlIIIIIIIllII);
                final String llllllllllllIIlIllIIlIIIIIIIlIlI = (llllllllllllIIlIllIIlIIIIIIIllIl.getBlock() == Blocks.FLOWING_WATER) ? "f" : "s";
                DebugRenderer.renderDebugText(String.valueOf(llllllllllllIIlIllIIlIIIIIIIlIlI) + " " + llllllllllllIIlIllIIlIIIIIIIllII, llllllllllllIIlIllIIlIIIIIIIlllI.getX() + 0.5, llllllllllllIIlIllIIlIIIIIIIlllI.getY() + llllllllllllIIlIllIIlIIIIIIIlIll, llllllllllllIIlIllIIlIIIIIIIlllI.getZ() + 0.5, llllllllllllIIlIllIIlIIIIIIIlIII, -16777216);
            }
        }
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }
}
