// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.pathfinding;

import java.util.Set;
import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.entity.Entity;
import java.util.EnumSet;
import javax.annotation.Nullable;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.math.MathHelper;

public class FlyingNodeProcessor extends WalkNodeProcessor
{
    @Override
    public int findPathOptions(final PathPoint[] llllllllllIllllIIIlllIlIlIllIllI, final PathPoint llllllllllIllllIIIlllIlIllIlIIll, final PathPoint llllllllllIllllIIIlllIlIllIlIIlI, final float llllllllllIllllIIIlllIlIllIlIIIl) {
        int llllllllllIllllIIIlllIlIllIlIIII = 0;
        final PathPoint llllllllllIllllIIIlllIlIllIIllll = this.openPoint(llllllllllIllllIIIlllIlIllIlIIll.xCoord, llllllllllIllllIIIlllIlIllIlIIll.yCoord, llllllllllIllllIIIlllIlIllIlIIll.zCoord + 1);
        final PathPoint llllllllllIllllIIIlllIlIllIIlllI = this.openPoint(llllllllllIllllIIIlllIlIllIlIIll.xCoord - 1, llllllllllIllllIIIlllIlIllIlIIll.yCoord, llllllllllIllllIIIlllIlIllIlIIll.zCoord);
        final PathPoint llllllllllIllllIIIlllIlIllIIllIl = this.openPoint(llllllllllIllllIIIlllIlIllIlIIll.xCoord + 1, llllllllllIllllIIIlllIlIllIlIIll.yCoord, llllllllllIllllIIIlllIlIllIlIIll.zCoord);
        final PathPoint llllllllllIllllIIIlllIlIllIIllII = this.openPoint(llllllllllIllllIIIlllIlIllIlIIll.xCoord, llllllllllIllllIIIlllIlIllIlIIll.yCoord, llllllllllIllllIIIlllIlIllIlIIll.zCoord - 1);
        final PathPoint llllllllllIllllIIIlllIlIllIIlIll = this.openPoint(llllllllllIllllIIIlllIlIllIlIIll.xCoord, llllllllllIllllIIIlllIlIllIlIIll.yCoord + 1, llllllllllIllllIIIlllIlIllIlIIll.zCoord);
        final PathPoint llllllllllIllllIIIlllIlIllIIlIlI = this.openPoint(llllllllllIllllIIIlllIlIllIlIIll.xCoord, llllllllllIllllIIIlllIlIllIlIIll.yCoord - 1, llllllllllIllllIIIlllIlIllIlIIll.zCoord);
        if (llllllllllIllllIIIlllIlIllIIllll != null && !llllllllllIllllIIIlllIlIllIIllll.visited && llllllllllIllllIIIlllIlIllIIllll.distanceTo(llllllllllIllllIIIlllIlIllIlIIlI) < llllllllllIllllIIIlllIlIllIlIIIl) {
            llllllllllIllllIIIlllIlIlIllIllI[llllllllllIllllIIIlllIlIllIlIIII++] = llllllllllIllllIIIlllIlIllIIllll;
        }
        if (llllllllllIllllIIIlllIlIllIIlllI != null && !llllllllllIllllIIIlllIlIllIIlllI.visited && llllllllllIllllIIIlllIlIllIIlllI.distanceTo(llllllllllIllllIIIlllIlIllIlIIlI) < llllllllllIllllIIIlllIlIllIlIIIl) {
            llllllllllIllllIIIlllIlIlIllIllI[llllllllllIllllIIIlllIlIllIlIIII++] = llllllllllIllllIIIlllIlIllIIlllI;
        }
        if (llllllllllIllllIIIlllIlIllIIllIl != null && !llllllllllIllllIIIlllIlIllIIllIl.visited && llllllllllIllllIIIlllIlIllIIllIl.distanceTo(llllllllllIllllIIIlllIlIllIlIIlI) < llllllllllIllllIIIlllIlIllIlIIIl) {
            llllllllllIllllIIIlllIlIlIllIllI[llllllllllIllllIIIlllIlIllIlIIII++] = llllllllllIllllIIIlllIlIllIIllIl;
        }
        if (llllllllllIllllIIIlllIlIllIIllII != null && !llllllllllIllllIIIlllIlIllIIllII.visited && llllllllllIllllIIIlllIlIllIIllII.distanceTo(llllllllllIllllIIIlllIlIllIlIIlI) < llllllllllIllllIIIlllIlIllIlIIIl) {
            llllllllllIllllIIIlllIlIlIllIllI[llllllllllIllllIIIlllIlIllIlIIII++] = llllllllllIllllIIIlllIlIllIIllII;
        }
        if (llllllllllIllllIIIlllIlIllIIlIll != null && !llllllllllIllllIIIlllIlIllIIlIll.visited && llllllllllIllllIIIlllIlIllIIlIll.distanceTo(llllllllllIllllIIIlllIlIllIlIIlI) < llllllllllIllllIIIlllIlIllIlIIIl) {
            llllllllllIllllIIIlllIlIlIllIllI[llllllllllIllllIIIlllIlIllIlIIII++] = llllllllllIllllIIIlllIlIllIIlIll;
        }
        if (llllllllllIllllIIIlllIlIllIIlIlI != null && !llllllllllIllllIIIlllIlIllIIlIlI.visited && llllllllllIllllIIIlllIlIllIIlIlI.distanceTo(llllllllllIllllIIIlllIlIllIlIIlI) < llllllllllIllllIIIlllIlIllIlIIIl) {
            llllllllllIllllIIIlllIlIlIllIllI[llllllllllIllllIIIlllIlIllIlIIII++] = llllllllllIllllIIIlllIlIllIIlIlI;
        }
        final boolean llllllllllIllllIIIlllIlIllIIlIIl = llllllllllIllllIIIlllIlIllIIllII == null || llllllllllIllllIIIlllIlIllIIllII.costMalus != 0.0f;
        final boolean llllllllllIllllIIIlllIlIllIIlIII = llllllllllIllllIIIlllIlIllIIllll == null || llllllllllIllllIIIlllIlIllIIllll.costMalus != 0.0f;
        final boolean llllllllllIllllIIIlllIlIllIIIlll = llllllllllIllllIIIlllIlIllIIllIl == null || llllllllllIllllIIIlllIlIllIIllIl.costMalus != 0.0f;
        final boolean llllllllllIllllIIIlllIlIllIIIllI = llllllllllIllllIIIlllIlIllIIlllI == null || llllllllllIllllIIIlllIlIllIIlllI.costMalus != 0.0f;
        final boolean llllllllllIllllIIIlllIlIllIIIlIl = llllllllllIllllIIIlllIlIllIIlIll == null || llllllllllIllllIIIlllIlIllIIlIll.costMalus != 0.0f;
        final boolean llllllllllIllllIIIlllIlIllIIIlII = llllllllllIllllIIIlllIlIllIIlIlI == null || llllllllllIllllIIIlllIlIllIIlIlI.costMalus != 0.0f;
        if (llllllllllIllllIIIlllIlIllIIlIIl && llllllllllIllllIIIlllIlIllIIIllI) {
            final PathPoint llllllllllIllllIIIlllIlIllIIIIll = this.openPoint(llllllllllIllllIIIlllIlIllIlIIll.xCoord - 1, llllllllllIllllIIIlllIlIllIlIIll.yCoord, llllllllllIllllIIIlllIlIllIlIIll.zCoord - 1);
            if (llllllllllIllllIIIlllIlIllIIIIll != null && !llllllllllIllllIIIlllIlIllIIIIll.visited && llllllllllIllllIIIlllIlIllIIIIll.distanceTo(llllllllllIllllIIIlllIlIllIlIIlI) < llllllllllIllllIIIlllIlIllIlIIIl) {
                llllllllllIllllIIIlllIlIlIllIllI[llllllllllIllllIIIlllIlIllIlIIII++] = llllllllllIllllIIIlllIlIllIIIIll;
            }
        }
        if (llllllllllIllllIIIlllIlIllIIlIIl && llllllllllIllllIIIlllIlIllIIIlll) {
            final PathPoint llllllllllIllllIIIlllIlIllIIIIlI = this.openPoint(llllllllllIllllIIIlllIlIllIlIIll.xCoord + 1, llllllllllIllllIIIlllIlIllIlIIll.yCoord, llllllllllIllllIIIlllIlIllIlIIll.zCoord - 1);
            if (llllllllllIllllIIIlllIlIllIIIIlI != null && !llllllllllIllllIIIlllIlIllIIIIlI.visited && llllllllllIllllIIIlllIlIllIIIIlI.distanceTo(llllllllllIllllIIIlllIlIllIlIIlI) < llllllllllIllllIIIlllIlIllIlIIIl) {
                llllllllllIllllIIIlllIlIlIllIllI[llllllllllIllllIIIlllIlIllIlIIII++] = llllllllllIllllIIIlllIlIllIIIIlI;
            }
        }
        if (llllllllllIllllIIIlllIlIllIIlIII && llllllllllIllllIIIlllIlIllIIIllI) {
            final PathPoint llllllllllIllllIIIlllIlIllIIIIIl = this.openPoint(llllllllllIllllIIIlllIlIllIlIIll.xCoord - 1, llllllllllIllllIIIlllIlIllIlIIll.yCoord, llllllllllIllllIIIlllIlIllIlIIll.zCoord + 1);
            if (llllllllllIllllIIIlllIlIllIIIIIl != null && !llllllllllIllllIIIlllIlIllIIIIIl.visited && llllllllllIllllIIIlllIlIllIIIIIl.distanceTo(llllllllllIllllIIIlllIlIllIlIIlI) < llllllllllIllllIIIlllIlIllIlIIIl) {
                llllllllllIllllIIIlllIlIlIllIllI[llllllllllIllllIIIlllIlIllIlIIII++] = llllllllllIllllIIIlllIlIllIIIIIl;
            }
        }
        if (llllllllllIllllIIIlllIlIllIIlIII && llllllllllIllllIIIlllIlIllIIIlll) {
            final PathPoint llllllllllIllllIIIlllIlIllIIIIII = this.openPoint(llllllllllIllllIIIlllIlIllIlIIll.xCoord + 1, llllllllllIllllIIIlllIlIllIlIIll.yCoord, llllllllllIllllIIIlllIlIllIlIIll.zCoord + 1);
            if (llllllllllIllllIIIlllIlIllIIIIII != null && !llllllllllIllllIIIlllIlIllIIIIII.visited && llllllllllIllllIIIlllIlIllIIIIII.distanceTo(llllllllllIllllIIIlllIlIllIlIIlI) < llllllllllIllllIIIlllIlIllIlIIIl) {
                llllllllllIllllIIIlllIlIlIllIllI[llllllllllIllllIIIlllIlIllIlIIII++] = llllllllllIllllIIIlllIlIllIIIIII;
            }
        }
        if (llllllllllIllllIIIlllIlIllIIlIIl && llllllllllIllllIIIlllIlIllIIIlIl) {
            final PathPoint llllllllllIllllIIIlllIlIlIllllll = this.openPoint(llllllllllIllllIIIlllIlIllIlIIll.xCoord, llllllllllIllllIIIlllIlIllIlIIll.yCoord + 1, llllllllllIllllIIIlllIlIllIlIIll.zCoord - 1);
            if (llllllllllIllllIIIlllIlIlIllllll != null && !llllllllllIllllIIIlllIlIlIllllll.visited && llllllllllIllllIIIlllIlIlIllllll.distanceTo(llllllllllIllllIIIlllIlIllIlIIlI) < llllllllllIllllIIIlllIlIllIlIIIl) {
                llllllllllIllllIIIlllIlIlIllIllI[llllllllllIllllIIIlllIlIllIlIIII++] = llllllllllIllllIIIlllIlIlIllllll;
            }
        }
        if (llllllllllIllllIIIlllIlIllIIlIII && llllllllllIllllIIIlllIlIllIIIlIl) {
            final PathPoint llllllllllIllllIIIlllIlIlIlllllI = this.openPoint(llllllllllIllllIIIlllIlIllIlIIll.xCoord, llllllllllIllllIIIlllIlIllIlIIll.yCoord + 1, llllllllllIllllIIIlllIlIllIlIIll.zCoord + 1);
            if (llllllllllIllllIIIlllIlIlIlllllI != null && !llllllllllIllllIIIlllIlIlIlllllI.visited && llllllllllIllllIIIlllIlIlIlllllI.distanceTo(llllllllllIllllIIIlllIlIllIlIIlI) < llllllllllIllllIIIlllIlIllIlIIIl) {
                llllllllllIllllIIIlllIlIlIllIllI[llllllllllIllllIIIlllIlIllIlIIII++] = llllllllllIllllIIIlllIlIlIlllllI;
            }
        }
        if (llllllllllIllllIIIlllIlIllIIIlll && llllllllllIllllIIIlllIlIllIIIlIl) {
            final PathPoint llllllllllIllllIIIlllIlIlIllllIl = this.openPoint(llllllllllIllllIIIlllIlIllIlIIll.xCoord + 1, llllllllllIllllIIIlllIlIllIlIIll.yCoord + 1, llllllllllIllllIIIlllIlIllIlIIll.zCoord);
            if (llllllllllIllllIIIlllIlIlIllllIl != null && !llllllllllIllllIIIlllIlIlIllllIl.visited && llllllllllIllllIIIlllIlIlIllllIl.distanceTo(llllllllllIllllIIIlllIlIllIlIIlI) < llllllllllIllllIIIlllIlIllIlIIIl) {
                llllllllllIllllIIIlllIlIlIllIllI[llllllllllIllllIIIlllIlIllIlIIII++] = llllllllllIllllIIIlllIlIlIllllIl;
            }
        }
        if (llllllllllIllllIIIlllIlIllIIIllI && llllllllllIllllIIIlllIlIllIIIlIl) {
            final PathPoint llllllllllIllllIIIlllIlIlIllllII = this.openPoint(llllllllllIllllIIIlllIlIllIlIIll.xCoord - 1, llllllllllIllllIIIlllIlIllIlIIll.yCoord + 1, llllllllllIllllIIIlllIlIllIlIIll.zCoord);
            if (llllllllllIllllIIIlllIlIlIllllII != null && !llllllllllIllllIIIlllIlIlIllllII.visited && llllllllllIllllIIIlllIlIlIllllII.distanceTo(llllllllllIllllIIIlllIlIllIlIIlI) < llllllllllIllllIIIlllIlIllIlIIIl) {
                llllllllllIllllIIIlllIlIlIllIllI[llllllllllIllllIIIlllIlIllIlIIII++] = llllllllllIllllIIIlllIlIlIllllII;
            }
        }
        if (llllllllllIllllIIIlllIlIllIIlIIl && llllllllllIllllIIIlllIlIllIIIlII) {
            final PathPoint llllllllllIllllIIIlllIlIlIlllIll = this.openPoint(llllllllllIllllIIIlllIlIllIlIIll.xCoord, llllllllllIllllIIIlllIlIllIlIIll.yCoord - 1, llllllllllIllllIIIlllIlIllIlIIll.zCoord - 1);
            if (llllllllllIllllIIIlllIlIlIlllIll != null && !llllllllllIllllIIIlllIlIlIlllIll.visited && llllllllllIllllIIIlllIlIlIlllIll.distanceTo(llllllllllIllllIIIlllIlIllIlIIlI) < llllllllllIllllIIIlllIlIllIlIIIl) {
                llllllllllIllllIIIlllIlIlIllIllI[llllllllllIllllIIIlllIlIllIlIIII++] = llllllllllIllllIIIlllIlIlIlllIll;
            }
        }
        if (llllllllllIllllIIIlllIlIllIIlIII && llllllllllIllllIIIlllIlIllIIIlII) {
            final PathPoint llllllllllIllllIIIlllIlIlIlllIlI = this.openPoint(llllllllllIllllIIIlllIlIllIlIIll.xCoord, llllllllllIllllIIIlllIlIllIlIIll.yCoord - 1, llllllllllIllllIIIlllIlIllIlIIll.zCoord + 1);
            if (llllllllllIllllIIIlllIlIlIlllIlI != null && !llllllllllIllllIIIlllIlIlIlllIlI.visited && llllllllllIllllIIIlllIlIlIlllIlI.distanceTo(llllllllllIllllIIIlllIlIllIlIIlI) < llllllllllIllllIIIlllIlIllIlIIIl) {
                llllllllllIllllIIIlllIlIlIllIllI[llllllllllIllllIIIlllIlIllIlIIII++] = llllllllllIllllIIIlllIlIlIlllIlI;
            }
        }
        if (llllllllllIllllIIIlllIlIllIIIlll && llllllllllIllllIIIlllIlIllIIIlII) {
            final PathPoint llllllllllIllllIIIlllIlIlIlllIIl = this.openPoint(llllllllllIllllIIIlllIlIllIlIIll.xCoord + 1, llllllllllIllllIIIlllIlIllIlIIll.yCoord - 1, llllllllllIllllIIIlllIlIllIlIIll.zCoord);
            if (llllllllllIllllIIIlllIlIlIlllIIl != null && !llllllllllIllllIIIlllIlIlIlllIIl.visited && llllllllllIllllIIIlllIlIlIlllIIl.distanceTo(llllllllllIllllIIIlllIlIllIlIIlI) < llllllllllIllllIIIlllIlIllIlIIIl) {
                llllllllllIllllIIIlllIlIlIllIllI[llllllllllIllllIIIlllIlIllIlIIII++] = llllllllllIllllIIIlllIlIlIlllIIl;
            }
        }
        if (llllllllllIllllIIIlllIlIllIIIllI && llllllllllIllllIIIlllIlIllIIIlII) {
            final PathPoint llllllllllIllllIIIlllIlIlIlllIII = this.openPoint(llllllllllIllllIIIlllIlIllIlIIll.xCoord - 1, llllllllllIllllIIIlllIlIllIlIIll.yCoord - 1, llllllllllIllllIIIlllIlIllIlIIll.zCoord);
            if (llllllllllIllllIIIlllIlIlIlllIII != null && !llllllllllIllllIIIlllIlIlIlllIII.visited && llllllllllIllllIIIlllIlIlIlllIII.distanceTo(llllllllllIllllIIIlllIlIllIlIIlI) < llllllllllIllllIIIlllIlIllIlIIIl) {
                llllllllllIllllIIIlllIlIlIllIllI[llllllllllIllllIIIlllIlIllIlIIII++] = llllllllllIllllIIIlllIlIlIlllIII;
            }
        }
        return llllllllllIllllIIIlllIlIllIlIIII;
    }
    
    @Override
    public PathPoint getPathPointToCoords(final double llllllllllIllllIIIlllIlIlllIlIll, final double llllllllllIllllIIIlllIlIlllIlllI, final double llllllllllIllllIIIlllIlIlllIllIl) {
        return super.openPoint(MathHelper.floor(llllllllllIllllIIIlllIlIlllIlIll), MathHelper.floor(llllllllllIllllIIIlllIlIlllIlllI), MathHelper.floor(llllllllllIllllIIIlllIlIlllIllIl));
    }
    
    private PathNodeType func_192559_a(final EntityLiving llllllllllIllllIIIlllIlIIlIIIIIl, final BlockPos llllllllllIllllIIIlllIlIIIllllIl) {
        return this.func_192558_a(llllllllllIllllIIIlllIlIIlIIIIIl, llllllllllIllllIIIlllIlIIIllllIl.getX(), llllllllllIllllIIIlllIlIIIllllIl.getY(), llllllllllIllllIIIlllIlIIIllllIl.getZ());
    }
    
    @Override
    public void initProcessor(final IBlockAccess llllllllllIllllIIIlllIllIIIlIIll, final EntityLiving llllllllllIllllIIIlllIllIIIlIIlI) {
        super.initProcessor(llllllllllIllllIIIlllIllIIIlIIll, llllllllllIllllIIIlllIllIIIlIIlI);
        this.avoidsWater = llllllllllIllllIIIlllIllIIIlIIlI.getPathPriority(PathNodeType.WATER);
    }
    
    private PathNodeType func_192558_a(final EntityLiving llllllllllIllllIIIlllIlIIIllIllI, final int llllllllllIllllIIIlllIlIIIllIlIl, final int llllllllllIllllIIIlllIlIIIlIllll, final int llllllllllIllllIIIlllIlIIIlIlllI) {
        return this.getPathNodeType(this.blockaccess, llllllllllIllllIIIlllIlIIIllIlIl, llllllllllIllllIIIlllIlIIIlIllll, llllllllllIllllIIIlllIlIIIlIlllI, llllllllllIllllIIIlllIlIIIllIllI, this.entitySizeX, this.entitySizeY, this.entitySizeZ, this.getCanBreakDoors(), this.getCanEnterDoors());
    }
    
    @Override
    public void postProcess() {
        this.entity.setPathPriority(PathNodeType.WATER, this.avoidsWater);
        super.postProcess();
    }
    
    @Nullable
    @Override
    protected PathPoint openPoint(final int llllllllllIllllIIIlllIlIlIIlllII, final int llllllllllIllllIIIlllIlIlIIlIlII, final int llllllllllIllllIIIlllIlIlIIlIIll) {
        PathPoint llllllllllIllllIIIlllIlIlIIllIIl = null;
        final PathNodeType llllllllllIllllIIIlllIlIlIIllIII = this.func_192558_a(this.entity, llllllllllIllllIIIlllIlIlIIlllII, llllllllllIllllIIIlllIlIlIIlIlII, llllllllllIllllIIIlllIlIlIIlIIll);
        final float llllllllllIllllIIIlllIlIlIIlIlll = this.entity.getPathPriority(llllllllllIllllIIIlllIlIlIIllIII);
        if (llllllllllIllllIIIlllIlIlIIlIlll >= 0.0f) {
            llllllllllIllllIIIlllIlIlIIllIIl = super.openPoint(llllllllllIllllIIIlllIlIlIIlllII, llllllllllIllllIIIlllIlIlIIlIlII, llllllllllIllllIIIlllIlIlIIlIIll);
            llllllllllIllllIIIlllIlIlIIllIIl.nodeType = llllllllllIllllIIIlllIlIlIIllIII;
            llllllllllIllllIIIlllIlIlIIllIIl.costMalus = Math.max(llllllllllIllllIIIlllIlIlIIllIIl.costMalus, llllllllllIllllIIIlllIlIlIIlIlll);
            if (llllllllllIllllIIIlllIlIlIIllIII == PathNodeType.WALKABLE) {
                final PathPoint pathPoint = llllllllllIllllIIIlllIlIlIIllIIl;
                ++pathPoint.costMalus;
            }
        }
        return (llllllllllIllllIIIlllIlIlIIllIII != PathNodeType.OPEN && llllllllllIllllIIIlllIlIlIIllIII != PathNodeType.WALKABLE) ? llllllllllIllllIIIlllIlIlIIllIIl : llllllllllIllllIIIlllIlIlIIllIIl;
    }
    
    @Override
    public PathNodeType getPathNodeType(final IBlockAccess llllllllllIllllIIIlllIlIIlllllIl, final int llllllllllIllllIIIlllIlIIllIllII, final int llllllllllIllllIIIlllIlIIllllIll, final int llllllllllIllllIIIlllIlIIllllIlI, final EntityLiving llllllllllIllllIIIlllIlIIllllIIl, final int llllllllllIllllIIIlllIlIIllllIII, final int llllllllllIllllIIIlllIlIIlllIlll, final int llllllllllIllllIIIlllIlIIlllIllI, final boolean llllllllllIllllIIIlllIlIIllIIlIl, final boolean llllllllllIllllIIIlllIlIIllIIlII) {
        final EnumSet<PathNodeType> llllllllllIllllIIIlllIlIIlllIIll = EnumSet.noneOf(PathNodeType.class);
        PathNodeType llllllllllIllllIIIlllIlIIlllIIlI = PathNodeType.BLOCKED;
        final BlockPos llllllllllIllllIIIlllIlIIlllIIIl = new BlockPos(llllllllllIllllIIIlllIlIIllllIIl);
        llllllllllIllllIIIlllIlIIlllIIlI = this.func_193577_a(llllllllllIllllIIIlllIlIIlllllIl, llllllllllIllllIIIlllIlIIllIllII, llllllllllIllllIIIlllIlIIllllIll, llllllllllIllllIIIlllIlIIllllIlI, llllllllllIllllIIIlllIlIIllllIII, llllllllllIllllIIIlllIlIIlllIlll, llllllllllIllllIIIlllIlIIlllIllI, llllllllllIllllIIIlllIlIIllIIlIl, llllllllllIllllIIIlllIlIIllIIlII, llllllllllIllllIIIlllIlIIlllIIll, llllllllllIllllIIIlllIlIIlllIIlI, llllllllllIllllIIIlllIlIIlllIIIl);
        if (llllllllllIllllIIIlllIlIIlllIIll.contains(PathNodeType.FENCE)) {
            return PathNodeType.FENCE;
        }
        PathNodeType llllllllllIllllIIIlllIlIIlllIIII = PathNodeType.BLOCKED;
        for (final PathNodeType llllllllllIllllIIIlllIlIIllIllll : llllllllllIllllIIIlllIlIIlllIIll) {
            if (llllllllllIllllIIIlllIlIIllllIIl.getPathPriority(llllllllllIllllIIIlllIlIIllIllll) < 0.0f) {
                return llllllllllIllllIIIlllIlIIllIllll;
            }
            if (llllllllllIllllIIIlllIlIIllllIIl.getPathPriority(llllllllllIllllIIIlllIlIIllIllll) < llllllllllIllllIIIlllIlIIllllIIl.getPathPriority(llllllllllIllllIIIlllIlIIlllIIII)) {
                continue;
            }
            llllllllllIllllIIIlllIlIIlllIIII = llllllllllIllllIIIlllIlIIllIllll;
        }
        if (llllllllllIllllIIIlllIlIIlllIIlI == PathNodeType.OPEN && llllllllllIllllIIIlllIlIIllllIIl.getPathPriority(llllllllllIllllIIIlllIlIIlllIIII) == 0.0f) {
            return PathNodeType.OPEN;
        }
        return llllllllllIllllIIIlllIlIIlllIIII;
    }
    
    @Override
    public PathNodeType getPathNodeType(final IBlockAccess llllllllllIllllIIIlllIlIIlIIllII, final int llllllllllIllllIIIlllIlIIlIlIIll, final int llllllllllIllllIIIlllIlIIlIlIIlI, final int llllllllllIllllIIIlllIlIIlIIlIIl) {
        PathNodeType llllllllllIllllIIIlllIlIIlIlIIII = this.getPathNodeTypeRaw(llllllllllIllllIIIlllIlIIlIIllII, llllllllllIllllIIIlllIlIIlIlIIll, llllllllllIllllIIIlllIlIIlIlIIlI, llllllllllIllllIIIlllIlIIlIIlIIl);
        if (llllllllllIllllIIIlllIlIIlIlIIII == PathNodeType.OPEN && llllllllllIllllIIIlllIlIIlIlIIlI >= 1) {
            final Block llllllllllIllllIIIlllIlIIlIIllll = llllllllllIllllIIIlllIlIIlIIllII.getBlockState(new BlockPos(llllllllllIllllIIIlllIlIIlIlIIll, llllllllllIllllIIIlllIlIIlIlIIlI - 1, llllllllllIllllIIIlllIlIIlIIlIIl)).getBlock();
            final PathNodeType llllllllllIllllIIIlllIlIIlIIlllI = this.getPathNodeTypeRaw(llllllllllIllllIIIlllIlIIlIIllII, llllllllllIllllIIIlllIlIIlIlIIll, llllllllllIllllIIIlllIlIIlIlIIlI - 1, llllllllllIllllIIIlllIlIIlIIlIIl);
            if (llllllllllIllllIIIlllIlIIlIIlllI != PathNodeType.DAMAGE_FIRE && llllllllllIllllIIIlllIlIIlIIllll != Blocks.MAGMA && llllllllllIllllIIIlllIlIIlIIlllI != PathNodeType.LAVA) {
                if (llllllllllIllllIIIlllIlIIlIIlllI == PathNodeType.DAMAGE_CACTUS) {
                    llllllllllIllllIIIlllIlIIlIlIIII = PathNodeType.DAMAGE_CACTUS;
                }
                else {
                    llllllllllIllllIIIlllIlIIlIlIIII = ((llllllllllIllllIIIlllIlIIlIIlllI != PathNodeType.WALKABLE && llllllllllIllllIIIlllIlIIlIIlllI != PathNodeType.OPEN && llllllllllIllllIIIlllIlIIlIIlllI != PathNodeType.WATER) ? PathNodeType.WALKABLE : PathNodeType.OPEN);
                }
            }
            else {
                llllllllllIllllIIIlllIlIIlIlIIII = PathNodeType.DAMAGE_FIRE;
            }
        }
        llllllllllIllllIIIlllIlIIlIlIIII = this.func_193578_a(llllllllllIllllIIIlllIlIIlIIllII, llllllllllIllllIIIlllIlIIlIlIIll, llllllllllIllllIIIlllIlIIlIlIIlI, llllllllllIllllIIIlllIlIIlIIlIIl, llllllllllIllllIIIlllIlIIlIlIIII);
        return llllllllllIllllIIIlllIlIIlIlIIII;
    }
    
    @Override
    public PathPoint getStart() {
        int llllllllllIllllIIIlllIllIIIIIlII;
        if (this.getCanSwim() && this.entity.isInWater()) {
            int llllllllllIllllIIIlllIllIIIIIlIl = (int)this.entity.getEntityBoundingBox().minY;
            final BlockPos.MutableBlockPos llllllllllIllllIIIlllIllIIIIIIll = new BlockPos.MutableBlockPos(MathHelper.floor(this.entity.posX), llllllllllIllllIIIlllIllIIIIIlIl, MathHelper.floor(this.entity.posZ));
            for (Block llllllllllIllllIIIlllIllIIIIIIlI = this.blockaccess.getBlockState(llllllllllIllllIIIlllIllIIIIIIll).getBlock(); llllllllllIllllIIIlllIllIIIIIIlI == Blocks.FLOWING_WATER || llllllllllIllllIIIlllIllIIIIIIlI == Blocks.WATER; llllllllllIllllIIIlllIllIIIIIIlI = this.blockaccess.getBlockState(llllllllllIllllIIIlllIllIIIIIIll).getBlock()) {
                ++llllllllllIllllIIIlllIllIIIIIlIl;
                llllllllllIllllIIIlllIllIIIIIIll.setPos(MathHelper.floor(this.entity.posX), llllllllllIllllIIIlllIllIIIIIlIl, MathHelper.floor(this.entity.posZ));
            }
        }
        else {
            llllllllllIllllIIIlllIllIIIIIlII = MathHelper.floor(this.entity.getEntityBoundingBox().minY + 0.5);
        }
        final BlockPos llllllllllIllllIIIlllIllIIIIIIIl = new BlockPos(this.entity);
        final PathNodeType llllllllllIllllIIIlllIllIIIIIIII = this.func_192558_a(this.entity, llllllllllIllllIIIlllIllIIIIIIIl.getX(), llllllllllIllllIIIlllIllIIIIIlII, llllllllllIllllIIIlllIllIIIIIIIl.getZ());
        if (this.entity.getPathPriority(llllllllllIllllIIIlllIllIIIIIIII) < 0.0f) {
            final Set<BlockPos> llllllllllIllllIIIlllIlIllllllll = (Set<BlockPos>)Sets.newHashSet();
            llllllllllIllllIIIlllIlIllllllll.add(new BlockPos(this.entity.getEntityBoundingBox().minX, llllllllllIllllIIIlllIllIIIIIlII, this.entity.getEntityBoundingBox().minZ));
            llllllllllIllllIIIlllIlIllllllll.add(new BlockPos(this.entity.getEntityBoundingBox().minX, llllllllllIllllIIIlllIllIIIIIlII, this.entity.getEntityBoundingBox().maxZ));
            llllllllllIllllIIIlllIlIllllllll.add(new BlockPos(this.entity.getEntityBoundingBox().maxX, llllllllllIllllIIIlllIllIIIIIlII, this.entity.getEntityBoundingBox().minZ));
            llllllllllIllllIIIlllIlIllllllll.add(new BlockPos(this.entity.getEntityBoundingBox().maxX, llllllllllIllllIIIlllIllIIIIIlII, this.entity.getEntityBoundingBox().maxZ));
            for (final BlockPos llllllllllIllllIIIlllIlIlllllllI : llllllllllIllllIIIlllIlIllllllll) {
                final PathNodeType llllllllllIllllIIIlllIlIllllllIl = this.func_192559_a(this.entity, llllllllllIllllIIIlllIlIlllllllI);
                if (this.entity.getPathPriority(llllllllllIllllIIIlllIlIllllllIl) >= 0.0f) {
                    return super.openPoint(llllllllllIllllIIIlllIlIlllllllI.getX(), llllllllllIllllIIIlllIlIlllllllI.getY(), llllllllllIllllIIIlllIlIlllllllI.getZ());
                }
            }
        }
        return super.openPoint(llllllllllIllllIIIlllIllIIIIIIIl.getX(), llllllllllIllllIIIlllIllIIIIIlII, llllllllllIllllIIIlllIllIIIIIIIl.getZ());
    }
}
