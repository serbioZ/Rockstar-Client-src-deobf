// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.util;

import io.netty.util.ResourceLeakDetector;

public class ChatAllowedCharacters
{
    public static final /* synthetic */ ResourceLeakDetector.Level NETTY_LEAK_DETECTION;
    
    static {
        NETTY_LEAK_DETECTION = ResourceLeakDetector.Level.DISABLED;
        ILLEGAL_STRUCTURE_CHARACTERS = new char[] { '.', '\n', '\r', '\t', '\0', '\f', '`', '?', '*', '\\', '<', '>', '|', '\"' };
        ILLEGAL_FILE_CHARACTERS = new char[] { '/', '\n', '\r', '\t', '\0', '\f', '`', '?', '*', '\\', '<', '>', '|', '\"', ':' };
        ResourceLeakDetector.setLevel(ChatAllowedCharacters.NETTY_LEAK_DETECTION);
    }
    
    public static boolean isAllowedCharacter(final char llllllllllIlllIlIllIllIlIlIIIIlI) {
        return llllllllllIlllIlIllIllIlIlIIIIlI != '§' && llllllllllIlllIlIllIllIlIlIIIIlI >= ' ' && llllllllllIlllIlIllIllIlIlIIIIlI != '\u007f';
    }
    
    public static String filterAllowedCharacters(final String llllllllllIlllIlIllIllIlIIllIlll) {
        final StringBuilder llllllllllIlllIlIllIllIlIIlllIIl = new StringBuilder();
        final String llllllllllIlllIlIllIllIlIIllIIlI;
        final float llllllllllIlllIlIllIllIlIIllIIll = ((char[])(Object)(llllllllllIlllIlIllIllIlIIllIIlI = (String)(Object)llllllllllIlllIlIllIllIlIIllIlll.toCharArray())).length;
        for (char llllllllllIlllIlIllIllIlIIllIlII = '\0'; llllllllllIlllIlIllIllIlIIllIlII < llllllllllIlllIlIllIllIlIIllIIll; ++llllllllllIlllIlIllIllIlIIllIlII) {
            final char llllllllllIlllIlIllIllIlIIlllIII = llllllllllIlllIlIllIllIlIIllIIlI[llllllllllIlllIlIllIllIlIIllIlII];
            if (isAllowedCharacter(llllllllllIlllIlIllIllIlIIlllIII)) {
                llllllllllIlllIlIllIllIlIIlllIIl.append(llllllllllIlllIlIllIllIlIIlllIII);
            }
        }
        return llllllllllIlllIlIllIllIlIIlllIIl.toString();
    }
}
