// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import net.minecraft.network.INetHandler;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketOpenWindow implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ int entityId;
    private /* synthetic */ int windowId;
    private /* synthetic */ ITextComponent windowTitle;
    private /* synthetic */ int slotCount;
    private /* synthetic */ String inventoryType;
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllIllIIIIIIlIIlllIlIllI) throws IOException {
        lllllllllllIllIIIIIIlIIlllIlIllI.writeByte(this.windowId);
        lllllllllllIllIIIIIIlIIlllIlIllI.writeString(this.inventoryType);
        lllllllllllIllIIIIIIlIIlllIlIllI.writeTextComponent(this.windowTitle);
        lllllllllllIllIIIIIIlIIlllIlIllI.writeByte(this.slotCount);
        if (this.inventoryType.equals("EntityHorse")) {
            lllllllllllIllIIIIIIlIIlllIlIllI.writeInt(this.entityId);
        }
    }
    
    public String getGuiId() {
        return this.inventoryType;
    }
    
    public int getWindowId() {
        return this.windowId;
    }
    
    public int getSlotCount() {
        return this.slotCount;
    }
    
    public SPacketOpenWindow(final int lllllllllllIllIIIIIIlIIllllllIll, final String lllllllllllIllIIIIIIlIIllllllIlI, final ITextComponent lllllllllllIllIIIIIIlIIllllllllI, final int lllllllllllIllIIIIIIlIIllllllIII) {
        this.windowId = lllllllllllIllIIIIIIlIIllllllIll;
        this.inventoryType = lllllllllllIllIIIIIIlIIllllllIlI;
        this.windowTitle = lllllllllllIllIIIIIIlIIllllllllI;
        this.slotCount = lllllllllllIllIIIIIIlIIllllllIII;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllIllIIIIIIlIIllllIIIlI) {
        lllllllllllIllIIIIIIlIIllllIIIlI.handleOpenWindow(this);
    }
    
    public ITextComponent getWindowTitle() {
        return this.windowTitle;
    }
    
    public SPacketOpenWindow() {
    }
    
    public SPacketOpenWindow(final int lllllllllllIllIIIIIIlIIlllllIIII, final String lllllllllllIllIIIIIIlIIllllIllll, final ITextComponent lllllllllllIllIIIIIIlIIllllIlllI, final int lllllllllllIllIIIIIIlIIllllIllIl, final int lllllllllllIllIIIIIIlIIllllIllII) {
        this(lllllllllllIllIIIIIIlIIlllllIIII, lllllllllllIllIIIIIIlIIllllIllll, lllllllllllIllIIIIIIlIIllllIlllI, lllllllllllIllIIIIIIlIIllllIllIl);
        this.entityId = lllllllllllIllIIIIIIlIIllllIllII;
    }
    
    public SPacketOpenWindow(final int lllllllllllIllIIIIIIlIlIIIIIllIl, final String lllllllllllIllIIIIIIlIlIIIIIllII, final ITextComponent lllllllllllIllIIIIIIlIlIIIIIIlll) {
        this(lllllllllllIllIIIIIIlIlIIIIIllIl, lllllllllllIllIIIIIIlIlIIIIIllII, lllllllllllIllIIIIIIlIlIIIIIIlll, 0);
    }
    
    public boolean hasSlots() {
        return this.slotCount > 0;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllIllIIIIIIlIIlllIlllII) throws IOException {
        this.windowId = lllllllllllIllIIIIIIlIIlllIlllII.readUnsignedByte();
        this.inventoryType = lllllllllllIllIIIIIIlIIlllIlllII.readStringFromBuffer(32);
        this.windowTitle = lllllllllllIllIIIIIIlIIlllIlllII.readTextComponent();
        this.slotCount = lllllllllllIllIIIIIIlIIlllIlllII.readUnsignedByte();
        if (this.inventoryType.equals("EntityHorse")) {
            this.entityId = lllllllllllIllIIIIIIlIIlllIlllII.readInt();
        }
    }
    
    public int getEntityId() {
        return this.entityId;
    }
}
