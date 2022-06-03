// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;

public class NextTickListEntry implements Comparable<NextTickListEntry>
{
    public /* synthetic */ long scheduledTime;
    public final /* synthetic */ BlockPos position;
    private static /* synthetic */ long nextTickEntryID;
    private final /* synthetic */ long tickEntryID;
    public /* synthetic */ int priority;
    private final /* synthetic */ Block block;
    
    @Override
    public int hashCode() {
        return this.position.hashCode();
    }
    
    public Block getBlock() {
        return this.block;
    }
    
    @Override
    public int compareTo(final NextTickListEntry llllllllllllllllIllIlIIlIlIlIIlI) {
        if (this.scheduledTime < llllllllllllllllIllIlIIlIlIlIIlI.scheduledTime) {
            return -1;
        }
        if (this.scheduledTime > llllllllllllllllIllIlIIlIlIlIIlI.scheduledTime) {
            return 1;
        }
        if (this.priority != llllllllllllllllIllIlIIlIlIlIIlI.priority) {
            return this.priority - llllllllllllllllIllIlIIlIlIlIIlI.priority;
        }
        if (this.tickEntryID < llllllllllllllllIllIlIIlIlIlIIlI.tickEntryID) {
            return -1;
        }
        return (this.tickEntryID > llllllllllllllllIllIlIIlIlIlIIlI.tickEntryID) ? 1 : 0;
    }
    
    @Override
    public String toString() {
        return String.valueOf(Block.getIdFromBlock(this.block)) + ": " + this.position + ", " + this.scheduledTime + ", " + this.priority + ", " + this.tickEntryID;
    }
    
    @Override
    public boolean equals(final Object llllllllllllllllIllIlIIlIllIIllI) {
        if (!(llllllllllllllllIllIlIIlIllIIllI instanceof NextTickListEntry)) {
            return false;
        }
        final NextTickListEntry llllllllllllllllIllIlIIlIllIlIII = (NextTickListEntry)llllllllllllllllIllIlIIlIllIIllI;
        return this.position.equals(llllllllllllllllIllIlIIlIllIlIII.position) && Block.isEqualTo(this.block, llllllllllllllllIllIlIIlIllIlIII.block);
    }
    
    public NextTickListEntry(final BlockPos llllllllllllllllIllIlIIlIlllIIlI, final Block llllllllllllllllIllIlIIlIllIlllI) {
        this.tickEntryID = NextTickListEntry.nextTickEntryID++;
        this.position = llllllllllllllllIllIlIIlIlllIIlI.toImmutable();
        this.block = llllllllllllllllIllIlIIlIllIlllI;
    }
    
    public NextTickListEntry setScheduledTime(final long llllllllllllllllIllIlIIlIlIlllII) {
        this.scheduledTime = llllllllllllllllIllIlIIlIlIlllII;
        return this;
    }
    
    public void setPriority(final int llllllllllllllllIllIlIIlIlIlIllI) {
        this.priority = llllllllllllllllIllIlIIlIlIlIllI;
    }
}
