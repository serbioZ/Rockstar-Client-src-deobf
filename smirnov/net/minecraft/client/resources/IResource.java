// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.resources;

import net.minecraft.util.ResourceLocation;
import javax.annotation.Nullable;
import net.minecraft.client.resources.data.IMetadataSection;
import java.io.InputStream;
import java.io.Closeable;

public interface IResource extends Closeable
{
    boolean hasMetadata();
    
    InputStream getInputStream();
    
    @Nullable
     <T extends IMetadataSection> T getMetadata(final String p0);
    
    ResourceLocation getResourceLocation();
    
    String getResourcePackName();
}
