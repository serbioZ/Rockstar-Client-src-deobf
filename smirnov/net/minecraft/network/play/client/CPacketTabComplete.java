// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.client;

import java.io.IOException;
import org.apache.commons.lang3.StringUtils;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.INetHandler;
import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.network.play.INetHandlerPlayServer;
import net.minecraft.network.Packet;

public class CPacketTabComplete implements Packet<INetHandlerPlayServer>
{
    private /* synthetic */ String message;
    @Nullable
    private /* synthetic */ BlockPos targetBlock;
    private /* synthetic */ boolean hasTargetBlock;
    
    @Nullable
    public BlockPos getTargetBlock() {
        return this.targetBlock;
    }
    
    public CPacketTabComplete() {
    }
    
    public boolean hasTargetBlock() {
        return this.hasTargetBlock;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllIIIlllIIllllIllIlIlI) throws IOException {
        llllllllllllIIIlllIIllllIllIlIlI.writeString(StringUtils.substring(this.message, 0, 32767));
        llllllllllllIIIlllIIllllIllIlIlI.writeBoolean(this.hasTargetBlock);
        final boolean llllllllllllIIIlllIIllllIllIlIIl = this.targetBlock != null;
        llllllllllllIIIlllIIllllIllIlIlI.writeBoolean(llllllllllllIIIlllIIllllIllIlIIl);
        if (llllllllllllIIIlllIIllllIllIlIIl) {
            llllllllllllIIIlllIIllllIllIlIlI.writeBlockPos(this.targetBlock);
        }
    }
    
    public CPacketTabComplete(final String llllllllllllIIIlllIIllllIllllllI, @Nullable final BlockPos llllllllllllIIIlllIIllllIllllIIl, final boolean llllllllllllIIIlllIIllllIlllllII) {
        this.message = llllllllllllIIIlllIIllllIllllllI;
        this.targetBlock = llllllllllllIIIlllIIllllIllllIIl;
        this.hasTargetBlock = llllllllllllIIIlllIIllllIlllllII;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayServer llllllllllllIIIlllIIllllIllIIIII) {
        llllllllllllIIIlllIIllllIllIIIII.processTabComplete(this);
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllIIIlllIIllllIlllIIII) throws IOException {
        this.message = llllllllllllIIIlllIIllllIlllIIII.readStringFromBuffer(32767);
        this.hasTargetBlock = llllllllllllIIIlllIIllllIlllIIII.readBoolean();
        final boolean llllllllllllIIIlllIIllllIlllIIlI = llllllllllllIIIlllIIllllIlllIIII.readBoolean();
        if (llllllllllllIIIlllIIllllIlllIIlI) {
            this.targetBlock = llllllllllllIIIlllIIllllIlllIIII.readBlockPos();
        }
    }
    
    public String getMessage() {
        return this.message;
    }
}
