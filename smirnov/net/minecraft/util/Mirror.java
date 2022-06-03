// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.util;

public enum Mirror
{
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Mirror;
    
    NONE("NONE", 0, "no_mirror"), 
    LEFT_RIGHT("LEFT_RIGHT", 1, "mirror_left_right");
    
    private final /* synthetic */ String name;
    private static final /* synthetic */ String[] mirrorNames;
    
    FRONT_BACK("FRONT_BACK", 2, "mirror_front_back");
    
    static {
        mirrorNames = new String[values().length];
        int lllllllllllIIlllIIIIIIIIllllllIl = 0;
        final int lllllllllllIIlllIIIIIIIIllllIlll;
        final int lllllllllllIIlllIIIIIIIIlllllIII = ((Mirror[])(Object)(lllllllllllIIlllIIIIIIIIllllIlll = (int)(Object)values())).length;
        for (float lllllllllllIIlllIIIIIIIIlllllIIl = 0; lllllllllllIIlllIIIIIIIIlllllIIl < lllllllllllIIlllIIIIIIIIlllllIII; ++lllllllllllIIlllIIIIIIIIlllllIIl) {
            final Mirror lllllllllllIIlllIIIIIIIIllllllII = lllllllllllIIlllIIIIIIIIllllIlll[lllllllllllIIlllIIIIIIIIlllllIIl];
            Mirror.mirrorNames[lllllllllllIIlllIIIIIIIIllllllIl++] = lllllllllllIIlllIIIIIIIIllllllII.name;
        }
    }
    
    public EnumFacing mirror(final EnumFacing lllllllllllIIlllIIIIIIIIllIlIIIl) {
        switch ($SWITCH_TABLE$net$minecraft$util$Mirror()[this.ordinal()]) {
            case 3: {
                if (lllllllllllIIlllIIIIIIIIllIlIIIl == EnumFacing.WEST) {
                    return EnumFacing.EAST;
                }
                if (lllllllllllIIlllIIIIIIIIllIlIIIl == EnumFacing.EAST) {
                    return EnumFacing.WEST;
                }
                return lllllllllllIIlllIIIIIIIIllIlIIIl;
            }
            case 2: {
                if (lllllllllllIIlllIIIIIIIIllIlIIIl == EnumFacing.NORTH) {
                    return EnumFacing.SOUTH;
                }
                if (lllllllllllIIlllIIIIIIIIllIlIIIl == EnumFacing.SOUTH) {
                    return EnumFacing.NORTH;
                }
                return lllllllllllIIlllIIIIIIIIllIlIIIl;
            }
            default: {
                return lllllllllllIIlllIIIIIIIIllIlIIIl;
            }
        }
    }
    
    public Rotation toRotation(final EnumFacing lllllllllllIIlllIIIIIIIIllIlIllI) {
        final EnumFacing.Axis lllllllllllIIlllIIIIIIIIllIllIII = lllllllllllIIlllIIIIIIIIllIlIllI.getAxis();
        return ((this != Mirror.LEFT_RIGHT || lllllllllllIIlllIIIIIIIIllIllIII != EnumFacing.Axis.Z) && (this != Mirror.FRONT_BACK || lllllllllllIIlllIIIIIIIIllIllIII != EnumFacing.Axis.X)) ? Rotation.NONE : Rotation.CLOCKWISE_180;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Mirror() {
        final int[] $switch_TABLE$net$minecraft$util$Mirror = Mirror.$SWITCH_TABLE$net$minecraft$util$Mirror;
        if ($switch_TABLE$net$minecraft$util$Mirror != null) {
            return $switch_TABLE$net$minecraft$util$Mirror;
        }
        final float lllllllllllIIlllIIIIIIIIllIIIlIl = (Object)new int[values().length];
        try {
            lllllllllllIIlllIIIIIIIIllIIIlIl[Mirror.FRONT_BACK.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllIIlllIIIIIIIIllIIIlIl[Mirror.LEFT_RIGHT.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllIIlllIIIIIIIIllIIIlIl[Mirror.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return Mirror.$SWITCH_TABLE$net$minecraft$util$Mirror = (int[])(Object)lllllllllllIIlllIIIIIIIIllIIIlIl;
    }
    
    private Mirror(final String lllllllllllIIlllIIIIIIIIlllIllll, final int lllllllllllIIlllIIIIIIIIlllIlllI, final String lllllllllllIIlllIIIIIIIIlllIllIl) {
        this.name = lllllllllllIIlllIIIIIIIIlllIllIl;
    }
    
    public int mirrorRotation(final int lllllllllllIIlllIIIIIIIIlllIIIIl, final int lllllllllllIIlllIIIIIIIIlllIIlIl) {
        final int lllllllllllIIlllIIIIIIIIlllIIlII = lllllllllllIIlllIIIIIIIIlllIIlIl / 2;
        final int lllllllllllIIlllIIIIIIIIlllIIIll = (lllllllllllIIlllIIIIIIIIlllIIIIl > lllllllllllIIlllIIIIIIIIlllIIlII) ? (lllllllllllIIlllIIIIIIIIlllIIIIl - lllllllllllIIlllIIIIIIIIlllIIlIl) : lllllllllllIIlllIIIIIIIIlllIIIIl;
        switch ($SWITCH_TABLE$net$minecraft$util$Mirror()[this.ordinal()]) {
            case 3: {
                return (lllllllllllIIlllIIIIIIIIlllIIlIl - lllllllllllIIlllIIIIIIIIlllIIIll) % lllllllllllIIlllIIIIIIIIlllIIlIl;
            }
            case 2: {
                return (lllllllllllIIlllIIIIIIIIlllIIlII - lllllllllllIIlllIIIIIIIIlllIIIll + lllllllllllIIlllIIIIIIIIlllIIlIl) % lllllllllllIIlllIIIIIIIIlllIIlIl;
            }
            default: {
                return lllllllllllIIlllIIIIIIIIlllIIIIl;
            }
        }
    }
}
