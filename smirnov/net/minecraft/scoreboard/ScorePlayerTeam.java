// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.scoreboard;

import javax.annotation.Nullable;
import java.util.Collection;
import com.google.common.collect.Sets;
import net.minecraft.util.text.TextFormatting;
import java.util.Set;

public class ScorePlayerTeam extends Team
{
    private /* synthetic */ EnumVisible deathMessageVisibility;
    private final /* synthetic */ Scoreboard theScoreboard;
    private /* synthetic */ EnumVisible nameTagVisibility;
    private /* synthetic */ String teamNameSPT;
    private final /* synthetic */ Set<String> membershipSet;
    private final /* synthetic */ String registeredName;
    private /* synthetic */ TextFormatting chatFormat;
    private /* synthetic */ CollisionRule collisionRule;
    private /* synthetic */ String namePrefixSPT;
    private /* synthetic */ boolean allowFriendlyFire;
    private /* synthetic */ String colorSuffix;
    private /* synthetic */ boolean canSeeFriendlyInvisibles;
    
    public ScorePlayerTeam(final Scoreboard llllllllllllIIIllllIIllllIlIllII, final String llllllllllllIIIllllIIllllIlIlllI) {
        this.membershipSet = (Set<String>)Sets.newHashSet();
        this.namePrefixSPT = "";
        this.colorSuffix = "";
        this.allowFriendlyFire = true;
        this.canSeeFriendlyInvisibles = true;
        this.nameTagVisibility = EnumVisible.ALWAYS;
        this.deathMessageVisibility = EnumVisible.ALWAYS;
        this.chatFormat = TextFormatting.RESET;
        this.collisionRule = CollisionRule.ALWAYS;
        this.theScoreboard = llllllllllllIIIllllIIllllIlIllII;
        this.registeredName = llllllllllllIIIllllIIllllIlIlllI;
        this.teamNameSPT = llllllllllllIIIllllIIllllIlIlllI;
    }
    
    @Override
    public EnumVisible getDeathMessageVisibility() {
        return this.deathMessageVisibility;
    }
    
    @Override
    public String formatString(final String llllllllllllIIIllllIIllllIIIIlII) {
        return String.valueOf(this.getColorPrefix()) + llllllllllllIIIllllIIllllIIIIlII + this.getColorSuffix();
    }
    
    public void setCollisionRule(final CollisionRule llllllllllllIIIllllIIlllIlIlIIll) {
        this.collisionRule = llllllllllllIIIllllIIlllIlIlIIll;
        this.theScoreboard.broadcastTeamInfoUpdate(this);
    }
    
    @Override
    public EnumVisible getNameTagVisibility() {
        return this.nameTagVisibility;
    }
    
    @Override
    public Collection<String> getMembershipCollection() {
        return this.membershipSet;
    }
    
    public String getColorPrefix() {
        return this.namePrefixSPT;
    }
    
    @Override
    public TextFormatting getChatFormat() {
        return this.chatFormat;
    }
    
    public void setNameSuffix(final String llllllllllllIIIllllIIllllIIIlIlI) {
        this.colorSuffix = llllllllllllIIIllllIIllllIIIlIlI;
        this.theScoreboard.broadcastTeamInfoUpdate(this);
    }
    
    public void setDeathMessageVisibility(final EnumVisible llllllllllllIIIllllIIlllIlIlllII) {
        this.deathMessageVisibility = llllllllllllIIIllllIIlllIlIlllII;
        this.theScoreboard.broadcastTeamInfoUpdate(this);
    }
    
    public int getFriendlyFlags() {
        int llllllllllllIIIllllIIlllIlIIllIl = 0;
        if (this.getAllowFriendlyFire()) {
            llllllllllllIIIllllIIlllIlIIllIl |= 0x1;
        }
        if (this.getSeeFriendlyInvisiblesEnabled()) {
            llllllllllllIIIllllIIlllIlIIllIl |= 0x2;
        }
        return llllllllllllIIIllllIIlllIlIIllIl;
    }
    
    public String getTeamName() {
        return this.teamNameSPT;
    }
    
    public void setTeamName(final String llllllllllllIIIllllIIllllIlIIIIl) {
        if (llllllllllllIIIllllIIllllIlIIIIl == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        this.teamNameSPT = llllllllllllIIIllllIIllllIlIIIIl;
        this.theScoreboard.broadcastTeamInfoUpdate(this);
    }
    
    @Override
    public boolean getSeeFriendlyInvisiblesEnabled() {
        return this.canSeeFriendlyInvisibles;
    }
    
    @Override
    public boolean getAllowFriendlyFire() {
        return this.allowFriendlyFire;
    }
    
    @Override
    public String getRegisteredName() {
        return this.registeredName;
    }
    
    public void setSeeFriendlyInvisiblesEnabled(final boolean llllllllllllIIIllllIIlllIllIllII) {
        this.canSeeFriendlyInvisibles = llllllllllllIIIllllIIlllIllIllII;
        this.theScoreboard.broadcastTeamInfoUpdate(this);
    }
    
    public void setFriendlyFlags(final int llllllllllllIIIllllIIlllIlIIIlIl) {
        this.setAllowFriendlyFire((llllllllllllIIIllllIIlllIlIIIlIl & 0x1) > 0);
        this.setSeeFriendlyInvisiblesEnabled((llllllllllllIIIllllIIlllIlIIIlIl & 0x2) > 0);
    }
    
    public static String formatPlayerName(@Nullable final Team llllllllllllIIIllllIIllllIIIIIIl, final String llllllllllllIIIllllIIlllIllllllI) {
        return (llllllllllllIIIllllIIllllIIIIIIl == null) ? llllllllllllIIIllllIIlllIllllllI : llllllllllllIIIllllIIllllIIIIIIl.formatString(llllllllllllIIIllllIIlllIllllllI);
    }
    
    public void setNamePrefix(final String llllllllllllIIIllllIIllllIIlIlIl) {
        if (llllllllllllIIIllllIIllllIIlIlIl == null) {
            throw new IllegalArgumentException("Prefix cannot be null");
        }
        this.namePrefixSPT = llllllllllllIIIllllIIllllIIlIlIl;
        this.theScoreboard.broadcastTeamInfoUpdate(this);
    }
    
    public String getColorSuffix() {
        return this.colorSuffix;
    }
    
    public void setNameTagVisibility(final EnumVisible llllllllllllIIIllllIIlllIllIIIII) {
        this.nameTagVisibility = llllllllllllIIIllllIIlllIllIIIII;
        this.theScoreboard.broadcastTeamInfoUpdate(this);
    }
    
    @Override
    public CollisionRule getCollisionRule() {
        return this.collisionRule;
    }
    
    public void setAllowFriendlyFire(final boolean llllllllllllIIIllllIIlllIlllIlll) {
        this.allowFriendlyFire = llllllllllllIIIllllIIlllIlllIlll;
        this.theScoreboard.broadcastTeamInfoUpdate(this);
    }
    
    public void setChatFormat(final TextFormatting llllllllllllIIIllllIIlllIIllllll) {
        this.chatFormat = llllllllllllIIIllllIIlllIIllllll;
    }
}
