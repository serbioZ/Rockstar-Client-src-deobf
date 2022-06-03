// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.altmanager.althening.api;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class AltService
{
    private final /* synthetic */ AltHelper userAuthentication;
    private /* synthetic */ EnumAltService currentService;
    private final /* synthetic */ AltHelper minecraftSession;
    
    public AltService() {
        this.userAuthentication = new AltHelper("com.mojang.authlib.yggdrasil.YggdrasilUserAuthentication");
        this.minecraftSession = new AltHelper("com.mojang.authlib.yggdrasil.YggdrasilMinecraftSessionService");
    }
    
    private void reflectionFields(final String lllllllllllIIIIlllIllllllIllIIII) throws NoSuchFieldException, IllegalAccessException {
        final HashMap<String, URL> lllllllllllIIIIlllIllllllIllIIll = new HashMap<String, URL>();
        final String lllllllllllIIIIlllIllllllIllIIlI = lllllllllllIIIIlllIllllllIllIIII.contains("thealtening") ? "http" : "https";
        lllllllllllIIIIlllIllllllIllIIll.put("ROUTE_AUTHENTICATE", this.constantURL(String.valueOf(lllllllllllIIIIlllIllllllIllIIlI) + "://authserver." + lllllllllllIIIIlllIllllllIllIIII + ".com/authenticate"));
        lllllllllllIIIIlllIllllllIllIIll.put("ROUTE_INVALIDATE", this.constantURL(String.valueOf(lllllllllllIIIIlllIllllllIllIIlI) + "://authserver" + lllllllllllIIIIlllIllllllIllIIII + "com/invalidate"));
        lllllllllllIIIIlllIllllllIllIIll.put("ROUTE_REFRESH", this.constantURL(String.valueOf(lllllllllllIIIIlllIllllllIllIIlI) + "://authserver." + lllllllllllIIIIlllIllllllIllIIII + ".com/refresh"));
        lllllllllllIIIIlllIllllllIllIIll.put("ROUTE_VALIDATE", this.constantURL(String.valueOf(lllllllllllIIIIlllIllllllIllIIlI) + "://authserver." + lllllllllllIIIIlllIllllllIllIIII + ".com/validate"));
        lllllllllllIIIIlllIllllllIllIIll.put("ROUTE_SIGNOUT", this.constantURL(String.valueOf(lllllllllllIIIIlllIllllllIllIIlI) + "://authserver." + lllllllllllIIIIlllIllllllIllIIII + ".com/signout"));
        lllllllllllIIIIlllIllllllIllIIll.forEach((lllllllllllIIIIlllIllllllIlIIIIl, lllllllllllIIIIlllIllllllIlIIIII) -> {
            try {
                this.userAuthentication.setStaticField(lllllllllllIIIIlllIllllllIlIIIIl, lllllllllllIIIIlllIllllllIlIIIII);
            }
            catch (Exception lllllllllllIIIIlllIllllllIIlllll) {
                lllllllllllIIIIlllIllllllIIlllll.printStackTrace();
            }
            return;
        });
        this.userAuthentication.setStaticField("BASE_URL", String.valueOf(lllllllllllIIIIlllIllllllIllIIlI) + "://authserver." + lllllllllllIIIIlllIllllllIllIIII + ".com/");
        this.minecraftSession.setStaticField("BASE_URL", String.valueOf(lllllllllllIIIIlllIllllllIllIIlI) + "://sessionserver." + lllllllllllIIIIlllIllllllIllIIII + ".com/session/minecraft/");
        this.minecraftSession.setStaticField("JOIN_URL", this.constantURL(String.valueOf(lllllllllllIIIIlllIllllllIllIIlI) + "://sessionserver." + lllllllllllIIIIlllIllllllIllIIII + ".com/session/minecraft/join"));
        this.minecraftSession.setStaticField("CHECK_URL", this.constantURL(String.valueOf(lllllllllllIIIIlllIllllllIllIIlI) + "://sessionserver." + lllllllllllIIIIlllIllllllIllIIII + ".com/session/minecraft/hasJoined"));
        this.minecraftSession.setStaticField("WHITELISTED_DOMAINS", new String[] { ".minecraft.net", ".mojang.com", ".thealtening.com" });
    }
    
    public void switchService(final EnumAltService lllllllllllIIIIlllIllllllIllllII) throws IllegalAccessException, NoSuchFieldException {
        if (this.currentService != lllllllllllIIIIlllIllllllIllllII) {
            this.reflectionFields(lllllllllllIIIIlllIllllllIllllII.hostname);
            this.currentService = lllllllllllIIIIlllIllllllIllllII;
        }
    }
    
    private URL constantURL(final String lllllllllllIIIIlllIllllllIlIlIlI) {
        try {
            return new URL(lllllllllllIIIIlllIllllllIlIlIlI);
        }
        catch (MalformedURLException lllllllllllIIIIlllIllllllIlIlIIl) {
            return null;
        }
    }
    
    public enum EnumAltService
    {
        THEALTENING("THEALTENING", 1, "THEALTENING", 1, "thealtening"), 
        MOJANG("MOJANG", 0, "MOJANG", 0, "mojang");
        
        /* synthetic */ String hostname;
        
        private EnumAltService(final String lllllllllllIlIIIIIlIllIIIlllIIII, final int lllllllllllIlIIIIIlIllIIIllIllll, final String lllllllllllIlIIIIIlIllIIIlllIlII, final int lllllllllllIlIIIIIlIllIIIlllIIll, final String lllllllllllIlIIIIIlIllIIIllIlllI) {
            this.hostname = lllllllllllIlIIIIIlIllIIIllIlllI;
        }
    }
}
