// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.feature;

import com.google.common.collect.Lists;
import net.minecraft.block.BlockLog;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.MathHelper;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import java.util.List;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import java.util.Random;

public class WorldGenBigTree extends WorldGenAbstractTree
{
    /* synthetic */ int height;
    /* synthetic */ int heightLimitLimit;
    private /* synthetic */ Random rand;
    private /* synthetic */ World world;
    /* synthetic */ double scaleWidth;
    private /* synthetic */ BlockPos basePos;
    /* synthetic */ double branchSlope;
    /* synthetic */ int heightLimit;
    /* synthetic */ int trunkSize;
    /* synthetic */ double heightAttenuation;
    /* synthetic */ double leafDensity;
    /* synthetic */ List<FoliageCoordinates> foliageCoords;
    /* synthetic */ int leafDistanceLimit;
    
    void crosSection(final BlockPos llllllllllllIIlIlIlIIlIllIlllIll, final float llllllllllllIIlIlIlIIlIlllIIIIll, final IBlockState llllllllllllIIlIlIlIIlIlllIIIIlI) {
        for (int llllllllllllIIlIlIlIIlIlllIIIIIl = (int)(llllllllllllIIlIlIlIIlIlllIIIIll + 0.618), llllllllllllIIlIlIlIIlIlllIIIIII = -llllllllllllIIlIlIlIIlIlllIIIIIl; llllllllllllIIlIlIlIIlIlllIIIIII <= llllllllllllIIlIlIlIIlIlllIIIIIl; ++llllllllllllIIlIlIlIIlIlllIIIIII) {
            for (int llllllllllllIIlIlIlIIlIllIllllll = -llllllllllllIIlIlIlIIlIlllIIIIIl; llllllllllllIIlIlIlIIlIllIllllll <= llllllllllllIIlIlIlIIlIlllIIIIIl; ++llllllllllllIIlIlIlIIlIllIllllll) {
                if (Math.pow(Math.abs(llllllllllllIIlIlIlIIlIlllIIIIII) + 0.5, 2.0) + Math.pow(Math.abs(llllllllllllIIlIlIlIIlIllIllllll) + 0.5, 2.0) <= llllllllllllIIlIlIlIIlIlllIIIIll * llllllllllllIIlIlIlIIlIlllIIIIll) {
                    final BlockPos llllllllllllIIlIlIlIIlIllIlllllI = llllllllllllIIlIlIlIIlIllIlllIll.add(llllllllllllIIlIlIlIIlIlllIIIIII, 0, llllllllllllIIlIlIlIIlIllIllllll);
                    final Material llllllllllllIIlIlIlIIlIllIllllIl = this.world.getBlockState(llllllllllllIIlIlIlIIlIllIlllllI).getMaterial();
                    if (llllllllllllIIlIlIlIIlIllIllllIl == Material.AIR || llllllllllllIIlIlIlIIlIllIllllIl == Material.LEAVES) {
                        this.setBlockAndNotifyAdequately(this.world, llllllllllllIIlIlIlIIlIllIlllllI, llllllllllllIIlIlIlIIlIlllIIIIlI);
                    }
                }
            }
        }
    }
    
    @Override
    public void setDecorationDefaults() {
        this.leafDistanceLimit = 5;
    }
    
    float layerSize(final int llllllllllllIIlIlIlIIlIllIlIlIII) {
        if (llllllllllllIIlIlIlIIlIllIlIlIII < this.heightLimit * 0.3f) {
            return -1.0f;
        }
        final float llllllllllllIIlIlIlIIlIllIlIllII = this.heightLimit / 2.0f;
        final float llllllllllllIIlIlIlIIlIllIlIlIll = llllllllllllIIlIlIlIIlIllIlIllII - llllllllllllIIlIlIlIIlIllIlIlIII;
        float llllllllllllIIlIlIlIIlIllIlIlIlI = MathHelper.sqrt(llllllllllllIIlIlIlIIlIllIlIllII * llllllllllllIIlIlIlIIlIllIlIllII - llllllllllllIIlIlIlIIlIllIlIlIll * llllllllllllIIlIlIlIIlIllIlIlIll);
        if (llllllllllllIIlIlIlIIlIllIlIlIll == 0.0f) {
            llllllllllllIIlIlIlIIlIllIlIlIlI = llllllllllllIIlIlIlIIlIllIlIllII;
        }
        else if (Math.abs(llllllllllllIIlIlIlIIlIllIlIlIll) >= llllllllllllIIlIlIlIIlIllIlIllII) {
            return 0.0f;
        }
        return llllllllllllIIlIlIlIIlIllIlIlIlI * 0.5f;
    }
    
    boolean leafNodeNeedsBase(final int llllllllllllIIlIlIlIIlIlIlIIIlII) {
        return llllllllllllIIlIlIlIIlIlIlIIIlII >= this.heightLimit * 0.2;
    }
    
    @Override
    public boolean generate(final World llllllllllllIIlIlIlIIlIlIIIIIIll, final Random llllllllllllIIlIlIlIIlIIlllllllI, final BlockPos llllllllllllIIlIlIlIIlIlIIIIIIIl) {
        this.world = llllllllllllIIlIlIlIIlIlIIIIIIll;
        this.basePos = llllllllllllIIlIlIlIIlIlIIIIIIIl;
        this.rand = new Random(llllllllllllIIlIlIlIIlIIlllllllI.nextLong());
        if (this.heightLimit == 0) {
            this.heightLimit = 5 + this.rand.nextInt(this.heightLimitLimit);
        }
        if (!this.validTreeLocation()) {
            return false;
        }
        this.generateLeafNodeList();
        this.generateLeaves();
        this.generateTrunk();
        this.generateLeafNodeBases();
        return true;
    }
    
    private int getGreatestDistance(final BlockPos llllllllllllIIlIlIlIIlIlIllIlIII) {
        final int llllllllllllIIlIlIlIIlIlIllIlIll = MathHelper.abs(llllllllllllIIlIlIlIIlIlIllIlIII.getX());
        final int llllllllllllIIlIlIlIIlIlIllIlIlI = MathHelper.abs(llllllllllllIIlIlIlIIlIlIllIlIII.getY());
        final int llllllllllllIIlIlIlIIlIlIllIlIIl = MathHelper.abs(llllllllllllIIlIlIlIIlIlIllIlIII.getZ());
        if (llllllllllllIIlIlIlIIlIlIllIlIIl > llllllllllllIIlIlIlIIlIlIllIlIll && llllllllllllIIlIlIlIIlIlIllIlIIl > llllllllllllIIlIlIlIIlIlIllIlIlI) {
            return llllllllllllIIlIlIlIIlIlIllIlIIl;
        }
        return (llllllllllllIIlIlIlIIlIlIllIlIlI > llllllllllllIIlIlIlIIlIlIllIlIll) ? llllllllllllIIlIlIlIIlIlIllIlIlI : llllllllllllIIlIlIlIIlIlIllIlIll;
    }
    
    private boolean validTreeLocation() {
        final Block llllllllllllIIlIlIlIIlIIlllllIII = this.world.getBlockState(this.basePos.down()).getBlock();
        if (llllllllllllIIlIlIlIIlIIlllllIII != Blocks.DIRT && llllllllllllIIlIlIlIIlIIlllllIII != Blocks.GRASS && llllllllllllIIlIlIlIIlIIlllllIII != Blocks.FARMLAND) {
            return false;
        }
        final int llllllllllllIIlIlIlIIlIIllllIlll = this.checkBlockLine(this.basePos, this.basePos.up(this.heightLimit - 1));
        if (llllllllllllIIlIlIlIIlIIllllIlll == -1) {
            return true;
        }
        if (llllllllllllIIlIlIlIIlIIllllIlll < 6) {
            return false;
        }
        this.heightLimit = llllllllllllIIlIlIlIIlIIllllIlll;
        return true;
    }
    
    void generateLeafNode(final BlockPos llllllllllllIIlIlIlIIlIllIIlIlll) {
        for (int llllllllllllIIlIlIlIIlIllIIllIIl = 0; llllllllllllIIlIlIlIIlIllIIllIIl < this.leafDistanceLimit; ++llllllllllllIIlIlIlIIlIllIIllIIl) {
            this.crosSection(llllllllllllIIlIlIlIIlIllIIlIlll.up(llllllllllllIIlIlIlIIlIllIIllIIl), this.leafSize(llllllllllllIIlIlIlIIlIllIIllIIl), Blocks.LEAVES.getDefaultState().withProperty((IProperty<Comparable>)BlockLeaves.CHECK_DECAY, false));
        }
    }
    
    void generateLeaves() {
        for (final FoliageCoordinates llllllllllllIIlIlIlIIlIlIlIIllIl : this.foliageCoords) {
            this.generateLeafNode(llllllllllllIIlIlIlIIlIlIlIIllIl);
        }
    }
    
    void limb(final BlockPos llllllllllllIIlIlIlIIlIlIlllllII, final BlockPos llllllllllllIIlIlIlIIlIlIllllIll, final Block llllllllllllIIlIlIlIIlIllIIIIllI) {
        final BlockPos llllllllllllIIlIlIlIIlIllIIIIlIl = llllllllllllIIlIlIlIIlIlIllllIll.add(-llllllllllllIIlIlIlIIlIlIlllllII.getX(), -llllllllllllIIlIlIlIIlIlIlllllII.getY(), -llllllllllllIIlIlIlIIlIlIlllllII.getZ());
        final int llllllllllllIIlIlIlIIlIllIIIIlII = this.getGreatestDistance(llllllllllllIIlIlIlIIlIllIIIIlIl);
        final float llllllllllllIIlIlIlIIlIllIIIIIll = llllllllllllIIlIlIlIIlIllIIIIlIl.getX() / (float)llllllllllllIIlIlIlIIlIllIIIIlII;
        final float llllllllllllIIlIlIlIIlIllIIIIIlI = llllllllllllIIlIlIlIIlIllIIIIlIl.getY() / (float)llllllllllllIIlIlIlIIlIllIIIIlII;
        final float llllllllllllIIlIlIlIIlIllIIIIIIl = llllllllllllIIlIlIlIIlIllIIIIlIl.getZ() / (float)llllllllllllIIlIlIlIIlIllIIIIlII;
        for (int llllllllllllIIlIlIlIIlIllIIIIIII = 0; llllllllllllIIlIlIlIIlIllIIIIIII <= llllllllllllIIlIlIlIIlIllIIIIlII; ++llllllllllllIIlIlIlIIlIllIIIIIII) {
            final BlockPos llllllllllllIIlIlIlIIlIlIlllllll = llllllllllllIIlIlIlIIlIlIlllllII.add(0.5f + llllllllllllIIlIlIlIIlIllIIIIIII * llllllllllllIIlIlIlIIlIllIIIIIll, 0.5f + llllllllllllIIlIlIlIIlIllIIIIIII * llllllllllllIIlIlIlIIlIllIIIIIlI, 0.5f + llllllllllllIIlIlIlIIlIllIIIIIII * llllllllllllIIlIlIlIIlIllIIIIIIl);
            final BlockLog.EnumAxis llllllllllllIIlIlIlIIlIlIllllllI = this.getLogAxis(llllllllllllIIlIlIlIIlIlIlllllII, llllllllllllIIlIlIlIIlIlIlllllll);
            this.setBlockAndNotifyAdequately(this.world, llllllllllllIIlIlIlIIlIlIlllllll, llllllllllllIIlIlIlIIlIllIIIIllI.getDefaultState().withProperty(BlockLog.LOG_AXIS, llllllllllllIIlIlIlIIlIlIllllllI));
        }
    }
    
    int checkBlockLine(final BlockPos llllllllllllIIlIlIlIIlIlIIIlIlII, final BlockPos llllllllllllIIlIlIlIIlIlIIIlllIl) {
        final BlockPos llllllllllllIIlIlIlIIlIlIIIlllII = llllllllllllIIlIlIlIIlIlIIIlllIl.add(-llllllllllllIIlIlIlIIlIlIIIlIlII.getX(), -llllllllllllIIlIlIlIIlIlIIIlIlII.getY(), -llllllllllllIIlIlIlIIlIlIIIlIlII.getZ());
        final int llllllllllllIIlIlIlIIlIlIIIllIll = this.getGreatestDistance(llllllllllllIIlIlIlIIlIlIIIlllII);
        final float llllllllllllIIlIlIlIIlIlIIIllIlI = llllllllllllIIlIlIlIIlIlIIIlllII.getX() / (float)llllllllllllIIlIlIlIIlIlIIIllIll;
        final float llllllllllllIIlIlIlIIlIlIIIllIIl = llllllllllllIIlIlIlIIlIlIIIlllII.getY() / (float)llllllllllllIIlIlIlIIlIlIIIllIll;
        final float llllllllllllIIlIlIlIIlIlIIIllIII = llllllllllllIIlIlIlIIlIlIIIlllII.getZ() / (float)llllllllllllIIlIlIlIIlIlIIIllIll;
        if (llllllllllllIIlIlIlIIlIlIIIllIll == 0) {
            return -1;
        }
        for (int llllllllllllIIlIlIlIIlIlIIIlIlll = 0; llllllllllllIIlIlIlIIlIlIIIlIlll <= llllllllllllIIlIlIlIIlIlIIIllIll; ++llllllllllllIIlIlIlIIlIlIIIlIlll) {
            final BlockPos llllllllllllIIlIlIlIIlIlIIIlIllI = llllllllllllIIlIlIlIIlIlIIIlIlII.add(0.5f + llllllllllllIIlIlIlIIlIlIIIlIlll * llllllllllllIIlIlIlIIlIlIIIllIlI, 0.5f + llllllllllllIIlIlIlIIlIlIIIlIlll * llllllllllllIIlIlIlIIlIlIIIllIIl, 0.5f + llllllllllllIIlIlIlIIlIlIIIlIlll * llllllllllllIIlIlIlIIlIlIIIllIII);
            if (!this.canGrowInto(this.world.getBlockState(llllllllllllIIlIlIlIIlIlIIIlIllI).getBlock())) {
                return llllllllllllIIlIlIlIIlIlIIIlIlll;
            }
        }
        return -1;
    }
    
    void generateTrunk() {
        final BlockPos llllllllllllIIlIlIlIIlIlIIlllllI = this.basePos;
        final BlockPos llllllllllllIIlIlIlIIlIlIIllllIl = this.basePos.up(this.height);
        final Block llllllllllllIIlIlIlIIlIlIIllllII = Blocks.LOG;
        this.limb(llllllllllllIIlIlIlIIlIlIIlllllI, llllllllllllIIlIlIlIIlIlIIllllIl, llllllllllllIIlIlIlIIlIlIIllllII);
        if (this.trunkSize == 2) {
            this.limb(llllllllllllIIlIlIlIIlIlIIlllllI.east(), llllllllllllIIlIlIlIIlIlIIllllIl.east(), llllllllllllIIlIlIlIIlIlIIllllII);
            this.limb(llllllllllllIIlIlIlIIlIlIIlllllI.east().south(), llllllllllllIIlIlIlIIlIlIIllllIl.east().south(), llllllllllllIIlIlIlIIlIlIIllllII);
            this.limb(llllllllllllIIlIlIlIIlIlIIlllllI.south(), llllllllllllIIlIlIlIIlIlIIllllIl.south(), llllllllllllIIlIlIlIIlIlIIllllII);
        }
    }
    
    private BlockLog.EnumAxis getLogAxis(final BlockPos llllllllllllIIlIlIlIIlIlIlIlIlll, final BlockPos llllllllllllIIlIlIlIIlIlIlIlllII) {
        BlockLog.EnumAxis llllllllllllIIlIlIlIIlIlIlIllIll = BlockLog.EnumAxis.Y;
        final int llllllllllllIIlIlIlIIlIlIlIllIlI = Math.abs(llllllllllllIIlIlIlIIlIlIlIlllII.getX() - llllllllllllIIlIlIlIIlIlIlIlIlll.getX());
        final int llllllllllllIIlIlIlIIlIlIlIllIIl = Math.abs(llllllllllllIIlIlIlIIlIlIlIlllII.getZ() - llllllllllllIIlIlIlIIlIlIlIlIlll.getZ());
        final int llllllllllllIIlIlIlIIlIlIlIllIII = Math.max(llllllllllllIIlIlIlIIlIlIlIllIlI, llllllllllllIIlIlIlIIlIlIlIllIIl);
        if (llllllllllllIIlIlIlIIlIlIlIllIII > 0) {
            if (llllllllllllIIlIlIlIIlIlIlIllIlI == llllllllllllIIlIlIlIIlIlIlIllIII) {
                llllllllllllIIlIlIlIIlIlIlIllIll = BlockLog.EnumAxis.X;
            }
            else if (llllllllllllIIlIlIlIIlIlIlIllIIl == llllllllllllIIlIlIlIIlIlIlIllIII) {
                llllllllllllIIlIlIlIIlIlIlIllIll = BlockLog.EnumAxis.Z;
            }
        }
        return llllllllllllIIlIlIlIIlIlIlIllIll;
    }
    
    void generateLeafNodeList() {
        this.height = (int)(this.heightLimit * this.heightAttenuation);
        if (this.height >= this.heightLimit) {
            this.height = this.heightLimit - 1;
        }
        int llllllllllllIIlIlIlIIlIllllIllll = (int)(1.382 + Math.pow(this.leafDensity * this.heightLimit / 13.0, 2.0));
        if (llllllllllllIIlIlIlIIlIllllIllll < 1) {
            llllllllllllIIlIlIlIIlIllllIllll = 1;
        }
        final int llllllllllllIIlIlIlIIlIllllIlllI = this.basePos.getY() + this.height;
        int llllllllllllIIlIlIlIIlIllllIllIl = this.heightLimit - this.leafDistanceLimit;
        this.foliageCoords = (List<FoliageCoordinates>)Lists.newArrayList();
        this.foliageCoords.add(new FoliageCoordinates(this.basePos.up(llllllllllllIIlIlIlIIlIllllIllIl), llllllllllllIIlIlIlIIlIllllIlllI));
        while (llllllllllllIIlIlIlIIlIllllIllIl >= 0) {
            final float llllllllllllIIlIlIlIIlIllllIllII = this.layerSize(llllllllllllIIlIlIlIIlIllllIllIl);
            if (llllllllllllIIlIlIlIIlIllllIllII >= 0.0f) {
                for (int llllllllllllIIlIlIlIIlIllllIlIll = 0; llllllllllllIIlIlIlIIlIllllIlIll < llllllllllllIIlIlIlIIlIllllIllll; ++llllllllllllIIlIlIlIIlIllllIlIll) {
                    final double llllllllllllIIlIlIlIIlIllllIlIlI = this.scaleWidth * llllllllllllIIlIlIlIIlIllllIllII * (this.rand.nextFloat() + 0.328);
                    final double llllllllllllIIlIlIlIIlIllllIlIIl = this.rand.nextFloat() * 2.0f * 3.141592653589793;
                    final double llllllllllllIIlIlIlIIlIllllIlIII = llllllllllllIIlIlIlIIlIllllIlIlI * Math.sin(llllllllllllIIlIlIlIIlIllllIlIIl) + 0.5;
                    final double llllllllllllIIlIlIlIIlIllllIIlll = llllllllllllIIlIlIlIIlIllllIlIlI * Math.cos(llllllllllllIIlIlIlIIlIllllIlIIl) + 0.5;
                    final BlockPos llllllllllllIIlIlIlIIlIllllIIllI = this.basePos.add(llllllllllllIIlIlIlIIlIllllIlIII, llllllllllllIIlIlIlIIlIllllIllIl - 1, llllllllllllIIlIlIlIIlIllllIIlll);
                    final BlockPos llllllllllllIIlIlIlIIlIllllIIlIl = llllllllllllIIlIlIlIIlIllllIIllI.up(this.leafDistanceLimit);
                    if (this.checkBlockLine(llllllllllllIIlIlIlIIlIllllIIllI, llllllllllllIIlIlIlIIlIllllIIlIl) == -1) {
                        final int llllllllllllIIlIlIlIIlIllllIIlII = this.basePos.getX() - llllllllllllIIlIlIlIIlIllllIIllI.getX();
                        final int llllllllllllIIlIlIlIIlIllllIIIll = this.basePos.getZ() - llllllllllllIIlIlIlIIlIllllIIllI.getZ();
                        final double llllllllllllIIlIlIlIIlIllllIIIlI = llllllllllllIIlIlIlIIlIllllIIllI.getY() - Math.sqrt(llllllllllllIIlIlIlIIlIllllIIlII * llllllllllllIIlIlIlIIlIllllIIlII + llllllllllllIIlIlIlIIlIllllIIIll * llllllllllllIIlIlIlIIlIllllIIIll) * this.branchSlope;
                        final int llllllllllllIIlIlIlIIlIllllIIIIl = (llllllllllllIIlIlIlIIlIllllIIIlI > llllllllllllIIlIlIlIIlIllllIlllI) ? llllllllllllIIlIlIlIIlIllllIlllI : ((int)llllllllllllIIlIlIlIIlIllllIIIlI);
                        final BlockPos llllllllllllIIlIlIlIIlIllllIIIII = new BlockPos(this.basePos.getX(), llllllllllllIIlIlIlIIlIllllIIIIl, this.basePos.getZ());
                        if (this.checkBlockLine(llllllllllllIIlIlIlIIlIllllIIIII, llllllllllllIIlIlIlIIlIllllIIllI) == -1) {
                            this.foliageCoords.add(new FoliageCoordinates(llllllllllllIIlIlIlIIlIllllIIllI, llllllllllllIIlIlIlIIlIllllIIIII.getY()));
                        }
                    }
                }
            }
            --llllllllllllIIlIlIlIIlIllllIllIl;
        }
    }
    
    float leafSize(final int llllllllllllIIlIlIlIIlIllIlIIIIl) {
        if (llllllllllllIIlIlIlIIlIllIlIIIIl >= 0 && llllllllllllIIlIlIlIIlIllIlIIIIl < this.leafDistanceLimit) {
            return (llllllllllllIIlIlIlIIlIllIlIIIIl != 0 && llllllllllllIIlIlIlIIlIllIlIIIIl != this.leafDistanceLimit - 1) ? 3.0f : 2.0f;
        }
        return -1.0f;
    }
    
    void generateLeafNodeBases() {
        for (final FoliageCoordinates llllllllllllIIlIlIlIIlIlIIllIIIl : this.foliageCoords) {
            final int llllllllllllIIlIlIlIIlIlIIllIIII = llllllllllllIIlIlIlIIlIlIIllIIIl.getBranchBase();
            final BlockPos llllllllllllIIlIlIlIIlIlIIlIllll = new BlockPos(this.basePos.getX(), llllllllllllIIlIlIlIIlIlIIllIIII, this.basePos.getZ());
            if (!llllllllllllIIlIlIlIIlIlIIlIllll.equals(llllllllllllIIlIlIlIIlIlIIllIIIl) && this.leafNodeNeedsBase(llllllllllllIIlIlIlIIlIlIIllIIII - this.basePos.getY())) {
                this.limb(llllllllllllIIlIlIlIIlIlIIlIllll, llllllllllllIIlIlIlIIlIlIIllIIIl, Blocks.LOG);
            }
        }
    }
    
    public WorldGenBigTree(final boolean llllllllllllIIlIlIlIIllIIIIIIIlI) {
        super(llllllllllllIIlIlIlIIllIIIIIIIlI);
        this.basePos = BlockPos.ORIGIN;
        this.heightAttenuation = 0.618;
        this.branchSlope = 0.381;
        this.scaleWidth = 1.0;
        this.leafDensity = 1.0;
        this.trunkSize = 1;
        this.heightLimitLimit = 12;
        this.leafDistanceLimit = 4;
    }
    
    static class FoliageCoordinates extends BlockPos
    {
        private final /* synthetic */ int branchBase;
        
        public int getBranchBase() {
            return this.branchBase;
        }
        
        public FoliageCoordinates(final BlockPos llllllllllIlllIlIIIIllIlIllIIIll, final int llllllllllIlllIlIIIIllIlIlIlllll) {
            super(llllllllllIlllIlIIIIllIlIllIIIll.getX(), llllllllllIlllIlIIIIllIlIllIIIll.getY(), llllllllllIlllIlIIIIllIlIllIIIll.getZ());
            this.branchBase = llllllllllIlllIlIIIIllIlIlIlllll;
        }
    }
}
