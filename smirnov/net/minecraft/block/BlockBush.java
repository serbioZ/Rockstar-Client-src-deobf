// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import javax.annotation.Nullable;
import net.minecraft.init.Blocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.block.material.Material;
import java.util.Random;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.util.math.AxisAlignedBB;

public class BlockBush extends Block
{
    protected static final /* synthetic */ AxisAlignedBB BUSH_AABB;
    
    public boolean canBlockStay(final World llllllllllllllIlIIlIlIIlllIlIIll, final BlockPos llllllllllllllIlIIlIlIIlllIIlllI, final IBlockState llllllllllllllIlIIlIlIIlllIlIIIl) {
        return this.canSustainBush(llllllllllllllIlIIlIlIIlllIlIIll.getBlockState(llllllllllllllIlIIlIlIIlllIIlllI.down()));
    }
    
    @Override
    public boolean isFullCube(final IBlockState llllllllllllllIlIIlIlIIlllIIIIlI) {
        return false;
    }
    
    @Override
    public void updateTick(final World llllllllllllllIlIIlIlIIllllIlIll, final BlockPos llllllllllllllIlIIlIlIIllllIlIlI, final IBlockState llllllllllllllIlIIlIlIIllllIIlII, final Random llllllllllllllIlIIlIlIIllllIlIII) {
        this.checkAndDropBlock(llllllllllllllIlIIlIlIIllllIlIll, llllllllllllllIlIIlIlIIllllIlIlI, llllllllllllllIlIIlIlIIllllIIlII);
    }
    
    protected BlockBush() {
        this(Material.PLANTS);
    }
    
    static {
        BUSH_AABB = new AxisAlignedBB(0.30000001192092896, 0.0, 0.30000001192092896, 0.699999988079071, 0.6000000238418579, 0.699999988079071);
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState llllllllllllllIlIIlIlIIlllIIIlII) {
        return false;
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState llllllllllllllIlIIlIlIIlllIIllII, final IBlockAccess llllllllllllllIlIIlIlIIlllIIlIll, final BlockPos llllllllllllllIlIIlIlIIlllIIlIlI) {
        return BlockBush.BUSH_AABB;
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess llllllllllllllIlIIlIlIIllIllllll, final IBlockState llllllllllllllIlIIlIlIIllIlllllI, final BlockPos llllllllllllllIlIIlIlIIllIllllIl, final EnumFacing llllllllllllllIlIIlIlIIllIllllII) {
        return BlockFaceShape.UNDEFINED;
    }
    
    protected BlockBush(final Material llllllllllllllIlIIlIlIlIIIIlIlII, final MapColor llllllllllllllIlIIlIlIlIIIIlIIII) {
        super(llllllllllllllIlIIlIlIlIIIIlIlII, llllllllllllllIlIIlIlIlIIIIlIIII);
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }
    
    protected void checkAndDropBlock(final World llllllllllllllIlIIlIlIIlllIllllI, final BlockPos llllllllllllllIlIIlIlIIlllIlllIl, final IBlockState llllllllllllllIlIIlIlIIlllIllIII) {
        if (!this.canBlockStay(llllllllllllllIlIIlIlIIlllIllllI, llllllllllllllIlIIlIlIIlllIlllIl, llllllllllllllIlIIlIlIIlllIllIII)) {
            this.dropBlockAsItem(llllllllllllllIlIIlIlIIlllIllllI, llllllllllllllIlIIlIlIIlllIlllIl, llllllllllllllIlIIlIlIIlllIllIII, 0);
            llllllllllllllIlIIlIlIIlllIllllI.setBlockState(llllllllllllllIlIIlIlIIlllIlllIl, Blocks.AIR.getDefaultState(), 3);
        }
    }
    
    protected boolean canSustainBush(final IBlockState llllllllllllllIlIIlIlIlIIIIIIlII) {
        return llllllllllllllIlIIlIlIlIIIIIIlII.getBlock() == Blocks.GRASS || llllllllllllllIlIIlIlIlIIIIIIlII.getBlock() == Blocks.DIRT || llllllllllllllIlIIlIlIlIIIIIIlII.getBlock() == Blocks.FARMLAND;
    }
    
    protected BlockBush(final Material llllllllllllllIlIIlIlIlIIIIllIll) {
        this(llllllllllllllIlIIlIlIlIIIIllIll, llllllllllllllIlIIlIlIlIIIIllIll.getMaterialMapColor());
    }
    
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final IBlockState llllllllllllllIlIIlIlIIlllIIlIII, final IBlockAccess llllllllllllllIlIIlIlIIlllIIIlll, final BlockPos llllllllllllllIlIIlIlIIlllIIIllI) {
        return BlockBush.NULL_AABB;
    }
    
    @Override
    public boolean canPlaceBlockAt(final World llllllllllllllIlIIlIlIlIIIIIlIll, final BlockPos llllllllllllllIlIIlIlIlIIIIIlIlI) {
        return super.canPlaceBlockAt(llllllllllllllIlIIlIlIlIIIIIlIll, llllllllllllllIlIIlIlIlIIIIIlIlI) && this.canSustainBush(llllllllllllllIlIIlIlIlIIIIIlIll.getBlockState(llllllllllllllIlIIlIlIlIIIIIlIlI.down()));
    }
    
    @Override
    public void neighborChanged(final IBlockState llllllllllllllIlIIlIlIIllllllIll, final World llllllllllllllIlIIlIlIIlllllIlII, final BlockPos llllllllllllllIlIIlIlIIlllllIIll, final Block llllllllllllllIlIIlIlIIlllllIIlI, final BlockPos llllllllllllllIlIIlIlIIlllllIIIl) {
        super.neighborChanged(llllllllllllllIlIIlIlIIllllllIll, llllllllllllllIlIIlIlIIlllllIlII, llllllllllllllIlIIlIlIIlllllIIll, llllllllllllllIlIIlIlIIlllllIIlI, llllllllllllllIlIIlIlIIlllllIIIl);
        this.checkAndDropBlock(llllllllllllllIlIIlIlIIlllllIlII, llllllllllllllIlIIlIlIIlllllIIll, llllllllllllllIlIIlIlIIllllllIll);
    }
}
