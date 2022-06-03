// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world;

import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.biome.Biome;
import javax.annotation.Nullable;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.chunk.Chunk;

public class ChunkCache implements IBlockAccess
{
    protected /* synthetic */ World worldObj;
    protected /* synthetic */ int chunkZ;
    protected /* synthetic */ boolean hasExtendedLevels;
    protected /* synthetic */ int chunkX;
    protected /* synthetic */ Chunk[][] chunkArray;
    
    private int getLightForExt(final EnumSkyBlock llllllllllllIIIllIIIllIlIlllIIII, final BlockPos llllllllllllIIIllIIIllIlIllIllll) {
        if (llllllllllllIIIllIIIllIlIlllIIII == EnumSkyBlock.SKY && !this.worldObj.provider.func_191066_m()) {
            return 0;
        }
        if (llllllllllllIIIllIIIllIlIllIllll.getY() < 0 || llllllllllllIIIllIIIllIlIllIllll.getY() >= 256) {
            return llllllllllllIIIllIIIllIlIlllIIII.defaultLightValue;
        }
        if (this.getBlockState(llllllllllllIIIllIIIllIlIllIllll).useNeighborBrightness()) {
            int llllllllllllIIIllIIIllIlIllIlllI = 0;
            final int llllllllllllIIIllIIIllIlIllIIIlI;
            final short llllllllllllIIIllIIIllIlIllIIIll = (short)((EnumFacing[])(Object)(llllllllllllIIIllIIIllIlIllIIIlI = (int)(Object)EnumFacing.values())).length;
            for (byte llllllllllllIIIllIIIllIlIllIIlII = 0; llllllllllllIIIllIIIllIlIllIIlII < llllllllllllIIIllIIIllIlIllIIIll; ++llllllllllllIIIllIIIllIlIllIIlII) {
                final EnumFacing llllllllllllIIIllIIIllIlIllIllIl = llllllllllllIIIllIIIllIlIllIIIlI[llllllllllllIIIllIIIllIlIllIIlII];
                final int llllllllllllIIIllIIIllIlIllIllII = this.getLightFor(llllllllllllIIIllIIIllIlIlllIIII, llllllllllllIIIllIIIllIlIllIllll.offset(llllllllllllIIIllIIIllIlIllIllIl));
                if (llllllllllllIIIllIIIllIlIllIllII > llllllllllllIIIllIIIllIlIllIlllI) {
                    llllllllllllIIIllIIIllIlIllIlllI = llllllllllllIIIllIIIllIlIllIllII;
                }
                if (llllllllllllIIIllIIIllIlIllIlllI >= 15) {
                    return llllllllllllIIIllIIIllIlIllIlllI;
                }
            }
            return llllllllllllIIIllIIIllIlIllIlllI;
        }
        final int llllllllllllIIIllIIIllIlIllIlIll = (llllllllllllIIIllIIIllIlIllIllll.getX() >> 4) - this.chunkX;
        final int llllllllllllIIIllIIIllIlIllIlIlI = (llllllllllllIIIllIIIllIlIllIllll.getZ() >> 4) - this.chunkZ;
        return this.chunkArray[llllllllllllIIIllIIIllIlIllIlIll][llllllllllllIIIllIIIllIlIllIlIlI].getLightFor(llllllllllllIIIllIIIllIlIlllIIII, llllllllllllIIIllIIIllIlIllIllll);
    }
    
    @Nullable
    public TileEntity getTileEntity(final BlockPos llllllllllllIIIllIIIllIllIlIllIl, final Chunk.EnumCreateEntityType llllllllllllIIIllIIIllIllIlIIlll) {
        final int llllllllllllIIIllIIIllIllIlIlIll = (llllllllllllIIIllIIIllIllIlIllIl.getX() >> 4) - this.chunkX;
        final int llllllllllllIIIllIIIllIllIlIlIlI = (llllllllllllIIIllIIIllIllIlIllIl.getZ() >> 4) - this.chunkZ;
        return this.chunkArray[llllllllllllIIIllIIIllIllIlIlIll][llllllllllllIIIllIIIllIllIlIlIlI].getTileEntity(llllllllllllIIIllIIIllIllIlIllIl, llllllllllllIIIllIIIllIllIlIIlll);
    }
    
    @Nullable
    @Override
    public TileEntity getTileEntity(final BlockPos llllllllllllIIIllIIIllIllIllIlII) {
        return this.getTileEntity(llllllllllllIIIllIIIllIllIllIlII, Chunk.EnumCreateEntityType.IMMEDIATE);
    }
    
    @Override
    public Biome getBiome(final BlockPos llllllllllllIIIllIIIllIlIlllllIl) {
        final int llllllllllllIIIllIIIllIllIIIIIII = (llllllllllllIIIllIIIllIlIlllllIl.getX() >> 4) - this.chunkX;
        final int llllllllllllIIIllIIIllIlIlllllll = (llllllllllllIIIllIIIllIlIlllllIl.getZ() >> 4) - this.chunkZ;
        return this.chunkArray[llllllllllllIIIllIIIllIllIIIIIII][llllllllllllIIIllIIIllIlIlllllll].getBiome(llllllllllllIIIllIIIllIlIlllllIl, this.worldObj.getBiomeProvider());
    }
    
    @Override
    public int getCombinedLight(final BlockPos llllllllllllIIIllIIIllIllIIllllI, final int llllllllllllIIIllIIIllIllIIllIII) {
        final int llllllllllllIIIllIIIllIllIIlllII = this.getLightForExt(EnumSkyBlock.SKY, llllllllllllIIIllIIIllIllIIllllI);
        int llllllllllllIIIllIIIllIllIIllIll = this.getLightForExt(EnumSkyBlock.BLOCK, llllllllllllIIIllIIIllIllIIllllI);
        if (llllllllllllIIIllIIIllIllIIllIll < llllllllllllIIIllIIIllIllIIllIII) {
            llllllllllllIIIllIIIllIllIIllIll = llllllllllllIIIllIIIllIllIIllIII;
        }
        return llllllllllllIIIllIIIllIllIIlllII << 20 | llllllllllllIIIllIIIllIllIIllIll << 4;
    }
    
    @Override
    public int getStrongPower(final BlockPos llllllllllllIIIllIIIllIlIlIIIlII, final EnumFacing llllllllllllIIIllIIIllIlIlIIIIll) {
        return this.getBlockState(llllllllllllIIIllIIIllIlIlIIIlII).getStrongPower(this, llllllllllllIIIllIIIllIlIlIIIlII, llllllllllllIIIllIIIllIlIlIIIIll);
    }
    
    @Override
    public IBlockState getBlockState(final BlockPos llllllllllllIIIllIIIllIllIIIlIlI) {
        if (llllllllllllIIIllIIIllIllIIIlIlI.getY() >= 0 && llllllllllllIIIllIIIllIllIIIlIlI.getY() < 256) {
            final int llllllllllllIIIllIIIllIllIIIlllI = (llllllllllllIIIllIIIllIllIIIlIlI.getX() >> 4) - this.chunkX;
            final int llllllllllllIIIllIIIllIllIIIllIl = (llllllllllllIIIllIIIllIllIIIlIlI.getZ() >> 4) - this.chunkZ;
            if (llllllllllllIIIllIIIllIllIIIlllI >= 0 && llllllllllllIIIllIIIllIllIIIlllI < this.chunkArray.length && llllllllllllIIIllIIIllIllIIIllIl >= 0 && llllllllllllIIIllIIIllIllIIIllIl < this.chunkArray[llllllllllllIIIllIIIllIllIIIlllI].length) {
                final Chunk llllllllllllIIIllIIIllIllIIIllII = this.chunkArray[llllllllllllIIIllIIIllIllIIIlllI][llllllllllllIIIllIIIllIllIIIllIl];
                if (llllllllllllIIIllIIIllIllIIIllII != null) {
                    return llllllllllllIIIllIIIllIllIIIllII.getBlockState(llllllllllllIIIllIIIllIllIIIlIlI);
                }
            }
        }
        return Blocks.AIR.getDefaultState();
    }
    
    public ChunkCache(final World llllllllllllIIIllIIIllIlllIlIIIl, final BlockPos llllllllllllIIIllIIIllIlllIIIlII, final BlockPos llllllllllllIIIllIIIllIlllIIIIll, final int llllllllllllIIIllIIIllIlllIIlllI) {
        this.worldObj = llllllllllllIIIllIIIllIlllIlIIIl;
        this.chunkX = llllllllllllIIIllIIIllIlllIIIlII.getX() - llllllllllllIIIllIIIllIlllIIlllI >> 4;
        this.chunkZ = llllllllllllIIIllIIIllIlllIIIlII.getZ() - llllllllllllIIIllIIIllIlllIIlllI >> 4;
        final int llllllllllllIIIllIIIllIlllIIllIl = llllllllllllIIIllIIIllIlllIIIIll.getX() + llllllllllllIIIllIIIllIlllIIlllI >> 4;
        final int llllllllllllIIIllIIIllIlllIIllII = llllllllllllIIIllIIIllIlllIIIIll.getZ() + llllllllllllIIIllIIIllIlllIIlllI >> 4;
        this.chunkArray = new Chunk[llllllllllllIIIllIIIllIlllIIllIl - this.chunkX + 1][llllllllllllIIIllIIIllIlllIIllII - this.chunkZ + 1];
        this.hasExtendedLevels = true;
        for (int llllllllllllIIIllIIIllIlllIIlIll = this.chunkX; llllllllllllIIIllIIIllIlllIIlIll <= llllllllllllIIIllIIIllIlllIIllIl; ++llllllllllllIIIllIIIllIlllIIlIll) {
            for (int llllllllllllIIIllIIIllIlllIIlIlI = this.chunkZ; llllllllllllIIIllIIIllIlllIIlIlI <= llllllllllllIIIllIIIllIlllIIllII; ++llllllllllllIIIllIIIllIlllIIlIlI) {
                this.chunkArray[llllllllllllIIIllIIIllIlllIIlIll - this.chunkX][llllllllllllIIIllIIIllIlllIIlIlI - this.chunkZ] = llllllllllllIIIllIIIllIlllIlIIIl.getChunkFromChunkCoords(llllllllllllIIIllIIIllIlllIIlIll, llllllllllllIIIllIIIllIlllIIlIlI);
            }
        }
        for (int llllllllllllIIIllIIIllIlllIIlIIl = llllllllllllIIIllIIIllIlllIIIlII.getX() >> 4; llllllllllllIIIllIIIllIlllIIlIIl <= llllllllllllIIIllIIIllIlllIIIIll.getX() >> 4; ++llllllllllllIIIllIIIllIlllIIlIIl) {
            for (int llllllllllllIIIllIIIllIlllIIlIII = llllllllllllIIIllIIIllIlllIIIlII.getZ() >> 4; llllllllllllIIIllIIIllIlllIIlIII <= llllllllllllIIIllIIIllIlllIIIIll.getZ() >> 4; ++llllllllllllIIIllIIIllIlllIIlIII) {
                final Chunk llllllllllllIIIllIIIllIlllIIIlll = this.chunkArray[llllllllllllIIIllIIIllIlllIIlIIl - this.chunkX][llllllllllllIIIllIIIllIlllIIlIII - this.chunkZ];
                if (llllllllllllIIIllIIIllIlllIIIlll != null && !llllllllllllIIIllIIIllIlllIIIlll.getAreLevelsEmpty(llllllllllllIIIllIIIllIlllIIIlII.getY(), llllllllllllIIIllIIIllIlllIIIIll.getY())) {
                    this.hasExtendedLevels = false;
                }
            }
        }
    }
    
    public boolean extendedLevelsInChunkCache() {
        return this.hasExtendedLevels;
    }
    
    public int getLightFor(final EnumSkyBlock llllllllllllIIIllIIIllIlIlIIllll, final BlockPos llllllllllllIIIllIIIllIlIlIIlllI) {
        if (llllllllllllIIIllIIIllIlIlIIlllI.getY() >= 0 && llllllllllllIIIllIIIllIlIlIIlllI.getY() < 256) {
            final int llllllllllllIIIllIIIllIlIlIlIIlI = (llllllllllllIIIllIIIllIlIlIIlllI.getX() >> 4) - this.chunkX;
            final int llllllllllllIIIllIIIllIlIlIlIIIl = (llllllllllllIIIllIIIllIlIlIIlllI.getZ() >> 4) - this.chunkZ;
            return this.chunkArray[llllllllllllIIIllIIIllIlIlIlIIlI][llllllllllllIIIllIIIllIlIlIlIIIl].getLightFor(llllllllllllIIIllIIIllIlIlIIllll, llllllllllllIIIllIIIllIlIlIIlllI);
        }
        return llllllllllllIIIllIIIllIlIlIIllll.defaultLightValue;
    }
    
    @Override
    public WorldType getWorldType() {
        return this.worldObj.getWorldType();
    }
    
    @Override
    public boolean isAirBlock(final BlockPos llllllllllllIIIllIIIllIlIlIlllIl) {
        return this.getBlockState(llllllllllllIIIllIIIllIlIlIlllIl).getMaterial() == Material.AIR;
    }
}
