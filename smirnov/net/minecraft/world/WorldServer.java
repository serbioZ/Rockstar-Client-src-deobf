// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world;

import java.util.ArrayList;
import com.google.common.util.concurrent.ListenableFuture;
import net.minecraft.world.biome.BiomeProvider;
import java.util.Random;
import java.util.Collection;
import net.minecraft.entity.INpc;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.passive.EntityAnimal;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import net.minecraft.profiler.Profiler;
import net.minecraft.world.storage.WorldInfo;
import net.minecraft.world.storage.ISaveHandler;
import net.minecraft.network.play.server.SPacketExplosion;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraft.network.play.server.SPacketBlockAction;
import net.minecraft.world.gen.feature.WorldGeneratorBonusChest;
import com.google.common.collect.Lists;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.chunk.storage.ExtendedBlockStorage;
import net.minecraft.init.Blocks;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.passive.EntitySkeletonHorse;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.network.play.server.SPacketParticles;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.entity.EntityList;
import com.google.common.base.Predicate;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.chunk.storage.IChunkLoader;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.network.play.server.SPacketEntityStatus;
import net.minecraft.advancements.FunctionManager;
import net.minecraft.advancements.AdvancementManager;
import net.minecraft.world.storage.loot.LootTableManager;
import java.io.File;
import net.minecraft.world.storage.WorldSavedDataCallableSave;
import net.minecraft.scoreboard.ScoreboardSaveData;
import net.minecraft.scoreboard.ServerScoreboard;
import net.minecraft.world.storage.WorldSavedData;
import net.minecraft.village.VillageCollection;
import net.minecraft.world.storage.MapStorage;
import net.minecraft.entity.player.EntityPlayerMP;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import net.minecraft.network.play.server.SPacketChangeGameState;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketSpawnGlobalEntity;
import net.minecraft.block.BlockEventData;
import javax.annotation.Nullable;
import net.minecraft.util.WeightedRandom;
import net.minecraft.world.biome.Biome;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.gen.ChunkProviderServer;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import org.apache.logging.log4j.LogManager;
import net.minecraft.block.state.IBlockState;
import java.util.Iterator;
import net.minecraft.util.ReportedException;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.crash.CrashReport;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import org.apache.logging.log4j.Logger;
import java.util.Set;
import java.util.List;
import net.minecraft.entity.EntityTracker;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.PlayerChunkMap;
import net.minecraft.village.VillageSiege;
import java.util.TreeSet;
import net.minecraft.entity.Entity;
import java.util.UUID;
import java.util.Map;
import net.minecraft.util.IThreadListener;

public class WorldServer extends World implements IThreadListener
{
    private /* synthetic */ boolean allPlayersSleeping;
    private final /* synthetic */ Map<UUID, Entity> entitiesByUuid;
    private final /* synthetic */ TreeSet<NextTickListEntry> pendingTickListEntriesTreeSet;
    protected final /* synthetic */ VillageSiege villageSiege;
    private final /* synthetic */ WorldEntitySpawner entitySpawner;
    private final /* synthetic */ ServerBlockEventList[] blockEventQueue;
    private final /* synthetic */ PlayerChunkMap thePlayerManager;
    private final /* synthetic */ MinecraftServer mcServer;
    private final /* synthetic */ EntityTracker theEntityTracker;
    private final /* synthetic */ Teleporter worldTeleporter;
    private /* synthetic */ int updateEntityTick;
    private final /* synthetic */ List<NextTickListEntry> pendingTickListEntriesThisTick;
    private final /* synthetic */ Set<NextTickListEntry> pendingTickListEntriesHashSet;
    private /* synthetic */ int blockEventCacheIndex;
    private static final /* synthetic */ Logger LOGGER;
    
    @Override
    public boolean tickUpdates(final boolean llllllllllIllllIlllIllIllllIlllI) {
        if (this.worldInfo.getTerrainType() == WorldType.DEBUG_WORLD) {
            return false;
        }
        int llllllllllIllllIlllIllIllllllIIl = this.pendingTickListEntriesTreeSet.size();
        if (llllllllllIllllIlllIllIllllllIIl != this.pendingTickListEntriesHashSet.size()) {
            throw new IllegalStateException("TickNextTick list out of synch");
        }
        if (llllllllllIllllIlllIllIllllllIIl > 65536) {
            llllllllllIllllIlllIllIllllllIIl = 65536;
        }
        this.theProfiler.startSection("cleaning");
        for (int llllllllllIllllIlllIllIllllllIII = 0; llllllllllIllllIlllIllIllllllIII < llllllllllIllllIlllIllIllllllIIl; ++llllllllllIllllIlllIllIllllllIII) {
            final NextTickListEntry llllllllllIllllIlllIllIlllllIlll = this.pendingTickListEntriesTreeSet.first();
            if (!llllllllllIllllIlllIllIllllIlllI && llllllllllIllllIlllIllIlllllIlll.scheduledTime > this.worldInfo.getWorldTotalTime()) {
                break;
            }
            this.pendingTickListEntriesTreeSet.remove(llllllllllIllllIlllIllIlllllIlll);
            this.pendingTickListEntriesHashSet.remove(llllllllllIllllIlllIllIlllllIlll);
            this.pendingTickListEntriesThisTick.add(llllllllllIllllIlllIllIlllllIlll);
        }
        this.theProfiler.endSection();
        this.theProfiler.startSection("ticking");
        final Iterator<NextTickListEntry> llllllllllIllllIlllIllIlllllIllI = this.pendingTickListEntriesThisTick.iterator();
        while (llllllllllIllllIlllIllIlllllIllI.hasNext()) {
            final NextTickListEntry llllllllllIllllIlllIllIlllllIlIl = llllllllllIllllIlllIllIlllllIllI.next();
            llllllllllIllllIlllIllIlllllIllI.remove();
            final int llllllllllIllllIlllIllIlllllIlII = 0;
            if (this.isAreaLoaded(llllllllllIllllIlllIllIlllllIlIl.position.add(0, 0, 0), llllllllllIllllIlllIllIlllllIlIl.position.add(0, 0, 0))) {
                final IBlockState llllllllllIllllIlllIllIlllllIIll = this.getBlockState(llllllllllIllllIlllIllIlllllIlIl.position);
                if (llllllllllIllllIlllIllIlllllIIll.getMaterial() == Material.AIR || !Block.isEqualTo(llllllllllIllllIlllIllIlllllIIll.getBlock(), llllllllllIllllIlllIllIlllllIlIl.getBlock())) {
                    continue;
                }
                try {
                    llllllllllIllllIlllIllIlllllIIll.getBlock().updateTick(this, llllllllllIllllIlllIllIlllllIlIl.position, llllllllllIllllIlllIllIlllllIIll, this.rand);
                    continue;
                }
                catch (Throwable llllllllllIllllIlllIllIlllllIIlI) {
                    final CrashReport llllllllllIllllIlllIllIlllllIIIl = CrashReport.makeCrashReport(llllllllllIllllIlllIllIlllllIIlI, "Exception while ticking a block");
                    final CrashReportCategory llllllllllIllllIlllIllIlllllIIII = llllllllllIllllIlllIllIlllllIIIl.makeCategory("Block being ticked");
                    CrashReportCategory.addBlockInfo(llllllllllIllllIlllIllIlllllIIII, llllllllllIllllIlllIllIlllllIlIl.position, llllllllllIllllIlllIllIlllllIIll);
                    throw new ReportedException(llllllllllIllllIlllIllIlllllIIIl);
                }
            }
            this.scheduleUpdate(llllllllllIllllIlllIllIlllllIlIl.position, llllllllllIllllIlllIllIlllllIlIl.getBlock(), 0);
        }
        this.theProfiler.endSection();
        this.pendingTickListEntriesThisTick.clear();
        return !this.pendingTickListEntriesTreeSet.isEmpty();
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    @Override
    public boolean isBlockTickPending(final BlockPos llllllllllIllllIlllIlllIIllIlIII, final Block llllllllllIllllIlllIlllIIllIIlll) {
        final NextTickListEntry llllllllllIllllIlllIlllIIllIlIlI = new NextTickListEntry(llllllllllIllllIlllIlllIIllIlIII, llllllllllIllllIlllIlllIIllIIlll);
        return this.pendingTickListEntriesThisTick.contains(llllllllllIllllIlllIlllIIllIlIlI);
    }
    
    public void flush() {
        this.saveHandler.flush();
    }
    
    protected void playerCheckLight() {
        this.theProfiler.startSection("playerCheckLight");
        if (!this.playerEntities.isEmpty()) {
            final int llllllllllIllllIlllIlllIllIIlIIl = this.rand.nextInt(this.playerEntities.size());
            final EntityPlayer llllllllllIllllIlllIlllIllIIlIII = this.playerEntities.get(llllllllllIllllIlllIlllIllIIlIIl);
            final int llllllllllIllllIlllIlllIllIIIlll = MathHelper.floor(llllllllllIllllIlllIlllIllIIlIII.posX) + this.rand.nextInt(11) - 5;
            final int llllllllllIllllIlllIlllIllIIIllI = MathHelper.floor(llllllllllIllllIlllIlllIllIIlIII.posY) + this.rand.nextInt(11) - 5;
            final int llllllllllIllllIlllIlllIllIIIlIl = MathHelper.floor(llllllllllIllllIlllIlllIllIIlIII.posZ) + this.rand.nextInt(11) - 5;
            this.checkLight(new BlockPos(llllllllllIllllIlllIlllIllIIIlll, llllllllllIllllIlllIlllIllIIIllI, llllllllllIllllIlllIlllIllIIIlIl));
        }
        this.theProfiler.endSection();
    }
    
    public void saveChunkData() {
        final ChunkProviderServer llllllllllIllllIlllIllIlIIlllllI = this.getChunkProvider();
        if (llllllllllIllllIlllIllIlIIlllllI.canSave()) {
            llllllllllIllllIlllIllIlIIlllllI.saveExtraData();
        }
    }
    
    public Teleporter getDefaultTeleporter() {
        return this.worldTeleporter;
    }
    
    private void resetRainAndThunder() {
        this.worldInfo.setRainTime(0);
        this.worldInfo.setRaining(false);
        this.worldInfo.setThunderTime(0);
        this.worldInfo.setThundering(false);
    }
    
    @Override
    public ChunkProviderServer getChunkProvider() {
        return (ChunkProviderServer)super.getChunkProvider();
    }
    
    @Nullable
    public Biome.SpawnListEntry getSpawnListEntryForTypeAt(final EnumCreatureType llllllllllIllllIlllIllllIIIllIIl, final BlockPos llllllllllIllllIlllIllllIIIllIII) {
        final List<Biome.SpawnListEntry> llllllllllIllllIlllIllllIIIllIll = this.getChunkProvider().getPossibleCreatures(llllllllllIllllIlllIllllIIIllIIl, llllllllllIllllIlllIllllIIIllIII);
        return (llllllllllIllllIlllIllllIIIllIll != null && !llllllllllIllllIlllIllllIIIllIll.isEmpty()) ? WeightedRandom.getRandomItem(this.rand, llllllllllIllllIlllIllllIIIllIll) : null;
    }
    
    @Override
    public boolean isUpdateScheduled(final BlockPos llllllllllIllllIlllIlllIIlIlllII, final Block llllllllllIllllIlllIlllIIlIlllll) {
        final NextTickListEntry llllllllllIllllIlllIlllIIlIllllI = new NextTickListEntry(llllllllllIllllIlllIlllIIlIlllII, llllllllllIllllIlllIlllIIlIlllll);
        return this.pendingTickListEntriesHashSet.contains(llllllllllIllllIlllIlllIIlIllllI);
    }
    
    @Override
    public void addBlockEvent(final BlockPos llllllllllIllllIlllIllIIlIllIIll, final Block llllllllllIllllIlllIllIIlIlIlIll, final int llllllllllIllllIlllIllIIlIlIlIlI, final int llllllllllIllllIlllIllIIlIllIIII) {
        final BlockEventData llllllllllIllllIlllIllIIlIlIllll = new BlockEventData(llllllllllIllllIlllIllIIlIllIIll, llllllllllIllllIlllIllIIlIlIlIll, llllllllllIllllIlllIllIIlIlIlIlI, llllllllllIllllIlllIllIIlIllIIII);
        for (final BlockEventData llllllllllIllllIlllIllIIlIlIlllI : this.blockEventQueue[this.blockEventCacheIndex]) {
            if (llllllllllIllllIlllIllIIlIlIlllI.equals(llllllllllIllllIlllIllIIlIlIllll)) {
                return;
            }
        }
        this.blockEventQueue[this.blockEventCacheIndex].add(llllllllllIllllIlllIllIIlIlIllll);
    }
    
    @Override
    protected void tickPlayers() {
        super.tickPlayers();
        this.theProfiler.endStartSection("players");
        for (int llllllllllIllllIlllIlllIIIIlIlll = 0; llllllllllIllllIlllIlllIIIIlIlll < this.playerEntities.size(); ++llllllllllIllllIlllIlllIIIIlIlll) {
            final Entity llllllllllIllllIlllIlllIIIIlIllI = this.playerEntities.get(llllllllllIllllIlllIlllIIIIlIlll);
            final Entity llllllllllIllllIlllIlllIIIIlIlIl = llllllllllIllllIlllIlllIIIIlIllI.getRidingEntity();
            if (llllllllllIllllIlllIlllIIIIlIlIl != null) {
                if (!llllllllllIllllIlllIlllIIIIlIlIl.isDead && llllllllllIllllIlllIlllIIIIlIlIl.isPassenger(llllllllllIllllIlllIlllIIIIlIllI)) {
                    continue;
                }
                llllllllllIllllIlllIlllIIIIlIllI.dismountRidingEntity();
            }
            this.theProfiler.startSection("tick");
            if (!llllllllllIllllIlllIlllIIIIlIllI.isDead) {
                try {
                    this.updateEntity(llllllllllIllllIlllIlllIIIIlIllI);
                }
                catch (Throwable llllllllllIllllIlllIlllIIIIlIlII) {
                    final CrashReport llllllllllIllllIlllIlllIIIIlIIll = CrashReport.makeCrashReport(llllllllllIllllIlllIlllIIIIlIlII, "Ticking player");
                    final CrashReportCategory llllllllllIllllIlllIlllIIIIlIIlI = llllllllllIllllIlllIlllIIIIlIIll.makeCategory("Player being ticked");
                    llllllllllIllllIlllIlllIIIIlIllI.addEntityCrashInfo(llllllllllIllllIlllIlllIIIIlIIlI);
                    throw new ReportedException(llllllllllIllllIlllIlllIIIIlIIll);
                }
            }
            this.theProfiler.endSection();
            this.theProfiler.startSection("remove");
            if (llllllllllIllllIlllIlllIIIIlIllI.isDead) {
                final int llllllllllIllllIlllIlllIIIIlIIIl = llllllllllIllllIlllIlllIIIIlIllI.chunkCoordX;
                final int llllllllllIllllIlllIlllIIIIlIIII = llllllllllIllllIlllIlllIIIIlIllI.chunkCoordZ;
                if (llllllllllIllllIlllIlllIIIIlIllI.addedToChunk && this.isChunkLoaded(llllllllllIllllIlllIlllIIIIlIIIl, llllllllllIllllIlllIlllIIIIlIIII, true)) {
                    this.getChunkFromChunkCoords(llllllllllIllllIlllIlllIIIIlIIIl, llllllllllIllllIlllIlllIIIIlIIII).removeEntity(llllllllllIllllIlllIlllIIIIlIllI);
                }
                this.loadedEntityList.remove(llllllllllIllllIlllIlllIIIIlIllI);
                this.onEntityRemoved(llllllllllIllllIlllIlllIIIIlIllI);
            }
            this.theProfiler.endSection();
        }
    }
    
    @Nullable
    @Override
    public MinecraftServer getMinecraftServer() {
        return this.mcServer;
    }
    
    @Override
    public void scheduleBlockUpdate(final BlockPos llllllllllIllllIlllIlllIIIlIlIII, final Block llllllllllIllllIlllIlllIIIlIlllI, final int llllllllllIllllIlllIlllIIIlIllIl, final int llllllllllIllllIlllIlllIIIlIllII) {
        final NextTickListEntry llllllllllIllllIlllIlllIIIlIlIll = new NextTickListEntry(llllllllllIllllIlllIlllIIIlIlIII, llllllllllIllllIlllIlllIIIlIlllI);
        llllllllllIllllIlllIlllIIIlIlIll.setPriority(llllllllllIllllIlllIlllIIIlIllII);
        final Material llllllllllIllllIlllIlllIIIlIlIlI = llllllllllIllllIlllIlllIIIlIlllI.getDefaultState().getMaterial();
        if (llllllllllIllllIlllIlllIIIlIlIlI != Material.AIR) {
            llllllllllIllllIlllIlllIIIlIlIll.setScheduledTime(llllllllllIllllIlllIlllIIIlIllIl + this.worldInfo.getWorldTotalTime());
        }
        if (!this.pendingTickListEntriesHashSet.contains(llllllllllIllllIlllIlllIIIlIlIll)) {
            this.pendingTickListEntriesHashSet.add(llllllllllIllllIlllIlllIIIlIlIll);
            this.pendingTickListEntriesTreeSet.add(llllllllllIllllIlllIlllIIIlIlIll);
        }
    }
    
    @Override
    public boolean addWeatherEffect(final Entity llllllllllIllllIlllIllIIlllIlIIl) {
        if (super.addWeatherEffect(llllllllllIllllIlllIllIIlllIlIIl)) {
            this.mcServer.getPlayerList().sendToAllNearExcept(null, llllllllllIllllIlllIllIIlllIlIIl.posX, llllllllllIllllIlllIllIIlllIlIIl.posY, llllllllllIllllIlllIllIIlllIlIIl.posZ, 512.0, this.provider.getDimensionType().getId(), new SPacketSpawnGlobalEntity(llllllllllIllllIlllIllIIlllIlIIl));
            return true;
        }
        return false;
    }
    
    @Override
    protected void updateWeather() {
        final boolean llllllllllIllllIlllIllIIlIIIlIll = this.isRaining();
        super.updateWeather();
        if (this.prevRainingStrength != this.rainingStrength) {
            this.mcServer.getPlayerList().sendPacketToAllPlayersInDimension(new SPacketChangeGameState(7, this.rainingStrength), this.provider.getDimensionType().getId());
        }
        if (this.prevThunderingStrength != this.thunderingStrength) {
            this.mcServer.getPlayerList().sendPacketToAllPlayersInDimension(new SPacketChangeGameState(8, this.thunderingStrength), this.provider.getDimensionType().getId());
        }
        if (llllllllllIllllIlllIllIIlIIIlIll != this.isRaining()) {
            if (llllllllllIllllIlllIllIIlIIIlIll) {
                this.mcServer.getPlayerList().sendPacketToAllPlayers(new SPacketChangeGameState(2, 0.0f));
            }
            else {
                this.mcServer.getPlayerList().sendPacketToAllPlayers(new SPacketChangeGameState(1, 0.0f));
            }
            this.mcServer.getPlayerList().sendPacketToAllPlayers(new SPacketChangeGameState(7, this.rainingStrength));
            this.mcServer.getPlayerList().sendPacketToAllPlayers(new SPacketChangeGameState(8, this.thunderingStrength));
        }
    }
    
    protected void wakeAllPlayers() {
        this.allPlayersSleeping = false;
        for (final EntityPlayer llllllllllIllllIlllIlllIllllIlIl : this.playerEntities.stream().filter(EntityPlayer::isPlayerSleeping).collect((Collector<? super Object, ?, List<? super Object>>)Collectors.toList())) {
            llllllllllIllllIlllIlllIllllIlIl.wakeUpPlayer(false, false, true);
        }
        if (this.getGameRules().getBoolean("doWeatherCycle")) {
            this.resetRainAndThunder();
        }
    }
    
    private void sendPacketWithinDistance(final EntityPlayerMP llllllllllIllllIlllIlIllllllIIII, final boolean llllllllllIllllIlllIlIllllllIlll, final double llllllllllIllllIlllIlIlllllIlllI, final double llllllllllIllllIlllIlIlllllIllIl, final double llllllllllIllllIlllIlIlllllIllII, final Packet<?> llllllllllIllllIlllIlIlllllIlIll) {
        final BlockPos llllllllllIllllIlllIlIllllllIIlI = llllllllllIllllIlllIlIllllllIIII.getPosition();
        final double llllllllllIllllIlllIlIllllllIIIl = llllllllllIllllIlllIlIllllllIIlI.distanceSq(llllllllllIllllIlllIlIlllllIlllI, llllllllllIllllIlllIlIlllllIllIl, llllllllllIllllIlllIlIlllllIllII);
        if (llllllllllIllllIlllIlIllllllIIIl <= 1024.0 || (llllllllllIllllIlllIlIllllllIlll && llllllllllIllllIlllIlIllllllIIIl <= 262144.0)) {
            llllllllllIllllIlllIlIllllllIIII.connection.sendPacket(llllllllllIllllIlllIlIlllllIlIll);
        }
    }
    
    @Nullable
    public BlockPos getSpawnCoordinate() {
        return this.provider.getSpawnCoordinate();
    }
    
    @Override
    public World init() {
        this.mapStorage = new MapStorage(this.saveHandler);
        final String llllllllllIllllIlllIllllIIllIIII = VillageCollection.fileNameForProvider(this.provider);
        final VillageCollection llllllllllIllllIlllIllllIIlIllll = (VillageCollection)this.mapStorage.getOrLoadData(VillageCollection.class, llllllllllIllllIlllIllllIIllIIII);
        if (llllllllllIllllIlllIllllIIlIllll == null) {
            this.villageCollectionObj = new VillageCollection(this);
            this.mapStorage.setData(llllllllllIllllIlllIllllIIllIIII, this.villageCollectionObj);
        }
        else {
            this.villageCollectionObj = llllllllllIllllIlllIllllIIlIllll;
            this.villageCollectionObj.setWorldsForAll(this);
        }
        this.worldScoreboard = new ServerScoreboard(this.mcServer);
        ScoreboardSaveData llllllllllIllllIlllIllllIIlIlllI = (ScoreboardSaveData)this.mapStorage.getOrLoadData(ScoreboardSaveData.class, "scoreboard");
        if (llllllllllIllllIlllIllllIIlIlllI == null) {
            llllllllllIllllIlllIllllIIlIlllI = new ScoreboardSaveData();
            this.mapStorage.setData("scoreboard", llllllllllIllllIlllIllllIIlIlllI);
        }
        llllllllllIllllIlllIllllIIlIlllI.setScoreboard(this.worldScoreboard);
        ((ServerScoreboard)this.worldScoreboard).addDirtyRunnable(new WorldSavedDataCallableSave(llllllllllIllllIlllIllllIIlIlllI));
        this.lootTable = new LootTableManager(new File(new File(this.saveHandler.getWorldDirectory(), "data"), "loot_tables"));
        this.field_191951_C = new AdvancementManager(new File(new File(this.saveHandler.getWorldDirectory(), "data"), "advancements"));
        this.field_193036_D = new FunctionManager(new File(new File(this.saveHandler.getWorldDirectory(), "data"), "functions"), this.mcServer);
        this.getWorldBorder().setCenter(this.worldInfo.getBorderCenterX(), this.worldInfo.getBorderCenterZ());
        this.getWorldBorder().setDamageAmount(this.worldInfo.getBorderDamagePerBlock());
        this.getWorldBorder().setDamageBuffer(this.worldInfo.getBorderSafeZone());
        this.getWorldBorder().setWarningDistance(this.worldInfo.getBorderWarningDistance());
        this.getWorldBorder().setWarningTime(this.worldInfo.getBorderWarningTime());
        if (this.worldInfo.getBorderLerpTime() > 0L) {
            this.getWorldBorder().setTransition(this.worldInfo.getBorderSize(), this.worldInfo.getBorderLerpTarget(), this.worldInfo.getBorderLerpTime());
        }
        else {
            this.getWorldBorder().setTransition(this.worldInfo.getBorderSize());
        }
        return this;
    }
    
    @Override
    public void setEntityState(final Entity llllllllllIllllIlllIllIIlllIIIIl, final byte llllllllllIllllIlllIllIIlllIIIII) {
        this.getEntityTracker().sendToTrackingAndSelf(llllllllllIllllIlllIllIIlllIIIIl, new SPacketEntityStatus(llllllllllIllllIlllIllIIlllIIIIl, llllllllllIllllIlllIllIIlllIIIII));
    }
    
    @Override
    public void setInitialSpawnLocation() {
        if (this.worldInfo.getSpawnY() <= 0) {
            this.worldInfo.setSpawnY(this.getSeaLevel() + 1);
        }
        int llllllllllIllllIlllIlllIlllIIIIl = this.worldInfo.getSpawnX();
        int llllllllllIllllIlllIlllIlllIIIII = this.worldInfo.getSpawnZ();
        int llllllllllIllllIlllIlllIllIlllll = 0;
        while (this.getGroundAboveSeaLevel(new BlockPos(llllllllllIllllIlllIlllIlllIIIIl, 0, llllllllllIllllIlllIlllIlllIIIII)).getMaterial() == Material.AIR) {
            llllllllllIllllIlllIlllIlllIIIIl += this.rand.nextInt(8) - this.rand.nextInt(8);
            llllllllllIllllIlllIlllIlllIIIII += this.rand.nextInt(8) - this.rand.nextInt(8);
            if (++llllllllllIllllIlllIlllIllIlllll == 10000) {
                break;
            }
        }
        this.worldInfo.setSpawnX(llllllllllIllllIlllIlllIlllIIIIl);
        this.worldInfo.setSpawnZ(llllllllllIllllIlllIlllIlllIIIII);
    }
    
    @Override
    public boolean isCallingFromMinecraftThread() {
        return this.mcServer.isCallingFromMinecraftThread();
    }
    
    @Override
    public void initialize(final WorldSettings llllllllllIllllIlllIllIllIIIllII) {
        if (!this.worldInfo.isInitialized()) {
            try {
                this.createSpawnPosition(llllllllllIllllIlllIllIllIIIllII);
                if (this.worldInfo.getTerrainType() == WorldType.DEBUG_WORLD) {
                    this.setDebugWorldSettings();
                }
                super.initialize(llllllllllIllllIlllIllIllIIIllII);
            }
            catch (Throwable llllllllllIllllIlllIllIllIIIllll) {
                final CrashReport llllllllllIllllIlllIllIllIIIlllI = CrashReport.makeCrashReport(llllllllllIllllIlllIllIllIIIllll, "Exception initializing level");
                try {
                    this.addWorldInfoToCrashReport(llllllllllIllllIlllIllIllIIIlllI);
                }
                catch (Throwable t) {}
                throw new ReportedException(llllllllllIllllIlllIllIllIIIlllI);
            }
            this.worldInfo.setServerInitialized(true);
        }
    }
    
    @Override
    protected IChunkProvider createChunkProvider() {
        final IChunkLoader llllllllllIllllIlllIllIllIlIIIlI = this.saveHandler.getChunkLoader(this.provider);
        return new ChunkProviderServer(this, llllllllllIllllIlllIllIllIlIIIlI, this.provider.createChunkGenerator());
    }
    
    protected BlockPos adjustPosToNearbyEntity(final BlockPos llllllllllIllllIlllIlllIIlllIlIl) {
        BlockPos llllllllllIllllIlllIlllIIllllIIl = this.getPrecipitationHeight(llllllllllIllllIlllIlllIIlllIlIl);
        final AxisAlignedBB llllllllllIllllIlllIlllIIllllIII = new AxisAlignedBB(llllllllllIllllIlllIlllIIllllIIl, new BlockPos(llllllllllIllllIlllIlllIIllllIIl.getX(), this.getHeight(), llllllllllIllllIlllIlllIIllllIIl.getZ())).expandXyz(3.0);
        final List<EntityLivingBase> llllllllllIllllIlllIlllIIlllIlll = this.getEntitiesWithinAABB((Class<? extends EntityLivingBase>)EntityLivingBase.class, llllllllllIllllIlllIlllIIllllIII, (com.google.common.base.Predicate<? super EntityLivingBase>)new Predicate<EntityLivingBase>() {
            public boolean apply(@Nullable final EntityLivingBase llllllllllllllIIllIlIlllIIlIIIII) {
                return llllllllllllllIIllIlIlllIIlIIIII != null && llllllllllllllIIllIlIlllIIlIIIII.isEntityAlive() && WorldServer.this.canSeeSky(llllllllllllllIIllIlIlllIIlIIIII.getPosition());
            }
        });
        if (!llllllllllIllllIlllIlllIIlllIlll.isEmpty()) {
            return llllllllllIllllIlllIlllIIlllIlll.get(this.rand.nextInt(llllllllllIllllIlllIlllIIlllIlll.size())).getPosition();
        }
        if (llllllllllIllllIlllIlllIIllllIIl.getY() == -1) {
            llllllllllIllllIlllIlllIIllllIIl = llllllllllIllllIlllIlllIIllllIIl.up(2);
        }
        return llllllllllIllllIlllIlllIIllllIIl;
    }
    
    private boolean fireBlockEvent(final BlockEventData llllllllllIllllIlllIllIIlIIlIIll) {
        final IBlockState llllllllllIllllIlllIllIIlIIlIlIl = this.getBlockState(llllllllllIllllIlllIllIIlIIlIIll.getPosition());
        return llllllllllIllllIlllIllIIlIIlIlIl.getBlock() == llllllllllIllllIlllIllIIlIIlIIll.getBlock() && llllllllllIllllIlllIllIIlIIlIlIl.onBlockEventReceived(this, llllllllllIllllIlllIllIIlIIlIIll.getPosition(), llllllllllIllllIlllIllIIlIIlIIll.getEventID(), llllllllllIllllIlllIllIIlIIlIIll.getEventParameter());
    }
    
    public boolean canCreatureTypeSpawnHere(final EnumCreatureType llllllllllIllllIlllIllllIIIlIIII, final Biome.SpawnListEntry llllllllllIllllIlllIllllIIIIlIlI, final BlockPos llllllllllIllllIlllIllllIIIIlIIl) {
        final List<Biome.SpawnListEntry> llllllllllIllllIlllIllllIIIIllIl = this.getChunkProvider().getPossibleCreatures(llllllllllIllllIlllIllllIIIlIIII, llllllllllIllllIlllIllllIIIIlIIl);
        return llllllllllIllllIlllIllllIIIIllIl != null && !llllllllllIllllIlllIllllIIIIllIl.isEmpty() && llllllllllIllllIlllIllllIIIIllIl.contains(llllllllllIllllIlllIllllIIIIlIlI);
    }
    
    @Override
    protected void onEntityRemoved(final Entity llllllllllIllllIlllIllIIllllIlII) {
        super.onEntityRemoved(llllllllllIllllIlllIllIIllllIlII);
        this.entitiesById.removeObject(llllllllllIllllIlllIllIIllllIlII.getEntityId());
        this.entitiesByUuid.remove(llllllllllIllllIlllIllIIllllIlII.getUniqueID());
        final Entity[] llllllllllIllllIlllIllIIllllIlll = llllllllllIllllIlllIllIIllllIlII.getParts();
        if (llllllllllIllllIlllIllIIllllIlll != null) {
            final Exception llllllllllIllllIlllIllIIlllIllll;
            final short llllllllllIllllIlllIllIIllllIIII = (short)((Entity[])(Object)(llllllllllIllllIlllIllIIlllIllll = (Exception)(Object)llllllllllIllllIlllIllIIllllIlll)).length;
            for (final Entity llllllllllIllllIlllIllIIllllIllI : llllllllllIllllIlllIllIIlllIllll) {
                this.entitiesById.removeObject(llllllllllIllllIlllIllIIllllIllI.getEntityId());
            }
        }
    }
    
    public void resetUpdateEntityTick() {
        this.updateEntityTick = 0;
    }
    
    @Nullable
    @Override
    public BlockPos func_190528_a(final String llllllllllIllllIlllIlIllllIlIIII, final BlockPos llllllllllIllllIlllIlIllllIIllll, final boolean llllllllllIllllIlllIlIllllIIlllI) {
        return this.getChunkProvider().getStrongholdGen(this, llllllllllIllllIlllIlIllllIlIIII, llllllllllIllllIlllIlIllllIIllll, llllllllllIllllIlllIlIllllIIlllI);
    }
    
    private boolean canAddEntity(final Entity llllllllllIllllIlllIllIlIIIllIIl) {
        if (llllllllllIllllIlllIllIlIIIllIIl.isDead) {
            WorldServer.LOGGER.warn("Tried to add entity {} but it was marked as removed already", (Object)EntityList.func_191301_a(llllllllllIllllIlllIllIlIIIllIIl));
            return false;
        }
        final UUID llllllllllIllllIlllIllIlIIIllIII = llllllllllIllllIlllIllIlIIIllIIl.getUniqueID();
        if (this.entitiesByUuid.containsKey(llllllllllIllllIlllIllIlIIIllIII)) {
            final Entity llllllllllIllllIlllIllIlIIIlIlll = this.entitiesByUuid.get(llllllllllIllllIlllIllIlIIIllIII);
            if (this.unloadedEntityList.contains(llllllllllIllllIlllIllIlIIIlIlll)) {
                this.unloadedEntityList.remove(llllllllllIllllIlllIllIlIIIlIlll);
            }
            else {
                if (!(llllllllllIllllIlllIllIlIIIllIIl instanceof EntityPlayer)) {
                    WorldServer.LOGGER.warn("Keeping entity {} that already exists with UUID {}", (Object)EntityList.func_191301_a(llllllllllIllllIlllIllIlIIIlIlll), (Object)llllllllllIllllIlllIllIlIIIllIII.toString());
                    return false;
                }
                WorldServer.LOGGER.warn("Force-added player with duplicate UUID {}", (Object)llllllllllIllllIlllIllIlIIIllIII.toString());
            }
            this.removeEntityDangerously(llllllllllIllllIlllIllIlIIIlIlll);
        }
        return true;
    }
    
    public FunctionManager func_193037_A() {
        return this.field_193036_D;
    }
    
    public void spawnParticle(final EnumParticleTypes llllllllllIllllIlllIllIIIlIIlIII, final boolean llllllllllIllllIlllIllIIIlIIIlll, final double llllllllllIllllIlllIllIIIIllIlll, final double llllllllllIllllIlllIllIIIlIIIlIl, final double llllllllllIllllIlllIllIIIlIIIlII, final int llllllllllIllllIlllIllIIIlIIIIll, final double llllllllllIllllIlllIllIIIIllIIll, final double llllllllllIllllIlllIllIIIlIIIIIl, final double llllllllllIllllIlllIllIIIlIIIIII, final double llllllllllIllllIlllIllIIIIllllll, final int... llllllllllIllllIlllIllIIIIlllllI) {
        final SPacketParticles llllllllllIllllIlllIllIIIIllllIl = new SPacketParticles(llllllllllIllllIlllIllIIIlIIlIII, llllllllllIllllIlllIllIIIlIIIlll, (float)llllllllllIllllIlllIllIIIIllIlll, (float)llllllllllIllllIlllIllIIIlIIIlIl, (float)llllllllllIllllIlllIllIIIlIIIlII, (float)llllllllllIllllIlllIllIIIIllIIll, (float)llllllllllIllllIlllIllIIIlIIIIIl, (float)llllllllllIllllIlllIllIIIlIIIIII, (float)llllllllllIllllIlllIllIIIIllllll, llllllllllIllllIlllIllIIIlIIIIll, llllllllllIllllIlllIllIIIIlllllI);
        for (int llllllllllIllllIlllIllIIIIllllII = 0; llllllllllIllllIlllIllIIIIllllII < this.playerEntities.size(); ++llllllllllIllllIlllIllIIIIllllII) {
            final EntityPlayerMP llllllllllIllllIlllIllIIIIlllIll = this.playerEntities.get(llllllllllIllllIlllIllIIIIllllII);
            this.sendPacketWithinDistance(llllllllllIllllIlllIllIIIIlllIll, llllllllllIllllIlllIllIIIlIIIlll, llllllllllIllllIlllIllIIIIllIlll, llllllllllIllllIlllIllIIIlIIIlIl, llllllllllIllllIlllIllIIIlIIIlII, llllllllllIllllIlllIllIIIIllllIl);
        }
    }
    
    @Override
    public void updateEntities() {
        if (this.playerEntities.isEmpty()) {
            if (this.updateEntityTick++ >= 300) {
                return;
            }
        }
        else {
            this.resetUpdateEntityTick();
        }
        this.provider.onWorldUpdateEntities();
        super.updateEntities();
    }
    
    public AdvancementManager func_191952_z() {
        return this.field_191951_C;
    }
    
    private boolean canSpawnAnimals() {
        return this.mcServer.getCanSpawnAnimals();
    }
    
    public void spawnParticle(final EnumParticleTypes llllllllllIllllIlllIllIIIllIIIlI, final double llllllllllIllllIlllIllIIIllIllII, final double llllllllllIllllIlllIllIIIllIlIll, final double llllllllllIllllIlllIllIIIlIllllI, final int llllllllllIllllIlllIllIIIlIlllIl, final double llllllllllIllllIlllIllIIIlIlllII, final double llllllllllIllllIlllIllIIIlIllIll, final double llllllllllIllllIlllIllIIIlIllIlI, final double llllllllllIllllIlllIllIIIllIIlIl, final int... llllllllllIllllIlllIllIIIllIIlII) {
        this.spawnParticle(llllllllllIllllIlllIllIIIllIIIlI, false, llllllllllIllllIlllIllIIIllIllII, llllllllllIllllIlllIllIIIllIlIll, llllllllllIllllIlllIllIIIlIllllI, llllllllllIllllIlllIllIIIlIlllIl, llllllllllIllllIlllIllIIIlIlllII, llllllllllIllllIlllIllIIIlIllIll, llllllllllIllllIlllIllIIIlIllIlI, llllllllllIllllIlllIllIIIllIIlIl, llllllllllIllllIlllIllIIIllIIlII);
    }
    
    public PlayerChunkMap getPlayerChunkMap() {
        return this.thePlayerManager;
    }
    
    @Override
    protected void updateBlocks() {
        this.playerCheckLight();
        if (this.worldInfo.getTerrainType() == WorldType.DEBUG_WORLD) {
            final Iterator<Chunk> llllllllllIllllIlllIlllIlIlIlIlI = this.thePlayerManager.getChunkIterator();
            while (llllllllllIllllIlllIlllIlIlIlIlI.hasNext()) {
                llllllllllIllllIlllIlllIlIlIlIlI.next().onTick(false);
            }
        }
        else {
            final int llllllllllIllllIlllIlllIlIlIlIIl = this.getGameRules().getInt("randomTickSpeed");
            final boolean llllllllllIllllIlllIlllIlIlIlIII = this.isRaining();
            final boolean llllllllllIllllIlllIlllIlIlIIlll = this.isThundering();
            this.theProfiler.startSection("pollingChunks");
            final Iterator<Chunk> llllllllllIllllIlllIlllIlIlIIllI = this.thePlayerManager.getChunkIterator();
            while (llllllllllIllllIlllIlllIlIlIIllI.hasNext()) {
                this.theProfiler.startSection("getChunk");
                final Chunk llllllllllIllllIlllIlllIlIlIIlIl = llllllllllIllllIlllIlllIlIlIIllI.next();
                final int llllllllllIllllIlllIlllIlIlIIlII = llllllllllIllllIlllIlllIlIlIIlIl.xPosition * 16;
                final int llllllllllIllllIlllIlllIlIlIIIll = llllllllllIllllIlllIlllIlIlIIlIl.zPosition * 16;
                this.theProfiler.endStartSection("checkNextLight");
                llllllllllIllllIlllIlllIlIlIIlIl.enqueueRelightChecks();
                this.theProfiler.endStartSection("tickChunk");
                llllllllllIllllIlllIlllIlIlIIlIl.onTick(false);
                this.theProfiler.endStartSection("thunder");
                if (llllllllllIllllIlllIlllIlIlIlIII && llllllllllIllllIlllIlllIlIlIIlll && this.rand.nextInt(100000) == 0) {
                    this.updateLCG = this.updateLCG * 3 + 1013904223;
                    final int llllllllllIllllIlllIlllIlIlIIIlI = this.updateLCG >> 2;
                    final BlockPos llllllllllIllllIlllIlllIlIlIIIIl = this.adjustPosToNearbyEntity(new BlockPos(llllllllllIllllIlllIlllIlIlIIlII + (llllllllllIllllIlllIlllIlIlIIIlI & 0xF), 0, llllllllllIllllIlllIlllIlIlIIIll + (llllllllllIllllIlllIlllIlIlIIIlI >> 8 & 0xF)));
                    if (this.isRainingAt(llllllllllIllllIlllIlllIlIlIIIIl)) {
                        final DifficultyInstance llllllllllIllllIlllIlllIlIlIIIII = this.getDifficultyForLocation(llllllllllIllllIlllIlllIlIlIIIIl);
                        if (this.getGameRules().getBoolean("doMobSpawning") && this.rand.nextDouble() < llllllllllIllllIlllIlllIlIlIIIII.getAdditionalDifficulty() * 0.01) {
                            final EntitySkeletonHorse llllllllllIllllIlllIlllIlIIlllll = new EntitySkeletonHorse(this);
                            llllllllllIllllIlllIlllIlIIlllll.func_190691_p(true);
                            llllllllllIllllIlllIlllIlIIlllll.setGrowingAge(0);
                            llllllllllIllllIlllIlllIlIIlllll.setPosition(llllllllllIllllIlllIlllIlIlIIIIl.getX(), llllllllllIllllIlllIlllIlIlIIIIl.getY(), llllllllllIllllIlllIlllIlIlIIIIl.getZ());
                            this.spawnEntityInWorld(llllllllllIllllIlllIlllIlIIlllll);
                            this.addWeatherEffect(new EntityLightningBolt(this, llllllllllIllllIlllIlllIlIlIIIIl.getX(), llllllllllIllllIlllIlllIlIlIIIIl.getY(), llllllllllIllllIlllIlllIlIlIIIIl.getZ(), true));
                        }
                        else {
                            this.addWeatherEffect(new EntityLightningBolt(this, llllllllllIllllIlllIlllIlIlIIIIl.getX(), llllllllllIllllIlllIlllIlIlIIIIl.getY(), llllllllllIllllIlllIlllIlIlIIIIl.getZ(), false));
                        }
                    }
                }
                this.theProfiler.endStartSection("iceandsnow");
                if (this.rand.nextInt(16) == 0) {
                    this.updateLCG = this.updateLCG * 3 + 1013904223;
                    final int llllllllllIllllIlllIlllIlIIllllI = this.updateLCG >> 2;
                    final BlockPos llllllllllIllllIlllIlllIlIIlllIl = this.getPrecipitationHeight(new BlockPos(llllllllllIllllIlllIlllIlIlIIlII + (llllllllllIllllIlllIlllIlIIllllI & 0xF), 0, llllllllllIllllIlllIlllIlIlIIIll + (llllllllllIllllIlllIlllIlIIllllI >> 8 & 0xF)));
                    final BlockPos llllllllllIllllIlllIlllIlIIlllII = llllllllllIllllIlllIlllIlIIlllIl.down();
                    if (this.canBlockFreezeNoWater(llllllllllIllllIlllIlllIlIIlllII)) {
                        this.setBlockState(llllllllllIllllIlllIlllIlIIlllII, Blocks.ICE.getDefaultState());
                    }
                    if (llllllllllIllllIlllIlllIlIlIlIII && this.canSnowAt(llllllllllIllllIlllIlllIlIIlllIl, true)) {
                        this.setBlockState(llllllllllIllllIlllIlllIlIIlllIl, Blocks.SNOW_LAYER.getDefaultState());
                    }
                    if (llllllllllIllllIlllIlllIlIlIlIII && this.getBiome(llllllllllIllllIlllIlllIlIIlllII).canRain()) {
                        this.getBlockState(llllllllllIllllIlllIlllIlIIlllII).getBlock().fillWithRain(this, llllllllllIllllIlllIlllIlIIlllII);
                    }
                }
                this.theProfiler.endStartSection("tickBlocks");
                if (llllllllllIllllIlllIlllIlIlIlIIl > 0) {
                    float llllllllllIllllIlllIlllIlIIIlIII;
                    for (int length = (llllllllllIllllIlllIlllIlIIIlIII = (float)(Object)llllllllllIllllIlllIlllIlIlIIlIl.getBlockStorageArray()).length, i = 0; i < length; ++i) {
                        final ExtendedBlockStorage llllllllllIllllIlllIlllIlIIllIll = llllllllllIllllIlllIlllIlIIIlIII[i];
                        if (llllllllllIllllIlllIlllIlIIllIll != Chunk.NULL_BLOCK_STORAGE && llllllllllIllllIlllIlllIlIIllIll.getNeedsRandomTick()) {
                            for (int llllllllllIllllIlllIlllIlIIllIlI = 0; llllllllllIllllIlllIlllIlIIllIlI < llllllllllIllllIlllIlllIlIlIlIIl; ++llllllllllIllllIlllIlllIlIIllIlI) {
                                this.updateLCG = this.updateLCG * 3 + 1013904223;
                                final int llllllllllIllllIlllIlllIlIIllIIl = this.updateLCG >> 2;
                                final int llllllllllIllllIlllIlllIlIIllIII = llllllllllIllllIlllIlllIlIIllIIl & 0xF;
                                final int llllllllllIllllIlllIlllIlIIlIlll = llllllllllIllllIlllIlllIlIIllIIl >> 8 & 0xF;
                                final int llllllllllIllllIlllIlllIlIIlIllI = llllllllllIllllIlllIlllIlIIllIIl >> 16 & 0xF;
                                final IBlockState llllllllllIllllIlllIlllIlIIlIlIl = llllllllllIllllIlllIlllIlIIllIll.get(llllllllllIllllIlllIlllIlIIllIII, llllllllllIllllIlllIlllIlIIlIllI, llllllllllIllllIlllIlllIlIIlIlll);
                                final Block llllllllllIllllIlllIlllIlIIlIlII = llllllllllIllllIlllIlllIlIIlIlIl.getBlock();
                                this.theProfiler.startSection("randomTick");
                                if (llllllllllIllllIlllIlllIlIIlIlII.getTickRandomly()) {
                                    llllllllllIllllIlllIlllIlIIlIlII.randomTick(this, new BlockPos(llllllllllIllllIlllIlllIlIIllIII + llllllllllIllllIlllIlllIlIlIIlII, llllllllllIllllIlllIlllIlIIlIllI + llllllllllIllllIlllIlllIlIIllIll.getYLocation(), llllllllllIllllIlllIlllIlIIlIlll + llllllllllIllllIlllIlllIlIlIIIll), llllllllllIllllIlllIlllIlIIlIlIl, this.rand);
                                }
                                this.theProfiler.endSection();
                            }
                        }
                    }
                }
                this.theProfiler.endSection();
            }
            this.theProfiler.endSection();
        }
    }
    
    public void saveAllChunks(final boolean llllllllllIllllIlllIllIlIlIIlIll, @Nullable final IProgressUpdate llllllllllIllllIlllIllIlIlIIIlIl) throws MinecraftException {
        final ChunkProviderServer llllllllllIllllIlllIllIlIlIIlIIl = this.getChunkProvider();
        if (llllllllllIllllIlllIllIlIlIIlIIl.canSave()) {
            if (llllllllllIllllIlllIllIlIlIIIlIl != null) {
                llllllllllIllllIlllIllIlIlIIIlIl.displaySavingString("Saving level");
            }
            this.saveLevel();
            if (llllllllllIllllIlllIllIlIlIIIlIl != null) {
                llllllllllIllllIlllIllIlIlIIIlIl.displayLoadingString("Saving chunks");
            }
            llllllllllIllllIlllIllIlIlIIlIIl.saveChunks(llllllllllIllllIlllIllIlIlIIlIll);
            for (final Chunk llllllllllIllllIlllIllIlIlIIlIII : Lists.newArrayList((Iterable)llllllllllIllllIlllIllIlIlIIlIIl.getLoadedChunks())) {
                if (llllllllllIllllIlllIllIlIlIIlIII != null && !this.thePlayerManager.contains(llllllllllIllllIlllIllIlIlIIlIII.xPosition, llllllllllIllllIlllIllIlIlIIlIII.zPosition)) {
                    llllllllllIllllIlllIllIlIlIIlIIl.unload(llllllllllIllllIlllIllIlIlIIlIII);
                }
            }
        }
    }
    
    public boolean areAllPlayersAsleep() {
        if (this.allPlayersSleeping && !this.isRemote) {
            for (final EntityPlayer llllllllllIllllIlllIlllIlllIlIlI : this.playerEntities) {
                if (!llllllllllIllllIlllIlllIlllIlIlI.isSpectator() && !llllllllllIllllIlllIlllIlllIlIlI.isPlayerFullyAsleep()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    protected void createBonusChest() {
        final WorldGeneratorBonusChest llllllllllIllllIlllIllIlIllIIIII = new WorldGeneratorBonusChest();
        for (int llllllllllIllllIlllIllIlIlIlllll = 0; llllllllllIllllIlllIllIlIlIlllll < 10; ++llllllllllIllllIlllIllIlIlIlllll) {
            final int llllllllllIllllIlllIllIlIlIllllI = this.worldInfo.getSpawnX() + this.rand.nextInt(6) - this.rand.nextInt(6);
            final int llllllllllIllllIlllIllIlIlIlllIl = this.worldInfo.getSpawnZ() + this.rand.nextInt(6) - this.rand.nextInt(6);
            final BlockPos llllllllllIllllIlllIllIlIlIlllII = this.getTopSolidOrLiquidBlock(new BlockPos(llllllllllIllllIlllIllIlIlIllllI, 0, llllllllllIllllIlllIllIlIlIlllIl)).up();
            if (llllllllllIllllIlllIllIlIllIIIII.generate(this, this.rand, llllllllllIllllIlllIllIlIlIlllII)) {
                break;
            }
        }
    }
    
    private void setDebugWorldSettings() {
        this.worldInfo.setMapFeaturesEnabled(false);
        this.worldInfo.setAllowCommands(true);
        this.worldInfo.setRaining(false);
        this.worldInfo.setThundering(false);
        this.worldInfo.setCleanWeatherTime(1000000000);
        this.worldInfo.setWorldTime(6000L);
        this.worldInfo.setGameType(GameType.SPECTATOR);
        this.worldInfo.setHardcore(false);
        this.worldInfo.setDifficulty(EnumDifficulty.PEACEFUL);
        this.worldInfo.setDifficultyLocked(true);
        this.getGameRules().setOrCreateGameRule("doDaylightCycle", "false");
    }
    
    @Override
    public boolean isBlockModifiable(final EntityPlayer llllllllllIllllIlllIllIllIIllIll, final BlockPos llllllllllIllllIlllIllIllIIllIlI) {
        return !this.mcServer.isBlockProtected(this, llllllllllIllllIlllIllIllIIllIlI, llllllllllIllllIlllIllIllIIllIll) && this.getWorldBorder().contains(llllllllllIllllIlllIllIllIIllIlI);
    }
    
    private void sendQueuedBlockEvents() {
        while (!this.blockEventQueue[this.blockEventCacheIndex].isEmpty()) {
            final int llllllllllIllllIlllIllIIlIlIIIII = this.blockEventCacheIndex;
            this.blockEventCacheIndex ^= 0x1;
            for (final BlockEventData llllllllllIllllIlllIllIIlIIlllll : this.blockEventQueue[llllllllllIllllIlllIllIIlIlIIIII]) {
                if (this.fireBlockEvent(llllllllllIllllIlllIllIIlIIlllll)) {
                    this.mcServer.getPlayerList().sendToAllNearExcept(null, llllllllllIllllIlllIllIIlIIlllll.getPosition().getX(), llllllllllIllllIlllIllIIlIIlllll.getPosition().getY(), llllllllllIllllIlllIllIIlIIlllll.getPosition().getZ(), 64.0, this.provider.getDimensionType().getId(), new SPacketBlockAction(llllllllllIllllIlllIllIIlIIlllll.getPosition(), llllllllllIllllIlllIllIIlIIlllll.getBlock(), llllllllllIllllIlllIllIIlIIlllll.getEventID(), llllllllllIllllIlllIllIIlIIlllll.getEventParameter()));
                }
            }
            this.blockEventQueue[llllllllllIllllIlllIllIIlIlIIIII].clear();
        }
    }
    
    @Override
    public void updateBlockTick(final BlockPos llllllllllIllllIlllIlllIIlIIIlIl, final Block llllllllllIllllIlllIlllIIlIIIlII, int llllllllllIllllIlllIlllIIIlllIll, final int llllllllllIllllIlllIlllIIlIIIIlI) {
        final Material llllllllllIllllIlllIlllIIlIIIIIl = llllllllllIllllIlllIlllIIlIIIlII.getDefaultState().getMaterial();
        if (this.scheduledUpdatesAreImmediate && llllllllllIllllIlllIlllIIlIIIIIl != Material.AIR) {
            if (llllllllllIllllIlllIlllIIlIIIlII.requiresUpdates()) {
                if (this.isAreaLoaded(llllllllllIllllIlllIlllIIlIIIlIl.add(-8, -8, -8), llllllllllIllllIlllIlllIIlIIIlIl.add(8, 8, 8))) {
                    final IBlockState llllllllllIllllIlllIlllIIlIIIIII = this.getBlockState(llllllllllIllllIlllIlllIIlIIIlIl);
                    if (llllllllllIllllIlllIlllIIlIIIIII.getMaterial() != Material.AIR && llllllllllIllllIlllIlllIIlIIIIII.getBlock() == llllllllllIllllIlllIlllIIlIIIlII) {
                        llllllllllIllllIlllIlllIIlIIIIII.getBlock().updateTick(this, llllllllllIllllIlllIlllIIlIIIlIl, llllllllllIllllIlllIlllIIlIIIIII, this.rand);
                    }
                }
                return;
            }
            llllllllllIllllIlllIlllIIIlllIll = 1;
        }
        final NextTickListEntry llllllllllIllllIlllIlllIIIllllll = new NextTickListEntry(llllllllllIllllIlllIlllIIlIIIlIl, llllllllllIllllIlllIlllIIlIIIlII);
        if (this.isBlockLoaded(llllllllllIllllIlllIlllIIlIIIlIl)) {
            if (llllllllllIllllIlllIlllIIlIIIIIl != Material.AIR) {
                llllllllllIllllIlllIlllIIIllllll.setScheduledTime(llllllllllIllllIlllIlllIIIlllIll + this.worldInfo.getWorldTotalTime());
                llllllllllIllllIlllIlllIIIllllll.setPriority(llllllllllIllllIlllIlllIIlIIIIlI);
            }
            if (!this.pendingTickListEntriesHashSet.contains(llllllllllIllllIlllIlllIIIllllll)) {
                this.pendingTickListEntriesHashSet.add(llllllllllIllllIlllIlllIIIllllll);
                this.pendingTickListEntriesTreeSet.add(llllllllllIllllIlllIlllIIIllllll);
            }
        }
    }
    
    public TemplateManager getStructureTemplateManager() {
        return this.saveHandler.getStructureTemplateManager();
    }
    
    @Nullable
    @Override
    public List<NextTickListEntry> getPendingBlockUpdates(final Chunk llllllllllIllllIlllIllIlllIlllII, final boolean llllllllllIllllIlllIllIlllIllIll) {
        final ChunkPos llllllllllIllllIlllIllIlllIllIlI = llllllllllIllllIlllIllIlllIlllII.getChunkCoordIntPair();
        final int llllllllllIllllIlllIllIlllIllIIl = (llllllllllIllllIlllIllIlllIllIlI.chunkXPos << 4) - 2;
        final int llllllllllIllllIlllIllIlllIllIII = llllllllllIllllIlllIllIlllIllIIl + 16 + 2;
        final int llllllllllIllllIlllIllIlllIlIlll = (llllllllllIllllIlllIllIlllIllIlI.chunkZPos << 4) - 2;
        final int llllllllllIllllIlllIllIlllIlIllI = llllllllllIllllIlllIllIlllIlIlll + 16 + 2;
        return this.getPendingBlockUpdates(new StructureBoundingBox(llllllllllIllllIlllIllIlllIllIIl, 0, llllllllllIllllIlllIllIlllIlIlll, llllllllllIllllIlllIllIlllIllIII, 256, llllllllllIllllIlllIllIlllIlIllI), llllllllllIllllIlllIllIlllIllIll);
    }
    
    @Override
    protected void onEntityAdded(final Entity llllllllllIllllIlllIllIlIIIIlIlI) {
        super.onEntityAdded(llllllllllIllllIlllIllIlIIIIlIlI);
        this.entitiesById.addKey(llllllllllIllllIlllIllIlIIIIlIlI.getEntityId(), llllllllllIllllIlllIllIlIIIIlIlI);
        this.entitiesByUuid.put(llllllllllIllllIlllIllIlIIIIlIlI.getUniqueID(), llllllllllIllllIlllIllIlIIIIlIlI);
        final Entity[] llllllllllIllllIlllIllIlIIIIlIIl = llllllllllIllllIlllIllIlIIIIlIlI.getParts();
        if (llllllllllIllllIlllIllIlIIIIlIIl != null) {
            final String llllllllllIllllIlllIllIlIIIIIIIl;
            final Exception llllllllllIllllIlllIllIlIIIIIIlI = (Exception)((Entity[])(Object)(llllllllllIllllIlllIllIlIIIIIIIl = (String)(Object)llllllllllIllllIlllIllIlIIIIlIIl)).length;
            for (String llllllllllIllllIlllIllIlIIIIIIll = (String)0; llllllllllIllllIlllIllIlIIIIIIll < llllllllllIllllIlllIllIlIIIIIIlI; ++llllllllllIllllIlllIllIlIIIIIIll) {
                final Entity llllllllllIllllIlllIllIlIIIIlIII = llllllllllIllllIlllIllIlIIIIIIIl[llllllllllIllllIlllIllIlIIIIIIll];
                this.entitiesById.addKey(llllllllllIllllIlllIllIlIIIIlIII.getEntityId(), llllllllllIllllIlllIllIlIIIIlIII);
            }
        }
    }
    
    @Override
    public Explosion newExplosion(@Nullable final Entity llllllllllIllllIlllIllIIllIlIIII, final double llllllllllIllllIlllIllIIllIIllll, final double llllllllllIllllIlllIllIIllIIIlII, final double llllllllllIllllIlllIllIIllIIIIll, final float llllllllllIllllIlllIllIIllIIIIlI, final boolean llllllllllIllllIlllIllIIllIIIIIl, final boolean llllllllllIllllIlllIllIIllIIIIII) {
        final Explosion llllllllllIllllIlllIllIIllIIlIIl = new Explosion(this, llllllllllIllllIlllIllIIllIlIIII, llllllllllIllllIlllIllIIllIIllll, llllllllllIllllIlllIllIIllIIIlII, llllllllllIllllIlllIllIIllIIIIll, llllllllllIllllIlllIllIIllIIIIlI, llllllllllIllllIlllIllIIllIIIIIl, llllllllllIllllIlllIllIIllIIIIII);
        llllllllllIllllIlllIllIIllIIlIIl.doExplosionA();
        llllllllllIllllIlllIllIIllIIlIIl.doExplosionB(false);
        if (!llllllllllIllllIlllIllIIllIIIIII) {
            llllllllllIllllIlllIllIIllIIlIIl.clearAffectedBlockPositions();
        }
        for (final EntityPlayer llllllllllIllllIlllIllIIllIIlIII : this.playerEntities) {
            if (llllllllllIllllIlllIllIIllIIlIII.getDistanceSq(llllllllllIllllIlllIllIIllIIllll, llllllllllIllllIlllIllIIllIIIlII, llllllllllIllllIlllIllIIllIIIIll) < 4096.0) {
                ((EntityPlayerMP)llllllllllIllllIlllIllIIllIIlIII).connection.sendPacket(new SPacketExplosion(llllllllllIllllIlllIllIIllIIllll, llllllllllIllllIlllIllIIllIIIlII, llllllllllIllllIlllIllIIllIIIIll, llllllllllIllllIlllIllIIllIIIIlI, llllllllllIllllIlllIllIIllIIlIIl.getAffectedBlockPositions(), llllllllllIllllIlllIllIIllIIlIIl.getPlayerKnockbackMap().get(llllllllllIllllIlllIllIIllIIlIII)));
            }
        }
        return llllllllllIllllIlllIllIIllIIlIIl;
    }
    
    public EntityTracker getEntityTracker() {
        return this.theEntityTracker;
    }
    
    protected void saveLevel() throws MinecraftException {
        this.checkSessionLock();
        final char llllllllllIllllIlllIllIlIIllIIII;
        final String llllllllllIllllIlllIllIlIIllIIIl = (String)((WorldServer[])(Object)(llllllllllIllllIlllIllIlIIllIIII = (char)(Object)this.mcServer.worldServers)).length;
        for (char llllllllllIllllIlllIllIlIIllIIlI = '\0'; llllllllllIllllIlllIllIlIIllIIlI < llllllllllIllllIlllIllIlIIllIIIl; ++llllllllllIllllIlllIllIlIIllIIlI) {
            final WorldServer llllllllllIllllIlllIllIlIIllIlIl = llllllllllIllllIlllIllIlIIllIIII[llllllllllIllllIlllIllIlIIllIIlI];
            if (llllllllllIllllIlllIllIlIIllIlIl instanceof WorldServerMulti) {
                ((WorldServerMulti)llllllllllIllllIlllIllIlIIllIlIl).saveAdditionalData();
            }
        }
        this.worldInfo.setBorderSize(this.getWorldBorder().getDiameter());
        this.worldInfo.getBorderCenterX(this.getWorldBorder().getCenterX());
        this.worldInfo.getBorderCenterZ(this.getWorldBorder().getCenterZ());
        this.worldInfo.setBorderSafeZone(this.getWorldBorder().getDamageBuffer());
        this.worldInfo.setBorderDamagePerBlock(this.getWorldBorder().getDamageAmount());
        this.worldInfo.setBorderWarningDistance(this.getWorldBorder().getWarningDistance());
        this.worldInfo.setBorderWarningTime(this.getWorldBorder().getWarningTime());
        this.worldInfo.setBorderLerpTarget(this.getWorldBorder().getTargetSize());
        this.worldInfo.setBorderLerpTime(this.getWorldBorder().getTimeUntilTarget());
        this.saveHandler.saveWorldInfoWithPlayer(this.worldInfo, this.mcServer.getPlayerList().getHostPlayerData());
        this.mapStorage.saveAllData();
    }
    
    public WorldServer(final MinecraftServer llllllllllIllllIlllIllllIIlllIlI, final ISaveHandler llllllllllIllllIlllIllllIIlllIIl, final WorldInfo llllllllllIllllIlllIllllIIlllllI, final int llllllllllIllllIlllIllllIIllIlll, final Profiler llllllllllIllllIlllIllllIIllIllI) {
        super(llllllllllIllllIlllIllllIIlllIIl, llllllllllIllllIlllIllllIIlllllI, DimensionType.getById(llllllllllIllllIlllIllllIIllIlll).createDimension(), llllllllllIllllIlllIllllIIllIllI, false);
        this.pendingTickListEntriesHashSet = (Set<NextTickListEntry>)Sets.newHashSet();
        this.pendingTickListEntriesTreeSet = new TreeSet<NextTickListEntry>();
        this.entitiesByUuid = (Map<UUID, Entity>)Maps.newHashMap();
        this.entitySpawner = new WorldEntitySpawner();
        this.villageSiege = new VillageSiege(this);
        this.blockEventQueue = new ServerBlockEventList[] { new ServerBlockEventList(null), new ServerBlockEventList(null) };
        this.pendingTickListEntriesThisTick = (List<NextTickListEntry>)Lists.newArrayList();
        this.mcServer = llllllllllIllllIlllIllllIIlllIlI;
        this.theEntityTracker = new EntityTracker(this);
        this.thePlayerManager = new PlayerChunkMap(this);
        this.provider.registerWorld(this);
        this.chunkProvider = this.createChunkProvider();
        this.worldTeleporter = new Teleporter(this);
        this.calculateInitialSkylight();
        this.calculateInitialWeather();
        this.getWorldBorder().setSize(llllllllllIllllIlllIllllIIlllIlI.getMaxWorldSize());
    }
    
    @Nullable
    public Entity getEntityFromUuid(final UUID llllllllllIllllIlllIlIlllllIIlIl) {
        return this.entitiesByUuid.get(llllllllllIllllIlllIlIlllllIIlIl);
    }
    
    @Override
    public boolean spawnEntityInWorld(final Entity llllllllllIllllIlllIllIlIIlIlIlI) {
        return this.canAddEntity(llllllllllIllllIlllIllIlIIlIlIlI) && super.spawnEntityInWorld(llllllllllIllllIlllIllIlIIlIlIlI);
    }
    
    @Override
    public void updateEntityWithOptionalForce(final Entity llllllllllIllllIlllIllIllIllIIII, final boolean llllllllllIllllIlllIllIllIlIllll) {
        if (!this.canSpawnAnimals() && (llllllllllIllllIlllIllIllIllIIII instanceof EntityAnimal || llllllllllIllllIlllIllIllIllIIII instanceof EntityWaterMob)) {
            llllllllllIllllIlllIllIllIllIIII.setDead();
        }
        if (!this.canSpawnNPCs() && llllllllllIllllIlllIllIllIllIIII instanceof INpc) {
            llllllllllIllllIlllIllIllIllIIII.setDead();
        }
        super.updateEntityWithOptionalForce(llllllllllIllllIlllIllIllIllIIII, llllllllllIllllIlllIllIllIlIllll);
    }
    
    @Override
    public void scheduleUpdate(final BlockPos llllllllllIllllIlllIlllIIlIlIlII, final Block llllllllllIllllIlllIlllIIlIIllll, final int llllllllllIllllIlllIlllIIlIlIIlI) {
        this.updateBlockTick(llllllllllIllllIlllIlllIIlIlIlII, llllllllllIllllIlllIlllIIlIIllll, llllllllllIllllIlllIlllIIlIlIIlI, 0);
    }
    
    @Override
    public void loadEntities(final Collection<Entity> llllllllllIllllIlllIllIlIIlIIIIl) {
        for (final Entity llllllllllIllllIlllIllIlIIlIIIll : Lists.newArrayList((Iterable)llllllllllIllllIlllIllIlIIlIIIIl)) {
            if (this.canAddEntity(llllllllllIllllIlllIllIlIIlIIIll)) {
                this.loadedEntityList.add(llllllllllIllllIlllIllIlIIlIIIll);
                this.onEntityAdded(llllllllllIllllIlllIllIlIIlIIIll);
            }
        }
    }
    
    @Override
    protected boolean isChunkLoaded(final int llllllllllIllllIlllIlllIllIlIllI, final int llllllllllIllllIlllIlllIllIlIIIl, final boolean llllllllllIllllIlllIlllIllIlIlII) {
        return this.getChunkProvider().chunkExists(llllllllllIllllIlllIlllIllIlIllI, llllllllllIllllIlllIlllIllIlIIIl);
    }
    
    private void createSpawnPosition(final WorldSettings llllllllllIllllIlllIllIlIllllIlI) {
        if (!this.provider.canRespawnHere()) {
            this.worldInfo.setSpawn(BlockPos.ORIGIN.up(this.provider.getAverageGroundLevel()));
        }
        else if (this.worldInfo.getTerrainType() == WorldType.DEBUG_WORLD) {
            this.worldInfo.setSpawn(BlockPos.ORIGIN.up());
        }
        else {
            this.findingSpawnPoint = true;
            final BiomeProvider llllllllllIllllIlllIllIlIllllIIl = this.provider.getBiomeProvider();
            final List<Biome> llllllllllIllllIlllIllIlIllllIII = llllllllllIllllIlllIllIlIllllIIl.getBiomesToSpawnIn();
            final Random llllllllllIllllIlllIllIlIlllIlll = new Random(this.getSeed());
            final BlockPos llllllllllIllllIlllIllIlIlllIllI = llllllllllIllllIlllIllIlIllllIIl.findBiomePosition(0, 0, 256, llllllllllIllllIlllIllIlIllllIII, llllllllllIllllIlllIllIlIlllIlll);
            int llllllllllIllllIlllIllIlIlllIlIl = 8;
            final int llllllllllIllllIlllIllIlIlllIlII = this.provider.getAverageGroundLevel();
            int llllllllllIllllIlllIllIlIlllIIll = 8;
            if (llllllllllIllllIlllIllIlIlllIllI != null) {
                llllllllllIllllIlllIllIlIlllIlIl = llllllllllIllllIlllIllIlIlllIllI.getX();
                llllllllllIllllIlllIllIlIlllIIll = llllllllllIllllIlllIllIlIlllIllI.getZ();
            }
            else {
                WorldServer.LOGGER.warn("Unable to find spawn biome");
            }
            int llllllllllIllllIlllIllIlIlllIIlI = 0;
            while (!this.provider.canCoordinateBeSpawn(llllllllllIllllIlllIllIlIlllIlIl, llllllllllIllllIlllIllIlIlllIIll)) {
                llllllllllIllllIlllIllIlIlllIlIl += llllllllllIllllIlllIllIlIlllIlll.nextInt(64) - llllllllllIllllIlllIllIlIlllIlll.nextInt(64);
                llllllllllIllllIlllIllIlIlllIIll += llllllllllIllllIlllIllIlIlllIlll.nextInt(64) - llllllllllIllllIlllIllIlIlllIlll.nextInt(64);
                if (++llllllllllIllllIlllIllIlIlllIIlI == 1000) {
                    break;
                }
            }
            this.worldInfo.setSpawn(new BlockPos(llllllllllIllllIlllIllIlIlllIlIl, llllllllllIllllIlllIllIlIlllIlII, llllllllllIllllIlllIllIlIlllIIll));
            this.findingSpawnPoint = false;
            if (llllllllllIllllIlllIllIlIllllIlI.isBonusChestEnabled()) {
                this.createBonusChest();
            }
        }
    }
    
    private boolean canSpawnNPCs() {
        return this.mcServer.getCanSpawnNPCs();
    }
    
    @Nullable
    @Override
    public List<NextTickListEntry> getPendingBlockUpdates(final StructureBoundingBox llllllllllIllllIlllIllIllIlllIll, final boolean llllllllllIllllIlllIllIlllIIIIll) {
        List<NextTickListEntry> llllllllllIllllIlllIllIlllIIIIlI = null;
        for (int llllllllllIllllIlllIllIlllIIIIIl = 0; llllllllllIllllIlllIllIlllIIIIIl < 2; ++llllllllllIllllIlllIllIlllIIIIIl) {
            Iterator<NextTickListEntry> llllllllllIllllIlllIllIllIllllll = null;
            if (llllllllllIllllIlllIllIlllIIIIIl == 0) {
                final Iterator<NextTickListEntry> llllllllllIllllIlllIllIlllIIIIII = this.pendingTickListEntriesTreeSet.iterator();
            }
            else {
                llllllllllIllllIlllIllIllIllllll = this.pendingTickListEntriesThisTick.iterator();
            }
            while (llllllllllIllllIlllIllIllIllllll.hasNext()) {
                final NextTickListEntry llllllllllIllllIlllIllIllIlllllI = llllllllllIllllIlllIllIllIllllll.next();
                final BlockPos llllllllllIllllIlllIllIllIllllIl = llllllllllIllllIlllIllIllIlllllI.position;
                if (llllllllllIllllIlllIllIllIllllIl.getX() >= llllllllllIllllIlllIllIllIlllIll.minX && llllllllllIllllIlllIllIllIllllIl.getX() < llllllllllIllllIlllIllIllIlllIll.maxX && llllllllllIllllIlllIllIllIllllIl.getZ() >= llllllllllIllllIlllIllIllIlllIll.minZ && llllllllllIllllIlllIllIllIllllIl.getZ() < llllllllllIllllIlllIllIllIlllIll.maxZ) {
                    if (llllllllllIllllIlllIllIlllIIIIll) {
                        if (llllllllllIllllIlllIllIlllIIIIIl == 0) {
                            this.pendingTickListEntriesHashSet.remove(llllllllllIllllIlllIllIllIlllllI);
                        }
                        llllllllllIllllIlllIllIllIllllll.remove();
                    }
                    if (llllllllllIllllIlllIllIlllIIIIlI == null) {
                        llllllllllIllllIlllIllIlllIIIIlI = (List<NextTickListEntry>)Lists.newArrayList();
                    }
                    llllllllllIllllIlllIllIlllIIIIlI.add(llllllllllIllllIlllIllIllIlllllI);
                }
            }
        }
        return llllllllllIllllIlllIllIlllIIIIlI;
    }
    
    public void spawnParticle(final EntityPlayerMP llllllllllIllllIlllIllIIIIIIlllI, final EnumParticleTypes llllllllllIllllIlllIllIIIIIllIll, final boolean llllllllllIllllIlllIllIIIIIllIlI, final double llllllllllIllllIlllIllIIIIIIlIll, final double llllllllllIllllIlllIllIIIIIIlIlI, final double llllllllllIllllIlllIllIIIIIIlIIl, final int llllllllllIllllIlllIllIIIIIIlIII, final double llllllllllIllllIlllIllIIIIIIIlll, final double llllllllllIllllIlllIllIIIIIIIllI, final double llllllllllIllllIlllIllIIIIIIIlIl, final double llllllllllIllllIlllIllIIIIIlIIlI, final int... llllllllllIllllIlllIllIIIIIlIIIl) {
        final Packet<?> llllllllllIllllIlllIllIIIIIlIIII = new SPacketParticles(llllllllllIllllIlllIllIIIIIllIll, llllllllllIllllIlllIllIIIIIllIlI, (float)llllllllllIllllIlllIllIIIIIIlIll, (float)llllllllllIllllIlllIllIIIIIIlIlI, (float)llllllllllIllllIlllIllIIIIIIlIIl, (float)llllllllllIllllIlllIllIIIIIIIlll, (float)llllllllllIllllIlllIllIIIIIIIllI, (float)llllllllllIllllIlllIllIIIIIIIlIl, (float)llllllllllIllllIlllIllIIIIIlIIlI, llllllllllIllllIlllIllIIIIIIlIII, llllllllllIllllIlllIllIIIIIlIIIl);
        this.sendPacketWithinDistance(llllllllllIllllIlllIllIIIIIIlllI, llllllllllIllllIlllIllIIIIIllIlI, llllllllllIllllIlllIllIIIIIIlIll, llllllllllIllllIlllIllIIIIIIlIlI, llllllllllIllllIlllIllIIIIIIlIIl, llllllllllIllllIlllIllIIIIIlIIII);
    }
    
    @Override
    public void updateAllPlayersSleepingFlag() {
        this.allPlayersSleeping = false;
        if (!this.playerEntities.isEmpty()) {
            int llllllllllIllllIlllIllllIIIIIIIl = 0;
            int llllllllllIllllIlllIllllIIIIIIII = 0;
            for (final EntityPlayer llllllllllIllllIlllIlllIllllllll : this.playerEntities) {
                if (llllllllllIllllIlllIlllIllllllll.isSpectator()) {
                    ++llllllllllIllllIlllIllllIIIIIIIl;
                }
                else {
                    if (!llllllllllIllllIlllIlllIllllllll.isPlayerSleeping()) {
                        continue;
                    }
                    ++llllllllllIllllIlllIllllIIIIIIII;
                }
            }
            this.allPlayersSleeping = (llllllllllIllllIlllIllllIIIIIIII > 0 && llllllllllIllllIlllIllllIIIIIIII >= this.playerEntities.size() - llllllllllIllllIlllIllllIIIIIIIl);
        }
    }
    
    @Override
    public void tick() {
        super.tick();
        if (this.getWorldInfo().isHardcoreModeEnabled() && this.getDifficulty() != EnumDifficulty.HARD) {
            this.getWorldInfo().setDifficulty(EnumDifficulty.HARD);
        }
        this.provider.getBiomeProvider().cleanupCache();
        if (this.areAllPlayersAsleep()) {
            if (this.getGameRules().getBoolean("doDaylightCycle")) {
                final long llllllllllIllllIlllIllllIIlIIllI = this.worldInfo.getWorldTime() + 24000L;
                this.worldInfo.setWorldTime(llllllllllIllllIlllIllllIIlIIllI - llllllllllIllllIlllIllllIIlIIllI % 24000L);
            }
            this.wakeAllPlayers();
        }
        this.theProfiler.startSection("mobSpawner");
        if (this.getGameRules().getBoolean("doMobSpawning") && this.worldInfo.getTerrainType() != WorldType.DEBUG_WORLD) {
            this.entitySpawner.findChunksForSpawning(this, this.spawnHostileMobs, this.spawnPeacefulMobs, this.worldInfo.getWorldTotalTime() % 400L == 0L);
        }
        this.theProfiler.endStartSection("chunkSource");
        this.chunkProvider.unloadQueuedChunks();
        final int llllllllllIllllIlllIllllIIlIIlIl = this.calculateSkylightSubtracted(1.0f);
        if (llllllllllIllllIlllIllllIIlIIlIl != this.getSkylightSubtracted()) {
            this.setSkylightSubtracted(llllllllllIllllIlllIllllIIlIIlIl);
        }
        this.worldInfo.setWorldTotalTime(this.worldInfo.getWorldTotalTime() + 1L);
        if (this.getGameRules().getBoolean("doDaylightCycle")) {
            this.worldInfo.setWorldTime(this.worldInfo.getWorldTime() + 1L);
        }
        this.theProfiler.endStartSection("tickPending");
        this.tickUpdates(false);
        this.theProfiler.endStartSection("tickBlocks");
        this.updateBlocks();
        this.theProfiler.endStartSection("chunkMap");
        this.thePlayerManager.tick();
        this.theProfiler.endStartSection("village");
        this.villageCollectionObj.tick();
        this.villageSiege.tick();
        this.theProfiler.endStartSection("portalForcer");
        this.worldTeleporter.removeStalePortalLocations(this.getTotalWorldTime());
        this.theProfiler.endSection();
        this.sendQueuedBlockEvents();
    }
    
    @Override
    public ListenableFuture<Object> addScheduledTask(final Runnable llllllllllIllllIlllIlIllllIlllIl) {
        return this.mcServer.addScheduledTask(llllllllllIllllIlllIlIllllIlllIl);
    }
    
    static class ServerBlockEventList extends ArrayList<BlockEventData>
    {
        private ServerBlockEventList() {
        }
    }
}
