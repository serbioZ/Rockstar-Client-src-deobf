// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.event.event;

import net.minecraft.util.math.BlockPos;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.world.IBlockAccess;
import ru.rockstar.api.event.Event;

public class EventRenderBlock extends Event
{
    private final /* synthetic */ IBlockAccess access;
    private final /* synthetic */ BufferBuilder bufferBuilder;
    private final /* synthetic */ IBlockState state;
    private final /* synthetic */ BlockPos pos;
    
    public IBlockAccess getAccess() {
        return this.access;
    }
    
    public EventRenderBlock(final IBlockState lllllllllllIIlIIlIlIIlllIIIlIllI, final BlockPos lllllllllllIIlIIlIlIIlllIIIllIlI, final IBlockAccess lllllllllllIIlIIlIlIIlllIIIllIIl, final BufferBuilder lllllllllllIIlIIlIlIIlllIIIllIII) {
        this.state = lllllllllllIIlIIlIlIIlllIIIlIllI;
        this.pos = lllllllllllIIlIIlIlIIlllIIIllIlI;
        this.access = lllllllllllIIlIIlIlIIlllIIIllIIl;
        this.bufferBuilder = lllllllllllIIlIIlIlIIlllIIIllIII;
    }
    
    public BufferBuilder getBufferBuilder() {
        return this.bufferBuilder;
    }
    
    public BlockPos getPos() {
        return this.pos;
    }
    
    public IBlockState getState() {
        return this.state;
    }
}
