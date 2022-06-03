// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world;

import java.util.UUID;
import net.minecraft.util.text.ITextComponent;

public abstract class BossInfo
{
    protected /* synthetic */ boolean playEndBossMusic;
    protected /* synthetic */ Overlay overlay;
    protected /* synthetic */ Color color;
    protected /* synthetic */ ITextComponent name;
    private final /* synthetic */ UUID uniqueId;
    protected /* synthetic */ float percent;
    protected /* synthetic */ boolean darkenSky;
    protected /* synthetic */ boolean createFog;
    
    public Color getColor() {
        return this.color;
    }
    
    public BossInfo(final UUID lllllllllllIIlIllllllIIIllIlIIII, final ITextComponent lllllllllllIIlIllllllIIIllIIllll, final Color lllllllllllIIlIllllllIIIllIIlIIl, final Overlay lllllllllllIIlIllllllIIIllIIllIl) {
        this.uniqueId = lllllllllllIIlIllllllIIIllIlIIII;
        this.name = lllllllllllIIlIllllllIIIllIIllll;
        this.color = lllllllllllIIlIllllllIIIllIIlIIl;
        this.overlay = lllllllllllIIlIllllllIIIllIIllIl;
        this.percent = 1.0f;
    }
    
    public void setColor(final Color lllllllllllIIlIllllllIIIlIlIlIlI) {
        this.color = lllllllllllIIlIllllllIIIlIlIlIlI;
    }
    
    public void setPercent(final float lllllllllllIIlIllllllIIIlIllIIll) {
        this.percent = lllllllllllIIlIllllllIIIlIllIIll;
    }
    
    public ITextComponent getName() {
        return this.name;
    }
    
    public BossInfo setPlayEndBossMusic(final boolean lllllllllllIIlIllllllIIIlIIIllll) {
        this.playEndBossMusic = lllllllllllIIlIllllllIIIlIIIllll;
        return this;
    }
    
    public float getPercent() {
        return this.percent;
    }
    
    public void setOverlay(final Overlay lllllllllllIIlIllllllIIIlIlIIIIl) {
        this.overlay = lllllllllllIIlIllllllIIIlIlIIIIl;
    }
    
    public BossInfo setDarkenSky(final boolean lllllllllllIIlIllllllIIIlIIllIlI) {
        this.darkenSky = lllllllllllIIlIllllllIIIlIIllIlI;
        return this;
    }
    
    public boolean shouldPlayEndBossMusic() {
        return this.playEndBossMusic;
    }
    
    public boolean shouldCreateFog() {
        return this.createFog;
    }
    
    public boolean shouldDarkenSky() {
        return this.darkenSky;
    }
    
    public BossInfo setCreateFog(final boolean lllllllllllIIlIllllllIIIlIIIlIIl) {
        this.createFog = lllllllllllIIlIllllllIIIlIIIlIIl;
        return this;
    }
    
    public UUID getUniqueId() {
        return this.uniqueId;
    }
    
    public void setName(final ITextComponent lllllllllllIIlIllllllIIIlIlllllI) {
        this.name = lllllllllllIIlIllllllIIIlIlllllI;
    }
    
    public Overlay getOverlay() {
        return this.overlay;
    }
    
    public enum Overlay
    {
        NOTCHED_20("NOTCHED_20", 4), 
        PROGRESS("PROGRESS", 0), 
        NOTCHED_6("NOTCHED_6", 1), 
        NOTCHED_10("NOTCHED_10", 2), 
        NOTCHED_12("NOTCHED_12", 3);
        
        private Overlay(final String lllllllllllIIlIlIIlIlIlIIIIlIIlI, final int lllllllllllIIlIlIIlIlIlIIIIlIIIl) {
        }
    }
    
    public enum Color
    {
        WHITE("WHITE", 6), 
        YELLOW("YELLOW", 4), 
        RED("RED", 2), 
        BLUE("BLUE", 1), 
        GREEN("GREEN", 3), 
        PINK("PINK", 0), 
        PURPLE("PURPLE", 5);
        
        private Color(final String lllllllllllIIIlIIlllIIlIIIlIIIIl, final int lllllllllllIIIlIIlllIIlIIIlIIIII) {
        }
    }
}
