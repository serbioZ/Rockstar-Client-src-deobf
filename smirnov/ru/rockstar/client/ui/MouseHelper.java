// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui;

import ru.rockstar.api.utils.Helper;

public class MouseHelper implements Helper
{
    public static boolean isHovered(final double lllllllllllIIIIlIlIIllIIIIllIllI, final double lllllllllllIIIIlIlIIllIIIIlIllll, final double lllllllllllIIIIlIlIIllIIIIlIlllI, final double lllllllllllIIIIlIlIIllIIIIlIllIl, final int lllllllllllIIIIlIlIIllIIIIlIllII, final int lllllllllllIIIIlIlIIllIIIIllIIIl) {
        return lllllllllllIIIIlIlIIllIIIIlIllII > lllllllllllIIIIlIlIIllIIIIllIllI && lllllllllllIIIIlIlIIllIIIIllIIIl > lllllllllllIIIIlIlIIllIIIIlIllll && lllllllllllIIIIlIlIIllIIIIlIllII < lllllllllllIIIIlIlIIllIIIIlIlllI && lllllllllllIIIIlIlIIllIIIIllIIIl < lllllllllllIIIIlIlIIllIIIIlIllIl;
    }
}
