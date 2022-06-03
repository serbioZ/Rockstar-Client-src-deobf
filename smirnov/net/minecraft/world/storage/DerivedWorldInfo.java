// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.storage;

import javax.annotation.Nullable;
import net.minecraft.world.GameRules;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameType;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.DimensionType;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.WorldType;

public class DerivedWorldInfo extends WorldInfo
{
    private final /* synthetic */ WorldInfo theWorldInfo;
    
    @Override
    public int getSpawnY() {
        return this.theWorldInfo.getSpawnY();
    }
    
    @Override
    public void setSpawnY(final int llllllllllllIIIlIIIlIlIllllIlllI) {
    }
    
    @Override
    public void setSpawnZ(final int llllllllllllIIIlIIIlIlIllllIllII) {
    }
    
    @Override
    public String getWorldName() {
        return this.theWorldInfo.getWorldName();
    }
    
    @Override
    public boolean isRaining() {
        return this.theWorldInfo.isRaining();
    }
    
    @Override
    public void setTerrainType(final WorldType llllllllllllIIIlIIIlIlIlllIIllll) {
    }
    
    @Override
    public boolean isInitialized() {
        return this.theWorldInfo.isInitialized();
    }
    
    @Override
    public void setWorldTotalTime(final long llllllllllllIIIlIIIlIlIllllIlIlI) {
    }
    
    @Override
    public void setSpawnX(final int llllllllllllIIIlIIIlIlIlllllIIII) {
    }
    
    @Override
    public void setDifficultyLocked(final boolean llllllllllllIIIlIIIlIlIllIlllIII) {
    }
    
    @Override
    public void setThunderTime(final int llllllllllllIIIlIIIlIlIlllIllllI) {
    }
    
    @Override
    public NBTTagCompound getPlayerNBTTagCompound() {
        return this.theWorldInfo.getPlayerNBTTagCompound();
    }
    
    @Override
    public boolean isHardcoreModeEnabled() {
        return this.theWorldInfo.isHardcoreModeEnabled();
    }
    
    @Override
    public boolean areCommandsAllowed() {
        return this.theWorldInfo.areCommandsAllowed();
    }
    
    @Override
    public WorldType getTerrainType() {
        return this.theWorldInfo.getTerrainType();
    }
    
    @Override
    public boolean isThundering() {
        return this.theWorldInfo.isThundering();
    }
    
    @Override
    public void setRainTime(final int llllllllllllIIIlIIIlIlIlllIllIlI) {
    }
    
    @Override
    public int getRainTime() {
        return this.theWorldInfo.getRainTime();
    }
    
    @Override
    public void setSaveVersion(final int llllllllllllIIIlIIIlIlIllllIIIlI) {
    }
    
    @Override
    public long getLastTimePlayed() {
        return this.theWorldInfo.getLastTimePlayed();
    }
    
    @Override
    public void setRaining(final boolean llllllllllllIIIlIIIlIlIlllIlllII) {
    }
    
    public DerivedWorldInfo(final WorldInfo llllllllllllIIIlIIIlIllIIIlIlIlI) {
        this.theWorldInfo = llllllllllllIIIlIIIlIllIIIlIlIlI;
    }
    
    @Override
    public void setDimensionData(final DimensionType llllllllllllIIIlIIIlIlIllIllIIII, final NBTTagCompound llllllllllllIIIlIIIlIlIllIlIllll) {
        this.theWorldInfo.setDimensionData(llllllllllllIIIlIIIlIlIllIllIIII, llllllllllllIIIlIIIlIlIllIlIllll);
    }
    
    @Override
    public int getSpawnX() {
        return this.theWorldInfo.getSpawnX();
    }
    
    @Override
    public long getWorldTotalTime() {
        return this.theWorldInfo.getWorldTotalTime();
    }
    
    @Override
    public boolean isMapFeaturesEnabled() {
        return this.theWorldInfo.isMapFeaturesEnabled();
    }
    
    @Override
    public int getThunderTime() {
        return this.theWorldInfo.getThunderTime();
    }
    
    @Override
    public long getSizeOnDisk() {
        return this.theWorldInfo.getSizeOnDisk();
    }
    
    @Override
    public void setThundering(final boolean llllllllllllIIIlIIIlIlIllllIIIII) {
    }
    
    @Override
    public EnumDifficulty getDifficulty() {
        return this.theWorldInfo.getDifficulty();
    }
    
    @Override
    public GameType getGameType() {
        return this.theWorldInfo.getGameType();
    }
    
    @Override
    public int getSpawnZ() {
        return this.theWorldInfo.getSpawnZ();
    }
    
    @Override
    public void setSpawn(final BlockPos llllllllllllIIIlIIIlIlIllllIIllI) {
    }
    
    @Override
    public void setWorldTime(final long llllllllllllIIIlIIIlIlIllllIlIII) {
    }
    
    @Override
    public void setDifficulty(final EnumDifficulty llllllllllllIIIlIIIlIlIllIllllIl) {
    }
    
    @Override
    public GameRules getGameRulesInstance() {
        return this.theWorldInfo.getGameRulesInstance();
    }
    
    @Override
    public long getSeed() {
        return this.theWorldInfo.getSeed();
    }
    
    @Override
    public void setAllowCommands(final boolean llllllllllllIIIlIIIlIlIlllIIlIlI) {
    }
    
    @Override
    public void setWorldName(final String llllllllllllIIIlIIIlIlIllllIIlII) {
    }
    
    @Override
    public NBTTagCompound getDimensionData(final DimensionType llllllllllllIIIlIIIlIlIllIlIlIll) {
        return this.theWorldInfo.getDimensionData(llllllllllllIIIlIIIlIlIllIlIlIll);
    }
    
    @Override
    public boolean isDifficultyLocked() {
        return this.theWorldInfo.isDifficultyLocked();
    }
    
    @Override
    public long getWorldTime() {
        return this.theWorldInfo.getWorldTime();
    }
    
    @Override
    public NBTTagCompound cloneNBTCompound(@Nullable final NBTTagCompound llllllllllllIIIlIIIlIllIIIlIIlII) {
        return this.theWorldInfo.cloneNBTCompound(llllllllllllIIIlIIIlIllIIIlIIlII);
    }
    
    @Override
    public void setServerInitialized(final boolean llllllllllllIIIlIIIlIlIlllIIIlIl) {
    }
    
    @Override
    public int getSaveVersion() {
        return this.theWorldInfo.getSaveVersion();
    }
}
