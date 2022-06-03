// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.network.INetHandler;
import java.io.IOException;
import java.util.UUID;
import java.util.Collection;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import com.google.common.collect.Lists;
import net.minecraft.network.PacketBuffer;
import java.util.List;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketEntityProperties implements Packet<INetHandlerPlayClient>
{
    private final /* synthetic */ List<Snapshot> snapshots;
    private /* synthetic */ int entityId;
    
    @Override
    public void processPacket(final INetHandlerPlayClient llllllllllllIIlIlIIlIIlIIIllIIlI) {
        llllllllllllIIlIlIIlIIlIIIllIIlI.handleEntityProperties(this);
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllIIlIlIIlIIlIIlIlIIII) throws IOException {
        this.entityId = llllllllllllIIlIlIIlIIlIIlIlIIII.readVarIntFromBuffer();
        for (int llllllllllllIIlIlIIlIIlIIlIllIIl = llllllllllllIIlIlIIlIIlIIlIlIIII.readInt(), llllllllllllIIlIlIIlIIlIIlIllIII = 0; llllllllllllIIlIlIIlIIlIIlIllIII < llllllllllllIIlIlIIlIIlIIlIllIIl; ++llllllllllllIIlIlIIlIIlIIlIllIII) {
            final String llllllllllllIIlIlIIlIIlIIlIlIlll = llllllllllllIIlIlIIlIIlIIlIlIIII.readStringFromBuffer(64);
            final double llllllllllllIIlIlIIlIIlIIlIlIllI = llllllllllllIIlIlIIlIIlIIlIlIIII.readDouble();
            final List<AttributeModifier> llllllllllllIIlIlIIlIIlIIlIlIlIl = (List<AttributeModifier>)Lists.newArrayList();
            for (int llllllllllllIIlIlIIlIIlIIlIlIlII = llllllllllllIIlIlIIlIIlIIlIlIIII.readVarIntFromBuffer(), llllllllllllIIlIlIIlIIlIIlIlIIll = 0; llllllllllllIIlIlIIlIIlIIlIlIIll < llllllllllllIIlIlIIlIIlIIlIlIlII; ++llllllllllllIIlIlIIlIIlIIlIlIIll) {
                final UUID llllllllllllIIlIlIIlIIlIIlIlIIlI = llllllllllllIIlIlIIlIIlIIlIlIIII.readUuid();
                llllllllllllIIlIlIIlIIlIIlIlIlIl.add(new AttributeModifier(llllllllllllIIlIlIIlIIlIIlIlIIlI, "Unknown synced attribute modifier", llllllllllllIIlIlIIlIIlIIlIlIIII.readDouble(), llllllllllllIIlIlIIlIIlIIlIlIIII.readByte()));
            }
            this.snapshots.add(new Snapshot(llllllllllllIIlIlIIlIIlIIlIlIlll, llllllllllllIIlIlIIlIIlIIlIlIllI, llllllllllllIIlIlIIlIIlIIlIlIlIl));
        }
    }
    
    public SPacketEntityProperties() {
        this.snapshots = (List<Snapshot>)Lists.newArrayList();
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllIIlIlIIlIIlIIIllllII) throws IOException {
        llllllllllllIIlIlIIlIIlIIIllllII.writeVarIntToBuffer(this.entityId);
        llllllllllllIIlIlIIlIIlIIIllllII.writeInt(this.snapshots.size());
        for (final Snapshot llllllllllllIIlIlIIlIIlIIIllllll : this.snapshots) {
            llllllllllllIIlIlIIlIIlIIIllllII.writeString(llllllllllllIIlIlIIlIIlIIIllllll.getName());
            llllllllllllIIlIlIIlIIlIIIllllII.writeDouble(llllllllllllIIlIlIIlIIlIIIllllll.getBaseValue());
            llllllllllllIIlIlIIlIIlIIIllllII.writeVarIntToBuffer(llllllllllllIIlIlIIlIIlIIIllllll.getModifiers().size());
            for (final AttributeModifier llllllllllllIIlIlIIlIIlIIIlllllI : llllllllllllIIlIlIIlIIlIIIllllll.getModifiers()) {
                llllllllllllIIlIlIIlIIlIIIllllII.writeUuid(llllllllllllIIlIlIIlIIlIIIlllllI.getID());
                llllllllllllIIlIlIIlIIlIIIllllII.writeDouble(llllllllllllIIlIlIIlIIlIIIlllllI.getAmount());
                llllllllllllIIlIlIIlIIlIIIllllII.writeByte(llllllllllllIIlIlIIlIIlIIIlllllI.getOperation());
            }
        }
    }
    
    public SPacketEntityProperties(final int llllllllllllIIlIlIIlIIlIIllIlIIl, final Collection<IAttributeInstance> llllllllllllIIlIlIIlIIlIIllIlIII) {
        this.snapshots = (List<Snapshot>)Lists.newArrayList();
        this.entityId = llllllllllllIIlIlIIlIIlIIllIlIIl;
        for (final IAttributeInstance llllllllllllIIlIlIIlIIlIIllIlIll : llllllllllllIIlIlIIlIIlIIllIlIII) {
            this.snapshots.add(new Snapshot(llllllllllllIIlIlIIlIIlIIllIlIll.getAttribute().getAttributeUnlocalizedName(), llllllllllllIIlIlIIlIIlIIllIlIll.getBaseValue(), llllllllllllIIlIlIIlIIlIIllIlIll.getModifiers()));
        }
    }
    
    public int getEntityId() {
        return this.entityId;
    }
    
    public List<Snapshot> getSnapshots() {
        return this.snapshots;
    }
    
    public class Snapshot
    {
        private final /* synthetic */ Collection<AttributeModifier> modifiers;
        private final /* synthetic */ String name;
        private final /* synthetic */ double baseValue;
        
        public String getName() {
            return this.name;
        }
        
        public Collection<AttributeModifier> getModifiers() {
            return this.modifiers;
        }
        
        public Snapshot(final String lllllllllllIllIIIllIlIlIIllIlIll, final double lllllllllllIllIIIllIlIlIIllIIlIl, final Collection<AttributeModifier> lllllllllllIllIIIllIlIlIIllIIlII) {
            this.name = lllllllllllIllIIIllIlIlIIllIlIll;
            this.baseValue = lllllllllllIllIIIllIlIlIIllIIlIl;
            this.modifiers = lllllllllllIllIIIllIlIlIIllIIlII;
        }
        
        public double getBaseValue() {
            return this.baseValue;
        }
    }
}
