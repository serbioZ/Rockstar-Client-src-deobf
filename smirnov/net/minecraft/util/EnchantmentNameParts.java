// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.util;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import net.minecraft.client.gui.FontRenderer;
import java.util.Random;

public class EnchantmentNameParts
{
    private final /* synthetic */ Random rand;
    private static final /* synthetic */ EnchantmentNameParts INSTANCE;
    private final /* synthetic */ String[] namePartsArray;
    
    public String generateNewRandomName(final FontRenderer lllllllllllllIIlIIlIllllIIlIlIII, final int lllllllllllllIIlIIlIllllIIlIIlll) {
        final int lllllllllllllIIlIIlIllllIIlIIllI = this.rand.nextInt(2) + 3;
        String lllllllllllllIIlIIlIllllIIlIIlIl = "";
        for (int lllllllllllllIIlIIlIllllIIlIIlII = 0; lllllllllllllIIlIIlIllllIIlIIlII < lllllllllllllIIlIIlIllllIIlIIllI; ++lllllllllllllIIlIIlIllllIIlIIlII) {
            if (lllllllllllllIIlIIlIllllIIlIIlII > 0) {
                lllllllllllllIIlIIlIllllIIlIIlIl = String.valueOf(lllllllllllllIIlIIlIllllIIlIIlIl) + " ";
            }
            lllllllllllllIIlIIlIllllIIlIIlIl = String.valueOf(lllllllllllllIIlIIlIllllIIlIIlIl) + this.namePartsArray[this.rand.nextInt(this.namePartsArray.length)];
        }
        final List<String> lllllllllllllIIlIIlIllllIIlIIIll = lllllllllllllIIlIIlIllllIIlIlIII.listFormattedStringToWidth(lllllllllllllIIlIIlIllllIIlIIlIl, lllllllllllllIIlIIlIllllIIlIIlll);
        return StringUtils.join((Iterable)((lllllllllllllIIlIIlIllllIIlIIIll.size() >= 2) ? lllllllllllllIIlIIlIllllIIlIIIll.subList(0, 2) : lllllllllllllIIlIIlIllllIIlIIIll), " ");
    }
    
    static {
        INSTANCE = new EnchantmentNameParts();
    }
    
    public static EnchantmentNameParts getInstance() {
        return EnchantmentNameParts.INSTANCE;
    }
    
    public void reseedRandomGenerator(final long lllllllllllllIIlIIlIllllIIIlIlll) {
        this.rand.setSeed(lllllllllllllIIlIIlIllllIIIlIlll);
    }
    
    public EnchantmentNameParts() {
        this.rand = new Random();
        this.namePartsArray = "the elder scrolls klaatu berata niktu xyzzy bless curse light darkness fire air earth water hot dry cold wet ignite snuff embiggen twist shorten stretch fiddle destroy imbue galvanize enchant free limited range of towards inside sphere cube self other ball mental physical grow shrink demon elemental spirit animal creature beast humanoid undead fresh stale phnglui mglwnafh cthulhu rlyeh wgahnagl fhtagnbaguette".split(" ");
    }
}
