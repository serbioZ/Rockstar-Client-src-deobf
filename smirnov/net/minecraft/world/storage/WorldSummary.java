// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.storage;

import net.minecraft.util.text.translation.I18n;
import net.minecraft.util.StringUtils;
import net.minecraft.world.GameType;

public class WorldSummary implements Comparable<WorldSummary>
{
    private final /* synthetic */ String displayName;
    private final /* synthetic */ String versionName;
    private final /* synthetic */ boolean versionSnapshot;
    private final /* synthetic */ GameType theEnumGameType;
    private final /* synthetic */ boolean cheatsEnabled;
    private final /* synthetic */ long lastTimePlayed;
    private final /* synthetic */ boolean requiresConversion;
    private final /* synthetic */ boolean hardcore;
    private final /* synthetic */ int versionId;
    private final /* synthetic */ String fileName;
    private final /* synthetic */ long sizeOnDisk;
    
    public String getDisplayName() {
        return this.displayName;
    }
    
    public boolean isHardcoreModeEnabled() {
        return this.hardcore;
    }
    
    public long getSizeOnDisk() {
        return this.sizeOnDisk;
    }
    
    public String getVersionName() {
        return StringUtils.isNullOrEmpty(this.versionName) ? I18n.translateToLocal("selectWorld.versionUnknown") : this.versionName;
    }
    
    public boolean getCheatsEnabled() {
        return this.cheatsEnabled;
    }
    
    public boolean requiresConversion() {
        return this.requiresConversion;
    }
    
    @Override
    public int compareTo(final WorldSummary lllllllllllIllIllllllIllIIIIIlII) {
        if (this.lastTimePlayed < lllllllllllIllIllllllIllIIIIIlII.lastTimePlayed) {
            return 1;
        }
        return (this.lastTimePlayed > lllllllllllIllIllllllIllIIIIIlII.lastTimePlayed) ? -1 : this.fileName.compareTo(lllllllllllIllIllllllIllIIIIIlII.fileName);
    }
    
    public String getFileName() {
        return this.fileName;
    }
    
    public long getLastTimePlayed() {
        return this.lastTimePlayed;
    }
    
    public GameType getEnumGameType() {
        return this.theEnumGameType;
    }
    
    public boolean askToOpenWorld() {
        return this.versionId > 1343;
    }
    
    public WorldSummary(final WorldInfo lllllllllllIllIllllllIllIIIllIll, final String lllllllllllIllIllllllIllIIlIIIII, final String lllllllllllIllIllllllIllIIIllIIl, final long lllllllllllIllIllllllIllIIIllIII, final boolean lllllllllllIllIllllllIllIIIlllIl) {
        this.fileName = lllllllllllIllIllllllIllIIlIIIII;
        this.displayName = lllllllllllIllIllllllIllIIIllIIl;
        this.lastTimePlayed = lllllllllllIllIllllllIllIIIllIll.getLastTimePlayed();
        this.sizeOnDisk = lllllllllllIllIllllllIllIIIllIII;
        this.theEnumGameType = lllllllllllIllIllllllIllIIIllIll.getGameType();
        this.requiresConversion = lllllllllllIllIllllllIllIIIlllIl;
        this.hardcore = lllllllllllIllIllllllIllIIIllIll.isHardcoreModeEnabled();
        this.cheatsEnabled = lllllllllllIllIllllllIllIIIllIll.areCommandsAllowed();
        this.versionName = lllllllllllIllIllllllIllIIIllIll.getVersionName();
        this.versionId = lllllllllllIllIllllllIllIIIllIll.getVersionId();
        this.versionSnapshot = lllllllllllIllIllllllIllIIIllIll.isVersionSnapshot();
    }
    
    public boolean markVersionInList() {
        return this.askToOpenWorld();
    }
}
