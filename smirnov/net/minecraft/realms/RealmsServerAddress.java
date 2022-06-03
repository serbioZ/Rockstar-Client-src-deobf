// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.realms;

import net.minecraft.client.multiplayer.ServerAddress;

public class RealmsServerAddress
{
    private final /* synthetic */ int port;
    private final /* synthetic */ String host;
    
    public int getPort() {
        return this.port;
    }
    
    public String getHost() {
        return this.host;
    }
    
    protected RealmsServerAddress(final String lllllllllllIIlIlIlIlIIllllIIIlll, final int lllllllllllIIlIlIlIlIIllllIIlIIl) {
        this.host = lllllllllllIIlIlIlIlIIllllIIIlll;
        this.port = lllllllllllIIlIlIlIlIIllllIIlIIl;
    }
    
    public static RealmsServerAddress parseString(final String lllllllllllIIlIlIlIlIIlllIllllIl) {
        final ServerAddress lllllllllllIIlIlIlIlIIlllIllllII = ServerAddress.fromString(lllllllllllIIlIlIlIlIIlllIllllIl);
        return new RealmsServerAddress(lllllllllllIIlIlIlIlIIlllIllllII.getIP(), lllllllllllIIlIlIlIlIIlllIllllII.getPort());
    }
}
