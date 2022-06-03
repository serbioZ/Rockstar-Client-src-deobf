// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import net.minecraft.network.INetHandler;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketUpdateTileEntity implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ int metadata;
    private /* synthetic */ BlockPos blockPos;
    private /* synthetic */ NBTTagCompound nbt;
    
    public NBTTagCompound getNbtCompound() {
        return this.nbt;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllIIlIlIIlIIIlIIllIlIlI) throws IOException {
        this.blockPos = lllllllllllIIlIlIIlIIIlIIllIlIlI.readBlockPos();
        this.metadata = lllllllllllIIlIlIIlIIIlIIllIlIlI.readUnsignedByte();
        this.nbt = lllllllllllIIlIlIIlIIIlIIllIlIlI.readNBTTagCompoundFromBuffer();
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllIIlIlIIlIIIlIIlIllllI) {
        lllllllllllIIlIlIIlIIIlIIlIllllI.handleUpdateTileEntity(this);
    }
    
    public int getTileEntityType() {
        return this.metadata;
    }
    
    public SPacketUpdateTileEntity(final BlockPos lllllllllllIIlIlIIlIIIlIIlllIlII, final int lllllllllllIIlIlIIlIIIlIIllIllll, final NBTTagCompound lllllllllllIIlIlIIlIIIlIIlllIIlI) {
        this.blockPos = lllllllllllIIlIlIIlIIIlIIlllIlII;
        this.metadata = lllllllllllIIlIlIIlIIIlIIllIllll;
        this.nbt = lllllllllllIIlIlIIlIIIlIIlllIIlI;
    }
    
    public SPacketUpdateTileEntity() {
    }
    
    public BlockPos getPos() {
        return this.blockPos;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllIIlIlIIlIIIlIIllIIIlI) throws IOException {
        lllllllllllIIlIlIIlIIIlIIllIIIlI.writeBlockPos(this.blockPos);
        lllllllllllIIlIlIIlIIIlIIllIIIlI.writeByte((byte)this.metadata);
        lllllllllllIIlIlIIlIIIlIIllIIIlI.writeNBTTagCompoundToBuffer(this.nbt);
    }
}
