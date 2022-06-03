// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.scoreboard;

public class ScoreObjective
{
    private /* synthetic */ IScoreCriteria.EnumRenderType renderType;
    private final /* synthetic */ String name;
    private final /* synthetic */ IScoreCriteria objectiveCriteria;
    private final /* synthetic */ Scoreboard theScoreboard;
    private /* synthetic */ String displayName;
    
    public Scoreboard getScoreboard() {
        return this.theScoreboard;
    }
    
    public IScoreCriteria getCriteria() {
        return this.objectiveCriteria;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setDisplayName(final String lllllllllllIlIlIlIIlIIIllIIIIlII) {
        this.displayName = lllllllllllIlIlIlIIlIIIllIIIIlII;
        this.theScoreboard.onObjectiveDisplayNameChanged(this);
    }
    
    public ScoreObjective(final Scoreboard lllllllllllIlIlIlIIlIIIllIIllIII, final String lllllllllllIlIlIlIIlIIIllIIllIll, final IScoreCriteria lllllllllllIlIlIlIIlIIIllIIllIlI) {
        this.theScoreboard = lllllllllllIlIlIlIIlIIIllIIllIII;
        this.name = lllllllllllIlIlIlIIlIIIllIIllIll;
        this.objectiveCriteria = lllllllllllIlIlIlIIlIIIllIIllIlI;
        this.displayName = lllllllllllIlIlIlIIlIIIllIIllIll;
        this.renderType = lllllllllllIlIlIlIIlIIIllIIllIlI.getRenderType();
    }
    
    public String getDisplayName() {
        return this.displayName;
    }
    
    public void setRenderType(final IScoreCriteria.EnumRenderType lllllllllllIlIlIlIIlIIIlIllllIll) {
        this.renderType = lllllllllllIlIlIlIIlIIIlIllllIll;
        this.theScoreboard.onObjectiveDisplayNameChanged(this);
    }
    
    public IScoreCriteria.EnumRenderType getRenderType() {
        return this.renderType;
    }
}
