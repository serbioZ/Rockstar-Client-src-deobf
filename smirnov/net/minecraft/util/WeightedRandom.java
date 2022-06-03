// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.util;

import java.util.Random;
import java.util.List;

public class WeightedRandom
{
    public static <T extends Item> T getRandomItem(final List<T> lllllllllllIlIIIlIlIIIlIllllIlll, int lllllllllllIlIIIlIlIIIlIllllIllI) {
        for (int lllllllllllIlIIIlIlIIIlIlllllIlI = 0, lllllllllllIlIIIlIlIIIlIlllllIIl = lllllllllllIlIIIlIlIIIlIllllIlll.size(); lllllllllllIlIIIlIlIIIlIlllllIlI < lllllllllllIlIIIlIlIIIlIlllllIIl; ++lllllllllllIlIIIlIlIIIlIlllllIlI) {
            final T lllllllllllIlIIIlIlIIIlIlllllIII = lllllllllllIlIIIlIlIIIlIllllIlll.get(lllllllllllIlIIIlIlIIIlIlllllIlI);
            lllllllllllIlIIIlIlIIIlIllllIllI -= lllllllllllIlIIIlIlIIIlIlllllIII.itemWeight;
            if (lllllllllllIlIIIlIlIIIlIllllIllI < 0) {
                return lllllllllllIlIIIlIlIIIlIlllllIII;
            }
        }
        return null;
    }
    
    public static <T extends Item> T getRandomItem(final Random lllllllllllIlIIIlIlIIIllIIIIlIIl, final List<T> lllllllllllIlIIIlIlIIIllIIIIIlII, final int lllllllllllIlIIIlIlIIIllIIIIIlll) {
        if (lllllllllllIlIIIlIlIIIllIIIIIlll <= 0) {
            throw new IllegalArgumentException();
        }
        final int lllllllllllIlIIIlIlIIIllIIIIIllI = lllllllllllIlIIIlIlIIIllIIIIlIIl.nextInt(lllllllllllIlIIIlIlIIIllIIIIIlll);
        return getRandomItem(lllllllllllIlIIIlIlIIIllIIIIIlII, lllllllllllIlIIIlIlIIIllIIIIIllI);
    }
    
    public static <T extends Item> T getRandomItem(final Random lllllllllllIlIIIlIlIIIlIlllIlllI, final List<T> lllllllllllIlIIIlIlIIIlIlllIllIl) {
        return getRandomItem(lllllllllllIlIIIlIlIIIlIlllIlllI, lllllllllllIlIIIlIlIIIlIlllIllIl, getTotalWeight(lllllllllllIlIIIlIlIIIlIlllIllIl));
    }
    
    public static int getTotalWeight(final List<? extends Item> lllllllllllIlIIIlIlIIIllIIIlIIlI) {
        int lllllllllllIlIIIlIlIIIllIIIlIllI = 0;
        for (int lllllllllllIlIIIlIlIIIllIIIlIlIl = 0, lllllllllllIlIIIlIlIIIllIIIlIlII = lllllllllllIlIIIlIlIIIllIIIlIIlI.size(); lllllllllllIlIIIlIlIIIllIIIlIlIl < lllllllllllIlIIIlIlIIIllIIIlIlII; ++lllllllllllIlIIIlIlIIIllIIIlIlIl) {
            final Item lllllllllllIlIIIlIlIIIllIIIlIIll = (Item)lllllllllllIlIIIlIlIIIllIIIlIIlI.get(lllllllllllIlIIIlIlIIIllIIIlIlIl);
            lllllllllllIlIIIlIlIIIllIIIlIllI += lllllllllllIlIIIlIlIIIllIIIlIIll.itemWeight;
        }
        return lllllllllllIlIIIlIlIIIllIIIlIllI;
    }
    
    public static class Item
    {
        protected /* synthetic */ int itemWeight;
        
        public Item(final int lllllllllllIlIIIlIIIIlIIlIlIIIll) {
            this.itemWeight = lllllllllllIlIIIlIIIIlIIlIlIIIll;
        }
    }
}
