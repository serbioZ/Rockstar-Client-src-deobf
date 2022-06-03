// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features.impl.misc;

import ru.rockstar.api.event.EventTarget;
import ru.rockstar.Main;
import ru.rockstar.api.event.event.EventUpdate;
import ru.rockstar.client.features.Category;
import ru.rockstar.client.features.Feature;

public class Panic extends Feature
{
    public Panic() {
        super("Panic", "\u0412\u044b\u043a\u043b\u044e\u0447\u0430\u0435\u0442 \u0432\u0441\u0435 \u043c\u043e\u0434\u0443\u043b\u0438 \u0447\u0438\u0442\u0430", 0, Category.MISC);
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate lllllllllllIIlIllIIlIlIIllllIllI) {
        for (final Feature lllllllllllIIlIllIIlIlIIllllIlIl : Main.featureDirector.getFeatureList()) {
            if (lllllllllllIIlIllIIlIlIIllllIlIl.isToggled()) {
                lllllllllllIIlIllIIlIlIIllllIlIl.toggle();
            }
        }
    }
}
