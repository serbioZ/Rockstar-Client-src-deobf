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

public class SPacketPlayerListHeaderFooter implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ ITextComponent footer;
    private /* synthetic */ ITextComponent header;
    
    public ITextComponent getHeader() {
        return this.header;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient llllllllllllIIIlIIIllIIIlIIlIIII) {
        llllllllllllIIIlIIIllIIIlIIlIIII.handlePlayerListHeaderFooter(this);
    }
    
    public ITextComponent getFooter() {
        return this.footer;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllIIIlIIIllIIIlIIlllII) throws IOException {
        this.header = llllllllllllIIIlIIIllIIIlIIlllII.readTextComponent();
        this.footer = llllllllllllIIIlIIIllIIIlIIlllII.readTextComponent();
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllIIIlIIIllIIIlIIlIlII) throws IOException {
        llllllllllllIIIlIIIllIIIlIIlIlII.writeTextComponent(this.header);
        llllllllllllIIIlIIIllIIIlIIlIlII.writeTextComponent(this.footer);
    }
}
