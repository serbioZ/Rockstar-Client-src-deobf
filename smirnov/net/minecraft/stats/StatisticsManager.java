// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.stats;

import com.google.common.collect.Maps;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.TupleIntJsonSerializable;
import java.util.Map;

public class StatisticsManager
{
    protected final /* synthetic */ Map<StatBase, TupleIntJsonSerializable> statsData;
    
    public void unlockAchievement(final EntityPlayer lllllllllllIIIIIlIIlIllIIlIIlIIl, final StatBase lllllllllllIIIIIlIIlIllIIlIIlIII, final int lllllllllllIIIIIlIIlIllIIlIIIIll) {
        TupleIntJsonSerializable lllllllllllIIIIIlIIlIllIIlIIIllI = this.statsData.get(lllllllllllIIIIIlIIlIllIIlIIlIII);
        if (lllllllllllIIIIIlIIlIllIIlIIIllI == null) {
            lllllllllllIIIIIlIIlIllIIlIIIllI = new TupleIntJsonSerializable();
            this.statsData.put(lllllllllllIIIIIlIIlIllIIlIIlIII, lllllllllllIIIIIlIIlIllIIlIIIllI);
        }
        lllllllllllIIIIIlIIlIllIIlIIIllI.setIntegerValue(lllllllllllIIIIIlIIlIllIIlIIIIll);
    }
    
    public int readStat(final StatBase lllllllllllIIIIIlIIlIllIIIllllIl) {
        final TupleIntJsonSerializable lllllllllllIIIIIlIIlIllIIIllllII = this.statsData.get(lllllllllllIIIIIlIIlIllIIIllllIl);
        return (lllllllllllIIIIIlIIlIllIIIllllII == null) ? 0 : lllllllllllIIIIIlIIlIllIIIllllII.getIntegerValue();
    }
    
    public void increaseStat(final EntityPlayer lllllllllllIIIIIlIIlIllIIlIlIIIl, final StatBase lllllllllllIIIIIlIIlIllIIlIlIlII, final int lllllllllllIIIIIlIIlIllIIlIlIIll) {
        this.unlockAchievement(lllllllllllIIIIIlIIlIllIIlIlIIIl, lllllllllllIIIIIlIIlIllIIlIlIlII, this.readStat(lllllllllllIIIIIlIIlIllIIlIlIlII) + lllllllllllIIIIIlIIlIllIIlIlIIll);
    }
    
    public StatisticsManager() {
        this.statsData = (Map<StatBase, TupleIntJsonSerializable>)Maps.newConcurrentMap();
    }
}
