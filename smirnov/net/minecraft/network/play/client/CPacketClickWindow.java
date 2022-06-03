// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.client;

import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.INetHandler;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.INetHandlerPlayServer;
import net.minecraft.network.Packet;

public class CPacketClickWindow implements Packet<INetHandlerPlayServer>
{
    private /* synthetic */ ItemStack clickedItem;
    private /* synthetic */ int usedButton;
    private /* synthetic */ ClickType mode;
    private /* synthetic */ int windowId;
    private /* synthetic */ int slotId;
    private /* synthetic */ short actionNumber;
    
    public int getSlotId() {
        return this.slotId;
    }
    
    public short getActionNumber() {
        return this.actionNumber;
    }
    
    public int getUsedButton() {
        return this.usedButton;
    }
    
    public ClickType getClickType() {
        return this.mode;
    }
    
    public CPacketClickWindow(final int llllllllllllIIllIllIIIIIIlIlIIII, final int llllllllllllIIllIllIIIIIIlIIllll, final int llllllllllllIIllIllIIIIIIlIlIlIl, final ClickType llllllllllllIIllIllIIIIIIlIIllIl, final ItemStack llllllllllllIIllIllIIIIIIlIlIIll, final short llllllllllllIIllIllIIIIIIlIlIIlI) {
        this.clickedItem = ItemStack.field_190927_a;
        this.windowId = llllllllllllIIllIllIIIIIIlIlIIII;
        this.slotId = llllllllllllIIllIllIIIIIIlIIllll;
        this.usedButton = llllllllllllIIllIllIIIIIIlIlIlIl;
        this.clickedItem = llllllllllllIIllIllIIIIIIlIlIIll.copy();
        this.actionNumber = llllllllllllIIllIllIIIIIIlIlIIlI;
        this.mode = llllllllllllIIllIllIIIIIIlIIllIl;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllIIllIllIIIIIIlIIIIIl) throws IOException {
        this.windowId = llllllllllllIIllIllIIIIIIlIIIIIl.readByte();
        this.slotId = llllllllllllIIllIllIIIIIIlIIIIIl.readShort();
        this.usedButton = llllllllllllIIllIllIIIIIIlIIIIIl.readByte();
        this.actionNumber = llllllllllllIIllIllIIIIIIlIIIIIl.readShort();
        this.mode = llllllllllllIIllIllIIIIIIlIIIIIl.readEnumValue(ClickType.class);
        this.clickedItem = llllllllllllIIllIllIIIIIIlIIIIIl.readItemStackFromBuffer();
    }
    
    public ItemStack getClickedItem() {
        return this.clickedItem;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllIIllIllIIIIIIIlllIll) throws IOException {
        llllllllllllIIllIllIIIIIIIlllIll.writeByte(this.windowId);
        llllllllllllIIllIllIIIIIIIlllIll.writeShort(this.slotId);
        llllllllllllIIllIllIIIIIIIlllIll.writeByte(this.usedButton);
        llllllllllllIIllIllIIIIIIIlllIll.writeShort(this.actionNumber);
        llllllllllllIIllIllIIIIIIIlllIll.writeEnumValue(this.mode);
        llllllllllllIIllIllIIIIIIIlllIll.writeItemStackToBuffer(this.clickedItem);
    }
    
    public CPacketClickWindow() {
        this.clickedItem = ItemStack.field_190927_a;
    }
    
    public int getWindowId() {
        return this.windowId;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayServer llllllllllllIIllIllIIIIIIlIIIlll) {
        llllllllllllIIllIllIIIIIIlIIIlll.processClickWindow(this);
    }
}
