// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.altmanager.althening.api;

import java.lang.reflect.Field;

public class AltHelper
{
    private /* synthetic */ Class<?> clazz;
    
    public AltHelper(final String lllllllllllllIIIIIIlIlllIlIIlIIl) {
        try {
            this.clazz = Class.forName(lllllllllllllIIIIIIlIlllIlIIlIIl);
        }
        catch (ClassNotFoundException lllllllllllllIIIIIIlIlllIlIIlIII) {
            lllllllllllllIIIIIIlIlllIlIIlIII.printStackTrace();
        }
    }
    
    public void setStaticField(final String lllllllllllllIIIIIIlIlllIIlllllI, final Object lllllllllllllIIIIIIlIlllIIllllIl) throws IllegalAccessException, NoSuchFieldException {
        final Field lllllllllllllIIIIIIlIlllIIllllII = this.clazz.getDeclaredField(lllllllllllllIIIIIIlIlllIIlllllI);
        lllllllllllllIIIIIIlIlllIIllllII.setAccessible(true);
        final Field lllllllllllllIIIIIIlIlllIIlllIll = Field.class.getDeclaredField("modifiers");
        lllllllllllllIIIIIIlIlllIIlllIll.setAccessible(true);
        lllllllllllllIIIIIIlIlllIIlllIll.setInt(lllllllllllllIIIIIIlIlllIIllllII, lllllllllllllIIIIIIlIlllIIllllII.getModifiers() & 0xFFFFFFEF);
        lllllllllllllIIIIIIlIlllIIllllII.set(null, lllllllllllllIIIIIIlIlllIIllllIl);
    }
}
