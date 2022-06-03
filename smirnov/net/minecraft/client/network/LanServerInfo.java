// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.network;

import net.minecraft.client.Minecraft;

public class LanServerInfo
{
    private /* synthetic */ long timeLastSeen;
    private final /* synthetic */ String lanServerIpPort;
    private final /* synthetic */ String lanServerMotd;
    
    public LanServerInfo(final String lIlIlllIIlIl, final String lIlIlllIIlII) {
        this.lanServerMotd = lIlIlllIIlIl;
        this.lanServerIpPort = lIlIlllIIlII;
        this.timeLastSeen = Minecraft.getSystemTime();
    }
    
    public void updateLastSeen() {
        this.timeLastSeen = Minecraft.getSystemTime();
    }
    
    public String getServerIpPort() {
        return this.lanServerIpPort;
    }
    
    public String getServerMotd() {
        return this.lanServerMotd;
    }
}
