// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.chunk;

import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.world.World;

public class ListChunkFactory implements IRenderChunkFactory
{
    @Override
    public RenderChunk create(final World llllllllllllIIIlIllllIlIIIlIIIlI, final RenderGlobal llllllllllllIIIlIllllIlIIIlIIIIl, final int llllllllllllIIIlIllllIlIIIlIIIII) {
        return new ListedRenderChunk(llllllllllllIIIlIllllIlIIIlIIIlI, llllllllllllIIIlIllllIlIIIlIIIIl, llllllllllllIIIlIllllIlIIIlIIIII);
    }
}
