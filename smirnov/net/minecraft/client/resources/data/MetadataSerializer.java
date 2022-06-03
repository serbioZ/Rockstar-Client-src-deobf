// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.resources.data;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapterFactory;
import net.minecraft.util.EnumTypeAdapterFactory;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.registry.RegistrySimple;
import java.lang.reflect.Type;
import com.google.gson.Gson;
import net.minecraft.util.registry.IRegistry;
import com.google.gson.GsonBuilder;

public class MetadataSerializer
{
    private final /* synthetic */ GsonBuilder gsonBuilder;
    private final /* synthetic */ IRegistry<String, Registration<? extends IMetadataSection>> metadataSectionSerializerRegistry;
    private /* synthetic */ Gson gson;
    
    public <T extends IMetadataSection> void registerMetadataSectionType(final IMetadataSectionSerializer<T> llllllllllIlllIIllIIlllllIIllIII, final Class<T> llllllllllIlllIIllIIlllllIIlIlll) {
        this.metadataSectionSerializerRegistry.putObject(llllllllllIlllIIllIIlllllIIllIII.getSectionName(), new Registration<IMetadataSection>((IMetadataSectionSerializer)llllllllllIlllIIllIIlllllIIllIII, (Class)llllllllllIlllIIllIIlllllIIlIlll, (Registration<IMetadataSection>)null));
        this.gsonBuilder.registerTypeAdapter((Type)llllllllllIlllIIllIIlllllIIlIlll, (Object)llllllllllIlllIIllIIlllllIIllIII);
        this.gson = null;
    }
    
    public MetadataSerializer() {
        this.metadataSectionSerializerRegistry = new RegistrySimple<String, Registration<? extends IMetadataSection>>();
        this.gsonBuilder = new GsonBuilder();
        this.gsonBuilder.registerTypeHierarchyAdapter((Class)ITextComponent.class, (Object)new ITextComponent.Serializer());
        this.gsonBuilder.registerTypeHierarchyAdapter((Class)Style.class, (Object)new Style.Serializer());
        this.gsonBuilder.registerTypeAdapterFactory((TypeAdapterFactory)new EnumTypeAdapterFactory());
    }
    
    private Gson getGson() {
        if (this.gson == null) {
            this.gson = this.gsonBuilder.create();
        }
        return this.gson;
    }
    
    public <T extends IMetadataSection> T parseMetadataSection(final String llllllllllIlllIIllIIlllllIIIlIlI, final JsonObject llllllllllIlllIIllIIlllllIIIlIIl) {
        if (llllllllllIlllIIllIIlllllIIIlIlI == null) {
            throw new IllegalArgumentException("Metadata section name cannot be null");
        }
        if (!llllllllllIlllIIllIIlllllIIIlIIl.has(llllllllllIlllIIllIIlllllIIIlIlI)) {
            return null;
        }
        if (!llllllllllIlllIIllIIlllllIIIlIIl.get(llllllllllIlllIIllIIlllllIIIlIlI).isJsonObject()) {
            throw new IllegalArgumentException("Invalid metadata for '" + llllllllllIlllIIllIIlllllIIIlIlI + "' - expected object, found " + llllllllllIlllIIllIIlllllIIIlIIl.get(llllllllllIlllIIllIIlllllIIIlIlI));
        }
        final Registration<?> llllllllllIlllIIllIIlllllIIIllII = this.metadataSectionSerializerRegistry.getObject(llllllllllIlllIIllIIlllllIIIlIlI);
        if (llllllllllIlllIIllIIlllllIIIllII == null) {
            throw new IllegalArgumentException("Don't know how to handle metadata section '" + llllllllllIlllIIllIIlllllIIIlIlI + "'");
        }
        return (T)this.getGson().fromJson((JsonElement)llllllllllIlllIIllIIlllllIIIlIIl.getAsJsonObject(llllllllllIlllIIllIIlllllIIIlIlI), (Class)llllllllllIlllIIllIIlllllIIIllII.clazz);
    }
    
    class Registration<T extends IMetadataSection>
    {
        final /* synthetic */ Class<T> clazz;
        final /* synthetic */ IMetadataSectionSerializer<T> section;
        
        private Registration(final IMetadataSectionSerializer<T> lllllllllllIlIIIIlIIIlIlIIIIllll, final Class<T> lllllllllllIlIIIIlIIIlIlIIIIlIlI) {
            this.section = lllllllllllIlIIIIlIIIlIlIIIIllll;
            this.clazz = lllllllllllIlIIIIlIIIlIlIIIIlIlI;
        }
    }
}
