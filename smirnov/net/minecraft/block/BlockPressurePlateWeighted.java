// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundCategory;
import net.minecraft.init.SoundEvents;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.material.MapColor;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;

public class BlockPressurePlateWeighted extends BlockBasePressurePlate
{
    private final /* synthetic */ int maxWeight;
    public static final /* synthetic */ PropertyInteger POWER;
    
    protected BlockPressurePlateWeighted(final Material lllllllllllIllllIIllIllllIIIIIlI, final int lllllllllllIllllIIllIlllIllllllI) {
        this(lllllllllllIllllIIllIllllIIIIIlI, lllllllllllIllllIIllIlllIllllllI, lllllllllllIllllIIllIllllIIIIIlI.getMaterialMapColor());
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllIllllIIllIlllIlIIIIlI) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockPressurePlateWeighted.POWER, lllllllllllIllllIIllIlllIlIIIIlI);
    }
    
    @Override
    protected int computeRedstoneStrength(final World lllllllllllIllllIIllIlllIllIIllI, final BlockPos lllllllllllIllllIIllIlllIllIIlIl) {
        final int lllllllllllIllllIIllIlllIllIlIIl = Math.min(lllllllllllIllllIIllIlllIllIIllI.getEntitiesWithinAABB((Class<? extends Entity>)Entity.class, BlockPressurePlateWeighted.PRESSURE_AABB.offset(lllllllllllIllllIIllIlllIllIIlIl)).size(), this.maxWeight);
        if (lllllllllllIllllIIllIlllIllIlIIl > 0) {
            final float lllllllllllIllllIIllIlllIllIlIII = Math.min(this.maxWeight, lllllllllllIllllIIllIlllIllIlIIl) / (float)this.maxWeight;
            return MathHelper.ceil(lllllllllllIllllIIllIlllIllIlIII * 15.0f);
        }
        return 0;
    }
    
    @Override
    protected int getRedstoneStrength(final IBlockState lllllllllllIllllIIllIlllIlIlIIlI) {
        return lllllllllllIllllIIllIlllIlIlIIlI.getValue((IProperty<Integer>)BlockPressurePlateWeighted.POWER);
    }
    
    protected BlockPressurePlateWeighted(final Material lllllllllllIllllIIllIlllIllllIII, final int lllllllllllIllllIIllIlllIlllIlll, final MapColor lllllllllllIllllIIllIlllIlllIllI) {
        super(lllllllllllIllllIIllIlllIllllIII, lllllllllllIllllIIllIlllIlllIllI);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockPressurePlateWeighted.POWER, 0));
        this.maxWeight = lllllllllllIllllIIllIlllIlllIlll;
    }
    
    static {
        POWER = PropertyInteger.create("power", 0, 15);
    }
    
    @Override
    public int tickRate(final World lllllllllllIllllIIllIlllIlIIlIII) {
        return 10;
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllIllllIIllIlllIIlllllI) {
        return lllllllllllIllllIIllIlllIIlllllI.getValue((IProperty<Integer>)BlockPressurePlateWeighted.POWER);
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockPressurePlateWeighted.POWER });
    }
    
    @Override
    protected void playClickOffSound(final World lllllllllllIllllIIllIlllIlIlIllI, final BlockPos lllllllllllIllllIIllIlllIlIlIlll) {
        lllllllllllIllllIIllIlllIlIlIllI.playSound(null, lllllllllllIllllIIllIlllIlIlIlll, SoundEvents.BLOCK_METAL_PRESSPLATE_CLICK_OFF, SoundCategory.BLOCKS, 0.3f, 0.75f);
    }
    
    @Override
    protected IBlockState setRedstoneStrength(final IBlockState lllllllllllIllllIIllIlllIlIIlIll, final int lllllllllllIllllIIllIlllIlIIlIlI) {
        return lllllllllllIllllIIllIlllIlIIlIll.withProperty((IProperty<Comparable>)BlockPressurePlateWeighted.POWER, lllllllllllIllllIIllIlllIlIIlIlI);
    }
    
    @Override
    protected void playClickOnSound(final World lllllllllllIllllIIllIlllIlIlllll, final BlockPos lllllllllllIllllIIllIlllIlIllllI) {
        lllllllllllIllllIIllIlllIlIlllll.playSound(null, lllllllllllIllllIIllIlllIlIllllI, SoundEvents.BLOCK_METAL_PRESSPLATE_CLICK_ON, SoundCategory.BLOCKS, 0.3f, 0.90000004f);
    }
}
