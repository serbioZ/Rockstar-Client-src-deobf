// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.command.impl;

import java.util.Iterator;
import ru.rockstar.client.features.Feature;
import ru.rockstar.Main;
import ru.rockstar.api.command.CommandAbstract;

public class PanicCommand extends CommandAbstract
{
    public PanicCommand() {
        super("panic", "Disabled all modules", ".panic", new String[] { "panic" });
    }
    
    @Override
    public void execute(final String... llIIlIIIllIllI) {
        if (llIIlIIIllIllI[0].equalsIgnoreCase("panic")) {
            for (final Feature llIIlIIIllIlll : Main.featureDirector.getFeatureList()) {
                if (llIIlIIIllIlll.isToggled()) {
                    llIIlIIIllIlll.toggle();
                }
            }
        }
    }
}
