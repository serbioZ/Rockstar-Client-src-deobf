// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.login.client;

import net.minecraft.network.INetHandler;
import java.security.PublicKey;
import javax.crypto.SecretKey;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import java.security.Key;
import net.minecraft.util.CryptManager;
import java.security.PrivateKey;
import net.minecraft.network.login.INetHandlerLoginServer;
import net.minecraft.network.Packet;

public class CPacketEncryptionResponse implements Packet<INetHandlerLoginServer>
{
    private /* synthetic */ byte[] secretKeyEncrypted;
    private /* synthetic */ byte[] verifyTokenEncrypted;
    
    public byte[] getVerifyToken(final PrivateKey lllllllllllIIIlIlIIIlllIIllIIlIl) {
        return (lllllllllllIIIlIlIIIlllIIllIIlIl == null) ? this.verifyTokenEncrypted : CryptManager.decryptData(lllllllllllIIIlIlIIIlllIIllIIlIl, this.verifyTokenEncrypted);
    }
    
    public CPacketEncryptionResponse() {
        this.secretKeyEncrypted = new byte[0];
        this.verifyTokenEncrypted = new byte[0];
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllIIIlIlIIIlllIIlllIlll) throws IOException {
        lllllllllllIIIlIlIIIlllIIlllIlll.writeByteArray(this.secretKeyEncrypted);
        lllllllllllIIIlIlIIIlllIIlllIlll.writeByteArray(this.verifyTokenEncrypted);
    }
    
    public SecretKey getSecretKey(final PrivateKey lllllllllllIIIlIlIIIlllIIllIllIl) {
        return CryptManager.decryptSharedKey(lllllllllllIIIlIlIIIlllIIllIllIl, this.secretKeyEncrypted);
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllIIIlIlIIIlllIIlllllIl) throws IOException {
        this.secretKeyEncrypted = lllllllllllIIIlIlIIIlllIIlllllIl.readByteArray();
        this.verifyTokenEncrypted = lllllllllllIIIlIlIIIlllIIlllllIl.readByteArray();
    }
    
    public CPacketEncryptionResponse(final SecretKey lllllllllllIIIlIlIIIlllIlIIIIlIl, final PublicKey lllllllllllIIIlIlIIIlllIlIIIlIII, final byte[] lllllllllllIIIlIlIIIlllIlIIIIIll) {
        this.secretKeyEncrypted = new byte[0];
        this.verifyTokenEncrypted = new byte[0];
        this.secretKeyEncrypted = CryptManager.encryptData(lllllllllllIIIlIlIIIlllIlIIIlIII, lllllllllllIIIlIlIIIlllIlIIIIlIl.getEncoded());
        this.verifyTokenEncrypted = CryptManager.encryptData(lllllllllllIIIlIlIIIlllIlIIIlIII, lllllllllllIIIlIlIIIlllIlIIIIIll);
    }
    
    @Override
    public void processPacket(final INetHandlerLoginServer lllllllllllIIIlIlIIIlllIIlllIIll) {
        lllllllllllIIIlIlIIIlllIIlllIIll.processEncryptionResponse(this);
    }
}
