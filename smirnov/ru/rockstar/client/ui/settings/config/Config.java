// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.settings.config;

import com.google.gson.JsonElement;
import ru.rockstar.client.features.Feature;
import ru.rockstar.Main;
import com.google.gson.JsonObject;
import java.io.File;

public final class Config implements ConfigUpdater
{
    private final /* synthetic */ String name;
    private final /* synthetic */ File file;
    
    public File getFile() {
        return this.file;
    }
    
    @Override
    public void load(final JsonObject lllllllllllllIllIlIIIlIlllIllIIl) {
        if (lllllllllllllIllIlIIIlIlllIllIIl.has("Features")) {
            final JsonObject lllllllllllllIllIlIIIlIlllIllIll = lllllllllllllIllIlIIIlIlllIllIIl.getAsJsonObject("Features");
            for (final Feature lllllllllllllIllIlIIIlIlllIllIlI : Main.featureDirector.getFeatureList()) {
                lllllllllllllIllIlIIIlIlllIllIlI.setEnabled(false);
                lllllllllllllIllIlIIIlIlllIllIlI.load(lllllllllllllIllIlIIIlIlllIllIll.getAsJsonObject(lllllllllllllIllIlIIIlIlllIllIlI.getLabel()));
            }
        }
    }
    
    public Config(final String lllllllllllllIllIlIIIlIllllllIII) {
        this.name = lllllllllllllIllIlIIIlIllllllIII;
        this.file = new File(ConfigManager.configDirectory, String.valueOf(lllllllllllllIllIlIIIlIllllllIII) + ".json");
        if (!this.file.exists()) {
            try {
                this.file.createNewFile();
            }
            catch (Exception ex) {}
        }
    }
    
    @Override
    public JsonObject save() {
        final JsonObject lllllllllllllIllIlIIIlIllllIlIlI = new JsonObject();
        final JsonObject lllllllllllllIllIlIIIlIllllIlIIl = new JsonObject();
        final JsonObject lllllllllllllIllIlIIIlIllllIlIII = new JsonObject();
        for (final Feature lllllllllllllIllIlIIIlIllllIIlll : Main.featureDirector.getFeatureList()) {
            lllllllllllllIllIlIIIlIllllIlIIl.add(lllllllllllllIllIlIIIlIllllIIlll.getLabel(), (JsonElement)lllllllllllllIllIlIIIlIllllIIlll.save());
        }
        lllllllllllllIllIlIIIlIllllIlIlI.add("Features", (JsonElement)lllllllllllllIllIlIIIlIllllIlIIl);
        return lllllllllllllIllIlIIIlIllllIlIlI;
    }
    
    public String getName() {
        return this.name;
    }
}
