// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.client;

import net.minecraft.network.INetHandler;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.network.play.INetHandlerPlayServer;
import net.minecraft.network.Packet;

public class CPacketPlayerDigging implements Packet<INetHandlerPlayServer>
{
    private /* synthetic */ EnumFacing facing;
    private /* synthetic */ BlockPos position;
    private /* synthetic */ Action action;
    
    @Override
    public void processPacket(final INetHandlerPlayServer llllllllllIllllIIIIlIIlIIlllllII) {
        llllllllllIllllIIIIlIIlIIlllllII.processPlayerDigging(this);
    }
    
    public CPacketPlayerDigging(final Action llllllllllIllllIIIIlIIlIlIIlIIlI, final BlockPos llllllllllIllllIIIIlIIlIlIIIllIl, final EnumFacing llllllllllIllllIIIIlIIlIlIIlIIII) {
        this.action = llllllllllIllllIIIIlIIlIlIIlIIlI;
        this.position = llllllllllIllllIIIIlIIlIlIIIllIl;
        this.facing = llllllllllIllllIIIIlIIlIlIIlIIII;
    }
    
    public EnumFacing getFacing() {
        return this.facing;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllIllllIIIIlIIlIlIIIIIlI) throws IOException {
        llllllllllIllllIIIIlIIlIlIIIIIlI.writeEnumValue(this.action);
        llllllllllIllllIIIIlIIlIlIIIIIlI.writeBlockPos(this.position);
        llllllllllIllllIIIIlIIlIlIIIIIlI.writeByte(this.facing.getIndex());
    }
    
    public BlockPos getPosition() {
        return this.position;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllIllllIIIIlIIlIlIIIIllI) throws IOException {
        this.action = llllllllllIllllIIIIlIIlIlIIIIllI.readEnumValue(Action.class);
        this.position = llllllllllIllllIIIIlIIlIlIIIIllI.readBlockPos();
        this.facing = EnumFacing.getFront(llllllllllIllllIIIIlIIlIlIIIIllI.readUnsignedByte());
    }
    
    public CPacketPlayerDigging() {
    }
    
    public Action getAction() {
        return this.action;
    }
    
    public enum Action
    {
        START_DESTROY_BLOCK("START_DESTROY_BLOCK", 0), 
        RELEASE_USE_ITEM("RELEASE_USE_ITEM", 5), 
        DROP_ALL_ITEMS("DROP_ALL_ITEMS", 3), 
        SWAP_HELD_ITEMS("SWAP_HELD_ITEMS", 6), 
        STOP_DESTROY_BLOCK("STOP_DESTROY_BLOCK", 2), 
        DROP_ITEM("DROP_ITEM", 4), 
        ABORT_DESTROY_BLOCK("ABORT_DESTROY_BLOCK", 1);
        
        private Action(final String llllllllllllIIllIIIlllIlIllIlIII, final int llllllllllllIIllIIIlllIlIllIIlll) {
        }
    }
}
