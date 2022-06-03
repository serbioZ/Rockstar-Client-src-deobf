// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world;

import net.minecraft.world.gen.ChunkGeneratorEnd;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.util.math.BlockPos;
import javax.annotation.Nullable;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.init.Biomes;
import net.minecraft.world.end.DragonFightManager;

public class WorldProviderEnd extends WorldProvider
{
    private /* synthetic */ DragonFightManager dragonFightManager;
    
    @Override
    public boolean isSurfaceWorld() {
        return false;
    }
    
    public void createBiomeProvider() {
        this.biomeProvider = new BiomeProviderSingle(Biomes.SKY);
        final NBTTagCompound lllllllllllIlIIIIIIIIIlIlIlIIllI = this.worldObj.getWorldInfo().getDimensionData(DimensionType.THE_END);
        this.dragonFightManager = ((this.worldObj instanceof WorldServer) ? new DragonFightManager((WorldServer)this.worldObj, lllllllllllIlIIIIIIIIIlIlIlIIllI.getCompoundTag("DragonFight")) : null);
    }
    
    @Override
    public void onWorldSave() {
        final NBTTagCompound lllllllllllIlIIIIIIIIIlIIlllIIII = new NBTTagCompound();
        if (this.dragonFightManager != null) {
            lllllllllllIlIIIIIIIIIlIIlllIIII.setTag("DragonFight", this.dragonFightManager.getCompound());
        }
        this.worldObj.getWorldInfo().setDimensionData(DimensionType.THE_END, lllllllllllIlIIIIIIIIIlIIlllIIII);
    }
    
    @Override
    public Vec3d getFogColor(final float lllllllllllIlIIIIIIIIIlIlIIlIIll, final float lllllllllllIlIIIIIIIIIlIlIIlIIlI) {
        final int lllllllllllIlIIIIIIIIIlIlIIlIIIl = 10518688;
        float lllllllllllIlIIIIIIIIIlIlIIlIIII = MathHelper.cos(lllllllllllIlIIIIIIIIIlIlIIlIIll * 6.2831855f) * 2.0f + 0.5f;
        lllllllllllIlIIIIIIIIIlIlIIlIIII = MathHelper.clamp(lllllllllllIlIIIIIIIIIlIlIIlIIII, 0.0f, 1.0f);
        float lllllllllllIlIIIIIIIIIlIlIIIllll = 0.627451f;
        float lllllllllllIlIIIIIIIIIlIlIIIlllI = 0.5019608f;
        float lllllllllllIlIIIIIIIIIlIlIIIllIl = 0.627451f;
        lllllllllllIlIIIIIIIIIlIlIIIllll *= lllllllllllIlIIIIIIIIIlIlIIlIIII * 0.0f + 0.15f;
        lllllllllllIlIIIIIIIIIlIlIIIlllI *= lllllllllllIlIIIIIIIIIlIlIIlIIII * 0.0f + 0.15f;
        lllllllllllIlIIIIIIIIIlIlIIIllIl *= lllllllllllIlIIIIIIIIIlIlIIlIIII * 0.0f + 0.15f;
        return new Vec3d(lllllllllllIlIIIIIIIIIlIlIIIllll, lllllllllllIlIIIIIIIIIlIlIIIlllI, lllllllllllIlIIIIIIIIIlIlIIIllIl);
    }
    
    @Override
    public int getAverageGroundLevel() {
        return 50;
    }
    
    @Override
    public boolean isSkyColored() {
        return false;
    }
    
    @Override
    public float calculateCelestialAngle(final long lllllllllllIlIIIIIIIIIlIlIIlllll, final float lllllllllllIlIIIIIIIIIlIlIIllllI) {
        return 0.0f;
    }
    
    @Override
    public boolean canRespawnHere() {
        return false;
    }
    
    @Override
    public void onWorldUpdateEntities() {
        if (this.dragonFightManager != null) {
            this.dragonFightManager.tick();
        }
    }
    
    @Override
    public boolean doesXZShowFog(final int lllllllllllIlIIIIIIIIIlIIlllIllI, final int lllllllllllIlIIIIIIIIIlIIlllIlIl) {
        return false;
    }
    
    @Override
    public float getCloudHeight() {
        return 8.0f;
    }
    
    @Nullable
    @Override
    public float[] calcSunriseSunsetColors(final float lllllllllllIlIIIIIIIIIlIlIIlllII, final float lllllllllllIlIIIIIIIIIlIlIIllIll) {
        return null;
    }
    
    @Nullable
    public DragonFightManager getDragonFightManager() {
        return this.dragonFightManager;
    }
    
    @Override
    public boolean canCoordinateBeSpawn(final int lllllllllllIlIIIIIIIIIlIIllllllI, final int lllllllllllIlIIIIIIIIIlIIllllIlI) {
        return this.worldObj.getGroundAboveSeaLevel(new BlockPos(lllllllllllIlIIIIIIIIIlIIllllllI, 0, lllllllllllIlIIIIIIIIIlIIllllIlI)).getMaterial().blocksMovement();
    }
    
    @Override
    public DimensionType getDimensionType() {
        return DimensionType.THE_END;
    }
    
    @Override
    public BlockPos getSpawnCoordinate() {
        return new BlockPos(100, 50, 0);
    }
    
    @Override
    public IChunkGenerator createChunkGenerator() {
        return new ChunkGeneratorEnd(this.worldObj, this.worldObj.getWorldInfo().isMapFeaturesEnabled(), this.worldObj.getSeed(), this.getSpawnCoordinate());
    }
}
