// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.tileentity;

import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.EnumParticleTypes;
import com.google.common.collect.Lists;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.EntityLiving;
import net.minecraft.world.chunk.storage.AnvilChunkLoader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StringUtils;
import net.minecraft.world.World;
import net.minecraft.util.WeightedRandom;
import javax.annotation.Nullable;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.WeightedSpawnerEntity;
import java.util.List;
import net.minecraft.entity.Entity;

public abstract class MobSpawnerBaseLogic
{
    private /* synthetic */ int spawnRange;
    private /* synthetic */ int spawnDelay;
    private /* synthetic */ Entity cachedEntity;
    private /* synthetic */ int activatingRangeFromPlayer;
    private /* synthetic */ int maxNearbyEntities;
    private /* synthetic */ int spawnCount;
    private /* synthetic */ double prevMobRotation;
    private final /* synthetic */ List<WeightedSpawnerEntity> potentialSpawns;
    private /* synthetic */ double mobRotation;
    private /* synthetic */ int maxSpawnDelay;
    private /* synthetic */ int minSpawnDelay;
    private /* synthetic */ WeightedSpawnerEntity randomEntity;
    
    public void func_190894_a(@Nullable final ResourceLocation llllllllllllIIlIllIllIlIIlIlIIIl) {
        if (llllllllllllIIlIllIllIlIIlIlIIIl != null) {
            this.randomEntity.getNbt().setString("id", llllllllllllIIlIllIllIlIIlIlIIIl.toString());
        }
    }
    
    private void resetTimer() {
        if (this.maxSpawnDelay <= this.minSpawnDelay) {
            this.spawnDelay = this.minSpawnDelay;
        }
        else {
            final int llllllllllllIIlIllIllIlIIIIllIlI = this.maxSpawnDelay - this.minSpawnDelay;
            this.spawnDelay = this.minSpawnDelay + this.getSpawnerWorld().rand.nextInt(llllllllllllIIlIllIllIlIIIIllIlI);
        }
        if (!this.potentialSpawns.isEmpty()) {
            this.setNextSpawnData(WeightedRandom.getRandomItem(this.getSpawnerWorld().rand, this.potentialSpawns));
        }
        this.broadcastEvent(1);
    }
    
    public abstract void broadcastEvent(final int p0);
    
    public abstract World getSpawnerWorld();
    
    @Nullable
    private ResourceLocation func_190895_g() {
        final String llllllllllllIIlIllIllIlIIlIllIIl = this.randomEntity.getNbt().getString("id");
        return StringUtils.isNullOrEmpty(llllllllllllIIlIllIllIlIIlIllIIl) ? null : new ResourceLocation(llllllllllllIIlIllIllIlIIlIllIIl);
    }
    
    public double getMobRotation() {
        return this.mobRotation;
    }
    
    public double getPrevMobRotation() {
        return this.prevMobRotation;
    }
    
    public NBTTagCompound writeToNBT(final NBTTagCompound llllllllllllIIlIllIllIIlllllllll) {
        final ResourceLocation llllllllllllIIlIllIllIlIIIIIIIll = this.func_190895_g();
        if (llllllllllllIIlIllIllIlIIIIIIIll == null) {
            return llllllllllllIIlIllIllIIlllllllll;
        }
        llllllllllllIIlIllIllIIlllllllll.setShort("Delay", (short)this.spawnDelay);
        llllllllllllIIlIllIllIIlllllllll.setShort("MinSpawnDelay", (short)this.minSpawnDelay);
        llllllllllllIIlIllIllIIlllllllll.setShort("MaxSpawnDelay", (short)this.maxSpawnDelay);
        llllllllllllIIlIllIllIIlllllllll.setShort("SpawnCount", (short)this.spawnCount);
        llllllllllllIIlIllIllIIlllllllll.setShort("MaxNearbyEntities", (short)this.maxNearbyEntities);
        llllllllllllIIlIllIllIIlllllllll.setShort("RequiredPlayerRange", (short)this.activatingRangeFromPlayer);
        llllllllllllIIlIllIllIIlllllllll.setShort("SpawnRange", (short)this.spawnRange);
        llllllllllllIIlIllIllIIlllllllll.setTag("SpawnData", this.randomEntity.getNbt().copy());
        final NBTTagList llllllllllllIIlIllIllIlIIIIIIIlI = new NBTTagList();
        if (this.potentialSpawns.isEmpty()) {
            llllllllllllIIlIllIllIlIIIIIIIlI.appendTag(this.randomEntity.toCompoundTag());
        }
        else {
            for (final WeightedSpawnerEntity llllllllllllIIlIllIllIlIIIIIIIIl : this.potentialSpawns) {
                llllllllllllIIlIllIllIlIIIIIIIlI.appendTag(llllllllllllIIlIllIllIlIIIIIIIIl.toCompoundTag());
            }
        }
        llllllllllllIIlIllIllIIlllllllll.setTag("SpawnPotentials", llllllllllllIIlIllIllIlIIIIIIIlI);
        return llllllllllllIIlIllIllIIlllllllll;
    }
    
    public abstract BlockPos getSpawnerPosition();
    
    public void setNextSpawnData(final WeightedSpawnerEntity llllllllllllIIlIllIllIIllllIlllI) {
        this.randomEntity = llllllllllllIIlIllIllIIllllIlllI;
    }
    
    public void readFromNBT(final NBTTagCompound llllllllllllIIlIllIllIlIIIIIlllI) {
        this.spawnDelay = llllllllllllIIlIllIllIlIIIIIlllI.getShort("Delay");
        this.potentialSpawns.clear();
        if (llllllllllllIIlIllIllIlIIIIIlllI.hasKey("SpawnPotentials", 9)) {
            final NBTTagList llllllllllllIIlIllIllIlIIIIlIIIl = llllllllllllIIlIllIllIlIIIIIlllI.getTagList("SpawnPotentials", 10);
            for (int llllllllllllIIlIllIllIlIIIIlIIII = 0; llllllllllllIIlIllIllIlIIIIlIIII < llllllllllllIIlIllIllIlIIIIlIIIl.tagCount(); ++llllllllllllIIlIllIllIlIIIIlIIII) {
                this.potentialSpawns.add(new WeightedSpawnerEntity(llllllllllllIIlIllIllIlIIIIlIIIl.getCompoundTagAt(llllllllllllIIlIllIllIlIIIIlIIII)));
            }
        }
        if (llllllllllllIIlIllIllIlIIIIIlllI.hasKey("SpawnData", 10)) {
            this.setNextSpawnData(new WeightedSpawnerEntity(1, llllllllllllIIlIllIllIlIIIIIlllI.getCompoundTag("SpawnData")));
        }
        else if (!this.potentialSpawns.isEmpty()) {
            this.setNextSpawnData(WeightedRandom.getRandomItem(this.getSpawnerWorld().rand, this.potentialSpawns));
        }
        if (llllllllllllIIlIllIllIlIIIIIlllI.hasKey("MinSpawnDelay", 99)) {
            this.minSpawnDelay = llllllllllllIIlIllIllIlIIIIIlllI.getShort("MinSpawnDelay");
            this.maxSpawnDelay = llllllllllllIIlIllIllIlIIIIIlllI.getShort("MaxSpawnDelay");
            this.spawnCount = llllllllllllIIlIllIllIlIIIIIlllI.getShort("SpawnCount");
        }
        if (llllllllllllIIlIllIllIlIIIIIlllI.hasKey("MaxNearbyEntities", 99)) {
            this.maxNearbyEntities = llllllllllllIIlIllIllIlIIIIIlllI.getShort("MaxNearbyEntities");
            this.activatingRangeFromPlayer = llllllllllllIIlIllIllIlIIIIIlllI.getShort("RequiredPlayerRange");
        }
        if (llllllllllllIIlIllIllIlIIIIIlllI.hasKey("SpawnRange", 99)) {
            this.spawnRange = llllllllllllIIlIllIllIlIIIIIlllI.getShort("SpawnRange");
        }
        if (this.getSpawnerWorld() != null) {
            this.cachedEntity = null;
        }
    }
    
    public Entity getCachedEntity() {
        if (this.cachedEntity == null) {
            this.cachedEntity = AnvilChunkLoader.readWorldEntity(this.randomEntity.getNbt(), this.getSpawnerWorld(), false);
            if (this.randomEntity.getNbt().getSize() == 1 && this.randomEntity.getNbt().hasKey("id", 8) && this.cachedEntity instanceof EntityLiving) {
                ((EntityLiving)this.cachedEntity).onInitialSpawn(this.getSpawnerWorld().getDifficultyForLocation(new BlockPos(this.cachedEntity)), null);
            }
        }
        return this.cachedEntity;
    }
    
    public boolean setDelayToMin(final int llllllllllllIIlIllIllIIlllllIlII) {
        if (llllllllllllIIlIllIllIIlllllIlII == 1 && this.getSpawnerWorld().isRemote) {
            this.spawnDelay = this.minSpawnDelay;
            return true;
        }
        return false;
    }
    
    public MobSpawnerBaseLogic() {
        this.spawnDelay = 20;
        this.potentialSpawns = (List<WeightedSpawnerEntity>)Lists.newArrayList();
        this.randomEntity = new WeightedSpawnerEntity();
        this.minSpawnDelay = 200;
        this.maxSpawnDelay = 800;
        this.spawnCount = 4;
        this.maxNearbyEntities = 6;
        this.activatingRangeFromPlayer = 16;
        this.spawnRange = 4;
    }
    
    public void updateSpawner() {
        if (!this.isActivated()) {
            this.prevMobRotation = this.mobRotation;
        }
        else {
            final BlockPos llllllllllllIIlIllIllIlIIIlllIll = this.getSpawnerPosition();
            if (this.getSpawnerWorld().isRemote) {
                final double llllllllllllIIlIllIllIlIIIlllIlI = llllllllllllIIlIllIllIlIIIlllIll.getX() + this.getSpawnerWorld().rand.nextFloat();
                final double llllllllllllIIlIllIllIlIIIlllIIl = llllllllllllIIlIllIllIlIIIlllIll.getY() + this.getSpawnerWorld().rand.nextFloat();
                final double llllllllllllIIlIllIllIlIIIlllIII = llllllllllllIIlIllIllIlIIIlllIll.getZ() + this.getSpawnerWorld().rand.nextFloat();
                this.getSpawnerWorld().spawnParticle(EnumParticleTypes.SMOKE_NORMAL, llllllllllllIIlIllIllIlIIIlllIlI, llllllllllllIIlIllIllIlIIIlllIIl, llllllllllllIIlIllIllIlIIIlllIII, 0.0, 0.0, 0.0, new int[0]);
                this.getSpawnerWorld().spawnParticle(EnumParticleTypes.FLAME, llllllllllllIIlIllIllIlIIIlllIlI, llllllllllllIIlIllIllIlIIIlllIIl, llllllllllllIIlIllIllIlIIIlllIII, 0.0, 0.0, 0.0, new int[0]);
                if (this.spawnDelay > 0) {
                    --this.spawnDelay;
                }
                this.prevMobRotation = this.mobRotation;
                this.mobRotation = (this.mobRotation + 1000.0f / (this.spawnDelay + 200.0f)) % 360.0;
            }
            else {
                if (this.spawnDelay == -1) {
                    this.resetTimer();
                }
                if (this.spawnDelay > 0) {
                    --this.spawnDelay;
                    return;
                }
                boolean llllllllllllIIlIllIllIlIIIllIlll = false;
                for (int llllllllllllIIlIllIllIlIIIllIllI = 0; llllllllllllIIlIllIllIlIIIllIllI < this.spawnCount; ++llllllllllllIIlIllIllIlIIIllIllI) {
                    final NBTTagCompound llllllllllllIIlIllIllIlIIIllIlIl = this.randomEntity.getNbt();
                    final NBTTagList llllllllllllIIlIllIllIlIIIllIlII = llllllllllllIIlIllIllIlIIIllIlIl.getTagList("Pos", 6);
                    final World llllllllllllIIlIllIllIlIIIllIIll = this.getSpawnerWorld();
                    final int llllllllllllIIlIllIllIlIIIllIIlI = llllllllllllIIlIllIllIlIIIllIlII.tagCount();
                    final double llllllllllllIIlIllIllIlIIIllIIIl = (llllllllllllIIlIllIllIlIIIllIIlI >= 1) ? llllllllllllIIlIllIllIlIIIllIlII.getDoubleAt(0) : (llllllllllllIIlIllIllIlIIIlllIll.getX() + (llllllllllllIIlIllIllIlIIIllIIll.rand.nextDouble() - llllllllllllIIlIllIllIlIIIllIIll.rand.nextDouble()) * this.spawnRange + 0.5);
                    final double llllllllllllIIlIllIllIlIIIllIIII = (llllllllllllIIlIllIllIlIIIllIIlI >= 2) ? llllllllllllIIlIllIllIlIIIllIlII.getDoubleAt(1) : (llllllllllllIIlIllIllIlIIIlllIll.getY() + llllllllllllIIlIllIllIlIIIllIIll.rand.nextInt(3) - 1);
                    final double llllllllllllIIlIllIllIlIIIlIllll = (llllllllllllIIlIllIllIlIIIllIIlI >= 3) ? llllllllllllIIlIllIllIlIIIllIlII.getDoubleAt(2) : (llllllllllllIIlIllIllIlIIIlllIll.getZ() + (llllllllllllIIlIllIllIlIIIllIIll.rand.nextDouble() - llllllllllllIIlIllIllIlIIIllIIll.rand.nextDouble()) * this.spawnRange + 0.5);
                    final Entity llllllllllllIIlIllIllIlIIIlIlllI = AnvilChunkLoader.readWorldEntityPos(llllllllllllIIlIllIllIlIIIllIlIl, llllllllllllIIlIllIllIlIIIllIIll, llllllllllllIIlIllIllIlIIIllIIIl, llllllllllllIIlIllIllIlIIIllIIII, llllllllllllIIlIllIllIlIIIlIllll, false);
                    if (llllllllllllIIlIllIllIlIIIlIlllI == null) {
                        return;
                    }
                    final int llllllllllllIIlIllIllIlIIIlIllIl = llllllllllllIIlIllIllIlIIIllIIll.getEntitiesWithinAABB(llllllllllllIIlIllIllIlIIIlIlllI.getClass(), new AxisAlignedBB(llllllllllllIIlIllIllIlIIIlllIll.getX(), llllllllllllIIlIllIllIlIIIlllIll.getY(), llllllllllllIIlIllIllIlIIIlllIll.getZ(), llllllllllllIIlIllIllIlIIIlllIll.getX() + 1, llllllllllllIIlIllIllIlIIIlllIll.getY() + 1, llllllllllllIIlIllIllIlIIIlllIll.getZ() + 1).expandXyz(this.spawnRange)).size();
                    if (llllllllllllIIlIllIllIlIIIlIllIl >= this.maxNearbyEntities) {
                        this.resetTimer();
                        return;
                    }
                    final EntityLiving llllllllllllIIlIllIllIlIIIlIllII = (llllllllllllIIlIllIllIlIIIlIlllI instanceof EntityLiving) ? ((EntityLiving)llllllllllllIIlIllIllIlIIIlIlllI) : null;
                    llllllllllllIIlIllIllIlIIIlIlllI.setLocationAndAngles(llllllllllllIIlIllIllIlIIIlIlllI.posX, llllllllllllIIlIllIllIlIIIlIlllI.posY, llllllllllllIIlIllIllIlIIIlIlllI.posZ, llllllllllllIIlIllIllIlIIIllIIll.rand.nextFloat() * 360.0f, 0.0f);
                    if (llllllllllllIIlIllIllIlIIIlIllII == null || (llllllllllllIIlIllIllIlIIIlIllII.getCanSpawnHere() && llllllllllllIIlIllIllIlIIIlIllII.isNotColliding())) {
                        if (this.randomEntity.getNbt().getSize() == 1 && this.randomEntity.getNbt().hasKey("id", 8) && llllllllllllIIlIllIllIlIIIlIlllI instanceof EntityLiving) {
                            ((EntityLiving)llllllllllllIIlIllIllIlIIIlIlllI).onInitialSpawn(llllllllllllIIlIllIllIlIIIllIIll.getDifficultyForLocation(new BlockPos(llllllllllllIIlIllIllIlIIIlIlllI)), null);
                        }
                        AnvilChunkLoader.spawnEntity(llllllllllllIIlIllIllIlIIIlIlllI, llllllllllllIIlIllIllIlIIIllIIll);
                        llllllllllllIIlIllIllIlIIIllIIll.playEvent(2004, llllllllllllIIlIllIllIlIIIlllIll, 0);
                        if (llllllllllllIIlIllIllIlIIIlIllII != null) {
                            llllllllllllIIlIllIllIlIIIlIllII.spawnExplosionParticle();
                        }
                        llllllllllllIIlIllIllIlIIIllIlll = true;
                    }
                }
                if (llllllllllllIIlIllIllIlIIIllIlll) {
                    this.resetTimer();
                }
            }
        }
    }
    
    private boolean isActivated() {
        final BlockPos llllllllllllIIlIllIllIlIIlIIllIl = this.getSpawnerPosition();
        return this.getSpawnerWorld().isAnyPlayerWithinRangeAt(llllllllllllIIlIllIllIlIIlIIllIl.getX() + 0.5, llllllllllllIIlIllIllIlIIlIIllIl.getY() + 0.5, llllllllllllIIlIllIllIlIIlIIllIl.getZ() + 0.5, this.activatingRangeFromPlayer);
    }
}
