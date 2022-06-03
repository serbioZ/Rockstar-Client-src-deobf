// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.scoreboard;

public class ScoreCriteriaHealth extends ScoreCriteria
{
    @Override
    public boolean isReadOnly() {
        return true;
    }
    
    public ScoreCriteriaHealth(final String lllllllllllIlllIIlllIlIIIIllIlII) {
        super(lllllllllllIlllIIlllIlIIIIllIlII);
    }
    
    @Override
    public IScoreCriteria.EnumRenderType getRenderType() {
        return IScoreCriteria.EnumRenderType.HEARTS;
    }
}
