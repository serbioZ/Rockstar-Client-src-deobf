// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.chunk.storage;

import optifine.Reflector;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.chunk.BlockStateContainer;
import net.minecraft.world.chunk.NibbleArray;

public class ExtendedBlockStorage
{
    private /* synthetic */ NibbleArray blocklightArray;
    private /* synthetic */ NibbleArray skylightArray;
    private final /* synthetic */ BlockStateContainer data;
    private /* synthetic */ int tickRefCount;
    private final /* synthetic */ int yBase;
    private /* synthetic */ int blockRefCount;
    
    public int getYLocation() {
        return this.yBase;
    }
    
    public int getExtSkylightValue(final int lllllllllllllIIlIllIlllIIIllllll, final int lllllllllllllIIlIllIlllIIIlllllI, final int lllllllllllllIIlIllIlllIIlIIIIIl) {
        return this.skylightArray.get(lllllllllllllIIlIllIlllIIIllllll, lllllllllllllIIlIllIlllIIIlllllI, lllllllllllllIIlIllIlllIIlIIIIIl);
    }
    
    public ExtendedBlockStorage(final int lllllllllllllIIlIllIlllIlIIIlIIl, final boolean lllllllllllllIIlIllIlllIlIIIlIII) {
        this.yBase = lllllllllllllIIlIllIlllIlIIIlIIl;
        this.data = new BlockStateContainer();
        this.blocklightArray = new NibbleArray();
        if (lllllllllllllIIlIllIlllIlIIIlIII) {
            this.skylightArray = new NibbleArray();
        }
    }
    
    public boolean isEmpty() {
        return this.blockRefCount == 0;
    }
    
    public void removeInvalidBlocks() {
        final IBlockState lllllllllllllIIlIllIlllIIIIlIlll = Blocks.AIR.getDefaultState();
        int lllllllllllllIIlIllIlllIIIIlIllI = 0;
        int lllllllllllllIIlIllIlllIIIIlIlIl = 0;
        for (int lllllllllllllIIlIllIlllIIIIlIlII = 0; lllllllllllllIIlIllIlllIIIIlIlII < 16; ++lllllllllllllIIlIllIlllIIIIlIlII) {
            for (int lllllllllllllIIlIllIlllIIIIlIIll = 0; lllllllllllllIIlIllIlllIIIIlIIll < 16; ++lllllllllllllIIlIllIlllIIIIlIIll) {
                for (int lllllllllllllIIlIllIlllIIIIlIIlI = 0; lllllllllllllIIlIllIlllIIIIlIIlI < 16; ++lllllllllllllIIlIllIlllIIIIlIIlI) {
                    final IBlockState lllllllllllllIIlIllIlllIIIIlIIIl = this.data.get(lllllllllllllIIlIllIlllIIIIlIIlI, lllllllllllllIIlIllIlllIIIIlIlII, lllllllllllllIIlIllIlllIIIIlIIll);
                    if (lllllllllllllIIlIllIlllIIIIlIIIl != lllllllllllllIIlIllIlllIIIIlIlll) {
                        ++lllllllllllllIIlIllIlllIIIIlIllI;
                        final Block lllllllllllllIIlIllIlllIIIIlIIII = lllllllllllllIIlIllIlllIIIIlIIIl.getBlock();
                        if (lllllllllllllIIlIllIlllIIIIlIIII.getTickRandomly()) {
                            ++lllllllllllllIIlIllIlllIIIIlIlIl;
                        }
                    }
                }
            }
        }
        this.blockRefCount = lllllllllllllIIlIllIlllIIIIlIllI;
        this.tickRefCount = lllllllllllllIIlIllIlllIIIIlIlIl;
    }
    
    public void setExtBlocklightValue(final int lllllllllllllIIlIllIlllIIIllIIIl, final int lllllllllllllIIlIllIlllIIIllIIII, final int lllllllllllllIIlIllIlllIIIllIlII, final int lllllllllllllIIlIllIlllIIIlIlllI) {
        this.blocklightArray.set(lllllllllllllIIlIllIlllIIIllIIIl, lllllllllllllIIlIllIlllIIIllIIII, lllllllllllllIIlIllIlllIIIllIlII, lllllllllllllIIlIllIlllIIIlIlllI);
    }
    
    public void setSkylightArray(final NibbleArray lllllllllllllIIlIllIllIlllllIlII) {
        this.skylightArray = lllllllllllllIIlIllIllIlllllIlII;
    }
    
    public boolean getNeedsRandomTick() {
        return this.tickRefCount > 0;
    }
    
    public void set(final int lllllllllllllIIlIllIlllIIllIIlll, final int lllllllllllllIIlIllIlllIIllIIllI, final int lllllllllllllIIlIllIlllIIllIIlIl, IBlockState lllllllllllllIIlIllIlllIIllIIlII) {
        if (Reflector.IExtendedBlockState.isInstance(lllllllllllllIIlIllIlllIIllIIlII)) {
            lllllllllllllIIlIllIlllIIllIIlII = Reflector.call(lllllllllllllIIlIllIlllIIllIIlII, Reflector.IExtendedBlockState_getClean, new Object[0]);
        }
        final IBlockState lllllllllllllIIlIllIlllIIllIlIll = this.get(lllllllllllllIIlIllIlllIIllIIlll, lllllllllllllIIlIllIlllIIllIIllI, lllllllllllllIIlIllIlllIIllIIlIl);
        final Block lllllllllllllIIlIllIlllIIllIlIlI = lllllllllllllIIlIllIlllIIllIlIll.getBlock();
        final Block lllllllllllllIIlIllIlllIIllIlIIl = ((IBlockState)lllllllllllllIIlIllIlllIIllIIlII).getBlock();
        if (lllllllllllllIIlIllIlllIIllIlIlI != Blocks.AIR) {
            --this.blockRefCount;
            if (lllllllllllllIIlIllIlllIIllIlIlI.getTickRandomly()) {
                --this.tickRefCount;
            }
        }
        if (lllllllllllllIIlIllIlllIIllIlIIl != Blocks.AIR) {
            ++this.blockRefCount;
            if (lllllllllllllIIlIllIlllIIllIlIIl.getTickRandomly()) {
                ++this.tickRefCount;
            }
        }
        this.data.set(lllllllllllllIIlIllIlllIIllIIlll, lllllllllllllIIlIllIlllIIllIIllI, lllllllllllllIIlIllIlllIIllIIlIl, (IBlockState)lllllllllllllIIlIllIlllIIllIIlII);
    }
    
    public IBlockState get(final int lllllllllllllIIlIllIlllIIllllIll, final int lllllllllllllIIlIllIlllIIllllllI, final int lllllllllllllIIlIllIlllIIlllllIl) {
        return this.data.get(lllllllllllllIIlIllIlllIIllllIll, lllllllllllllIIlIllIlllIIllllllI, lllllllllllllIIlIllIlllIIlllllIl);
    }
    
    public void setExtSkylightValue(final int lllllllllllllIIlIllIlllIIlIIllII, final int lllllllllllllIIlIllIlllIIlIlIIII, final int lllllllllllllIIlIllIlllIIlIIlIlI, final int lllllllllllllIIlIllIlllIIlIIlIIl) {
        this.skylightArray.set(lllllllllllllIIlIllIlllIIlIIllII, lllllllllllllIIlIllIlllIIlIlIIII, lllllllllllllIIlIllIlllIIlIIlIlI, lllllllllllllIIlIllIlllIIlIIlIIl);
    }
    
    public BlockStateContainer getData() {
        return this.data;
    }
    
    public void setBlocklightArray(final NibbleArray lllllllllllllIIlIllIllIllllllIII) {
        this.blocklightArray = lllllllllllllIIlIllIllIllllllIII;
    }
    
    public NibbleArray getSkylightArray() {
        return this.skylightArray;
    }
    
    public int getExtBlocklightValue(final int lllllllllllllIIlIllIlllIIIlIIlII, final int lllllllllllllIIlIllIlllIIIlIIlll, final int lllllllllllllIIlIllIlllIIIlIIllI) {
        return this.blocklightArray.get(lllllllllllllIIlIllIlllIIIlIIlII, lllllllllllllIIlIllIlllIIIlIIlll, lllllllllllllIIlIllIlllIIIlIIllI);
    }
    
    public NibbleArray getBlocklightArray() {
        return this.blocklightArray;
    }
}
