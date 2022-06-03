// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.client;

import net.minecraft.network.INetHandler;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.INetHandlerPlayServer;
import net.minecraft.network.Packet;

public class CPacketCreativeInventoryAction implements Packet<INetHandlerPlayServer>
{
    private /* synthetic */ ItemStack stack;
    private /* synthetic */ int slotId;
    
    public int getSlotId() {
        return this.slotId;
    }
    
    public CPacketCreativeInventoryAction(final int llllllllllllIlllIIllIIIIIlIlIlII, final ItemStack llllllllllllIlllIIllIIIIIlIlIIll) {
        this.stack = ItemStack.field_190927_a;
        this.slotId = llllllllllllIlllIIllIIIIIlIlIlII;
        this.stack = llllllllllllIlllIIllIIIIIlIlIIll.copy();
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllIlllIIllIIIIIlIIIlII) throws IOException {
        this.slotId = llllllllllllIlllIIllIIIIIlIIIlII.readShort();
        this.stack = llllllllllllIlllIIllIIIIIlIIIlII.readItemStackFromBuffer();
    }
    
    public ItemStack getStack() {
        return this.stack;
    }
    
    public CPacketCreativeInventoryAction() {
        this.stack = ItemStack.field_190927_a;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllIlllIIllIIIIIIlllllI) throws IOException {
        llllllllllllIlllIIllIIIIIIlllllI.writeShort(this.slotId);
        llllllllllllIlllIIllIIIIIIlllllI.writeItemStackToBuffer(this.stack);
    }
    
    @Override
    public void processPacket(final INetHandlerPlayServer llllllllllllIlllIIllIIIIIlIIlIlI) {
        llllllllllllIlllIIllIIIIIlIIlIlI.processCreativeInventoryAction(this);
    }
}
