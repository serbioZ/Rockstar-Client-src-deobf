// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.util;

public interface ITooltipFlag
{
    boolean func_194127_a();
    
    public enum TooltipFlags implements ITooltipFlag
    {
        NORMAL("NORMAL", 0, false), 
        ADVANCED("ADVANCED", 1, true);
        
        final /* synthetic */ boolean field_194131_c;
        
        @Override
        public boolean func_194127_a() {
            return this.field_194131_c;
        }
        
        private TooltipFlags(final String lllllllllllllIlIIIlIIllIIIllllll, final int lllllllllllllIlIIIlIIllIIIlllllI, final boolean lllllllllllllIlIIIlIIllIIlIIIIIl) {
            this.field_194131_c = lllllllllllllIlIIIlIIllIIlIIIIIl;
        }
    }
}
