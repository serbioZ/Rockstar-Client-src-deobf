// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.chunk;

import javax.annotation.Nullable;
import net.minecraft.block.Block;
import net.minecraft.network.PacketBuffer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.IntIdentityHashBiMap;

public class BlockStatePaletteHashMap implements IBlockStatePalette
{
    private final /* synthetic */ IBlockStatePaletteResizer paletteResizer;
    private final /* synthetic */ int bits;
    private final /* synthetic */ IntIdentityHashBiMap<IBlockState> statePaletteMap;
    
    @Override
    public void read(final PacketBuffer lllllllllllIllIlIIIlIllIllIIlllI) {
        this.statePaletteMap.clear();
        for (int lllllllllllIllIlIIIlIllIllIlIIIl = lllllllllllIllIlIIIlIllIllIIlllI.readVarIntFromBuffer(), lllllllllllIllIlIIIlIllIllIlIIII = 0; lllllllllllIllIlIIIlIllIllIlIIII < lllllllllllIllIlIIIlIllIllIlIIIl; ++lllllllllllIllIlIIIlIllIllIlIIII) {
            this.statePaletteMap.add(Block.BLOCK_STATE_IDS.getByValue(lllllllllllIllIlIIIlIllIllIIlllI.readVarIntFromBuffer()));
        }
    }
    
    @Override
    public void write(final PacketBuffer lllllllllllIllIlIIIlIllIllIIIIlI) {
        final int lllllllllllIllIlIIIlIllIllIIIlIl = this.statePaletteMap.size();
        lllllllllllIllIlIIIlIllIllIIIIlI.writeVarIntToBuffer(lllllllllllIllIlIIIlIllIllIIIlIl);
        for (int lllllllllllIllIlIIIlIllIllIIIlII = 0; lllllllllllIllIlIIIlIllIllIIIlII < lllllllllllIllIlIIIlIllIllIIIlIl; ++lllllllllllIllIlIIIlIllIllIIIlII) {
            lllllllllllIllIlIIIlIllIllIIIIlI.writeVarIntToBuffer(Block.BLOCK_STATE_IDS.get(this.statePaletteMap.get(lllllllllllIllIlIIIlIllIllIIIlII)));
        }
    }
    
    @Nullable
    @Override
    public IBlockState getBlockState(final int lllllllllllIllIlIIIlIllIllIllIlI) {
        return this.statePaletteMap.get(lllllllllllIllIlIIIlIllIllIllIlI);
    }
    
    public BlockStatePaletteHashMap(final int lllllllllllIllIlIIIlIllIlllIlIll, final IBlockStatePaletteResizer lllllllllllIllIlIIIlIllIlllIIlll) {
        this.bits = lllllllllllIllIlIIIlIllIlllIlIll;
        this.paletteResizer = lllllllllllIllIlIIIlIllIlllIIlll;
        this.statePaletteMap = new IntIdentityHashBiMap<IBlockState>(1 << lllllllllllIllIlIIIlIllIlllIlIll);
    }
    
    @Override
    public int getSerializedState() {
        int lllllllllllIllIlIIIlIllIlIlllIll = PacketBuffer.getVarIntSize(this.statePaletteMap.size());
        for (int lllllllllllIllIlIIIlIllIlIlllIlI = 0; lllllllllllIllIlIIIlIllIlIlllIlI < this.statePaletteMap.size(); ++lllllllllllIllIlIIIlIllIlIlllIlI) {
            lllllllllllIllIlIIIlIllIlIlllIll += PacketBuffer.getVarIntSize(Block.BLOCK_STATE_IDS.get(this.statePaletteMap.get(lllllllllllIllIlIIIlIllIlIlllIlI)));
        }
        return lllllllllllIllIlIIIlIllIlIlllIll;
    }
    
    @Override
    public int idFor(final IBlockState lllllllllllIllIlIIIlIllIlllIIIlI) {
        int lllllllllllIllIlIIIlIllIlllIIIIl = this.statePaletteMap.getId(lllllllllllIllIlIIIlIllIlllIIIlI);
        if (lllllllllllIllIlIIIlIllIlllIIIIl == -1) {
            lllllllllllIllIlIIIlIllIlllIIIIl = this.statePaletteMap.add(lllllllllllIllIlIIIlIllIlllIIIlI);
            if (lllllllllllIllIlIIIlIllIlllIIIIl >= 1 << this.bits) {
                lllllllllllIllIlIIIlIllIlllIIIIl = this.paletteResizer.onResize(this.bits + 1, lllllllllllIllIlIIIlIllIlllIIIlI);
            }
        }
        return lllllllllllIllIlIIIlIllIlllIIIIl;
    }
}
