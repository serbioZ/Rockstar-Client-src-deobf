// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.chunk;

import net.minecraft.init.Blocks;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;

public class ChunkPrimer
{
    private static final /* synthetic */ IBlockState DEFAULT_STATE;
    private final /* synthetic */ char[] data;
    
    public int findGroundBlockIdx(final int llllllllllllIIIIlIlIlllIIlIlIlII, final int llllllllllllIIIIlIlIlllIIlIlIIll) {
        final int llllllllllllIIIIlIlIlllIIlIllIII = (llllllllllllIIIIlIlIlllIIlIlIlII << 12 | llllllllllllIIIIlIlIlllIIlIlIIll << 8) + 256 - 1;
        for (int llllllllllllIIIIlIlIlllIIlIlIlll = 255; llllllllllllIIIIlIlIlllIIlIlIlll >= 0; --llllllllllllIIIIlIlIlllIIlIlIlll) {
            final IBlockState llllllllllllIIIIlIlIlllIIlIlIllI = Block.BLOCK_STATE_IDS.getByValue(this.data[llllllllllllIIIIlIlIlllIIlIllIII + llllllllllllIIIIlIlIlllIIlIlIlll]);
            if (llllllllllllIIIIlIlIlllIIlIlIllI != null && llllllllllllIIIIlIlIlllIIlIlIllI != ChunkPrimer.DEFAULT_STATE) {
                return llllllllllllIIIIlIlIlllIIlIlIlll;
            }
        }
        return 0;
    }
    
    static {
        DEFAULT_STATE = Blocks.AIR.getDefaultState();
    }
    
    public void setBlockState(final int llllllllllllIIIIlIlIlllIIllIlllI, final int llllllllllllIIIIlIlIlllIIlllIIlI, final int llllllllllllIIIIlIlIlllIIlllIIIl, final IBlockState llllllllllllIIIIlIlIlllIIllIlIll) {
        this.data[getBlockIndex(llllllllllllIIIIlIlIlllIIllIlllI, llllllllllllIIIIlIlIlllIIlllIIlI, llllllllllllIIIIlIlIlllIIlllIIIl)] = (char)Block.BLOCK_STATE_IDS.get(llllllllllllIIIIlIlIlllIIllIlIll);
    }
    
    private static int getBlockIndex(final int llllllllllllIIIIlIlIlllIIllIIlII, final int llllllllllllIIIIlIlIlllIIllIIllI, final int llllllllllllIIIIlIlIlllIIllIIlIl) {
        return llllllllllllIIIIlIlIlllIIllIIlII << 12 | llllllllllllIIIIlIlIlllIIllIIlIl << 8 | llllllllllllIIIIlIlIlllIIllIIllI;
    }
    
    public IBlockState getBlockState(final int llllllllllllIIIIlIlIlllIIlllllIl, final int llllllllllllIIIIlIlIlllIIlllllII, final int llllllllllllIIIIlIlIlllIIllllIll) {
        final IBlockState llllllllllllIIIIlIlIlllIIlllllll = Block.BLOCK_STATE_IDS.getByValue(this.data[getBlockIndex(llllllllllllIIIIlIlIlllIIlllllIl, llllllllllllIIIIlIlIlllIIlllllII, llllllllllllIIIIlIlIlllIIllllIll)]);
        return (llllllllllllIIIIlIlIlllIIlllllll == null) ? ChunkPrimer.DEFAULT_STATE : llllllllllllIIIIlIlIlllIIlllllll;
    }
    
    public ChunkPrimer() {
        this.data = new char[65536];
    }
}
