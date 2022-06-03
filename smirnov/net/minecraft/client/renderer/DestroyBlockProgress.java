// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer;

import net.minecraft.util.math.BlockPos;

public class DestroyBlockProgress
{
    private final /* synthetic */ int miningPlayerEntId;
    private /* synthetic */ int partialBlockProgress;
    private final /* synthetic */ BlockPos position;
    private /* synthetic */ int createdAtCloudUpdateTick;
    
    public BlockPos getPosition() {
        return this.position;
    }
    
    public void setCloudUpdateTick(final int lllllllllllIIlllIllIIlllIIIIIlIl) {
        this.createdAtCloudUpdateTick = lllllllllllIIlllIllIIlllIIIIIlIl;
    }
    
    public void setPartialBlockDamage(int lllllllllllIIlllIllIIlllIIIIlllI) {
        if (lllllllllllIIlllIllIIlllIIIIlllI > 10) {
            lllllllllllIIlllIllIIlllIIIIlllI = 10;
        }
        this.partialBlockProgress = (int)lllllllllllIIlllIllIIlllIIIIlllI;
    }
    
    public int getPartialBlockDamage() {
        return this.partialBlockProgress;
    }
    
    public DestroyBlockProgress(final int lllllllllllIIlllIllIIlllIIIllIll, final BlockPos lllllllllllIIlllIllIIlllIIIlIlll) {
        this.miningPlayerEntId = lllllllllllIIlllIllIIlllIIIllIll;
        this.position = lllllllllllIIlllIllIIlllIIIlIlll;
    }
    
    public int getCreationCloudUpdateTick() {
        return this.createdAtCloudUpdateTick;
    }
}
