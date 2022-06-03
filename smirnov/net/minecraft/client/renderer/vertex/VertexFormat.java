// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.vertex;

import org.apache.logging.log4j.LogManager;
import com.google.common.collect.Lists;
import org.apache.logging.log4j.Logger;
import java.util.List;

public class VertexFormat
{
    private final /* synthetic */ List<Integer> offsets;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumUsage;
    private static final /* synthetic */ Logger LOGGER;
    private /* synthetic */ int normalElementOffset;
    private final /* synthetic */ List<VertexFormatElement> elements;
    private /* synthetic */ int nextOffset;
    private /* synthetic */ int colorElementOffset;
    private final /* synthetic */ List<Integer> uvOffsetsById;
    
    public boolean hasUvOffset(final int lllllllllllIIllIIIIllIllllIIIlll) {
        return this.uvOffsetsById.size() - 1 >= lllllllllllIIllIIIIllIllllIIIlll;
    }
    
    public int getIntegerSize() {
        return this.getNextOffset() / 4;
    }
    
    public int getUvOffsetById(final int lllllllllllIIllIIIIllIlllIllllll) {
        return this.uvOffsetsById.get(lllllllllllIIllIIIIllIlllIllllll);
    }
    
    public VertexFormatElement getElement(final int lllllllllllIIllIIIIllIlllIIllIlI) {
        return this.elements.get(lllllllllllIIllIIIIllIlllIIllIlI);
    }
    
    public VertexFormat addElement(final VertexFormatElement lllllllllllIIllIIIIllIllllIlIlll) {
        if (lllllllllllIIllIIIIllIllllIlIlll.isPositionElement() && this.hasPosition()) {
            VertexFormat.LOGGER.warn("VertexFormat error: Trying to add a position VertexFormatElement when one already exists, ignoring.");
            return this;
        }
        this.elements.add(lllllllllllIIllIIIIllIllllIlIlll);
        this.offsets.add(this.nextOffset);
        switch ($SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumUsage()[lllllllllllIIllIIIIllIllllIlIlll.getUsage().ordinal()]) {
            case 2: {
                this.normalElementOffset = this.nextOffset;
                break;
            }
            case 3: {
                this.colorElementOffset = this.nextOffset;
                break;
            }
            case 4: {
                this.uvOffsetsById.add(lllllllllllIIllIIIIllIllllIlIlll.getIndex(), this.nextOffset);
                break;
            }
        }
        this.nextOffset += lllllllllllIIllIIIIllIllllIlIlll.getSize();
        return this;
    }
    
    public int getNextOffset() {
        return this.nextOffset;
    }
    
    @Override
    public int hashCode() {
        int lllllllllllIIllIIIIllIlllIIIIlIl = this.elements.hashCode();
        lllllllllllIIllIIIIllIlllIIIIlIl = 31 * lllllllllllIIllIIIIllIlllIIIIlIl + this.offsets.hashCode();
        lllllllllllIIllIIIIllIlllIIIIlIl = 31 * lllllllllllIIllIIIIllIlllIIIIlIl + this.nextOffset;
        return lllllllllllIIllIIIIllIlllIIIIlIl;
    }
    
    public int getElementCount() {
        return this.elements.size();
    }
    
    public boolean hasColor() {
        return this.colorElementOffset >= 0;
    }
    
    public VertexFormat(final VertexFormat lllllllllllIIllIIIIllIlllllIIlII) {
        this();
        for (int lllllllllllIIllIIIIllIlllllIIllI = 0; lllllllllllIIllIIIIllIlllllIIllI < lllllllllllIIllIIIIllIlllllIIlII.getElementCount(); ++lllllllllllIIllIIIIllIlllllIIllI) {
            this.addElement(lllllllllllIIllIIIIllIlllllIIlII.getElement(lllllllllllIIllIIIIllIlllllIIllI));
        }
        this.nextOffset = lllllllllllIIllIIIIllIlllllIIlII.getNextOffset();
    }
    
    public VertexFormat() {
        this.elements = (List<VertexFormatElement>)Lists.newArrayList();
        this.offsets = (List<Integer>)Lists.newArrayList();
        this.colorElementOffset = -1;
        this.uvOffsetsById = (List<Integer>)Lists.newArrayList();
        this.normalElementOffset = -1;
    }
    
    public void clear() {
        this.elements.clear();
        this.offsets.clear();
        this.colorElementOffset = -1;
        this.uvOffsetsById.clear();
        this.normalElementOffset = -1;
        this.nextOffset = 0;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumUsage() {
        final int[] $switch_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumUsage = VertexFormat.$SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumUsage;
        if ($switch_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumUsage != null) {
            return $switch_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumUsage;
        }
        final char lllllllllllIIllIIIIllIlllIIIIIIl = (Object)new int[VertexFormatElement.EnumUsage.values().length];
        try {
            lllllllllllIIllIIIIllIlllIIIIIIl[VertexFormatElement.EnumUsage.BLEND_WEIGHT.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllIIllIIIIllIlllIIIIIIl[VertexFormatElement.EnumUsage.COLOR.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllIIllIIIIllIlllIIIIIIl[VertexFormatElement.EnumUsage.MATRIX.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllIIllIIIIllIlllIIIIIIl[VertexFormatElement.EnumUsage.NORMAL.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllIIllIIIIllIlllIIIIIIl[VertexFormatElement.EnumUsage.PADDING.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllIIllIIIIllIlllIIIIIIl[VertexFormatElement.EnumUsage.POSITION.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        try {
            lllllllllllIIllIIIIllIlllIIIIIIl[VertexFormatElement.EnumUsage.UV.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError7) {}
        return VertexFormat.$SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumUsage = (int[])(Object)lllllllllllIIllIIIIllIlllIIIIIIl;
    }
    
    @Override
    public String toString() {
        String lllllllllllIIllIIIIllIlllIlllIlI = "format: " + this.elements.size() + " elements: ";
        for (int lllllllllllIIllIIIIllIlllIlllIIl = 0; lllllllllllIIllIIIIllIlllIlllIIl < this.elements.size(); ++lllllllllllIIllIIIIllIlllIlllIIl) {
            lllllllllllIIllIIIIllIlllIlllIlI = String.valueOf(lllllllllllIIllIIIIllIlllIlllIlI) + this.elements.get(lllllllllllIIllIIIIllIlllIlllIIl).toString();
            if (lllllllllllIIllIIIIllIlllIlllIIl != this.elements.size() - 1) {
                lllllllllllIIllIIIIllIlllIlllIlI = String.valueOf(lllllllllllIIllIIIIllIlllIlllIlI) + " ";
            }
        }
        return lllllllllllIIllIIIIllIlllIlllIlI;
    }
    
    public int getOffset(final int lllllllllllIIllIIIIllIlllIIlIIlI) {
        return this.offsets.get(lllllllllllIIllIIIIllIlllIIlIIlI);
    }
    
    public int getNormalOffset() {
        return this.normalElementOffset;
    }
    
    public List<VertexFormatElement> getElements() {
        return this.elements;
    }
    
    @Override
    public boolean equals(final Object lllllllllllIIllIIIIllIlllIIIlIlI) {
        if (this == lllllllllllIIllIIIIllIlllIIIlIlI) {
            return true;
        }
        if (lllllllllllIIllIIIIllIlllIIIlIlI != null && this.getClass() == lllllllllllIIllIIIIllIlllIIIlIlI.getClass()) {
            final VertexFormat lllllllllllIIllIIIIllIlllIIIllII = (VertexFormat)lllllllllllIIllIIIIllIlllIIIlIlI;
            return this.nextOffset == lllllllllllIIllIIIIllIlllIIIllII.nextOffset && this.elements.equals(lllllllllllIIllIIIIllIlllIIIllII.elements) && this.offsets.equals(lllllllllllIIllIIIIllIlllIIIllII.offsets);
        }
        return false;
    }
    
    public int getColorOffset() {
        return this.colorElementOffset;
    }
    
    public boolean hasNormal() {
        return this.normalElementOffset >= 0;
    }
    
    private boolean hasPosition() {
        for (int lllllllllllIIllIIIIllIlllIllIIII = 0, lllllllllllIIllIIIIllIlllIlIllll = this.elements.size(); lllllllllllIIllIIIIllIlllIllIIII < lllllllllllIIllIIIIllIlllIlIllll; ++lllllllllllIIllIIIIllIlllIllIIII) {
            final VertexFormatElement lllllllllllIIllIIIIllIlllIlIlllI = this.elements.get(lllllllllllIIllIIIIllIlllIllIIII);
            if (lllllllllllIIllIIIIllIlllIlIlllI.isPositionElement()) {
                return true;
            }
        }
        return false;
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
}
