// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world;

import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockPortal;
import net.minecraft.block.state.pattern.BlockPattern;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.Vec3i;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.Entity;
import java.util.Random;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;

public class Teleporter
{
    private final /* synthetic */ WorldServer worldServerInstance;
    private final /* synthetic */ Long2ObjectMap<PortalPosition> destinationCoordinateCache;
    private final /* synthetic */ Random random;
    
    public boolean placeInExistingPortal(final Entity lllllllllllllllIlIlIIlIlIlIIlIlI, final float lllllllllllllllIlIlIIlIlIlIIlIIl) {
        final int lllllllllllllllIlIlIIlIlIlIIlIII = 128;
        double lllllllllllllllIlIlIIlIlIlIIIlll = -1.0;
        final int lllllllllllllllIlIlIIlIlIlIIIllI = MathHelper.floor(lllllllllllllllIlIlIIlIlIlIIlIlI.posX);
        final int lllllllllllllllIlIlIIlIlIlIIIlIl = MathHelper.floor(lllllllllllllllIlIlIIlIlIlIIlIlI.posZ);
        boolean lllllllllllllllIlIlIIlIlIlIIIlII = true;
        BlockPos lllllllllllllllIlIlIIlIlIlIIIIll = BlockPos.ORIGIN;
        final long lllllllllllllllIlIlIIlIlIlIIIIlI = ChunkPos.asLong(lllllllllllllllIlIlIIlIlIlIIIllI, lllllllllllllllIlIlIIlIlIlIIIlIl);
        if (this.destinationCoordinateCache.containsKey(lllllllllllllllIlIlIIlIlIlIIIIlI)) {
            final PortalPosition lllllllllllllllIlIlIIlIlIlIIIIIl = (PortalPosition)this.destinationCoordinateCache.get(lllllllllllllllIlIlIIlIlIlIIIIlI);
            lllllllllllllllIlIlIIlIlIlIIIlll = 0.0;
            lllllllllllllllIlIlIIlIlIlIIIIll = lllllllllllllllIlIlIIlIlIlIIIIIl;
            lllllllllllllllIlIlIIlIlIlIIIIIl.lastUpdateTime = this.worldServerInstance.getTotalWorldTime();
            lllllllllllllllIlIlIIlIlIlIIIlII = false;
        }
        else {
            final BlockPos lllllllllllllllIlIlIIlIlIlIIIIII = new BlockPos(lllllllllllllllIlIlIIlIlIlIIlIlI);
            for (int lllllllllllllllIlIlIIlIlIIllllll = -128; lllllllllllllllIlIlIIlIlIIllllll <= 128; ++lllllllllllllllIlIlIIlIlIIllllll) {
                for (int lllllllllllllllIlIlIIlIlIIllllIl = -128; lllllllllllllllIlIlIIlIlIIllllIl <= 128; ++lllllllllllllllIlIlIIlIlIIllllIl) {
                    BlockPos lllllllllllllllIlIlIIlIlIIlllllI;
                    for (BlockPos lllllllllllllllIlIlIIlIlIIllllII = lllllllllllllllIlIlIIlIlIlIIIIII.add(lllllllllllllllIlIlIIlIlIIllllll, this.worldServerInstance.getActualHeight() - 1 - lllllllllllllllIlIlIIlIlIlIIIIII.getY(), lllllllllllllllIlIlIIlIlIIllllIl); lllllllllllllllIlIlIIlIlIIllllII.getY() >= 0; lllllllllllllllIlIlIIlIlIIllllII = lllllllllllllllIlIlIIlIlIIlllllI) {
                        lllllllllllllllIlIlIIlIlIIlllllI = lllllllllllllllIlIlIIlIlIIllllII.down();
                        if (this.worldServerInstance.getBlockState(lllllllllllllllIlIlIIlIlIIllllII).getBlock() == Blocks.PORTAL) {
                            for (lllllllllllllllIlIlIIlIlIIlllllI = lllllllllllllllIlIlIIlIlIIllllII.down(); this.worldServerInstance.getBlockState(lllllllllllllllIlIlIIlIlIIlllllI).getBlock() == Blocks.PORTAL; lllllllllllllllIlIlIIlIlIIlllllI = lllllllllllllllIlIlIIlIlIIlllllI.down()) {
                                lllllllllllllllIlIlIIlIlIIllllII = lllllllllllllllIlIlIIlIlIIlllllI;
                            }
                            final double lllllllllllllllIlIlIIlIlIIlllIll = lllllllllllllllIlIlIIlIlIIllllII.distanceSq(lllllllllllllllIlIlIIlIlIlIIIIII);
                            if (lllllllllllllllIlIlIIlIlIlIIIlll < 0.0 || lllllllllllllllIlIlIIlIlIIlllIll < lllllllllllllllIlIlIIlIlIlIIIlll) {
                                lllllllllllllllIlIlIIlIlIlIIIlll = lllllllllllllllIlIlIIlIlIIlllIll;
                                lllllllllllllllIlIlIIlIlIlIIIIll = lllllllllllllllIlIlIIlIlIIllllII;
                            }
                        }
                    }
                }
            }
        }
        if (lllllllllllllllIlIlIIlIlIlIIIlll >= 0.0) {
            if (lllllllllllllllIlIlIIlIlIlIIIlII) {
                this.destinationCoordinateCache.put(lllllllllllllllIlIlIIlIlIlIIIIlI, (Object)new PortalPosition(lllllllllllllllIlIlIIlIlIlIIIIll, this.worldServerInstance.getTotalWorldTime()));
            }
            double lllllllllllllllIlIlIIlIlIIlllIlI = lllllllllllllllIlIlIIlIlIlIIIIll.getX() + 0.5;
            double lllllllllllllllIlIlIIlIlIIlllIIl = lllllllllllllllIlIlIIlIlIlIIIIll.getZ() + 0.5;
            final BlockPattern.PatternHelper lllllllllllllllIlIlIIlIlIIlllIII = Blocks.PORTAL.createPatternHelper(this.worldServerInstance, lllllllllllllllIlIlIIlIlIlIIIIll);
            final boolean lllllllllllllllIlIlIIlIlIIllIlll = lllllllllllllllIlIlIIlIlIIlllIII.getForwards().rotateY().getAxisDirection() == EnumFacing.AxisDirection.NEGATIVE;
            double lllllllllllllllIlIlIIlIlIIllIllI = (lllllllllllllllIlIlIIlIlIIlllIII.getForwards().getAxis() == EnumFacing.Axis.X) ? lllllllllllllllIlIlIIlIlIIlllIII.getFrontTopLeft().getZ() : ((double)lllllllllllllllIlIlIIlIlIIlllIII.getFrontTopLeft().getX());
            final double lllllllllllllllIlIlIIlIlIIllIlIl = lllllllllllllllIlIlIIlIlIIlllIII.getFrontTopLeft().getY() + 1 - lllllllllllllllIlIlIIlIlIlIIlIlI.getLastPortalVec().yCoord * lllllllllllllllIlIlIIlIlIIlllIII.getHeight();
            if (lllllllllllllllIlIlIIlIlIIllIlll) {
                ++lllllllllllllllIlIlIIlIlIIllIllI;
            }
            if (lllllllllllllllIlIlIIlIlIIlllIII.getForwards().getAxis() == EnumFacing.Axis.X) {
                lllllllllllllllIlIlIIlIlIIlllIIl = lllllllllllllllIlIlIIlIlIIllIllI + (1.0 - lllllllllllllllIlIlIIlIlIlIIlIlI.getLastPortalVec().xCoord) * lllllllllllllllIlIlIIlIlIIlllIII.getWidth() * lllllllllllllllIlIlIIlIlIIlllIII.getForwards().rotateY().getAxisDirection().getOffset();
            }
            else {
                lllllllllllllllIlIlIIlIlIIlllIlI = lllllllllllllllIlIlIIlIlIIllIllI + (1.0 - lllllllllllllllIlIlIIlIlIlIIlIlI.getLastPortalVec().xCoord) * lllllllllllllllIlIlIIlIlIIlllIII.getWidth() * lllllllllllllllIlIlIIlIlIIlllIII.getForwards().rotateY().getAxisDirection().getOffset();
            }
            float lllllllllllllllIlIlIIlIlIIllIlII = 0.0f;
            float lllllllllllllllIlIlIIlIlIIllIIll = 0.0f;
            float lllllllllllllllIlIlIIlIlIIllIIlI = 0.0f;
            float lllllllllllllllIlIlIIlIlIIllIIIl = 0.0f;
            if (lllllllllllllllIlIlIIlIlIIlllIII.getForwards().getOpposite() == lllllllllllllllIlIlIIlIlIlIIlIlI.getTeleportDirection()) {
                lllllllllllllllIlIlIIlIlIIllIlII = 1.0f;
                lllllllllllllllIlIlIIlIlIIllIIll = 1.0f;
            }
            else if (lllllllllllllllIlIlIIlIlIIlllIII.getForwards().getOpposite() == lllllllllllllllIlIlIIlIlIlIIlIlI.getTeleportDirection().getOpposite()) {
                lllllllllllllllIlIlIIlIlIIllIlII = -1.0f;
                lllllllllllllllIlIlIIlIlIIllIIll = -1.0f;
            }
            else if (lllllllllllllllIlIlIIlIlIIlllIII.getForwards().getOpposite() == lllllllllllllllIlIlIIlIlIlIIlIlI.getTeleportDirection().rotateY()) {
                lllllllllllllllIlIlIIlIlIIllIIlI = 1.0f;
                lllllllllllllllIlIlIIlIlIIllIIIl = -1.0f;
            }
            else {
                lllllllllllllllIlIlIIlIlIIllIIlI = -1.0f;
                lllllllllllllllIlIlIIlIlIIllIIIl = 1.0f;
            }
            final double lllllllllllllllIlIlIIlIlIIllIIII = lllllllllllllllIlIlIIlIlIlIIlIlI.motionX;
            final double lllllllllllllllIlIlIIlIlIIlIllll = lllllllllllllllIlIlIIlIlIlIIlIlI.motionZ;
            lllllllllllllllIlIlIIlIlIlIIlIlI.motionX = lllllllllllllllIlIlIIlIlIIllIIII * lllllllllllllllIlIlIIlIlIIllIlII + lllllllllllllllIlIlIIlIlIIlIllll * lllllllllllllllIlIlIIlIlIIllIIIl;
            lllllllllllllllIlIlIIlIlIlIIlIlI.motionZ = lllllllllllllllIlIlIIlIlIIllIIII * lllllllllllllllIlIlIIlIlIIllIIlI + lllllllllllllllIlIlIIlIlIIlIllll * lllllllllllllllIlIlIIlIlIIllIIll;
            lllllllllllllllIlIlIIlIlIlIIlIlI.rotationYaw = lllllllllllllllIlIlIIlIlIlIIlIIl - lllllllllllllllIlIlIIlIlIlIIlIlI.getTeleportDirection().getOpposite().getHorizontalIndex() * 90 + lllllllllllllllIlIlIIlIlIIlllIII.getForwards().getHorizontalIndex() * 90;
            if (lllllllllllllllIlIlIIlIlIlIIlIlI instanceof EntityPlayerMP) {
                ((EntityPlayerMP)lllllllllllllllIlIlIIlIlIlIIlIlI).connection.setPlayerLocation(lllllllllllllllIlIlIIlIlIIlllIlI, lllllllllllllllIlIlIIlIlIIllIlIl, lllllllllllllllIlIlIIlIlIIlllIIl, lllllllllllllllIlIlIIlIlIlIIlIlI.rotationYaw, lllllllllllllllIlIlIIlIlIlIIlIlI.rotationPitch);
            }
            else {
                lllllllllllllllIlIlIIlIlIlIIlIlI.setLocationAndAngles(lllllllllllllllIlIlIIlIlIIlllIlI, lllllllllllllllIlIlIIlIlIIllIlIl, lllllllllllllllIlIlIIlIlIIlllIIl, lllllllllllllllIlIlIIlIlIlIIlIlI.rotationYaw, lllllllllllllllIlIlIIlIlIlIIlIlI.rotationPitch);
            }
            return true;
        }
        return false;
    }
    
    public void placeInPortal(final Entity lllllllllllllllIlIlIIlIlIlllIIIl, final float lllllllllllllllIlIlIIlIlIlllllll) {
        if (this.worldServerInstance.provider.getDimensionType().getId() != 1) {
            if (!this.placeInExistingPortal(lllllllllllllllIlIlIIlIlIlllIIIl, lllllllllllllllIlIlIIlIlIlllllll)) {
                this.makePortal(lllllllllllllllIlIlIIlIlIlllIIIl);
                this.placeInExistingPortal(lllllllllllllllIlIlIIlIlIlllIIIl, lllllllllllllllIlIlIIlIlIlllllll);
            }
        }
        else {
            final int lllllllllllllllIlIlIIlIlIllllllI = MathHelper.floor(lllllllllllllllIlIlIIlIlIlllIIIl.posX);
            final int lllllllllllllllIlIlIIlIlIlllllIl = MathHelper.floor(lllllllllllllllIlIlIIlIlIlllIIIl.posY) - 1;
            final int lllllllllllllllIlIlIIlIlIlllllII = MathHelper.floor(lllllllllllllllIlIlIIlIlIlllIIIl.posZ);
            final int lllllllllllllllIlIlIIlIlIllllIll = 1;
            final int lllllllllllllllIlIlIIlIlIllllIlI = 0;
            for (int lllllllllllllllIlIlIIlIlIllllIIl = -2; lllllllllllllllIlIlIIlIlIllllIIl <= 2; ++lllllllllllllllIlIlIIlIlIllllIIl) {
                for (int lllllllllllllllIlIlIIlIlIllllIII = -2; lllllllllllllllIlIlIIlIlIllllIII <= 2; ++lllllllllllllllIlIlIIlIlIllllIII) {
                    for (int lllllllllllllllIlIlIIlIlIlllIlll = -1; lllllllllllllllIlIlIIlIlIlllIlll < 3; ++lllllllllllllllIlIlIIlIlIlllIlll) {
                        final int lllllllllllllllIlIlIIlIlIlllIllI = lllllllllllllllIlIlIIlIlIllllllI + lllllllllllllllIlIlIIlIlIllllIII * 1 + lllllllllllllllIlIlIIlIlIllllIIl * 0;
                        final int lllllllllllllllIlIlIIlIlIlllIlIl = lllllllllllllllIlIlIIlIlIlllllIl + lllllllllllllllIlIlIIlIlIlllIlll;
                        final int lllllllllllllllIlIlIIlIlIlllIlII = lllllllllllllllIlIlIIlIlIlllllII + lllllllllllllllIlIlIIlIlIllllIII * 0 - lllllllllllllllIlIlIIlIlIllllIIl * 1;
                        final boolean lllllllllllllllIlIlIIlIlIlllIIll = lllllllllllllllIlIlIIlIlIlllIlll < 0;
                        this.worldServerInstance.setBlockState(new BlockPos(lllllllllllllllIlIlIIlIlIlllIllI, lllllllllllllllIlIlIIlIlIlllIlIl, lllllllllllllllIlIlIIlIlIlllIlII), lllllllllllllllIlIlIIlIlIlllIIll ? Blocks.OBSIDIAN.getDefaultState() : Blocks.AIR.getDefaultState());
                    }
                }
            }
            lllllllllllllllIlIlIIlIlIlllIIIl.setLocationAndAngles(lllllllllllllllIlIlIIlIlIllllllI, lllllllllllllllIlIlIIlIlIlllllIl, lllllllllllllllIlIlIIlIlIlllllII, lllllllllllllllIlIlIIlIlIlllIIIl.rotationYaw, 0.0f);
            lllllllllllllllIlIlIIlIlIlllIIIl.motionX = 0.0;
            lllllllllllllllIlIlIIlIlIlllIIIl.motionY = 0.0;
            lllllllllllllllIlIlIIlIlIlllIIIl.motionZ = 0.0;
        }
    }
    
    public boolean makePortal(final Entity lllllllllllllllIlIlIIlIIlllllIII) {
        final int lllllllllllllllIlIlIIlIIllllIlll = 16;
        double lllllllllllllllIlIlIIlIIllllIllI = -1.0;
        final int lllllllllllllllIlIlIIlIIllllIlIl = MathHelper.floor(lllllllllllllllIlIlIIlIIlllllIII.posX);
        final int lllllllllllllllIlIlIIlIIllllIlII = MathHelper.floor(lllllllllllllllIlIlIIlIIlllllIII.posY);
        final int lllllllllllllllIlIlIIlIIllllIIll = MathHelper.floor(lllllllllllllllIlIlIIlIIlllllIII.posZ);
        int lllllllllllllllIlIlIIlIIllllIIlI = lllllllllllllllIlIlIIlIIllllIlIl;
        int lllllllllllllllIlIlIIlIIllllIIIl = lllllllllllllllIlIlIIlIIllllIlII;
        int lllllllllllllllIlIlIIlIIllllIIII = lllllllllllllllIlIlIIlIIllllIIll;
        int lllllllllllllllIlIlIIlIIlllIllll = 0;
        final int lllllllllllllllIlIlIIlIIlllIlllI = this.random.nextInt(4);
        final BlockPos.MutableBlockPos lllllllllllllllIlIlIIlIIlllIllIl = new BlockPos.MutableBlockPos();
        for (int lllllllllllllllIlIlIIlIIlllIllII = lllllllllllllllIlIlIIlIIllllIlIl - 16; lllllllllllllllIlIlIIlIIlllIllII <= lllllllllllllllIlIlIIlIIllllIlIl + 16; ++lllllllllllllllIlIlIIlIIlllIllII) {
            final double lllllllllllllllIlIlIIlIIlllIlIll = lllllllllllllllIlIlIIlIIlllIllII + 0.5 - lllllllllllllllIlIlIIlIIlllllIII.posX;
            for (int lllllllllllllllIlIlIIlIIlllIlIlI = lllllllllllllllIlIlIIlIIllllIIll - 16; lllllllllllllllIlIlIIlIIlllIlIlI <= lllllllllllllllIlIlIIlIIllllIIll + 16; ++lllllllllllllllIlIlIIlIIlllIlIlI) {
                final double lllllllllllllllIlIlIIlIIlllIlIIl = lllllllllllllllIlIlIIlIIlllIlIlI + 0.5 - lllllllllllllllIlIlIIlIIlllllIII.posZ;
            Label_0446:
                for (int lllllllllllllllIlIlIIlIIlllIlIII = this.worldServerInstance.getActualHeight() - 1; lllllllllllllllIlIlIIlIIlllIlIII >= 0; --lllllllllllllllIlIlIIlIIlllIlIII) {
                    if (this.worldServerInstance.isAirBlock(lllllllllllllllIlIlIIlIIlllIllIl.setPos(lllllllllllllllIlIlIIlIIlllIllII, lllllllllllllllIlIlIIlIIlllIlIII, lllllllllllllllIlIlIIlIIlllIlIlI))) {
                        while (lllllllllllllllIlIlIIlIIlllIlIII > 0 && this.worldServerInstance.isAirBlock(lllllllllllllllIlIlIIlIIlllIllIl.setPos(lllllllllllllllIlIlIIlIIlllIllII, lllllllllllllllIlIlIIlIIlllIlIII - 1, lllllllllllllllIlIlIIlIIlllIlIlI))) {
                            --lllllllllllllllIlIlIIlIIlllIlIII;
                        }
                        for (int lllllllllllllllIlIlIIlIIlllIIlll = lllllllllllllllIlIlIIlIIlllIlllI; lllllllllllllllIlIlIIlIIlllIIlll < lllllllllllllllIlIlIIlIIlllIlllI + 4; ++lllllllllllllllIlIlIIlIIlllIIlll) {
                            int lllllllllllllllIlIlIIlIIlllIIllI = lllllllllllllllIlIlIIlIIlllIIlll % 2;
                            int lllllllllllllllIlIlIIlIIlllIIlIl = 1 - lllllllllllllllIlIlIIlIIlllIIllI;
                            if (lllllllllllllllIlIlIIlIIlllIIlll % 4 >= 2) {
                                lllllllllllllllIlIlIIlIIlllIIllI = -lllllllllllllllIlIlIIlIIlllIIllI;
                                lllllllllllllllIlIlIIlIIlllIIlIl = -lllllllllllllllIlIlIIlIIlllIIlIl;
                            }
                            for (int lllllllllllllllIlIlIIlIIlllIIlII = 0; lllllllllllllllIlIlIIlIIlllIIlII < 3; ++lllllllllllllllIlIlIIlIIlllIIlII) {
                                for (int lllllllllllllllIlIlIIlIIlllIIIll = 0; lllllllllllllllIlIlIIlIIlllIIIll < 4; ++lllllllllllllllIlIlIIlIIlllIIIll) {
                                    for (int lllllllllllllllIlIlIIlIIlllIIIlI = -1; lllllllllllllllIlIlIIlIIlllIIIlI < 4; ++lllllllllllllllIlIlIIlIIlllIIIlI) {
                                        final int lllllllllllllllIlIlIIlIIlllIIIIl = lllllllllllllllIlIlIIlIIlllIllII + (lllllllllllllllIlIlIIlIIlllIIIll - 1) * lllllllllllllllIlIlIIlIIlllIIllI + lllllllllllllllIlIlIIlIIlllIIlII * lllllllllllllllIlIlIIlIIlllIIlIl;
                                        final int lllllllllllllllIlIlIIlIIlllIIIII = lllllllllllllllIlIlIIlIIlllIlIII + lllllllllllllllIlIlIIlIIlllIIIlI;
                                        final int lllllllllllllllIlIlIIlIIllIlllll = lllllllllllllllIlIlIIlIIlllIlIlI + (lllllllllllllllIlIlIIlIIlllIIIll - 1) * lllllllllllllllIlIlIIlIIlllIIlIl - lllllllllllllllIlIlIIlIIlllIIlII * lllllllllllllllIlIlIIlIIlllIIllI;
                                        lllllllllllllllIlIlIIlIIlllIllIl.setPos(lllllllllllllllIlIlIIlIIlllIIIIl, lllllllllllllllIlIlIIlIIlllIIIII, lllllllllllllllIlIlIIlIIllIlllll);
                                        if (lllllllllllllllIlIlIIlIIlllIIIlI < 0 && !this.worldServerInstance.getBlockState(lllllllllllllllIlIlIIlIIlllIllIl).getMaterial().isSolid()) {
                                            continue Label_0446;
                                        }
                                        if (lllllllllllllllIlIlIIlIIlllIIIlI >= 0 && !this.worldServerInstance.isAirBlock(lllllllllllllllIlIlIIlIIlllIllIl)) {
                                            continue Label_0446;
                                        }
                                    }
                                }
                            }
                            final double lllllllllllllllIlIlIIlIIllIllllI = lllllllllllllllIlIlIIlIIlllIlIII + 0.5 - lllllllllllllllIlIlIIlIIlllllIII.posY;
                            final double lllllllllllllllIlIlIIlIIllIlllIl = lllllllllllllllIlIlIIlIIlllIlIll * lllllllllllllllIlIlIIlIIlllIlIll + lllllllllllllllIlIlIIlIIllIllllI * lllllllllllllllIlIlIIlIIllIllllI + lllllllllllllllIlIlIIlIIlllIlIIl * lllllllllllllllIlIlIIlIIlllIlIIl;
                            if (lllllllllllllllIlIlIIlIIllllIllI < 0.0 || lllllllllllllllIlIlIIlIIllIlllIl < lllllllllllllllIlIlIIlIIllllIllI) {
                                lllllllllllllllIlIlIIlIIllllIllI = lllllllllllllllIlIlIIlIIllIlllIl;
                                lllllllllllllllIlIlIIlIIllllIIlI = lllllllllllllllIlIlIIlIIlllIllII;
                                lllllllllllllllIlIlIIlIIllllIIIl = lllllllllllllllIlIlIIlIIlllIlIII;
                                lllllllllllllllIlIlIIlIIllllIIII = lllllllllllllllIlIlIIlIIlllIlIlI;
                                lllllllllllllllIlIlIIlIIlllIllll = lllllllllllllllIlIlIIlIIlllIIlll % 4;
                            }
                        }
                    }
                }
            }
        }
        if (lllllllllllllllIlIlIIlIIllllIllI < 0.0) {
            for (int lllllllllllllllIlIlIIlIIllIlllII = lllllllllllllllIlIlIIlIIllllIlIl - 16; lllllllllllllllIlIlIIlIIllIlllII <= lllllllllllllllIlIlIIlIIllllIlIl + 16; ++lllllllllllllllIlIlIIlIIllIlllII) {
                final double lllllllllllllllIlIlIIlIIllIllIll = lllllllllllllllIlIlIIlIIllIlllII + 0.5 - lllllllllllllllIlIlIIlIIlllllIII.posX;
                for (int lllllllllllllllIlIlIIlIIllIllIlI = lllllllllllllllIlIlIIlIIllllIIll - 16; lllllllllllllllIlIlIIlIIllIllIlI <= lllllllllllllllIlIlIIlIIllllIIll + 16; ++lllllllllllllllIlIlIIlIIllIllIlI) {
                    final double lllllllllllllllIlIlIIlIIllIllIIl = lllllllllllllllIlIlIIlIIllIllIlI + 0.5 - lllllllllllllllIlIlIIlIIlllllIII.posZ;
                Label_0819:
                    for (int lllllllllllllllIlIlIIlIIllIllIII = this.worldServerInstance.getActualHeight() - 1; lllllllllllllllIlIlIIlIIllIllIII >= 0; --lllllllllllllllIlIlIIlIIllIllIII) {
                        if (this.worldServerInstance.isAirBlock(lllllllllllllllIlIlIIlIIlllIllIl.setPos(lllllllllllllllIlIlIIlIIllIlllII, lllllllllllllllIlIlIIlIIllIllIII, lllllllllllllllIlIlIIlIIllIllIlI))) {
                            while (lllllllllllllllIlIlIIlIIllIllIII > 0 && this.worldServerInstance.isAirBlock(lllllllllllllllIlIlIIlIIlllIllIl.setPos(lllllllllllllllIlIlIIlIIllIlllII, lllllllllllllllIlIlIIlIIllIllIII - 1, lllllllllllllllIlIlIIlIIllIllIlI))) {
                                --lllllllllllllllIlIlIIlIIllIllIII;
                            }
                            for (int lllllllllllllllIlIlIIlIIllIlIlll = lllllllllllllllIlIlIIlIIlllIlllI; lllllllllllllllIlIlIIlIIllIlIlll < lllllllllllllllIlIlIIlIIlllIlllI + 2; ++lllllllllllllllIlIlIIlIIllIlIlll) {
                                final int lllllllllllllllIlIlIIlIIllIlIllI = lllllllllllllllIlIlIIlIIllIlIlll % 2;
                                final int lllllllllllllllIlIlIIlIIllIlIlIl = 1 - lllllllllllllllIlIlIIlIIllIlIllI;
                                for (int lllllllllllllllIlIlIIlIIllIlIlII = 0; lllllllllllllllIlIlIIlIIllIlIlII < 4; ++lllllllllllllllIlIlIIlIIllIlIlII) {
                                    for (int lllllllllllllllIlIlIIlIIllIlIIll = -1; lllllllllllllllIlIlIIlIIllIlIIll < 4; ++lllllllllllllllIlIlIIlIIllIlIIll) {
                                        final int lllllllllllllllIlIlIIlIIllIlIIlI = lllllllllllllllIlIlIIlIIllIlllII + (lllllllllllllllIlIlIIlIIllIlIlII - 1) * lllllllllllllllIlIlIIlIIllIlIllI;
                                        final int lllllllllllllllIlIlIIlIIllIlIIIl = lllllllllllllllIlIlIIlIIllIllIII + lllllllllllllllIlIlIIlIIllIlIIll;
                                        final int lllllllllllllllIlIlIIlIIllIlIIII = lllllllllllllllIlIlIIlIIllIllIlI + (lllllllllllllllIlIlIIlIIllIlIlII - 1) * lllllllllllllllIlIlIIlIIllIlIlIl;
                                        lllllllllllllllIlIlIIlIIlllIllIl.setPos(lllllllllllllllIlIlIIlIIllIlIIlI, lllllllllllllllIlIlIIlIIllIlIIIl, lllllllllllllllIlIlIIlIIllIlIIII);
                                        if (lllllllllllllllIlIlIIlIIllIlIIll < 0 && !this.worldServerInstance.getBlockState(lllllllllllllllIlIlIIlIIlllIllIl).getMaterial().isSolid()) {
                                            continue Label_0819;
                                        }
                                        if (lllllllllllllllIlIlIIlIIllIlIIll >= 0 && !this.worldServerInstance.isAirBlock(lllllllllllllllIlIlIIlIIlllIllIl)) {
                                            continue Label_0819;
                                        }
                                    }
                                }
                                final double lllllllllllllllIlIlIIlIIllIIllll = lllllllllllllllIlIlIIlIIllIllIII + 0.5 - lllllllllllllllIlIlIIlIIlllllIII.posY;
                                final double lllllllllllllllIlIlIIlIIllIIlllI = lllllllllllllllIlIlIIlIIllIllIll * lllllllllllllllIlIlIIlIIllIllIll + lllllllllllllllIlIlIIlIIllIIllll * lllllllllllllllIlIlIIlIIllIIllll + lllllllllllllllIlIlIIlIIllIllIIl * lllllllllllllllIlIlIIlIIllIllIIl;
                                if (lllllllllllllllIlIlIIlIIllllIllI < 0.0 || lllllllllllllllIlIlIIlIIllIIlllI < lllllllllllllllIlIlIIlIIllllIllI) {
                                    lllllllllllllllIlIlIIlIIllllIllI = lllllllllllllllIlIlIIlIIllIIlllI;
                                    lllllllllllllllIlIlIIlIIllllIIlI = lllllllllllllllIlIlIIlIIllIlllII;
                                    lllllllllllllllIlIlIIlIIllllIIIl = lllllllllllllllIlIlIIlIIllIllIII;
                                    lllllllllllllllIlIlIIlIIllllIIII = lllllllllllllllIlIlIIlIIllIllIlI;
                                    lllllllllllllllIlIlIIlIIlllIllll = lllllllllllllllIlIlIIlIIllIlIlll % 2;
                                }
                            }
                        }
                    }
                }
            }
        }
        final int lllllllllllllllIlIlIIlIIllIIllIl = lllllllllllllllIlIlIIlIIllllIIlI;
        int lllllllllllllllIlIlIIlIIllIIllII = lllllllllllllllIlIlIIlIIllllIIIl;
        final int lllllllllllllllIlIlIIlIIllIIlIll = lllllllllllllllIlIlIIlIIllllIIII;
        int lllllllllllllllIlIlIIlIIllIIlIlI = lllllllllllllllIlIlIIlIIlllIllll % 2;
        int lllllllllllllllIlIlIIlIIllIIlIIl = 1 - lllllllllllllllIlIlIIlIIllIIlIlI;
        if (lllllllllllllllIlIlIIlIIlllIllll % 4 >= 2) {
            lllllllllllllllIlIlIIlIIllIIlIlI = -lllllllllllllllIlIlIIlIIllIIlIlI;
            lllllllllllllllIlIlIIlIIllIIlIIl = -lllllllllllllllIlIlIIlIIllIIlIIl;
        }
        if (lllllllllllllllIlIlIIlIIllllIllI < 0.0) {
            lllllllllllllllIlIlIIlIIllllIIIl = (lllllllllllllllIlIlIIlIIllIIllII = MathHelper.clamp(lllllllllllllllIlIlIIlIIllllIIIl, 70, this.worldServerInstance.getActualHeight() - 10));
            for (int lllllllllllllllIlIlIIlIIllIIlIII = -1; lllllllllllllllIlIlIIlIIllIIlIII <= 1; ++lllllllllllllllIlIlIIlIIllIIlIII) {
                for (int lllllllllllllllIlIlIIlIIllIIIlll = 1; lllllllllllllllIlIlIIlIIllIIIlll < 3; ++lllllllllllllllIlIlIIlIIllIIIlll) {
                    for (int lllllllllllllllIlIlIIlIIllIIIllI = -1; lllllllllllllllIlIlIIlIIllIIIllI < 3; ++lllllllllllllllIlIlIIlIIllIIIllI) {
                        final int lllllllllllllllIlIlIIlIIllIIIlIl = lllllllllllllllIlIlIIlIIllIIllIl + (lllllllllllllllIlIlIIlIIllIIIlll - 1) * lllllllllllllllIlIlIIlIIllIIlIlI + lllllllllllllllIlIlIIlIIllIIlIII * lllllllllllllllIlIlIIlIIllIIlIIl;
                        final int lllllllllllllllIlIlIIlIIllIIIlII = lllllllllllllllIlIlIIlIIllIIllII + lllllllllllllllIlIlIIlIIllIIIllI;
                        final int lllllllllllllllIlIlIIlIIllIIIIll = lllllllllllllllIlIlIIlIIllIIlIll + (lllllllllllllllIlIlIIlIIllIIIlll - 1) * lllllllllllllllIlIlIIlIIllIIlIIl - lllllllllllllllIlIlIIlIIllIIlIII * lllllllllllllllIlIlIIlIIllIIlIlI;
                        final boolean lllllllllllllllIlIlIIlIIllIIIIlI = lllllllllllllllIlIlIIlIIllIIIllI < 0;
                        this.worldServerInstance.setBlockState(new BlockPos(lllllllllllllllIlIlIIlIIllIIIlIl, lllllllllllllllIlIlIIlIIllIIIlII, lllllllllllllllIlIlIIlIIllIIIIll), lllllllllllllllIlIlIIlIIllIIIIlI ? Blocks.OBSIDIAN.getDefaultState() : Blocks.AIR.getDefaultState());
                    }
                }
            }
        }
        final IBlockState lllllllllllllllIlIlIIlIIllIIIIIl = Blocks.PORTAL.getDefaultState().withProperty(BlockPortal.AXIS, (lllllllllllllllIlIlIIlIIllIIlIlI == 0) ? EnumFacing.Axis.Z : EnumFacing.Axis.X);
        for (int lllllllllllllllIlIlIIlIIllIIIIII = 0; lllllllllllllllIlIlIIlIIllIIIIII < 4; ++lllllllllllllllIlIlIIlIIllIIIIII) {
            for (int lllllllllllllllIlIlIIlIIlIllllll = 0; lllllllllllllllIlIlIIlIIlIllllll < 4; ++lllllllllllllllIlIlIIlIIlIllllll) {
                for (int lllllllllllllllIlIlIIlIIlIlllllI = -1; lllllllllllllllIlIlIIlIIlIlllllI < 4; ++lllllllllllllllIlIlIIlIIlIlllllI) {
                    final int lllllllllllllllIlIlIIlIIlIllllIl = lllllllllllllllIlIlIIlIIllIIllIl + (lllllllllllllllIlIlIIlIIlIllllll - 1) * lllllllllllllllIlIlIIlIIllIIlIlI;
                    final int lllllllllllllllIlIlIIlIIlIllllII = lllllllllllllllIlIlIIlIIllIIllII + lllllllllllllllIlIlIIlIIlIlllllI;
                    final int lllllllllllllllIlIlIIlIIlIlllIll = lllllllllllllllIlIlIIlIIllIIlIll + (lllllllllllllllIlIlIIlIIlIllllll - 1) * lllllllllllllllIlIlIIlIIllIIlIIl;
                    final boolean lllllllllllllllIlIlIIlIIlIlllIlI = lllllllllllllllIlIlIIlIIlIllllll == 0 || lllllllllllllllIlIlIIlIIlIllllll == 3 || lllllllllllllllIlIlIIlIIlIlllllI == -1 || lllllllllllllllIlIlIIlIIlIlllllI == 3;
                    this.worldServerInstance.setBlockState(new BlockPos(lllllllllllllllIlIlIIlIIlIllllIl, lllllllllllllllIlIlIIlIIlIllllII, lllllllllllllllIlIlIIlIIlIlllIll), lllllllllllllllIlIlIIlIIlIlllIlI ? Blocks.OBSIDIAN.getDefaultState() : lllllllllllllllIlIlIIlIIllIIIIIl, 2);
                }
            }
            for (int lllllllllllllllIlIlIIlIIlIlllIIl = 0; lllllllllllllllIlIlIIlIIlIlllIIl < 4; ++lllllllllllllllIlIlIIlIIlIlllIIl) {
                for (int lllllllllllllllIlIlIIlIIlIlllIII = -1; lllllllllllllllIlIlIIlIIlIlllIII < 4; ++lllllllllllllllIlIlIIlIIlIlllIII) {
                    final int lllllllllllllllIlIlIIlIIlIllIlll = lllllllllllllllIlIlIIlIIllIIllIl + (lllllllllllllllIlIlIIlIIlIlllIIl - 1) * lllllllllllllllIlIlIIlIIllIIlIlI;
                    final int lllllllllllllllIlIlIIlIIlIllIllI = lllllllllllllllIlIlIIlIIllIIllII + lllllllllllllllIlIlIIlIIlIlllIII;
                    final int lllllllllllllllIlIlIIlIIlIllIlIl = lllllllllllllllIlIlIIlIIllIIlIll + (lllllllllllllllIlIlIIlIIlIlllIIl - 1) * lllllllllllllllIlIlIIlIIllIIlIIl;
                    final BlockPos lllllllllllllllIlIlIIlIIlIllIlII = new BlockPos(lllllllllllllllIlIlIIlIIlIllIlll, lllllllllllllllIlIlIIlIIlIllIllI, lllllllllllllllIlIlIIlIIlIllIlIl);
                    this.worldServerInstance.notifyNeighborsOfStateChange(lllllllllllllllIlIlIIlIIlIllIlII, this.worldServerInstance.getBlockState(lllllllllllllllIlIlIIlIIlIllIlII).getBlock(), false);
                }
            }
        }
        return true;
    }
    
    public void removeStalePortalLocations(final long lllllllllllllllIlIlIIlIIlIIlIIII) {
        if (lllllllllllllllIlIlIIlIIlIIlIIII % 100L == 0L) {
            final long lllllllllllllllIlIlIIlIIlIIIllll = lllllllllllllllIlIlIIlIIlIIlIIII - 300L;
            final ObjectIterator<PortalPosition> lllllllllllllllIlIlIIlIIlIIIlllI = (ObjectIterator<PortalPosition>)this.destinationCoordinateCache.values().iterator();
            while (lllllllllllllllIlIlIIlIIlIIIlllI.hasNext()) {
                final PortalPosition lllllllllllllllIlIlIIlIIlIIIllIl = (PortalPosition)lllllllllllllllIlIlIIlIIlIIIlllI.next();
                if (lllllllllllllllIlIlIIlIIlIIIllIl == null || lllllllllllllllIlIlIIlIIlIIIllIl.lastUpdateTime < lllllllllllllllIlIlIIlIIlIIIllll) {
                    lllllllllllllllIlIlIIlIIlIIIlllI.remove();
                }
            }
        }
    }
    
    public Teleporter(final WorldServer lllllllllllllllIlIlIIlIllIIlIIll) {
        this.destinationCoordinateCache = (Long2ObjectMap<PortalPosition>)new Long2ObjectOpenHashMap(4096);
        this.worldServerInstance = lllllllllllllllIlIlIIlIllIIlIIll;
        this.random = new Random(lllllllllllllllIlIlIIlIllIIlIIll.getSeed());
    }
    
    public class PortalPosition extends BlockPos
    {
        public /* synthetic */ long lastUpdateTime;
        
        public PortalPosition(final BlockPos lllllllllllIllIIllIllIIIllIIllII, final long lllllllllllIllIIllIllIIIllIIlIll) {
            super(lllllllllllIllIIllIllIIIllIIllII.getX(), lllllllllllIllIIllIllIIIllIIllII.getY(), lllllllllllIllIIllIllIIIllIIllII.getZ());
            this.lastUpdateTime = lllllllllllIllIIllIllIIIllIIlIll;
        }
    }
}
