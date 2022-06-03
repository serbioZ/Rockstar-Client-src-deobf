// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world;

import net.minecraft.util.math.Vec3i;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.entity.player.EntityPlayerMP;
import com.google.common.base.MoreObjects;
import java.util.UUID;
import net.minecraft.block.BlockObserver;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockLiquid;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.util.SoundCategory;
import net.minecraft.entity.EntityLiving;
import net.minecraft.network.Packet;
import net.minecraft.world.storage.WorldSavedData;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.util.EnumFacing;
import ru.rockstar.api.event.event.EventRenderWorldLight;
import java.util.Collection;
import java.util.Iterator;
import net.minecraft.init.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;
import net.minecraft.util.EntitySelectors;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.init.Biomes;
import net.minecraft.util.ReportedException;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.crash.ICrashReportDetail;
import net.minecraft.crash.CrashReport;
import net.minecraft.world.biome.Biome;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.SoundEvent;
import com.google.common.collect.Lists;
import net.minecraft.util.math.AxisAlignedBB;
import javax.annotation.Nullable;
import com.google.common.base.Predicate;
import com.google.common.base.Function;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.border.WorldBorder;
import net.minecraft.advancements.FunctionManager;
import net.minecraft.world.storage.ISaveHandler;
import net.minecraft.world.storage.loot.LootTableManager;
import java.util.Calendar;
import net.minecraft.util.IntHashMap;
import net.minecraft.world.storage.WorldInfo;
import net.minecraft.pathfinding.PathWorldListener;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.advancements.AdvancementManager;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.storage.MapStorage;
import net.minecraft.profiler.Profiler;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.entity.Entity;
import java.util.List;
import java.util.Random;
import net.minecraft.village.VillageCollection;

public abstract class World implements IBlockAccess
{
    public final /* synthetic */ boolean isRemote;
    protected /* synthetic */ boolean spawnPeacefulMobs;
    protected /* synthetic */ VillageCollection villageCollectionObj;
    protected /* synthetic */ float thunderingStrength;
    public final /* synthetic */ Random rand;
    public final /* synthetic */ List<Entity> weatherEffects;
    public final /* synthetic */ List<TileEntity> loadedTileEntityList;
    public final /* synthetic */ Profiler theProfiler;
    public final /* synthetic */ WorldProvider provider;
    private /* synthetic */ int skylightSubtracted;
    private /* synthetic */ int lastLightningBolt;
    public final /* synthetic */ List<TileEntity> tickableTileEntities;
    protected /* synthetic */ float rainingStrength;
    protected /* synthetic */ MapStorage mapStorage;
    protected /* synthetic */ IChunkProvider chunkProvider;
    protected /* synthetic */ boolean spawnHostileMobs;
    protected /* synthetic */ boolean scheduledUpdatesAreImmediate;
    protected /* synthetic */ int updateLCG;
    protected /* synthetic */ Scoreboard worldScoreboard;
    protected /* synthetic */ float prevRainingStrength;
    protected /* synthetic */ PathWorldListener pathListener;
    protected /* synthetic */ WorldInfo worldInfo;
    protected final /* synthetic */ IntHashMap<Entity> entitiesById;
    private final /* synthetic */ Calendar theCalendar;
    protected /* synthetic */ LootTableManager lootTable;
    protected /* synthetic */ float prevThunderingStrength;
    protected final /* synthetic */ ISaveHandler saveHandler;
    private /* synthetic */ boolean processingLoadedTiles;
    private /* synthetic */ int seaLevel;
    protected final /* synthetic */ List<Entity> unloadedEntityList;
    private final /* synthetic */ List<TileEntity> addedTileEntityList;
    /* synthetic */ int[] lightUpdateBlockList;
    private final /* synthetic */ WorldBorder worldBorder;
    public final /* synthetic */ List<EntityPlayer> playerEntities;
    public final /* synthetic */ List<Entity> loadedEntityList;
    private final /* synthetic */ List<TileEntity> tileEntitiesToBeRemoved;
    protected /* synthetic */ List<IWorldEventListener> eventListeners;
    
    public boolean canBlockSeeSky(final BlockPos lllllllllllIllIIIlIlIIIlllIIlIIl) {
        if (lllllllllllIllIIIlIlIIIlllIIlIIl.getY() >= this.getSeaLevel()) {
            return this.canSeeSky(lllllllllllIllIIIlIlIIIlllIIlIIl);
        }
        final BlockPos lllllllllllIllIIIlIlIIIlllIIlIII = new BlockPos(lllllllllllIllIIIlIlIIIlllIIlIIl.getX(), this.getSeaLevel(), lllllllllllIllIIIlIlIIIlllIIlIIl.getZ());
        if (!this.canSeeSky(lllllllllllIllIIIlIlIIIlllIIlIII)) {
            return false;
        }
        for (BlockPos lllllllllllIllIIIlIlIIIlllIIIlll = lllllllllllIllIIIlIlIIIlllIIlIII.down(); lllllllllllIllIIIlIlIIIlllIIIlll.getY() > lllllllllllIllIIIlIlIIIlllIIlIIl.getY(); lllllllllllIllIIIlIlIIIlllIIIlll = lllllllllllIllIIIlIlIIIlllIIIlll.down()) {
            final IBlockState lllllllllllIllIIIlIlIIIlllIIIllI = this.getBlockState(lllllllllllIllIIIlIlIIIlllIIIlll);
            if (lllllllllllIllIIIlIlIIIlllIIIllI.getLightOpacity() > 0 && !lllllllllllIllIIIlIlIIIlllIIIllI.getMaterial().isLiquid()) {
                return false;
            }
        }
        return true;
    }
    
    public int getUniqueDataId(final String lllllllllllIllIIIlIIlIIIlIlIlllI) {
        return this.mapStorage.getUniqueDataId(lllllllllllIllIIIlIIlIIIlIlIlllI);
    }
    
    public void setSeaLevel(final int lllllllllllIllIIIlIIlIlIIlIlIIll) {
        this.seaLevel = lllllllllllIllIIIlIIlIlIIlIlIIll;
    }
    
    @Nullable
    public EntityPlayer getNearestAttackablePlayer(final BlockPos lllllllllllIllIIIlIIlIIllIIllIII, final double lllllllllllIllIIIlIIlIIllIIlIlll, final double lllllllllllIllIIIlIIlIIllIIllIlI) {
        return this.getNearestAttackablePlayer(lllllllllllIllIIIlIIlIIllIIllIII.getX() + 0.5f, lllllllllllIllIIIlIIlIIllIIllIII.getY() + 0.5f, lllllllllllIllIIIlIIlIIllIIllIII.getZ() + 0.5f, lllllllllllIllIIIlIIlIIllIIlIlll, lllllllllllIllIIIlIIlIIllIIllIlI, null, null);
    }
    
    public boolean isBlockLoaded(final BlockPos lllllllllllIllIIIlIlIIllIIIlllll, final boolean lllllllllllIllIIIlIlIIllIIlIIIIl) {
        return this.isChunkLoaded(lllllllllllIllIIIlIlIIllIIIlllll.getX() >> 4, lllllllllllIllIIIlIlIIllIIIlllll.getZ() >> 4, lllllllllllIllIIIlIlIIllIIlIIIIl);
    }
    
    public List<AxisAlignedBB> getCollisionBoxes(@Nullable final Entity lllllllllllIllIIIlIIllllIIlllllI, final AxisAlignedBB lllllllllllIllIIIlIIllllIlIIIlIl) {
        final List<AxisAlignedBB> lllllllllllIllIIIlIIllllIlIIIlII = (List<AxisAlignedBB>)Lists.newArrayList();
        this.func_191504_a(lllllllllllIllIIIlIIllllIIlllllI, lllllllllllIllIIIlIIllllIlIIIlIl, false, lllllllllllIllIIIlIIllllIlIIIlII);
        if (lllllllllllIllIIIlIIllllIIlllllI != null) {
            final List<Entity> lllllllllllIllIIIlIIllllIlIIIIll = this.getEntitiesWithinAABBExcludingEntity(lllllllllllIllIIIlIIllllIIlllllI, lllllllllllIllIIIlIIllllIlIIIlIl.expandXyz(0.25));
            for (int lllllllllllIllIIIlIIllllIlIIIIlI = 0; lllllllllllIllIIIlIIllllIlIIIIlI < lllllllllllIllIIIlIIllllIlIIIIll.size(); ++lllllllllllIllIIIlIIllllIlIIIIlI) {
                final Entity lllllllllllIllIIIlIIllllIlIIIIIl = lllllllllllIllIIIlIIllllIlIIIIll.get(lllllllllllIllIIIlIIllllIlIIIIlI);
                if (!lllllllllllIllIIIlIIllllIIlllllI.isRidingSameEntity(lllllllllllIllIIIlIIllllIlIIIIIl)) {
                    AxisAlignedBB lllllllllllIllIIIlIIllllIlIIIIII = lllllllllllIllIIIlIIllllIlIIIIIl.getCollisionBoundingBox();
                    if (lllllllllllIllIIIlIIllllIlIIIIII != null && lllllllllllIllIIIlIIllllIlIIIIII.intersectsWith(lllllllllllIllIIIlIIllllIlIIIlIl)) {
                        lllllllllllIllIIIlIIllllIlIIIlII.add(lllllllllllIllIIIlIIllllIlIIIIII);
                    }
                    lllllllllllIllIIIlIIllllIlIIIIII = lllllllllllIllIIIlIIllllIIlllllI.getCollisionBox(lllllllllllIllIIIlIIllllIlIIIIIl);
                    if (lllllllllllIllIIIlIIllllIlIIIIII != null && lllllllllllIllIIIlIIllllIlIIIIII.intersectsWith(lllllllllllIllIIIlIIllllIlIIIlIl)) {
                        lllllllllllIllIIIlIIllllIlIIIlII.add(lllllllllllIllIIIlIIllllIlIIIIII);
                    }
                }
            }
        }
        return lllllllllllIllIIIlIIllllIlIIIlII;
    }
    
    public int getLastLightningBolt() {
        return this.lastLightningBolt;
    }
    
    public long getWorldTime() {
        return this.worldInfo.getWorldTime();
    }
    
    public void removeTileEntity(final BlockPos lllllllllllIllIIIlIIllIIIllIIlll) {
        final TileEntity lllllllllllIllIIIlIIllIIIllIIllI = this.getTileEntity(lllllllllllIllIIIlIIllIIIllIIlll);
        if (lllllllllllIllIIIlIIllIIIllIIllI != null && this.processingLoadedTiles) {
            lllllllllllIllIIIlIIllIIIllIIllI.invalidate();
            this.addedTileEntityList.remove(lllllllllllIllIIIlIIllIIIllIIllI);
        }
        else {
            if (lllllllllllIllIIIlIIllIIIllIIllI != null) {
                this.addedTileEntityList.remove(lllllllllllIllIIIlIIllIIIllIIllI);
                this.loadedTileEntityList.remove(lllllllllllIllIIIlIIllIIIllIIllI);
                this.tickableTileEntities.remove(lllllllllllIllIIIlIIllIIIllIIllI);
            }
            this.getChunkFromBlockCoords(lllllllllllIllIIIlIIllIIIllIIlll).removeTileEntity(lllllllllllIllIIIlIIllIIIllIIlll);
        }
    }
    
    public void setWorldTime(final long lllllllllllIllIIIlIIlIIlIIlllIII) {
        this.worldInfo.setWorldTime(lllllllllllIllIIIlIIlIIlIIlllIII);
    }
    
    public boolean isAreaLoaded(final BlockPos lllllllllllIllIIIlIlIIllIIIIIIIl, final BlockPos lllllllllllIllIIIlIlIIllIIIIIIll) {
        return this.isAreaLoaded(lllllllllllIllIIIlIlIIllIIIIIIIl, lllllllllllIllIIIlIlIIllIIIIIIll, true);
    }
    
    public int getActualHeight() {
        return this.provider.getHasNoSky() ? 128 : 256;
    }
    
    public BlockPos getSpawnPoint() {
        BlockPos lllllllllllIllIIIlIIlIIlIIllIlII = new BlockPos(this.worldInfo.getSpawnX(), this.worldInfo.getSpawnY(), this.worldInfo.getSpawnZ());
        if (!this.getWorldBorder().contains(lllllllllllIllIIIlIIlIIlIIllIlII)) {
            lllllllllllIllIIIlIIlIIlIIllIlII = this.getHeight(new BlockPos(this.getWorldBorder().getCenterX(), 0.0, this.getWorldBorder().getCenterZ()));
        }
        return lllllllllllIllIIIlIIlIIlIIllIlII;
    }
    
    @Nullable
    public MapStorage getMapStorage() {
        return this.mapStorage;
    }
    
    public float getCelestialAngleRadians(final float lllllllllllIllIIIlIIlllIlIlllIII) {
        final float lllllllllllIllIIIlIIlllIlIlllIlI = this.getCelestialAngle(lllllllllllIllIIIlIIlllIlIlllIII);
        return lllllllllllIllIIIlIIlllIlIlllIlI * 6.2831855f;
    }
    
    public void playRecord(final BlockPos lllllllllllIllIIIlIlIIIIIllIIIIl, @Nullable final SoundEvent lllllllllllIllIIIlIlIIIIIlIlllII) {
        for (int lllllllllllIllIIIlIlIIIIIlIlllll = 0; lllllllllllIllIIIlIlIIIIIlIlllll < this.eventListeners.size(); ++lllllllllllIllIIIlIlIIIIIlIlllll) {
            this.eventListeners.get(lllllllllllIllIIIlIlIIIIIlIlllll).playRecord(lllllllllllIllIIIlIlIIIIIlIlllII, lllllllllllIllIIIlIlIIIIIllIIIIl);
        }
    }
    
    public boolean canBlockFreezeWater(final BlockPos lllllllllllIllIIIlIIllIIIIIIlIlI) {
        return this.canBlockFreeze(lllllllllllIllIIIlIIllIIIIIIlIlI, false);
    }
    
    private boolean isAreaLoaded(int lllllllllllIllIIIlIlIIlIllIIllll, final int lllllllllllIllIIIlIlIIlIllIllIII, int lllllllllllIllIIIlIlIIlIllIIllIl, int lllllllllllIllIIIlIlIIlIllIIllII, final int lllllllllllIllIIIlIlIIlIllIlIlIl, int lllllllllllIllIIIlIlIIlIllIIlIlI, final boolean lllllllllllIllIIIlIlIIlIllIlIIll) {
        if (lllllllllllIllIIIlIlIIlIllIlIlIl >= 0 && lllllllllllIllIIIlIlIIlIllIllIII < 256) {
            lllllllllllIllIIIlIlIIlIllIIllll >>= 4;
            lllllllllllIllIIIlIlIIlIllIIllIl >>= 4;
            lllllllllllIllIIIlIlIIlIllIIllII >>= (4 != 0);
            lllllllllllIllIIIlIlIIlIllIIlIlI >>= 4;
            for (int lllllllllllIllIIIlIlIIlIllIlIIlI = lllllllllllIllIIIlIlIIlIllIIllll; lllllllllllIllIIIlIlIIlIllIlIIlI <= (lllllllllllIllIIIlIlIIlIllIIllII ? 1 : 0); ++lllllllllllIllIIIlIlIIlIllIlIIlI) {
                for (int lllllllllllIllIIIlIlIIlIllIlIIIl = (int)lllllllllllIllIIIlIlIIlIllIIllIl; lllllllllllIllIIIlIlIIlIllIlIIIl <= lllllllllllIllIIIlIlIIlIllIIlIlI; ++lllllllllllIllIIIlIlIIlIllIlIIIl) {
                    if (!this.isChunkLoaded(lllllllllllIllIIIlIlIIlIllIlIIlI, lllllllllllIllIIIlIlIIlIllIlIIIl, lllllllllllIllIIIlIlIIlIllIlIIll)) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
    
    public int getSkylightSubtracted() {
        return this.skylightSubtracted;
    }
    
    public void joinEntityInSurroundings(final Entity lllllllllllIllIIIlIIlIIlIIlIIIll) {
        final int lllllllllllIllIIIlIIlIIlIIlIIIlI = MathHelper.floor(lllllllllllIllIIIlIIlIIlIIlIIIll.posX / 16.0);
        final int lllllllllllIllIIIlIIlIIlIIlIIIIl = MathHelper.floor(lllllllllllIllIIIlIIlIIlIIlIIIll.posZ / 16.0);
        final int lllllllllllIllIIIlIIlIIlIIlIIIII = 2;
        for (int lllllllllllIllIIIlIIlIIlIIIlllll = -2; lllllllllllIllIIIlIIlIIlIIIlllll <= 2; ++lllllllllllIllIIIlIIlIIlIIIlllll) {
            for (int lllllllllllIllIIIlIIlIIlIIIllllI = -2; lllllllllllIllIIIlIIlIIlIIIllllI <= 2; ++lllllllllllIllIIIlIIlIIlIIIllllI) {
                this.getChunkFromChunkCoords(lllllllllllIllIIIlIIlIIlIIlIIIlI + lllllllllllIllIIIlIIlIIlIIIlllll, lllllllllllIllIIIlIIlIIlIIlIIIIl + lllllllllllIllIIIlIIlIIlIIIllllI);
            }
        }
        if (!this.loadedEntityList.contains(lllllllllllIllIIIlIIlIIlIIlIIIll)) {
            this.loadedEntityList.add(lllllllllllIllIIIlIIlIIlIIlIIIll);
        }
    }
    
    public void setTotalWorldTime(final long lllllllllllIllIIIlIIlIIlIlIIlIIl) {
        this.worldInfo.setWorldTotalTime(lllllllllllIllIIIlIIlIIlIlIIlIIl);
    }
    
    public LootTableManager getLootTableManager() {
        return this.lootTable;
    }
    
    public void updateEntityWithOptionalForce(final Entity lllllllllllIllIIIlIIlllIIIIIIIII, final boolean lllllllllllIllIIIlIIllIlllllIlIl) {
        if (!(lllllllllllIllIIIlIIlllIIIIIIIII instanceof EntityPlayer)) {
            final int lllllllllllIllIIIlIIllIllllllllI = MathHelper.floor(lllllllllllIllIIIlIIlllIIIIIIIII.posX);
            final int lllllllllllIllIIIlIIllIlllllllIl = MathHelper.floor(lllllllllllIllIIIlIIlllIIIIIIIII.posZ);
            final int lllllllllllIllIIIlIIllIlllllllII = 32;
            if (lllllllllllIllIIIlIIllIlllllIlIl && !this.isAreaLoaded(lllllllllllIllIIIlIIllIllllllllI - 32, 0, lllllllllllIllIIIlIIllIlllllllIl - 32, lllllllllllIllIIIlIIllIllllllllI + 32, 0, lllllllllllIllIIIlIIllIlllllllIl + 32, true)) {
                return;
            }
        }
        lllllllllllIllIIIlIIlllIIIIIIIII.lastTickPosX = lllllllllllIllIIIlIIlllIIIIIIIII.posX;
        lllllllllllIllIIIlIIlllIIIIIIIII.lastTickPosY = lllllllllllIllIIIlIIlllIIIIIIIII.posY;
        lllllllllllIllIIIlIIlllIIIIIIIII.lastTickPosZ = lllllllllllIllIIIlIIlllIIIIIIIII.posZ;
        lllllllllllIllIIIlIIlllIIIIIIIII.prevRotationYaw = lllllllllllIllIIIlIIlllIIIIIIIII.rotationYaw;
        lllllllllllIllIIIlIIlllIIIIIIIII.prevRotationPitch = lllllllllllIllIIIlIIlllIIIIIIIII.rotationPitch;
        if (lllllllllllIllIIIlIIllIlllllIlIl && lllllllllllIllIIIlIIlllIIIIIIIII.addedToChunk) {
            ++lllllllllllIllIIIlIIlllIIIIIIIII.ticksExisted;
            if (lllllllllllIllIIIlIIlllIIIIIIIII.isRiding()) {
                lllllllllllIllIIIlIIlllIIIIIIIII.updateRidden();
            }
            else {
                lllllllllllIllIIIlIIlllIIIIIIIII.onUpdate();
            }
        }
        this.theProfiler.startSection("chunkCheck");
        if (Double.isNaN(lllllllllllIllIIIlIIlllIIIIIIIII.posX) || Double.isInfinite(lllllllllllIllIIIlIIlllIIIIIIIII.posX)) {
            lllllllllllIllIIIlIIlllIIIIIIIII.posX = lllllllllllIllIIIlIIlllIIIIIIIII.lastTickPosX;
        }
        if (Double.isNaN(lllllllllllIllIIIlIIlllIIIIIIIII.posY) || Double.isInfinite(lllllllllllIllIIIlIIlllIIIIIIIII.posY)) {
            lllllllllllIllIIIlIIlllIIIIIIIII.posY = lllllllllllIllIIIlIIlllIIIIIIIII.lastTickPosY;
        }
        if (Double.isNaN(lllllllllllIllIIIlIIlllIIIIIIIII.posZ) || Double.isInfinite(lllllllllllIllIIIlIIlllIIIIIIIII.posZ)) {
            lllllllllllIllIIIlIIlllIIIIIIIII.posZ = lllllllllllIllIIIlIIlllIIIIIIIII.lastTickPosZ;
        }
        if (Double.isNaN(lllllllllllIllIIIlIIlllIIIIIIIII.rotationPitch) || Double.isInfinite(lllllllllllIllIIIlIIlllIIIIIIIII.rotationPitch)) {
            lllllllllllIllIIIlIIlllIIIIIIIII.rotationPitch = lllllllllllIllIIIlIIlllIIIIIIIII.prevRotationPitch;
        }
        if (Double.isNaN(lllllllllllIllIIIlIIlllIIIIIIIII.rotationYaw) || Double.isInfinite(lllllllllllIllIIIlIIlllIIIIIIIII.rotationYaw)) {
            lllllllllllIllIIIlIIlllIIIIIIIII.rotationYaw = lllllllllllIllIIIlIIlllIIIIIIIII.prevRotationYaw;
        }
        final int lllllllllllIllIIIlIIllIllllllIll = MathHelper.floor(lllllllllllIllIIIlIIlllIIIIIIIII.posX / 16.0);
        final int lllllllllllIllIIIlIIllIllllllIlI = MathHelper.floor(lllllllllllIllIIIlIIlllIIIIIIIII.posY / 16.0);
        final int lllllllllllIllIIIlIIllIllllllIIl = MathHelper.floor(lllllllllllIllIIIlIIlllIIIIIIIII.posZ / 16.0);
        if (!lllllllllllIllIIIlIIlllIIIIIIIII.addedToChunk || lllllllllllIllIIIlIIlllIIIIIIIII.chunkCoordX != lllllllllllIllIIIlIIllIllllllIll || lllllllllllIllIIIlIIlllIIIIIIIII.chunkCoordY != lllllllllllIllIIIlIIllIllllllIlI || lllllllllllIllIIIlIIlllIIIIIIIII.chunkCoordZ != lllllllllllIllIIIlIIllIllllllIIl) {
            if (lllllllllllIllIIIlIIlllIIIIIIIII.addedToChunk && this.isChunkLoaded(lllllllllllIllIIIlIIlllIIIIIIIII.chunkCoordX, lllllllllllIllIIIlIIlllIIIIIIIII.chunkCoordZ, true)) {
                this.getChunkFromChunkCoords(lllllllllllIllIIIlIIlllIIIIIIIII.chunkCoordX, lllllllllllIllIIIlIIlllIIIIIIIII.chunkCoordZ).removeEntityAtIndex(lllllllllllIllIIIlIIlllIIIIIIIII, lllllllllllIllIIIlIIlllIIIIIIIII.chunkCoordY);
            }
            if (!lllllllllllIllIIIlIIlllIIIIIIIII.setPositionNonDirty() && !this.isChunkLoaded(lllllllllllIllIIIlIIllIllllllIll, lllllllllllIllIIIlIIllIllllllIIl, true)) {
                lllllllllllIllIIIlIIlllIIIIIIIII.addedToChunk = false;
            }
            else {
                this.getChunkFromChunkCoords(lllllllllllIllIIIlIIllIllllllIll, lllllllllllIllIIIlIIllIllllllIIl).addEntity(lllllllllllIllIIIlIIlllIIIIIIIII);
            }
        }
        this.theProfiler.endSection();
        if (lllllllllllIllIIIlIIllIlllllIlIl && lllllllllllIllIIIlIIlllIIIIIIIII.addedToChunk) {
            for (final Entity lllllllllllIllIIIlIIllIllllllIII : lllllllllllIllIIIlIIlllIIIIIIIII.getPassengers()) {
                if (!lllllllllllIllIIIlIIllIllllllIII.isDead && lllllllllllIllIIIlIIllIllllllIII.getRidingEntity() == lllllllllllIllIIIlIIlllIIIIIIIII) {
                    this.updateEntity(lllllllllllIllIIIlIIllIllllllIII);
                }
                else {
                    lllllllllllIllIIIlIIllIllllllIII.dismountRidingEntity();
                }
            }
        }
    }
    
    @Override
    public Biome getBiome(final BlockPos lllllllllllIllIIIlIlIIllIlIllIll) {
        if (this.isBlockLoaded(lllllllllllIllIIIlIlIIllIlIllIll)) {
            final Chunk lllllllllllIllIIIlIlIIllIlIllIlI = this.getChunkFromBlockCoords(lllllllllllIllIIIlIlIIllIlIllIll);
            try {
                return lllllllllllIllIIIlIlIIllIlIllIlI.getBiome(lllllllllllIllIIIlIlIIllIlIllIll, this.provider.getBiomeProvider());
            }
            catch (Throwable lllllllllllIllIIIlIlIIllIlIllIIl) {
                final CrashReport lllllllllllIllIIIlIlIIllIlIllIII = CrashReport.makeCrashReport(lllllllllllIllIIIlIlIIllIlIllIIl, "Getting biome");
                final CrashReportCategory lllllllllllIllIIIlIlIIllIlIlIlll = lllllllllllIllIIIlIlIIllIlIllIII.makeCategory("Coordinates of biome request");
                lllllllllllIllIIIlIlIIllIlIlIlll.setDetail("Location", new ICrashReportDetail<String>() {
                    @Override
                    public String call() throws Exception {
                        return CrashReportCategory.getCoordinateInfo(lllllllllllIllIIIlIlIIllIlIllIll);
                    }
                });
                throw new ReportedException(lllllllllllIllIIIlIlIIllIlIllIII);
            }
        }
        return this.provider.getBiomeProvider().getBiome(lllllllllllIllIIIlIlIIllIlIllIll, Biomes.PLAINS);
    }
    
    public <T extends Entity> List<T> getEntities(final Class<? extends T> lllllllllllIllIIIlIIlIllIIIIIlIl, final Predicate<? super T> lllllllllllIllIIIlIIlIlIllllllll) {
        final List<T> lllllllllllIllIIIlIIlIllIIIIIIll = (List<T>)Lists.newArrayList();
        for (final Entity lllllllllllIllIIIlIIlIllIIIIIIlI : this.loadedEntityList) {
            if (lllllllllllIllIIIlIIlIllIIIIIlIl.isAssignableFrom(lllllllllllIllIIIlIIlIllIIIIIIlI.getClass()) && lllllllllllIllIIIlIIlIlIllllllll.apply((Object)lllllllllllIllIIIlIIlIllIIIIIIlI)) {
                lllllllllllIllIIIlIIlIllIIIIIIll.add((T)lllllllllllIllIIIlIIlIllIIIIIIlI);
            }
        }
        return lllllllllllIllIIIlIIlIllIIIIIIll;
    }
    
    public GameRules getGameRules() {
        return this.worldInfo.getGameRulesInstance();
    }
    
    public boolean checkLight(final BlockPos lllllllllllIllIIIlIIlIllllIIlIlI) {
        boolean lllllllllllIllIIIlIIlIllllIIllII = false;
        if (this.provider.func_191066_m()) {
            lllllllllllIllIIIlIIlIllllIIllII |= this.checkLightFor(EnumSkyBlock.SKY, lllllllllllIllIIIlIIlIllllIIlIlI);
        }
        lllllllllllIllIIIlIIlIllllIIllII |= this.checkLightFor(EnumSkyBlock.BLOCK, lllllllllllIllIIIlIIlIllllIIlIlI);
        return lllllllllllIllIIIlIIlIllllIIllII;
    }
    
    @Nullable
    public EntityPlayer getPlayerEntityByName(final String lllllllllllIllIIIlIIlIIlIllIIIll) {
        for (int lllllllllllIllIIIlIIlIIlIllIIIlI = 0; lllllllllllIllIIIlIIlIIlIllIIIlI < this.playerEntities.size(); ++lllllllllllIllIIIlIIlIIlIllIIIlI) {
            final EntityPlayer lllllllllllIllIIIlIIlIIlIllIIIIl = this.playerEntities.get(lllllllllllIllIIIlIIlIIlIllIIIlI);
            if (lllllllllllIllIIIlIIlIIlIllIIIll.equals(lllllllllllIllIIIlIIlIIlIllIIIIl.getName())) {
                return lllllllllllIllIIIlIIlIIlIllIIIIl;
            }
        }
        return null;
    }
    
    @Nullable
    public <T extends Entity> T findNearestEntityWithinAABB(final Class<? extends T> lllllllllllIllIIIlIIlIlIlIlIlIll, final AxisAlignedBB lllllllllllIllIIIlIIlIlIlIlIlIlI, final T lllllllllllIllIIIlIIlIlIlIlIlIIl) {
        final List<T> lllllllllllIllIIIlIIlIlIlIllIIlI = this.getEntitiesWithinAABB(lllllllllllIllIIIlIIlIlIlIlIlIll, lllllllllllIllIIIlIIlIlIlIlIlIlI);
        T lllllllllllIllIIIlIIlIlIlIllIIIl = null;
        double lllllllllllIllIIIlIIlIlIlIllIIII = Double.MAX_VALUE;
        for (int lllllllllllIllIIIlIIlIlIlIlIllll = 0; lllllllllllIllIIIlIIlIlIlIlIllll < lllllllllllIllIIIlIIlIlIlIllIIlI.size(); ++lllllllllllIllIIIlIIlIlIlIlIllll) {
            final T lllllllllllIllIIIlIIlIlIlIlIlllI = lllllllllllIllIIIlIIlIlIlIllIIlI.get(lllllllllllIllIIIlIIlIlIlIlIllll);
            if (lllllllllllIllIIIlIIlIlIlIlIlllI != lllllllllllIllIIIlIIlIlIlIlIlIIl && EntitySelectors.NOT_SPECTATING.apply((Object)lllllllllllIllIIIlIIlIlIlIlIlllI)) {
                final double lllllllllllIllIIIlIIlIlIlIlIllIl = lllllllllllIllIIIlIIlIlIlIlIlIIl.getDistanceSqToEntity(lllllllllllIllIIIlIIlIlIlIlIlllI);
                if (lllllllllllIllIIIlIIlIlIlIlIllIl <= lllllllllllIllIIIlIIlIlIlIllIIII) {
                    lllllllllllIllIIIlIIlIlIlIllIIIl = lllllllllllIllIIIlIIlIlIlIlIlllI;
                    lllllllllllIllIIIlIIlIlIlIllIIII = lllllllllllIllIIIlIIlIlIlIlIllIl;
                }
            }
        }
        return lllllllllllIllIIIlIIlIlIlIllIIIl;
    }
    
    public boolean setBlockState(final BlockPos lllllllllllIllIIIlIlIIlIlIlIIllI, final IBlockState lllllllllllIllIIIlIlIIlIlIlIIlIl, final int lllllllllllIllIIIlIlIIlIlIIlllIl) {
        if (this.isOutsideBuildHeight(lllllllllllIllIIIlIlIIlIlIlIIllI)) {
            return false;
        }
        if (!this.isRemote && this.worldInfo.getTerrainType() == WorldType.DEBUG_WORLD) {
            return false;
        }
        final Chunk lllllllllllIllIIIlIlIIlIlIlIIIll = this.getChunkFromBlockCoords(lllllllllllIllIIIlIlIIlIlIlIIllI);
        final Block lllllllllllIllIIIlIlIIlIlIlIIIlI = lllllllllllIllIIIlIlIIlIlIlIIlIl.getBlock();
        final IBlockState lllllllllllIllIIIlIlIIlIlIlIIIIl = lllllllllllIllIIIlIlIIlIlIlIIIll.setBlockState(lllllllllllIllIIIlIlIIlIlIlIIllI, lllllllllllIllIIIlIlIIlIlIlIIlIl);
        if (lllllllllllIllIIIlIlIIlIlIlIIIIl == null) {
            return false;
        }
        if (lllllllllllIllIIIlIlIIlIlIlIIlIl.getLightOpacity() != lllllllllllIllIIIlIlIIlIlIlIIIIl.getLightOpacity() || lllllllllllIllIIIlIlIIlIlIlIIlIl.getLightValue() != lllllllllllIllIIIlIlIIlIlIlIIIIl.getLightValue()) {
            this.theProfiler.startSection("checkLight");
            this.checkLight(lllllllllllIllIIIlIlIIlIlIlIIllI);
            this.theProfiler.endSection();
        }
        if ((lllllllllllIllIIIlIlIIlIlIIlllIl & 0x2) != 0x0 && (!this.isRemote || (lllllllllllIllIIIlIlIIlIlIIlllIl & 0x4) == 0x0) && lllllllllllIllIIIlIlIIlIlIlIIIll.isPopulated()) {
            this.notifyBlockUpdate(lllllllllllIllIIIlIlIIlIlIlIIllI, lllllllllllIllIIIlIlIIlIlIlIIIIl, lllllllllllIllIIIlIlIIlIlIlIIlIl, lllllllllllIllIIIlIlIIlIlIIlllIl);
        }
        if (!this.isRemote && (lllllllllllIllIIIlIlIIlIlIIlllIl & 0x1) != 0x0) {
            this.notifyNeighborsRespectDebug(lllllllllllIllIIIlIlIIlIlIlIIllI, lllllllllllIllIIIlIlIIlIlIlIIIIl.getBlock(), true);
            if (lllllllllllIllIIIlIlIIlIlIlIIlIl.hasComparatorInputOverride()) {
                this.updateComparatorOutputLevel(lllllllllllIllIIIlIlIIlIlIlIIllI, lllllllllllIllIIIlIlIIlIlIlIIIlI);
            }
        }
        else if (!this.isRemote && (lllllllllllIllIIIlIlIIlIlIIlllIl & 0x10) == 0x0) {
            this.func_190522_c(lllllllllllIllIIIlIlIIlIlIlIIllI, lllllllllllIllIIIlIlIIlIlIlIIIlI);
        }
        return true;
    }
    
    public List<Entity> getEntitiesInAABBexcluding(@Nullable final Entity lllllllllllIllIIIlIIlIllIIIlIllI, final AxisAlignedBB lllllllllllIllIIIlIIlIllIIlIIIII, @Nullable final Predicate<? super Entity> lllllllllllIllIIIlIIlIllIIIlIlII) {
        final List<Entity> lllllllllllIllIIIlIIlIllIIIllllI = (List<Entity>)Lists.newArrayList();
        final int lllllllllllIllIIIlIIlIllIIIlllIl = MathHelper.floor((lllllllllllIllIIIlIIlIllIIlIIIII.minX - 2.0) / 16.0);
        final int lllllllllllIllIIIlIIlIllIIIlllII = MathHelper.floor((lllllllllllIllIIIlIIlIllIIlIIIII.maxX + 2.0) / 16.0);
        final int lllllllllllIllIIIlIIlIllIIIllIll = MathHelper.floor((lllllllllllIllIIIlIIlIllIIlIIIII.minZ - 2.0) / 16.0);
        final int lllllllllllIllIIIlIIlIllIIIllIlI = MathHelper.floor((lllllllllllIllIIIlIIlIllIIlIIIII.maxZ + 2.0) / 16.0);
        for (int lllllllllllIllIIIlIIlIllIIIllIIl = lllllllllllIllIIIlIIlIllIIIlllIl; lllllllllllIllIIIlIIlIllIIIllIIl <= lllllllllllIllIIIlIIlIllIIIlllII; ++lllllllllllIllIIIlIIlIllIIIllIIl) {
            for (int lllllllllllIllIIIlIIlIllIIIllIII = lllllllllllIllIIIlIIlIllIIIllIll; lllllllllllIllIIIlIIlIllIIIllIII <= lllllllllllIllIIIlIIlIllIIIllIlI; ++lllllllllllIllIIIlIIlIllIIIllIII) {
                if (this.isChunkLoaded(lllllllllllIllIIIlIIlIllIIIllIIl, lllllllllllIllIIIlIIlIllIIIllIII, true)) {
                    this.getChunkFromChunkCoords(lllllllllllIllIIIlIIlIllIIIllIIl, lllllllllllIllIIIlIIlIllIIIllIII).getEntitiesWithinAABBForEntity(lllllllllllIllIIIlIIlIllIIIlIllI, lllllllllllIllIIIlIIlIllIIlIIIII, lllllllllllIllIIIlIIlIllIIIllllI, lllllllllllIllIIIlIIlIllIIIlIlII);
                }
            }
        }
        return lllllllllllIllIIIlIIlIllIIIllllI;
    }
    
    protected void updateBlocks() {
    }
    
    protected void onEntityRemoved(final Entity lllllllllllIllIIIlIIlllllIllllIl) {
        for (int lllllllllllIllIIIlIIlllllIllllII = 0; lllllllllllIllIIIlIIlllllIllllII < this.eventListeners.size(); ++lllllllllllIllIIIlIIlllllIllllII) {
            this.eventListeners.get(lllllllllllIllIIIlIIlllllIllllII).onEntityRemoved(lllllllllllIllIIIlIIlllllIllllIl);
        }
    }
    
    public boolean isAreaLoaded(final BlockPos lllllllllllIllIIIlIlIIllIIIllIIl, final int lllllllllllIllIIIlIlIIllIIIllIII) {
        return this.isAreaLoaded(lllllllllllIllIIIlIlIIllIIIllIIl, lllllllllllIllIIIlIlIIllIIIllIII, true);
    }
    
    public boolean canSnowAt(final BlockPos lllllllllllIllIIIlIIlIllllIlllII, final boolean lllllllllllIllIIIlIIlIllllIlIlIl) {
        final Biome lllllllllllIllIIIlIIlIllllIllIlI = this.getBiome(lllllllllllIllIIIlIIlIllllIlllII);
        final float lllllllllllIllIIIlIIlIllllIllIIl = lllllllllllIllIIIlIIlIllllIllIlI.getFloatTemperature(lllllllllllIllIIIlIIlIllllIlllII);
        if (lllllllllllIllIIIlIIlIllllIllIIl >= 0.15f) {
            return false;
        }
        if (!lllllllllllIllIIIlIIlIllllIlIlIl) {
            return true;
        }
        if (lllllllllllIllIIIlIIlIllllIlllII.getY() >= 0 && lllllllllllIllIIIlIIlIllllIlllII.getY() < 256 && this.getLightFor(EnumSkyBlock.BLOCK, lllllllllllIllIIIlIIlIllllIlllII) < 10) {
            final IBlockState lllllllllllIllIIIlIIlIllllIllIII = this.getBlockState(lllllllllllIllIIIlIIlIllllIlllII);
            if (lllllllllllIllIIIlIIlIllllIllIII.getMaterial() == Material.AIR && Blocks.SNOW_LAYER.canPlaceBlockAt(this, lllllllllllIllIIIlIIlIllllIlllII)) {
                return true;
            }
        }
        return false;
    }
    
    public long getSeed() {
        return this.worldInfo.getSeed();
    }
    
    public void playEvent(@Nullable final EntityPlayer lllllllllllIllIIIlIIlIIIlIIIIlll, final int lllllllllllIllIIIlIIlIIIIlllllIl, final BlockPos lllllllllllIllIIIlIIlIIIlIIIIlIl, final int lllllllllllIllIIIlIIlIIIIllllIll) {
        try {
            for (int lllllllllllIllIIIlIIlIIIlIIIIIll = 0; lllllllllllIllIIIlIIlIIIlIIIIIll < this.eventListeners.size(); ++lllllllllllIllIIIlIIlIIIlIIIIIll) {
                this.eventListeners.get(lllllllllllIllIIIlIIlIIIlIIIIIll).playEvent(lllllllllllIllIIIlIIlIIIlIIIIlll, lllllllllllIllIIIlIIlIIIIlllllIl, lllllllllllIllIIIlIIlIIIlIIIIlIl, lllllllllllIllIIIlIIlIIIIllllIll);
            }
        }
        catch (Throwable lllllllllllIllIIIlIIlIIIlIIIIIlI) {
            final CrashReport lllllllllllIllIIIlIIlIIIlIIIIIIl = CrashReport.makeCrashReport(lllllllllllIllIIIlIIlIIIlIIIIIlI, "Playing level event");
            final CrashReportCategory lllllllllllIllIIIlIIlIIIlIIIIIII = lllllllllllIllIIIlIIlIIIlIIIIIIl.makeCategory("Level event being played");
            lllllllllllIllIIIlIIlIIIlIIIIIII.addCrashSection("Block coordinates", CrashReportCategory.getCoordinateInfo(lllllllllllIllIIIlIIlIIIlIIIIlIl));
            lllllllllllIllIIIlIIlIIIlIIIIIII.addCrashSection("Event source", lllllllllllIllIIIlIIlIIIlIIIIlll);
            lllllllllllIllIIIlIIlIIIlIIIIIII.addCrashSection("Event type", lllllllllllIllIIIlIIlIIIIlllllIl);
            lllllllllllIllIIIlIIlIIIlIIIIIII.addCrashSection("Event data", lllllllllllIllIIIlIIlIIIIllllIll);
            throw new ReportedException(lllllllllllIllIIIlIIlIIIlIIIIIIl);
        }
    }
    
    public World init() {
        return this;
    }
    
    @Override
    public boolean isAirBlock(final BlockPos lllllllllllIllIIIlIlIIllIIlIllIl) {
        return this.getBlockState(lllllllllllIllIIIlIlIIllIIlIllIl).getMaterial() == Material.AIR;
    }
    
    public void calculateInitialSkylight() {
        final int lllllllllllIllIIIlIIllIIIlIIIIIl = this.calculateSkylightSubtracted(1.0f);
        if (lllllllllllIllIIIlIIllIIIlIIIIIl != this.skylightSubtracted) {
            this.skylightSubtracted = lllllllllllIllIIIlIIllIIIlIIIIIl;
        }
    }
    
    public void updateAllPlayersSleepingFlag() {
    }
    
    public void setTileEntity(final BlockPos lllllllllllIllIIIlIIllIIIllIllll, @Nullable final TileEntity lllllllllllIllIIIlIIllIIIlllIIll) {
        if (!this.isOutsideBuildHeight(lllllllllllIllIIIlIIllIIIllIllll) && lllllllllllIllIIIlIIllIIIlllIIll != null && !lllllllllllIllIIIlIIllIIIlllIIll.isInvalid()) {
            if (this.processingLoadedTiles) {
                lllllllllllIllIIIlIIllIIIlllIIll.setPos(lllllllllllIllIIIlIIllIIIllIllll);
                final Iterator<TileEntity> lllllllllllIllIIIlIIllIIIlllIIlI = this.addedTileEntityList.iterator();
                while (lllllllllllIllIIIlIIllIIIlllIIlI.hasNext()) {
                    final TileEntity lllllllllllIllIIIlIIllIIIlllIIIl = lllllllllllIllIIIlIIllIIIlllIIlI.next();
                    if (lllllllllllIllIIIlIIllIIIlllIIIl.getPos().equals(lllllllllllIllIIIlIIllIIIllIllll)) {
                        lllllllllllIllIIIlIIllIIIlllIIIl.invalidate();
                        lllllllllllIllIIIlIIllIIIlllIIlI.remove();
                    }
                }
                this.addedTileEntityList.add(lllllllllllIllIIIlIIllIIIlllIIll);
            }
            else {
                this.getChunkFromBlockCoords(lllllllllllIllIIIlIIllIIIllIllll).addTileEntity(lllllllllllIllIIIlIIllIIIllIllll, lllllllllllIllIIIlIIllIIIlllIIll);
                this.addTileEntity(lllllllllllIllIIIlIIllIIIlllIIll);
            }
        }
    }
    
    private boolean isOutsideBuildHeight(final BlockPos lllllllllllIllIIIlIlIIllIIllIlII) {
        return lllllllllllIllIIIlIlIIllIIllIlII.getY() < 0 || lllllllllllIllIIIlIlIIllIIllIlII.getY() >= 256;
    }
    
    public int getHeight(final int lllllllllllIllIIIlIlIIIllIIIlIlI, final int lllllllllllIllIIIlIlIIIllIIIllll) {
        int lllllllllllIllIIIlIlIIIllIIIllII = 0;
        if (lllllllllllIllIIIlIlIIIllIIIlIlI >= -30000000 && lllllllllllIllIIIlIlIIIllIIIllll >= -30000000 && lllllllllllIllIIIlIlIIIllIIIlIlI < 30000000 && lllllllllllIllIIIlIlIIIllIIIllll < 30000000) {
            if (this.isChunkLoaded(lllllllllllIllIIIlIlIIIllIIIlIlI >> 4, lllllllllllIllIIIlIlIIIllIIIllll >> 4, true)) {
                final int lllllllllllIllIIIlIlIIIllIIIlllI = this.getChunkFromChunkCoords(lllllllllllIllIIIlIlIIIllIIIlIlI >> 4, lllllllllllIllIIIlIlIIIllIIIllll >> 4).getHeightValue(lllllllllllIllIIIlIlIIIllIIIlIlI & 0xF, lllllllllllIllIIIlIlIIIllIIIllll & 0xF);
            }
            else {
                final int lllllllllllIllIIIlIlIIIllIIIllIl = 0;
            }
        }
        else {
            lllllllllllIllIIIlIlIIIllIIIllII = this.getSeaLevel() + 1;
        }
        return lllllllllllIllIIIlIlIIIllIIIllII;
    }
    
    public float getRainStrength(final float lllllllllllIllIIIlIIlIIIlllIIlll) {
        return this.prevRainingStrength + (this.rainingStrength - this.prevRainingStrength) * lllllllllllIllIIIlIIlIIIlllIIlll;
    }
    
    public void tick() {
        this.updateWeather();
    }
    
    @Nullable
    public EntityPlayer func_190525_a(final double lllllllllllIllIIIlIIlIIlllIllIlI, final double lllllllllllIllIIIlIIlIIlllIllIIl, final double lllllllllllIllIIIlIIlIIlllIIllIl, final double lllllllllllIllIIIlIIlIIlllIlIlll, final Predicate<Entity> lllllllllllIllIIIlIIlIIlllIlIllI) {
        double lllllllllllIllIIIlIIlIIlllIlIlIl = -1.0;
        EntityPlayer lllllllllllIllIIIlIIlIIlllIlIlII = null;
        for (int lllllllllllIllIIIlIIlIIlllIlIIll = 0; lllllllllllIllIIIlIIlIIlllIlIIll < this.playerEntities.size(); ++lllllllllllIllIIIlIIlIIlllIlIIll) {
            final EntityPlayer lllllllllllIllIIIlIIlIIlllIlIIlI = this.playerEntities.get(lllllllllllIllIIIlIIlIIlllIlIIll);
            if (lllllllllllIllIIIlIIlIIlllIlIllI.apply((Object)lllllllllllIllIIIlIIlIIlllIlIIlI)) {
                final double lllllllllllIllIIIlIIlIIlllIlIIIl = lllllllllllIllIIIlIIlIIlllIlIIlI.getDistanceSq(lllllllllllIllIIIlIIlIIlllIllIlI, lllllllllllIllIIIlIIlIIlllIllIIl, lllllllllllIllIIIlIIlIIlllIIllIl);
                if ((lllllllllllIllIIIlIIlIIlllIlIlll < 0.0 || lllllllllllIllIIIlIIlIIlllIlIIIl < lllllllllllIllIIIlIIlIIlllIlIlll * lllllllllllIllIIIlIIlIIlllIlIlll) && (lllllllllllIllIIIlIIlIIlllIlIlIl == -1.0 || lllllllllllIllIIIlIIlIIlllIlIIIl < lllllllllllIllIIIlIIlIIlllIlIlIl)) {
                    lllllllllllIllIIIlIIlIIlllIlIlIl = lllllllllllIllIIIlIIlIIlllIlIIIl;
                    lllllllllllIllIIIlIIlIIlllIlIlII = lllllllllllIllIIIlIIlIIlllIlIIlI;
                }
            }
        }
        return lllllllllllIllIIIlIIlIIlllIlIlII;
    }
    
    public void addTileEntities(final Collection<TileEntity> lllllllllllIllIIIlIIlllIIIIlIIlI) {
        if (this.processingLoadedTiles) {
            this.addedTileEntityList.addAll(lllllllllllIllIIIlIIlllIIIIlIIlI);
        }
        else {
            for (final TileEntity lllllllllllIllIIIlIIlllIIIIlIlII : lllllllllllIllIIIlIIlllIIIIlIIlI) {
                this.addTileEntity(lllllllllllIllIIIlIIlllIIIIlIlII);
            }
        }
    }
    
    public boolean checkLightFor(final EnumSkyBlock lllllllllllIllIIIlIIlIllIlIllIll, final BlockPos lllllllllllIllIIIlIIlIlllIIIIIII) {
        final EventRenderWorldLight lllllllllllIllIIIlIIlIllIlllllll = new EventRenderWorldLight(lllllllllllIllIIIlIIlIllIlIllIll, lllllllllllIllIIIlIIlIlllIIIIIII);
        lllllllllllIllIIIlIIlIllIlllllll.call();
        if (lllllllllllIllIIIlIIlIllIlllllll.isCancelled()) {
            return false;
        }
        if (!this.isAreaLoaded(lllllllllllIllIIIlIIlIlllIIIIIII, 17, false)) {
            return false;
        }
        int lllllllllllIllIIIlIIlIllIllllllI = 0;
        int lllllllllllIllIIIlIIlIllIlllllIl = 0;
        this.theProfiler.startSection("getBrightness");
        final int lllllllllllIllIIIlIIlIllIlllllII = this.getLightFor(lllllllllllIllIIIlIIlIllIlIllIll, lllllllllllIllIIIlIIlIlllIIIIIII);
        final int lllllllllllIllIIIlIIlIllIllllIll = this.getRawLight(lllllllllllIllIIIlIIlIlllIIIIIII, lllllllllllIllIIIlIIlIllIlIllIll);
        final int lllllllllllIllIIIlIIlIllIllllIlI = lllllllllllIllIIIlIIlIlllIIIIIII.getX();
        final int lllllllllllIllIIIlIIlIllIllllIIl = lllllllllllIllIIIlIIlIlllIIIIIII.getY();
        final int lllllllllllIllIIIlIIlIllIllllIII = lllllllllllIllIIIlIIlIlllIIIIIII.getZ();
        if (lllllllllllIllIIIlIIlIllIllllIll > lllllllllllIllIIIlIIlIllIlllllII) {
            this.lightUpdateBlockList[lllllllllllIllIIIlIIlIllIlllllIl++] = 133152;
        }
        else if (lllllllllllIllIIIlIIlIllIllllIll < lllllllllllIllIIIlIIlIllIlllllII) {
            this.lightUpdateBlockList[lllllllllllIllIIIlIIlIllIlllllIl++] = (0x20820 | lllllllllllIllIIIlIIlIllIlllllII << 18);
            while (lllllllllllIllIIIlIIlIllIllllllI < lllllllllllIllIIIlIIlIllIlllllIl) {
                final int lllllllllllIllIIIlIIlIllIlllIlll = this.lightUpdateBlockList[lllllllllllIllIIIlIIlIllIllllllI++];
                final int lllllllllllIllIIIlIIlIllIlllIllI = (lllllllllllIllIIIlIIlIllIlllIlll & 0x3F) - 32 + lllllllllllIllIIIlIIlIllIllllIlI;
                final int lllllllllllIllIIIlIIlIllIlllIlIl = (lllllllllllIllIIIlIIlIllIlllIlll >> 6 & 0x3F) - 32 + lllllllllllIllIIIlIIlIllIllllIIl;
                final int lllllllllllIllIIIlIIlIllIlllIlII = (lllllllllllIllIIIlIIlIllIlllIlll >> 12 & 0x3F) - 32 + lllllllllllIllIIIlIIlIllIllllIII;
                final int lllllllllllIllIIIlIIlIllIlllIIll = lllllllllllIllIIIlIIlIllIlllIlll >> 18 & 0xF;
                final BlockPos lllllllllllIllIIIlIIlIllIlllIIlI = new BlockPos(lllllllllllIllIIIlIIlIllIlllIllI, lllllllllllIllIIIlIIlIllIlllIlIl, lllllllllllIllIIIlIIlIllIlllIlII);
                int lllllllllllIllIIIlIIlIllIlllIIIl = this.getLightFor(lllllllllllIllIIIlIIlIllIlIllIll, lllllllllllIllIIIlIIlIllIlllIIlI);
                if (lllllllllllIllIIIlIIlIllIlllIIIl == lllllllllllIllIIIlIIlIllIlllIIll) {
                    this.setLightFor(lllllllllllIllIIIlIIlIllIlIllIll, lllllllllllIllIIIlIIlIllIlllIIlI, 0);
                    if (lllllllllllIllIIIlIIlIllIlllIIll <= 0) {
                        continue;
                    }
                    final int lllllllllllIllIIIlIIlIllIlllIIII = MathHelper.abs(lllllllllllIllIIIlIIlIllIlllIllI - lllllllllllIllIIIlIIlIllIllllIlI);
                    final int lllllllllllIllIIIlIIlIllIllIllll = MathHelper.abs(lllllllllllIllIIIlIIlIllIlllIlIl - lllllllllllIllIIIlIIlIllIllllIIl);
                    final int lllllllllllIllIIIlIIlIllIllIlllI = MathHelper.abs(lllllllllllIllIIIlIIlIllIlllIlII - lllllllllllIllIIIlIIlIllIllllIII);
                    if (lllllllllllIllIIIlIIlIllIlllIIII + lllllllllllIllIIIlIIlIllIllIllll + lllllllllllIllIIIlIIlIllIllIlllI >= 17) {
                        continue;
                    }
                    final BlockPos.PooledMutableBlockPos lllllllllllIllIIIlIIlIllIllIllIl = BlockPos.PooledMutableBlockPos.retain();
                    final char lllllllllllIllIIIlIIlIllIlIIIIll;
                    final byte lllllllllllIllIIIlIIlIllIlIIIlII = (byte)((EnumFacing[])(Object)(lllllllllllIllIIIlIIlIllIlIIIIll = (char)(Object)EnumFacing.values())).length;
                    for (char lllllllllllIllIIIlIIlIllIlIIIlIl = '\0'; lllllllllllIllIIIlIIlIllIlIIIlIl < lllllllllllIllIIIlIIlIllIlIIIlII; ++lllllllllllIllIIIlIIlIllIlIIIlIl) {
                        final EnumFacing lllllllllllIllIIIlIIlIllIllIllII = lllllllllllIllIIIlIIlIllIlIIIIll[lllllllllllIllIIIlIIlIllIlIIIlIl];
                        final int lllllllllllIllIIIlIIlIllIllIlIll = lllllllllllIllIIIlIIlIllIlllIllI + lllllllllllIllIIIlIIlIllIllIllII.getFrontOffsetX();
                        final int lllllllllllIllIIIlIIlIllIllIlIlI = lllllllllllIllIIIlIIlIllIlllIlIl + lllllllllllIllIIIlIIlIllIllIllII.getFrontOffsetY();
                        final int lllllllllllIllIIIlIIlIllIllIlIIl = lllllllllllIllIIIlIIlIllIlllIlII + lllllllllllIllIIIlIIlIllIllIllII.getFrontOffsetZ();
                        lllllllllllIllIIIlIIlIllIllIllIl.setPos(lllllllllllIllIIIlIIlIllIllIlIll, lllllllllllIllIIIlIIlIllIllIlIlI, lllllllllllIllIIIlIIlIllIllIlIIl);
                        final int lllllllllllIllIIIlIIlIllIllIlIII = Math.max(1, this.getBlockState(lllllllllllIllIIIlIIlIllIllIllIl).getLightOpacity());
                        lllllllllllIllIIIlIIlIllIlllIIIl = this.getLightFor(lllllllllllIllIIIlIIlIllIlIllIll, lllllllllllIllIIIlIIlIllIllIllIl);
                        if (lllllllllllIllIIIlIIlIllIlllIIIl == lllllllllllIllIIIlIIlIllIlllIIll - lllllllllllIllIIIlIIlIllIllIlIII && lllllllllllIllIIIlIIlIllIlllllIl < this.lightUpdateBlockList.length) {
                            this.lightUpdateBlockList[lllllllllllIllIIIlIIlIllIlllllIl++] = (lllllllllllIllIIIlIIlIllIllIlIll - lllllllllllIllIIIlIIlIllIllllIlI + 32 | lllllllllllIllIIIlIIlIllIllIlIlI - lllllllllllIllIIIlIIlIllIllllIIl + 32 << 6 | lllllllllllIllIIIlIIlIllIllIlIIl - lllllllllllIllIIIlIIlIllIllllIII + 32 << 12 | lllllllllllIllIIIlIIlIllIlllIIll - lllllllllllIllIIIlIIlIllIllIlIII << 18);
                        }
                    }
                    lllllllllllIllIIIlIIlIllIllIllIl.release();
                }
            }
            lllllllllllIllIIIlIIlIllIllllllI = 0;
        }
        this.theProfiler.endSection();
        this.theProfiler.startSection("checkedPosition < toCheckCount");
        while (lllllllllllIllIIIlIIlIllIllllllI < lllllllllllIllIIIlIIlIllIlllllIl) {
            final int lllllllllllIllIIIlIIlIllIllIIlll = this.lightUpdateBlockList[lllllllllllIllIIIlIIlIllIllllllI++];
            final int lllllllllllIllIIIlIIlIllIllIIllI = (lllllllllllIllIIIlIIlIllIllIIlll & 0x3F) - 32 + lllllllllllIllIIIlIIlIllIllllIlI;
            final int lllllllllllIllIIIlIIlIllIllIIlIl = (lllllllllllIllIIIlIIlIllIllIIlll >> 6 & 0x3F) - 32 + lllllllllllIllIIIlIIlIllIllllIIl;
            final int lllllllllllIllIIIlIIlIllIllIIlII = (lllllllllllIllIIIlIIlIllIllIIlll >> 12 & 0x3F) - 32 + lllllllllllIllIIIlIIlIllIllllIII;
            final BlockPos lllllllllllIllIIIlIIlIllIllIIIll = new BlockPos(lllllllllllIllIIIlIIlIllIllIIllI, lllllllllllIllIIIlIIlIllIllIIlIl, lllllllllllIllIIIlIIlIllIllIIlII);
            final int lllllllllllIllIIIlIIlIllIllIIIlI = this.getLightFor(lllllllllllIllIIIlIIlIllIlIllIll, lllllllllllIllIIIlIIlIllIllIIIll);
            final int lllllllllllIllIIIlIIlIllIllIIIIl = this.getRawLight(lllllllllllIllIIIlIIlIllIllIIIll, lllllllllllIllIIIlIIlIllIlIllIll);
            if (lllllllllllIllIIIlIIlIllIllIIIIl != lllllllllllIllIIIlIIlIllIllIIIlI) {
                this.setLightFor(lllllllllllIllIIIlIIlIllIlIllIll, lllllllllllIllIIIlIIlIllIllIIIll, lllllllllllIllIIIlIIlIllIllIIIIl);
                if (lllllllllllIllIIIlIIlIllIllIIIIl <= lllllllllllIllIIIlIIlIllIllIIIlI) {
                    continue;
                }
                final int lllllllllllIllIIIlIIlIllIllIIIII = Math.abs(lllllllllllIllIIIlIIlIllIllIIllI - lllllllllllIllIIIlIIlIllIllllIlI);
                final int lllllllllllIllIIIlIIlIllIlIlllll = Math.abs(lllllllllllIllIIIlIIlIllIllIIlIl - lllllllllllIllIIIlIIlIllIllllIIl);
                final int lllllllllllIllIIIlIIlIllIlIllllI = Math.abs(lllllllllllIllIIIlIIlIllIllIIlII - lllllllllllIllIIIlIIlIllIllllIII);
                final boolean lllllllllllIllIIIlIIlIllIlIlllIl = lllllllllllIllIIIlIIlIllIlllllIl < this.lightUpdateBlockList.length - 6;
                if (lllllllllllIllIIIlIIlIllIllIIIII + lllllllllllIllIIIlIIlIllIlIlllll + lllllllllllIllIIIlIIlIllIlIllllI >= 17 || !lllllllllllIllIIIlIIlIllIlIlllIl) {
                    continue;
                }
                if (this.getLightFor(lllllllllllIllIIIlIIlIllIlIllIll, lllllllllllIllIIIlIIlIllIllIIIll.west()) < lllllllllllIllIIIlIIlIllIllIIIIl) {
                    this.lightUpdateBlockList[lllllllllllIllIIIlIIlIllIlllllIl++] = lllllllllllIllIIIlIIlIllIllIIllI - 1 - lllllllllllIllIIIlIIlIllIllllIlI + 32 + (lllllllllllIllIIIlIIlIllIllIIlIl - lllllllllllIllIIIlIIlIllIllllIIl + 32 << 6) + (lllllllllllIllIIIlIIlIllIllIIlII - lllllllllllIllIIIlIIlIllIllllIII + 32 << 12);
                }
                if (this.getLightFor(lllllllllllIllIIIlIIlIllIlIllIll, lllllllllllIllIIIlIIlIllIllIIIll.east()) < lllllllllllIllIIIlIIlIllIllIIIIl) {
                    this.lightUpdateBlockList[lllllllllllIllIIIlIIlIllIlllllIl++] = lllllllllllIllIIIlIIlIllIllIIllI + 1 - lllllllllllIllIIIlIIlIllIllllIlI + 32 + (lllllllllllIllIIIlIIlIllIllIIlIl - lllllllllllIllIIIlIIlIllIllllIIl + 32 << 6) + (lllllllllllIllIIIlIIlIllIllIIlII - lllllllllllIllIIIlIIlIllIllllIII + 32 << 12);
                }
                if (this.getLightFor(lllllllllllIllIIIlIIlIllIlIllIll, lllllllllllIllIIIlIIlIllIllIIIll.down()) < lllllllllllIllIIIlIIlIllIllIIIIl) {
                    this.lightUpdateBlockList[lllllllllllIllIIIlIIlIllIlllllIl++] = lllllllllllIllIIIlIIlIllIllIIllI - lllllllllllIllIIIlIIlIllIllllIlI + 32 + (lllllllllllIllIIIlIIlIllIllIIlIl - 1 - lllllllllllIllIIIlIIlIllIllllIIl + 32 << 6) + (lllllllllllIllIIIlIIlIllIllIIlII - lllllllllllIllIIIlIIlIllIllllIII + 32 << 12);
                }
                if (this.getLightFor(lllllllllllIllIIIlIIlIllIlIllIll, lllllllllllIllIIIlIIlIllIllIIIll.up()) < lllllllllllIllIIIlIIlIllIllIIIIl) {
                    this.lightUpdateBlockList[lllllllllllIllIIIlIIlIllIlllllIl++] = lllllllllllIllIIIlIIlIllIllIIllI - lllllllllllIllIIIlIIlIllIllllIlI + 32 + (lllllllllllIllIIIlIIlIllIllIIlIl + 1 - lllllllllllIllIIIlIIlIllIllllIIl + 32 << 6) + (lllllllllllIllIIIlIIlIllIllIIlII - lllllllllllIllIIIlIIlIllIllllIII + 32 << 12);
                }
                if (this.getLightFor(lllllllllllIllIIIlIIlIllIlIllIll, lllllllllllIllIIIlIIlIllIllIIIll.north()) < lllllllllllIllIIIlIIlIllIllIIIIl) {
                    this.lightUpdateBlockList[lllllllllllIllIIIlIIlIllIlllllIl++] = lllllllllllIllIIIlIIlIllIllIIllI - lllllllllllIllIIIlIIlIllIllllIlI + 32 + (lllllllllllIllIIIlIIlIllIllIIlIl - lllllllllllIllIIIlIIlIllIllllIIl + 32 << 6) + (lllllllllllIllIIIlIIlIllIllIIlII - 1 - lllllllllllIllIIIlIIlIllIllllIII + 32 << 12);
                }
                if (this.getLightFor(lllllllllllIllIIIlIIlIllIlIllIll, lllllllllllIllIIIlIIlIllIllIIIll.south()) >= lllllllllllIllIIIlIIlIllIllIIIIl) {
                    continue;
                }
                this.lightUpdateBlockList[lllllllllllIllIIIlIIlIllIlllllIl++] = lllllllllllIllIIIlIIlIllIllIIllI - lllllllllllIllIIIlIIlIllIllllIlI + 32 + (lllllllllllIllIIIlIIlIllIllIIlIl - lllllllllllIllIIIlIIlIllIllllIIl + 32 << 6) + (lllllllllllIllIIIlIIlIllIllIIlII + 1 - lllllllllllIllIIIlIIlIllIllllIII + 32 << 12);
            }
        }
        this.theProfiler.endSection();
        return true;
    }
    
    public DifficultyInstance getDifficultyForLocation(final BlockPos lllllllllllIllIIIlIIlIIIIIIllIII) {
        long lllllllllllIllIIIlIIlIIIIIIllIll = 0L;
        float lllllllllllIllIIIlIIlIIIIIIllIlI = 0.0f;
        if (this.isBlockLoaded(lllllllllllIllIIIlIIlIIIIIIllIII)) {
            lllllllllllIllIIIlIIlIIIIIIllIlI = this.getCurrentMoonPhaseFactor();
            lllllllllllIllIIIlIIlIIIIIIllIll = this.getChunkFromBlockCoords(lllllllllllIllIIIlIIlIIIIIIllIII).getInhabitedTime();
        }
        return new DifficultyInstance(this.getDifficulty(), this.getWorldTime(), lllllllllllIllIIIlIIlIIIIIIllIll, lllllllllllIllIIIlIIlIIIIIIllIlI);
    }
    
    protected void calculateInitialWeather() {
        if (this.worldInfo.isRaining()) {
            this.rainingStrength = 1.0f;
            if (this.worldInfo.isThundering()) {
                this.thunderingStrength = 1.0f;
            }
        }
    }
    
    public void setSpawnPoint(final BlockPos lllllllllllIllIIIlIIlIIlIIlIlllI) {
        this.worldInfo.setSpawn(lllllllllllIllIIIlIIlIIlIIlIlllI);
    }
    
    public boolean isAreaLoaded(final StructureBoundingBox lllllllllllIllIIIlIlIIlIlllIIllI, final boolean lllllllllllIllIIIlIlIIlIlllIIlIl) {
        return this.isAreaLoaded(lllllllllllIllIIIlIlIIlIlllIIllI.minX, lllllllllllIllIIIlIlIIlIlllIIllI.minY, lllllllllllIllIIIlIlIIlIlllIIllI.minZ, lllllllllllIllIIIlIlIIlIlllIIllI.maxX, lllllllllllIllIIIlIlIIlIlllIIllI.maxY, lllllllllllIllIIIlIlIIlIlllIIllI.maxZ, lllllllllllIllIIIlIlIIlIlllIIlIl);
    }
    
    public void setThunderStrength(final float lllllllllllIllIIIlIIlIIIlllIlIll) {
        this.prevThunderingStrength = lllllllllllIllIIIlIIlIIIlllIlIll;
        this.thunderingStrength = lllllllllllIllIIIlIIlIIIlllIlIll;
    }
    
    public void removeEntityDangerously(final Entity lllllllllllIllIIIlIIlllllIlIllIl) {
        lllllllllllIllIIIlIIlllllIlIllIl.setDropItemsWhenDead(false);
        lllllllllllIllIIIlIIlllllIlIllIl.setDead();
        if (lllllllllllIllIIIlIIlllllIlIllIl instanceof EntityPlayer) {
            this.playerEntities.remove(lllllllllllIllIIIlIIlllllIlIllIl);
            this.updateAllPlayersSleepingFlag();
        }
        final int lllllllllllIllIIIlIIlllllIlIllII = lllllllllllIllIIIlIIlllllIlIllIl.chunkCoordX;
        final int lllllllllllIllIIIlIIlllllIlIlIll = lllllllllllIllIIIlIIlllllIlIllIl.chunkCoordZ;
        if (lllllllllllIllIIIlIIlllllIlIllIl.addedToChunk && this.isChunkLoaded(lllllllllllIllIIIlIIlllllIlIllII, lllllllllllIllIIIlIIlllllIlIlIll, true)) {
            this.getChunkFromChunkCoords(lllllllllllIllIIIlIIlllllIlIllII, lllllllllllIllIIIlIIlllllIlIlIll).removeEntity(lllllllllllIllIIIlIIlllllIlIllIl);
        }
        this.loadedEntityList.remove(lllllllllllIllIIIlIIlllllIlIllIl);
        this.onEntityRemoved(lllllllllllIllIIIlIIlllllIlIllIl);
    }
    
    public void setRainStrength(final float lllllllllllIllIIIlIIlIIIllIlllll) {
        this.prevRainingStrength = lllllllllllIllIIIlIIlIIIllIlllll;
        this.rainingStrength = lllllllllllIllIIIlIIlIIIllIlllll;
    }
    
    public void playEvent(final int lllllllllllIllIIIlIIlIIIlIIlIlll, final BlockPos lllllllllllIllIIIlIIlIIIlIIlIIlI, final int lllllllllllIllIIIlIIlIIIlIIlIlIl) {
        this.playEvent(null, lllllllllllIllIIIlIIlIIIlIIlIlll, lllllllllllIllIIIlIIlIIIlIIlIIlI, lllllllllllIllIIIlIIlIIIlIIlIlIl);
    }
    
    public boolean destroyBlock(final BlockPos lllllllllllIllIIIlIlIIlIlIIIlIII, final boolean lllllllllllIllIIIlIlIIlIlIIIIlll) {
        final IBlockState lllllllllllIllIIIlIlIIlIlIIIlIll = this.getBlockState(lllllllllllIllIIIlIlIIlIlIIIlIII);
        final Block lllllllllllIllIIIlIlIIlIlIIIlIlI = lllllllllllIllIIIlIlIIlIlIIIlIll.getBlock();
        if (lllllllllllIllIIIlIlIIlIlIIIlIll.getMaterial() == Material.AIR) {
            return false;
        }
        this.playEvent(2001, lllllllllllIllIIIlIlIIlIlIIIlIII, Block.getStateId(lllllllllllIllIIIlIlIIlIlIIIlIll));
        if (lllllllllllIllIIIlIlIIlIlIIIIlll) {
            lllllllllllIllIIIlIlIIlIlIIIlIlI.dropBlockAsItem(this, lllllllllllIllIIIlIlIIlIlIIIlIII, lllllllllllIllIIIlIlIIlIlIIIlIll, 0);
        }
        return this.setBlockState(lllllllllllIllIIIlIlIIlIlIIIlIII, Blocks.AIR.getDefaultState(), 3);
    }
    
    public boolean setBlockToAir(final BlockPos lllllllllllIllIIIlIlIIlIlIIlIllI) {
        return this.setBlockState(lllllllllllIllIIIlIlIIlIlIIlIllI, Blocks.AIR.getDefaultState(), 3);
    }
    
    public void notifyNeighborsOfStateChange(final BlockPos lllllllllllIllIIIlIlIIlIIIIlIlll, final Block lllllllllllIllIIIlIlIIlIIIIllIlI, final boolean lllllllllllIllIIIlIlIIlIIIIlIlIl) {
        this.func_190524_a(lllllllllllIllIIIlIlIIlIIIIlIlll.west(), lllllllllllIllIIIlIlIIlIIIIllIlI, lllllllllllIllIIIlIlIIlIIIIlIlll);
        this.func_190524_a(lllllllllllIllIIIlIlIIlIIIIlIlll.east(), lllllllllllIllIIIlIlIIlIIIIllIlI, lllllllllllIllIIIlIlIIlIIIIlIlll);
        this.func_190524_a(lllllllllllIllIIIlIlIIlIIIIlIlll.down(), lllllllllllIllIIIlIlIIlIIIIllIlI, lllllllllllIllIIIlIlIIlIIIIlIlll);
        this.func_190524_a(lllllllllllIllIIIlIlIIlIIIIlIlll.up(), lllllllllllIllIIIlIlIIlIIIIllIlI, lllllllllllIllIIIlIlIIlIIIIlIlll);
        this.func_190524_a(lllllllllllIllIIIlIlIIlIIIIlIlll.north(), lllllllllllIllIIIlIlIIlIIIIllIlI, lllllllllllIllIIIlIlIIlIIIIlIlll);
        this.func_190524_a(lllllllllllIllIIIlIlIIlIIIIlIlll.south(), lllllllllllIllIIIlIlIIlIIIIllIlI, lllllllllllIllIIIlIlIIlIIIIlIlll);
        if (lllllllllllIllIIIlIlIIlIIIIlIlIl) {
            this.func_190522_c(lllllllllllIllIIIlIlIIlIIIIlIlll, lllllllllllIllIIIlIlIIlIIIIllIlI);
        }
    }
    
    public <T extends Entity> List<T> getEntitiesWithinAABB(final Class<? extends T> lllllllllllIllIIIlIIlIlIlllIIllI, final AxisAlignedBB lllllllllllIllIIIlIIlIlIlllIIIlI) {
        return this.getEntitiesWithinAABB(lllllllllllIllIIIlIIlIlIlllIIllI, lllllllllllIllIIIlIIlIlIlllIIIlI, (com.google.common.base.Predicate<? super T>)EntitySelectors.NOT_SPECTATING);
    }
    
    @Nullable
    public MinecraftServer getMinecraftServer() {
        return null;
    }
    
    public boolean isBlockNormalCube(final BlockPos lllllllllllIllIIIlIIllIIIlIIllIl, final boolean lllllllllllIllIIIlIIllIIIlIIIlll) {
        if (this.isOutsideBuildHeight(lllllllllllIllIIIlIIllIIIlIIllIl)) {
            return false;
        }
        final Chunk lllllllllllIllIIIlIIllIIIlIIlIll = this.chunkProvider.getLoadedChunk(lllllllllllIllIIIlIIllIIIlIIllIl.getX() >> 4, lllllllllllIllIIIlIIllIIIlIIllIl.getZ() >> 4);
        if (lllllllllllIllIIIlIIllIIIlIIlIll != null && !lllllllllllIllIIIlIIllIIIlIIlIll.isEmpty()) {
            final IBlockState lllllllllllIllIIIlIIllIIIlIIlIlI = this.getBlockState(lllllllllllIllIIIlIIllIIIlIIllIl);
            return lllllllllllIllIIIlIIllIIIlIIlIlI.getMaterial().isOpaque() && lllllllllllIllIIIlIIllIIIlIIlIlI.isFullCube();
        }
        return lllllllllllIllIIIlIIllIIIlIIIlll;
    }
    
    public boolean isBlockModifiable(final EntityPlayer lllllllllllIllIIIlIIlIIlIIIlIlIl, final BlockPos lllllllllllIllIIIlIIlIIlIIIlIlII) {
        return true;
    }
    
    public void spawnParticle(final EnumParticleTypes lllllllllllIllIIIlIlIIIIIlIIIlll, final double lllllllllllIllIIIlIlIIIIIlIIIllI, final double lllllllllllIllIIIlIlIIIIIlIIlllI, final double lllllllllllIllIIIlIlIIIIIlIIllIl, final double lllllllllllIllIIIlIlIIIIIlIIIIll, final double lllllllllllIllIIIlIlIIIIIlIIlIll, final double lllllllllllIllIIIlIlIIIIIlIIlIlI, final int... lllllllllllIllIIIlIlIIIIIlIIIIII) {
        this.spawnParticle(lllllllllllIllIIIlIlIIIIIlIIIlll.getParticleID(), lllllllllllIllIIIlIlIIIIIlIIIlll.getShouldIgnoreRange(), lllllllllllIllIIIlIlIIIIIlIIIllI, lllllllllllIllIIIlIlIIIIIlIIlllI, lllllllllllIllIIIlIlIIIIIlIIllIl, lllllllllllIllIIIlIlIIIIIlIIIIll, lllllllllllIllIIIlIlIIIIIlIIlIll, lllllllllllIllIIIlIlIIIIIlIIlIlI, lllllllllllIllIIIlIlIIIIIlIIIIII);
    }
    
    public void addEventListener(final IWorldEventListener lllllllllllIllIIIlIIlllllIlIIIIl) {
        this.eventListeners.add(lllllllllllIllIIIlIIlllllIlIIIIl);
    }
    
    public List<Entity> getEntitiesWithinAABBExcludingEntity(@Nullable final Entity lllllllllllIllIIIlIIlIllIIlIllll, final AxisAlignedBB lllllllllllIllIIIlIIlIllIIlIlllI) {
        return this.getEntitiesInAABBexcluding(lllllllllllIllIIIlIIlIllIIlIllll, lllllllllllIllIIIlIIlIllIIlIlllI, EntitySelectors.NOT_SPECTATING);
    }
    
    public void func_190523_a(final int lllllllllllIllIIIlIlIIIIIIllIlII, final double lllllllllllIllIIIlIlIIIIIIlIlIIl, final double lllllllllllIllIIIlIlIIIIIIlIlIII, final double lllllllllllIllIIIlIlIIIIIIllIIIl, final double lllllllllllIllIIIlIlIIIIIIllIIII, final double lllllllllllIllIIIlIlIIIIIIlIIlIl, final double lllllllllllIllIIIlIlIIIIIIlIIlII, final int... lllllllllllIllIIIlIlIIIIIIlIllIl) {
        for (int lllllllllllIllIIIlIlIIIIIIlIllII = 0; lllllllllllIllIIIlIlIIIIIIlIllII < this.eventListeners.size(); ++lllllllllllIllIIIlIlIIIIIIlIllII) {
            this.eventListeners.get(lllllllllllIllIIIlIlIIIIIIlIllII).func_190570_a(lllllllllllIllIIIlIlIIIIIIllIlII, false, true, lllllllllllIllIIIlIlIIIIIIlIlIIl, lllllllllllIllIIIlIlIIIIIIlIlIII, lllllllllllIllIIIlIlIIIIIIllIIIl, lllllllllllIllIIIlIlIIIIIIllIIII, lllllllllllIllIIIlIlIIIIIIlIIlIl, lllllllllllIllIIIlIlIIIIIIlIIlII, lllllllllllIllIIIlIlIIIIIIlIllIl);
        }
    }
    
    public Vec3d getFogColor(final float lllllllllllIllIIIlIIlllIlIIIllll) {
        final float lllllllllllIllIIIlIIlllIlIIIlllI = this.getCelestialAngle(lllllllllllIllIIIlIIlllIlIIIllll);
        return this.provider.getFogColor(lllllllllllIllIIIlIIlllIlIIIlllI, lllllllllllIllIIIlIIlllIlIIIllll);
    }
    
    public void immediateBlockTick(final BlockPos lllllllllllIllIIIlIIllIIIIIlIIII, final IBlockState lllllllllllIllIIIlIIllIIIIIIllll, final Random lllllllllllIllIIIlIIllIIIIIlIIlI) {
        this.scheduledUpdatesAreImmediate = true;
        lllllllllllIllIIIlIIllIIIIIIllll.getBlock().updateTick(this, lllllllllllIllIIIlIIllIIIIIlIIII, lllllllllllIllIIIlIIllIIIIIIllll, lllllllllllIllIIIlIIllIIIIIlIIlI);
        this.scheduledUpdatesAreImmediate = false;
    }
    
    public void notifyNeighborsRespectDebug(final BlockPos lllllllllllIllIIIlIlIIlIIllIIIII, final Block lllllllllllIllIIIlIlIIlIIllIIIll, final boolean lllllllllllIllIIIlIlIIlIIllIIIlI) {
        if (this.worldInfo.getTerrainType() != WorldType.DEBUG_WORLD) {
            this.notifyNeighborsOfStateChange(lllllllllllIllIIIlIlIIlIIllIIIII, lllllllllllIllIIIlIlIIlIIllIIIll, lllllllllllIllIIIlIlIIlIIllIIIlI);
        }
    }
    
    public void updateBlockTick(final BlockPos lllllllllllIllIIIlIIlllIIlIllllI, final Block lllllllllllIllIIIlIIlllIIlIlllIl, final int lllllllllllIllIIIlIIlllIIlIlllII, final int lllllllllllIllIIIlIIlllIIlIllIll) {
    }
    
    public boolean isBlockinHighHumidity(final BlockPos lllllllllllIllIIIlIIlIIIllIIlIll) {
        final Biome lllllllllllIllIIIlIIlIIIllIIlIlI = this.getBiome(lllllllllllIllIIIlIIlIIIllIIlIll);
        return lllllllllllIllIIIlIIlIIIllIIlIlI.isHighHumidity();
    }
    
    public void scheduleBlockUpdate(final BlockPos lllllllllllIllIIIlIIlllIIlIllIIl, final Block lllllllllllIllIIIlIIlllIIlIllIII, final int lllllllllllIllIIIlIIlllIIlIlIlll, final int lllllllllllIllIIIlIIlllIIlIlIllI) {
    }
    
    public long getTotalWorldTime() {
        return this.worldInfo.getWorldTotalTime();
    }
    
    public boolean addTileEntity(final TileEntity lllllllllllIllIIIlIIlllIIIIllllI) {
        final boolean lllllllllllIllIIIlIIlllIIIlIIIlI = this.loadedTileEntityList.add(lllllllllllIllIIIlIIlllIIIIllllI);
        if (lllllllllllIllIIIlIIlllIIIlIIIlI && lllllllllllIllIIIlIIlllIIIIllllI instanceof ITickable) {
            this.tickableTileEntities.add(lllllllllllIllIIIlIIlllIIIIllllI);
        }
        if (this.isRemote) {
            final BlockPos lllllllllllIllIIIlIIlllIIIlIIIIl = lllllllllllIllIIIlIIlllIIIIllllI.getPos();
            final IBlockState lllllllllllIllIIIlIIlllIIIlIIIII = this.getBlockState(lllllllllllIllIIIlIIlllIIIlIIIIl);
            this.notifyBlockUpdate(lllllllllllIllIIIlIIlllIIIlIIIIl, lllllllllllIllIIIlIIlllIIIlIIIII, lllllllllllIllIIIlIIlllIIIlIIIII, 2);
        }
        return lllllllllllIllIIIlIIlllIIIlIIIlI;
    }
    
    public void setLightFor(final EnumSkyBlock lllllllllllIllIIIlIlIIIlIlIIlIll, final BlockPos lllllllllllIllIIIlIlIIIlIlIIllll, final int lllllllllllIllIIIlIlIIIlIlIIlIIl) {
        if (this.isValid(lllllllllllIllIIIlIlIIIlIlIIllll) && this.isBlockLoaded(lllllllllllIllIIIlIlIIIlIlIIllll)) {
            final Chunk lllllllllllIllIIIlIlIIIlIlIIllIl = this.getChunkFromBlockCoords(lllllllllllIllIIIlIlIIIlIlIIllll);
            lllllllllllIllIIIlIlIIIlIlIIllIl.setLightFor(lllllllllllIllIIIlIlIIIlIlIIlIll, lllllllllllIllIIIlIlIIIlIlIIllll, lllllllllllIllIIIlIlIIIlIlIIlIIl);
            this.notifyLightSet(lllllllllllIllIIIlIlIIIlIlIIllll);
        }
    }
    
    public void updateEntity(final Entity lllllllllllIllIIIlIIlllIIIIIlIlI) {
        this.updateEntityWithOptionalForce(lllllllllllIllIIIlIIlllIIIIIlIlI, true);
    }
    
    public Calendar getCurrentDate() {
        if (this.getTotalWorldTime() % 600L == 0L) {
            this.theCalendar.setTimeInMillis(MinecraftServer.getCurrentTimeMillis());
        }
        return this.theCalendar;
    }
    
    public BlockPos getTopSolidOrLiquidBlock(final BlockPos lllllllllllIllIIIlIIlllIIlllllIl) {
        final Chunk lllllllllllIllIIIlIIlllIIlllllII = this.getChunkFromBlockCoords(lllllllllllIllIIIlIIlllIIlllllIl);
        BlockPos lllllllllllIllIIIlIIlllIIllllIll;
        BlockPos lllllllllllIllIIIlIIlllIIllllIlI;
        for (lllllllllllIllIIIlIIlllIIllllIll = new BlockPos(lllllllllllIllIIIlIIlllIIlllllIl.getX(), lllllllllllIllIIIlIIlllIIlllllII.getTopFilledSegment() + 16, lllllllllllIllIIIlIIlllIIlllllIl.getZ()); lllllllllllIllIIIlIIlllIIllllIll.getY() >= 0; lllllllllllIllIIIlIIlllIIllllIll = lllllllllllIllIIIlIIlllIIllllIlI) {
            lllllllllllIllIIIlIIlllIIllllIlI = lllllllllllIllIIIlIIlllIIllllIll.down();
            final Material lllllllllllIllIIIlIIlllIIllllIIl = lllllllllllIllIIIlIIlllIIlllllII.getBlockState(lllllllllllIllIIIlIIlllIIllllIlI).getMaterial();
            if (lllllllllllIllIIIlIIlllIIllllIIl.blocksMovement() && lllllllllllIllIIIlIIlllIIllllIIl != Material.LEAVES) {
                break;
            }
        }
        return lllllllllllIllIIIlIIlllIIllllIll;
    }
    
    @Override
    public IBlockState getBlockState(final BlockPos lllllllllllIllIIIlIlIIIlIIlIIlIl) {
        if (this.isOutsideBuildHeight(lllllllllllIllIIIlIlIIIlIIlIIlIl)) {
            return Blocks.AIR.getDefaultState();
        }
        final Chunk lllllllllllIllIIIlIlIIIlIIlIIlII = this.getChunkFromBlockCoords(lllllllllllIllIIIlIlIIIlIIlIIlIl);
        return lllllllllllIllIIIlIlIIIlIIlIIlII.getBlockState(lllllllllllIllIIIlIlIIIlIIlIIlIl);
    }
    
    public void updateComparatorOutputLevel(final BlockPos lllllllllllIllIIIlIIlIIIIIlIIlll, final Block lllllllllllIllIIIlIIlIIIIIlIIllI) {
        for (final EnumFacing lllllllllllIllIIIlIIlIIIIIlIlIll : EnumFacing.Plane.HORIZONTAL) {
            BlockPos lllllllllllIllIIIlIIlIIIIIlIlIlI = lllllllllllIllIIIlIIlIIIIIlIIlll.offset(lllllllllllIllIIIlIIlIIIIIlIlIll);
            if (this.isBlockLoaded(lllllllllllIllIIIlIIlIIIIIlIlIlI)) {
                IBlockState lllllllllllIllIIIlIIlIIIIIlIlIIl = this.getBlockState(lllllllllllIllIIIlIIlIIIIIlIlIlI);
                if (Blocks.UNPOWERED_COMPARATOR.isSameDiode(lllllllllllIllIIIlIIlIIIIIlIlIIl)) {
                    lllllllllllIllIIIlIIlIIIIIlIlIIl.neighborChanged(this, lllllllllllIllIIIlIIlIIIIIlIlIlI, lllllllllllIllIIIlIIlIIIIIlIIllI, lllllllllllIllIIIlIIlIIIIIlIIlll);
                }
                else {
                    if (!lllllllllllIllIIIlIIlIIIIIlIlIIl.isNormalCube()) {
                        continue;
                    }
                    lllllllllllIllIIIlIIlIIIIIlIlIlI = lllllllllllIllIIIlIIlIIIIIlIlIlI.offset(lllllllllllIllIIIlIIlIIIIIlIlIll);
                    lllllllllllIllIIIlIIlIIIIIlIlIIl = this.getBlockState(lllllllllllIllIIIlIIlIIIIIlIlIlI);
                    if (!Blocks.UNPOWERED_COMPARATOR.isSameDiode(lllllllllllIllIIIlIIlIIIIIlIlIIl)) {
                        continue;
                    }
                    lllllllllllIllIIIlIIlIIIIIlIlIIl.neighborChanged(this, lllllllllllIllIIIlIIlIIIIIlIlIlI, lllllllllllIllIIIlIIlIIIIIlIIllI, lllllllllllIllIIIlIIlIIIIIlIIlll);
                }
            }
        }
    }
    
    @Nullable
    public WorldSavedData loadItemData(final Class<? extends WorldSavedData> lllllllllllIllIIIlIIlIIIlIllIllI, final String lllllllllllIllIIIlIIlIIIlIllIIlI) {
        return this.mapStorage.getOrLoadData(lllllllllllIllIIIlIIlIIIlIllIllI, lllllllllllIllIIIlIIlIIIlIllIIlI);
    }
    
    public void sendPacketToServer(final Packet<?> lllllllllllIllIIIlIIIllllllIIlII) {
        throw new UnsupportedOperationException("Can't send packets to server unless you're on the client.");
    }
    
    public float getLightBrightness(final BlockPos lllllllllllIllIIIlIlIIIlIIlIllII) {
        return this.provider.getLightBrightnessTable()[this.getLightFromNeighbors(lllllllllllIllIIIlIlIIIlIIlIllII)];
    }
    
    public int countEntities(final Class<?> lllllllllllIllIIIlIIlIlIlIIIlIII) {
        int lllllllllllIllIIIlIIlIlIlIIIlIll = 0;
        for (final Entity lllllllllllIllIIIlIIlIlIlIIIlIlI : this.loadedEntityList) {
            if ((!(lllllllllllIllIIIlIIlIlIlIIIlIlI instanceof EntityLiving) || !((EntityLiving)lllllllllllIllIIIlIIlIlIlIIIlIlI).isNoDespawnRequired()) && lllllllllllIllIIIlIIlIlIlIIIlIII.isAssignableFrom(lllllllllllIllIIIlIIlIlIlIIIlIlI.getClass())) {
                ++lllllllllllIllIIIlIIlIlIlIIIlIll;
            }
        }
        return lllllllllllIllIIIlIIlIlIlIIIlIll;
    }
    
    public String getProviderName() {
        return this.chunkProvider.makeString();
    }
    
    protected abstract boolean isChunkLoaded(final int p0, final int p1, final boolean p2);
    
    public int getRedstonePower(final BlockPos lllllllllllIllIIIlIIlIlIIIlIllll, final EnumFacing lllllllllllIllIIIlIIlIlIIIlIlIlI) {
        final IBlockState lllllllllllIllIIIlIIlIlIIIlIllIl = this.getBlockState(lllllllllllIllIIIlIIlIlIIIlIllll);
        return lllllllllllIllIIIlIIlIlIIIlIllIl.isNormalCube() ? this.getStrongPower(lllllllllllIllIIIlIIlIlIIIlIllll) : lllllllllllIllIIIlIIlIlIIIlIllIl.getWeakPower(this, lllllllllllIllIIIlIIlIlIIIlIllll, lllllllllllIllIIIlIIlIlIIIlIlIlI);
    }
    
    private void spawnParticle(final int lllllllllllIllIIIlIIlllllllIlIll, final boolean lllllllllllIllIIIlIIllllllllIllI, final double lllllllllllIllIIIlIIlllllllIlIIl, final double lllllllllllIllIIIlIIllllllllIlII, final double lllllllllllIllIIIlIIlllllllIIlll, final double lllllllllllIllIIIlIIlllllllIIllI, final double lllllllllllIllIIIlIIlllllllIIlIl, final double lllllllllllIllIIIlIIllllllllIIII, final int... lllllllllllIllIIIlIIlllllllIllll) {
        for (int lllllllllllIllIIIlIIlllllllIlllI = 0; lllllllllllIllIIIlIIlllllllIlllI < this.eventListeners.size(); ++lllllllllllIllIIIlIIlllllllIlllI) {
            this.eventListeners.get(lllllllllllIllIIIlIIlllllllIlllI).spawnParticle(lllllllllllIllIIIlIIlllllllIlIll, lllllllllllIllIIIlIIllllllllIllI, lllllllllllIllIIIlIIlllllllIlIIl, lllllllllllIllIIIlIIllllllllIlII, lllllllllllIllIIIlIIlllllllIIlll, lllllllllllIllIIIlIIlllllllIIllI, lllllllllllIllIIIlIIlllllllIIlIl, lllllllllllIllIIIlIIllllllllIIII, lllllllllllIllIIIlIIlllllllIllll);
        }
    }
    
    public boolean isThundering() {
        return this.getThunderStrength(1.0f) > 0.9;
    }
    
    public float getThunderStrength(final float lllllllllllIllIIIlIIlIIIllllIIIl) {
        return (this.prevThunderingStrength + (this.thunderingStrength - this.prevThunderingStrength) * lllllllllllIllIIIlIIlIIIllllIIIl) * this.getRainStrength(lllllllllllIllIIIlIIlIIIllllIIIl);
    }
    
    public int getSeaLevel() {
        return this.seaLevel;
    }
    
    public void unloadEntities(final Collection<Entity> lllllllllllIllIIIlIIlIlIIlllIlII) {
        this.unloadedEntityList.addAll(lllllllllllIllIIIlIIlIlIIlllIlII);
    }
    
    public boolean isSpawnChunk(final int lllllllllllIllIIIlIIIlllllllIIlI, final int lllllllllllIllIIIlIIIllllllIlIlI) {
        final BlockPos lllllllllllIllIIIlIIIlllllllIIII = this.getSpawnPoint();
        final int lllllllllllIllIIIlIIIllllllIllll = lllllllllllIllIIIlIIIlllllllIIlI * 16 + 8 - lllllllllllIllIIIlIIIlllllllIIII.getX();
        final int lllllllllllIllIIIlIIIllllllIlllI = lllllllllllIllIIIlIIIllllllIlIlI * 16 + 8 - lllllllllllIllIIIlIIIlllllllIIII.getZ();
        final int lllllllllllIllIIIlIIIllllllIllIl = 128;
        return lllllllllllIllIIIlIIIllllllIllll >= -128 && lllllllllllIllIIIlIIIllllllIllll <= 128 && lllllllllllIllIIIlIIIllllllIlllI >= -128 && lllllllllllIllIIIlIIIllllllIlllI <= 128;
    }
    
    @Nullable
    public EntityPlayer getNearestAttackablePlayer(final Entity lllllllllllIllIIIlIIlIIllIlIIlII, final double lllllllllllIllIIIlIIlIIllIlIIlll, final double lllllllllllIllIIIlIIlIIllIlIIllI) {
        return this.getNearestAttackablePlayer(lllllllllllIllIIIlIIlIIllIlIIlII.posX, lllllllllllIllIIIlIIlIIllIlIIlII.posY, lllllllllllIllIIIlIIlIIllIlIIlII.posZ, lllllllllllIllIIIlIIlIIllIlIIlll, lllllllllllIllIIIlIIlIIllIlIIllI, null, null);
    }
    
    public void markBlockRangeForRenderUpdate(final int lllllllllllIllIIIlIlIIlIIIlllIII, final int lllllllllllIllIIIlIlIIlIIIllIlll, final int lllllllllllIllIIIlIlIIlIIIlIlllI, final int lllllllllllIllIIIlIlIIlIIIlIllIl, final int lllllllllllIllIIIlIlIIlIIIllIlII, final int lllllllllllIllIIIlIlIIlIIIllIIll) {
        for (int lllllllllllIllIIIlIlIIlIIIllIIlI = 0; lllllllllllIllIIIlIlIIlIIIllIIlI < this.eventListeners.size(); ++lllllllllllIllIIIlIlIIlIIIllIIlI) {
            this.eventListeners.get(lllllllllllIllIIIlIlIIlIIIllIIlI).markBlockRangeForRenderUpdate(lllllllllllIllIIIlIlIIlIIIlllIII, lllllllllllIllIIIlIlIIlIIIllIlll, lllllllllllIllIIIlIlIIlIIIlIlllI, lllllllllllIllIIIlIlIIlIIIlIllIl, lllllllllllIllIIIlIlIIlIIIllIlII, lllllllllllIllIIIlIlIIlIIIllIIll);
        }
    }
    
    public void playSound(@Nullable final EntityPlayer lllllllllllIllIIIlIlIIIIlIIlIIll, final BlockPos lllllllllllIllIIIlIlIIIIlIIllIIl, final SoundEvent lllllllllllIllIIIlIlIIIIlIIlIIIl, final SoundCategory lllllllllllIllIIIlIlIIIIlIIlIIII, final float lllllllllllIllIIIlIlIIIIlIIIllll, final float lllllllllllIllIIIlIlIIIIlIIIlllI) {
        this.playSound(lllllllllllIllIIIlIlIIIIlIIlIIll, lllllllllllIllIIIlIlIIIIlIIllIIl.getX() + 0.5, lllllllllllIllIIIlIlIIIIlIIllIIl.getY() + 0.5, lllllllllllIllIIIlIlIIIIlIIllIIl.getZ() + 0.5, lllllllllllIllIIIlIlIIIIlIIlIIIl, lllllllllllIllIIIlIlIIIIlIIlIIII, lllllllllllIllIIIlIlIIIIlIIIllll, lllllllllllIllIIIlIlIIIIlIIIlllI);
    }
    
    public boolean isBlockTickPending(final BlockPos lllllllllllIllIIIlIlIIIlllIlIlll, final Block lllllllllllIllIIIlIlIIIlllIlIllI) {
        return false;
    }
    
    public ISaveHandler getSaveHandler() {
        return this.saveHandler;
    }
    
    public void setItemData(final String lllllllllllIllIIIlIIlIIIlIllllll, final WorldSavedData lllllllllllIllIIIlIIlIIIlIlllIll) {
        this.mapStorage.setData(lllllllllllIllIIIlIIlIIIlIllllll, lllllllllllIllIIIlIIlIIIlIlllIll);
    }
    
    public boolean isDaytime() {
        return this.skylightSubtracted < 4;
    }
    
    public WorldInfo getWorldInfo() {
        return this.worldInfo;
    }
    
    public BiomeProvider getBiomeProvider() {
        return this.provider.getBiomeProvider();
    }
    
    public Random setRandomSeed(final int lllllllllllIllIIIlIIlIIIIllIlIII, final int lllllllllllIllIIIlIIlIIIIllIllII, final int lllllllllllIllIIIlIIlIIIIllIlIll) {
        final long lllllllllllIllIIIlIIlIIIIllIlIlI = lllllllllllIllIIIlIIlIIIIllIlIII * 341873128712L + lllllllllllIllIIIlIIlIIIIllIllII * 132897987541L + this.getWorldInfo().getSeed() + lllllllllllIllIIIlIIlIIIIllIlIll;
        this.rand.setSeed(lllllllllllIllIIIlIIlIIIIllIlIlI);
        return this.rand;
    }
    
    public void notifyLightSet(final BlockPos lllllllllllIllIIIlIlIIIlIlIIIIII) {
        for (int lllllllllllIllIIIlIlIIIlIlIIIIlI = 0; lllllllllllIllIIIlIlIIIlIlIIIIlI < this.eventListeners.size(); ++lllllllllllIllIIIlIlIIIlIlIIIIlI) {
            this.eventListeners.get(lllllllllllIllIIIlIlIIIlIlIIIIlI).notifyLightSet(lllllllllllIllIIIlIlIIIlIlIIIIII);
        }
    }
    
    public void func_190522_c(final BlockPos lllllllllllIllIIIlIlIIlIIIlIIIlI, final Block lllllllllllIllIIIlIlIIlIIIlIIIIl) {
        this.func_190529_b(lllllllllllIllIIIlIlIIlIIIlIIIlI.west(), lllllllllllIllIIIlIlIIlIIIlIIIIl, lllllllllllIllIIIlIlIIlIIIlIIIlI);
        this.func_190529_b(lllllllllllIllIIIlIlIIlIIIlIIIlI.east(), lllllllllllIllIIIlIlIIlIIIlIIIIl, lllllllllllIllIIIlIlIIlIIIlIIIlI);
        this.func_190529_b(lllllllllllIllIIIlIlIIlIIIlIIIlI.down(), lllllllllllIllIIIlIlIIlIIIlIIIIl, lllllllllllIllIIIlIlIIlIIIlIIIlI);
        this.func_190529_b(lllllllllllIllIIIlIlIIlIIIlIIIlI.up(), lllllllllllIllIIIlIlIIlIIIlIIIIl, lllllllllllIllIIIlIlIIlIIIlIIIlI);
        this.func_190529_b(lllllllllllIllIIIlIlIIlIIIlIIIlI.north(), lllllllllllIllIIIlIlIIlIIIlIIIIl, lllllllllllIllIIIlIlIIlIIIlIIIlI);
        this.func_190529_b(lllllllllllIllIIIlIlIIlIIIlIIIlI.south(), lllllllllllIllIIIlIlIIlIIIlIIIIl, lllllllllllIllIIIlIlIIlIIIlIIIlI);
    }
    
    public boolean canSeeSky(final BlockPos lllllllllllIllIIIlIlIIIlllIlIIII) {
        return this.getChunkFromBlockCoords(lllllllllllIllIIIlIlIIIlllIlIIII).canSeeSky(lllllllllllIllIIIlIlIIIlllIlIIII);
    }
    
    public <T extends Entity> List<T> getEntitiesWithinAABB(final Class<? extends T> lllllllllllIllIIIlIIlIlIllIlIlIl, final AxisAlignedBB lllllllllllIllIIIlIIlIlIllIlIlII, @Nullable final Predicate<? super T> lllllllllllIllIIIlIIlIlIllIlIIll) {
        final int lllllllllllIllIIIlIIlIlIllIlIIlI = MathHelper.floor((lllllllllllIllIIIlIIlIlIllIlIlII.minX - 2.0) / 16.0);
        final int lllllllllllIllIIIlIIlIlIllIlIIIl = MathHelper.ceil((lllllllllllIllIIIlIIlIlIllIlIlII.maxX + 2.0) / 16.0);
        final int lllllllllllIllIIIlIIlIlIllIlIIII = MathHelper.floor((lllllllllllIllIIIlIIlIlIllIlIlII.minZ - 2.0) / 16.0);
        final int lllllllllllIllIIIlIIlIlIllIIllll = MathHelper.ceil((lllllllllllIllIIIlIIlIlIllIlIlII.maxZ + 2.0) / 16.0);
        final List<T> lllllllllllIllIIIlIIlIlIllIIlllI = (List<T>)Lists.newArrayList();
        for (int lllllllllllIllIIIlIIlIlIllIIllIl = lllllllllllIllIIIlIIlIlIllIlIIlI; lllllllllllIllIIIlIIlIlIllIIllIl < lllllllllllIllIIIlIIlIlIllIlIIIl; ++lllllllllllIllIIIlIIlIlIllIIllIl) {
            for (int lllllllllllIllIIIlIIlIlIllIIllII = lllllllllllIllIIIlIIlIlIllIlIIII; lllllllllllIllIIIlIIlIlIllIIllII < lllllllllllIllIIIlIIlIlIllIIllll; ++lllllllllllIllIIIlIIlIlIllIIllII) {
                if (this.isChunkLoaded(lllllllllllIllIIIlIIlIlIllIIllIl, lllllllllllIllIIIlIIlIlIllIIllII, true)) {
                    this.getChunkFromChunkCoords(lllllllllllIllIIIlIIlIlIllIIllIl, lllllllllllIllIIIlIIlIlIllIIllII).getEntitiesOfTypeWithinAAAB(lllllllllllIllIIIlIIlIlIllIlIlIl, lllllllllllIllIIIlIIlIlIllIlIlII, lllllllllllIllIIIlIIlIlIllIIlllI, lllllllllllIllIIIlIIlIlIllIlIIll);
                }
            }
        }
        return lllllllllllIllIIIlIIlIlIllIIlllI;
    }
    
    public boolean handleMaterialAcceleration(final AxisAlignedBB lllllllllllIllIIIlIIllIlIIlllIlI, final Material lllllllllllIllIIIlIIllIlIlIIllIl, final Entity lllllllllllIllIIIlIIllIlIlIIllII) {
        final int lllllllllllIllIIIlIIllIlIlIIlIll = MathHelper.floor(lllllllllllIllIIIlIIllIlIIlllIlI.minX);
        final int lllllllllllIllIIIlIIllIlIlIIlIlI = MathHelper.ceil(lllllllllllIllIIIlIIllIlIIlllIlI.maxX);
        final int lllllllllllIllIIIlIIllIlIlIIlIIl = MathHelper.floor(lllllllllllIllIIIlIIllIlIIlllIlI.minY);
        final int lllllllllllIllIIIlIIllIlIlIIlIII = MathHelper.ceil(lllllllllllIllIIIlIIllIlIIlllIlI.maxY);
        final int lllllllllllIllIIIlIIllIlIlIIIlll = MathHelper.floor(lllllllllllIllIIIlIIllIlIIlllIlI.minZ);
        final int lllllllllllIllIIIlIIllIlIlIIIllI = MathHelper.ceil(lllllllllllIllIIIlIIllIlIIlllIlI.maxZ);
        if (!this.isAreaLoaded(lllllllllllIllIIIlIIllIlIlIIlIll, lllllllllllIllIIIlIIllIlIlIIlIIl, lllllllllllIllIIIlIIllIlIlIIIlll, lllllllllllIllIIIlIIllIlIlIIlIlI, lllllllllllIllIIIlIIllIlIlIIlIII, lllllllllllIllIIIlIIllIlIlIIIllI, true)) {
            return false;
        }
        boolean lllllllllllIllIIIlIIllIlIlIIIlIl = false;
        Vec3d lllllllllllIllIIIlIIllIlIlIIIlII = Vec3d.ZERO;
        final BlockPos.PooledMutableBlockPos lllllllllllIllIIIlIIllIlIlIIIIll = BlockPos.PooledMutableBlockPos.retain();
        for (int lllllllllllIllIIIlIIllIlIlIIIIlI = lllllllllllIllIIIlIIllIlIlIIlIll; lllllllllllIllIIIlIIllIlIlIIIIlI < lllllllllllIllIIIlIIllIlIlIIlIlI; ++lllllllllllIllIIIlIIllIlIlIIIIlI) {
            for (int lllllllllllIllIIIlIIllIlIlIIIIIl = lllllllllllIllIIIlIIllIlIlIIlIIl; lllllllllllIllIIIlIIllIlIlIIIIIl < lllllllllllIllIIIlIIllIlIlIIlIII; ++lllllllllllIllIIIlIIllIlIlIIIIIl) {
                for (int lllllllllllIllIIIlIIllIlIlIIIIII = lllllllllllIllIIIlIIllIlIlIIIlll; lllllllllllIllIIIlIIllIlIlIIIIII < lllllllllllIllIIIlIIllIlIlIIIllI; ++lllllllllllIllIIIlIIllIlIlIIIIII) {
                    lllllllllllIllIIIlIIllIlIlIIIIll.setPos(lllllllllllIllIIIlIIllIlIlIIIIlI, lllllllllllIllIIIlIIllIlIlIIIIIl, lllllllllllIllIIIlIIllIlIlIIIIII);
                    final IBlockState lllllllllllIllIIIlIIllIlIIllllll = this.getBlockState(lllllllllllIllIIIlIIllIlIlIIIIll);
                    final Block lllllllllllIllIIIlIIllIlIIlllllI = lllllllllllIllIIIlIIllIlIIllllll.getBlock();
                    if (lllllllllllIllIIIlIIllIlIIllllll.getMaterial() == lllllllllllIllIIIlIIllIlIlIIllIl) {
                        final double lllllllllllIllIIIlIIllIlIIllllIl = lllllllllllIllIIIlIIllIlIlIIIIIl + 1 - BlockLiquid.getLiquidHeightPercent(lllllllllllIllIIIlIIllIlIIllllll.getValue((IProperty<Integer>)BlockLiquid.LEVEL));
                        if (lllllllllllIllIIIlIIllIlIlIIlIII >= lllllllllllIllIIIlIIllIlIIllllIl) {
                            lllllllllllIllIIIlIIllIlIlIIIlIl = true;
                            lllllllllllIllIIIlIIllIlIlIIIlII = lllllllllllIllIIIlIIllIlIIlllllI.modifyAcceleration(this, lllllllllllIllIIIlIIllIlIlIIIIll, lllllllllllIllIIIlIIllIlIlIIllII, lllllllllllIllIIIlIIllIlIlIIIlII);
                        }
                    }
                }
            }
        }
        lllllllllllIllIIIlIIllIlIlIIIIll.release();
        if (lllllllllllIllIIIlIIllIlIlIIIlII.lengthVector() > 0.0 && lllllllllllIllIIIlIIllIlIlIIllII.isPushedByWater()) {
            lllllllllllIllIIIlIIllIlIlIIIlII = lllllllllllIllIIIlIIllIlIlIIIlII.normalize();
            final double lllllllllllIllIIIlIIllIlIIllllII = 0.014;
            lllllllllllIllIIIlIIllIlIlIIllII.motionX += lllllllllllIllIIIlIIllIlIlIIIlII.xCoord * 0.014;
            lllllllllllIllIIIlIIllIlIlIIllII.motionY += lllllllllllIllIIIlIIllIlIlIIIlII.yCoord * 0.014;
            lllllllllllIllIIIlIIllIlIlIIllII.motionZ += lllllllllllIllIIIlIIllIlIlIIIlII.zCoord * 0.014;
        }
        return lllllllllllIllIIIlIIllIlIlIIIlIl;
    }
    
    @Nullable
    public List<NextTickListEntry> getPendingBlockUpdates(final StructureBoundingBox lllllllllllIllIIIlIIlIllIIlllIII, final boolean lllllllllllIllIIIlIIlIllIIllIlll) {
        return null;
    }
    
    @Override
    public WorldType getWorldType() {
        return this.worldInfo.getTerrainType();
    }
    
    public Vec3d getSkyColor(final Entity lllllllllllIllIIIlIIlllIllllIIll, final float lllllllllllIllIIIlIIlllIllllIIlI) {
        final float lllllllllllIllIIIlIIlllIllllIIIl = this.getCelestialAngle(lllllllllllIllIIIlIIlllIllllIIlI);
        float lllllllllllIllIIIlIIlllIllllIIII = MathHelper.cos(lllllllllllIllIIIlIIlllIllllIIIl * 6.2831855f) * 2.0f + 0.5f;
        lllllllllllIllIIIlIIlllIllllIIII = MathHelper.clamp(lllllllllllIllIIIlIIlllIllllIIII, 0.0f, 1.0f);
        final int lllllllllllIllIIIlIIlllIlllIllll = MathHelper.floor(lllllllllllIllIIIlIIlllIllllIIll.posX);
        final int lllllllllllIllIIIlIIlllIlllIlllI = MathHelper.floor(lllllllllllIllIIIlIIlllIllllIIll.posY);
        final int lllllllllllIllIIIlIIlllIlllIllIl = MathHelper.floor(lllllllllllIllIIIlIIlllIllllIIll.posZ);
        final BlockPos lllllllllllIllIIIlIIlllIlllIllII = new BlockPos(lllllllllllIllIIIlIIlllIlllIllll, lllllllllllIllIIIlIIlllIlllIlllI, lllllllllllIllIIIlIIlllIlllIllIl);
        final Biome lllllllllllIllIIIlIIlllIlllIlIll = this.getBiome(lllllllllllIllIIIlIIlllIlllIllII);
        final float lllllllllllIllIIIlIIlllIlllIlIlI = lllllllllllIllIIIlIIlllIlllIlIll.getFloatTemperature(lllllllllllIllIIIlIIlllIlllIllII);
        final int lllllllllllIllIIIlIIlllIlllIlIIl = lllllllllllIllIIIlIIlllIlllIlIll.getSkyColorByTemp(lllllllllllIllIIIlIIlllIlllIlIlI);
        float lllllllllllIllIIIlIIlllIlllIlIII = (lllllllllllIllIIIlIIlllIlllIlIIl >> 16 & 0xFF) / 255.0f;
        float lllllllllllIllIIIlIIlllIlllIIlll = (lllllllllllIllIIIlIIlllIlllIlIIl >> 8 & 0xFF) / 255.0f;
        float lllllllllllIllIIIlIIlllIlllIIllI = (lllllllllllIllIIIlIIlllIlllIlIIl & 0xFF) / 255.0f;
        lllllllllllIllIIIlIIlllIlllIlIII *= lllllllllllIllIIIlIIlllIllllIIII;
        lllllllllllIllIIIlIIlllIlllIIlll *= lllllllllllIllIIIlIIlllIllllIIII;
        lllllllllllIllIIIlIIlllIlllIIllI *= lllllllllllIllIIIlIIlllIllllIIII;
        final float lllllllllllIllIIIlIIlllIlllIIlIl = this.getRainStrength(lllllllllllIllIIIlIIlllIllllIIlI);
        if (lllllllllllIllIIIlIIlllIlllIIlIl > 0.0f) {
            final float lllllllllllIllIIIlIIlllIlllIIlII = (lllllllllllIllIIIlIIlllIlllIlIII * 0.3f + lllllllllllIllIIIlIIlllIlllIIlll * 0.59f + lllllllllllIllIIIlIIlllIlllIIllI * 0.11f) * 0.6f;
            final float lllllllllllIllIIIlIIlllIlllIIIll = 1.0f - lllllllllllIllIIIlIIlllIlllIIlIl * 0.75f;
            lllllllllllIllIIIlIIlllIlllIlIII = lllllllllllIllIIIlIIlllIlllIlIII * lllllllllllIllIIIlIIlllIlllIIIll + lllllllllllIllIIIlIIlllIlllIIlII * (1.0f - lllllllllllIllIIIlIIlllIlllIIIll);
            lllllllllllIllIIIlIIlllIlllIIlll = lllllllllllIllIIIlIIlllIlllIIlll * lllllllllllIllIIIlIIlllIlllIIIll + lllllllllllIllIIIlIIlllIlllIIlII * (1.0f - lllllllllllIllIIIlIIlllIlllIIIll);
            lllllllllllIllIIIlIIlllIlllIIllI = lllllllllllIllIIIlIIlllIlllIIllI * lllllllllllIllIIIlIIlllIlllIIIll + lllllllllllIllIIIlIIlllIlllIIlII * (1.0f - lllllllllllIllIIIlIIlllIlllIIIll);
        }
        final float lllllllllllIllIIIlIIlllIlllIIIlI = this.getThunderStrength(lllllllllllIllIIIlIIlllIllllIIlI);
        if (lllllllllllIllIIIlIIlllIlllIIIlI > 0.0f) {
            final float lllllllllllIllIIIlIIlllIlllIIIIl = (lllllllllllIllIIIlIIlllIlllIlIII * 0.3f + lllllllllllIllIIIlIIlllIlllIIlll * 0.59f + lllllllllllIllIIIlIIlllIlllIIllI * 0.11f) * 0.2f;
            final float lllllllllllIllIIIlIIlllIlllIIIII = 1.0f - lllllllllllIllIIIlIIlllIlllIIIlI * 0.75f;
            lllllllllllIllIIIlIIlllIlllIlIII = lllllllllllIllIIIlIIlllIlllIlIII * lllllllllllIllIIIlIIlllIlllIIIII + lllllllllllIllIIIlIIlllIlllIIIIl * (1.0f - lllllllllllIllIIIlIIlllIlllIIIII);
            lllllllllllIllIIIlIIlllIlllIIlll = lllllllllllIllIIIlIIlllIlllIIlll * lllllllllllIllIIIlIIlllIlllIIIII + lllllllllllIllIIIlIIlllIlllIIIIl * (1.0f - lllllllllllIllIIIlIIlllIlllIIIII);
            lllllllllllIllIIIlIIlllIlllIIllI = lllllllllllIllIIIlIIlllIlllIIllI * lllllllllllIllIIIlIIlllIlllIIIII + lllllllllllIllIIIlIIlllIlllIIIIl * (1.0f - lllllllllllIllIIIlIIlllIlllIIIII);
        }
        if (this.lastLightningBolt > 0) {
            float lllllllllllIllIIIlIIlllIllIlllll = this.lastLightningBolt - lllllllllllIllIIIlIIlllIllllIIlI;
            if (lllllllllllIllIIIlIIlllIllIlllll > 1.0f) {
                lllllllllllIllIIIlIIlllIllIlllll = 1.0f;
            }
            lllllllllllIllIIIlIIlllIllIlllll *= 0.45f;
            lllllllllllIllIIIlIIlllIlllIlIII = lllllllllllIllIIIlIIlllIlllIlIII * (1.0f - lllllllllllIllIIIlIIlllIllIlllll) + 0.8f * lllllllllllIllIIIlIIlllIllIlllll;
            lllllllllllIllIIIlIIlllIlllIIlll = lllllllllllIllIIIlIIlllIlllIIlll * (1.0f - lllllllllllIllIIIlIIlllIllIlllll) + 0.8f * lllllllllllIllIIIlIIlllIllIlllll;
            lllllllllllIllIIIlIIlllIlllIIllI = lllllllllllIllIIIlIIlllIlllIIllI * (1.0f - lllllllllllIllIIIlIIlllIllIlllll) + 1.0f * lllllllllllIllIIIlIIlllIllIlllll;
        }
        return new Vec3d(lllllllllllIllIIIlIIlllIlllIlIII, lllllllllllIllIIIlIIlllIlllIIlll, lllllllllllIllIIIlIIlllIlllIIllI);
    }
    
    public void setInitialSpawnLocation() {
        this.setSpawnPoint(new BlockPos(8, 64, 8));
    }
    
    public int getLightFor(final EnumSkyBlock lllllllllllIllIIIlIlIIIlIlIlllIl, BlockPos lllllllllllIllIIIlIlIIIlIlIllIII) {
        if (((Vec3i)lllllllllllIllIIIlIlIIIlIlIllIII).getY() < 0) {
            lllllllllllIllIIIlIlIIIlIlIllIII = new BlockPos(((Vec3i)lllllllllllIllIIIlIlIIIlIlIllIII).getX(), 0, ((Vec3i)lllllllllllIllIIIlIlIIIlIlIllIII).getZ());
        }
        if (!this.isValid((BlockPos)lllllllllllIllIIIlIlIIIlIlIllIII)) {
            return lllllllllllIllIIIlIlIIIlIlIlllIl.defaultLightValue;
        }
        if (!this.isBlockLoaded((BlockPos)lllllllllllIllIIIlIlIIIlIlIllIII)) {
            return lllllllllllIllIIIlIlIIIlIlIlllIl.defaultLightValue;
        }
        final Chunk lllllllllllIllIIIlIlIIIlIlIllIll = this.getChunkFromBlockCoords((BlockPos)lllllllllllIllIIIlIlIIIlIlIllIII);
        return lllllllllllIllIIIlIlIIIlIlIllIll.getLightFor(lllllllllllIllIIIlIlIIIlIlIlllIl, (BlockPos)lllllllllllIllIIIlIlIIIlIlIllIII);
    }
    
    public IChunkProvider getChunkProvider() {
        return this.chunkProvider;
    }
    
    @Override
    public int getCombinedLight(final BlockPos lllllllllllIllIIIlIlIIIlIIlllIII, final int lllllllllllIllIIIlIlIIIlIIllIlll) {
        final int lllllllllllIllIIIlIlIIIlIIllIllI = this.getLightFromNeighborsFor(EnumSkyBlock.SKY, lllllllllllIllIIIlIlIIIlIIlllIII);
        int lllllllllllIllIIIlIlIIIlIIllIlIl = this.getLightFromNeighborsFor(EnumSkyBlock.BLOCK, lllllllllllIllIIIlIlIIIlIIlllIII);
        if (lllllllllllIllIIIlIlIIIlIIllIlIl < lllllllllllIllIIIlIlIIIlIIllIlll) {
            lllllllllllIllIIIlIlIIIlIIllIlIl = lllllllllllIllIIIlIlIIIlIIllIlll;
        }
        return lllllllllllIllIIIlIlIIIlIIllIllI << 20 | lllllllllllIllIIIlIlIIIlIIllIlIl << 4;
    }
    
    public void notifyBlockUpdate(final BlockPos lllllllllllIllIIIlIlIIlIIllIlllI, final IBlockState lllllllllllIllIIIlIlIIlIIllIllIl, final IBlockState lllllllllllIllIIIlIlIIlIIlllIIlI, final int lllllllllllIllIIIlIlIIlIIlllIIIl) {
        for (int lllllllllllIllIIIlIlIIlIIlllIIII = 0; lllllllllllIllIIIlIlIIlIIlllIIII < this.eventListeners.size(); ++lllllllllllIllIIIlIlIIlIIlllIIII) {
            this.eventListeners.get(lllllllllllIllIIIlIlIIlIIlllIIII).notifyBlockUpdate(this, lllllllllllIllIIIlIlIIlIIllIlllI, lllllllllllIllIIIlIlIIlIIllIllIl, lllllllllllIllIIIlIlIIlIIlllIIlI, lllllllllllIllIIIlIlIIlIIlllIIIl);
        }
    }
    
    public int getLight(BlockPos lllllllllllIllIIIlIlIIIllIlIIIlI, final boolean lllllllllllIllIIIlIlIIIllIlIlIlI) {
        if (((Vec3i)lllllllllllIllIIIlIlIIIllIlIIIlI).getX() < -30000000 || ((Vec3i)lllllllllllIllIIIlIlIIIllIlIIIlI).getZ() < -30000000 || ((Vec3i)lllllllllllIllIIIlIlIIIllIlIIIlI).getX() >= 30000000 || ((Vec3i)lllllllllllIllIIIlIlIIIllIlIIIlI).getZ() >= 30000000) {
            return 15;
        }
        if (lllllllllllIllIIIlIlIIIllIlIlIlI && this.getBlockState((BlockPos)lllllllllllIllIIIlIlIIIllIlIIIlI).useNeighborBrightness()) {
            int lllllllllllIllIIIlIlIIIllIlIlIIl = this.getLight(((BlockPos)lllllllllllIllIIIlIlIIIllIlIIIlI).up(), false);
            final int lllllllllllIllIIIlIlIIIllIlIlIII = this.getLight(((BlockPos)lllllllllllIllIIIlIlIIIllIlIIIlI).east(), false);
            final int lllllllllllIllIIIlIlIIIllIlIIlll = this.getLight(((BlockPos)lllllllllllIllIIIlIlIIIllIlIIIlI).west(), false);
            final int lllllllllllIllIIIlIlIIIllIlIIllI = this.getLight(((BlockPos)lllllllllllIllIIIlIlIIIllIlIIIlI).south(), false);
            final int lllllllllllIllIIIlIlIIIllIlIIlIl = this.getLight(((BlockPos)lllllllllllIllIIIlIlIIIllIlIIIlI).north(), false);
            if (lllllllllllIllIIIlIlIIIllIlIlIII > lllllllllllIllIIIlIlIIIllIlIlIIl) {
                lllllllllllIllIIIlIlIIIllIlIlIIl = lllllllllllIllIIIlIlIIIllIlIlIII;
            }
            if (lllllllllllIllIIIlIlIIIllIlIIlll > lllllllllllIllIIIlIlIIIllIlIlIIl) {
                lllllllllllIllIIIlIlIIIllIlIlIIl = lllllllllllIllIIIlIlIIIllIlIIlll;
            }
            if (lllllllllllIllIIIlIlIIIllIlIIllI > lllllllllllIllIIIlIlIIIllIlIlIIl) {
                lllllllllllIllIIIlIlIIIllIlIlIIl = lllllllllllIllIIIlIlIIIllIlIIllI;
            }
            if (lllllllllllIllIIIlIlIIIllIlIIlIl > lllllllllllIllIIIlIlIIIllIlIlIIl) {
                lllllllllllIllIIIlIlIIIllIlIlIIl = lllllllllllIllIIIlIlIIIllIlIIlIl;
            }
            return lllllllllllIllIIIlIlIIIllIlIlIIl;
        }
        if (((Vec3i)lllllllllllIllIIIlIlIIIllIlIIIlI).getY() < 0) {
            return 0;
        }
        if (((Vec3i)lllllllllllIllIIIlIlIIIllIlIIIlI).getY() >= 256) {
            lllllllllllIllIIIlIlIIIllIlIIIlI = new BlockPos(((Vec3i)lllllllllllIllIIIlIlIIIllIlIIIlI).getX(), 255, ((Vec3i)lllllllllllIllIIIlIlIIIllIlIIIlI).getZ());
        }
        final Chunk lllllllllllIllIIIlIlIIIllIlIIlII = this.getChunkFromBlockCoords((BlockPos)lllllllllllIllIIIlIlIIIllIlIIIlI);
        return lllllllllllIllIIIlIlIIIllIlIIlII.getLightSubtracted((BlockPos)lllllllllllIllIIIlIlIIIllIlIIIlI, this.skylightSubtracted);
    }
    
    @Nullable
    public RayTraceResult rayTraceBlocks(final Vec3d lllllllllllIllIIIlIlIIIlIIIIllll, final Vec3d lllllllllllIllIIIlIlIIIlIIIIlllI, final boolean lllllllllllIllIIIlIlIIIlIIIIllIl) {
        return this.rayTraceBlocks(lllllllllllIllIIIlIlIIIlIIIIllll, lllllllllllIllIIIlIlIIIlIIIIlllI, lllllllllllIllIIIlIlIIIlIIIIllIl, false, false);
    }
    
    @Nullable
    public BlockPos func_190528_a(final String lllllllllllIllIIIlIIIlllllIlllll, final BlockPos lllllllllllIllIIIlIIIlllllIllllI, final boolean lllllllllllIllIIIlIIIlllllIlllIl) {
        return null;
    }
    
    public CrashReportCategory addWorldInfoToCrashReport(final CrashReport lllllllllllIllIIIlIIlIIIIlIlllII) {
        final CrashReportCategory lllllllllllIllIIIlIIlIIIIlIllIll = lllllllllllIllIIIlIIlIIIIlIlllII.makeCategoryDepth("Affected level", 1);
        lllllllllllIllIIIlIIlIIIIlIllIll.addCrashSection("Level name", (this.worldInfo == null) ? "????" : this.worldInfo.getWorldName());
        lllllllllllIllIIIlIIlIIIIlIllIll.setDetail("All players", new ICrashReportDetail<String>() {
            @Override
            public String call() {
                return String.valueOf(World.this.playerEntities.size()) + " total; " + World.this.playerEntities;
            }
        });
        lllllllllllIllIIIlIIlIIIIlIllIll.setDetail("Chunk stats", new ICrashReportDetail<String>() {
            @Override
            public String call() {
                return World.this.chunkProvider.makeString();
            }
        });
        try {
            this.worldInfo.addToCrashReport(lllllllllllIllIIIlIIlIIIIlIllIll);
        }
        catch (Throwable lllllllllllIllIIIlIIlIIIIlIllIlI) {
            lllllllllllIllIIIlIIlIIIIlIllIll.addCrashSectionThrowable("Level Data Unobtainable", lllllllllllIllIIIlIIlIIIIlIllIlI);
        }
        return lllllllllllIllIIIlIIlIIIIlIllIll;
    }
    
    public int getStrongPower(final BlockPos lllllllllllIllIIIlIIlIlIIlIIIIlI) {
        int lllllllllllIllIIIlIIlIlIIlIIIIIl = 0;
        lllllllllllIllIIIlIIlIlIIlIIIIIl = Math.max(lllllllllllIllIIIlIIlIlIIlIIIIIl, this.getStrongPower(lllllllllllIllIIIlIIlIlIIlIIIIlI.down(), EnumFacing.DOWN));
        if (lllllllllllIllIIIlIIlIlIIlIIIIIl >= 15) {
            return lllllllllllIllIIIlIIlIlIIlIIIIIl;
        }
        lllllllllllIllIIIlIIlIlIIlIIIIIl = Math.max(lllllllllllIllIIIlIIlIlIIlIIIIIl, this.getStrongPower(lllllllllllIllIIIlIIlIlIIlIIIIlI.up(), EnumFacing.UP));
        if (lllllllllllIllIIIlIIlIlIIlIIIIIl >= 15) {
            return lllllllllllIllIIIlIIlIlIIlIIIIIl;
        }
        lllllllllllIllIIIlIIlIlIIlIIIIIl = Math.max(lllllllllllIllIIIlIIlIlIIlIIIIIl, this.getStrongPower(lllllllllllIllIIIlIIlIlIIlIIIIlI.north(), EnumFacing.NORTH));
        if (lllllllllllIllIIIlIIlIlIIlIIIIIl >= 15) {
            return lllllllllllIllIIIlIIlIlIIlIIIIIl;
        }
        lllllllllllIllIIIlIIlIlIIlIIIIIl = Math.max(lllllllllllIllIIIlIIlIlIIlIIIIIl, this.getStrongPower(lllllllllllIllIIIlIIlIlIIlIIIIlI.south(), EnumFacing.SOUTH));
        if (lllllllllllIllIIIlIIlIlIIlIIIIIl >= 15) {
            return lllllllllllIllIIIlIIlIlIIlIIIIIl;
        }
        lllllllllllIllIIIlIIlIlIIlIIIIIl = Math.max(lllllllllllIllIIIlIIlIlIIlIIIIIl, this.getStrongPower(lllllllllllIllIIIlIIlIlIIlIIIIlI.west(), EnumFacing.WEST));
        if (lllllllllllIllIIIlIIlIlIIlIIIIIl >= 15) {
            return lllllllllllIllIIIlIIlIlIIlIIIIIl;
        }
        lllllllllllIllIIIlIIlIlIIlIIIIIl = Math.max(lllllllllllIllIIIlIIlIlIIlIIIIIl, this.getStrongPower(lllllllllllIllIIIlIIlIlIIlIIIIlI.east(), EnumFacing.EAST));
        return (lllllllllllIllIIIlIIlIlIIlIIIIIl >= 15) ? lllllllllllIllIIIlIIlIlIIlIIIIIl : lllllllllllIllIIIlIIlIlIIlIIIIIl;
    }
    
    public boolean func_190526_b(final int lllllllllllIllIIIlIlIIlIlIllIIll, final int lllllllllllIllIIIlIlIIlIlIllIIlI) {
        return this.isChunkLoaded(lllllllllllIllIIIlIlIIlIlIllIIll, lllllllllllIllIIIlIlIIlIlIllIIlI, false) || this.chunkProvider.func_191062_e(lllllllllllIllIIIlIlIIlIlIllIIll, lllllllllllIllIIIlIlIIlIlIllIIlI);
    }
    
    public WorldBorder getWorldBorder() {
        return this.worldBorder;
    }
    
    public Chunk getChunkFromBlockCoords(final BlockPos lllllllllllIllIIIlIlIIlIllIIIIll) {
        return this.getChunkFromChunkCoords(lllllllllllIllIIIlIlIIlIllIIIIll.getX() >> 4, lllllllllllIllIIIlIlIIlIllIIIIll.getZ() >> 4);
    }
    
    public void setAllowedSpawnTypes(final boolean lllllllllllIllIIIlIIllIIIIllIlll, final boolean lllllllllllIllIIIlIIllIIIIllIllI) {
        this.spawnHostileMobs = lllllllllllIllIIIlIIllIIIIllIlll;
        this.spawnPeacefulMobs = lllllllllllIllIIIlIIllIIIIllIllI;
    }
    
    public boolean isAreaLoaded(final BlockPos lllllllllllIllIIIlIlIIllIIIIllll, final int lllllllllllIllIIIlIlIIllIIIIlIlI, final boolean lllllllllllIllIIIlIlIIllIIIIlIIl) {
        return this.isAreaLoaded(lllllllllllIllIIIlIlIIllIIIIllll.getX() - lllllllllllIllIIIlIlIIllIIIIlIlI, lllllllllllIllIIIlIlIIllIIIIllll.getY() - lllllllllllIllIIIlIlIIllIIIIlIlI, lllllllllllIllIIIlIlIIllIIIIllll.getZ() - lllllllllllIllIIIlIlIIllIIIIlIlI, lllllllllllIllIIIlIlIIllIIIIllll.getX() + lllllllllllIllIIIlIlIIllIIIIlIlI, lllllllllllIllIIIlIlIIllIIIIllll.getY() + lllllllllllIllIIIlIlIIllIIIIlIlI, lllllllllllIllIIIlIlIIllIIIIllll.getZ() + lllllllllllIllIIIlIlIIllIIIIlIlI, lllllllllllIllIIIlIlIIllIIIIlIIl);
    }
    
    public void sendQuittingDisconnectingPacket() {
    }
    
    public boolean isMaterialInBB(final AxisAlignedBB lllllllllllIllIIIlIIllIlIIIIllIl, final Material lllllllllllIllIIIlIIllIlIIIllIIl) {
        final int lllllllllllIllIIIlIIllIlIIIllIII = MathHelper.floor(lllllllllllIllIIIlIIllIlIIIIllIl.minX);
        final int lllllllllllIllIIIlIIllIlIIIlIlll = MathHelper.ceil(lllllllllllIllIIIlIIllIlIIIIllIl.maxX);
        final int lllllllllllIllIIIlIIllIlIIIlIllI = MathHelper.floor(lllllllllllIllIIIlIIllIlIIIIllIl.minY);
        final int lllllllllllIllIIIlIIllIlIIIlIlIl = MathHelper.ceil(lllllllllllIllIIIlIIllIlIIIIllIl.maxY);
        final int lllllllllllIllIIIlIIllIlIIIlIlII = MathHelper.floor(lllllllllllIllIIIlIIllIlIIIIllIl.minZ);
        final int lllllllllllIllIIIlIIllIlIIIlIIll = MathHelper.ceil(lllllllllllIllIIIlIIllIlIIIIllIl.maxZ);
        final BlockPos.PooledMutableBlockPos lllllllllllIllIIIlIIllIlIIIlIIlI = BlockPos.PooledMutableBlockPos.retain();
        for (int lllllllllllIllIIIlIIllIlIIIlIIIl = lllllllllllIllIIIlIIllIlIIIllIII; lllllllllllIllIIIlIIllIlIIIlIIIl < lllllllllllIllIIIlIIllIlIIIlIlll; ++lllllllllllIllIIIlIIllIlIIIlIIIl) {
            for (int lllllllllllIllIIIlIIllIlIIIlIIII = lllllllllllIllIIIlIIllIlIIIlIllI; lllllllllllIllIIIlIIllIlIIIlIIII < lllllllllllIllIIIlIIllIlIIIlIlIl; ++lllllllllllIllIIIlIIllIlIIIlIIII) {
                for (int lllllllllllIllIIIlIIllIlIIIIllll = lllllllllllIllIIIlIIllIlIIIlIlII; lllllllllllIllIIIlIIllIlIIIIllll < lllllllllllIllIIIlIIllIlIIIlIIll; ++lllllllllllIllIIIlIIllIlIIIIllll) {
                    if (this.getBlockState(lllllllllllIllIIIlIIllIlIIIlIIlI.setPos(lllllllllllIllIIIlIIllIlIIIlIIIl, lllllllllllIllIIIlIIllIlIIIlIIII, lllllllllllIllIIIlIIllIlIIIIllll)).getMaterial() == lllllllllllIllIIIlIIllIlIIIllIIl) {
                        lllllllllllIllIIIlIIllIlIIIlIIlI.release();
                        return true;
                    }
                }
            }
        }
        lllllllllllIllIIIlIIllIlIIIlIIlI.release();
        return false;
    }
    
    @Nullable
    @Override
    public TileEntity getTileEntity(final BlockPos lllllllllllIllIIIlIIllIIlIIIlIll) {
        if (this.isOutsideBuildHeight(lllllllllllIllIIIlIIllIIlIIIlIll)) {
            return null;
        }
        TileEntity lllllllllllIllIIIlIIllIIlIIIlIlI = null;
        if (this.processingLoadedTiles) {
            lllllllllllIllIIIlIIllIIlIIIlIlI = this.getPendingTileEntityAt(lllllllllllIllIIIlIIllIIlIIIlIll);
        }
        if (lllllllllllIllIIIlIIllIIlIIIlIlI == null) {
            lllllllllllIllIIIlIIllIIlIIIlIlI = this.getChunkFromBlockCoords(lllllllllllIllIIIlIIllIIlIIIlIll).getTileEntity(lllllllllllIllIIIlIIllIIlIIIlIll, Chunk.EnumCreateEntityType.IMMEDIATE);
        }
        if (lllllllllllIllIIIlIIllIIlIIIlIlI == null) {
            lllllllllllIllIIIlIIllIIlIIIlIlI = this.getPendingTileEntityAt(lllllllllllIllIIIlIIllIIlIIIlIll);
        }
        return lllllllllllIllIIIlIIllIIlIIIlIlI;
    }
    
    private boolean isValid(final BlockPos lllllllllllIllIIIlIlIIllIIllIlll) {
        return !this.isOutsideBuildHeight(lllllllllllIllIIIlIlIIllIIllIlll) && lllllllllllIllIIIlIlIIllIIllIlll.getX() >= -30000000 && lllllllllllIllIIIlIlIIllIIllIlll.getZ() >= -30000000 && lllllllllllIllIIIlIlIIllIIllIlll.getX() < 30000000 && lllllllllllIllIIIlIlIIllIIllIlll.getZ() < 30000000;
    }
    
    public boolean func_191503_g(final Entity lllllllllllIllIIIlIIllllIIllIIII) {
        double lllllllllllIllIIIlIIllllIIlIllll = this.worldBorder.minX();
        double lllllllllllIllIIIlIIllllIIlIlllI = this.worldBorder.minZ();
        double lllllllllllIllIIIlIIllllIIlIllIl = this.worldBorder.maxX();
        double lllllllllllIllIIIlIIllllIIlIllII = this.worldBorder.maxZ();
        if (lllllllllllIllIIIlIIllllIIllIIII.isOutsideBorder()) {
            ++lllllllllllIllIIIlIIllllIIlIllll;
            ++lllllllllllIllIIIlIIllllIIlIlllI;
            --lllllllllllIllIIIlIIllllIIlIllIl;
            --lllllllllllIllIIIlIIllllIIlIllII;
        }
        else {
            --lllllllllllIllIIIlIIllllIIlIllll;
            --lllllllllllIllIIIlIIllllIIlIlllI;
            ++lllllllllllIllIIIlIIllllIIlIllIl;
            ++lllllllllllIllIIIlIIllllIIlIllII;
        }
        return lllllllllllIllIIIlIIllllIIllIIII.posX > lllllllllllIllIIIlIIllllIIlIllll && lllllllllllIllIIIlIIllllIIllIIII.posX < lllllllllllIllIIIlIIllllIIlIllIl && lllllllllllIllIIIlIIllllIIllIIII.posZ > lllllllllllIllIIIlIIllllIIlIlllI && lllllllllllIllIIIlIIllllIIllIIII.posZ < lllllllllllIllIIIlIIllllIIlIllII;
    }
    
    public void sendBlockBreakProgress(final int lllllllllllIllIIIlIIlIIIIlIIlIII, final BlockPos lllllllllllIllIIIlIIlIIIIlIIIlll, final int lllllllllllIllIIIlIIlIIIIlIIllII) {
        for (int lllllllllllIllIIIlIIlIIIIlIIlIll = 0; lllllllllllIllIIIlIIlIIIIlIIlIll < this.eventListeners.size(); ++lllllllllllIllIIIlIIlIIIIlIIlIll) {
            final IWorldEventListener lllllllllllIllIIIlIIlIIIIlIIlIlI = this.eventListeners.get(lllllllllllIllIIIlIIlIIIIlIIlIll);
            lllllllllllIllIIIlIIlIIIIlIIlIlI.sendBlockBreakProgress(lllllllllllIllIIIlIIlIIIIlIIlIII, lllllllllllIllIIIlIIlIIIIlIIIlll, lllllllllllIllIIIlIIlIIIIlIIllII);
        }
    }
    
    public void markTileEntityForRemoval(final TileEntity lllllllllllIllIIIlIIllIIIlIlllIl) {
        this.tileEntitiesToBeRemoved.add(lllllllllllIllIIIlIIllIIIlIlllIl);
    }
    
    public void notifyNeighborsOfStateExcept(final BlockPos lllllllllllIllIIIlIlIIlIIIIIlIll, final Block lllllllllllIllIIIlIlIIlIIIIIlllI, final EnumFacing lllllllllllIllIIIlIlIIlIIIIIlIIl) {
        if (lllllllllllIllIIIlIlIIlIIIIIlIIl != EnumFacing.WEST) {
            this.func_190524_a(lllllllllllIllIIIlIlIIlIIIIIlIll.west(), lllllllllllIllIIIlIlIIlIIIIIlllI, lllllllllllIllIIIlIlIIlIIIIIlIll);
        }
        if (lllllllllllIllIIIlIlIIlIIIIIlIIl != EnumFacing.EAST) {
            this.func_190524_a(lllllllllllIllIIIlIlIIlIIIIIlIll.east(), lllllllllllIllIIIlIlIIlIIIIIlllI, lllllllllllIllIIIlIlIIlIIIIIlIll);
        }
        if (lllllllllllIllIIIlIlIIlIIIIIlIIl != EnumFacing.DOWN) {
            this.func_190524_a(lllllllllllIllIIIlIlIIlIIIIIlIll.down(), lllllllllllIllIIIlIlIIlIIIIIlllI, lllllllllllIllIIIlIlIIlIIIIIlIll);
        }
        if (lllllllllllIllIIIlIlIIlIIIIIlIIl != EnumFacing.UP) {
            this.func_190524_a(lllllllllllIllIIIlIlIIlIIIIIlIll.up(), lllllllllllIllIIIlIlIIlIIIIIlllI, lllllllllllIllIIIlIlIIlIIIIIlIll);
        }
        if (lllllllllllIllIIIlIlIIlIIIIIlIIl != EnumFacing.NORTH) {
            this.func_190524_a(lllllllllllIllIIIlIlIIlIIIIIlIll.north(), lllllllllllIllIIIlIlIIlIIIIIlllI, lllllllllllIllIIIlIlIIlIIIIIlIll);
        }
        if (lllllllllllIllIIIlIlIIlIIIIIlIIl != EnumFacing.SOUTH) {
            this.func_190524_a(lllllllllllIllIIIlIlIIlIIIIIlIll.south(), lllllllllllIllIIIlIlIIlIIIIIlllI, lllllllllllIllIIIlIlIIlIIIIIlIll);
        }
    }
    
    public int isBlockIndirectlyGettingPowered(final BlockPos lllllllllllIllIIIlIIlIlIIIIllIIl) {
        int lllllllllllIllIIIlIIlIlIIIIllIII = 0;
        final float lllllllllllIllIIIlIIlIlIIIIIllll;
        final long lllllllllllIllIIIlIIlIlIIIIlIIII = ((EnumFacing[])(Object)(lllllllllllIllIIIlIIlIlIIIIIllll = (float)(Object)EnumFacing.values())).length;
        for (byte lllllllllllIllIIIlIIlIlIIIIlIIIl = 0; lllllllllllIllIIIlIIlIlIIIIlIIIl < lllllllllllIllIIIlIIlIlIIIIlIIII; ++lllllllllllIllIIIlIIlIlIIIIlIIIl) {
            final EnumFacing lllllllllllIllIIIlIIlIlIIIIlIlll = lllllllllllIllIIIlIIlIlIIIIIllll[lllllllllllIllIIIlIIlIlIIIIlIIIl];
            final int lllllllllllIllIIIlIIlIlIIIIlIllI = this.getRedstonePower(lllllllllllIllIIIlIIlIlIIIIllIIl.offset(lllllllllllIllIIIlIIlIlIIIIlIlll), lllllllllllIllIIIlIIlIlIIIIlIlll);
            if (lllllllllllIllIIIlIIlIlIIIIlIllI >= 15) {
                return 15;
            }
            if (lllllllllllIllIIIlIIlIlIIIIlIllI > lllllllllllIllIIIlIIlIlIIIIllIII) {
                lllllllllllIllIIIlIIlIlIIIIllIII = lllllllllllIllIIIlIIlIlIIIIlIllI;
            }
        }
        return lllllllllllIllIIIlIIlIlIIIIllIII;
    }
    
    public void removeEntity(final Entity lllllllllllIllIIIlIIlllllIllIIll) {
        if (lllllllllllIllIIIlIIlllllIllIIll.isBeingRidden()) {
            lllllllllllIllIIIlIIlllllIllIIll.removePassengers();
        }
        if (lllllllllllIllIIIlIIlllllIllIIll.isRiding()) {
            lllllllllllIllIIIlIIlllllIllIIll.dismountRidingEntity();
        }
        lllllllllllIllIIIlIIlllllIllIIll.setDead();
        if (lllllllllllIllIIIlIIlllllIllIIll instanceof EntityPlayer) {
            this.playerEntities.remove(lllllllllllIllIIIlIIlllllIllIIll);
            this.updateAllPlayersSleepingFlag();
            this.onEntityRemoved(lllllllllllIllIIIlIIlllllIllIIll);
        }
    }
    
    public boolean isBlockPowered(final BlockPos lllllllllllIllIIIlIIlIlIIIlIIIll) {
        return this.getRedstonePower(lllllllllllIllIIIlIIlIlIIIlIIIll.down(), EnumFacing.DOWN) > 0 || this.getRedstonePower(lllllllllllIllIIIlIIlIlIIIlIIIll.up(), EnumFacing.UP) > 0 || this.getRedstonePower(lllllllllllIllIIIlIIlIlIIIlIIIll.north(), EnumFacing.NORTH) > 0 || this.getRedstonePower(lllllllllllIllIIIlIIlIlIIIlIIIll.south(), EnumFacing.SOUTH) > 0 || this.getRedstonePower(lllllllllllIllIIIlIIlIlIIIlIIIll.west(), EnumFacing.WEST) > 0 || this.getRedstonePower(lllllllllllIllIIIlIIlIlIIIlIIIll.east(), EnumFacing.EAST) > 0;
    }
    
    public boolean canBlockFreeze(final BlockPos lllllllllllIllIIIlIIlIlllllllIII, final boolean lllllllllllIllIIIlIIlIlllllIllll) {
        final Biome lllllllllllIllIIIlIIlIllllllIllI = this.getBiome(lllllllllllIllIIIlIIlIlllllllIII);
        final float lllllllllllIllIIIlIIlIllllllIlIl = lllllllllllIllIIIlIIlIllllllIllI.getFloatTemperature(lllllllllllIllIIIlIIlIlllllllIII);
        if (lllllllllllIllIIIlIIlIllllllIlIl >= 0.15f) {
            return false;
        }
        if (lllllllllllIllIIIlIIlIlllllllIII.getY() >= 0 && lllllllllllIllIIIlIIlIlllllllIII.getY() < 256 && this.getLightFor(EnumSkyBlock.BLOCK, lllllllllllIllIIIlIIlIlllllllIII) < 10) {
            final IBlockState lllllllllllIllIIIlIIlIllllllIlII = this.getBlockState(lllllllllllIllIIIlIIlIlllllllIII);
            final Block lllllllllllIllIIIlIIlIllllllIIll = lllllllllllIllIIIlIIlIllllllIlII.getBlock();
            if ((lllllllllllIllIIIlIIlIllllllIIll == Blocks.WATER || lllllllllllIllIIIlIIlIllllllIIll == Blocks.FLOWING_WATER) && lllllllllllIllIIIlIIlIllllllIlII.getValue((IProperty<Integer>)BlockLiquid.LEVEL) == 0) {
                if (!lllllllllllIllIIIlIIlIlllllIllll) {
                    return true;
                }
                final boolean lllllllllllIllIIIlIIlIllllllIIlI = this.isWater(lllllllllllIllIIIlIIlIlllllllIII.west()) && this.isWater(lllllllllllIllIIIlIIlIlllllllIII.east()) && this.isWater(lllllllllllIllIIIlIIlIlllllllIII.north()) && this.isWater(lllllllllllIllIIIlIIlIlllllllIII.south());
                if (!lllllllllllIllIIIlIIlIllllllIIlI) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public void func_190529_b(final BlockPos lllllllllllIllIIIlIlIIIlllIlllll, final Block lllllllllllIllIIIlIlIIIlllIllllI, final BlockPos lllllllllllIllIIIlIlIIIlllIlllIl) {
        if (!this.isRemote) {
            final IBlockState lllllllllllIllIIIlIlIIIllllIIlII = this.getBlockState(lllllllllllIllIIIlIlIIIlllIlllll);
            if (lllllllllllIllIIIlIlIIIllllIIlII.getBlock() == Blocks.field_190976_dk) {
                try {
                    ((BlockObserver)lllllllllllIllIIIlIlIIIllllIIlII.getBlock()).func_190962_b(lllllllllllIllIIIlIlIIIllllIIlII, this, lllllllllllIllIIIlIlIIIlllIlllll, lllllllllllIllIIIlIlIIIlllIllllI, lllllllllllIllIIIlIlIIIlllIlllIl);
                }
                catch (Throwable lllllllllllIllIIIlIlIIIllllIIIll) {
                    final CrashReport lllllllllllIllIIIlIlIIIllllIIIlI = CrashReport.makeCrashReport(lllllllllllIllIIIlIlIIIllllIIIll, "Exception while updating neighbours");
                    final CrashReportCategory lllllllllllIllIIIlIlIIIllllIIIIl = lllllllllllIllIIIlIlIIIllllIIIlI.makeCategory("Block being updated");
                    lllllllllllIllIIIlIlIIIllllIIIIl.setDetail("Source block type", new ICrashReportDetail<String>() {
                        @Override
                        public String call() throws Exception {
                            try {
                                return String.format("ID #%d (%s // %s)", Block.getIdFromBlock(lllllllllllIllIIIlIlIIIlllIllllI), lllllllllllIllIIIlIlIIIlllIllllI.getUnlocalizedName(), lllllllllllIllIIIlIlIIIlllIllllI.getClass().getCanonicalName());
                            }
                            catch (Throwable lllllllllllIIllIIllllIllIllllIlI) {
                                return "ID #" + Block.getIdFromBlock(lllllllllllIllIIIlIlIIIlllIllllI);
                            }
                        }
                    });
                    CrashReportCategory.addBlockInfo(lllllllllllIllIIIlIlIIIllllIIIIl, lllllllllllIllIIIlIlIIIlllIlllll, lllllllllllIllIIIlIlIIIllllIIlII);
                    throw new ReportedException(lllllllllllIllIIIlIlIIIllllIIIlI);
                }
            }
        }
    }
    
    @Nullable
    public EntityPlayer getPlayerEntityByUUID(final UUID lllllllllllIllIIIlIIlIIlIlIlIlll) {
        for (int lllllllllllIllIIIlIIlIIlIlIlIllI = 0; lllllllllllIllIIIlIIlIIlIlIlIllI < this.playerEntities.size(); ++lllllllllllIllIIIlIIlIIlIlIlIllI) {
            final EntityPlayer lllllllllllIllIIIlIIlIIlIlIlIlIl = this.playerEntities.get(lllllllllllIllIIIlIIlIIlIlIlIllI);
            if (lllllllllllIllIIIlIIlIIlIlIlIlll.equals(lllllllllllIllIIIlIIlIIlIlIlIlIl.getUniqueID())) {
                return lllllllllllIllIIIlIIlIIlIlIlIlIl;
            }
        }
        return null;
    }
    
    public boolean containsAnyLiquid(final AxisAlignedBB lllllllllllIllIIIlIIllIllIlIIIlI) {
        final int lllllllllllIllIIIlIIllIllIlIIIIl = MathHelper.floor(lllllllllllIllIIIlIIllIllIlIIIlI.minX);
        final int lllllllllllIllIIIlIIllIllIlIIIII = MathHelper.ceil(lllllllllllIllIIIlIIllIllIlIIIlI.maxX);
        final int lllllllllllIllIIIlIIllIllIIlllll = MathHelper.floor(lllllllllllIllIIIlIIllIllIlIIIlI.minY);
        final int lllllllllllIllIIIlIIllIllIIllllI = MathHelper.ceil(lllllllllllIllIIIlIIllIllIlIIIlI.maxY);
        final int lllllllllllIllIIIlIIllIllIIlllIl = MathHelper.floor(lllllllllllIllIIIlIIllIllIlIIIlI.minZ);
        final int lllllllllllIllIIIlIIllIllIIlllII = MathHelper.ceil(lllllllllllIllIIIlIIllIllIlIIIlI.maxZ);
        final BlockPos.PooledMutableBlockPos lllllllllllIllIIIlIIllIllIIllIll = BlockPos.PooledMutableBlockPos.retain();
        for (int lllllllllllIllIIIlIIllIllIIllIlI = lllllllllllIllIIIlIIllIllIlIIIIl; lllllllllllIllIIIlIIllIllIIllIlI < lllllllllllIllIIIlIIllIllIlIIIII; ++lllllllllllIllIIIlIIllIllIIllIlI) {
            for (int lllllllllllIllIIIlIIllIllIIllIIl = lllllllllllIllIIIlIIllIllIIlllll; lllllllllllIllIIIlIIllIllIIllIIl < lllllllllllIllIIIlIIllIllIIllllI; ++lllllllllllIllIIIlIIllIllIIllIIl) {
                for (int lllllllllllIllIIIlIIllIllIIllIII = lllllllllllIllIIIlIIllIllIIlllIl; lllllllllllIllIIIlIIllIllIIllIII < lllllllllllIllIIIlIIllIllIIlllII; ++lllllllllllIllIIIlIIllIllIIllIII) {
                    final IBlockState lllllllllllIllIIIlIIllIllIIlIlll = this.getBlockState(lllllllllllIllIIIlIIllIllIIllIll.setPos(lllllllllllIllIIIlIIllIllIIllIlI, lllllllllllIllIIIlIIllIllIIllIIl, lllllllllllIllIIIlIIllIllIIllIII));
                    if (lllllllllllIllIIIlIIllIllIIlIlll.getMaterial().isLiquid()) {
                        lllllllllllIllIIIlIIllIllIIllIll.release();
                        return true;
                    }
                }
            }
        }
        lllllllllllIllIIIlIIllIllIIllIll.release();
        return false;
    }
    
    public boolean setBlockState(final BlockPos lllllllllllIllIIIlIlIIlIlIIIIIII, final IBlockState lllllllllllIllIIIlIlIIlIIlllllII) {
        return this.setBlockState(lllllllllllIllIIIlIlIIlIlIIIIIII, lllllllllllIllIIIlIlIIlIIlllllII, 3);
    }
    
    protected void playMoodSoundAndCheckLight(final int lllllllllllIllIIIlIIllIIIIIllllI, final int lllllllllllIllIIIlIIllIIIIIlllIl, final Chunk lllllllllllIllIIIlIIllIIIIIllIll) {
        lllllllllllIllIIIlIIllIIIIIllIll.enqueueRelightChecks();
    }
    
    public Vec3d getCloudColour(final float lllllllllllIllIIIlIIlllIlIlIlIlI) {
        final float lllllllllllIllIIIlIIlllIlIlIlIIl = this.getCelestialAngle(lllllllllllIllIIIlIIlllIlIlIlIlI);
        float lllllllllllIllIIIlIIlllIlIlIlIII = MathHelper.cos(lllllllllllIllIIIlIIlllIlIlIlIIl * 6.2831855f) * 2.0f + 0.5f;
        lllllllllllIllIIIlIIlllIlIlIlIII = MathHelper.clamp(lllllllllllIllIIIlIIlllIlIlIlIII, 0.0f, 1.0f);
        float lllllllllllIllIIIlIIlllIlIlIIlll = 1.0f;
        float lllllllllllIllIIIlIIlllIlIlIIllI = 1.0f;
        float lllllllllllIllIIIlIIlllIlIlIIlIl = 1.0f;
        final float lllllllllllIllIIIlIIlllIlIlIIlII = this.getRainStrength(lllllllllllIllIIIlIIlllIlIlIlIlI);
        if (lllllllllllIllIIIlIIlllIlIlIIlII > 0.0f) {
            final float lllllllllllIllIIIlIIlllIlIlIIIll = (lllllllllllIllIIIlIIlllIlIlIIlll * 0.3f + lllllllllllIllIIIlIIlllIlIlIIllI * 0.59f + lllllllllllIllIIIlIIlllIlIlIIlIl * 0.11f) * 0.6f;
            final float lllllllllllIllIIIlIIlllIlIlIIIlI = 1.0f - lllllllllllIllIIIlIIlllIlIlIIlII * 0.95f;
            lllllllllllIllIIIlIIlllIlIlIIlll = lllllllllllIllIIIlIIlllIlIlIIlll * lllllllllllIllIIIlIIlllIlIlIIIlI + lllllllllllIllIIIlIIlllIlIlIIIll * (1.0f - lllllllllllIllIIIlIIlllIlIlIIIlI);
            lllllllllllIllIIIlIIlllIlIlIIllI = lllllllllllIllIIIlIIlllIlIlIIllI * lllllllllllIllIIIlIIlllIlIlIIIlI + lllllllllllIllIIIlIIlllIlIlIIIll * (1.0f - lllllllllllIllIIIlIIlllIlIlIIIlI);
            lllllllllllIllIIIlIIlllIlIlIIlIl = lllllllllllIllIIIlIIlllIlIlIIlIl * lllllllllllIllIIIlIIlllIlIlIIIlI + lllllllllllIllIIIlIIlllIlIlIIIll * (1.0f - lllllllllllIllIIIlIIlllIlIlIIIlI);
        }
        lllllllllllIllIIIlIIlllIlIlIIlll *= lllllllllllIllIIIlIIlllIlIlIlIII * 0.9f + 0.1f;
        lllllllllllIllIIIlIIlllIlIlIIllI *= lllllllllllIllIIIlIIlllIlIlIlIII * 0.9f + 0.1f;
        lllllllllllIllIIIlIIlllIlIlIIlIl *= lllllllllllIllIIIlIIlllIlIlIlIII * 0.85f + 0.15f;
        final float lllllllllllIllIIIlIIlllIlIlIIIIl = this.getThunderStrength(lllllllllllIllIIIlIIlllIlIlIlIlI);
        if (lllllllllllIllIIIlIIlllIlIlIIIIl > 0.0f) {
            final float lllllllllllIllIIIlIIlllIlIlIIIII = (lllllllllllIllIIIlIIlllIlIlIIlll * 0.3f + lllllllllllIllIIIlIIlllIlIlIIllI * 0.59f + lllllllllllIllIIIlIIlllIlIlIIlIl * 0.11f) * 0.2f;
            final float lllllllllllIllIIIlIIlllIlIIlllll = 1.0f - lllllllllllIllIIIlIIlllIlIlIIIIl * 0.95f;
            lllllllllllIllIIIlIIlllIlIlIIlll = lllllllllllIllIIIlIIlllIlIlIIlll * lllllllllllIllIIIlIIlllIlIIlllll + lllllllllllIllIIIlIIlllIlIlIIIII * (1.0f - lllllllllllIllIIIlIIlllIlIIlllll);
            lllllllllllIllIIIlIIlllIlIlIIllI = lllllllllllIllIIIlIIlllIlIlIIllI * lllllllllllIllIIIlIIlllIlIIlllll + lllllllllllIllIIIlIIlllIlIlIIIII * (1.0f - lllllllllllIllIIIlIIlllIlIIlllll);
            lllllllllllIllIIIlIIlllIlIlIIlIl = lllllllllllIllIIIlIIlllIlIlIIlIl * lllllllllllIllIIIlIIlllIlIIlllll + lllllllllllIllIIIlIIlllIlIlIIIII * (1.0f - lllllllllllIllIIIlIIlllIlIIlllll);
        }
        return new Vec3d(lllllllllllIllIIIlIIlllIlIlIIlll, lllllllllllIllIIIlIIlllIlIlIIllI, lllllllllllIllIIIlIIlllIlIlIIlIl);
    }
    
    @Nullable
    public EntityPlayer getNearestAttackablePlayer(final double lllllllllllIllIIIlIIlIIllIIIIlIl, final double lllllllllllIllIIIlIIlIIllIIIIlII, final double lllllllllllIllIIIlIIlIIllIIIIIll, final double lllllllllllIllIIIlIIlIIllIIIIIlI, final double lllllllllllIllIIIlIIlIIlIlllIIlI, @Nullable final Function<EntityPlayer, Double> lllllllllllIllIIIlIIlIIllIIIIIII, @Nullable final Predicate<EntityPlayer> lllllllllllIllIIIlIIlIIlIlllIIII) {
        double lllllllllllIllIIIlIIlIIlIllllllI = -1.0;
        EntityPlayer lllllllllllIllIIIlIIlIIlIlllllIl = null;
        for (int lllllllllllIllIIIlIIlIIlIlllllII = 0; lllllllllllIllIIIlIIlIIlIlllllII < this.playerEntities.size(); ++lllllllllllIllIIIlIIlIIlIlllllII) {
            final EntityPlayer lllllllllllIllIIIlIIlIIlIllllIll = this.playerEntities.get(lllllllllllIllIIIlIIlIIlIlllllII);
            if (!lllllllllllIllIIIlIIlIIlIllllIll.capabilities.disableDamage && lllllllllllIllIIIlIIlIIlIllllIll.isEntityAlive() && !lllllllllllIllIIIlIIlIIlIllllIll.isSpectator() && (lllllllllllIllIIIlIIlIIlIlllIIII == null || lllllllllllIllIIIlIIlIIlIlllIIII.apply((Object)lllllllllllIllIIIlIIlIIlIllllIll))) {
                final double lllllllllllIllIIIlIIlIIlIllllIlI = lllllllllllIllIIIlIIlIIlIllllIll.getDistanceSq(lllllllllllIllIIIlIIlIIllIIIIlIl, lllllllllllIllIIIlIIlIIlIllllIll.posY, lllllllllllIllIIIlIIlIIllIIIIIll);
                double lllllllllllIllIIIlIIlIIlIllllIIl = lllllllllllIllIIIlIIlIIllIIIIIlI;
                if (lllllllllllIllIIIlIIlIIlIllllIll.isSneaking()) {
                    lllllllllllIllIIIlIIlIIlIllllIIl = lllllllllllIllIIIlIIlIIllIIIIIlI * 0.800000011920929;
                }
                if (lllllllllllIllIIIlIIlIIlIllllIll.isInvisible()) {
                    float lllllllllllIllIIIlIIlIIlIllllIII = lllllllllllIllIIIlIIlIIlIllllIll.getArmorVisibility();
                    if (lllllllllllIllIIIlIIlIIlIllllIII < 0.1f) {
                        lllllllllllIllIIIlIIlIIlIllllIII = 0.1f;
                    }
                    lllllllllllIllIIIlIIlIIlIllllIIl *= 0.7f * lllllllllllIllIIIlIIlIIlIllllIII;
                }
                if (lllllllllllIllIIIlIIlIIllIIIIIII != null) {
                    lllllllllllIllIIIlIIlIIlIllllIIl *= (double)MoreObjects.firstNonNull((Object)lllllllllllIllIIIlIIlIIllIIIIIII.apply((Object)lllllllllllIllIIIlIIlIIlIllllIll), (Object)1.0);
                }
                if ((lllllllllllIllIIIlIIlIIlIlllIIlI < 0.0 || Math.abs(lllllllllllIllIIIlIIlIIlIllllIll.posY - lllllllllllIllIIIlIIlIIllIIIIlII) < lllllllllllIllIIIlIIlIIlIlllIIlI * lllllllllllIllIIIlIIlIIlIlllIIlI) && (lllllllllllIllIIIlIIlIIllIIIIIlI < 0.0 || lllllllllllIllIIIlIIlIIlIllllIlI < lllllllllllIllIIIlIIlIIlIllllIIl * lllllllllllIllIIIlIIlIIlIllllIIl) && (lllllllllllIllIIIlIIlIIlIllllllI == -1.0 || lllllllllllIllIIIlIIlIIlIllllIlI < lllllllllllIllIIIlIIlIIlIllllllI)) {
                    lllllllllllIllIIIlIIlIIlIllllllI = lllllllllllIllIIIlIIlIIlIllllIlI;
                    lllllllllllIllIIIlIIlIIlIlllllIl = lllllllllllIllIIIlIIlIIlIllllIll;
                }
            }
        }
        return lllllllllllIllIIIlIIlIIlIlllllIl;
    }
    
    public IBlockState getGroundAboveSeaLevel(final BlockPos lllllllllllIllIIIlIlIIllIlIIIIIl) {
        BlockPos lllllllllllIllIIIlIlIIllIlIIIIII;
        for (lllllllllllIllIIIlIlIIllIlIIIIII = new BlockPos(lllllllllllIllIIIlIlIIllIlIIIIIl.getX(), this.getSeaLevel(), lllllllllllIllIIIlIlIIllIlIIIIIl.getZ()); !this.isAirBlock(lllllllllllIllIIIlIlIIllIlIIIIII.up()); lllllllllllIllIIIlIlIIllIlIIIIII = lllllllllllIllIIIlIlIIllIlIIIIII.up()) {}
        return this.getBlockState(lllllllllllIllIIIlIlIIllIlIIIIII);
    }
    
    public EnumDifficulty getDifficulty() {
        return this.getWorldInfo().getDifficulty();
    }
    
    public void checkSessionLock() throws MinecraftException {
        this.saveHandler.checkSessionLock();
    }
    
    public void updateEntities() {
        this.theProfiler.startSection("entities");
        this.theProfiler.startSection("global");
        for (int lllllllllllIllIIIlIIlllIIlIIllIl = 0; lllllllllllIllIIIlIIlllIIlIIllIl < this.weatherEffects.size(); ++lllllllllllIllIIIlIIlllIIlIIllIl) {
            final Entity lllllllllllIllIIIlIIlllIIlIIllII = this.weatherEffects.get(lllllllllllIllIIIlIIlllIIlIIllIl);
            try {
                final Entity entity = lllllllllllIllIIIlIIlllIIlIIllII;
                ++entity.ticksExisted;
                lllllllllllIllIIIlIIlllIIlIIllII.onUpdate();
            }
            catch (Throwable lllllllllllIllIIIlIIlllIIlIIlIll) {
                final CrashReport lllllllllllIllIIIlIIlllIIlIIlIlI = CrashReport.makeCrashReport(lllllllllllIllIIIlIIlllIIlIIlIll, "Ticking entity");
                final CrashReportCategory lllllllllllIllIIIlIIlllIIlIIlIIl = lllllllllllIllIIIlIIlllIIlIIlIlI.makeCategory("Entity being ticked");
                if (lllllllllllIllIIIlIIlllIIlIIllII == null) {
                    lllllllllllIllIIIlIIlllIIlIIlIIl.addCrashSection("Entity", "~~NULL~~");
                }
                else {
                    lllllllllllIllIIIlIIlllIIlIIllII.addEntityCrashInfo(lllllllllllIllIIIlIIlllIIlIIlIIl);
                }
                throw new ReportedException(lllllllllllIllIIIlIIlllIIlIIlIlI);
            }
            if (lllllllllllIllIIIlIIlllIIlIIllII.isDead) {
                this.weatherEffects.remove(lllllllllllIllIIIlIIlllIIlIIllIl--);
            }
        }
        this.theProfiler.endStartSection("remove");
        this.loadedEntityList.removeAll(this.unloadedEntityList);
        for (int lllllllllllIllIIIlIIlllIIlIIlIII = 0; lllllllllllIllIIIlIIlllIIlIIlIII < this.unloadedEntityList.size(); ++lllllllllllIllIIIlIIlllIIlIIlIII) {
            final Entity lllllllllllIllIIIlIIlllIIlIIIlll = this.unloadedEntityList.get(lllllllllllIllIIIlIIlllIIlIIlIII);
            final int lllllllllllIllIIIlIIlllIIlIIIllI = lllllllllllIllIIIlIIlllIIlIIIlll.chunkCoordX;
            final int lllllllllllIllIIIlIIlllIIlIIIlIl = lllllllllllIllIIIlIIlllIIlIIIlll.chunkCoordZ;
            if (lllllllllllIllIIIlIIlllIIlIIIlll.addedToChunk && this.isChunkLoaded(lllllllllllIllIIIlIIlllIIlIIIllI, lllllllllllIllIIIlIIlllIIlIIIlIl, true)) {
                this.getChunkFromChunkCoords(lllllllllllIllIIIlIIlllIIlIIIllI, lllllllllllIllIIIlIIlllIIlIIIlIl).removeEntity(lllllllllllIllIIIlIIlllIIlIIIlll);
            }
        }
        for (int lllllllllllIllIIIlIIlllIIlIIIlII = 0; lllllllllllIllIIIlIIlllIIlIIIlII < this.unloadedEntityList.size(); ++lllllllllllIllIIIlIIlllIIlIIIlII) {
            this.onEntityRemoved(this.unloadedEntityList.get(lllllllllllIllIIIlIIlllIIlIIIlII));
        }
        this.unloadedEntityList.clear();
        this.tickPlayers();
        this.theProfiler.endStartSection("regular");
        for (int lllllllllllIllIIIlIIlllIIlIIIIll = 0; lllllllllllIllIIIlIIlllIIlIIIIll < this.loadedEntityList.size(); ++lllllllllllIllIIIlIIlllIIlIIIIll) {
            final Entity lllllllllllIllIIIlIIlllIIlIIIIlI = this.loadedEntityList.get(lllllllllllIllIIIlIIlllIIlIIIIll);
            final Entity lllllllllllIllIIIlIIlllIIlIIIIIl = lllllllllllIllIIIlIIlllIIlIIIIlI.getRidingEntity();
            if (lllllllllllIllIIIlIIlllIIlIIIIIl != null) {
                if (!lllllllllllIllIIIlIIlllIIlIIIIIl.isDead && lllllllllllIllIIIlIIlllIIlIIIIIl.isPassenger(lllllllllllIllIIIlIIlllIIlIIIIlI)) {
                    continue;
                }
                lllllllllllIllIIIlIIlllIIlIIIIlI.dismountRidingEntity();
            }
            this.theProfiler.startSection("tick");
            if (!lllllllllllIllIIIlIIlllIIlIIIIlI.isDead && !(lllllllllllIllIIIlIIlllIIlIIIIlI instanceof EntityPlayerMP)) {
                try {
                    this.updateEntity(lllllllllllIllIIIlIIlllIIlIIIIlI);
                }
                catch (Throwable lllllllllllIllIIIlIIlllIIlIIIIII) {
                    final CrashReport lllllllllllIllIIIlIIlllIIIllllll = CrashReport.makeCrashReport(lllllllllllIllIIIlIIlllIIlIIIIII, "Ticking entity");
                    final CrashReportCategory lllllllllllIllIIIlIIlllIIIlllllI = lllllllllllIllIIIlIIlllIIIllllll.makeCategory("Entity being ticked");
                    lllllllllllIllIIIlIIlllIIlIIIIlI.addEntityCrashInfo(lllllllllllIllIIIlIIlllIIIlllllI);
                    throw new ReportedException(lllllllllllIllIIIlIIlllIIIllllll);
                }
            }
            this.theProfiler.endSection();
            this.theProfiler.startSection("remove");
            if (lllllllllllIllIIIlIIlllIIlIIIIlI.isDead) {
                final int lllllllllllIllIIIlIIlllIIIllllIl = lllllllllllIllIIIlIIlllIIlIIIIlI.chunkCoordX;
                final int lllllllllllIllIIIlIIlllIIIllllII = lllllllllllIllIIIlIIlllIIlIIIIlI.chunkCoordZ;
                if (lllllllllllIllIIIlIIlllIIlIIIIlI.addedToChunk && this.isChunkLoaded(lllllllllllIllIIIlIIlllIIIllllIl, lllllllllllIllIIIlIIlllIIIllllII, true)) {
                    this.getChunkFromChunkCoords(lllllllllllIllIIIlIIlllIIIllllIl, lllllllllllIllIIIlIIlllIIIllllII).removeEntity(lllllllllllIllIIIlIIlllIIlIIIIlI);
                }
                this.loadedEntityList.remove(lllllllllllIllIIIlIIlllIIlIIIIll--);
                this.onEntityRemoved(lllllllllllIllIIIlIIlllIIlIIIIlI);
            }
            this.theProfiler.endSection();
        }
        this.theProfiler.endStartSection("blockEntities");
        if (!this.tileEntitiesToBeRemoved.isEmpty()) {
            this.tickableTileEntities.removeAll(this.tileEntitiesToBeRemoved);
            this.loadedTileEntityList.removeAll(this.tileEntitiesToBeRemoved);
            this.tileEntitiesToBeRemoved.clear();
        }
        this.processingLoadedTiles = true;
        final Iterator<TileEntity> lllllllllllIllIIIlIIlllIIIlllIll = this.tickableTileEntities.iterator();
        while (lllllllllllIllIIIlIIlllIIIlllIll.hasNext()) {
            final TileEntity lllllllllllIllIIIlIIlllIIIlllIlI = lllllllllllIllIIIlIIlllIIIlllIll.next();
            if (!lllllllllllIllIIIlIIlllIIIlllIlI.isInvalid() && lllllllllllIllIIIlIIlllIIIlllIlI.hasWorldObj()) {
                final BlockPos lllllllllllIllIIIlIIlllIIIlllIIl = lllllllllllIllIIIlIIlllIIIlllIlI.getPos();
                if (this.isBlockLoaded(lllllllllllIllIIIlIIlllIIIlllIIl) && this.worldBorder.contains(lllllllllllIllIIIlIIlllIIIlllIIl)) {
                    try {
                        this.theProfiler.func_194340_a(() -> String.valueOf(TileEntity.func_190559_a(lllllllllllIllIIIlIIlllIIIlllIlI.getClass())));
                        ((ITickable)lllllllllllIllIIIlIIlllIIIlllIlI).update();
                        this.theProfiler.endSection();
                    }
                    catch (Throwable lllllllllllIllIIIlIIlllIIIlllIII) {
                        final CrashReport lllllllllllIllIIIlIIlllIIIllIlll = CrashReport.makeCrashReport(lllllllllllIllIIIlIIlllIIIlllIII, "Ticking block entity");
                        final CrashReportCategory lllllllllllIllIIIlIIlllIIIllIllI = lllllllllllIllIIIlIIlllIIIllIlll.makeCategory("Block entity being ticked");
                        lllllllllllIllIIIlIIlllIIIlllIlI.addInfoToCrashReport(lllllllllllIllIIIlIIlllIIIllIllI);
                        throw new ReportedException(lllllllllllIllIIIlIIlllIIIllIlll);
                    }
                }
            }
            if (lllllllllllIllIIIlIIlllIIIlllIlI.isInvalid()) {
                lllllllllllIllIIIlIIlllIIIlllIll.remove();
                this.loadedTileEntityList.remove(lllllllllllIllIIIlIIlllIIIlllIlI);
                if (!this.isBlockLoaded(lllllllllllIllIIIlIIlllIIIlllIlI.getPos())) {
                    continue;
                }
                this.getChunkFromBlockCoords(lllllllllllIllIIIlIIlllIIIlllIlI.getPos()).removeTileEntity(lllllllllllIllIIIlIIlllIIIlllIlI.getPos());
            }
        }
        this.processingLoadedTiles = false;
        this.theProfiler.endStartSection("pendingBlockEntities");
        if (!this.addedTileEntityList.isEmpty()) {
            for (int lllllllllllIllIIIlIIlllIIIllIlIl = 0; lllllllllllIllIIIlIIlllIIIllIlIl < this.addedTileEntityList.size(); ++lllllllllllIllIIIlIIlllIIIllIlIl) {
                final TileEntity lllllllllllIllIIIlIIlllIIIllIlII = this.addedTileEntityList.get(lllllllllllIllIIIlIIlllIIIllIlIl);
                if (!lllllllllllIllIIIlIIlllIIIllIlII.isInvalid()) {
                    if (!this.loadedTileEntityList.contains(lllllllllllIllIIIlIIlllIIIllIlII)) {
                        this.addTileEntity(lllllllllllIllIIIlIIlllIIIllIlII);
                    }
                    if (this.isBlockLoaded(lllllllllllIllIIIlIIlllIIIllIlII.getPos())) {
                        final Chunk lllllllllllIllIIIlIIlllIIIllIIll = this.getChunkFromBlockCoords(lllllllllllIllIIIlIIlllIIIllIlII.getPos());
                        final IBlockState lllllllllllIllIIIlIIlllIIIllIIlI = lllllllllllIllIIIlIIlllIIIllIIll.getBlockState(lllllllllllIllIIIlIIlllIIIllIlII.getPos());
                        lllllllllllIllIIIlIIlllIIIllIIll.addTileEntity(lllllllllllIllIIIlIIlllIIIllIlII.getPos(), lllllllllllIllIIIlIIlllIIIllIlII);
                        this.notifyBlockUpdate(lllllllllllIllIIIlIIlllIIIllIlII.getPos(), lllllllllllIllIIIlIIlllIIIllIIlI, lllllllllllIllIIIlIIlllIIIllIIlI, 3);
                    }
                }
            }
            this.addedTileEntityList.clear();
        }
        this.theProfiler.endSection();
        this.theProfiler.endSection();
    }
    
    public boolean canBlockFreezeNoWater(final BlockPos lllllllllllIllIIIlIIllIIIIIIIlII) {
        return this.canBlockFreeze(lllllllllllIllIIIlIIllIIIIIIIlII, true);
    }
    
    public boolean tickUpdates(final boolean lllllllllllIllIIIlIIlIllIIllllIl) {
        return false;
    }
    
    @Nullable
    private TileEntity getPendingTileEntityAt(final BlockPos lllllllllllIllIIIlIIllIIlIIIIIIl) {
        for (int lllllllllllIllIIIlIIllIIlIIIIIII = 0; lllllllllllIllIIIlIIllIIlIIIIIII < this.addedTileEntityList.size(); ++lllllllllllIllIIIlIIllIIlIIIIIII) {
            final TileEntity lllllllllllIllIIIlIIllIIIlllllll = this.addedTileEntityList.get(lllllllllllIllIIIlIIllIIlIIIIIII);
            if (!lllllllllllIllIIIlIIllIIIlllllll.isInvalid() && lllllllllllIllIIIlIIllIIIlllllll.getPos().equals(lllllllllllIllIIIlIIllIIlIIIIIIl)) {
                return lllllllllllIllIIIlIIllIIIlllllll;
            }
        }
        return null;
    }
    
    public void markBlocksDirtyVertical(final int lllllllllllIllIIIlIlIIlIIlIlIllI, final int lllllllllllIllIIIlIlIIlIIlIIlllI, int lllllllllllIllIIIlIlIIlIIlIIllIl, int lllllllllllIllIIIlIlIIlIIlIIllII) {
        if (lllllllllllIllIIIlIlIIlIIlIIllIl > lllllllllllIllIIIlIlIIlIIlIIllII) {
            final int lllllllllllIllIIIlIlIIlIIlIlIIlI = lllllllllllIllIIIlIlIIlIIlIIllII;
            lllllllllllIllIIIlIlIIlIIlIIllII = (int)lllllllllllIllIIIlIlIIlIIlIIllIl;
            lllllllllllIllIIIlIlIIlIIlIIllIl = lllllllllllIllIIIlIlIIlIIlIlIIlI;
        }
        if (this.provider.func_191066_m()) {
            for (int lllllllllllIllIIIlIlIIlIIlIlIIIl = (int)lllllllllllIllIIIlIlIIlIIlIIllIl; lllllllllllIllIIIlIlIIlIIlIlIIIl <= lllllllllllIllIIIlIlIIlIIlIIllII; ++lllllllllllIllIIIlIlIIlIIlIlIIIl) {
                this.checkLightFor(EnumSkyBlock.SKY, new BlockPos(lllllllllllIllIIIlIlIIlIIlIlIllI, lllllllllllIllIIIlIlIIlIIlIlIIIl, lllllllllllIllIIIlIlIIlIIlIIlllI));
            }
        }
        this.markBlockRangeForRenderUpdate(lllllllllllIllIIIlIlIIlIIlIlIllI, (int)lllllllllllIllIIIlIlIIlIIlIIllIl, lllllllllllIllIIIlIlIIlIIlIIlllI, lllllllllllIllIIIlIlIIlIIlIlIllI, lllllllllllIllIIIlIlIIlIIlIIllII, lllllllllllIllIIIlIlIIlIIlIIlllI);
    }
    
    private boolean isWater(final BlockPos lllllllllllIllIIIlIIlIlllllIIllI) {
        return this.getBlockState(lllllllllllIllIIIlIIlIlllllIIllI).getMaterial() == Material.WATER;
    }
    
    public boolean isBlockLoaded(final BlockPos lllllllllllIllIIIlIlIIllIIlIIlll) {
        return this.isBlockLoaded(lllllllllllIllIIIlIlIIllIIlIIlll, true);
    }
    
    public boolean collidesWithAnyBlock(final AxisAlignedBB lllllllllllIllIIIlIIllllIIlIIIII) {
        return this.func_191504_a(null, lllllllllllIllIIIlIIllllIIlIIIII, true, Lists.newArrayList());
    }
    
    public float getSunBrightness(final float lllllllllllIllIIIlIIllllIIIIlllI) {
        final float lllllllllllIllIIIlIIllllIIIIllIl = this.getCelestialAngle(lllllllllllIllIIIlIIllllIIIIlllI);
        float lllllllllllIllIIIlIIllllIIIIllII = 1.0f - (MathHelper.cos(lllllllllllIllIIIlIIllllIIIIllIl * 6.2831855f) * 2.0f + 0.2f);
        lllllllllllIllIIIlIIllllIIIIllII = MathHelper.clamp(lllllllllllIllIIIlIIllllIIIIllII, 0.0f, 1.0f);
        lllllllllllIllIIIlIIllllIIIIllII = 1.0f - lllllllllllIllIIIlIIllllIIIIllII;
        lllllllllllIllIIIlIIllllIIIIllII *= (float)(1.0 - this.getRainStrength(lllllllllllIllIIIlIIllllIIIIlllI) * 5.0f / 16.0);
        lllllllllllIllIIIlIIllllIIIIllII *= (float)(1.0 - this.getThunderStrength(lllllllllllIllIIIlIIllllIIIIlllI) * 5.0f / 16.0);
        return lllllllllllIllIIIlIIllllIIIIllII * 0.8f + 0.2f;
    }
    
    public boolean spawnEntityInWorld(final Entity lllllllllllIllIIIlIIllllllIIllll) {
        final int lllllllllllIllIIIlIIllllllIlIlII = MathHelper.floor(lllllllllllIllIIIlIIllllllIIllll.posX / 16.0);
        final int lllllllllllIllIIIlIIllllllIlIIll = MathHelper.floor(lllllllllllIllIIIlIIllllllIIllll.posZ / 16.0);
        boolean lllllllllllIllIIIlIIllllllIlIIlI = lllllllllllIllIIIlIIllllllIIllll.forceSpawn;
        if (lllllllllllIllIIIlIIllllllIIllll instanceof EntityPlayer) {
            lllllllllllIllIIIlIIllllllIlIIlI = true;
        }
        if (!lllllllllllIllIIIlIIllllllIlIIlI && !this.isChunkLoaded(lllllllllllIllIIIlIIllllllIlIlII, lllllllllllIllIIIlIIllllllIlIIll, false)) {
            return false;
        }
        if (lllllllllllIllIIIlIIllllllIIllll instanceof EntityPlayer) {
            final EntityPlayer lllllllllllIllIIIlIIllllllIlIIIl = (EntityPlayer)lllllllllllIllIIIlIIllllllIIllll;
            this.playerEntities.add(lllllllllllIllIIIlIIllllllIlIIIl);
            this.updateAllPlayersSleepingFlag();
        }
        this.getChunkFromChunkCoords(lllllllllllIllIIIlIIllllllIlIlII, lllllllllllIllIIIlIIllllllIlIIll).addEntity(lllllllllllIllIIIlIIllllllIIllll);
        this.loadedEntityList.add(lllllllllllIllIIIlIIllllllIIllll);
        this.onEntityAdded(lllllllllllIllIIIlIIllllllIIllll);
        return true;
    }
    
    protected void updateWeather() {
        if (this.provider.func_191066_m() && !this.isRemote) {
            final boolean lllllllllllIllIIIlIIllIIIIlIlIIl = this.getGameRules().getBoolean("doWeatherCycle");
            if (lllllllllllIllIIIlIIllIIIIlIlIIl) {
                int lllllllllllIllIIIlIIllIIIIlIlIII = this.worldInfo.getCleanWeatherTime();
                if (lllllllllllIllIIIlIIllIIIIlIlIII > 0) {
                    --lllllllllllIllIIIlIIllIIIIlIlIII;
                    this.worldInfo.setCleanWeatherTime(lllllllllllIllIIIlIIllIIIIlIlIII);
                    this.worldInfo.setThunderTime(this.worldInfo.isThundering() ? 1 : 2);
                    this.worldInfo.setRainTime(this.worldInfo.isRaining() ? 1 : 2);
                }
                int lllllllllllIllIIIlIIllIIIIlIIlll = this.worldInfo.getThunderTime();
                if (lllllllllllIllIIIlIIllIIIIlIIlll <= 0) {
                    if (this.worldInfo.isThundering()) {
                        this.worldInfo.setThunderTime(this.rand.nextInt(12000) + 3600);
                    }
                    else {
                        this.worldInfo.setThunderTime(this.rand.nextInt(168000) + 12000);
                    }
                }
                else {
                    --lllllllllllIllIIIlIIllIIIIlIIlll;
                    this.worldInfo.setThunderTime(lllllllllllIllIIIlIIllIIIIlIIlll);
                    if (lllllllllllIllIIIlIIllIIIIlIIlll <= 0) {
                        this.worldInfo.setThundering(!this.worldInfo.isThundering());
                    }
                }
                int lllllllllllIllIIIlIIllIIIIlIIllI = this.worldInfo.getRainTime();
                if (lllllllllllIllIIIlIIllIIIIlIIllI <= 0) {
                    if (this.worldInfo.isRaining()) {
                        this.worldInfo.setRainTime(this.rand.nextInt(12000) + 12000);
                    }
                    else {
                        this.worldInfo.setRainTime(this.rand.nextInt(168000) + 12000);
                    }
                }
                else {
                    --lllllllllllIllIIIlIIllIIIIlIIllI;
                    this.worldInfo.setRainTime(lllllllllllIllIIIlIIllIIIIlIIllI);
                    if (lllllllllllIllIIIlIIllIIIIlIIllI <= 0) {
                        this.worldInfo.setRaining(!this.worldInfo.isRaining());
                    }
                }
            }
            this.prevThunderingStrength = this.thunderingStrength;
            if (this.worldInfo.isThundering()) {
                this.thunderingStrength += (float)0.01;
            }
            else {
                this.thunderingStrength -= (float)0.01;
            }
            this.thunderingStrength = MathHelper.clamp(this.thunderingStrength, 0.0f, 1.0f);
            this.prevRainingStrength = this.rainingStrength;
            if (this.worldInfo.isRaining()) {
                this.rainingStrength += (float)0.01;
            }
            else {
                this.rainingStrength -= (float)0.01;
            }
            this.rainingStrength = MathHelper.clamp(this.rainingStrength, 0.0f, 1.0f);
        }
    }
    
    public void playSound(final double lllllllllllIllIIIlIlIIIIIllIlllI, final double lllllllllllIllIIIlIlIIIIIllIllIl, final double lllllllllllIllIIIlIlIIIIIllIllII, final SoundEvent lllllllllllIllIIIlIlIIIIIllIlIll, final SoundCategory lllllllllllIllIIIlIlIIIIIllIlIlI, final float lllllllllllIllIIIlIlIIIIIllIlIIl, final float lllllllllllIllIIIlIlIIIIIllIlIII, final boolean lllllllllllIllIIIlIlIIIIIllIIlll) {
    }
    
    public void spawnParticle(final EnumParticleTypes lllllllllllIllIIIlIlIIIIIIIlIllI, final boolean lllllllllllIllIIIlIlIIIIIIIlIlIl, final double lllllllllllIllIIIlIlIIIIIIIIlIlI, final double lllllllllllIllIIIlIlIIIIIIIlIIll, final double lllllllllllIllIIIlIlIIIIIIIIlIII, final double lllllllllllIllIIIlIlIIIIIIIlIIIl, final double lllllllllllIllIIIlIlIIIIIIIlIIII, final double lllllllllllIllIIIlIlIIIIIIIIIlIl, final int... lllllllllllIllIIIlIlIIIIIIIIIlII) {
        this.spawnParticle(lllllllllllIllIIIlIlIIIIIIIlIllI.getParticleID(), lllllllllllIllIIIlIlIIIIIIIlIllI.getShouldIgnoreRange() || lllllllllllIllIIIlIlIIIIIIIlIlIl, lllllllllllIllIIIlIlIIIIIIIIlIlI, lllllllllllIllIIIlIlIIIIIIIlIIll, lllllllllllIllIIIlIlIIIIIIIIlIII, lllllllllllIllIIIlIlIIIIIIIlIIIl, lllllllllllIllIIIlIlIIIIIIIlIIII, lllllllllllIllIIIlIlIIIIIIIIIlIl, lllllllllllIllIIIlIlIIIIIIIIIlII);
    }
    
    public float getStarBrightness(final float lllllllllllIllIIIlIIlllIIllIllIl) {
        final float lllllllllllIllIIIlIIlllIIllIllII = this.getCelestialAngle(lllllllllllIllIIIlIIlllIIllIllIl);
        float lllllllllllIllIIIlIIlllIIllIlIll = 1.0f - (MathHelper.cos(lllllllllllIllIIIlIIlllIIllIllII * 6.2831855f) * 2.0f + 0.25f);
        lllllllllllIllIIIlIIlllIIllIlIll = MathHelper.clamp(lllllllllllIllIIIlIIlllIIllIlIll, 0.0f, 1.0f);
        return lllllllllllIllIIIlIIlllIIllIlIll * lllllllllllIllIIIlIIlllIIllIlIll * 0.5f;
    }
    
    public void func_190524_a(final BlockPos lllllllllllIllIIIlIlIIIlllllllll, final Block lllllllllllIllIIIlIlIIIllllllllI, final BlockPos lllllllllllIllIIIlIlIIIlllllllIl) {
        if (!this.isRemote) {
            final IBlockState lllllllllllIllIIIlIlIIIlllllllII = this.getBlockState(lllllllllllIllIIIlIlIIIlllllllll);
            try {
                lllllllllllIllIIIlIlIIIlllllllII.neighborChanged(this, lllllllllllIllIIIlIlIIIlllllllll, lllllllllllIllIIIlIlIIIllllllllI, lllllllllllIllIIIlIlIIIlllllllIl);
            }
            catch (Throwable lllllllllllIllIIIlIlIIIllllllIll) {
                final CrashReport lllllllllllIllIIIlIlIIIllllllIlI = CrashReport.makeCrashReport(lllllllllllIllIIIlIlIIIllllllIll, "Exception while updating neighbours");
                final CrashReportCategory lllllllllllIllIIIlIlIIIllllllIIl = lllllllllllIllIIIlIlIIIllllllIlI.makeCategory("Block being updated");
                lllllllllllIllIIIlIlIIIllllllIIl.setDetail("Source block type", new ICrashReportDetail<String>() {
                    @Override
                    public String call() throws Exception {
                        try {
                            return String.format("ID #%d (%s // %s)", Block.getIdFromBlock(lllllllllllIllIIIlIlIIIllllllllI), lllllllllllIllIIIlIlIIIllllllllI.getUnlocalizedName(), lllllllllllIllIIIlIlIIIllllllllI.getClass().getCanonicalName());
                        }
                        catch (Throwable llllllllllllIlIIIlllIIIlIlIlIIIl) {
                            return "ID #" + Block.getIdFromBlock(lllllllllllIllIIIlIlIIIllllllllI);
                        }
                    }
                });
                CrashReportCategory.addBlockInfo(lllllllllllIllIIIlIlIIIllllllIIl, lllllllllllIllIIIlIlIIIlllllllll, lllllllllllIllIIIlIlIIIlllllllII);
                throw new ReportedException(lllllllllllIllIIIlIlIIIllllllIlI);
            }
        }
    }
    
    @Nullable
    public EntityPlayer getNearestPlayerNotCreative(final Entity lllllllllllIllIIIlIIlIlIIIIIIIII, final double lllllllllllIllIIIlIIlIIlllllllII) {
        return this.getClosestPlayer(lllllllllllIllIIIlIIlIlIIIIIIIII.posX, lllllllllllIllIIIlIIlIlIIIIIIIII.posY, lllllllllllIllIIIlIIlIlIIIIIIIII.posZ, lllllllllllIllIIIlIIlIIlllllllII, true);
    }
    
    @Nullable
    public RayTraceResult rayTraceBlocks(final Vec3d lllllllllllIllIIIlIlIIIlIIIlIllI, final Vec3d lllllllllllIllIIIlIlIIIlIIIlIlIl) {
        return this.rayTraceBlocks(lllllllllllIllIIIlIlIIIlIIIlIllI, lllllllllllIllIIIlIlIIIlIIIlIlIl, false, false, false);
    }
    
    @Nullable
    public EntityPlayer getClosestPlayer(final double lllllllllllIllIIIlIIlIIllllIllII, final double lllllllllllIllIIIlIIlIIlllllIIlI, final double lllllllllllIllIIIlIIlIIllllIlIlI, final double lllllllllllIllIIIlIIlIIlllllIIII, final boolean lllllllllllIllIIIlIIlIIllllIllll) {
        final Predicate<Entity> lllllllllllIllIIIlIIlIIllllIlllI = lllllllllllIllIIIlIIlIIllllIllll ? EntitySelectors.CAN_AI_TARGET : EntitySelectors.NOT_SPECTATING;
        return this.func_190525_a(lllllllllllIllIIIlIIlIIllllIllII, lllllllllllIllIIIlIIlIIlllllIIlI, lllllllllllIllIIIlIIlIIllllIlIlI, lllllllllllIllIIIlIIlIIlllllIIII, lllllllllllIllIIIlIIlIIllllIlllI);
    }
    
    public Scoreboard getScoreboard() {
        return this.worldScoreboard;
    }
    
    public boolean addWeatherEffect(final Entity lllllllllllIllIIIlIIllllllIlllll) {
        this.weatherEffects.add(lllllllllllIllIIIlIIllllllIlllll);
        return true;
    }
    
    @Nullable
    public Entity getEntityByID(final int lllllllllllIllIIIlIIlIlIlIIlllIl) {
        return this.entitiesById.lookup(lllllllllllIllIIIlIIlIlIlIIlllIl);
    }
    
    public void playSound(@Nullable final EntityPlayer lllllllllllIllIIIlIlIIIIlIIIIIlI, final double lllllllllllIllIIIlIlIIIIlIIIIIIl, final double lllllllllllIllIIIlIlIIIIlIIIIIII, final double lllllllllllIllIIIlIlIIIIIlllllll, final SoundEvent lllllllllllIllIIIlIlIIIIIllllllI, final SoundCategory lllllllllllIllIIIlIlIIIIIlllIIll, final float lllllllllllIllIIIlIlIIIIIlllllII, final float lllllllllllIllIIIlIlIIIIIlllIIIl) {
        for (int lllllllllllIllIIIlIlIIIIIllllIlI = 0; lllllllllllIllIIIlIlIIIIIllllIlI < this.eventListeners.size(); ++lllllllllllIllIIIlIlIIIIIllllIlI) {
            this.eventListeners.get(lllllllllllIllIIIlIlIIIIIllllIlI).playSoundToAllNearExcept(lllllllllllIllIIIlIlIIIIlIIIIIlI, lllllllllllIllIIIlIlIIIIIllllllI, lllllllllllIllIIIlIlIIIIIlllIIll, lllllllllllIllIIIlIlIIIIlIIIIIIl, lllllllllllIllIIIlIlIIIIlIIIIIII, lllllllllllIllIIIlIlIIIIIlllllll, lllllllllllIllIIIlIlIIIIIlllllII, lllllllllllIllIIIlIlIIIIIlllIIIl);
        }
    }
    
    public boolean isBlockFullCube(final BlockPos lllllllllllIllIIIlIIllIIIlIlIlIl) {
        final AxisAlignedBB lllllllllllIllIIIlIIllIIIlIlIlll = this.getBlockState(lllllllllllIllIIIlIIllIIIlIlIlIl).getCollisionBoundingBox(this, lllllllllllIllIIIlIIllIIIlIlIlIl);
        return lllllllllllIllIIIlIIllIIIlIlIlll != Block.NULL_AABB && lllllllllllIllIIIlIIllIIIlIlIlll.getAverageEdgeLength() >= 1.0;
    }
    
    public int calculateSkylightSubtracted(final float lllllllllllIllIIIlIIllllIIIlIllI) {
        final float lllllllllllIllIIIlIIllllIIIllIIl = this.getCelestialAngle(lllllllllllIllIIIlIIllllIIIlIllI);
        float lllllllllllIllIIIlIIllllIIIllIII = 1.0f - (MathHelper.cos(lllllllllllIllIIIlIIllllIIIllIIl * 6.2831855f) * 2.0f + 0.5f);
        lllllllllllIllIIIlIIllllIIIllIII = MathHelper.clamp(lllllllllllIllIIIlIIllllIIIllIII, 0.0f, 1.0f);
        lllllllllllIllIIIlIIllllIIIllIII = 1.0f - lllllllllllIllIIIlIIllllIIIllIII;
        lllllllllllIllIIIlIIllllIIIllIII *= (float)(1.0 - this.getRainStrength(lllllllllllIllIIIlIIllllIIIlIllI) * 5.0f / 16.0);
        lllllllllllIllIIIlIIllllIIIllIII *= (float)(1.0 - this.getThunderStrength(lllllllllllIllIIIlIIllllIIIlIllI) * 5.0f / 16.0);
        lllllllllllIllIIIlIIllllIIIllIII = 1.0f - lllllllllllIllIIIlIIllllIIIllIII;
        return (int)(lllllllllllIllIIIlIIllllIIIllIII * 11.0f);
    }
    
    public <T extends Entity> List<T> getPlayers(final Class<? extends T> lllllllllllIllIIIlIIlIlIllllIlII, final Predicate<? super T> lllllllllllIllIIIlIIlIlIllllIIll) {
        final List<T> lllllllllllIllIIIlIIlIlIllllIIlI = (List<T>)Lists.newArrayList();
        for (final Entity lllllllllllIllIIIlIIlIlIllllIIIl : this.playerEntities) {
            if (lllllllllllIllIIIlIIlIlIllllIlII.isAssignableFrom(lllllllllllIllIIIlIIlIlIllllIIIl.getClass()) && lllllllllllIllIIIlIIlIlIllllIIll.apply((Object)lllllllllllIllIIIlIIlIlIllllIIIl)) {
                lllllllllllIllIIIlIIlIlIllllIIlI.add((T)lllllllllllIllIIIlIIlIlIllllIIIl);
            }
        }
        return lllllllllllIllIIIlIIlIlIllllIIlI;
    }
    
    public VillageCollection getVillageCollection() {
        return this.villageCollectionObj;
    }
    
    public Explosion createExplosion(@Nullable final Entity lllllllllllIllIIIlIIllIIlllllIIl, final double lllllllllllIllIIIlIIllIIlllllIII, final double lllllllllllIllIIIlIIllIIllllIIII, final double lllllllllllIllIIIlIIllIIllllIllI, final float lllllllllllIllIIIlIIllIIlllIlllI, final boolean lllllllllllIllIIIlIIllIIlllIllIl) {
        return this.newExplosion(lllllllllllIllIIIlIIllIIlllllIIl, lllllllllllIllIIIlIIllIIlllllIII, lllllllllllIllIIIlIIllIIllllIIII, lllllllllllIllIIIlIIllIIllllIllI, lllllllllllIllIIIlIIllIIlllIlllI, false, lllllllllllIllIIIlIIllIIlllIllIl);
    }
    
    public void addBlockEvent(final BlockPos lllllllllllIllIIIlIIlIIlIIIIlIII, final Block lllllllllllIllIIIlIIlIIlIIIIIlll, final int lllllllllllIllIIIlIIlIIlIIIIIllI, final int lllllllllllIllIIIlIIlIIlIIIIIIIl) {
        this.getBlockState(lllllllllllIllIIIlIIlIIlIIIIlIII).onBlockEventReceived(this, lllllllllllIllIIIlIIlIIlIIIIlIII, lllllllllllIllIIIlIIlIIlIIIIIllI, lllllllllllIllIIIlIIlIIlIIIIIIIl);
    }
    
    protected void onEntityAdded(final Entity lllllllllllIllIIIlIIllllllIIIIll) {
        for (int lllllllllllIllIIIlIIllllllIIIlIl = 0; lllllllllllIllIIIlIIllllllIIIlIl < this.eventListeners.size(); ++lllllllllllIllIIIlIIllllllIIIlIl) {
            this.eventListeners.get(lllllllllllIllIIIlIIllllllIIIlIl).onEntityAdded(lllllllllllIllIIIlIIllllllIIIIll);
        }
    }
    
    public double getHorizon() {
        return (this.worldInfo.getTerrainType() == WorldType.FLAT) ? 0.0 : 63.0;
    }
    
    public int getLight(BlockPos lllllllllllIllIIIlIlIIIllIlllIll) {
        if (((Vec3i)lllllllllllIllIIIlIlIIIllIlllIll).getY() < 0) {
            return 0;
        }
        if (((Vec3i)lllllllllllIllIIIlIlIIIllIlllIll).getY() >= 256) {
            lllllllllllIllIIIlIlIIIllIlllIll = new BlockPos(((Vec3i)lllllllllllIllIIIlIlIIIllIlllIll).getX(), 255, ((Vec3i)lllllllllllIllIIIlIlIIIllIlllIll).getZ());
        }
        return this.getChunkFromBlockCoords((BlockPos)lllllllllllIllIIIlIlIIIllIlllIll).getLightSubtracted((BlockPos)lllllllllllIllIIIlIlIIIllIlllIll, 0);
    }
    
    public void makeFireworks(final double lllllllllllIllIIIlIIlIIIIIllllll, final double lllllllllllIllIIIlIIlIIIIIlllllI, final double lllllllllllIllIIIlIIlIIIIIllllIl, final double lllllllllllIllIIIlIIlIIIIIllllII, final double lllllllllllIllIIIlIIlIIIIIlllIll, final double lllllllllllIllIIIlIIlIIIIIlllIlI, @Nullable final NBTTagCompound lllllllllllIllIIIlIIlIIIIIlllIIl) {
    }
    
    public float getBlockDensity(final Vec3d lllllllllllIllIIIlIIllIIlIllIIII, final AxisAlignedBB lllllllllllIllIIIlIIllIIlIllllll) {
        final double lllllllllllIllIIIlIIllIIlIlllllI = 1.0 / ((lllllllllllIllIIIlIIllIIlIllllll.maxX - lllllllllllIllIIIlIIllIIlIllllll.minX) * 2.0 + 1.0);
        final double lllllllllllIllIIIlIIllIIlIllllIl = 1.0 / ((lllllllllllIllIIIlIIllIIlIllllll.maxY - lllllllllllIllIIIlIIllIIlIllllll.minY) * 2.0 + 1.0);
        final double lllllllllllIllIIIlIIllIIlIllllII = 1.0 / ((lllllllllllIllIIIlIIllIIlIllllll.maxZ - lllllllllllIllIIIlIIllIIlIllllll.minZ) * 2.0 + 1.0);
        final double lllllllllllIllIIIlIIllIIlIlllIll = (1.0 - Math.floor(1.0 / lllllllllllIllIIIlIIllIIlIlllllI) * lllllllllllIllIIIlIIllIIlIlllllI) / 2.0;
        final double lllllllllllIllIIIlIIllIIlIlllIlI = (1.0 - Math.floor(1.0 / lllllllllllIllIIIlIIllIIlIllllII) * lllllllllllIllIIIlIIllIIlIllllII) / 2.0;
        if (lllllllllllIllIIIlIIllIIlIlllllI >= 0.0 && lllllllllllIllIIIlIIllIIlIllllIl >= 0.0 && lllllllllllIllIIIlIIllIIlIllllII >= 0.0) {
            int lllllllllllIllIIIlIIllIIlIlllIIl = 0;
            int lllllllllllIllIIIlIIllIIlIlllIII = 0;
            for (float lllllllllllIllIIIlIIllIIlIllIlll = 0.0f; lllllllllllIllIIIlIIllIIlIllIlll <= 1.0f; lllllllllllIllIIIlIIllIIlIllIlll += (float)lllllllllllIllIIIlIIllIIlIlllllI) {
                for (float lllllllllllIllIIIlIIllIIlIllIllI = 0.0f; lllllllllllIllIIIlIIllIIlIllIllI <= 1.0f; lllllllllllIllIIIlIIllIIlIllIllI += (float)lllllllllllIllIIIlIIllIIlIllllIl) {
                    for (float lllllllllllIllIIIlIIllIIlIllIlIl = 0.0f; lllllllllllIllIIIlIIllIIlIllIlIl <= 1.0f; lllllllllllIllIIIlIIllIIlIllIlIl += (float)lllllllllllIllIIIlIIllIIlIllllII) {
                        final double lllllllllllIllIIIlIIllIIlIllIlII = lllllllllllIllIIIlIIllIIlIllllll.minX + (lllllllllllIllIIIlIIllIIlIllllll.maxX - lllllllllllIllIIIlIIllIIlIllllll.minX) * lllllllllllIllIIIlIIllIIlIllIlll;
                        final double lllllllllllIllIIIlIIllIIlIllIIll = lllllllllllIllIIIlIIllIIlIllllll.minY + (lllllllllllIllIIIlIIllIIlIllllll.maxY - lllllllllllIllIIIlIIllIIlIllllll.minY) * lllllllllllIllIIIlIIllIIlIllIllI;
                        final double lllllllllllIllIIIlIIllIIlIllIIlI = lllllllllllIllIIIlIIllIIlIllllll.minZ + (lllllllllllIllIIIlIIllIIlIllllll.maxZ - lllllllllllIllIIIlIIllIIlIllllll.minZ) * lllllllllllIllIIIlIIllIIlIllIlIl;
                        if (this.rayTraceBlocks(new Vec3d(lllllllllllIllIIIlIIllIIlIllIlII + lllllllllllIllIIIlIIllIIlIlllIll, lllllllllllIllIIIlIIllIIlIllIIll, lllllllllllIllIIIlIIllIIlIllIIlI + lllllllllllIllIIIlIIllIIlIlllIlI), lllllllllllIllIIIlIIllIIlIllIIII) == null) {
                            ++lllllllllllIllIIIlIIllIIlIlllIIl;
                        }
                        ++lllllllllllIllIIIlIIllIIlIlllIII;
                    }
                }
            }
            return lllllllllllIllIIIlIIllIIlIlllIIl / (float)lllllllllllIllIIIlIIllIIlIlllIII;
        }
        return 0.0f;
    }
    
    protected World(final ISaveHandler lllllllllllIllIIIlIlIIllIlllIIII, final WorldInfo lllllllllllIllIIIlIlIIllIllIlIIl, final WorldProvider lllllllllllIllIIIlIlIIllIllIlllI, final Profiler lllllllllllIllIIIlIlIIllIllIllIl, final boolean lllllllllllIllIIIlIlIIllIllIllII) {
        this.seaLevel = 63;
        this.loadedEntityList = (List<Entity>)Lists.newArrayList();
        this.unloadedEntityList = (List<Entity>)Lists.newArrayList();
        this.loadedTileEntityList = (List<TileEntity>)Lists.newArrayList();
        this.tickableTileEntities = (List<TileEntity>)Lists.newArrayList();
        this.addedTileEntityList = (List<TileEntity>)Lists.newArrayList();
        this.tileEntitiesToBeRemoved = (List<TileEntity>)Lists.newArrayList();
        this.playerEntities = (List<EntityPlayer>)Lists.newArrayList();
        this.weatherEffects = (List<Entity>)Lists.newArrayList();
        this.entitiesById = new IntHashMap<Entity>();
        this.updateLCG = new Random().nextInt();
        this.rand = new Random();
        this.pathListener = new PathWorldListener();
        this.eventListeners = (List<IWorldEventListener>)Lists.newArrayList((Object[])new IWorldEventListener[] { this.pathListener });
        this.theCalendar = Calendar.getInstance();
        this.worldScoreboard = new Scoreboard();
        this.spawnHostileMobs = true;
        this.spawnPeacefulMobs = true;
        this.lightUpdateBlockList = new int[32768];
        this.saveHandler = lllllllllllIllIIIlIlIIllIlllIIII;
        this.theProfiler = lllllllllllIllIIIlIlIIllIllIllIl;
        this.worldInfo = lllllllllllIllIIIlIlIIllIllIlIIl;
        this.provider = lllllllllllIllIIIlIlIIllIllIlllI;
        this.isRemote = lllllllllllIllIIIlIlIIllIllIllII;
        this.worldBorder = lllllllllllIllIIIlIlIIllIllIlllI.createWorldBorder();
    }
    
    public boolean checkNoEntityCollision(final AxisAlignedBB lllllllllllIllIIIlIIllIllllIllII) {
        return this.checkNoEntityCollision(lllllllllllIllIIIlIIllIllllIllII, null);
    }
    
    public int getLightFromNeighborsFor(final EnumSkyBlock lllllllllllIllIIIlIlIIIlIlllIIlI, BlockPos lllllllllllIllIIIlIlIIIlIllIlIII) {
        if (!this.provider.func_191066_m() && lllllllllllIllIIIlIlIIIlIlllIIlI == EnumSkyBlock.SKY) {
            return 0;
        }
        if (lllllllllllIllIIIlIlIIIlIllIlIII.getY() < 0) {
            lllllllllllIllIIIlIlIIIlIllIlIII = new BlockPos(lllllllllllIllIIIlIlIIIlIllIlIII.getX(), 0, lllllllllllIllIIIlIlIIIlIllIlIII.getZ());
        }
        if (!this.isValid(lllllllllllIllIIIlIlIIIlIllIlIII)) {
            return lllllllllllIllIIIlIlIIIlIlllIIlI.defaultLightValue;
        }
        if (!this.isBlockLoaded(lllllllllllIllIIIlIlIIIlIllIlIII)) {
            return lllllllllllIllIIIlIlIIIlIlllIIlI.defaultLightValue;
        }
        if (this.getBlockState(lllllllllllIllIIIlIlIIIlIllIlIII).useNeighborBrightness()) {
            int lllllllllllIllIIIlIlIIIlIlllIIII = this.getLightFor(lllllllllllIllIIIlIlIIIlIlllIIlI, lllllllllllIllIIIlIlIIIlIllIlIII.up());
            final int lllllllllllIllIIIlIlIIIlIllIllll = this.getLightFor(lllllllllllIllIIIlIlIIIlIlllIIlI, lllllllllllIllIIIlIlIIIlIllIlIII.east());
            final int lllllllllllIllIIIlIlIIIlIllIlllI = this.getLightFor(lllllllllllIllIIIlIlIIIlIlllIIlI, lllllllllllIllIIIlIlIIIlIllIlIII.west());
            final int lllllllllllIllIIIlIlIIIlIllIllIl = this.getLightFor(lllllllllllIllIIIlIlIIIlIlllIIlI, lllllllllllIllIIIlIlIIIlIllIlIII.south());
            final int lllllllllllIllIIIlIlIIIlIllIllII = this.getLightFor(lllllllllllIllIIIlIlIIIlIlllIIlI, lllllllllllIllIIIlIlIIIlIllIlIII.north());
            if (lllllllllllIllIIIlIlIIIlIllIllll > lllllllllllIllIIIlIlIIIlIlllIIII) {
                lllllllllllIllIIIlIlIIIlIlllIIII = lllllllllllIllIIIlIlIIIlIllIllll;
            }
            if (lllllllllllIllIIIlIlIIIlIllIlllI > lllllllllllIllIIIlIlIIIlIlllIIII) {
                lllllllllllIllIIIlIlIIIlIlllIIII = lllllllllllIllIIIlIlIIIlIllIlllI;
            }
            if (lllllllllllIllIIIlIlIIIlIllIllIl > lllllllllllIllIIIlIlIIIlIlllIIII) {
                lllllllllllIllIIIlIlIIIlIlllIIII = lllllllllllIllIIIlIlIIIlIllIllIl;
            }
            if (lllllllllllIllIIIlIlIIIlIllIllII > lllllllllllIllIIIlIlIIIlIlllIIII) {
                lllllllllllIllIIIlIlIIIlIlllIIII = lllllllllllIllIIIlIlIIIlIllIllII;
            }
            return lllllllllllIllIIIlIlIIIlIlllIIII;
        }
        final Chunk lllllllllllIllIIIlIlIIIlIllIlIll = this.getChunkFromBlockCoords(lllllllllllIllIIIlIlIIIlIllIlIII);
        return lllllllllllIllIIIlIlIIIlIllIlIll.getLightFor(lllllllllllIllIIIlIlIIIlIlllIIlI, lllllllllllIllIIIlIlIIIlIllIlIII);
    }
    
    public boolean isAreaLoaded(final StructureBoundingBox lllllllllllIllIIIlIlIIlIllllIIII) {
        return this.isAreaLoaded(lllllllllllIllIIIlIlIIlIllllIIII, true);
    }
    
    @Nullable
    public List<NextTickListEntry> getPendingBlockUpdates(final Chunk lllllllllllIllIIIlIIlIllIIlllIll, final boolean lllllllllllIllIIIlIIlIllIIlllIlI) {
        return null;
    }
    
    public boolean extinguishFire(@Nullable final EntityPlayer lllllllllllIllIIIlIIllIIlIIlllII, BlockPos lllllllllllIllIIIlIIllIIlIIlIlll, final EnumFacing lllllllllllIllIIIlIIllIIlIIllIlI) {
        lllllllllllIllIIIlIIllIIlIIlIlll = (long)((BlockPos)lllllllllllIllIIIlIIllIIlIIlIlll).offset(lllllllllllIllIIIlIIllIIlIIllIlI);
        if (this.getBlockState((BlockPos)lllllllllllIllIIIlIIllIIlIIlIlll).getBlock() == Blocks.FIRE) {
            this.playEvent(lllllllllllIllIIIlIIllIIlIIlllII, 1009, (BlockPos)lllllllllllIllIIIlIIllIIlIIlIlll, 0);
            this.setBlockToAir((BlockPos)lllllllllllIllIIIlIIllIIlIIlIlll);
            return true;
        }
        return false;
    }
    
    public int getMoonPhase() {
        return this.provider.getMoonPhase(this.worldInfo.getWorldTime());
    }
    
    protected abstract IChunkProvider createChunkProvider();
    
    public Explosion newExplosion(@Nullable final Entity lllllllllllIllIIIlIIllIIlllIIIlI, final double lllllllllllIllIIIlIIllIIlllIIIIl, final double lllllllllllIllIIIlIIllIIlllIIIII, final double lllllllllllIllIIIlIIllIIllIlIllI, final float lllllllllllIllIIIlIIllIIllIllllI, final boolean lllllllllllIllIIIlIIllIIllIlllIl, final boolean lllllllllllIllIIIlIIllIIllIlllII) {
        final Explosion lllllllllllIllIIIlIIllIIllIllIll = new Explosion(this, lllllllllllIllIIIlIIllIIlllIIIlI, lllllllllllIllIIIlIIllIIlllIIIIl, lllllllllllIllIIIlIIllIIlllIIIII, lllllllllllIllIIIlIIllIIllIlIllI, lllllllllllIllIIIlIIllIIllIllllI, lllllllllllIllIIIlIIllIIllIlllIl, lllllllllllIllIIIlIIllIIllIlllII);
        lllllllllllIllIIIlIIllIIllIllIll.doExplosionA();
        lllllllllllIllIIIlIIllIIllIllIll.doExplosionB(true);
        return lllllllllllIllIIIlIIllIIllIllIll;
    }
    
    @Nullable
    public RayTraceResult rayTraceBlocks(Vec3d lllllllllllIllIIIlIlIIIIllIIIIlI, final Vec3d lllllllllllIllIIIlIlIIIIllIIIIIl, final boolean lllllllllllIllIIIlIlIIIIlllIIlII, final boolean lllllllllllIllIIIlIlIIIIlllIIIll, final boolean lllllllllllIllIIIlIlIIIIlllIIIlI) {
        if (Double.isNaN(lllllllllllIllIIIlIlIIIIllIIIIlI.xCoord) || Double.isNaN(lllllllllllIllIIIlIlIIIIllIIIIlI.yCoord) || Double.isNaN(lllllllllllIllIIIlIlIIIIllIIIIlI.zCoord)) {
            return null;
        }
        if (!Double.isNaN(lllllllllllIllIIIlIlIIIIllIIIIIl.xCoord) && !Double.isNaN(lllllllllllIllIIIlIlIIIIllIIIIIl.yCoord) && !Double.isNaN(lllllllllllIllIIIlIlIIIIllIIIIIl.zCoord)) {
            final int lllllllllllIllIIIlIlIIIIlllIIIIl = MathHelper.floor(lllllllllllIllIIIlIlIIIIllIIIIIl.xCoord);
            final int lllllllllllIllIIIlIlIIIIlllIIIII = MathHelper.floor(lllllllllllIllIIIlIlIIIIllIIIIIl.yCoord);
            final int lllllllllllIllIIIlIlIIIIllIlllll = MathHelper.floor(lllllllllllIllIIIlIlIIIIllIIIIIl.zCoord);
            int lllllllllllIllIIIlIlIIIIllIllllI = MathHelper.floor(lllllllllllIllIIIlIlIIIIllIIIIlI.xCoord);
            int lllllllllllIllIIIlIlIIIIllIlllIl = MathHelper.floor(lllllllllllIllIIIlIlIIIIllIIIIlI.yCoord);
            int lllllllllllIllIIIlIlIIIIllIlllII = MathHelper.floor(lllllllllllIllIIIlIlIIIIllIIIIlI.zCoord);
            BlockPos lllllllllllIllIIIlIlIIIIllIllIll = new BlockPos(lllllllllllIllIIIlIlIIIIllIllllI, lllllllllllIllIIIlIlIIIIllIlllIl, lllllllllllIllIIIlIlIIIIllIlllII);
            final IBlockState lllllllllllIllIIIlIlIIIIllIllIlI = this.getBlockState(lllllllllllIllIIIlIlIIIIllIllIll);
            final Block lllllllllllIllIIIlIlIIIIllIllIIl = lllllllllllIllIIIlIlIIIIllIllIlI.getBlock();
            if ((!lllllllllllIllIIIlIlIIIIlllIIIll || lllllllllllIllIIIlIlIIIIllIllIlI.getCollisionBoundingBox(this, lllllllllllIllIIIlIlIIIIllIllIll) != Block.NULL_AABB) && lllllllllllIllIIIlIlIIIIllIllIIl.canCollideCheck(lllllllllllIllIIIlIlIIIIllIllIlI, lllllllllllIllIIIlIlIIIIlllIIlII)) {
                final RayTraceResult lllllllllllIllIIIlIlIIIIllIllIII = lllllllllllIllIIIlIlIIIIllIllIlI.collisionRayTrace(this, lllllllllllIllIIIlIlIIIIllIllIll, lllllllllllIllIIIlIlIIIIllIIIIlI, lllllllllllIllIIIlIlIIIIllIIIIIl);
                if (lllllllllllIllIIIlIlIIIIllIllIII != null) {
                    return lllllllllllIllIIIlIlIIIIllIllIII;
                }
            }
            RayTraceResult lllllllllllIllIIIlIlIIIIllIlIlll = null;
            int lllllllllllIllIIIlIlIIIIllIlIllI = 200;
            while (lllllllllllIllIIIlIlIIIIllIlIllI-- >= 0) {
                if (Double.isNaN(lllllllllllIllIIIlIlIIIIllIIIIlI.xCoord) || Double.isNaN(lllllllllllIllIIIlIlIIIIllIIIIlI.yCoord) || Double.isNaN(lllllllllllIllIIIlIlIIIIllIIIIlI.zCoord)) {
                    return null;
                }
                if (lllllllllllIllIIIlIlIIIIllIllllI == lllllllllllIllIIIlIlIIIIlllIIIIl && lllllllllllIllIIIlIlIIIIllIlllIl == lllllllllllIllIIIlIlIIIIlllIIIII && lllllllllllIllIIIlIlIIIIllIlllII == lllllllllllIllIIIlIlIIIIllIlllll) {
                    return lllllllllllIllIIIlIlIIIIlllIIIlI ? lllllllllllIllIIIlIlIIIIllIlIlll : null;
                }
                boolean lllllllllllIllIIIlIlIIIIllIlIlIl = true;
                boolean lllllllllllIllIIIlIlIIIIllIlIlII = true;
                boolean lllllllllllIllIIIlIlIIIIllIlIIll = true;
                double lllllllllllIllIIIlIlIIIIllIlIIlI = 999.0;
                double lllllllllllIllIIIlIlIIIIllIlIIIl = 999.0;
                double lllllllllllIllIIIlIlIIIIllIlIIII = 999.0;
                if (lllllllllllIllIIIlIlIIIIlllIIIIl > lllllllllllIllIIIlIlIIIIllIllllI) {
                    lllllllllllIllIIIlIlIIIIllIlIIlI = lllllllllllIllIIIlIlIIIIllIllllI + 1.0;
                }
                else if (lllllllllllIllIIIlIlIIIIlllIIIIl < lllllllllllIllIIIlIlIIIIllIllllI) {
                    lllllllllllIllIIIlIlIIIIllIlIIlI = lllllllllllIllIIIlIlIIIIllIllllI + 0.0;
                }
                else {
                    lllllllllllIllIIIlIlIIIIllIlIlIl = false;
                }
                if (lllllllllllIllIIIlIlIIIIlllIIIII > lllllllllllIllIIIlIlIIIIllIlllIl) {
                    lllllllllllIllIIIlIlIIIIllIlIIIl = lllllllllllIllIIIlIlIIIIllIlllIl + 1.0;
                }
                else if (lllllllllllIllIIIlIlIIIIlllIIIII < lllllllllllIllIIIlIlIIIIllIlllIl) {
                    lllllllllllIllIIIlIlIIIIllIlIIIl = lllllllllllIllIIIlIlIIIIllIlllIl + 0.0;
                }
                else {
                    lllllllllllIllIIIlIlIIIIllIlIlII = false;
                }
                if (lllllllllllIllIIIlIlIIIIllIlllll > lllllllllllIllIIIlIlIIIIllIlllII) {
                    lllllllllllIllIIIlIlIIIIllIlIIII = lllllllllllIllIIIlIlIIIIllIlllII + 1.0;
                }
                else if (lllllllllllIllIIIlIlIIIIllIlllll < lllllllllllIllIIIlIlIIIIllIlllII) {
                    lllllllllllIllIIIlIlIIIIllIlIIII = lllllllllllIllIIIlIlIIIIllIlllII + 0.0;
                }
                else {
                    lllllllllllIllIIIlIlIIIIllIlIIll = false;
                }
                double lllllllllllIllIIIlIlIIIIllIIllll = 999.0;
                double lllllllllllIllIIIlIlIIIIllIIlllI = 999.0;
                double lllllllllllIllIIIlIlIIIIllIIllIl = 999.0;
                final double lllllllllllIllIIIlIlIIIIllIIllII = lllllllllllIllIIIlIlIIIIllIIIIIl.xCoord - lllllllllllIllIIIlIlIIIIllIIIIlI.xCoord;
                final double lllllllllllIllIIIlIlIIIIllIIlIll = lllllllllllIllIIIlIlIIIIllIIIIIl.yCoord - lllllllllllIllIIIlIlIIIIllIIIIlI.yCoord;
                final double lllllllllllIllIIIlIlIIIIllIIlIlI = lllllllllllIllIIIlIlIIIIllIIIIIl.zCoord - lllllllllllIllIIIlIlIIIIllIIIIlI.zCoord;
                if (lllllllllllIllIIIlIlIIIIllIlIlIl) {
                    lllllllllllIllIIIlIlIIIIllIIllll = (lllllllllllIllIIIlIlIIIIllIlIIlI - lllllllllllIllIIIlIlIIIIllIIIIlI.xCoord) / lllllllllllIllIIIlIlIIIIllIIllII;
                }
                if (lllllllllllIllIIIlIlIIIIllIlIlII) {
                    lllllllllllIllIIIlIlIIIIllIIlllI = (lllllllllllIllIIIlIlIIIIllIlIIIl - lllllllllllIllIIIlIlIIIIllIIIIlI.yCoord) / lllllllllllIllIIIlIlIIIIllIIlIll;
                }
                if (lllllllllllIllIIIlIlIIIIllIlIIll) {
                    lllllllllllIllIIIlIlIIIIllIIllIl = (lllllllllllIllIIIlIlIIIIllIlIIII - lllllllllllIllIIIlIlIIIIllIIIIlI.zCoord) / lllllllllllIllIIIlIlIIIIllIIlIlI;
                }
                if (lllllllllllIllIIIlIlIIIIllIIllll == -0.0) {
                    lllllllllllIllIIIlIlIIIIllIIllll = -1.0E-4;
                }
                if (lllllllllllIllIIIlIlIIIIllIIlllI == -0.0) {
                    lllllllllllIllIIIlIlIIIIllIIlllI = -1.0E-4;
                }
                if (lllllllllllIllIIIlIlIIIIllIIllIl == -0.0) {
                    lllllllllllIllIIIlIlIIIIllIIllIl = -1.0E-4;
                }
                EnumFacing lllllllllllIllIIIlIlIIIIllIIIlll = null;
                if (lllllllllllIllIIIlIlIIIIllIIllll < lllllllllllIllIIIlIlIIIIllIIlllI && lllllllllllIllIIIlIlIIIIllIIllll < lllllllllllIllIIIlIlIIIIllIIllIl) {
                    final EnumFacing lllllllllllIllIIIlIlIIIIllIIlIIl = (lllllllllllIllIIIlIlIIIIlllIIIIl > lllllllllllIllIIIlIlIIIIllIllllI) ? EnumFacing.WEST : EnumFacing.EAST;
                    lllllllllllIllIIIlIlIIIIllIIIIlI = new Vec3d(lllllllllllIllIIIlIlIIIIllIlIIlI, lllllllllllIllIIIlIlIIIIllIIIIlI.yCoord + lllllllllllIllIIIlIlIIIIllIIlIll * lllllllllllIllIIIlIlIIIIllIIllll, lllllllllllIllIIIlIlIIIIllIIIIlI.zCoord + lllllllllllIllIIIlIlIIIIllIIlIlI * lllllllllllIllIIIlIlIIIIllIIllll);
                }
                else if (lllllllllllIllIIIlIlIIIIllIIlllI < lllllllllllIllIIIlIlIIIIllIIllIl) {
                    final EnumFacing lllllllllllIllIIIlIlIIIIllIIlIII = (lllllllllllIllIIIlIlIIIIlllIIIII > lllllllllllIllIIIlIlIIIIllIlllIl) ? EnumFacing.DOWN : EnumFacing.UP;
                    lllllllllllIllIIIlIlIIIIllIIIIlI = new Vec3d(lllllllllllIllIIIlIlIIIIllIIIIlI.xCoord + lllllllllllIllIIIlIlIIIIllIIllII * lllllllllllIllIIIlIlIIIIllIIlllI, lllllllllllIllIIIlIlIIIIllIlIIIl, lllllllllllIllIIIlIlIIIIllIIIIlI.zCoord + lllllllllllIllIIIlIlIIIIllIIlIlI * lllllllllllIllIIIlIlIIIIllIIlllI);
                }
                else {
                    lllllllllllIllIIIlIlIIIIllIIIlll = ((lllllllllllIllIIIlIlIIIIllIlllll > lllllllllllIllIIIlIlIIIIllIlllII) ? EnumFacing.NORTH : EnumFacing.SOUTH);
                    lllllllllllIllIIIlIlIIIIllIIIIlI = new Vec3d(lllllllllllIllIIIlIlIIIIllIIIIlI.xCoord + lllllllllllIllIIIlIlIIIIllIIllII * lllllllllllIllIIIlIlIIIIllIIllIl, lllllllllllIllIIIlIlIIIIllIIIIlI.yCoord + lllllllllllIllIIIlIlIIIIllIIlIll * lllllllllllIllIIIlIlIIIIllIIllIl, lllllllllllIllIIIlIlIIIIllIlIIII);
                }
                lllllllllllIllIIIlIlIIIIllIllllI = MathHelper.floor(lllllllllllIllIIIlIlIIIIllIIIIlI.xCoord) - ((lllllllllllIllIIIlIlIIIIllIIIlll == EnumFacing.EAST) ? 1 : 0);
                lllllllllllIllIIIlIlIIIIllIlllIl = MathHelper.floor(lllllllllllIllIIIlIlIIIIllIIIIlI.yCoord) - ((lllllllllllIllIIIlIlIIIIllIIIlll == EnumFacing.UP) ? 1 : 0);
                lllllllllllIllIIIlIlIIIIllIlllII = MathHelper.floor(lllllllllllIllIIIlIlIIIIllIIIIlI.zCoord) - ((lllllllllllIllIIIlIlIIIIllIIIlll == EnumFacing.SOUTH) ? 1 : 0);
                lllllllllllIllIIIlIlIIIIllIllIll = new BlockPos(lllllllllllIllIIIlIlIIIIllIllllI, lllllllllllIllIIIlIlIIIIllIlllIl, lllllllllllIllIIIlIlIIIIllIlllII);
                final IBlockState lllllllllllIllIIIlIlIIIIllIIIllI = this.getBlockState(lllllllllllIllIIIlIlIIIIllIllIll);
                final Block lllllllllllIllIIIlIlIIIIllIIIlIl = lllllllllllIllIIIlIlIIIIllIIIllI.getBlock();
                if (lllllllllllIllIIIlIlIIIIlllIIIll && lllllllllllIllIIIlIlIIIIllIIIllI.getMaterial() != Material.PORTAL && lllllllllllIllIIIlIlIIIIllIIIllI.getCollisionBoundingBox(this, lllllllllllIllIIIlIlIIIIllIllIll) == Block.NULL_AABB) {
                    continue;
                }
                if (lllllllllllIllIIIlIlIIIIllIIIlIl.canCollideCheck(lllllllllllIllIIIlIlIIIIllIIIllI, lllllllllllIllIIIlIlIIIIlllIIlII)) {
                    final RayTraceResult lllllllllllIllIIIlIlIIIIllIIIlII = lllllllllllIllIIIlIlIIIIllIIIllI.collisionRayTrace(this, lllllllllllIllIIIlIlIIIIllIllIll, lllllllllllIllIIIlIlIIIIllIIIIlI, lllllllllllIllIIIlIlIIIIllIIIIIl);
                    if (lllllllllllIllIIIlIlIIIIllIIIlII != null) {
                        return lllllllllllIllIIIlIlIIIIllIIIlII;
                    }
                    continue;
                }
                else {
                    lllllllllllIllIIIlIlIIIIllIlIlll = new RayTraceResult(RayTraceResult.Type.MISS, lllllllllllIllIIIlIlIIIIllIIIIlI, lllllllllllIllIIIlIlIIIIllIIIlll, lllllllllllIllIIIlIlIIIIllIllIll);
                }
            }
            return lllllllllllIllIIIlIlIIIIlllIIIlI ? lllllllllllIllIIIlIlIIIIllIlIlll : null;
        }
        return null;
    }
    
    private boolean func_191504_a(@Nullable final Entity lllllllllllIllIIIlIIlllllIIIIIII, final AxisAlignedBB lllllllllllIllIIIlIIllllIlllllll, final boolean lllllllllllIllIIIlIIllllIllllllI, @Nullable final List<AxisAlignedBB> lllllllllllIllIIIlIIllllIllIIlII) {
        final int lllllllllllIllIIIlIIllllIlllllII = MathHelper.floor(lllllllllllIllIIIlIIllllIlllllll.minX) - 1;
        final int lllllllllllIllIIIlIIllllIllllIll = MathHelper.ceil(lllllllllllIllIIIlIIllllIlllllll.maxX) + 1;
        final int lllllllllllIllIIIlIIllllIllllIlI = MathHelper.floor(lllllllllllIllIIIlIIllllIlllllll.minY) - 1;
        final int lllllllllllIllIIIlIIllllIllllIIl = MathHelper.ceil(lllllllllllIllIIIlIIllllIlllllll.maxY) + 1;
        final int lllllllllllIllIIIlIIllllIllllIII = MathHelper.floor(lllllllllllIllIIIlIIllllIlllllll.minZ) - 1;
        final int lllllllllllIllIIIlIIllllIlllIlll = MathHelper.ceil(lllllllllllIllIIIlIIllllIlllllll.maxZ) + 1;
        final WorldBorder lllllllllllIllIIIlIIllllIlllIllI = this.getWorldBorder();
        final boolean lllllllllllIllIIIlIIllllIlllIlIl = lllllllllllIllIIIlIIlllllIIIIIII != null && lllllllllllIllIIIlIIlllllIIIIIII.isOutsideBorder();
        final boolean lllllllllllIllIIIlIIllllIlllIlII = lllllllllllIllIIIlIIlllllIIIIIII != null && this.func_191503_g(lllllllllllIllIIIlIIlllllIIIIIII);
        final IBlockState lllllllllllIllIIIlIIllllIlllIIll = Blocks.STONE.getDefaultState();
        final BlockPos.PooledMutableBlockPos lllllllllllIllIIIlIIllllIlllIIlI = BlockPos.PooledMutableBlockPos.retain();
        try {
            for (int lllllllllllIllIIIlIIllllIlllIIIl = lllllllllllIllIIIlIIllllIlllllII; lllllllllllIllIIIlIIllllIlllIIIl < lllllllllllIllIIIlIIllllIllllIll; ++lllllllllllIllIIIlIIllllIlllIIIl) {
                for (int lllllllllllIllIIIlIIllllIlllIIII = lllllllllllIllIIIlIIllllIllllIII; lllllllllllIllIIIlIIllllIlllIIII < lllllllllllIllIIIlIIllllIlllIlll; ++lllllllllllIllIIIlIIllllIlllIIII) {
                    final boolean lllllllllllIllIIIlIIllllIllIllll = lllllllllllIllIIIlIIllllIlllIIIl == lllllllllllIllIIIlIIllllIlllllII || lllllllllllIllIIIlIIllllIlllIIIl == lllllllllllIllIIIlIIllllIllllIll - 1;
                    final boolean lllllllllllIllIIIlIIllllIllIlllI = lllllllllllIllIIIlIIllllIlllIIII == lllllllllllIllIIIlIIllllIllllIII || lllllllllllIllIIIlIIllllIlllIIII == lllllllllllIllIIIlIIllllIlllIlll - 1;
                    if ((!lllllllllllIllIIIlIIllllIllIllll || !lllllllllllIllIIIlIIllllIllIlllI) && this.isBlockLoaded(lllllllllllIllIIIlIIllllIlllIIlI.setPos(lllllllllllIllIIIlIIllllIlllIIIl, 64, lllllllllllIllIIIlIIllllIlllIIII))) {
                        for (int lllllllllllIllIIIlIIllllIllIllIl = lllllllllllIllIIIlIIllllIllllIlI; lllllllllllIllIIIlIIllllIllIllIl < lllllllllllIllIIIlIIllllIllllIIl; ++lllllllllllIllIIIlIIllllIllIllIl) {
                            if ((!lllllllllllIllIIIlIIllllIllIllll && !lllllllllllIllIIIlIIllllIllIlllI) || lllllllllllIllIIIlIIllllIllIllIl != lllllllllllIllIIIlIIllllIllllIIl - 1) {
                                if (lllllllllllIllIIIlIIllllIllllllI) {
                                    if (lllllllllllIllIIIlIIllllIlllIIIl < -30000000 || lllllllllllIllIIIlIIllllIlllIIIl >= 30000000 || lllllllllllIllIIIlIIllllIlllIIII < -30000000 || lllllllllllIllIIIlIIllllIlllIIII >= 30000000) {
                                        final String lllllllllllIllIIIlIIllllIlIlIIII;
                                        final boolean lllllllllllIllIIIlIIllllIllIllII = (boolean)(lllllllllllIllIIIlIIllllIlIlIIII = (String)1);
                                        return (boolean)lllllllllllIllIIIlIIllllIlIlIIII;
                                    }
                                }
                                else if (lllllllllllIllIIIlIIlllllIIIIIII != null && lllllllllllIllIIIlIIllllIlllIlIl == lllllllllllIllIIIlIIllllIlllIlII) {
                                    lllllllllllIllIIIlIIlllllIIIIIII.setOutsideBorder(!lllllllllllIllIIIlIIllllIlllIlII);
                                }
                                lllllllllllIllIIIlIIllllIlllIIlI.setPos(lllllllllllIllIIIlIIllllIlllIIIl, lllllllllllIllIIIlIIllllIllIllIl, lllllllllllIllIIIlIIllllIlllIIII);
                                IBlockState lllllllllllIllIIIlIIllllIllIlIlI = null;
                                if (!lllllllllllIllIIIlIIllllIllllllI && !lllllllllllIllIIIlIIllllIlllIllI.contains(lllllllllllIllIIIlIIllllIlllIIlI) && lllllllllllIllIIIlIIllllIlllIlII) {
                                    final IBlockState lllllllllllIllIIIlIIllllIllIlIll = lllllllllllIllIIIlIIllllIlllIIll;
                                }
                                else {
                                    lllllllllllIllIIIlIIllllIllIlIlI = this.getBlockState(lllllllllllIllIIIlIIllllIlllIIlI);
                                }
                                lllllllllllIllIIIlIIllllIllIlIlI.addCollisionBoxToList(this, lllllllllllIllIIIlIIllllIlllIIlI, lllllllllllIllIIIlIIllllIlllllll, lllllllllllIllIIIlIIllllIllIIlII, lllllllllllIllIIIlIIlllllIIIIIII, false);
                                if (lllllllllllIllIIIlIIllllIllllllI && !lllllllllllIllIIIlIIllllIllIIlII.isEmpty()) {
                                    final String lllllllllllIllIIIlIIllllIlIlIIII;
                                    final boolean lllllllllllIllIIIlIIllllIllIlIIl = (boolean)(lllllllllllIllIIIlIIllllIlIlIIII = (String)1);
                                    return (boolean)lllllllllllIllIIIlIIllllIlIlIIII;
                                }
                            }
                        }
                    }
                }
            }
        }
        finally {
            lllllllllllIllIIIlIIllllIlllIIlI.release();
        }
        lllllllllllIllIIIlIIllllIlllIIlI.release();
        return !lllllllllllIllIIIlIIllllIllIIlII.isEmpty();
    }
    
    public void removeEventListener(final IWorldEventListener lllllllllllIllIIIlIIlllllIIllIll) {
        this.eventListeners.remove(lllllllllllIllIIIlIIlllllIIllIll);
    }
    
    public float getCurrentMoonPhaseFactor() {
        return WorldProvider.MOON_PHASE_FACTORS[this.provider.getMoonPhase(this.worldInfo.getWorldTime())];
    }
    
    @Override
    public int getStrongPower(final BlockPos lllllllllllIllIIIlIIlIlIIlIIlIll, final EnumFacing lllllllllllIllIIIlIIlIlIIlIIllIl) {
        return this.getBlockState(lllllllllllIllIIIlIIlIlIIlIIlIll).getStrongPower(this, lllllllllllIllIIIlIIlIlIIlIIlIll, lllllllllllIllIIIlIIlIlIIlIIllIl);
    }
    
    public String getDebugLoadedEntities() {
        return "All: " + this.loadedEntityList.size();
    }
    
    public boolean checkBlockCollision(final AxisAlignedBB lllllllllllIllIIIlIIllIlllIIlIIl) {
        final int lllllllllllIllIIIlIIllIlllIIlIII = MathHelper.floor(lllllllllllIllIIIlIIllIlllIIlIIl.minX);
        final int lllllllllllIllIIIlIIllIlllIIIlll = MathHelper.ceil(lllllllllllIllIIIlIIllIlllIIlIIl.maxX);
        final int lllllllllllIllIIIlIIllIlllIIIllI = MathHelper.floor(lllllllllllIllIIIlIIllIlllIIlIIl.minY);
        final int lllllllllllIllIIIlIIllIlllIIIlIl = MathHelper.ceil(lllllllllllIllIIIlIIllIlllIIlIIl.maxY);
        final int lllllllllllIllIIIlIIllIlllIIIlII = MathHelper.floor(lllllllllllIllIIIlIIllIlllIIlIIl.minZ);
        final int lllllllllllIllIIIlIIllIlllIIIIll = MathHelper.ceil(lllllllllllIllIIIlIIllIlllIIlIIl.maxZ);
        final BlockPos.PooledMutableBlockPos lllllllllllIllIIIlIIllIlllIIIIlI = BlockPos.PooledMutableBlockPos.retain();
        for (int lllllllllllIllIIIlIIllIlllIIIIIl = lllllllllllIllIIIlIIllIlllIIlIII; lllllllllllIllIIIlIIllIlllIIIIIl < lllllllllllIllIIIlIIllIlllIIIlll; ++lllllllllllIllIIIlIIllIlllIIIIIl) {
            for (int lllllllllllIllIIIlIIllIlllIIIIII = lllllllllllIllIIIlIIllIlllIIIllI; lllllllllllIllIIIlIIllIlllIIIIII < lllllllllllIllIIIlIIllIlllIIIlIl; ++lllllllllllIllIIIlIIllIlllIIIIII) {
                for (int lllllllllllIllIIIlIIllIllIllllll = lllllllllllIllIIIlIIllIlllIIIlII; lllllllllllIllIIIlIIllIllIllllll < lllllllllllIllIIIlIIllIlllIIIIll; ++lllllllllllIllIIIlIIllIllIllllll) {
                    final IBlockState lllllllllllIllIIIlIIllIllIlllllI = this.getBlockState(lllllllllllIllIIIlIIllIlllIIIIlI.setPos(lllllllllllIllIIIlIIllIlllIIIIIl, lllllllllllIllIIIlIIllIlllIIIIII, lllllllllllIllIIIlIIllIllIllllll));
                    if (lllllllllllIllIIIlIIllIllIlllllI.getMaterial() != Material.AIR) {
                        lllllllllllIllIIIlIIllIlllIIIIlI.release();
                        return true;
                    }
                }
            }
        }
        lllllllllllIllIIIlIIllIlllIIIIlI.release();
        return false;
    }
    
    public boolean isSidePowered(final BlockPos lllllllllllIllIIIlIIlIlIIIlllIIl, final EnumFacing lllllllllllIllIIIlIIlIlIIIllIlIl) {
        return this.getRedstonePower(lllllllllllIllIIIlIIlIlIIIlllIIl, lllllllllllIllIIIlIIlIlIIIllIlIl) > 0;
    }
    
    public int getLightFromNeighbors(final BlockPos lllllllllllIllIIIlIlIIIllIllIlIl) {
        return this.getLight(lllllllllllIllIIIlIlIIIllIllIlIl, true);
    }
    
    public boolean isRaining() {
        return this.getRainStrength(1.0f) > 0.2;
    }
    
    public boolean isFlammableWithin(final AxisAlignedBB lllllllllllIllIIIlIIllIlIllIlllI) {
        final int lllllllllllIllIIIlIIllIlIllllIlI = MathHelper.floor(lllllllllllIllIIIlIIllIlIllIlllI.minX);
        final int lllllllllllIllIIIlIIllIlIllllIIl = MathHelper.ceil(lllllllllllIllIIIlIIllIlIllIlllI.maxX);
        final int lllllllllllIllIIIlIIllIlIllllIII = MathHelper.floor(lllllllllllIllIIIlIIllIlIllIlllI.minY);
        final int lllllllllllIllIIIlIIllIlIlllIlll = MathHelper.ceil(lllllllllllIllIIIlIIllIlIllIlllI.maxY);
        final int lllllllllllIllIIIlIIllIlIlllIllI = MathHelper.floor(lllllllllllIllIIIlIIllIlIllIlllI.minZ);
        final int lllllllllllIllIIIlIIllIlIlllIlIl = MathHelper.ceil(lllllllllllIllIIIlIIllIlIllIlllI.maxZ);
        if (this.isAreaLoaded(lllllllllllIllIIIlIIllIlIllllIlI, lllllllllllIllIIIlIIllIlIllllIII, lllllllllllIllIIIlIIllIlIlllIllI, lllllllllllIllIIIlIIllIlIllllIIl, lllllllllllIllIIIlIIllIlIlllIlll, lllllllllllIllIIIlIIllIlIlllIlIl, true)) {
            final BlockPos.PooledMutableBlockPos lllllllllllIllIIIlIIllIlIlllIlII = BlockPos.PooledMutableBlockPos.retain();
            for (int lllllllllllIllIIIlIIllIlIlllIIll = lllllllllllIllIIIlIIllIlIllllIlI; lllllllllllIllIIIlIIllIlIlllIIll < lllllllllllIllIIIlIIllIlIllllIIl; ++lllllllllllIllIIIlIIllIlIlllIIll) {
                for (int lllllllllllIllIIIlIIllIlIlllIIlI = lllllllllllIllIIIlIIllIlIllllIII; lllllllllllIllIIIlIIllIlIlllIIlI < lllllllllllIllIIIlIIllIlIlllIlll; ++lllllllllllIllIIIlIIllIlIlllIIlI) {
                    for (int lllllllllllIllIIIlIIllIlIlllIIIl = lllllllllllIllIIIlIIllIlIlllIllI; lllllllllllIllIIIlIIllIlIlllIIIl < lllllllllllIllIIIlIIllIlIlllIlIl; ++lllllllllllIllIIIlIIllIlIlllIIIl) {
                        final Block lllllllllllIllIIIlIIllIlIlllIIII = this.getBlockState(lllllllllllIllIIIlIIllIlIlllIlII.setPos(lllllllllllIllIIIlIIllIlIlllIIll, lllllllllllIllIIIlIIllIlIlllIIlI, lllllllllllIllIIIlIIllIlIlllIIIl)).getBlock();
                        if (lllllllllllIllIIIlIIllIlIlllIIII == Blocks.FIRE || lllllllllllIllIIIlIIllIlIlllIIII == Blocks.FLOWING_LAVA || lllllllllllIllIIIlIIllIlIlllIIII == Blocks.LAVA) {
                            lllllllllllIllIIIlIIllIlIlllIlII.release();
                            return true;
                        }
                    }
                }
            }
            lllllllllllIllIIIlIIllIlIlllIlII.release();
        }
        return false;
    }
    
    public boolean func_190527_a(final Block lllllllllllIllIIIlIIlIlIIllIlIlI, final BlockPos lllllllllllIllIIIlIIlIlIIllIIIIl, final boolean lllllllllllIllIIIlIIlIlIIllIIIII, final EnumFacing lllllllllllIllIIIlIIlIlIIllIIlll, @Nullable final Entity lllllllllllIllIIIlIIlIlIIllIIllI) {
        final IBlockState lllllllllllIllIIIlIIlIlIIllIIlIl = this.getBlockState(lllllllllllIllIIIlIIlIlIIllIIIIl);
        final AxisAlignedBB lllllllllllIllIIIlIIlIlIIllIIlII = lllllllllllIllIIIlIIlIlIIllIIIII ? null : lllllllllllIllIIIlIIlIlIIllIlIlI.getDefaultState().getCollisionBoundingBox(this, lllllllllllIllIIIlIIlIlIIllIIIIl);
        return (lllllllllllIllIIIlIIlIlIIllIIlII == Block.NULL_AABB || this.checkNoEntityCollision(lllllllllllIllIIIlIIlIlIIllIIlII.offset(lllllllllllIllIIIlIIlIlIIllIIIIl), lllllllllllIllIIIlIIlIlIIllIIllI)) && ((lllllllllllIllIIIlIIlIlIIllIIlIl.getMaterial() == Material.CIRCUITS && lllllllllllIllIIIlIIlIlIIllIlIlI == Blocks.ANVIL) || (lllllllllllIllIIIlIIlIlIIllIIlIl.getMaterial().isReplaceable() && lllllllllllIllIIIlIIlIlIIllIlIlI.canPlaceBlockOnSide(this, lllllllllllIllIIIlIIlIlIIllIIIIl, lllllllllllIllIIIlIIlIlIIllIIlll)));
    }
    
    public void markChunkDirty(final BlockPos lllllllllllIllIIIlIIlIlIlIIlIIll, final TileEntity lllllllllllIllIIIlIIlIlIlIIlIlIl) {
        if (this.isBlockLoaded(lllllllllllIllIIIlIIlIlIlIIlIIll)) {
            this.getChunkFromBlockCoords(lllllllllllIllIIIlIIlIlIlIIlIIll).setChunkModified();
        }
    }
    
    public void initialize(final WorldSettings lllllllllllIllIIIlIlIIllIlIIlIll) {
        this.worldInfo.setServerInitialized(true);
    }
    
    public void loadEntities(final Collection<Entity> lllllllllllIllIIIlIIlIlIIlllllll) {
        this.loadedEntityList.addAll(lllllllllllIllIIIlIIlIlIIlllllll);
        for (final Entity lllllllllllIllIIIlIIlIlIIllllllI : lllllllllllIllIIIlIIlIlIIlllllll) {
            this.onEntityAdded(lllllllllllIllIIIlIIlIlIIllllllI);
        }
    }
    
    private int getRawLight(final BlockPos lllllllllllIllIIIlIIlIlllIlIlllI, final EnumSkyBlock lllllllllllIllIIIlIIlIlllIllIlll) {
        if (lllllllllllIllIIIlIIlIlllIllIlll == EnumSkyBlock.SKY && this.canSeeSky(lllllllllllIllIIIlIIlIlllIlIlllI)) {
            return 15;
        }
        final IBlockState lllllllllllIllIIIlIIlIlllIllIllI = this.getBlockState(lllllllllllIllIIIlIIlIlllIlIlllI);
        int lllllllllllIllIIIlIIlIlllIllIlIl = (lllllllllllIllIIIlIIlIlllIllIlll == EnumSkyBlock.SKY) ? 0 : lllllllllllIllIIIlIIlIlllIllIllI.getLightValue();
        int lllllllllllIllIIIlIIlIlllIllIlII = lllllllllllIllIIIlIIlIlllIllIllI.getLightOpacity();
        if (lllllllllllIllIIIlIIlIlllIllIlII >= 15 && lllllllllllIllIIIlIIlIlllIllIllI.getLightValue() > 0) {
            lllllllllllIllIIIlIIlIlllIllIlII = 1;
        }
        if (lllllllllllIllIIIlIIlIlllIllIlII < 1) {
            lllllllllllIllIIIlIIlIlllIllIlII = 1;
        }
        if (lllllllllllIllIIIlIIlIlllIllIlII >= 15) {
            return 0;
        }
        if (lllllllllllIllIIIlIIlIlllIllIlIl >= 14) {
            return lllllllllllIllIIIlIIlIlllIllIlIl;
        }
        final BlockPos.PooledMutableBlockPos lllllllllllIllIIIlIIlIlllIllIIll = BlockPos.PooledMutableBlockPos.retain();
        try {
            final long lllllllllllIllIIIlIIlIlllIlIIlIl;
            final short lllllllllllIllIIIlIIlIlllIlIIllI = (short)((EnumFacing[])(Object)(lllllllllllIllIIIlIIlIlllIlIIlIl = (long)(Object)EnumFacing.values())).length;
            for (final EnumFacing lllllllllllIllIIIlIIlIlllIllIIlI : lllllllllllIllIIIlIIlIlllIlIIlIl) {
                lllllllllllIllIIIlIIlIlllIllIIll.setPos(lllllllllllIllIIIlIIlIlllIlIlllI).move(lllllllllllIllIIIlIIlIlllIllIIlI);
                final int lllllllllllIllIIIlIIlIlllIllIIIl = this.getLightFor(lllllllllllIllIIIlIIlIlllIllIlll, lllllllllllIllIIIlIIlIlllIllIIll) - lllllllllllIllIIIlIIlIlllIllIlII;
                if (lllllllllllIllIIIlIIlIlllIllIIIl > lllllllllllIllIIIlIIlIlllIllIlIl) {
                    lllllllllllIllIIIlIIlIlllIllIlIl = lllllllllllIllIIIlIIlIlllIllIIIl;
                }
                if (lllllllllllIllIIIlIIlIlllIllIlIl >= 14) {
                    final byte lllllllllllIllIIIlIIlIlllIlIIIIl;
                    final int lllllllllllIllIIIlIIlIlllIllIIII = lllllllllllIllIIIlIIlIlllIlIIIIl = (byte)lllllllllllIllIIIlIIlIlllIllIlIl;
                    return lllllllllllIllIIIlIIlIlllIlIIIIl;
                }
            }
            byte lllllllllllIllIIIlIIlIlllIlIIIIl = (byte)lllllllllllIllIIIlIIlIlllIllIlIl;
            return lllllllllllIllIIIlIIlIlllIlIIIIl;
        }
        finally {
            lllllllllllIllIIIlIIlIlllIllIIll.release();
        }
    }
    
    @Deprecated
    public int getChunksLowestHorizon(final int lllllllllllIllIIIlIlIIIllIIIIIlI, final int lllllllllllIllIIIlIlIIIlIlllllIl) {
        if (lllllllllllIllIIIlIlIIIllIIIIIlI < -30000000 || lllllllllllIllIIIlIlIIIlIlllllIl < -30000000 || lllllllllllIllIIIlIlIIIllIIIIIlI >= 30000000 || lllllllllllIllIIIlIlIIIlIlllllIl >= 30000000) {
            return this.getSeaLevel() + 1;
        }
        if (!this.isChunkLoaded(lllllllllllIllIIIlIlIIIllIIIIIlI >> 4, lllllllllllIllIIIlIlIIIlIlllllIl >> 4, true)) {
            return 0;
        }
        final Chunk lllllllllllIllIIIlIlIIIllIIIIIII = this.getChunkFromChunkCoords(lllllllllllIllIIIlIlIIIllIIIIIlI >> 4, lllllllllllIllIIIlIlIIIlIlllllIl >> 4);
        return lllllllllllIllIIIlIlIIIllIIIIIII.getLowestHeight();
    }
    
    public Chunk getChunkFromChunkCoords(final int lllllllllllIllIIIlIlIIlIlIllllII, final int lllllllllllIllIIIlIlIIlIlIlllIll) {
        return this.chunkProvider.provideChunk(lllllllllllIllIIIlIlIIlIlIllllII, lllllllllllIllIIIlIlIIlIlIlllIll);
    }
    
    public boolean isUpdateScheduled(final BlockPos lllllllllllIllIIIlIIlllIIllIIlIl, final Block lllllllllllIllIIIlIIlllIIllIIlII) {
        return true;
    }
    
    public boolean isAreaLoaded(final BlockPos lllllllllllIllIIIlIlIIlIllllIllI, final BlockPos lllllllllllIllIIIlIlIIlIlllllIIl, final boolean lllllllllllIllIIIlIlIIlIllllIlII) {
        return this.isAreaLoaded(lllllllllllIllIIIlIlIIlIllllIllI.getX(), lllllllllllIllIIIlIlIIlIllllIllI.getY(), lllllllllllIllIIIlIlIIlIllllIllI.getZ(), lllllllllllIllIIIlIlIIlIlllllIIl.getX(), lllllllllllIllIIIlIlIIlIlllllIIl.getY(), lllllllllllIllIIIlIlIIlIlllllIIl.getZ(), lllllllllllIllIIIlIlIIlIllllIlII);
    }
    
    protected void tickPlayers() {
    }
    
    public void playBroadcastSound(final int lllllllllllIllIIIlIIlIIIlIlIIlIl, final BlockPos lllllllllllIllIIIlIIlIIIlIlIIlII, final int lllllllllllIllIIIlIIlIIIlIlIIIll) {
        for (int lllllllllllIllIIIlIIlIIIlIlIIIlI = 0; lllllllllllIllIIIlIIlIIIlIlIIIlI < this.eventListeners.size(); ++lllllllllllIllIIIlIIlIIIlIlIIIlI) {
            this.eventListeners.get(lllllllllllIllIIIlIIlIIIlIlIIIlI).broadcastSound(lllllllllllIllIIIlIIlIIIlIlIIlIl, lllllllllllIllIIIlIIlIIIlIlIIlII, lllllllllllIllIIIlIIlIIIlIlIIIll);
        }
    }
    
    public int getHeight() {
        return 256;
    }
    
    public boolean isAnyPlayerWithinRangeAt(final double lllllllllllIllIIIlIIlIIllIllllII, final double lllllllllllIllIIIlIIlIIllIllIIll, final double lllllllllllIllIIIlIIlIIllIllIIlI, final double lllllllllllIllIIIlIIlIIllIllIIIl) {
        for (int lllllllllllIllIIIlIIlIIllIlllIII = 0; lllllllllllIllIIIlIIlIIllIlllIII < this.playerEntities.size(); ++lllllllllllIllIIIlIIlIIllIlllIII) {
            final EntityPlayer lllllllllllIllIIIlIIlIIllIllIlll = this.playerEntities.get(lllllllllllIllIIIlIIlIIllIlllIII);
            if (EntitySelectors.NOT_SPECTATING.apply((Object)lllllllllllIllIIIlIIlIIllIllIlll)) {
                final double lllllllllllIllIIIlIIlIIllIllIllI = lllllllllllIllIIIlIIlIIllIllIlll.getDistanceSq(lllllllllllIllIIIlIIlIIllIllllII, lllllllllllIllIIIlIIlIIllIllIIll, lllllllllllIllIIIlIIlIIllIllIIlI);
                if (lllllllllllIllIIIlIIlIIllIllIIIl < 0.0 || lllllllllllIllIIIlIIlIIllIllIllI < lllllllllllIllIIIlIIlIIllIllIIIl * lllllllllllIllIIIlIIlIIllIllIIIl) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public void scheduleUpdate(final BlockPos lllllllllllIllIIIlIIlllIIllIIIlI, final Block lllllllllllIllIIIlIIlllIIllIIIIl, final int lllllllllllIllIIIlIIlllIIllIIIII) {
    }
    
    public void setEntityState(final Entity lllllllllllIllIIIlIIlIIlIIIlIIlI, final byte lllllllllllIllIIIlIIlIIlIIIlIIIl) {
    }
    
    public BlockPos getPrecipitationHeight(final BlockPos lllllllllllIllIIIlIIlllIlIIIIlll) {
        return this.getChunkFromBlockCoords(lllllllllllIllIIIlIIlllIlIIIIlll).getPrecipitationHeight(lllllllllllIllIIIlIIlllIlIIIIlll);
    }
    
    public BlockPos getHeight(final BlockPos lllllllllllIllIIIlIlIIIllIIlIllI) {
        return new BlockPos(lllllllllllIllIIIlIlIIIllIIlIllI.getX(), this.getHeight(lllllllllllIllIIIlIlIIIllIIlIllI.getX(), lllllllllllIllIIIlIlIIIllIIlIllI.getZ()), lllllllllllIllIIIlIlIIIllIIlIllI.getZ());
    }
    
    public float getCelestialAngle(final float lllllllllllIllIIIlIIlllIllIIlIII) {
        return this.provider.calculateCelestialAngle(this.worldInfo.getWorldTime(), lllllllllllIllIIIlIIlllIllIIlIII);
    }
    
    public void setLastLightningBolt(final int lllllllllllIllIIIlIIlIIIIIIIIIll) {
        this.lastLightningBolt = lllllllllllIllIIIlIIlIIIIIIIIIll;
    }
    
    public List<Entity> getLoadedEntityList() {
        return this.loadedEntityList;
    }
    
    public boolean isRainingAt(final BlockPos lllllllllllIllIIIlIIlIIIllIlIlII) {
        if (!this.isRaining()) {
            return false;
        }
        if (!this.canSeeSky(lllllllllllIllIIIlIIlIIIllIlIlII)) {
            return false;
        }
        if (this.getPrecipitationHeight(lllllllllllIllIIIlIIlIIIllIlIlII).getY() > lllllllllllIllIIIlIIlIIIllIlIlII.getY()) {
            return false;
        }
        final Biome lllllllllllIllIIIlIIlIIIllIlIIll = this.getBiome(lllllllllllIllIIIlIIlIIIllIlIlII);
        return !lllllllllllIllIIIlIIlIIIllIlIIll.getEnableSnow() && !this.canSnowAt(lllllllllllIllIIIlIIlIIIllIlIlII, false) && lllllllllllIllIIIlIIlIIIllIlIIll.canRain();
    }
    
    public void markBlockRangeForRenderUpdate(final BlockPos lllllllllllIllIIIlIlIIlIIlIIIIll, final BlockPos lllllllllllIllIIIlIlIIlIIlIIIlIl) {
        this.markBlockRangeForRenderUpdate(lllllllllllIllIIIlIlIIlIIlIIIIll.getX(), lllllllllllIllIIIlIlIIlIIlIIIIll.getY(), lllllllllllIllIIIlIlIIlIIlIIIIll.getZ(), lllllllllllIllIIIlIlIIlIIlIIIlIl.getX(), lllllllllllIllIIIlIlIIlIIlIIIlIl.getY(), lllllllllllIllIIIlIlIIlIIlIIIlIl.getZ());
    }
    
    @Nullable
    public EntityPlayer getClosestPlayerToEntity(final Entity lllllllllllIllIIIlIIlIlIIIIIIllI, final double lllllllllllIllIIIlIIlIlIIIIIIlIl) {
        return this.getClosestPlayer(lllllllllllIllIIIlIIlIlIIIIIIllI.posX, lllllllllllIllIIIlIIlIlIIIIIIllI.posY, lllllllllllIllIIIlIIlIlIIIIIIllI.posZ, lllllllllllIllIIIlIIlIlIIIIIIlIl, false);
    }
    
    public boolean checkNoEntityCollision(final AxisAlignedBB lllllllllllIllIIIlIIllIlllIlllII, @Nullable final Entity lllllllllllIllIIIlIIllIlllIllIll) {
        final List<Entity> lllllllllllIllIIIlIIllIllllIIIII = this.getEntitiesWithinAABBExcludingEntity(null, lllllllllllIllIIIlIIllIlllIlllII);
        for (int lllllllllllIllIIIlIIllIlllIlllll = 0; lllllllllllIllIIIlIIllIlllIlllll < lllllllllllIllIIIlIIllIllllIIIII.size(); ++lllllllllllIllIIIlIIllIlllIlllll) {
            final Entity lllllllllllIllIIIlIIllIlllIllllI = lllllllllllIllIIIlIIllIllllIIIII.get(lllllllllllIllIIIlIIllIlllIlllll);
            if (!lllllllllllIllIIIlIIllIlllIllllI.isDead && lllllllllllIllIIIlIIllIlllIllllI.preventEntitySpawning && lllllllllllIllIIIlIIllIlllIllllI != lllllllllllIllIIIlIIllIlllIllIll && (lllllllllllIllIIIlIIllIlllIllIll == null || lllllllllllIllIIIlIIllIlllIllllI.isRidingSameEntity(lllllllllllIllIIIlIIllIlllIllIll))) {
                return false;
            }
        }
        return true;
    }
    
    public void setSkylightSubtracted(final int lllllllllllIllIIIlIIlIIIIIIIllII) {
        this.skylightSubtracted = lllllllllllIllIIIlIIlIIIIIIIllII;
    }
}
