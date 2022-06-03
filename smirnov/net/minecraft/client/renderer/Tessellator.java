// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer;

public class Tessellator
{
    private final /* synthetic */ BufferBuilder worldRenderer;
    private final /* synthetic */ WorldVertexBufferUploader vboUploader;
    private static final /* synthetic */ Tessellator INSTANCE;
    
    static {
        INSTANCE = new Tessellator(2097152);
    }
    
    public BufferBuilder getBuffer() {
        return this.worldRenderer;
    }
    
    public static Tessellator getInstance() {
        return Tessellator.INSTANCE;
    }
    
    public void draw() {
        this.worldRenderer.finishDrawing();
        this.vboUploader.draw(this.worldRenderer);
    }
    
    public Tessellator(final int llllllllllllIIlIIlIIIIIIlIIIlIIl) {
        this.vboUploader = new WorldVertexBufferUploader();
        this.worldRenderer = new BufferBuilder(llllllllllllIIlIIlIIIIIIlIIIlIIl);
    }
}
