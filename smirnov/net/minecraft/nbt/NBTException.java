// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.nbt;

public class NBTException extends Exception
{
    private static String func_193592_a(final String llllllllllllllIlIIIllIlIlllllIll, final int llllllllllllllIlIIIllIlIllllIllI) {
        final StringBuilder llllllllllllllIlIIIllIlIlllllIIl = new StringBuilder();
        final int llllllllllllllIlIIIllIlIlllllIII = Math.min(llllllllllllllIlIIIllIlIlllllIll.length(), llllllllllllllIlIIIllIlIllllIllI);
        if (llllllllllllllIlIIIllIlIlllllIII > 35) {
            llllllllllllllIlIIIllIlIlllllIIl.append("...");
        }
        llllllllllllllIlIIIllIlIlllllIIl.append(llllllllllllllIlIIIllIlIlllllIll.substring(Math.max(0, llllllllllllllIlIIIllIlIlllllIII - 35), llllllllllllllIlIIIllIlIlllllIII));
        llllllllllllllIlIIIllIlIlllllIIl.append("<--[HERE]");
        return llllllllllllllIlIIIllIlIlllllIIl.toString();
    }
    
    public NBTException(final String llllllllllllllIlIIIllIllIIIIIllI, final String llllllllllllllIlIIIllIllIIIIIIIl, final int llllllllllllllIlIIIllIllIIIIIlII) {
        super(String.valueOf(llllllllllllllIlIIIllIllIIIIIllI) + " at: " + func_193592_a(llllllllllllllIlIIIllIllIIIIIIIl, llllllllllllllIlIIIllIllIIIIIlII));
    }
}
