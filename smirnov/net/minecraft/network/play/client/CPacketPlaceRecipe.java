// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.client;

import net.minecraft.network.INetHandler;
import java.io.IOException;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.network.PacketBuffer;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.network.play.INetHandlerPlayServer;
import net.minecraft.network.Packet;

public class CPacketPlaceRecipe implements Packet<INetHandlerPlayServer>
{
    private /* synthetic */ IRecipe field_194321_b;
    private /* synthetic */ boolean field_194322_c;
    private /* synthetic */ int field_194320_a;
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllIlllIIlIlllllIIllllIll) throws IOException {
        llllllllllIlllIIlIlllllIIllllIll.writeByte(this.field_194320_a);
        llllllllllIlllIIlIlllllIIllllIll.writeVarIntToBuffer(CraftingManager.func_193375_a(this.field_194321_b));
        llllllllllIlllIIlIlllllIIllllIll.writeBoolean(this.field_194322_c);
    }
    
    public CPacketPlaceRecipe() {
    }
    
    public int func_194318_a() {
        return this.field_194320_a;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllIlllIIlIlllllIlIIIIIll) throws IOException {
        this.field_194320_a = llllllllllIlllIIlIlllllIlIIIIIll.readByte();
        this.field_194321_b = CraftingManager.func_193374_a(llllllllllIlllIIlIlllllIlIIIIIll.readVarIntFromBuffer());
        this.field_194322_c = llllllllllIlllIIlIlllllIlIIIIIll.readBoolean();
    }
    
    public IRecipe func_194317_b() {
        return this.field_194321_b;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayServer llllllllllIlllIIlIlllllIIlllIlll) {
        llllllllllIlllIIlIlllllIIlllIlll.func_194308_a(this);
    }
    
    public CPacketPlaceRecipe(final int llllllllllIlllIIlIlllllIlIIIlIIl, final IRecipe llllllllllIlllIIlIlllllIlIIIllII, final boolean llllllllllIlllIIlIlllllIlIIIlIll) {
        this.field_194320_a = llllllllllIlllIIlIlllllIlIIIlIIl;
        this.field_194321_b = llllllllllIlllIIlIlllllIlIIIllII;
        this.field_194322_c = llllllllllIlllIIlIlllllIlIIIlIll;
    }
    
    public boolean func_194319_c() {
        return this.field_194322_c;
    }
}
