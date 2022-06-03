// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.resources;

import org.apache.logging.log4j.LogManager;
import net.minecraft.util.text.translation.LanguageMap;
import com.google.common.collect.Lists;
import java.io.IOException;
import net.minecraft.client.resources.data.LanguageMetadataSection;
import java.util.List;
import com.google.common.collect.Sets;
import java.util.SortedSet;
import com.google.common.collect.Maps;
import net.minecraft.client.resources.data.MetadataSerializer;
import org.apache.logging.log4j.Logger;
import java.util.Map;

public class LanguageManager implements IResourceManagerReloadListener
{
    protected static final /* synthetic */ Locale CURRENT_LOCALE;
    private /* synthetic */ String currentLanguage;
    private final /* synthetic */ Map<String, Language> languageMap;
    private static final /* synthetic */ Logger LOGGER;
    private final /* synthetic */ MetadataSerializer theMetadataSerializer;
    
    public Language getCurrentLanguage() {
        final String llllllllllllIIIIIIIIlIllllIlllIl = this.languageMap.containsKey(this.currentLanguage) ? this.currentLanguage : "en_us";
        return this.languageMap.get(llllllllllllIIIIIIIIlIllllIlllIl);
    }
    
    public void setCurrentLanguage(final Language llllllllllllIIIIIIIIlIlllllIIIll) {
        this.currentLanguage = llllllllllllIIIIIIIIlIlllllIIIll.getLanguageCode();
    }
    
    public LanguageManager(final MetadataSerializer llllllllllllIIIIIIIIllIIIIIIllIl, final String llllllllllllIIIIIIIIllIIIIIIlIIl) {
        this.languageMap = (Map<String, Language>)Maps.newHashMap();
        this.theMetadataSerializer = llllllllllllIIIIIIIIllIIIIIIllIl;
        this.currentLanguage = llllllllllllIIIIIIIIllIIIIIIlIIl;
        I18n.setLocale(LanguageManager.CURRENT_LOCALE);
    }
    
    public SortedSet<Language> getLanguages() {
        return (SortedSet<Language>)Sets.newTreeSet((Iterable)this.languageMap.values());
    }
    
    public void parseLanguageMetadata(final List<IResourcePack> llllllllllllIIIIIIIIlIlllllllIIl) {
        this.languageMap.clear();
        for (final IResourcePack llllllllllllIIIIIIIIlIllllllllll : llllllllllllIIIIIIIIlIlllllllIIl) {
            try {
                final LanguageMetadataSection llllllllllllIIIIIIIIlIlllllllllI = llllllllllllIIIIIIIIlIllllllllll.getPackMetadata(this.theMetadataSerializer, "language");
                if (llllllllllllIIIIIIIIlIlllllllllI == null) {
                    continue;
                }
                for (final Language llllllllllllIIIIIIIIlIllllllllIl : llllllllllllIIIIIIIIlIlllllllllI.getLanguages()) {
                    if (!this.languageMap.containsKey(llllllllllllIIIIIIIIlIllllllllIl.getLanguageCode())) {
                        this.languageMap.put(llllllllllllIIIIIIIIlIllllllllIl.getLanguageCode(), llllllllllllIIIIIIIIlIllllllllIl);
                    }
                }
            }
            catch (RuntimeException llllllllllllIIIIIIIIlIllllllllII) {
                LanguageManager.LOGGER.warn("Unable to parse language metadata section of resourcepack: {}", (Object)llllllllllllIIIIIIIIlIllllllllll.getPackName(), (Object)llllllllllllIIIIIIIIlIllllllllII);
            }
            catch (IOException llllllllllllIIIIIIIIlIlllllllIll) {
                LanguageManager.LOGGER.warn("Unable to parse language metadata section of resourcepack: {}", (Object)llllllllllllIIIIIIIIlIllllllllll.getPackName(), (Object)llllllllllllIIIIIIIIlIlllllllIll);
            }
        }
    }
    
    @Override
    public void onResourceManagerReload(final IResourceManager llllllllllllIIIIIIIIlIlllllIllll) {
        final List<String> llllllllllllIIIIIIIIlIlllllIlllI = (List<String>)Lists.newArrayList((Object[])new String[] { "en_us" });
        if (!"en_us".equals(this.currentLanguage)) {
            llllllllllllIIIIIIIIlIlllllIlllI.add(this.currentLanguage);
        }
        LanguageManager.CURRENT_LOCALE.loadLocaleDataFiles(llllllllllllIIIIIIIIlIlllllIllll, llllllllllllIIIIIIIIlIlllllIlllI);
        LanguageMap.replaceWith(LanguageManager.CURRENT_LOCALE.properties);
    }
    
    public Language func_191960_a(final String llllllllllllIIIIIIIIlIllllIlIIlI) {
        return this.languageMap.get(llllllllllllIIIIIIIIlIllllIlIIlI);
    }
    
    public boolean isCurrentLanguageBidirectional() {
        return this.getCurrentLanguage() != null && this.getCurrentLanguage().isBidirectional();
    }
    
    static {
        LOGGER = LogManager.getLogger();
        CURRENT_LOCALE = new Locale();
    }
    
    public boolean isCurrentLocaleUnicode() {
        return LanguageManager.CURRENT_LOCALE.isUnicode();
    }
}
