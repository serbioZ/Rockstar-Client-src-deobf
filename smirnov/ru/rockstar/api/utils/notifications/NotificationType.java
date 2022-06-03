// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.utils.notifications;

import java.awt.Color;

public enum NotificationType
{
    ERROR("ERROR", 2, new Color(255, 79, 79), "Q");
    
    private final /* synthetic */ Color color;
    
    WARNING("WARNING", 3, new Color(255, 211, 53), "r"), 
    SUCCESS("SUCCESS", 0, new Color(79, 117, 72), "R");
    
    private final /* synthetic */ String colorstr;
    
    INFO("INFO", 1, new Color(100, 100, 255), "p");
    
    private NotificationType(final String lllllllllllllIlIlIlIlllllIIlIlIl, final int lllllllllllllIlIlIlIlllllIIlIlII, final Color lllllllllllllIlIlIlIlllllIIllIII, final String lllllllllllllIlIlIlIlllllIIlIlll) {
        this.color = lllllllllllllIlIlIlIlllllIIllIII;
        this.colorstr = lllllllllllllIlIlIlIlllllIIlIlll;
    }
    
    public final String getColorstr() {
        return this.colorstr;
    }
    
    public final Color getColor() {
        return this.color;
    }
}
