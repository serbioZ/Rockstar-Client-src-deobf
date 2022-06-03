// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.server.management;

import net.minecraft.network.play.server.SPacketMultiBlockChange;
import net.minecraft.world.World;
import net.minecraft.network.play.server.SPacketBlockChange;
import net.minecraft.util.math.BlockPos;
import net.minecraft.network.play.server.SPacketUnloadChunk;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.base.Predicate;
import org.apache.logging.log4j.LogManager;
import net.minecraft.entity.Entity;
import net.minecraft.network.play.server.SPacketChunkData;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.network.Packet;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.entity.player.EntityPlayerMP;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.world.chunk.Chunk;
import org.apache.logging.log4j.Logger;
import net.minecraft.util.math.ChunkPos;

public class PlayerChunkMapEntry
{
    private final /* synthetic */ PlayerChunkMap playerChunkMap;
    private final /* synthetic */ ChunkPos pos;
    private static final /* synthetic */ Logger LOGGER;
    private /* synthetic */ long lastUpdateInhabitedTime;
    @Nullable
    private /* synthetic */ Chunk chunk;
    private /* synthetic */ boolean sentToPlayers;
    private final /* synthetic */ List<EntityPlayerMP> players;
    private /* synthetic */ int changedSectionFilter;
    private /* synthetic */ int changes;
    private final /* synthetic */ short[] changedBlocks;
    
    private void sendBlockEntity(@Nullable final TileEntity lllllllllllIllIlllllIllIIllIIIIl) {
        if (lllllllllllIllIlllllIllIIllIIIIl != null) {
            final SPacketUpdateTileEntity lllllllllllIllIlllllIllIIllIIIII = lllllllllllIllIlllllIllIIllIIIIl.getUpdatePacket();
            if (lllllllllllIllIlllllIllIIllIIIII != null) {
                this.sendPacket(lllllllllllIllIlllllIllIIllIIIII);
            }
        }
    }
    
    public void blockChanged(final int lllllllllllIllIlllllIllIlIIIllll, final int lllllllllllIllIlllllIllIlIIIlllI, final int lllllllllllIllIlllllIllIlIIIIlll) {
        if (this.sentToPlayers) {
            if (this.changes == 0) {
                this.playerChunkMap.addEntry(this);
            }
            this.changedSectionFilter |= 1 << (lllllllllllIllIlllllIllIlIIIlllI >> 4);
            if (this.changes < 64) {
                final short lllllllllllIllIlllllIllIlIIIllII = (short)(lllllllllllIllIlllllIllIlIIIllll << 12 | lllllllllllIllIlllllIllIlIIIIlll << 8 | lllllllllllIllIlllllIllIlIIIlllI);
                for (int lllllllllllIllIlllllIllIlIIIlIll = 0; lllllllllllIllIlllllIllIlIIIlIll < this.changes; ++lllllllllllIllIlllllIllIlIIIlIll) {
                    if (this.changedBlocks[lllllllllllIllIlllllIllIlIIIlIll] == lllllllllllIllIlllllIllIlIIIllII) {
                        return;
                    }
                }
                this.changedBlocks[this.changes++] = lllllllllllIllIlllllIllIlIIIllII;
            }
        }
    }
    
    public boolean sendToPlayers() {
        if (this.sentToPlayers) {
            return true;
        }
        if (this.chunk == null) {
            return false;
        }
        if (!this.chunk.isPopulated()) {
            return false;
        }
        this.changes = 0;
        this.changedSectionFilter = 0;
        this.sentToPlayers = true;
        final Packet<?> lllllllllllIllIlllllIllIlIlIlIII = new SPacketChunkData(this.chunk, 65535);
        for (final EntityPlayerMP lllllllllllIllIlllllIllIlIlIIlll : this.players) {
            lllllllllllIllIlllllIllIlIlIIlll.connection.sendPacket(lllllllllllIllIlllllIllIlIlIlIII);
            this.playerChunkMap.getWorldServer().getEntityTracker().sendLeashedEntitiesInChunk(lllllllllllIllIlllllIllIlIlIIlll, this.chunk);
        }
        return true;
    }
    
    public void addPlayer(final EntityPlayerMP lllllllllllIllIlllllIllIlIlllIlI) {
        if (this.players.contains(lllllllllllIllIlllllIllIlIlllIlI)) {
            PlayerChunkMapEntry.LOGGER.debug("Failed to add player. {} already is in chunk {}, {}", (Object)lllllllllllIllIlllllIllIlIlllIlI, (Object)this.pos.chunkXPos, (Object)this.pos.chunkZPos);
        }
        else {
            if (this.players.isEmpty()) {
                this.lastUpdateInhabitedTime = this.playerChunkMap.getWorldServer().getTotalWorldTime();
            }
            this.players.add(lllllllllllIllIlllllIllIlIlllIlI);
            if (this.sentToPlayers) {
                this.sendNearbySpecialEntities(lllllllllllIllIlllllIllIlIlllIlI);
            }
        }
    }
    
    public ChunkPos getPos() {
        return this.pos;
    }
    
    public double getClosestPlayerDistance() {
        double lllllllllllIllIlllllIllIIIllIIlI = Double.MAX_VALUE;
        for (final EntityPlayerMP lllllllllllIllIlllllIllIIIllIIIl : this.players) {
            final double lllllllllllIllIlllllIllIIIllIIII = this.pos.getDistanceSq(lllllllllllIllIlllllIllIIIllIIIl);
            if (lllllllllllIllIlllllIllIIIllIIII < lllllllllllIllIlllllIllIIIllIIlI) {
                lllllllllllIllIlllllIllIIIllIIlI = lllllllllllIllIlllllIllIIIllIIII;
            }
        }
        return lllllllllllIllIlllllIllIIIllIIlI;
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    public boolean hasPlayerMatchingInRange(final double lllllllllllIllIlllllIllIIlIIIIll, final Predicate<EntityPlayerMP> lllllllllllIllIlllllIllIIlIIlIII) {
        for (int lllllllllllIllIlllllIllIIlIIIlll = 0, lllllllllllIllIlllllIllIIlIIIllI = this.players.size(); lllllllllllIllIlllllIllIIlIIIlll < lllllllllllIllIlllllIllIIlIIIllI; ++lllllllllllIllIlllllIllIIlIIIlll) {
            final EntityPlayerMP lllllllllllIllIlllllIllIIlIIIlIl = this.players.get(lllllllllllIllIlllllIllIIlIIIlll);
            if (lllllllllllIllIlllllIllIIlIIlIII.apply((Object)lllllllllllIllIlllllIllIIlIIIlIl) && this.pos.getDistanceSq(lllllllllllIllIlllllIllIIlIIIlIl) < lllllllllllIllIlllllIllIIlIIIIll * lllllllllllIllIlllllIllIIlIIIIll) {
                return true;
            }
        }
        return false;
    }
    
    public void sendPacket(final Packet<?> lllllllllllIllIlllllIllIIlllllIl) {
        if (this.sentToPlayers) {
            for (int lllllllllllIllIlllllIllIIlllllll = 0; lllllllllllIllIlllllIllIIlllllll < this.players.size(); ++lllllllllllIllIlllllIllIIlllllll) {
                this.players.get(lllllllllllIllIlllllIllIIlllllll).connection.sendPacket(lllllllllllIllIlllllIllIIlllllIl);
            }
        }
    }
    
    public void sendNearbySpecialEntities(final EntityPlayerMP lllllllllllIllIlllllIllIlIIlllll) {
        if (this.sentToPlayers) {
            lllllllllllIllIlllllIllIlIIlllll.connection.sendPacket(new SPacketChunkData(this.chunk, 65535));
            this.playerChunkMap.getWorldServer().getEntityTracker().sendLeashedEntitiesInChunk(lllllllllllIllIlllllIllIlIIlllll, this.chunk);
        }
    }
    
    public PlayerChunkMapEntry(final PlayerChunkMap lllllllllllIllIlllllIllIllIIIlIl, final int lllllllllllIllIlllllIllIllIIlIII, final int lllllllllllIllIlllllIllIllIIIIll) {
        this.players = (List<EntityPlayerMP>)Lists.newArrayList();
        this.changedBlocks = new short[64];
        this.playerChunkMap = lllllllllllIllIlllllIllIllIIIlIl;
        this.pos = new ChunkPos(lllllllllllIllIlllllIllIllIIlIII, lllllllllllIllIlllllIllIllIIIIll);
        this.chunk = lllllllllllIllIlllllIllIllIIIlIl.getWorldServer().getChunkProvider().loadChunk(lllllllllllIllIlllllIllIllIIlIII, lllllllllllIllIlllllIllIllIIIIll);
    }
    
    public boolean isSentToPlayers() {
        return this.sentToPlayers;
    }
    
    public boolean hasPlayerMatching(final Predicate<EntityPlayerMP> lllllllllllIllIlllllIllIIlIlIIll) {
        return Iterables.tryFind((Iterable)this.players, (Predicate)lllllllllllIllIlllllIllIIlIlIIll).isPresent();
    }
    
    public void updateChunkInhabitedTime() {
        final long lllllllllllIllIlllllIllIlIIllIIl = this.playerChunkMap.getWorldServer().getTotalWorldTime();
        if (this.chunk != null) {
            this.chunk.setInhabitedTime(this.chunk.getInhabitedTime() + lllllllllllIllIlllllIllIlIIllIIl - this.lastUpdateInhabitedTime);
        }
        this.lastUpdateInhabitedTime = lllllllllllIllIlllllIllIlIIllIIl;
    }
    
    @Nullable
    public Chunk getChunk() {
        return this.chunk;
    }
    
    public boolean providePlayerChunk(final boolean lllllllllllIllIlllllIllIlIlIlllI) {
        if (this.chunk != null) {
            return true;
        }
        if (lllllllllllIllIlllllIllIlIlIlllI) {
            this.chunk = this.playerChunkMap.getWorldServer().getChunkProvider().provideChunk(this.pos.chunkXPos, this.pos.chunkZPos);
        }
        else {
            this.chunk = this.playerChunkMap.getWorldServer().getChunkProvider().loadChunk(this.pos.chunkXPos, this.pos.chunkZPos);
        }
        return this.chunk != null;
    }
    
    public void removePlayer(final EntityPlayerMP lllllllllllIllIlllllIllIlIllIlII) {
        if (this.players.contains(lllllllllllIllIlllllIllIlIllIlII)) {
            if (this.sentToPlayers) {
                lllllllllllIllIlllllIllIlIllIlII.connection.sendPacket(new SPacketUnloadChunk(this.pos.chunkXPos, this.pos.chunkZPos));
            }
            this.players.remove(lllllllllllIllIlllllIllIlIllIlII);
            if (this.players.isEmpty()) {
                this.playerChunkMap.removeEntry(this);
            }
        }
    }
    
    public void update() {
        if (this.sentToPlayers && this.chunk != null && this.changes != 0) {
            if (this.changes == 1) {
                final int lllllllllllIllIlllllIllIIlllIlII = (this.changedBlocks[0] >> 12 & 0xF) + this.pos.chunkXPos * 16;
                final int lllllllllllIllIlllllIllIIlllIIll = this.changedBlocks[0] & 0xFF;
                final int lllllllllllIllIlllllIllIIlllIIlI = (this.changedBlocks[0] >> 8 & 0xF) + this.pos.chunkZPos * 16;
                final BlockPos lllllllllllIllIlllllIllIIlllIIIl = new BlockPos(lllllllllllIllIlllllIllIIlllIlII, lllllllllllIllIlllllIllIIlllIIll, lllllllllllIllIlllllIllIIlllIIlI);
                this.sendPacket(new SPacketBlockChange(this.playerChunkMap.getWorldServer(), lllllllllllIllIlllllIllIIlllIIIl));
                if (this.playerChunkMap.getWorldServer().getBlockState(lllllllllllIllIlllllIllIIlllIIIl).getBlock().hasTileEntity()) {
                    this.sendBlockEntity(this.playerChunkMap.getWorldServer().getTileEntity(lllllllllllIllIlllllIllIIlllIIIl));
                }
            }
            else if (this.changes == 64) {
                this.sendPacket(new SPacketChunkData(this.chunk, this.changedSectionFilter));
            }
            else {
                this.sendPacket(new SPacketMultiBlockChange(this.changes, this.changedBlocks, this.chunk));
                for (int lllllllllllIllIlllllIllIIlllIIII = 0; lllllllllllIllIlllllIllIIlllIIII < this.changes; ++lllllllllllIllIlllllIllIIlllIIII) {
                    final int lllllllllllIllIlllllIllIIllIllll = (this.changedBlocks[lllllllllllIllIlllllIllIIlllIIII] >> 12 & 0xF) + this.pos.chunkXPos * 16;
                    final int lllllllllllIllIlllllIllIIllIlllI = this.changedBlocks[lllllllllllIllIlllllIllIIlllIIII] & 0xFF;
                    final int lllllllllllIllIlllllIllIIllIllIl = (this.changedBlocks[lllllllllllIllIlllllIllIIlllIIII] >> 8 & 0xF) + this.pos.chunkZPos * 16;
                    final BlockPos lllllllllllIllIlllllIllIIllIllII = new BlockPos(lllllllllllIllIlllllIllIIllIllll, lllllllllllIllIlllllIllIIllIlllI, lllllllllllIllIlllllIllIIllIllIl);
                    if (this.playerChunkMap.getWorldServer().getBlockState(lllllllllllIllIlllllIllIIllIllII).getBlock().hasTileEntity()) {
                        this.sendBlockEntity(this.playerChunkMap.getWorldServer().getTileEntity(lllllllllllIllIlllllIllIIllIllII));
                    }
                }
            }
            this.changes = 0;
            this.changedSectionFilter = 0;
        }
    }
    
    public boolean containsPlayer(final EntityPlayerMP lllllllllllIllIlllllIllIIlIlIlll) {
        return this.players.contains(lllllllllllIllIlllllIllIIlIlIlll);
    }
}
