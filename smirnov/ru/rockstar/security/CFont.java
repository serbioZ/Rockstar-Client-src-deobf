// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.security;

import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;

public class CFont
{
    private static final /* synthetic */ char[] hexArray;
    
    static {
        hexArray = "0123456789ABCDEF".toCharArray();
    }
    
    public static byte[] generateHWID() {
        try {
            final MessageDigest llllllllllllIIIlIIIllIlIIIIllIIl = MessageDigest.getInstance("MD5");
            final String llllllllllllIIIlIIIllIlIIIIllIII = String.valueOf(System.getProperty("os.name")) + System.getProperty("os.arch") + System.getProperty("os.version") + System.getProperty("user.name") + Runtime.getRuntime().availableProcessors() + System.getenv("PROCESSOR_IDENTIFIER") + System.getenv("PROCESSOR_ARCHITECTURE") + System.getenv("PROCESSOR_ARCHITEW6432") + System.getenv("NUMBER_OF_PROCESSORS");
            return llllllllllllIIIlIIIllIlIIIIllIIl.digest(llllllllllllIIIlIIIllIlIIIIllIII.getBytes());
        }
        catch (NoSuchAlgorithmException llllllllllllIIIlIIIllIlIIIIlIlll) {
            throw new Error("Algorithm wasn't found.", llllllllllllIIIlIIIllIlIIIIlIlll);
        }
    }
    
    public static byte[] hexStringToByteArray(final String llllllllllllIIIlIIIllIlIIIIIllII) {
        final int llllllllllllIIIlIIIllIlIIIIIllll = llllllllllllIIIlIIIllIlIIIIIllII.length();
        final byte[] llllllllllllIIIlIIIllIlIIIIIlllI = new byte[llllllllllllIIIlIIIllIlIIIIIllll / 2];
        for (int llllllllllllIIIlIIIllIlIIIIIllIl = 0; llllllllllllIIIlIIIllIlIIIIIllIl < llllllllllllIIIlIIIllIlIIIIIllll; llllllllllllIIIlIIIllIlIIIIIllIl += 2) {
            llllllllllllIIIlIIIllIlIIIIIlllI[llllllllllllIIIlIIIllIlIIIIIllIl / 2] = (byte)((Character.digit(llllllllllllIIIlIIIllIlIIIIIllII.charAt(llllllllllllIIIlIIIllIlIIIIIllIl), 16) << 4) + Character.digit(llllllllllllIIIlIIIllIlIIIIIllII.charAt(llllllllllllIIIlIIIllIlIIIIIllIl + 1), 16));
        }
        return llllllllllllIIIlIIIllIlIIIIIlllI;
    }
    
    public static String bytesToHex(final byte[] llllllllllllIIIlIIIllIlIIIIIIlII) {
        final char[] llllllllllllIIIlIIIllIlIIIIIIIll = new char[llllllllllllIIIlIIIllIlIIIIIIlII.length * 2];
        for (int llllllllllllIIIlIIIllIlIIIIIIIlI = 0; llllllllllllIIIlIIIllIlIIIIIIIlI < llllllllllllIIIlIIIllIlIIIIIIlII.length; ++llllllllllllIIIlIIIllIlIIIIIIIlI) {
            final int llllllllllllIIIlIIIllIlIIIIIIIIl = llllllllllllIIIlIIIllIlIIIIIIlII[llllllllllllIIIlIIIllIlIIIIIIIlI] & 0xFF;
            llllllllllllIIIlIIIllIlIIIIIIIll[llllllllllllIIIlIIIllIlIIIIIIIlI * 2] = CFont.hexArray[llllllllllllIIIlIIIllIlIIIIIIIIl >>> 4];
            llllllllllllIIIlIIIllIlIIIIIIIll[llllllllllllIIIlIIIllIlIIIIIIIlI * 2 + 1] = CFont.hexArray[llllllllllllIIIlIIIllIlIIIIIIIIl & 0xF];
        }
        return new String(llllllllllllIIIlIIIllIlIIIIIIIll);
    }
}
