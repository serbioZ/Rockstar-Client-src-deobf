// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import net.minecraft.network.INetHandler;
import com.google.common.collect.Lists;
import net.minecraft.scoreboard.Team;
import net.minecraft.scoreboard.ScorePlayerTeam;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import java.util.Collection;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketTeams implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ String collisionRule;
    private /* synthetic */ String prefix;
    private /* synthetic */ String displayName;
    private final /* synthetic */ Collection<String> players;
    private /* synthetic */ String suffix;
    private /* synthetic */ String nameTagVisibility;
    private /* synthetic */ int action;
    private /* synthetic */ int color;
    private /* synthetic */ String name;
    private /* synthetic */ int friendlyFlags;
    
    public int getAction() {
        return this.action;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllIIlIIllIllllIIIllIlIl) throws IOException {
        lllllllllllIIlIIllIllllIIIllIlIl.writeString(this.name);
        lllllllllllIIlIIllIllllIIIllIlIl.writeByte(this.action);
        if (this.action == 0 || this.action == 2) {
            lllllllllllIIlIIllIllllIIIllIlIl.writeString(this.displayName);
            lllllllllllIIlIIllIllllIIIllIlIl.writeString(this.prefix);
            lllllllllllIIlIIllIllllIIIllIlIl.writeString(this.suffix);
            lllllllllllIIlIIllIllllIIIllIlIl.writeByte(this.friendlyFlags);
            lllllllllllIIlIIllIllllIIIllIlIl.writeString(this.nameTagVisibility);
            lllllllllllIIlIIllIllllIIIllIlIl.writeString(this.collisionRule);
            lllllllllllIIlIIllIllllIIIllIlIl.writeByte(this.color);
        }
        if (this.action == 0 || this.action == 3 || this.action == 4) {
            lllllllllllIIlIIllIllllIIIllIlIl.writeVarIntToBuffer(this.players.size());
            for (final String lllllllllllIIlIIllIllllIIIllIlII : this.players) {
                lllllllllllIIlIIllIllllIIIllIlIl.writeString(lllllllllllIIlIIllIllllIIIllIlII);
            }
        }
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getSuffix() {
        return this.suffix;
    }
    
    public SPacketTeams(final ScorePlayerTeam lllllllllllIIlIIllIllllIIlIIllIl, final Collection<String> lllllllllllIIlIIllIllllIIlIIlIII, final int lllllllllllIIlIIllIllllIIlIIlIll) {
        this.name = "";
        this.displayName = "";
        this.prefix = "";
        this.suffix = "";
        this.nameTagVisibility = Team.EnumVisible.ALWAYS.internalName;
        this.collisionRule = Team.CollisionRule.ALWAYS.name;
        this.color = -1;
        this.players = (Collection<String>)Lists.newArrayList();
        if (lllllllllllIIlIIllIllllIIlIIlIll != 3 && lllllllllllIIlIIllIllllIIlIIlIll != 4) {
            throw new IllegalArgumentException("Method must be join or leave for player constructor");
        }
        if (lllllllllllIIlIIllIllllIIlIIlIII != null && !lllllllllllIIlIIllIllllIIlIIlIII.isEmpty()) {
            this.action = lllllllllllIIlIIllIllllIIlIIlIll;
            this.name = lllllllllllIIlIIllIllllIIlIIllIl.getRegisteredName();
            this.players.addAll(lllllllllllIIlIIllIllllIIlIIlIII);
            return;
        }
        throw new IllegalArgumentException("Players cannot be null/empty");
    }
    
    public SPacketTeams() {
        this.name = "";
        this.displayName = "";
        this.prefix = "";
        this.suffix = "";
        this.nameTagVisibility = Team.EnumVisible.ALWAYS.internalName;
        this.collisionRule = Team.CollisionRule.ALWAYS.name;
        this.color = -1;
        this.players = (Collection<String>)Lists.newArrayList();
    }
    
    public String getDisplayName() {
        return this.displayName;
    }
    
    public Collection<String> getPlayers() {
        return this.players;
    }
    
    public int getColor() {
        return this.color;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllIIlIIllIllllIIIlIlIlI) {
        lllllllllllIIlIIllIllllIIIlIlIlI.handleTeams(this);
    }
    
    public String getCollisionRule() {
        return this.collisionRule;
    }
    
    public SPacketTeams(final ScorePlayerTeam lllllllllllIIlIIllIllllIIlIlIlII, final int lllllllllllIIlIIllIllllIIlIlIllI) {
        this.name = "";
        this.displayName = "";
        this.prefix = "";
        this.suffix = "";
        this.nameTagVisibility = Team.EnumVisible.ALWAYS.internalName;
        this.collisionRule = Team.CollisionRule.ALWAYS.name;
        this.color = -1;
        this.players = (Collection<String>)Lists.newArrayList();
        this.name = lllllllllllIIlIIllIllllIIlIlIlII.getRegisteredName();
        this.action = lllllllllllIIlIIllIllllIIlIlIllI;
        if (lllllllllllIIlIIllIllllIIlIlIllI == 0 || lllllllllllIIlIIllIllllIIlIlIllI == 2) {
            this.displayName = lllllllllllIIlIIllIllllIIlIlIlII.getTeamName();
            this.prefix = lllllllllllIIlIIllIllllIIlIlIlII.getColorPrefix();
            this.suffix = lllllllllllIIlIIllIllllIIlIlIlII.getColorSuffix();
            this.friendlyFlags = lllllllllllIIlIIllIllllIIlIlIlII.getFriendlyFlags();
            this.nameTagVisibility = lllllllllllIIlIIllIllllIIlIlIlII.getNameTagVisibility().internalName;
            this.collisionRule = lllllllllllIIlIIllIllllIIlIlIlII.getCollisionRule().name;
            this.color = lllllllllllIIlIIllIllllIIlIlIlII.getChatFormat().getColorIndex();
        }
        if (lllllllllllIIlIIllIllllIIlIlIllI == 0) {
            this.players.addAll(lllllllllllIIlIIllIllllIIlIlIlII.getMembershipCollection());
        }
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllIIlIIllIllllIIlIIIIIl) throws IOException {
        this.name = lllllllllllIIlIIllIllllIIlIIIIIl.readStringFromBuffer(16);
        this.action = lllllllllllIIlIIllIllllIIlIIIIIl.readByte();
        if (this.action == 0 || this.action == 2) {
            this.displayName = lllllllllllIIlIIllIllllIIlIIIIIl.readStringFromBuffer(32);
            this.prefix = lllllllllllIIlIIllIllllIIlIIIIIl.readStringFromBuffer(16);
            this.suffix = lllllllllllIIlIIllIllllIIlIIIIIl.readStringFromBuffer(16);
            this.friendlyFlags = lllllllllllIIlIIllIllllIIlIIIIIl.readByte();
            this.nameTagVisibility = lllllllllllIIlIIllIllllIIlIIIIIl.readStringFromBuffer(32);
            this.collisionRule = lllllllllllIIlIIllIllllIIlIIIIIl.readStringFromBuffer(32);
            this.color = lllllllllllIIlIIllIllllIIlIIIIIl.readByte();
        }
        if (this.action == 0 || this.action == 3 || this.action == 4) {
            for (int lllllllllllIIlIIllIllllIIlIIIIII = lllllllllllIIlIIllIllllIIlIIIIIl.readVarIntFromBuffer(), lllllllllllIIlIIllIllllIIIllllll = 0; lllllllllllIIlIIllIllllIIIllllll < lllllllllllIIlIIllIllllIIlIIIIII; ++lllllllllllIIlIIllIllllIIIllllll) {
                this.players.add(lllllllllllIIlIIllIllllIIlIIIIIl.readStringFromBuffer(40));
            }
        }
    }
    
    public String getPrefix() {
        return this.prefix;
    }
    
    public int getFriendlyFlags() {
        return this.friendlyFlags;
    }
    
    public String getNameTagVisibility() {
        return this.nameTagVisibility;
    }
}
