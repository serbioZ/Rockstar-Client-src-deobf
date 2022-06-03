// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import net.minecraft.network.INetHandler;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.ChatType;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketChat implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ ChatType type;
    private /* synthetic */ ITextComponent chatComponent;
    
    public boolean isSystem() {
        return this.type == ChatType.SYSTEM || this.type == ChatType.GAME_INFO;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIlIIIlIIllllIIIlII) throws IOException {
        llllllllllllllIlIIIlIIllllIIIlII.writeTextComponent(this.chatComponent);
        llllllllllllllIlIIIlIIllllIIIlII.writeByte(this.type.func_192583_a());
    }
    
    public ITextComponent getChatComponent() {
        return this.chatComponent;
    }
    
    public SPacketChat(final ITextComponent llllllllllllllIlIIIlIIllllIllIll) {
        this(llllllllllllllIlIIIlIIllllIllIll, ChatType.SYSTEM);
    }
    
    public ChatType func_192590_c() {
        return this.type;
    }
    
    public SPacketChat(final ITextComponent llllllllllllllIlIIIlIIllllIlIlII, final ChatType llllllllllllllIlIIIlIIllllIlIIII) {
        this.chatComponent = llllllllllllllIlIIIlIIllllIlIlII;
        this.type = llllllllllllllIlIIIlIIllllIlIIII;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIlIIIlIIllllIIllII) throws IOException {
        this.chatComponent = llllllllllllllIlIIIlIIllllIIllII.readTextComponent();
        this.type = ChatType.func_192582_a(llllllllllllllIlIIIlIIllllIIllII.readByte());
    }
    
    public SPacketChat() {
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient llllllllllllllIlIIIlIIlllIlllllI) {
        llllllllllllllIlIIIlIIlllIlllllI.handleChat(this);
    }
}
