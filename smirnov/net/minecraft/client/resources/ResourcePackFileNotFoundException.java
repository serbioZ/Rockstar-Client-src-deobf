// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.resources;

import java.io.File;
import java.io.FileNotFoundException;

public class ResourcePackFileNotFoundException extends FileNotFoundException
{
    public ResourcePackFileNotFoundException(final File llllllllllllIlIIIlIIlIlIIlIlIIll, final String llllllllllllIlIIIlIIlIlIIlIlIlIl) {
        super(String.format("'%s' in ResourcePack '%s'", llllllllllllIlIIIlIIlIlIIlIlIlIl, llllllllllllIlIIIlIIlIlIIlIlIIll));
    }
}
