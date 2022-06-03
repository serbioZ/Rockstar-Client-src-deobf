// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import javax.annotation.Nullable;
import net.minecraft.item.Item;
import java.util.Random;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.pattern.BlockMaterialMatcher;
import net.minecraft.block.state.pattern.BlockStateMatcher;
import net.minecraft.block.state.pattern.FactoryBlockPattern;
import net.minecraft.util.Rotation;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.util.Mirror;
import net.minecraft.block.state.IBlockState;
import java.util.Iterator;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.entity.Entity;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.EnumFacing;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.init.Blocks;
import net.minecraft.block.properties.IProperty;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockWorldState;
import com.google.common.base.Predicate;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.block.state.pattern.BlockPattern;

public class BlockSkull extends BlockContainer
{
    private /* synthetic */ BlockPattern witherPattern;
    protected static final /* synthetic */ AxisAlignedBB SOUTH_AABB;
    private static final /* synthetic */ Predicate<BlockWorldState> IS_WITHER_SKELETON;
    protected static final /* synthetic */ AxisAlignedBB DEFAULT_AABB;
    protected static final /* synthetic */ AxisAlignedBB EAST_AABB;
    protected static final /* synthetic */ AxisAlignedBB NORTH_AABB;
    public static final /* synthetic */ PropertyBool NODROP;
    public static final /* synthetic */ PropertyDirection FACING;
    private /* synthetic */ BlockPattern witherBasePattern;
    protected static final /* synthetic */ AxisAlignedBB WEST_AABB;
    
    public void checkWitherSpawn(final World llllllllllllIIIlIIIIlIIIIIIIIIlI, final BlockPos llllllllllllIIIlIIIIIllllllIlllI, final TileEntitySkull llllllllllllIIIlIIIIIllllllIllIl) {
        if (llllllllllllIIIlIIIIIllllllIllIl.getSkullType() == 1 && llllllllllllIIIlIIIIIllllllIlllI.getY() >= 2 && llllllllllllIIIlIIIIlIIIIIIIIIlI.getDifficulty() != EnumDifficulty.PEACEFUL && !llllllllllllIIIlIIIIlIIIIIIIIIlI.isRemote) {
            final BlockPattern llllllllllllIIIlIIIIIlllllllllll = this.getWitherPattern();
            final BlockPattern.PatternHelper llllllllllllIIIlIIIIIllllllllllI = llllllllllllIIIlIIIIIlllllllllll.match(llllllllllllIIIlIIIIlIIIIIIIIIlI, llllllllllllIIIlIIIIIllllllIlllI);
            if (llllllllllllIIIlIIIIIllllllllllI != null) {
                for (int llllllllllllIIIlIIIIIlllllllllIl = 0; llllllllllllIIIlIIIIIlllllllllIl < 3; ++llllllllllllIIIlIIIIIlllllllllIl) {
                    final BlockWorldState llllllllllllIIIlIIIIIlllllllllII = llllllllllllIIIlIIIIIllllllllllI.translateOffset(llllllllllllIIIlIIIIIlllllllllIl, 0, 0);
                    llllllllllllIIIlIIIIlIIIIIIIIIlI.setBlockState(llllllllllllIIIlIIIIIlllllllllII.getPos(), llllllllllllIIIlIIIIIlllllllllII.getBlockState().withProperty((IProperty<Comparable>)BlockSkull.NODROP, true), 2);
                }
                for (int llllllllllllIIIlIIIIIllllllllIll = 0; llllllllllllIIIlIIIIIllllllllIll < llllllllllllIIIlIIIIIlllllllllll.getPalmLength(); ++llllllllllllIIIlIIIIIllllllllIll) {
                    for (int llllllllllllIIIlIIIIIllllllllIlI = 0; llllllllllllIIIlIIIIIllllllllIlI < llllllllllllIIIlIIIIIlllllllllll.getThumbLength(); ++llllllllllllIIIlIIIIIllllllllIlI) {
                        final BlockWorldState llllllllllllIIIlIIIIIllllllllIIl = llllllllllllIIIlIIIIIllllllllllI.translateOffset(llllllllllllIIIlIIIIIllllllllIll, llllllllllllIIIlIIIIIllllllllIlI, 0);
                        llllllllllllIIIlIIIIlIIIIIIIIIlI.setBlockState(llllllllllllIIIlIIIIIllllllllIIl.getPos(), Blocks.AIR.getDefaultState(), 2);
                    }
                }
                final BlockPos llllllllllllIIIlIIIIIllllllllIII = llllllllllllIIIlIIIIIllllllllllI.translateOffset(1, 0, 0).getPos();
                final EntityWither llllllllllllIIIlIIIIIlllllllIlll = new EntityWither(llllllllllllIIIlIIIIlIIIIIIIIIlI);
                final BlockPos llllllllllllIIIlIIIIIlllllllIllI = llllllllllllIIIlIIIIIllllllllllI.translateOffset(1, 2, 0).getPos();
                llllllllllllIIIlIIIIIlllllllIlll.setLocationAndAngles(llllllllllllIIIlIIIIIlllllllIllI.getX() + 0.5, llllllllllllIIIlIIIIIlllllllIllI.getY() + 0.55, llllllllllllIIIlIIIIIlllllllIllI.getZ() + 0.5, (llllllllllllIIIlIIIIIllllllllllI.getForwards().getAxis() == EnumFacing.Axis.X) ? 0.0f : 90.0f, 0.0f);
                llllllllllllIIIlIIIIIlllllllIlll.renderYawOffset = ((llllllllllllIIIlIIIIIllllllllllI.getForwards().getAxis() == EnumFacing.Axis.X) ? 0.0f : 90.0f);
                llllllllllllIIIlIIIIIlllllllIlll.ignite();
                for (final EntityPlayerMP llllllllllllIIIlIIIIIlllllllIlIl : llllllllllllIIIlIIIIlIIIIIIIIIlI.getEntitiesWithinAABB((Class<? extends EntityPlayerMP>)EntityPlayerMP.class, llllllllllllIIIlIIIIIlllllllIlll.getEntityBoundingBox().expandXyz(50.0))) {
                    CriteriaTriggers.field_192133_m.func_192229_a(llllllllllllIIIlIIIIIlllllllIlIl, llllllllllllIIIlIIIIIlllllllIlll);
                }
                llllllllllllIIIlIIIIlIIIIIIIIIlI.spawnEntityInWorld(llllllllllllIIIlIIIIIlllllllIlll);
                for (int llllllllllllIIIlIIIIIlllllllIlII = 0; llllllllllllIIIlIIIIIlllllllIlII < 120; ++llllllllllllIIIlIIIIIlllllllIlII) {
                    llllllllllllIIIlIIIIlIIIIIIIIIlI.spawnParticle(EnumParticleTypes.SNOWBALL, llllllllllllIIIlIIIIIllllllllIII.getX() + llllllllllllIIIlIIIIlIIIIIIIIIlI.rand.nextDouble(), llllllllllllIIIlIIIIIllllllllIII.getY() - 2 + llllllllllllIIIlIIIIlIIIIIIIIIlI.rand.nextDouble() * 3.9, llllllllllllIIIlIIIIIllllllllIII.getZ() + llllllllllllIIIlIIIIlIIIIIIIIIlI.rand.nextDouble(), 0.0, 0.0, 0.0, new int[0]);
                }
                for (int llllllllllllIIIlIIIIIlllllllIIll = 0; llllllllllllIIIlIIIIIlllllllIIll < llllllllllllIIIlIIIIIlllllllllll.getPalmLength(); ++llllllllllllIIIlIIIIIlllllllIIll) {
                    for (int llllllllllllIIIlIIIIIlllllllIIlI = 0; llllllllllllIIIlIIIIIlllllllIIlI < llllllllllllIIIlIIIIIlllllllllll.getThumbLength(); ++llllllllllllIIIlIIIIIlllllllIIlI) {
                        final BlockWorldState llllllllllllIIIlIIIIIlllllllIIIl = llllllllllllIIIlIIIIIllllllllllI.translateOffset(llllllllllllIIIlIIIIIlllllllIIll, llllllllllllIIIlIIIIIlllllllIIlI, 0);
                        llllllllllllIIIlIIIIlIIIIIIIIIlI.notifyNeighborsRespectDebug(llllllllllllIIIlIIIIIlllllllIIIl.getPos(), Blocks.AIR, false);
                    }
                }
            }
        }
    }
    
    @Override
    public IBlockState withMirror(final IBlockState llllllllllllIIIlIIIIIlllllIIlIll, final Mirror llllllllllllIIIlIIIIIlllllIIllII) {
        return llllllllllllIIIlIIIIIlllllIIlIll.withRotation(llllllllllllIIIlIIIIIlllllIIllII.toRotation(llllllllllllIIIlIIIIIlllllIIlIll.getValue((IProperty<EnumFacing>)BlockSkull.FACING)));
    }
    
    @Override
    public String getLocalizedName() {
        return I18n.translateToLocal("tile.skull.skeleton.name");
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = BlockSkull.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final short llllllllllllIIIlIIIIIllllIlllIlI = (Object)new int[EnumFacing.values().length];
        try {
            llllllllllllIIIlIIIIIllllIlllIlI[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllIIIlIIIIIllllIlllIlI[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllIIIlIIIIIllllIlllIlI[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllIIIlIIIIIllllIlllIlI[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            llllllllllllIIIlIIIIIllllIlllIlI[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            llllllllllllIIIlIIIIIllllIlllIlI[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return BlockSkull.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)llllllllllllIIIlIIIIIllllIlllIlI;
    }
    
    @Override
    public IBlockState onBlockPlaced(final World llllllllllllIIIlIIIIlIIIIllIIlll, final BlockPos llllllllllllIIIlIIIIlIIIIllIIllI, final EnumFacing llllllllllllIIIlIIIIlIIIIllIIlIl, final float llllllllllllIIIlIIIIlIIIIllIIlII, final float llllllllllllIIIlIIIIlIIIIllIIIll, final float llllllllllllIIIlIIIIlIIIIllIIIlI, final int llllllllllllIIIlIIIIlIIIIllIIIIl, final EntityLivingBase llllllllllllIIIlIIIIlIIIIlIllllI) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockSkull.FACING, llllllllllllIIIlIIIIlIIIIlIllllI.getHorizontalFacing()).withProperty((IProperty<Comparable>)BlockSkull.NODROP, false);
    }
    
    @Override
    public void dropBlockAsItemWithChance(final World llllllllllllIIIlIIIIlIIIIlIIlIll, final BlockPos llllllllllllIIIlIIIIlIIIIlIIlIlI, final IBlockState llllllllllllIIIlIIIIlIIIIlIIlIIl, final float llllllllllllIIIlIIIIlIIIIlIIlIII, final int llllllllllllIIIlIIIIlIIIIlIIIlll) {
    }
    
    @Override
    public boolean isFullCube(final IBlockState llllllllllllIIIlIIIIlIIIIlllIIll) {
        return false;
    }
    
    protected BlockSkull() {
        super(Material.CIRCUITS);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockSkull.FACING, EnumFacing.NORTH).withProperty((IProperty<Comparable>)BlockSkull.NODROP, false));
    }
    
    @Override
    public void onBlockHarvested(final World llllllllllllIIIlIIIIlIIIIIlllIll, final BlockPos llllllllllllIIIlIIIIlIIIIIllllll, IBlockState llllllllllllIIIlIIIIlIIIIIlllIIl, final EntityPlayer llllllllllllIIIlIIIIlIIIIIllllIl) {
        if (llllllllllllIIIlIIIIlIIIIIllllIl.capabilities.isCreativeMode) {
            llllllllllllIIIlIIIIlIIIIIlllIIl = llllllllllllIIIlIIIIlIIIIIlllIIl.withProperty((IProperty<Comparable>)BlockSkull.NODROP, true);
            llllllllllllIIIlIIIIlIIIIIlllIll.setBlockState(llllllllllllIIIlIIIIlIIIIIllllll, llllllllllllIIIlIIIIlIIIIIlllIIl, 4);
        }
        super.onBlockHarvested(llllllllllllIIIlIIIIlIIIIIlllIll, llllllllllllIIIlIIIIlIIIIIllllll, llllllllllllIIIlIIIIlIIIIIlllIIl, llllllllllllIIIlIIIIlIIIIIllllIl);
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState llllllllllllIIIlIIIIlIIIIllIlIll, final IBlockAccess llllllllllllIIIlIIIIlIIIIllIllIl, final BlockPos llllllllllllIIIlIIIIlIIIIllIllII) {
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[llllllllllllIIIlIIIIlIIIIllIlIll.getValue((IProperty<EnumFacing>)BlockSkull.FACING).ordinal()]) {
            default: {
                return BlockSkull.DEFAULT_AABB;
            }
            case 3: {
                return BlockSkull.NORTH_AABB;
            }
            case 4: {
                return BlockSkull.SOUTH_AABB;
            }
            case 5: {
                return BlockSkull.WEST_AABB;
            }
            case 6: {
                return BlockSkull.EAST_AABB;
            }
        }
    }
    
    @Override
    public ItemStack getItem(final World llllllllllllIIIlIIIIlIIIIlIlIIII, final BlockPos llllllllllllIIIlIIIIlIIIIlIIllll, final IBlockState llllllllllllIIIlIIIIlIIIIlIlIIll) {
        int llllllllllllIIIlIIIIlIIIIlIlIIlI = 0;
        final TileEntity llllllllllllIIIlIIIIlIIIIlIlIIIl = llllllllllllIIIlIIIIlIIIIlIlIIII.getTileEntity(llllllllllllIIIlIIIIlIIIIlIIllll);
        if (llllllllllllIIIlIIIIlIIIIlIlIIIl instanceof TileEntitySkull) {
            llllllllllllIIIlIIIIlIIIIlIlIIlI = ((TileEntitySkull)llllllllllllIIIlIIIIlIIIIlIlIIIl).getSkullType();
        }
        return new ItemStack(Items.SKULL, 1, llllllllllllIIIlIIIIlIIIIlIlIIlI);
    }
    
    @Override
    public IBlockState withRotation(final IBlockState llllllllllllIIIlIIIIIlllllIlIIlI, final Rotation llllllllllllIIIlIIIIIlllllIlIIll) {
        return llllllllllllIIIlIIIIIlllllIlIIlI.withProperty((IProperty<Comparable>)BlockSkull.FACING, llllllllllllIIIlIIIIIlllllIlIIll.rotate(llllllllllllIIIlIIIIIlllllIlIIlI.getValue((IProperty<EnumFacing>)BlockSkull.FACING)));
    }
    
    public boolean canDispenserPlace(final World llllllllllllIIIlIIIIlIIIIIIlIllI, final BlockPos llllllllllllIIIlIIIIlIIIIIIlIIIl, final ItemStack llllllllllllIIIlIIIIlIIIIIIlIIII) {
        return llllllllllllIIIlIIIIlIIIIIIlIIII.getMetadata() == 1 && llllllllllllIIIlIIIIlIIIIIIlIIIl.getY() >= 2 && llllllllllllIIIlIIIIlIIIIIIlIllI.getDifficulty() != EnumDifficulty.PEACEFUL && !llllllllllllIIIlIIIIlIIIIIIlIllI.isRemote && this.getWitherBasePattern().match(llllllllllllIIIlIIIIlIIIIIIlIllI, llllllllllllIIIlIIIIlIIIIIIlIIIl) != null;
    }
    
    @Override
    public TileEntity createNewTileEntity(final World llllllllllllIIIlIIIIlIIIIlIlllII, final int llllllllllllIIIlIIIIlIIIIlIllIll) {
        return new TileEntitySkull();
    }
    
    protected BlockPattern getWitherPattern() {
        if (this.witherPattern == null) {
            this.witherPattern = FactoryBlockPattern.start().aisle("^^^", "###", "~#~").where('#', BlockWorldState.hasState((Predicate<IBlockState>)BlockStateMatcher.forBlock(Blocks.SOUL_SAND))).where('^', BlockSkull.IS_WITHER_SKELETON).where('~', BlockWorldState.hasState((Predicate<IBlockState>)BlockMaterialMatcher.forMaterial(Material.AIR))).build();
        }
        return this.witherPattern;
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllIIIlIIIIIlllllIllIIl) {
        int llllllllllllIIIlIIIIIlllllIllIlI = 0;
        llllllllllllIIIlIIIIIlllllIllIlI |= llllllllllllIIIlIIIIIlllllIllIIl.getValue((IProperty<EnumFacing>)BlockSkull.FACING).getIndex();
        if (llllllllllllIIIlIIIIIlllllIllIIl.getValue((IProperty<Boolean>)BlockSkull.NODROP)) {
            llllllllllllIIIlIIIIIlllllIllIlI |= 0x8;
        }
        return llllllllllllIIIlIIIIIlllllIllIlI;
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess llllllllllllIIIlIIIIIllllIllllll, final IBlockState llllllllllllIIIlIIIIIllllIlllllI, final BlockPos llllllllllllIIIlIIIIIllllIllllIl, final EnumFacing llllllllllllIIIlIIIIIllllIllllII) {
        return BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public boolean func_190946_v(final IBlockState llllllllllllIIIlIIIIlIIIIlllIIIl) {
        return true;
    }
    
    @Override
    public void breakBlock(final World llllllllllllIIIlIIIIlIIIIIlIIllI, final BlockPos llllllllllllIIIlIIIIlIIIIIlIllIl, final IBlockState llllllllllllIIIlIIIIlIIIIIlIllII) {
        if (!llllllllllllIIIlIIIIlIIIIIlIIllI.isRemote) {
            if (!llllllllllllIIIlIIIIlIIIIIlIllII.getValue((IProperty<Boolean>)BlockSkull.NODROP)) {
                final TileEntity llllllllllllIIIlIIIIlIIIIIlIlIll = llllllllllllIIIlIIIIlIIIIIlIIllI.getTileEntity(llllllllllllIIIlIIIIlIIIIIlIllIl);
                if (llllllllllllIIIlIIIIlIIIIIlIlIll instanceof TileEntitySkull) {
                    final TileEntitySkull llllllllllllIIIlIIIIlIIIIIlIlIlI = (TileEntitySkull)llllllllllllIIIlIIIIlIIIIIlIlIll;
                    final ItemStack llllllllllllIIIlIIIIlIIIIIlIlIIl = this.getItem(llllllllllllIIIlIIIIlIIIIIlIIllI, llllllllllllIIIlIIIIlIIIIIlIllIl, llllllllllllIIIlIIIIlIIIIIlIllII);
                    if (llllllllllllIIIlIIIIlIIIIIlIlIlI.getSkullType() == 3 && llllllllllllIIIlIIIIlIIIIIlIlIlI.getPlayerProfile() != null) {
                        llllllllllllIIIlIIIIlIIIIIlIlIIl.setTagCompound(new NBTTagCompound());
                        final NBTTagCompound llllllllllllIIIlIIIIlIIIIIlIlIII = new NBTTagCompound();
                        NBTUtil.writeGameProfile(llllllllllllIIIlIIIIlIIIIIlIlIII, llllllllllllIIIlIIIIlIIIIIlIlIlI.getPlayerProfile());
                        llllllllllllIIIlIIIIlIIIIIlIlIIl.getTagCompound().setTag("SkullOwner", llllllllllllIIIlIIIIlIIIIIlIlIII);
                    }
                    Block.spawnAsEntity(llllllllllllIIIlIIIIlIIIIIlIIllI, llllllllllllIIIlIIIIlIIIIIlIllIl, llllllllllllIIIlIIIIlIIIIIlIlIIl);
                }
            }
            super.breakBlock(llllllllllllIIIlIIIIlIIIIIlIIllI, llllllllllllIIIlIIIIlIIIIIlIllIl, llllllllllllIIIlIIIIlIIIIIlIllII);
        }
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockSkull.FACING, BlockSkull.NODROP });
    }
    
    protected BlockPattern getWitherBasePattern() {
        if (this.witherBasePattern == null) {
            this.witherBasePattern = FactoryBlockPattern.start().aisle("   ", "###", "~#~").where('#', BlockWorldState.hasState((Predicate<IBlockState>)BlockStateMatcher.forBlock(Blocks.SOUL_SAND))).where('~', BlockWorldState.hasState((Predicate<IBlockState>)BlockMaterialMatcher.forMaterial(Material.AIR))).build();
        }
        return this.witherBasePattern;
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllIIIlIIIIlIIIIIIllllI, final Random llllllllllllIIIlIIIIlIIIIIIlllIl, final int llllllllllllIIIlIIIIlIIIIIIlllII) {
        return Items.SKULL;
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState llllllllllllIIIlIIIIlIIIIlllIlIl) {
        return false;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllIIIlIIIIIlllllIlllll) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockSkull.FACING, EnumFacing.getFront(llllllllllllIIIlIIIIIlllllIlllll & 0x7)).withProperty((IProperty<Comparable>)BlockSkull.NODROP, (llllllllllllIIIlIIIIIlllllIlllll & 0x8) > 0);
    }
    
    static {
        FACING = BlockDirectional.FACING;
        NODROP = PropertyBool.create("nodrop");
        IS_WITHER_SKELETON = (Predicate)new Predicate<BlockWorldState>() {
            public boolean apply(@Nullable final BlockWorldState lllllllllllllIIllllIllIlllllIIIl) {
                return lllllllllllllIIllllIllIlllllIIIl.getBlockState() != null && lllllllllllllIIllllIllIlllllIIIl.getBlockState().getBlock() == Blocks.SKULL && lllllllllllllIIllllIllIlllllIIIl.getTileEntity() instanceof TileEntitySkull && ((TileEntitySkull)lllllllllllllIIllllIllIlllllIIIl.getTileEntity()).getSkullType() == 1;
            }
        };
        DEFAULT_AABB = new AxisAlignedBB(0.25, 0.0, 0.25, 0.75, 0.5, 0.75);
        NORTH_AABB = new AxisAlignedBB(0.25, 0.25, 0.5, 0.75, 0.75, 1.0);
        SOUTH_AABB = new AxisAlignedBB(0.25, 0.25, 0.0, 0.75, 0.75, 0.5);
        WEST_AABB = new AxisAlignedBB(0.5, 0.25, 0.25, 1.0, 0.75, 0.75);
        EAST_AABB = new AxisAlignedBB(0.0, 0.25, 0.25, 0.5, 0.75, 0.75);
    }
}
