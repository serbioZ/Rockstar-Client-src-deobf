// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.scoreboard;

import net.minecraft.network.play.server.SPacketScoreboardObjective;
import com.google.common.collect.Lists;
import net.minecraft.network.play.server.SPacketDisplayObjective;
import net.minecraft.network.play.server.SPacketUpdateScore;
import java.util.Collection;
import net.minecraft.network.play.server.SPacketTeams;
import java.util.Arrays;
import java.util.List;
import net.minecraft.network.Packet;
import net.minecraft.entity.player.EntityPlayerMP;
import com.google.common.collect.Sets;
import net.minecraft.server.MinecraftServer;
import java.util.Set;

public class ServerScoreboard extends Scoreboard
{
    private /* synthetic */ Runnable[] dirtyRunnables;
    private final /* synthetic */ Set<ScoreObjective> addedObjectives;
    private final /* synthetic */ MinecraftServer scoreboardMCServer;
    
    protected void markSaveDataDirty() {
        final short lllllllllllIIIlllIlIlIlIIIIIlIIl;
        final double lllllllllllIIIlllIlIlIlIIIIIlIlI = ((Runnable[])(Object)(lllllllllllIIIlllIlIlIlIIIIIlIIl = (short)(Object)this.dirtyRunnables)).length;
        for (char lllllllllllIIIlllIlIlIlIIIIIlIll = '\0'; lllllllllllIIIlllIlIlIlIIIIIlIll < lllllllllllIIIlllIlIlIlIIIIIlIlI; ++lllllllllllIIIlllIlIlIlIIIIIlIll) {
            final Runnable lllllllllllIIIlllIlIlIlIIIIIlllI = lllllllllllIIIlllIlIlIlIIIIIlIIl[lllllllllllIIIlllIlIlIlIIIIIlIll];
            lllllllllllIIIlllIlIlIlIIIIIlllI.run();
        }
    }
    
    public ServerScoreboard(final MinecraftServer lllllllllllIIIlllIlIlIlIIlllIlIl) {
        this.addedObjectives = (Set<ScoreObjective>)Sets.newHashSet();
        this.dirtyRunnables = new Runnable[0];
        this.scoreboardMCServer = lllllllllllIIIlllIlIlIlIIlllIlIl;
    }
    
    public void sendDisplaySlotRemovalPackets(final ScoreObjective lllllllllllIIIlllIlIlIIlllIIllIl) {
        final List<Packet<?>> lllllllllllIIIlllIlIlIIlllIlIIIl = this.getDestroyPackets(lllllllllllIIIlllIlIlIIlllIIllIl);
        for (final EntityPlayerMP lllllllllllIIIlllIlIlIIlllIlIIII : this.scoreboardMCServer.getPlayerList().getPlayerList()) {
            for (final Packet<?> lllllllllllIIIlllIlIlIIlllIIllll : lllllllllllIIIlllIlIlIIlllIlIIIl) {
                lllllllllllIIIlllIlIlIIlllIlIIII.connection.sendPacket(lllllllllllIIIlllIlIlIIlllIIllll);
            }
        }
        this.addedObjectives.remove(lllllllllllIIIlllIlIlIIlllIIllIl);
    }
    
    @Override
    public boolean addPlayerToTeam(final String lllllllllllIIIlllIlIlIlIIlIIlIlI, final String lllllllllllIIIlllIlIlIlIIlIIllIl) {
        if (super.addPlayerToTeam(lllllllllllIIIlllIlIlIlIIlIIlIlI, lllllllllllIIIlllIlIlIlIIlIIllIl)) {
            final ScorePlayerTeam lllllllllllIIIlllIlIlIlIIlIIllII = this.getTeam(lllllllllllIIIlllIlIlIlIIlIIllIl);
            this.scoreboardMCServer.getPlayerList().sendPacketToAllPlayers(new SPacketTeams(lllllllllllIIIlllIlIlIlIIlIIllII, Arrays.asList(lllllllllllIIIlllIlIlIlIIlIIlIlI), 3));
            this.markSaveDataDirty();
            return true;
        }
        return false;
    }
    
    public void addObjective(final ScoreObjective lllllllllllIIIlllIlIlIIllllIllII) {
        final List<Packet<?>> lllllllllllIIIlllIlIlIIlllllIIII = this.getCreatePackets(lllllllllllIIIlllIlIlIIllllIllII);
        for (final EntityPlayerMP lllllllllllIIIlllIlIlIIllllIllll : this.scoreboardMCServer.getPlayerList().getPlayerList()) {
            for (final Packet<?> lllllllllllIIIlllIlIlIIllllIlllI : lllllllllllIIIlllIlIlIIlllllIIII) {
                lllllllllllIIIlllIlIlIIllllIllll.connection.sendPacket(lllllllllllIIIlllIlIlIIllllIlllI);
            }
        }
        this.addedObjectives.add(lllllllllllIIIlllIlIlIIllllIllII);
    }
    
    @Override
    public void broadcastScoreUpdate(final String lllllllllllIIIlllIlIlIlIIllIIIIl, final ScoreObjective lllllllllllIIIlllIlIlIlIIllIIIll) {
        super.broadcastScoreUpdate(lllllllllllIIIlllIlIlIlIIllIIIIl, lllllllllllIIIlllIlIlIlIIllIIIll);
        this.scoreboardMCServer.getPlayerList().sendPacketToAllPlayers(new SPacketUpdateScore(lllllllllllIIIlllIlIlIlIIllIIIIl, lllllllllllIIIlllIlIlIlIIllIIIll));
        this.markSaveDataDirty();
    }
    
    @Override
    public void broadcastTeamInfoUpdate(final ScorePlayerTeam lllllllllllIIIlllIlIlIlIIIlIIIIl) {
        super.broadcastTeamInfoUpdate(lllllllllllIIIlllIlIlIlIIIlIIIIl);
        this.scoreboardMCServer.getPlayerList().sendPacketToAllPlayers(new SPacketTeams(lllllllllllIIIlllIlIlIlIIIlIIIIl, 2));
        this.markSaveDataDirty();
    }
    
    @Override
    public void setObjectiveInDisplaySlot(final int lllllllllllIIIlllIlIlIlIIlIllIlI, final ScoreObjective lllllllllllIIIlllIlIlIlIIlIllIIl) {
        final ScoreObjective lllllllllllIIIlllIlIlIlIIlIllIII = this.getObjectiveInDisplaySlot(lllllllllllIIIlllIlIlIlIIlIllIlI);
        super.setObjectiveInDisplaySlot(lllllllllllIIIlllIlIlIlIIlIllIlI, lllllllllllIIIlllIlIlIlIIlIllIIl);
        if (lllllllllllIIIlllIlIlIlIIlIllIII != lllllllllllIIIlllIlIlIlIIlIllIIl && lllllllllllIIIlllIlIlIlIIlIllIII != null) {
            if (this.getObjectiveDisplaySlotCount(lllllllllllIIIlllIlIlIlIIlIllIII) > 0) {
                this.scoreboardMCServer.getPlayerList().sendPacketToAllPlayers(new SPacketDisplayObjective(lllllllllllIIIlllIlIlIlIIlIllIlI, lllllllllllIIIlllIlIlIlIIlIllIIl));
            }
            else {
                this.sendDisplaySlotRemovalPackets(lllllllllllIIIlllIlIlIlIIlIllIII);
            }
        }
        if (lllllllllllIIIlllIlIlIlIIlIllIIl != null) {
            if (this.addedObjectives.contains(lllllllllllIIIlllIlIlIlIIlIllIIl)) {
                this.scoreboardMCServer.getPlayerList().sendPacketToAllPlayers(new SPacketDisplayObjective(lllllllllllIIIlllIlIlIlIIlIllIlI, lllllllllllIIIlllIlIlIlIIlIllIIl));
            }
            else {
                this.addObjective(lllllllllllIIIlllIlIlIlIIlIllIIl);
            }
        }
        this.markSaveDataDirty();
    }
    
    public List<Packet<?>> getCreatePackets(final ScoreObjective lllllllllllIIIlllIlIlIlIIIIIIIlI) {
        final List<Packet<?>> lllllllllllIIIlllIlIlIlIIIIIIIIl = (List<Packet<?>>)Lists.newArrayList();
        lllllllllllIIIlllIlIlIlIIIIIIIIl.add(new SPacketScoreboardObjective(lllllllllllIIIlllIlIlIlIIIIIIIlI, 0));
        for (int lllllllllllIIIlllIlIlIlIIIIIIIII = 0; lllllllllllIIIlllIlIlIlIIIIIIIII < 19; ++lllllllllllIIIlllIlIlIlIIIIIIIII) {
            if (this.getObjectiveInDisplaySlot(lllllllllllIIIlllIlIlIlIIIIIIIII) == lllllllllllIIIlllIlIlIlIIIIIIIlI) {
                lllllllllllIIIlllIlIlIlIIIIIIIIl.add(new SPacketDisplayObjective(lllllllllllIIIlllIlIlIlIIIIIIIII, lllllllllllIIIlllIlIlIlIIIIIIIlI));
            }
        }
        for (final Score lllllllllllIIIlllIlIlIIlllllllll : this.getSortedScores(lllllllllllIIIlllIlIlIlIIIIIIIlI)) {
            lllllllllllIIIlllIlIlIlIIIIIIIIl.add(new SPacketUpdateScore(lllllllllllIIIlllIlIlIIlllllllll));
        }
        return lllllllllllIIIlllIlIlIlIIIIIIIIl;
    }
    
    @Override
    public void onScoreObjectiveRemoved(final ScoreObjective lllllllllllIIIlllIlIlIlIIIlIllIl) {
        super.onScoreObjectiveRemoved(lllllllllllIIIlllIlIlIlIIIlIllIl);
        if (this.addedObjectives.contains(lllllllllllIIIlllIlIlIlIIIlIllIl)) {
            this.sendDisplaySlotRemovalPackets(lllllllllllIIIlllIlIlIlIIIlIllIl);
        }
        this.markSaveDataDirty();
    }
    
    @Override
    public void broadcastTeamCreated(final ScorePlayerTeam lllllllllllIIIlllIlIlIlIIIlIlIIl) {
        super.broadcastTeamCreated(lllllllllllIIIlllIlIlIlIIIlIlIIl);
        this.scoreboardMCServer.getPlayerList().sendPacketToAllPlayers(new SPacketTeams(lllllllllllIIIlllIlIlIlIIIlIlIIl, 0));
        this.markSaveDataDirty();
    }
    
    @Override
    public void onScoreUpdated(final Score lllllllllllIIIlllIlIlIlIIlllIIIl) {
        super.onScoreUpdated(lllllllllllIIIlllIlIlIlIIlllIIIl);
        if (this.addedObjectives.contains(lllllllllllIIIlllIlIlIlIIlllIIIl.getObjective())) {
            this.scoreboardMCServer.getPlayerList().sendPacketToAllPlayers(new SPacketUpdateScore(lllllllllllIIIlllIlIlIlIIlllIIIl));
        }
        this.markSaveDataDirty();
    }
    
    @Override
    public void removePlayerFromTeam(final String lllllllllllIIIlllIlIlIlIIlIIIIII, final ScorePlayerTeam lllllllllllIIIlllIlIlIlIIIllllll) {
        super.removePlayerFromTeam(lllllllllllIIIlllIlIlIlIIlIIIIII, lllllllllllIIIlllIlIlIlIIIllllll);
        this.scoreboardMCServer.getPlayerList().sendPacketToAllPlayers(new SPacketTeams(lllllllllllIIIlllIlIlIlIIIllllll, Arrays.asList(lllllllllllIIIlllIlIlIlIIlIIIIII), 4));
        this.markSaveDataDirty();
    }
    
    public int getObjectiveDisplaySlotCount(final ScoreObjective lllllllllllIIIlllIlIlIIlllIIIIlI) {
        int lllllllllllIIIlllIlIlIIlllIIIIIl = 0;
        for (int lllllllllllIIIlllIlIlIIlllIIIIII = 0; lllllllllllIIIlllIlIlIIlllIIIIII < 19; ++lllllllllllIIIlllIlIlIIlllIIIIII) {
            if (this.getObjectiveInDisplaySlot(lllllllllllIIIlllIlIlIIlllIIIIII) == lllllllllllIIIlllIlIlIIlllIIIIlI) {
                ++lllllllllllIIIlllIlIlIIlllIIIIIl;
            }
        }
        return lllllllllllIIIlllIlIlIIlllIIIIIl;
    }
    
    @Override
    public void broadcastTeamRemove(final ScorePlayerTeam lllllllllllIIIlllIlIlIlIIIIllIll) {
        super.broadcastTeamRemove(lllllllllllIIIlllIlIlIlIIIIllIll);
        this.scoreboardMCServer.getPlayerList().sendPacketToAllPlayers(new SPacketTeams(lllllllllllIIIlllIlIlIlIIIIllIll, 1));
        this.markSaveDataDirty();
    }
    
    @Override
    public void onScoreObjectiveAdded(final ScoreObjective lllllllllllIIIlllIlIlIlIIIlllIll) {
        super.onScoreObjectiveAdded(lllllllllllIIIlllIlIlIlIIIlllIll);
        this.markSaveDataDirty();
    }
    
    public void addDirtyRunnable(final Runnable lllllllllllIIIlllIlIlIlIIIIlIlIl) {
        this.dirtyRunnables = Arrays.copyOf(this.dirtyRunnables, this.dirtyRunnables.length + 1);
        this.dirtyRunnables[this.dirtyRunnables.length - 1] = lllllllllllIIIlllIlIlIlIIIIlIlIl;
    }
    
    @Override
    public void broadcastScoreUpdate(final String lllllllllllIIIlllIlIlIlIIllIlIIl) {
        super.broadcastScoreUpdate(lllllllllllIIIlllIlIlIlIIllIlIIl);
        this.scoreboardMCServer.getPlayerList().sendPacketToAllPlayers(new SPacketUpdateScore(lllllllllllIIIlllIlIlIlIIllIlIIl));
        this.markSaveDataDirty();
    }
    
    @Override
    public void onObjectiveDisplayNameChanged(final ScoreObjective lllllllllllIIIlllIlIlIlIIIllIIll) {
        super.onObjectiveDisplayNameChanged(lllllllllllIIIlllIlIlIlIIIllIIll);
        if (this.addedObjectives.contains(lllllllllllIIIlllIlIlIlIIIllIIll)) {
            this.scoreboardMCServer.getPlayerList().sendPacketToAllPlayers(new SPacketScoreboardObjective(lllllllllllIIIlllIlIlIlIIIllIIll, 2));
        }
        this.markSaveDataDirty();
    }
    
    public List<Packet<?>> getDestroyPackets(final ScoreObjective lllllllllllIIIlllIlIlIIllllIIIIl) {
        final List<Packet<?>> lllllllllllIIIlllIlIlIIllllIIIII = (List<Packet<?>>)Lists.newArrayList();
        lllllllllllIIIlllIlIlIIllllIIIII.add(new SPacketScoreboardObjective(lllllllllllIIIlllIlIlIIllllIIIIl, 1));
        for (int lllllllllllIIIlllIlIlIIlllIlllll = 0; lllllllllllIIIlllIlIlIIlllIlllll < 19; ++lllllllllllIIIlllIlIlIIlllIlllll) {
            if (this.getObjectiveInDisplaySlot(lllllllllllIIIlllIlIlIIlllIlllll) == lllllllllllIIIlllIlIlIIllllIIIIl) {
                lllllllllllIIIlllIlIlIIllllIIIII.add(new SPacketDisplayObjective(lllllllllllIIIlllIlIlIIlllIlllll, lllllllllllIIIlllIlIlIIllllIIIIl));
            }
        }
        return lllllllllllIIIlllIlIlIIllllIIIII;
    }
}
