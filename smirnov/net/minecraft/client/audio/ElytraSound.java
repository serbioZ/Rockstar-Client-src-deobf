// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.audio;

import net.minecraft.util.SoundCategory;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.entity.EntityPlayerSP;

public class ElytraSound extends MovingSound
{
    private /* synthetic */ int time;
    private final /* synthetic */ EntityPlayerSP player;
    
    @Override
    public void update() {
        ++this.time;
        if (!this.player.isDead && (this.time <= 20 || this.player.isElytraFlying())) {
            this.xPosF = (float)this.player.posX;
            this.yPosF = (float)this.player.posY;
            this.zPosF = (float)this.player.posZ;
            final float llllllllllllIlllllIIlIIIIIlIlIll = MathHelper.sqrt(this.player.motionX * this.player.motionX + this.player.motionZ * this.player.motionZ + this.player.motionY * this.player.motionY);
            final float llllllllllllIlllllIIlIIIIIlIlIlI = llllllllllllIlllllIIlIIIIIlIlIll / 2.0f;
            if (llllllllllllIlllllIIlIIIIIlIlIll >= 0.01) {
                this.volume = MathHelper.clamp(llllllllllllIlllllIIlIIIIIlIlIlI * llllllllllllIlllllIIlIIIIIlIlIlI, 0.0f, 1.0f);
            }
            else {
                this.volume = 0.0f;
            }
            if (this.time < 20) {
                this.volume = 0.0f;
            }
            else if (this.time < 40) {
                this.volume *= (float)((this.time - 20) / 20.0);
            }
            final float llllllllllllIlllllIIlIIIIIlIlIIl = 0.8f;
            if (this.volume > 0.8f) {
                this.pitch = 1.0f + (this.volume - 0.8f);
            }
            else {
                this.pitch = 1.0f;
            }
        }
        else {
            this.donePlaying = true;
        }
    }
    
    public ElytraSound(final EntityPlayerSP llllllllllllIlllllIIlIIIIIllIIll) {
        super(SoundEvents.ITEM_ELYTRA_FLYING, SoundCategory.PLAYERS);
        this.player = llllllllllllIlllllIIlIIIIIllIIll;
        this.repeat = true;
        this.repeatDelay = 0;
        this.volume = 0.1f;
    }
}
