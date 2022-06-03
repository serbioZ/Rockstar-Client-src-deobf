// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import net.minecraft.network.INetHandler;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import javax.annotation.Nullable;
import net.minecraft.util.ResourceLocation;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketSelectAdvancementsTab implements Packet<INetHandlerPlayClient>
{
    @Nullable
    private /* synthetic */ ResourceLocation field_194155_a;
    
    public SPacketSelectAdvancementsTab() {
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIlIlIlllIIlIIIIIIl) throws IOException {
        llllllllllllllIlIlIlllIIlIIIIIIl.writeBoolean(this.field_194155_a != null);
        if (this.field_194155_a != null) {
            llllllllllllllIlIlIlllIIlIIIIIIl.func_192572_a(this.field_194155_a);
        }
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIlIlIlllIIlIIIIlll) throws IOException {
        if (llllllllllllllIlIlIlllIIlIIIIlll.readBoolean()) {
            this.field_194155_a = llllllllllllllIlIlIlllIIlIIIIlll.func_192575_l();
        }
    }
    
    @Nullable
    public ResourceLocation func_194154_a() {
        return this.field_194155_a;
    }
    
    public SPacketSelectAdvancementsTab(@Nullable final ResourceLocation llllllllllllllIlIlIlllIIlIIlIlIl) {
        this.field_194155_a = llllllllllllllIlIlIlllIIlIIlIlIl;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient llllllllllllllIlIlIlllIIlIIIllIl) {
        llllllllllllllIlIlIlllIIlIIIllIl.func_194022_a(this);
    }
}
