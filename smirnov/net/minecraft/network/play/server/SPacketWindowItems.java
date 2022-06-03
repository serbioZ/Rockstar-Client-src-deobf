// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.INetHandler;
import net.minecraft.util.NonNullList;
import net.minecraft.item.ItemStack;
import java.util.List;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketWindowItems implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ List<ItemStack> itemStacks;
    private /* synthetic */ int windowId;
    
    public SPacketWindowItems(final int llllllllllIllllllllIIIIlIIIlIlll, final NonNullList<ItemStack> llllllllllIllllllllIIIIlIIIlIllI) {
        this.windowId = llllllllllIllllllllIIIIlIIIlIlll;
        this.itemStacks = NonNullList.func_191197_a(llllllllllIllllllllIIIIlIIIlIllI.size(), ItemStack.field_190927_a);
        for (int llllllllllIllllllllIIIIlIIIllIlI = 0; llllllllllIllllllllIIIIlIIIllIlI < this.itemStacks.size(); ++llllllllllIllllllllIIIIlIIIllIlI) {
            final ItemStack llllllllllIllllllllIIIIlIIIllIIl = llllllllllIllllllllIIIIlIIIlIllI.get(llllllllllIllllllllIIIIlIIIllIlI);
            this.itemStacks.set(llllllllllIllllllllIIIIlIIIllIlI, llllllllllIllllllllIIIIlIIIllIIl.copy());
        }
    }
    
    public int getWindowId() {
        return this.windowId;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient llllllllllIllllllllIIIIIllllIlll) {
        llllllllllIllllllllIIIIIllllIlll.handleWindowItems(this);
    }
    
    public SPacketWindowItems() {
    }
    
    public List<ItemStack> getItemStacks() {
        return this.itemStacks;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllIllllllllIIIIlIIIIlIlI) throws IOException {
        this.windowId = llllllllllIllllllllIIIIlIIIIlIlI.readUnsignedByte();
        final int llllllllllIllllllllIIIIlIIIIllIl = llllllllllIllllllllIIIIlIIIIlIlI.readShort();
        this.itemStacks = NonNullList.func_191197_a(llllllllllIllllllllIIIIlIIIIllIl, ItemStack.field_190927_a);
        for (int llllllllllIllllllllIIIIlIIIIllII = 0; llllllllllIllllllllIIIIlIIIIllII < llllllllllIllllllllIIIIlIIIIllIl; ++llllllllllIllllllllIIIIlIIIIllII) {
            this.itemStacks.set(llllllllllIllllllllIIIIlIIIIllII, llllllllllIllllllllIIIIlIIIIlIlI.readItemStackFromBuffer());
        }
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllIllllllllIIIIIllllllll) throws IOException {
        llllllllllIllllllllIIIIIllllllll.writeByte(this.windowId);
        llllllllllIllllllllIIIIIllllllll.writeShort(this.itemStacks.size());
        for (final ItemStack llllllllllIllllllllIIIIlIIIIIIIl : this.itemStacks) {
            llllllllllIllllllllIIIIIllllllll.writeItemStackToBuffer(llllllllllIllllllllIIIIlIIIIIIIl);
        }
    }
}
