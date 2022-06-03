// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.math.Vec3i;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.init.Biomes;
import net.minecraft.util.EnumHand;
import net.minecraft.block.material.EnumPushReaction;
import javax.annotation.Nullable;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import java.util.Random;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.block.material.MapColor;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.Rotation;
import net.minecraft.tileentity.TileEntityBed;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.properties.IProperty;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.util.math.AxisAlignedBB;

public class BlockBed extends BlockHorizontal implements ITileEntityProvider
{
    protected static final /* synthetic */ AxisAlignedBB BED_AABB;
    public static final /* synthetic */ PropertyBool OCCUPIED;
    public static final /* synthetic */ PropertyEnum<EnumPartType> PART;
    
    @Override
    public IBlockState withMirror(final IBlockState lllllllllllllIIIllIIIlIIIIIIIlll, final Mirror lllllllllllllIIIllIIIlIIIIIIIlII) {
        return lllllllllllllIIIllIIIlIIIIIIIlll.withRotation(lllllllllllllIIIllIIIlIIIIIIIlII.toRotation(lllllllllllllIIIllIIIlIIIIIIIlll.getValue((IProperty<EnumFacing>)BlockBed.FACING)));
    }
    
    @Override
    public void neighborChanged(final IBlockState lllllllllllllIIIllIIIlIIllIlIllI, final World lllllllllllllIIIllIIIlIIllIlIlIl, final BlockPos lllllllllllllIIIllIIIlIIllIlIlII, final Block lllllllllllllIIIllIIIlIIllIlIIll, final BlockPos lllllllllllllIIIllIIIlIIllIlIIlI) {
        final EnumFacing lllllllllllllIIIllIIIlIIllIlIIIl = lllllllllllllIIIllIIIlIIllIlIllI.getValue((IProperty<EnumFacing>)BlockBed.FACING);
        if (lllllllllllllIIIllIIIlIIllIlIllI.getValue(BlockBed.PART) == EnumPartType.FOOT) {
            if (lllllllllllllIIIllIIIlIIllIlIlIl.getBlockState(lllllllllllllIIIllIIIlIIllIlIlII.offset(lllllllllllllIIIllIIIlIIllIlIIIl)).getBlock() != this) {
                lllllllllllllIIIllIIIlIIllIlIlIl.setBlockToAir(lllllllllllllIIIllIIIlIIllIlIlII);
            }
        }
        else if (lllllllllllllIIIllIIIlIIllIlIlIl.getBlockState(lllllllllllllIIIllIIIlIIllIlIlII.offset(lllllllllllllIIIllIIIlIIllIlIIIl.getOpposite())).getBlock() != this) {
            if (!lllllllllllllIIIllIIIlIIllIlIlIl.isRemote) {
                this.dropBlockAsItem(lllllllllllllIIIllIIIlIIllIlIlIl, lllllllllllllIIIllIIIlIIllIlIlII, lllllllllllllIIIllIIIlIIllIlIllI, 0);
            }
            lllllllllllllIIIllIIIlIIllIlIlIl.setBlockToAir(lllllllllllllIIIllIIIlIIllIlIlII);
        }
    }
    
    @Override
    public TileEntity createNewTileEntity(final World lllllllllllllIIIllIIIIllllllIIll, final int lllllllllllllIIIllIIIIllllllIIlI) {
        return new TileEntityBed();
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllIIIllIIIlIIIIlIIIlI) {
        final EnumFacing lllllllllllllIIIllIIIlIIIIlIIlII = EnumFacing.getHorizontal(lllllllllllllIIIllIIIlIIIIlIIIlI);
        return ((lllllllllllllIIIllIIIlIIIIlIIIlI & 0x8) > 0) ? this.getDefaultState().withProperty(BlockBed.PART, EnumPartType.HEAD).withProperty((IProperty<Comparable>)BlockBed.FACING, lllllllllllllIIIllIIIlIIIIlIIlII).withProperty((IProperty<Comparable>)BlockBed.OCCUPIED, (lllllllllllllIIIllIIIlIIIIlIIIlI & 0x4) > 0) : this.getDefaultState().withProperty(BlockBed.PART, EnumPartType.FOOT).withProperty((IProperty<Comparable>)BlockBed.FACING, lllllllllllllIIIllIIIlIIIIlIIlII);
    }
    
    @Override
    public IBlockState withRotation(final IBlockState lllllllllllllIIIllIIIlIIIIIIlllI, final Rotation lllllllllllllIIIllIIIlIIIIIIllIl) {
        return lllllllllllllIIIllIIIlIIIIIIlllI.withProperty((IProperty<Comparable>)BlockBed.FACING, lllllllllllllIIIllIIIlIIIIIIllIl.rotate(lllllllllllllIIIllIIIlIIIIIIlllI.getValue((IProperty<EnumFacing>)BlockBed.FACING)));
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllllIIIllIIIIlllllllIll, final IBlockState lllllllllllllIIIllIIIIlllllllIlI, final BlockPos lllllllllllllIIIllIIIIlllllllIIl, final EnumFacing lllllllllllllIIIllIIIIlllllllIII) {
        return BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public boolean func_190946_v(final IBlockState lllllllllllllIIIllIIIlIIllIIIIII) {
        return true;
    }
    
    @Override
    public void onLanded(final World lllllllllllllIIIllIIIlIIllIllllI, final Entity lllllllllllllIIIllIIIlIIlllIIIII) {
        if (lllllllllllllIIIllIIIlIIlllIIIII.isSneaking()) {
            super.onLanded(lllllllllllllIIIllIIIlIIllIllllI, lllllllllllllIIIllIIIlIIlllIIIII);
        }
        else if (lllllllllllllIIIllIIIlIIlllIIIII.motionY < 0.0) {
            lllllllllllllIIIllIIIlIIlllIIIII.motionY = -lllllllllllllIIIllIIIlIIlllIIIII.motionY * 0.6600000262260437;
            if (!(lllllllllllllIIIllIIIlIIlllIIIII instanceof EntityLivingBase)) {
                lllllllllllllIIIllIIIlIIlllIIIII.motionY *= 0.8;
            }
        }
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllIIIllIIIlIIIIIIIIII) {
        int lllllllllllllIIIllIIIIllllllllll = 0;
        lllllllllllllIIIllIIIIllllllllll |= lllllllllllllIIIllIIIlIIIIIIIIII.getValue((IProperty<EnumFacing>)BlockBed.FACING).getHorizontalIndex();
        if (lllllllllllllIIIllIIIlIIIIIIIIII.getValue(BlockBed.PART) == EnumPartType.HEAD) {
            lllllllllllllIIIllIIIIllllllllll |= 0x8;
            if (lllllllllllllIIIllIIIlIIIIIIIIII.getValue((IProperty<Boolean>)BlockBed.OCCUPIED)) {
                lllllllllllllIIIllIIIIllllllllll |= 0x4;
            }
        }
        return lllllllllllllIIIllIIIIllllllllll;
    }
    
    @Override
    public MapColor getMapColor(final IBlockState lllllllllllllIIIllIIIlIlIIlIIlll, final IBlockAccess lllllllllllllIIIllIIIlIlIIlIIllI, final BlockPos lllllllllllllIIIllIIIlIlIIlIIlIl) {
        if (lllllllllllllIIIllIIIlIlIIlIIlll.getValue(BlockBed.PART) == EnumPartType.FOOT) {
            final TileEntity lllllllllllllIIIllIIIlIlIIlIIlII = lllllllllllllIIIllIIIlIlIIlIIllI.getTileEntity(lllllllllllllIIIllIIIlIlIIlIIlIl);
            if (lllllllllllllIIIllIIIlIlIIlIIlII instanceof TileEntityBed) {
                final EnumDyeColor lllllllllllllIIIllIIIlIlIIlIIIll = ((TileEntityBed)lllllllllllllIIIllIIIlIlIIlIIlII).func_193048_a();
                return MapColor.func_193558_a(lllllllllllllIIIllIIIlIlIIlIIIll);
            }
        }
        return MapColor.CLOTH;
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockBed.FACING, BlockBed.PART, BlockBed.OCCUPIED });
    }
    
    @Override
    public void onFallenUpon(final World lllllllllllllIIIllIIIlIIlllIlIIl, final BlockPos lllllllllllllIIIllIIIlIIlllIllIl, final Entity lllllllllllllIIIllIIIlIIlllIIlll, final float lllllllllllllIIIllIIIlIIlllIIllI) {
        super.onFallenUpon(lllllllllllllIIIllIIIlIIlllIlIIl, lllllllllllllIIIllIIIlIIlllIllIl, lllllllllllllIIIllIIIlIIlllIIlll, lllllllllllllIIIllIIIlIIlllIIllI * 0.5f);
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllllIIIllIIIlIIllIIIllI, final Random lllllllllllllIIIllIIIlIIllIIlIII, final int lllllllllllllIIIllIIIlIIllIIIlll) {
        return (lllllllllllllIIIllIIIlIIllIIIllI.getValue(BlockBed.PART) == EnumPartType.FOOT) ? Items.field_190931_a : Items.BED;
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllllIIIllIIIlIIllIIIlII, final IBlockAccess lllllllllllllIIIllIIIlIIllIIIIll, final BlockPos lllllllllllllIIIllIIIlIIllIIIIlI) {
        return BlockBed.BED_AABB;
    }
    
    @Override
    public IBlockState getActualState(IBlockState lllllllllllllIIIllIIIlIIIIIlIlIl, final IBlockAccess lllllllllllllIIIllIIIlIIIIIllIIl, final BlockPos lllllllllllllIIIllIIIlIIIIIlIIll) {
        if (lllllllllllllIIIllIIIlIIIIIlIlIl.getValue(BlockBed.PART) == EnumPartType.FOOT) {
            final IBlockState lllllllllllllIIIllIIIlIIIIIlIlll = lllllllllllllIIIllIIIlIIIIIllIIl.getBlockState(lllllllllllllIIIllIIIlIIIIIlIIll.offset(lllllllllllllIIIllIIIlIIIIIlIlIl.getValue((IProperty<EnumFacing>)BlockBed.FACING)));
            if (lllllllllllllIIIllIIIlIIIIIlIlll.getBlock() == this) {
                lllllllllllllIIIllIIIlIIIIIlIlIl = lllllllllllllIIIllIIIlIIIIIlIlIl.withProperty((IProperty<Comparable>)BlockBed.OCCUPIED, (Boolean)lllllllllllllIIIllIIIlIIIIIlIlll.getValue((IProperty<V>)BlockBed.OCCUPIED));
            }
        }
        return lllllllllllllIIIllIIIlIIIIIlIlIl;
    }
    
    @Override
    public EnumBlockRenderType getRenderType(final IBlockState lllllllllllllIIIllIIIlIIIlllIllI) {
        return EnumBlockRenderType.ENTITYBLOCK_ANIMATED;
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }
    
    @Override
    public void harvestBlock(final World lllllllllllllIIIllIIIlIIIlIIIllI, final EntityPlayer lllllllllllllIIIllIIIlIIIlIIIlIl, final BlockPos lllllllllllllIIIllIIIlIIIIlllIll, final IBlockState lllllllllllllIIIllIIIlIIIIlllIlI, final TileEntity lllllllllllllIIIllIIIlIIIlIIIIlI, final ItemStack lllllllllllllIIIllIIIlIIIIlllIII) {
        if (lllllllllllllIIIllIIIlIIIIlllIlI.getValue(BlockBed.PART) == EnumPartType.HEAD && lllllllllllllIIIllIIIlIIIlIIIIlI instanceof TileEntityBed) {
            final TileEntityBed lllllllllllllIIIllIIIlIIIlIIIIII = (TileEntityBed)lllllllllllllIIIllIIIlIIIlIIIIlI;
            final ItemStack lllllllllllllIIIllIIIlIIIIllllll = lllllllllllllIIIllIIIlIIIlIIIIII.func_193049_f();
            Block.spawnAsEntity(lllllllllllllIIIllIIIlIIIlIIIllI, lllllllllllllIIIllIIIlIIIIlllIll, lllllllllllllIIIllIIIlIIIIllllll);
        }
        else {
            super.harvestBlock(lllllllllllllIIIllIIIlIIIlIIIllI, lllllllllllllIIIllIIIlIIIlIIIlIl, lllllllllllllIIIllIIIlIIIIlllIll, lllllllllllllIIIllIIIlIIIIlllIlI, null, lllllllllllllIIIllIIIlIIIIlllIII);
        }
    }
    
    @Override
    public void breakBlock(final World lllllllllllllIIIllIIIlIIIIllIIII, final BlockPos lllllllllllllIIIllIIIlIIIIlIlIll, final IBlockState lllllllllllllIIIllIIIlIIIIlIlllI) {
        super.breakBlock(lllllllllllllIIIllIIIlIIIIllIIII, lllllllllllllIIIllIIIlIIIIlIlIll, lllllllllllllIIIllIIIlIIIIlIlllI);
        lllllllllllllIIIllIIIlIIIIllIIII.removeTileEntity(lllllllllllllIIIllIIIlIIIIlIlIll);
    }
    
    protected static boolean hasRoomForPlayer(final World lllllllllllllIIIllIIIlIIlIIIlllI, final BlockPos lllllllllllllIIIllIIIlIIlIIIllll) {
        return lllllllllllllIIIllIIIlIIlIIIlllI.getBlockState(lllllllllllllIIIllIIIlIIlIIIllll.down()).isFullyOpaque() && !lllllllllllllIIIllIIIlIIlIIIlllI.getBlockState(lllllllllllllIIIllIIIlIIlIIIllll).getMaterial().isSolid() && !lllllllllllllIIIllIIIlIIlIIIlllI.getBlockState(lllllllllllllIIIllIIIlIIlIIIllll.up()).getMaterial().isSolid();
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllllIIIllIIIlIIllllIlIl) {
        return false;
    }
    
    @Override
    public void dropBlockAsItemWithChance(final World lllllllllllllIIIllIIIlIIlIIIIllI, final BlockPos lllllllllllllIIIllIIIlIIlIIIIlIl, final IBlockState lllllllllllllIIIllIIIlIIIlllllIl, final float lllllllllllllIIIllIIIlIIlIIIIIll, final int lllllllllllllIIIllIIIlIIlIIIIIlI) {
        if (lllllllllllllIIIllIIIlIIIlllllIl.getValue(BlockBed.PART) == EnumPartType.HEAD) {
            final TileEntity lllllllllllllIIIllIIIlIIlIIIIIIl = lllllllllllllIIIllIIIlIIlIIIIllI.getTileEntity(lllllllllllllIIIllIIIlIIlIIIIlIl);
            final EnumDyeColor lllllllllllllIIIllIIIlIIlIIIIIII = (lllllllllllllIIIllIIIlIIlIIIIIIl instanceof TileEntityBed) ? ((TileEntityBed)lllllllllllllIIIllIIIlIIlIIIIIIl).func_193048_a() : EnumDyeColor.RED;
            Block.spawnAsEntity(lllllllllllllIIIllIIIlIIlIIIIllI, lllllllllllllIIIllIIIlIIlIIIIlIl, new ItemStack(Items.BED, 1, lllllllllllllIIIllIIIlIIlIIIIIII.getMetadata()));
        }
    }
    
    public BlockBed() {
        super(Material.CLOTH);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockBed.PART, EnumPartType.FOOT).withProperty((IProperty<Comparable>)BlockBed.OCCUPIED, false));
        this.isBlockContainer = true;
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllllIIIllIIIlIIllllIlll) {
        return false;
    }
    
    @Override
    public ItemStack getItem(final World lllllllllllllIIIllIIIlIIIllIlllI, final BlockPos lllllllllllllIIIllIIIlIIIllIllIl, final IBlockState lllllllllllllIIIllIIIlIIIllIllII) {
        BlockPos lllllllllllllIIIllIIIlIIIllIlIll = lllllllllllllIIIllIIIlIIIllIllIl;
        if (lllllllllllllIIIllIIIlIIIllIllII.getValue(BlockBed.PART) == EnumPartType.FOOT) {
            lllllllllllllIIIllIIIlIIIllIlIll = lllllllllllllIIIllIIIlIIIllIllIl.offset(lllllllllllllIIIllIIIlIIIllIllII.getValue((IProperty<EnumFacing>)BlockBed.FACING));
        }
        final TileEntity lllllllllllllIIIllIIIlIIIllIlIlI = lllllllllllllIIIllIIIlIIIllIlllI.getTileEntity(lllllllllllllIIIllIIIlIIIllIlIll);
        final EnumDyeColor lllllllllllllIIIllIIIlIIIllIlIIl = (lllllllllllllIIIllIIIlIIIllIlIlI instanceof TileEntityBed) ? ((TileEntityBed)lllllllllllllIIIllIIIlIIIllIlIlI).func_193048_a() : EnumDyeColor.RED;
        return new ItemStack(Items.BED, 1, lllllllllllllIIIllIIIlIIIllIlIIl.getMetadata());
    }
    
    static {
        PART = PropertyEnum.create("part", EnumPartType.class);
        OCCUPIED = PropertyBool.create("occupied");
        BED_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.5625, 1.0);
    }
    
    public static boolean func_193385_b(final int lllllllllllllIIIllIIIIllllllIIII) {
        return (lllllllllllllIIIllIIIIllllllIIII & 0x8) != 0x0;
    }
    
    @Nullable
    private EntityPlayer getPlayerInBed(final World lllllllllllllIIIllIIIlIIllllllII, final BlockPos lllllllllllllIIIllIIIlIIlllllIll) {
        for (final EntityPlayer lllllllllllllIIIllIIIlIIllllllIl : lllllllllllllIIIllIIIlIIllllllII.playerEntities) {
            if (lllllllllllllIIIllIIIlIIllllllIl.isPlayerSleeping() && lllllllllllllIIIllIIIlIIllllllIl.bedLocation.equals(lllllllllllllIIIllIIIlIIlllllIll)) {
                return lllllllllllllIIIllIIIlIIllllllIl;
            }
        }
        return null;
    }
    
    @Nullable
    public static BlockPos getSafeExitLocation(final World lllllllllllllIIIllIIIlIIlIllIIII, final BlockPos lllllllllllllIIIllIIIlIIlIlIllll, int lllllllllllllIIIllIIIlIIlIlIlllI) {
        final EnumFacing lllllllllllllIIIllIIIlIIlIlIllIl = lllllllllllllIIIllIIIlIIlIllIIII.getBlockState(lllllllllllllIIIllIIIlIIlIlIllll).getValue((IProperty<EnumFacing>)BlockBed.FACING);
        final int lllllllllllllIIIllIIIlIIlIlIllII = lllllllllllllIIIllIIIlIIlIlIllll.getX();
        final int lllllllllllllIIIllIIIlIIlIlIlIll = lllllllllllllIIIllIIIlIIlIlIllll.getY();
        final int lllllllllllllIIIllIIIlIIlIlIlIlI = lllllllllllllIIIllIIIlIIlIlIllll.getZ();
        for (int lllllllllllllIIIllIIIlIIlIlIlIIl = 0; lllllllllllllIIIllIIIlIIlIlIlIIl <= 1; ++lllllllllllllIIIllIIIlIIlIlIlIIl) {
            final int lllllllllllllIIIllIIIlIIlIlIlIII = lllllllllllllIIIllIIIlIIlIlIllII - lllllllllllllIIIllIIIlIIlIlIllIl.getFrontOffsetX() * lllllllllllllIIIllIIIlIIlIlIlIIl - 1;
            final int lllllllllllllIIIllIIIlIIlIlIIlll = lllllllllllllIIIllIIIlIIlIlIlIlI - lllllllllllllIIIllIIIlIIlIlIllIl.getFrontOffsetZ() * lllllllllllllIIIllIIIlIIlIlIlIIl - 1;
            final int lllllllllllllIIIllIIIlIIlIlIIllI = lllllllllllllIIIllIIIlIIlIlIlIII + 2;
            final int lllllllllllllIIIllIIIlIIlIlIIlIl = lllllllllllllIIIllIIIlIIlIlIIlll + 2;
            for (int lllllllllllllIIIllIIIlIIlIlIIlII = lllllllllllllIIIllIIIlIIlIlIlIII; lllllllllllllIIIllIIIlIIlIlIIlII <= lllllllllllllIIIllIIIlIIlIlIIllI; ++lllllllllllllIIIllIIIlIIlIlIIlII) {
                for (int lllllllllllllIIIllIIIlIIlIlIIIll = lllllllllllllIIIllIIIlIIlIlIIlll; lllllllllllllIIIllIIIlIIlIlIIIll <= lllllllllllllIIIllIIIlIIlIlIIlIl; ++lllllllllllllIIIllIIIlIIlIlIIIll) {
                    final BlockPos lllllllllllllIIIllIIIlIIlIlIIIlI = new BlockPos(lllllllllllllIIIllIIIlIIlIlIIlII, lllllllllllllIIIllIIIlIIlIlIlIll, lllllllllllllIIIllIIIlIIlIlIIIll);
                    if (hasRoomForPlayer(lllllllllllllIIIllIIIlIIlIllIIII, lllllllllllllIIIllIIIlIIlIlIIIlI)) {
                        if (lllllllllllllIIIllIIIlIIlIlIlllI <= 0) {
                            return lllllllllllllIIIllIIIlIIlIlIIIlI;
                        }
                        --lllllllllllllIIIllIIIlIIlIlIlllI;
                    }
                }
            }
        }
        return null;
    }
    
    @Override
    public void onBlockHarvested(final World lllllllllllllIIIllIIIlIIIlIllIll, final BlockPos lllllllllllllIIIllIIIlIIIlIlIlII, final IBlockState lllllllllllllIIIllIIIlIIIlIlIIll, final EntityPlayer lllllllllllllIIIllIIIlIIIlIlIIlI) {
        if (lllllllllllllIIIllIIIlIIIlIlIIlI.capabilities.isCreativeMode && lllllllllllllIIIllIIIlIIIlIlIIll.getValue(BlockBed.PART) == EnumPartType.FOOT) {
            final BlockPos lllllllllllllIIIllIIIlIIIlIlIlll = lllllllllllllIIIllIIIlIIIlIlIlII.offset(lllllllllllllIIIllIIIlIIIlIlIIll.getValue((IProperty<EnumFacing>)BlockBed.FACING));
            if (lllllllllllllIIIllIIIlIIIlIllIll.getBlockState(lllllllllllllIIIllIIIlIIIlIlIlll).getBlock() == this) {
                lllllllllllllIIIllIIIlIIIlIllIll.setBlockToAir(lllllllllllllIIIllIIIlIIIlIlIlll);
            }
        }
    }
    
    @Override
    public EnumPushReaction getMobilityFlag(final IBlockState lllllllllllllIIIllIIIlIIIllllIIl) {
        return EnumPushReaction.DESTROY;
    }
    
    @Override
    public boolean onBlockActivated(final World lllllllllllllIIIllIIIlIlIIIlIllI, BlockPos lllllllllllllIIIllIIIlIlIIIIlIII, IBlockState lllllllllllllIIIllIIIlIlIIIIIlll, final EntityPlayer lllllllllllllIIIllIIIlIlIIIIIllI, final EnumHand lllllllllllllIIIllIIIlIlIIIlIIlI, final EnumFacing lllllllllllllIIIllIIIlIlIIIlIIIl, final float lllllllllllllIIIllIIIlIlIIIlIIII, final float lllllllllllllIIIllIIIlIlIIIIllll, final float lllllllllllllIIIllIIIlIlIIIIlllI) {
        if (lllllllllllllIIIllIIIlIlIIIlIllI.isRemote) {
            return true;
        }
        if (lllllllllllllIIIllIIIlIlIIIIIlll.getValue(BlockBed.PART) != EnumPartType.HEAD) {
            lllllllllllllIIIllIIIlIlIIIIlIII = ((BlockPos)lllllllllllllIIIllIIIlIlIIIIlIII).offset(lllllllllllllIIIllIIIlIlIIIIIlll.getValue((IProperty<EnumFacing>)BlockBed.FACING));
            lllllllllllllIIIllIIIlIlIIIIIlll = lllllllllllllIIIllIIIlIlIIIlIllI.getBlockState((BlockPos)lllllllllllllIIIllIIIlIlIIIIlIII);
            if (lllllllllllllIIIllIIIlIlIIIIIlll.getBlock() != this) {
                return true;
            }
        }
        if (!lllllllllllllIIIllIIIlIlIIIlIllI.provider.canRespawnHere() || lllllllllllllIIIllIIIlIlIIIlIllI.getBiome((BlockPos)lllllllllllllIIIllIIIlIlIIIIlIII) == Biomes.HELL) {
            lllllllllllllIIIllIIIlIlIIIlIllI.setBlockToAir((BlockPos)lllllllllllllIIIllIIIlIlIIIIlIII);
            final BlockPos lllllllllllllIIIllIIIlIlIIIIlIll = ((BlockPos)lllllllllllllIIIllIIIlIlIIIIlIII).offset(lllllllllllllIIIllIIIlIlIIIIIlll.getValue((IProperty<EnumFacing>)BlockBed.FACING).getOpposite());
            if (lllllllllllllIIIllIIIlIlIIIlIllI.getBlockState(lllllllllllllIIIllIIIlIlIIIIlIll).getBlock() == this) {
                lllllllllllllIIIllIIIlIlIIIlIllI.setBlockToAir(lllllllllllllIIIllIIIlIlIIIIlIll);
            }
            lllllllllllllIIIllIIIlIlIIIlIllI.newExplosion(null, ((Vec3i)lllllllllllllIIIllIIIlIlIIIIlIII).getX() + 0.5, ((Vec3i)lllllllllllllIIIllIIIlIlIIIIlIII).getY() + 0.5, ((Vec3i)lllllllllllllIIIllIIIlIlIIIIlIII).getZ() + 0.5, 5.0f, true, true);
            return true;
        }
        if (lllllllllllllIIIllIIIlIlIIIIIlll.getValue((IProperty<Boolean>)BlockBed.OCCUPIED)) {
            final EntityPlayer lllllllllllllIIIllIIIlIlIIIIllIl = this.getPlayerInBed(lllllllllllllIIIllIIIlIlIIIlIllI, (BlockPos)lllllllllllllIIIllIIIlIlIIIIlIII);
            if (lllllllllllllIIIllIIIlIlIIIIllIl != null) {
                lllllllllllllIIIllIIIlIlIIIIIllI.addChatComponentMessage(new TextComponentTranslation("tile.bed.occupied", new Object[0]), true);
                return true;
            }
            lllllllllllllIIIllIIIlIlIIIIIlll = lllllllllllllIIIllIIIlIlIIIIIlll.withProperty((IProperty<Comparable>)BlockBed.OCCUPIED, false);
            lllllllllllllIIIllIIIlIlIIIlIllI.setBlockState((BlockPos)lllllllllllllIIIllIIIlIlIIIIlIII, lllllllllllllIIIllIIIlIlIIIIIlll, 4);
        }
        final EntityPlayer.SleepResult lllllllllllllIIIllIIIlIlIIIIllII = lllllllllllllIIIllIIIlIlIIIIIllI.trySleep((BlockPos)lllllllllllllIIIllIIIlIlIIIIlIII);
        if (lllllllllllllIIIllIIIlIlIIIIllII == EntityPlayer.SleepResult.OK) {
            lllllllllllllIIIllIIIlIlIIIIIlll = lllllllllllllIIIllIIIlIlIIIIIlll.withProperty((IProperty<Comparable>)BlockBed.OCCUPIED, true);
            lllllllllllllIIIllIIIlIlIIIlIllI.setBlockState((BlockPos)lllllllllllllIIIllIIIlIlIIIIlIII, lllllllllllllIIIllIIIlIlIIIIIlll, 4);
            return true;
        }
        if (lllllllllllllIIIllIIIlIlIIIIllII == EntityPlayer.SleepResult.NOT_POSSIBLE_NOW) {
            lllllllllllllIIIllIIIlIlIIIIIllI.addChatComponentMessage(new TextComponentTranslation("tile.bed.noSleep", new Object[0]), true);
        }
        else if (lllllllllllllIIIllIIIlIlIIIIllII == EntityPlayer.SleepResult.NOT_SAFE) {
            lllllllllllllIIIllIIIlIlIIIIIllI.addChatComponentMessage(new TextComponentTranslation("tile.bed.notSafe", new Object[0]), true);
        }
        else if (lllllllllllllIIIllIIIlIlIIIIllII == EntityPlayer.SleepResult.TOO_FAR_AWAY) {
            lllllllllllllIIIllIIIlIlIIIIIllI.addChatComponentMessage(new TextComponentTranslation("tile.bed.tooFarAway", new Object[0]), true);
        }
        return true;
    }
    
    public enum EnumPartType implements IStringSerializable
    {
        private final /* synthetic */ String name;
        
        FOOT("FOOT", 1, "foot"), 
        HEAD("HEAD", 0, "head");
        
        @Override
        public String getName() {
            return this.name;
        }
        
        private EnumPartType(final String lllllllllllIIIlllIIIIlIIIlIlIIll, final int lllllllllllIIIlllIIIIlIIIlIlIIlI, final String lllllllllllIIIlllIIIIlIIIlIlIIIl) {
            this.name = lllllllllllIIIlllIIIIlIIIlIlIIIl;
        }
        
        @Override
        public String toString() {
            return this.name;
        }
    }
}
