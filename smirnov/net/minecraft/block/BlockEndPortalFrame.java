// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.Rotation;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import net.minecraft.init.Blocks;
import net.minecraft.block.state.BlockWorldState;
import net.minecraft.block.state.pattern.BlockStateMatcher;
import net.minecraft.block.state.pattern.FactoryBlockPattern;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import java.util.Random;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.world.IBlockAccess;
import javax.annotation.Nullable;
import net.minecraft.entity.Entity;
import java.util.List;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.Mirror;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.properties.IProperty;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockPattern;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyBool;

public class BlockEndPortalFrame extends Block
{
    public static final /* synthetic */ PropertyBool EYE;
    public static final /* synthetic */ PropertyDirection FACING;
    protected static final /* synthetic */ AxisAlignedBB AABB_BLOCK;
    private static /* synthetic */ BlockPattern portalShape;
    protected static final /* synthetic */ AxisAlignedBB AABB_EYE;
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllIIlIlllllIlIllIlIIlIl) {
        return false;
    }
    
    public BlockEndPortalFrame() {
        super(Material.ROCK, MapColor.GREEN);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockEndPortalFrame.FACING, EnumFacing.NORTH).withProperty((IProperty<Comparable>)BlockEndPortalFrame.EYE, false));
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllIIlIlllllIlIlllllIIlI) {
        return false;
    }
    
    @Override
    public int getComparatorInputOverride(final IBlockState lllllllllllIIlIlllllIlIlllIIIlIl, final World lllllllllllIIlIlllllIlIlllIIIlll, final BlockPos lllllllllllIIlIlllllIlIlllIIIllI) {
        return lllllllllllIIlIlllllIlIlllIIIlIl.getValue((IProperty<Boolean>)BlockEndPortalFrame.EYE) ? 15 : 0;
    }
    
    @Override
    public IBlockState withMirror(final IBlockState lllllllllllIIlIlllllIlIllIlIllIl, final Mirror lllllllllllIIlIlllllIlIllIlIllII) {
        return lllllllllllIIlIlllllIlIllIlIllIl.withRotation(lllllllllllIIlIlllllIlIllIlIllII.toRotation(lllllllllllIIlIlllllIlIllIlIllIl.getValue((IProperty<EnumFacing>)BlockEndPortalFrame.FACING)));
    }
    
    @Override
    public IBlockState onBlockPlaced(final World lllllllllllIIlIlllllIlIlllIlIllI, final BlockPos lllllllllllIIlIlllllIlIlllIlIlIl, final EnumFacing lllllllllllIIlIlllllIlIlllIlIlII, final float lllllllllllIIlIlllllIlIlllIlIIll, final float lllllllllllIIlIlllllIlIlllIlIIlI, final float lllllllllllIIlIlllllIlIlllIlIIIl, final int lllllllllllIIlIlllllIlIlllIlIIII, final EntityLivingBase lllllllllllIIlIlllllIlIlllIIllIl) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockEndPortalFrame.FACING, lllllllllllIIlIlllllIlIlllIIllIl.getHorizontalFacing().getOpposite()).withProperty((IProperty<Comparable>)BlockEndPortalFrame.EYE, false);
    }
    
    @Override
    public void addCollisionBoxToList(final IBlockState lllllllllllIIlIlllllIlIllllIlIII, final World lllllllllllIIlIlllllIlIllllIIlll, final BlockPos lllllllllllIIlIlllllIlIllllIIllI, final AxisAlignedBB lllllllllllIIlIlllllIlIllllIIlIl, final List<AxisAlignedBB> lllllllllllIIlIlllllIlIlllIllllI, @Nullable final Entity lllllllllllIIlIlllllIlIllllIIIll, final boolean lllllllllllIIlIlllllIlIllllIIIlI) {
        Block.addCollisionBoxToList(lllllllllllIIlIlllllIlIllllIIllI, lllllllllllIIlIlllllIlIllllIIlIl, lllllllllllIIlIlllllIlIlllIllllI, BlockEndPortalFrame.AABB_BLOCK);
        if (lllllllllllIIlIlllllIlIllllIIlll.getBlockState(lllllllllllIIlIlllllIlIllllIIllI).getValue((IProperty<Boolean>)BlockEndPortalFrame.EYE)) {
            Block.addCollisionBoxToList(lllllllllllIIlIlllllIlIllllIIllI, lllllllllllIIlIlllllIlIllllIIlIl, lllllllllllIIlIlllllIlIlllIllllI, BlockEndPortalFrame.AABB_EYE);
        }
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllIIlIlllllIlIllIlllIll) {
        int lllllllllllIIlIlllllIlIllIlllIlI = 0;
        lllllllllllIIlIlllllIlIllIlllIlI |= lllllllllllIIlIlllllIlIllIlllIll.getValue((IProperty<EnumFacing>)BlockEndPortalFrame.FACING).getHorizontalIndex();
        if (lllllllllllIIlIlllllIlIllIlllIll.getValue((IProperty<Boolean>)BlockEndPortalFrame.EYE)) {
            lllllllllllIIlIlllllIlIllIlllIlI |= 0x4;
        }
        return lllllllllllIIlIlllllIlIllIlllIlI;
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllIIlIlllllIlIllIlIIIlI, final IBlockState lllllllllllIIlIlllllIlIllIlIIIIl, final BlockPos lllllllllllIIlIlllllIlIllIlIIIII, final EnumFacing lllllllllllIIlIlllllIlIllIIlllll) {
        return (lllllllllllIIlIlllllIlIllIIlllll == EnumFacing.DOWN) ? BlockFaceShape.SOLID : BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllIIlIlllllIlIlllIlllII, final Random lllllllllllIIlIlllllIlIlllIllIll, final int lllllllllllIIlIlllllIlIlllIllIlI) {
        return Items.field_190931_a;
    }
    
    @Override
    public boolean hasComparatorInputOverride(final IBlockState lllllllllllIIlIlllllIlIlllIIlIll) {
        return true;
    }
    
    static {
        FACING = BlockHorizontal.FACING;
        EYE = PropertyBool.create("eye");
        AABB_BLOCK = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.8125, 1.0);
        AABB_EYE = new AxisAlignedBB(0.3125, 0.8125, 0.3125, 0.6875, 1.0, 0.6875);
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllIIlIlllllIlIlllllIIII, final IBlockAccess lllllllllllIIlIlllllIlIllllIllll, final BlockPos lllllllllllIIlIlllllIlIllllIlllI) {
        return BlockEndPortalFrame.AABB_BLOCK;
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockEndPortalFrame.FACING, BlockEndPortalFrame.EYE });
    }
    
    public static BlockPattern getOrCreatePortalShape() {
        if (BlockEndPortalFrame.portalShape == null) {
            BlockEndPortalFrame.portalShape = FactoryBlockPattern.start().aisle("?vvv?", ">???<", ">???<", ">???<", "?^^^?").where('?', BlockWorldState.hasState(BlockStateMatcher.ANY)).where('^', BlockWorldState.hasState((Predicate<IBlockState>)BlockStateMatcher.forBlock(Blocks.END_PORTAL_FRAME).where((IProperty<Comparable>)BlockEndPortalFrame.EYE, (com.google.common.base.Predicate<? extends Comparable>)Predicates.equalTo((Object)true)).where((IProperty<Comparable>)BlockEndPortalFrame.FACING, (com.google.common.base.Predicate<? extends Comparable>)Predicates.equalTo((Object)EnumFacing.SOUTH)))).where('>', BlockWorldState.hasState((Predicate<IBlockState>)BlockStateMatcher.forBlock(Blocks.END_PORTAL_FRAME).where((IProperty<Comparable>)BlockEndPortalFrame.EYE, (com.google.common.base.Predicate<? extends Comparable>)Predicates.equalTo((Object)true)).where((IProperty<Comparable>)BlockEndPortalFrame.FACING, (com.google.common.base.Predicate<? extends Comparable>)Predicates.equalTo((Object)EnumFacing.WEST)))).where('v', BlockWorldState.hasState((Predicate<IBlockState>)BlockStateMatcher.forBlock(Blocks.END_PORTAL_FRAME).where((IProperty<Comparable>)BlockEndPortalFrame.EYE, (com.google.common.base.Predicate<? extends Comparable>)Predicates.equalTo((Object)true)).where((IProperty<Comparable>)BlockEndPortalFrame.FACING, (com.google.common.base.Predicate<? extends Comparable>)Predicates.equalTo((Object)EnumFacing.NORTH)))).where('<', BlockWorldState.hasState((Predicate<IBlockState>)BlockStateMatcher.forBlock(Blocks.END_PORTAL_FRAME).where((IProperty<Comparable>)BlockEndPortalFrame.EYE, (com.google.common.base.Predicate<? extends Comparable>)Predicates.equalTo((Object)true)).where((IProperty<Comparable>)BlockEndPortalFrame.FACING, (com.google.common.base.Predicate<? extends Comparable>)Predicates.equalTo((Object)EnumFacing.EAST)))).build();
        }
        return BlockEndPortalFrame.portalShape;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllIIlIlllllIlIlllIIIIIl) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockEndPortalFrame.EYE, (lllllllllllIIlIlllllIlIlllIIIIIl & 0x4) != 0x0).withProperty((IProperty<Comparable>)BlockEndPortalFrame.FACING, EnumFacing.getHorizontal(lllllllllllIIlIlllllIlIlllIIIIIl & 0x3));
    }
    
    @Override
    public IBlockState withRotation(final IBlockState lllllllllllIIlIlllllIlIllIllIIlI, final Rotation lllllllllllIIlIlllllIlIllIllIIIl) {
        return lllllllllllIIlIlllllIlIllIllIIlI.withProperty((IProperty<Comparable>)BlockEndPortalFrame.FACING, lllllllllllIIlIlllllIlIllIllIIIl.rotate(lllllllllllIIlIlllllIlIllIllIIlI.getValue((IProperty<EnumFacing>)BlockEndPortalFrame.FACING)));
    }
}
