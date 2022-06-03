// 
// Decompiled by Procyon v0.5.36
// 

package ru.rockstar.api.event.event;

import net.minecraft.block.BlockLiquid;
import net.minecraft.util.math.BlockPos;
import ru.rockstar.api.event.Event;

public class EventLiquidSolid extends Event
{
    private final /* synthetic */ BlockPos pos;
    private final /* synthetic */ BlockLiquid blockLiquid;
    
    public EventLiquidSolid(final BlockLiquid lllllllllllIlIIlllIlllllIIllIllI, final BlockPos lllllllllllIlIIlllIlllllIIlllIII) {
        this.blockLiquid = lllllllllllIlIIlllIlllllIIllIllI;
        this.pos = lllllllllllIlIIlllIlllllIIlllIII;
    }
    
    public BlockLiquid getBlock() {
        return this.blockLiquid;
    }
    
    public BlockPos getPos() {
        return this.pos;
    }
}
