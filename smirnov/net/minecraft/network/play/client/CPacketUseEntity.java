// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.client;

import net.minecraft.network.INetHandler;
import javax.annotation.Nullable;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.EnumHand;
import net.minecraft.network.play.INetHandlerPlayServer;
import net.minecraft.network.Packet;

public class CPacketUseEntity implements Packet<INetHandlerPlayServer>
{
    private /* synthetic */ EnumHand hand;
    private /* synthetic */ Vec3d hitVec;
    private /* synthetic */ Action action;
    private /* synthetic */ int entityId;
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllIIIIIIIIIIlllllIllll) throws IOException {
        llllllllllllIIIIIIIIIIlllllIllll.writeVarIntToBuffer(this.entityId);
        llllllllllllIIIIIIIIIIlllllIllll.writeEnumValue(this.action);
        if (this.action == Action.INTERACT_AT) {
            llllllllllllIIIIIIIIIIlllllIllll.writeFloat((float)this.hitVec.xCoord);
            llllllllllllIIIIIIIIIIlllllIllll.writeFloat((float)this.hitVec.yCoord);
            llllllllllllIIIIIIIIIIlllllIllll.writeFloat((float)this.hitVec.zCoord);
        }
        if (this.action == Action.INTERACT || this.action == Action.INTERACT_AT) {
            llllllllllllIIIIIIIIIIlllllIllll.writeEnumValue(this.hand);
        }
    }
    
    public CPacketUseEntity(final Entity llllllllllllIIIIIIIIIlIIIIIIIIIl, final EnumHand llllllllllllIIIIIIIIIlIIIIIIIIII, final Vec3d llllllllllllIIIIIIIIIIlllllllIll) {
        this.entityId = llllllllllllIIIIIIIIIlIIIIIIIIIl.getEntityId();
        this.action = Action.INTERACT_AT;
        this.hand = llllllllllllIIIIIIIIIlIIIIIIIIII;
        this.hitVec = llllllllllllIIIIIIIIIIlllllllIll;
    }
    
    public Action getAction() {
        return this.action;
    }
    
    @Nullable
    public Entity getEntityFromWorld(final World llllllllllllIIIIIIIIIIlllllIIlIl) {
        return llllllllllllIIIIIIIIIIlllllIIlIl.getEntityByID(this.entityId);
    }
    
    public CPacketUseEntity() {
    }
    
    public Vec3d getHitVec() {
        return this.hitVec;
    }
    
    public CPacketUseEntity(final Entity llllllllllllIIIIIIIIIlIIIIIlIIlI) {
        this.entityId = llllllllllllIIIIIIIIIlIIIIIlIIlI.getEntityId();
        this.action = Action.ATTACK;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayServer llllllllllllIIIIIIIIIIlllllIlIll) {
        llllllllllllIIIIIIIIIIlllllIlIll.processUseEntity(this);
    }
    
    public CPacketUseEntity(final Entity llllllllllllIIIIIIIIIlIIIIIIlIII, final EnumHand llllllllllllIIIIIIIIIlIIIIIIlIlI) {
        this.entityId = llllllllllllIIIIIIIIIlIIIIIIlIII.getEntityId();
        this.action = Action.INTERACT;
        this.hand = llllllllllllIIIIIIIIIlIIIIIIlIlI;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllIIIIIIIIIIllllllIlIl) throws IOException {
        this.entityId = llllllllllllIIIIIIIIIIllllllIlIl.readVarIntFromBuffer();
        this.action = llllllllllllIIIIIIIIIIllllllIlIl.readEnumValue(Action.class);
        if (this.action == Action.INTERACT_AT) {
            this.hitVec = new Vec3d(llllllllllllIIIIIIIIIIllllllIlIl.readFloat(), llllllllllllIIIIIIIIIIllllllIlIl.readFloat(), llllllllllllIIIIIIIIIIllllllIlIl.readFloat());
        }
        if (this.action == Action.INTERACT || this.action == Action.INTERACT_AT) {
            this.hand = llllllllllllIIIIIIIIIIllllllIlIl.readEnumValue(EnumHand.class);
        }
    }
    
    public EnumHand getHand() {
        return this.hand;
    }
    
    public enum Action
    {
        ATTACK("ATTACK", 1), 
        INTERACT_AT("INTERACT_AT", 2), 
        INTERACT("INTERACT", 0);
        
        private Action(final String lllllllllllIlIlIlIIlIIIIIlIIIIlI, final int lllllllllllIlIlIlIIlIIIIIlIIIIIl) {
        }
    }
}
