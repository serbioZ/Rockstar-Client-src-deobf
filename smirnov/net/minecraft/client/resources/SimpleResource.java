// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.resources;

import com.google.common.collect.Maps;
import java.io.IOException;
import javax.annotation.Nullable;
import org.apache.commons.io.IOUtils;
import com.google.gson.JsonParser;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import net.minecraft.client.resources.data.MetadataSerializer;
import net.minecraft.util.ResourceLocation;
import com.google.gson.JsonObject;
import net.minecraft.client.resources.data.IMetadataSection;
import java.util.Map;
import java.io.InputStream;

public class SimpleResource implements IResource
{
    private final /* synthetic */ InputStream resourceInputStream;
    private /* synthetic */ boolean mcmetaJsonChecked;
    private final /* synthetic */ Map<String, IMetadataSection> mapMetadataSections;
    private /* synthetic */ JsonObject mcmetaJson;
    private final /* synthetic */ ResourceLocation srResourceLocation;
    private final /* synthetic */ MetadataSerializer srMetadataSerializer;
    private final /* synthetic */ InputStream mcmetaInputStream;
    private final /* synthetic */ String resourcePackName;
    
    @Nullable
    @Override
    public <T extends IMetadataSection> T getMetadata(final String llllllllllIlllIllIlIIIIIIlllIllI) {
        if (!this.hasMetadata()) {
            return null;
        }
        if (this.mcmetaJson == null && !this.mcmetaJsonChecked) {
            this.mcmetaJsonChecked = true;
            BufferedReader llllllllllIlllIllIlIIIIIIlllIlIl = null;
            try {
                llllllllllIlllIllIlIIIIIIlllIlIl = new BufferedReader(new InputStreamReader(this.mcmetaInputStream, StandardCharsets.UTF_8));
                this.mcmetaJson = new JsonParser().parse((Reader)llllllllllIlllIllIlIIIIIIlllIlIl).getAsJsonObject();
            }
            finally {
                IOUtils.closeQuietly((Reader)llllllllllIlllIllIlIIIIIIlllIlIl);
            }
            IOUtils.closeQuietly((Reader)llllllllllIlllIllIlIIIIIIlllIlIl);
        }
        T llllllllllIlllIllIlIIIIIIlllIlII = (T)this.mapMetadataSections.get(llllllllllIlllIllIlIIIIIIlllIllI);
        if (llllllllllIlllIllIlIIIIIIlllIlII == null) {
            llllllllllIlllIllIlIIIIIIlllIlII = this.srMetadataSerializer.parseMetadataSection(llllllllllIlllIllIlIIIIIIlllIllI, this.mcmetaJson);
        }
        return llllllllllIlllIllIlIIIIIIlllIlII;
    }
    
    @Override
    public boolean hasMetadata() {
        return this.mcmetaInputStream != null;
    }
    
    @Override
    public int hashCode() {
        int llllllllllIlllIllIlIIIIIIllIIIII = (this.resourcePackName != null) ? this.resourcePackName.hashCode() : 0;
        llllllllllIlllIllIlIIIIIIllIIIII = 31 * llllllllllIlllIllIlIIIIIIllIIIII + ((this.srResourceLocation != null) ? this.srResourceLocation.hashCode() : 0);
        return llllllllllIlllIllIlIIIIIIllIIIII;
    }
    
    @Override
    public boolean equals(final Object llllllllllIlllIllIlIIIIIIllIlIII) {
        if (this == llllllllllIlllIllIlIIIIIIllIlIII) {
            return true;
        }
        if (!(llllllllllIlllIllIlIIIIIIllIlIII instanceof SimpleResource)) {
            return false;
        }
        final SimpleResource llllllllllIlllIllIlIIIIIIllIIlll = (SimpleResource)llllllllllIlllIllIlIIIIIIllIlIII;
        if (this.srResourceLocation != null) {
            if (!this.srResourceLocation.equals(llllllllllIlllIllIlIIIIIIllIIlll.srResourceLocation)) {
                return false;
            }
        }
        else if (llllllllllIlllIllIlIIIIIIllIIlll.srResourceLocation != null) {
            return false;
        }
        if (this.resourcePackName != null) {
            if (!this.resourcePackName.equals(llllllllllIlllIllIlIIIIIIllIIlll.resourcePackName)) {
                return false;
            }
        }
        else if (llllllllllIlllIllIlIIIIIIllIIlll.resourcePackName != null) {
            return false;
        }
        return true;
    }
    
    @Override
    public void close() throws IOException {
        this.resourceInputStream.close();
        if (this.mcmetaInputStream != null) {
            this.mcmetaInputStream.close();
        }
    }
    
    public SimpleResource(final String llllllllllIlllIllIlIIIIIlIIIllll, final ResourceLocation llllllllllIlllIllIlIIIIIlIIIlIII, final InputStream llllllllllIlllIllIlIIIIIlIIIIlll, final InputStream llllllllllIlllIllIlIIIIIlIIIllII, final MetadataSerializer llllllllllIlllIllIlIIIIIlIIIIlIl) {
        this.mapMetadataSections = (Map<String, IMetadataSection>)Maps.newHashMap();
        this.resourcePackName = llllllllllIlllIllIlIIIIIlIIIllll;
        this.srResourceLocation = llllllllllIlllIllIlIIIIIlIIIlIII;
        this.resourceInputStream = llllllllllIlllIllIlIIIIIlIIIIlll;
        this.mcmetaInputStream = llllllllllIlllIllIlIIIIIlIIIllII;
        this.srMetadataSerializer = llllllllllIlllIllIlIIIIIlIIIIlIl;
    }
    
    @Override
    public InputStream getInputStream() {
        return this.resourceInputStream;
    }
    
    @Override
    public ResourceLocation getResourceLocation() {
        return this.srResourceLocation;
    }
    
    @Override
    public String getResourcePackName() {
        return this.resourcePackName;
    }
}
