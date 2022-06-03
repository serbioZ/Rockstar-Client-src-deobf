// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.login.client;

import java.io.IOException;
import java.util.UUID;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.INetHandler;
import com.mojang.authlib.GameProfile;
import net.minecraft.network.login.INetHandlerLoginServer;
import net.minecraft.network.Packet;

public class CPacketLoginStart implements Packet<INetHandlerLoginServer>
{
    private /* synthetic */ GameProfile profile;
    
    public GameProfile getProfile() {
        return this.profile;
    }
    
    @Override
    public void processPacket(final INetHandlerLoginServer lllIIlIIIIll) {
        lllIIlIIIIll.processLoginStart(this);
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllIIlIIllll) throws IOException {
        this.profile = new GameProfile((UUID)null, lllIIlIIllll.readStringFromBuffer(16));
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllIIlIIlIIl) throws IOException {
        lllIIlIIlIIl.writeString(this.profile.getName());
    }
    
    public CPacketLoginStart() {
    }
    
    public CPacketLoginStart(final GameProfile lllIIlIlIlIl) {
        this.profile = lllIIlIlIlIl;
    }
}
