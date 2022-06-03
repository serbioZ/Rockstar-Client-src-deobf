// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.resources;

import java.util.Map;

public class I18n
{
    private static /* synthetic */ Locale i18nLocale;
    
    public static boolean hasKey(final String llllllllllllllIIIIIllIIlllllllIl) {
        return I18n.i18nLocale.hasKey(llllllllllllllIIIIIllIIlllllllIl);
    }
    
    public static String format(final String llllllllllllllIIIIIllIlIIIIIIIIl, final Object... llllllllllllllIIIIIllIlIIIIIIIlI) {
        return I18n.i18nLocale.formatMessage(llllllllllllllIIIIIllIlIIIIIIIIl, llllllllllllllIIIIIllIlIIIIIIIlI);
    }
    
    public static Map getLocaleProperties() {
        return I18n.i18nLocale.properties;
    }
    
    static void setLocale(final Locale llllllllllllllIIIIIllIlIIIIIIllI) {
        I18n.i18nLocale = llllllllllllllIIIIIllIlIIIIIIllI;
    }
}
