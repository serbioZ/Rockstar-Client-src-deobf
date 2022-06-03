// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.event.event;

import net.minecraft.entity.Entity;
import ru.rockstar.api.event.Event;

public class EventAttack extends Event
{
    private final /* synthetic */ Entity entity;
    private final /* synthetic */ boolean preAttack;
    
    public boolean isPreAttack() {
        return this.preAttack;
    }
    
    public Entity getEntity() {
        return this.entity;
    }
    
    public boolean isPostAttack() {
        return !this.preAttack;
    }
    
    public EventAttack(final Entity llllllllllllIllIllIIIIlIllIIIlll, final boolean llllllllllllIllIllIIIIlIllIIIIll) {
        this.entity = llllllllllllIllIllIIIIlIllIIIlll;
        this.preAttack = llllllllllllIllIllIIIIlIllIIIIll;
    }
}
