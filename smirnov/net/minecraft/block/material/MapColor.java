// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block.material;

import net.minecraft.item.EnumDyeColor;

public class MapColor
{
    public static final /* synthetic */ MapColor BROWN;
    public static final /* synthetic */ MapColor CYAN;
    public static final /* synthetic */ MapColor BLACK;
    public static final /* synthetic */ MapColor PINK;
    public static final /* synthetic */ MapColor ADOBE;
    public /* synthetic */ int colorValue;
    public static final /* synthetic */ MapColor GREEN;
    public static final /* synthetic */ MapColor LIME;
    public static final /* synthetic */ MapColor RED;
    public final /* synthetic */ int colorIndex;
    public static final /* synthetic */ MapColor[] COLORS;
    public static final /* synthetic */ MapColor SILVER;
    public static final /* synthetic */ MapColor LIGHT_BLUE;
    public static final /* synthetic */ MapColor GRAY;
    public static final /* synthetic */ MapColor BLUE;
    public static final /* synthetic */ MapColor PURPLE;
    public static final /* synthetic */ MapColor YELLOW;
    public static final /* synthetic */ MapColor SNOW;
    public static final /* synthetic */ MapColor MAGENTA;
    public static final /* synthetic */ MapColor[] field_193575_b;
    
    public static MapColor func_193558_a(final EnumDyeColor lllllllllllIlIllIlIIIIlIllIllIlI) {
        return MapColor.field_193575_b[lllllllllllIlIllIlIIIIlIllIllIlI.getMetadata()];
    }
    
    private MapColor(final int lllllllllllIlIllIlIIIIlIllllIIll, final int lllllllllllIlIllIlIIIIlIlllIllll) {
        if (lllllllllllIlIllIlIIIIlIllllIIll >= 0 && lllllllllllIlIllIlIIIIlIllllIIll <= 63) {
            this.colorIndex = lllllllllllIlIllIlIIIIlIllllIIll;
            this.colorValue = lllllllllllIlIllIlIIIIlIlllIllll;
            MapColor.COLORS[lllllllllllIlIllIlIIIIlIllllIIll] = this;
            return;
        }
        throw new IndexOutOfBoundsException("Map colour ID must be between 0 and 63 (inclusive)");
    }
    
    static {
        COLORS = new MapColor[64];
        field_193575_b = new MapColor[16];
        AIR = new MapColor(0, 0);
        GRASS = new MapColor(1, 8368696);
        SAND = new MapColor(2, 16247203);
        CLOTH = new MapColor(3, 13092807);
        TNT = new MapColor(4, 16711680);
        ICE = new MapColor(5, 10526975);
        IRON = new MapColor(6, 10987431);
        FOLIAGE = new MapColor(7, 31744);
        SNOW = new MapColor(8, 16777215);
        CLAY = new MapColor(9, 10791096);
        DIRT = new MapColor(10, 9923917);
        STONE = new MapColor(11, 7368816);
        WATER = new MapColor(12, 4210943);
        WOOD = new MapColor(13, 9402184);
        QUARTZ = new MapColor(14, 16776437);
        ADOBE = new MapColor(15, 14188339);
        MAGENTA = new MapColor(16, 11685080);
        LIGHT_BLUE = new MapColor(17, 6724056);
        YELLOW = new MapColor(18, 15066419);
        LIME = new MapColor(19, 8375321);
        PINK = new MapColor(20, 15892389);
        GRAY = new MapColor(21, 5000268);
        SILVER = new MapColor(22, 10066329);
        CYAN = new MapColor(23, 5013401);
        PURPLE = new MapColor(24, 8339378);
        BLUE = new MapColor(25, 3361970);
        BROWN = new MapColor(26, 6704179);
        GREEN = new MapColor(27, 6717235);
        RED = new MapColor(28, 10040115);
        BLACK = new MapColor(29, 1644825);
        GOLD = new MapColor(30, 16445005);
        DIAMOND = new MapColor(31, 6085589);
        LAPIS = new MapColor(32, 4882687);
        EMERALD = new MapColor(33, 55610);
        OBSIDIAN = new MapColor(34, 8476209);
        NETHERRACK = new MapColor(35, 7340544);
        field_193561_M = new MapColor(36, 13742497);
        field_193562_N = new MapColor(37, 10441252);
        field_193563_O = new MapColor(38, 9787244);
        field_193564_P = new MapColor(39, 7367818);
        field_193565_Q = new MapColor(40, 12223780);
        field_193566_R = new MapColor(41, 6780213);
        field_193567_S = new MapColor(42, 10505550);
        field_193568_T = new MapColor(43, 3746083);
        field_193569_U = new MapColor(44, 8874850);
        field_193570_V = new MapColor(45, 5725276);
        field_193571_W = new MapColor(46, 8014168);
        field_193572_X = new MapColor(47, 4996700);
        field_193573_Y = new MapColor(48, 4993571);
        field_193574_Z = new MapColor(49, 5001770);
        field_193559_aa = new MapColor(50, 9321518);
        field_193560_ab = new MapColor(51, 2430480);
        MapColor.field_193575_b[EnumDyeColor.WHITE.getMetadata()] = MapColor.SNOW;
        MapColor.field_193575_b[EnumDyeColor.ORANGE.getMetadata()] = MapColor.ADOBE;
        MapColor.field_193575_b[EnumDyeColor.MAGENTA.getMetadata()] = MapColor.MAGENTA;
        MapColor.field_193575_b[EnumDyeColor.LIGHT_BLUE.getMetadata()] = MapColor.LIGHT_BLUE;
        MapColor.field_193575_b[EnumDyeColor.YELLOW.getMetadata()] = MapColor.YELLOW;
        MapColor.field_193575_b[EnumDyeColor.LIME.getMetadata()] = MapColor.LIME;
        MapColor.field_193575_b[EnumDyeColor.PINK.getMetadata()] = MapColor.PINK;
        MapColor.field_193575_b[EnumDyeColor.GRAY.getMetadata()] = MapColor.GRAY;
        MapColor.field_193575_b[EnumDyeColor.SILVER.getMetadata()] = MapColor.SILVER;
        MapColor.field_193575_b[EnumDyeColor.CYAN.getMetadata()] = MapColor.CYAN;
        MapColor.field_193575_b[EnumDyeColor.PURPLE.getMetadata()] = MapColor.PURPLE;
        MapColor.field_193575_b[EnumDyeColor.BLUE.getMetadata()] = MapColor.BLUE;
        MapColor.field_193575_b[EnumDyeColor.BROWN.getMetadata()] = MapColor.BROWN;
        MapColor.field_193575_b[EnumDyeColor.GREEN.getMetadata()] = MapColor.GREEN;
        MapColor.field_193575_b[EnumDyeColor.RED.getMetadata()] = MapColor.RED;
        MapColor.field_193575_b[EnumDyeColor.BLACK.getMetadata()] = MapColor.BLACK;
    }
    
    public int getMapColor(final int lllllllllllIlIllIlIIIIlIlllIIIIl) {
        int lllllllllllIlIllIlIIIIlIlllIIllI = 220;
        if (lllllllllllIlIllIlIIIIlIlllIIIIl == 3) {
            lllllllllllIlIllIlIIIIlIlllIIllI = 135;
        }
        if (lllllllllllIlIllIlIIIIlIlllIIIIl == 2) {
            lllllllllllIlIllIlIIIIlIlllIIllI = 255;
        }
        if (lllllllllllIlIllIlIIIIlIlllIIIIl == 1) {
            lllllllllllIlIllIlIIIIlIlllIIllI = 220;
        }
        if (lllllllllllIlIllIlIIIIlIlllIIIIl == 0) {
            lllllllllllIlIllIlIIIIlIlllIIllI = 180;
        }
        final int lllllllllllIlIllIlIIIIlIlllIIlIl = (this.colorValue >> 16 & 0xFF) * lllllllllllIlIllIlIIIIlIlllIIllI / 255;
        final int lllllllllllIlIllIlIIIIlIlllIIlII = (this.colorValue >> 8 & 0xFF) * lllllllllllIlIllIlIIIIlIlllIIllI / 255;
        final int lllllllllllIlIllIlIIIIlIlllIIIll = (this.colorValue & 0xFF) * lllllllllllIlIllIlIIIIlIlllIIllI / 255;
        return 0xFF000000 | lllllllllllIlIllIlIIIIlIlllIIlIl << 16 | lllllllllllIlIllIlIIIIlIlllIIlII << 8 | lllllllllllIlIllIlIIIIlIlllIIIll;
    }
}
