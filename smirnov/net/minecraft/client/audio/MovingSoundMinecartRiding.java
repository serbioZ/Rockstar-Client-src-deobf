// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.audio;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.SoundCategory;
import net.minecraft.init.SoundEvents;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.item.EntityMinecart;

public class MovingSoundMinecartRiding extends MovingSound
{
    private final /* synthetic */ EntityMinecart minecart;
    private final /* synthetic */ EntityPlayer player;
    
    public MovingSoundMinecartRiding(final EntityPlayer lllllllllllllIIlIllllllIIIIIllIl, final EntityMinecart lllllllllllllIIlIllllllIIIIIllII) {
        super(SoundEvents.ENTITY_MINECART_INSIDE, SoundCategory.NEUTRAL);
        this.player = lllllllllllllIIlIllllllIIIIIllIl;
        this.minecart = lllllllllllllIIlIllllllIIIIIllII;
        this.attenuationType = ISound.AttenuationType.NONE;
        this.repeat = true;
        this.repeatDelay = 0;
    }
    
    @Override
    public void update() {
        if (!this.minecart.isDead && this.player.isRiding() && this.player.getRidingEntity() == this.minecart) {
            final float lllllllllllllIIlIllllllIIIIIIlIl = MathHelper.sqrt(this.minecart.motionX * this.minecart.motionX + this.minecart.motionZ * this.minecart.motionZ);
            if (lllllllllllllIIlIllllllIIIIIIlIl >= 0.01) {
                this.volume = 0.0f + MathHelper.clamp(lllllllllllllIIlIllllllIIIIIIlIl, 0.0f, 1.0f) * 0.75f;
            }
            else {
                this.volume = 0.0f;
            }
        }
        else {
            this.donePlaying = true;
        }
    }
}
