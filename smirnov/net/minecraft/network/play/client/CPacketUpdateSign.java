// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.client;

import net.minecraft.network.INetHandler;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.network.play.INetHandlerPlayServer;
import net.minecraft.network.Packet;

public class CPacketUpdateSign implements Packet<INetHandlerPlayServer>
{
    private /* synthetic */ String[] lines;
    private /* synthetic */ BlockPos pos;
    
    @Override
    public void processPacket(final INetHandlerPlayServer lllllllllllIIIlIIIIlIllIIIlIlllI) {
        lllllllllllIIIlIIIIlIllIIIlIlllI.processUpdateSign(this);
    }
    
    public CPacketUpdateSign(final BlockPos lllllllllllIIIlIIIIlIllIIlIIlIII, final ITextComponent[] lllllllllllIIIlIIIIlIllIIlIIIlll) {
        this.pos = lllllllllllIIIlIIIIlIllIIlIIlIII;
        this.lines = new String[] { lllllllllllIIIlIIIIlIllIIlIIIlll[0].getUnformattedText(), lllllllllllIIIlIIIIlIllIIlIIIlll[1].getUnformattedText(), lllllllllllIIIlIIIIlIllIIlIIIlll[2].getUnformattedText(), lllllllllllIIIlIIIIlIllIIlIIIlll[3].getUnformattedText() };
    }
    
    public String[] getLines() {
        return this.lines;
    }
    
    public BlockPos getPosition() {
        return this.pos;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllIIIlIIIIlIllIIIllllll) throws IOException {
        this.pos = lllllllllllIIIlIIIIlIllIIIllllll.readBlockPos();
        this.lines = new String[4];
        for (int lllllllllllIIIlIIIIlIllIIIlllllI = 0; lllllllllllIIIlIIIIlIllIIIlllllI < 4; ++lllllllllllIIIlIIIIlIllIIIlllllI) {
            this.lines[lllllllllllIIIlIIIIlIllIIIlllllI] = lllllllllllIIIlIIIIlIllIIIllllll.readStringFromBuffer(384);
        }
    }
    
    public CPacketUpdateSign() {
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllIIIlIIIIlIllIIIllIllI) throws IOException {
        lllllllllllIIIlIIIIlIllIIIllIllI.writeBlockPos(this.pos);
        for (int lllllllllllIIIlIIIIlIllIIIllIlIl = 0; lllllllllllIIIlIIIIlIllIIIllIlIl < 4; ++lllllllllllIIIlIIIIlIllIIIllIlIl) {
            lllllllllllIIIlIIIIlIllIIIllIllI.writeString(this.lines[lllllllllllIIIlIIIIlIllIIIllIlIl]);
        }
    }
}
