// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer;

import java.nio.ByteOrder;
import java.nio.ByteBuffer;
import org.lwjgl.util.glu.GLU;
import java.nio.IntBuffer;
import java.nio.FloatBuffer;

public class GLAllocation
{
    public static FloatBuffer createDirectFloatBuffer(final int llllllllllllIIIIlllIllllIllllIlI) {
        return createDirectByteBuffer(llllllllllllIIIIlllIllllIllllIlI << 2).asFloatBuffer();
    }
    
    public static synchronized void deleteDisplayLists(final int llllllllllllIIIIlllIlllllIIIIlll, final int llllllllllllIIIIlllIlllllIIIlIII) {
        GlStateManager.glDeleteLists(llllllllllllIIIIlllIlllllIIIIlll, llllllllllllIIIIlllIlllllIIIlIII);
    }
    
    public static IntBuffer createDirectIntBuffer(final int llllllllllllIIIIlllIllllIlllllIl) {
        return createDirectByteBuffer(llllllllllllIIIIlllIllllIlllllIl << 2).asIntBuffer();
    }
    
    public static synchronized int generateDisplayLists(final int llllllllllllIIIIlllIlllllIIlIIll) {
        final int llllllllllllIIIIlllIlllllIIlIIlI = GlStateManager.glGenLists(llllllllllllIIIIlllIlllllIIlIIll);
        if (llllllllllllIIIIlllIlllllIIlIIlI == 0) {
            final int llllllllllllIIIIlllIlllllIIlIIIl = GlStateManager.glGetError();
            String llllllllllllIIIIlllIlllllIIlIIII = "No error code reported";
            if (llllllllllllIIIIlllIlllllIIlIIIl != 0) {
                llllllllllllIIIIlllIlllllIIlIIII = GLU.gluErrorString(llllllllllllIIIIlllIlllllIIlIIIl);
            }
            throw new IllegalStateException("glGenLists returned an ID of 0 for a count of " + llllllllllllIIIIlllIlllllIIlIIll + ", GL error (" + llllllllllllIIIIlllIlllllIIlIIIl + "): " + llllllllllllIIIIlllIlllllIIlIIII);
        }
        return llllllllllllIIIIlllIlllllIIlIIlI;
    }
    
    public static synchronized void deleteDisplayLists(final int llllllllllllIIIIlllIlllllIIIIlII) {
        deleteDisplayLists(llllllllllllIIIIlllIlllllIIIIlII, 1);
    }
    
    public static synchronized ByteBuffer createDirectByteBuffer(final int llllllllllllIIIIlllIlllllIIIIIII) {
        return ByteBuffer.allocateDirect(llllllllllllIIIIlllIlllllIIIIIII).order(ByteOrder.nativeOrder());
    }
}
