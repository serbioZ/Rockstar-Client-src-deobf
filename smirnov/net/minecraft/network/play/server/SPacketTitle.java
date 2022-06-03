// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import java.util.Locale;
import net.minecraft.network.INetHandler;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import javax.annotation.Nullable;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketTitle implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ Type type;
    private /* synthetic */ int fadeInTime;
    private /* synthetic */ ITextComponent message;
    private /* synthetic */ int displayTime;
    private /* synthetic */ int fadeOutTime;
    
    public SPacketTitle(final Type llllllllllIllllIIIlIlIIlIllIIllI, @Nullable final ITextComponent llllllllllIllllIIIlIlIIlIllIIlIl, final int llllllllllIllllIIIlIlIIlIllIIlII, final int llllllllllIllllIIIlIlIIlIllIlIIl, final int llllllllllIllllIIIlIlIIlIllIIIlI) {
        this.type = llllllllllIllllIIIlIlIIlIllIIllI;
        this.message = llllllllllIllllIIIlIlIIlIllIIlIl;
        this.fadeInTime = llllllllllIllllIIIlIlIIlIllIIlII;
        this.displayTime = llllllllllIllllIIIlIlIIlIllIlIIl;
        this.fadeOutTime = llllllllllIllllIIIlIlIIlIllIIIlI;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient llllllllllIllllIIIlIlIIlIlIlIIlI) {
        llllllllllIllllIIIlIlIIlIlIlIIlI.handleTitle(this);
    }
    
    public int getFadeInTime() {
        return this.fadeInTime;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllIllllIIIlIlIIlIlIlllII) throws IOException {
        this.type = llllllllllIllllIIIlIlIIlIlIlllII.readEnumValue(Type.class);
        if (this.type == Type.TITLE || this.type == Type.SUBTITLE || this.type == Type.ACTIONBAR) {
            this.message = llllllllllIllllIIIlIlIIlIlIlllII.readTextComponent();
        }
        if (this.type == Type.TIMES) {
            this.fadeInTime = llllllllllIllllIIIlIlIIlIlIlllII.readInt();
            this.displayTime = llllllllllIllllIIIlIlIIlIlIlllII.readInt();
            this.fadeOutTime = llllllllllIllllIIIlIlIIlIlIlllII.readInt();
        }
    }
    
    public SPacketTitle(final int llllllllllIllllIIIlIlIIlIlllIllI, final int llllllllllIllllIIIlIlIIlIlllIlIl, final int llllllllllIllllIIIlIlIIlIllllIII) {
        this(Type.TIMES, null, llllllllllIllllIIIlIlIIlIlllIllI, llllllllllIllllIIIlIlIIlIlllIlIl, llllllllllIllllIIIlIlIIlIllllIII);
    }
    
    public int getFadeOutTime() {
        return this.fadeOutTime;
    }
    
    public SPacketTitle(final Type llllllllllIllllIIIlIlIIllIIIIIIl, final ITextComponent llllllllllIllllIIIlIlIIllIIIIIll) {
        this(llllllllllIllllIIIlIlIIllIIIIIIl, llllllllllIllllIIIlIlIIllIIIIIll, -1, -1, -1);
    }
    
    public Type getType() {
        return this.type;
    }
    
    public SPacketTitle() {
    }
    
    public int getDisplayTime() {
        return this.displayTime;
    }
    
    public ITextComponent getMessage() {
        return this.message;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllIllllIIIlIlIIlIlIllIII) throws IOException {
        llllllllllIllllIIIlIlIIlIlIllIII.writeEnumValue(this.type);
        if (this.type == Type.TITLE || this.type == Type.SUBTITLE || this.type == Type.ACTIONBAR) {
            llllllllllIllllIIIlIlIIlIlIllIII.writeTextComponent(this.message);
        }
        if (this.type == Type.TIMES) {
            llllllllllIllllIIIlIlIIlIlIllIII.writeInt(this.fadeInTime);
            llllllllllIllllIIIlIlIIlIlIllIII.writeInt(this.displayTime);
            llllllllllIllllIIIlIlIIlIlIllIII.writeInt(this.fadeOutTime);
        }
    }
    
    public enum Type
    {
        TIMES("TIMES", 3), 
        RESET("RESET", 5), 
        SUBTITLE("SUBTITLE", 1), 
        ACTIONBAR("ACTIONBAR", 2), 
        TITLE("TITLE", 0), 
        CLEAR("CLEAR", 4);
        
        private Type(final String lllllllllllIllIlIllIllIlIIIlIIIl, final int lllllllllllIllIlIllIllIlIIIlIIII) {
        }
        
        public static Type byName(final String lllllllllllIllIlIllIllIlIIIIlIII) {
            final byte lllllllllllIllIlIllIllIlIIIIIlII;
            final short lllllllllllIllIlIllIllIlIIIIIlIl = (short)((Type[])(Object)(lllllllllllIllIlIllIllIlIIIIIlII = (byte)(Object)values())).length;
            for (float lllllllllllIllIlIllIllIlIIIIIllI = 0; lllllllllllIllIlIllIllIlIIIIIllI < lllllllllllIllIlIllIllIlIIIIIlIl; ++lllllllllllIllIlIllIllIlIIIIIllI) {
                final Type lllllllllllIllIlIllIllIlIIIIlIIl = lllllllllllIllIlIllIllIlIIIIIlII[lllllllllllIllIlIllIllIlIIIIIllI];
                if (lllllllllllIllIlIllIllIlIIIIlIIl.name().equalsIgnoreCase(lllllllllllIllIlIllIllIlIIIIlIII)) {
                    return lllllllllllIllIlIllIllIlIIIIlIIl;
                }
            }
            return Type.TITLE;
        }
        
        public static String[] getNames() {
            final String[] lllllllllllIllIlIllIllIIllllllIl = new String[values().length];
            int lllllllllllIllIlIllIllIIllllllII = 0;
            final String lllllllllllIllIlIllIllIIllllIlIl;
            final short lllllllllllIllIlIllIllIIllllIllI = (short)((Type[])(Object)(lllllllllllIllIlIllIllIIllllIlIl = (String)(Object)values())).length;
            for (final Type lllllllllllIllIlIllIllIIlllllIll : lllllllllllIllIlIllIllIIllllIlIl) {
                lllllllllllIllIlIllIllIIllllllIl[lllllllllllIllIlIllIllIIllllllII++] = lllllllllllIllIlIllIllIIlllllIll.name().toLowerCase(Locale.ROOT);
            }
            return lllllllllllIllIlIllIllIIllllllIl;
        }
    }
}
