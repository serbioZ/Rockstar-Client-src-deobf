// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import net.minecraft.network.INetHandler;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketDisplayObjective implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ String scoreName;
    private /* synthetic */ int position;
    
    public SPacketDisplayObjective(final int lllllllllllllIlIIIIllIIlllllIIII, final ScoreObjective lllllllllllllIlIIIIllIIllllIllll) {
        this.position = lllllllllllllIlIIIIllIIlllllIIII;
        if (lllllllllllllIlIIIIllIIllllIllll == null) {
            this.scoreName = "";
        }
        else {
            this.scoreName = lllllllllllllIlIIIIllIIllllIllll.getName();
        }
    }
    
    public SPacketDisplayObjective() {
    }
    
    public String getName() {
        return this.scoreName;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllIlIIIIllIIllllIIIII) throws IOException {
        lllllllllllllIlIIIIllIIllllIIIII.writeByte(this.position);
        lllllllllllllIlIIIIllIIllllIIIII.writeString(this.scoreName);
    }
    
    public int getPosition() {
        return this.position;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllIlIIIIllIIllllIlIII) throws IOException {
        this.position = lllllllllllllIlIIIIllIIllllIlIII.readByte();
        this.scoreName = lllllllllllllIlIIIIllIIllllIlIII.readStringFromBuffer(16);
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllllIlIIIIllIIlllIllIlI) {
        lllllllllllllIlIIIIllIIlllIllIlI.handleDisplayObjective(this);
    }
}
