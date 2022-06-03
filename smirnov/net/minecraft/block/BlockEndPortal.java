// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.EnumParticleTypes;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.util.EnumFacing;
import net.minecraft.item.ItemStack;
import java.util.Random;
import javax.annotation.Nullable;
import net.minecraft.entity.Entity;
import java.util.List;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.tileentity.TileEntityEndPortal;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;

public class BlockEndPortal extends BlockContainer
{
    protected static final /* synthetic */ AxisAlignedBB END_PORTAL_AABB;
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllIlIIIllIIIllIIIIIIlII) {
        return false;
    }
    
    @Override
    public TileEntity createNewTileEntity(final World lllllllllllIlIIIllIIIllIIIlIIIlI, final int lllllllllllIlIIIllIIIllIIIlIIIIl) {
        return new TileEntityEndPortal();
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllIlIIIllIIIllIIIIlllll, final IBlockAccess lllllllllllIlIIIllIIIllIIIIllllI, final BlockPos lllllllllllIlIIIllIIIllIIIIlllIl) {
        return BlockEndPortal.END_PORTAL_AABB;
    }
    
    @Override
    public void addCollisionBoxToList(final IBlockState lllllllllllIlIIIllIIIllIIIIIllII, final World lllllllllllIlIIIllIIIllIIIIIlIll, final BlockPos lllllllllllIlIIIllIIIllIIIIIlIlI, final AxisAlignedBB lllllllllllIlIIIllIIIllIIIIIlIIl, final List<AxisAlignedBB> lllllllllllIlIIIllIIIllIIIIIlIII, @Nullable final Entity lllllllllllIlIIIllIIIllIIIIIIlll, final boolean lllllllllllIlIIIllIIIllIIIIIIllI) {
    }
    
    @Override
    public int quantityDropped(final Random lllllllllllIlIIIllIIIllIIIIIIIII) {
        return 0;
    }
    
    @Override
    public void onEntityCollidedWithBlock(final World lllllllllllIlIIIllIIIlIllllllIlI, final BlockPos lllllllllllIlIIIllIIIlIllllllIIl, final IBlockState lllllllllllIlIIIllIIIlIllllllIII, final Entity lllllllllllIlIIIllIIIlIlllllIlll) {
        if (!lllllllllllIlIIIllIIIlIllllllIlI.isRemote && !lllllllllllIlIIIllIIIlIlllllIlll.isRiding() && !lllllllllllIlIIIllIIIlIlllllIlll.isBeingRidden() && lllllllllllIlIIIllIIIlIlllllIlll.isNonBoss() && lllllllllllIlIIIllIIIlIlllllIlll.getEntityBoundingBox().intersectsWith(lllllllllllIlIIIllIIIlIllllllIII.getBoundingBox(lllllllllllIlIIIllIIIlIllllllIlI, lllllllllllIlIIIllIIIlIllllllIIl).offset(lllllllllllIlIIIllIIIlIllllllIIl))) {
            lllllllllllIlIIIllIIIlIlllllIlll.changeDimension(1);
        }
    }
    
    @Override
    public ItemStack getItem(final World lllllllllllIlIIIllIIIlIlllIlIlII, final BlockPos lllllllllllIlIIIllIIIlIlllIlIIll, final IBlockState lllllllllllIlIIIllIIIlIlllIlIIlI) {
        return ItemStack.field_190927_a;
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllIlIIIllIIIlIlllIIllII, final IBlockState lllllllllllIlIIIllIIIlIlllIIlIll, final BlockPos lllllllllllIlIIIllIIIlIlllIIlIlI, final EnumFacing lllllllllllIlIIIllIIIlIlllIIlIIl) {
        return BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public MapColor getMapColor(final IBlockState lllllllllllIlIIIllIIIlIlllIlIIII, final IBlockAccess lllllllllllIlIIIllIIIlIlllIIllll, final BlockPos lllllllllllIlIIIllIIIlIlllIIlllI) {
        return MapColor.BLACK;
    }
    
    protected BlockEndPortal(final Material lllllllllllIlIIIllIIIllIIIlIIlII) {
        super(lllllllllllIlIIIllIIIllIIIlIIlII);
        this.setLightLevel(1.0f);
    }
    
    @Override
    public boolean shouldSideBeRendered(final IBlockState lllllllllllIlIIIllIIIllIIIIlIllI, final IBlockAccess lllllllllllIlIIIllIIIllIIIIlIlIl, final BlockPos lllllllllllIlIIIllIIIllIIIIIllll, final EnumFacing lllllllllllIlIIIllIIIllIIIIIlllI) {
        return lllllllllllIlIIIllIIIllIIIIIlllI == EnumFacing.DOWN && super.shouldSideBeRendered(lllllllllllIlIIIllIIIllIIIIlIllI, lllllllllllIlIIIllIIIllIIIIlIlIl, lllllllllllIlIIIllIIIllIIIIIllll, lllllllllllIlIIIllIIIllIIIIIlllI);
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllIlIIIllIIIllIIIIIIIlI) {
        return false;
    }
    
    @Override
    public void randomDisplayTick(final IBlockState lllllllllllIlIIIllIIIlIllllIlIII, final World lllllllllllIlIIIllIIIlIllllIIlll, final BlockPos lllllllllllIlIIIllIIIlIllllIIllI, final Random lllllllllllIlIIIllIIIlIllllIIlIl) {
        final double lllllllllllIlIIIllIIIlIllllIIlII = lllllllllllIlIIIllIIIlIllllIIllI.getX() + lllllllllllIlIIIllIIIlIllllIIlIl.nextFloat();
        final double lllllllllllIlIIIllIIIlIllllIIIll = lllllllllllIlIIIllIIIlIllllIIllI.getY() + 0.8f;
        final double lllllllllllIlIIIllIIIlIllllIIIlI = lllllllllllIlIIIllIIIlIllllIIllI.getZ() + lllllllllllIlIIIllIIIlIllllIIlIl.nextFloat();
        final double lllllllllllIlIIIllIIIlIllllIIIIl = 0.0;
        final double lllllllllllIlIIIllIIIlIllllIIIII = 0.0;
        final double lllllllllllIlIIIllIIIlIlllIlllll = 0.0;
        lllllllllllIlIIIllIIIlIllllIIlll.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, lllllllllllIlIIIllIIIlIllllIIlII, lllllllllllIlIIIllIIIlIllllIIIll, lllllllllllIlIIIllIIIlIllllIIIlI, 0.0, 0.0, 0.0, new int[0]);
    }
    
    static {
        END_PORTAL_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.75, 1.0);
    }
}
