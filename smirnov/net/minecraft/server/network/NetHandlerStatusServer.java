// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.server.network;

import net.minecraft.network.status.server.SPacketServerInfo;
import net.minecraft.network.status.client.CPacketServerQuery;
import net.minecraft.network.Packet;
import net.minecraft.network.status.server.SPacketPong;
import net.minecraft.network.status.client.CPacketPing;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.server.MinecraftServer;
import net.minecraft.network.NetworkManager;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.network.status.INetHandlerStatusServer;

public class NetHandlerStatusServer implements INetHandlerStatusServer
{
    private /* synthetic */ boolean handled;
    private static final /* synthetic */ ITextComponent EXIT_MESSAGE;
    private final /* synthetic */ NetworkManager networkManager;
    private final /* synthetic */ MinecraftServer server;
    
    static {
        EXIT_MESSAGE = new TextComponentString("Status request has been handled.");
    }
    
    @Override
    public void processPing(final CPacketPing lllllllllllIIIIIlIlIlIllIlllIlII) {
        this.networkManager.sendPacket(new SPacketPong(lllllllllllIIIIIlIlIlIllIlllIlII.getClientTime()));
        this.networkManager.closeChannel(NetHandlerStatusServer.EXIT_MESSAGE);
    }
    
    public NetHandlerStatusServer(final MinecraftServer lllllllllllIIIIIlIlIlIlllIIIIIlI, final NetworkManager lllllllllllIIIIIlIlIlIllIllllllI) {
        this.server = lllllllllllIIIIIlIlIlIlllIIIIIlI;
        this.networkManager = lllllllllllIIIIIlIlIlIllIllllllI;
    }
    
    @Override
    public void processServerQuery(final CPacketServerQuery lllllllllllIIIIIlIlIlIllIllllIIl) {
        if (this.handled) {
            this.networkManager.closeChannel(NetHandlerStatusServer.EXIT_MESSAGE);
        }
        else {
            this.handled = true;
            this.networkManager.sendPacket(new SPacketServerInfo(this.server.getServerStatusResponse()));
        }
    }
    
    @Override
    public void onDisconnect(final ITextComponent lllllllllllIIIIIlIlIlIllIlllllII) {
    }
}
