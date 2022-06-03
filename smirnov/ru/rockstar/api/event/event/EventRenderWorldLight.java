// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.event.event;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumSkyBlock;
import ru.rockstar.api.event.Event;

public class EventRenderWorldLight extends Event
{
    private final /* synthetic */ EnumSkyBlock enumSkyBlock;
    private final /* synthetic */ BlockPos pos;
    
    public BlockPos getPos() {
        return this.pos;
    }
    
    public EventRenderWorldLight(final EnumSkyBlock lllllllllllIIlIllIlllIIIIIllIllI, final BlockPos lllllllllllIIlIllIlllIIIIIllIlIl) {
        this.enumSkyBlock = lllllllllllIIlIllIlllIIIIIllIllI;
        this.pos = lllllllllllIIlIllIlllIIIIIllIlIl;
    }
    
    public EnumSkyBlock getEnumSkyBlock() {
        return this.enumSkyBlock;
    }
}
