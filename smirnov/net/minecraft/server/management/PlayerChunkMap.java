// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.server.management;

import net.minecraft.util.math.ChunkPos;
import com.google.common.collect.Sets;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import com.google.common.collect.Lists;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldProvider;
import java.util.Collections;
import com.google.common.collect.ComparisonChain;
import java.util.Comparator;
import com.google.common.collect.AbstractIterator;
import net.minecraft.world.chunk.Chunk;
import java.util.Iterator;
import javax.annotation.Nullable;
import java.util.Set;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import java.util.List;
import net.minecraft.world.WorldServer;
import net.minecraft.entity.player.EntityPlayerMP;
import com.google.common.base.Predicate;

public class PlayerChunkMap
{
    private /* synthetic */ long previousTotalWorldTime;
    private static final /* synthetic */ Predicate<EntityPlayerMP> NOT_SPECTATOR;
    private final /* synthetic */ WorldServer theWorldServer;
    private /* synthetic */ boolean sortSendToPlayers;
    private final /* synthetic */ List<EntityPlayerMP> players;
    private final /* synthetic */ List<PlayerChunkMapEntry> pendingSendToPlayers;
    private /* synthetic */ int playerViewRadius;
    private final /* synthetic */ List<PlayerChunkMapEntry> playerInstanceList;
    private /* synthetic */ boolean sortMissingChunks;
    private static final /* synthetic */ Predicate<EntityPlayerMP> CAN_GENERATE_CHUNKS;
    private final /* synthetic */ Long2ObjectMap<PlayerChunkMapEntry> playerInstances;
    private final /* synthetic */ Set<PlayerChunkMapEntry> playerInstancesToUpdate;
    private final /* synthetic */ List<PlayerChunkMapEntry> playersNeedingChunks;
    
    private boolean overlaps(final int lllllllllllIIllIlIllIIlllIlIlIIl, final int lllllllllllIIllIlIllIIlllIlIlIII, final int lllllllllllIIllIlIllIIlllIlIIlll, final int lllllllllllIIllIlIllIIlllIlIIllI, final int lllllllllllIIllIlIllIIlllIlIIlIl) {
        final int lllllllllllIIllIlIllIIlllIlIlIll = lllllllllllIIllIlIllIIlllIlIlIIl - lllllllllllIIllIlIllIIlllIlIIlll;
        final int lllllllllllIIllIlIllIIlllIlIlIlI = lllllllllllIIllIlIllIIlllIlIlIII - lllllllllllIIllIlIllIIlllIlIIllI;
        return lllllllllllIIllIlIllIIlllIlIlIll >= -lllllllllllIIllIlIllIIlllIlIIlIl && lllllllllllIIllIlIllIIlllIlIlIll <= lllllllllllIIllIlIllIIlllIlIIlIl && (lllllllllllIIllIlIllIIlllIlIlIlI >= -lllllllllllIIllIlIllIIlllIlIIlIl && lllllllllllIIllIlIllIIlllIlIlIlI <= lllllllllllIIllIlIllIIlllIlIIlIl);
    }
    
    static {
        NOT_SPECTATOR = (Predicate)new Predicate<EntityPlayerMP>() {
            public boolean apply(@Nullable final EntityPlayerMP lllllllllllIlIIllllIllIIlIIlIllI) {
                return lllllllllllIlIIllllIllIIlIIlIllI != null && !lllllllllllIlIIllllIllIIlIIlIllI.isSpectator();
            }
        };
        CAN_GENERATE_CHUNKS = (Predicate)new Predicate<EntityPlayerMP>() {
            public boolean apply(@Nullable final EntityPlayerMP llllllllllIllllIlIllllIIIlIIIllI) {
                return llllllllllIllllIlIllllIIIlIIIllI != null && (!llllllllllIllllIlIllllIIIlIIIllI.isSpectator() || llllllllllIllllIlIllllIIIlIIIllI.getServerWorld().getGameRules().getBoolean("spectatorsGenerateChunks"));
            }
        };
    }
    
    public WorldServer getWorldServer() {
        return this.theWorldServer;
    }
    
    public void addPlayer(final EntityPlayerMP lllllllllllIIllIlIllIIllllIlIIlI) {
        final int lllllllllllIIllIlIllIIllllIlIlll = (int)lllllllllllIIllIlIllIIllllIlIIlI.posX >> 4;
        final int lllllllllllIIllIlIllIIllllIlIllI = (int)lllllllllllIIllIlIllIIllllIlIIlI.posZ >> 4;
        lllllllllllIIllIlIllIIllllIlIIlI.managedPosX = lllllllllllIIllIlIllIIllllIlIIlI.posX;
        lllllllllllIIllIlIllIIllllIlIIlI.managedPosZ = lllllllllllIIllIlIllIIllllIlIIlI.posZ;
        for (int lllllllllllIIllIlIllIIllllIlIlIl = lllllllllllIIllIlIllIIllllIlIlll - this.playerViewRadius; lllllllllllIIllIlIllIIllllIlIlIl <= lllllllllllIIllIlIllIIllllIlIlll + this.playerViewRadius; ++lllllllllllIIllIlIllIIllllIlIlIl) {
            for (int lllllllllllIIllIlIllIIllllIlIlII = lllllllllllIIllIlIllIIllllIlIllI - this.playerViewRadius; lllllllllllIIllIlIllIIllllIlIlII <= lllllllllllIIllIlIllIIllllIlIllI + this.playerViewRadius; ++lllllllllllIIllIlIllIIllllIlIlII) {
                this.getOrCreateEntry(lllllllllllIIllIlIllIIllllIlIlIl, lllllllllllIIllIlIllIIllllIlIlII).addPlayer(lllllllllllIIllIlIllIIllllIlIIlI);
            }
        }
        this.players.add(lllllllllllIIllIlIllIIllllIlIIlI);
        this.markSortPending();
    }
    
    public Iterator<Chunk> getChunkIterator() {
        final Iterator<PlayerChunkMapEntry> lllllllllllIIllIlIllIlIIIIllIIll = this.playerInstanceList.iterator();
        return (Iterator<Chunk>)new AbstractIterator<Chunk>() {
            protected Chunk computeNext() {
                while (lllllllllllIIllIlIllIlIIIIllIIll.hasNext()) {
                    final PlayerChunkMapEntry lllllllllllIlllIlIlIIlIIIIIIlllI = lllllllllllIIllIlIllIlIIIIllIIll.next();
                    final Chunk lllllllllllIlllIlIlIIlIIIIIIllIl = lllllllllllIlllIlIlIIlIIIIIIlllI.getChunk();
                    if (lllllllllllIlllIlIlIIlIIIIIIllIl == null) {
                        continue;
                    }
                    if (!lllllllllllIlllIlIlIIlIIIIIIllIl.isLightPopulated() && lllllllllllIlllIlIlIIlIIIIIIllIl.isTerrainPopulated()) {
                        return lllllllllllIlllIlIlIIlIIIIIIllIl;
                    }
                    if (!lllllllllllIlllIlIlIIlIIIIIIllIl.isChunkTicked()) {
                        return lllllllllllIlllIlIlIIlIIIIIIllIl;
                    }
                    if (!lllllllllllIlllIlIlIIlIIIIIIlllI.hasPlayerMatchingInRange(128.0, PlayerChunkMap.NOT_SPECTATOR)) {
                        continue;
                    }
                    return lllllllllllIlllIlIlIIlIIIIIIllIl;
                }
                return (Chunk)this.endOfData();
            }
        };
    }
    
    public void tick() {
        final long lllllllllllIIllIlIllIlIIIIlIIlll = this.theWorldServer.getTotalWorldTime();
        if (lllllllllllIIllIlIllIlIIIIlIIlll - this.previousTotalWorldTime > 8000L) {
            this.previousTotalWorldTime = lllllllllllIIllIlIllIlIIIIlIIlll;
            for (int lllllllllllIIllIlIllIlIIIIlIIllI = 0; lllllllllllIIllIlIllIlIIIIlIIllI < this.playerInstanceList.size(); ++lllllllllllIIllIlIllIlIIIIlIIllI) {
                final PlayerChunkMapEntry lllllllllllIIllIlIllIlIIIIlIIlIl = this.playerInstanceList.get(lllllllllllIIllIlIllIlIIIIlIIllI);
                lllllllllllIIllIlIllIlIIIIlIIlIl.update();
                lllllllllllIIllIlIllIlIIIIlIIlIl.updateChunkInhabitedTime();
            }
        }
        if (!this.playerInstancesToUpdate.isEmpty()) {
            for (final PlayerChunkMapEntry lllllllllllIIllIlIllIlIIIIlIIlII : this.playerInstancesToUpdate) {
                lllllllllllIIllIlIllIlIIIIlIIlII.update();
            }
            this.playerInstancesToUpdate.clear();
        }
        if (this.sortMissingChunks && lllllllllllIIllIlIllIlIIIIlIIlll % 4L == 0L) {
            this.sortMissingChunks = false;
            Collections.sort(this.playersNeedingChunks, new Comparator<PlayerChunkMapEntry>() {
                @Override
                public int compare(final PlayerChunkMapEntry llllllllllIlllllIIllllIIIIIlIlII, final PlayerChunkMapEntry llllllllllIlllllIIllllIIIIIlIIll) {
                    return ComparisonChain.start().compare(llllllllllIlllllIIllllIIIIIlIlII.getClosestPlayerDistance(), llllllllllIlllllIIllllIIIIIlIIll.getClosestPlayerDistance()).result();
                }
            });
        }
        if (this.sortSendToPlayers && lllllllllllIIllIlIllIlIIIIlIIlll % 4L == 2L) {
            this.sortSendToPlayers = false;
            Collections.sort(this.pendingSendToPlayers, new Comparator<PlayerChunkMapEntry>() {
                @Override
                public int compare(final PlayerChunkMapEntry llllllllllllIIllIIIlIIIIllllIIll, final PlayerChunkMapEntry llllllllllllIIllIIIlIIIIllllIlII) {
                    return ComparisonChain.start().compare(llllllllllllIIllIIIlIIIIllllIIll.getClosestPlayerDistance(), llllllllllllIIllIIIlIIIIllllIlII.getClosestPlayerDistance()).result();
                }
            });
        }
        if (!this.playersNeedingChunks.isEmpty()) {
            final long lllllllllllIIllIlIllIlIIIIlIIIll = System.nanoTime() + 50000000L;
            int lllllllllllIIllIlIllIlIIIIlIIIlI = 49;
            final Iterator<PlayerChunkMapEntry> lllllllllllIIllIlIllIlIIIIlIIIIl = this.playersNeedingChunks.iterator();
            while (lllllllllllIIllIlIllIlIIIIlIIIIl.hasNext()) {
                final PlayerChunkMapEntry lllllllllllIIllIlIllIlIIIIlIIIII = lllllllllllIIllIlIllIlIIIIlIIIIl.next();
                if (lllllllllllIIllIlIllIlIIIIlIIIII.getChunk() == null) {
                    final boolean lllllllllllIIllIlIllIlIIIIIlllll = lllllllllllIIllIlIllIlIIIIlIIIII.hasPlayerMatching(PlayerChunkMap.CAN_GENERATE_CHUNKS);
                    if (!lllllllllllIIllIlIllIlIIIIlIIIII.providePlayerChunk(lllllllllllIIllIlIllIlIIIIIlllll)) {
                        continue;
                    }
                    lllllllllllIIllIlIllIlIIIIlIIIIl.remove();
                    if (lllllllllllIIllIlIllIlIIIIlIIIII.sendToPlayers()) {
                        this.pendingSendToPlayers.remove(lllllllllllIIllIlIllIlIIIIlIIIII);
                    }
                    if (--lllllllllllIIllIlIllIlIIIIlIIIlI < 0) {
                        break;
                    }
                    if (System.nanoTime() > lllllllllllIIllIlIllIlIIIIlIIIll) {
                        break;
                    }
                    continue;
                }
            }
        }
        if (!this.pendingSendToPlayers.isEmpty()) {
            int lllllllllllIIllIlIllIlIIIIIllllI = 81;
            final Iterator<PlayerChunkMapEntry> lllllllllllIIllIlIllIlIIIIIlllIl = this.pendingSendToPlayers.iterator();
            while (lllllllllllIIllIlIllIlIIIIIlllIl.hasNext()) {
                final PlayerChunkMapEntry lllllllllllIIllIlIllIlIIIIIlllII = lllllllllllIIllIlIllIlIIIIIlllIl.next();
                if (lllllllllllIIllIlIllIlIIIIIlllII.sendToPlayers()) {
                    lllllllllllIIllIlIllIlIIIIIlllIl.remove();
                    if (--lllllllllllIIllIlIllIlIIIIIllllI < 0) {
                        break;
                    }
                    continue;
                }
            }
        }
        if (this.players.isEmpty()) {
            final WorldProvider lllllllllllIIllIlIllIlIIIIIllIll = this.theWorldServer.provider;
            if (!lllllllllllIIllIlIllIlIIIIIllIll.canRespawnHere()) {
                this.theWorldServer.getChunkProvider().unloadAllChunks();
            }
        }
    }
    
    public void markBlockForUpdate(final BlockPos lllllllllllIIllIlIllIIlllllIlIII) {
        final int lllllllllllIIllIlIllIIlllllIIlll = lllllllllllIIllIlIllIIlllllIlIII.getX() >> 4;
        final int lllllllllllIIllIlIllIIlllllIIllI = lllllllllllIIllIlIllIIlllllIlIII.getZ() >> 4;
        final PlayerChunkMapEntry lllllllllllIIllIlIllIIlllllIIlIl = this.getEntry(lllllllllllIIllIlIllIIlllllIIlll, lllllllllllIIllIlIllIIlllllIIllI);
        if (lllllllllllIIllIlIllIIlllllIIlIl != null) {
            lllllllllllIIllIlIllIIlllllIIlIl.blockChanged(lllllllllllIIllIlIllIIlllllIlIII.getX() & 0xF, lllllllllllIIllIlIllIIlllllIlIII.getY(), lllllllllllIIllIlIllIIlllllIlIII.getZ() & 0xF);
        }
    }
    
    private static long getIndex(final int lllllllllllIIllIlIllIIllIIllllll, final int lllllllllllIIllIlIllIIllIIlllllI) {
        return lllllllllllIIllIlIllIIllIIllllll + 2147483647L | lllllllllllIIllIlIllIIllIIlllllI + 2147483647L << 32;
    }
    
    public void addEntry(final PlayerChunkMapEntry lllllllllllIIllIlIllIIllIIlllIII) {
        this.playerInstancesToUpdate.add(lllllllllllIIllIlIllIIllIIlllIII);
    }
    
    public static int getFurthestViewableBlock(final int lllllllllllIIllIlIllIIllIlIIIIll) {
        return lllllllllllIIllIlIllIIllIlIIIIll * 16 - 16;
    }
    
    @Nullable
    public PlayerChunkMapEntry getEntry(final int lllllllllllIIllIlIllIlIIIIIIIIlI, final int lllllllllllIIllIlIllIIlllllllllI) {
        return (PlayerChunkMapEntry)this.playerInstances.get(getIndex(lllllllllllIIllIlIllIlIIIIIIIIlI, lllllllllllIIllIlIllIIlllllllllI));
    }
    
    private void markSortPending() {
        this.sortMissingChunks = true;
        this.sortSendToPlayers = true;
    }
    
    public boolean isPlayerWatchingChunk(final EntityPlayerMP lllllllllllIIllIlIllIIllIllIllll, final int lllllllllllIIllIlIllIIllIllIlIIl, final int lllllllllllIIllIlIllIIllIllIlIII) {
        final PlayerChunkMapEntry lllllllllllIIllIlIllIIllIllIllII = this.getEntry(lllllllllllIIllIlIllIIllIllIlIIl, lllllllllllIIllIlIllIIllIllIlIII);
        return lllllllllllIIllIlIllIIllIllIllII != null && lllllllllllIIllIlIllIIllIllIllII.containsPlayer(lllllllllllIIllIlIllIIllIllIllll) && lllllllllllIIllIlIllIIllIllIllII.isSentToPlayers();
    }
    
    public void setPlayerViewRadius(int lllllllllllIIllIlIllIIllIlIlIIII) {
        lllllllllllIIllIlIllIIllIlIlIIII = MathHelper.clamp(lllllllllllIIllIlIllIIllIlIlIIII, 3, 32);
        if (lllllllllllIIllIlIllIIllIlIlIIII != this.playerViewRadius) {
            final int lllllllllllIIllIlIllIIllIlIllIlI = lllllllllllIIllIlIllIIllIlIlIIII - this.playerViewRadius;
            for (final EntityPlayerMP lllllllllllIIllIlIllIIllIlIllIIl : Lists.newArrayList((Iterable)this.players)) {
                final int lllllllllllIIllIlIllIIllIlIllIII = (int)lllllllllllIIllIlIllIIllIlIllIIl.posX >> 4;
                final int lllllllllllIIllIlIllIIllIlIlIlll = (int)lllllllllllIIllIlIllIIllIlIllIIl.posZ >> 4;
                if (lllllllllllIIllIlIllIIllIlIllIlI > 0) {
                    for (int lllllllllllIIllIlIllIIllIlIlIllI = lllllllllllIIllIlIllIIllIlIllIII - lllllllllllIIllIlIllIIllIlIlIIII; lllllllllllIIllIlIllIIllIlIlIllI <= lllllllllllIIllIlIllIIllIlIllIII + lllllllllllIIllIlIllIIllIlIlIIII; ++lllllllllllIIllIlIllIIllIlIlIllI) {
                        for (int lllllllllllIIllIlIllIIllIlIlIlIl = lllllllllllIIllIlIllIIllIlIlIlll - lllllllllllIIllIlIllIIllIlIlIIII; lllllllllllIIllIlIllIIllIlIlIlIl <= lllllllllllIIllIlIllIIllIlIlIlll + lllllllllllIIllIlIllIIllIlIlIIII; ++lllllllllllIIllIlIllIIllIlIlIlIl) {
                            final PlayerChunkMapEntry lllllllllllIIllIlIllIIllIlIlIlII = this.getOrCreateEntry(lllllllllllIIllIlIllIIllIlIlIllI, lllllllllllIIllIlIllIIllIlIlIlIl);
                            if (!lllllllllllIIllIlIllIIllIlIlIlII.containsPlayer(lllllllllllIIllIlIllIIllIlIllIIl)) {
                                lllllllllllIIllIlIllIIllIlIlIlII.addPlayer(lllllllllllIIllIlIllIIllIlIllIIl);
                            }
                        }
                    }
                }
                else {
                    for (int lllllllllllIIllIlIllIIllIlIlIIll = lllllllllllIIllIlIllIIllIlIllIII - this.playerViewRadius; lllllllllllIIllIlIllIIllIlIlIIll <= lllllllllllIIllIlIllIIllIlIllIII + this.playerViewRadius; ++lllllllllllIIllIlIllIIllIlIlIIll) {
                        for (int lllllllllllIIllIlIllIIllIlIlIIlI = lllllllllllIIllIlIllIIllIlIlIlll - this.playerViewRadius; lllllllllllIIllIlIllIIllIlIlIIlI <= lllllllllllIIllIlIllIIllIlIlIlll + this.playerViewRadius; ++lllllllllllIIllIlIllIIllIlIlIIlI) {
                            if (!this.overlaps(lllllllllllIIllIlIllIIllIlIlIIll, lllllllllllIIllIlIllIIllIlIlIIlI, lllllllllllIIllIlIllIIllIlIllIII, lllllllllllIIllIlIllIIllIlIlIlll, lllllllllllIIllIlIllIIllIlIlIIII)) {
                                this.getOrCreateEntry(lllllllllllIIllIlIllIIllIlIlIIll, lllllllllllIIllIlIllIIllIlIlIIlI).removePlayer(lllllllllllIIllIlIllIIllIlIllIIl);
                            }
                        }
                    }
                }
            }
            this.playerViewRadius = lllllllllllIIllIlIllIIllIlIlIIII;
            this.markSortPending();
        }
    }
    
    public boolean contains(final int lllllllllllIIllIlIllIlIIIIIIlIIl, final int lllllllllllIIllIlIllIlIIIIIIllII) {
        final long lllllllllllIIllIlIllIlIIIIIIlIll = getIndex(lllllllllllIIllIlIllIlIIIIIIlIIl, lllllllllllIIllIlIllIlIIIIIIllII);
        return this.playerInstances.get(lllllllllllIIllIlIllIlIIIIIIlIll) != null;
    }
    
    public void removePlayer(final EntityPlayerMP lllllllllllIIllIlIllIIlllIlllllI) {
        final int lllllllllllIIllIlIllIIllllIIIlII = (int)lllllllllllIIllIlIllIIlllIlllllI.managedPosX >> 4;
        final int lllllllllllIIllIlIllIIllllIIIIll = (int)lllllllllllIIllIlIllIIlllIlllllI.managedPosZ >> 4;
        for (int lllllllllllIIllIlIllIIllllIIIIlI = lllllllllllIIllIlIllIIllllIIIlII - this.playerViewRadius; lllllllllllIIllIlIllIIllllIIIIlI <= lllllllllllIIllIlIllIIllllIIIlII + this.playerViewRadius; ++lllllllllllIIllIlIllIIllllIIIIlI) {
            for (int lllllllllllIIllIlIllIIllllIIIIIl = lllllllllllIIllIlIllIIllllIIIIll - this.playerViewRadius; lllllllllllIIllIlIllIIllllIIIIIl <= lllllllllllIIllIlIllIIllllIIIIll + this.playerViewRadius; ++lllllllllllIIllIlIllIIllllIIIIIl) {
                final PlayerChunkMapEntry lllllllllllIIllIlIllIIllllIIIIII = this.getEntry(lllllllllllIIllIlIllIIllllIIIIlI, lllllllllllIIllIlIllIIllllIIIIIl);
                if (lllllllllllIIllIlIllIIllllIIIIII != null) {
                    lllllllllllIIllIlIllIIllllIIIIII.removePlayer(lllllllllllIIllIlIllIIlllIlllllI);
                }
            }
        }
        this.players.remove(lllllllllllIIllIlIllIIlllIlllllI);
        this.markSortPending();
    }
    
    private PlayerChunkMapEntry getOrCreateEntry(final int lllllllllllIIllIlIllIIllllllIIlI, final int lllllllllllIIllIlIllIIllllllIllI) {
        final long lllllllllllIIllIlIllIIllllllIlIl = getIndex(lllllllllllIIllIlIllIIllllllIIlI, lllllllllllIIllIlIllIIllllllIllI);
        PlayerChunkMapEntry lllllllllllIIllIlIllIIllllllIlII = (PlayerChunkMapEntry)this.playerInstances.get(lllllllllllIIllIlIllIIllllllIlIl);
        if (lllllllllllIIllIlIllIIllllllIlII == null) {
            lllllllllllIIllIlIllIIllllllIlII = new PlayerChunkMapEntry(this, lllllllllllIIllIlIllIIllllllIIlI, lllllllllllIIllIlIllIIllllllIllI);
            this.playerInstances.put(lllllllllllIIllIlIllIIllllllIlIl, (Object)lllllllllllIIllIlIllIIllllllIlII);
            this.playerInstanceList.add(lllllllllllIIllIlIllIIllllllIlII);
            if (lllllllllllIIllIlIllIIllllllIlII.getChunk() == null) {
                this.playersNeedingChunks.add(lllllllllllIIllIlIllIIllllllIlII);
            }
            if (!lllllllllllIIllIlIllIIllllllIlII.sendToPlayers()) {
                this.pendingSendToPlayers.add(lllllllllllIIllIlIllIIllllllIlII);
            }
        }
        return lllllllllllIIllIlIllIIllllllIlII;
    }
    
    public PlayerChunkMap(final WorldServer lllllllllllIIllIlIllIlIIIIllllII) {
        this.players = (List<EntityPlayerMP>)Lists.newArrayList();
        this.playerInstances = (Long2ObjectMap<PlayerChunkMapEntry>)new Long2ObjectOpenHashMap(4096);
        this.playerInstancesToUpdate = (Set<PlayerChunkMapEntry>)Sets.newHashSet();
        this.pendingSendToPlayers = (List<PlayerChunkMapEntry>)Lists.newLinkedList();
        this.playersNeedingChunks = (List<PlayerChunkMapEntry>)Lists.newLinkedList();
        this.playerInstanceList = (List<PlayerChunkMapEntry>)Lists.newArrayList();
        this.sortMissingChunks = true;
        this.sortSendToPlayers = true;
        this.theWorldServer = lllllllllllIIllIlIllIlIIIIllllII;
        this.setPlayerViewRadius(lllllllllllIIllIlIllIlIIIIllllII.getMinecraftServer().getPlayerList().getViewDistance());
    }
    
    public void removeEntry(final PlayerChunkMapEntry lllllllllllIIllIlIllIIllIIlIlIlI) {
        final ChunkPos lllllllllllIIllIlIllIIllIIlIlllI = lllllllllllIIllIlIllIIllIIlIlIlI.getPos();
        final long lllllllllllIIllIlIllIIllIIlIllIl = getIndex(lllllllllllIIllIlIllIIllIIlIlllI.chunkXPos, lllllllllllIIllIlIllIIllIIlIlllI.chunkZPos);
        lllllllllllIIllIlIllIIllIIlIlIlI.updateChunkInhabitedTime();
        this.playerInstances.remove(lllllllllllIIllIlIllIIllIIlIllIl);
        this.playerInstanceList.remove(lllllllllllIIllIlIllIIllIIlIlIlI);
        this.playerInstancesToUpdate.remove(lllllllllllIIllIlIllIIllIIlIlIlI);
        this.pendingSendToPlayers.remove(lllllllllllIIllIlIllIIllIIlIlIlI);
        this.playersNeedingChunks.remove(lllllllllllIIllIlIllIIllIIlIlIlI);
        final Chunk lllllllllllIIllIlIllIIllIIlIllII = lllllllllllIIllIlIllIIllIIlIlIlI.getChunk();
        if (lllllllllllIIllIlIllIIllIIlIllII != null) {
            this.getWorldServer().getChunkProvider().unload(lllllllllllIIllIlIllIIllIIlIllII);
        }
    }
    
    public void updateMovingPlayer(final EntityPlayerMP lllllllllllIIllIlIllIIlllIIlIIlI) {
        final int lllllllllllIIllIlIllIIlllIIlIIIl = (int)lllllllllllIIllIlIllIIlllIIlIIlI.posX >> 4;
        final int lllllllllllIIllIlIllIIlllIIlIIII = (int)lllllllllllIIllIlIllIIlllIIlIIlI.posZ >> 4;
        final double lllllllllllIIllIlIllIIlllIIIllll = lllllllllllIIllIlIllIIlllIIlIIlI.managedPosX - lllllllllllIIllIlIllIIlllIIlIIlI.posX;
        final double lllllllllllIIllIlIllIIlllIIIlllI = lllllllllllIIllIlIllIIlllIIlIIlI.managedPosZ - lllllllllllIIllIlIllIIlllIIlIIlI.posZ;
        final double lllllllllllIIllIlIllIIlllIIIllIl = lllllllllllIIllIlIllIIlllIIIllll * lllllllllllIIllIlIllIIlllIIIllll + lllllllllllIIllIlIllIIlllIIIlllI * lllllllllllIIllIlIllIIlllIIIlllI;
        if (lllllllllllIIllIlIllIIlllIIIllIl >= 64.0) {
            final int lllllllllllIIllIlIllIIlllIIIllII = (int)lllllllllllIIllIlIllIIlllIIlIIlI.managedPosX >> 4;
            final int lllllllllllIIllIlIllIIlllIIIlIll = (int)lllllllllllIIllIlIllIIlllIIlIIlI.managedPosZ >> 4;
            final int lllllllllllIIllIlIllIIlllIIIlIlI = this.playerViewRadius;
            final int lllllllllllIIllIlIllIIlllIIIlIIl = lllllllllllIIllIlIllIIlllIIlIIIl - lllllllllllIIllIlIllIIlllIIIllII;
            final int lllllllllllIIllIlIllIIlllIIIlIII = lllllllllllIIllIlIllIIlllIIlIIII - lllllllllllIIllIlIllIIlllIIIlIll;
            if (lllllllllllIIllIlIllIIlllIIIlIIl != 0 || lllllllllllIIllIlIllIIlllIIIlIII != 0) {
                for (int lllllllllllIIllIlIllIIlllIIIIlll = lllllllllllIIllIlIllIIlllIIlIIIl - lllllllllllIIllIlIllIIlllIIIlIlI; lllllllllllIIllIlIllIIlllIIIIlll <= lllllllllllIIllIlIllIIlllIIlIIIl + lllllllllllIIllIlIllIIlllIIIlIlI; ++lllllllllllIIllIlIllIIlllIIIIlll) {
                    for (int lllllllllllIIllIlIllIIlllIIIIllI = lllllllllllIIllIlIllIIlllIIlIIII - lllllllllllIIllIlIllIIlllIIIlIlI; lllllllllllIIllIlIllIIlllIIIIllI <= lllllllllllIIllIlIllIIlllIIlIIII + lllllllllllIIllIlIllIIlllIIIlIlI; ++lllllllllllIIllIlIllIIlllIIIIllI) {
                        if (!this.overlaps(lllllllllllIIllIlIllIIlllIIIIlll, lllllllllllIIllIlIllIIlllIIIIllI, lllllllllllIIllIlIllIIlllIIIllII, lllllllllllIIllIlIllIIlllIIIlIll, lllllllllllIIllIlIllIIlllIIIlIlI)) {
                            this.getOrCreateEntry(lllllllllllIIllIlIllIIlllIIIIlll, lllllllllllIIllIlIllIIlllIIIIllI).addPlayer(lllllllllllIIllIlIllIIlllIIlIIlI);
                        }
                        if (!this.overlaps(lllllllllllIIllIlIllIIlllIIIIlll - lllllllllllIIllIlIllIIlllIIIlIIl, lllllllllllIIllIlIllIIlllIIIIllI - lllllllllllIIllIlIllIIlllIIIlIII, lllllllllllIIllIlIllIIlllIIlIIIl, lllllllllllIIllIlIllIIlllIIlIIII, lllllllllllIIllIlIllIIlllIIIlIlI)) {
                            final PlayerChunkMapEntry lllllllllllIIllIlIllIIlllIIIIlIl = this.getEntry(lllllllllllIIllIlIllIIlllIIIIlll - lllllllllllIIllIlIllIIlllIIIlIIl, lllllllllllIIllIlIllIIlllIIIIllI - lllllllllllIIllIlIllIIlllIIIlIII);
                            if (lllllllllllIIllIlIllIIlllIIIIlIl != null) {
                                lllllllllllIIllIlIllIIlllIIIIlIl.removePlayer(lllllllllllIIllIlIllIIlllIIlIIlI);
                            }
                        }
                    }
                }
                lllllllllllIIllIlIllIIlllIIlIIlI.managedPosX = lllllllllllIIllIlIllIIlllIIlIIlI.posX;
                lllllllllllIIllIlIllIIlllIIlIIlI.managedPosZ = lllllllllllIIllIlIllIIlllIIlIIlI.posZ;
                this.markSortPending();
            }
        }
    }
}
