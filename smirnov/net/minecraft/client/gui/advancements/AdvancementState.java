// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui.advancements;

public enum AdvancementState
{
    private final /* synthetic */ int field_192671_d;
    
    UNOBTAINED("UNOBTAINED", 1, 1), 
    OBTAINED("OBTAINED", 0, 0);
    
    private AdvancementState(final String lllllllllllllllIlIIIlIllIIIIllIl, final int lllllllllllllllIlIIIlIllIIIIllII, final int lllllllllllllllIlIIIlIllIIIIllll) {
        this.field_192671_d = lllllllllllllllIlIIIlIllIIIIllll;
    }
    
    public int func_192667_a() {
        return this.field_192671_d;
    }
}
