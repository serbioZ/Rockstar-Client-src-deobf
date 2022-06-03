// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.event.event;

import net.minecraft.entity.Entity;
import ru.rockstar.api.event.Event;

public class EventAttackClient extends Event
{
    private final /* synthetic */ Entity entity;
    
    public EventAttackClient(final Entity lllllllllllIIIIlIIlIlIlIllIIlllI) {
        this.entity = lllllllllllIIIIlIIlIlIlIllIIlllI;
    }
    
    public Entity getEntity() {
        return this.entity;
    }
}
