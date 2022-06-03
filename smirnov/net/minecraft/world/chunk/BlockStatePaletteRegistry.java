// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.chunk;

import net.minecraft.init.Blocks;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.network.PacketBuffer;

public class BlockStatePaletteRegistry implements IBlockStatePalette
{
    @Override
    public void read(final PacketBuffer llllllllllllIlIIlIIIIlIllIIlIIIl) {
        llllllllllllIlIIlIIIIlIllIIlIIIl.readVarIntFromBuffer();
    }
    
    @Override
    public void write(final PacketBuffer llllllllllllIlIIlIIIIlIllIIIlllI) {
        llllllllllllIlIIlIIIIlIllIIIlllI.writeVarIntToBuffer(0);
    }
    
    @Override
    public IBlockState getBlockState(final int llllllllllllIlIIlIIIIlIllIIlIllI) {
        final IBlockState llllllllllllIlIIlIIIIlIllIIlIlll = Block.BLOCK_STATE_IDS.getByValue(llllllllllllIlIIlIIIIlIllIIlIllI);
        return (llllllllllllIlIIlIIIIlIllIIlIlll == null) ? Blocks.AIR.getDefaultState() : llllllllllllIlIIlIIIIlIllIIlIlll;
    }
    
    @Override
    public int idFor(final IBlockState llllllllllllIlIIlIIIIlIllIIlllIl) {
        final int llllllllllllIlIIlIIIIlIllIIllllI = Block.BLOCK_STATE_IDS.get(llllllllllllIlIIlIIIIlIllIIlllIl);
        return (llllllllllllIlIIlIIIIlIllIIllllI == -1) ? 0 : llllllllllllIlIIlIIIIlIllIIllllI;
    }
    
    @Override
    public int getSerializedState() {
        return PacketBuffer.getVarIntSize(0);
    }
}
