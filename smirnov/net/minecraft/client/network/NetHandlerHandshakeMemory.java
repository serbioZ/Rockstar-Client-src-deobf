// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.network;

import net.minecraft.network.INetHandler;
import net.minecraft.server.network.NetHandlerLoginServer;
import net.minecraft.network.handshake.client.C00Handshake;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.network.NetworkManager;
import net.minecraft.server.MinecraftServer;
import net.minecraft.network.handshake.INetHandlerHandshakeServer;

public class NetHandlerHandshakeMemory implements INetHandlerHandshakeServer
{
    private final /* synthetic */ MinecraftServer mcServer;
    private final /* synthetic */ NetworkManager networkManager;
    
    @Override
    public void onDisconnect(final ITextComponent llllllllllIlllIIIlIlllllllIIllIl) {
    }
    
    @Override
    public void processHandshake(final C00Handshake llllllllllIlllIIIlIlllllllIlIIIl) {
        this.networkManager.setConnectionState(llllllllllIlllIIIlIlllllllIlIIIl.getRequestedState());
        this.networkManager.setNetHandler(new NetHandlerLoginServer(this.mcServer, this.networkManager));
    }
    
    public NetHandlerHandshakeMemory(final MinecraftServer llllllllllIlllIIIlIlllllllIllIIl, final NetworkManager llllllllllIlllIIIlIlllllllIllIII) {
        this.mcServer = llllllllllIlllIIIlIlllllllIllIIl;
        this.networkManager = llllllllllIlllIIIlIlllllllIllIII;
    }
}
