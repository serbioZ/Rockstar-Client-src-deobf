// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraft.world.World;
import net.minecraft.block.properties.IProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;

public class BlockPotato extends BlockCrops
{
    private static final /* synthetic */ AxisAlignedBB[] POTATO_AABB;
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllllllIIIIIIIllIIlIlllI, final IBlockAccess lllllllllllllllIIIIIIIllIIlIllIl, final BlockPos lllllllllllllllIIIIIIIllIIlIllII) {
        return BlockPotato.POTATO_AABB[lllllllllllllllIIIIIIIllIIlIlllI.getValue((IProperty<Integer>)this.getAgeProperty())];
    }
    
    @Override
    public void dropBlockAsItemWithChance(final World lllllllllllllllIIIIIIIllIIllIllI, final BlockPos lllllllllllllllIIIIIIIllIIlllIll, final IBlockState lllllllllllllllIIIIIIIllIIllIlII, final float lllllllllllllllIIIIIIIllIIllIIll, final int lllllllllllllllIIIIIIIllIIllIIlI) {
        super.dropBlockAsItemWithChance(lllllllllllllllIIIIIIIllIIllIllI, lllllllllllllllIIIIIIIllIIlllIll, lllllllllllllllIIIIIIIllIIllIlII, lllllllllllllllIIIIIIIllIIllIIll, lllllllllllllllIIIIIIIllIIllIIlI);
        if (!lllllllllllllllIIIIIIIllIIllIllI.isRemote && this.isMaxAge(lllllllllllllllIIIIIIIllIIllIlII) && lllllllllllllllIIIIIIIllIIllIllI.rand.nextInt(50) == 0) {
            Block.spawnAsEntity(lllllllllllllllIIIIIIIllIIllIllI, lllllllllllllllIIIIIIIllIIlllIll, new ItemStack(Items.POISONOUS_POTATO));
        }
    }
    
    static {
        POTATO_AABB = new AxisAlignedBB[] { new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.125, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.1875, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.25, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.3125, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.375, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.4375, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.5, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.5625, 1.0) };
    }
    
    @Override
    protected Item getSeed() {
        return Items.POTATO;
    }
    
    @Override
    protected Item getCrop() {
        return Items.POTATO;
    }
}
