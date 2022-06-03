// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.IStringSerializable;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import java.util.Random;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.block.properties.PropertyEnum;

public abstract class BlockSlab extends Block
{
    public static final /* synthetic */ PropertyEnum<EnumBlockHalf> HALF;
    protected static final /* synthetic */ AxisAlignedBB AABB_BOTTOM_HALF;
    protected static final /* synthetic */ AxisAlignedBB AABB_TOP_HALF;
    
    public abstract IProperty<?> getVariantProperty();
    
    protected static boolean isHalfSlab(final IBlockState lllllllllllIlIllllIIlIIIlllIIIll) {
        final Block lllllllllllIlIllllIIlIIIlllIIlII = lllllllllllIlIllllIIlIIIlllIIIll.getBlock();
        return lllllllllllIlIllllIIlIIIlllIIlII == Blocks.STONE_SLAB || lllllllllllIlIllllIIlIIIlllIIlII == Blocks.WOODEN_SLAB || lllllllllllIlIllllIIlIIIlllIIlII == Blocks.STONE_SLAB2 || lllllllllllIlIllllIIlIIIlllIIlII == Blocks.PURPUR_SLAB;
    }
    
    @Override
    public boolean isFullyOpaque(final IBlockState lllllllllllIlIllllIIlIIlIIllIIll) {
        return ((BlockSlab)lllllllllllIlIllllIIlIIlIIllIIll.getBlock()).isDouble() || lllllllllllIlIllllIIlIIlIIllIIll.getValue(BlockSlab.HALF) == EnumBlockHalf.TOP;
    }
    
    public BlockSlab(final Material lllllllllllIlIllllIIlIIlIlIIIlII, final MapColor lllllllllllIlIllllIIlIIlIlIIIIII) {
        super(lllllllllllIlIllllIIlIIlIlIIIlII, lllllllllllIlIllllIIlIIlIlIIIIII);
        this.fullBlock = this.isDouble();
        this.setLightOpacity(255);
    }
    
    @Override
    public int quantityDropped(final Random lllllllllllIlIllllIIlIIlIIIIIlIl) {
        return this.isDouble() ? 2 : 1;
    }
    
    public abstract String getUnlocalizedName(final int p0);
    
    @Override
    public IBlockState onBlockPlaced(final World lllllllllllIlIllllIIlIIlIIIlIIII, final BlockPos lllllllllllIlIllllIIlIIlIIIllIIl, final EnumFacing lllllllllllIlIllllIIlIIlIIIllIII, final float lllllllllllIlIllllIIlIIlIIIIllIl, final float lllllllllllIlIllllIIlIIlIIIlIllI, final float lllllllllllIlIllllIIlIIlIIIIlIll, final int lllllllllllIlIllllIIlIIlIIIIlIlI, final EntityLivingBase lllllllllllIlIllllIIlIIlIIIlIIll) {
        final IBlockState lllllllllllIlIllllIIlIIlIIIlIIlI = super.onBlockPlaced(lllllllllllIlIllllIIlIIlIIIlIIII, lllllllllllIlIllllIIlIIlIIIllIIl, lllllllllllIlIllllIIlIIlIIIllIII, lllllllllllIlIllllIIlIIlIIIIllIl, lllllllllllIlIllllIIlIIlIIIlIllI, lllllllllllIlIllllIIlIIlIIIIlIll, lllllllllllIlIllllIIlIIlIIIIlIlI, lllllllllllIlIllllIIlIIlIIIlIIll).withProperty(BlockSlab.HALF, EnumBlockHalf.BOTTOM);
        if (this.isDouble()) {
            return lllllllllllIlIllllIIlIIlIIIlIIlI;
        }
        return (lllllllllllIlIllllIIlIIlIIIllIII != EnumFacing.DOWN && (lllllllllllIlIllllIIlIIlIIIllIII == EnumFacing.UP || lllllllllllIlIllllIIlIIlIIIlIllI <= 0.5)) ? lllllllllllIlIllllIIlIIlIIIlIIlI : lllllllllllIlIllllIIlIIlIIIlIIlI.withProperty(BlockSlab.HALF, EnumBlockHalf.TOP);
    }
    
    public BlockSlab(final Material lllllllllllIlIllllIIlIIlIlIIlIIl) {
        this(lllllllllllIlIllllIIlIIlIlIIlIIl, lllllllllllIlIllllIIlIIlIlIIlIIl.getMaterialMapColor());
    }
    
    public abstract boolean isDouble();
    
    static {
        HALF = PropertyEnum.create("half", EnumBlockHalf.class);
        AABB_BOTTOM_HALF = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.5, 1.0);
        AABB_TOP_HALF = new AxisAlignedBB(0.0, 0.5, 0.0, 1.0, 1.0, 1.0);
    }
    
    @Override
    protected boolean canSilkHarvest() {
        return false;
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllIlIllllIIlIIlIIIIIIIl) {
        return this.isDouble();
    }
    
    @Override
    public boolean shouldSideBeRendered(final IBlockState lllllllllllIlIllllIIlIIIllllIllI, final IBlockAccess lllllllllllIlIllllIIlIIIllllIlIl, final BlockPos lllllllllllIlIllllIIlIIIllllIlII, final EnumFacing lllllllllllIlIllllIIlIIIllllIIll) {
        if (this.isDouble()) {
            return super.shouldSideBeRendered(lllllllllllIlIllllIIlIIIllllIllI, lllllllllllIlIllllIIlIIIllllIlIl, lllllllllllIlIllllIIlIIIllllIlII, lllllllllllIlIllllIIlIIIllllIIll);
        }
        if (lllllllllllIlIllllIIlIIIllllIIll != EnumFacing.UP && lllllllllllIlIllllIIlIIIllllIIll != EnumFacing.DOWN && !super.shouldSideBeRendered(lllllllllllIlIllllIIlIIIllllIllI, lllllllllllIlIllllIIlIIIllllIlIl, lllllllllllIlIllllIIlIIIllllIlII, lllllllllllIlIllllIIlIIIllllIIll)) {
            return false;
        }
        final IBlockState lllllllllllIlIllllIIlIIIllllIIlI = lllllllllllIlIllllIIlIIIllllIlIl.getBlockState(lllllllllllIlIllllIIlIIIllllIlII.offset(lllllllllllIlIllllIIlIIIllllIIll));
        final boolean lllllllllllIlIllllIIlIIIllllIIIl = isHalfSlab(lllllllllllIlIllllIIlIIIllllIIlI) && lllllllllllIlIllllIIlIIIllllIIlI.getValue(BlockSlab.HALF) == EnumBlockHalf.TOP;
        final boolean lllllllllllIlIllllIIlIIIllllIIII = isHalfSlab(lllllllllllIlIllllIIlIIIllllIllI) && lllllllllllIlIllllIIlIIIllllIllI.getValue(BlockSlab.HALF) == EnumBlockHalf.TOP;
        if (lllllllllllIlIllllIIlIIIllllIIII) {
            return lllllllllllIlIllllIIlIIIllllIIll == EnumFacing.DOWN || (lllllllllllIlIllllIIlIIIllllIIll == EnumFacing.UP && super.shouldSideBeRendered(lllllllllllIlIllllIIlIIIllllIllI, lllllllllllIlIllllIIlIIIllllIlIl, lllllllllllIlIllllIIlIIIllllIlII, lllllllllllIlIllllIIlIIIllllIIll)) || !isHalfSlab(lllllllllllIlIllllIIlIIIllllIIlI) || !lllllllllllIlIllllIIlIIIllllIIIl;
        }
        return lllllllllllIlIllllIIlIIIllllIIll == EnumFacing.UP || (lllllllllllIlIllllIIlIIIllllIIll == EnumFacing.DOWN && super.shouldSideBeRendered(lllllllllllIlIllllIIlIIIllllIllI, lllllllllllIlIllllIIlIIIllllIlIl, lllllllllllIlIllllIIlIIIllllIlII, lllllllllllIlIllllIIlIIIllllIIll)) || !isHalfSlab(lllllllllllIlIllllIIlIIIllllIIlI) || lllllllllllIlIllllIIlIIIllllIIIl;
    }
    
    public abstract Comparable<?> getTypeForItem(final ItemStack p0);
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllIlIllllIIlIIlIIlIIlll) {
        return this.isDouble();
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllIlIllllIIlIIlIIlIllll, final IBlockState lllllllllllIlIllllIIlIIlIIlIlIll, final BlockPos lllllllllllIlIllllIIlIIlIIlIllIl, final EnumFacing lllllllllllIlIllllIIlIIlIIlIllII) {
        if (((BlockSlab)lllllllllllIlIllllIIlIIlIIlIlIll.getBlock()).isDouble()) {
            return BlockFaceShape.SOLID;
        }
        if (lllllllllllIlIllllIIlIIlIIlIllII == EnumFacing.UP && lllllllllllIlIllllIIlIIlIIlIlIll.getValue(BlockSlab.HALF) == EnumBlockHalf.TOP) {
            return BlockFaceShape.SOLID;
        }
        return (lllllllllllIlIllllIIlIIlIIlIllII == EnumFacing.DOWN && lllllllllllIlIllllIIlIIlIIlIlIll.getValue(BlockSlab.HALF) == EnumBlockHalf.BOTTOM) ? BlockFaceShape.SOLID : BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllIlIllllIIlIIlIIlllIll, final IBlockAccess lllllllllllIlIllllIIlIIlIIlllIlI, final BlockPos lllllllllllIlIllllIIlIIlIIlllIIl) {
        if (this.isDouble()) {
            return BlockSlab.FULL_BLOCK_AABB;
        }
        return (lllllllllllIlIllllIIlIIlIIlllIll.getValue(BlockSlab.HALF) == EnumBlockHalf.TOP) ? BlockSlab.AABB_TOP_HALF : BlockSlab.AABB_BOTTOM_HALF;
    }
    
    public enum EnumBlockHalf implements IStringSerializable
    {
        private final /* synthetic */ String name;
        
        TOP("TOP", 0, "top"), 
        BOTTOM("BOTTOM", 1, "bottom");
        
        private EnumBlockHalf(final String lllllllllllIlIIIlIIIIlIIlllIlIIl, final int lllllllllllIlIIIlIIIIlIIlllIlIII, final String lllllllllllIlIIIlIIIIlIIlllIlIll) {
            this.name = lllllllllllIlIIIlIIIIlIIlllIlIll;
        }
        
        @Override
        public String toString() {
            return this.name;
        }
        
        @Override
        public String getName() {
            return this.name;
        }
    }
}
