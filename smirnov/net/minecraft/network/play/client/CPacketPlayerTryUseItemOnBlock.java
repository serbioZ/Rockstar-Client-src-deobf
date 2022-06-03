// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.client;

import net.minecraft.network.INetHandler;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.network.play.INetHandlerPlayServer;
import net.minecraft.network.Packet;

public class CPacketPlayerTryUseItemOnBlock implements Packet<INetHandlerPlayServer>
{
    private /* synthetic */ float facingX;
    private /* synthetic */ BlockPos position;
    private /* synthetic */ float facingZ;
    private /* synthetic */ EnumFacing placedBlockDirection;
    private /* synthetic */ float facingY;
    private /* synthetic */ EnumHand hand;
    
    public EnumFacing getDirection() {
        return this.placedBlockDirection;
    }
    
    public BlockPos getPos() {
        return this.position;
    }
    
    public CPacketPlayerTryUseItemOnBlock(final BlockPos llllllllllllllIIIllIIIIllIIllIlI, final EnumFacing llllllllllllllIIIllIIIIllIIlIIlI, final EnumHand llllllllllllllIIIllIIIIllIIllIII, final float llllllllllllllIIIllIIIIllIIlIlll, final float llllllllllllllIIIllIIIIllIIIllll, final float llllllllllllllIIIllIIIIllIIlIlIl) {
        this.position = llllllllllllllIIIllIIIIllIIllIlI;
        this.placedBlockDirection = llllllllllllllIIIllIIIIllIIlIIlI;
        this.hand = llllllllllllllIIIllIIIIllIIllIII;
        this.facingX = llllllllllllllIIIllIIIIllIIlIlll;
        this.facingY = llllllllllllllIIIllIIIIllIIIllll;
        this.facingZ = llllllllllllllIIIllIIIIllIIlIlIl;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIIIllIIIIllIIIlIlI) throws IOException {
        this.position = llllllllllllllIIIllIIIIllIIIlIlI.readBlockPos();
        this.placedBlockDirection = llllllllllllllIIIllIIIIllIIIlIlI.readEnumValue(EnumFacing.class);
        this.hand = llllllllllllllIIIllIIIIllIIIlIlI.readEnumValue(EnumHand.class);
        this.facingX = llllllllllllllIIIllIIIIllIIIlIlI.readFloat();
        this.facingY = llllllllllllllIIIllIIIIllIIIlIlI.readFloat();
        this.facingZ = llllllllllllllIIIllIIIIllIIIlIlI.readFloat();
    }
    
    public CPacketPlayerTryUseItemOnBlock() {
    }
    
    public float getFacingZ() {
        return this.facingZ;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayServer llllllllllllllIIIllIIIIlIlllllII) {
        llllllllllllllIIIllIIIIlIlllllII.processRightClickBlock(this);
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIIIllIIIIllIIIIIlI) throws IOException {
        llllllllllllllIIIllIIIIllIIIIIlI.writeBlockPos(this.position);
        llllllllllllllIIIllIIIIllIIIIIlI.writeEnumValue(this.placedBlockDirection);
        llllllllllllllIIIllIIIIllIIIIIlI.writeEnumValue(this.hand);
        llllllllllllllIIIllIIIIllIIIIIlI.writeFloat(this.facingX);
        llllllllllllllIIIllIIIIllIIIIIlI.writeFloat(this.facingY);
        llllllllllllllIIIllIIIIllIIIIIlI.writeFloat(this.facingZ);
    }
    
    public float getFacingX() {
        return this.facingX;
    }
    
    public float getFacingY() {
        return this.facingY;
    }
    
    public EnumHand getHand() {
        return this.hand;
    }
}
