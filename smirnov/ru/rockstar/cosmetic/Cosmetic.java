// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.cosmetic;

import ru.rockstar.cosmetic.impl.DragonWing;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class Cosmetic
{
    public static ResourceLocation getWing(final String lllllllllllllIlIIlIIIllIlllllIII) {
        return new ResourceLocation("richclient/" + lllllllllllllIlIIlIIIllIlllllIII.toLowerCase() + ".png");
    }
    
    public static void renderAccessory(final String[] lllllllllllllIlIIlIIIlllIIIIIlIl, final EntityPlayer lllllllllllllIlIIlIIIlllIIIIlIII, final float lllllllllllllIlIIlIIIlllIIIIIlll) {
        final short lllllllllllllIlIIlIIIllIllllllll = (Object)lllllllllllllIlIIlIIIlllIIIIIlIl;
        final long lllllllllllllIlIIlIIIlllIIIIIIII = lllllllllllllIlIIlIIIlllIIIIIlIl.length;
        for (float lllllllllllllIlIIlIIIlllIIIIIIIl = 0; lllllllllllllIlIIlIIIlllIIIIIIIl < lllllllllllllIlIIlIIIlllIIIIIIII; ++lllllllllllllIlIIlIIIlllIIIIIIIl) {
            final String lllllllllllllIlIIlIIIlllIIIIIllI = lllllllllllllIlIIlIIIllIllllllll[lllllllllllllIlIIlIIIlllIIIIIIIl];
            final Exception lllllllllllllIlIIlIIIllIlllllllI;
            switch (lllllllllllllIlIIlIIIllIlllllllI = (Exception)lllllllllllllIlIIlIIIlllIIIIIllI) {
                case "Dragon_wing": {
                    DragonWing.render(lllllllllllllIlIIlIIIlllIIIIlIII, lllllllllllllIlIIlIIIlllIIIIIlll);
                    break;
                }
                default:
                    break;
            }
        }
    }
    
    public static ResourceLocation getCape(final String lllllllllllllIlIIlIIIllIllllllII) {
        return new ResourceLocation("richclient/" + lllllllllllllIlIIlIIIllIllllllII.toLowerCase() + ".png");
    }
}
