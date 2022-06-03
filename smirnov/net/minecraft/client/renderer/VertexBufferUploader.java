// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer;

import net.minecraft.client.renderer.vertex.VertexBuffer;

public class VertexBufferUploader extends WorldVertexBufferUploader
{
    private /* synthetic */ VertexBuffer vertexBuffer;
    
    @Override
    public void draw(final BufferBuilder lllllllllllIIllIlIIIlIIlIllIllIl) {
        lllllllllllIIllIlIIIlIIlIllIllIl.reset();
        this.vertexBuffer.bufferData(lllllllllllIIllIlIIIlIIlIllIllIl.getByteBuffer());
    }
    
    public void setVertexBuffer(final VertexBuffer lllllllllllIIllIlIIIlIIlIllIIlll) {
        this.vertexBuffer = lllllllllllIIllIlIIIlIIlIllIIlll;
    }
}
