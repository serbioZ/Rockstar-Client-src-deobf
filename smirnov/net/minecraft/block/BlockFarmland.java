// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.item.Item;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.BlockFaceShape;
import java.util.Random;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.material.Material;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.util.math.AxisAlignedBB;

public class BlockFarmland extends Block
{
    protected static final /* synthetic */ AxisAlignedBB field_194405_c;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing;
    public static final /* synthetic */ PropertyInteger MOISTURE;
    protected static final /* synthetic */ AxisAlignedBB FARMLAND_AABB;
    
    protected static void func_190970_b(final World lllllllllllIlllIIllIIIIlIIlIIlII, final BlockPos lllllllllllIlllIIllIIIIlIIlIIIll) {
        lllllllllllIlllIIllIIIIlIIlIIlII.setBlockState(lllllllllllIlllIIllIIIIlIIlIIIll, Blocks.DIRT.getDefaultState());
        final AxisAlignedBB lllllllllllIlllIIllIIIIlIIlIIIlI = BlockFarmland.field_194405_c.offset(lllllllllllIlllIIllIIIIlIIlIIIll);
        for (final Entity lllllllllllIlllIIllIIIIlIIlIIIIl : lllllllllllIlllIIllIIIIlIIlIIlII.getEntitiesWithinAABBExcludingEntity(null, lllllllllllIlllIIllIIIIlIIlIIIlI)) {
            final double lllllllllllIlllIIllIIIIlIIlIIIII = Math.min(lllllllllllIlllIIllIIIIlIIlIIIlI.maxY - lllllllllllIlllIIllIIIIlIIlIIIlI.minY, lllllllllllIlllIIllIIIIlIIlIIIlI.maxY - lllllllllllIlllIIllIIIIlIIlIIIIl.getEntityBoundingBox().minY);
            lllllllllllIlllIIllIIIIlIIlIIIIl.setPositionAndUpdate(lllllllllllIlllIIllIIIIlIIlIIIIl.posX, lllllllllllIlllIIllIIIIlIIlIIIIl.posY + lllllllllllIlllIIllIIIIlIIlIIIII + 0.001, lllllllllllIlllIIllIIIIlIIlIIIIl.posZ);
        }
    }
    
    @Override
    public void neighborChanged(final IBlockState lllllllllllIlllIIllIIIIIllllIllI, final World lllllllllllIlllIIllIIIIIlllllIll, final BlockPos lllllllllllIlllIIllIIIIIlllllIlI, final Block lllllllllllIlllIIllIIIIIllllIIll, final BlockPos lllllllllllIlllIIllIIIIIlllllIII) {
        super.neighborChanged(lllllllllllIlllIIllIIIIIllllIllI, lllllllllllIlllIIllIIIIIlllllIll, lllllllllllIlllIIllIIIIIlllllIlI, lllllllllllIlllIIllIIIIIllllIIll, lllllllllllIlllIIllIIIIIlllllIII);
        if (lllllllllllIlllIIllIIIIIlllllIll.getBlockState(lllllllllllIlllIIllIIIIIlllllIlI.up()).getMaterial().isSolid()) {
            func_190970_b(lllllllllllIlllIIllIIIIIlllllIll, lllllllllllIlllIIllIIIIIlllllIlI);
        }
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllIlllIIllIIIIlIlIIlIlI) {
        return false;
    }
    
    @Override
    public boolean shouldSideBeRendered(final IBlockState lllllllllllIlllIIllIIIIIllIlIllI, final IBlockAccess lllllllllllIlllIIllIIIIIllIlllII, final BlockPos lllllllllllIlllIIllIIIIIllIllIll, final EnumFacing lllllllllllIlllIIllIIIIIllIlIIll) {
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllIlllIIllIIIIIllIlIIll.ordinal()]) {
            case 2: {
                return true;
            }
            case 3:
            case 4:
            case 5:
            case 6: {
                final IBlockState lllllllllllIlllIIllIIIIIllIllIIl = lllllllllllIlllIIllIIIIIllIlllII.getBlockState(lllllllllllIlllIIllIIIIIllIllIll.offset(lllllllllllIlllIIllIIIIIllIlIIll));
                final Block lllllllllllIlllIIllIIIIIllIllIII = lllllllllllIlllIIllIIIIIllIllIIl.getBlock();
                return !lllllllllllIlllIIllIIIIIllIllIIl.isOpaqueCube() && lllllllllllIlllIIllIIIIIllIllIII != Blocks.FARMLAND && lllllllllllIlllIIllIIIIIllIllIII != Blocks.GRASS_PATH;
            }
            default: {
                return super.shouldSideBeRendered(lllllllllllIlllIIllIIIIIllIlIllI, lllllllllllIlllIIllIIIIIllIlllII, lllllllllllIlllIIllIIIIIllIllIll, lllllllllllIlllIIllIIIIIllIlIIll);
            }
        }
    }
    
    protected BlockFarmland() {
        super(Material.GROUND);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockFarmland.MOISTURE, 0));
        this.setTickRandomly(true);
        this.setLightOpacity(255);
    }
    
    @Override
    public void onBlockAdded(final World lllllllllllIlllIIllIIIIIlllIlIII, final BlockPos lllllllllllIlllIIllIIIIIlllIlIll, final IBlockState lllllllllllIlllIIllIIIIIlllIIllI) {
        super.onBlockAdded(lllllllllllIlllIIllIIIIIlllIlIII, lllllllllllIlllIIllIIIIIlllIlIll, lllllllllllIlllIIllIIIIIlllIIllI);
        if (lllllllllllIlllIIllIIIIIlllIlIII.getBlockState(lllllllllllIlllIIllIIIIIlllIlIll.up()).getMaterial().isSolid()) {
            func_190970_b(lllllllllllIlllIIllIIIIIlllIlIII, lllllllllllIlllIIllIIIIIlllIlIll);
        }
    }
    
    private boolean hasCrops(final World lllllllllllIlllIIllIIIIlIIIlIlIl, final BlockPos lllllllllllIlllIIllIIIIlIIIlIIIl) {
        final Block lllllllllllIlllIIllIIIIlIIIlIIll = lllllllllllIlllIIllIIIIlIIIlIlIl.getBlockState(lllllllllllIlllIIllIIIIlIIIlIIIl.up()).getBlock();
        return lllllllllllIlllIIllIIIIlIIIlIIll instanceof BlockCrops || lllllllllllIlllIIllIIIIlIIIlIIll instanceof BlockStem;
    }
    
    private boolean hasWater(final World lllllllllllIlllIIllIIIIlIIIIIlll, final BlockPos lllllllllllIlllIIllIIIIlIIIIIllI) {
        for (final BlockPos.MutableBlockPos lllllllllllIlllIIllIIIIlIIIIlIII : BlockPos.getAllInBoxMutable(lllllllllllIlllIIllIIIIlIIIIIllI.add(-4, 0, -4), lllllllllllIlllIIllIIIIlIIIIIllI.add(4, 1, 4))) {
            if (lllllllllllIlllIIllIIIIlIIIIIlll.getBlockState(lllllllllllIlllIIllIIIIlIIIIlIII).getMaterial() == Material.WATER) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void updateTick(final World lllllllllllIlllIIllIIIIlIIllllIl, final BlockPos lllllllllllIlllIIllIIIIlIlIIIIlI, final IBlockState lllllllllllIlllIIllIIIIlIIlllIll, final Random lllllllllllIlllIIllIIIIlIlIIIIII) {
        final int lllllllllllIlllIIllIIIIlIIllllll = lllllllllllIlllIIllIIIIlIIlllIll.getValue((IProperty<Integer>)BlockFarmland.MOISTURE);
        if (!this.hasWater(lllllllllllIlllIIllIIIIlIIllllIl, lllllllllllIlllIIllIIIIlIlIIIIlI) && !lllllllllllIlllIIllIIIIlIIllllIl.isRainingAt(lllllllllllIlllIIllIIIIlIlIIIIlI.up())) {
            if (lllllllllllIlllIIllIIIIlIIllllll > 0) {
                lllllllllllIlllIIllIIIIlIIllllIl.setBlockState(lllllllllllIlllIIllIIIIlIlIIIIlI, lllllllllllIlllIIllIIIIlIIlllIll.withProperty((IProperty<Comparable>)BlockFarmland.MOISTURE, lllllllllllIlllIIllIIIIlIIllllll - 1), 2);
            }
            else if (!this.hasCrops(lllllllllllIlllIIllIIIIlIIllllIl, lllllllllllIlllIIllIIIIlIlIIIIlI)) {
                func_190970_b(lllllllllllIlllIIllIIIIlIIllllIl, lllllllllllIlllIIllIIIIlIlIIIIlI);
            }
        }
        else if (lllllllllllIlllIIllIIIIlIIllllll < 7) {
            lllllllllllIlllIIllIIIIlIIllllIl.setBlockState(lllllllllllIlllIIllIIIIlIlIIIIlI, lllllllllllIlllIIllIIIIlIIlllIll.withProperty((IProperty<Comparable>)BlockFarmland.MOISTURE, 7), 2);
        }
    }
    
    static {
        MOISTURE = PropertyInteger.create("moisture", 0, 7);
        FARMLAND_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.9375, 1.0);
        field_194405_c = new AxisAlignedBB(0.0, 0.9375, 0.0, 1.0, 1.0, 1.0);
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllIlllIIllIIIIlIlIIllII) {
        return false;
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllIlllIIllIIIIlIlIlIIII, final IBlockAccess lllllllllllIlllIIllIIIIlIlIIllll, final BlockPos lllllllllllIlllIIllIIIIlIlIIlllI) {
        return BlockFarmland.FARMLAND_AABB;
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllIlllIIllIIIIIlIlllIIl, final IBlockState lllllllllllIlllIIllIIIIIlIlllIII, final BlockPos lllllllllllIlllIIllIIIIIlIllIlll, final EnumFacing lllllllllllIlllIIllIIIIIlIllIllI) {
        return (lllllllllllIlllIIllIIIIIlIllIllI == EnumFacing.DOWN) ? BlockFaceShape.SOLID : BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllIlllIIllIIIIIllIIIIll) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockFarmland.MOISTURE, lllllllllllIlllIIllIIIIIllIIIIll & 0x7);
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockFarmland.MOISTURE });
    }
    
    @Override
    public void onFallenUpon(final World lllllllllllIlllIIllIIIIlIIlIlllI, final BlockPos lllllllllllIlllIIllIIIIlIIlIllIl, final Entity lllllllllllIlllIIllIIIIlIIllIIIl, final float lllllllllllIlllIIllIIIIlIIlIlIll) {
        if (!lllllllllllIlllIIllIIIIlIIlIlllI.isRemote && lllllllllllIlllIIllIIIIlIIlIlllI.rand.nextFloat() < lllllllllllIlllIIllIIIIlIIlIlIll - 0.5f && lllllllllllIlllIIllIIIIlIIllIIIl instanceof EntityLivingBase && (lllllllllllIlllIIllIIIIlIIllIIIl instanceof EntityPlayer || lllllllllllIlllIIllIIIIlIIlIlllI.getGameRules().getBoolean("mobGriefing")) && lllllllllllIlllIIllIIIIlIIllIIIl.width * lllllllllllIlllIIllIIIIlIIllIIIl.width * lllllllllllIlllIIllIIIIlIIllIIIl.height > 0.512f) {
            func_190970_b(lllllllllllIlllIIllIIIIlIIlIlllI, lllllllllllIlllIIllIIIIlIIlIllIl);
        }
        super.onFallenUpon(lllllllllllIlllIIllIIIIlIIlIlllI, lllllllllllIlllIIllIIIIlIIlIllIl, lllllllllllIlllIIllIIIIlIIllIIIl, lllllllllllIlllIIllIIIIlIIlIlIll);
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = BlockFarmland.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final byte lllllllllllIlllIIllIIIIIlIllIIll = (Object)new int[EnumFacing.values().length];
        try {
            lllllllllllIlllIIllIIIIIlIllIIll[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllIlllIIllIIIIIlIllIIll[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllIlllIIllIIIIIlIllIIll[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllIlllIIllIIIIIlIllIIll[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllIlllIIllIIIIIlIllIIll[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllIlllIIllIIIIIlIllIIll[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return BlockFarmland.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)lllllllllllIlllIIllIIIIIlIllIIll;
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllIlllIIllIIIIIllIIllIl, final Random lllllllllllIlllIIllIIIIIllIIlIlI, final int lllllllllllIlllIIllIIIIIllIIlIll) {
        return Blocks.DIRT.getItemDropped(Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.DIRT), lllllllllllIlllIIllIIIIIllIIlIlI, lllllllllllIlllIIllIIIIIllIIlIll);
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllIlllIIllIIIIIlIllllll) {
        return lllllllllllIlllIIllIIIIIlIllllll.getValue((IProperty<Integer>)BlockFarmland.MOISTURE);
    }
}
