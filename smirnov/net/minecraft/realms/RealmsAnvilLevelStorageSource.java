// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.realms;

import net.minecraft.util.IProgressUpdate;
import net.minecraft.client.AnvilConverterException;
import net.minecraft.world.storage.WorldSummary;
import com.google.common.collect.Lists;
import java.util.List;
import net.minecraft.world.storage.ISaveFormat;

public class RealmsAnvilLevelStorageSource
{
    private final /* synthetic */ ISaveFormat levelStorageSource;
    
    public RealmsAnvilLevelStorageSource(final ISaveFormat lllllllllllllIllIIlIIlllIIIIIIlI) {
        this.levelStorageSource = lllllllllllllIllIIlIIlllIIIIIIlI;
    }
    
    public boolean levelExists(final String lllllllllllllIllIIlIIllIlllllIll) {
        return this.levelStorageSource.canLoadWorld(lllllllllllllIllIIlIIllIlllllIll);
    }
    
    public boolean requiresConversion(final String lllllllllllllIllIIlIIllIlllIllII) {
        return this.levelStorageSource.isOldMapFormat(lllllllllllllIllIIlIIllIlllIllII);
    }
    
    public boolean isNewLevelIdAcceptable(final String lllllllllllllIllIIlIIllIlllIIllI) {
        return this.levelStorageSource.isNewLevelIdAcceptable(lllllllllllllIllIIlIIllIlllIIllI);
    }
    
    public void renameLevel(final String lllllllllllllIllIIlIIllIllIlIIII, final String lllllllllllllIllIIlIIllIllIIllll) {
        this.levelStorageSource.renameWorld(lllllllllllllIllIIlIIllIllIlIIII, lllllllllllllIllIIlIIllIllIIllll);
    }
    
    public List<RealmsLevelSummary> getLevelList() throws AnvilConverterException {
        final List<RealmsLevelSummary> lllllllllllllIllIIlIIllIllIIIllI = (List<RealmsLevelSummary>)Lists.newArrayList();
        for (final WorldSummary lllllllllllllIllIIlIIllIllIIIlIl : this.levelStorageSource.getSaveList()) {
            lllllllllllllIllIIlIIllIllIIIllI.add(new RealmsLevelSummary(lllllllllllllIllIIlIIllIllIIIlIl));
        }
        return lllllllllllllIllIIlIIllIllIIIllI;
    }
    
    public boolean isConvertible(final String lllllllllllllIllIIlIIllIllIllIII) {
        return this.levelStorageSource.isConvertible(lllllllllllllIllIIlIIllIllIllIII);
    }
    
    public void clearAll() {
        this.levelStorageSource.flushCache();
    }
    
    public String getName() {
        return this.levelStorageSource.getName();
    }
    
    public boolean deleteLevel(final String lllllllllllllIllIIlIIllIllIllllI) {
        return this.levelStorageSource.deleteWorldDirectory(lllllllllllllIllIIlIIllIllIllllI);
    }
    
    public boolean convertLevel(final String lllllllllllllIllIIlIIllIllllIlII, final IProgressUpdate lllllllllllllIllIIlIIllIllllIIll) {
        return this.levelStorageSource.convertMapFormat(lllllllllllllIllIIlIIllIllllIlII, lllllllllllllIllIIlIIllIllllIIll);
    }
}
