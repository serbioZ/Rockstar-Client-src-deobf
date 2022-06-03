// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.event.event;

import net.minecraft.entity.EntityLivingBase;
import ru.rockstar.api.event.Event;

public class EventNameTags extends Event
{
    private /* synthetic */ String renderedName;
    private final /* synthetic */ EntityLivingBase entity;
    
    public EntityLivingBase getEntity() {
        return this.entity;
    }
    
    public String getRenderedName() {
        return this.renderedName;
    }
    
    public void setRenderedName(final String lllllllllllllllIIlIIlIlIIllIIlll) {
        this.renderedName = lllllllllllllllIIlIIlIlIIllIIlll;
    }
    
    public EventNameTags(final EntityLivingBase lllllllllllllllIIlIIlIlIIlllIlIl, final String lllllllllllllllIIlIIlIlIIlllIIIl) {
        this.entity = lllllllllllllllIIlIIlIlIIlllIlIl;
        this.renderedName = lllllllllllllllIIlIIlIlIIlllIIIl;
    }
}
