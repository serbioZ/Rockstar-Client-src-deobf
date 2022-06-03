// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.network.INetHandler;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketUpdateScore implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ Action action;
    private /* synthetic */ int value;
    private /* synthetic */ String name;
    private /* synthetic */ String objective;
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllIllIllIlIIlllIlIlIl) throws IOException {
        lllllllllllllIllIllIlIIlllIlIlIl.writeString(this.name);
        lllllllllllllIllIllIlIIlllIlIlIl.writeEnumValue(this.action);
        lllllllllllllIllIllIlIIlllIlIlIl.writeString(this.objective);
        if (this.action != Action.REMOVE) {
            lllllllllllllIllIllIlIIlllIlIlIl.writeVarIntToBuffer(this.value);
        }
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllIllIllIlIIlllIllIIl) throws IOException {
        this.name = lllllllllllllIllIllIlIIlllIllIIl.readStringFromBuffer(40);
        this.action = lllllllllllllIllIllIlIIlllIllIIl.readEnumValue(Action.class);
        this.objective = lllllllllllllIllIllIlIIlllIllIIl.readStringFromBuffer(16);
        if (this.action != Action.REMOVE) {
            this.value = lllllllllllllIllIllIlIIlllIllIIl.readVarIntFromBuffer();
        }
    }
    
    public SPacketUpdateScore() {
        this.name = "";
        this.objective = "";
    }
    
    public int getScoreValue() {
        return this.value;
    }
    
    public SPacketUpdateScore(final String lllllllllllllIllIllIlIIllllIIIII, final ScoreObjective lllllllllllllIllIllIlIIlllIlllll) {
        this.name = "";
        this.objective = "";
        this.name = lllllllllllllIllIllIlIIllllIIIII;
        this.objective = lllllllllllllIllIllIlIIlllIlllll.getName();
        this.value = 0;
        this.action = Action.REMOVE;
    }
    
    public String getPlayerName() {
        return this.name;
    }
    
    public String getObjectiveName() {
        return this.objective;
    }
    
    public Action getScoreAction() {
        return this.action;
    }
    
    public SPacketUpdateScore(final Score lllllllllllllIllIllIlIIllllIlllI) {
        this.name = "";
        this.objective = "";
        this.name = lllllllllllllIllIllIlIIllllIlllI.getPlayerName();
        this.objective = lllllllllllllIllIllIlIIllllIlllI.getObjective().getName();
        this.value = lllllllllllllIllIllIlIIllllIlllI.getScorePoints();
        this.action = Action.CHANGE;
    }
    
    public SPacketUpdateScore(final String lllllllllllllIllIllIlIIllllIlIII) {
        this.name = "";
        this.objective = "";
        this.name = lllllllllllllIllIllIlIIllllIlIII;
        this.objective = "";
        this.value = 0;
        this.action = Action.REMOVE;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllllIllIllIlIIlllIIllIl) {
        lllllllllllllIllIllIlIIlllIIllIl.handleUpdateScore(this);
    }
    
    public enum Action
    {
        CHANGE("CHANGE", 0), 
        REMOVE("REMOVE", 1);
        
        private Action(final String lllllllllllIIIlIllIlIlIIlllllIll, final int lllllllllllIIIlIllIlIlIIlllllIlI) {
        }
    }
}
