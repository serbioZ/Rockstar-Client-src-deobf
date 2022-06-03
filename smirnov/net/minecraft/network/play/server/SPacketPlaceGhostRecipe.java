// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import net.minecraft.network.INetHandler;
import java.io.IOException;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.network.PacketBuffer;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketPlaceGhostRecipe implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ int field_194314_a;
    private /* synthetic */ IRecipe field_194315_b;
    
    public SPacketPlaceGhostRecipe() {
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient llllllllllllIIIIllIIIIIIlllllIlI) {
        llllllllllllIIIIllIIIIIIlllllIlI.func_194307_a(this);
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllIIIIllIIIIIlIIIIIllI) throws IOException {
        this.field_194314_a = llllllllllllIIIIllIIIIIlIIIIIllI.readByte();
        this.field_194315_b = CraftingManager.func_193374_a(llllllllllllIIIIllIIIIIlIIIIIllI.readVarIntFromBuffer());
    }
    
    public IRecipe func_194311_a() {
        return this.field_194315_b;
    }
    
    public int func_194313_b() {
        return this.field_194314_a;
    }
    
    public SPacketPlaceGhostRecipe(final int llllllllllllIIIIllIIIIIlIIIlIIIl, final IRecipe llllllllllllIIIIllIIIIIlIIIlIIII) {
        this.field_194314_a = llllllllllllIIIIllIIIIIlIIIlIIIl;
        this.field_194315_b = llllllllllllIIIIllIIIIIlIIIlIIII;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllIIIIllIIIIIIlllllllI) throws IOException {
        llllllllllllIIIIllIIIIIIlllllllI.writeByte(this.field_194314_a);
        llllllllllllIIIIllIIIIIIlllllllI.writeVarIntToBuffer(CraftingManager.func_193375_a(this.field_194315_b));
    }
}
