// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.IStringSerializable;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.util.Rotation;
import net.minecraft.block.state.BlockStateContainer;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.entity.Entity;
import com.google.common.base.Predicate;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.item.Item;
import net.minecraft.init.Blocks;
import net.minecraft.util.Mirror;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntityComparator;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.player.EntityPlayer;
import java.util.Random;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyBool;

public class BlockRedstoneComparator extends BlockRedstoneDiode implements ITileEntityProvider
{
    public static final /* synthetic */ PropertyBool POWERED;
    public static final /* synthetic */ PropertyEnum<Mode> MODE;
    
    @Override
    public IBlockState onBlockPlaced(final World llllllllllllIIlIIlllllIlllllllIl, final BlockPos llllllllllllIIlIIlllllIlllllllII, final EnumFacing llllllllllllIIlIIlllllIllllllIll, final float llllllllllllIIlIIlllllIllllllIlI, final float llllllllllllIIlIIlllllIllllllIIl, final float llllllllllllIIlIIlllllIllllllIII, final int llllllllllllIIlIIlllllIlllllIlll, final EntityLivingBase llllllllllllIIlIIlllllIlllllIllI) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockRedstoneComparator.FACING, llllllllllllIIlIIlllllIlllllIllI.getHorizontalFacing().getOpposite()).withProperty((IProperty<Comparable>)BlockRedstoneComparator.POWERED, false).withProperty(BlockRedstoneComparator.MODE, Mode.COMPARE);
    }
    
    @Override
    public ItemStack getItem(final World llllllllllllIIlIIlllllllIIIllIll, final BlockPos llllllllllllIIlIIlllllllIIIllIlI, final IBlockState llllllllllllIIlIIlllllllIIIllIIl) {
        return new ItemStack(Items.COMPARATOR);
    }
    
    @Override
    public void updateTick(final World llllllllllllIIlIIllllllIIlIlIllI, final BlockPos llllllllllllIIlIIllllllIIlIlIlIl, final IBlockState llllllllllllIIlIIllllllIIlIIllll, final Random llllllllllllIIlIIllllllIIlIlIIll) {
        if (this.isRepeaterPowered) {
            llllllllllllIIlIIllllllIIlIlIllI.setBlockState(llllllllllllIIlIIllllllIIlIlIlIl, this.getUnpoweredState(llllllllllllIIlIIllllllIIlIIllll).withProperty((IProperty<Comparable>)BlockRedstoneComparator.POWERED, true), 4);
        }
        this.onStateChange(llllllllllllIIlIIllllllIIlIlIllI, llllllllllllIIlIIllllllIIlIlIlIl, llllllllllllIIlIIllllllIIlIIllll);
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllIIlIIllllllIIIIlIlIl) {
        int llllllllllllIIlIIllllllIIIIlIlII = 0;
        llllllllllllIIlIIllllllIIIIlIlII |= llllllllllllIIlIIllllllIIIIlIlIl.getValue((IProperty<EnumFacing>)BlockRedstoneComparator.FACING).getHorizontalIndex();
        if (llllllllllllIIlIIllllllIIIIlIlIl.getValue((IProperty<Boolean>)BlockRedstoneComparator.POWERED)) {
            llllllllllllIIlIIllllllIIIIlIlII |= 0x8;
        }
        if (llllllllllllIIlIIllllllIIIIlIlIl.getValue(BlockRedstoneComparator.MODE) == Mode.SUBTRACT) {
            llllllllllllIIlIIllllllIIIIlIlII |= 0x4;
        }
        return llllllllllllIIlIIllllllIIIIlIlII;
    }
    
    public BlockRedstoneComparator(final boolean llllllllllllIIlIIlllllllIIlIIIlI) {
        super(llllllllllllIIlIIlllllllIIlIIIlI);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockRedstoneComparator.FACING, EnumFacing.NORTH).withProperty((IProperty<Comparable>)BlockRedstoneComparator.POWERED, false).withProperty(BlockRedstoneComparator.MODE, Mode.COMPARE));
        this.isBlockContainer = true;
    }
    
    @Override
    public boolean onBlockActivated(final World llllllllllllIIlIIllllllIlIIlIIIl, final BlockPos llllllllllllIIlIIllllllIlIIllIll, IBlockState llllllllllllIIlIIllllllIlIIIllll, final EntityPlayer llllllllllllIIlIIllllllIlIIIlllI, final EnumHand llllllllllllIIlIIllllllIlIIllIII, final EnumFacing llllllllllllIIlIIllllllIlIIlIlll, final float llllllllllllIIlIIllllllIlIIlIllI, final float llllllllllllIIlIIllllllIlIIlIlIl, final float llllllllllllIIlIIllllllIlIIlIlII) {
        if (!llllllllllllIIlIIllllllIlIIIlllI.capabilities.allowEdit) {
            return false;
        }
        llllllllllllIIlIIllllllIlIIIllll = llllllllllllIIlIIllllllIlIIIllll.cycleProperty(BlockRedstoneComparator.MODE);
        final float llllllllllllIIlIIllllllIlIIlIIll = (llllllllllllIIlIIllllllIlIIIllll.getValue(BlockRedstoneComparator.MODE) == Mode.SUBTRACT) ? 0.55f : 0.5f;
        llllllllllllIIlIIllllllIlIIlIIIl.playSound(llllllllllllIIlIIllllllIlIIIlllI, llllllllllllIIlIIllllllIlIIllIll, SoundEvents.BLOCK_COMPARATOR_CLICK, SoundCategory.BLOCKS, 0.3f, llllllllllllIIlIIllllllIlIIlIIll);
        llllllllllllIIlIIllllllIlIIlIIIl.setBlockState(llllllllllllIIlIIllllllIlIIllIll, llllllllllllIIlIIllllllIlIIIllll, 2);
        this.onStateChange(llllllllllllIIlIIllllllIlIIlIIIl, llllllllllllIIlIIllllllIlIIllIll, llllllllllllIIlIIllllllIlIIIllll);
        return true;
    }
    
    @Override
    public void onBlockAdded(final World llllllllllllIIlIIllllllIIlIIlIIl, final BlockPos llllllllllllIIlIIllllllIIlIIlIII, final IBlockState llllllllllllIIlIIllllllIIlIIIlll) {
        super.onBlockAdded(llllllllllllIIlIIllllllIIlIIlIIl, llllllllllllIIlIIllllllIIlIIlIII, llllllllllllIIlIIllllllIIlIIIlll);
        llllllllllllIIlIIllllllIIlIIlIIl.setTileEntity(llllllllllllIIlIIllllllIIlIIlIII, this.createNewTileEntity(llllllllllllIIlIIllllllIIlIIlIIl, 0));
    }
    
    static {
        POWERED = PropertyBool.create("powered");
        MODE = PropertyEnum.create("mode", Mode.class);
    }
    
    @Override
    public TileEntity createNewTileEntity(final World llllllllllllIIlIIllllllIIIlIIIII, final int llllllllllllIIlIIllllllIIIIlllll) {
        return new TileEntityComparator();
    }
    
    @Override
    protected int calculateInputStrength(final World llllllllllllIIlIIllllllIllIIIIll, final BlockPos llllllllllllIIlIIllllllIllIIIIlI, final IBlockState llllllllllllIIlIIllllllIlIlllIII) {
        int llllllllllllIIlIIllllllIllIIIIII = super.calculateInputStrength(llllllllllllIIlIIllllllIllIIIIll, llllllllllllIIlIIllllllIllIIIIlI, llllllllllllIIlIIllllllIlIlllIII);
        final EnumFacing llllllllllllIIlIIllllllIlIllllll = llllllllllllIIlIIllllllIlIlllIII.getValue((IProperty<EnumFacing>)BlockRedstoneComparator.FACING);
        BlockPos llllllllllllIIlIIllllllIlIlllllI = llllllllllllIIlIIllllllIllIIIIlI.offset(llllllllllllIIlIIllllllIlIllllll);
        IBlockState llllllllllllIIlIIllllllIlIllllIl = llllllllllllIIlIIllllllIllIIIIll.getBlockState(llllllllllllIIlIIllllllIlIlllllI);
        if (llllllllllllIIlIIllllllIlIllllIl.hasComparatorInputOverride()) {
            llllllllllllIIlIIllllllIllIIIIII = llllllllllllIIlIIllllllIlIllllIl.getComparatorInputOverride(llllllllllllIIlIIllllllIllIIIIll, llllllllllllIIlIIllllllIlIlllllI);
        }
        else if (llllllllllllIIlIIllllllIllIIIIII < 15 && llllllllllllIIlIIllllllIlIllllIl.isNormalCube()) {
            llllllllllllIIlIIllllllIlIlllllI = llllllllllllIIlIIllllllIlIlllllI.offset(llllllllllllIIlIIllllllIlIllllll);
            llllllllllllIIlIIllllllIlIllllIl = llllllllllllIIlIIllllllIllIIIIll.getBlockState(llllllllllllIIlIIllllllIlIlllllI);
            if (llllllllllllIIlIIllllllIlIllllIl.hasComparatorInputOverride()) {
                llllllllllllIIlIIllllllIllIIIIII = llllllllllllIIlIIllllllIlIllllIl.getComparatorInputOverride(llllllllllllIIlIIllllllIllIIIIll, llllllllllllIIlIIllllllIlIlllllI);
            }
            else if (llllllllllllIIlIIllllllIlIllllIl.getMaterial() == Material.AIR) {
                final EntityItemFrame llllllllllllIIlIIllllllIlIllllII = this.findItemFrame(llllllllllllIIlIIllllllIllIIIIll, llllllllllllIIlIIllllllIlIllllll, llllllllllllIIlIIllllllIlIlllllI);
                if (llllllllllllIIlIIllllllIlIllllII != null) {
                    llllllllllllIIlIIllllllIllIIIIII = llllllllllllIIlIIllllllIlIllllII.getAnalogOutput();
                }
            }
        }
        return llllllllllllIIlIIllllllIllIIIIII;
    }
    
    @Override
    public IBlockState withMirror(final IBlockState llllllllllllIIlIIllllllIIIIIIlIl, final Mirror llllllllllllIIlIIllllllIIIIIIlII) {
        return llllllllllllIIlIIllllllIIIIIIlIl.withRotation(llllllllllllIIlIIllllllIIIIIIlII.toRotation(llllllllllllIIlIIllllllIIIIIIlIl.getValue((IProperty<EnumFacing>)BlockRedstoneComparator.FACING)));
    }
    
    @Override
    protected IBlockState getPoweredState(final IBlockState llllllllllllIIlIIlllllllIIIIllIl) {
        final Boolean llllllllllllIIlIIlllllllIIIlIIII = llllllllllllIIlIIlllllllIIIIllIl.getValue((IProperty<Boolean>)BlockRedstoneComparator.POWERED);
        final Mode llllllllllllIIlIIlllllllIIIIllll = llllllllllllIIlIIlllllllIIIIllIl.getValue(BlockRedstoneComparator.MODE);
        final EnumFacing llllllllllllIIlIIlllllllIIIIlllI = llllllllllllIIlIIlllllllIIIIllIl.getValue((IProperty<EnumFacing>)BlockRedstoneComparator.FACING);
        return Blocks.POWERED_COMPARATOR.getDefaultState().withProperty((IProperty<Comparable>)BlockRedstoneComparator.FACING, llllllllllllIIlIIlllllllIIIIlllI).withProperty((IProperty<Comparable>)BlockRedstoneComparator.POWERED, llllllllllllIIlIIlllllllIIIlIIII).withProperty(BlockRedstoneComparator.MODE, llllllllllllIIlIIlllllllIIIIllll);
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllIIlIIlllllllIIIlllll, final Random llllllllllllIIlIIlllllllIIIllllI, final int llllllllllllIIlIIlllllllIIIlllIl) {
        return Items.COMPARATOR;
    }
    
    @Override
    protected boolean isPowered(final IBlockState llllllllllllIIlIIllllllIllllIlll) {
        return this.isRepeaterPowered || llllllllllllIIlIIllllllIllllIlll.getValue((IProperty<Boolean>)BlockRedstoneComparator.POWERED);
    }
    
    @Override
    protected IBlockState getUnpoweredState(final IBlockState llllllllllllIIlIIlllllllIIIIIlII) {
        final Boolean llllllllllllIIlIIlllllllIIIIIIll = llllllllllllIIlIIlllllllIIIIIlII.getValue((IProperty<Boolean>)BlockRedstoneComparator.POWERED);
        final Mode llllllllllllIIlIIlllllllIIIIIIlI = llllllllllllIIlIIlllllllIIIIIlII.getValue(BlockRedstoneComparator.MODE);
        final EnumFacing llllllllllllIIlIIlllllllIIIIIIIl = llllllllllllIIlIIlllllllIIIIIlII.getValue((IProperty<EnumFacing>)BlockRedstoneComparator.FACING);
        return Blocks.UNPOWERED_COMPARATOR.getDefaultState().withProperty((IProperty<Comparable>)BlockRedstoneComparator.FACING, llllllllllllIIlIIlllllllIIIIIIIl).withProperty((IProperty<Comparable>)BlockRedstoneComparator.POWERED, llllllllllllIIlIIlllllllIIIIIIll).withProperty(BlockRedstoneComparator.MODE, llllllllllllIIlIIlllllllIIIIIIlI);
    }
    
    private void onStateChange(final World llllllllllllIIlIIllllllIIllIIIll, final BlockPos llllllllllllIIlIIllllllIIllIllII, final IBlockState llllllllllllIIlIIllllllIIllIIIIl) {
        final int llllllllllllIIlIIllllllIIllIlIlI = this.calculateOutput(llllllllllllIIlIIllllllIIllIIIll, llllllllllllIIlIIllllllIIllIllII, llllllllllllIIlIIllllllIIllIIIIl);
        final TileEntity llllllllllllIIlIIllllllIIllIlIIl = llllllllllllIIlIIllllllIIllIIIll.getTileEntity(llllllllllllIIlIIllllllIIllIllII);
        int llllllllllllIIlIIllllllIIllIlIII = 0;
        if (llllllllllllIIlIIllllllIIllIlIIl instanceof TileEntityComparator) {
            final TileEntityComparator llllllllllllIIlIIllllllIIllIIlll = (TileEntityComparator)llllllllllllIIlIIllllllIIllIlIIl;
            llllllllllllIIlIIllllllIIllIlIII = llllllllllllIIlIIllllllIIllIIlll.getOutputSignal();
            llllllllllllIIlIIllllllIIllIIlll.setOutputSignal(llllllllllllIIlIIllllllIIllIlIlI);
        }
        if (llllllllllllIIlIIllllllIIllIlIII != llllllllllllIIlIIllllllIIllIlIlI || llllllllllllIIlIIllllllIIllIIIIl.getValue(BlockRedstoneComparator.MODE) == Mode.COMPARE) {
            final boolean llllllllllllIIlIIllllllIIllIIllI = this.shouldBePowered(llllllllllllIIlIIllllllIIllIIIll, llllllllllllIIlIIllllllIIllIllII, llllllllllllIIlIIllllllIIllIIIIl);
            final boolean llllllllllllIIlIIllllllIIllIIlIl = this.isPowered(llllllllllllIIlIIllllllIIllIIIIl);
            if (llllllllllllIIlIIllllllIIllIIlIl && !llllllllllllIIlIIllllllIIllIIllI) {
                llllllllllllIIlIIllllllIIllIIIll.setBlockState(llllllllllllIIlIIllllllIIllIllII, llllllllllllIIlIIllllllIIllIIIIl.withProperty((IProperty<Comparable>)BlockRedstoneComparator.POWERED, false), 2);
            }
            else if (!llllllllllllIIlIIllllllIIllIIlIl && llllllllllllIIlIIllllllIIllIIllI) {
                llllllllllllIIlIIllllllIIllIIIll.setBlockState(llllllllllllIIlIIllllllIIllIllII, llllllllllllIIlIIllllllIIllIIIIl.withProperty((IProperty<Comparable>)BlockRedstoneComparator.POWERED, true), 2);
            }
            this.notifyNeighbors(llllllllllllIIlIIllllllIIllIIIll, llllllllllllIIlIIllllllIIllIllII, llllllllllllIIlIIllllllIIllIIIIl);
        }
    }
    
    @Override
    public boolean eventReceived(final IBlockState llllllllllllIIlIIllllllIIIlIlllI, final World llllllllllllIIlIIllllllIIIlIIllI, final BlockPos llllllllllllIIlIIllllllIIIlIIlIl, final int llllllllllllIIlIIllllllIIIlIIlII, final int llllllllllllIIlIIllllllIIIlIIIll) {
        super.eventReceived(llllllllllllIIlIIllllllIIIlIlllI, llllllllllllIIlIIllllllIIIlIIllI, llllllllllllIIlIIllllllIIIlIIlIl, llllllllllllIIlIIllllllIIIlIIlII, llllllllllllIIlIIllllllIIIlIIIll);
        final TileEntity llllllllllllIIlIIllllllIIIlIlIIl = llllllllllllIIlIIllllllIIIlIIllI.getTileEntity(llllllllllllIIlIIllllllIIIlIIlIl);
        return llllllllllllIIlIIllllllIIIlIlIIl != null && llllllllllllIIlIIllllllIIIlIlIIl.receiveClientEvent(llllllllllllIIlIIllllllIIIlIIlII, llllllllllllIIlIIllllllIIIlIIIll);
    }
    
    @Override
    protected int getActiveSignal(final IBlockAccess llllllllllllIIlIIllllllIlllIlllI, final BlockPos llllllllllllIIlIIllllllIlllIllIl, final IBlockState llllllllllllIIlIIllllllIllllIIII) {
        final TileEntity llllllllllllIIlIIllllllIlllIllll = llllllllllllIIlIIllllllIlllIlllI.getTileEntity(llllllllllllIIlIIllllllIlllIllIl);
        return (llllllllllllIIlIIllllllIlllIllll instanceof TileEntityComparator) ? ((TileEntityComparator)llllllllllllIIlIIllllllIlllIllll).getOutputSignal() : 0;
    }
    
    @Nullable
    private EntityItemFrame findItemFrame(final World llllllllllllIIlIIllllllIlIlIllII, final EnumFacing llllllllllllIIlIIllllllIlIlIlIll, final BlockPos llllllllllllIIlIIllllllIlIlIIlIl) {
        final List<EntityItemFrame> llllllllllllIIlIIllllllIlIlIlIIl = llllllllllllIIlIIllllllIlIlIllII.getEntitiesWithinAABB((Class<? extends EntityItemFrame>)EntityItemFrame.class, new AxisAlignedBB(llllllllllllIIlIIllllllIlIlIIlIl.getX(), llllllllllllIIlIIllllllIlIlIIlIl.getY(), llllllllllllIIlIIllllllIlIlIIlIl.getZ(), llllllllllllIIlIIllllllIlIlIIlIl.getX() + 1, llllllllllllIIlIIllllllIlIlIIlIl.getY() + 1, llllllllllllIIlIIllllllIlIlIIlIl.getZ() + 1), (com.google.common.base.Predicate<? super EntityItemFrame>)new Predicate<Entity>() {
            public boolean apply(@Nullable final Entity llllllllllIlllIlIlllIlIlIllIlIIl) {
                return llllllllllIlllIlIlllIlIlIllIlIIl != null && llllllllllIlllIlIlllIlIlIllIlIIl.getHorizontalFacing() == llllllllllllIIlIIllllllIlIlIlIll;
            }
        });
        return (llllllllllllIIlIIllllllIlIlIlIIl.size() == 1) ? llllllllllllIIlIIllllllIlIlIlIIl.get(0) : null;
    }
    
    @Override
    protected boolean shouldBePowered(final World llllllllllllIIlIIllllllIllIllIII, final BlockPos llllllllllllIIlIIllllllIllIlIlll, final IBlockState llllllllllllIIlIIllllllIllIlIIII) {
        final int llllllllllllIIlIIllllllIllIlIlIl = this.calculateInputStrength(llllllllllllIIlIIllllllIllIllIII, llllllllllllIIlIIllllllIllIlIlll, llllllllllllIIlIIllllllIllIlIIII);
        if (llllllllllllIIlIIllllllIllIlIlIl >= 15) {
            return true;
        }
        if (llllllllllllIIlIIllllllIllIlIlIl == 0) {
            return false;
        }
        final int llllllllllllIIlIIllllllIllIlIlII = this.getPowerOnSides(llllllllllllIIlIIllllllIllIllIII, llllllllllllIIlIIllllllIllIlIlll, llllllllllllIIlIIllllllIllIlIIII);
        return llllllllllllIIlIIllllllIllIlIlII == 0 || llllllllllllIIlIIllllllIllIlIlIl >= llllllllllllIIlIIllllllIllIlIlII;
    }
    
    @Override
    protected void updateState(final World llllllllllllIIlIIllllllIlIIIIlII, final BlockPos llllllllllllIIlIIllllllIlIIIIIll, final IBlockState llllllllllllIIlIIllllllIlIIIIIlI) {
        if (!llllllllllllIIlIIllllllIlIIIIlII.isBlockTickPending(llllllllllllIIlIIllllllIlIIIIIll, this)) {
            final int llllllllllllIIlIIllllllIlIIIIIIl = this.calculateOutput(llllllllllllIIlIIllllllIlIIIIlII, llllllllllllIIlIIllllllIlIIIIIll, llllllllllllIIlIIllllllIlIIIIIlI);
            final TileEntity llllllllllllIIlIIllllllIlIIIIIII = llllllllllllIIlIIllllllIlIIIIlII.getTileEntity(llllllllllllIIlIIllllllIlIIIIIll);
            final int llllllllllllIIlIIllllllIIlllllll = (llllllllllllIIlIIllllllIlIIIIIII instanceof TileEntityComparator) ? ((TileEntityComparator)llllllllllllIIlIIllllllIlIIIIIII).getOutputSignal() : 0;
            if (llllllllllllIIlIIllllllIlIIIIIIl != llllllllllllIIlIIllllllIIlllllll || this.isPowered(llllllllllllIIlIIllllllIlIIIIIlI) != this.shouldBePowered(llllllllllllIIlIIllllllIlIIIIlII, llllllllllllIIlIIllllllIlIIIIIll, llllllllllllIIlIIllllllIlIIIIIlI)) {
                if (this.isFacingTowardsRepeater(llllllllllllIIlIIllllllIlIIIIlII, llllllllllllIIlIIllllllIlIIIIIll, llllllllllllIIlIIllllllIlIIIIIlI)) {
                    llllllllllllIIlIIllllllIlIIIIlII.updateBlockTick(llllllllllllIIlIIllllllIlIIIIIll, this, 2, -1);
                }
                else {
                    llllllllllllIIlIIllllllIlIIIIlII.updateBlockTick(llllllllllllIIlIIllllllIlIIIIIll, this, 2, 0);
                }
            }
        }
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockRedstoneComparator.FACING, BlockRedstoneComparator.MODE, BlockRedstoneComparator.POWERED });
    }
    
    @Override
    public IBlockState withRotation(final IBlockState llllllllllllIIlIIllllllIIIIIlllI, final Rotation llllllllllllIIlIIllllllIIIIIllIl) {
        return llllllllllllIIlIIllllllIIIIIlllI.withProperty((IProperty<Comparable>)BlockRedstoneComparator.FACING, llllllllllllIIlIIllllllIIIIIllIl.rotate(llllllllllllIIlIIllllllIIIIIlllI.getValue((IProperty<EnumFacing>)BlockRedstoneComparator.FACING)));
    }
    
    @Override
    public String getLocalizedName() {
        return I18n.translateToLocal("item.comparator.name");
    }
    
    private int calculateOutput(final World llllllllllllIIlIIllllllIlllIIllI, final BlockPos llllllllllllIIlIIllllllIlllIIIIl, final IBlockState llllllllllllIIlIIllllllIlllIIIII) {
        return (llllllllllllIIlIIllllllIlllIIIII.getValue(BlockRedstoneComparator.MODE) == Mode.SUBTRACT) ? Math.max(this.calculateInputStrength(llllllllllllIIlIIllllllIlllIIllI, llllllllllllIIlIIllllllIlllIIIIl, llllllllllllIIlIIllllllIlllIIIII) - this.getPowerOnSides(llllllllllllIIlIIllllllIlllIIllI, llllllllllllIIlIIllllllIlllIIIIl, llllllllllllIIlIIllllllIlllIIIII), 0) : this.calculateInputStrength(llllllllllllIIlIIllllllIlllIIllI, llllllllllllIIlIIllllllIlllIIIIl, llllllllllllIIlIIllllllIlllIIIII);
    }
    
    @Override
    public void breakBlock(final World llllllllllllIIlIIllllllIIIlllIIl, final BlockPos llllllllllllIIlIIllllllIIIlllIII, final IBlockState llllllllllllIIlIIllllllIIIlllIll) {
        super.breakBlock(llllllllllllIIlIIllllllIIIlllIIl, llllllllllllIIlIIllllllIIIlllIII, llllllllllllIIlIIllllllIIIlllIll);
        llllllllllllIIlIIllllllIIIlllIIl.removeTileEntity(llllllllllllIIlIIllllllIIIlllIII);
        this.notifyNeighbors(llllllllllllIIlIIllllllIIIlllIIl, llllllllllllIIlIIllllllIIIlllIII, llllllllllllIIlIIllllllIIIlllIll);
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllIIlIIllllllIIIIllIIl) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockRedstoneComparator.FACING, EnumFacing.getHorizontal(llllllllllllIIlIIllllllIIIIllIIl)).withProperty((IProperty<Comparable>)BlockRedstoneComparator.POWERED, (llllllllllllIIlIIllllllIIIIllIIl & 0x8) > 0).withProperty(BlockRedstoneComparator.MODE, ((llllllllllllIIlIIllllllIIIIllIIl & 0x4) > 0) ? Mode.SUBTRACT : Mode.COMPARE);
    }
    
    @Override
    protected int getDelay(final IBlockState llllllllllllIIlIIlllllllIIIlIlll) {
        return 2;
    }
    
    public enum Mode implements IStringSerializable
    {
        private final /* synthetic */ String name;
        
        COMPARE("COMPARE", 0, "compare"), 
        SUBTRACT("SUBTRACT", 1, "subtract");
        
        @Override
        public String getName() {
            return this.name;
        }
        
        private Mode(final String llllllllllllIIlIlIIllIIIIllllllI, final int llllllllllllIIlIlIIllIIIIlllllIl, final String llllllllllllIIlIlIIllIIIlIIIIIII) {
            this.name = llllllllllllIIlIlIIllIIIlIIIIIII;
        }
        
        @Override
        public String toString() {
            return this.name;
        }
    }
}
