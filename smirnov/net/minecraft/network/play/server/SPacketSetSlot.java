// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import net.minecraft.network.INetHandler;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketSetSlot implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ ItemStack item;
    private /* synthetic */ int slot;
    private /* synthetic */ int windowId;
    
    public ItemStack getStack() {
        return this.item;
    }
    
    public int getWindowId() {
        return this.windowId;
    }
    
    public SPacketSetSlot() {
        this.item = ItemStack.field_190927_a;
    }
    
    public SPacketSetSlot(final int lllllllllllIlllIIIIIllIlllIlllIl, final int lllllllllllIlllIIIIIllIlllIlllII, final ItemStack lllllllllllIlllIIIIIllIlllIlllll) {
        this.item = ItemStack.field_190927_a;
        this.windowId = lllllllllllIlllIIIIIllIlllIlllIl;
        this.slot = lllllllllllIlllIIIIIllIlllIlllII;
        this.item = lllllllllllIlllIIIIIllIlllIlllll.copy();
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllIlllIIIIIllIlllIlIlll) {
        lllllllllllIlllIIIIIllIlllIlIlll.handleSetSlot(this);
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllIlllIIIIIllIlllIIlIll) throws IOException {
        lllllllllllIlllIIIIIllIlllIIlIll.writeByte(this.windowId);
        lllllllllllIlllIIIIIllIlllIIlIll.writeShort(this.slot);
        lllllllllllIlllIIIIIllIlllIIlIll.writeItemStackToBuffer(this.item);
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllIlllIIIIIllIlllIIllll) throws IOException {
        this.windowId = lllllllllllIlllIIIIIllIlllIIllll.readByte();
        this.slot = lllllllllllIlllIIIIIllIlllIIllll.readShort();
        this.item = lllllllllllIlllIIIIIllIlllIIllll.readItemStackFromBuffer();
    }
    
    public int getSlot() {
        return this.slot;
    }
}
