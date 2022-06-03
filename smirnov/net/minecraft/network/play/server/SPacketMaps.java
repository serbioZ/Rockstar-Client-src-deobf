// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import net.minecraft.network.INetHandler;
import java.io.IOException;
import net.minecraft.network.PacketBuffer;
import net.minecraft.world.storage.MapData;
import java.util.Collection;
import net.minecraft.world.storage.MapDecoration;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketMaps implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ int minX;
    private /* synthetic */ int minZ;
    private /* synthetic */ boolean trackingPosition;
    private /* synthetic */ byte mapScale;
    private /* synthetic */ MapDecoration[] icons;
    private /* synthetic */ int mapId;
    private /* synthetic */ int rows;
    private /* synthetic */ int columns;
    private /* synthetic */ byte[] mapDataBytes;
    
    public SPacketMaps(final int lllllllllllIIllIIIIllIIlllIllIlI, final byte lllllllllllIIllIIIIllIIlllIllIIl, final boolean lllllllllllIIllIIIIllIIlllIIllII, final Collection<MapDecoration> lllllllllllIIllIIIIllIIlllIlIlll, final byte[] lllllllllllIIllIIIIllIIlllIlIllI, final int lllllllllllIIllIIIIllIIlllIlIlIl, final int lllllllllllIIllIIIIllIIlllIIlIII, final int lllllllllllIIllIIIIllIIlllIlIIll, final int lllllllllllIIllIIIIllIIlllIIIllI) {
        this.mapId = lllllllllllIIllIIIIllIIlllIllIlI;
        this.mapScale = lllllllllllIIllIIIIllIIlllIllIIl;
        this.trackingPosition = lllllllllllIIllIIIIllIIlllIIllII;
        this.icons = lllllllllllIIllIIIIllIIlllIlIlll.toArray(new MapDecoration[lllllllllllIIllIIIIllIIlllIlIlll.size()]);
        this.minX = lllllllllllIIllIIIIllIIlllIlIlIl;
        this.minZ = lllllllllllIIllIIIIllIIlllIIlIII;
        this.columns = lllllllllllIIllIIIIllIIlllIlIIll;
        this.rows = lllllllllllIIllIIIIllIIlllIIIllI;
        this.mapDataBytes = new byte[lllllllllllIIllIIIIllIIlllIlIIll * lllllllllllIIllIIIIllIIlllIIIllI];
        for (int lllllllllllIIllIIIIllIIlllIlIIIl = 0; lllllllllllIIllIIIIllIIlllIlIIIl < lllllllllllIIllIIIIllIIlllIlIIll; ++lllllllllllIIllIIIIllIIlllIlIIIl) {
            for (int lllllllllllIIllIIIIllIIlllIlIIII = 0; lllllllllllIIllIIIIllIIlllIlIIII < lllllllllllIIllIIIIllIIlllIIIllI; ++lllllllllllIIllIIIIllIIlllIlIIII) {
                this.mapDataBytes[lllllllllllIIllIIIIllIIlllIlIIIl + lllllllllllIIllIIIIllIIlllIlIIII * lllllllllllIIllIIIIllIIlllIlIIll] = lllllllllllIIllIIIIllIIlllIlIllI[lllllllllllIIllIIIIllIIlllIlIlIl + lllllllllllIIllIIIIllIIlllIlIIIl + (lllllllllllIIllIIIIllIIlllIIlIII + lllllllllllIIllIIIIllIIlllIlIIII) * 128];
            }
        }
    }
    
    public void setMapdataTo(final MapData lllllllllllIIllIIIIllIIllIIlIlII) {
        lllllllllllIIllIIIIllIIllIIlIlII.scale = this.mapScale;
        lllllllllllIIllIIIIllIIllIIlIlII.trackingPosition = this.trackingPosition;
        lllllllllllIIllIIIIllIIllIIlIlII.mapDecorations.clear();
        for (int lllllllllllIIllIIIIllIIllIIllIIl = 0; lllllllllllIIllIIIIllIIllIIllIIl < this.icons.length; ++lllllllllllIIllIIIIllIIllIIllIIl) {
            final MapDecoration lllllllllllIIllIIIIllIIllIIllIII = this.icons[lllllllllllIIllIIIIllIIllIIllIIl];
            lllllllllllIIllIIIIllIIllIIlIlII.mapDecorations.put("icon-" + lllllllllllIIllIIIIllIIllIIllIIl, lllllllllllIIllIIIIllIIllIIllIII);
        }
        for (int lllllllllllIIllIIIIllIIllIIlIlll = 0; lllllllllllIIllIIIIllIIllIIlIlll < this.columns; ++lllllllllllIIllIIIIllIIllIIlIlll) {
            for (int lllllllllllIIllIIIIllIIllIIlIllI = 0; lllllllllllIIllIIIIllIIllIIlIllI < this.rows; ++lllllllllllIIllIIIIllIIllIIlIllI) {
                lllllllllllIIllIIIIllIIllIIlIlII.colors[this.minX + lllllllllllIIllIIIIllIIllIIlIlll + (this.minZ + lllllllllllIIllIIIIllIIllIIlIllI) * 128] = this.mapDataBytes[lllllllllllIIllIIIIllIIllIIlIlll + lllllllllllIIllIIIIllIIllIIlIllI * this.columns];
            }
        }
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllIIllIIIIllIIllIlIllIl) throws IOException {
        lllllllllllIIllIIIIllIIllIlIllIl.writeVarIntToBuffer(this.mapId);
        lllllllllllIIllIIIIllIIllIlIllIl.writeByte(this.mapScale);
        lllllllllllIIllIIIIllIIllIlIllIl.writeBoolean(this.trackingPosition);
        lllllllllllIIllIIIIllIIllIlIllIl.writeVarIntToBuffer(this.icons.length);
        final byte lllllllllllIIllIIIIllIIllIlIlIIl;
        final float lllllllllllIIllIIIIllIIllIlIlIlI = ((MapDecoration[])(Object)(lllllllllllIIllIIIIllIIllIlIlIIl = (byte)(Object)this.icons)).length;
        for (short lllllllllllIIllIIIIllIIllIlIlIll = 0; lllllllllllIIllIIIIllIIllIlIlIll < lllllllllllIIllIIIIllIIllIlIlIlI; ++lllllllllllIIllIIIIllIIllIlIlIll) {
            final MapDecoration lllllllllllIIllIIIIllIIllIlIllll = lllllllllllIIllIIIIllIIllIlIlIIl[lllllllllllIIllIIIIllIIllIlIlIll];
            lllllllllllIIllIIIIllIIllIlIllIl.writeByte((lllllllllllIIllIIIIllIIllIlIllll.getType() & 0xF) << 4 | (lllllllllllIIllIIIIllIIllIlIllll.getRotation() & 0xF));
            lllllllllllIIllIIIIllIIllIlIllIl.writeByte(lllllllllllIIllIIIIllIIllIlIllll.getX());
            lllllllllllIIllIIIIllIIllIlIllIl.writeByte(lllllllllllIIllIIIIllIIllIlIllll.getY());
        }
        lllllllllllIIllIIIIllIIllIlIllIl.writeByte(this.columns);
        if (this.columns > 0) {
            lllllllllllIIllIIIIllIIllIlIllIl.writeByte(this.rows);
            lllllllllllIIllIIIIllIIllIlIllIl.writeByte(this.minX);
            lllllllllllIIllIIIIllIIllIlIllIl.writeByte(this.minZ);
            lllllllllllIIllIIIIllIIllIlIllIl.writeByteArray(this.mapDataBytes);
        }
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllIIllIIIIllIIllIlllllI) throws IOException {
        this.mapId = lllllllllllIIllIIIIllIIllIlllllI.readVarIntFromBuffer();
        this.mapScale = lllllllllllIIllIIIIllIIllIlllllI.readByte();
        this.trackingPosition = lllllllllllIIllIIIIllIIllIlllllI.readBoolean();
        this.icons = new MapDecoration[lllllllllllIIllIIIIllIIllIlllllI.readVarIntFromBuffer()];
        for (int lllllllllllIIllIIIIllIIllIllllIl = 0; lllllllllllIIllIIIIllIIllIllllIl < this.icons.length; ++lllllllllllIIllIIIIllIIllIllllIl) {
            final short lllllllllllIIllIIIIllIIllIllllII = lllllllllllIIllIIIIllIIllIlllllI.readByte();
            this.icons[lllllllllllIIllIIIIllIIllIllllIl] = new MapDecoration(MapDecoration.Type.func_191159_a((byte)(lllllllllllIIllIIIIllIIllIllllII >> 4 & 0xF)), lllllllllllIIllIIIIllIIllIlllllI.readByte(), lllllllllllIIllIIIIllIIllIlllllI.readByte(), (byte)(lllllllllllIIllIIIIllIIllIllllII & 0xF));
        }
        this.columns = lllllllllllIIllIIIIllIIllIlllllI.readUnsignedByte();
        if (this.columns > 0) {
            this.rows = lllllllllllIIllIIIIllIIllIlllllI.readUnsignedByte();
            this.minX = lllllllllllIIllIIIIllIIllIlllllI.readUnsignedByte();
            this.minZ = lllllllllllIIllIIIIllIIllIlllllI.readUnsignedByte();
            this.mapDataBytes = lllllllllllIIllIIIIllIIllIlllllI.readByteArray();
        }
    }
    
    public SPacketMaps() {
    }
    
    public int getMapId() {
        return this.mapId;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllIIllIIIIllIIllIlIIlIl) {
        lllllllllllIIllIIIIllIIllIlIIlIl.handleMaps(this);
    }
}
