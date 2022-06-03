// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.client;

import net.minecraft.entity.Entity;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.INetHandler;
import net.minecraft.network.play.INetHandlerPlayServer;
import net.minecraft.network.Packet;

public class CPacketEntityAction implements Packet<INetHandlerPlayServer>
{
    private /* synthetic */ Action action;
    private /* synthetic */ int auxData;
    private /* synthetic */ int entityID;
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllIlllIIlllIIIllllIlIl) throws IOException {
        this.entityID = llllllllllllIlllIIlllIIIllllIlIl.readVarIntFromBuffer();
        this.action = llllllllllllIlllIIlllIIIllllIlIl.readEnumValue(Action.class);
        this.auxData = llllllllllllIlllIIlllIIIllllIlIl.readVarIntFromBuffer();
    }
    
    public CPacketEntityAction() {
    }
    
    public Action getAction() {
        return this.action;
    }
    
    public CPacketEntityAction(final Entity llllllllllllIlllIIlllIIIllllllll, final Action llllllllllllIlllIIlllIIIlllllIlI, final int llllllllllllIlllIIlllIIIllllllIl) {
        this.entityID = llllllllllllIlllIIlllIIIllllllll.getEntityId();
        this.action = llllllllllllIlllIIlllIIIlllllIlI;
        this.auxData = llllllllllllIlllIIlllIIIllllllIl;
    }
    
    public CPacketEntityAction(final Entity llllllllllllIlllIIlllIIlIIIIIllI, final Action llllllllllllIlllIIlllIIlIIIIIlIl) {
        this(llllllllllllIlllIIlllIIlIIIIIllI, llllllllllllIlllIIlllIIlIIIIIlIl, 0);
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllIlllIIlllIIIlllIllIl) throws IOException {
        llllllllllllIlllIIlllIIIlllIllIl.writeVarIntToBuffer(this.entityID);
        llllllllllllIlllIIlllIIIlllIllIl.writeEnumValue(this.action);
        llllllllllllIlllIIlllIIIlllIllIl.writeVarIntToBuffer(this.auxData);
    }
    
    public int getAuxData() {
        return this.auxData;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayServer llllllllllllIlllIIlllIIIlllIlIIl) {
        llllllllllllIlllIIlllIIIlllIlIIl.processEntityAction(this);
    }
    
    public enum Action
    {
        STOP_SPRINTING("STOP_SPRINTING", 4), 
        START_FALL_FLYING("START_FALL_FLYING", 8), 
        STOP_RIDING_JUMP("STOP_RIDING_JUMP", 6), 
        OPEN_INVENTORY("OPEN_INVENTORY", 7), 
        START_SPRINTING("START_SPRINTING", 3), 
        STOP_SNEAKING("STOP_SNEAKING", 1), 
        STOP_SLEEPING("STOP_SLEEPING", 2), 
        START_RIDING_JUMP("START_RIDING_JUMP", 5), 
        START_SNEAKING("START_SNEAKING", 0);
        
        private Action(final String lllllllllllllllIIIIIIIlIIIIIIlIl, final int lllllllllllllllIIIIIIIlIIIIIIlII) {
        }
    }
}
