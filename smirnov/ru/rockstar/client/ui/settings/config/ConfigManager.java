// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.settings.config;

import ru.rockstar.Main;
import java.io.IOException;
import java.io.FileWriter;
import com.google.gson.JsonElement;
import com.google.gson.GsonBuilder;
import java.io.FileNotFoundException;
import java.io.Reader;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileReader;
import org.apache.commons.io.FilenameUtils;
import java.util.ArrayList;
import java.io.File;

public final class ConfigManager extends Manager<Config>
{
    public static final /* synthetic */ File configDirectory;
    private static final /* synthetic */ ArrayList<Config> loadedConfigs;
    
    public ConfigManager() {
        this.setContents(loadConfigs());
        ConfigManager.configDirectory.mkdirs();
    }
    
    public void load() {
        if (!ConfigManager.configDirectory.exists()) {
            ConfigManager.configDirectory.mkdirs();
        }
        if (ConfigManager.configDirectory != null) {
            final File[] lllllllllllllIIIlIIIIllllIlIIIIl = ConfigManager.configDirectory.listFiles(lllllllllllllIIIlIIIIlllIlIlllII -> !lllllllllllllIIIlIIIIlllIlIlllII.isDirectory() && FilenameUtils.getExtension(lllllllllllllIIIlIIIIlllIlIlllII.getName()).equals("json"));
            final int lllllllllllllIIIlIIIIllllIIllIlI;
            final float lllllllllllllIIIlIIIIllllIIllIll = ((File[])(Object)(lllllllllllllIIIlIIIIllllIIllIlI = (int)(Object)lllllllllllllIIIlIIIIllllIlIIIIl)).length;
            for (byte lllllllllllllIIIlIIIIllllIIlllII = 0; lllllllllllllIIIlIIIIllllIIlllII < lllllllllllllIIIlIIIIllllIIllIll; ++lllllllllllllIIIlIIIIllllIIlllII) {
                final File lllllllllllllIIIlIIIIllllIlIIIII = lllllllllllllIIIlIIIIllllIIllIlI[lllllllllllllIIIlIIIIllllIIlllII];
                final Config lllllllllllllIIIlIIIIllllIIlllll = new Config(FilenameUtils.removeExtension(lllllllllllllIIIlIIIIllllIlIIIII.getName()).replace(" ", ""));
                ConfigManager.loadedConfigs.add(lllllllllllllIIIlIIIIllllIIlllll);
            }
        }
    }
    
    public boolean loadConfig(final String lllllllllllllIIIlIIIIllllIIIlIlI) {
        if (lllllllllllllIIIlIIIIllllIIIlIlI == null) {
            return false;
        }
        final Config lllllllllllllIIIlIIIIllllIIlIIII = this.findConfig(lllllllllllllIIIlIIIIllllIIIlIlI);
        if (lllllllllllllIIIlIIIIllllIIlIIII == null) {
            return false;
        }
        try {
            final FileReader lllllllllllllIIIlIIIIllllIIIllll = new FileReader(lllllllllllllIIIlIIIIllllIIlIIII.getFile());
            final JsonParser lllllllllllllIIIlIIIIllllIIIlllI = new JsonParser();
            final JsonObject lllllllllllllIIIlIIIIllllIIIllIl = (JsonObject)lllllllllllllIIIlIIIIllllIIIlllI.parse((Reader)lllllllllllllIIIlIIIIllllIIIllll);
            lllllllllllllIIIlIIIIllllIIlIIII.load(lllllllllllllIIIlIIIIllllIIIllIl);
            return true;
        }
        catch (FileNotFoundException lllllllllllllIIIlIIIIllllIIIllII) {
            return false;
        }
    }
    
    public boolean saveConfig(final String lllllllllllllIIIlIIIIlllIlllllll) {
        if (lllllllllllllIIIlIIIIlllIlllllll == null) {
            return false;
        }
        Config lllllllllllllIIIlIIIIlllIllllllI;
        if ((lllllllllllllIIIlIIIIlllIllllllI = this.findConfig(lllllllllllllIIIlIIIIlllIlllllll)) == null) {
            final Config lllllllllllllIIIlIIIIlllIlllllIl;
            lllllllllllllIIIlIIIIlllIllllllI = (lllllllllllllIIIlIIIIlllIlllllIl = new Config(lllllllllllllIIIlIIIIlllIlllllll));
            this.getContents().add(lllllllllllllIIIlIIIIlllIlllllIl);
        }
        final String lllllllllllllIIIlIIIIlllIlllllII = new GsonBuilder().setPrettyPrinting().create().toJson((JsonElement)lllllllllllllIIIlIIIIlllIllllllI.save());
        try {
            final FileWriter lllllllllllllIIIlIIIIlllIllllIll = new FileWriter(lllllllllllllIIIlIIIIlllIllllllI.getFile());
            lllllllllllllIIIlIIIIlllIllllIll.write(lllllllllllllIIIlIIIIlllIlllllII);
            lllllllllllllIIIlIIIIlllIllllIll.close();
            return true;
        }
        catch (IOException lllllllllllllIIIlIIIIlllIllllIlI) {
            return false;
        }
    }
    
    private static ArrayList<Config> loadConfigs() {
        final File[] lllllllllllllIIIlIIIIllllIlIllll = ConfigManager.configDirectory.listFiles();
        if (lllllllllllllIIIlIIIIllllIlIllll != null) {
            final boolean lllllllllllllIIIlIIIIllllIlIlIIl;
            final String lllllllllllllIIIlIIIIllllIlIlIlI = (String)((File[])(Object)(lllllllllllllIIIlIIIIllllIlIlIIl = (boolean)(Object)lllllllllllllIIIlIIIIllllIlIllll)).length;
            for (float lllllllllllllIIIlIIIIllllIlIlIll = 0; lllllllllllllIIIlIIIIllllIlIlIll < lllllllllllllIIIlIIIIllllIlIlIlI; ++lllllllllllllIIIlIIIIllllIlIlIll) {
                final File lllllllllllllIIIlIIIIllllIlIlllI = lllllllllllllIIIlIIIIllllIlIlIIl[lllllllllllllIIIlIIIIllllIlIlIll];
                if (FilenameUtils.getExtension(lllllllllllllIIIlIIIIllllIlIlllI.getName()).equals("json")) {
                    ConfigManager.loadedConfigs.add(new Config(FilenameUtils.removeExtension(lllllllllllllIIIlIIIIllllIlIlllI.getName())));
                }
            }
        }
        return ConfigManager.loadedConfigs;
    }
    
    public static ArrayList<Config> getLoadedConfigs() {
        return ConfigManager.loadedConfigs;
    }
    
    static {
        configDirectory = new File(Main.instance.name, "configs");
        loadedConfigs = new ArrayList<Config>();
    }
    
    public Config findConfig(final String lllllllllllllIIIlIIIIlllIllIllII) {
        if (lllllllllllllIIIlIIIIlllIllIllII == null) {
            return null;
        }
        for (final Config lllllllllllllIIIlIIIIlllIllIlllI : this.getContents()) {
            if (lllllllllllllIIIlIIIIlllIllIlllI.getName().equalsIgnoreCase(lllllllllllllIIIlIIIIlllIllIllII)) {
                return lllllllllllllIIIlIIIIlllIllIlllI;
            }
        }
        if (new File(ConfigManager.configDirectory, String.valueOf(lllllllllllllIIIlIIIIlllIllIllII) + ".json").exists()) {
            return new Config(lllllllllllllIIIlIIIIlllIllIllII);
        }
        return null;
    }
    
    public boolean deleteConfig(final String lllllllllllllIIIlIIIIlllIllIIlII) {
        if (lllllllllllllIIIlIIIIlllIllIIlII == null) {
            return false;
        }
        final Config lllllllllllllIIIlIIIIlllIllIIIll;
        if ((lllllllllllllIIIlIIIIlllIllIIIll = this.findConfig(lllllllllllllIIIlIIIIlllIllIIlII)) != null) {
            final File lllllllllllllIIIlIIIIlllIllIIIlI = lllllllllllllIIIlIIIIlllIllIIIll.getFile();
            this.getContents().remove(lllllllllllllIIIlIIIIlllIllIIIll);
            return lllllllllllllIIIlIIIIlllIllIIIlI.exists() && lllllllllllllIIIlIIIIlllIllIIIlI.delete();
        }
        return false;
    }
}
