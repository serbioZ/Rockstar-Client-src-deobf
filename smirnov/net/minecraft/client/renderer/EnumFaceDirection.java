// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer;

import net.minecraft.util.EnumFacing;

public enum EnumFaceDirection
{
    SOUTH("SOUTH", 3, new VertexInformation[] { new VertexInformation(Constants.WEST_INDEX, Constants.UP_INDEX, Constants.SOUTH_INDEX, null), new VertexInformation(Constants.WEST_INDEX, Constants.DOWN_INDEX, Constants.SOUTH_INDEX, null), new VertexInformation(Constants.EAST_INDEX, Constants.DOWN_INDEX, Constants.SOUTH_INDEX, null), new VertexInformation(Constants.EAST_INDEX, Constants.UP_INDEX, Constants.SOUTH_INDEX, null) }), 
    EAST("EAST", 5, new VertexInformation[] { new VertexInformation(Constants.EAST_INDEX, Constants.UP_INDEX, Constants.SOUTH_INDEX, null), new VertexInformation(Constants.EAST_INDEX, Constants.DOWN_INDEX, Constants.SOUTH_INDEX, null), new VertexInformation(Constants.EAST_INDEX, Constants.DOWN_INDEX, Constants.NORTH_INDEX, null), new VertexInformation(Constants.EAST_INDEX, Constants.UP_INDEX, Constants.NORTH_INDEX, null) }), 
    NORTH("NORTH", 2, new VertexInformation[] { new VertexInformation(Constants.EAST_INDEX, Constants.UP_INDEX, Constants.NORTH_INDEX, null), new VertexInformation(Constants.EAST_INDEX, Constants.DOWN_INDEX, Constants.NORTH_INDEX, null), new VertexInformation(Constants.WEST_INDEX, Constants.DOWN_INDEX, Constants.NORTH_INDEX, null), new VertexInformation(Constants.WEST_INDEX, Constants.UP_INDEX, Constants.NORTH_INDEX, null) }), 
    WEST("WEST", 4, new VertexInformation[] { new VertexInformation(Constants.WEST_INDEX, Constants.UP_INDEX, Constants.NORTH_INDEX, null), new VertexInformation(Constants.WEST_INDEX, Constants.DOWN_INDEX, Constants.NORTH_INDEX, null), new VertexInformation(Constants.WEST_INDEX, Constants.DOWN_INDEX, Constants.SOUTH_INDEX, null), new VertexInformation(Constants.WEST_INDEX, Constants.UP_INDEX, Constants.SOUTH_INDEX, null) });
    
    private static final /* synthetic */ EnumFaceDirection[] FACINGS;
    
    DOWN("DOWN", 0, new VertexInformation[] { new VertexInformation(Constants.WEST_INDEX, Constants.DOWN_INDEX, Constants.SOUTH_INDEX, null), new VertexInformation(Constants.WEST_INDEX, Constants.DOWN_INDEX, Constants.NORTH_INDEX, null), new VertexInformation(Constants.EAST_INDEX, Constants.DOWN_INDEX, Constants.NORTH_INDEX, null), new VertexInformation(Constants.EAST_INDEX, Constants.DOWN_INDEX, Constants.SOUTH_INDEX, null) });
    
    private final /* synthetic */ VertexInformation[] vertexInfos;
    
    UP("UP", 1, new VertexInformation[] { new VertexInformation(Constants.WEST_INDEX, Constants.UP_INDEX, Constants.NORTH_INDEX, null), new VertexInformation(Constants.WEST_INDEX, Constants.UP_INDEX, Constants.SOUTH_INDEX, null), new VertexInformation(Constants.EAST_INDEX, Constants.UP_INDEX, Constants.SOUTH_INDEX, null), new VertexInformation(Constants.EAST_INDEX, Constants.UP_INDEX, Constants.NORTH_INDEX, null) });
    
    public static EnumFaceDirection getFacing(final EnumFacing llllllllllllIllllIllIIIlIIllllII) {
        return EnumFaceDirection.FACINGS[llllllllllllIllllIllIIIlIIllllII.getIndex()];
    }
    
    private EnumFaceDirection(final String llllllllllllIllllIllIIIlIIllIIll, final int llllllllllllIllllIllIIIlIIllIIlI, final VertexInformation[] llllllllllllIllllIllIIIlIIllIIIl) {
        this.vertexInfos = llllllllllllIllllIllIIIlIIllIIIl;
    }
    
    public VertexInformation getVertexInformation(final int llllllllllllIllllIllIIIlIIlIllIl) {
        return this.vertexInfos[llllllllllllIllllIllIIIlIIlIllIl];
    }
    
    static {
        (FACINGS = new EnumFaceDirection[6])[Constants.DOWN_INDEX] = EnumFaceDirection.DOWN;
        EnumFaceDirection.FACINGS[Constants.UP_INDEX] = EnumFaceDirection.UP;
        EnumFaceDirection.FACINGS[Constants.NORTH_INDEX] = EnumFaceDirection.NORTH;
        EnumFaceDirection.FACINGS[Constants.SOUTH_INDEX] = EnumFaceDirection.SOUTH;
        EnumFaceDirection.FACINGS[Constants.WEST_INDEX] = EnumFaceDirection.WEST;
        EnumFaceDirection.FACINGS[Constants.EAST_INDEX] = EnumFaceDirection.EAST;
    }
    
    public static final class Constants
    {
        public static final /* synthetic */ int NORTH_INDEX;
        public static final /* synthetic */ int DOWN_INDEX;
        public static final /* synthetic */ int WEST_INDEX;
        public static final /* synthetic */ int UP_INDEX;
        public static final /* synthetic */ int EAST_INDEX;
        public static final /* synthetic */ int SOUTH_INDEX;
        
        static {
            SOUTH_INDEX = EnumFacing.SOUTH.getIndex();
            UP_INDEX = EnumFacing.UP.getIndex();
            EAST_INDEX = EnumFacing.EAST.getIndex();
            NORTH_INDEX = EnumFacing.NORTH.getIndex();
            DOWN_INDEX = EnumFacing.DOWN.getIndex();
            WEST_INDEX = EnumFacing.WEST.getIndex();
        }
    }
    
    public static class VertexInformation
    {
        public final /* synthetic */ int zIndex;
        public final /* synthetic */ int xIndex;
        public final /* synthetic */ int yIndex;
        
        private VertexInformation(final int lllllllllllllIIllIlIlIllIlIIIIII, final int lllllllllllllIIllIlIlIllIlIIIIll, final int lllllllllllllIIllIlIlIllIIlllllI) {
            this.xIndex = lllllllllllllIIllIlIlIllIlIIIIII;
            this.yIndex = lllllllllllllIIllIlIlIllIlIIIIll;
            this.zIndex = lllllllllllllIIllIlIlIllIIlllllI;
        }
    }
}
