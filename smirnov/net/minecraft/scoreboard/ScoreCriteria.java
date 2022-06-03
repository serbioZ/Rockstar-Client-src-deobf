// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.scoreboard;

public class ScoreCriteria implements IScoreCriteria
{
    private final /* synthetic */ String dummyName;
    
    @Override
    public boolean isReadOnly() {
        return false;
    }
    
    public ScoreCriteria(final String lllllllllllIIIIIIIIlIIlIIlIIIIIl) {
        this.dummyName = lllllllllllIIIIIIIIlIIlIIlIIIIIl;
        IScoreCriteria.INSTANCES.put(lllllllllllIIIIIIIIlIIlIIlIIIIIl, this);
    }
    
    @Override
    public EnumRenderType getRenderType() {
        return EnumRenderType.INTEGER;
    }
    
    @Override
    public String getName() {
        return this.dummyName;
    }
}
