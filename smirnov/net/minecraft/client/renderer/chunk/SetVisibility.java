// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.chunk;

import java.util.Set;
import net.minecraft.util.EnumFacing;

public class SetVisibility
{
    private /* synthetic */ long bits;
    private static final /* synthetic */ int COUNT_FACES;
    
    private void clearBit(final int lllllllllllllIIlIllIIIlIlIIllIII) {
        this.bits &= ~(1 << lllllllllllllIIlIllIIIlIlIIllIII);
    }
    
    private void setBit(final int lllllllllllllIIlIllIIIlIlIIllllI) {
        this.bits |= 1 << lllllllllllllIIlIllIIIlIlIIllllI;
    }
    
    static {
        COUNT_FACES = EnumFacing.values().length;
    }
    
    public void setAllVisible(final boolean lllllllllllllIIlIllIIIlIllIllIlI) {
        if (lllllllllllllIIlIllIIIlIllIllIlI) {
            this.bits = -1L;
        }
        else {
            this.bits = 0L;
        }
    }
    
    public void setManyVisible(final Set<EnumFacing> lllllllllllllIIlIllIIIlIlllIlllI) {
        for (final EnumFacing lllllllllllllIIlIllIIIlIllllIIIl : lllllllllllllIIlIllIIIlIlllIlllI) {
            for (final EnumFacing lllllllllllllIIlIllIIIlIllllIIII : lllllllllllllIIlIllIIIlIlllIlllI) {
                this.setVisible(lllllllllllllIIlIllIIIlIllllIIIl, lllllllllllllIIlIllIIIlIllllIIII, true);
            }
        }
    }
    
    private boolean getBit(final int lllllllllllllIIlIllIIIlIlIlIllll) {
        return (this.bits & (long)(1 << lllllllllllllIIlIllIIIlIlIlIllll)) != 0x0L;
    }
    
    @Override
    public String toString() {
        final StringBuilder lllllllllllllIIlIllIIIlIllIIIIlI = new StringBuilder();
        lllllllllllllIIlIllIIIlIllIIIIlI.append(' ');
        int lllllllllllllIIlIllIIIlIlIlllIII;
        long lllllllllllllIIlIllIIIlIlIlllIIl = ((EnumFacing[])(Object)(lllllllllllllIIlIllIIIlIlIlllIII = (int)(Object)EnumFacing.values())).length;
        for (char lllllllllllllIIlIllIIIlIlIlllIlI = '\0'; lllllllllllllIIlIllIIIlIlIlllIlI < lllllllllllllIIlIllIIIlIlIlllIIl; ++lllllllllllllIIlIllIIIlIlIlllIlI) {
            final EnumFacing lllllllllllllIIlIllIIIlIllIIIIIl = lllllllllllllIIlIllIIIlIlIlllIII[lllllllllllllIIlIllIIIlIlIlllIlI];
            lllllllllllllIIlIllIIIlIllIIIIlI.append(' ').append(lllllllllllllIIlIllIIIlIllIIIIIl.toString().toUpperCase().charAt(0));
        }
        lllllllllllllIIlIllIIIlIllIIIIlI.append('\n');
        lllllllllllllIIlIllIIIlIlIlllIIl = ((EnumFacing[])(Object)(lllllllllllllIIlIllIIIlIlIlllIII = (int)(Object)EnumFacing.values())).length;
        for (char lllllllllllllIIlIllIIIlIlIlllIlI = '\0'; lllllllllllllIIlIllIIIlIlIlllIlI < lllllllllllllIIlIllIIIlIlIlllIIl; ++lllllllllllllIIlIllIIIlIlIlllIlI) {
            final EnumFacing lllllllllllllIIlIllIIIlIllIIIIII = lllllllllllllIIlIllIIIlIlIlllIII[lllllllllllllIIlIllIIIlIlIlllIlI];
            lllllllllllllIIlIllIIIlIllIIIIlI.append(lllllllllllllIIlIllIIIlIllIIIIII.toString().toUpperCase().charAt(0));
            final short lllllllllllllIIlIllIIIlIlIllIlII;
            final Exception lllllllllllllIIlIllIIIlIlIllIlIl = (Exception)((EnumFacing[])(Object)(lllllllllllllIIlIllIIIlIlIllIlII = (short)(Object)EnumFacing.values())).length;
            for (short lllllllllllllIIlIllIIIlIlIllIllI = 0; lllllllllllllIIlIllIIIlIlIllIllI < lllllllllllllIIlIllIIIlIlIllIlIl; ++lllllllllllllIIlIllIIIlIlIllIllI) {
                final EnumFacing lllllllllllllIIlIllIIIlIlIllllll = lllllllllllllIIlIllIIIlIlIllIlII[lllllllllllllIIlIllIIIlIlIllIllI];
                if (lllllllllllllIIlIllIIIlIllIIIIII == lllllllllllllIIlIllIIIlIlIllllll) {
                    lllllllllllllIIlIllIIIlIllIIIIlI.append("  ");
                }
                else {
                    final boolean lllllllllllllIIlIllIIIlIlIlllllI = this.isVisible(lllllllllllllIIlIllIIIlIllIIIIII, lllllllllllllIIlIllIIIlIlIllllll);
                    lllllllllllllIIlIllIIIlIllIIIIlI.append(' ').append(lllllllllllllIIlIllIIIlIlIlllllI ? 'Y' : 'n');
                }
            }
            lllllllllllllIIlIllIIIlIllIIIIlI.append('\n');
        }
        return lllllllllllllIIlIllIIIlIllIIIIlI.toString();
    }
    
    private void setBit(final int lllllllllllllIIlIllIIIlIlIlIIlIl, final boolean lllllllllllllIIlIllIIIlIlIlIIlll) {
        if (lllllllllllllIIlIllIIIlIlIlIIlll) {
            this.setBit(lllllllllllllIIlIllIIIlIlIlIIlIl);
        }
        else {
            this.clearBit(lllllllllllllIIlIllIIIlIlIlIIlIl);
        }
    }
    
    public void setVisible(final EnumFacing lllllllllllllIIlIllIIIlIlllIIIII, final EnumFacing lllllllllllllIIlIllIIIlIlllIIIll, final boolean lllllllllllllIIlIllIIIlIlllIIIlI) {
        this.setBit(lllllllllllllIIlIllIIIlIlllIIIII.ordinal() + lllllllllllllIIlIllIIIlIlllIIIll.ordinal() * SetVisibility.COUNT_FACES, lllllllllllllIIlIllIIIlIlllIIIlI);
        this.setBit(lllllllllllllIIlIllIIIlIlllIIIll.ordinal() + lllllllllllllIIlIllIIIlIlllIIIII.ordinal() * SetVisibility.COUNT_FACES, lllllllllllllIIlIllIIIlIlllIIIlI);
    }
    
    public boolean isVisible(final EnumFacing lllllllllllllIIlIllIIIlIllIlIIII, final EnumFacing lllllllllllllIIlIllIIIlIllIlIIlI) {
        return this.getBit(lllllllllllllIIlIllIIIlIllIlIIII.ordinal() + lllllllllllllIIlIllIIIlIllIlIIlI.ordinal() * SetVisibility.COUNT_FACES);
    }
}
