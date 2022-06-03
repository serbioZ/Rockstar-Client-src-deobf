// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world;

import net.minecraft.world.border.WorldBorder;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.init.Biomes;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.gen.ChunkGeneratorHell;
import net.minecraft.world.gen.IChunkGenerator;

public class WorldProviderHell extends WorldProvider
{
    @Override
    public DimensionType getDimensionType() {
        return DimensionType.NETHER;
    }
    
    @Override
    public IChunkGenerator createChunkGenerator() {
        return new ChunkGeneratorHell(this.worldObj, this.worldObj.getWorldInfo().isMapFeaturesEnabled(), this.worldObj.getSeed());
    }
    
    @Override
    public boolean canCoordinateBeSpawn(final int lllllllllllIllIlIlIllllIIIIlIlIl, final int lllllllllllIllIlIlIllllIIIIlIlII) {
        return false;
    }
    
    @Override
    public boolean canRespawnHere() {
        return false;
    }
    
    @Override
    public Vec3d getFogColor(final float lllllllllllIllIlIlIllllIIIlIlIII, final float lllllllllllIllIlIlIllllIIIlIIlll) {
        return new Vec3d(0.20000000298023224, 0.029999999329447746, 0.029999999329447746);
    }
    
    @Override
    public boolean isSurfaceWorld() {
        return false;
    }
    
    @Override
    public boolean doesXZShowFog(final int lllllllllllIllIlIlIllllIIIIIlllI, final int lllllllllllIllIlIlIllllIIIIIllIl) {
        return true;
    }
    
    public void createBiomeProvider() {
        this.biomeProvider = new BiomeProviderSingle(Biomes.HELL);
        this.isHellWorld = true;
        this.hasNoSky = true;
    }
    
    @Override
    public WorldBorder createWorldBorder() {
        return new WorldBorder() {
            @Override
            public double getCenterZ() {
                return super.getCenterZ() / 8.0;
            }
            
            @Override
            public double getCenterX() {
                return super.getCenterX() / 8.0;
            }
        };
    }
    
    @Override
    public float calculateCelestialAngle(final long lllllllllllIllIlIlIllllIIIIlIIlI, final float lllllllllllIllIlIlIllllIIIIlIIIl) {
        return 0.5f;
    }
    
    @Override
    protected void generateLightBrightnessTable() {
        final float lllllllllllIllIlIlIllllIIIlIIIIl = 0.1f;
        for (int lllllllllllIllIlIlIllllIIIlIIIII = 0; lllllllllllIllIlIlIllllIIIlIIIII <= 15; ++lllllllllllIllIlIlIllllIIIlIIIII) {
            final float lllllllllllIllIlIlIllllIIIIlllll = 1.0f - lllllllllllIllIlIlIllllIIIlIIIII / 15.0f;
            this.lightBrightnessTable[lllllllllllIllIlIlIllllIIIlIIIII] = (1.0f - lllllllllllIllIlIlIllllIIIIlllll) / (lllllllllllIllIlIlIllllIIIIlllll * 3.0f + 1.0f) * 0.9f + 0.1f;
        }
    }
}
