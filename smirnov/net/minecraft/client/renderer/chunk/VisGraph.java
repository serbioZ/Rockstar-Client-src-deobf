// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.chunk;

import net.minecraft.util.IntegerCache;
import java.util.ArrayDeque;
import java.util.EnumSet;
import java.util.Set;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumFacing;
import java.util.BitSet;

public class VisGraph
{
    private static final /* synthetic */ int DY;
    private static final /* synthetic */ int DZ;
    private final /* synthetic */ BitSet bitSet;
    private /* synthetic */ int empty;
    private static final /* synthetic */ int DX;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing;
    private static final /* synthetic */ int[] INDEX_OF_EDGES;
    
    private int getNeighborIndexAtFace(final int llllllllllllIlIllllIlIIIllIIlllI, final EnumFacing llllllllllllIlIllllIlIIIllIIllIl) {
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[llllllllllllIlIllllIlIIIllIIllIl.ordinal()]) {
            case 1: {
                if ((llllllllllllIlIllllIlIIIllIIlllI >> 8 & 0xF) == 0x0) {
                    return -1;
                }
                return llllllllllllIlIllllIlIIIllIIlllI - VisGraph.DY;
            }
            case 2: {
                if ((llllllllllllIlIllllIlIIIllIIlllI >> 8 & 0xF) == 0xF) {
                    return -1;
                }
                return llllllllllllIlIllllIlIIIllIIlllI + VisGraph.DY;
            }
            case 3: {
                if ((llllllllllllIlIllllIlIIIllIIlllI >> 4 & 0xF) == 0x0) {
                    return -1;
                }
                return llllllllllllIlIllllIlIIIllIIlllI - VisGraph.DZ;
            }
            case 4: {
                if ((llllllllllllIlIllllIlIIIllIIlllI >> 4 & 0xF) == 0xF) {
                    return -1;
                }
                return llllllllllllIlIllllIlIIIllIIlllI + VisGraph.DZ;
            }
            case 5: {
                if ((llllllllllllIlIllllIlIIIllIIlllI >> 0 & 0xF) == 0x0) {
                    return -1;
                }
                return llllllllllllIlIllllIlIIIllIIlllI - VisGraph.DX;
            }
            case 6: {
                if ((llllllllllllIlIllllIlIIIllIIlllI >> 0 & 0xF) == 0xF) {
                    return -1;
                }
                return llllllllllllIlIllllIlIIIllIIlllI + VisGraph.DX;
            }
            default: {
                return -1;
            }
        }
    }
    
    public SetVisibility computeVisibility() {
        final SetVisibility llllllllllllIlIllllIlIIlIIIIlIlI = new SetVisibility();
        if (4096 - this.empty < 256) {
            llllllllllllIlIllllIlIIlIIIIlIlI.setAllVisible(true);
        }
        else if (this.empty == 0) {
            llllllllllllIlIllllIlIIlIIIIlIlI.setAllVisible(false);
        }
        else {
            final long llllllllllllIlIllllIlIIlIIIIIIll;
            final long llllllllllllIlIllllIlIIlIIIIIlII = ((int[])(Object)(llllllllllllIlIllllIlIIlIIIIIIll = (long)(Object)VisGraph.INDEX_OF_EDGES)).length;
            for (Exception llllllllllllIlIllllIlIIlIIIIIlIl = (Exception)0; llllllllllllIlIllllIlIIlIIIIIlIl < llllllllllllIlIllllIlIIlIIIIIlII; ++llllllllllllIlIllllIlIIlIIIIIlIl) {
                final int llllllllllllIlIllllIlIIlIIIIlIIl = llllllllllllIlIllllIlIIlIIIIIIll[llllllllllllIlIllllIlIIlIIIIIlIl];
                if (!this.bitSet.get(llllllllllllIlIllllIlIIlIIIIlIIl)) {
                    llllllllllllIlIllllIlIIlIIIIlIlI.setManyVisible(this.floodFill(llllllllllllIlIllllIlIIlIIIIlIIl));
                }
            }
        }
        return llllllllllllIlIllllIlIIlIIIIlIlI;
    }
    
    public void setOpaqueCube(final BlockPos llllllllllllIlIllllIlIIlIIlIIIII) {
        this.bitSet.set(getIndex(llllllllllllIlIllllIlIIlIIlIIIII), true);
        --this.empty;
    }
    
    private Set<EnumFacing> floodFill(final int llllllllllllIlIllllIlIIIllllIIIl) {
        final Set<EnumFacing> llllllllllllIlIllllIlIIIllllIIII = EnumSet.noneOf(EnumFacing.class);
        final ArrayDeque llllllllllllIlIllllIlIIIlllIllll = new ArrayDeque(384);
        llllllllllllIlIllllIlIIIlllIllll.add(IntegerCache.getInteger(llllllllllllIlIllllIlIIIllllIIIl));
        this.bitSet.set(llllllllllllIlIllllIlIIIllllIIIl, true);
        while (!llllllllllllIlIllllIlIIIlllIllll.isEmpty()) {
            final int llllllllllllIlIllllIlIIIlllIlllI = llllllllllllIlIllllIlIIIlllIllll.poll();
            this.addEdges(llllllllllllIlIllllIlIIIlllIlllI, llllllllllllIlIllllIlIIIllllIIII);
            final char llllllllllllIlIllllIlIIIlllIIIll;
            final short llllllllllllIlIllllIlIIIlllIIlII = (short)((EnumFacing[])(Object)(llllllllllllIlIllllIlIIIlllIIIll = (char)(Object)EnumFacing.VALUES)).length;
            for (double llllllllllllIlIllllIlIIIlllIIlIl = 0; llllllllllllIlIllllIlIIIlllIIlIl < llllllllllllIlIllllIlIIIlllIIlII; ++llllllllllllIlIllllIlIIIlllIIlIl) {
                final EnumFacing llllllllllllIlIllllIlIIIlllIllIl = llllllllllllIlIllllIlIIIlllIIIll[llllllllllllIlIllllIlIIIlllIIlIl];
                final int llllllllllllIlIllllIlIIIlllIllII = this.getNeighborIndexAtFace(llllllllllllIlIllllIlIIIlllIlllI, llllllllllllIlIllllIlIIIlllIllIl);
                if (llllllllllllIlIllllIlIIIlllIllII >= 0 && !this.bitSet.get(llllllllllllIlIllllIlIIIlllIllII)) {
                    this.bitSet.set(llllllllllllIlIllllIlIIIlllIllII, true);
                    llllllllllllIlIllllIlIIIlllIllll.add(IntegerCache.getInteger(llllllllllllIlIllllIlIIIlllIllII));
                }
            }
        }
        return llllllllllllIlIllllIlIIIllllIIII;
    }
    
    private static int getIndex(final int llllllllllllIlIllllIlIIlIIIlIlll, final int llllllllllllIlIllllIlIIlIIIlIllI, final int llllllllllllIlIllllIlIIlIIIlIlIl) {
        return llllllllllllIlIllllIlIIlIIIlIlll << 0 | llllllllllllIlIllllIlIIlIIIlIllI << 8 | llllllllllllIlIllllIlIIlIIIlIlIl << 4;
    }
    
    public VisGraph() {
        this.bitSet = new BitSet(4096);
        this.empty = 4096;
    }
    
    static {
        DX = (int)Math.pow(16.0, 0.0);
        DZ = (int)Math.pow(16.0, 1.0);
        DY = (int)Math.pow(16.0, 2.0);
        INDEX_OF_EDGES = new int[1352];
        final int llllllllllllIlIllllIlIIlIIllIIlI = 0;
        final int llllllllllllIlIllllIlIIlIIllIIIl = 15;
        int llllllllllllIlIllllIlIIlIIllIIII = 0;
        for (int llllllllllllIlIllllIlIIlIIlIllll = 0; llllllllllllIlIllllIlIIlIIlIllll < 16; ++llllllllllllIlIllllIlIIlIIlIllll) {
            for (int llllllllllllIlIllllIlIIlIIlIlllI = 0; llllllllllllIlIllllIlIIlIIlIlllI < 16; ++llllllllllllIlIllllIlIIlIIlIlllI) {
                for (int llllllllllllIlIllllIlIIlIIlIllIl = 0; llllllllllllIlIllllIlIIlIIlIllIl < 16; ++llllllllllllIlIllllIlIIlIIlIllIl) {
                    if (llllllllllllIlIllllIlIIlIIlIllll == 0 || llllllllllllIlIllllIlIIlIIlIllll == 15 || llllllllllllIlIllllIlIIlIIlIlllI == 0 || llllllllllllIlIllllIlIIlIIlIlllI == 15 || llllllllllllIlIllllIlIIlIIlIllIl == 0 || llllllllllllIlIllllIlIIlIIlIllIl == 15) {
                        VisGraph.INDEX_OF_EDGES[llllllllllllIlIllllIlIIlIIllIIII++] = getIndex(llllllllllllIlIllllIlIIlIIlIllll, llllllllllllIlIllllIlIIlIIlIlllI, llllllllllllIlIllllIlIIlIIlIllIl);
                    }
                }
            }
        }
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = VisGraph.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final short llllllllllllIlIllllIlIIIllIIlIIl = (Object)new int[EnumFacing.values().length];
        try {
            llllllllllllIlIllllIlIIIllIIlIIl[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllIlIllllIlIIIllIIlIIl[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllIlIllllIlIIIllIIlIIl[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllIlIllllIlIIIllIIlIIl[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            llllllllllllIlIllllIlIIIllIIlIIl[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            llllllllllllIlIllllIlIIIllIIlIIl[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return VisGraph.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)llllllllllllIlIllllIlIIIllIIlIIl;
    }
    
    public Set<EnumFacing> getVisibleFacings(final BlockPos llllllllllllIlIllllIlIIIllllllIl) {
        return this.floodFill(getIndex(llllllllllllIlIllllIlIIIllllllIl));
    }
    
    private static int getIndex(final BlockPos llllllllllllIlIllllIlIIlIIIlllII) {
        return getIndex(llllllllllllIlIllllIlIIlIIIlllII.getX() & 0xF, llllllllllllIlIllllIlIIlIIIlllII.getY() & 0xF, llllllllllllIlIllllIlIIlIIIlllII.getZ() & 0xF);
    }
    
    private void addEdges(final int llllllllllllIlIllllIlIIIllIlIllI, final Set<EnumFacing> llllllllllllIlIllllIlIIIllIlIlIl) {
        final int llllllllllllIlIllllIlIIIllIllIIl = llllllllllllIlIllllIlIIIllIlIllI >> 0 & 0xF;
        if (llllllllllllIlIllllIlIIIllIllIIl == 0) {
            llllllllllllIlIllllIlIIIllIlIlIl.add(EnumFacing.WEST);
        }
        else if (llllllllllllIlIllllIlIIIllIllIIl == 15) {
            llllllllllllIlIllllIlIIIllIlIlIl.add(EnumFacing.EAST);
        }
        final int llllllllllllIlIllllIlIIIllIllIII = llllllllllllIlIllllIlIIIllIlIllI >> 8 & 0xF;
        if (llllllllllllIlIllllIlIIIllIllIII == 0) {
            llllllllllllIlIllllIlIIIllIlIlIl.add(EnumFacing.DOWN);
        }
        else if (llllllllllllIlIllllIlIIIllIllIII == 15) {
            llllllllllllIlIllllIlIIIllIlIlIl.add(EnumFacing.UP);
        }
        final int llllllllllllIlIllllIlIIIllIlIlll = llllllllllllIlIllllIlIIIllIlIllI >> 4 & 0xF;
        if (llllllllllllIlIllllIlIIIllIlIlll == 0) {
            llllllllllllIlIllllIlIIIllIlIlIl.add(EnumFacing.NORTH);
        }
        else if (llllllllllllIlIllllIlIIIllIlIlll == 15) {
            llllllllllllIlIllllIlIIIllIlIlIl.add(EnumFacing.SOUTH);
        }
    }
}
