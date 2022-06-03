// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.pathfinding;

import javax.annotation.Nullable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockWall;
import net.minecraft.block.BlockFence;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockDoor;
import net.minecraft.util.EnumFacing;
import java.util.Set;
import com.google.common.collect.Sets;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.EntityLiving;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.block.BlockRailBase;
import net.minecraft.util.math.BlockPos;
import java.util.EnumSet;
import net.minecraft.world.IBlockAccess;

public class WalkNodeProcessor extends NodeProcessor
{
    protected /* synthetic */ float avoidsWater;
    
    public PathNodeType func_193577_a(final IBlockAccess llllllllllllllIIlIlllIlllIIIllII, final int llllllllllllllIIlIlllIlllIIIlIll, final int llllllllllllllIIlIlllIlllIIllllI, final int llllllllllllllIIlIlllIlllIIlllIl, final int llllllllllllllIIlIlllIlllIIIlIII, final int llllllllllllllIIlIlllIlllIIIIlll, final int llllllllllllllIIlIlllIlllIIllIlI, final boolean llllllllllllllIIlIlllIlllIIllIIl, final boolean llllllllllllllIIlIlllIlllIIIIlII, final EnumSet<PathNodeType> llllllllllllllIIlIlllIlllIIlIlll, PathNodeType llllllllllllllIIlIlllIlllIIIIIlI, final BlockPos llllllllllllllIIlIlllIlllIIlIlIl) {
        for (int llllllllllllllIIlIlllIlllIIlIlII = 0; llllllllllllllIIlIlllIlllIIlIlII < llllllllllllllIIlIlllIlllIIIlIII; ++llllllllllllllIIlIlllIlllIIlIlII) {
            for (int llllllllllllllIIlIlllIlllIIlIIll = 0; llllllllllllllIIlIlllIlllIIlIIll < llllllllllllllIIlIlllIlllIIIIlll; ++llllllllllllllIIlIlllIlllIIlIIll) {
                for (int llllllllllllllIIlIlllIlllIIlIIlI = 0; llllllllllllllIIlIlllIlllIIlIIlI < llllllllllllllIIlIlllIlllIIllIlI; ++llllllllllllllIIlIlllIlllIIlIIlI) {
                    final int llllllllllllllIIlIlllIlllIIlIIIl = llllllllllllllIIlIlllIlllIIlIlII + llllllllllllllIIlIlllIlllIIIlIll;
                    final int llllllllllllllIIlIlllIlllIIlIIII = llllllllllllllIIlIlllIlllIIlIIll + llllllllllllllIIlIlllIlllIIllllI;
                    final int llllllllllllllIIlIlllIlllIIIllll = llllllllllllllIIlIlllIlllIIlIIlI + llllllllllllllIIlIlllIlllIIlllIl;
                    PathNodeType llllllllllllllIIlIlllIlllIIIlllI = this.getPathNodeType(llllllllllllllIIlIlllIlllIIIllII, llllllllllllllIIlIlllIlllIIlIIIl, llllllllllllllIIlIlllIlllIIlIIII, llllllllllllllIIlIlllIlllIIIllll);
                    if (llllllllllllllIIlIlllIlllIIIlllI == PathNodeType.DOOR_WOOD_CLOSED && llllllllllllllIIlIlllIlllIIllIIl && llllllllllllllIIlIlllIlllIIIIlII) {
                        llllllllllllllIIlIlllIlllIIIlllI = PathNodeType.WALKABLE;
                    }
                    if (llllllllllllllIIlIlllIlllIIIlllI == PathNodeType.DOOR_OPEN && !llllllllllllllIIlIlllIlllIIIIlII) {
                        llllllllllllllIIlIlllIlllIIIlllI = PathNodeType.BLOCKED;
                    }
                    if (llllllllllllllIIlIlllIlllIIIlllI == PathNodeType.RAIL && !(llllllllllllllIIlIlllIlllIIIllII.getBlockState(llllllllllllllIIlIlllIlllIIlIlIl).getBlock() instanceof BlockRailBase) && !(llllllllllllllIIlIlllIlllIIIllII.getBlockState(llllllllllllllIIlIlllIlllIIlIlIl.down()).getBlock() instanceof BlockRailBase)) {
                        llllllllllllllIIlIlllIlllIIIlllI = PathNodeType.FENCE;
                    }
                    if (llllllllllllllIIlIlllIlllIIlIlII == 0 && llllllllllllllIIlIlllIlllIIlIIll == 0 && llllllllllllllIIlIlllIlllIIlIIlI == 0) {
                        llllllllllllllIIlIlllIlllIIIIIlI = llllllllllllllIIlIlllIlllIIIlllI;
                    }
                    llllllllllllllIIlIlllIlllIIlIlll.add(llllllllllllllIIlIlllIlllIIIlllI);
                }
            }
        }
        return (PathNodeType)llllllllllllllIIlIlllIlllIIIIIlI;
    }
    
    public PathNodeType func_193578_a(final IBlockAccess llllllllllllllIIlIlllIllIIllllll, final int llllllllllllllIIlIlllIllIIllIlIl, final int llllllllllllllIIlIlllIllIIllllIl, final int llllllllllllllIIlIlllIllIIllllII, PathNodeType llllllllllllllIIlIlllIllIIllIIlI) {
        final BlockPos.PooledMutableBlockPos llllllllllllllIIlIlllIllIIlllIlI = BlockPos.PooledMutableBlockPos.retain();
        if (llllllllllllllIIlIlllIllIIllIIlI == PathNodeType.WALKABLE) {
            for (int llllllllllllllIIlIlllIllIIlllIIl = -1; llllllllllllllIIlIlllIllIIlllIIl <= 1; ++llllllllllllllIIlIlllIllIIlllIIl) {
                for (int llllllllllllllIIlIlllIllIIlllIII = -1; llllllllllllllIIlIlllIllIIlllIII <= 1; ++llllllllllllllIIlIlllIllIIlllIII) {
                    if (llllllllllllllIIlIlllIllIIlllIIl != 0 || llllllllllllllIIlIlllIllIIlllIII != 0) {
                        final Block llllllllllllllIIlIlllIllIIllIlll = llllllllllllllIIlIlllIllIIllllll.getBlockState(llllllllllllllIIlIlllIllIIlllIlI.setPos(llllllllllllllIIlIlllIllIIlllIIl + llllllllllllllIIlIlllIllIIllIlIl, llllllllllllllIIlIlllIllIIllllIl, llllllllllllllIIlIlllIllIIlllIII + llllllllllllllIIlIlllIllIIllllII)).getBlock();
                        if (llllllllllllllIIlIlllIllIIllIlll == Blocks.CACTUS) {
                            llllllllllllllIIlIlllIllIIllIIlI = PathNodeType.DANGER_CACTUS;
                        }
                        else if (llllllllllllllIIlIlllIllIIllIlll == Blocks.FIRE) {
                            llllllllllllllIIlIlllIllIIllIIlI = PathNodeType.DANGER_FIRE;
                        }
                    }
                }
            }
        }
        llllllllllllllIIlIlllIllIIlllIlI.release();
        return llllllllllllllIIlIlllIllIIllIIlI;
    }
    
    private PathNodeType getPathNodeType(final EntityLiving llllllllllllllIIlIlllIllIllIlIlI, final int llllllllllllllIIlIlllIllIllIlIIl, final int llllllllllllllIIlIlllIllIllIIIll, final int llllllllllllllIIlIlllIllIllIIlll) {
        return this.getPathNodeType(this.blockaccess, llllllllllllllIIlIlllIllIllIlIIl, llllllllllllllIIlIlllIllIllIIIll, llllllllllllllIIlIlllIllIllIIlll, llllllllllllllIIlIlllIllIllIlIlI, this.entitySizeX, this.entitySizeY, this.entitySizeZ, this.getCanBreakDoors(), this.getCanEnterDoors());
    }
    
    @Override
    public void postProcess() {
        this.entity.setPathPriority(PathNodeType.WATER, this.avoidsWater);
        super.postProcess();
    }
    
    private PathNodeType getPathNodeType(final EntityLiving llllllllllllllIIlIlllIllIlllIlIl, final BlockPos llllllllllllllIIlIlllIllIlllIlII) {
        return this.getPathNodeType(llllllllllllllIIlIlllIllIlllIlIl, llllllllllllllIIlIlllIllIlllIlII.getX(), llllllllllllllIIlIlllIllIlllIlII.getY(), llllllllllllllIIlIlllIllIlllIlII.getZ());
    }
    
    @Override
    public PathPoint getStart() {
        int llllllllllllllIIlIllllIIlIIIIIIl = 0;
        if (this.getCanSwim() && this.entity.isInWater()) {
            int llllllllllllllIIlIllllIIlIIIIIll = (int)this.entity.getEntityBoundingBox().minY;
            final BlockPos.MutableBlockPos llllllllllllllIIlIllllIIlIIIIIII = new BlockPos.MutableBlockPos(MathHelper.floor(this.entity.posX), llllllllllllllIIlIllllIIlIIIIIll, MathHelper.floor(this.entity.posZ));
            for (Block llllllllllllllIIlIllllIIIlllllll = this.blockaccess.getBlockState(llllllllllllllIIlIllllIIlIIIIIII).getBlock(); llllllllllllllIIlIllllIIIlllllll == Blocks.FLOWING_WATER || llllllllllllllIIlIllllIIIlllllll == Blocks.WATER; llllllllllllllIIlIllllIIIlllllll = this.blockaccess.getBlockState(llllllllllllllIIlIllllIIlIIIIIII).getBlock()) {
                ++llllllllllllllIIlIllllIIlIIIIIll;
                llllllllllllllIIlIllllIIlIIIIIII.setPos(MathHelper.floor(this.entity.posX), llllllllllllllIIlIllllIIlIIIIIll, MathHelper.floor(this.entity.posZ));
            }
        }
        else if (this.entity.onGround) {
            final int llllllllllllllIIlIllllIIlIIIIIlI = MathHelper.floor(this.entity.getEntityBoundingBox().minY + 0.5);
        }
        else {
            BlockPos llllllllllllllIIlIllllIIIllllllI;
            for (llllllllllllllIIlIllllIIIllllllI = new BlockPos(this.entity); (this.blockaccess.getBlockState(llllllllllllllIIlIllllIIIllllllI).getMaterial() == Material.AIR || this.blockaccess.getBlockState(llllllllllllllIIlIllllIIIllllllI).getBlock().isPassable(this.blockaccess, llllllllllllllIIlIllllIIIllllllI)) && llllllllllllllIIlIllllIIIllllllI.getY() > 0; llllllllllllllIIlIllllIIIllllllI = llllllllllllllIIlIllllIIIllllllI.down()) {}
            llllllllllllllIIlIllllIIlIIIIIIl = llllllllllllllIIlIllllIIIllllllI.up().getY();
        }
        final BlockPos llllllllllllllIIlIllllIIIlllllIl = new BlockPos(this.entity);
        final PathNodeType llllllllllllllIIlIllllIIIlllllII = this.getPathNodeType(this.entity, llllllllllllllIIlIllllIIIlllllIl.getX(), llllllllllllllIIlIllllIIlIIIIIIl, llllllllllllllIIlIllllIIIlllllIl.getZ());
        if (this.entity.getPathPriority(llllllllllllllIIlIllllIIIlllllII) < 0.0f) {
            final Set<BlockPos> llllllllllllllIIlIllllIIIllllIll = (Set<BlockPos>)Sets.newHashSet();
            llllllllllllllIIlIllllIIIllllIll.add(new BlockPos(this.entity.getEntityBoundingBox().minX, llllllllllllllIIlIllllIIlIIIIIIl, this.entity.getEntityBoundingBox().minZ));
            llllllllllllllIIlIllllIIIllllIll.add(new BlockPos(this.entity.getEntityBoundingBox().minX, llllllllllllllIIlIllllIIlIIIIIIl, this.entity.getEntityBoundingBox().maxZ));
            llllllllllllllIIlIllllIIIllllIll.add(new BlockPos(this.entity.getEntityBoundingBox().maxX, llllllllllllllIIlIllllIIlIIIIIIl, this.entity.getEntityBoundingBox().minZ));
            llllllllllllllIIlIllllIIIllllIll.add(new BlockPos(this.entity.getEntityBoundingBox().maxX, llllllllllllllIIlIllllIIlIIIIIIl, this.entity.getEntityBoundingBox().maxZ));
            for (final BlockPos llllllllllllllIIlIllllIIIllllIlI : llllllllllllllIIlIllllIIIllllIll) {
                final PathNodeType llllllllllllllIIlIllllIIIllllIIl = this.getPathNodeType(this.entity, llllllllllllllIIlIllllIIIllllIlI);
                if (this.entity.getPathPriority(llllllllllllllIIlIllllIIIllllIIl) >= 0.0f) {
                    return this.openPoint(llllllllllllllIIlIllllIIIllllIlI.getX(), llllllllllllllIIlIllllIIIllllIlI.getY(), llllllllllllllIIlIllllIIIllllIlI.getZ());
                }
            }
        }
        return this.openPoint(llllllllllllllIIlIllllIIIlllllIl.getX(), llllllllllllllIIlIllllIIlIIIIIIl, llllllllllllllIIlIllllIIIlllllIl.getZ());
    }
    
    @Override
    public PathPoint getPathPointToCoords(final double llllllllllllllIIlIllllIIIllIlIll, final double llllllllllllllIIlIllllIIIllIIllI, final double llllllllllllllIIlIllllIIIllIlIIl) {
        return this.openPoint(MathHelper.floor(llllllllllllllIIlIllllIIIllIlIll), MathHelper.floor(llllllllllllllIIlIllllIIIllIIllI), MathHelper.floor(llllllllllllllIIlIllllIIIllIlIIl));
    }
    
    @Override
    public int findPathOptions(final PathPoint[] llllllllllllllIIlIllllIIIlIlIIII, final PathPoint llllllllllllllIIlIllllIIIIlllIIl, final PathPoint llllllllllllllIIlIllllIIIlIIlllI, final float llllllllllllllIIlIllllIIIIllIlll) {
        int llllllllllllllIIlIllllIIIlIIllII = 0;
        int llllllllllllllIIlIllllIIIlIIlIll = 0;
        final PathNodeType llllllllllllllIIlIllllIIIlIIlIlI = this.getPathNodeType(this.entity, llllllllllllllIIlIllllIIIIlllIIl.xCoord, llllllllllllllIIlIllllIIIIlllIIl.yCoord + 1, llllllllllllllIIlIllllIIIIlllIIl.zCoord);
        if (this.entity.getPathPriority(llllllllllllllIIlIllllIIIlIIlIlI) >= 0.0f) {
            llllllllllllllIIlIllllIIIlIIlIll = MathHelper.floor(Math.max(1.0f, this.entity.stepHeight));
        }
        final BlockPos llllllllllllllIIlIllllIIIlIIlIIl = new BlockPos(llllllllllllllIIlIllllIIIIlllIIl.xCoord, llllllllllllllIIlIllllIIIIlllIIl.yCoord, llllllllllllllIIlIllllIIIIlllIIl.zCoord).down();
        final double llllllllllllllIIlIllllIIIlIIlIII = llllllllllllllIIlIllllIIIIlllIIl.yCoord - (1.0 - this.blockaccess.getBlockState(llllllllllllllIIlIllllIIIlIIlIIl).getBoundingBox(this.blockaccess, llllllllllllllIIlIllllIIIlIIlIIl).maxY);
        final PathPoint llllllllllllllIIlIllllIIIlIIIlll = this.getSafePoint(llllllllllllllIIlIllllIIIIlllIIl.xCoord, llllllllllllllIIlIllllIIIIlllIIl.yCoord, llllllllllllllIIlIllllIIIIlllIIl.zCoord + 1, llllllllllllllIIlIllllIIIlIIlIll, llllllllllllllIIlIllllIIIlIIlIII, EnumFacing.SOUTH);
        final PathPoint llllllllllllllIIlIllllIIIlIIIllI = this.getSafePoint(llllllllllllllIIlIllllIIIIlllIIl.xCoord - 1, llllllllllllllIIlIllllIIIIlllIIl.yCoord, llllllllllllllIIlIllllIIIIlllIIl.zCoord, llllllllllllllIIlIllllIIIlIIlIll, llllllllllllllIIlIllllIIIlIIlIII, EnumFacing.WEST);
        final PathPoint llllllllllllllIIlIllllIIIlIIIlIl = this.getSafePoint(llllllllllllllIIlIllllIIIIlllIIl.xCoord + 1, llllllllllllllIIlIllllIIIIlllIIl.yCoord, llllllllllllllIIlIllllIIIIlllIIl.zCoord, llllllllllllllIIlIllllIIIlIIlIll, llllllllllllllIIlIllllIIIlIIlIII, EnumFacing.EAST);
        final PathPoint llllllllllllllIIlIllllIIIlIIIlII = this.getSafePoint(llllllllllllllIIlIllllIIIIlllIIl.xCoord, llllllllllllllIIlIllllIIIIlllIIl.yCoord, llllllllllllllIIlIllllIIIIlllIIl.zCoord - 1, llllllllllllllIIlIllllIIIlIIlIll, llllllllllllllIIlIllllIIIlIIlIII, EnumFacing.NORTH);
        if (llllllllllllllIIlIllllIIIlIIIlll != null && !llllllllllllllIIlIllllIIIlIIIlll.visited && llllllllllllllIIlIllllIIIlIIIlll.distanceTo(llllllllllllllIIlIllllIIIlIIlllI) < llllllllllllllIIlIllllIIIIllIlll) {
            llllllllllllllIIlIllllIIIlIlIIII[llllllllllllllIIlIllllIIIlIIllII++] = llllllllllllllIIlIllllIIIlIIIlll;
        }
        if (llllllllllllllIIlIllllIIIlIIIllI != null && !llllllllllllllIIlIllllIIIlIIIllI.visited && llllllllllllllIIlIllllIIIlIIIllI.distanceTo(llllllllllllllIIlIllllIIIlIIlllI) < llllllllllllllIIlIllllIIIIllIlll) {
            llllllllllllllIIlIllllIIIlIlIIII[llllllllllllllIIlIllllIIIlIIllII++] = llllllllllllllIIlIllllIIIlIIIllI;
        }
        if (llllllllllllllIIlIllllIIIlIIIlIl != null && !llllllllllllllIIlIllllIIIlIIIlIl.visited && llllllllllllllIIlIllllIIIlIIIlIl.distanceTo(llllllllllllllIIlIllllIIIlIIlllI) < llllllllllllllIIlIllllIIIIllIlll) {
            llllllllllllllIIlIllllIIIlIlIIII[llllllllllllllIIlIllllIIIlIIllII++] = llllllllllllllIIlIllllIIIlIIIlIl;
        }
        if (llllllllllllllIIlIllllIIIlIIIlII != null && !llllllllllllllIIlIllllIIIlIIIlII.visited && llllllllllllllIIlIllllIIIlIIIlII.distanceTo(llllllllllllllIIlIllllIIIlIIlllI) < llllllllllllllIIlIllllIIIIllIlll) {
            llllllllllllllIIlIllllIIIlIlIIII[llllllllllllllIIlIllllIIIlIIllII++] = llllllllllllllIIlIllllIIIlIIIlII;
        }
        final boolean llllllllllllllIIlIllllIIIlIIIIll = llllllllllllllIIlIllllIIIlIIIlII == null || llllllllllllllIIlIllllIIIlIIIlII.nodeType == PathNodeType.OPEN || llllllllllllllIIlIllllIIIlIIIlII.costMalus != 0.0f;
        final boolean llllllllllllllIIlIllllIIIlIIIIlI = llllllllllllllIIlIllllIIIlIIIlll == null || llllllllllllllIIlIllllIIIlIIIlll.nodeType == PathNodeType.OPEN || llllllllllllllIIlIllllIIIlIIIlll.costMalus != 0.0f;
        final boolean llllllllllllllIIlIllllIIIlIIIIIl = llllllllllllllIIlIllllIIIlIIIlIl == null || llllllllllllllIIlIllllIIIlIIIlIl.nodeType == PathNodeType.OPEN || llllllllllllllIIlIllllIIIlIIIlIl.costMalus != 0.0f;
        final boolean llllllllllllllIIlIllllIIIlIIIIII = llllllllllllllIIlIllllIIIlIIIllI == null || llllllllllllllIIlIllllIIIlIIIllI.nodeType == PathNodeType.OPEN || llllllllllllllIIlIllllIIIlIIIllI.costMalus != 0.0f;
        if (llllllllllllllIIlIllllIIIlIIIIll && llllllllllllllIIlIllllIIIlIIIIII) {
            final PathPoint llllllllllllllIIlIllllIIIIllllll = this.getSafePoint(llllllllllllllIIlIllllIIIIlllIIl.xCoord - 1, llllllllllllllIIlIllllIIIIlllIIl.yCoord, llllllllllllllIIlIllllIIIIlllIIl.zCoord - 1, llllllllllllllIIlIllllIIIlIIlIll, llllllllllllllIIlIllllIIIlIIlIII, EnumFacing.NORTH);
            if (llllllllllllllIIlIllllIIIIllllll != null && !llllllllllllllIIlIllllIIIIllllll.visited && llllllllllllllIIlIllllIIIIllllll.distanceTo(llllllllllllllIIlIllllIIIlIIlllI) < llllllllllllllIIlIllllIIIIllIlll) {
                llllllllllllllIIlIllllIIIlIlIIII[llllllllllllllIIlIllllIIIlIIllII++] = llllllllllllllIIlIllllIIIIllllll;
            }
        }
        if (llllllllllllllIIlIllllIIIlIIIIll && llllllllllllllIIlIllllIIIlIIIIIl) {
            final PathPoint llllllllllllllIIlIllllIIIIlllllI = this.getSafePoint(llllllllllllllIIlIllllIIIIlllIIl.xCoord + 1, llllllllllllllIIlIllllIIIIlllIIl.yCoord, llllllllllllllIIlIllllIIIIlllIIl.zCoord - 1, llllllllllllllIIlIllllIIIlIIlIll, llllllllllllllIIlIllllIIIlIIlIII, EnumFacing.NORTH);
            if (llllllllllllllIIlIllllIIIIlllllI != null && !llllllllllllllIIlIllllIIIIlllllI.visited && llllllllllllllIIlIllllIIIIlllllI.distanceTo(llllllllllllllIIlIllllIIIlIIlllI) < llllllllllllllIIlIllllIIIIllIlll) {
                llllllllllllllIIlIllllIIIlIlIIII[llllllllllllllIIlIllllIIIlIIllII++] = llllllllllllllIIlIllllIIIIlllllI;
            }
        }
        if (llllllllllllllIIlIllllIIIlIIIIlI && llllllllllllllIIlIllllIIIlIIIIII) {
            final PathPoint llllllllllllllIIlIllllIIIIllllIl = this.getSafePoint(llllllllllllllIIlIllllIIIIlllIIl.xCoord - 1, llllllllllllllIIlIllllIIIIlllIIl.yCoord, llllllllllllllIIlIllllIIIIlllIIl.zCoord + 1, llllllllllllllIIlIllllIIIlIIlIll, llllllllllllllIIlIllllIIIlIIlIII, EnumFacing.SOUTH);
            if (llllllllllllllIIlIllllIIIIllllIl != null && !llllllllllllllIIlIllllIIIIllllIl.visited && llllllllllllllIIlIllllIIIIllllIl.distanceTo(llllllllllllllIIlIllllIIIlIIlllI) < llllllllllllllIIlIllllIIIIllIlll) {
                llllllllllllllIIlIllllIIIlIlIIII[llllllllllllllIIlIllllIIIlIIllII++] = llllllllllllllIIlIllllIIIIllllIl;
            }
        }
        if (llllllllllllllIIlIllllIIIlIIIIlI && llllllllllllllIIlIllllIIIlIIIIIl) {
            final PathPoint llllllllllllllIIlIllllIIIIllllII = this.getSafePoint(llllllllllllllIIlIllllIIIIlllIIl.xCoord + 1, llllllllllllllIIlIllllIIIIlllIIl.yCoord, llllllllllllllIIlIllllIIIIlllIIl.zCoord + 1, llllllllllllllIIlIllllIIIlIIlIll, llllllllllllllIIlIllllIIIlIIlIII, EnumFacing.SOUTH);
            if (llllllllllllllIIlIllllIIIIllllII != null && !llllllllllllllIIlIllllIIIIllllII.visited && llllllllllllllIIlIllllIIIIllllII.distanceTo(llllllllllllllIIlIllllIIIlIIlllI) < llllllllllllllIIlIllllIIIIllIlll) {
                llllllllllllllIIlIllllIIIlIlIIII[llllllllllllllIIlIllllIIIlIIllII++] = llllllllllllllIIlIllllIIIIllllII;
            }
        }
        return llllllllllllllIIlIllllIIIlIIllII;
    }
    
    protected PathNodeType getPathNodeTypeRaw(final IBlockAccess llllllllllllllIIlIlllIllIIIlllII, final int llllllllllllllIIlIlllIllIIlIIIll, final int llllllllllllllIIlIlllIllIIIllIlI, final int llllllllllllllIIlIlllIllIIIllIIl) {
        final BlockPos llllllllllllllIIlIlllIllIIlIIIII = new BlockPos(llllllllllllllIIlIlllIllIIlIIIll, llllllllllllllIIlIlllIllIIIllIlI, llllllllllllllIIlIlllIllIIIllIIl);
        final IBlockState llllllllllllllIIlIlllIllIIIlllll = llllllllllllllIIlIlllIllIIIlllII.getBlockState(llllllllllllllIIlIlllIllIIlIIIII);
        final Block llllllllllllllIIlIlllIllIIIllllI = llllllllllllllIIlIlllIllIIIlllll.getBlock();
        final Material llllllllllllllIIlIlllIllIIIlllIl = llllllllllllllIIlIlllIllIIIlllll.getMaterial();
        if (llllllllllllllIIlIlllIllIIIlllIl == Material.AIR) {
            return PathNodeType.OPEN;
        }
        if (llllllllllllllIIlIlllIllIIIllllI == Blocks.TRAPDOOR || llllllllllllllIIlIlllIllIIIllllI == Blocks.IRON_TRAPDOOR || llllllllllllllIIlIlllIllIIIllllI == Blocks.WATERLILY) {
            return PathNodeType.TRAPDOOR;
        }
        if (llllllllllllllIIlIlllIllIIIllllI == Blocks.FIRE) {
            return PathNodeType.DAMAGE_FIRE;
        }
        if (llllllllllllllIIlIlllIllIIIllllI == Blocks.CACTUS) {
            return PathNodeType.DAMAGE_CACTUS;
        }
        if (llllllllllllllIIlIlllIllIIIllllI instanceof BlockDoor && llllllllllllllIIlIlllIllIIIlllIl == Material.WOOD && !llllllllllllllIIlIlllIllIIIlllll.getValue((IProperty<Boolean>)BlockDoor.OPEN)) {
            return PathNodeType.DOOR_WOOD_CLOSED;
        }
        if (llllllllllllllIIlIlllIllIIIllllI instanceof BlockDoor && llllllllllllllIIlIlllIllIIIlllIl == Material.IRON && !llllllllllllllIIlIlllIllIIIlllll.getValue((IProperty<Boolean>)BlockDoor.OPEN)) {
            return PathNodeType.DOOR_IRON_CLOSED;
        }
        if (llllllllllllllIIlIlllIllIIIllllI instanceof BlockDoor && llllllllllllllIIlIlllIllIIIlllll.getValue((IProperty<Boolean>)BlockDoor.OPEN)) {
            return PathNodeType.DOOR_OPEN;
        }
        if (llllllllllllllIIlIlllIllIIIllllI instanceof BlockRailBase) {
            return PathNodeType.RAIL;
        }
        if (llllllllllllllIIlIlllIllIIIllllI instanceof BlockFence || llllllllllllllIIlIlllIllIIIllllI instanceof BlockWall || (llllllllllllllIIlIlllIllIIIllllI instanceof BlockFenceGate && !llllllllllllllIIlIlllIllIIIlllll.getValue((IProperty<Boolean>)BlockFenceGate.OPEN))) {
            return PathNodeType.FENCE;
        }
        if (llllllllllllllIIlIlllIllIIIlllIl == Material.WATER) {
            return PathNodeType.WATER;
        }
        if (llllllllllllllIIlIlllIllIIIlllIl == Material.LAVA) {
            return PathNodeType.LAVA;
        }
        return llllllllllllllIIlIlllIllIIIllllI.isPassable(llllllllllllllIIlIlllIllIIIlllII, llllllllllllllIIlIlllIllIIlIIIII) ? PathNodeType.OPEN : PathNodeType.BLOCKED;
    }
    
    @Override
    public PathNodeType getPathNodeType(final IBlockAccess llllllllllllllIIlIlllIllllIlIlll, final int llllllllllllllIIlIlllIllllIlIllI, final int llllllllllllllIIlIlllIllllIIIlII, final int llllllllllllllIIlIlllIllllIIIIll, final EntityLiving llllllllllllllIIlIlllIllllIlIIll, final int llllllllllllllIIlIlllIllllIlIIlI, final int llllllllllllllIIlIlllIllllIlIIIl, final int llllllllllllllIIlIlllIllllIlIIII, final boolean llllllllllllllIIlIlllIlllIlllllI, final boolean llllllllllllllIIlIlllIlllIllllIl) {
        final EnumSet<PathNodeType> llllllllllllllIIlIlllIllllIIllIl = EnumSet.noneOf(PathNodeType.class);
        PathNodeType llllllllllllllIIlIlllIllllIIllII = PathNodeType.BLOCKED;
        final double llllllllllllllIIlIlllIllllIIlIll = llllllllllllllIIlIlllIllllIlIIll.width / 2.0;
        final BlockPos llllllllllllllIIlIlllIllllIIlIlI = new BlockPos(llllllllllllllIIlIlllIllllIlIIll);
        llllllllllllllIIlIlllIllllIIllII = this.func_193577_a(llllllllllllllIIlIlllIllllIlIlll, llllllllllllllIIlIlllIllllIlIllI, llllllllllllllIIlIlllIllllIIIlII, llllllllllllllIIlIlllIllllIIIIll, llllllllllllllIIlIlllIllllIlIIlI, llllllllllllllIIlIlllIllllIlIIIl, llllllllllllllIIlIlllIllllIlIIII, llllllllllllllIIlIlllIlllIlllllI, llllllllllllllIIlIlllIlllIllllIl, llllllllllllllIIlIlllIllllIIllIl, llllllllllllllIIlIlllIllllIIllII, llllllllllllllIIlIlllIllllIIlIlI);
        if (llllllllllllllIIlIlllIllllIIllIl.contains(PathNodeType.FENCE)) {
            return PathNodeType.FENCE;
        }
        PathNodeType llllllllllllllIIlIlllIllllIIlIIl = PathNodeType.BLOCKED;
        for (final PathNodeType llllllllllllllIIlIlllIllllIIlIII : llllllllllllllIIlIlllIllllIIllIl) {
            if (llllllllllllllIIlIlllIllllIlIIll.getPathPriority(llllllllllllllIIlIlllIllllIIlIII) < 0.0f) {
                return llllllllllllllIIlIlllIllllIIlIII;
            }
            if (llllllllllllllIIlIlllIllllIlIIll.getPathPriority(llllllllllllllIIlIlllIllllIIlIII) < llllllllllllllIIlIlllIllllIlIIll.getPathPriority(llllllllllllllIIlIlllIllllIIlIIl)) {
                continue;
            }
            llllllllllllllIIlIlllIllllIIlIIl = llllllllllllllIIlIlllIllllIIlIII;
        }
        if (llllllllllllllIIlIlllIllllIIllII == PathNodeType.OPEN && llllllllllllllIIlIlllIllllIlIIll.getPathPriority(llllllllllllllIIlIlllIllllIIlIIl) == 0.0f) {
            return PathNodeType.OPEN;
        }
        return llllllllllllllIIlIlllIllllIIlIIl;
    }
    
    @Override
    public PathNodeType getPathNodeType(final IBlockAccess llllllllllllllIIlIlllIllIlIlIIII, final int llllllllllllllIIlIlllIllIlIIllll, final int llllllllllllllIIlIlllIllIlIIlllI, final int llllllllllllllIIlIlllIllIlIIllIl) {
        PathNodeType llllllllllllllIIlIlllIllIlIlIlII = this.getPathNodeTypeRaw(llllllllllllllIIlIlllIllIlIlIIII, llllllllllllllIIlIlllIllIlIIllll, llllllllllllllIIlIlllIllIlIIlllI, llllllllllllllIIlIlllIllIlIIllIl);
        if (llllllllllllllIIlIlllIllIlIlIlII == PathNodeType.OPEN && llllllllllllllIIlIlllIllIlIIlllI >= 1) {
            final Block llllllllllllllIIlIlllIllIlIlIIll = llllllllllllllIIlIlllIllIlIlIIII.getBlockState(new BlockPos(llllllllllllllIIlIlllIllIlIIllll, llllllllllllllIIlIlllIllIlIIlllI - 1, llllllllllllllIIlIlllIllIlIIllIl)).getBlock();
            final PathNodeType llllllllllllllIIlIlllIllIlIlIIlI = this.getPathNodeTypeRaw(llllllllllllllIIlIlllIllIlIlIIII, llllllllllllllIIlIlllIllIlIIllll, llllllllllllllIIlIlllIllIlIIlllI - 1, llllllllllllllIIlIlllIllIlIIllIl);
            llllllllllllllIIlIlllIllIlIlIlII = ((llllllllllllllIIlIlllIllIlIlIIlI != PathNodeType.WALKABLE && llllllllllllllIIlIlllIllIlIlIIlI != PathNodeType.OPEN && llllllllllllllIIlIlllIllIlIlIIlI != PathNodeType.WATER && llllllllllllllIIlIlllIllIlIlIIlI != PathNodeType.LAVA) ? PathNodeType.WALKABLE : PathNodeType.OPEN);
            if (llllllllllllllIIlIlllIllIlIlIIlI == PathNodeType.DAMAGE_FIRE || llllllllllllllIIlIlllIllIlIlIIll == Blocks.MAGMA) {
                llllllllllllllIIlIlllIllIlIlIlII = PathNodeType.DAMAGE_FIRE;
            }
            if (llllllllllllllIIlIlllIllIlIlIIlI == PathNodeType.DAMAGE_CACTUS) {
                llllllllllllllIIlIlllIllIlIlIlII = PathNodeType.DAMAGE_CACTUS;
            }
        }
        llllllllllllllIIlIlllIllIlIlIlII = this.func_193578_a(llllllllllllllIIlIlllIllIlIlIIII, llllllllllllllIIlIlllIllIlIIllll, llllllllllllllIIlIlllIllIlIIlllI, llllllllllllllIIlIlllIllIlIIllIl, llllllllllllllIIlIlllIllIlIlIlII);
        return llllllllllllllIIlIlllIllIlIlIlII;
    }
    
    @Nullable
    private PathPoint getSafePoint(final int llllllllllllllIIlIlllIllllllllIl, int llllllllllllllIIlIllllIIIIIlIIlI, final int llllllllllllllIIlIlllIlllllllIll, final int llllllllllllllIIlIllllIIIIIlIIII, final double llllllllllllllIIlIlllIlllllllIIl, final EnumFacing llllllllllllllIIlIlllIlllllllIII) {
        PathPoint llllllllllllllIIlIllllIIIIIIllIl = null;
        final BlockPos llllllllllllllIIlIllllIIIIIIllII = new BlockPos(llllllllllllllIIlIlllIllllllllIl, llllllllllllllIIlIllllIIIIIlIIlI, llllllllllllllIIlIlllIlllllllIll);
        final BlockPos llllllllllllllIIlIllllIIIIIIlIll = llllllllllllllIIlIllllIIIIIIllII.down();
        final double llllllllllllllIIlIllllIIIIIIlIlI = llllllllllllllIIlIllllIIIIIlIIlI - (1.0 - this.blockaccess.getBlockState(llllllllllllllIIlIllllIIIIIIlIll).getBoundingBox(this.blockaccess, llllllllllllllIIlIllllIIIIIIlIll).maxY);
        if (llllllllllllllIIlIllllIIIIIIlIlI - llllllllllllllIIlIlllIlllllllIIl > 1.125) {
            return null;
        }
        PathNodeType llllllllllllllIIlIllllIIIIIIlIIl = this.getPathNodeType(this.entity, llllllllllllllIIlIlllIllllllllIl, llllllllllllllIIlIllllIIIIIlIIlI, llllllllllllllIIlIlllIlllllllIll);
        float llllllllllllllIIlIllllIIIIIIlIII = this.entity.getPathPriority(llllllllllllllIIlIllllIIIIIIlIIl);
        final double llllllllllllllIIlIllllIIIIIIIlll = this.entity.width / 2.0;
        if (llllllllllllllIIlIllllIIIIIIlIII >= 0.0f) {
            llllllllllllllIIlIllllIIIIIIllIl = this.openPoint(llllllllllllllIIlIlllIllllllllIl, llllllllllllllIIlIllllIIIIIlIIlI, llllllllllllllIIlIlllIlllllllIll);
            llllllllllllllIIlIllllIIIIIIllIl.nodeType = llllllllllllllIIlIllllIIIIIIlIIl;
            llllllllllllllIIlIllllIIIIIIllIl.costMalus = Math.max(llllllllllllllIIlIllllIIIIIIllIl.costMalus, llllllllllllllIIlIllllIIIIIIlIII);
        }
        if (llllllllllllllIIlIllllIIIIIIlIIl == PathNodeType.WALKABLE) {
            return llllllllllllllIIlIllllIIIIIIllIl;
        }
        if (llllllllllllllIIlIllllIIIIIIllIl == null && llllllllllllllIIlIllllIIIIIlIIII > 0 && llllllllllllllIIlIllllIIIIIIlIIl != PathNodeType.FENCE && llllllllllllllIIlIllllIIIIIIlIIl != PathNodeType.TRAPDOOR) {
            llllllllllllllIIlIllllIIIIIIllIl = this.getSafePoint(llllllllllllllIIlIlllIllllllllIl, llllllllllllllIIlIllllIIIIIlIIlI + 1, llllllllllllllIIlIlllIlllllllIll, llllllllllllllIIlIllllIIIIIlIIII - 1, llllllllllllllIIlIlllIlllllllIIl, llllllllllllllIIlIlllIlllllllIII);
            if (llllllllllllllIIlIllllIIIIIIllIl != null && (llllllllllllllIIlIllllIIIIIIllIl.nodeType == PathNodeType.OPEN || llllllllllllllIIlIllllIIIIIIllIl.nodeType == PathNodeType.WALKABLE) && this.entity.width < 1.0f) {
                final double llllllllllllllIIlIllllIIIIIIIllI = llllllllllllllIIlIlllIllllllllIl - llllllllllllllIIlIlllIlllllllIII.getFrontOffsetX() + 0.5;
                final double llllllllllllllIIlIllllIIIIIIIlIl = llllllllllllllIIlIlllIlllllllIll - llllllllllllllIIlIlllIlllllllIII.getFrontOffsetZ() + 0.5;
                final AxisAlignedBB llllllllllllllIIlIllllIIIIIIIlII = new AxisAlignedBB(llllllllllllllIIlIllllIIIIIIIllI - llllllllllllllIIlIllllIIIIIIIlll, llllllllllllllIIlIllllIIIIIlIIlI + 0.001, llllllllllllllIIlIllllIIIIIIIlIl - llllllllllllllIIlIllllIIIIIIIlll, llllllllllllllIIlIllllIIIIIIIllI + llllllllllllllIIlIllllIIIIIIIlll, llllllllllllllIIlIllllIIIIIlIIlI + this.entity.height, llllllllllllllIIlIllllIIIIIIIlIl + llllllllllllllIIlIllllIIIIIIIlll);
                final AxisAlignedBB llllllllllllllIIlIllllIIIIIIIIll = this.blockaccess.getBlockState(llllllllllllllIIlIllllIIIIIIllII).getBoundingBox(this.blockaccess, llllllllllllllIIlIllllIIIIIIllII);
                final AxisAlignedBB llllllllllllllIIlIllllIIIIIIIIlI = llllllllllllllIIlIllllIIIIIIIlII.addCoord(0.0, llllllllllllllIIlIllllIIIIIIIIll.maxY - 0.002, 0.0);
                if (this.entity.world.collidesWithAnyBlock(llllllllllllllIIlIllllIIIIIIIIlI)) {
                    llllllllllllllIIlIllllIIIIIIllIl = null;
                }
            }
        }
        if (llllllllllllllIIlIllllIIIIIIlIIl == PathNodeType.OPEN) {
            final AxisAlignedBB llllllllllllllIIlIllllIIIIIIIIIl = new AxisAlignedBB(llllllllllllllIIlIlllIllllllllIl - llllllllllllllIIlIllllIIIIIIIlll + 0.5, llllllllllllllIIlIllllIIIIIlIIlI + 0.001, llllllllllllllIIlIlllIlllllllIll - llllllllllllllIIlIllllIIIIIIIlll + 0.5, llllllllllllllIIlIlllIllllllllIl + llllllllllllllIIlIllllIIIIIIIlll + 0.5, llllllllllllllIIlIllllIIIIIlIIlI + this.entity.height, llllllllllllllIIlIlllIlllllllIll + llllllllllllllIIlIllllIIIIIIIlll + 0.5);
            if (this.entity.world.collidesWithAnyBlock(llllllllllllllIIlIllllIIIIIIIIIl)) {
                return null;
            }
            if (this.entity.width >= 1.0f) {
                final PathNodeType llllllllllllllIIlIllllIIIIIIIIII = this.getPathNodeType(this.entity, llllllllllllllIIlIlllIllllllllIl, llllllllllllllIIlIllllIIIIIlIIlI - 1, llllllllllllllIIlIlllIlllllllIll);
                if (llllllllllllllIIlIllllIIIIIIIIII == PathNodeType.BLOCKED) {
                    llllllllllllllIIlIllllIIIIIIllIl = this.openPoint(llllllllllllllIIlIlllIllllllllIl, llllllllllllllIIlIllllIIIIIlIIlI, llllllllllllllIIlIlllIlllllllIll);
                    llllllllllllllIIlIllllIIIIIIllIl.nodeType = PathNodeType.WALKABLE;
                    llllllllllllllIIlIllllIIIIIIllIl.costMalus = Math.max(llllllllllllllIIlIllllIIIIIIllIl.costMalus, llllllllllllllIIlIllllIIIIIIlIII);
                    return llllllllllllllIIlIllllIIIIIIllIl;
                }
            }
            int llllllllllllllIIlIlllIllllllllll = 0;
            while (llllllllllllllIIlIllllIIIIIlIIlI > 0 && llllllllllllllIIlIllllIIIIIIlIIl == PathNodeType.OPEN) {
                --llllllllllllllIIlIllllIIIIIlIIlI;
                if (llllllllllllllIIlIlllIllllllllll++ >= this.entity.getMaxFallHeight()) {
                    return null;
                }
                llllllllllllllIIlIllllIIIIIIlIIl = this.getPathNodeType(this.entity, llllllllllllllIIlIlllIllllllllIl, llllllllllllllIIlIllllIIIIIlIIlI, llllllllllllllIIlIlllIlllllllIll);
                llllllllllllllIIlIllllIIIIIIlIII = this.entity.getPathPriority(llllllllllllllIIlIllllIIIIIIlIIl);
                if (llllllllllllllIIlIllllIIIIIIlIIl != PathNodeType.OPEN && llllllllllllllIIlIllllIIIIIIlIII >= 0.0f) {
                    llllllllllllllIIlIllllIIIIIIllIl = this.openPoint(llllllllllllllIIlIlllIllllllllIl, llllllllllllllIIlIllllIIIIIlIIlI, llllllllllllllIIlIlllIlllllllIll);
                    llllllllllllllIIlIllllIIIIIIllIl.nodeType = llllllllllllllIIlIllllIIIIIIlIIl;
                    llllllllllllllIIlIllllIIIIIIllIl.costMalus = Math.max(llllllllllllllIIlIllllIIIIIIllIl.costMalus, llllllllllllllIIlIllllIIIIIIlIII);
                    break;
                }
                if (llllllllllllllIIlIllllIIIIIIlIII < 0.0f) {
                    return null;
                }
            }
        }
        return llllllllllllllIIlIllllIIIIIIllIl;
    }
    
    @Override
    public void initProcessor(final IBlockAccess llllllllllllllIIlIllllIIlIIlIIIl, final EntityLiving llllllllllllllIIlIllllIIlIIlIIII) {
        super.initProcessor(llllllllllllllIIlIllllIIlIIlIIIl, llllllllllllllIIlIllllIIlIIlIIII);
        this.avoidsWater = llllllllllllllIIlIllllIIlIIlIIII.getPathPriority(PathNodeType.WATER);
    }
}
