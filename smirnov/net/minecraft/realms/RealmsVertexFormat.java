// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.realms;

import net.minecraft.client.renderer.vertex.VertexFormatElement;
import com.google.common.collect.Lists;
import java.util.List;
import net.minecraft.client.renderer.vertex.VertexFormat;

public class RealmsVertexFormat
{
    private /* synthetic */ VertexFormat v;
    
    public RealmsVertexFormat(final VertexFormat llllllllllIllllllIlIlIIllIlIllIl) {
        this.v = llllllllllIllllllIlIlIIllIlIllIl;
    }
    
    public boolean hasUv(final int llllllllllIllllllIlIlIIllIIIllll) {
        return this.v.hasUvOffset(llllllllllIllllllIlIlIIllIIIllll);
    }
    
    public int getColorOffset() {
        return this.v.getColorOffset();
    }
    
    public boolean hasColor() {
        return this.v.hasColor();
    }
    
    public int getOffset(final int llllllllllIllllllIlIlIIlIllIlIll) {
        return this.v.getOffset(llllllllllIllllllIlIlIIlIllIlIll);
    }
    
    public boolean hasNormal() {
        return this.v.hasNormal();
    }
    
    public RealmsVertexFormat addElement(final RealmsVertexFormatElement llllllllllIllllllIlIlIIllIIIIlIl) {
        return this.from(this.v.addElement(llllllllllIllllllIlIlIIllIIIIlIl.getVertexFormatElement()));
    }
    
    public int getVertexSize() {
        return this.v.getNextOffset();
    }
    
    public int getNormalOffset() {
        return this.v.getNormalOffset();
    }
    
    @Override
    public String toString() {
        return this.v.toString();
    }
    
    public VertexFormat getVertexFormat() {
        return this.v;
    }
    
    public int getUvOffset(final int llllllllllIllllllIlIlIIllIIlllIl) {
        return this.v.getUvOffsetById(llllllllllIllllllIlIlIIllIIlllIl);
    }
    
    public RealmsVertexFormatElement getElement(final int llllllllllIllllllIlIlIIllIIIlIIl) {
        return new RealmsVertexFormatElement(this.v.getElement(llllllllllIllllllIlIlIIllIIIlIIl));
    }
    
    @Override
    public boolean equals(final Object llllllllllIllllllIlIlIIlIlIlllIl) {
        return this.v.equals(llllllllllIllllllIlIlIIlIlIlllIl);
    }
    
    @Override
    public int hashCode() {
        return this.v.hashCode();
    }
    
    public List<RealmsVertexFormatElement> getElements() {
        final List<RealmsVertexFormatElement> llllllllllIllllllIlIlIIlIllllIlI = (List<RealmsVertexFormatElement>)Lists.newArrayList();
        for (final VertexFormatElement llllllllllIllllllIlIlIIlIllllIIl : this.v.getElements()) {
            llllllllllIllllllIlIlIIlIllllIlI.add(new RealmsVertexFormatElement(llllllllllIllllllIlIlIIlIllllIIl));
        }
        return llllllllllIllllllIlIlIIlIllllIlI;
    }
    
    public void clear() {
        this.v.clear();
    }
    
    public int getElementCount() {
        return this.v.getElementCount();
    }
    
    public RealmsVertexFormat from(final VertexFormat llllllllllIllllllIlIlIIllIlIIlll) {
        this.v = llllllllllIllllllIlIlIIllIlIIlll;
        return this;
    }
    
    public int getIntegerSize() {
        return this.v.getIntegerSize();
    }
}
