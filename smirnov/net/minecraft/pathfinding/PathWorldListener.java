// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.pathfinding;

import net.minecraft.util.SoundCategory;
import javax.annotation.Nullable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.SoundEvent;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.Entity;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.World;
import com.google.common.collect.Lists;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.player.EntityPlayer;
import java.util.List;
import net.minecraft.world.IWorldEventListener;

public class PathWorldListener implements IWorldEventListener
{
    private final /* synthetic */ List<PathNavigate> navigations;
    
    @Override
    public void playEvent(final EntityPlayer llllllllllllIlIIlIllIIllIlIlllIl, final int llllllllllllIlIIlIllIIllIlIlllII, final BlockPos llllllllllllIlIIlIllIIllIlIllIll, final int llllllllllllIlIIlIllIIllIlIllIlI) {
    }
    
    @Override
    public void spawnParticle(final int llllllllllllIlIIlIllIIlllIIIIlIl, final boolean llllllllllllIlIIlIllIIlllIIIIlII, final double llllllllllllIlIIlIllIIlllIIIIIll, final double llllllllllllIlIIlIllIIlllIIIIIlI, final double llllllllllllIlIIlIllIIlllIIIIIIl, final double llllllllllllIlIIlIllIIlllIIIIIII, final double llllllllllllIlIIlIllIIllIlllllll, final double llllllllllllIlIIlIllIIllIllllllI, final int... llllllllllllIlIIlIllIIllIlllllIl) {
    }
    
    public PathWorldListener() {
        this.navigations = (List<PathNavigate>)Lists.newArrayList();
    }
    
    @Override
    public void broadcastSound(final int llllllllllllIlIIlIllIIllIllIIIIl, final BlockPos llllllllllllIlIIlIllIIllIllIIIII, final int llllllllllllIlIIlIllIIllIlIlllll) {
    }
    
    @Override
    public void notifyBlockUpdate(final World llllllllllllIlIIlIllIIllllIIIIll, final BlockPos llllllllllllIlIIlIllIIlllIllIlIl, final IBlockState llllllllllllIlIIlIllIIlllIllIlII, final IBlockState llllllllllllIlIIlIllIIlllIllIIll, final int llllllllllllIlIIlIllIIlllIllllll) {
        if (this.didBlockChange(llllllllllllIlIIlIllIIllllIIIIll, llllllllllllIlIIlIllIIlllIllIlIl, llllllllllllIlIIlIllIIlllIllIlII, llllllllllllIlIIlIllIIlllIllIIll)) {
            for (int llllllllllllIlIIlIllIIlllIlllllI = 0, llllllllllllIlIIlIllIIlllIllllIl = this.navigations.size(); llllllllllllIlIIlIllIIlllIlllllI < llllllllllllIlIIlIllIIlllIllllIl; ++llllllllllllIlIIlIllIIlllIlllllI) {
                final PathNavigate llllllllllllIlIIlIllIIlllIllllII = this.navigations.get(llllllllllllIlIIlIllIIlllIlllllI);
                if (llllllllllllIlIIlIllIIlllIllllII != null && !llllllllllllIlIIlIllIIlllIllllII.canUpdatePathOnTimeout()) {
                    final Path llllllllllllIlIIlIllIIlllIlllIll = llllllllllllIlIIlIllIIlllIllllII.getPath();
                    if (llllllllllllIlIIlIllIIlllIlllIll != null && !llllllllllllIlIIlIllIIlllIlllIll.isFinished() && llllllllllllIlIIlIllIIlllIlllIll.getCurrentPathLength() != 0) {
                        final PathPoint llllllllllllIlIIlIllIIlllIlllIlI = llllllllllllIlIIlIllIIlllIllllII.currentPath.getFinalPathPoint();
                        final double llllllllllllIlIIlIllIIlllIlllIIl = llllllllllllIlIIlIllIIlllIllIlIl.distanceSq((llllllllllllIlIIlIllIIlllIlllIlI.xCoord + llllllllllllIlIIlIllIIlllIllllII.theEntity.posX) / 2.0, (llllllllllllIlIIlIllIIlllIlllIlI.yCoord + llllllllllllIlIIlIllIIlllIllllII.theEntity.posY) / 2.0, (llllllllllllIlIIlIllIIlllIlllIlI.zCoord + llllllllllllIlIIlIllIIlllIllllII.theEntity.posZ) / 2.0);
                        final int llllllllllllIlIIlIllIIlllIlllIII = (llllllllllllIlIIlIllIIlllIlllIll.getCurrentPathLength() - llllllllllllIlIIlIllIIlllIlllIll.getCurrentPathIndex()) * (llllllllllllIlIIlIllIIlllIlllIll.getCurrentPathLength() - llllllllllllIlIIlIllIIlllIlllIll.getCurrentPathIndex());
                        if (llllllllllllIlIIlIllIIlllIlllIIl < llllllllllllIlIIlIllIIlllIlllIII) {
                            llllllllllllIlIIlIllIIlllIllllII.updatePath();
                        }
                    }
                }
            }
        }
    }
    
    @Override
    public void func_190570_a(final int llllllllllllIlIIlIllIIllIllllIll, final boolean llllllllllllIlIIlIllIIllIllllIlI, final boolean llllllllllllIlIIlIllIIllIllllIIl, final double llllllllllllIlIIlIllIIllIllllIII, final double llllllllllllIlIIlIllIIllIlllIlll, final double llllllllllllIlIIlIllIIllIlllIllI, final double llllllllllllIlIIlIllIIllIlllIlIl, final double llllllllllllIlIIlIllIIllIlllIlII, final double llllllllllllIlIIlIllIIllIlllIIll, final int... llllllllllllIlIIlIllIIllIlllIIlI) {
    }
    
    @Override
    public void sendBlockBreakProgress(final int llllllllllllIlIIlIllIIllIlIllIII, final BlockPos llllllllllllIlIIlIllIIllIlIlIlll, final int llllllllllllIlIIlIllIIllIlIlIllI) {
    }
    
    @Override
    public void onEntityRemoved(final Entity llllllllllllIlIIlIllIIllIllIIllI) {
        if (llllllllllllIlIIlIllIIllIllIIllI instanceof EntityLiving) {
            this.navigations.remove(((EntityLiving)llllllllllllIlIIlIllIIllIllIIllI).getNavigator());
        }
    }
    
    @Override
    public void markBlockRangeForRenderUpdate(final int llllllllllllIlIIlIllIIlllIIlIlIl, final int llllllllllllIlIIlIllIIlllIIlIlII, final int llllllllllllIlIIlIllIIlllIIlIIll, final int llllllllllllIlIIlIllIIlllIIlIIlI, final int llllllllllllIlIIlIllIIlllIIlIIIl, final int llllllllllllIlIIlIllIIlllIIlIIII) {
    }
    
    @Override
    public void onEntityAdded(final Entity llllllllllllIlIIlIllIIllIllIllII) {
        if (llllllllllllIlIIlIllIIllIllIllII instanceof EntityLiving) {
            this.navigations.add(((EntityLiving)llllllllllllIlIIlIllIIllIllIllII).getNavigator());
        }
    }
    
    @Override
    public void playRecord(final SoundEvent llllllllllllIlIIlIllIIllIllIIlII, final BlockPos llllllllllllIlIIlIllIIllIllIIIll) {
    }
    
    protected boolean didBlockChange(final World llllllllllllIlIIlIllIIlllIlIIlII, final BlockPos llllllllllllIlIIlIllIIlllIlIIIll, final IBlockState llllllllllllIlIIlIllIIlllIIlllII, final IBlockState llllllllllllIlIIlIllIIlllIlIIIIl) {
        final AxisAlignedBB llllllllllllIlIIlIllIIlllIlIIIII = llllllllllllIlIIlIllIIlllIIlllII.getCollisionBoundingBox(llllllllllllIlIIlIllIIlllIlIIlII, llllllllllllIlIIlIllIIlllIlIIIll);
        final AxisAlignedBB llllllllllllIlIIlIllIIlllIIlllll = llllllllllllIlIIlIllIIlllIlIIIIl.getCollisionBoundingBox(llllllllllllIlIIlIllIIlllIlIIlII, llllllllllllIlIIlIllIIlllIlIIIll);
        return llllllllllllIlIIlIllIIlllIlIIIII != llllllllllllIlIIlIllIIlllIIlllll && (llllllllllllIlIIlIllIIlllIlIIIII == null || !llllllllllllIlIIlIllIIlllIlIIIII.equals(llllllllllllIlIIlIllIIlllIIlllll));
    }
    
    @Override
    public void notifyLightSet(final BlockPos llllllllllllIlIIlIllIIlllIIlIlll) {
    }
    
    @Override
    public void playSoundToAllNearExcept(@Nullable final EntityPlayer llllllllllllIlIIlIllIIlllIIIlllI, final SoundEvent llllllllllllIlIIlIllIIlllIIIllIl, final SoundCategory llllllllllllIlIIlIllIIlllIIIllII, final double llllllllllllIlIIlIllIIlllIIIlIll, final double llllllllllllIlIIlIllIIlllIIIlIlI, final double llllllllllllIlIIlIllIIlllIIIlIIl, final float llllllllllllIlIIlIllIIlllIIIlIII, final float llllllllllllIlIIlIllIIlllIIIIlll) {
    }
}
