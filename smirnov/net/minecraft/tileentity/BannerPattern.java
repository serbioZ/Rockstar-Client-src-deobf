// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.tileentity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.init.Items;
import net.minecraft.init.Blocks;
import javax.annotation.Nullable;
import net.minecraft.item.ItemStack;

public enum BannerPattern
{
    STRIPE_DOWNRIGHT("STRIPE_DOWNRIGHT", 11, "stripe_downright", "drs", "#  ", " # ", "  #"), 
    SQUARE_BOTTOM_RIGHT("SQUARE_BOTTOM_RIGHT", 2, "square_bottom_right", "br", "   ", "   ", "  #"), 
    CURLY_BORDER("CURLY_BORDER", 31, "curly_border", "cbo", new ItemStack(Blocks.VINE)), 
    BORDER("BORDER", 30, "border", "bo", "###", "# #", "###"), 
    CIRCLE_MIDDLE("CIRCLE_MIDDLE", 24, "circle", "mc", "   ", " # ", "   "), 
    HALF_VERTICAL_MIRROR("HALF_VERTICAL_MIRROR", 28, "half_vertical_right", "vhr", " ##", " ##", " ##"), 
    STRIPE_DOWNLEFT("STRIPE_DOWNLEFT", 12, "stripe_downleft", "dls", "  #", " # ", "#  "), 
    MOJANG("MOJANG", 38, "mojang", "moj", new ItemStack(Items.GOLDEN_APPLE, 1, 1)), 
    STRIPE_RIGHT("STRIPE_RIGHT", 8, "stripe_right", "rs", "  #", "  #", "  #"), 
    RHOMBUS_MIDDLE("RHOMBUS_MIDDLE", 25, "rhombus", "mr", " # ", "# #", " # "), 
    CROSS("CROSS", 14, "cross", "cr", "# #", " # ", "# #"), 
    DIAGONAL_LEFT_MIRROR("DIAGONAL_LEFT_MIRROR", 22, "diagonal_up_left", "lud", "   ", "#  ", "## "), 
    FLOWER("FLOWER", 37, "flower", "flo", new ItemStack(Blocks.RED_FLOWER, 1, BlockFlower.EnumFlowerType.OXEYE_DAISY.getMeta())), 
    GRADIENT("GRADIENT", 33, "gradient", "gra", "# #", " # ", " # "), 
    DIAGONAL_RIGHT_MIRROR("DIAGONAL_RIGHT_MIRROR", 23, "diagonal_right", "rud", " ##", "  #", "   "), 
    BRICKS("BRICKS", 35, "bricks", "bri", new ItemStack(Blocks.BRICK_BLOCK)), 
    SKULL("SKULL", 36, "skull", "sku", new ItemStack(Items.SKULL, 1, 1)), 
    HALF_VERTICAL("HALF_VERTICAL", 26, "half_vertical", "vh", "## ", "## ", "## "), 
    STRIPE_SMALL("STRIPE_SMALL", 13, "small_stripes", "ss", "# #", "# #", "   "), 
    GRADIENT_UP("GRADIENT_UP", 34, "gradient_up", "gru", " # ", " # ", "# #"), 
    DIAGONAL_LEFT("DIAGONAL_LEFT", 20, "diagonal_left", "ld", "## ", "#  ", "   "), 
    TRIANGLES_TOP("TRIANGLES_TOP", 19, "triangles_top", "tts", " # ", "# #", "   "), 
    TRIANGLES_BOTTOM("TRIANGLES_BOTTOM", 18, "triangles_bottom", "bts", "   ", "# #", " # "), 
    HALF_HORIZONTAL("HALF_HORIZONTAL", 27, "half_horizontal", "hh", "###", "###", "   "), 
    SQUARE_TOP_LEFT("SQUARE_TOP_LEFT", 3, "square_top_left", "tl", "#  ", "   ", "   "), 
    SQUARE_BOTTOM_LEFT("SQUARE_BOTTOM_LEFT", 1, "square_bottom_left", "bl", "   ", "   ", "#  "), 
    DIAGONAL_RIGHT("DIAGONAL_RIGHT", 21, "diagonal_up_right", "rd", "   ", "  #", " ##"), 
    STRIPE_CENTER("STRIPE_CENTER", 9, "stripe_center", "cs", " # ", " # ", " # ");
    
    private final /* synthetic */ String field_191015_O;
    
    TRIANGLE_TOP("TRIANGLE_TOP", 17, "triangle_top", "tt", "# #", " # ", "   "), 
    STRIPE_LEFT("STRIPE_LEFT", 7, "stripe_left", "ls", "#  ", "#  ", "#  "), 
    STRAIGHT_CROSS("STRAIGHT_CROSS", 15, "straight_cross", "sc", " # ", "###", " # "), 
    STRIPE_MIDDLE("STRIPE_MIDDLE", 10, "stripe_middle", "ms", "   ", "###", "   "), 
    HALF_HORIZONTAL_MIRROR("HALF_HORIZONTAL_MIRROR", 29, "half_horizontal_bottom", "hhb", "   ", "###", "###"), 
    TRIANGLE_BOTTOM("TRIANGLE_BOTTOM", 16, "triangle_bottom", "bt", "   ", " # ", "# #");
    
    private final /* synthetic */ String field_191014_N;
    private final /* synthetic */ String[] field_191016_P;
    private /* synthetic */ ItemStack field_191017_Q;
    
    SQUARE_TOP_RIGHT("SQUARE_TOP_RIGHT", 4, "square_top_right", "tr", "  #", "   ", "   "), 
    BASE("BASE", 0, "base", "b"), 
    STRIPE_BOTTOM("STRIPE_BOTTOM", 5, "stripe_bottom", "bs", "   ", "   ", "###"), 
    CREEPER("CREEPER", 32, "creeper", "cre", new ItemStack(Items.SKULL, 1, 4)), 
    STRIPE_TOP("STRIPE_TOP", 6, "stripe_top", "ts", "###", "   ", "   ");
    
    private BannerPattern(final String lllllllllllIIIlIIlIIIllIlIllIIll, final int lllllllllllIIIlIIlIIIllIlIllIIlI, final String lllllllllllIIIlIIlIIIllIlIllIIIl, final String lllllllllllIIIlIIlIIIllIlIllIIII, final ItemStack lllllllllllIIIlIIlIIIllIlIlIllll) {
        this(lllllllllllIIIlIIlIIIllIlIllIIll, lllllllllllIIIlIIlIIIllIlIllIIlI, lllllllllllIIIlIIlIIIllIlIllIIIl, lllllllllllIIIlIIlIIIllIlIllIIII);
        this.field_191017_Q = lllllllllllIIIlIIlIIIllIlIlIllll;
    }
    
    public String[] func_190996_c() {
        return this.field_191016_P;
    }
    
    @Nullable
    public static BannerPattern func_190994_a(final String lllllllllllIIIlIIlIIIllIIlllllll) {
        final double lllllllllllIIIlIIlIIIllIIllllIll;
        final float lllllllllllIIIlIIlIIIllIIlllllII = ((BannerPattern[])(Object)(lllllllllllIIIlIIlIIIllIIllllIll = (double)(Object)values())).length;
        for (boolean lllllllllllIIIlIIlIIIllIIlllllIl = false; (lllllllllllIIIlIIlIIIllIIlllllIl ? 1 : 0) < lllllllllllIIIlIIlIIIllIIlllllII; ++lllllllllllIIIlIIlIIIllIIlllllIl) {
            final BannerPattern lllllllllllIIIlIIlIIIllIlIIIIIII = lllllllllllIIIlIIlIIIllIIllllIll[lllllllllllIIIlIIlIIIllIIlllllIl];
            if (lllllllllllIIIlIIlIIIllIlIIIIIII.field_191015_O.equals(lllllllllllIIIlIIlIIIllIIlllllll)) {
                return lllllllllllIIIlIIlIIIllIlIIIIIII;
            }
        }
        return null;
    }
    
    private BannerPattern(final String lllllllllllIIIlIIlIIIllIlIIlllll, final int lllllllllllIIIlIIlIIIllIlIIllllI, final String lllllllllllIIIlIIlIIIllIlIlIIlIl, final String lllllllllllIIIlIIlIIIllIlIIlllII, final String lllllllllllIIIlIIlIIIllIlIIllIll, final String lllllllllllIIIlIIlIIIllIlIlIIIlI, final String lllllllllllIIIlIIlIIIllIlIIllIIl) {
        this(lllllllllllIIIlIIlIIIllIlIIlllll, lllllllllllIIIlIIlIIIllIlIIllllI, lllllllllllIIIlIIlIIIllIlIlIIlIl, lllllllllllIIIlIIlIIIllIlIIlllII);
        this.field_191016_P[0] = lllllllllllIIIlIIlIIIllIlIIllIll;
        this.field_191016_P[1] = lllllllllllIIIlIIlIIIllIlIlIIIlI;
        this.field_191016_P[2] = lllllllllllIIIlIIlIIIllIlIIllIIl;
    }
    
    public String func_190993_b() {
        return this.field_191015_O;
    }
    
    public ItemStack func_190998_f() {
        return this.field_191017_Q;
    }
    
    public boolean func_191000_d() {
        return !this.field_191017_Q.func_190926_b() || this.field_191016_P[0] != null;
    }
    
    public boolean func_190999_e() {
        return !this.field_191017_Q.func_190926_b();
    }
    
    private BannerPattern(final String lllllllllllIIIlIIlIIIllIllIIIIlI, final int lllllllllllIIIlIIlIIIllIllIIIIIl, final String lllllllllllIIIlIIlIIIllIllIIIlIl, final String lllllllllllIIIlIIlIIIllIlIllllll) {
        this.field_191016_P = new String[3];
        this.field_191017_Q = ItemStack.field_190927_a;
        this.field_191014_N = lllllllllllIIIlIIlIIIllIllIIIlIl;
        this.field_191015_O = lllllllllllIIIlIIlIIIllIlIllllll;
    }
    
    public String func_190997_a() {
        return this.field_191014_N;
    }
}
