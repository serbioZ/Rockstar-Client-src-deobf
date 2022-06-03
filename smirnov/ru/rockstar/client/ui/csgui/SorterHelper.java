// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.ui.csgui;

import ru.rockstar.client.ui.csgui.component.impl.ModuleComponent;
import ru.rockstar.client.ui.csgui.component.Component;
import java.util.Comparator;

public class SorterHelper implements Comparator<Component>
{
    @Override
    public int compare(final Component lllllllllllIIllIlllIIIlIIlIIlIlI, final Component lllllllllllIIllIlllIIIlIIlIIlIll) {
        if (lllllllllllIIllIlllIIIlIIlIIlIlI instanceof ModuleComponent && lllllllllllIIllIlllIIIlIIlIIlIll instanceof ModuleComponent) {
            return lllllllllllIIllIlllIIIlIIlIIlIlI.getName().compareTo(lllllllllllIIllIlllIIIlIIlIIlIll.getName());
        }
        return 0;
    }
}
