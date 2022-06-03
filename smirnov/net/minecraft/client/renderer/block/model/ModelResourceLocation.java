// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.block.model;

import java.util.Locale;
import org.apache.commons.lang3.StringUtils;
import net.minecraft.util.ResourceLocation;

public class ModelResourceLocation extends ResourceLocation
{
    private final /* synthetic */ String variant;
    
    @Override
    public boolean equals(final Object lllllllllllllIlllIIIIlIllIIllIIl) {
        if (this == lllllllllllllIlllIIIIlIllIIllIIl) {
            return true;
        }
        if (lllllllllllllIlllIIIIlIllIIllIIl instanceof ModelResourceLocation && super.equals(lllllllllllllIlllIIIIlIllIIllIIl)) {
            final ModelResourceLocation lllllllllllllIlllIIIIlIllIIllIll = (ModelResourceLocation)lllllllllllllIlllIIIIlIllIIllIIl;
            return this.variant.equals(lllllllllllllIlllIIIIlIllIIllIll.variant);
        }
        return false;
    }
    
    public ModelResourceLocation(final String lllllllllllllIlllIIIIlIllIllIIIl, final String lllllllllllllIlllIIIIlIllIllIIII) {
        this(0, parsePathString(String.valueOf(lllllllllllllIlllIIIIlIllIllIIIl) + '#' + ((lllllllllllllIlllIIIIlIllIllIIII == null) ? "normal" : lllllllllllllIlllIIIIlIllIllIIII)));
    }
    
    protected ModelResourceLocation(final int lllllllllllllIlllIIIIlIlllIIlIll, final String... lllllllllllllIlllIIIIlIlllIIlIlI) {
        super(0, new String[] { lllllllllllllIlllIIIIlIlllIIlIlI[0], lllllllllllllIlllIIIIlIlllIIlIlI[1] });
        this.variant = (StringUtils.isEmpty((CharSequence)lllllllllllllIlllIIIIlIlllIIlIlI[2]) ? "normal" : lllllllllllllIlllIIIIlIlllIIlIlI[2].toLowerCase(Locale.ROOT));
    }
    
    @Override
    public int hashCode() {
        return 31 * super.hashCode() + this.variant.hashCode();
    }
    
    protected static String[] parsePathString(final String lllllllllllllIlllIIIIlIllIlIIlll) {
        final String[] lllllllllllllIlllIIIIlIllIlIlIlI = { null, lllllllllllllIlllIIIIlIllIlIIlll, null };
        final int lllllllllllllIlllIIIIlIllIlIlIIl = lllllllllllllIlllIIIIlIllIlIIlll.indexOf(35);
        String lllllllllllllIlllIIIIlIllIlIlIII = lllllllllllllIlllIIIIlIllIlIIlll;
        if (lllllllllllllIlllIIIIlIllIlIlIIl >= 0) {
            lllllllllllllIlllIIIIlIllIlIlIlI[2] = lllllllllllllIlllIIIIlIllIlIIlll.substring(lllllllllllllIlllIIIIlIllIlIlIIl + 1, lllllllllllllIlllIIIIlIllIlIIlll.length());
            if (lllllllllllllIlllIIIIlIllIlIlIIl > 1) {
                lllllllllllllIlllIIIIlIllIlIlIII = lllllllllllllIlllIIIIlIllIlIIlll.substring(0, lllllllllllllIlllIIIIlIllIlIlIIl);
            }
        }
        System.arraycopy(ResourceLocation.splitObjectName(lllllllllllllIlllIIIIlIllIlIlIII), 0, lllllllllllllIlllIIIIlIllIlIlIlI, 0, 2);
        return lllllllllllllIlllIIIIlIllIlIlIlI;
    }
    
    public ModelResourceLocation(final ResourceLocation lllllllllllllIlllIIIIlIllIllllIl, final String lllllllllllllIlllIIIIlIllIllllII) {
        this(lllllllllllllIlllIIIIlIllIllllIl.toString(), lllllllllllllIlllIIIIlIllIllllII);
    }
    
    @Override
    public String toString() {
        return String.valueOf(super.toString()) + '#' + this.variant;
    }
    
    public String getVariant() {
        return this.variant;
    }
    
    public ModelResourceLocation(final String lllllllllllllIlllIIIIlIlllIIIlII) {
        this(0, parsePathString(lllllllllllllIlllIIIIlIlllIIIlII));
    }
}
