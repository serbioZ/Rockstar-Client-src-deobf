// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.chunk;

import javax.annotation.Nullable;
import net.minecraft.block.Block;
import net.minecraft.network.PacketBuffer;
import net.minecraft.block.state.IBlockState;

public class BlockStatePaletteLinear implements IBlockStatePalette
{
    private final /* synthetic */ IBlockStatePaletteResizer resizeHandler;
    private final /* synthetic */ IBlockState[] states;
    private final /* synthetic */ int bits;
    private /* synthetic */ int arraySize;
    
    @Override
    public void write(final PacketBuffer llllllllllIlllIIIllIIlllIIlIlIII) {
        llllllllllIlllIIIllIIlllIIlIlIII.writeVarIntToBuffer(this.arraySize);
        for (int llllllllllIlllIIIllIIlllIIlIIlll = 0; llllllllllIlllIIIllIIlllIIlIIlll < this.arraySize; ++llllllllllIlllIIIllIIlllIIlIIlll) {
            llllllllllIlllIIIllIIlllIIlIlIII.writeVarIntToBuffer(Block.BLOCK_STATE_IDS.get(this.states[llllllllllIlllIIIllIIlllIIlIIlll]));
        }
    }
    
    @Override
    public int getSerializedState() {
        int llllllllllIlllIIIllIIlllIIIlllll = PacketBuffer.getVarIntSize(this.arraySize);
        for (int llllllllllIlllIIIllIIlllIIIllllI = 0; llllllllllIlllIIIllIIlllIIIllllI < this.arraySize; ++llllllllllIlllIIIllIIlllIIIllllI) {
            llllllllllIlllIIIllIIlllIIIlllll += PacketBuffer.getVarIntSize(Block.BLOCK_STATE_IDS.get(this.states[llllllllllIlllIIIllIIlllIIIllllI]));
        }
        return llllllllllIlllIIIllIIlllIIIlllll;
    }
    
    public BlockStatePaletteLinear(final int llllllllllIlllIIIllIIlllIlIIIlll, final IBlockStatePaletteResizer llllllllllIlllIIIllIIlllIlIIIllI) {
        this.states = new IBlockState[1 << llllllllllIlllIIIllIIlllIlIIIlll];
        this.bits = llllllllllIlllIIIllIIlllIlIIIlll;
        this.resizeHandler = llllllllllIlllIIIllIIlllIlIIIllI;
    }
    
    @Nullable
    @Override
    public IBlockState getBlockState(final int llllllllllIlllIIIllIIlllIIlllIII) {
        return (llllllllllIlllIIIllIIlllIIlllIII >= 0 && llllllllllIlllIIIllIIlllIIlllIII < this.arraySize) ? this.states[llllllllllIlllIIIllIIlllIIlllIII] : null;
    }
    
    @Override
    public int idFor(final IBlockState llllllllllIlllIIIllIIlllIIllllIl) {
        for (int llllllllllIlllIIIllIIlllIlIIIIII = 0; llllllllllIlllIIIllIIlllIlIIIIII < this.arraySize; ++llllllllllIlllIIIllIIlllIlIIIIII) {
            if (this.states[llllllllllIlllIIIllIIlllIlIIIIII] == llllllllllIlllIIIllIIlllIIllllIl) {
                return llllllllllIlllIIIllIIlllIlIIIIII;
            }
        }
        final int llllllllllIlllIIIllIIlllIIllllll = this.arraySize;
        if (llllllllllIlllIIIllIIlllIIllllll < this.states.length) {
            this.states[llllllllllIlllIIIllIIlllIIllllll] = llllllllllIlllIIIllIIlllIIllllIl;
            ++this.arraySize;
            return llllllllllIlllIIIllIIlllIIllllll;
        }
        return this.resizeHandler.onResize(this.bits + 1, llllllllllIlllIIIllIIlllIIllllIl);
    }
    
    @Override
    public void read(final PacketBuffer llllllllllIlllIIIllIIlllIIlIlllI) {
        this.arraySize = llllllllllIlllIIIllIIlllIIlIlllI.readVarIntFromBuffer();
        for (int llllllllllIlllIIIllIIlllIIllIIII = 0; llllllllllIlllIIIllIIlllIIllIIII < this.arraySize; ++llllllllllIlllIIIllIIlllIIllIIII) {
            this.states[llllllllllIlllIIIllIIlllIIllIIII] = Block.BLOCK_STATE_IDS.getByValue(llllllllllIlllIIIllIIlllIIlIlllI.readVarIntFromBuffer());
        }
    }
}
