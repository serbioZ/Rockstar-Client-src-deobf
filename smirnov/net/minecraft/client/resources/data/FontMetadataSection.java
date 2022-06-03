// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.resources.data;

public class FontMetadataSection implements IMetadataSection
{
    private final /* synthetic */ float[] charSpacings;
    private final /* synthetic */ float[] charLefts;
    private final /* synthetic */ float[] charWidths;
    
    public FontMetadataSection(final float[] lllllllllllIllllIIllllllIIIIIlII, final float[] lllllllllllIllllIIllllllIIIIIIll, final float[] lllllllllllIllllIIllllllIIIIIllI) {
        this.charWidths = lllllllllllIllllIIllllllIIIIIlII;
        this.charLefts = lllllllllllIllllIIllllllIIIIIIll;
        this.charSpacings = lllllllllllIllllIIllllllIIIIIllI;
    }
}
