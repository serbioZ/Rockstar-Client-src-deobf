// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.vertex;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VertexFormatElement
{
    private static final /* synthetic */ Logger LOGGER;
    private final /* synthetic */ int index;
    private final /* synthetic */ EnumUsage usage;
    private final /* synthetic */ EnumType type;
    private final /* synthetic */ int elementCount;
    
    @Override
    public boolean equals(final Object lllllllllllIlIlIlIlIIIIlIlIIIIlI) {
        if (this == lllllllllllIlIlIlIlIIIIlIlIIIIlI) {
            return true;
        }
        if (lllllllllllIlIlIlIlIIIIlIlIIIIlI != null && this.getClass() == lllllllllllIlIlIlIlIIIIlIlIIIIlI.getClass()) {
            final VertexFormatElement lllllllllllIlIlIlIlIIIIlIlIIIIIl = (VertexFormatElement)lllllllllllIlIlIlIlIIIIlIlIIIIlI;
            return this.elementCount == lllllllllllIlIlIlIlIIIIlIlIIIIIl.elementCount && this.index == lllllllllllIlIlIlIlIIIIlIlIIIIIl.index && this.type == lllllllllllIlIlIlIlIIIIlIlIIIIIl.type && this.usage == lllllllllllIlIlIlIlIIIIlIlIIIIIl.usage;
        }
        return false;
    }
    
    public final EnumUsage getUsage() {
        return this.usage;
    }
    
    public final EnumType getType() {
        return this.type;
    }
    
    @Override
    public int hashCode() {
        int lllllllllllIlIlIlIlIIIIlIIlllIlI = this.type.hashCode();
        lllllllllllIlIlIlIlIIIIlIIlllIlI = 31 * lllllllllllIlIlIlIlIIIIlIIlllIlI + this.usage.hashCode();
        lllllllllllIlIlIlIlIIIIlIIlllIlI = 31 * lllllllllllIlIlIlIlIIIIlIIlllIlI + this.index;
        lllllllllllIlIlIlIlIIIIlIIlllIlI = 31 * lllllllllllIlIlIlIlIIIIlIIlllIlI + this.elementCount;
        return lllllllllllIlIlIlIlIIIIlIIlllIlI;
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    private final boolean isFirstOrUV(final int lllllllllllIlIlIlIlIIIIlIlIlllIl, final EnumUsage lllllllllllIlIlIlIlIIIIlIlIllllI) {
        return lllllllllllIlIlIlIlIIIIlIlIlllIl == 0 || lllllllllllIlIlIlIlIIIIlIlIllllI == EnumUsage.UV;
    }
    
    @Override
    public String toString() {
        return String.valueOf(this.elementCount) + "," + this.usage.getDisplayName() + "," + this.type.getDisplayName();
    }
    
    public final boolean isPositionElement() {
        return this.usage == EnumUsage.POSITION;
    }
    
    public final int getSize() {
        return this.type.getSize() * this.elementCount;
    }
    
    public final int getElementCount() {
        return this.elementCount;
    }
    
    public VertexFormatElement(final int lllllllllllIlIlIlIlIIIIlIllIlIll, final EnumType lllllllllllIlIlIlIlIIIIlIllIlIlI, final EnumUsage lllllllllllIlIlIlIlIIIIlIllIlIIl, final int lllllllllllIlIlIlIlIIIIlIllIIIll) {
        if (this.isFirstOrUV(lllllllllllIlIlIlIlIIIIlIllIlIll, lllllllllllIlIlIlIlIIIIlIllIlIIl)) {
            this.usage = lllllllllllIlIlIlIlIIIIlIllIlIIl;
        }
        else {
            VertexFormatElement.LOGGER.warn("Multiple vertex elements of the same type other than UVs are not supported. Forcing type to UV.");
            this.usage = EnumUsage.UV;
        }
        this.type = lllllllllllIlIlIlIlIIIIlIllIlIlI;
        this.index = lllllllllllIlIlIlIlIIIIlIllIlIll;
        this.elementCount = lllllllllllIlIlIlIlIIIIlIllIIIll;
    }
    
    public final int getIndex() {
        return this.index;
    }
    
    public enum EnumType
    {
        UINT("UINT", 5, 4, "Unsigned Int", 5125), 
        INT("INT", 6, 4, "Int", 5124), 
        UBYTE("UBYTE", 1, 1, "Unsigned Byte", 5121), 
        SHORT("SHORT", 4, 2, "Short", 5122);
        
        private final /* synthetic */ int size;
        
        USHORT("USHORT", 3, 2, "Unsigned Short", 5123);
        
        private final /* synthetic */ int glConstant;
        
        FLOAT("FLOAT", 0, 4, "Float", 5126), 
        BYTE("BYTE", 2, 1, "Byte", 5120);
        
        private final /* synthetic */ String displayName;
        
        public int getSize() {
            return this.size;
        }
        
        private EnumType(final String llllllllllllIllIIIIlllIIIIIIlIIl, final int llllllllllllIllIIIIlllIIIIIIlIII, final int llllllllllllIllIIIIlllIIIIIIIlll, final String llllllllllllIllIIIIlllIIIIIIllII, final int llllllllllllIllIIIIlllIIIIIIlIll) {
            this.size = llllllllllllIllIIIIlllIIIIIIIlll;
            this.displayName = llllllllllllIllIIIIlllIIIIIIllII;
            this.glConstant = llllllllllllIllIIIIlllIIIIIIlIll;
        }
        
        public int getGlConstant() {
            return this.glConstant;
        }
        
        public String getDisplayName() {
            return this.displayName;
        }
    }
    
    public enum EnumUsage
    {
        private final /* synthetic */ String displayName;
        
        PADDING("PADDING", 6, "Padding"), 
        MATRIX("MATRIX", 4, "Bone Matrix"), 
        BLEND_WEIGHT("BLEND_WEIGHT", 5, "Blend Weight"), 
        COLOR("COLOR", 2, "Vertex Color"), 
        POSITION("POSITION", 0, "Position"), 
        NORMAL("NORMAL", 1, "Normal"), 
        UV("UV", 3, "UV");
        
        private EnumUsage(final String llllllllllllIllllllllIIlIIIIIIII, final int llllllllllllIllllllllIIIllllllll, final String llllllllllllIllllllllIIlIIIIIIlI) {
            this.displayName = llllllllllllIllllllllIIlIIIIIIlI;
        }
        
        public String getDisplayName() {
            return this.displayName;
        }
    }
}
