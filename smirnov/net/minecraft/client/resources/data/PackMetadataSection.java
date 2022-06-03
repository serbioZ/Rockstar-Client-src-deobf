// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.resources.data;

import net.minecraft.util.text.ITextComponent;

public class PackMetadataSection implements IMetadataSection
{
    private final /* synthetic */ ITextComponent packDescription;
    private final /* synthetic */ int packFormat;
    
    public ITextComponent getPackDescription() {
        return this.packDescription;
    }
    
    public int getPackFormat() {
        return this.packFormat;
    }
    
    public PackMetadataSection(final ITextComponent llllllllllIlllIIIlIIlIlIIlIIlIll, final int llllllllllIlllIIIlIIlIlIIlIIllIl) {
        this.packDescription = llllllllllIlllIIIlIIlIlIIlIIlIll;
        this.packFormat = llllllllllIlllIIIlIIlIlIIlIIllIl;
    }
}
