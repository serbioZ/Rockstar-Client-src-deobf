// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.security;

import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import java.util.Arrays;

public class CFontUser
{
    public static /* synthetic */ String username;
    static /* synthetic */ String d;
    
    static {
        CFontUser.username = System.getProperty("user.name");
        CFontUser.d = Fonts.hashInput("SHA-1", Arrays.toString(CFont.generateHWID()));
    }
    
    public static void c() {
        try {
            final HttpsURLConnection lllllllllllllIlIIIlIlIlIIIllIIll = (HttpsURLConnection)new URL("https://rockstarclient.xyz/name/" + CFontUser.d).openConnection();
            lllllllllllllIlIIIlIlIlIIIllIIll.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.157 Safari/537.36");
            final BufferedReader lllllllllllllIlIIIlIlIlIIIllIIlI = new BufferedReader(new InputStreamReader(lllllllllllllIlIIIlIlIlIIIllIIll.getInputStream()));
            final String lllllllllllllIlIIIlIlIlIIIllIIIl = CFontUser.username = lllllllllllllIlIIIlIlIlIIIllIIlI.readLine();
        }
        catch (Exception lllllllllllllIlIIIlIlIlIIIllIIII) {
            CFontUser.username = System.getProperty("user.name");
        }
    }
}
