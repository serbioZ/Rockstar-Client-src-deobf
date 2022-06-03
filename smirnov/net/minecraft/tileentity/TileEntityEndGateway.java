// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.tileentity;

import java.util.List;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.gen.feature.WorldGenEndGateway;
import org.apache.logging.log4j.LogManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.EnumFacing;
import javax.annotation.Nullable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.chunk.Chunk;
import java.util.Random;
import net.minecraft.world.gen.feature.WorldGenEndIsland;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldProviderEnd;
import net.minecraft.entity.Entity;
import org.apache.logging.log4j.Logger;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ITickable;

public class TileEntityEndGateway extends TileEntityEndPortal implements ITickable
{
    private /* synthetic */ BlockPos exitPortal;
    private /* synthetic */ int teleportCooldown;
    private static final /* synthetic */ Logger LOG;
    private /* synthetic */ boolean exactTeleport;
    private /* synthetic */ long age;
    
    public void triggerCooldown() {
        if (!this.world.isRemote) {
            this.teleportCooldown = 40;
            this.world.addBlockEvent(this.getPos(), this.getBlockType(), 1, 0);
            this.markDirty();
        }
    }
    
    public void teleportEntity(final Entity lllllllllllIlIlllIllIIIlIIlIlIII) {
        if (!this.world.isRemote && !this.isCoolingDown()) {
            this.teleportCooldown = 100;
            if (this.exitPortal == null && this.world.provider instanceof WorldProviderEnd) {
                this.findExitPortal();
            }
            if (this.exitPortal != null) {
                final BlockPos lllllllllllIlIlllIllIIIlIIlIlIlI = this.exactTeleport ? this.exitPortal : this.findExitPosition();
                lllllllllllIlIlllIllIIIlIIlIlIII.setPositionAndUpdate(lllllllllllIlIlllIllIIIlIIlIlIlI.getX() + 0.5, lllllllllllIlIlllIllIIIlIIlIlIlI.getY() + 0.5, lllllllllllIlIlllIllIIIlIIlIlIlI.getZ() + 0.5);
            }
            this.triggerCooldown();
        }
    }
    
    private void findExitPortal() {
        final Vec3d lllllllllllIlIlllIllIIIlIIIllIll = new Vec3d(this.getPos().getX(), 0.0, this.getPos().getZ()).normalize();
        Vec3d lllllllllllIlIlllIllIIIlIIIllIlI = lllllllllllIlIlllIllIIIlIIIllIll.scale(1024.0);
        for (int lllllllllllIlIlllIllIIIlIIIllIIl = 16; getChunk(this.world, lllllllllllIlIlllIllIIIlIIIllIlI).getTopFilledSegment() > 0 && lllllllllllIlIlllIllIIIlIIIllIIl-- > 0; lllllllllllIlIlllIllIIIlIIIllIlI = lllllllllllIlIlllIllIIIlIIIllIlI.add(lllllllllllIlIlllIllIIIlIIIllIll.scale(-16.0))) {
            TileEntityEndGateway.LOG.debug("Skipping backwards past nonempty chunk at {}", (Object)lllllllllllIlIlllIllIIIlIIIllIlI);
        }
        for (int lllllllllllIlIlllIllIIIlIIIllIII = 16; getChunk(this.world, lllllllllllIlIlllIllIIIlIIIllIlI).getTopFilledSegment() == 0 && lllllllllllIlIlllIllIIIlIIIllIII-- > 0; lllllllllllIlIlllIllIIIlIIIllIlI = lllllllllllIlIlllIllIIIlIIIllIlI.add(lllllllllllIlIlllIllIIIlIIIllIll.scale(16.0))) {
            TileEntityEndGateway.LOG.debug("Skipping forward past empty chunk at {}", (Object)lllllllllllIlIlllIllIIIlIIIllIlI);
        }
        TileEntityEndGateway.LOG.debug("Found chunk at {}", (Object)lllllllllllIlIlllIllIIIlIIIllIlI);
        final Chunk lllllllllllIlIlllIllIIIlIIIlIlll = getChunk(this.world, lllllllllllIlIlllIllIIIlIIIllIlI);
        this.exitPortal = findSpawnpointInChunk(lllllllllllIlIlllIllIIIlIIIlIlll);
        if (this.exitPortal == null) {
            this.exitPortal = new BlockPos(lllllllllllIlIlllIllIIIlIIIllIlI.xCoord + 0.5, 75.0, lllllllllllIlIlllIllIIIlIIIllIlI.zCoord + 0.5);
            TileEntityEndGateway.LOG.debug("Failed to find suitable block, settling on {}", (Object)this.exitPortal);
            new WorldGenEndIsland().generate(this.world, new Random(this.exitPortal.toLong()), this.exitPortal);
        }
        else {
            TileEntityEndGateway.LOG.debug("Found block at {}", (Object)this.exitPortal);
        }
        this.exitPortal = findHighestBlock(this.world, this.exitPortal, 16, true);
        TileEntityEndGateway.LOG.debug("Creating portal at {}", (Object)this.exitPortal);
        this.exitPortal = this.exitPortal.up(10);
        this.createExitPortal(this.exitPortal);
        this.markDirty();
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound lllllllllllIlIlllIllIIIlIllIIIll) {
        super.readFromNBT(lllllllllllIlIlllIllIIIlIllIIIll);
        this.age = lllllllllllIlIlllIllIIIlIllIIIll.getLong("Age");
        if (lllllllllllIlIlllIllIIIlIllIIIll.hasKey("ExitPortal", 10)) {
            this.exitPortal = NBTUtil.getPosFromTag(lllllllllllIlIlllIllIIIlIllIIIll.getCompoundTag("ExitPortal"));
        }
        this.exactTeleport = lllllllllllIlIlllIllIIIlIllIIIll.getBoolean("ExactTeleport");
    }
    
    private static Chunk getChunk(final World lllllllllllIlIlllIllIIIIllllIIlI, final Vec3d lllllllllllIlIlllIllIIIIllllIIIl) {
        return lllllllllllIlIlllIllIIIIllllIIlI.getChunkFromChunkCoords(MathHelper.floor(lllllllllllIlIlllIllIIIIllllIIIl.xCoord / 16.0), MathHelper.floor(lllllllllllIlIlllIllIIIIllllIIIl.zCoord / 16.0));
    }
    
    @Override
    public NBTTagCompound writeToNBT(final NBTTagCompound lllllllllllIlIlllIllIIIlIllIlIIl) {
        super.writeToNBT(lllllllllllIlIlllIllIIIlIllIlIIl);
        lllllllllllIlIlllIllIIIlIllIlIIl.setLong("Age", this.age);
        if (this.exitPortal != null) {
            lllllllllllIlIlllIllIIIlIllIlIIl.setTag("ExitPortal", NBTUtil.createPosTag(this.exitPortal));
        }
        if (this.exactTeleport) {
            lllllllllllIlIlllIllIIIlIllIlIIl.setBoolean("ExactTeleport", this.exactTeleport);
        }
        return lllllllllllIlIlllIllIIIlIllIlIIl;
    }
    
    @Nullable
    private static BlockPos findSpawnpointInChunk(final Chunk lllllllllllIlIlllIllIIIIlllIIlII) {
        final BlockPos lllllllllllIlIlllIllIIIIlllIIIll = new BlockPos(lllllllllllIlIlllIllIIIIlllIIlII.xPosition * 16, 30, lllllllllllIlIlllIllIIIIlllIIlII.zPosition * 16);
        final int lllllllllllIlIlllIllIIIIlllIIIlI = lllllllllllIlIlllIllIIIIlllIIlII.getTopFilledSegment() + 16 - 1;
        final BlockPos lllllllllllIlIlllIllIIIIlllIIIIl = new BlockPos(lllllllllllIlIlllIllIIIIlllIIlII.xPosition * 16 + 16 - 1, lllllllllllIlIlllIllIIIIlllIIIlI, lllllllllllIlIlllIllIIIIlllIIlII.zPosition * 16 + 16 - 1);
        BlockPos lllllllllllIlIlllIllIIIIlllIIIII = null;
        double lllllllllllIlIlllIllIIIIllIlllll = 0.0;
        for (final BlockPos lllllllllllIlIlllIllIIIIllIllllI : BlockPos.getAllInBox(lllllllllllIlIlllIllIIIIlllIIIll, lllllllllllIlIlllIllIIIIlllIIIIl)) {
            final IBlockState lllllllllllIlIlllIllIIIIllIlllIl = lllllllllllIlIlllIllIIIIlllIIlII.getBlockState(lllllllllllIlIlllIllIIIIllIllllI);
            if (lllllllllllIlIlllIllIIIIllIlllIl.getBlock() == Blocks.END_STONE && !lllllllllllIlIlllIllIIIIlllIIlII.getBlockState(lllllllllllIlIlllIllIIIIllIllllI.up(1)).isBlockNormalCube() && !lllllllllllIlIlllIllIIIIlllIIlII.getBlockState(lllllllllllIlIlllIllIIIIllIllllI.up(2)).isBlockNormalCube()) {
                final double lllllllllllIlIlllIllIIIIllIlllII = lllllllllllIlIlllIllIIIIllIllllI.distanceSqToCenter(0.0, 0.0, 0.0);
                if (lllllllllllIlIlllIllIIIIlllIIIII != null && lllllllllllIlIlllIllIIIIllIlllII >= lllllllllllIlIlllIllIIIIllIlllll) {
                    continue;
                }
                lllllllllllIlIlllIllIIIIlllIIIII = lllllllllllIlIlllIllIIIIllIllllI;
                lllllllllllIlIlllIllIIIIllIlllll = lllllllllllIlIlllIllIIIIllIlllII;
            }
        }
        return lllllllllllIlIlllIllIIIIlllIIIII;
    }
    
    public boolean isSpawning() {
        return this.age < 200L;
    }
    
    private BlockPos findExitPosition() {
        final BlockPos lllllllllllIlIlllIllIIIlIIlIIIll = findHighestBlock(this.world, this.exitPortal, 5, false);
        TileEntityEndGateway.LOG.debug("Best exit position for portal at {} is {}", (Object)this.exitPortal, (Object)lllllllllllIlIlllIllIIIlIIlIIIll);
        return lllllllllllIlIlllIllIIIlIIlIIIll.up();
    }
    
    @Override
    public boolean shouldRenderFace(final EnumFacing lllllllllllIlIlllIllIIIIllIIIIlI) {
        return this.getBlockType().getDefaultState().shouldSideBeRendered(this.world, this.getPos(), lllllllllllIlIlllIllIIIIllIIIIlI);
    }
    
    @Override
    public boolean receiveClientEvent(final int lllllllllllIlIlllIllIIIlIIllIIIl, final int lllllllllllIlIlllIllIIIlIIllIIII) {
        if (lllllllllllIlIlllIllIIIlIIllIIIl == 1) {
            this.teleportCooldown = 40;
            return true;
        }
        return super.receiveClientEvent(lllllllllllIlIlllIllIIIlIIllIIIl, lllllllllllIlIlllIllIIIlIIllIIII);
    }
    
    private static BlockPos findHighestBlock(final World lllllllllllIlIlllIllIIIlIIIIlIII, final BlockPos lllllllllllIlIlllIllIIIlIIIIIlll, final int lllllllllllIlIlllIllIIIIllllllII, final boolean lllllllllllIlIlllIllIIIIlllllIll) {
        BlockPos lllllllllllIlIlllIllIIIlIIIIIlII = null;
        for (int lllllllllllIlIlllIllIIIlIIIIIIll = -lllllllllllIlIlllIllIIIIllllllII; lllllllllllIlIlllIllIIIlIIIIIIll <= lllllllllllIlIlllIllIIIIllllllII; ++lllllllllllIlIlllIllIIIlIIIIIIll) {
            for (int lllllllllllIlIlllIllIIIlIIIIIIlI = -lllllllllllIlIlllIllIIIIllllllII; lllllllllllIlIlllIllIIIlIIIIIIlI <= lllllllllllIlIlllIllIIIIllllllII; ++lllllllllllIlIlllIllIIIlIIIIIIlI) {
                if (lllllllllllIlIlllIllIIIlIIIIIIll != 0 || lllllllllllIlIlllIllIIIlIIIIIIlI != 0 || lllllllllllIlIlllIllIIIIlllllIll) {
                    for (int lllllllllllIlIlllIllIIIlIIIIIIIl = 255; lllllllllllIlIlllIllIIIlIIIIIIIl > ((lllllllllllIlIlllIllIIIlIIIIIlII == null) ? 0 : lllllllllllIlIlllIllIIIlIIIIIlII.getY()); --lllllllllllIlIlllIllIIIlIIIIIIIl) {
                        final BlockPos lllllllllllIlIlllIllIIIlIIIIIIII = new BlockPos(lllllllllllIlIlllIllIIIlIIIIIlll.getX() + lllllllllllIlIlllIllIIIlIIIIIIll, lllllllllllIlIlllIllIIIlIIIIIIIl, lllllllllllIlIlllIllIIIlIIIIIlll.getZ() + lllllllllllIlIlllIllIIIlIIIIIIlI);
                        final IBlockState lllllllllllIlIlllIllIIIIllllllll = lllllllllllIlIlllIllIIIlIIIIlIII.getBlockState(lllllllllllIlIlllIllIIIlIIIIIIII);
                        if (lllllllllllIlIlllIllIIIIllllllll.isBlockNormalCube() && (lllllllllllIlIlllIllIIIIlllllIll || lllllllllllIlIlllIllIIIIllllllll.getBlock() != Blocks.BEDROCK)) {
                            lllllllllllIlIlllIllIIIlIIIIIlII = lllllllllllIlIlllIllIIIlIIIIIIII;
                            break;
                        }
                    }
                }
            }
        }
        return (lllllllllllIlIlllIllIIIlIIIIIlII == null) ? lllllllllllIlIlllIllIIIlIIIIIlll : lllllllllllIlIlllIllIIIlIIIIIlII;
    }
    
    public float getSpawnPercent(final float lllllllllllIlIlllIllIIIlIlIIlIlI) {
        return MathHelper.clamp((this.age + lllllllllllIlIlllIllIIIlIlIIlIlI) / 200.0f, 0.0f, 1.0f);
    }
    
    @Override
    public double getMaxRenderDistanceSquared() {
        return 65536.0;
    }
    
    public int getParticleAmount() {
        int lllllllllllIlIlllIllIIIIlIlllIII = 0;
        Exception lllllllllllIlIlllIllIIIIlIllIIIl;
        for (boolean lllllllllllIlIlllIllIIIIlIllIIlI = ((EnumFacing[])(Object)(lllllllllllIlIlllIllIIIIlIllIIIl = (Exception)(Object)EnumFacing.values())).length != 0, lllllllllllIlIlllIllIIIIlIllIIll = false; lllllllllllIlIlllIllIIIIlIllIIll < lllllllllllIlIlllIllIIIIlIllIIlI; ++lllllllllllIlIlllIllIIIIlIllIIll) {
            final EnumFacing lllllllllllIlIlllIllIIIIlIllIlll = lllllllllllIlIlllIllIIIIlIllIIIl[lllllllllllIlIlllIllIIIIlIllIIll];
            lllllllllllIlIlllIllIIIIlIlllIII += (this.shouldRenderFace(lllllllllllIlIlllIllIIIIlIllIlll) ? 1 : 0);
        }
        return lllllllllllIlIlllIllIIIIlIlllIII;
    }
    
    @Nullable
    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        return new SPacketUpdateTileEntity(this.pos, 8, this.getUpdateTag());
    }
    
    public boolean isCoolingDown() {
        return this.teleportCooldown > 0;
    }
    
    public void func_190603_b(final BlockPos lllllllllllIlIlllIllIIIIlIlIllIl) {
        this.exactTeleport = true;
        this.exitPortal = lllllllllllIlIlllIllIIIIlIlIllIl;
    }
    
    static {
        LOG = LogManager.getLogger();
    }
    
    public float getCooldownPercent(final float lllllllllllIlIlllIllIIIlIlIIIIlI) {
        return 1.0f - MathHelper.clamp((this.teleportCooldown - lllllllllllIlIlllIllIIIlIlIIIIlI) / 40.0f, 0.0f, 1.0f);
    }
    
    @Override
    public NBTTagCompound getUpdateTag() {
        return this.writeToNBT(new NBTTagCompound());
    }
    
    private void createExitPortal(final BlockPos lllllllllllIlIlllIllIIIIllIIllII) {
        new WorldGenEndGateway().generate(this.world, new Random(), lllllllllllIlIlllIllIIIIllIIllII);
        final TileEntity lllllllllllIlIlllIllIIIIllIIlIll = this.world.getTileEntity(lllllllllllIlIlllIllIIIIllIIllII);
        if (lllllllllllIlIlllIllIIIIllIIlIll instanceof TileEntityEndGateway) {
            final TileEntityEndGateway lllllllllllIlIlllIllIIIIllIIlIlI = (TileEntityEndGateway)lllllllllllIlIlllIllIIIIllIIlIll;
            lllllllllllIlIlllIllIIIIllIIlIlI.exitPortal = new BlockPos(this.getPos());
            lllllllllllIlIlllIllIIIIllIIlIlI.markDirty();
        }
        else {
            TileEntityEndGateway.LOG.warn("Couldn't save exit portal at {}", (Object)lllllllllllIlIlllIllIIIIllIIllII);
        }
    }
    
    @Override
    public void update() {
        final boolean lllllllllllIlIlllIllIIIlIlIllIlI = this.isSpawning();
        final boolean lllllllllllIlIlllIllIIIlIlIllIIl = this.isCoolingDown();
        ++this.age;
        if (lllllllllllIlIlllIllIIIlIlIllIIl) {
            --this.teleportCooldown;
        }
        else if (!this.world.isRemote) {
            final List<Entity> lllllllllllIlIlllIllIIIlIlIllIII = this.world.getEntitiesWithinAABB((Class<? extends Entity>)Entity.class, new AxisAlignedBB(this.getPos()));
            if (!lllllllllllIlIlllIllIIIlIlIllIII.isEmpty()) {
                this.teleportEntity(lllllllllllIlIlllIllIIIlIlIllIII.get(0));
            }
            if (this.age % 2400L == 0L) {
                this.triggerCooldown();
            }
        }
        if (lllllllllllIlIlllIllIIIlIlIllIlI != this.isSpawning() || lllllllllllIlIlllIllIIIlIlIllIIl != this.isCoolingDown()) {
            this.markDirty();
        }
    }
}
