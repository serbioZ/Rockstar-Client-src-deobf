// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import net.minecraft.client.settings.GameSettings;

public class GuiOptionButton extends GuiButton
{
    private final /* synthetic */ GameSettings.Options enumOptions;
    
    public GuiOptionButton(final int lllllllllllIIllllIlIIIlIllIIIlIl, final int lllllllllllIIllllIlIIIlIlIlllllI, final int lllllllllllIIllllIlIIIlIllIIIIll, final GameSettings.Options lllllllllllIIllllIlIIIlIlIllllII, final String lllllllllllIIllllIlIIIlIlIlllIll) {
        super(lllllllllllIIllllIlIIIlIllIIIlIl, lllllllllllIIllllIlIIIlIlIlllllI, lllllllllllIIllllIlIIIlIllIIIIll, 150, 20, lllllllllllIIllllIlIIIlIlIlllIll);
        this.enumOptions = lllllllllllIIllllIlIIIlIlIllllII;
    }
    
    public GuiOptionButton(final int lllllllllllIIllllIlIIIlIllIlIlIl, final int lllllllllllIIllllIlIIIlIllIlIlII, final int lllllllllllIIllllIlIIIlIllIlIIll, final String lllllllllllIIllllIlIIIlIllIIllIl) {
        this(lllllllllllIIllllIlIIIlIllIlIlIl, lllllllllllIIllllIlIIIlIllIlIlII, lllllllllllIIllllIlIIIlIllIlIIll, null, lllllllllllIIllllIlIIIlIllIIllIl);
    }
    
    public GameSettings.Options returnEnumOptions() {
        return this.enumOptions;
    }
}
