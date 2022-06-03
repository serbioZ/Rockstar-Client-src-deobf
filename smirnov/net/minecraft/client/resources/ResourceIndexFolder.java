// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.resources;

import net.minecraft.util.ResourceLocation;
import java.io.File;

public class ResourceIndexFolder extends ResourceIndex
{
    private final /* synthetic */ File baseDir;
    
    @Override
    public File getFile(final ResourceLocation llllllllllllIlIllIIIllIlllIIlIIl) {
        return new File(this.baseDir, llllllllllllIlIllIIIllIlllIIlIIl.toString().replace(':', '/'));
    }
    
    public ResourceIndexFolder(final File llllllllllllIlIllIIIllIlllIIllll) {
        this.baseDir = llllllllllllIlIllIIIllIlllIIllll;
    }
    
    @Override
    public File getPackMcmeta() {
        return new File(this.baseDir, "pack.mcmeta");
    }
}
