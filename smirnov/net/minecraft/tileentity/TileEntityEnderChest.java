// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.tileentity;

import net.minecraft.util.SoundCategory;
import net.minecraft.init.SoundEvents;
import net.minecraft.init.Blocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ITickable;

public class TileEntityEnderChest extends TileEntity implements ITickable
{
    public /* synthetic */ float prevLidAngle;
    public /* synthetic */ int numPlayersUsing;
    public /* synthetic */ float lidAngle;
    private /* synthetic */ int ticksSinceSync;
    
    public boolean canBeUsed(final EntityPlayer lllllllllllllllIIIlIIIIIlIllllIl) {
        return this.world.getTileEntity(this.pos) == this && lllllllllllllllIIIlIIIIIlIllllIl.getDistanceSq(this.pos.getX() + 0.5, this.pos.getY() + 0.5, this.pos.getZ() + 0.5) <= 64.0;
    }
    
    public void closeChest() {
        --this.numPlayersUsing;
        this.world.addBlockEvent(this.pos, Blocks.ENDER_CHEST, 1, this.numPlayersUsing);
    }
    
    @Override
    public boolean receiveClientEvent(final int lllllllllllllllIIIlIIIIIllIIlllI, final int lllllllllllllllIIIlIIIIIllIIlIlI) {
        if (lllllllllllllllIIIlIIIIIllIIlllI == 1) {
            this.numPlayersUsing = lllllllllllllllIIIlIIIIIllIIlIlI;
            return true;
        }
        return super.receiveClientEvent(lllllllllllllllIIIlIIIIIllIIlllI, lllllllllllllllIIIlIIIIIllIIlIlI);
    }
    
    public void openChest() {
        ++this.numPlayersUsing;
        this.world.addBlockEvent(this.pos, Blocks.ENDER_CHEST, 1, this.numPlayersUsing);
    }
    
    @Override
    public void invalidate() {
        this.updateContainingBlockInfo();
        super.invalidate();
    }
    
    @Override
    public void update() {
        if (++this.ticksSinceSync % 20 * 4 == 0) {
            this.world.addBlockEvent(this.pos, Blocks.ENDER_CHEST, 1, this.numPlayersUsing);
        }
        this.prevLidAngle = this.lidAngle;
        final int lllllllllllllllIIIlIIIIIlllIIlIl = this.pos.getX();
        final int lllllllllllllllIIIlIIIIIlllIIlII = this.pos.getY();
        final int lllllllllllllllIIIlIIIIIlllIIIll = this.pos.getZ();
        final float lllllllllllllllIIIlIIIIIlllIIIlI = 0.1f;
        if (this.numPlayersUsing > 0 && this.lidAngle == 0.0f) {
            final double lllllllllllllllIIIlIIIIIlllIIIIl = lllllllllllllllIIIlIIIIIlllIIlIl + 0.5;
            final double lllllllllllllllIIIlIIIIIlllIIIII = lllllllllllllllIIIlIIIIIlllIIIll + 0.5;
            this.world.playSound(null, lllllllllllllllIIIlIIIIIlllIIIIl, lllllllllllllllIIIlIIIIIlllIIlII + 0.5, lllllllllllllllIIIlIIIIIlllIIIII, SoundEvents.BLOCK_ENDERCHEST_OPEN, SoundCategory.BLOCKS, 0.5f, this.world.rand.nextFloat() * 0.1f + 0.9f);
        }
        if ((this.numPlayersUsing == 0 && this.lidAngle > 0.0f) || (this.numPlayersUsing > 0 && this.lidAngle < 1.0f)) {
            final float lllllllllllllllIIIlIIIIIllIlllll = this.lidAngle;
            if (this.numPlayersUsing > 0) {
                this.lidAngle += 0.1f;
            }
            else {
                this.lidAngle -= 0.1f;
            }
            if (this.lidAngle > 1.0f) {
                this.lidAngle = 1.0f;
            }
            final float lllllllllllllllIIIlIIIIIllIllllI = 0.5f;
            if (this.lidAngle < 0.5f && lllllllllllllllIIIlIIIIIllIlllll >= 0.5f) {
                final double lllllllllllllllIIIlIIIIIllIlllIl = lllllllllllllllIIIlIIIIIlllIIlIl + 0.5;
                final double lllllllllllllllIIIlIIIIIllIlllII = lllllllllllllllIIIlIIIIIlllIIIll + 0.5;
                this.world.playSound(null, lllllllllllllllIIIlIIIIIllIlllIl, lllllllllllllllIIIlIIIIIlllIIlII + 0.5, lllllllllllllllIIIlIIIIIllIlllII, SoundEvents.BLOCK_ENDERCHEST_CLOSE, SoundCategory.BLOCKS, 0.5f, this.world.rand.nextFloat() * 0.1f + 0.9f);
            }
            if (this.lidAngle < 0.0f) {
                this.lidAngle = 0.0f;
            }
        }
    }
}
