// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block.state;

import java.util.Collection;
import com.google.common.collect.Lists;
import net.minecraft.block.Block;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.init.Blocks;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.material.Material;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import java.util.List;

public class BlockPistonStructureHelper
{
    private final /* synthetic */ List<BlockPos> toDestroy;
    private final /* synthetic */ BlockPos pistonPos;
    private final /* synthetic */ World world;
    private final /* synthetic */ BlockPos blockToMove;
    private final /* synthetic */ List<BlockPos> toMove;
    private final /* synthetic */ EnumFacing moveDirection;
    
    private boolean addBlockLine(final BlockPos lllllllllllIllIIIllIIlIlIllIlIlI, final EnumFacing lllllllllllIllIIIllIIlIlIlIllIll) {
        IBlockState lllllllllllIllIIIllIIlIlIllIlIII = this.world.getBlockState(lllllllllllIllIIIllIIlIlIllIlIlI);
        Block lllllllllllIllIIIllIIlIlIllIIlll = lllllllllllIllIIIllIIlIlIllIlIII.getBlock();
        if (lllllllllllIllIIIllIIlIlIllIlIII.getMaterial() == Material.AIR) {
            return true;
        }
        if (!BlockPistonBase.canPush(lllllllllllIllIIIllIIlIlIllIlIII, this.world, lllllllllllIllIIIllIIlIlIllIlIlI, this.moveDirection, false, lllllllllllIllIIIllIIlIlIlIllIll)) {
            return true;
        }
        if (lllllllllllIllIIIllIIlIlIllIlIlI.equals(this.pistonPos)) {
            return true;
        }
        if (this.toMove.contains(lllllllllllIllIIIllIIlIlIllIlIlI)) {
            return true;
        }
        int lllllllllllIllIIIllIIlIlIllIIllI = 1;
        if (lllllllllllIllIIIllIIlIlIllIIllI + this.toMove.size() > 12) {
            return false;
        }
        while (lllllllllllIllIIIllIIlIlIllIIlll == Blocks.SLIME_BLOCK) {
            final BlockPos lllllllllllIllIIIllIIlIlIllIIlIl = lllllllllllIllIIIllIIlIlIllIlIlI.offset(this.moveDirection.getOpposite(), lllllllllllIllIIIllIIlIlIllIIllI);
            lllllllllllIllIIIllIIlIlIllIlIII = this.world.getBlockState(lllllllllllIllIIIllIIlIlIllIIlIl);
            lllllllllllIllIIIllIIlIlIllIIlll = lllllllllllIllIIIllIIlIlIllIlIII.getBlock();
            if (lllllllllllIllIIIllIIlIlIllIlIII.getMaterial() == Material.AIR || !BlockPistonBase.canPush(lllllllllllIllIIIllIIlIlIllIlIII, this.world, lllllllllllIllIIIllIIlIlIllIIlIl, this.moveDirection, false, this.moveDirection.getOpposite())) {
                break;
            }
            if (lllllllllllIllIIIllIIlIlIllIIlIl.equals(this.pistonPos)) {
                break;
            }
            if (++lllllllllllIllIIIllIIlIlIllIIllI + this.toMove.size() > 12) {
                return false;
            }
        }
        int lllllllllllIllIIIllIIlIlIllIIlII = 0;
        for (int lllllllllllIllIIIllIIlIlIllIIIll = lllllllllllIllIIIllIIlIlIllIIllI - 1; lllllllllllIllIIIllIIlIlIllIIIll >= 0; --lllllllllllIllIIIllIIlIlIllIIIll) {
            this.toMove.add(lllllllllllIllIIIllIIlIlIllIlIlI.offset(this.moveDirection.getOpposite(), lllllllllllIllIIIllIIlIlIllIIIll));
            ++lllllllllllIllIIIllIIlIlIllIIlII;
        }
        int lllllllllllIllIIIllIIlIlIllIIIlI = 1;
        while (true) {
            final BlockPos lllllllllllIllIIIllIIlIlIllIIIIl = lllllllllllIllIIIllIIlIlIllIlIlI.offset(this.moveDirection, lllllllllllIllIIIllIIlIlIllIIIlI);
            final int lllllllllllIllIIIllIIlIlIllIIIII = this.toMove.indexOf(lllllllllllIllIIIllIIlIlIllIIIIl);
            if (lllllllllllIllIIIllIIlIlIllIIIII > -1) {
                this.reorderListAtCollision(lllllllllllIllIIIllIIlIlIllIIlII, lllllllllllIllIIIllIIlIlIllIIIII);
                for (int lllllllllllIllIIIllIIlIlIlIlllll = 0; lllllllllllIllIIIllIIlIlIlIlllll <= lllllllllllIllIIIllIIlIlIllIIIII + lllllllllllIllIIIllIIlIlIllIIlII; ++lllllllllllIllIIIllIIlIlIlIlllll) {
                    final BlockPos lllllllllllIllIIIllIIlIlIlIllllI = this.toMove.get(lllllllllllIllIIIllIIlIlIlIlllll);
                    if (this.world.getBlockState(lllllllllllIllIIIllIIlIlIlIllllI).getBlock() == Blocks.SLIME_BLOCK && !this.addBranchingBlocks(lllllllllllIllIIIllIIlIlIlIllllI)) {
                        return false;
                    }
                }
                return true;
            }
            lllllllllllIllIIIllIIlIlIllIlIII = this.world.getBlockState(lllllllllllIllIIIllIIlIlIllIIIIl);
            if (lllllllllllIllIIIllIIlIlIllIlIII.getMaterial() == Material.AIR) {
                return true;
            }
            if (!BlockPistonBase.canPush(lllllllllllIllIIIllIIlIlIllIlIII, this.world, lllllllllllIllIIIllIIlIlIllIIIIl, this.moveDirection, true, this.moveDirection) || lllllllllllIllIIIllIIlIlIllIIIIl.equals(this.pistonPos)) {
                return false;
            }
            if (lllllllllllIllIIIllIIlIlIllIlIII.getMobilityFlag() == EnumPushReaction.DESTROY) {
                this.toDestroy.add(lllllllllllIllIIIllIIlIlIllIIIIl);
                return true;
            }
            if (this.toMove.size() >= 12) {
                return false;
            }
            this.toMove.add(lllllllllllIllIIIllIIlIlIllIIIIl);
            ++lllllllllllIllIIIllIIlIlIllIIlII;
            ++lllllllllllIllIIIllIIlIlIllIIIlI;
        }
    }
    
    private boolean addBranchingBlocks(final BlockPos lllllllllllIllIIIllIIlIlIIlllIII) {
        short lllllllllllIllIIIllIIlIlIIllIIIl;
        for (int lllllllllllIllIIIllIIlIlIIllIIlI = ((EnumFacing[])(Object)(lllllllllllIllIIIllIIlIlIIllIIIl = (short)(Object)EnumFacing.values())).length, lllllllllllIllIIIllIIlIlIIllIIll = 0; lllllllllllIllIIIllIIlIlIIllIIll < lllllllllllIllIIIllIIlIlIIllIIlI; ++lllllllllllIllIIIllIIlIlIIllIIll) {
            final EnumFacing lllllllllllIllIIIllIIlIlIIllIlll = lllllllllllIllIIIllIIlIlIIllIIIl[lllllllllllIllIIIllIIlIlIIllIIll];
            if (lllllllllllIllIIIllIIlIlIIllIlll.getAxis() != this.moveDirection.getAxis() && !this.addBlockLine(lllllllllllIllIIIllIIlIlIIlllIII.offset(lllllllllllIllIIIllIIlIlIIllIlll), lllllllllllIllIIIllIIlIlIIllIlll)) {
                return false;
            }
        }
        return true;
    }
    
    public List<BlockPos> getBlocksToDestroy() {
        return this.toDestroy;
    }
    
    private void reorderListAtCollision(final int lllllllllllIllIIIllIIlIlIlIIIlII, final int lllllllllllIllIIIllIIlIlIlIIlIIl) {
        final List<BlockPos> lllllllllllIllIIIllIIlIlIlIIlIII = (List<BlockPos>)Lists.newArrayList();
        final List<BlockPos> lllllllllllIllIIIllIIlIlIlIIIlll = (List<BlockPos>)Lists.newArrayList();
        final List<BlockPos> lllllllllllIllIIIllIIlIlIlIIIllI = (List<BlockPos>)Lists.newArrayList();
        lllllllllllIllIIIllIIlIlIlIIlIII.addAll(this.toMove.subList(0, lllllllllllIllIIIllIIlIlIlIIlIIl));
        lllllllllllIllIIIllIIlIlIlIIIlll.addAll(this.toMove.subList(this.toMove.size() - lllllllllllIllIIIllIIlIlIlIIIlII, this.toMove.size()));
        lllllllllllIllIIIllIIlIlIlIIIllI.addAll(this.toMove.subList(lllllllllllIllIIIllIIlIlIlIIlIIl, this.toMove.size() - lllllllllllIllIIIllIIlIlIlIIIlII));
        this.toMove.clear();
        this.toMove.addAll(lllllllllllIllIIIllIIlIlIlIIlIII);
        this.toMove.addAll(lllllllllllIllIIIllIIlIlIlIIIlll);
        this.toMove.addAll(lllllllllllIllIIIllIIlIlIlIIIllI);
    }
    
    public List<BlockPos> getBlocksToMove() {
        return this.toMove;
    }
    
    public BlockPistonStructureHelper(final World lllllllllllIllIIIllIIlIllIIIIlll, final BlockPos lllllllllllIllIIIllIIlIllIIIlIll, final EnumFacing lllllllllllIllIIIllIIlIllIIIIlIl, final boolean lllllllllllIllIIIllIIlIllIIIlIIl) {
        this.toMove = (List<BlockPos>)Lists.newArrayList();
        this.toDestroy = (List<BlockPos>)Lists.newArrayList();
        this.world = lllllllllllIllIIIllIIlIllIIIIlll;
        this.pistonPos = lllllllllllIllIIIllIIlIllIIIlIll;
        if (lllllllllllIllIIIllIIlIllIIIlIIl) {
            this.moveDirection = lllllllllllIllIIIllIIlIllIIIIlIl;
            this.blockToMove = lllllllllllIllIIIllIIlIllIIIlIll.offset(lllllllllllIllIIIllIIlIllIIIIlIl);
        }
        else {
            this.moveDirection = lllllllllllIllIIIllIIlIllIIIIlIl.getOpposite();
            this.blockToMove = lllllllllllIllIIIllIIlIllIIIlIll.offset(lllllllllllIllIIIllIIlIllIIIIlIl, 2);
        }
    }
    
    public boolean canMove() {
        this.toMove.clear();
        this.toDestroy.clear();
        final IBlockState lllllllllllIllIIIllIIlIlIllllllI = this.world.getBlockState(this.blockToMove);
        if (!BlockPistonBase.canPush(lllllllllllIllIIIllIIlIlIllllllI, this.world, this.blockToMove, this.moveDirection, false, this.moveDirection)) {
            if (lllllllllllIllIIIllIIlIlIllllllI.getMobilityFlag() == EnumPushReaction.DESTROY) {
                this.toDestroy.add(this.blockToMove);
                return true;
            }
            return false;
        }
        else {
            if (!this.addBlockLine(this.blockToMove, this.moveDirection)) {
                return false;
            }
            for (int lllllllllllIllIIIllIIlIlIlllllIl = 0; lllllllllllIllIIIllIIlIlIlllllIl < this.toMove.size(); ++lllllllllllIllIIIllIIlIlIlllllIl) {
                final BlockPos lllllllllllIllIIIllIIlIlIlllllII = this.toMove.get(lllllllllllIllIIIllIIlIlIlllllIl);
                if (this.world.getBlockState(lllllllllllIllIIIllIIlIlIlllllII).getBlock() == Blocks.SLIME_BLOCK && !this.addBranchingBlocks(lllllllllllIllIIIllIIlIlIlllllII)) {
                    return false;
                }
            }
            return true;
        }
    }
}
