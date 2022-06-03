// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.EnumHand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.util.Rotation;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import java.util.Random;
import net.minecraft.entity.Entity;
import java.util.List;
import net.minecraft.util.Mirror;
import net.minecraft.util.math.AxisAlignedBB;
import javax.annotation.Nullable;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityPiston;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;

public class BlockPistonMoving extends BlockContainer
{
    public static final /* synthetic */ PropertyEnum<BlockPistonExtension.EnumPistonType> TYPE;
    public static final /* synthetic */ PropertyDirection FACING;
    
    public BlockPistonMoving() {
        super(Material.PISTON);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockPistonMoving.FACING, EnumFacing.NORTH).withProperty(BlockPistonMoving.TYPE, BlockPistonExtension.EnumPistonType.DEFAULT));
        this.setHardness(-1.0f);
    }
    
    @Override
    public void neighborChanged(final IBlockState llllllllllIllllIllIIIllIlllllIll, final World llllllllllIllllIllIIIllIlllllIlI, final BlockPos llllllllllIllllIllIIIllIlllllIIl, final Block llllllllllIllllIllIIIllIlllllIII, final BlockPos llllllllllIllllIllIIIllIllllIlll) {
        if (!llllllllllIllllIllIIIllIlllllIlI.isRemote) {
            llllllllllIllllIllIIIllIlllllIlI.getTileEntity(llllllllllIllllIllIIIllIlllllIIl);
        }
    }
    
    @Nullable
    private TileEntityPiston getTilePistonAt(final IBlockAccess llllllllllIllllIllIIIllIlIllllll, final BlockPos llllllllllIllllIllIIIllIlIlllIll) {
        final TileEntity llllllllllIllllIllIIIllIlIllllIl = llllllllllIllllIllIIIllIlIllllll.getTileEntity(llllllllllIllllIllIIIllIlIlllIll);
        return (llllllllllIllllIllIIIllIlIllllIl instanceof TileEntityPiston) ? ((TileEntityPiston)llllllllllIllllIllIIIllIlIllllIl) : null;
    }
    
    @Override
    public void breakBlock(final World llllllllllIllllIllIIIlllIlIIllII, final BlockPos llllllllllIllllIllIIIlllIlIIlIll, final IBlockState llllllllllIllllIllIIIlllIlIIlIlI) {
        final TileEntity llllllllllIllllIllIIIlllIlIIlIIl = llllllllllIllllIllIIIlllIlIIllII.getTileEntity(llllllllllIllllIllIIIlllIlIIlIll);
        if (llllllllllIllllIllIIIlllIlIIlIIl instanceof TileEntityPiston) {
            ((TileEntityPiston)llllllllllIllllIllIIIlllIlIIlIIl).clearPistonTileEntity();
        }
        else {
            super.breakBlock(llllllllllIllllIllIIIlllIlIIllII, llllllllllIllllIllIIIlllIlIIlIll, llllllllllIllllIllIIIlllIlIIlIlI);
        }
    }
    
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final IBlockState llllllllllIllllIllIIIllIlllIllll, final IBlockAccess llllllllllIllllIllIIIllIlllIlllI, final BlockPos llllllllllIllllIllIIIllIlllIlIIl) {
        final TileEntityPiston llllllllllIllllIllIIIllIlllIllII = this.getTilePistonAt(llllllllllIllllIllIIIllIlllIlllI, llllllllllIllllIllIIIllIlllIlIIl);
        return (llllllllllIllllIllIIIllIlllIllII == null) ? null : llllllllllIllllIllIIIllIlllIllII.getAABB(llllllllllIllllIllIIIllIlllIlllI, llllllllllIllllIllIIIllIlllIlIIl);
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllIllllIllIIIllIlIllIIII) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockPistonMoving.FACING, BlockPistonExtension.getFacing(llllllllllIllllIllIIIllIlIllIIII)).withProperty(BlockPistonMoving.TYPE, ((llllllllllIllllIllIIIllIlIllIIII & 0x8) > 0) ? BlockPistonExtension.EnumPistonType.STICKY : BlockPistonExtension.EnumPistonType.DEFAULT);
    }
    
    @Override
    public IBlockState withMirror(final IBlockState llllllllllIllllIllIIIllIlIlIIlIl, final Mirror llllllllllIllllIllIIIllIlIlIIlII) {
        return llllllllllIllllIllIIIllIlIlIIlIl.withRotation(llllllllllIllllIllIIIllIlIlIIlII.toRotation(llllllllllIllllIllIIIllIlIlIIlIl.getValue((IProperty<EnumFacing>)BlockPistonMoving.FACING)));
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllIllllIllIIIllIlIIllllI) {
        int llllllllllIllllIllIIIllIlIIlllIl = 0;
        llllllllllIllllIllIIIllIlIIlllIl |= llllllllllIllllIllIIIllIlIIllllI.getValue((IProperty<EnumFacing>)BlockPistonMoving.FACING).getIndex();
        if (llllllllllIllllIllIIIllIlIIllllI.getValue(BlockPistonMoving.TYPE) == BlockPistonExtension.EnumPistonType.STICKY) {
            llllllllllIllllIllIIIllIlIIlllIl |= 0x8;
        }
        return llllllllllIllllIllIIIllIlIIlllIl;
    }
    
    @Override
    public void addCollisionBoxToList(final IBlockState llllllllllIllllIllIIIllIllIlllll, final World llllllllllIllllIllIIIllIllIllllI, final BlockPos llllllllllIllllIllIIIllIllIlllIl, final AxisAlignedBB llllllllllIllllIllIIIllIllIlllII, final List<AxisAlignedBB> llllllllllIllllIllIIIllIllIllIll, @Nullable final Entity llllllllllIllllIllIIIllIllIlIIlI, final boolean llllllllllIllllIllIIIllIllIllIIl) {
        final TileEntityPiston llllllllllIllllIllIIIllIllIllIII = this.getTilePistonAt(llllllllllIllllIllIIIllIllIllllI, llllllllllIllllIllIIIllIllIlllIl);
        if (llllllllllIllllIllIIIllIllIllIII != null) {
            llllllllllIllllIllIIIllIllIllIII.func_190609_a(llllllllllIllllIllIIIllIllIllllI, llllllllllIllllIllIIIllIllIlllIl, llllllllllIllllIllIIIllIllIlllII, llllllllllIllllIllIIIllIllIllIll, llllllllllIllllIllIIIllIllIlIIlI);
        }
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState llllllllllIllllIllIIIlllIIlIlIll) {
        return false;
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState llllllllllIllllIllIIIllIllIIlIll, final IBlockAccess llllllllllIllllIllIIIllIllIIlIlI, final BlockPos llllllllllIllllIllIIIllIllIIIlIl) {
        final TileEntityPiston llllllllllIllllIllIIIllIllIIlIII = this.getTilePistonAt(llllllllllIllllIllIIIllIllIIlIlI, llllllllllIllllIllIIIllIllIIIlIl);
        return (llllllllllIllllIllIIIllIllIIlIII != null) ? llllllllllIllllIllIIIllIllIIlIII.getAABB(llllllllllIllllIllIIIllIllIIlIlI, llllllllllIllllIllIIIllIllIIIlIl) : BlockPistonMoving.FULL_BLOCK_AABB;
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllIllllIllIIIlllIIIllIIl, final Random llllllllllIllllIllIIIlllIIIllIII, final int llllllllllIllllIllIIIlllIIIlIlll) {
        return Items.field_190931_a;
    }
    
    @Override
    public ItemStack getItem(final World llllllllllIllllIllIIIllIlIlllIII, final BlockPos llllllllllIllllIllIIIllIlIllIlll, final IBlockState llllllllllIllllIllIIIllIlIllIllI) {
        return ItemStack.field_190927_a;
    }
    
    @Override
    public IBlockState withRotation(final IBlockState llllllllllIllllIllIIIllIlIlIllII, final Rotation llllllllllIllllIllIIIllIlIlIlIIl) {
        return llllllllllIllllIllIIIllIlIlIllII.withProperty((IProperty<Comparable>)BlockPistonMoving.FACING, llllllllllIllllIllIIIllIlIlIlIIl.rotate(llllllllllIllllIllIIIllIlIlIllII.getValue((IProperty<EnumFacing>)BlockPistonMoving.FACING)));
    }
    
    public static TileEntity createTilePiston(final IBlockState llllllllllIllllIllIIIlllIlIlIllI, final EnumFacing llllllllllIllllIllIIIlllIlIllIIl, final boolean llllllllllIllllIllIIIlllIlIllIII, final boolean llllllllllIllllIllIIIlllIlIlIIll) {
        return new TileEntityPiston(llllllllllIllllIllIIIlllIlIlIllI, llllllllllIllllIllIIIlllIlIllIIl, llllllllllIllllIllIIIlllIlIllIII, llllllllllIllllIllIIIlllIlIlIIll);
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockPistonMoving.FACING, BlockPistonMoving.TYPE });
    }
    
    @Override
    public boolean canPlaceBlockOnSide(final World llllllllllIllllIllIIIlllIIllllll, final BlockPos llllllllllIllllIllIIIlllIIlllllI, final EnumFacing llllllllllIllllIllIIIlllIIllllIl) {
        return false;
    }
    
    @Override
    public void dropBlockAsItemWithChance(final World llllllllllIllllIllIIIlllIIIIlIII, final BlockPos llllllllllIllllIllIIIlllIIIIIlll, final IBlockState llllllllllIllllIllIIIlllIIIIlllI, final float llllllllllIllllIllIIIlllIIIIllIl, final int llllllllllIllllIllIIIlllIIIIllII) {
        if (!llllllllllIllllIllIIIlllIIIIlIII.isRemote) {
            final TileEntityPiston llllllllllIllllIllIIIlllIIIIlIll = this.getTilePistonAt(llllllllllIllllIllIIIlllIIIIlIII, llllllllllIllllIllIIIlllIIIIIlll);
            if (llllllllllIllllIllIIIlllIIIIlIll != null) {
                final IBlockState llllllllllIllllIllIIIlllIIIIlIlI = llllllllllIllllIllIIIlllIIIIlIll.getPistonState();
                llllllllllIllllIllIIIlllIIIIlIlI.getBlock().dropBlockAsItem(llllllllllIllllIllIIIlllIIIIlIII, llllllllllIllllIllIIIlllIIIIIlll, llllllllllIllllIllIIIlllIIIIlIlI, 0);
            }
        }
    }
    
    @Nullable
    @Override
    public RayTraceResult collisionRayTrace(final IBlockState llllllllllIllllIllIIIlllIIIIIIll, final World llllllllllIllllIllIIIlllIIIIIIlI, final BlockPos llllllllllIllllIllIIIlllIIIIIIIl, final Vec3d llllllllllIllllIllIIIlllIIIIIIII, final Vec3d llllllllllIllllIllIIIllIllllllll) {
        return null;
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess llllllllllIllllIllIIIllIlIIlIllI, final IBlockState llllllllllIllllIllIIIllIlIIlIlIl, final BlockPos llllllllllIllllIllIIIllIlIIlIlII, final EnumFacing llllllllllIllllIllIIIllIlIIlIIll) {
        return BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public boolean canPlaceBlockAt(final World llllllllllIllllIllIIIlllIlIIIIlI, final BlockPos llllllllllIllllIllIIIlllIlIIIIIl) {
        return false;
    }
    
    static {
        FACING = BlockPistonExtension.FACING;
        TYPE = BlockPistonExtension.TYPE;
    }
    
    @Override
    public boolean onBlockActivated(final World llllllllllIllllIllIIIlllIIlIIlIl, final BlockPos llllllllllIllllIllIIIlllIIIllIll, final IBlockState llllllllllIllllIllIIIlllIIlIIIll, final EntityPlayer llllllllllIllllIllIIIlllIIlIIIlI, final EnumHand llllllllllIllllIllIIIlllIIlIIIIl, final EnumFacing llllllllllIllllIllIIIlllIIlIIIII, final float llllllllllIllllIllIIIlllIIIlllll, final float llllllllllIllllIllIIIlllIIIllllI, final float llllllllllIllllIllIIIlllIIIlllIl) {
        if (!llllllllllIllllIllIIIlllIIlIIlIl.isRemote && llllllllllIllllIllIIIlllIIlIIlIl.getTileEntity(llllllllllIllllIllIIIlllIIIllIll) == null) {
            llllllllllIllllIllIIIlllIIlIIlIl.setBlockToAir(llllllllllIllllIllIIIlllIIIllIll);
            return true;
        }
        return false;
    }
    
    @Override
    public void onBlockDestroyedByPlayer(final World llllllllllIllllIllIIIlllIIllIllI, final BlockPos llllllllllIllllIllIIIlllIIllIlIl, final IBlockState llllllllllIllllIllIIIlllIIlIllll) {
        final BlockPos llllllllllIllllIllIIIlllIIllIIll = llllllllllIllllIllIIIlllIIllIlIl.offset(llllllllllIllllIllIIIlllIIlIllll.getValue((IProperty<EnumFacing>)BlockPistonMoving.FACING).getOpposite());
        final IBlockState llllllllllIllllIllIIIlllIIllIIlI = llllllllllIllllIllIIIlllIIllIllI.getBlockState(llllllllllIllllIllIIIlllIIllIIll);
        if (llllllllllIllllIllIIIlllIIllIIlI.getBlock() instanceof BlockPistonBase && llllllllllIllllIllIIIlllIIllIIlI.getValue((IProperty<Boolean>)BlockPistonBase.EXTENDED)) {
            llllllllllIllllIllIIIlllIIllIllI.setBlockToAir(llllllllllIllllIllIIIlllIIllIIll);
        }
    }
    
    @Nullable
    @Override
    public TileEntity createNewTileEntity(final World llllllllllIllllIllIIIlllIllIIIII, final int llllllllllIllllIllIIIlllIlIlllll) {
        return null;
    }
    
    @Override
    public boolean isFullCube(final IBlockState llllllllllIllllIllIIIlllIIlIlIIl) {
        return false;
    }
}
