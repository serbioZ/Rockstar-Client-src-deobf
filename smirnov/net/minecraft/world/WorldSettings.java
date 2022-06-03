// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world;

import net.minecraft.world.storage.WorldInfo;

public final class WorldSettings
{
    private final /* synthetic */ boolean mapFeaturesEnabled;
    private final /* synthetic */ boolean hardcoreEnabled;
    private final /* synthetic */ GameType theGameType;
    private /* synthetic */ boolean commandsAllowed;
    private final /* synthetic */ WorldType terrainType;
    private /* synthetic */ String generatorOptions;
    private /* synthetic */ boolean bonusChestEnabled;
    private final /* synthetic */ long seed;
    
    public WorldSettings(final long lllllllllllIlIIIlIlIlIIIIllllIlI, final GameType lllllllllllIlIIIlIlIlIIIIllllIIl, final boolean lllllllllllIlIIIlIlIlIIIIllllIII, final boolean lllllllllllIlIIIlIlIlIIIIlllIlll, final WorldType lllllllllllIlIIIlIlIlIIIIlllIllI) {
        this.generatorOptions = "";
        this.seed = lllllllllllIlIIIlIlIlIIIIllllIlI;
        this.theGameType = lllllllllllIlIIIlIlIlIIIIllllIIl;
        this.mapFeaturesEnabled = lllllllllllIlIIIlIlIlIIIIllllIII;
        this.hardcoreEnabled = lllllllllllIlIIIlIlIlIIIIlllIlll;
        this.terrainType = lllllllllllIlIIIlIlIlIIIIlllIllI;
    }
    
    public boolean areCommandsAllowed() {
        return this.commandsAllowed;
    }
    
    public boolean isBonusChestEnabled() {
        return this.bonusChestEnabled;
    }
    
    public WorldType getTerrainType() {
        return this.terrainType;
    }
    
    public String getGeneratorOptions() {
        return this.generatorOptions;
    }
    
    public GameType getGameType() {
        return this.theGameType;
    }
    
    public WorldSettings(final WorldInfo lllllllllllIlIIIlIlIlIIIIlllIIlI) {
        this(lllllllllllIlIIIlIlIlIIIIlllIIlI.getSeed(), lllllllllllIlIIIlIlIlIIIIlllIIlI.getGameType(), lllllllllllIlIIIlIlIlIIIIlllIIlI.isMapFeaturesEnabled(), lllllllllllIlIIIlIlIlIIIIlllIIlI.isHardcoreModeEnabled(), lllllllllllIlIIIlIlIlIIIIlllIIlI.getTerrainType());
    }
    
    public WorldSettings enableCommands() {
        this.commandsAllowed = true;
        return this;
    }
    
    public WorldSettings enableBonusChest() {
        this.bonusChestEnabled = true;
        return this;
    }
    
    public boolean isMapFeaturesEnabled() {
        return this.mapFeaturesEnabled;
    }
    
    public static GameType getGameTypeById(final int lllllllllllIlIIIlIlIlIIIIlIIllIl) {
        return GameType.getByID(lllllllllllIlIIIlIlIlIIIIlIIllIl);
    }
    
    public boolean getHardcoreEnabled() {
        return this.hardcoreEnabled;
    }
    
    public long getSeed() {
        return this.seed;
    }
    
    public WorldSettings setGeneratorOptions(final String lllllllllllIlIIIlIlIlIIIIllIIlII) {
        this.generatorOptions = lllllllllllIlIIIlIlIlIIIIllIIlII;
        return this;
    }
}
