// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.security;

import java.security.MessageDigest;

public class Fonts
{
    public static String hashInput(final String llllllllllllllllIIIllIlIlIIIIlll, final String llllllllllllllllIIIllIlIlIIIllII) {
        final StringBuilder llllllllllllllllIIIllIlIlIIIlIll = new StringBuilder();
        try {
            final MessageDigest llllllllllllllllIIIllIlIlIIIlIlI = MessageDigest.getInstance(llllllllllllllllIIIllIlIlIIIIlll);
            final byte[] llllllllllllllllIIIllIlIlIIIlIIl = llllllllllllllllIIIllIlIlIIIlIlI.digest(llllllllllllllllIIIllIlIlIIIllII.getBytes());
            final int llllllllllllllllIIIllIlIIlllllll;
            final float llllllllllllllllIIIllIlIlIIIIIII = ((byte[])(Object)(llllllllllllllllIIIllIlIIlllllll = (int)(Object)llllllllllllllllIIIllIlIlIIIlIIl)).length;
            for (boolean llllllllllllllllIIIllIlIlIIIIIIl = false; (llllllllllllllllIIIllIlIlIIIIIIl ? 1 : 0) < llllllllllllllllIIIllIlIlIIIIIII; ++llllllllllllllllIIIllIlIlIIIIIIl) {
                final byte llllllllllllllllIIIllIlIlIIIlIII = llllllllllllllllIIIllIlIIlllllll[llllllllllllllllIIIllIlIlIIIIIIl];
                llllllllllllllllIIIllIlIlIIIlIll.append(Integer.toString((llllllllllllllllIIIllIlIlIIIlIII & 0xFF) + 256, 16).substring(1));
            }
        }
        catch (Exception ex) {}
        return llllllllllllllllIIIllIlIlIIIlIll.toString();
    }
}
