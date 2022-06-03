// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.block.properties.IProperty;
import java.util.Random;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.util.math.AxisAlignedBB;

public class BlockCactus extends Block
{
    protected static final /* synthetic */ AxisAlignedBB CACTUS_COLLISION_AABB;
    protected static final /* synthetic */ AxisAlignedBB CACTUS_AABB;
    public static final /* synthetic */ PropertyInteger AGE;
    
    @Override
    public void updateTick(final World llllllllllllIlllllIlIIIIllllIllI, final BlockPos llllllllllllIlllllIlIIIIllllIlIl, final IBlockState llllllllllllIlllllIlIIIIllllllIl, final Random llllllllllllIlllllIlIIIIllllllII) {
        final BlockPos llllllllllllIlllllIlIIIIlllllIll = llllllllllllIlllllIlIIIIllllIlIl.up();
        if (llllllllllllIlllllIlIIIIllllIllI.isAirBlock(llllllllllllIlllllIlIIIIlllllIll)) {
            int llllllllllllIlllllIlIIIIlllllIlI;
            for (llllllllllllIlllllIlIIIIlllllIlI = 1; llllllllllllIlllllIlIIIIllllIllI.getBlockState(llllllllllllIlllllIlIIIIllllIlIl.down(llllllllllllIlllllIlIIIIlllllIlI)).getBlock() == this; ++llllllllllllIlllllIlIIIIlllllIlI) {}
            if (llllllllllllIlllllIlIIIIlllllIlI < 3) {
                final int llllllllllllIlllllIlIIIIlllllIIl = llllllllllllIlllllIlIIIIllllllIl.getValue((IProperty<Integer>)BlockCactus.AGE);
                if (llllllllllllIlllllIlIIIIlllllIIl == 15) {
                    llllllllllllIlllllIlIIIIllllIllI.setBlockState(llllllllllllIlllllIlIIIIlllllIll, this.getDefaultState());
                    final IBlockState llllllllllllIlllllIlIIIIlllllIII = llllllllllllIlllllIlIIIIllllllIl.withProperty((IProperty<Comparable>)BlockCactus.AGE, 0);
                    llllllllllllIlllllIlIIIIllllIllI.setBlockState(llllllllllllIlllllIlIIIIllllIlIl, llllllllllllIlllllIlIIIIlllllIII, 4);
                    llllllllllllIlllllIlIIIIlllllIII.neighborChanged(llllllllllllIlllllIlIIIIllllIllI, llllllllllllIlllllIlIIIIlllllIll, this, llllllllllllIlllllIlIIIIllllIlIl);
                }
                else {
                    llllllllllllIlllllIlIIIIllllIllI.setBlockState(llllllllllllIlllllIlIIIIllllIlIl, llllllllllllIlllllIlIIIIllllllIl.withProperty((IProperty<Comparable>)BlockCactus.AGE, llllllllllllIlllllIlIIIIlllllIIl + 1), 4);
                }
            }
        }
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState llllllllllllIlllllIlIIIIlllIIIlI) {
        return false;
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }
    
    @Override
    public void neighborChanged(final IBlockState llllllllllllIlllllIlIIIIllIlIlII, final World llllllllllllIlllllIlIIIIllIlIIll, final BlockPos llllllllllllIlllllIlIIIIllIIllIl, final Block llllllllllllIlllllIlIIIIllIlIIIl, final BlockPos llllllllllllIlllllIlIIIIllIlIIII) {
        if (!this.canBlockStay(llllllllllllIlllllIlIIIIllIlIIll, llllllllllllIlllllIlIIIIllIIllIl)) {
            llllllllllllIlllllIlIIIIllIlIIll.destroyBlock(llllllllllllIlllllIlIIIIllIIllIl, true);
        }
    }
    
    protected BlockCactus() {
        super(Material.CACTUS);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockCactus.AGE, 0));
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockCactus.AGE });
    }
    
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final IBlockState llllllllllllIlllllIlIIIIlllIlllI, final IBlockAccess llllllllllllIlllllIlIIIIlllIllIl, final BlockPos llllllllllllIlllllIlIIIIlllIllII) {
        return BlockCactus.CACTUS_COLLISION_AABB;
    }
    
    @Override
    public boolean isFullCube(final IBlockState llllllllllllIlllllIlIIIIlllIIlII) {
        return false;
    }
    
    public boolean canBlockStay(final World llllllllllllIlllllIlIIIIllIIIllI, final BlockPos llllllllllllIlllllIlIIIIllIIIIII) {
        for (final EnumFacing llllllllllllIlllllIlIIIIllIIIlII : EnumFacing.Plane.HORIZONTAL) {
            final Material llllllllllllIlllllIlIIIIllIIIIll = llllllllllllIlllllIlIIIIllIIIllI.getBlockState(llllllllllllIlllllIlIIIIllIIIIII.offset(llllllllllllIlllllIlIIIIllIIIlII)).getMaterial();
            if (llllllllllllIlllllIlIIIIllIIIIll.isSolid() || llllllllllllIlllllIlIIIIllIIIIll == Material.LAVA) {
                return false;
            }
        }
        final Block llllllllllllIlllllIlIIIIllIIIIlI = llllllllllllIlllllIlIIIIllIIIllI.getBlockState(llllllllllllIlllllIlIIIIllIIIIII.down()).getBlock();
        return llllllllllllIlllllIlIIIIllIIIIlI == Blocks.CACTUS || (llllllllllllIlllllIlIIIIllIIIIlI == Blocks.SAND && !llllllllllllIlllllIlIIIIllIIIllI.getBlockState(llllllllllllIlllllIlIIIIllIIIIII.up()).getMaterial().isLiquid());
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllIlllllIlIIIIlIlIllll) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockCactus.AGE, llllllllllllIlllllIlIIIIlIlIllll);
    }
    
    @Override
    public void onEntityCollidedWithBlock(final World llllllllllllIlllllIlIIIIlIlllIlI, final BlockPos llllllllllllIlllllIlIIIIlIlllIIl, final IBlockState llllllllllllIlllllIlIIIIlIlllIII, final Entity llllllllllllIlllllIlIIIIlIllIllI) {
        llllllllllllIlllllIlIIIIlIllIllI.attackEntityFrom(DamageSource.cactus, 1.0f);
    }
    
    @Override
    public AxisAlignedBB getSelectedBoundingBox(final IBlockState llllllllllllIlllllIlIIIIlllIlIIl, final World llllllllllllIlllllIlIIIIlllIlIII, final BlockPos llllllllllllIlllllIlIIIIlllIIlll) {
        return BlockCactus.CACTUS_AABB.offset(llllllllllllIlllllIlIIIIlllIIlll);
    }
    
    static {
        AGE = PropertyInteger.create("age", 0, 15);
        CACTUS_COLLISION_AABB = new AxisAlignedBB(0.0625, 0.0, 0.0625, 0.9375, 0.9375, 0.9375);
        CACTUS_AABB = new AxisAlignedBB(0.0625, 0.0, 0.0625, 0.9375, 1.0, 0.9375);
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess llllllllllllIlllllIlIIIIlIlIIllI, final IBlockState llllllllllllIlllllIlIIIIlIlIIlIl, final BlockPos llllllllllllIlllllIlIIIIlIlIIlII, final EnumFacing llllllllllllIlllllIlIIIIlIlIIIll) {
        return BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllIlllllIlIIIIlIlIlIll) {
        return llllllllllllIlllllIlIIIIlIlIlIll.getValue((IProperty<Integer>)BlockCactus.AGE);
    }
    
    @Override
    public boolean canPlaceBlockAt(final World llllllllllllIlllllIlIIIIllIlllIl, final BlockPos llllllllllllIlllllIlIIIIllIllIIl) {
        return super.canPlaceBlockAt(llllllllllllIlllllIlIIIIllIlllIl, llllllllllllIlllllIlIIIIllIllIIl) && this.canBlockStay(llllllllllllIlllllIlIIIIllIlllIl, llllllllllllIlllllIlIIIIllIllIIl);
    }
}
