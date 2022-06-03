// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.advancements;

import net.minecraft.util.text.TextFormatting;

public enum FrameType
{
    GOAL("GOAL", 2, "goal", 52, TextFormatting.GREEN);
    
    private final /* synthetic */ int field_192314_e;
    private final /* synthetic */ String field_192313_d;
    private final /* synthetic */ TextFormatting field_193230_f;
    
    CHALLENGE("CHALLENGE", 1, "challenge", 26, TextFormatting.DARK_PURPLE), 
    TASK("TASK", 0, "task", 0, TextFormatting.GREEN);
    
    private FrameType(final String lllllllllllllllIIlIlllllIlIllIlI, final int lllllllllllllllIIlIlllllIlIllIIl, final String lllllllllllllllIIlIlllllIlIllllI, final int lllllllllllllllIIlIlllllIlIlllIl, final TextFormatting lllllllllllllllIIlIlllllIlIlllII) {
        this.field_192313_d = lllllllllllllllIIlIlllllIlIllllI;
        this.field_192314_e = lllllllllllllllIIlIlllllIlIlllIl;
        this.field_193230_f = lllllllllllllllIIlIlllllIlIlllII;
    }
    
    public String func_192307_a() {
        return this.field_192313_d;
    }
    
    public TextFormatting func_193229_c() {
        return this.field_193230_f;
    }
    
    public int func_192309_b() {
        return this.field_192314_e;
    }
    
    public static FrameType func_192308_a(final String lllllllllllllllIIlIlllllIlIIlIlI) {
        final int lllllllllllllllIIlIlllllIlIIIlII;
        final double lllllllllllllllIIlIlllllIlIIIlIl = ((FrameType[])(Object)(lllllllllllllllIIlIlllllIlIIIlII = (int)(Object)values())).length;
        for (Exception lllllllllllllllIIlIlllllIlIIIllI = (Exception)0; lllllllllllllllIIlIlllllIlIIIllI < lllllllllllllllIIlIlllllIlIIIlIl; ++lllllllllllllllIIlIlllllIlIIIllI) {
            final FrameType lllllllllllllllIIlIlllllIlIIlIIl = lllllllllllllllIIlIlllllIlIIIlII[lllllllllllllllIIlIlllllIlIIIllI];
            if (lllllllllllllllIIlIlllllIlIIlIIl.field_192313_d.equals(lllllllllllllllIIlIlllllIlIIlIlI)) {
                return lllllllllllllllIIlIlllllIlIIlIIl;
            }
        }
        throw new IllegalArgumentException("Unknown frame type '" + lllllllllllllllIIlIlllllIlIIlIlI + "'");
    }
}
