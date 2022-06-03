// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.utils.render;

import net.minecraft.client.Minecraft;

public class AnimationHelper
{
    private /* synthetic */ State currentState;
    private /* synthetic */ boolean initialState;
    public static /* synthetic */ float speedTarget;
    private /* synthetic */ long currentStateStart;
    private /* synthetic */ State previousState;
    private /* synthetic */ int time;
    
    static {
        AnimationHelper.speedTarget = 0.125f;
    }
    
    public static double animate(final double llllllllllIlllIIIlIllllllIIllIll, double llllllllllIlllIIIlIllllllIlIIIII, double llllllllllIlllIIIlIllllllIIlllll) {
        final boolean llllllllllIlllIIIlIllllllIIllllI = llllllllllIlllIIIlIllllllIIllIll > llllllllllIlllIIIlIllllllIlIIIII;
        if (llllllllllIlllIIIlIllllllIIlllll < 0.0) {
            llllllllllIlllIIIlIllllllIIlllll = 0.0;
        }
        else if (llllllllllIlllIIIlIllllllIIlllll > 1.0) {
            llllllllllIlllIIIlIllllllIIlllll = 1.0;
        }
        final double llllllllllIlllIIIlIllllllIIlllIl = Math.max(llllllllllIlllIIIlIllllllIIllIll, llllllllllIlllIIIlIllllllIlIIIII) - Math.min(llllllllllIlllIIIlIllllllIIllIll, llllllllllIlllIIIlIllllllIlIIIII);
        double llllllllllIlllIIIlIllllllIIlllII = llllllllllIlllIIIlIllllllIIlllIl * llllllllllIlllIIIlIllllllIIlllll;
        if (llllllllllIlllIIIlIllllllIIlllII < 0.1) {
            llllllllllIlllIIIlIllllllIIlllII = 0.1;
        }
        llllllllllIlllIIIlIllllllIlIIIII = (llllllllllIlllIIIlIllllllIIllllI ? (llllllllllIlllIIIlIllllllIlIIIII += llllllllllIlllIIIlIllllllIIlllII) : (llllllllllIlllIIIlIllllllIlIIIII -= llllllllllIlllIIIlIllllllIIlllII));
        return llllllllllIlllIIIlIllllllIlIIIII;
    }
    
    public static float calculateCompensation(final float llllllllllIlllIIIlIllllllIIIllll, float llllllllllIlllIIIlIllllllIIIlllI, long llllllllllIlllIIIlIllllllIIIIllI, final double llllllllllIlllIIIlIllllllIIIIlIl) {
        final float llllllllllIlllIIIlIllllllIIIlIll = llllllllllIlllIIIlIllllllIIIlllI - llllllllllIlllIIIlIllllllIIIllll;
        if (llllllllllIlllIIIlIllllllIIIIllI < 1L) {
            llllllllllIlllIIIlIllllllIIIIllI = 1L;
        }
        if (llllllllllIlllIIIlIllllllIIIIllI > 1000L) {
            llllllllllIlllIIIlIllllllIIIIllI = 16L;
        }
        if (llllllllllIlllIIIlIllllllIIIlIll > llllllllllIlllIIIlIllllllIIIIlIl) {
            final double llllllllllIlllIIIlIllllllIIIlIlI = (llllllllllIlllIIIlIllllllIIIIlIl * llllllllllIlllIIIlIllllllIIIIllI / 16.0 < 0.5) ? 0.5 : (llllllllllIlllIIIlIllllllIIIIlIl * llllllllllIlllIIIlIllllllIIIIllI / 16.0);
            llllllllllIlllIIIlIllllllIIIlllI -= (float)llllllllllIlllIIIlIllllllIIIlIlI;
            if (llllllllllIlllIIIlIllllllIIIlllI < llllllllllIlllIIIlIllllllIIIllll) {
                llllllllllIlllIIIlIllllllIIIlllI = llllllllllIlllIIIlIllllllIIIllll;
            }
        }
        else if (llllllllllIlllIIIlIllllllIIIlIll < -llllllllllIlllIIIlIllllllIIIIlIl) {
            final double llllllllllIlllIIIlIllllllIIIlIIl = (llllllllllIlllIIIlIllllllIIIIlIl * llllllllllIlllIIIlIllllllIIIIllI / 16.0 < 0.5) ? 0.5 : (llllllllllIlllIIIlIllllllIIIIlIl * llllllllllIlllIIIlIllllllIIIIllI / 16.0);
            llllllllllIlllIIIlIllllllIIIlllI += (float)llllllllllIlllIIIlIllllllIIIlIIl;
            if (llllllllllIlllIIIlIllllllIIIlllI > llllllllllIlllIIIlIllllllIIIllll) {
                llllllllllIlllIIIlIllllllIIIlllI = llllllllllIlllIIIlIllllllIIIllll;
            }
        }
        else {
            llllllllllIlllIIIlIllllllIIIlllI = llllllllllIlllIIIlIllllllIIIllll;
        }
        return llllllllllIlllIIIlIllllllIIIlllI;
    }
    
    public AnimationHelper(final int llllllllllIlllIIIlIllllllIlllIII, final boolean llllllllllIlllIIIlIllllllIllIlll) {
        this.previousState = State.STATIC;
        this.currentState = State.STATIC;
        this.currentStateStart = 0L;
        this.time = llllllllllIlllIIIlIllllllIlllIII;
        this.initialState = llllllllllIlllIIIlIllllllIllIlll;
        if (llllllllllIlllIIIlIllllllIllIlll) {
            this.previousState = State.EXPANDING;
        }
    }
    
    public static float animation(final float llllllllllIlllIIIlIllllllIllIIlI, final float llllllllllIlllIIIlIllllllIllIIIl, final float llllllllllIlllIIIlIllllllIllIIII) {
        float llllllllllIlllIIIlIllllllIlIllll = (llllllllllIlllIIIlIllllllIllIIIl - llllllllllIlllIIIlIllllllIllIIlI) / Minecraft.getDebugFPS() * 15.0f;
        if (llllllllllIlllIIIlIllllllIlIllll > 0.0f) {
            llllllllllIlllIIIlIllllllIlIllll = Math.max(llllllllllIlllIIIlIllllllIllIIII, llllllllllIlllIIIlIllllllIlIllll);
            llllllllllIlllIIIlIllllllIlIllll = Math.min(llllllllllIlllIIIlIllllllIllIIIl - llllllllllIlllIIIlIllllllIllIIlI, llllllllllIlllIIIlIllllllIlIllll);
        }
        else if (llllllllllIlllIIIlIllllllIlIllll < 0.0f) {
            llllllllllIlllIIIlIllllllIlIllll = Math.min(-llllllllllIlllIIIlIllllllIllIIII, llllllllllIlllIIIlIllllllIlIllll);
            llllllllllIlllIIIlIllllllIlIllll = Math.max(llllllllllIlllIIIlIllllllIllIIIl - llllllllllIlllIIIlIllllllIllIIlI, llllllllllIlllIIIlIllllllIlIllll);
        }
        return llllllllllIlllIIIlIllllllIllIIlI + llllllllllIlllIIIlIllllllIlIllll;
    }
    
    public double getAnimationFactor() {
        if (this.currentState == State.EXPANDING) {
            return (System.currentTimeMillis() - this.currentStateStart) / (double)this.time;
        }
        if (this.currentState == State.RETRACTING) {
            return (this.time - (System.currentTimeMillis() - this.currentStateStart)) / (double)this.time;
        }
        return (this.previousState == State.EXPANDING) ? 1 : 0;
    }
    
    public enum State
    {
        RETRACTING("RETRACTING", 1), 
        STATIC("STATIC", 2), 
        EXPANDING("EXPANDING", 0);
        
        private State(final String lllllllllllIIlIllllIIlllIllIllll, final int lllllllllllIIlIllllIIlllIllIlllI) {
        }
    }
}
