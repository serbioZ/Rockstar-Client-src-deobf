// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import net.minecraft.network.INetHandler;
import java.io.IOException;
import net.minecraft.item.crafting.CraftingManager;
import com.google.common.collect.Lists;
import net.minecraft.network.PacketBuffer;
import net.minecraft.item.crafting.IRecipe;
import java.util.List;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketRecipeBook implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ State field_193646_a;
    private /* synthetic */ List<IRecipe> field_193647_c;
    private /* synthetic */ List<IRecipe> field_192596_a;
    private /* synthetic */ boolean field_192598_c;
    private /* synthetic */ boolean field_192599_d;
    
    public List<IRecipe> func_192595_a() {
        return this.field_192596_a;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllIlllIIIIlIlllllIlIIIll) throws IOException {
        this.field_193646_a = llllllllllIlllIIIIlIlllllIlIIIll.readEnumValue(State.class);
        this.field_192598_c = llllllllllIlllIIIIlIlllllIlIIIll.readBoolean();
        this.field_192599_d = llllllllllIlllIIIIlIlllllIlIIIll.readBoolean();
        int llllllllllIlllIIIIlIlllllIlIIlll = llllllllllIlllIIIIlIlllllIlIIIll.readVarIntFromBuffer();
        this.field_192596_a = (List<IRecipe>)Lists.newArrayList();
        for (int llllllllllIlllIIIIlIlllllIlIIllI = 0; llllllllllIlllIIIIlIlllllIlIIllI < llllllllllIlllIIIIlIlllllIlIIlll; ++llllllllllIlllIIIIlIlllllIlIIllI) {
            this.field_192596_a.add(CraftingManager.func_193374_a(llllllllllIlllIIIIlIlllllIlIIIll.readVarIntFromBuffer()));
        }
        if (this.field_193646_a == State.INIT) {
            llllllllllIlllIIIIlIlllllIlIIlll = llllllllllIlllIIIIlIlllllIlIIIll.readVarIntFromBuffer();
            this.field_193647_c = (List<IRecipe>)Lists.newArrayList();
            for (int llllllllllIlllIIIIlIlllllIlIIlIl = 0; llllllllllIlllIIIIlIlllllIlIIlIl < llllllllllIlllIIIIlIlllllIlIIlll; ++llllllllllIlllIIIIlIlllllIlIIlIl) {
                this.field_193647_c.add(CraftingManager.func_193374_a(llllllllllIlllIIIIlIlllllIlIIIll.readVarIntFromBuffer()));
            }
        }
    }
    
    public State func_194151_e() {
        return this.field_193646_a;
    }
    
    public SPacketRecipeBook() {
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient llllllllllIlllIIIIlIlllllIllIIII) {
        llllllllllIlllIIIIlIlllllIllIIII.func_191980_a(this);
    }
    
    public List<IRecipe> func_193644_b() {
        return this.field_193647_c;
    }
    
    public boolean func_192594_d() {
        return this.field_192599_d;
    }
    
    public boolean func_192593_c() {
        return this.field_192598_c;
    }
    
    public SPacketRecipeBook(final State llllllllllIlllIIIIlIlllllIlllllI, final List<IRecipe> llllllllllIlllIIIIlIlllllIllllIl, final List<IRecipe> llllllllllIlllIIIIlIlllllIllIllI, final boolean llllllllllIlllIIIIlIlllllIlllIll, final boolean llllllllllIlllIIIIlIlllllIlllIlI) {
        this.field_193646_a = llllllllllIlllIIIIlIlllllIlllllI;
        this.field_192596_a = llllllllllIlllIIIIlIlllllIllllIl;
        this.field_193647_c = llllllllllIlllIIIIlIlllllIllIllI;
        this.field_192598_c = llllllllllIlllIIIIlIlllllIlllIll;
        this.field_192599_d = llllllllllIlllIIIIlIlllllIlllIlI;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllIlllIIIIlIlllllIIllIll) throws IOException {
        llllllllllIlllIIIIlIlllllIIllIll.writeEnumValue(this.field_193646_a);
        llllllllllIlllIIIIlIlllllIIllIll.writeBoolean(this.field_192598_c);
        llllllllllIlllIIIIlIlllllIIllIll.writeBoolean(this.field_192599_d);
        llllllllllIlllIIIIlIlllllIIllIll.writeVarIntToBuffer(this.field_192596_a.size());
        for (final IRecipe llllllllllIlllIIIIlIlllllIIllIlI : this.field_192596_a) {
            llllllllllIlllIIIIlIlllllIIllIll.writeVarIntToBuffer(CraftingManager.func_193375_a(llllllllllIlllIIIIlIlllllIIllIlI));
        }
        if (this.field_193646_a == State.INIT) {
            llllllllllIlllIIIIlIlllllIIllIll.writeVarIntToBuffer(this.field_193647_c.size());
            for (final IRecipe llllllllllIlllIIIIlIlllllIIllIIl : this.field_193647_c) {
                llllllllllIlllIIIIlIlllllIIllIll.writeVarIntToBuffer(CraftingManager.func_193375_a(llllllllllIlllIIIIlIlllllIIllIIl));
            }
        }
    }
    
    public enum State
    {
        ADD("ADD", 1), 
        INIT("INIT", 0), 
        REMOVE("REMOVE", 2);
        
        private State(final String lllllllllllIIlIlllIllllIlIIIllll, final int lllllllllllIIlIlllIllllIlIIIlllI) {
        }
    }
}
