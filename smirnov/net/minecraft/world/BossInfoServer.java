// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world;

import java.util.Collections;
import com.google.common.collect.Sets;
import net.minecraft.util.math.MathHelper;
import net.minecraft.network.Packet;
import java.util.Collection;
import com.google.common.base.Objects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.network.play.server.SPacketUpdateBossInfo;
import net.minecraft.entity.player.EntityPlayerMP;
import java.util.Set;

public class BossInfoServer extends BossInfo
{
    private final /* synthetic */ Set<EntityPlayerMP> players;
    private final /* synthetic */ Set<EntityPlayerMP> readOnlyPlayers;
    private /* synthetic */ boolean visible;
    
    @Override
    public BossInfo setDarkenSky(final boolean llllllllllllllllIIIlllIIIIlIIIll) {
        if (llllllllllllllllIIIlllIIIIlIIIll != this.darkenSky) {
            super.setDarkenSky(llllllllllllllllIIIlllIIIIlIIIll);
            this.sendUpdate(SPacketUpdateBossInfo.Operation.UPDATE_PROPERTIES);
        }
        return this;
    }
    
    @Override
    public void setName(final ITextComponent llllllllllllllllIIIlllIIIIIIllll) {
        if (!Objects.equal((Object)llllllllllllllllIIIlllIIIIIIllll, (Object)this.name)) {
            super.setName(llllllllllllllllIIIlllIIIIIIllll);
            this.sendUpdate(SPacketUpdateBossInfo.Operation.UPDATE_NAME);
        }
    }
    
    @Override
    public void setPercent(final float llllllllllllllllIIIlllIIIIllIlIl) {
        if (llllllllllllllllIIIlllIIIIllIlIl != this.percent) {
            super.setPercent(llllllllllllllllIIIlllIIIIllIlIl);
            this.sendUpdate(SPacketUpdateBossInfo.Operation.UPDATE_PCT);
        }
    }
    
    public Collection<EntityPlayerMP> getPlayers() {
        return this.readOnlyPlayers;
    }
    
    public void addPlayer(final EntityPlayerMP llllllllllllllllIIIllIlllllllIll) {
        if (this.players.add(llllllllllllllllIIIllIlllllllIll) && this.visible) {
            llllllllllllllllIIIllIlllllllIll.connection.sendPacket(new SPacketUpdateBossInfo(SPacketUpdateBossInfo.Operation.ADD, this));
        }
    }
    
    @Override
    public BossInfo setCreateFog(final boolean llllllllllllllllIIIlllIIIIIlIlll) {
        if (llllllllllllllllIIIlllIIIIIlIlll != this.createFog) {
            super.setCreateFog(llllllllllllllllIIIlllIIIIIlIlll);
            this.sendUpdate(SPacketUpdateBossInfo.Operation.UPDATE_PROPERTIES);
        }
        return this;
    }
    
    @Override
    public void setColor(final Color llllllllllllllllIIIlllIIIIlIllll) {
        if (llllllllllllllllIIIlllIIIIlIllll != this.color) {
            super.setColor(llllllllllllllllIIIlllIIIIlIllll);
            this.sendUpdate(SPacketUpdateBossInfo.Operation.UPDATE_STYLE);
        }
    }
    
    @Override
    public void setOverlay(final Overlay llllllllllllllllIIIlllIIIIlIlIIl) {
        if (llllllllllllllllIIIlllIIIIlIlIIl != this.overlay) {
            super.setOverlay(llllllllllllllllIIIlllIIIIlIlIIl);
            this.sendUpdate(SPacketUpdateBossInfo.Operation.UPDATE_STYLE);
        }
    }
    
    public void setVisible(final boolean llllllllllllllllIIIllIlllllIllll) {
        if (llllllllllllllllIIIllIlllllIllll != this.visible) {
            this.visible = llllllllllllllllIIIllIlllllIllll;
            for (final EntityPlayerMP llllllllllllllllIIIllIlllllIlllI : this.players) {
                llllllllllllllllIIIllIlllllIlllI.connection.sendPacket(new SPacketUpdateBossInfo(llllllllllllllllIIIllIlllllIllll ? SPacketUpdateBossInfo.Operation.ADD : SPacketUpdateBossInfo.Operation.REMOVE, this));
            }
        }
    }
    
    private void sendUpdate(final SPacketUpdateBossInfo.Operation llllllllllllllllIIIlllIIIIIIlIII) {
        if (this.visible) {
            final SPacketUpdateBossInfo llllllllllllllllIIIlllIIIIIIIlll = new SPacketUpdateBossInfo(llllllllllllllllIIIlllIIIIIIlIII, this);
            for (final EntityPlayerMP llllllllllllllllIIIlllIIIIIIIllI : this.players) {
                llllllllllllllllIIIlllIIIIIIIllI.connection.sendPacket(llllllllllllllllIIIlllIIIIIIIlll);
            }
        }
    }
    
    @Override
    public BossInfo setPlayEndBossMusic(final boolean llllllllllllllllIIIlllIIIIIlllIl) {
        if (llllllllllllllllIIIlllIIIIIlllIl != this.playEndBossMusic) {
            super.setPlayEndBossMusic(llllllllllllllllIIIlllIIIIIlllIl);
            this.sendUpdate(SPacketUpdateBossInfo.Operation.UPDATE_PROPERTIES);
        }
        return this;
    }
    
    public void removePlayer(final EntityPlayerMP llllllllllllllllIIIllIllllllIlll) {
        if (this.players.remove(llllllllllllllllIIIllIllllllIlll) && this.visible) {
            llllllllllllllllIIIllIllllllIlll.connection.sendPacket(new SPacketUpdateBossInfo(SPacketUpdateBossInfo.Operation.REMOVE, this));
        }
    }
    
    public BossInfoServer(final ITextComponent llllllllllllllllIIIlllIIIIllllll, final Color llllllllllllllllIIIlllIIIIlllIlI, final Overlay llllllllllllllllIIIlllIIIIllllIl) {
        super(MathHelper.getRandomUUID(), llllllllllllllllIIIlllIIIIllllll, llllllllllllllllIIIlllIIIIlllIlI, llllllllllllllllIIIlllIIIIllllIl);
        this.players = (Set<EntityPlayerMP>)Sets.newHashSet();
        this.readOnlyPlayers = Collections.unmodifiableSet((Set<? extends EntityPlayerMP>)this.players);
        this.visible = true;
    }
}
