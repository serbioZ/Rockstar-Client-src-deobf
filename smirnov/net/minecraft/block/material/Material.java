// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block.material;

public class Material
{
    private final /* synthetic */ MapColor materialMapColor;
    private /* synthetic */ boolean isAdventureModeExempt;
    private /* synthetic */ boolean requiresNoTool;
    private /* synthetic */ boolean replaceable;
    private /* synthetic */ boolean isTranslucent;
    private /* synthetic */ EnumPushReaction mobilityFlag;
    private /* synthetic */ boolean canBurn;
    
    public MapColor getMaterialMapColor() {
        return this.materialMapColor;
    }
    
    public boolean getCanBurn() {
        return this.canBurn;
    }
    
    protected Material setBurning() {
        this.canBurn = true;
        return this;
    }
    
    private Material setTranslucent() {
        this.isTranslucent = true;
        return this;
    }
    
    public boolean blocksLight() {
        return true;
    }
    
    public Material setReplaceable() {
        this.replaceable = true;
        return this;
    }
    
    protected Material setImmovableMobility() {
        this.mobilityFlag = EnumPushReaction.BLOCK;
        return this;
    }
    
    protected Material setNoPushMobility() {
        this.mobilityFlag = EnumPushReaction.DESTROY;
        return this;
    }
    
    protected Material setRequiresTool() {
        this.requiresNoTool = false;
        return this;
    }
    
    public boolean isReplaceable() {
        return this.replaceable;
    }
    
    public boolean isToolNotRequired() {
        return this.requiresNoTool;
    }
    
    public boolean isSolid() {
        return true;
    }
    
    public boolean isOpaque() {
        return !this.isTranslucent && this.blocksMovement();
    }
    
    protected Material setAdventureModeExempt() {
        this.isAdventureModeExempt = true;
        return this;
    }
    
    public boolean blocksMovement() {
        return true;
    }
    
    static {
        AIR = new MaterialTransparent(MapColor.AIR);
        GRASS = new Material(MapColor.GRASS);
        GROUND = new Material(MapColor.DIRT);
        WOOD = new Material(MapColor.WOOD).setBurning();
        ROCK = new Material(MapColor.STONE).setRequiresTool();
        IRON = new Material(MapColor.IRON).setRequiresTool();
        ANVIL = new Material(MapColor.IRON).setRequiresTool().setImmovableMobility();
        WATER = new MaterialLiquid(MapColor.WATER).setNoPushMobility();
        LAVA = new MaterialLiquid(MapColor.TNT).setNoPushMobility();
        LEAVES = new Material(MapColor.FOLIAGE).setBurning().setTranslucent().setNoPushMobility();
        PLANTS = new MaterialLogic(MapColor.FOLIAGE).setNoPushMobility();
        VINE = new MaterialLogic(MapColor.FOLIAGE).setBurning().setNoPushMobility().setReplaceable();
        SPONGE = new Material(MapColor.YELLOW);
        CLOTH = new Material(MapColor.CLOTH).setBurning();
        FIRE = new MaterialTransparent(MapColor.AIR).setNoPushMobility();
        SAND = new Material(MapColor.SAND);
        CIRCUITS = new MaterialLogic(MapColor.AIR).setNoPushMobility();
        CARPET = new MaterialLogic(MapColor.CLOTH).setBurning();
        GLASS = new Material(MapColor.AIR).setTranslucent().setAdventureModeExempt();
        REDSTONE_LIGHT = new Material(MapColor.AIR).setAdventureModeExempt();
        TNT = new Material(MapColor.TNT).setBurning().setTranslucent();
        CORAL = new Material(MapColor.FOLIAGE).setNoPushMobility();
        ICE = new Material(MapColor.ICE).setTranslucent().setAdventureModeExempt();
        PACKED_ICE = new Material(MapColor.ICE).setAdventureModeExempt();
        SNOW = new MaterialLogic(MapColor.SNOW).setReplaceable().setTranslucent().setRequiresTool().setNoPushMobility();
        CRAFTED_SNOW = new Material(MapColor.SNOW).setRequiresTool();
        CACTUS = new Material(MapColor.FOLIAGE).setTranslucent().setNoPushMobility();
        CLAY = new Material(MapColor.CLAY);
        GOURD = new Material(MapColor.FOLIAGE).setNoPushMobility();
        DRAGON_EGG = new Material(MapColor.FOLIAGE).setNoPushMobility();
        PORTAL = new MaterialPortal(MapColor.AIR).setImmovableMobility();
        CAKE = new Material(MapColor.AIR).setNoPushMobility();
        WEB = new Material() {
            @Override
            public boolean blocksMovement() {
                return false;
            }
        }.setRequiresTool().setNoPushMobility();
        PISTON = new Material(MapColor.STONE).setImmovableMobility();
        BARRIER = new Material(MapColor.AIR).setRequiresTool().setImmovableMobility();
        STRUCTURE_VOID = new MaterialTransparent(MapColor.AIR);
    }
    
    public Material(final MapColor lllllllllllllIlIllllIlIlIIllllIl) {
        this.requiresNoTool = true;
        this.mobilityFlag = EnumPushReaction.NORMAL;
        this.materialMapColor = lllllllllllllIlIllllIlIlIIllllIl;
    }
    
    public EnumPushReaction getMobilityFlag() {
        return this.mobilityFlag;
    }
    
    public boolean isLiquid() {
        return false;
    }
}
