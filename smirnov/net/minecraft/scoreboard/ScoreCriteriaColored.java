// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.scoreboard;

import net.minecraft.util.text.TextFormatting;

public class ScoreCriteriaColored implements IScoreCriteria
{
    private final /* synthetic */ String goalName;
    
    @Override
    public EnumRenderType getRenderType() {
        return EnumRenderType.INTEGER;
    }
    
    @Override
    public boolean isReadOnly() {
        return false;
    }
    
    public ScoreCriteriaColored(final String lllllllllllIIlIllIllIIlIIIlIIIlI, final TextFormatting lllllllllllIIlIllIllIIlIIIlIIIIl) {
        this.goalName = String.valueOf(lllllllllllIIlIllIllIIlIIIlIIIlI) + lllllllllllIIlIllIllIIlIIIlIIIIl.getFriendlyName();
        IScoreCriteria.INSTANCES.put(this.goalName, this);
    }
    
    @Override
    public String getName() {
        return this.goalName;
    }
}
