// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import javax.annotation.Nullable;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.INetHandler;
import net.minecraft.potion.Potion;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketRemoveEntityEffect implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ int entityId;
    private /* synthetic */ Potion effectId;
    
    public SPacketRemoveEntityEffect() {
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllIlllllIlIIIllIIIllIIIl) throws IOException {
        llllllllllIlllllIlIIIllIIIllIIIl.writeVarIntToBuffer(this.entityId);
        llllllllllIlllllIlIIIllIIIllIIIl.writeByte(Potion.getIdFromPotion(this.effectId));
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllIlllllIlIIIllIIIllIlll) throws IOException {
        this.entityId = llllllllllIlllllIlIIIllIIIllIlll.readVarIntFromBuffer();
        this.effectId = Potion.getPotionById(llllllllllIlllllIlIIIllIIIllIlll.readUnsignedByte());
    }
    
    @Nullable
    public Potion getPotion() {
        return this.effectId;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient llllllllllIlllllIlIIIllIIIlIlIIl) {
        llllllllllIlllllIlIIIllIIIlIlIIl.handleRemoveEntityEffect(this);
    }
    
    public SPacketRemoveEntityEffect(final int llllllllllIlllllIlIIIllIIIllllll, final Potion llllllllllIlllllIlIIIllIIIlllllI) {
        this.entityId = llllllllllIlllllIlIIIllIIIllllll;
        this.effectId = llllllllllIlllllIlIIIllIIIlllllI;
    }
    
    @Nullable
    public Entity getEntity(final World llllllllllIlllllIlIIIllIIIlIIIll) {
        return llllllllllIlllllIlIIIllIIIlIIIll.getEntityByID(this.entityId);
    }
}
