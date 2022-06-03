// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.EnumParticleTypes;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.util.Mirror;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Rotation;
import net.minecraft.util.EnumHand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyInteger;

public class BlockRedstoneRepeater extends BlockRedstoneDiode
{
    public static final /* synthetic */ PropertyInteger DELAY;
    public static final /* synthetic */ PropertyBool LOCKED;
    
    @Override
    protected boolean isAlternateInput(final IBlockState lllllllllllIIlllIlIllllIllllllII) {
        return BlockRedstoneDiode.isDiode(lllllllllllIIlllIlIllllIllllllII);
    }
    
    static {
        LOCKED = PropertyBool.create("locked");
        DELAY = PropertyInteger.create("delay", 1, 4);
    }
    
    @Override
    protected IBlockState getPoweredState(final IBlockState lllllllllllIIlllIlIlllllIIlIIlll) {
        final Integer lllllllllllIIlllIlIlllllIIlIIllI = lllllllllllIIlllIlIlllllIIlIIlll.getValue((IProperty<Integer>)BlockRedstoneRepeater.DELAY);
        final Boolean lllllllllllIIlllIlIlllllIIlIIlIl = lllllllllllIIlllIlIlllllIIlIIlll.getValue((IProperty<Boolean>)BlockRedstoneRepeater.LOCKED);
        final EnumFacing lllllllllllIIlllIlIlllllIIlIIlII = lllllllllllIIlllIlIlllllIIlIIlll.getValue((IProperty<EnumFacing>)BlockRedstoneRepeater.FACING);
        return Blocks.POWERED_REPEATER.getDefaultState().withProperty((IProperty<Comparable>)BlockRedstoneRepeater.FACING, lllllllllllIIlllIlIlllllIIlIIlII).withProperty((IProperty<Comparable>)BlockRedstoneRepeater.DELAY, lllllllllllIIlllIlIlllllIIlIIllI).withProperty((IProperty<Comparable>)BlockRedstoneRepeater.LOCKED, lllllllllllIIlllIlIlllllIIlIIlIl);
    }
    
    @Override
    protected int getDelay(final IBlockState lllllllllllIIlllIlIlllllIIlIlllI) {
        return lllllllllllIIlllIlIlllllIIlIlllI.getValue((IProperty<Integer>)BlockRedstoneRepeater.DELAY) * 2;
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllIIlllIlIllllIllIIIIIl) {
        int lllllllllllIIlllIlIllllIllIIIIII = 0;
        lllllllllllIIlllIlIllllIllIIIIII |= lllllllllllIIlllIlIllllIllIIIIIl.getValue((IProperty<EnumFacing>)BlockRedstoneRepeater.FACING).getHorizontalIndex();
        lllllllllllIIlllIlIllllIllIIIIII |= lllllllllllIIlllIlIllllIllIIIIIl.getValue((IProperty<Integer>)BlockRedstoneRepeater.DELAY) - 1 << 2;
        return lllllllllllIIlllIlIllllIllIIIIII;
    }
    
    @Override
    public IBlockState getActualState(final IBlockState lllllllllllIIlllIlIlllllIlIlIIll, final IBlockAccess lllllllllllIIlllIlIlllllIlIlIIlI, final BlockPos lllllllllllIIlllIlIlllllIlIlIlIl) {
        return lllllllllllIIlllIlIlllllIlIlIIll.withProperty((IProperty<Comparable>)BlockRedstoneRepeater.LOCKED, this.isLocked(lllllllllllIIlllIlIlllllIlIlIIlI, lllllllllllIIlllIlIlllllIlIlIlIl, lllllllllllIIlllIlIlllllIlIlIIll));
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllIIlllIlIllllIllIIIlll) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockRedstoneRepeater.FACING, EnumFacing.getHorizontal(lllllllllllIIlllIlIllllIllIIIlll)).withProperty((IProperty<Comparable>)BlockRedstoneRepeater.LOCKED, false).withProperty((IProperty<Comparable>)BlockRedstoneRepeater.DELAY, 1 + (lllllllllllIIlllIlIllllIllIIIlll >> 2));
    }
    
    @Override
    public void breakBlock(final World lllllllllllIIlllIlIllllIllIIllIl, final BlockPos lllllllllllIIlllIlIllllIllIlIIII, final IBlockState lllllllllllIIlllIlIllllIllIIlIll) {
        super.breakBlock(lllllllllllIIlllIlIllllIllIIllIl, lllllllllllIIlllIlIllllIllIlIIII, lllllllllllIIlllIlIllllIllIIlIll);
        this.notifyNeighbors(lllllllllllIIlllIlIllllIllIIllIl, lllllllllllIIlllIlIllllIllIlIIII, lllllllllllIIlllIlIllllIllIIlIll);
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllIIlllIlIlllllIIIlIIIl, final Random lllllllllllIIlllIlIlllllIIIlIIII, final int lllllllllllIIlllIlIlllllIIIIllll) {
        return Items.REPEATER;
    }
    
    protected BlockRedstoneRepeater(final boolean lllllllllllIIlllIlIlllllIlIllllI) {
        super(lllllllllllIIlllIlIlllllIlIllllI);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockRedstoneRepeater.FACING, EnumFacing.NORTH).withProperty((IProperty<Comparable>)BlockRedstoneRepeater.DELAY, 1).withProperty((IProperty<Comparable>)BlockRedstoneRepeater.LOCKED, false));
    }
    
    @Override
    public boolean onBlockActivated(final World lllllllllllIIlllIlIlllllIIllllIl, final BlockPos lllllllllllIIlllIlIlllllIIllllII, final IBlockState lllllllllllIIlllIlIlllllIIllIIlI, final EntityPlayer lllllllllllIIlllIlIlllllIIlllIlI, final EnumHand lllllllllllIIlllIlIlllllIIlllIIl, final EnumFacing lllllllllllIIlllIlIlllllIIlllIII, final float lllllllllllIIlllIlIlllllIIllIlll, final float lllllllllllIIlllIlIlllllIIllIllI, final float lllllllllllIIlllIlIlllllIIllIlIl) {
        if (!lllllllllllIIlllIlIlllllIIlllIlI.capabilities.allowEdit) {
            return false;
        }
        lllllllllllIIlllIlIlllllIIllllIl.setBlockState(lllllllllllIIlllIlIlllllIIllllII, lllllllllllIIlllIlIlllllIIllIIlI.cycleProperty((IProperty<Comparable>)BlockRedstoneRepeater.DELAY), 3);
        return true;
    }
    
    @Override
    public IBlockState withRotation(final IBlockState lllllllllllIIlllIlIlllllIlIIllIl, final Rotation lllllllllllIIlllIlIlllllIlIIlIlI) {
        return lllllllllllIIlllIlIlllllIlIIllIl.withProperty((IProperty<Comparable>)BlockRedstoneRepeater.FACING, lllllllllllIIlllIlIlllllIlIIlIlI.rotate(lllllllllllIIlllIlIlllllIlIIllIl.getValue((IProperty<EnumFacing>)BlockRedstoneRepeater.FACING)));
    }
    
    @Override
    public ItemStack getItem(final World lllllllllllIIlllIlIlllllIIIIllIl, final BlockPos lllllllllllIIlllIlIlllllIIIIllII, final IBlockState lllllllllllIIlllIlIlllllIIIIlIll) {
        return new ItemStack(Items.REPEATER);
    }
    
    @Override
    protected IBlockState getUnpoweredState(final IBlockState lllllllllllIIlllIlIlllllIIIlIllI) {
        final Integer lllllllllllIIlllIlIlllllIIIllIIl = lllllllllllIIlllIlIlllllIIIlIllI.getValue((IProperty<Integer>)BlockRedstoneRepeater.DELAY);
        final Boolean lllllllllllIIlllIlIlllllIIIllIII = lllllllllllIIlllIlIlllllIIIlIllI.getValue((IProperty<Boolean>)BlockRedstoneRepeater.LOCKED);
        final EnumFacing lllllllllllIIlllIlIlllllIIIlIlll = lllllllllllIIlllIlIlllllIIIlIllI.getValue((IProperty<EnumFacing>)BlockRedstoneRepeater.FACING);
        return Blocks.UNPOWERED_REPEATER.getDefaultState().withProperty((IProperty<Comparable>)BlockRedstoneRepeater.FACING, lllllllllllIIlllIlIlllllIIIlIlll).withProperty((IProperty<Comparable>)BlockRedstoneRepeater.DELAY, lllllllllllIIlllIlIlllllIIIllIIl).withProperty((IProperty<Comparable>)BlockRedstoneRepeater.LOCKED, lllllllllllIIlllIlIlllllIIIllIII);
    }
    
    @Override
    public IBlockState withMirror(final IBlockState lllllllllllIIlllIlIlllllIlIIIlII, final Mirror lllllllllllIIlllIlIlllllIlIIIIll) {
        return lllllllllllIIlllIlIlllllIlIIIlII.withRotation(lllllllllllIIlllIlIlllllIlIIIIll.toRotation(lllllllllllIIlllIlIlllllIlIIIlII.getValue((IProperty<EnumFacing>)BlockRedstoneRepeater.FACING)));
    }
    
    @Override
    public String getLocalizedName() {
        return I18n.translateToLocal("item.diode.name");
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockRedstoneRepeater.FACING, BlockRedstoneRepeater.DELAY, BlockRedstoneRepeater.LOCKED });
    }
    
    @Override
    public void randomDisplayTick(final IBlockState lllllllllllIIlllIlIllllIlllIIIIl, final World lllllllllllIIlllIlIllllIlllIIIII, final BlockPos lllllllllllIIlllIlIllllIlllIlIll, final Random lllllllllllIIlllIlIllllIlllIlIlI) {
        if (this.isRepeaterPowered) {
            final EnumFacing lllllllllllIIlllIlIllllIlllIlIIl = lllllllllllIIlllIlIllllIlllIIIIl.getValue((IProperty<EnumFacing>)BlockRedstoneRepeater.FACING);
            final double lllllllllllIIlllIlIllllIlllIlIII = lllllllllllIIlllIlIllllIlllIlIll.getX() + 0.5f + (lllllllllllIIlllIlIllllIlllIlIlI.nextFloat() - 0.5f) * 0.2;
            final double lllllllllllIIlllIlIllllIlllIIlll = lllllllllllIIlllIlIllllIlllIlIll.getY() + 0.4f + (lllllllllllIIlllIlIllllIlllIlIlI.nextFloat() - 0.5f) * 0.2;
            final double lllllllllllIIlllIlIllllIlllIIllI = lllllllllllIIlllIlIllllIlllIlIll.getZ() + 0.5f + (lllllllllllIIlllIlIllllIlllIlIlI.nextFloat() - 0.5f) * 0.2;
            float lllllllllllIIlllIlIllllIlllIIlIl = -5.0f;
            if (lllllllllllIIlllIlIllllIlllIlIlI.nextBoolean()) {
                lllllllllllIIlllIlIllllIlllIIlIl = (float)(lllllllllllIIlllIlIllllIlllIIIIl.getValue((IProperty<Integer>)BlockRedstoneRepeater.DELAY) * 2 - 1);
            }
            lllllllllllIIlllIlIllllIlllIIlIl /= 16.0f;
            final double lllllllllllIIlllIlIllllIlllIIlII = lllllllllllIIlllIlIllllIlllIIlIl * lllllllllllIIlllIlIllllIlllIlIIl.getFrontOffsetX();
            final double lllllllllllIIlllIlIllllIlllIIIll = lllllllllllIIlllIlIllllIlllIIlIl * lllllllllllIIlllIlIllllIlllIlIIl.getFrontOffsetZ();
            lllllllllllIIlllIlIllllIlllIIIII.spawnParticle(EnumParticleTypes.REDSTONE, lllllllllllIIlllIlIllllIlllIlIII + lllllllllllIIlllIlIllllIlllIIlII, lllllllllllIIlllIlIllllIlllIIlll, lllllllllllIIlllIlIllllIlllIIllI + lllllllllllIIlllIlIllllIlllIIIll, 0.0, 0.0, 0.0, new int[0]);
        }
    }
    
    @Override
    public boolean isLocked(final IBlockAccess lllllllllllIIlllIlIlllllIIIIIIIl, final BlockPos lllllllllllIIlllIlIlllllIIIIIIII, final IBlockState lllllllllllIIlllIlIlllllIIIIIIll) {
        return this.getPowerOnSides(lllllllllllIIlllIlIlllllIIIIIIIl, lllllllllllIIlllIlIlllllIIIIIIII, lllllllllllIIlllIlIlllllIIIIIIll) > 0;
    }
}
