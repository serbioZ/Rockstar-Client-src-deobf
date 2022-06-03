// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.chunk;

import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.world.World;

public class VboChunkFactory implements IRenderChunkFactory
{
    @Override
    public RenderChunk create(final World llllllllllllIlllIIlllllIIlllIIlI, final RenderGlobal llllllllllllIlllIIlllllIIllIlllI, final int llllllllllllIlllIIlllllIIlllIIII) {
        return new RenderChunk(llllllllllllIlllIIlllllIIlllIIlI, llllllllllllIlllIIlllllIIllIlllI, llllllllllllIlllIIlllllIIlllIIII);
    }
}
