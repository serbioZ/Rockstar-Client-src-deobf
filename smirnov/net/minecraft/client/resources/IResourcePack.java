// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.resources;

import java.util.Set;
import java.io.InputStream;
import java.awt.image.BufferedImage;
import net.minecraft.util.ResourceLocation;
import javax.annotation.Nullable;
import java.io.IOException;
import net.minecraft.client.resources.data.IMetadataSection;
import net.minecraft.client.resources.data.MetadataSerializer;

public interface IResourcePack
{
    @Nullable
     <T extends IMetadataSection> T getPackMetadata(final MetadataSerializer p0, final String p1) throws IOException;
    
    boolean resourceExists(final ResourceLocation p0);
    
    BufferedImage getPackImage() throws IOException;
    
    String getPackName();
    
    InputStream getInputStream(final ResourceLocation p0) throws IOException;
    
    Set<String> getResourceDomains();
}
