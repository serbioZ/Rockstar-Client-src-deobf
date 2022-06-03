// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.world.IBlockAccess;
import net.minecraft.block.properties.IProperty;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.feature.WorldGenBigMushroom;
import net.minecraft.init.Blocks;
import java.util.Iterator;
import java.util.Random;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.util.math.AxisAlignedBB;

public class BlockMushroom extends BlockBush implements IGrowable
{
    protected static final /* synthetic */ AxisAlignedBB MUSHROOM_AABB;
    
    static {
        MUSHROOM_AABB = new AxisAlignedBB(0.30000001192092896, 0.0, 0.30000001192092896, 0.699999988079071, 0.4000000059604645, 0.699999988079071);
    }
    
    @Override
    public boolean canGrow(final World llllllllllllIlIlIIIllIIIllIllIll, final BlockPos llllllllllllIlIlIIIllIIIllIllIlI, final IBlockState llllllllllllIlIlIIIllIIIllIllIIl, final boolean llllllllllllIlIlIIIllIIIllIllIII) {
        return true;
    }
    
    @Override
    public void updateTick(final World llllllllllllIlIlIIIllIIlIIIllIIl, BlockPos llllllllllllIlIlIIIllIIlIIIIlllI, final IBlockState llllllllllllIlIlIIIllIIlIIIlIlll, final Random llllllllllllIlIlIIIllIIlIIIlIllI) {
        if (llllllllllllIlIlIIIllIIlIIIlIllI.nextInt(25) == 0) {
            int llllllllllllIlIlIIIllIIlIIIlIlIl = 5;
            final int llllllllllllIlIlIIIllIIlIIIlIlII = 4;
            for (final BlockPos llllllllllllIlIlIIIllIIlIIIlIIll : BlockPos.getAllInBoxMutable(llllllllllllIlIlIIIllIIlIIIIlllI.add(-4, -1, -4), llllllllllllIlIlIIIllIIlIIIIlllI.add(4, 1, 4))) {
                if (llllllllllllIlIlIIIllIIlIIIllIIl.getBlockState(llllllllllllIlIlIIIllIIlIIIlIIll).getBlock() == this && --llllllllllllIlIlIIIllIIlIIIlIlIl <= 0) {
                    return;
                }
            }
            BlockPos llllllllllllIlIlIIIllIIlIIIlIIlI = llllllllllllIlIlIIIllIIlIIIIlllI.add(llllllllllllIlIlIIIllIIlIIIlIllI.nextInt(3) - 1, llllllllllllIlIlIIIllIIlIIIlIllI.nextInt(2) - llllllllllllIlIlIIIllIIlIIIlIllI.nextInt(2), llllllllllllIlIlIIIllIIlIIIlIllI.nextInt(3) - 1);
            for (int llllllllllllIlIlIIIllIIlIIIlIIIl = 0; llllllllllllIlIlIIIllIIlIIIlIIIl < 4; ++llllllllllllIlIlIIIllIIlIIIlIIIl) {
                if (llllllllllllIlIlIIIllIIlIIIllIIl.isAirBlock(llllllllllllIlIlIIIllIIlIIIlIIlI) && this.canBlockStay(llllllllllllIlIlIIIllIIlIIIllIIl, llllllllllllIlIlIIIllIIlIIIlIIlI, this.getDefaultState())) {
                    llllllllllllIlIlIIIllIIlIIIIlllI = llllllllllllIlIlIIIllIIlIIIlIIlI;
                }
                llllllllllllIlIlIIIllIIlIIIlIIlI = llllllllllllIlIlIIIllIIlIIIIlllI.add(llllllllllllIlIlIIIllIIlIIIlIllI.nextInt(3) - 1, llllllllllllIlIlIIIllIIlIIIlIllI.nextInt(2) - llllllllllllIlIlIIIllIIlIIIlIllI.nextInt(2), llllllllllllIlIlIIIllIIlIIIlIllI.nextInt(3) - 1);
            }
            if (llllllllllllIlIlIIIllIIlIIIllIIl.isAirBlock(llllllllllllIlIlIIIllIIlIIIlIIlI) && this.canBlockStay(llllllllllllIlIlIIIllIIlIIIllIIl, llllllllllllIlIlIIIllIIlIIIlIIlI, this.getDefaultState())) {
                llllllllllllIlIlIIIllIIlIIIllIIl.setBlockState(llllllllllllIlIlIIIllIIlIIIlIIlI, this.getDefaultState(), 2);
            }
        }
    }
    
    @Override
    public boolean canUseBonemeal(final World llllllllllllIlIlIIIllIIIllIlIlIl, final Random llllllllllllIlIlIIIllIIIllIlIlII, final BlockPos llllllllllllIlIlIIIllIIIllIlIIll, final IBlockState llllllllllllIlIlIIIllIIIllIlIIlI) {
        return llllllllllllIlIlIIIllIIIllIlIlII.nextFloat() < 0.4;
    }
    
    public boolean generateBigMushroom(final World llllllllllllIlIlIIIllIIIlllIIlll, final BlockPos llllllllllllIlIlIIIllIIIlllIIllI, final IBlockState llllllllllllIlIlIIIllIIIllIlllll, final Random llllllllllllIlIlIIIllIIIlllIIlII) {
        llllllllllllIlIlIIIllIIIlllIIlll.setBlockToAir(llllllllllllIlIlIIIllIIIlllIIllI);
        WorldGenerator llllllllllllIlIlIIIllIIIlllIIIll = null;
        if (this == Blocks.BROWN_MUSHROOM) {
            llllllllllllIlIlIIIllIIIlllIIIll = new WorldGenBigMushroom(Blocks.BROWN_MUSHROOM_BLOCK);
        }
        else if (this == Blocks.RED_MUSHROOM) {
            llllllllllllIlIlIIIllIIIlllIIIll = new WorldGenBigMushroom(Blocks.RED_MUSHROOM_BLOCK);
        }
        if (llllllllllllIlIlIIIllIIIlllIIIll != null && llllllllllllIlIlIIIllIIIlllIIIll.generate(llllllllllllIlIlIIIllIIIlllIIlll, llllllllllllIlIlIIIllIIIlllIIlII, llllllllllllIlIlIIIllIIIlllIIllI)) {
            return true;
        }
        llllllllllllIlIlIIIllIIIlllIIlll.setBlockState(llllllllllllIlIlIIIllIIIlllIIllI, llllllllllllIlIlIIIllIIIllIlllll, 3);
        return false;
    }
    
    @Override
    protected boolean canSustainBush(final IBlockState llllllllllllIlIlIIIllIIIllllllII) {
        return llllllllllllIlIlIIIllIIIllllllII.isFullBlock();
    }
    
    @Override
    public boolean canBlockStay(final World llllllllllllIlIlIIIllIIIllllIIIl, final BlockPos llllllllllllIlIlIIIllIIIllllIIII, final IBlockState llllllllllllIlIlIIIllIIIllllIlII) {
        if (llllllllllllIlIlIIIllIIIllllIIII.getY() >= 0 && llllllllllllIlIlIIIllIIIllllIIII.getY() < 256) {
            final IBlockState llllllllllllIlIlIIIllIIIllllIIll = llllllllllllIlIlIIIllIIIllllIIIl.getBlockState(llllllllllllIlIlIIIllIIIllllIIII.down());
            return llllllllllllIlIlIIIllIIIllllIIll.getBlock() == Blocks.MYCELIUM || (llllllllllllIlIlIIIllIIIllllIIll.getBlock() == Blocks.DIRT && llllllllllllIlIlIIIllIIIllllIIll.getValue(BlockDirt.VARIANT) == BlockDirt.DirtType.PODZOL) || (llllllllllllIlIlIIIllIIIllllIIIl.getLight(llllllllllllIlIlIIIllIIIllllIIII) < 13 && this.canSustainBush(llllllllllllIlIlIIIllIIIllllIIll));
        }
        return false;
    }
    
    @Override
    public boolean canPlaceBlockAt(final World llllllllllllIlIlIIIllIIlIIIIIIIl, final BlockPos llllllllllllIlIlIIIllIIlIIIIIIII) {
        return super.canPlaceBlockAt(llllllllllllIlIlIIIllIIlIIIIIIIl, llllllllllllIlIlIIIllIIlIIIIIIII) && this.canBlockStay(llllllllllllIlIlIIIllIIlIIIIIIIl, llllllllllllIlIlIIIllIIlIIIIIIII, this.getDefaultState());
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState llllllllllllIlIlIIIllIIlIIlIIlIl, final IBlockAccess llllllllllllIlIlIIIllIIlIIlIIlII, final BlockPos llllllllllllIlIlIIIllIIlIIlIIIll) {
        return BlockMushroom.MUSHROOM_AABB;
    }
    
    protected BlockMushroom() {
        this.setTickRandomly(true);
    }
    
    @Override
    public void grow(final World llllllllllllIlIlIIIllIIIllIIlIlI, final Random llllllllllllIlIlIIIllIIIllIIlIIl, final BlockPos llllllllllllIlIlIIIllIIIllIIIIll, final IBlockState llllllllllllIlIlIIIllIIIllIIIlll) {
        this.generateBigMushroom(llllllllllllIlIlIIIllIIIllIIlIlI, llllllllllllIlIlIIIllIIIllIIIIll, llllllllllllIlIlIIIllIIIllIIIlll, llllllllllllIlIlIIIllIIIllIIlIIl);
    }
}
