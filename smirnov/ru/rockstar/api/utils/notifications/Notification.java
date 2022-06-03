// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.utils.notifications;

import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.Minecraft;
import ru.rockstar.api.utils.render.Shifting;
import ru.rockstar.api.utils.font.CFont;
import ru.rockstar.api.utils.render.StopWatch;

public final class Notification
{
    private final /* synthetic */ StopWatch timer;
    private final /* synthetic */ int time;
    private final /* synthetic */ String title;
    private final /* synthetic */ String content;
    private final /* synthetic */ NotificationType type;
    private final /* synthetic */ CFont fontRenderer;
    private final /* synthetic */ Shifting translate;
    
    public final String getTitle() {
        return this.title;
    }
    
    public final int getWidth() {
        return Math.max(100, Math.max(this.fontRenderer.getStringWidth(this.title), this.fontRenderer.getStringWidth(this.content)) + 10);
    }
    
    public final String getContent() {
        return this.content;
    }
    
    public final NotificationType getType() {
        return this.type;
    }
    
    public Notification(final String lllllllllllIllIllllIlIIlIIllIIll, final String lllllllllllIllIllllIlIIlIIlIllII, final NotificationType lllllllllllIllIllllIlIIlIIlIlIll, final CFont lllllllllllIllIllllIlIIlIIlIlIlI) {
        this.title = lllllllllllIllIllllIlIIlIIllIIll;
        this.content = lllllllllllIllIllllIlIIlIIlIllII;
        this.time = 1900;
        this.type = lllllllllllIllIllllIlIIlIIlIlIll;
        this.timer = new StopWatch();
        this.fontRenderer = lllllllllllIllIllllIlIIlIIlIlIlI;
        final ScaledResolution lllllllllllIllIllllIlIIlIIlIllll = new ScaledResolution(Minecraft.getMinecraft());
        this.translate = new Shifting((float)(lllllllllllIllIllllIlIIlIIlIllll.getScaledWidth() - this.getWidth()), (float)(lllllllllllIllIllllIlIIlIIlIllll.getScaledHeight() - 30));
    }
    
    public final Shifting getTranslate() {
        return this.translate;
    }
    
    static {
        HEIGHT = 30;
    }
    
    public final StopWatch getTimer() {
        return this.timer;
    }
    
    public final int getTime() {
        return this.time;
    }
}
