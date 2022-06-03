// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.feature;

import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockHugeMushroom;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.block.Block;

public class WorldGenBigMushroom extends WorldGenerator
{
    private final /* synthetic */ Block mushroomType;
    
    @Override
    public boolean generate(final World llllllllllIlllllIllIIlIIllIIllII, final Random llllllllllIlllllIllIIlIIlIlIllll, final BlockPos llllllllllIlllllIllIIlIIllIIlIlI) {
        Block llllllllllIlllllIllIIlIIllIIlIIl = this.mushroomType;
        if (llllllllllIlllllIllIIlIIllIIlIIl == null) {
            llllllllllIlllllIllIIlIIllIIlIIl = (llllllllllIlllllIllIIlIIlIlIllll.nextBoolean() ? Blocks.BROWN_MUSHROOM_BLOCK : Blocks.RED_MUSHROOM_BLOCK);
        }
        int llllllllllIlllllIllIIlIIllIIlIII = llllllllllIlllllIllIIlIIlIlIllll.nextInt(3) + 4;
        if (llllllllllIlllllIllIIlIIlIlIllll.nextInt(12) == 0) {
            llllllllllIlllllIllIIlIIllIIlIII *= 2;
        }
        boolean llllllllllIlllllIllIIlIIllIIIlll = true;
        if (llllllllllIlllllIllIIlIIllIIlIlI.getY() < 1 || llllllllllIlllllIllIIlIIllIIlIlI.getY() + llllllllllIlllllIllIIlIIllIIlIII + 1 >= 256) {
            return false;
        }
        for (int llllllllllIlllllIllIIlIIllIIIllI = llllllllllIlllllIllIIlIIllIIlIlI.getY(); llllllllllIlllllIllIIlIIllIIIllI <= llllllllllIlllllIllIIlIIllIIlIlI.getY() + 1 + llllllllllIlllllIllIIlIIllIIlIII; ++llllllllllIlllllIllIIlIIllIIIllI) {
            int llllllllllIlllllIllIIlIIllIIIlIl = 3;
            if (llllllllllIlllllIllIIlIIllIIIllI <= llllllllllIlllllIllIIlIIllIIlIlI.getY() + 3) {
                llllllllllIlllllIllIIlIIllIIIlIl = 0;
            }
            final BlockPos.MutableBlockPos llllllllllIlllllIllIIlIIllIIIlII = new BlockPos.MutableBlockPos();
            for (int llllllllllIlllllIllIIlIIllIIIIll = llllllllllIlllllIllIIlIIllIIlIlI.getX() - llllllllllIlllllIllIIlIIllIIIlIl; llllllllllIlllllIllIIlIIllIIIIll <= llllllllllIlllllIllIIlIIllIIlIlI.getX() + llllllllllIlllllIllIIlIIllIIIlIl && llllllllllIlllllIllIIlIIllIIIlll; ++llllllllllIlllllIllIIlIIllIIIIll) {
                for (int llllllllllIlllllIllIIlIIllIIIIlI = llllllllllIlllllIllIIlIIllIIlIlI.getZ() - llllllllllIlllllIllIIlIIllIIIlIl; llllllllllIlllllIllIIlIIllIIIIlI <= llllllllllIlllllIllIIlIIllIIlIlI.getZ() + llllllllllIlllllIllIIlIIllIIIlIl && llllllllllIlllllIllIIlIIllIIIlll; ++llllllllllIlllllIllIIlIIllIIIIlI) {
                    if (llllllllllIlllllIllIIlIIllIIIllI >= 0 && llllllllllIlllllIllIIlIIllIIIllI < 256) {
                        final Material llllllllllIlllllIllIIlIIllIIIIIl = llllllllllIlllllIllIIlIIllIIllII.getBlockState(llllllllllIlllllIllIIlIIllIIIlII.setPos(llllllllllIlllllIllIIlIIllIIIIll, llllllllllIlllllIllIIlIIllIIIllI, llllllllllIlllllIllIIlIIllIIIIlI)).getMaterial();
                        if (llllllllllIlllllIllIIlIIllIIIIIl != Material.AIR && llllllllllIlllllIllIIlIIllIIIIIl != Material.LEAVES) {
                            llllllllllIlllllIllIIlIIllIIIlll = false;
                        }
                    }
                    else {
                        llllllllllIlllllIllIIlIIllIIIlll = false;
                    }
                }
            }
        }
        if (!llllllllllIlllllIllIIlIIllIIIlll) {
            return false;
        }
        final Block llllllllllIlllllIllIIlIIllIIIIII = llllllllllIlllllIllIIlIIllIIllII.getBlockState(llllllllllIlllllIllIIlIIllIIlIlI.down()).getBlock();
        if (llllllllllIlllllIllIIlIIllIIIIII != Blocks.DIRT && llllllllllIlllllIllIIlIIllIIIIII != Blocks.GRASS && llllllllllIlllllIllIIlIIllIIIIII != Blocks.MYCELIUM) {
            return false;
        }
        int llllllllllIlllllIllIIlIIlIllllll = llllllllllIlllllIllIIlIIllIIlIlI.getY() + llllllllllIlllllIllIIlIIllIIlIII;
        if (llllllllllIlllllIllIIlIIllIIlIIl == Blocks.RED_MUSHROOM_BLOCK) {
            llllllllllIlllllIllIIlIIlIllllll = llllllllllIlllllIllIIlIIllIIlIlI.getY() + llllllllllIlllllIllIIlIIllIIlIII - 3;
        }
        for (int llllllllllIlllllIllIIlIIlIlllllI = llllllllllIlllllIllIIlIIlIllllll; llllllllllIlllllIllIIlIIlIlllllI <= llllllllllIlllllIllIIlIIllIIlIlI.getY() + llllllllllIlllllIllIIlIIllIIlIII; ++llllllllllIlllllIllIIlIIlIlllllI) {
            int llllllllllIlllllIllIIlIIlIllllIl = 1;
            if (llllllllllIlllllIllIIlIIlIlllllI < llllllllllIlllllIllIIlIIllIIlIlI.getY() + llllllllllIlllllIllIIlIIllIIlIII) {
                ++llllllllllIlllllIllIIlIIlIllllIl;
            }
            if (llllllllllIlllllIllIIlIIllIIlIIl == Blocks.BROWN_MUSHROOM_BLOCK) {
                llllllllllIlllllIllIIlIIlIllllIl = 3;
            }
            final int llllllllllIlllllIllIIlIIlIllllII = llllllllllIlllllIllIIlIIllIIlIlI.getX() - llllllllllIlllllIllIIlIIlIllllIl;
            final int llllllllllIlllllIllIIlIIlIlllIll = llllllllllIlllllIllIIlIIllIIlIlI.getX() + llllllllllIlllllIllIIlIIlIllllIl;
            final int llllllllllIlllllIllIIlIIlIlllIlI = llllllllllIlllllIllIIlIIllIIlIlI.getZ() - llllllllllIlllllIllIIlIIlIllllIl;
            final int llllllllllIlllllIllIIlIIlIlllIIl = llllllllllIlllllIllIIlIIllIIlIlI.getZ() + llllllllllIlllllIllIIlIIlIllllIl;
            for (int llllllllllIlllllIllIIlIIlIlllIII = llllllllllIlllllIllIIlIIlIllllII; llllllllllIlllllIllIIlIIlIlllIII <= llllllllllIlllllIllIIlIIlIlllIll; ++llllllllllIlllllIllIIlIIlIlllIII) {
                for (int llllllllllIlllllIllIIlIIlIllIlll = llllllllllIlllllIllIIlIIlIlllIlI; llllllllllIlllllIllIIlIIlIllIlll <= llllllllllIlllllIllIIlIIlIlllIIl; ++llllllllllIlllllIllIIlIIlIllIlll) {
                    int llllllllllIlllllIllIIlIIlIllIllI = 5;
                    if (llllllllllIlllllIllIIlIIlIlllIII == llllllllllIlllllIllIIlIIlIllllII) {
                        --llllllllllIlllllIllIIlIIlIllIllI;
                    }
                    else if (llllllllllIlllllIllIIlIIlIlllIII == llllllllllIlllllIllIIlIIlIlllIll) {
                        ++llllllllllIlllllIllIIlIIlIllIllI;
                    }
                    if (llllllllllIlllllIllIIlIIlIllIlll == llllllllllIlllllIllIIlIIlIlllIlI) {
                        llllllllllIlllllIllIIlIIlIllIllI -= 3;
                    }
                    else if (llllllllllIlllllIllIIlIIlIllIlll == llllllllllIlllllIllIIlIIlIlllIIl) {
                        llllllllllIlllllIllIIlIIlIllIllI += 3;
                    }
                    BlockHugeMushroom.EnumType llllllllllIlllllIllIIlIIlIllIlIl = BlockHugeMushroom.EnumType.byMetadata(llllllllllIlllllIllIIlIIlIllIllI);
                    if (llllllllllIlllllIllIIlIIllIIlIIl == Blocks.BROWN_MUSHROOM_BLOCK || llllllllllIlllllIllIIlIIlIlllllI < llllllllllIlllllIllIIlIIllIIlIlI.getY() + llllllllllIlllllIllIIlIIllIIlIII) {
                        if (llllllllllIlllllIllIIlIIlIlllIII == llllllllllIlllllIllIIlIIlIllllII || llllllllllIlllllIllIIlIIlIlllIII == llllllllllIlllllIllIIlIIlIlllIll) {
                            if (llllllllllIlllllIllIIlIIlIllIlll == llllllllllIlllllIllIIlIIlIlllIlI) {
                                continue;
                            }
                            if (llllllllllIlllllIllIIlIIlIllIlll == llllllllllIlllllIllIIlIIlIlllIIl) {
                                continue;
                            }
                        }
                        if (llllllllllIlllllIllIIlIIlIlllIII == llllllllllIlllllIllIIlIIllIIlIlI.getX() - (llllllllllIlllllIllIIlIIlIllllIl - 1) && llllllllllIlllllIllIIlIIlIllIlll == llllllllllIlllllIllIIlIIlIlllIlI) {
                            llllllllllIlllllIllIIlIIlIllIlIl = BlockHugeMushroom.EnumType.NORTH_WEST;
                        }
                        if (llllllllllIlllllIllIIlIIlIlllIII == llllllllllIlllllIllIIlIIlIllllII && llllllllllIlllllIllIIlIIlIllIlll == llllllllllIlllllIllIIlIIllIIlIlI.getZ() - (llllllllllIlllllIllIIlIIlIllllIl - 1)) {
                            llllllllllIlllllIllIIlIIlIllIlIl = BlockHugeMushroom.EnumType.NORTH_WEST;
                        }
                        if (llllllllllIlllllIllIIlIIlIlllIII == llllllllllIlllllIllIIlIIllIIlIlI.getX() + (llllllllllIlllllIllIIlIIlIllllIl - 1) && llllllllllIlllllIllIIlIIlIllIlll == llllllllllIlllllIllIIlIIlIlllIlI) {
                            llllllllllIlllllIllIIlIIlIllIlIl = BlockHugeMushroom.EnumType.NORTH_EAST;
                        }
                        if (llllllllllIlllllIllIIlIIlIlllIII == llllllllllIlllllIllIIlIIlIlllIll && llllllllllIlllllIllIIlIIlIllIlll == llllllllllIlllllIllIIlIIllIIlIlI.getZ() - (llllllllllIlllllIllIIlIIlIllllIl - 1)) {
                            llllllllllIlllllIllIIlIIlIllIlIl = BlockHugeMushroom.EnumType.NORTH_EAST;
                        }
                        if (llllllllllIlllllIllIIlIIlIlllIII == llllllllllIlllllIllIIlIIllIIlIlI.getX() - (llllllllllIlllllIllIIlIIlIllllIl - 1) && llllllllllIlllllIllIIlIIlIllIlll == llllllllllIlllllIllIIlIIlIlllIIl) {
                            llllllllllIlllllIllIIlIIlIllIlIl = BlockHugeMushroom.EnumType.SOUTH_WEST;
                        }
                        if (llllllllllIlllllIllIIlIIlIlllIII == llllllllllIlllllIllIIlIIlIllllII && llllllllllIlllllIllIIlIIlIllIlll == llllllllllIlllllIllIIlIIllIIlIlI.getZ() + (llllllllllIlllllIllIIlIIlIllllIl - 1)) {
                            llllllllllIlllllIllIIlIIlIllIlIl = BlockHugeMushroom.EnumType.SOUTH_WEST;
                        }
                        if (llllllllllIlllllIllIIlIIlIlllIII == llllllllllIlllllIllIIlIIllIIlIlI.getX() + (llllllllllIlllllIllIIlIIlIllllIl - 1) && llllllllllIlllllIllIIlIIlIllIlll == llllllllllIlllllIllIIlIIlIlllIIl) {
                            llllllllllIlllllIllIIlIIlIllIlIl = BlockHugeMushroom.EnumType.SOUTH_EAST;
                        }
                        if (llllllllllIlllllIllIIlIIlIlllIII == llllllllllIlllllIllIIlIIlIlllIll && llllllllllIlllllIllIIlIIlIllIlll == llllllllllIlllllIllIIlIIllIIlIlI.getZ() + (llllllllllIlllllIllIIlIIlIllllIl - 1)) {
                            llllllllllIlllllIllIIlIIlIllIlIl = BlockHugeMushroom.EnumType.SOUTH_EAST;
                        }
                    }
                    if (llllllllllIlllllIllIIlIIlIllIlIl == BlockHugeMushroom.EnumType.CENTER && llllllllllIlllllIllIIlIIlIlllllI < llllllllllIlllllIllIIlIIllIIlIlI.getY() + llllllllllIlllllIllIIlIIllIIlIII) {
                        llllllllllIlllllIllIIlIIlIllIlIl = BlockHugeMushroom.EnumType.ALL_INSIDE;
                    }
                    if (llllllllllIlllllIllIIlIIllIIlIlI.getY() >= llllllllllIlllllIllIIlIIllIIlIlI.getY() + llllllllllIlllllIllIIlIIllIIlIII - 1 || llllllllllIlllllIllIIlIIlIllIlIl != BlockHugeMushroom.EnumType.ALL_INSIDE) {
                        final BlockPos llllllllllIlllllIllIIlIIlIllIlII = new BlockPos(llllllllllIlllllIllIIlIIlIlllIII, llllllllllIlllllIllIIlIIlIlllllI, llllllllllIlllllIllIIlIIlIllIlll);
                        if (!llllllllllIlllllIllIIlIIllIIllII.getBlockState(llllllllllIlllllIllIIlIIlIllIlII).isFullBlock()) {
                            this.setBlockAndNotifyAdequately(llllllllllIlllllIllIIlIIllIIllII, llllllllllIlllllIllIIlIIlIllIlII, llllllllllIlllllIllIIlIIllIIlIIl.getDefaultState().withProperty(BlockHugeMushroom.VARIANT, llllllllllIlllllIllIIlIIlIllIlIl));
                        }
                    }
                }
            }
        }
        for (int llllllllllIlllllIllIIlIIlIllIIll = 0; llllllllllIlllllIllIIlIIlIllIIll < llllllllllIlllllIllIIlIIllIIlIII; ++llllllllllIlllllIllIIlIIlIllIIll) {
            final IBlockState llllllllllIlllllIllIIlIIlIllIIlI = llllllllllIlllllIllIIlIIllIIllII.getBlockState(llllllllllIlllllIllIIlIIllIIlIlI.up(llllllllllIlllllIllIIlIIlIllIIll));
            if (!llllllllllIlllllIllIIlIIlIllIIlI.isFullBlock()) {
                this.setBlockAndNotifyAdequately(llllllllllIlllllIllIIlIIllIIllII, llllllllllIlllllIllIIlIIllIIlIlI.up(llllllllllIlllllIllIIlIIlIllIIll), llllllllllIlllllIllIIlIIllIIlIIl.getDefaultState().withProperty(BlockHugeMushroom.VARIANT, BlockHugeMushroom.EnumType.STEM));
            }
        }
        return true;
    }
    
    public WorldGenBigMushroom(final Block llllllllllIlllllIllIIlIIlllIIlIl) {
        super(true);
        this.mushroomType = llllllllllIlllllIllIIlIIlllIIlIl;
    }
    
    public WorldGenBigMushroom() {
        super(false);
        this.mushroomType = null;
    }
}
