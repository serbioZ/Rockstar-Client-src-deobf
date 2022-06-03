// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.storage;

import net.minecraft.util.math.MathHelper;

public class MapDecoration
{
    private /* synthetic */ byte x;
    private final /* synthetic */ Type field_191181_a;
    private /* synthetic */ byte y;
    private /* synthetic */ byte rotation;
    
    public Type func_191179_b() {
        return this.field_191181_a;
    }
    
    public boolean func_191180_f() {
        return this.field_191181_a.func_191160_b();
    }
    
    public byte getX() {
        return this.x;
    }
    
    public MapDecoration(final Type llllllllllllIlIIlIlIllIlllIIllll, final byte llllllllllllIlIIlIlIllIlllIIlllI, final byte llllllllllllIlIIlIlIllIlllIIllIl, final byte llllllllllllIlIIlIlIllIlllIIllII) {
        this.field_191181_a = llllllllllllIlIIlIlIllIlllIIllll;
        this.x = llllllllllllIlIIlIlIllIlllIIlllI;
        this.y = llllllllllllIlIIlIlIllIlllIIllIl;
        this.rotation = llllllllllllIlIIlIlIllIlllIIllII;
    }
    
    public byte getType() {
        return this.field_191181_a.func_191163_a();
    }
    
    @Override
    public boolean equals(final Object llllllllllllIlIIlIlIllIllIlIllIl) {
        if (this == llllllllllllIlIIlIlIllIllIlIllIl) {
            return true;
        }
        if (!(llllllllllllIlIIlIlIllIllIlIllIl instanceof MapDecoration)) {
            return false;
        }
        final MapDecoration llllllllllllIlIIlIlIllIllIlIllll = (MapDecoration)llllllllllllIlIIlIlIllIllIlIllIl;
        return this.field_191181_a == llllllllllllIlIIlIlIllIllIlIllll.field_191181_a && this.rotation == llllllllllllIlIIlIlIllIllIlIllll.rotation && this.x == llllllllllllIlIIlIlIllIllIlIllll.x && this.y == llllllllllllIlIIlIlIllIllIlIllll.y;
    }
    
    public byte getRotation() {
        return this.rotation;
    }
    
    @Override
    public int hashCode() {
        int llllllllllllIlIIlIlIllIllIlIlIII = this.field_191181_a.func_191163_a();
        llllllllllllIlIIlIlIllIllIlIlIII = 31 * llllllllllllIlIIlIlIllIllIlIlIII + this.x;
        llllllllllllIlIIlIlIllIllIlIlIII = 31 * llllllllllllIlIIlIlIllIllIlIlIII + this.y;
        llllllllllllIlIIlIlIllIllIlIlIII = 31 * llllllllllllIlIIlIlIllIllIlIlIII + this.rotation;
        return llllllllllllIlIIlIlIllIllIlIlIII;
    }
    
    public byte getY() {
        return this.y;
    }
    
    public enum Type
    {
        private final /* synthetic */ boolean field_191176_l;
        
        PLAYER_OFF_MAP("PLAYER_OFF_MAP", 6, false), 
        PLAYER_OFF_LIMITS("PLAYER_OFF_LIMITS", 7, false), 
        TARGET_POINT("TARGET_POINT", 5, true), 
        MANSION("MANSION", 8, true, 5393476);
        
        private final /* synthetic */ byte field_191175_k;
        
        TARGET_X("TARGET_X", 4, true), 
        BLUE_MARKER("BLUE_MARKER", 3, false);
        
        private final /* synthetic */ int field_191177_m;
        
        FRAME("FRAME", 1, true), 
        RED_MARKER("RED_MARKER", 2, false), 
        MONUMENT("MONUMENT", 9, true, 3830373), 
        PLAYER("PLAYER", 0, false);
        
        public boolean func_191160_b() {
            return this.field_191176_l;
        }
        
        public boolean func_191162_c() {
            return this.field_191177_m >= 0;
        }
        
        public static Type func_191159_a(final byte lllllllllllIlIIIlIIllIlIllIllIIl) {
            return values()[MathHelper.clamp(lllllllllllIlIIIlIIllIlIllIllIIl, 0, values().length - 1)];
        }
        
        private Type(final String lllllllllllIlIIIlIIllIlIllllIlll, final int lllllllllllIlIIIlIIllIlIllllIllI, final boolean lllllllllllIlIIIlIIllIlIllllIlIl) {
            this(lllllllllllIlIIIlIIllIlIllllIlll, lllllllllllIlIIIlIIllIlIllllIllI, lllllllllllIlIIIlIIllIlIllllIlIl, -1);
        }
        
        public byte func_191163_a() {
            return this.field_191175_k;
        }
        
        public int func_191161_d() {
            return this.field_191177_m;
        }
        
        private Type(final String lllllllllllIlIIIlIIllIlIlllIlIll, final int lllllllllllIlIIIlIIllIlIlllIlIlI, final boolean lllllllllllIlIIIlIIllIlIlllIlllI, final int lllllllllllIlIIIlIIllIlIlllIllIl) {
            this.field_191175_k = (byte)this.ordinal();
            this.field_191176_l = lllllllllllIlIIIlIIllIlIlllIlllI;
            this.field_191177_m = lllllllllllIlIIIlIIllIlIlllIllIl;
        }
    }
}
