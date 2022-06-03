// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.status.server;

import net.minecraft.util.JsonUtils;
import com.google.gson.TypeAdapterFactory;
import net.minecraft.util.EnumTypeAdapterFactory;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.ITextComponent;
import java.lang.reflect.Type;
import com.google.gson.GsonBuilder;
import net.minecraft.network.INetHandler;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.ServerStatusResponse;
import com.google.gson.Gson;
import net.minecraft.network.status.INetHandlerStatusClient;
import net.minecraft.network.Packet;

public class SPacketServerInfo implements Packet<INetHandlerStatusClient>
{
    private static final /* synthetic */ Gson GSON;
    private /* synthetic */ ServerStatusResponse response;
    
    public ServerStatusResponse getResponse() {
        return this.response;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllIIlllIllllIIlIIIlllll) throws IOException {
        lllllllllllIIlllIllllIIlIIIlllll.writeString(SPacketServerInfo.GSON.toJson((Object)this.response));
    }
    
    public SPacketServerInfo(final ServerStatusResponse lllllllllllIIlllIllllIIlIIlIlIIl) {
        this.response = lllllllllllIIlllIllllIIlIIlIlIIl;
    }
    
    @Override
    public void processPacket(final INetHandlerStatusClient lllllllllllIIlllIllllIIlIIIlIlll) {
        lllllllllllIIlllIllllIIlIIIlIlll.handleServerInfo(this);
    }
    
    static {
        GSON = new GsonBuilder().registerTypeAdapter((Type)ServerStatusResponse.Version.class, (Object)new ServerStatusResponse.Version.Serializer()).registerTypeAdapter((Type)ServerStatusResponse.Players.class, (Object)new ServerStatusResponse.Players.Serializer()).registerTypeAdapter((Type)ServerStatusResponse.class, (Object)new ServerStatusResponse.Serializer()).registerTypeHierarchyAdapter((Class)ITextComponent.class, (Object)new ITextComponent.Serializer()).registerTypeHierarchyAdapter((Class)Style.class, (Object)new Style.Serializer()).registerTypeAdapterFactory((TypeAdapterFactory)new EnumTypeAdapterFactory()).create();
    }
    
    public SPacketServerInfo() {
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllIIlllIllllIIlIIlIIIll) throws IOException {
        this.response = JsonUtils.gsonDeserialize(SPacketServerInfo.GSON, lllllllllllIIlllIllllIIlIIlIIIll.readStringFromBuffer(32767), ServerStatusResponse.class);
    }
}
