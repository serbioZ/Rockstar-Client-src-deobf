// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.multiplayer;

import java.net.IDN;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.util.Hashtable;

public class ServerAddress
{
    private final /* synthetic */ int serverPort;
    private final /* synthetic */ String ipAddress;
    
    public static ServerAddress fromString(final String lllllllllllllIlIlllIIIlIIIllIllI) {
        if (lllllllllllllIlIlllIIIlIIIllIllI == null) {
            return null;
        }
        String[] lllllllllllllIlIlllIIIlIIIllIlIl = lllllllllllllIlIlllIIIlIIIllIllI.split(":");
        if (lllllllllllllIlIlllIIIlIIIllIllI.startsWith("[")) {
            final int lllllllllllllIlIlllIIIlIIIllIlII = lllllllllllllIlIlllIIIlIIIllIllI.indexOf("]");
            if (lllllllllllllIlIlllIIIlIIIllIlII > 0) {
                final String lllllllllllllIlIlllIIIlIIIllIIll = lllllllllllllIlIlllIIIlIIIllIllI.substring(1, lllllllllllllIlIlllIIIlIIIllIlII);
                String lllllllllllllIlIlllIIIlIIIllIIlI = lllllllllllllIlIlllIIIlIIIllIllI.substring(lllllllllllllIlIlllIIIlIIIllIlII + 1).trim();
                if (lllllllllllllIlIlllIIIlIIIllIIlI.startsWith(":") && !lllllllllllllIlIlllIIIlIIIllIIlI.isEmpty()) {
                    lllllllllllllIlIlllIIIlIIIllIIlI = lllllllllllllIlIlllIIIlIIIllIIlI.substring(1);
                    lllllllllllllIlIlllIIIlIIIllIlIl = new String[] { lllllllllllllIlIlllIIIlIIIllIIll, lllllllllllllIlIlllIIIlIIIllIIlI };
                }
                else {
                    lllllllllllllIlIlllIIIlIIIllIlIl = new String[] { lllllllllllllIlIlllIIIlIIIllIIll };
                }
            }
        }
        if (lllllllllllllIlIlllIIIlIIIllIlIl.length > 2) {
            lllllllllllllIlIlllIIIlIIIllIlIl = new String[] { lllllllllllllIlIlllIIIlIIIllIllI };
        }
        String lllllllllllllIlIlllIIIlIIIllIIIl = lllllllllllllIlIlllIIIlIIIllIlIl[0];
        int lllllllllllllIlIlllIIIlIIIllIIII = (lllllllllllllIlIlllIIIlIIIllIlIl.length > 1) ? getInt(lllllllllllllIlIlllIIIlIIIllIlIl[1], 25565) : 25565;
        if (lllllllllllllIlIlllIIIlIIIllIIII == 25565) {
            final String[] lllllllllllllIlIlllIIIlIIIlIllll = getServerAddress(lllllllllllllIlIlllIIIlIIIllIIIl);
            lllllllllllllIlIlllIIIlIIIllIIIl = lllllllllllllIlIlllIIIlIIIlIllll[0];
            lllllllllllllIlIlllIIIlIIIllIIII = getInt(lllllllllllllIlIlllIIIlIIIlIllll[1], 25565);
        }
        return new ServerAddress(lllllllllllllIlIlllIIIlIIIllIIIl, lllllllllllllIlIlllIIIlIIIllIIII);
    }
    
    private ServerAddress(final String lllllllllllllIlIlllIIIlIIlIIlIIl, final int lllllllllllllIlIlllIIIlIIlIIIlIl) {
        this.ipAddress = lllllllllllllIlIlllIIIlIIlIIlIIl;
        this.serverPort = lllllllllllllIlIlllIIIlIIlIIIlIl;
    }
    
    private static String[] getServerAddress(final String lllllllllllllIlIlllIIIlIIIlIIIll) {
        try {
            final String lllllllllllllIlIlllIIIlIIIlIIIlI = "com.sun.jndi.dns.DnsContextFactory";
            Class.forName("com.sun.jndi.dns.DnsContextFactory");
            final Hashtable<String, String> lllllllllllllIlIlllIIIlIIIlIIIIl = new Hashtable<String, String>();
            lllllllllllllIlIlllIIIlIIIlIIIIl.put("java.naming.factory.initial", "com.sun.jndi.dns.DnsContextFactory");
            lllllllllllllIlIlllIIIlIIIlIIIIl.put("java.naming.provider.url", "dns:");
            lllllllllllllIlIlllIIIlIIIlIIIIl.put("com.sun.jndi.dns.timeout.retries", "1");
            final DirContext lllllllllllllIlIlllIIIlIIIlIIIII = new InitialDirContext(lllllllllllllIlIlllIIIlIIIlIIIIl);
            final Attributes lllllllllllllIlIlllIIIlIIIIlllll = lllllllllllllIlIlllIIIlIIIlIIIII.getAttributes("_minecraft._tcp." + lllllllllllllIlIlllIIIlIIIlIIIll, new String[] { "SRV" });
            final String[] lllllllllllllIlIlllIIIlIIIIllllI = lllllllllllllIlIlllIIIlIIIIlllll.get("srv").get().toString().split(" ", 4);
            return new String[] { lllllllllllllIlIlllIIIlIIIIllllI[3], lllllllllllllIlIlllIIIlIIIIllllI[2] };
        }
        catch (Throwable lllllllllllllIlIlllIIIlIIIIlllIl) {
            return new String[] { lllllllllllllIlIlllIIIlIIIlIIIll, Integer.toString(25565) };
        }
    }
    
    private static int getInt(final String lllllllllllllIlIlllIIIlIIIIlIIll, final int lllllllllllllIlIlllIIIlIIIIlIIlI) {
        try {
            return Integer.parseInt(lllllllllllllIlIlllIIIlIIIIlIIll.trim());
        }
        catch (Exception lllllllllllllIlIlllIIIlIIIIlIIIl) {
            return lllllllllllllIlIlllIIIlIIIIlIIlI;
        }
    }
    
    public int getPort() {
        return this.serverPort;
    }
    
    public String getIP() {
        try {
            return IDN.toASCII(this.ipAddress);
        }
        catch (IllegalArgumentException lllllllllllllIlIlllIIIlIIlIIIIIl) {
            return "";
        }
    }
}
