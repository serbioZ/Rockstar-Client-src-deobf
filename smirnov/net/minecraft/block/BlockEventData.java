// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.util.math.BlockPos;

public class BlockEventData
{
    private final /* synthetic */ int eventID;
    private final /* synthetic */ int eventParameter;
    private final /* synthetic */ Block blockType;
    private final /* synthetic */ BlockPos position;
    
    @Override
    public String toString() {
        return "TE(" + this.position + ")," + this.eventID + "," + this.eventParameter + "," + this.blockType;
    }
    
    public Block getBlock() {
        return this.blockType;
    }
    
    public BlockPos getPosition() {
        return this.position;
    }
    
    public int getEventID() {
        return this.eventID;
    }
    
    @Override
    public boolean equals(final Object llllllllllIlllIlIlIIIIllIIlIlIIl) {
        if (!(llllllllllIlllIlIlIIIIllIIlIlIIl instanceof BlockEventData)) {
            return false;
        }
        final BlockEventData llllllllllIlllIlIlIIIIllIIlIlIll = (BlockEventData)llllllllllIlllIlIlIIIIllIIlIlIIl;
        return this.position.equals(llllllllllIlllIlIlIIIIllIIlIlIll.position) && this.eventID == llllllllllIlllIlIlIIIIllIIlIlIll.eventID && this.eventParameter == llllllllllIlllIlIlIIIIllIIlIlIll.eventParameter && this.blockType == llllllllllIlllIlIlIIIIllIIlIlIll.blockType;
    }
    
    public BlockEventData(final BlockPos llllllllllIlllIlIlIIIIllIlIIIlIl, final Block llllllllllIlllIlIlIIIIllIlIIIlII, final int llllllllllIlllIlIlIIIIllIIlllllI, final int llllllllllIlllIlIlIIIIllIlIIIIlI) {
        this.position = llllllllllIlllIlIlIIIIllIlIIIlIl;
        this.eventID = llllllllllIlllIlIlIIIIllIIlllllI;
        this.eventParameter = llllllllllIlllIlIlIIIIllIlIIIIlI;
        this.blockType = llllllllllIlllIlIlIIIIllIlIIIlII;
    }
    
    public int getEventParameter() {
        return this.eventParameter;
    }
}
