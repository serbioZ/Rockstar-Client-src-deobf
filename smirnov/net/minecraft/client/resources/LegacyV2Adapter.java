// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.resources;

import javax.annotation.Nullable;
import net.minecraft.client.resources.data.IMetadataSection;
import net.minecraft.client.resources.data.MetadataSerializer;
import java.awt.image.BufferedImage;
import java.util.Set;
import java.io.IOException;
import java.io.InputStream;
import net.minecraft.util.ResourceLocation;

public class LegacyV2Adapter implements IResourcePack
{
    private final /* synthetic */ IResourcePack field_191383_a;
    
    public LegacyV2Adapter(final IResourcePack lllllllllllllIlllIllIllIIllIIlII) {
        this.field_191383_a = lllllllllllllIlllIllIllIIllIIlII;
    }
    
    @Override
    public InputStream getInputStream(final ResourceLocation lllllllllllllIlllIllIllIIllIIIII) throws IOException {
        return this.field_191383_a.getInputStream(this.func_191382_c(lllllllllllllIlllIllIllIIllIIIII));
    }
    
    @Override
    public boolean resourceExists(final ResourceLocation lllllllllllllIlllIllIllIIlIIlIIl) {
        return this.field_191383_a.resourceExists(this.func_191382_c(lllllllllllllIlllIllIllIIlIIlIIl));
    }
    
    @Override
    public String getPackName() {
        return this.field_191383_a.getPackName();
    }
    
    @Override
    public Set<String> getResourceDomains() {
        return this.field_191383_a.getResourceDomains();
    }
    
    private ResourceLocation func_191382_c(final ResourceLocation lllllllllllllIlllIllIllIIlIlIIlI) {
        final String lllllllllllllIlllIllIllIIlIlIllI = lllllllllllllIlllIllIllIIlIlIIlI.getResourcePath();
        if (!"lang/swg_de.lang".equals(lllllllllllllIlllIllIllIIlIlIllI) && lllllllllllllIlllIllIllIIlIlIllI.startsWith("lang/") && lllllllllllllIlllIllIllIIlIlIllI.endsWith(".lang")) {
            final int lllllllllllllIlllIllIllIIlIlIlIl = lllllllllllllIlllIllIllIIlIlIllI.indexOf(95);
            if (lllllllllllllIlllIllIllIIlIlIlIl != -1) {
                final String lllllllllllllIlllIllIllIIlIlIlII = String.valueOf(lllllllllllllIlllIllIllIIlIlIllI.substring(0, lllllllllllllIlllIllIllIIlIlIlIl + 1)) + lllllllllllllIlllIllIllIIlIlIllI.substring(lllllllllllllIlllIllIllIIlIlIlIl + 1, lllllllllllllIlllIllIllIIlIlIllI.indexOf(46, lllllllllllllIlllIllIllIIlIlIlIl)).toUpperCase() + ".lang";
                return new ResourceLocation(lllllllllllllIlllIllIllIIlIlIIlI.getResourceDomain(), "") {
                    @Override
                    public String getResourcePath() {
                        return lllllllllllllIlllIllIllIIlIlIlII;
                    }
                };
            }
        }
        return lllllllllllllIlllIllIllIIlIlIIlI;
    }
    
    @Override
    public BufferedImage getPackImage() throws IOException {
        return this.field_191383_a.getPackImage();
    }
    
    @Nullable
    @Override
    public <T extends IMetadataSection> T getPackMetadata(final MetadataSerializer lllllllllllllIlllIllIllIIIlllllI, final String lllllllllllllIlllIllIllIIlIIIIII) throws IOException {
        return this.field_191383_a.getPackMetadata(lllllllllllllIlllIllIllIIIlllllI, lllllllllllllIlllIllIllIIlIIIIII);
    }
}
