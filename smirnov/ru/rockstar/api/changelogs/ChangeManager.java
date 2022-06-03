// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.changelogs;

import ru.rockstar.Main;
import java.util.ArrayList;

public class ChangeManager
{
    public static /* synthetic */ ArrayList<ChangeLog> changeLogs;
    
    public ArrayList<ChangeLog> getChangeLogs() {
        return ChangeManager.changeLogs;
    }
    
    static {
        ChangeManager.changeLogs = new ArrayList<ChangeLog>();
    }
    
    public ChangeManager() {
        ChangeManager.changeLogs.add(new ChangeLog("Version " + Main.instance.version, ChangeType.NONE));
        ChangeManager.changeLogs.add(new ChangeLog("Release RECODE!", ChangeType.NONE));
    }
}
