// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.chunk.storage;

import java.io.ByteArrayOutputStream;
import net.minecraft.server.MinecraftServer;
import java.io.BufferedOutputStream;
import java.util.zip.DeflaterOutputStream;
import java.io.OutputStream;
import java.io.DataOutputStream;
import com.google.common.collect.Lists;
import javax.annotation.Nullable;
import java.io.IOException;
import java.util.zip.InflaterInputStream;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.util.List;
import java.io.RandomAccessFile;
import java.io.File;

public class RegionFile
{
    private final /* synthetic */ File fileName;
    private static final /* synthetic */ byte[] EMPTY_SECTOR;
    private /* synthetic */ RandomAccessFile dataFile;
    private /* synthetic */ int sizeDelta;
    private final /* synthetic */ int[] offsets;
    private /* synthetic */ List<Boolean> sectorFree;
    private final /* synthetic */ int[] chunkTimestamps;
    private /* synthetic */ long lastModified;
    
    @Nullable
    public synchronized DataInputStream getChunkDataInputStream(final int lllllllllllllIIlIllllIIIlIlIIlII, final int lllllllllllllIIlIllllIIIlIlIIIll) {
        if (this.outOfBounds(lllllllllllllIIlIllllIIIlIlIIlII, lllllllllllllIIlIllllIIIlIlIIIll)) {
            return null;
        }
        try {
            final int lllllllllllllIIlIllllIIIlIlIIIlI = this.getOffset(lllllllllllllIIlIllllIIIlIlIIlII, lllllllllllllIIlIllllIIIlIlIIIll);
            if (lllllllllllllIIlIllllIIIlIlIIIlI == 0) {
                return null;
            }
            final int lllllllllllllIIlIllllIIIlIlIIIIl = lllllllllllllIIlIllllIIIlIlIIIlI >> 8;
            final int lllllllllllllIIlIllllIIIlIlIIIII = lllllllllllllIIlIllllIIIlIlIIIlI & 0xFF;
            if (lllllllllllllIIlIllllIIIlIlIIIIl + lllllllllllllIIlIllllIIIlIlIIIII > this.sectorFree.size()) {
                return null;
            }
            this.dataFile.seek(lllllllllllllIIlIllllIIIlIlIIIIl * 4096);
            final int lllllllllllllIIlIllllIIIlIIlllll = this.dataFile.readInt();
            if (lllllllllllllIIlIllllIIIlIIlllll > 4096 * lllllllllllllIIlIllllIIIlIlIIIII) {
                return null;
            }
            if (lllllllllllllIIlIllllIIIlIIlllll <= 0) {
                return null;
            }
            final byte lllllllllllllIIlIllllIIIlIIllllI = this.dataFile.readByte();
            if (lllllllllllllIIlIllllIIIlIIllllI == 1) {
                final byte[] lllllllllllllIIlIllllIIIlIIlllIl = new byte[lllllllllllllIIlIllllIIIlIIlllll - 1];
                this.dataFile.read(lllllllllllllIIlIllllIIIlIIlllIl);
                return new DataInputStream(new BufferedInputStream(new GZIPInputStream(new ByteArrayInputStream(lllllllllllllIIlIllllIIIlIIlllIl))));
            }
            if (lllllllllllllIIlIllllIIIlIIllllI == 2) {
                final byte[] lllllllllllllIIlIllllIIIlIIlllII = new byte[lllllllllllllIIlIllllIIIlIIlllll - 1];
                this.dataFile.read(lllllllllllllIIlIllllIIIlIIlllII);
                return new DataInputStream(new BufferedInputStream(new InflaterInputStream(new ByteArrayInputStream(lllllllllllllIIlIllllIIIlIIlllII))));
            }
            return null;
        }
        catch (IOException lllllllllllllIIlIllllIIIlIIllIll) {
            return null;
        }
    }
    
    private void setOffset(final int lllllllllllllIIlIllllIIIIIllIllI, final int lllllllllllllIIlIllllIIIIIllIlIl, final int lllllllllllllIIlIllllIIIIIllIIII) throws IOException {
        this.offsets[lllllllllllllIIlIllllIIIIIllIllI + lllllllllllllIIlIllllIIIIIllIlIl * 32] = lllllllllllllIIlIllllIIIIIllIIII;
        this.dataFile.seek((lllllllllllllIIlIllllIIIIIllIllI + lllllllllllllIIlIllllIIIIIllIlIl * 32) * 4);
        this.dataFile.writeInt(lllllllllllllIIlIllllIIIIIllIIII);
    }
    
    private int getOffset(final int lllllllllllllIIlIllllIIIIlIIIllI, final int lllllllllllllIIlIllllIIIIlIIIlIl) {
        return this.offsets[lllllllllllllIIlIllllIIIIlIIIllI + lllllllllllllIIlIllllIIIIlIIIlIl * 32];
    }
    
    private void setChunkTimestamp(final int lllllllllllllIIlIllllIIIIIlIIllI, final int lllllllllllllIIlIllllIIIIIlIlIIl, final int lllllllllllllIIlIllllIIIIIlIIlII) throws IOException {
        this.chunkTimestamps[lllllllllllllIIlIllllIIIIIlIIllI + lllllllllllllIIlIllllIIIIIlIlIIl * 32] = lllllllllllllIIlIllllIIIIIlIIlII;
        this.dataFile.seek(4096 + (lllllllllllllIIlIllllIIIIIlIIllI + lllllllllllllIIlIllllIIIIIlIlIIl * 32) * 4);
        this.dataFile.writeInt(lllllllllllllIIlIllllIIIIIlIIlII);
    }
    
    public RegionFile(final File lllllllllllllIIlIllllIIIlIllIIll) {
        this.offsets = new int[1024];
        this.chunkTimestamps = new int[1024];
        this.fileName = lllllllllllllIIlIllllIIIlIllIIll;
        this.sizeDelta = 0;
        try {
            if (lllllllllllllIIlIllllIIIlIllIIll.exists()) {
                this.lastModified = lllllllllllllIIlIllllIIIlIllIIll.lastModified();
            }
            this.dataFile = new RandomAccessFile(lllllllllllllIIlIllllIIIlIllIIll, "rw");
            if (this.dataFile.length() < 4096L) {
                this.dataFile.write(RegionFile.EMPTY_SECTOR);
                this.dataFile.write(RegionFile.EMPTY_SECTOR);
                this.sizeDelta += 8192;
            }
            if ((this.dataFile.length() & 0xFFFL) != 0x0L) {
                for (int lllllllllllllIIlIllllIIIlIllllIl = 0; lllllllllllllIIlIllllIIIlIllllIl < (this.dataFile.length() & 0xFFFL); ++lllllllllllllIIlIllllIIIlIllllIl) {
                    this.dataFile.write(0);
                }
            }
            final int lllllllllllllIIlIllllIIIlIllllII = (int)this.dataFile.length() / 4096;
            this.sectorFree = (List<Boolean>)Lists.newArrayListWithCapacity(lllllllllllllIIlIllllIIIlIllllII);
            for (int lllllllllllllIIlIllllIIIlIlllIll = 0; lllllllllllllIIlIllllIIIlIlllIll < lllllllllllllIIlIllllIIIlIllllII; ++lllllllllllllIIlIllllIIIlIlllIll) {
                this.sectorFree.add(true);
            }
            this.sectorFree.set(0, false);
            this.sectorFree.set(1, false);
            this.dataFile.seek(0L);
            for (int lllllllllllllIIlIllllIIIlIlllIlI = 0; lllllllllllllIIlIllllIIIlIlllIlI < 1024; ++lllllllllllllIIlIllllIIIlIlllIlI) {
                final int lllllllllllllIIlIllllIIIlIlllIIl = this.dataFile.readInt();
                this.offsets[lllllllllllllIIlIllllIIIlIlllIlI] = lllllllllllllIIlIllllIIIlIlllIIl;
                if (lllllllllllllIIlIllllIIIlIlllIIl != 0 && (lllllllllllllIIlIllllIIIlIlllIIl >> 8) + (lllllllllllllIIlIllllIIIlIlllIIl & 0xFF) <= this.sectorFree.size()) {
                    for (int lllllllllllllIIlIllllIIIlIlllIII = 0; lllllllllllllIIlIllllIIIlIlllIII < (lllllllllllllIIlIllllIIIlIlllIIl & 0xFF); ++lllllllllllllIIlIllllIIIlIlllIII) {
                        this.sectorFree.set((lllllllllllllIIlIllllIIIlIlllIIl >> 8) + lllllllllllllIIlIllllIIIlIlllIII, false);
                    }
                }
            }
            for (int lllllllllllllIIlIllllIIIlIllIlll = 0; lllllllllllllIIlIllllIIIlIllIlll < 1024; ++lllllllllllllIIlIllllIIIlIllIlll) {
                final int lllllllllllllIIlIllllIIIlIllIllI = this.dataFile.readInt();
                this.chunkTimestamps[lllllllllllllIIlIllllIIIlIllIlll] = lllllllllllllIIlIllllIIIlIllIllI;
            }
        }
        catch (IOException lllllllllllllIIlIllllIIIlIllIlIl) {
            lllllllllllllIIlIllllIIIlIllIlIl.printStackTrace();
        }
    }
    
    private void write(final int lllllllllllllIIlIllllIIIIlIlIlll, final byte[] lllllllllllllIIlIllllIIIIlIllIlI, final int lllllllllllllIIlIllllIIIIlIllIIl) throws IOException {
        this.dataFile.seek(lllllllllllllIIlIllllIIIIlIlIlll * 4096);
        this.dataFile.writeInt(lllllllllllllIIlIllllIIIIlIllIIl + 1);
        this.dataFile.writeByte(2);
        this.dataFile.write(lllllllllllllIIlIllllIIIIlIllIlI, 0, lllllllllllllIIlIllllIIIIlIllIIl);
    }
    
    @Nullable
    public DataOutputStream getChunkDataOutputStream(final int lllllllllllllIIlIllllIIIlIIIllIl, final int lllllllllllllIIlIllllIIIlIIIlIIl) {
        DataOutputStream dataOutputStream;
        if (this.outOfBounds(lllllllllllllIIlIllllIIIlIIIllIl, lllllllllllllIIlIllllIIIlIIIlIIl)) {
            dataOutputStream = null;
        }
        else {
            final BufferedOutputStream out;
            dataOutputStream = new DataOutputStream(out);
            out = new BufferedOutputStream(new DeflaterOutputStream(new ChunkBuffer(lllllllllllllIIlIllllIIIlIIIllIl, lllllllllllllIIlIllllIIIlIIIlIIl)));
        }
        return dataOutputStream;
    }
    
    public void close() throws IOException {
        if (this.dataFile != null) {
            this.dataFile.close();
        }
    }
    
    public boolean isChunkSaved(final int lllllllllllllIIlIllllIIIIlIIIIII, final int lllllllllllllIIlIllllIIIIIllllII) {
        return this.getOffset(lllllllllllllIIlIllllIIIIlIIIIII, lllllllllllllIIlIllllIIIIIllllII) != 0;
    }
    
    private boolean outOfBounds(final int lllllllllllllIIlIllllIIIIlIlIIIl, final int lllllllllllllIIlIllllIIIIlIIlllI) {
        return lllllllllllllIIlIllllIIIIlIlIIIl < 0 || lllllllllllllIIlIllllIIIIlIlIIIl >= 32 || lllllllllllllIIlIllllIIIIlIIlllI < 0 || lllllllllllllIIlIllllIIIIlIIlllI >= 32;
    }
    
    protected synchronized void write(final int lllllllllllllIIlIllllIIIIllllIll, final int lllllllllllllIIlIllllIIIIllllIlI, final byte[] lllllllllllllIIlIllllIIIIllIlIIl, final int lllllllllllllIIlIllllIIIIllllIII) {
        try {
            final int lllllllllllllIIlIllllIIIIlllIlll = this.getOffset(lllllllllllllIIlIllllIIIIllllIll, lllllllllllllIIlIllllIIIIllllIlI);
            int lllllllllllllIIlIllllIIIIlllIllI = lllllllllllllIIlIllllIIIIlllIlll >> 8;
            final int lllllllllllllIIlIllllIIIIlllIlIl = lllllllllllllIIlIllllIIIIlllIlll & 0xFF;
            final int lllllllllllllIIlIllllIIIIlllIlII = (lllllllllllllIIlIllllIIIIllllIII + 5) / 4096 + 1;
            if (lllllllllllllIIlIllllIIIIlllIlII >= 256) {
                return;
            }
            if (lllllllllllllIIlIllllIIIIlllIllI != 0 && lllllllllllllIIlIllllIIIIlllIlIl == lllllllllllllIIlIllllIIIIlllIlII) {
                this.write(lllllllllllllIIlIllllIIIIlllIllI, lllllllllllllIIlIllllIIIIllIlIIl, lllllllllllllIIlIllllIIIIllllIII);
            }
            else {
                for (int lllllllllllllIIlIllllIIIIlllIIll = 0; lllllllllllllIIlIllllIIIIlllIIll < lllllllllllllIIlIllllIIIIlllIlIl; ++lllllllllllllIIlIllllIIIIlllIIll) {
                    this.sectorFree.set(lllllllllllllIIlIllllIIIIlllIllI + lllllllllllllIIlIllllIIIIlllIIll, true);
                }
                int lllllllllllllIIlIllllIIIIlllIIlI = this.sectorFree.indexOf(true);
                int lllllllllllllIIlIllllIIIIlllIIIl = 0;
                if (lllllllllllllIIlIllllIIIIlllIIlI != -1) {
                    for (int lllllllllllllIIlIllllIIIIlllIIII = lllllllllllllIIlIllllIIIIlllIIlI; lllllllllllllIIlIllllIIIIlllIIII < this.sectorFree.size(); ++lllllllllllllIIlIllllIIIIlllIIII) {
                        if (lllllllllllllIIlIllllIIIIlllIIIl != 0) {
                            if (this.sectorFree.get(lllllllllllllIIlIllllIIIIlllIIII)) {
                                ++lllllllllllllIIlIllllIIIIlllIIIl;
                            }
                            else {
                                lllllllllllllIIlIllllIIIIlllIIIl = 0;
                            }
                        }
                        else if (this.sectorFree.get(lllllllllllllIIlIllllIIIIlllIIII)) {
                            lllllllllllllIIlIllllIIIIlllIIlI = lllllllllllllIIlIllllIIIIlllIIII;
                            lllllllllllllIIlIllllIIIIlllIIIl = 1;
                        }
                        if (lllllllllllllIIlIllllIIIIlllIIIl >= lllllllllllllIIlIllllIIIIlllIlII) {
                            break;
                        }
                    }
                }
                if (lllllllllllllIIlIllllIIIIlllIIIl >= lllllllllllllIIlIllllIIIIlllIlII) {
                    lllllllllllllIIlIllllIIIIlllIllI = lllllllllllllIIlIllllIIIIlllIIlI;
                    this.setOffset(lllllllllllllIIlIllllIIIIllllIll, lllllllllllllIIlIllllIIIIllllIlI, lllllllllllllIIlIllllIIIIlllIIlI << 8 | lllllllllllllIIlIllllIIIIlllIlII);
                    for (int lllllllllllllIIlIllllIIIIllIllll = 0; lllllllllllllIIlIllllIIIIllIllll < lllllllllllllIIlIllllIIIIlllIlII; ++lllllllllllllIIlIllllIIIIllIllll) {
                        this.sectorFree.set(lllllllllllllIIlIllllIIIIlllIllI + lllllllllllllIIlIllllIIIIllIllll, false);
                    }
                    this.write(lllllllllllllIIlIllllIIIIlllIllI, lllllllllllllIIlIllllIIIIllIlIIl, lllllllllllllIIlIllllIIIIllllIII);
                }
                else {
                    this.dataFile.seek(this.dataFile.length());
                    lllllllllllllIIlIllllIIIIlllIllI = this.sectorFree.size();
                    for (int lllllllllllllIIlIllllIIIIllIlllI = 0; lllllllllllllIIlIllllIIIIllIlllI < lllllllllllllIIlIllllIIIIlllIlII; ++lllllllllllllIIlIllllIIIIllIlllI) {
                        this.dataFile.write(RegionFile.EMPTY_SECTOR);
                        this.sectorFree.add(false);
                    }
                    this.sizeDelta += 4096 * lllllllllllllIIlIllllIIIIlllIlII;
                    this.write(lllllllllllllIIlIllllIIIIlllIllI, lllllllllllllIIlIllllIIIIllIlIIl, lllllllllllllIIlIllllIIIIllllIII);
                    this.setOffset(lllllllllllllIIlIllllIIIIllllIll, lllllllllllllIIlIllllIIIIllllIlI, lllllllllllllIIlIllllIIIIlllIllI << 8 | lllllllllllllIIlIllllIIIIlllIlII);
                }
            }
            this.setChunkTimestamp(lllllllllllllIIlIllllIIIIllllIll, lllllllllllllIIlIllllIIIIllllIlI, (int)(MinecraftServer.getCurrentTimeMillis() / 1000L));
        }
        catch (IOException lllllllllllllIIlIllllIIIIllIllIl) {
            lllllllllllllIIlIllllIIIIllIllIl.printStackTrace();
        }
    }
    
    static {
        EMPTY_SECTOR = new byte[4096];
    }
    
    class ChunkBuffer extends ByteArrayOutputStream
    {
        private final /* synthetic */ int chunkZ;
        private final /* synthetic */ int chunkX;
        
        @Override
        public void close() throws IOException {
            RegionFile.this.write(this.chunkX, this.chunkZ, this.buf, this.count);
        }
        
        public ChunkBuffer(final int llllllllllllIllIlIllllIIlIIIlIIl, final int llllllllllllIllIlIllllIIlIIIIlII) {
            super(8096);
            this.chunkX = llllllllllllIllIlIllllIIlIIIlIIl;
            this.chunkZ = llllllllllllIllIlIllllIIlIIIIlII;
        }
    }
}
