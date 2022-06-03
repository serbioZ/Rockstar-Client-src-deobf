// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.login.server;

import net.minecraft.network.INetHandler;
import net.minecraft.util.CryptManager;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import java.security.PublicKey;
import net.minecraft.network.login.INetHandlerLoginClient;
import net.minecraft.network.Packet;

public class SPacketEncryptionRequest implements Packet<INetHandlerLoginClient>
{
    private /* synthetic */ PublicKey publicKey;
    private /* synthetic */ String hashedServerId;
    private /* synthetic */ byte[] verifyToken;
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllIllIlIlllllIIIIIIIll) throws IOException {
        llllllllllllIllIlIlllllIIIIIIIll.writeString(this.hashedServerId);
        llllllllllllIllIlIlllllIIIIIIIll.writeByteArray(this.publicKey.getEncoded());
        llllllllllllIllIlIlllllIIIIIIIll.writeByteArray(this.verifyToken);
    }
    
    public String getServerId() {
        return this.hashedServerId;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllIllIlIlllllIIIIIlIIl) throws IOException {
        this.hashedServerId = llllllllllllIllIlIlllllIIIIIlIIl.readStringFromBuffer(20);
        this.publicKey = CryptManager.decodePublicKey(llllllllllllIllIlIlllllIIIIIlIIl.readByteArray());
        this.verifyToken = llllllllllllIllIlIlllllIIIIIlIIl.readByteArray();
    }
    
    public SPacketEncryptionRequest(final String llllllllllllIllIlIlllllIIIIlIIIl, final PublicKey llllllllllllIllIlIlllllIIIIlIlII, final byte[] llllllllllllIllIlIlllllIIIIIllll) {
        this.hashedServerId = llllllllllllIllIlIlllllIIIIlIIIl;
        this.publicKey = llllllllllllIllIlIlllllIIIIlIlII;
        this.verifyToken = llllllllllllIllIlIlllllIIIIIllll;
    }
    
    @Override
    public void processPacket(final INetHandlerLoginClient llllllllllllIllIlIllllIlllllllll) {
        llllllllllllIllIlIllllIlllllllll.handleEncryptionRequest(this);
    }
    
    public byte[] getVerifyToken() {
        return this.verifyToken;
    }
    
    public SPacketEncryptionRequest() {
    }
    
    public PublicKey getPublicKey() {
        return this.publicKey;
    }
}
