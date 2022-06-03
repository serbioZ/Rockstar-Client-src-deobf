// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.chunk.storage;

import java.io.DataOutputStream;
import com.google.common.collect.Maps;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.File;
import java.util.Map;

public class RegionFileCache
{
    private static final /* synthetic */ Map<File, RegionFile> REGIONS_BY_FILE;
    
    public static synchronized RegionFile func_191065_b(final File lllllllllllIIIIIIIlIlllIllllIIlI, final int lllllllllllIIIIIIIlIlllIllllIIIl, final int lllllllllllIIIIIIIlIlllIllllIIII) {
        final File lllllllllllIIIIIIIlIlllIllllIllI = new File(lllllllllllIIIIIIIlIlllIllllIIlI, "region");
        final File lllllllllllIIIIIIIlIlllIllllIlIl = new File(lllllllllllIIIIIIIlIlllIllllIllI, "r." + (lllllllllllIIIIIIIlIlllIllllIIIl >> 5) + "." + (lllllllllllIIIIIIIlIlllIllllIIII >> 5) + ".mca");
        final RegionFile lllllllllllIIIIIIIlIlllIllllIlII = RegionFileCache.REGIONS_BY_FILE.get(lllllllllllIIIIIIIlIlllIllllIlIl);
        if (lllllllllllIIIIIIIlIlllIllllIlII != null) {
            return lllllllllllIIIIIIIlIlllIllllIlII;
        }
        if (lllllllllllIIIIIIIlIlllIllllIllI.exists() && lllllllllllIIIIIIIlIlllIllllIlIl.exists()) {
            if (RegionFileCache.REGIONS_BY_FILE.size() >= 256) {
                clearRegionFileReferences();
            }
            final RegionFile lllllllllllIIIIIIIlIlllIllllIIll = new RegionFile(lllllllllllIIIIIIIlIlllIllllIlIl);
            RegionFileCache.REGIONS_BY_FILE.put(lllllllllllIIIIIIIlIlllIllllIlIl, lllllllllllIIIIIIIlIlllIllllIIll);
            return lllllllllllIIIIIIIlIlllIllllIIll;
        }
        return null;
    }
    
    public static DataInputStream getChunkInputStream(final File lllllllllllIIIIIIIlIlllIllIllIll, final int lllllllllllIIIIIIIlIlllIllIllllI, final int lllllllllllIIIIIIIlIlllIllIllIIl) {
        final RegionFile lllllllllllIIIIIIIlIlllIllIlllII = createOrLoadRegionFile(lllllllllllIIIIIIIlIlllIllIllIll, lllllllllllIIIIIIIlIlllIllIllllI, lllllllllllIIIIIIIlIlllIllIllIIl);
        return lllllllllllIIIIIIIlIlllIllIlllII.getChunkDataInputStream(lllllllllllIIIIIIIlIlllIllIllllI & 0x1F, lllllllllllIIIIIIIlIlllIllIllIIl & 0x1F);
    }
    
    public static synchronized void clearRegionFileReferences() {
        for (final RegionFile lllllllllllIIIIIIIlIlllIlllIlIII : RegionFileCache.REGIONS_BY_FILE.values()) {
            try {
                if (lllllllllllIIIIIIIlIlllIlllIlIII == null) {
                    continue;
                }
                lllllllllllIIIIIIIlIlllIlllIlIII.close();
            }
            catch (IOException lllllllllllIIIIIIIlIlllIlllIIlll) {
                lllllllllllIIIIIIIlIlllIlllIIlll.printStackTrace();
            }
        }
        RegionFileCache.REGIONS_BY_FILE.clear();
    }
    
    static {
        REGIONS_BY_FILE = Maps.newHashMap();
    }
    
    public static DataOutputStream getChunkOutputStream(final File lllllllllllIIIIIIIlIlllIllIlIIll, final int lllllllllllIIIIIIIlIlllIllIIlllI, final int lllllllllllIIIIIIIlIlllIllIlIIIl) {
        final RegionFile lllllllllllIIIIIIIlIlllIllIlIIII = createOrLoadRegionFile(lllllllllllIIIIIIIlIlllIllIlIIll, lllllllllllIIIIIIIlIlllIllIIlllI, lllllllllllIIIIIIIlIlllIllIlIIIl);
        return lllllllllllIIIIIIIlIlllIllIlIIII.getChunkDataOutputStream(lllllllllllIIIIIIIlIlllIllIIlllI & 0x1F, lllllllllllIIIIIIIlIlllIllIlIIIl & 0x1F);
    }
    
    public static boolean func_191064_f(final File lllllllllllIIIIIIIlIlllIllIIIlll, final int lllllllllllIIIIIIIlIlllIllIIIIlI, final int lllllllllllIIIIIIIlIlllIllIIIIIl) {
        final RegionFile lllllllllllIIIIIIIlIlllIllIIIlII = func_191065_b(lllllllllllIIIIIIIlIlllIllIIIlll, lllllllllllIIIIIIIlIlllIllIIIIlI, lllllllllllIIIIIIIlIlllIllIIIIIl);
        return lllllllllllIIIIIIIlIlllIllIIIlII != null && lllllllllllIIIIIIIlIlllIllIIIlII.isChunkSaved(lllllllllllIIIIIIIlIlllIllIIIIlI & 0x1F, lllllllllllIIIIIIIlIlllIllIIIIIl & 0x1F);
    }
    
    public static synchronized RegionFile createOrLoadRegionFile(final File lllllllllllIIIIIIIlIllllIIIIlllI, final int lllllllllllIIIIIIIlIllllIIIIllIl, final int lllllllllllIIIIIIIlIllllIIIIIlIl) {
        final File lllllllllllIIIIIIIlIllllIIIIlIll = new File(lllllllllllIIIIIIIlIllllIIIIlllI, "region");
        final File lllllllllllIIIIIIIlIllllIIIIlIlI = new File(lllllllllllIIIIIIIlIllllIIIIlIll, "r." + (lllllllllllIIIIIIIlIllllIIIIllIl >> 5) + "." + (lllllllllllIIIIIIIlIllllIIIIIlIl >> 5) + ".mca");
        final RegionFile lllllllllllIIIIIIIlIllllIIIIlIIl = RegionFileCache.REGIONS_BY_FILE.get(lllllllllllIIIIIIIlIllllIIIIlIlI);
        if (lllllllllllIIIIIIIlIllllIIIIlIIl != null) {
            return lllllllllllIIIIIIIlIllllIIIIlIIl;
        }
        if (!lllllllllllIIIIIIIlIllllIIIIlIll.exists()) {
            lllllllllllIIIIIIIlIllllIIIIlIll.mkdirs();
        }
        if (RegionFileCache.REGIONS_BY_FILE.size() >= 256) {
            clearRegionFileReferences();
        }
        final RegionFile lllllllllllIIIIIIIlIllllIIIIlIII = new RegionFile(lllllllllllIIIIIIIlIllllIIIIlIlI);
        RegionFileCache.REGIONS_BY_FILE.put(lllllllllllIIIIIIIlIllllIIIIlIlI, lllllllllllIIIIIIIlIllllIIIIlIII);
        return lllllllllllIIIIIIIlIllllIIIIlIII;
    }
}
