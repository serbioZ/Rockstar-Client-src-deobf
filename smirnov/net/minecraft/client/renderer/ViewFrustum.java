// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer;

import javax.annotation.Nullable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.client.renderer.chunk.IRenderChunkFactory;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.chunk.RenderChunk;
import net.minecraft.world.World;

public class ViewFrustum
{
    protected /* synthetic */ int countChunksX;
    protected /* synthetic */ int countChunksY;
    protected final /* synthetic */ World world;
    public /* synthetic */ RenderChunk[] renderChunks;
    protected final /* synthetic */ RenderGlobal renderGlobal;
    protected /* synthetic */ int countChunksZ;
    
    public void markBlocksForUpdate(final int lllllllllllIIlIIIIIIlllllIIllllI, final int lllllllllllIIlIIIIIIlllllIIlllIl, final int lllllllllllIIlIIIIIIlllllIIlllII, final int lllllllllllIIlIIIIIIlllllIIllIll, final int lllllllllllIIlIIIIIIlllllIIllIlI, final int lllllllllllIIlIIIIIIlllllIIIIIll, final boolean lllllllllllIIlIIIIIIlllllIIllIII) {
        final int lllllllllllIIlIIIIIIlllllIIlIlll = MathHelper.intFloorDiv(lllllllllllIIlIIIIIIlllllIIllllI, 16);
        final int lllllllllllIIlIIIIIIlllllIIlIllI = MathHelper.intFloorDiv(lllllllllllIIlIIIIIIlllllIIlllIl, 16);
        final int lllllllllllIIlIIIIIIlllllIIlIlIl = MathHelper.intFloorDiv(lllllllllllIIlIIIIIIlllllIIlllII, 16);
        final int lllllllllllIIlIIIIIIlllllIIlIlII = MathHelper.intFloorDiv(lllllllllllIIlIIIIIIlllllIIllIll, 16);
        final int lllllllllllIIlIIIIIIlllllIIlIIll = MathHelper.intFloorDiv(lllllllllllIIlIIIIIIlllllIIllIlI, 16);
        final int lllllllllllIIlIIIIIIlllllIIlIIlI = MathHelper.intFloorDiv(lllllllllllIIlIIIIIIlllllIIIIIll, 16);
        for (int lllllllllllIIlIIIIIIlllllIIlIIIl = lllllllllllIIlIIIIIIlllllIIlIlll; lllllllllllIIlIIIIIIlllllIIlIIIl <= lllllllllllIIlIIIIIIlllllIIlIlII; ++lllllllllllIIlIIIIIIlllllIIlIIIl) {
            int lllllllllllIIlIIIIIIlllllIIlIIII = lllllllllllIIlIIIIIIlllllIIlIIIl % this.countChunksX;
            if (lllllllllllIIlIIIIIIlllllIIlIIII < 0) {
                lllllllllllIIlIIIIIIlllllIIlIIII += this.countChunksX;
            }
            for (int lllllllllllIIlIIIIIIlllllIIIllll = lllllllllllIIlIIIIIIlllllIIlIllI; lllllllllllIIlIIIIIIlllllIIIllll <= lllllllllllIIlIIIIIIlllllIIlIIll; ++lllllllllllIIlIIIIIIlllllIIIllll) {
                int lllllllllllIIlIIIIIIlllllIIIlllI = lllllllllllIIlIIIIIIlllllIIIllll % this.countChunksY;
                if (lllllllllllIIlIIIIIIlllllIIIlllI < 0) {
                    lllllllllllIIlIIIIIIlllllIIIlllI += this.countChunksY;
                }
                for (int lllllllllllIIlIIIIIIlllllIIIllIl = lllllllllllIIlIIIIIIlllllIIlIlIl; lllllllllllIIlIIIIIIlllllIIIllIl <= lllllllllllIIlIIIIIIlllllIIlIIlI; ++lllllllllllIIlIIIIIIlllllIIIllIl) {
                    int lllllllllllIIlIIIIIIlllllIIIllII = lllllllllllIIlIIIIIIlllllIIIllIl % this.countChunksZ;
                    if (lllllllllllIIlIIIIIIlllllIIIllII < 0) {
                        lllllllllllIIlIIIIIIlllllIIIllII += this.countChunksZ;
                    }
                    final int lllllllllllIIlIIIIIIlllllIIIlIll = (lllllllllllIIlIIIIIIlllllIIIllII * this.countChunksY + lllllllllllIIlIIIIIIlllllIIIlllI) * this.countChunksX + lllllllllllIIlIIIIIIlllllIIlIIII;
                    final RenderChunk lllllllllllIIlIIIIIIlllllIIIlIlI = this.renderChunks[lllllllllllIIlIIIIIIlllllIIIlIll];
                    lllllllllllIIlIIIIIIlllllIIIlIlI.setNeedsUpdate(lllllllllllIIlIIIIIIlllllIIllIII);
                }
            }
        }
    }
    
    public ViewFrustum(final World lllllllllllIIlIIIIIlIIIIIIIlllIl, final int lllllllllllIIlIIIIIlIIIIIIIlllII, final RenderGlobal lllllllllllIIlIIIIIlIIIIIIlIIIII, final IRenderChunkFactory lllllllllllIIlIIIIIlIIIIIIIllIlI) {
        this.renderGlobal = lllllllllllIIlIIIIIlIIIIIIlIIIII;
        this.world = lllllllllllIIlIIIIIlIIIIIIIlllIl;
        this.setCountChunksXYZ(lllllllllllIIlIIIIIlIIIIIIIlllII);
        this.createRenderChunks(lllllllllllIIlIIIIIlIIIIIIIllIlI);
    }
    
    public void updateChunkPositions(final double lllllllllllIIlIIIIIIllllllIllllI, final double lllllllllllIIlIIIIIIllllllIlllIl) {
        final int lllllllllllIIlIIIIIIllllllIlllII = MathHelper.floor(lllllllllllIIlIIIIIIllllllIllllI) - 8;
        final int lllllllllllIIlIIIIIIllllllIllIll = MathHelper.floor(lllllllllllIIlIIIIIIllllllIlllIl) - 8;
        final int lllllllllllIIlIIIIIIllllllIllIlI = this.countChunksX * 16;
        for (int lllllllllllIIlIIIIIIllllllIllIIl = 0; lllllllllllIIlIIIIIIllllllIllIIl < this.countChunksX; ++lllllllllllIIlIIIIIIllllllIllIIl) {
            final int lllllllllllIIlIIIIIIllllllIllIII = this.getBaseCoordinate(lllllllllllIIlIIIIIIllllllIlllII, lllllllllllIIlIIIIIIllllllIllIlI, lllllllllllIIlIIIIIIllllllIllIIl);
            for (int lllllllllllIIlIIIIIIllllllIlIlll = 0; lllllllllllIIlIIIIIIllllllIlIlll < this.countChunksZ; ++lllllllllllIIlIIIIIIllllllIlIlll) {
                final int lllllllllllIIlIIIIIIllllllIlIllI = this.getBaseCoordinate(lllllllllllIIlIIIIIIllllllIllIll, lllllllllllIIlIIIIIIllllllIllIlI, lllllllllllIIlIIIIIIllllllIlIlll);
                for (int lllllllllllIIlIIIIIIllllllIlIlIl = 0; lllllllllllIIlIIIIIIllllllIlIlIl < this.countChunksY; ++lllllllllllIIlIIIIIIllllllIlIlIl) {
                    final int lllllllllllIIlIIIIIIllllllIlIlII = lllllllllllIIlIIIIIIllllllIlIlIl * 16;
                    final RenderChunk lllllllllllIIlIIIIIIllllllIlIIll = this.renderChunks[(lllllllllllIIlIIIIIIllllllIlIlll * this.countChunksY + lllllllllllIIlIIIIIIllllllIlIlIl) * this.countChunksX + lllllllllllIIlIIIIIIllllllIllIIl];
                    lllllllllllIIlIIIIIIllllllIlIIll.setPosition(lllllllllllIIlIIIIIIllllllIllIII, lllllllllllIIlIIIIIIllllllIlIlII, lllllllllllIIlIIIIIIllllllIlIllI);
                }
            }
        }
    }
    
    public void deleteGlResources() {
        final char lllllllllllIIlIIIIIIllllllllIllI;
        final byte lllllllllllIIlIIIIIIllllllllIlll = (byte)((RenderChunk[])(Object)(lllllllllllIIlIIIIIIllllllllIllI = (char)(Object)this.renderChunks)).length;
        for (Exception lllllllllllIIlIIIIIIlllllllllIII = (Exception)0; lllllllllllIIlIIIIIIlllllllllIII < lllllllllllIIlIIIIIIllllllllIlll; ++lllllllllllIIlIIIIIIlllllllllIII) {
            final RenderChunk lllllllllllIIlIIIIIIlllllllllIll = lllllllllllIIlIIIIIIllllllllIllI[lllllllllllIIlIIIIIIlllllllllIII];
            lllllllllllIIlIIIIIIlllllllllIll.deleteGlResources();
        }
    }
    
    protected void createRenderChunks(final IRenderChunkFactory lllllllllllIIlIIIIIlIIIIIIIIlIII) {
        final int lllllllllllIIlIIIIIlIIIIIIIIllll = this.countChunksX * this.countChunksY * this.countChunksZ;
        this.renderChunks = new RenderChunk[lllllllllllIIlIIIIIlIIIIIIIIllll];
        int lllllllllllIIlIIIIIlIIIIIIIIlllI = 0;
        for (int lllllllllllIIlIIIIIlIIIIIIIIllIl = 0; lllllllllllIIlIIIIIlIIIIIIIIllIl < this.countChunksX; ++lllllllllllIIlIIIIIlIIIIIIIIllIl) {
            for (int lllllllllllIIlIIIIIlIIIIIIIIllII = 0; lllllllllllIIlIIIIIlIIIIIIIIllII < this.countChunksY; ++lllllllllllIIlIIIIIlIIIIIIIIllII) {
                for (int lllllllllllIIlIIIIIlIIIIIIIIlIll = 0; lllllllllllIIlIIIIIlIIIIIIIIlIll < this.countChunksZ; ++lllllllllllIIlIIIIIlIIIIIIIIlIll) {
                    final int lllllllllllIIlIIIIIlIIIIIIIIlIlI = (lllllllllllIIlIIIIIlIIIIIIIIlIll * this.countChunksY + lllllllllllIIlIIIIIlIIIIIIIIllII) * this.countChunksX + lllllllllllIIlIIIIIlIIIIIIIIllIl;
                    (this.renderChunks[lllllllllllIIlIIIIIlIIIIIIIIlIlI] = lllllllllllIIlIIIIIlIIIIIIIIlIII.create(this.world, this.renderGlobal, lllllllllllIIlIIIIIlIIIIIIIIlllI++)).setPosition(lllllllllllIIlIIIIIlIIIIIIIIllIl * 16, lllllllllllIIlIIIIIlIIIIIIIIllII * 16, lllllllllllIIlIIIIIlIIIIIIIIlIll * 16);
                }
            }
        }
    }
    
    @Nullable
    public RenderChunk getRenderChunk(final BlockPos lllllllllllIIlIIIIIIllllIllIIllI) {
        int lllllllllllIIlIIIIIIllllIllIlIll = lllllllllllIIlIIIIIIllllIllIIllI.getX() >> 4;
        final int lllllllllllIIlIIIIIIllllIllIlIlI = lllllllllllIIlIIIIIIllllIllIIllI.getY() >> 4;
        int lllllllllllIIlIIIIIIllllIllIlIIl = lllllllllllIIlIIIIIIllllIllIIllI.getZ() >> 4;
        if (lllllllllllIIlIIIIIIllllIllIlIlI >= 0 && lllllllllllIIlIIIIIIllllIllIlIlI < this.countChunksY) {
            lllllllllllIIlIIIIIIllllIllIlIll %= this.countChunksX;
            if (lllllllllllIIlIIIIIIllllIllIlIll < 0) {
                lllllllllllIIlIIIIIIllllIllIlIll += this.countChunksX;
            }
            lllllllllllIIlIIIIIIllllIllIlIIl %= this.countChunksZ;
            if (lllllllllllIIlIIIIIIllllIllIlIIl < 0) {
                lllllllllllIIlIIIIIIllllIllIlIIl += this.countChunksZ;
            }
            final int lllllllllllIIlIIIIIIllllIllIlIII = (lllllllllllIIlIIIIIIllllIllIlIIl * this.countChunksY + lllllllllllIIlIIIIIIllllIllIlIlI) * this.countChunksX + lllllllllllIIlIIIIIIllllIllIlIll;
            return this.renderChunks[lllllllllllIIlIIIIIIllllIllIlIII];
        }
        return null;
    }
    
    protected void setCountChunksXYZ(final int lllllllllllIIlIIIIIIlllllllIlllI) {
        final int lllllllllllIIlIIIIIIllllllllIIII = lllllllllllIIlIIIIIIlllllllIlllI * 2 + 1;
        this.countChunksX = lllllllllllIIlIIIIIIllllllllIIII;
        this.countChunksY = 16;
        this.countChunksZ = lllllllllllIIlIIIIIIllllllllIIII;
    }
    
    private int getBaseCoordinate(final int lllllllllllIIlIIIIIIlllllIlllIlI, final int lllllllllllIIlIIIIIIlllllIlllllI, final int lllllllllllIIlIIIIIIlllllIlllIII) {
        final int lllllllllllIIlIIIIIIlllllIllllII = lllllllllllIIlIIIIIIlllllIlllIII * 16;
        int lllllllllllIIlIIIIIIlllllIlllIll = lllllllllllIIlIIIIIIlllllIllllII - lllllllllllIIlIIIIIIlllllIlllIlI + lllllllllllIIlIIIIIIlllllIlllllI / 2;
        if (lllllllllllIIlIIIIIIlllllIlllIll < 0) {
            lllllllllllIIlIIIIIIlllllIlllIll -= lllllllllllIIlIIIIIIlllllIlllllI - 1;
        }
        return lllllllllllIIlIIIIIIlllllIllllII - lllllllllllIIlIIIIIIlllllIlllIll / lllllllllllIIlIIIIIIlllllIlllllI * lllllllllllIIlIIIIIIlllllIlllllI;
    }
}
