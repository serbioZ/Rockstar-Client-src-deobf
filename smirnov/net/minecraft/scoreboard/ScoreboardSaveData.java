// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.scoreboard;

import net.minecraft.util.text.TextFormatting;
import org.apache.logging.log4j.LogManager;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.nbt.NBTTagList;
import org.apache.logging.log4j.Logger;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.storage.WorldSavedData;

public class ScoreboardSaveData extends WorldSavedData
{
    private /* synthetic */ Scoreboard theScoreboard;
    private /* synthetic */ NBTTagCompound delayedInitNbt;
    private static final /* synthetic */ Logger LOGGER;
    
    protected void readScores(final NBTTagList llllllllllIlllIlIlIIlIIIIIlllIII) {
        for (int llllllllllIlllIlIlIIlIIIIIllIlll = 0; llllllllllIlllIlIlIIlIIIIIllIlll < llllllllllIlllIlIlIIlIIIIIlllIII.tagCount(); ++llllllllllIlllIlIlIIlIIIIIllIlll) {
            final NBTTagCompound llllllllllIlllIlIlIIlIIIIIllIllI = llllllllllIlllIlIlIIlIIIIIlllIII.getCompoundTagAt(llllllllllIlllIlIlIIlIIIIIllIlll);
            final ScoreObjective llllllllllIlllIlIlIIlIIIIIllIlIl = this.theScoreboard.getObjective(llllllllllIlllIlIlIIlIIIIIllIllI.getString("Objective"));
            String llllllllllIlllIlIlIIlIIIIIllIlII = llllllllllIlllIlIlIIlIIIIIllIllI.getString("Name");
            if (llllllllllIlllIlIlIIlIIIIIllIlII.length() > 40) {
                llllllllllIlllIlIlIIlIIIIIllIlII = llllllllllIlllIlIlIIlIIIIIllIlII.substring(0, 40);
            }
            final Score llllllllllIlllIlIlIIlIIIIIllIIll = this.theScoreboard.getOrCreateScore(llllllllllIlllIlIlIIlIIIIIllIlII, llllllllllIlllIlIlIIlIIIIIllIlIl);
            llllllllllIlllIlIlIIlIIIIIllIIll.setScorePoints(llllllllllIlllIlIlIIlIIIIIllIllI.getInteger("Score"));
            if (llllllllllIlllIlIlIIlIIIIIllIllI.hasKey("Locked")) {
                llllllllllIlllIlIlIIlIIIIIllIIll.setLocked(llllllllllIlllIlIlIIlIIIIIllIllI.getBoolean("Locked"));
            }
        }
    }
    
    protected NBTTagList teamsToNbt() {
        final NBTTagList llllllllllIlllIlIlIIlIIIIIIlllII = new NBTTagList();
        for (final ScorePlayerTeam llllllllllIlllIlIlIIlIIIIIIllIll : this.theScoreboard.getTeams()) {
            final NBTTagCompound llllllllllIlllIlIlIIlIIIIIIllIlI = new NBTTagCompound();
            llllllllllIlllIlIlIIlIIIIIIllIlI.setString("Name", llllllllllIlllIlIlIIlIIIIIIllIll.getRegisteredName());
            llllllllllIlllIlIlIIlIIIIIIllIlI.setString("DisplayName", llllllllllIlllIlIlIIlIIIIIIllIll.getTeamName());
            if (llllllllllIlllIlIlIIlIIIIIIllIll.getChatFormat().getColorIndex() >= 0) {
                llllllllllIlllIlIlIIlIIIIIIllIlI.setString("TeamColor", llllllllllIlllIlIlIIlIIIIIIllIll.getChatFormat().getFriendlyName());
            }
            llllllllllIlllIlIlIIlIIIIIIllIlI.setString("Prefix", llllllllllIlllIlIlIIlIIIIIIllIll.getColorPrefix());
            llllllllllIlllIlIlIIlIIIIIIllIlI.setString("Suffix", llllllllllIlllIlIlIIlIIIIIIllIll.getColorSuffix());
            llllllllllIlllIlIlIIlIIIIIIllIlI.setBoolean("AllowFriendlyFire", llllllllllIlllIlIlIIlIIIIIIllIll.getAllowFriendlyFire());
            llllllllllIlllIlIlIIlIIIIIIllIlI.setBoolean("SeeFriendlyInvisibles", llllllllllIlllIlIlIIlIIIIIIllIll.getSeeFriendlyInvisiblesEnabled());
            llllllllllIlllIlIlIIlIIIIIIllIlI.setString("NameTagVisibility", llllllllllIlllIlIlIIlIIIIIIllIll.getNameTagVisibility().internalName);
            llllllllllIlllIlIlIIlIIIIIIllIlI.setString("DeathMessageVisibility", llllllllllIlllIlIlIIlIIIIIIllIll.getDeathMessageVisibility().internalName);
            llllllllllIlllIlIlIIlIIIIIIllIlI.setString("CollisionRule", llllllllllIlllIlIlIIlIIIIIIllIll.getCollisionRule().name);
            final NBTTagList llllllllllIlllIlIlIIlIIIIIIllIIl = new NBTTagList();
            for (final String llllllllllIlllIlIlIIlIIIIIIllIII : llllllllllIlllIlIlIIlIIIIIIllIll.getMembershipCollection()) {
                llllllllllIlllIlIlIIlIIIIIIllIIl.appendTag(new NBTTagString(llllllllllIlllIlIlIIlIIIIIIllIII));
            }
            llllllllllIlllIlIlIIlIIIIIIllIlI.setTag("Players", llllllllllIlllIlIlIIlIIIIIIllIIl);
            llllllllllIlllIlIlIIlIIIIIIlllII.appendTag(llllllllllIlllIlIlIIlIIIIIIllIlI);
        }
        return llllllllllIlllIlIlIIlIIIIIIlllII;
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    public ScoreboardSaveData() {
        this("scoreboard");
    }
    
    protected void readDisplayConfig(final NBTTagCompound llllllllllIlllIlIlIIlIIIIlIllllI) {
        for (int llllllllllIlllIlIlIIlIIIIlIlllIl = 0; llllllllllIlllIlIlIIlIIIIlIlllIl < 19; ++llllllllllIlllIlIlIIlIIIIlIlllIl) {
            if (llllllllllIlllIlIlIIlIIIIlIllllI.hasKey("slot_" + llllllllllIlllIlIlIIlIIIIlIlllIl, 8)) {
                final String llllllllllIlllIlIlIIlIIIIlIlllII = llllllllllIlllIlIlIIlIIIIlIllllI.getString("slot_" + llllllllllIlllIlIlIIlIIIIlIlllIl);
                final ScoreObjective llllllllllIlllIlIlIIlIIIIlIllIll = this.theScoreboard.getObjective(llllllllllIlllIlIlIIlIIIIlIlllII);
                this.theScoreboard.setObjectiveInDisplaySlot(llllllllllIlllIlIlIIlIIIIlIlllIl, llllllllllIlllIlIlIIlIIIIlIllIll);
            }
        }
    }
    
    public ScoreboardSaveData(final String llllllllllIlllIlIlIIlIIIlIIlIlll) {
        super(llllllllllIlllIlIlIIlIIIlIIlIlll);
    }
    
    public void setScoreboard(final Scoreboard llllllllllIlllIlIlIIlIIIlIIlIIIl) {
        this.theScoreboard = llllllllllIlllIlIlIIlIIIlIIlIIIl;
        if (this.delayedInitNbt != null) {
            this.readFromNBT(this.delayedInitNbt);
        }
    }
    
    protected void readObjectives(final NBTTagList llllllllllIlllIlIlIIlIIIIlIIIllI) {
        for (int llllllllllIlllIlIlIIlIIIIlIIllII = 0; llllllllllIlllIlIlIIlIIIIlIIllII < llllllllllIlllIlIlIIlIIIIlIIIllI.tagCount(); ++llllllllllIlllIlIlIIlIIIIlIIllII) {
            final NBTTagCompound llllllllllIlllIlIlIIlIIIIlIIlIll = llllllllllIlllIlIlIIlIIIIlIIIllI.getCompoundTagAt(llllllllllIlllIlIlIIlIIIIlIIllII);
            final IScoreCriteria llllllllllIlllIlIlIIlIIIIlIIlIlI = IScoreCriteria.INSTANCES.get(llllllllllIlllIlIlIIlIIIIlIIlIll.getString("CriteriaName"));
            if (llllllllllIlllIlIlIIlIIIIlIIlIlI != null) {
                String llllllllllIlllIlIlIIlIIIIlIIlIIl = llllllllllIlllIlIlIIlIIIIlIIlIll.getString("Name");
                if (llllllllllIlllIlIlIIlIIIIlIIlIIl.length() > 16) {
                    llllllllllIlllIlIlIIlIIIIlIIlIIl = llllllllllIlllIlIlIIlIIIIlIIlIIl.substring(0, 16);
                }
                final ScoreObjective llllllllllIlllIlIlIIlIIIIlIIlIII = this.theScoreboard.addScoreObjective(llllllllllIlllIlIlIIlIIIIlIIlIIl, llllllllllIlllIlIlIIlIIIIlIIlIlI);
                llllllllllIlllIlIlIIlIIIIlIIlIII.setDisplayName(llllllllllIlllIlIlIIlIIIIlIIlIll.getString("DisplayName"));
                llllllllllIlllIlIlIIlIIIIlIIlIII.setRenderType(IScoreCriteria.EnumRenderType.getByName(llllllllllIlllIlIlIIlIIIIlIIlIll.getString("RenderType")));
            }
        }
    }
    
    protected void fillInDisplaySlots(final NBTTagCompound llllllllllIlllIlIlIIlIIIIIIIlIII) {
        final NBTTagCompound llllllllllIlllIlIlIIlIIIIIIIIlll = new NBTTagCompound();
        boolean llllllllllIlllIlIlIIlIIIIIIIIllI = false;
        for (int llllllllllIlllIlIlIIlIIIIIIIIlIl = 0; llllllllllIlllIlIlIIlIIIIIIIIlIl < 19; ++llllllllllIlllIlIlIIlIIIIIIIIlIl) {
            final ScoreObjective llllllllllIlllIlIlIIlIIIIIIIIlII = this.theScoreboard.getObjectiveInDisplaySlot(llllllllllIlllIlIlIIlIIIIIIIIlIl);
            if (llllllllllIlllIlIlIIlIIIIIIIIlII != null) {
                llllllllllIlllIlIlIIlIIIIIIIIlll.setString("slot_" + llllllllllIlllIlIlIIlIIIIIIIIlIl, llllllllllIlllIlIlIIlIIIIIIIIlII.getName());
                llllllllllIlllIlIlIIlIIIIIIIIllI = true;
            }
        }
        if (llllllllllIlllIlIlIIlIIIIIIIIllI) {
            llllllllllIlllIlIlIIlIIIIIIIlIII.setTag("DisplaySlots", llllllllllIlllIlIlIIlIIIIIIIIlll);
        }
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound llllllllllIlllIlIlIIlIIIlIIIllIl) {
        if (this.theScoreboard == null) {
            this.delayedInitNbt = llllllllllIlllIlIlIIlIIIlIIIllIl;
        }
        else {
            this.readObjectives(llllllllllIlllIlIlIIlIIIlIIIllIl.getTagList("Objectives", 10));
            this.readScores(llllllllllIlllIlIlIIlIIIlIIIllIl.getTagList("PlayerScores", 10));
            if (llllllllllIlllIlIlIIlIIIlIIIllIl.hasKey("DisplaySlots", 10)) {
                this.readDisplayConfig(llllllllllIlllIlIlIIlIIIlIIIllIl.getCompoundTag("DisplaySlots"));
            }
            if (llllllllllIlllIlIlIIlIIIlIIIllIl.hasKey("Teams", 9)) {
                this.readTeams(llllllllllIlllIlIlIIlIIIlIIIllIl.getTagList("Teams", 10));
            }
        }
    }
    
    protected NBTTagList objectivesToNbt() {
        final NBTTagList llllllllllIlllIlIlIIIlllllllIlll = new NBTTagList();
        for (final ScoreObjective llllllllllIlllIlIlIIIlllllllIllI : this.theScoreboard.getScoreObjectives()) {
            if (llllllllllIlllIlIlIIIlllllllIllI.getCriteria() != null) {
                final NBTTagCompound llllllllllIlllIlIlIIIlllllllIlIl = new NBTTagCompound();
                llllllllllIlllIlIlIIIlllllllIlIl.setString("Name", llllllllllIlllIlIlIIIlllllllIllI.getName());
                llllllllllIlllIlIlIIIlllllllIlIl.setString("CriteriaName", llllllllllIlllIlIlIIIlllllllIllI.getCriteria().getName());
                llllllllllIlllIlIlIIIlllllllIlIl.setString("DisplayName", llllllllllIlllIlIlIIIlllllllIllI.getDisplayName());
                llllllllllIlllIlIlIIIlllllllIlIl.setString("RenderType", llllllllllIlllIlIlIIIlllllllIllI.getRenderType().getRenderType());
                llllllllllIlllIlIlIIIlllllllIlll.appendTag(llllllllllIlllIlIlIIIlllllllIlIl);
            }
        }
        return llllllllllIlllIlIlIIIlllllllIlll;
    }
    
    protected void loadTeamPlayers(final ScorePlayerTeam llllllllllIlllIlIlIIlIIIIllIIlll, final NBTTagList llllllllllIlllIlIlIIlIIIIllIIllI) {
        for (int llllllllllIlllIlIlIIlIIIIllIlIIl = 0; llllllllllIlllIlIlIIlIIIIllIlIIl < llllllllllIlllIlIlIIlIIIIllIIllI.tagCount(); ++llllllllllIlllIlIlIIlIIIIllIlIIl) {
            this.theScoreboard.addPlayerToTeam(llllllllllIlllIlIlIIlIIIIllIIllI.getStringTagAt(llllllllllIlllIlIlIIlIIIIllIlIIl), llllllllllIlllIlIlIIlIIIIllIIlll.getRegisteredName());
        }
    }
    
    protected NBTTagList scoresToNbt() {
        final NBTTagList llllllllllIlllIlIlIIIllllllIlIIl = new NBTTagList();
        for (final Score llllllllllIlllIlIlIIIllllllIlIII : this.theScoreboard.getScores()) {
            if (llllllllllIlllIlIlIIIllllllIlIII.getObjective() != null) {
                final NBTTagCompound llllllllllIlllIlIlIIIllllllIIlll = new NBTTagCompound();
                llllllllllIlllIlIlIIIllllllIIlll.setString("Name", llllllllllIlllIlIlIIIllllllIlIII.getPlayerName());
                llllllllllIlllIlIlIIIllllllIIlll.setString("Objective", llllllllllIlllIlIlIIIllllllIlIII.getObjective().getName());
                llllllllllIlllIlIlIIIllllllIIlll.setInteger("Score", llllllllllIlllIlIlIIIllllllIlIII.getScorePoints());
                llllllllllIlllIlIlIIIllllllIIlll.setBoolean("Locked", llllllllllIlllIlIlIIIllllllIlIII.isLocked());
                llllllllllIlllIlIlIIIllllllIlIIl.appendTag(llllllllllIlllIlIlIIIllllllIIlll);
            }
        }
        return llllllllllIlllIlIlIIIllllllIlIIl;
    }
    
    protected void readTeams(final NBTTagList llllllllllIlllIlIlIIlIIIIlllIlll) {
        for (int llllllllllIlllIlIlIIlIIIlIIIIIII = 0; llllllllllIlllIlIlIIlIIIlIIIIIII < llllllllllIlllIlIlIIlIIIIlllIlll.tagCount(); ++llllllllllIlllIlIlIIlIIIlIIIIIII) {
            final NBTTagCompound llllllllllIlllIlIlIIlIIIIlllllll = llllllllllIlllIlIlIIlIIIIlllIlll.getCompoundTagAt(llllllllllIlllIlIlIIlIIIlIIIIIII);
            String llllllllllIlllIlIlIIlIIIIllllllI = llllllllllIlllIlIlIIlIIIIlllllll.getString("Name");
            if (llllllllllIlllIlIlIIlIIIIllllllI.length() > 16) {
                llllllllllIlllIlIlIIlIIIIllllllI = llllllllllIlllIlIlIIlIIIIllllllI.substring(0, 16);
            }
            final ScorePlayerTeam llllllllllIlllIlIlIIlIIIIlllllIl = this.theScoreboard.createTeam(llllllllllIlllIlIlIIlIIIIllllllI);
            String llllllllllIlllIlIlIIlIIIIlllllII = llllllllllIlllIlIlIIlIIIIlllllll.getString("DisplayName");
            if (llllllllllIlllIlIlIIlIIIIlllllII.length() > 32) {
                llllllllllIlllIlIlIIlIIIIlllllII = llllllllllIlllIlIlIIlIIIIlllllII.substring(0, 32);
            }
            llllllllllIlllIlIlIIlIIIIlllllIl.setTeamName(llllllllllIlllIlIlIIlIIIIlllllII);
            if (llllllllllIlllIlIlIIlIIIIlllllll.hasKey("TeamColor", 8)) {
                llllllllllIlllIlIlIIlIIIIlllllIl.setChatFormat(TextFormatting.getValueByName(llllllllllIlllIlIlIIlIIIIlllllll.getString("TeamColor")));
            }
            llllllllllIlllIlIlIIlIIIIlllllIl.setNamePrefix(llllllllllIlllIlIlIIlIIIIlllllll.getString("Prefix"));
            llllllllllIlllIlIlIIlIIIIlllllIl.setNameSuffix(llllllllllIlllIlIlIIlIIIIlllllll.getString("Suffix"));
            if (llllllllllIlllIlIlIIlIIIIlllllll.hasKey("AllowFriendlyFire", 99)) {
                llllllllllIlllIlIlIIlIIIIlllllIl.setAllowFriendlyFire(llllllllllIlllIlIlIIlIIIIlllllll.getBoolean("AllowFriendlyFire"));
            }
            if (llllllllllIlllIlIlIIlIIIIlllllll.hasKey("SeeFriendlyInvisibles", 99)) {
                llllllllllIlllIlIlIIlIIIIlllllIl.setSeeFriendlyInvisiblesEnabled(llllllllllIlllIlIlIIlIIIIlllllll.getBoolean("SeeFriendlyInvisibles"));
            }
            if (llllllllllIlllIlIlIIlIIIIlllllll.hasKey("NameTagVisibility", 8)) {
                final Team.EnumVisible llllllllllIlllIlIlIIlIIIIllllIll = Team.EnumVisible.getByName(llllllllllIlllIlIlIIlIIIIlllllll.getString("NameTagVisibility"));
                if (llllllllllIlllIlIlIIlIIIIllllIll != null) {
                    llllllllllIlllIlIlIIlIIIIlllllIl.setNameTagVisibility(llllllllllIlllIlIlIIlIIIIllllIll);
                }
            }
            if (llllllllllIlllIlIlIIlIIIIlllllll.hasKey("DeathMessageVisibility", 8)) {
                final Team.EnumVisible llllllllllIlllIlIlIIlIIIIllllIlI = Team.EnumVisible.getByName(llllllllllIlllIlIlIIlIIIIlllllll.getString("DeathMessageVisibility"));
                if (llllllllllIlllIlIlIIlIIIIllllIlI != null) {
                    llllllllllIlllIlIlIIlIIIIlllllIl.setDeathMessageVisibility(llllllllllIlllIlIlIIlIIIIllllIlI);
                }
            }
            if (llllllllllIlllIlIlIIlIIIIlllllll.hasKey("CollisionRule", 8)) {
                final Team.CollisionRule llllllllllIlllIlIlIIlIIIIllllIIl = Team.CollisionRule.getByName(llllllllllIlllIlIlIIlIIIIlllllll.getString("CollisionRule"));
                if (llllllllllIlllIlIlIIlIIIIllllIIl != null) {
                    llllllllllIlllIlIlIIlIIIIlllllIl.setCollisionRule(llllllllllIlllIlIlIIlIIIIllllIIl);
                }
            }
            this.loadTeamPlayers(llllllllllIlllIlIlIIlIIIIlllllIl, llllllllllIlllIlIlIIlIIIIlllllll.getTagList("Players", 8));
        }
    }
    
    @Override
    public NBTTagCompound writeToNBT(final NBTTagCompound llllllllllIlllIlIlIIlIIIIIlIlIII) {
        if (this.theScoreboard == null) {
            ScoreboardSaveData.LOGGER.warn("Tried to save scoreboard without having a scoreboard...");
            return llllllllllIlllIlIlIIlIIIIIlIlIII;
        }
        llllllllllIlllIlIlIIlIIIIIlIlIII.setTag("Objectives", this.objectivesToNbt());
        llllllllllIlllIlIlIIlIIIIIlIlIII.setTag("PlayerScores", this.scoresToNbt());
        llllllllllIlllIlIlIIlIIIIIlIlIII.setTag("Teams", this.teamsToNbt());
        this.fillInDisplaySlots(llllllllllIlllIlIlIIlIIIIIlIlIII);
        return llllllllllIlllIlIlIIlIIIIIlIlIII;
    }
}
