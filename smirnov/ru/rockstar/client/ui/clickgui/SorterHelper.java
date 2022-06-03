// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.clickgui;

import ru.rockstar.client.ui.clickgui.component.impl.ModuleComponent;
import ru.rockstar.client.ui.clickgui.component.Component;
import java.util.Comparator;

public class SorterHelper implements Comparator<Component>
{
    @Override
    public int compare(final Component lllllllllllIlIlIllllIIllIIIIlllI, final Component lllllllllllIlIlIllllIIllIIIIlIll) {
        if (lllllllllllIlIlIllllIIllIIIIlllI instanceof ModuleComponent && lllllllllllIlIlIllllIIllIIIIlIll instanceof ModuleComponent) {
            return lllllllllllIlIlIllllIIllIIIIlllI.getName().compareTo(lllllllllllIlIlIllllIIllIIIIlIll.getName());
        }
        return 0;
    }
}
