// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world;

import net.minecraft.entity.player.PlayerCapabilities;

public enum GameType
{
    CREATIVE("CREATIVE", 2, 1, "creative", "c");
    
    /* synthetic */ String shortName;
    /* synthetic */ int id;
    
    SPECTATOR("SPECTATOR", 4, 3, "spectator", "sp"), 
    NOT_SET("NOT_SET", 0, -1, "", "");
    
    /* synthetic */ String name;
    
    ADVENTURE("ADVENTURE", 3, 2, "adventure", "a"), 
    SURVIVAL("SURVIVAL", 1, 0, "survival", "s");
    
    private GameType(final String lllllllllllIlIllIlIIIIllllIIlIII, final int lllllllllllIlIllIlIIIIllllIIIlll, final int lllllllllllIlIllIlIIIIllllIIIllI, final String lllllllllllIlIllIlIIIIllllIIlIll, final String lllllllllllIlIllIlIIIIllllIIlIlI) {
        this.id = lllllllllllIlIllIlIIIIllllIIIllI;
        this.name = lllllllllllIlIllIlIIIIllllIIlIll;
        this.shortName = lllllllllllIlIllIlIIIIllllIIlIlI;
    }
    
    public static GameType getByID(final int lllllllllllIlIllIlIIIIlllIlIllII) {
        return parseGameTypeWithDefault(lllllllllllIlIllIlIIIIlllIlIllII, GameType.SURVIVAL);
    }
    
    public static GameType parseGameTypeWithDefault(final String lllllllllllIlIllIlIIIIlllIIlIIII, final GameType lllllllllllIlIllIlIIIIlllIIIllll) {
        final long lllllllllllIlIllIlIIIIlllIIIlIll;
        final long lllllllllllIlIllIlIIIIlllIIIllII = ((GameType[])(Object)(lllllllllllIlIllIlIIIIlllIIIlIll = (long)(Object)values())).length;
        for (char lllllllllllIlIllIlIIIIlllIIIllIl = '\0'; lllllllllllIlIllIlIIIIlllIIIllIl < lllllllllllIlIllIlIIIIlllIIIllII; ++lllllllllllIlIllIlIIIIlllIIIllIl) {
            final GameType lllllllllllIlIllIlIIIIlllIIlIIIl = lllllllllllIlIllIlIIIIlllIIIlIll[lllllllllllIlIllIlIIIIlllIIIllIl];
            if (lllllllllllIlIllIlIIIIlllIIlIIIl.name.equals(lllllllllllIlIllIlIIIIlllIIlIIII) || lllllllllllIlIllIlIIIIlllIIlIIIl.shortName.equals(lllllllllllIlIllIlIIIIlllIIlIIII)) {
                return lllllllllllIlIllIlIIIIlllIIlIIIl;
            }
        }
        return lllllllllllIlIllIlIIIIlllIIIllll;
    }
    
    public boolean isCreative() {
        return this == GameType.CREATIVE;
    }
    
    public int getID() {
        return this.id;
    }
    
    public boolean isSurvivalOrAdventure() {
        return this == GameType.SURVIVAL || this == GameType.ADVENTURE;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void configurePlayerCapabilities(final PlayerCapabilities lllllllllllIlIllIlIIIIlllIlllIII) {
        if (this == GameType.CREATIVE) {
            lllllllllllIlIllIlIIIIlllIlllIII.allowFlying = true;
            lllllllllllIlIllIlIIIIlllIlllIII.isCreativeMode = true;
            lllllllllllIlIllIlIIIIlllIlllIII.disableDamage = true;
        }
        else if (this == GameType.SPECTATOR) {
            lllllllllllIlIllIlIIIIlllIlllIII.allowFlying = true;
            lllllllllllIlIllIlIIIIlllIlllIII.isCreativeMode = false;
            lllllllllllIlIllIlIIIIlllIlllIII.disableDamage = true;
            lllllllllllIlIllIlIIIIlllIlllIII.isFlying = true;
        }
        else {
            lllllllllllIlIllIlIIIIlllIlllIII.allowFlying = false;
            lllllllllllIlIllIlIIIIlllIlllIII.isCreativeMode = false;
            lllllllllllIlIllIlIIIIlllIlllIII.disableDamage = false;
            lllllllllllIlIllIlIIIIlllIlllIII.isFlying = false;
        }
        lllllllllllIlIllIlIIIIlllIlllIII.allowEdit = !this.isAdventure();
    }
    
    public static GameType parseGameTypeWithDefault(final int lllllllllllIlIllIlIIIIlllIlIIlIl, final GameType lllllllllllIlIllIlIIIIlllIlIIIIl) {
        final long lllllllllllIlIllIlIIIIlllIIlllIl;
        final float lllllllllllIlIllIlIIIIlllIIllllI = ((GameType[])(Object)(lllllllllllIlIllIlIIIIlllIIlllIl = (long)(Object)values())).length;
        for (double lllllllllllIlIllIlIIIIlllIIlllll = 0; lllllllllllIlIllIlIIIIlllIIlllll < lllllllllllIlIllIlIIIIlllIIllllI; ++lllllllllllIlIllIlIIIIlllIIlllll) {
            final GameType lllllllllllIlIllIlIIIIlllIlIIIll = lllllllllllIlIllIlIIIIlllIIlllIl[lllllllllllIlIllIlIIIIlllIIlllll];
            if (lllllllllllIlIllIlIIIIlllIlIIIll.id == lllllllllllIlIllIlIIIIlllIlIIlIl) {
                return lllllllllllIlIllIlIIIIlllIlIIIll;
            }
        }
        return lllllllllllIlIllIlIIIIlllIlIIIIl;
    }
    
    public boolean isAdventure() {
        return this == GameType.ADVENTURE || this == GameType.SPECTATOR;
    }
    
    public static GameType getByName(final String lllllllllllIlIllIlIIIIlllIIllIlI) {
        return parseGameTypeWithDefault(lllllllllllIlIllIlIIIIlllIIllIlI, GameType.SURVIVAL);
    }
}
