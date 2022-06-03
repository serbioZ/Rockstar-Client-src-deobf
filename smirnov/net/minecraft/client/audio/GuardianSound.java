// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.audio;

import net.minecraft.util.SoundCategory;
import net.minecraft.init.SoundEvents;
import net.minecraft.entity.monster.EntityGuardian;

public class GuardianSound extends MovingSound
{
    private final /* synthetic */ EntityGuardian guardian;
    
    @Override
    public void update() {
        if (!this.guardian.isDead && this.guardian.hasTargetedEntity()) {
            this.xPosF = (float)this.guardian.posX;
            this.yPosF = (float)this.guardian.posY;
            this.zPosF = (float)this.guardian.posZ;
            final float lllllllllllllIllIllIlIlIIlIIllII = this.guardian.getAttackAnimationScale(0.0f);
            this.volume = 0.0f + 1.0f * lllllllllllllIllIllIlIlIIlIIllII * lllllllllllllIllIllIlIlIIlIIllII;
            this.pitch = 0.7f + 0.5f * lllllllllllllIllIllIlIlIIlIIllII;
        }
        else {
            this.donePlaying = true;
        }
    }
    
    public GuardianSound(final EntityGuardian lllllllllllllIllIllIlIlIIlIlIIII) {
        super(SoundEvents.ENTITY_GUARDIAN_ATTACK, SoundCategory.HOSTILE);
        this.guardian = lllllllllllllIllIllIlIlIIlIlIIII;
        this.attenuationType = ISound.AttenuationType.NONE;
        this.repeat = true;
        this.repeatDelay = 0;
    }
}
