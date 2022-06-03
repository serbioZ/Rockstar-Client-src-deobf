// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world;

public class WorldType
{
    private final /* synthetic */ String worldType;
    public static final /* synthetic */ WorldType DEFAULT_1_1;
    public static final /* synthetic */ WorldType DEFAULT;
    private final /* synthetic */ int generatorVersion;
    public static final /* synthetic */ WorldType[] WORLD_TYPES;
    private final /* synthetic */ int worldTypeId;
    private /* synthetic */ boolean canBeCreated;
    private /* synthetic */ boolean hasNotificationData;
    private /* synthetic */ boolean isWorldTypeVersioned;
    
    private WorldType setVersioned() {
        this.isWorldTypeVersioned = true;
        return this;
    }
    
    public String getTranslatedInfo() {
        return String.valueOf(this.getTranslateName()) + ".info";
    }
    
    static {
        WORLD_TYPES = new WorldType[16];
        DEFAULT = new WorldType(0, "default", 1).setVersioned();
        FLAT = new WorldType(1, "flat");
        LARGE_BIOMES = new WorldType(2, "largeBiomes");
        AMPLIFIED = new WorldType(3, "amplified").setNotificationData();
        CUSTOMIZED = new WorldType(4, "customized");
        DEBUG_WORLD = new WorldType(5, "debug_all_block_states");
        DEFAULT_1_1 = new WorldType(8, "default_1_1", 0).setCanBeCreated(false);
    }
    
    private WorldType(final int lllllllllllIlIIIllIIIIlIlIIIIIIl, final String lllllllllllIlIIIllIIIIlIIlllllII, final int lllllllllllIlIIIllIIIIlIIlllllll) {
        this.worldType = lllllllllllIlIIIllIIIIlIIlllllII;
        this.generatorVersion = lllllllllllIlIIIllIIIIlIIlllllll;
        this.canBeCreated = true;
        this.worldTypeId = lllllllllllIlIIIllIIIIlIlIIIIIIl;
        WorldType.WORLD_TYPES[lllllllllllIlIIIllIIIIlIlIIIIIIl] = this;
    }
    
    private WorldType setCanBeCreated(final boolean lllllllllllIlIIIllIIIIlIIllIIlIl) {
        this.canBeCreated = lllllllllllIlIIIllIIIIlIIllIIlIl;
        return this;
    }
    
    public int getWorldTypeID() {
        return this.worldTypeId;
    }
    
    private WorldType(final int lllllllllllIlIIIllIIIIlIlIIIlIII, final String lllllllllllIlIIIllIIIIlIlIIIlIlI) {
        this(lllllllllllIlIIIllIIIIlIlIIIlIII, lllllllllllIlIIIllIIIIlIlIIIlIlI, 0);
    }
    
    public String getTranslateName() {
        return "generator." + this.worldType;
    }
    
    public WorldType getWorldTypeForGeneratorVersion(final int lllllllllllIlIIIllIIIIlIIllIlIll) {
        return (this == WorldType.DEFAULT && lllllllllllIlIIIllIIIIlIIllIlIll == 0) ? WorldType.DEFAULT_1_1 : this;
    }
    
    private WorldType setNotificationData() {
        this.hasNotificationData = true;
        return this;
    }
    
    public boolean showWorldInfoNotice() {
        return this.hasNotificationData;
    }
    
    public boolean isVersioned() {
        return this.isWorldTypeVersioned;
    }
    
    public String getWorldTypeName() {
        return this.worldType;
    }
    
    public boolean getCanBeCreated() {
        return this.canBeCreated;
    }
    
    public int getGeneratorVersion() {
        return this.generatorVersion;
    }
    
    public static WorldType parseWorldType(final String lllllllllllIlIIIllIIIIlIIlIlIIlI) {
        String lllllllllllIlIIIllIIIIlIIlIIlllI;
        for (int lllllllllllIlIIIllIIIIlIIlIIllll = ((WorldType[])(Object)(lllllllllllIlIIIllIIIIlIIlIIlllI = (String)(Object)WorldType.WORLD_TYPES)).length, lllllllllllIlIIIllIIIIlIIlIlIIII = 0; lllllllllllIlIIIllIIIIlIIlIlIIII < lllllllllllIlIIIllIIIIlIIlIIllll; ++lllllllllllIlIIIllIIIIlIIlIlIIII) {
            final WorldType lllllllllllIlIIIllIIIIlIIlIlIIll = lllllllllllIlIIIllIIIIlIIlIIlllI[lllllllllllIlIIIllIIIIlIIlIlIIII];
            if (lllllllllllIlIIIllIIIIlIIlIlIIll != null && lllllllllllIlIIIllIIIIlIIlIlIIll.worldType.equalsIgnoreCase(lllllllllllIlIIIllIIIIlIIlIlIIlI)) {
                return lllllllllllIlIIIllIIIIlIIlIlIIll;
            }
        }
        return null;
    }
}
