// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.command.macro;

import java.util.ArrayList;
import java.util.List;

public class MacroManager
{
    public /* synthetic */ List<Macro> macros;
    
    public MacroManager() {
        this.macros = new ArrayList<Macro>();
    }
    
    public void addMacro(final Macro lllllllllllllIIIlllllIlIlIlIIIll) {
        this.macros.add(lllllllllllllIIIlllllIlIlIlIIIll);
    }
    
    public void deleteMacroByKey(final int lllllllllllllIIIlllllIlIlIIlllll) {
        this.macros.removeIf(lllllllllllllIIIlllllIlIlIIllIII -> lllllllllllllIIIlllllIlIlIIllIII.getKey() == lllllllllllllIIIlllllIlIlIIlllll);
    }
    
    public List<Macro> getMacros() {
        return this.macros;
    }
}
