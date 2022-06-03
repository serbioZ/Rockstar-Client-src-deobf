// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.network.play.server;

import java.io.IOException;
import net.minecraft.stats.StatList;
import com.google.common.collect.Maps;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.INetHandler;
import net.minecraft.stats.StatBase;
import java.util.Map;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.Packet;

public class SPacketStatistics implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ Map<StatBase, Integer> statisticMap;
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllIIIIIllIIlIlIllIlIlIl) {
        lllllllllllIIIIIllIIlIlIllIlIlIl.handleStatistics(this);
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllIIIIIllIIlIlIllIIllIl) throws IOException {
        final int lllllllllllIIIIIllIIlIlIllIIllII = lllllllllllIIIIIllIIlIlIllIIllIl.readVarIntFromBuffer();
        this.statisticMap = (Map<StatBase, Integer>)Maps.newHashMap();
        for (int lllllllllllIIIIIllIIlIlIllIIlIll = 0; lllllllllllIIIIIllIIlIlIllIIlIll < lllllllllllIIIIIllIIlIlIllIIllII; ++lllllllllllIIIIIllIIlIlIllIIlIll) {
            final StatBase lllllllllllIIIIIllIIlIlIllIIlIlI = StatList.getOneShotStat(lllllllllllIIIIIllIIlIlIllIIllIl.readStringFromBuffer(32767));
            final int lllllllllllIIIIIllIIlIlIllIIlIIl = lllllllllllIIIIIllIIlIlIllIIllIl.readVarIntFromBuffer();
            if (lllllllllllIIIIIllIIlIlIllIIlIlI != null) {
                this.statisticMap.put(lllllllllllIIIIIllIIlIlIllIIlIlI, lllllllllllIIIIIllIIlIlIllIIlIIl);
            }
        }
    }
    
    public Map<StatBase, Integer> getStatisticMap() {
        return this.statisticMap;
    }
    
    public SPacketStatistics() {
    }
    
    public SPacketStatistics(final Map<StatBase, Integer> lllllllllllIIIIIllIIlIlIllIlllIl) {
        this.statisticMap = lllllllllllIIIIIllIIlIlIllIlllIl;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllIIIIIllIIlIlIlIlllIlI) throws IOException {
        lllllllllllIIIIIllIIlIlIlIlllIlI.writeVarIntToBuffer(this.statisticMap.size());
        for (final Map.Entry<StatBase, Integer> lllllllllllIIIIIllIIlIlIlIllllII : this.statisticMap.entrySet()) {
            lllllllllllIIIIIllIIlIlIlIlllIlI.writeString(lllllllllllIIIIIllIIlIlIlIllllII.getKey().statId);
            lllllllllllIIIIIllIIlIlIlIlllIlI.writeVarIntToBuffer(lllllllllllIIIIIllIIlIlIlIllllII.getValue());
        }
    }
}
