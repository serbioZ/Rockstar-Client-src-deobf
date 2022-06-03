// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.scoreboard;

import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Collection;
import javax.annotation.Nullable;
import net.minecraft.util.text.TextFormatting;

public abstract class Team
{
    public abstract String formatString(final String p0);
    
    public abstract TextFormatting getChatFormat();
    
    public abstract boolean getSeeFriendlyInvisiblesEnabled();
    
    public abstract boolean getAllowFriendlyFire();
    
    public abstract CollisionRule getCollisionRule();
    
    public boolean isSameTeam(@Nullable final Team lllllllllllllIlllllIllIlIlIIlIIl) {
        return lllllllllllllIlllllIllIlIlIIlIIl != null && this == lllllllllllllIlllllIllIlIlIIlIIl;
    }
    
    public abstract Collection<String> getMembershipCollection();
    
    public abstract EnumVisible getDeathMessageVisibility();
    
    public abstract EnumVisible getNameTagVisibility();
    
    public abstract String getRegisteredName();
    
    public enum CollisionRule
    {
        NEVER("NEVER", 1, "never", 1), 
        HIDE_FOR_OTHER_TEAMS("HIDE_FOR_OTHER_TEAMS", 2, "pushOtherTeams", 2);
        
        public final /* synthetic */ int id;
        private static final /* synthetic */ Map<String, CollisionRule> nameMap;
        public final /* synthetic */ String name;
        
        ALWAYS("ALWAYS", 0, "always", 0), 
        HIDE_FOR_OWN_TEAM("HIDE_FOR_OWN_TEAM", 3, "pushOwnTeam", 3);
        
        @Nullable
        public static CollisionRule getByName(final String lllllllllllIIIllIlIllllllllllllI) {
            return CollisionRule.nameMap.get(lllllllllllIIIllIlIllllllllllllI);
        }
        
        static {
            nameMap = Maps.newHashMap();
            float lllllllllllIIIllIllIIIIIIIIIIIII;
            for (float lllllllllllIIIllIllIIIIIIIIIIIIl = ((CollisionRule[])(Object)(lllllllllllIIIllIllIIIIIIIIIIIII = (float)(Object)values())).length, lllllllllllIIIllIllIIIIIIIIIIIlI = 0; lllllllllllIIIllIllIIIIIIIIIIIlI < lllllllllllIIIllIllIIIIIIIIIIIIl; ++lllllllllllIIIllIllIIIIIIIIIIIlI) {
                final CollisionRule lllllllllllIIIllIllIIIIIIIIIIlII = lllllllllllIIIllIllIIIIIIIIIIIII[lllllllllllIIIllIllIIIIIIIIIIIlI];
                CollisionRule.nameMap.put(lllllllllllIIIllIllIIIIIIIIIIlII.name, lllllllllllIIIllIllIIIIIIIIIIlII);
            }
        }
        
        private CollisionRule(final String lllllllllllIIIllIlIlllllllllIIll, final int lllllllllllIIIllIlIlllllllllIIlI, final String lllllllllllIIIllIlIlllllllllIllI, final int lllllllllllIIIllIlIlllllllllIIII) {
            this.name = lllllllllllIIIllIlIlllllllllIllI;
            this.id = lllllllllllIIIllIlIlllllllllIIII;
        }
        
        public static String[] getNames() {
            return CollisionRule.nameMap.keySet().toArray(new String[CollisionRule.nameMap.size()]);
        }
    }
    
    public enum EnumVisible
    {
        NEVER("NEVER", 1, "never", 1), 
        HIDE_FOR_OWN_TEAM("HIDE_FOR_OWN_TEAM", 3, "hideForOwnTeam", 3);
        
        public final /* synthetic */ int id;
        public final /* synthetic */ String internalName;
        private static final /* synthetic */ Map<String, EnumVisible> nameMap;
        
        HIDE_FOR_OTHER_TEAMS("HIDE_FOR_OTHER_TEAMS", 2, "hideForOtherTeams", 2), 
        ALWAYS("ALWAYS", 0, "always", 0);
        
        static {
            nameMap = Maps.newHashMap();
            final boolean lllllllllllIlIIlIIIIIIlIIIlIIIll;
            final double lllllllllllIlIIlIIIIIIlIIIlIIlII = ((EnumVisible[])(Object)(lllllllllllIlIIlIIIIIIlIIIlIIIll = (boolean)(Object)values())).length;
            for (float lllllllllllIlIIlIIIIIIlIIIlIIlIl = 0; lllllllllllIlIIlIIIIIIlIIIlIIlIl < lllllllllllIlIIlIIIIIIlIIIlIIlII; ++lllllllllllIlIIlIIIIIIlIIIlIIlIl) {
                final EnumVisible lllllllllllIlIIlIIIIIIlIIIlIIlll = lllllllllllIlIIlIIIIIIlIIIlIIIll[lllllllllllIlIIlIIIIIIlIIIlIIlIl];
                EnumVisible.nameMap.put(lllllllllllIlIIlIIIIIIlIIIlIIlll.internalName, lllllllllllIlIIlIIIIIIlIIIlIIlll);
            }
        }
        
        public static String[] getNames() {
            return EnumVisible.nameMap.keySet().toArray(new String[EnumVisible.nameMap.size()]);
        }
        
        private EnumVisible(final String lllllllllllIlIIlIIIIIIlIIIIlIllI, final int lllllllllllIlIIlIIIIIIlIIIIlIlIl, final String lllllllllllIlIIlIIIIIIlIIIIllIIl, final int lllllllllllIlIIlIIIIIIlIIIIlIIll) {
            this.internalName = lllllllllllIlIIlIIIIIIlIIIIllIIl;
            this.id = lllllllllllIlIIlIIIIIIlIIIIlIIll;
        }
        
        @Nullable
        public static EnumVisible getByName(final String lllllllllllIlIIlIIIIIIlIIIlIIIII) {
            return EnumVisible.nameMap.get(lllllllllllIlIIlIIIIIIlIIIlIIIII);
        }
    }
}
