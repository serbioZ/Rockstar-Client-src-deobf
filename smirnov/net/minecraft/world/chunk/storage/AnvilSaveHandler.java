// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.chunk.storage;

import net.minecraft.util.datafix.DataFixer;
import javax.annotation.Nullable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.storage.WorldInfo;
import net.minecraft.world.storage.ThreadedFileIOBase;
import net.minecraft.world.WorldProviderEnd;
import java.io.File;
import net.minecraft.world.WorldProviderHell;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.storage.SaveHandler;

public class AnvilSaveHandler extends SaveHandler
{
    @Override
    public IChunkLoader getChunkLoader(final WorldProvider lllllllllllIlIIIlIllIlIlIlIlIIII) {
        final File lllllllllllIlIIIlIllIlIlIlIIllll = this.getWorldDirectory();
        if (lllllllllllIlIIIlIllIlIlIlIlIIII instanceof WorldProviderHell) {
            final File lllllllllllIlIIIlIllIlIlIlIIlllI = new File(lllllllllllIlIIIlIllIlIlIlIIllll, "DIM-1");
            lllllllllllIlIIIlIllIlIlIlIIlllI.mkdirs();
            return new AnvilChunkLoader(lllllllllllIlIIIlIllIlIlIlIIlllI, this.dataFixer);
        }
        if (lllllllllllIlIIIlIllIlIlIlIlIIII instanceof WorldProviderEnd) {
            final File lllllllllllIlIIIlIllIlIlIlIIllIl = new File(lllllllllllIlIIIlIllIlIlIlIIllll, "DIM1");
            lllllllllllIlIIIlIllIlIlIlIIllIl.mkdirs();
            return new AnvilChunkLoader(lllllllllllIlIIIlIllIlIlIlIIllIl, this.dataFixer);
        }
        return new AnvilChunkLoader(lllllllllllIlIIIlIllIlIlIlIIllll, this.dataFixer);
    }
    
    @Override
    public void flush() {
        try {
            ThreadedFileIOBase.getThreadedIOInstance().waitForFinish();
        }
        catch (InterruptedException lllllllllllIlIIIlIllIlIlIIllllIl) {
            lllllllllllIlIIIlIllIlIlIIllllIl.printStackTrace();
        }
        RegionFileCache.clearRegionFileReferences();
    }
    
    @Override
    public void saveWorldInfoWithPlayer(final WorldInfo lllllllllllIlIIIlIllIlIlIlIIIlII, @Nullable final NBTTagCompound lllllllllllIlIIIlIllIlIlIlIIIIll) {
        lllllllllllIlIIIlIllIlIlIlIIIlII.setSaveVersion(19133);
        super.saveWorldInfoWithPlayer(lllllllllllIlIIIlIllIlIlIlIIIlII, lllllllllllIlIIIlIllIlIlIlIIIIll);
    }
    
    public AnvilSaveHandler(final File lllllllllllIlIIIlIllIlIlIlIllllI, final String lllllllllllIlIIIlIllIlIlIlIlllIl, final boolean lllllllllllIlIIIlIllIlIlIlIlllII, final DataFixer lllllllllllIlIIIlIllIlIlIlIllIll) {
        super(lllllllllllIlIIIlIllIlIlIlIllllI, lllllllllllIlIIIlIllIlIlIlIlllIl, lllllllllllIlIIIlIllIlIlIlIlllII, lllllllllllIlIIIlIllIlIlIlIllIll);
    }
}
