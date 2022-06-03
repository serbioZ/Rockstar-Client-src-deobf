// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.login.server;

import java.io.IOException;
import java.util.UUID;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.INetHandler;
import com.mojang.authlib.GameProfile;
import net.minecraft.network.login.INetHandlerLoginClient;
import net.minecraft.network.Packet;

public class SPacketLoginSuccess implements Packet<INetHandlerLoginClient>
{
    private /* synthetic */ GameProfile profile;
    
    @Override
    public void processPacket(final INetHandlerLoginClient lllllllllllIIIIlIIIlIllllIIlIIll) {
        lllllllllllIIIIlIIIlIllllIIlIIll.handleLoginSuccess(this);
    }
    
    public SPacketLoginSuccess() {
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllIIIIlIIIlIllllIlIlIII) throws IOException {
        final String lllllllllllIIIIlIIIlIllllIlIIlll = lllllllllllIIIIlIIIlIllllIlIlIII.readStringFromBuffer(36);
        final String lllllllllllIIIIlIIIlIllllIlIIllI = lllllllllllIIIIlIIIlIllllIlIlIII.readStringFromBuffer(16);
        final UUID lllllllllllIIIIlIIIlIllllIlIIlIl = UUID.fromString(lllllllllllIIIIlIIIlIllllIlIIlll);
        this.profile = new GameProfile(lllllllllllIIIIlIIIlIllllIlIIlIl, lllllllllllIIIIlIIIlIllllIlIIllI);
    }
    
    public GameProfile getProfile() {
        return this.profile;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllIIIIlIIIlIllllIIllIll) throws IOException {
        final UUID lllllllllllIIIIlIIIlIllllIIllIlI = this.profile.getId();
        lllllllllllIIIIlIIIlIllllIIllIll.writeString((lllllllllllIIIIlIIIlIllllIIllIlI == null) ? "" : lllllllllllIIIIlIIIlIllllIIllIlI.toString());
        lllllllllllIIIIlIIIlIllllIIllIll.writeString(this.profile.getName());
    }
    
    public SPacketLoginSuccess(final GameProfile lllllllllllIIIIlIIIlIllllIllIIIl) {
        this.profile = lllllllllllIIIIlIIIlIllllIllIIIl;
    }
}
