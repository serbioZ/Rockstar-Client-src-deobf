// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.chunk;

import javax.annotation.Nullable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.network.PacketBuffer;

public interface IBlockStatePalette
{
    void read(final PacketBuffer p0);
    
    int getSerializedState();
    
    int idFor(final IBlockState p0);
    
    @Nullable
    IBlockState getBlockState(final int p0);
    
    void write(final PacketBuffer p0);
}
