// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.scoreboard;

import java.util.Comparator;
import java.util.Collections;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.util.text.TextFormatting;
import com.google.common.collect.Maps;
import javax.annotation.Nullable;
import java.util.Collection;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Map;

public class Scoreboard
{
    private final /* synthetic */ Map<IScoreCriteria, List<ScoreObjective>> scoreObjectiveCriterias;
    private final /* synthetic */ Map<String, Map<ScoreObjective, Score>> entitiesScoreObjectives;
    private final /* synthetic */ Map<String, ScorePlayerTeam> teams;
    private final /* synthetic */ Map<String, ScorePlayerTeam> teamMemberships;
    private static /* synthetic */ String[] displaySlots;
    private final /* synthetic */ Map<String, ScoreObjective> scoreObjectives;
    private final /* synthetic */ ScoreObjective[] objectiveDisplaySlots;
    
    public ScoreObjective addScoreObjective(final String llllllllllllIIlIIlIIlIIlIIlIIlll, final IScoreCriteria llllllllllllIIlIIlIIlIIlIIlIIllI) {
        if (llllllllllllIIlIIlIIlIIlIIlIIlll.length() > 16) {
            throw new IllegalArgumentException("The objective name '" + llllllllllllIIlIIlIIlIIlIIlIIlll + "' is too long!");
        }
        ScoreObjective llllllllllllIIlIIlIIlIIlIIlIIlIl = this.getObjective(llllllllllllIIlIIlIIlIIlIIlIIlll);
        if (llllllllllllIIlIIlIIlIIlIIlIIlIl != null) {
            throw new IllegalArgumentException("An objective with the name '" + llllllllllllIIlIIlIIlIIlIIlIIlll + "' already exists!");
        }
        llllllllllllIIlIIlIIlIIlIIlIIlIl = new ScoreObjective(this, llllllllllllIIlIIlIIlIIlIIlIIlll, llllllllllllIIlIIlIIlIIlIIlIIllI);
        List<ScoreObjective> llllllllllllIIlIIlIIlIIlIIlIIlII = this.scoreObjectiveCriterias.get(llllllllllllIIlIIlIIlIIlIIlIIllI);
        if (llllllllllllIIlIIlIIlIIlIIlIIlII == null) {
            llllllllllllIIlIIlIIlIIlIIlIIlII = (List<ScoreObjective>)Lists.newArrayList();
            this.scoreObjectiveCriterias.put(llllllllllllIIlIIlIIlIIlIIlIIllI, llllllllllllIIlIIlIIlIIlIIlIIlII);
        }
        llllllllllllIIlIIlIIlIIlIIlIIlII.add(llllllllllllIIlIIlIIlIIlIIlIIlIl);
        this.scoreObjectives.put(llllllllllllIIlIIlIIlIIlIIlIIlll, llllllllllllIIlIIlIIlIIlIIlIIlIl);
        this.onScoreObjectiveAdded(llllllllllllIIlIIlIIlIIlIIlIIlIl);
        return llllllllllllIIlIIlIIlIIlIIlIIlIl;
    }
    
    public Collection<ScoreObjective> getScoreObjectives() {
        return this.scoreObjectives.values();
    }
    
    public boolean entityHasObjective(final String llllllllllllIIlIIlIIlIIlIIIIlIlI, final ScoreObjective llllllllllllIIlIIlIIlIIlIIIIlllI) {
        final Map<ScoreObjective, Score> llllllllllllIIlIIlIIlIIlIIIIllIl = this.entitiesScoreObjectives.get(llllllllllllIIlIIlIIlIIlIIIIlIlI);
        if (llllllllllllIIlIIlIIlIIlIIIIllIl == null) {
            return false;
        }
        final Score llllllllllllIIlIIlIIlIIlIIIIllII = llllllllllllIIlIIlIIlIIlIIIIllIl.get(llllllllllllIIlIIlIIlIIlIIIIlllI);
        return llllllllllllIIlIIlIIlIIlIIIIllII != null;
    }
    
    public Collection<Score> getScores() {
        final Collection<Map<ScoreObjective, Score>> llllllllllllIIlIIlIIlIIIllIIIlll = this.entitiesScoreObjectives.values();
        final List<Score> llllllllllllIIlIIlIIlIIIllIIIllI = (List<Score>)Lists.newArrayList();
        for (final Map<ScoreObjective, Score> llllllllllllIIlIIlIIlIIIllIIIlIl : llllllllllllIIlIIlIIlIIIllIIIlll) {
            llllllllllllIIlIIlIIlIIIllIIIllI.addAll(llllllllllllIIlIIlIIlIIIllIIIlIl.values());
        }
        return llllllllllllIIlIIlIIlIIIllIIIllI;
    }
    
    public void broadcastTeamRemove(final ScorePlayerTeam llllllllllllIIlIIlIIlIIIIlIIIIlI) {
    }
    
    @Nullable
    public ScoreObjective getObjective(final String llllllllllllIIlIIlIIlIIlIIlIlllI) {
        return this.scoreObjectives.get(llllllllllllIIlIIlIIlIIlIIlIlllI);
    }
    
    public void onScoreObjectiveRemoved(final ScoreObjective llllllllllllIIlIIlIIlIIIIlIIllll) {
    }
    
    public ScorePlayerTeam getTeam(final String llllllllllllIIlIIlIIlIIIlIIlIIll) {
        return this.teams.get(llllllllllllIIlIIlIIlIIIlIIlIIll);
    }
    
    public Scoreboard() {
        this.scoreObjectives = (Map<String, ScoreObjective>)Maps.newHashMap();
        this.scoreObjectiveCriterias = (Map<IScoreCriteria, List<ScoreObjective>>)Maps.newHashMap();
        this.entitiesScoreObjectives = (Map<String, Map<ScoreObjective, Score>>)Maps.newHashMap();
        this.objectiveDisplaySlots = new ScoreObjective[19];
        this.teams = (Map<String, ScorePlayerTeam>)Maps.newHashMap();
        this.teamMemberships = (Map<String, ScorePlayerTeam>)Maps.newHashMap();
    }
    
    public void broadcastTeamCreated(final ScorePlayerTeam llllllllllllIIlIIlIIlIIIIlIIIllI) {
    }
    
    public ScorePlayerTeam createTeam(final String llllllllllllIIlIIlIIlIIIlIIIlIll) {
        if (llllllllllllIIlIIlIIlIIIlIIIlIll.length() > 16) {
            throw new IllegalArgumentException("The team name '" + llllllllllllIIlIIlIIlIIIlIIIlIll + "' is too long!");
        }
        ScorePlayerTeam llllllllllllIIlIIlIIlIIIlIIIllIl = this.getTeam(llllllllllllIIlIIlIIlIIIlIIIlIll);
        if (llllllllllllIIlIIlIIlIIIlIIIllIl != null) {
            throw new IllegalArgumentException("A team with the name '" + llllllllllllIIlIIlIIlIIIlIIIlIll + "' already exists!");
        }
        llllllllllllIIlIIlIIlIIIlIIIllIl = new ScorePlayerTeam(this, llllllllllllIIlIIlIIlIIIlIIIlIll);
        this.teams.put(llllllllllllIIlIIlIIlIIIlIIIlIll, llllllllllllIIlIIlIIlIIIlIIIllIl);
        this.broadcastTeamCreated(llllllllllllIIlIIlIIlIIIlIIIllIl);
        return llllllllllllIIlIIlIIlIIIlIIIllIl;
    }
    
    @Nullable
    public ScorePlayerTeam getPlayersTeam(final String llllllllllllIIlIIlIIlIIIIlIlIlll) {
        return this.teamMemberships.get(llllllllllllIIlIIlIIlIIIIlIlIlll);
    }
    
    public static String[] getDisplaySlotStrings() {
        if (Scoreboard.displaySlots == null) {
            Scoreboard.displaySlots = new String[19];
            for (int llllllllllllIIlIIlIIlIIIIIllIIIl = 0; llllllllllllIIlIIlIIlIIIIIllIIIl < 19; ++llllllllllllIIlIIlIIlIIIIIllIIIl) {
                Scoreboard.displaySlots[llllllllllllIIlIIlIIlIIIIIllIIIl] = getObjectiveDisplaySlot(llllllllllllIIlIIlIIlIIIIIllIIIl);
            }
        }
        return Scoreboard.displaySlots;
    }
    
    public void broadcastScoreUpdate(final String llllllllllllIIlIIlIIlIIIIlIIlIll) {
    }
    
    public void removePlayerFromTeam(final String llllllllllllIIlIIlIIlIIIIllIIlIl, final ScorePlayerTeam llllllllllllIIlIIlIIlIIIIllIIlII) {
        if (this.getPlayersTeam(llllllllllllIIlIIlIIlIIIIllIIlIl) != llllllllllllIIlIIlIIlIIIIllIIlII) {
            throw new IllegalStateException("Player is either on another team or not on any team. Cannot remove from team '" + llllllllllllIIlIIlIIlIIIIllIIlII.getRegisteredName() + "'.");
        }
        this.teamMemberships.remove(llllllllllllIIlIIlIIlIIIIllIIlIl);
        llllllllllllIIlIIlIIlIIIIllIIlII.getMembershipCollection().remove(llllllllllllIIlIIlIIlIIIIllIIlIl);
    }
    
    public void onScoreUpdated(final Score llllllllllllIIlIIlIIlIIIIlIIllIl) {
    }
    
    public void removeTeam(final ScorePlayerTeam llllllllllllIIlIIlIIlIIIlIIIIlII) {
        this.teams.remove(llllllllllllIIlIIlIIlIIIlIIIIlII.getRegisteredName());
        for (final String llllllllllllIIlIIlIIlIIIlIIIIIll : llllllllllllIIlIIlIIlIIIlIIIIlII.getMembershipCollection()) {
            this.teamMemberships.remove(llllllllllllIIlIIlIIlIIIlIIIIIll);
        }
        this.broadcastTeamRemove(llllllllllllIIlIIlIIlIIIlIIIIlII);
    }
    
    public static int getObjectiveDisplaySlotNumber(final String llllllllllllIIlIIlIIlIIIIIlllIII) {
        if ("list".equalsIgnoreCase(llllllllllllIIlIIlIIlIIIIIlllIII)) {
            return 0;
        }
        if ("sidebar".equalsIgnoreCase(llllllllllllIIlIIlIIlIIIIIlllIII)) {
            return 1;
        }
        if ("belowName".equalsIgnoreCase(llllllllllllIIlIIlIIlIIIIIlllIII)) {
            return 2;
        }
        if (llllllllllllIIlIIlIIlIIIIIlllIII.startsWith("sidebar.team.")) {
            final String llllllllllllIIlIIlIIlIIIIIllIlll = llllllllllllIIlIIlIIlIIIIIlllIII.substring("sidebar.team.".length());
            final TextFormatting llllllllllllIIlIIlIIlIIIIIllIllI = TextFormatting.getValueByName(llllllllllllIIlIIlIIlIIIIIllIlll);
            if (llllllllllllIIlIIlIIlIIIIIllIllI != null && llllllllllllIIlIIlIIlIIIIIllIllI.getColorIndex() >= 0) {
                return llllllllllllIIlIIlIIlIIIIIllIllI.getColorIndex() + 3;
            }
        }
        return -1;
    }
    
    @Nullable
    public ScoreObjective getObjectiveInDisplaySlot(final int llllllllllllIIlIIlIIlIIIlIIllIll) {
        return this.objectiveDisplaySlots[llllllllllllIIlIIlIIlIIIlIIllIll];
    }
    
    public void setObjectiveInDisplaySlot(final int llllllllllllIIlIIlIIlIIIlIlIIIII, final ScoreObjective llllllllllllIIlIIlIIlIIIlIIlllll) {
        this.objectiveDisplaySlots[llllllllllllIIlIIlIIlIIIlIlIIIII] = llllllllllllIIlIIlIIlIIIlIIlllll;
    }
    
    public Map<ScoreObjective, Score> getObjectivesForEntity(final String llllllllllllIIlIIlIIlIIIlIlllIII) {
        Map<ScoreObjective, Score> llllllllllllIIlIIlIIlIIIlIlllIlI = this.entitiesScoreObjectives.get(llllllllllllIIlIIlIIlIIIlIlllIII);
        if (llllllllllllIIlIIlIIlIIIlIlllIlI == null) {
            llllllllllllIIlIIlIIlIIIlIlllIlI = (Map<ScoreObjective, Score>)Maps.newHashMap();
        }
        return llllllllllllIIlIIlIIlIIIlIlllIlI;
    }
    
    public Collection<ScoreObjective> getObjectivesFromCriteria(final IScoreCriteria llllllllllllIIlIIlIIlIIlIIIllIlI) {
        final Collection<ScoreObjective> llllllllllllIIlIIlIIlIIlIIIllIIl = this.scoreObjectiveCriterias.get(llllllllllllIIlIIlIIlIIlIIIllIlI);
        return (Collection<ScoreObjective>)((llllllllllllIIlIIlIIlIIlIIIllIIl == null) ? Lists.newArrayList() : Lists.newArrayList((Iterable)llllllllllllIIlIIlIIlIIlIIIllIIl));
    }
    
    public Collection<ScorePlayerTeam> getTeams() {
        return this.teams.values();
    }
    
    public void broadcastTeamInfoUpdate(final ScorePlayerTeam llllllllllllIIlIIlIIlIIIIlIIIlII) {
    }
    
    public void removeObjective(final ScoreObjective llllllllllllIIlIIlIIlIIIlIllIIII) {
        this.scoreObjectives.remove(llllllllllllIIlIIlIIlIIIlIllIIII.getName());
        for (int llllllllllllIIlIIlIIlIIIlIlIllll = 0; llllllllllllIIlIIlIIlIIIlIlIllll < 19; ++llllllllllllIIlIIlIIlIIIlIlIllll) {
            if (this.getObjectiveInDisplaySlot(llllllllllllIIlIIlIIlIIIlIlIllll) == llllllllllllIIlIIlIIlIIIlIllIIII) {
                this.setObjectiveInDisplaySlot(llllllllllllIIlIIlIIlIIIlIlIllll, null);
            }
        }
        final List<ScoreObjective> llllllllllllIIlIIlIIlIIIlIlIlllI = this.scoreObjectiveCriterias.get(llllllllllllIIlIIlIIlIIIlIllIIII.getCriteria());
        if (llllllllllllIIlIIlIIlIIIlIlIlllI != null) {
            llllllllllllIIlIIlIIlIIIlIlIlllI.remove(llllllllllllIIlIIlIIlIIIlIllIIII);
        }
        for (final Map<ScoreObjective, Score> llllllllllllIIlIIlIIlIIIlIlIllIl : this.entitiesScoreObjectives.values()) {
            llllllllllllIIlIIlIIlIIIlIlIllIl.remove(llllllllllllIIlIIlIIlIIIlIllIIII);
        }
        this.onScoreObjectiveRemoved(llllllllllllIIlIIlIIlIIIlIllIIII);
    }
    
    public void broadcastScoreUpdate(final String llllllllllllIIlIIlIIlIIIIlIIlIIl, final ScoreObjective llllllllllllIIlIIlIIlIIIIlIIlIII) {
    }
    
    public Score getOrCreateScore(final String llllllllllllIIlIIlIIlIIlIIIIIIII, final ScoreObjective llllllllllllIIlIIlIIlIIIlllllIlI) {
        if (llllllllllllIIlIIlIIlIIlIIIIIIII.length() > 40) {
            throw new IllegalArgumentException("The player name '" + llllllllllllIIlIIlIIlIIlIIIIIIII + "' is too long!");
        }
        Map<ScoreObjective, Score> llllllllllllIIlIIlIIlIIIlllllllI = this.entitiesScoreObjectives.get(llllllllllllIIlIIlIIlIIlIIIIIIII);
        if (llllllllllllIIlIIlIIlIIIlllllllI == null) {
            llllllllllllIIlIIlIIlIIIlllllllI = (Map<ScoreObjective, Score>)Maps.newHashMap();
            this.entitiesScoreObjectives.put(llllllllllllIIlIIlIIlIIlIIIIIIII, llllllllllllIIlIIlIIlIIIlllllllI);
        }
        Score llllllllllllIIlIIlIIlIIIllllllIl = llllllllllllIIlIIlIIlIIIlllllllI.get(llllllllllllIIlIIlIIlIIIlllllIlI);
        if (llllllllllllIIlIIlIIlIIIllllllIl == null) {
            llllllllllllIIlIIlIIlIIIllllllIl = new Score(this, llllllllllllIIlIIlIIlIIIlllllIlI, llllllllllllIIlIIlIIlIIlIIIIIIII);
            llllllllllllIIlIIlIIlIIIlllllllI.put(llllllllllllIIlIIlIIlIIIlllllIlI, llllllllllllIIlIIlIIlIIIllllllIl);
        }
        return llllllllllllIIlIIlIIlIIIllllllIl;
    }
    
    public void removeEntity(final Entity llllllllllllIIlIIlIIlIIIIIlIlIII) {
        if (llllllllllllIIlIIlIIlIIIIIlIlIII != null && !(llllllllllllIIlIIlIIlIIIIIlIlIII instanceof EntityPlayer) && !llllllllllllIIlIIlIIlIIIIIlIlIII.isEntityAlive()) {
            final String llllllllllllIIlIIlIIlIIIIIlIlIlI = llllllllllllIIlIIlIIlIIIIIlIlIII.getCachedUniqueIdString();
            this.removeObjectiveFromEntity(llllllllllllIIlIIlIIlIIIIIlIlIlI, null);
            this.removePlayerFromTeams(llllllllllllIIlIIlIIlIIIIIlIlIlI);
        }
    }
    
    public Collection<Score> getSortedScores(final ScoreObjective llllllllllllIIlIIlIIlIIIllllIIII) {
        final List<Score> llllllllllllIIlIIlIIlIIIlllIllll = (List<Score>)Lists.newArrayList();
        for (final Map<ScoreObjective, Score> llllllllllllIIlIIlIIlIIIlllIlllI : this.entitiesScoreObjectives.values()) {
            final Score llllllllllllIIlIIlIIlIIIlllIllIl = llllllllllllIIlIIlIIlIIIlllIlllI.get(llllllllllllIIlIIlIIlIIIllllIIII);
            if (llllllllllllIIlIIlIIlIIIlllIllIl != null) {
                llllllllllllIIlIIlIIlIIIlllIllll.add(llllllllllllIIlIIlIIlIIIlllIllIl);
            }
        }
        Collections.sort(llllllllllllIIlIIlIIlIIIlllIllll, Score.SCORE_COMPARATOR);
        return llllllllllllIIlIIlIIlIIIlllIllll;
    }
    
    public Collection<String> getObjectiveNames() {
        return this.entitiesScoreObjectives.keySet();
    }
    
    public Collection<String> getTeamNames() {
        return this.teams.keySet();
    }
    
    public boolean removePlayerFromTeams(final String llllllllllllIIlIIlIIlIIIIllIlllI) {
        final ScorePlayerTeam llllllllllllIIlIIlIIlIIIIllIllIl = this.getPlayersTeam(llllllllllllIIlIIlIIlIIIIllIlllI);
        if (llllllllllllIIlIIlIIlIIIIllIllIl != null) {
            this.removePlayerFromTeam(llllllllllllIIlIIlIIlIIIIllIlllI, llllllllllllIIlIIlIIlIIIIllIllIl);
            return true;
        }
        return false;
    }
    
    public void onObjectiveDisplayNameChanged(final ScoreObjective llllllllllllIIlIIlIIlIIIIlIlIIIl) {
    }
    
    public boolean addPlayerToTeam(final String llllllllllllIIlIIlIIlIIIIlllIlIl, final String llllllllllllIIlIIlIIlIIIIllllIII) {
        if (llllllllllllIIlIIlIIlIIIIlllIlIl.length() > 40) {
            throw new IllegalArgumentException("The player name '" + llllllllllllIIlIIlIIlIIIIlllIlIl + "' is too long!");
        }
        if (!this.teams.containsKey(llllllllllllIIlIIlIIlIIIIllllIII)) {
            return false;
        }
        final ScorePlayerTeam llllllllllllIIlIIlIIlIIIIlllIlll = this.getTeam(llllllllllllIIlIIlIIlIIIIllllIII);
        if (this.getPlayersTeam(llllllllllllIIlIIlIIlIIIIlllIlIl) != null) {
            this.removePlayerFromTeams(llllllllllllIIlIIlIIlIIIIlllIlIl);
        }
        this.teamMemberships.put(llllllllllllIIlIIlIIlIIIIlllIlIl, llllllllllllIIlIIlIIlIIIIlllIlll);
        llllllllllllIIlIIlIIlIIIIlllIlll.getMembershipCollection().add(llllllllllllIIlIIlIIlIIIIlllIlIl);
        return true;
    }
    
    public void onScoreObjectiveAdded(final ScoreObjective llllllllllllIIlIIlIIlIIIIlIlIIll) {
    }
    
    public void removeObjectiveFromEntity(final String llllllllllllIIlIIlIIlIIIllIllIIl, final ScoreObjective llllllllllllIIlIIlIIlIIIllIllIII) {
        if (llllllllllllIIlIIlIIlIIIllIllIII == null) {
            final Map<ScoreObjective, Score> llllllllllllIIlIIlIIlIIIllIlIlll = this.entitiesScoreObjectives.remove(llllllllllllIIlIIlIIlIIIllIllIIl);
            if (llllllllllllIIlIIlIIlIIIllIlIlll != null) {
                this.broadcastScoreUpdate(llllllllllllIIlIIlIIlIIIllIllIIl);
            }
        }
        else {
            final Map<ScoreObjective, Score> llllllllllllIIlIIlIIlIIIllIlIllI = this.entitiesScoreObjectives.get(llllllllllllIIlIIlIIlIIIllIllIIl);
            if (llllllllllllIIlIIlIIlIIIllIlIllI != null) {
                final Score llllllllllllIIlIIlIIlIIIllIlIlIl = llllllllllllIIlIIlIIlIIIllIlIllI.remove(llllllllllllIIlIIlIIlIIIllIllIII);
                if (llllllllllllIIlIIlIIlIIIllIlIllI.size() < 1) {
                    final Map<ScoreObjective, Score> llllllllllllIIlIIlIIlIIIllIlIlII = this.entitiesScoreObjectives.remove(llllllllllllIIlIIlIIlIIIllIllIIl);
                    if (llllllllllllIIlIIlIIlIIIllIlIlII != null) {
                        this.broadcastScoreUpdate(llllllllllllIIlIIlIIlIIIllIllIIl);
                    }
                }
                else if (llllllllllllIIlIIlIIlIIIllIlIlIl != null) {
                    this.broadcastScoreUpdate(llllllllllllIIlIIlIIlIIIllIllIIl, llllllllllllIIlIIlIIlIIIllIllIII);
                }
            }
        }
    }
    
    public static String getObjectiveDisplaySlot(final int llllllllllllIIlIIlIIlIIIIIllllll) {
        switch (llllllllllllIIlIIlIIlIIIIIllllll) {
            case 0: {
                return "list";
            }
            case 1: {
                return "sidebar";
            }
            case 2: {
                return "belowName";
            }
            default: {
                if (llllllllllllIIlIIlIIlIIIIIllllll >= 3 && llllllllllllIIlIIlIIlIIIIIllllll <= 18) {
                    final TextFormatting llllllllllllIIlIIlIIlIIIIIlllllI = TextFormatting.fromColorIndex(llllllllllllIIlIIlIIlIIIIIllllll - 3);
                    if (llllllllllllIIlIIlIIlIIIIIlllllI != null && llllllllllllIIlIIlIIlIIIIIlllllI != TextFormatting.RESET) {
                        return "sidebar.team." + llllllllllllIIlIIlIIlIIIIIlllllI.getFriendlyName();
                    }
                }
                return null;
            }
        }
    }
}
