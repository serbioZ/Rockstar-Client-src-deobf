// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.realms;

import net.minecraft.world.storage.WorldSummary;

public class RealmsLevelSummary implements Comparable<RealmsLevelSummary>
{
    private final /* synthetic */ WorldSummary levelSummary;
    
    public int compareTo(final WorldSummary lllllllllllIlllIlIlIIIllllIIIllI) {
        return this.levelSummary.compareTo(lllllllllllIlllIlIlIIIllllIIIllI);
    }
    
    public long getSizeOnDisk() {
        return this.levelSummary.getSizeOnDisk();
    }
    
    public boolean isRequiresConversion() {
        return this.levelSummary.requiresConversion();
    }
    
    public RealmsLevelSummary(final WorldSummary lllllllllllIlllIlIlIIIllllIlllll) {
        this.levelSummary = lllllllllllIlllIlIlIIIllllIlllll;
    }
    
    public boolean hasCheats() {
        return this.levelSummary.getCheatsEnabled();
    }
    
    public String getLevelId() {
        return this.levelSummary.getFileName();
    }
    
    public boolean isHardcore() {
        return this.levelSummary.isHardcoreModeEnabled();
    }
    
    public int getGameMode() {
        return this.levelSummary.getEnumGameType().getID();
    }
    
    public String getLevelName() {
        return this.levelSummary.getDisplayName();
    }
    
    @Override
    public int compareTo(final RealmsLevelSummary lllllllllllIlllIlIlIIIlllIlllIll) {
        if (this.levelSummary.getLastTimePlayed() < lllllllllllIlllIlIlIIIlllIlllIll.getLastPlayed()) {
            return 1;
        }
        return (this.levelSummary.getLastTimePlayed() > lllllllllllIlllIlIlIIIlllIlllIll.getLastPlayed()) ? -1 : this.levelSummary.getFileName().compareTo(lllllllllllIlllIlIlIIIlllIlllIll.getLevelId());
    }
    
    public long getLastPlayed() {
        return this.levelSummary.getLastTimePlayed();
    }
}
