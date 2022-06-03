// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import net.minecraft.network.INetHandler;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketEffect implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ int soundType;
    private /* synthetic */ int soundData;
    private /* synthetic */ boolean serverWide;
    private /* synthetic */ BlockPos soundPos;
    
    public BlockPos getSoundPos() {
        return this.soundPos;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllIIIlIIlIlIlIllIlIlIlI) {
        lllllllllllIIIlIIlIlIlIllIlIlIlI.handleEffect(this);
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllIIIlIIlIlIlIllIllIllI) throws IOException {
        this.soundType = lllllllllllIIIlIIlIlIlIllIllIllI.readInt();
        this.soundPos = lllllllllllIIIlIIlIlIlIllIllIllI.readBlockPos();
        this.soundData = lllllllllllIIIlIIlIlIlIllIllIllI.readInt();
        this.serverWide = lllllllllllIIIlIIlIlIlIllIllIllI.readBoolean();
    }
    
    public boolean isSoundServerwide() {
        return this.serverWide;
    }
    
    public int getSoundType() {
        return this.soundType;
    }
    
    public SPacketEffect() {
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllIIIlIIlIlIlIllIllIIlI) throws IOException {
        lllllllllllIIIlIIlIlIlIllIllIIlI.writeInt(this.soundType);
        lllllllllllIIIlIIlIlIlIllIllIIlI.writeBlockPos(this.soundPos);
        lllllllllllIIIlIIlIlIlIllIllIIlI.writeInt(this.soundData);
        lllllllllllIIIlIIlIlIlIllIllIIlI.writeBoolean(this.serverWide);
    }
    
    public SPacketEffect(final int lllllllllllIIIlIIlIlIlIllIllllll, final BlockPos lllllllllllIIIlIIlIlIlIllIlllllI, final int lllllllllllIIIlIIlIlIlIllIllllIl, final boolean lllllllllllIIIlIIlIlIlIlllIIIIIl) {
        this.soundType = lllllllllllIIIlIIlIlIlIllIllllll;
        this.soundPos = lllllllllllIIIlIIlIlIlIllIlllllI;
        this.soundData = lllllllllllIIIlIIlIlIlIllIllllIl;
        this.serverWide = lllllllllllIIIlIIlIlIlIlllIIIIIl;
    }
    
    public int getSoundData() {
        return this.soundData;
    }
}
