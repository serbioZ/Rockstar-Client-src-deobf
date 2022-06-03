// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.audio;

import net.minecraft.util.SoundCategory;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.item.EntityMinecart;

public class MovingSoundMinecart extends MovingSound
{
    private final /* synthetic */ EntityMinecart minecart;
    private /* synthetic */ float distance;
    
    @Override
    public void update() {
        if (this.minecart.isDead) {
            this.donePlaying = true;
        }
        else {
            this.xPosF = (float)this.minecart.posX;
            this.yPosF = (float)this.minecart.posY;
            this.zPosF = (float)this.minecart.posZ;
            final float llllllllllllIlIIlllIIllllIlllIII = MathHelper.sqrt(this.minecart.motionX * this.minecart.motionX + this.minecart.motionZ * this.minecart.motionZ);
            if (llllllllllllIlIIlllIIllllIlllIII >= 0.01) {
                this.distance = MathHelper.clamp(this.distance + 0.0025f, 0.0f, 1.0f);
                this.volume = 0.0f + MathHelper.clamp(llllllllllllIlIIlllIIllllIlllIII, 0.0f, 0.5f) * 0.7f;
            }
            else {
                this.distance = 0.0f;
                this.volume = 0.0f;
            }
        }
    }
    
    public MovingSoundMinecart(final EntityMinecart llllllllllllIlIIlllIIllllIllllII) {
        super(SoundEvents.ENTITY_MINECART_RIDING, SoundCategory.NEUTRAL);
        this.distance = 0.0f;
        this.minecart = llllllllllllIlIIlllIIllllIllllII;
        this.repeat = true;
        this.repeatDelay = 0;
    }
}
