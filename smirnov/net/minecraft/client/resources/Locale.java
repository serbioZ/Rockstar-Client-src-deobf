// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.resources;

import com.google.common.collect.Maps;
import java.util.IllegalFormatException;
import com.google.common.collect.Iterables;
import java.nio.charset.StandardCharsets;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;
import java.io.IOException;
import net.minecraft.util.ResourceLocation;
import java.util.List;
import com.google.common.base.Splitter;
import java.util.Map;
import java.util.regex.Pattern;

public class Locale
{
    private static final /* synthetic */ Pattern PATTERN;
    private /* synthetic */ boolean unicode;
    /* synthetic */ Map<String, String> properties;
    private static final /* synthetic */ Splitter SPLITTER;
    
    public synchronized void loadLocaleDataFiles(final IResourceManager lllllllllllllIlIlIllIlllIlllllll, final List<String> lllllllllllllIlIlIllIlllIllllllI) {
        this.properties.clear();
        for (final String lllllllllllllIlIlIllIllllIIIIIll : lllllllllllllIlIlIllIlllIllllllI) {
            final String lllllllllllllIlIlIllIllllIIIIIlI = String.format("lang/%s.lang", lllllllllllllIlIlIllIllllIIIIIll);
            for (final String lllllllllllllIlIlIllIllllIIIIIIl : lllllllllllllIlIlIllIlllIlllllll.getResourceDomains()) {
                try {
                    this.loadLocaleData(lllllllllllllIlIlIllIlllIlllllll.getAllResources(new ResourceLocation(lllllllllllllIlIlIllIllllIIIIIIl, lllllllllllllIlIlIllIllllIIIIIlI)));
                }
                catch (IOException ex) {}
            }
        }
        this.checkUnicode();
    }
    
    public boolean hasKey(final String lllllllllllllIlIlIllIlllIIIllllI) {
        return this.properties.containsKey(lllllllllllllIlIlIllIlllIIIllllI);
    }
    
    private void loadLocaleData(final List<IResource> lllllllllllllIlIlIllIlllIlIllIII) throws IOException {
        for (final IResource lllllllllllllIlIlIllIlllIlIlIlll : lllllllllllllIlIlIllIlllIlIllIII) {
            final InputStream lllllllllllllIlIlIllIlllIlIlIllI = lllllllllllllIlIlIllIlllIlIlIlll.getInputStream();
            try {
                this.loadLocaleData(lllllllllllllIlIlIllIlllIlIlIllI);
            }
            finally {
                IOUtils.closeQuietly(lllllllllllllIlIlIllIlllIlIlIllI);
            }
            IOUtils.closeQuietly(lllllllllllllIlIlIllIlllIlIlIllI);
        }
    }
    
    private void loadLocaleData(final InputStream lllllllllllllIlIlIllIlllIlIIIlll) throws IOException {
        for (final String lllllllllllllIlIlIllIlllIlIIIllI : IOUtils.readLines(lllllllllllllIlIlIllIlllIlIIIlll, StandardCharsets.UTF_8)) {
            if (!lllllllllllllIlIlIllIlllIlIIIllI.isEmpty() && lllllllllllllIlIlIllIlllIlIIIllI.charAt(0) != '#') {
                final String[] lllllllllllllIlIlIllIlllIlIIIlIl = (String[])Iterables.toArray(Locale.SPLITTER.split((CharSequence)lllllllllllllIlIlIllIlllIlIIIllI), (Class)String.class);
                if (lllllllllllllIlIlIllIlllIlIIIlIl == null || lllllllllllllIlIlIllIlllIlIIIlIl.length != 2) {
                    continue;
                }
                final String lllllllllllllIlIlIllIlllIlIIIlII = lllllllllllllIlIlIllIlllIlIIIlIl[0];
                final String lllllllllllllIlIlIllIlllIlIIIIll = Locale.PATTERN.matcher(lllllllllllllIlIlIllIlllIlIIIlIl[1]).replaceAll("%$1s");
                this.properties.put(lllllllllllllIlIlIllIlllIlIIIlII, lllllllllllllIlIlIllIlllIlIIIIll);
            }
        }
    }
    
    public String formatMessage(final String lllllllllllllIlIlIllIlllIIlIllII, final Object[] lllllllllllllIlIlIllIlllIIlIlIll) {
        final String lllllllllllllIlIlIllIlllIIlIlIlI = this.translateKeyPrivate(lllllllllllllIlIlIllIlllIIlIllII);
        try {
            return String.format(lllllllllllllIlIlIllIlllIIlIlIlI, lllllllllllllIlIlIllIlllIIlIlIll);
        }
        catch (IllegalFormatException lllllllllllllIlIlIllIlllIIlIlIIl) {
            return "Format error: " + lllllllllllllIlIlIllIlllIIlIlIlI;
        }
    }
    
    private String translateKeyPrivate(final String lllllllllllllIlIlIllIlllIIllIlll) {
        final String lllllllllllllIlIlIllIlllIIllIllI = this.properties.get(lllllllllllllIlIlIllIlllIIllIlll);
        return (lllllllllllllIlIlIllIlllIIllIllI == null) ? lllllllllllllIlIlIllIlllIIllIlll : lllllllllllllIlIlIllIlllIIllIllI;
    }
    
    static {
        SPLITTER = Splitter.on('=').limit(2);
        PATTERN = Pattern.compile("%(\\d+\\$)?[\\d\\.]*[df]");
    }
    
    public Locale() {
        this.properties = (Map<String, String>)Maps.newHashMap();
    }
    
    private void checkUnicode() {
        this.unicode = false;
        int lllllllllllllIlIlIllIlllIllIllII = 0;
        int lllllllllllllIlIlIllIlllIllIlIll = 0;
        for (final String lllllllllllllIlIlIllIlllIllIlIlI : this.properties.values()) {
            final int lllllllllllllIlIlIllIlllIllIlIIl = lllllllllllllIlIlIllIlllIllIlIlI.length();
            lllllllllllllIlIlIllIlllIllIlIll += lllllllllllllIlIlIllIlllIllIlIIl;
            for (int lllllllllllllIlIlIllIlllIllIlIII = 0; lllllllllllllIlIlIllIlllIllIlIII < lllllllllllllIlIlIllIlllIllIlIIl; ++lllllllllllllIlIlIllIlllIllIlIII) {
                if (lllllllllllllIlIlIllIlllIllIlIlI.charAt(lllllllllllllIlIlIllIlllIllIlIII) >= '\u0100') {
                    ++lllllllllllllIlIlIllIlllIllIllII;
                }
            }
        }
        final float lllllllllllllIlIlIllIlllIllIIlll = lllllllllllllIlIlIllIlllIllIllII / (float)lllllllllllllIlIlIllIlllIllIlIll;
        this.unicode = (lllllllllllllIlIlIllIlllIllIIlll > 0.1);
    }
    
    public boolean isUnicode() {
        return this.unicode;
    }
}
