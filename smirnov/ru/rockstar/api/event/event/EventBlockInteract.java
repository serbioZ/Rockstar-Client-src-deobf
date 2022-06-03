// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.event.event;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import ru.rockstar.api.event.Event;

public class EventBlockInteract extends Event
{
    private /* synthetic */ BlockPos pos;
    private /* synthetic */ EnumFacing face;
    
    public EnumFacing getFace() {
        return this.face;
    }
    
    public void setPos(final BlockPos llllllllllllllllIIlIIlIIllIIllIl) {
        this.pos = llllllllllllllllIIlIIlIIllIIllIl;
    }
    
    public BlockPos getPos() {
        return this.pos;
    }
    
    public void setFace(final EnumFacing llllllllllllllllIIlIIlIIllIIIllI) {
        this.face = llllllllllllllllIIlIIlIIllIIIllI;
    }
    
    public EventBlockInteract(final BlockPos llllllllllllllllIIlIIlIIllIlIlll, final EnumFacing llllllllllllllllIIlIIlIIllIlIllI) {
        this.pos = llllllllllllllllIIlIIlIIllIlIlll;
        this.face = llllllllllllllllIIlIIlIIllIlIllI;
    }
}
