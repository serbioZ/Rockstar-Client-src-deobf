// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block.state.pattern;

import com.google.common.base.MoreObjects;
import net.minecraft.util.math.Vec3i;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.CacheBuilder;
import net.minecraft.world.World;
import javax.annotation.Nullable;
import com.google.common.cache.LoadingCache;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.state.BlockWorldState;
import com.google.common.base.Predicate;

public class BlockPattern
{
    private final /* synthetic */ int palmLength;
    private final /* synthetic */ int fingerLength;
    private final /* synthetic */ Predicate<BlockWorldState>[][][] blockMatches;
    private final /* synthetic */ int thumbLength;
    
    public int getPalmLength() {
        return this.palmLength;
    }
    
    @Nullable
    private PatternHelper checkPatternAt(final BlockPos lllllllllllIIlIIIIlIlIIIlllIIllI, final EnumFacing lllllllllllIIlIIIIlIlIIIlllIIlIl, final EnumFacing lllllllllllIIlIIIIlIlIIIlllIIlII, final LoadingCache<BlockPos, BlockWorldState> lllllllllllIIlIIIIlIlIIIllIllIll) {
        for (int lllllllllllIIlIIIIlIlIIIlllIIIlI = 0; lllllllllllIIlIIIIlIlIIIlllIIIlI < this.palmLength; ++lllllllllllIIlIIIIlIlIIIlllIIIlI) {
            for (int lllllllllllIIlIIIIlIlIIIlllIIIIl = 0; lllllllllllIIlIIIIlIlIIIlllIIIIl < this.thumbLength; ++lllllllllllIIlIIIIlIlIIIlllIIIIl) {
                for (int lllllllllllIIlIIIIlIlIIIlllIIIII = 0; lllllllllllIIlIIIIlIlIIIlllIIIII < this.fingerLength; ++lllllllllllIIlIIIIlIlIIIlllIIIII) {
                    if (!this.blockMatches[lllllllllllIIlIIIIlIlIIIlllIIIII][lllllllllllIIlIIIIlIlIIIlllIIIIl][lllllllllllIIlIIIIlIlIIIlllIIIlI].apply((Object)lllllllllllIIlIIIIlIlIIIllIllIll.getUnchecked((Object)translateOffset(lllllllllllIIlIIIIlIlIIIlllIIllI, lllllllllllIIlIIIIlIlIIIlllIIlIl, lllllllllllIIlIIIIlIlIIIlllIIlII, lllllllllllIIlIIIIlIlIIIlllIIIlI, lllllllllllIIlIIIIlIlIIIlllIIIIl, lllllllllllIIlIIIIlIlIIIlllIIIII)))) {
                        return null;
                    }
                }
            }
        }
        return new PatternHelper(lllllllllllIIlIIIIlIlIIIlllIIllI, lllllllllllIIlIIIIlIlIIIlllIIlIl, lllllllllllIIlIIIIlIlIIIlllIIlII, lllllllllllIIlIIIIlIlIIIllIllIll, this.palmLength, this.thumbLength, this.fingerLength);
    }
    
    public int getFingerLength() {
        return this.fingerLength;
    }
    
    @Nullable
    public PatternHelper match(final World lllllllllllIIlIIIIlIlIIIlIllllIl, final BlockPos lllllllllllIIlIIIIlIlIIIllIIIlIl) {
        final LoadingCache<BlockPos, BlockWorldState> lllllllllllIIlIIIIlIlIIIllIIIlII = createLoadingCache(lllllllllllIIlIIIIlIlIIIlIllllIl, false);
        final int lllllllllllIIlIIIIlIlIIIllIIIIll = Math.max(Math.max(this.palmLength, this.thumbLength), this.fingerLength);
        for (final BlockPos lllllllllllIIlIIIIlIlIIIllIIIIlI : BlockPos.getAllInBox(lllllllllllIIlIIIIlIlIIIllIIIlIl, lllllllllllIIlIIIIlIlIIIllIIIlIl.add(lllllllllllIIlIIIIlIlIIIllIIIIll - 1, lllllllllllIIlIIIIlIlIIIllIIIIll - 1, lllllllllllIIlIIIIlIlIIIllIIIIll - 1))) {
            final byte lllllllllllIIlIIIIlIlIIIlIllIlII;
            final boolean lllllllllllIIlIIIIlIlIIIlIllIlIl = ((EnumFacing[])(Object)(lllllllllllIIlIIIIlIlIIIlIllIlII = (byte)(Object)EnumFacing.values())).length != 0;
            for (char lllllllllllIIlIIIIlIlIIIlIllIllI = '\0'; lllllllllllIIlIIIIlIlIIIlIllIllI < (lllllllllllIIlIIIIlIlIIIlIllIlIl ? 1 : 0); ++lllllllllllIIlIIIIlIlIIIlIllIllI) {
                final EnumFacing lllllllllllIIlIIIIlIlIIIllIIIIIl = lllllllllllIIlIIIIlIlIIIlIllIlII[lllllllllllIIlIIIIlIlIIIlIllIllI];
                final short lllllllllllIIlIIIIlIlIIIlIllIIII;
                final Exception lllllllllllIIlIIIIlIlIIIlIllIIIl = (Exception)((EnumFacing[])(Object)(lllllllllllIIlIIIIlIlIIIlIllIIII = (short)(Object)EnumFacing.values())).length;
                for (double lllllllllllIIlIIIIlIlIIIlIllIIlI = 0; lllllllllllIIlIIIIlIlIIIlIllIIlI < lllllllllllIIlIIIIlIlIIIlIllIIIl; ++lllllllllllIIlIIIIlIlIIIlIllIIlI) {
                    final EnumFacing lllllllllllIIlIIIIlIlIIIllIIIIII = lllllllllllIIlIIIIlIlIIIlIllIIII[lllllllllllIIlIIIIlIlIIIlIllIIlI];
                    if (lllllllllllIIlIIIIlIlIIIllIIIIII != lllllllllllIIlIIIIlIlIIIllIIIIIl && lllllllllllIIlIIIIlIlIIIllIIIIII != lllllllllllIIlIIIIlIlIIIllIIIIIl.getOpposite()) {
                        final PatternHelper lllllllllllIIlIIIIlIlIIIlIllllll = this.checkPatternAt(lllllllllllIIlIIIIlIlIIIllIIIIlI, lllllllllllIIlIIIIlIlIIIllIIIIIl, lllllllllllIIlIIIIlIlIIIllIIIIII, lllllllllllIIlIIIIlIlIIIllIIIlII);
                        if (lllllllllllIIlIIIIlIlIIIlIllllll != null) {
                            return lllllllllllIIlIIIIlIlIIIlIllllll;
                        }
                    }
                }
            }
        }
        return null;
    }
    
    public BlockPattern(final Predicate<BlockWorldState>[][][] lllllllllllIIlIIIIlIlIIIlllllIll) {
        this.blockMatches = lllllllllllIIlIIIIlIlIIIlllllIll;
        this.fingerLength = lllllllllllIIlIIIIlIlIIIlllllIll.length;
        if (this.fingerLength > 0) {
            this.thumbLength = lllllllllllIIlIIIIlIlIIIlllllIll[0].length;
            if (this.thumbLength > 0) {
                this.palmLength = lllllllllllIIlIIIIlIlIIIlllllIll[0][0].length;
            }
            else {
                this.palmLength = 0;
            }
        }
        else {
            this.thumbLength = 0;
            this.palmLength = 0;
        }
    }
    
    public int getThumbLength() {
        return this.thumbLength;
    }
    
    public static LoadingCache<BlockPos, BlockWorldState> createLoadingCache(final World lllllllllllIIlIIIIlIlIIIlIlIllII, final boolean lllllllllllIIlIIIIlIlIIIlIlIlIll) {
        return (LoadingCache<BlockPos, BlockWorldState>)CacheBuilder.newBuilder().build((com.google.common.cache.CacheLoader)new CacheLoader(lllllllllllIIlIIIIlIlIIIlIlIllII, lllllllllllIIlIIIIlIlIIIlIlIlIll));
    }
    
    protected static BlockPos translateOffset(final BlockPos lllllllllllIIlIIIIlIlIIIlIIlIllI, final EnumFacing lllllllllllIIlIIIIlIlIIIlIIllllI, final EnumFacing lllllllllllIIlIIIIlIlIIIlIIlllIl, final int lllllllllllIIlIIIIlIlIIIlIIlllII, final int lllllllllllIIlIIIIlIlIIIlIIllIll, final int lllllllllllIIlIIIIlIlIIIlIIllIlI) {
        if (lllllllllllIIlIIIIlIlIIIlIIllllI != lllllllllllIIlIIIIlIlIIIlIIlllIl && lllllllllllIIlIIIIlIlIIIlIIllllI != lllllllllllIIlIIIIlIlIIIlIIlllIl.getOpposite()) {
            final Vec3i lllllllllllIIlIIIIlIlIIIlIIllIIl = new Vec3i(lllllllllllIIlIIIIlIlIIIlIIllllI.getFrontOffsetX(), lllllllllllIIlIIIIlIlIIIlIIllllI.getFrontOffsetY(), lllllllllllIIlIIIIlIlIIIlIIllllI.getFrontOffsetZ());
            final Vec3i lllllllllllIIlIIIIlIlIIIlIIllIII = new Vec3i(lllllllllllIIlIIIIlIlIIIlIIlllIl.getFrontOffsetX(), lllllllllllIIlIIIIlIlIIIlIIlllIl.getFrontOffsetY(), lllllllllllIIlIIIIlIlIIIlIIlllIl.getFrontOffsetZ());
            final Vec3i lllllllllllIIlIIIIlIlIIIlIIlIlll = lllllllllllIIlIIIIlIlIIIlIIllIIl.crossProduct(lllllllllllIIlIIIIlIlIIIlIIllIII);
            return lllllllllllIIlIIIIlIlIIIlIIlIllI.add(lllllllllllIIlIIIIlIlIIIlIIllIII.getX() * -lllllllllllIIlIIIIlIlIIIlIIllIll + lllllllllllIIlIIIIlIlIIIlIIlIlll.getX() * lllllllllllIIlIIIIlIlIIIlIIlllII + lllllllllllIIlIIIIlIlIIIlIIllIIl.getX() * lllllllllllIIlIIIIlIlIIIlIIllIlI, lllllllllllIIlIIIIlIlIIIlIIllIII.getY() * -lllllllllllIIlIIIIlIlIIIlIIllIll + lllllllllllIIlIIIIlIlIIIlIIlIlll.getY() * lllllllllllIIlIIIIlIlIIIlIIlllII + lllllllllllIIlIIIIlIlIIIlIIllIIl.getY() * lllllllllllIIlIIIIlIlIIIlIIllIlI, lllllllllllIIlIIIIlIlIIIlIIllIII.getZ() * -lllllllllllIIlIIIIlIlIIIlIIllIll + lllllllllllIIlIIIIlIlIIIlIIlIlll.getZ() * lllllllllllIIlIIIIlIlIIIlIIlllII + lllllllllllIIlIIIIlIlIIIlIIllIIl.getZ() * lllllllllllIIlIIIIlIlIIIlIIllIlI);
        }
        throw new IllegalArgumentException("Invalid forwards & up combination");
    }
    
    static class CacheLoader extends com.google.common.cache.CacheLoader<BlockPos, BlockWorldState>
    {
        private final /* synthetic */ World world;
        private final /* synthetic */ boolean forceLoad;
        
        public BlockWorldState load(final BlockPos llllllllllllIIIIIIlIllllllIllIII) throws Exception {
            return new BlockWorldState(this.world, llllllllllllIIIIIIlIllllllIllIII, this.forceLoad);
        }
        
        public CacheLoader(final World llllllllllllIIIIIIlIllllllIlllIl, final boolean llllllllllllIIIIIIlIllllllIlllll) {
            this.world = llllllllllllIIIIIIlIllllllIlllIl;
            this.forceLoad = llllllllllllIIIIIIlIllllllIlllll;
        }
    }
    
    public static class PatternHelper
    {
        private final /* synthetic */ LoadingCache<BlockPos, BlockWorldState> lcache;
        private final /* synthetic */ EnumFacing up;
        private final /* synthetic */ int depth;
        private final /* synthetic */ int height;
        private final /* synthetic */ int width;
        private final /* synthetic */ EnumFacing forwards;
        private final /* synthetic */ BlockPos frontTopLeft;
        
        public int getWidth() {
            return this.width;
        }
        
        public BlockPos getFrontTopLeft() {
            return this.frontTopLeft;
        }
        
        public PatternHelper(final BlockPos lllllllllllllIllIllIllIlIIIIIlII, final EnumFacing lllllllllllllIllIllIllIIlllllIll, final EnumFacing lllllllllllllIllIllIllIIlllllIlI, final LoadingCache<BlockPos, BlockWorldState> lllllllllllllIllIllIllIIlllllIIl, final int lllllllllllllIllIllIllIlIIIIIIII, final int lllllllllllllIllIllIllIIllllIlll, final int lllllllllllllIllIllIllIIllllIllI) {
            this.frontTopLeft = lllllllllllllIllIllIllIlIIIIIlII;
            this.forwards = lllllllllllllIllIllIllIIlllllIll;
            this.up = lllllllllllllIllIllIllIIlllllIlI;
            this.lcache = lllllllllllllIllIllIllIIlllllIIl;
            this.width = lllllllllllllIllIllIllIlIIIIIIII;
            this.height = lllllllllllllIllIllIllIIllllIlll;
            this.depth = lllllllllllllIllIllIllIIllllIllI;
        }
        
        public BlockWorldState translateOffset(final int lllllllllllllIllIllIllIIlllIIIIl, final int lllllllllllllIllIllIllIIllIlllII, final int lllllllllllllIllIllIllIIllIlllll) {
            return (BlockWorldState)this.lcache.getUnchecked((Object)BlockPattern.translateOffset(this.frontTopLeft, this.getForwards(), this.getUp(), lllllllllllllIllIllIllIIlllIIIIl, lllllllllllllIllIllIllIIllIlllII, lllllllllllllIllIllIllIIllIlllll));
        }
        
        public EnumFacing getUp() {
            return this.up;
        }
        
        @Override
        public String toString() {
            return MoreObjects.toStringHelper((Object)this).add("up", (Object)this.up).add("forwards", (Object)this.forwards).add("frontTopLeft", (Object)this.frontTopLeft).toString();
        }
        
        public int getHeight() {
            return this.height;
        }
        
        public EnumFacing getForwards() {
            return this.forwards;
        }
    }
}
