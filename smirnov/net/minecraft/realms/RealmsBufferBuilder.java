// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.realms;

import net.minecraft.client.renderer.vertex.VertexFormat;
import java.nio.ByteBuffer;
import net.minecraft.client.renderer.BufferBuilder;

public class RealmsBufferBuilder
{
    private /* synthetic */ BufferBuilder b;
    
    public RealmsBufferBuilder(final BufferBuilder llllllllllllIlllIllllIlIlIllllll) {
        this.b = llllllllllllIlllIllllIlIlIllllll;
    }
    
    public void putBulkData(final int[] llllllllllllIlllIllllIlIIIIIIIIl) {
        this.b.addVertexData(llllllllllllIlllIllllIlIIIIIIIIl);
    }
    
    public RealmsBufferBuilder vertex(final double llllllllllllIlllIllllIIllllIlIlI, final double llllllllllllIlllIllllIIllllIlIIl, final double llllllllllllIlllIllllIIllllIIlII) {
        return this.from(this.b.pos(llllllllllllIlllIllllIIllllIlIlI, llllllllllllIlllIllllIIllllIlIIl, llllllllllllIlllIllllIIllllIIlII));
    }
    
    public void fixupQuadColor(final float llllllllllllIlllIllllIIlllIllIlI, final float llllllllllllIlllIllllIIlllIllIIl, final float llllllllllllIlllIllllIIlllIllIII) {
        this.b.putColorRGB_F4(llllllllllllIlllIllllIIlllIllIlI, llllllllllllIlllIllllIIlllIllIIl, llllllllllllIlllIllllIIlllIllIII);
    }
    
    public void postNormal(final float llllllllllllIlllIllllIlIlIIllIlI, final float llllllllllllIlllIllllIlIlIIlllIl, final float llllllllllllIlllIllllIlIlIIlllII) {
        this.b.putNormal(llllllllllllIlllIllllIlIlIIllIlI, llllllllllllIlllIllllIlIlIIlllIl, llllllllllllIlllIllllIlIlIIlllII);
    }
    
    public void faceTex2(final int llllllllllllIlllIllllIlIIlIIllIl, final int llllllllllllIlllIllllIlIIlIlIIIl, final int llllllllllllIlllIllllIlIIlIlIIII, final int llllllllllllIlllIllllIlIIlIIlIlI) {
        this.b.putBrightness4(llllllllllllIlllIllllIlIIlIIllIl, llllllllllllIlllIllllIlIIlIlIIIl, llllllllllllIlllIllllIlIIlIlIIII, llllllllllllIlllIllllIlIIlIIlIlI);
    }
    
    public RealmsBufferBuilder normal(final float llllllllllllIlllIllllIlIIlllIllI, final float llllllllllllIlllIllllIlIIllllIIl, final float llllllllllllIlllIllllIlIIllllIII) {
        return this.from(this.b.normal(llllllllllllIlllIllllIlIIlllIllI, llllllllllllIlllIllllIlIIllllIIl, llllllllllllIlllIllllIlIIllllIII));
    }
    
    public void postProcessFacePosition(final double llllllllllllIlllIllllIlIIlIIIlII, final double llllllllllllIlllIllllIlIIIllllll, final double llllllllllllIlllIllllIlIIIlllllI) {
        this.b.putPosition(llllllllllllIlllIllllIlIIlIIIlII, llllllllllllIlllIllllIlIIIllllll, llllllllllllIlllIllllIlIIIlllllI);
    }
    
    public ByteBuffer getBuffer() {
        return this.b.getByteBuffer();
    }
    
    public RealmsBufferBuilder tex(final double llllllllllllIlllIllllIIlllllIlll, final double llllllllllllIlllIllllIIllllllIIl) {
        return this.from(this.b.tex(llllllllllllIlllIllllIIlllllIlll, llllllllllllIlllIllllIIllllllIIl));
    }
    
    public void faceTint(final float llllllllllllIlllIllllIlIIIIlIIIl, final float llllllllllllIlllIllllIlIIIIlIIII, final float llllllllllllIlllIllllIlIIIIIllll, final int llllllllllllIlllIllllIlIIIIlIIll) {
        this.b.putColorMultiplier(llllllllllllIlllIllllIlIIIIlIIIl, llllllllllllIlllIllllIlIIIIlIIII, llllllllllllIlllIllllIlIIIIIllll, llllllllllllIlllIllllIlIIIIlIIll);
    }
    
    public RealmsBufferBuilder color(final float llllllllllllIlllIllllIlIIIlIlIII, final float llllllllllllIlllIllllIlIIIlIIlll, final float llllllllllllIlllIllllIlIIIlIIIIl, final float llllllllllllIlllIllllIlIIIlIIlIl) {
        return this.from(this.b.color(llllllllllllIlllIllllIlIIIlIlIII, llllllllllllIlllIllllIlIIIlIIlll, llllllllllllIlllIllllIlIIIlIIIIl, llllllllllllIlllIllllIlIIIlIIlIl));
    }
    
    public void clear() {
        this.b.reset();
    }
    
    public void restoreState(final BufferBuilder.State llllllllllllIlllIllllIlIlIIIIlIl) {
        this.b.setVertexState(llllllllllllIlllIllllIlIlIIIIlIl);
    }
    
    public void end() {
        this.b.finishDrawing();
    }
    
    public void fixupQuadColor(final int llllllllllllIlllIllllIlIlIlIIlll) {
        this.b.putColor4(llllllllllllIlllIllllIlIlIlIIlll);
    }
    
    public void noColor() {
        this.b.noColor();
    }
    
    public void offset(final double llllllllllllIlllIllllIlIlIIIllll, final double llllllllllllIlllIllllIlIlIIIlllI, final double llllllllllllIlllIllllIlIlIIIlIIl) {
        this.b.setTranslation(llllllllllllIlllIllllIlIlIIIllll, llllllllllllIlllIllllIlIlIIIlllI, llllllllllllIlllIllllIlIlIIIlIIl);
    }
    
    public RealmsBufferBuilder color(final int llllllllllllIlllIllllIlIIlIlllII, final int llllllllllllIlllIllllIlIIllIIIII, final int llllllllllllIlllIllllIlIIlIllIlI, final int llllllllllllIlllIllllIlIIlIllllI) {
        return this.from(this.b.color(llllllllllllIlllIllllIlIIlIlllII, llllllllllllIlllIllllIlIIllIIIII, llllllllllllIlllIllllIlIIlIllIlI, llllllllllllIlllIllllIlIIlIllllI));
    }
    
    public void sortQuads(final float llllllllllllIlllIllllIlIlIlIllll, final float llllllllllllIlllIllllIlIlIlIlllI, final float llllllllllllIlllIllllIlIlIlIllIl) {
        this.b.sortVertexData(llllllllllllIlllIllllIlIlIlIllll, llllllllllllIlllIllllIlIlIlIlllI, llllllllllllIlllIllllIlIlIlIllIl);
    }
    
    public void fixupVertexColor(final float llllllllllllIlllIllllIlIIIllIIlI, final float llllllllllllIlllIllllIlIIIllIllI, final float llllllllllllIlllIllllIlIIIllIIII, final int llllllllllllIlllIllllIlIIIlIllll) {
        this.b.putColorRGB_F(llllllllllllIlllIllllIlIIIllIIlI, llllllllllllIlllIllllIlIIIllIllI, llllllllllllIlllIllllIlIIIllIIII, llllllllllllIlllIllllIlIIIlIllll);
    }
    
    public RealmsBufferBuilder from(final BufferBuilder llllllllllllIlllIllllIlIlIlllIIl) {
        this.b = llllllllllllIlllIllllIlIlIlllIIl;
        return this;
    }
    
    public void begin(final int llllllllllllIlllIllllIlIIllIllII, final VertexFormat llllllllllllIlllIllllIlIIllIlIll) {
        this.b.begin(llllllllllllIlllIllllIlIIllIllII, llllllllllllIlllIllllIlIIllIlIll);
    }
    
    public int getDrawMode() {
        return this.b.getDrawMode();
    }
    
    public RealmsVertexFormat getVertexFormat() {
        return new RealmsVertexFormat(this.b.getVertexFormat());
    }
    
    public RealmsBufferBuilder tex2(final int llllllllllllIlllIllllIlIIIIIlIIl, final int llllllllllllIlllIllllIlIIIIIIlIl) {
        return this.from(this.b.lightmap(llllllllllllIlllIllllIlIIIIIlIIl, llllllllllllIlllIllllIlIIIIIIlIl));
    }
    
    public void endVertex() {
        this.b.endVertex();
    }
    
    public int getVertexCount() {
        return this.b.getVertexCount();
    }
}
