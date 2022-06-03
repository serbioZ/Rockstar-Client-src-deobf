// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.advancements;

import com.google.gson.TypeAdapterFactory;
import net.minecraft.util.EnumTypeAdapterFactory;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.ITextComponent;
import com.google.gson.JsonObject;
import com.google.gson.JsonDeserializationContext;
import java.lang.reflect.Type;
import com.google.gson.JsonElement;
import com.google.gson.JsonDeserializer;
import com.google.gson.GsonBuilder;
import org.apache.logging.log4j.LogManager;
import java.nio.charset.StandardCharsets;
import org.apache.commons.io.FileUtils;
import com.google.common.collect.Maps;
import java.io.BufferedReader;
import java.util.Iterator;
import java.net.URI;
import java.net.URL;
import java.nio.file.FileSystem;
import java.io.Closeable;
import java.net.URISyntaxException;
import org.apache.commons.io.IOUtils;
import java.io.IOException;
import com.google.gson.JsonParseException;
import java.io.Reader;
import net.minecraft.util.JsonUtils;
import org.apache.commons.io.FilenameUtils;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.FileVisitOption;
import java.nio.file.FileSystems;
import java.util.Collections;
import java.nio.file.Paths;
import net.minecraft.item.crafting.CraftingManager;
import javax.annotation.Nullable;
import net.minecraft.util.ResourceLocation;
import java.util.Map;
import com.google.gson.Gson;
import java.io.File;
import org.apache.logging.log4j.Logger;

public class AdvancementManager
{
    private static final /* synthetic */ Logger field_192782_a;
    private final /* synthetic */ File field_192785_d;
    private static final /* synthetic */ AdvancementList field_192784_c;
    private /* synthetic */ boolean field_193768_e;
    private static final /* synthetic */ Gson field_192783_b;
    
    public void func_192779_a() {
        this.field_193768_e = false;
        AdvancementManager.field_192784_c.func_192087_a();
        final Map<ResourceLocation, Advancement.Builder> lllllllllllIIllIlllIllllIIlIIIIl = this.func_192781_c();
        this.func_192777_a(lllllllllllIIllIlllIllllIIlIIIIl);
        AdvancementManager.field_192784_c.func_192083_a(lllllllllllIIllIlllIllllIIlIIIIl);
        for (final Advancement lllllllllllIIllIlllIllllIIlIIIII : AdvancementManager.field_192784_c.func_192088_b()) {
            if (lllllllllllIIllIlllIllllIIlIIIII.func_192068_c() != null) {
                AdvancementTreeNode.func_192323_a(lllllllllllIIllIlllIllllIIlIIIII);
            }
        }
    }
    
    @Nullable
    public Advancement func_192778_a(final ResourceLocation lllllllllllIIllIlllIlllIllIIllIl) {
        return AdvancementManager.field_192784_c.func_192084_a(lllllllllllIIllIlllIlllIllIIllIl);
    }
    
    private void func_192777_a(final Map<ResourceLocation, Advancement.Builder> lllllllllllIIllIlllIlllIllIllllI) {
        FileSystem lllllllllllIIllIlllIlllIlllIlllI = null;
        try {
            final URL lllllllllllIIllIlllIlllIlllIllIl = AdvancementManager.class.getResource("/assets/.mcassetsroot");
            if (lllllllllllIIllIlllIlllIlllIllIl != null) {
                final URI lllllllllllIIllIlllIlllIlllIllII = lllllllllllIIllIlllIlllIlllIllIl.toURI();
                Path lllllllllllIIllIlllIlllIlllIlIlI = null;
                if ("file".equals(lllllllllllIIllIlllIlllIlllIllII.getScheme())) {
                    final Path lllllllllllIIllIlllIlllIlllIlIll = Paths.get(CraftingManager.class.getResource("/assets/minecraft/advancements").toURI());
                }
                else {
                    if (!"jar".equals(lllllllllllIIllIlllIlllIlllIllII.getScheme())) {
                        AdvancementManager.field_192782_a.error("Unsupported scheme " + lllllllllllIIllIlllIlllIlllIllII + " trying to list all built-in advancements (NYI?)");
                        this.field_193768_e = true;
                        return;
                    }
                    lllllllllllIIllIlllIlllIlllIlllI = FileSystems.newFileSystem(lllllllllllIIllIlllIlllIlllIllII, Collections.emptyMap());
                    lllllllllllIIllIlllIlllIlllIlIlI = lllllllllllIIllIlllIlllIlllIlllI.getPath("/assets/minecraft/advancements", new String[0]);
                }
                for (final Path lllllllllllIIllIlllIlllIlllIlIII : Files.walk(lllllllllllIIllIlllIlllIlllIlIlI, new FileVisitOption[0])) {
                    if ("json".equals(FilenameUtils.getExtension(lllllllllllIIllIlllIlllIlllIlIII.toString()))) {
                        final Path lllllllllllIIllIlllIlllIlllIIlll = lllllllllllIIllIlllIlllIlllIlIlI.relativize(lllllllllllIIllIlllIlllIlllIlIII);
                        final String lllllllllllIIllIlllIlllIlllIIllI = FilenameUtils.removeExtension(lllllllllllIIllIlllIlllIlllIIlll.toString()).replaceAll("\\\\", "/");
                        final ResourceLocation lllllllllllIIllIlllIlllIlllIIlIl = new ResourceLocation("minecraft", lllllllllllIIllIlllIlllIlllIIllI);
                        if (lllllllllllIIllIlllIlllIllIllllI.containsKey(lllllllllllIIllIlllIlllIlllIIlIl)) {
                            continue;
                        }
                        BufferedReader lllllllllllIIllIlllIlllIlllIIlII = null;
                        try {
                            lllllllllllIIllIlllIlllIlllIIlII = Files.newBufferedReader(lllllllllllIIllIlllIlllIlllIlIII);
                            final Advancement.Builder lllllllllllIIllIlllIlllIlllIIIll = JsonUtils.func_193839_a(AdvancementManager.field_192783_b, lllllllllllIIllIlllIlllIlllIIlII, Advancement.Builder.class);
                            lllllllllllIIllIlllIlllIllIllllI.put(lllllllllllIIllIlllIlllIlllIIlIl, lllllllllllIIllIlllIlllIlllIIIll);
                        }
                        catch (JsonParseException lllllllllllIIllIlllIlllIlllIIIlI) {
                            AdvancementManager.field_192782_a.error("Parsing error loading built-in advancement " + lllllllllllIIllIlllIlllIlllIIlIl, (Throwable)lllllllllllIIllIlllIlllIlllIIIlI);
                            this.field_193768_e = true;
                        }
                        catch (IOException lllllllllllIIllIlllIlllIlllIIIIl) {
                            AdvancementManager.field_192782_a.error("Couldn't read advancement " + lllllllllllIIllIlllIlllIlllIIlIl + " from " + lllllllllllIIllIlllIlllIlllIlIII, (Throwable)lllllllllllIIllIlllIlllIlllIIIIl);
                            this.field_193768_e = true;
                        }
                        finally {
                            IOUtils.closeQuietly((Reader)lllllllllllIIllIlllIlllIlllIIlII);
                        }
                        IOUtils.closeQuietly((Reader)lllllllllllIIllIlllIlllIlllIIlII);
                    }
                }
                return;
            }
            AdvancementManager.field_192782_a.error("Couldn't find .mcassetsroot");
            this.field_193768_e = true;
        }
        catch (IOException ex) {}
        catch (URISyntaxException lllllllllllIIllIlllIlllIlllIIIII) {
            AdvancementManager.field_192782_a.error("Couldn't get a list of all built-in advancement files", (Throwable)lllllllllllIIllIlllIlllIlllIIIII);
            this.field_193768_e = true;
            return;
        }
        finally {
            IOUtils.closeQuietly((Closeable)lllllllllllIIllIlllIlllIlllIlllI);
        }
        IOUtils.closeQuietly((Closeable)lllllllllllIIllIlllIlllIlllIlllI);
    }
    
    private Map<ResourceLocation, Advancement.Builder> func_192781_c() {
        if (this.field_192785_d == null) {
            return (Map<ResourceLocation, Advancement.Builder>)Maps.newHashMap();
        }
        final Map<ResourceLocation, Advancement.Builder> lllllllllllIIllIlllIllllIIIIllll = (Map<ResourceLocation, Advancement.Builder>)Maps.newHashMap();
        this.field_192785_d.mkdirs();
        for (final File lllllllllllIIllIlllIllllIIIIlllI : FileUtils.listFiles(this.field_192785_d, new String[] { "json" }, true)) {
            final String lllllllllllIIllIlllIllllIIIIllIl = FilenameUtils.removeExtension(this.field_192785_d.toURI().relativize(lllllllllllIIllIlllIllllIIIIlllI.toURI()).toString());
            final String[] lllllllllllIIllIlllIllllIIIIllII = lllllllllllIIllIlllIllllIIIIllIl.split("/", 2);
            if (lllllllllllIIllIlllIllllIIIIllII.length == 2) {
                final ResourceLocation lllllllllllIIllIlllIllllIIIIlIll = new ResourceLocation(lllllllllllIIllIlllIllllIIIIllII[0], lllllllllllIIllIlllIllllIIIIllII[1]);
                try {
                    final Advancement.Builder lllllllllllIIllIlllIllllIIIIlIlI = JsonUtils.gsonDeserialize(AdvancementManager.field_192783_b, FileUtils.readFileToString(lllllllllllIIllIlllIllllIIIIlllI, StandardCharsets.UTF_8), Advancement.Builder.class);
                    if (lllllllllllIIllIlllIllllIIIIlIlI == null) {
                        AdvancementManager.field_192782_a.error("Couldn't load custom advancement " + lllllllllllIIllIlllIllllIIIIlIll + " from " + lllllllllllIIllIlllIllllIIIIlllI + " as it's empty or null");
                    }
                    else {
                        lllllllllllIIllIlllIllllIIIIllll.put(lllllllllllIIllIlllIllllIIIIlIll, lllllllllllIIllIlllIllllIIIIlIlI);
                    }
                }
                catch (IllegalArgumentException | JsonParseException ex2) {
                    final RuntimeException ex;
                    final RuntimeException lllllllllllIIllIlllIllllIIIIlIIl = ex;
                    AdvancementManager.field_192782_a.error("Parsing error loading custom advancement " + lllllllllllIIllIlllIllllIIIIlIll, (Throwable)lllllllllllIIllIlllIllllIIIIlIIl);
                    this.field_193768_e = true;
                }
                catch (IOException lllllllllllIIllIlllIllllIIIIlIII) {
                    AdvancementManager.field_192782_a.error("Couldn't read custom advancement " + lllllllllllIIllIlllIllllIIIIlIll + " from " + lllllllllllIIllIlllIllllIIIIlllI, (Throwable)lllllllllllIIllIlllIllllIIIIlIII);
                    this.field_193768_e = true;
                }
            }
        }
        return lllllllllllIIllIlllIllllIIIIllll;
    }
    
    public boolean func_193767_b() {
        return this.field_193768_e;
    }
    
    public AdvancementManager(@Nullable final File lllllllllllIIllIlllIllllIIlIIlll) {
        this.field_192785_d = lllllllllllIIllIlllIllllIIlIIlll;
        this.func_192779_a();
    }
    
    static {
        field_192782_a = LogManager.getLogger();
        field_192783_b = new GsonBuilder().registerTypeHierarchyAdapter((Class)Advancement.Builder.class, (Object)new JsonDeserializer<Advancement.Builder>() {
            public Advancement.Builder deserialize(final JsonElement lllllllllllIllIIllIIIIIllIIllIIl, final Type lllllllllllIllIIllIIIIIllIIlllII, final JsonDeserializationContext lllllllllllIllIIllIIIIIllIIllIII) throws JsonParseException {
                final JsonObject lllllllllllIllIIllIIIIIllIIllIlI = JsonUtils.getJsonObject(lllllllllllIllIIllIIIIIllIIllIIl, "advancement");
                return Advancement.Builder.func_192059_a(lllllllllllIllIIllIIIIIllIIllIlI, lllllllllllIllIIllIIIIIllIIllIII);
            }
        }).registerTypeAdapter((Type)AdvancementRewards.class, (Object)new AdvancementRewards.Deserializer()).registerTypeHierarchyAdapter((Class)ITextComponent.class, (Object)new ITextComponent.Serializer()).registerTypeHierarchyAdapter((Class)Style.class, (Object)new Style.Serializer()).registerTypeAdapterFactory((TypeAdapterFactory)new EnumTypeAdapterFactory()).create();
        field_192784_c = new AdvancementList();
    }
    
    public Iterable<Advancement> func_192780_b() {
        return AdvancementManager.field_192784_c.func_192089_c();
    }
}
