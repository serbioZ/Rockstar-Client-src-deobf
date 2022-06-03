// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.client;

import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.INetHandler;
import net.minecraft.util.EnumHandSide;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.play.INetHandlerPlayServer;
import net.minecraft.network.Packet;

public class CPacketClientSettings implements Packet<INetHandlerPlayServer>
{
    private /* synthetic */ String lang;
    private /* synthetic */ EntityPlayer.EnumChatVisibility chatVisibility;
    private /* synthetic */ int modelPartFlags;
    private /* synthetic */ EnumHandSide mainHand;
    private /* synthetic */ int view;
    private /* synthetic */ boolean enableColors;
    
    public boolean isColorsEnabled() {
        return this.enableColors;
    }
    
    public CPacketClientSettings() {
    }
    
    public int getModelPartFlags() {
        return this.modelPartFlags;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllIlllIIllIIIlIIllllIIII) throws IOException {
        this.lang = llllllllllIlllIIllIIIlIIllllIIII.readStringFromBuffer(16);
        this.view = llllllllllIlllIIllIIIlIIllllIIII.readByte();
        this.chatVisibility = llllllllllIlllIIllIIIlIIllllIIII.readEnumValue(EntityPlayer.EnumChatVisibility.class);
        this.enableColors = llllllllllIlllIIllIIIlIIllllIIII.readBoolean();
        this.modelPartFlags = llllllllllIlllIIllIIIlIIllllIIII.readUnsignedByte();
        this.mainHand = llllllllllIlllIIllIIIlIIllllIIII.readEnumValue(EnumHandSide.class);
    }
    
    public String getLang() {
        return this.lang;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllIlllIIllIIIlIIlllIlIII) throws IOException {
        llllllllllIlllIIllIIIlIIlllIlIII.writeString(this.lang);
        llllllllllIlllIIllIIIlIIlllIlIII.writeByte(this.view);
        llllllllllIlllIIllIIIlIIlllIlIII.writeEnumValue(this.chatVisibility);
        llllllllllIlllIIllIIIlIIlllIlIII.writeBoolean(this.enableColors);
        llllllllllIlllIIllIIIlIIlllIlIII.writeByte(this.modelPartFlags);
        llllllllllIlllIIllIIIlIIlllIlIII.writeEnumValue(this.mainHand);
    }
    
    @Override
    public void processPacket(final INetHandlerPlayServer llllllllllIlllIIllIIIlIIlllIIlII) {
        llllllllllIlllIIllIIIlIIlllIIlII.processClientSettings(this);
    }
    
    public EntityPlayer.EnumChatVisibility getChatVisibility() {
        return this.chatVisibility;
    }
    
    public EnumHandSide getMainHand() {
        return this.mainHand;
    }
    
    public CPacketClientSettings(final String llllllllllIlllIIllIIIlIIlllllIIl, final int llllllllllIlllIIllIIIlIIlllllIII, final EntityPlayer.EnumChatVisibility llllllllllIlllIIllIIIlIIlllllllI, final boolean llllllllllIlllIIllIIIlIIllllIllI, final int llllllllllIlllIIllIIIlIIllllllII, final EnumHandSide llllllllllIlllIIllIIIlIIlllllIll) {
        this.lang = llllllllllIlllIIllIIIlIIlllllIIl;
        this.view = llllllllllIlllIIllIIIlIIlllllIII;
        this.chatVisibility = llllllllllIlllIIllIIIlIIlllllllI;
        this.enableColors = llllllllllIlllIIllIIIlIIllllIllI;
        this.modelPartFlags = llllllllllIlllIIllIIIlIIllllllII;
        this.mainHand = llllllllllIlllIIllIIIlIIlllllIll;
    }
}
