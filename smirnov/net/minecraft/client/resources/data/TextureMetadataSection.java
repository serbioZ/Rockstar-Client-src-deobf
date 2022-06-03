// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.resources.data;

public class TextureMetadataSection implements IMetadataSection
{
    private final /* synthetic */ boolean textureClamp;
    private final /* synthetic */ boolean textureBlur;
    
    public TextureMetadataSection(final boolean lllllllllllIIIIIllIlIlIIIlIlllII, final boolean lllllllllllIIIIIllIlIlIIIlIllIll) {
        this.textureBlur = lllllllllllIIIIIllIlIlIIIlIlllII;
        this.textureClamp = lllllllllllIIIIIllIlIlIIIlIllIll;
    }
    
    public boolean getTextureBlur() {
        return this.textureBlur;
    }
    
    public boolean getTextureClamp() {
        return this.textureClamp;
    }
}
