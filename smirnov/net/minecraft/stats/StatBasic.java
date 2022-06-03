// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.stats;

import net.minecraft.util.text.ITextComponent;

public class StatBasic extends StatBase
{
    public StatBasic(final String lllllllllllIlIllIIlIllllllIIIllI, final ITextComponent lllllllllllIlIllIIlIllllllIIlIII) {
        super(lllllllllllIlIllIIlIllllllIIIllI, lllllllllllIlIllIIlIllllllIIlIII);
    }
    
    public StatBasic(final String lllllllllllIlIllIIlIllllllIlIIII, final ITextComponent lllllllllllIlIllIIlIllllllIIllll, final IStatType lllllllllllIlIllIIlIllllllIlIIlI) {
        super(lllllllllllIlIllIIlIllllllIlIIII, lllllllllllIlIllIIlIllllllIIllll, lllllllllllIlIllIIlIllllllIlIIlI);
    }
    
    @Override
    public StatBase registerStat() {
        super.registerStat();
        StatList.BASIC_STATS.add(this);
        return this;
    }
}
