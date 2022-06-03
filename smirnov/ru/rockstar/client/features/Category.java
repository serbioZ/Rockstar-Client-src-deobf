// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.client.features;

import java.awt.Color;

public enum Category
{
    private final /* synthetic */ int color2;
    public /* synthetic */ String name;
    
    DISPLAY("DISPLAY", 5, new Color(186, 85, 211).getRGB(), new Color(91, 41, 102).getRGB(), "Display"), 
    VISUALS("VISUALS", 2, new Color(0, 206, 209).getRGB(), new Color(2, 121, 123).getRGB(), "Visuals");
    
    private final /* synthetic */ int color;
    
    PLAYER("PLAYER", 3, new Color(244, 164, 96).getRGB(), new Color(132, 68, 9).getRGB(), "Player"), 
    MOVEMENT("MOVEMENT", 1, new Color(123, 104, 238).getRGB(), new Color(73, 63, 151).getRGB(), "Movement"), 
    MISC("MISC", 4, new Color(90, 10, 190).getRGB(), new Color(90, 10, 120).getRGB(), "Misc"), 
    COMBAT("COMBAT", 0, new Color(220, 20, 60).getRGB(), new Color(137, 3, 42).getRGB(), "Combat");
    
    private Category(final String lllllllllllIlllIIlIIIIIlIIIllIIl, final int lllllllllllIlllIIlIIIIIlIIIllIII, final int lllllllllllIlllIIlIIIIIlIIIlllIl, final int lllllllllllIlllIIlIIIIIlIIIlIllI, final String lllllllllllIlllIIlIIIIIlIIIllIll) {
        this.color = lllllllllllIlllIIlIIIIIlIIIlllIl;
        this.color2 = lllllllllllIlllIIlIIIIIlIIIlIllI;
        this.name = lllllllllllIlllIIlIIIIIlIIIllIll;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getColor2() {
        return this.color2;
    }
    
    public int getColor() {
        return this.color;
    }
}
