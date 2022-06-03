// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world;

public enum EnumDifficulty
{
    HARD("HARD", 3, 3, "options.difficulty.hard");
    
    private static final /* synthetic */ EnumDifficulty[] ID_MAPPING;
    
    PEACEFUL("PEACEFUL", 0, 0, "options.difficulty.peaceful"), 
    NORMAL("NORMAL", 2, 2, "options.difficulty.normal");
    
    private final /* synthetic */ int difficultyId;
    private final /* synthetic */ String difficultyResourceKey;
    
    EASY("EASY", 1, 1, "options.difficulty.easy");
    
    public int getDifficultyId() {
        return this.difficultyId;
    }
    
    public String getDifficultyResourceKey() {
        return this.difficultyResourceKey;
    }
    
    private EnumDifficulty(final String llllllllllllllIIllllIIllllIIllll, final int llllllllllllllIIllllIIllllIIlllI, final int llllllllllllllIIllllIIllllIlIIlI, final String llllllllllllllIIllllIIllllIIllII) {
        this.difficultyId = llllllllllllllIIllllIIllllIlIIlI;
        this.difficultyResourceKey = llllllllllllllIIllllIIllllIIllII;
    }
    
    static {
        ID_MAPPING = new EnumDifficulty[values().length];
        final long llllllllllllllIIllllIIllllIllIIl;
        final float llllllllllllllIIllllIIllllIllIlI = ((EnumDifficulty[])(Object)(llllllllllllllIIllllIIllllIllIIl = (long)(Object)values())).length;
        for (short llllllllllllllIIllllIIllllIllIll = 0; llllllllllllllIIllllIIllllIllIll < llllllllllllllIIllllIIllllIllIlI; ++llllllllllllllIIllllIIllllIllIll) {
            final EnumDifficulty llllllllllllllIIllllIIllllIlllIl = llllllllllllllIIllllIIllllIllIIl[llllllllllllllIIllllIIllllIllIll];
            EnumDifficulty.ID_MAPPING[llllllllllllllIIllllIIllllIlllIl.difficultyId] = llllllllllllllIIllllIIllllIlllIl;
        }
    }
    
    public static EnumDifficulty getDifficultyEnum(final int llllllllllllllIIllllIIllllIIIllI) {
        return EnumDifficulty.ID_MAPPING[llllllllllllllIIllllIIllllIIIllI % EnumDifficulty.ID_MAPPING.length];
    }
}
