// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.realms;

import net.minecraft.client.renderer.vertex.VertexFormatElement;

public class RealmsVertexFormatElement
{
    private final /* synthetic */ VertexFormatElement v;
    
    public int getCount() {
        return this.v.getElementCount();
    }
    
    public VertexFormatElement getVertexFormatElement() {
        return this.v;
    }
    
    public RealmsVertexFormatElement(final VertexFormatElement lllllllllllIIIlIllIIIIIlIIIIllII) {
        this.v = lllllllllllIIIlIllIIIIIlIIIIllII;
    }
    
    @Override
    public boolean equals(final Object lllllllllllIIIlIllIIIIIIllllIlII) {
        return this.v.equals(lllllllllllIIIlIllIIIIIIllllIlII);
    }
    
    public int getByteSize() {
        return this.v.getSize();
    }
    
    @Override
    public int hashCode() {
        return this.v.hashCode();
    }
    
    public int getIndex() {
        return this.v.getIndex();
    }
    
    @Override
    public String toString() {
        return this.v.toString();
    }
    
    public boolean isPosition() {
        return this.v.isPositionElement();
    }
}
