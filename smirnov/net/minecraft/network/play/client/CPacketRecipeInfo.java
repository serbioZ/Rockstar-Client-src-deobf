// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.client;

import java.io.IOException;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.INetHandler;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.network.play.INetHandlerPlayServer;
import net.minecraft.network.Packet;

public class CPacketRecipeInfo implements Packet<INetHandlerPlayServer>
{
    private /* synthetic */ IRecipe field_193649_d;
    private /* synthetic */ boolean field_192632_f;
    private /* synthetic */ boolean field_192631_e;
    private /* synthetic */ Purpose field_194157_a;
    
    public CPacketRecipeInfo() {
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllIlIllIIlIllIlIlIIllIl) throws IOException {
        this.field_194157_a = lllllllllllIlIllIIlIllIlIlIIllIl.readEnumValue(Purpose.class);
        if (this.field_194157_a == Purpose.SHOWN) {
            this.field_193649_d = CraftingManager.func_193374_a(lllllllllllIlIllIIlIllIlIlIIllIl.readInt());
        }
        else if (this.field_194157_a == Purpose.SETTINGS) {
            this.field_192631_e = lllllllllllIlIllIIlIllIlIlIIllIl.readBoolean();
            this.field_192632_f = lllllllllllIlIllIIlIllIlIlIIllIl.readBoolean();
        }
    }
    
    public CPacketRecipeInfo(final boolean lllllllllllIlIllIIlIllIlIlIlIlll, final boolean lllllllllllIlIllIIlIllIlIlIlIllI) {
        this.field_194157_a = Purpose.SETTINGS;
        this.field_192631_e = lllllllllllIlIllIIlIllIlIlIlIlll;
        this.field_192632_f = lllllllllllIlIllIIlIllIlIlIlIllI;
    }
    
    public IRecipe func_193648_b() {
        return this.field_193649_d;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayServer lllllllllllIlIllIIlIllIlIlIIIIll) {
        lllllllllllIlIllIIlIllIlIlIIIIll.func_191984_a(this);
    }
    
    public boolean func_192625_d() {
        return this.field_192632_f;
    }
    
    public CPacketRecipeInfo(final IRecipe lllllllllllIlIllIIlIllIlIlIllllI) {
        this.field_194157_a = Purpose.SHOWN;
        this.field_193649_d = lllllllllllIlIllIIlIllIlIlIllllI;
    }
    
    public boolean func_192624_c() {
        return this.field_192631_e;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllIlIllIIlIllIlIlIIIlll) throws IOException {
        lllllllllllIlIllIIlIllIlIlIIIlll.writeEnumValue(this.field_194157_a);
        if (this.field_194157_a == Purpose.SHOWN) {
            lllllllllllIlIllIIlIllIlIlIIIlll.writeInt(CraftingManager.func_193375_a(this.field_193649_d));
        }
        else if (this.field_194157_a == Purpose.SETTINGS) {
            lllllllllllIlIllIIlIllIlIlIIIlll.writeBoolean(this.field_192631_e);
            lllllllllllIlIllIIlIllIlIlIIIlll.writeBoolean(this.field_192632_f);
        }
    }
    
    public Purpose func_194156_a() {
        return this.field_194157_a;
    }
    
    public enum Purpose
    {
        SHOWN("SHOWN", 0), 
        SETTINGS("SETTINGS", 1);
        
        private Purpose(final String llllllllllIllllIIIlIIIIlIlllIlll, final int llllllllllIllllIIIlIIIIlIlllIllI) {
        }
    }
}
