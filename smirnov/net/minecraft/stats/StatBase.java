// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.stats;

import net.minecraft.util.text.TextFormatting;
import java.util.Locale;
import net.minecraft.scoreboard.ScoreCriteriaStat;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.scoreboard.IScoreCriteria;
import java.text.NumberFormat;
import net.minecraft.util.IJsonSerializable;
import java.text.DecimalFormat;

public class StatBase
{
    private static final /* synthetic */ DecimalFormat decimalFormat;
    public static /* synthetic */ IStatType distanceStatType;
    private /* synthetic */ Class<? extends IJsonSerializable> serializableClazz;
    private final /* synthetic */ IStatType formatter;
    public final /* synthetic */ String statId;
    private static final /* synthetic */ NumberFormat numberFormat;
    public static /* synthetic */ IStatType simpleStatType;
    public static /* synthetic */ IStatType divideByTen;
    public static /* synthetic */ IStatType timeStatType;
    private final /* synthetic */ IScoreCriteria objectiveCriteria;
    public /* synthetic */ boolean isIndependent;
    private final /* synthetic */ ITextComponent statName;
    
    public StatBase initIndependentStat() {
        this.isIndependent = true;
        return this;
    }
    
    @Override
    public int hashCode() {
        return this.statId.hashCode();
    }
    
    public StatBase(final String lllllllllllllIllIIlIlIllIlIIlIll, final ITextComponent lllllllllllllIllIIlIlIllIlIIllIl) {
        this(lllllllllllllIllIIlIlIllIlIIlIll, lllllllllllllIllIIlIlIllIlIIllIl, StatBase.simpleStatType);
    }
    
    public StatBase(final String lllllllllllllIllIIlIlIllIlIllIIl, final ITextComponent lllllllllllllIllIIlIlIllIlIllIII, final IStatType lllllllllllllIllIIlIlIllIlIlIlll) {
        this.statId = lllllllllllllIllIIlIlIllIlIllIIl;
        this.statName = lllllllllllllIllIIlIlIllIlIllIII;
        this.formatter = lllllllllllllIllIIlIlIllIlIlIlll;
        this.objectiveCriteria = new ScoreCriteriaStat(this);
        IScoreCriteria.INSTANCES.put(this.objectiveCriteria.getName(), this.objectiveCriteria);
    }
    
    public String format(final int lllllllllllllIllIIlIlIllIIlllllI) {
        return this.formatter.format(lllllllllllllIllIIlIlIllIIlllllI);
    }
    
    static {
        numberFormat = NumberFormat.getIntegerInstance(Locale.US);
        StatBase.simpleStatType = new IStatType() {
            @Override
            public String format(final int lllllllllllIIIlIIlIIlllllIllllll) {
                return StatBase.numberFormat.format(lllllllllllIIIlIIlIIlllllIllllll);
            }
        };
        decimalFormat = new DecimalFormat("########0.00");
        StatBase.timeStatType = new IStatType() {
            @Override
            public String format(final int llllllllllllIllIIIlIIllllIIlIIlI) {
                final double llllllllllllIllIIIlIIllllIIlIlll = llllllllllllIllIIIlIIllllIIlIIlI / 20.0;
                final double llllllllllllIllIIIlIIllllIIlIllI = llllllllllllIllIIIlIIllllIIlIlll / 60.0;
                final double llllllllllllIllIIIlIIllllIIlIlIl = llllllllllllIllIIIlIIllllIIlIllI / 60.0;
                final double llllllllllllIllIIIlIIllllIIlIlII = llllllllllllIllIIIlIIllllIIlIlIl / 24.0;
                final double llllllllllllIllIIIlIIllllIIlIIll = llllllllllllIllIIIlIIllllIIlIlII / 365.0;
                if (llllllllllllIllIIIlIIllllIIlIIll > 0.5) {
                    return String.valueOf(StatBase.decimalFormat.format(llllllllllllIllIIIlIIllllIIlIIll)) + " y";
                }
                if (llllllllllllIllIIIlIIllllIIlIlII > 0.5) {
                    return String.valueOf(StatBase.decimalFormat.format(llllllllllllIllIIIlIIllllIIlIlII)) + " d";
                }
                if (llllllllllllIllIIIlIIllllIIlIlIl > 0.5) {
                    return String.valueOf(StatBase.decimalFormat.format(llllllllllllIllIIIlIIllllIIlIlIl)) + " h";
                }
                return (llllllllllllIllIIIlIIllllIIlIllI > 0.5) ? (String.valueOf(StatBase.decimalFormat.format(llllllllllllIllIIIlIIllllIIlIllI)) + " m") : (String.valueOf(llllllllllllIllIIIlIIllllIIlIlll) + " s");
            }
        };
        StatBase.distanceStatType = new IStatType() {
            @Override
            public String format(final int lllllllllllIIlIIllllIlIIIlIlllll) {
                final double lllllllllllIIlIIllllIlIIIlIllllI = lllllllllllIIlIIllllIlIIIlIlllll / 100.0;
                final double lllllllllllIIlIIllllIlIIIlIlllIl = lllllllllllIIlIIllllIlIIIlIllllI / 1000.0;
                if (lllllllllllIIlIIllllIlIIIlIlllIl > 0.5) {
                    return String.valueOf(StatBase.decimalFormat.format(lllllllllllIIlIIllllIlIIIlIlllIl)) + " km";
                }
                return (lllllllllllIIlIIllllIlIIIlIllllI > 0.5) ? (String.valueOf(StatBase.decimalFormat.format(lllllllllllIIlIIllllIlIIIlIllllI)) + " m") : (String.valueOf(lllllllllllIIlIIllllIlIIIlIlllll) + " cm");
            }
        };
        StatBase.divideByTen = new IStatType() {
            @Override
            public String format(final int llllllllllllIllIlIIlIIIlIIIIlIIl) {
                return StatBase.decimalFormat.format(llllllllllllIllIlIIlIIIlIIIIlIIl * 0.1);
            }
        };
    }
    
    public StatBase registerStat() {
        if (StatList.ID_TO_STAT_MAP.containsKey(this.statId)) {
            throw new RuntimeException("Duplicate stat id: \"" + StatList.ID_TO_STAT_MAP.get(this.statId).statName + "\" and \"" + this.statName + "\" at id " + this.statId);
        }
        StatList.ALL_STATS.add(this);
        StatList.ID_TO_STAT_MAP.put(this.statId, this);
        return this;
    }
    
    public IScoreCriteria getCriteria() {
        return this.objectiveCriteria;
    }
    
    public ITextComponent getStatName() {
        final ITextComponent lllllllllllllIllIIlIlIllIIlllIlI = this.statName.createCopy();
        lllllllllllllIllIIlIlIllIIlllIlI.getStyle().setColor(TextFormatting.GRAY);
        return lllllllllllllIllIIlIlIllIIlllIlI;
    }
    
    public Class<? extends IJsonSerializable> getSerializableClazz() {
        return this.serializableClazz;
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIllIIlIlIllIIllIIll) {
        if (this == lllllllllllllIllIIlIlIllIIllIIll) {
            return true;
        }
        if (lllllllllllllIllIIlIlIllIIllIIll != null && this.getClass() == lllllllllllllIllIIlIlIllIIllIIll.getClass()) {
            final StatBase lllllllllllllIllIIlIlIllIIllIIlI = (StatBase)lllllllllllllIllIIlIlIllIIllIIll;
            return this.statId.equals(lllllllllllllIllIIlIlIllIIllIIlI.statId);
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "Stat{id=" + this.statId + ", nameId=" + this.statName + ", awardLocallyOnly=" + this.isIndependent + ", formatter=" + this.formatter + ", objectiveCriteria=" + this.objectiveCriteria + '}';
    }
}
