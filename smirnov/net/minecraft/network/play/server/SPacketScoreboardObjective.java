// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import net.minecraft.scoreboard.ScoreObjective;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.INetHandler;
import net.minecraft.scoreboard.IScoreCriteria;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketScoreboardObjective implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ String objectiveName;
    private /* synthetic */ IScoreCriteria.EnumRenderType type;
    private /* synthetic */ String objectiveValue;
    private /* synthetic */ int action;
    
    public String getObjectiveValue() {
        return this.objectiveValue;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllIIIlIIlIlIlIIlIlllII) throws IOException {
        this.objectiveName = llllllllllllIIIlIIlIlIlIIlIlllII.readStringFromBuffer(16);
        this.action = llllllllllllIIIlIIlIlIlIIlIlllII.readByte();
        if (this.action == 0 || this.action == 2) {
            this.objectiveValue = llllllllllllIIIlIIlIlIlIIlIlllII.readStringFromBuffer(32);
            this.type = IScoreCriteria.EnumRenderType.getByName(llllllllllllIIIlIIlIlIlIIlIlllII.readStringFromBuffer(16));
        }
    }
    
    public SPacketScoreboardObjective(final ScoreObjective llllllllllllIIIlIIlIlIlIIllIIlII, final int llllllllllllIIIlIIlIlIlIIllIIIII) {
        this.objectiveName = llllllllllllIIIlIIlIlIlIIllIIlII.getName();
        this.objectiveValue = llllllllllllIIIlIIlIlIlIIllIIlII.getDisplayName();
        this.type = llllllllllllIIIlIIlIlIlIIllIIlII.getCriteria().getRenderType();
        this.action = llllllllllllIIIlIIlIlIlIIllIIIII;
    }
    
    public int getAction() {
        return this.action;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllIIIlIIlIlIlIIlIlIllI) throws IOException {
        llllllllllllIIIlIIlIlIlIIlIlIllI.writeString(this.objectiveName);
        llllllllllllIIIlIIlIlIlIIlIlIllI.writeByte(this.action);
        if (this.action == 0 || this.action == 2) {
            llllllllllllIIIlIIlIlIlIIlIlIllI.writeString(this.objectiveValue);
            llllllllllllIIIlIIlIlIlIIlIlIllI.writeString(this.type.getRenderType());
        }
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient llllllllllllIIIlIIlIlIlIIlIIlllI) {
        llllllllllllIIIlIIlIlIlIIlIIlllI.handleScoreboardObjective(this);
    }
    
    public String getObjectiveName() {
        return this.objectiveName;
    }
    
    public IScoreCriteria.EnumRenderType getRenderType() {
        return this.type;
    }
    
    public SPacketScoreboardObjective() {
    }
}
