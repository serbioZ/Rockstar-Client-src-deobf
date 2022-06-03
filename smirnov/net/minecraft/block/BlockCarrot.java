// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.block.properties.IProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.math.AxisAlignedBB;

public class BlockCarrot extends BlockCrops
{
    private static final /* synthetic */ AxisAlignedBB[] CARROT_AABB;
    
    static {
        CARROT_AABB = new AxisAlignedBB[] { new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.125, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.1875, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.25, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.3125, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.375, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.4375, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.5, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.5625, 1.0) };
    }
    
    @Override
    protected Item getCrop() {
        return Items.CARROT;
    }
    
    @Override
    protected Item getSeed() {
        return Items.CARROT;
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllIIIIIIlllIIlIllllIIII, final IBlockAccess lllllllllllIIIIIIlllIIlIllllIIll, final BlockPos lllllllllllIIIIIIlllIIlIllllIIlI) {
        return BlockCarrot.CARROT_AABB[lllllllllllIIIIIIlllIIlIllllIIII.getValue((IProperty<Integer>)this.getAgeProperty())];
    }
}
