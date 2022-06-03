// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.vertex;

import java.nio.ByteBuffer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;

public class VertexBuffer
{
    private final /* synthetic */ VertexFormat vertexFormat;
    private /* synthetic */ int count;
    private /* synthetic */ int glBufferId;
    
    public VertexBuffer(final VertexFormat llllllllllllllIlIllIIIIllIlIlIlI) {
        this.vertexFormat = llllllllllllllIlIllIIIIllIlIlIlI;
        this.glBufferId = OpenGlHelper.glGenBuffers();
    }
    
    public void unbindBuffer() {
        OpenGlHelper.glBindBuffer(OpenGlHelper.GL_ARRAY_BUFFER, 0);
    }
    
    public void drawArrays(final int llllllllllllllIlIllIIIIllIIllIIl) {
        GlStateManager.glDrawArrays(llllllllllllllIlIllIIIIllIIllIIl, 0, this.count);
    }
    
    public void deleteGlBuffers() {
        if (this.glBufferId >= 0) {
            OpenGlHelper.glDeleteBuffers(this.glBufferId);
            this.glBufferId = -1;
        }
    }
    
    public void bindBuffer() {
        OpenGlHelper.glBindBuffer(OpenGlHelper.GL_ARRAY_BUFFER, this.glBufferId);
    }
    
    public void bufferData(final ByteBuffer llllllllllllllIlIllIIIIllIlIIIIl) {
        this.bindBuffer();
        OpenGlHelper.glBufferData(OpenGlHelper.GL_ARRAY_BUFFER, llllllllllllllIlIllIIIIllIlIIIIl, 35044);
        this.unbindBuffer();
        this.count = llllllllllllllIlIllIIIIllIlIIIIl.limit() / this.vertexFormat.getNextOffset();
    }
}
