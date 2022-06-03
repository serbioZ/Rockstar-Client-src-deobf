// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import net.minecraft.network.INetHandler;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketEntityEquipment implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ int entityID;
    private /* synthetic */ ItemStack itemStack;
    private /* synthetic */ EntityEquipmentSlot equipmentSlot;
    
    public ItemStack getItemStack() {
        return this.itemStack;
    }
    
    public EntityEquipmentSlot getEquipmentSlot() {
        return this.equipmentSlot;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllllllIlIIIIlIlllllIIIl) {
        lllllllllllllllIlIIIIlIlllllIIIl.handleEntityEquipment(this);
    }
    
    public SPacketEntityEquipment() {
        this.itemStack = ItemStack.field_190927_a;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllIlIIIIlIllllllIll) throws IOException {
        this.entityID = lllllllllllllllIlIIIIlIllllllIll.readVarIntFromBuffer();
        this.equipmentSlot = lllllllllllllllIlIIIIlIllllllIll.readEnumValue(EntityEquipmentSlot.class);
        this.itemStack = lllllllllllllllIlIIIIlIllllllIll.readItemStackFromBuffer();
    }
    
    public int getEntityID() {
        return this.entityID;
    }
    
    public SPacketEntityEquipment(final int lllllllllllllllIlIIIIllIIIIIIlll, final EntityEquipmentSlot lllllllllllllllIlIIIIllIIIIIIllI, final ItemStack lllllllllllllllIlIIIIllIIIIIIIIl) {
        this.itemStack = ItemStack.field_190927_a;
        this.entityID = lllllllllllllllIlIIIIllIIIIIIlll;
        this.equipmentSlot = lllllllllllllllIlIIIIllIIIIIIllI;
        this.itemStack = lllllllllllllllIlIIIIllIIIIIIIIl.copy();
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllIlIIIIlIlllllIlIl) throws IOException {
        lllllllllllllllIlIIIIlIlllllIlIl.writeVarIntToBuffer(this.entityID);
        lllllllllllllllIlIIIIlIlllllIlIl.writeEnumValue(this.equipmentSlot);
        lllllllllllllllIlIIIIlIlllllIlIl.writeItemStackToBuffer(this.itemStack);
    }
}
