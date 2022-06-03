// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.scoreboard;

import java.util.Comparator;

public class Score
{
    private final /* synthetic */ Scoreboard theScoreboard;
    private /* synthetic */ boolean locked;
    private /* synthetic */ int scorePoints;
    private final /* synthetic */ ScoreObjective theScoreObjective;
    private final /* synthetic */ String scorePlayerName;
    private /* synthetic */ boolean forceUpdate;
    
    public void incrementScore() {
        if (this.theScoreObjective.getCriteria().isReadOnly()) {
            throw new IllegalStateException("Cannot modify read-only score");
        }
        this.increaseScore(1);
    }
    
    public void decreaseScore(final int lllllllllllIIlllllIlIIIllllIIlII) {
        if (this.theScoreObjective.getCriteria().isReadOnly()) {
            throw new IllegalStateException("Cannot modify read-only score");
        }
        this.setScorePoints(this.getScorePoints() - lllllllllllIIlllllIlIIIllllIIlII);
    }
    
    static {
        SCORE_COMPARATOR = new Comparator<Score>() {
            @Override
            public int compare(final Score llllllllllllIlllIIIlIlllIIllIIII, final Score llllllllllllIlllIIIlIlllIIlIllIl) {
                if (llllllllllllIlllIIIlIlllIIllIIII.getScorePoints() > llllllllllllIlllIIIlIlllIIlIllIl.getScorePoints()) {
                    return 1;
                }
                return (llllllllllllIlllIIIlIlllIIllIIII.getScorePoints() < llllllllllllIlllIIIlIlllIIlIllIl.getScorePoints()) ? -1 : llllllllllllIlllIIIlIlllIIlIllIl.getPlayerName().compareToIgnoreCase(llllllllllllIlllIIIlIlllIIllIIII.getPlayerName());
            }
        };
    }
    
    public Score(final Scoreboard lllllllllllIIlllllIlIIIlllllIIII, final ScoreObjective lllllllllllIIlllllIlIIIllllIllll, final String lllllllllllIIlllllIlIIIlllllIIlI) {
        this.theScoreboard = lllllllllllIIlllllIlIIIlllllIIII;
        this.theScoreObjective = lllllllllllIIlllllIlIIIllllIllll;
        this.scorePlayerName = lllllllllllIIlllllIlIIIlllllIIlI;
        this.forceUpdate = true;
    }
    
    public int getScorePoints() {
        return this.scorePoints;
    }
    
    public void setLocked(final boolean lllllllllllIIlllllIlIIIlllIIIIll) {
        this.locked = lllllllllllIIlllllIlIIIlllIIIIll;
    }
    
    public void setScorePoints(final int lllllllllllIIlllllIlIIIlllIlIlII) {
        final int lllllllllllIIlllllIlIIIlllIlIllI = this.scorePoints;
        this.scorePoints = lllllllllllIIlllllIlIIIlllIlIlII;
        if (lllllllllllIIlllllIlIIIlllIlIllI != lllllllllllIIlllllIlIIIlllIlIlII || this.forceUpdate) {
            this.forceUpdate = false;
            this.getScoreScoreboard().onScoreUpdated(this);
        }
    }
    
    public ScoreObjective getObjective() {
        return this.theScoreObjective;
    }
    
    public Scoreboard getScoreScoreboard() {
        return this.theScoreboard;
    }
    
    public boolean isLocked() {
        return this.locked;
    }
    
    public void increaseScore(final int lllllllllllIIlllllIlIIIllllIlIlI) {
        if (this.theScoreObjective.getCriteria().isReadOnly()) {
            throw new IllegalStateException("Cannot modify read-only score");
        }
        this.setScorePoints(this.getScorePoints() + lllllllllllIIlllllIlIIIllllIlIlI);
    }
    
    public String getPlayerName() {
        return this.scorePlayerName;
    }
}
