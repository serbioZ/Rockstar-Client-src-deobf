// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.block.material.MapColor;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.tileentity.TileEntityEndGateway;
import java.util.Random;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.util.EnumFacing;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import javax.annotation.Nullable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;

public class BlockEndGateway extends BlockContainer
{
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final IBlockState llllllllllllllIllIlIIllllIllIlll, final IBlockAccess llllllllllllllIllIlIIllllIllIllI, final BlockPos llllllllllllllIllIlIIllllIllIlIl) {
        return BlockEndGateway.NULL_AABB;
    }
    
    @Override
    public ItemStack getItem(final World llllllllllllllIllIlIIllllIIIIlII, final BlockPos llllllllllllllIllIlIIllllIIIIIll, final IBlockState llllllllllllllIllIlIIllllIIIIIlI) {
        return ItemStack.field_190927_a;
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess llllllllllllllIllIlIIlllIlllllII, final IBlockState llllllllllllllIllIlIIlllIllllIll, final BlockPos llllllllllllllIllIlIIlllIllllIlI, final EnumFacing llllllllllllllIllIlIIlllIllllIIl) {
        return BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public boolean isFullCube(final IBlockState llllllllllllllIllIlIIllllIllIIIl) {
        return false;
    }
    
    @Override
    public void randomDisplayTick(final IBlockState llllllllllllllIllIlIIllllIlIIIII, final World llllllllllllllIllIlIIllllIIlIIlI, final BlockPos llllllllllllllIllIlIIllllIIlIIIl, final Random llllllllllllllIllIlIIllllIIlIIII) {
        final TileEntity llllllllllllllIllIlIIllllIIlllII = llllllllllllllIllIlIIllllIIlIIlI.getTileEntity(llllllllllllllIllIlIIllllIIlIIIl);
        if (llllllllllllllIllIlIIllllIIlllII instanceof TileEntityEndGateway) {
            for (int llllllllllllllIllIlIIllllIIllIll = ((TileEntityEndGateway)llllllllllllllIllIlIIllllIIlllII).getParticleAmount(), llllllllllllllIllIlIIllllIIllIlI = 0; llllllllllllllIllIlIIllllIIllIlI < llllllllllllllIllIlIIllllIIllIll; ++llllllllllllllIllIlIIllllIIllIlI) {
                double llllllllllllllIllIlIIllllIIllIIl = llllllllllllllIllIlIIllllIIlIIIl.getX() + llllllllllllllIllIlIIllllIIlIIII.nextFloat();
                final double llllllllllllllIllIlIIllllIIllIII = llllllllllllllIllIlIIllllIIlIIIl.getY() + llllllllllllllIllIlIIllllIIlIIII.nextFloat();
                double llllllllllllllIllIlIIllllIIlIlll = llllllllllllllIllIlIIllllIIlIIIl.getZ() + llllllllllllllIllIlIIllllIIlIIII.nextFloat();
                double llllllllllllllIllIlIIllllIIlIllI = (llllllllllllllIllIlIIllllIIlIIII.nextFloat() - 0.5) * 0.5;
                final double llllllllllllllIllIlIIllllIIlIlIl = (llllllllllllllIllIlIIllllIIlIIII.nextFloat() - 0.5) * 0.5;
                double llllllllllllllIllIlIIllllIIlIlII = (llllllllllllllIllIlIIllllIIlIIII.nextFloat() - 0.5) * 0.5;
                final int llllllllllllllIllIlIIllllIIlIIll = llllllllllllllIllIlIIllllIIlIIII.nextInt(2) * 2 - 1;
                if (llllllllllllllIllIlIIllllIIlIIII.nextBoolean()) {
                    llllllllllllllIllIlIIllllIIlIlll = llllllllllllllIllIlIIllllIIlIIIl.getZ() + 0.5 + 0.25 * llllllllllllllIllIlIIllllIIlIIll;
                    llllllllllllllIllIlIIllllIIlIlII = llllllllllllllIllIlIIllllIIlIIII.nextFloat() * 2.0f * llllllllllllllIllIlIIllllIIlIIll;
                }
                else {
                    llllllllllllllIllIlIIllllIIllIIl = llllllllllllllIllIlIIllllIIlIIIl.getX() + 0.5 + 0.25 * llllllllllllllIllIlIIllllIIlIIll;
                    llllllllllllllIllIlIIllllIIlIllI = llllllllllllllIllIlIIllllIIlIIII.nextFloat() * 2.0f * llllllllllllllIllIlIIllllIIlIIll;
                }
                llllllllllllllIllIlIIllllIIlIIlI.spawnParticle(EnumParticleTypes.PORTAL, llllllllllllllIllIlIIllllIIllIIl, llllllllllllllIllIlIIllllIIllIII, llllllllllllllIllIlIIllllIIlIlll, llllllllllllllIllIlIIllllIIlIllI, llllllllllllllIllIlIIllllIIlIlIl, llllllllllllllIllIlIIllllIIlIlII, new int[0]);
            }
        }
    }
    
    @Override
    public TileEntity createNewTileEntity(final World llllllllllllllIllIlIIlllllIIlIll, final int llllllllllllllIllIlIIlllllIIlIlI) {
        return new TileEntityEndGateway();
    }
    
    @Override
    public MapColor getMapColor(final IBlockState llllllllllllllIllIlIIllllIIIIIII, final IBlockAccess llllllllllllllIllIlIIlllIlllllll, final BlockPos llllllllllllllIllIlIIlllIllllllI) {
        return MapColor.BLACK;
    }
    
    @Override
    public boolean shouldSideBeRendered(final IBlockState llllllllllllllIllIlIIlllllIIIIll, final IBlockAccess llllllllllllllIllIlIIlllllIIIIlI, final BlockPos llllllllllllllIllIlIIllllIllllII, final EnumFacing llllllllllllllIllIlIIlllllIIIIII) {
        final IBlockState llllllllllllllIllIlIIllllIllllll = llllllllllllllIllIlIIlllllIIIIlI.getBlockState(llllllllllllllIllIlIIllllIllllII.offset(llllllllllllllIllIlIIlllllIIIIII));
        final Block llllllllllllllIllIlIIllllIlllllI = llllllllllllllIllIlIIllllIllllll.getBlock();
        return !llllllllllllllIllIlIIllllIllllll.isOpaqueCube() && llllllllllllllIllIlIIllllIlllllI != Blocks.END_GATEWAY;
    }
    
    @Override
    public int quantityDropped(final Random llllllllllllllIllIlIIllllIlIllll) {
        return 0;
    }
    
    protected BlockEndGateway(final Material llllllllllllllIllIlIIlllllIIllIl) {
        super(llllllllllllllIllIlIIlllllIIllIl);
        this.setLightLevel(1.0f);
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState llllllllllllllIllIlIIllllIllIIll) {
        return false;
    }
}
