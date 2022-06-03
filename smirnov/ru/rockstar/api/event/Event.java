// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.event;

import java.lang.reflect.InvocationTargetException;
import ru.rockstar.Main;

public abstract class Event
{
    private /* synthetic */ boolean cancelled;
    
    private static void call(final Event lIIIlIlllIIIIll) {
        final EventManager eventManager = Main.instance.eventManager;
        final ArrayHelper<Data> lIIIlIlllIIIIlI = EventManager.get(lIIIlIlllIIIIll.getClass());
        if (lIIIlIlllIIIIlI != null) {
            for (final Data lIIIlIlllIIIIIl : lIIIlIlllIIIIlI) {
                try {
                    lIIIlIlllIIIIIl.target.invoke(lIIIlIlllIIIIIl.source, lIIIlIlllIIIIll);
                }
                catch (IllegalAccessException lIIIlIlllIIIIII) {
                    lIIIlIlllIIIIII.printStackTrace();
                }
                catch (InvocationTargetException lIIIlIllIllllll) {
                    lIIIlIllIllllll.printStackTrace();
                }
            }
        }
    }
    
    public void setCancelled(final boolean lIIIlIlllIIlIIl) {
        this.cancelled = lIIIlIlllIIlIIl;
    }
    
    public Event call() {
        this.cancelled = false;
        call(this);
        return this;
    }
    
    public boolean isCancelled() {
        return this.cancelled;
    }
    
    public enum State
    {
        PRE("PRE", 0, "PRE", 0), 
        POST("POST", 1, "POST", 1);
        
        private State(final String llllllllllllIIIllIIIIlIIIllIlIll, final int llllllllllllIIIllIIIIlIIIllIlIlI, final String llllllllllllIIIllIIIIlIIIllIlllI, final int llllllllllllIIIllIIIIlIIIllIllIl) {
        }
    }
}
