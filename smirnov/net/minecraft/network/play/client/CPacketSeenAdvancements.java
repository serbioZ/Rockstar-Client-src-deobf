// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.client;

import net.minecraft.network.INetHandler;
import javax.annotation.Nullable;
import net.minecraft.advancements.Advancement;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.network.play.INetHandlerPlayServer;
import net.minecraft.network.Packet;

public class CPacketSeenAdvancements implements Packet<INetHandlerPlayServer>
{
    private /* synthetic */ ResourceLocation field_194167_b;
    private /* synthetic */ Action field_194166_a;
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllIlIIIlIlIIlIIIIlIll) throws IOException {
        this.field_194166_a = lllllllllllllIlIIIlIlIIlIIIIlIll.readEnumValue(Action.class);
        if (this.field_194166_a == Action.OPENED_TAB) {
            this.field_194167_b = lllllllllllllIlIIIlIlIIlIIIIlIll.func_192575_l();
        }
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllIlIIIlIlIIlIIIIIIll) throws IOException {
        lllllllllllllIlIIIlIlIIlIIIIIIll.writeEnumValue(this.field_194166_a);
        if (this.field_194166_a == Action.OPENED_TAB) {
            lllllllllllllIlIIIlIlIIlIIIIIIll.func_192572_a(this.field_194167_b);
        }
    }
    
    public static CPacketSeenAdvancements func_194164_a() {
        return new CPacketSeenAdvancements(Action.CLOSED_SCREEN, null);
    }
    
    public static CPacketSeenAdvancements func_194163_a(final Advancement lllllllllllllIlIIIlIlIIlIIIlIIII) {
        return new CPacketSeenAdvancements(Action.OPENED_TAB, lllllllllllllIlIIIlIlIIlIIIlIIII.func_192067_g());
    }
    
    public Action func_194162_b() {
        return this.field_194166_a;
    }
    
    public CPacketSeenAdvancements() {
    }
    
    public CPacketSeenAdvancements(final Action lllllllllllllIlIIIlIlIIlIIIlIIll, @Nullable final ResourceLocation lllllllllllllIlIIIlIlIIlIIIlIIlI) {
        this.field_194166_a = lllllllllllllIlIIIlIlIIlIIIlIIll;
        this.field_194167_b = lllllllllllllIlIIIlIlIIlIIIlIIlI;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayServer lllllllllllllIlIIIlIlIIIllllllll) {
        lllllllllllllIlIIIlIlIIIllllllll.func_194027_a(this);
    }
    
    public ResourceLocation func_194165_c() {
        return this.field_194167_b;
    }
    
    public enum Action
    {
        CLOSED_SCREEN("CLOSED_SCREEN", 1), 
        OPENED_TAB("OPENED_TAB", 0);
        
        private Action(final String lllllllllllllIlIIIlIIlIllIIIllll, final int lllllllllllllIlIIIlIIlIllIIIlllI) {
        }
    }
}
