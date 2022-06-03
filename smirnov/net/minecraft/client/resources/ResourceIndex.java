// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.resources;

import javax.annotation.Nullable;
import java.io.BufferedReader;
import org.apache.commons.io.IOUtils;
import java.io.FileNotFoundException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.util.JsonUtils;
import java.io.Reader;
import com.google.gson.JsonParser;
import com.google.common.io.Files;
import java.nio.charset.StandardCharsets;
import org.apache.logging.log4j.LogManager;
import net.minecraft.util.ResourceLocation;
import com.google.common.collect.Maps;
import org.apache.logging.log4j.Logger;
import java.io.File;
import java.util.Map;

public class ResourceIndex
{
    private final /* synthetic */ Map<String, File> resourceMap;
    private static final /* synthetic */ Logger LOGGER;
    
    protected ResourceIndex() {
        this.resourceMap = (Map<String, File>)Maps.newHashMap();
    }
    
    public boolean isFileExisting(final ResourceLocation lllllllllllllIllllllIIIIllllIlll) {
        final File lllllllllllllIllllllIIIIllllIllI = this.getFile(lllllllllllllIllllllIIIIllllIlll);
        return lllllllllllllIllllllIIIIllllIllI != null && lllllllllllllIllllllIIIIllllIllI.isFile();
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    public ResourceIndex(final File lllllllllllllIllllllIIIlIIlIIlIl, final String lllllllllllllIllllllIIIlIIIlIIll) {
        this.resourceMap = (Map<String, File>)Maps.newHashMap();
        final File lllllllllllllIllllllIIIlIIlIIIll = new File(lllllllllllllIllllllIIIlIIlIIlIl, "objects");
        final File lllllllllllllIllllllIIIlIIlIIIlI = new File(lllllllllllllIllllllIIIlIIlIIlIl, "indexes/" + lllllllllllllIllllllIIIlIIIlIIll + ".json");
        BufferedReader lllllllllllllIllllllIIIlIIlIIIIl = null;
        try {
            lllllllllllllIllllllIIIlIIlIIIIl = Files.newReader(lllllllllllllIllllllIIIlIIlIIIlI, StandardCharsets.UTF_8);
            final JsonObject lllllllllllllIllllllIIIlIIlIIIII = new JsonParser().parse((Reader)lllllllllllllIllllllIIIlIIlIIIIl).getAsJsonObject();
            final JsonObject lllllllllllllIllllllIIIlIIIlllll = JsonUtils.getJsonObject(lllllllllllllIllllllIIIlIIlIIIII, "objects", null);
            if (lllllllllllllIllllllIIIlIIIlllll != null) {
                for (final Map.Entry<String, JsonElement> lllllllllllllIllllllIIIlIIIllllI : lllllllllllllIllllllIIIlIIIlllll.entrySet()) {
                    final JsonObject lllllllllllllIllllllIIIlIIIlllIl = (JsonObject)lllllllllllllIllllllIIIlIIIllllI.getValue();
                    final String lllllllllllllIllllllIIIlIIIlllII = lllllllllllllIllllllIIIlIIIllllI.getKey();
                    final String[] lllllllllllllIllllllIIIlIIIllIll = lllllllllllllIllllllIIIlIIIlllII.split("/", 2);
                    final String lllllllllllllIllllllIIIlIIIllIlI = (lllllllllllllIllllllIIIlIIIllIll.length == 1) ? lllllllllllllIllllllIIIlIIIllIll[0] : (String.valueOf(lllllllllllllIllllllIIIlIIIllIll[0]) + ":" + lllllllllllllIllllllIIIlIIIllIll[1]);
                    final String lllllllllllllIllllllIIIlIIIllIIl = JsonUtils.getString(lllllllllllllIllllllIIIlIIIlllIl, "hash");
                    final File lllllllllllllIllllllIIIlIIIllIII = new File(lllllllllllllIllllllIIIlIIlIIIll, String.valueOf(lllllllllllllIllllllIIIlIIIllIIl.substring(0, 2)) + "/" + lllllllllllllIllllllIIIlIIIllIIl);
                    this.resourceMap.put(lllllllllllllIllllllIIIlIIIllIlI, lllllllllllllIllllllIIIlIIIllIII);
                }
            }
        }
        catch (JsonParseException lllllllllllllIllllllIIIlIIIlIlll) {
            ResourceIndex.LOGGER.error("Unable to parse resource index file: {}", (Object)lllllllllllllIllllllIIIlIIlIIIlI);
        }
        catch (FileNotFoundException lllllllllllllIllllllIIIlIIIlIllI) {
            ResourceIndex.LOGGER.error("Can't find the resource index file: {}", (Object)lllllllllllllIllllllIIIlIIlIIIlI);
        }
        finally {
            IOUtils.closeQuietly((Reader)lllllllllllllIllllllIIIlIIlIIIIl);
        }
        IOUtils.closeQuietly((Reader)lllllllllllllIllllllIIIlIIlIIIIl);
    }
    
    public File getPackMcmeta() {
        return this.resourceMap.get("pack.mcmeta");
    }
    
    @Nullable
    public File getFile(final ResourceLocation lllllllllllllIllllllIIIlIIIIIIII) {
        final String lllllllllllllIllllllIIIIllllllll = lllllllllllllIllllllIIIlIIIIIIII.toString();
        return this.resourceMap.get(lllllllllllllIllllllIIIIllllllll);
    }
}
