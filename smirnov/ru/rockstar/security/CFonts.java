// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.security;

import java.net.UnknownHostException;
import java.net.SocketAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.io.IOException;

public class CFonts
{
    public static boolean isInternetAvailable() throws IOException {
        return isHostAvailable("google.com") || isHostAvailable("amazon.com") || isHostAvailable("facebook.com") || isHostAvailable("apple.com");
    }
    
    private static boolean isHostAvailable(final String lllllllllllIIIIlIlIIllIIlllIIlIl) throws IOException {
        try {
            char lllllllllllIIIIlIlIIllIIlllIIlII = (char)null;
            final double lllllllllllIIIIlIlIIllIIlllIIIll = (double)null;
            try {
                final Socket lllllllllllIIIIlIlIIllIIlllIlIIl = new Socket();
                try {
                    final int lllllllllllIIIIlIlIIllIIlllIlIII = 80;
                    final InetSocketAddress lllllllllllIIIIlIlIIllIIlllIIlll = new InetSocketAddress(lllllllllllIIIIlIlIIllIIlllIIlIl, lllllllllllIIIIlIlIIllIIlllIlIII);
                    lllllllllllIIIIlIlIIllIIlllIlIIl.connect(lllllllllllIIIIlIlIIllIIlllIIlll, 3000);
                    return true;
                }
                finally {
                    if (lllllllllllIIIIlIlIIllIIlllIlIIl != null) {
                        lllllllllllIIIIlIlIIllIIlllIlIIl.close();
                    }
                }
            }
            finally {
                if (lllllllllllIIIIlIlIIllIIlllIIlII == null) {
                    lllllllllllIIIIlIlIIllIIlllIIlII = (char)lllllllllllIIIIlIlIIllIIlllIIIll;
                }
                else if (lllllllllllIIIIlIlIIllIIlllIIlII != lllllllllllIIIIlIlIIllIIlllIIIll) {
                    ((Throwable)lllllllllllIIIIlIlIIllIIlllIIlII).addSuppressed((Throwable)lllllllllllIIIIlIlIIllIIlllIIIll);
                }
            }
        }
        catch (UnknownHostException lllllllllllIIIIlIlIIllIIlllIIllI) {
            return false;
        }
    }
}
