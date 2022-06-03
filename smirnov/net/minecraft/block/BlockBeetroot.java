// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import java.util.Random;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.block.properties.PropertyInteger;

public class BlockBeetroot extends BlockCrops
{
    public static final /* synthetic */ PropertyInteger BEETROOT_AGE;
    private static final /* synthetic */ AxisAlignedBB[] BEETROOT_AABB;
    
    @Override
    protected int getBonemealAgeIncrease(final World lllllllllllIIlIIIIlIlllIlllIIIIl) {
        return super.getBonemealAgeIncrease(lllllllllllIIlIIIIlIlllIlllIIIIl) / 3;
    }
    
    @Override
    protected Item getCrop() {
        return Items.BEETROOT;
    }
    
    @Override
    protected PropertyInteger getAgeProperty() {
        return BlockBeetroot.BEETROOT_AGE;
    }
    
    static {
        BEETROOT_AGE = PropertyInteger.create("age", 0, 3);
        BEETROOT_AABB = new AxisAlignedBB[] { new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.125, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.25, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.375, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.5, 1.0) };
    }
    
    @Override
    protected Item getSeed() {
        return Items.BEETROOT_SEEDS;
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockBeetroot.BEETROOT_AGE });
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllIIlIIIIlIlllIllIlIllI, final IBlockAccess lllllllllllIIlIIIIlIlllIllIllIIl, final BlockPos lllllllllllIIlIIIIlIlllIllIllIII) {
        return BlockBeetroot.BEETROOT_AABB[lllllllllllIIlIIIIlIlllIllIlIllI.getValue((IProperty<Integer>)this.getAgeProperty())];
    }
    
    @Override
    public void updateTick(final World lllllllllllIIlIIIIlIlllIlllIllll, final BlockPos lllllllllllIIlIIIIlIlllIlllIlllI, final IBlockState lllllllllllIIlIIIIlIlllIlllIllIl, final Random lllllllllllIIlIIIIlIlllIlllIllII) {
        if (lllllllllllIIlIIIIlIlllIlllIllII.nextInt(3) == 0) {
            this.checkAndDropBlock(lllllllllllIIlIIIIlIlllIlllIllll, lllllllllllIIlIIIIlIlllIlllIlllI, lllllllllllIIlIIIIlIlllIlllIllIl);
        }
        else {
            super.updateTick(lllllllllllIIlIIIIlIlllIlllIllll, lllllllllllIIlIIIIlIlllIlllIlllI, lllllllllllIIlIIIIlIlllIlllIllIl, lllllllllllIIlIIIIlIlllIlllIllII);
        }
    }
    
    @Override
    public int getMaxAge() {
        return 3;
    }
}
