// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.event.event;

import net.minecraft.entity.Entity;
import ru.rockstar.api.event.Event;

public class EventAttackSilent extends Event
{
    private final /* synthetic */ Entity targetEntity;
    
    public Entity getTargetEntity() {
        return this.targetEntity;
    }
    
    public EventAttackSilent(final Entity llllllllllIlllIllllIIllllIIIlIlI) {
        this.targetEntity = llllllllllIlllIllllIIllllIIIlIlI;
    }
}
