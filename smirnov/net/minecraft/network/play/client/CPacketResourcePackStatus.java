// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.client;

import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.INetHandler;
import net.minecraft.network.play.INetHandlerPlayServer;
import net.minecraft.network.Packet;

public class CPacketResourcePackStatus implements Packet<INetHandlerPlayServer>
{
    private /* synthetic */ Action action;
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllIlllIIIIlIIlIlIIllIl) throws IOException {
        this.action = llllllllllllIlllIIIIlIIlIlIIllIl.readEnumValue(Action.class);
    }
    
    public CPacketResourcePackStatus() {
    }
    
    public CPacketResourcePackStatus(final Action llllllllllllIlllIIIIlIIlIlIlIIll) {
        this.action = llllllllllllIlllIIIIlIIlIlIlIIll;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayServer llllllllllllIlllIIIIlIIlIIllllll) {
        llllllllllllIlllIIIIlIIlIIllllll.handleResourcePackStatus(this);
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllIlllIIIIlIIlIlIIIlll) throws IOException {
        llllllllllllIlllIIIIlIIlIlIIIlll.writeEnumValue(this.action);
    }
    
    public enum Action
    {
        FAILED_DOWNLOAD("FAILED_DOWNLOAD", 2), 
        ACCEPTED("ACCEPTED", 3), 
        SUCCESSFULLY_LOADED("SUCCESSFULLY_LOADED", 0), 
        DECLINED("DECLINED", 1);
        
        private Action(final String lllllllllllllIllIIIlIIllIllIlIII, final int lllllllllllllIllIIIlIIllIllIIlll) {
        }
    }
}
