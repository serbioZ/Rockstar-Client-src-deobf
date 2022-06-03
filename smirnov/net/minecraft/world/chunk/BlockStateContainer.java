// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.chunk;

import net.minecraft.util.math.MathHelper;
import javax.annotation.Nullable;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.network.PacketBuffer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BitArray;

public class BlockStateContainer implements IBlockStatePaletteResizer
{
    private /* synthetic */ int bits;
    protected /* synthetic */ BitArray storage;
    private static final /* synthetic */ IBlockStatePalette REGISTRY_BASED_PALETTE;
    protected /* synthetic */ IBlockStatePalette palette;
    protected static final /* synthetic */ IBlockState AIR_BLOCK_STATE;
    
    public void read(final PacketBuffer llllllllllllIlIllIIlIllIlIlllIlI) {
        final int llllllllllllIlIllIIlIllIlIllllII = llllllllllllIlIllIIlIllIlIlllIlI.readByte();
        if (this.bits != llllllllllllIlIllIIlIllIlIllllII) {
            this.setBits(llllllllllllIlIllIIlIllIlIllllII);
        }
        this.palette.read(llllllllllllIlIllIIlIllIlIlllIlI);
        llllllllllllIlIllIIlIllIlIlllIlI.readLongArray(this.storage.getBackingLongArray());
    }
    
    static {
        REGISTRY_BASED_PALETTE = new BlockStatePaletteRegistry();
        AIR_BLOCK_STATE = Blocks.AIR.getDefaultState();
    }
    
    protected void set(final int llllllllllllIlIllIIlIllIllIllIIl, final IBlockState llllllllllllIlIllIIlIllIllIllIII) {
        final int llllllllllllIlIllIIlIllIllIllIll = this.palette.idFor(llllllllllllIlIllIIlIllIllIllIII);
        this.storage.setAt(llllllllllllIlIllIIlIllIllIllIIl, llllllllllllIlIllIIlIllIllIllIll);
    }
    
    protected IBlockState get(final int llllllllllllIlIllIIlIllIllIIIIll) {
        final IBlockState llllllllllllIlIllIIlIllIllIIIlIl = this.palette.getBlockState(this.storage.getAt(llllllllllllIlIllIIlIllIllIIIIll));
        return (llllllllllllIlIllIIlIllIllIIIlIl == null) ? BlockStateContainer.AIR_BLOCK_STATE : llllllllllllIlIllIIlIllIllIIIlIl;
    }
    
    private static int getIndex(final int llllllllllllIlIllIIlIlllIIIIllll, final int llllllllllllIlIllIIlIlllIIIIlllI, final int llllllllllllIlIllIIlIlllIIIIllIl) {
        return llllllllllllIlIllIIlIlllIIIIlllI << 8 | llllllllllllIlIllIIlIlllIIIIllIl << 4 | llllllllllllIlIllIIlIlllIIIIllll;
    }
    
    public BlockStateContainer() {
        this.setBits(4);
    }
    
    @Override
    public int onResize(final int llllllllllllIlIllIIlIllIlllllllI, final IBlockState llllllllllllIlIllIIlIllIllllllIl) {
        final BitArray llllllllllllIlIllIIlIllIllllllII = this.storage;
        final IBlockStatePalette llllllllllllIlIllIIlIllIlllllIll = this.palette;
        this.setBits(llllllllllllIlIllIIlIllIlllllllI);
        for (int llllllllllllIlIllIIlIllIlllllIlI = 0; llllllllllllIlIllIIlIllIlllllIlI < llllllllllllIlIllIIlIllIllllllII.size(); ++llllllllllllIlIllIIlIllIlllllIlI) {
            final IBlockState llllllllllllIlIllIIlIllIlllllIIl = llllllllllllIlIllIIlIllIlllllIll.getBlockState(llllllllllllIlIllIIlIllIllllllII.getAt(llllllllllllIlIllIIlIllIlllllIlI));
            if (llllllllllllIlIllIIlIllIlllllIIl != null) {
                this.set(llllllllllllIlIllIIlIllIlllllIlI, llllllllllllIlIllIIlIllIlllllIIl);
            }
        }
        return this.palette.idFor(llllllllllllIlIllIIlIllIllllllIl);
    }
    
    @Nullable
    public NibbleArray getDataForNBT(final byte[] llllllllllllIlIllIIlIllIlIlIlIII, final NibbleArray llllllllllllIlIllIIlIllIlIIllllI) {
        NibbleArray llllllllllllIlIllIIlIllIlIlIIllI = null;
        for (int llllllllllllIlIllIIlIllIlIlIIlIl = 0; llllllllllllIlIllIIlIllIlIlIIlIl < 4096; ++llllllllllllIlIllIIlIllIlIlIIlIl) {
            final int llllllllllllIlIllIIlIllIlIlIIlII = Block.BLOCK_STATE_IDS.get(this.get(llllllllllllIlIllIIlIllIlIlIIlIl));
            final int llllllllllllIlIllIIlIllIlIlIIIll = llllllllllllIlIllIIlIllIlIlIIlIl & 0xF;
            final int llllllllllllIlIllIIlIllIlIlIIIlI = llllllllllllIlIllIIlIllIlIlIIlIl >> 8 & 0xF;
            final int llllllllllllIlIllIIlIllIlIlIIIIl = llllllllllllIlIllIIlIllIlIlIIlIl >> 4 & 0xF;
            if ((llllllllllllIlIllIIlIllIlIlIIlII >> 12 & 0xF) != 0x0) {
                if (llllllllllllIlIllIIlIllIlIlIIllI == null) {
                    llllllllllllIlIllIIlIllIlIlIIllI = new NibbleArray();
                }
                llllllllllllIlIllIIlIllIlIlIIllI.set(llllllllllllIlIllIIlIllIlIlIIIll, llllllllllllIlIllIIlIllIlIlIIIlI, llllllllllllIlIllIIlIllIlIlIIIIl, llllllllllllIlIllIIlIllIlIlIIlII >> 12 & 0xF);
            }
            llllllllllllIlIllIIlIllIlIlIlIII[llllllllllllIlIllIIlIllIlIlIIlIl] = (byte)(llllllllllllIlIllIIlIllIlIlIIlII >> 4 & 0xFF);
            llllllllllllIlIllIIlIllIlIIllllI.set(llllllllllllIlIllIIlIllIlIlIIIll, llllllllllllIlIllIIlIllIlIlIIIlI, llllllllllllIlIllIIlIllIlIlIIIIl, llllllllllllIlIllIIlIllIlIlIIlII & 0xF);
        }
        return llllllllllllIlIllIIlIllIlIlIIllI;
    }
    
    public int getSerializedSize() {
        return 1 + this.palette.getSerializedState() + PacketBuffer.getVarIntSize(this.storage.size()) + this.storage.getBackingLongArray().length * 8;
    }
    
    public void set(final int llllllllllllIlIllIIlIllIlllIIllI, final int llllllllllllIlIllIIlIllIlllIlIlI, final int llllllllllllIlIllIIlIllIlllIIlII, final IBlockState llllllllllllIlIllIIlIllIlllIlIII) {
        this.set(getIndex(llllllllllllIlIllIIlIllIlllIIllI, llllllllllllIlIllIIlIllIlllIlIlI, llllllllllllIlIllIIlIllIlllIIlII), llllllllllllIlIllIIlIllIlllIlIII);
    }
    
    public IBlockState get(final int llllllllllllIlIllIIlIllIllIlIIIl, final int llllllllllllIlIllIIlIllIllIIllII, final int llllllllllllIlIllIIlIllIllIIllll) {
        return this.get(getIndex(llllllllllllIlIllIIlIllIllIlIIIl, llllllllllllIlIllIIlIllIllIIllII, llllllllllllIlIllIIlIllIllIIllll));
    }
    
    public void write(final PacketBuffer llllllllllllIlIllIIlIllIlIllIlIl) {
        llllllllllllIlIllIIlIllIlIllIlIl.writeByte(this.bits);
        this.palette.write(llllllllllllIlIllIIlIllIlIllIlIl);
        llllllllllllIlIllIIlIllIlIllIlIl.writeLongArray(this.storage.getBackingLongArray());
    }
    
    private void setBits(final int llllllllllllIlIllIIlIlllIIIIlIIl) {
        if (llllllllllllIlIllIIlIlllIIIIlIIl != this.bits) {
            this.bits = llllllllllllIlIllIIlIlllIIIIlIIl;
            if (this.bits <= 4) {
                this.bits = 4;
                this.palette = new BlockStatePaletteLinear(this.bits, this);
            }
            else if (this.bits <= 8) {
                this.palette = new BlockStatePaletteHashMap(this.bits, this);
            }
            else {
                this.palette = BlockStateContainer.REGISTRY_BASED_PALETTE;
                this.bits = MathHelper.log2DeBruijn(Block.BLOCK_STATE_IDS.size());
            }
            this.palette.idFor(BlockStateContainer.AIR_BLOCK_STATE);
            this.storage = new BitArray(this.bits, 4096);
        }
    }
    
    public void setDataFromNBT(final byte[] llllllllllllIlIllIIlIllIlIIIllII, final NibbleArray llllllllllllIlIllIIlIllIlIIIIIIl, @Nullable final NibbleArray llllllllllllIlIllIIlIllIlIIIlIlI) {
        for (int llllllllllllIlIllIIlIllIlIIIlIIl = 0; llllllllllllIlIllIIlIllIlIIIlIIl < 4096; ++llllllllllllIlIllIIlIllIlIIIlIIl) {
            final int llllllllllllIlIllIIlIllIlIIIlIII = llllllllllllIlIllIIlIllIlIIIlIIl & 0xF;
            final int llllllllllllIlIllIIlIllIlIIIIlll = llllllllllllIlIllIIlIllIlIIIlIIl >> 8 & 0xF;
            final int llllllllllllIlIllIIlIllIlIIIIllI = llllllllllllIlIllIIlIllIlIIIlIIl >> 4 & 0xF;
            final int llllllllllllIlIllIIlIllIlIIIIlIl = (llllllllllllIlIllIIlIllIlIIIlIlI == null) ? 0 : llllllllllllIlIllIIlIllIlIIIlIlI.get(llllllllllllIlIllIIlIllIlIIIlIII, llllllllllllIlIllIIlIllIlIIIIlll, llllllllllllIlIllIIlIllIlIIIIllI);
            final int llllllllllllIlIllIIlIllIlIIIIlII = llllllllllllIlIllIIlIllIlIIIIlIl << 12 | (llllllllllllIlIllIIlIllIlIIIllII[llllllllllllIlIllIIlIllIlIIIlIIl] & 0xFF) << 4 | llllllllllllIlIllIIlIllIlIIIIIIl.get(llllllllllllIlIllIIlIllIlIIIlIII, llllllllllllIlIllIIlIllIlIIIIlll, llllllllllllIlIllIIlIllIlIIIIllI);
            this.set(llllllllllllIlIllIIlIllIlIIIlIIl, Block.BLOCK_STATE_IDS.getByValue(llllllllllllIlIllIIlIllIlIIIIlII));
        }
    }
}
