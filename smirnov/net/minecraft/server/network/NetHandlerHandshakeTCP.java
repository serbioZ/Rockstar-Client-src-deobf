// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.server.network;

import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.login.server.SPacketDisconnect;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.network.handshake.client.C00Handshake;
import net.minecraft.network.EnumConnectionState;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.server.MinecraftServer;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.handshake.INetHandlerHandshakeServer;

public class NetHandlerHandshakeTCP implements INetHandlerHandshakeServer
{
    private final /* synthetic */ NetworkManager networkManager;
    private final /* synthetic */ MinecraftServer server;
    
    @Override
    public void onDisconnect(final ITextComponent llllllllllIlllIIIIllIIIlllIllIIl) {
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$network$EnumConnectionState() {
        final int[] $switch_TABLE$net$minecraft$network$EnumConnectionState = NetHandlerHandshakeTCP.$SWITCH_TABLE$net$minecraft$network$EnumConnectionState;
        if ($switch_TABLE$net$minecraft$network$EnumConnectionState != null) {
            return $switch_TABLE$net$minecraft$network$EnumConnectionState;
        }
        final char llllllllllIlllIIIIllIIIlllIlIlll = (Object)new int[EnumConnectionState.values().length];
        try {
            llllllllllIlllIIIIllIIIlllIlIlll[EnumConnectionState.HANDSHAKING.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllIlllIIIIllIIIlllIlIlll[EnumConnectionState.LOGIN.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllIlllIIIIllIIIlllIlIlll[EnumConnectionState.PLAY.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllIlllIIIIllIIIlllIlIlll[EnumConnectionState.STATUS.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return NetHandlerHandshakeTCP.$SWITCH_TABLE$net$minecraft$network$EnumConnectionState = (int[])(Object)llllllllllIlllIIIIllIIIlllIlIlll;
    }
    
    public NetHandlerHandshakeTCP(final MinecraftServer llllllllllIlllIIIIllIIIllllIIllI, final NetworkManager llllllllllIlllIIIIllIIIllllIIlIl) {
        this.server = llllllllllIlllIIIIllIIIllllIIllI;
        this.networkManager = llllllllllIlllIIIIllIIIllllIIlIl;
    }
    
    @Override
    public void processHandshake(final C00Handshake llllllllllIlllIIIIllIIIlllIlllII) {
        switch ($SWITCH_TABLE$net$minecraft$network$EnumConnectionState()[llllllllllIlllIIIIllIIIlllIlllII.getRequestedState().ordinal()]) {
            case 4: {
                this.networkManager.setConnectionState(EnumConnectionState.LOGIN);
                if (llllllllllIlllIIIIllIIIlllIlllII.getProtocolVersion() > 340) {
                    final ITextComponent llllllllllIlllIIIIllIIIlllIlllll = new TextComponentTranslation("multiplayer.disconnect.outdated_server", new Object[] { "1.12.2" });
                    this.networkManager.sendPacket(new SPacketDisconnect(llllllllllIlllIIIIllIIIlllIlllll));
                    this.networkManager.closeChannel(llllllllllIlllIIIIllIIIlllIlllll);
                    break;
                }
                if (llllllllllIlllIIIIllIIIlllIlllII.getProtocolVersion() < 340) {
                    final ITextComponent llllllllllIlllIIIIllIIIlllIllllI = new TextComponentTranslation("multiplayer.disconnect.outdated_client", new Object[] { "1.12.2" });
                    this.networkManager.sendPacket(new SPacketDisconnect(llllllllllIlllIIIIllIIIlllIllllI));
                    this.networkManager.closeChannel(llllllllllIlllIIIIllIIIlllIllllI);
                    break;
                }
                this.networkManager.setNetHandler(new NetHandlerLoginServer(this.server, this.networkManager));
                break;
            }
            case 3: {
                this.networkManager.setConnectionState(EnumConnectionState.STATUS);
                this.networkManager.setNetHandler(new NetHandlerStatusServer(this.server, this.networkManager));
                break;
            }
            default: {
                throw new UnsupportedOperationException("Invalid intention " + llllllllllIlllIIIIllIIIlllIlllII.getRequestedState());
            }
        }
    }
}
