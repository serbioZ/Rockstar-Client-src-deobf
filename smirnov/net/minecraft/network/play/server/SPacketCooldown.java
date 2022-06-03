// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import net.minecraft.network.INetHandler;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.item.Item;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketCooldown implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ Item item;
    private /* synthetic */ int ticks;
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllIIllllIlIIIllIlIlIIl) throws IOException {
        this.item = Item.getItemById(llllllllllllIIllllIlIIIllIlIlIIl.readVarIntFromBuffer());
        this.ticks = llllllllllllIIllllIlIIIllIlIlIIl.readVarIntFromBuffer();
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient llllllllllllIIllllIlIIIllIIlllIl) {
        llllllllllllIIllllIlIIIllIIlllIl.handleCooldown(this);
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllIIllllIlIIIllIlIIlIl) throws IOException {
        llllllllllllIIllllIlIIIllIlIIlIl.writeVarIntToBuffer(Item.getIdFromItem(this.item));
        llllllllllllIIllllIlIIIllIlIIlIl.writeVarIntToBuffer(this.ticks);
    }
    
    public int getTicks() {
        return this.ticks;
    }
    
    public SPacketCooldown(final Item llllllllllllIIllllIlIIIllIllIIll, final int llllllllllllIIllllIlIIIllIllIIlI) {
        this.item = llllllllllllIIllllIlIIIllIllIIll;
        this.ticks = llllllllllllIIllllIlIIIllIllIIlI;
    }
    
    public SPacketCooldown() {
    }
    
    public Item getItem() {
        return this.item;
    }
}
