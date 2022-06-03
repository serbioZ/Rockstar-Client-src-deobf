// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.event.event;

import net.minecraft.entity.Entity;
import ru.rockstar.api.event.Event;

public class EventAttackPacket extends Event
{
    private final /* synthetic */ Entity targetEntity;
    
    public Entity getTargetEntity() {
        return this.targetEntity;
    }
    
    public EventAttackPacket(final Entity llllllllllIllllIIlIlllIIlIlllIlI) {
        this.targetEntity = llllllllllIllllIIlIlllIIlIlllIlI;
    }
}
