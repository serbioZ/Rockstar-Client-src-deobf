// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.event.event;

import net.minecraft.util.EnumHandSide;
import ru.rockstar.api.event.Event;

public class EventTransformSideFirstPerson extends Event
{
    private final /* synthetic */ EnumHandSide enumHandSide;
    
    public EnumHandSide getEnumHandSide() {
        return this.enumHandSide;
    }
    
    public EventTransformSideFirstPerson(final EnumHandSide llllllllllllllIlIIIlIIlllIlIIlll) {
        this.enumHandSide = llllllllllllllIlIIIlIIlllIlIIlll;
    }
}
