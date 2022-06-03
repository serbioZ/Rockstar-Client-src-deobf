// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.particle;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumParticleTypes;

public class ParticleEmitter extends Particle
{
    private final /* synthetic */ EnumParticleTypes particleTypes;
    private /* synthetic */ int age;
    private final /* synthetic */ int lifetime;
    private final /* synthetic */ Entity attachedEntity;
    
    @Override
    public int getFXLayer() {
        return 3;
    }
    
    public ParticleEmitter(final World llllllllllllIlIllIllIlIIIlIlIllI, final Entity llllllllllllIlIllIllIlIIIlIlIlIl, final EnumParticleTypes llllllllllllIlIllIllIlIIIlIlIlII, final int llllllllllllIlIllIllIlIIIlIlIIll) {
        super(llllllllllllIlIllIllIlIIIlIlIllI, llllllllllllIlIllIllIlIIIlIlIlIl.posX, llllllllllllIlIllIllIlIIIlIlIlIl.getEntityBoundingBox().minY + llllllllllllIlIllIllIlIIIlIlIlIl.height / 2.0f, llllllllllllIlIllIllIlIIIlIlIlIl.posZ, llllllllllllIlIllIllIlIIIlIlIlIl.motionX, llllllllllllIlIllIllIlIIIlIlIlIl.motionY, llllllllllllIlIllIllIlIIIlIlIlIl.motionZ);
        this.attachedEntity = llllllllllllIlIllIllIlIIIlIlIlIl;
        this.lifetime = llllllllllllIlIllIllIlIIIlIlIIll;
        this.particleTypes = llllllllllllIlIllIllIlIIIlIlIlII;
        this.onUpdate();
    }
    
    public ParticleEmitter(final World llllllllllllIlIllIllIlIIIllIIlII, final Entity llllllllllllIlIllIllIlIIIllIIlll, final EnumParticleTypes llllllllllllIlIllIllIlIIIllIIIlI) {
        this(llllllllllllIlIllIllIlIIIllIIlII, llllllllllllIlIllIllIlIIIllIIlll, llllllllllllIlIllIllIlIIIllIIIlI, 3);
    }
    
    @Override
    public void onUpdate() {
        for (int llllllllllllIlIllIllIlIIIlIIIIII = 0; llllllllllllIlIllIllIlIIIlIIIIII < 16; ++llllllllllllIlIllIllIlIIIlIIIIII) {
            final double llllllllllllIlIllIllIlIIIIllllll = this.rand.nextFloat() * 2.0f - 1.0f;
            final double llllllllllllIlIllIllIlIIIIlllllI = this.rand.nextFloat() * 2.0f - 1.0f;
            final double llllllllllllIlIllIllIlIIIIllllIl = this.rand.nextFloat() * 2.0f - 1.0f;
            if (llllllllllllIlIllIllIlIIIIllllll * llllllllllllIlIllIllIlIIIIllllll + llllllllllllIlIllIllIlIIIIlllllI * llllllllllllIlIllIllIlIIIIlllllI + llllllllllllIlIllIllIlIIIIllllIl * llllllllllllIlIllIllIlIIIIllllIl <= 1.0) {
                final double llllllllllllIlIllIllIlIIIIllllII = this.attachedEntity.posX + llllllllllllIlIllIllIlIIIIllllll * this.attachedEntity.width / 4.0;
                final double llllllllllllIlIllIllIlIIIIlllIll = this.attachedEntity.getEntityBoundingBox().minY + this.attachedEntity.height / 2.0f + llllllllllllIlIllIllIlIIIIlllllI * this.attachedEntity.height / 4.0;
                final double llllllllllllIlIllIllIlIIIIlllIlI = this.attachedEntity.posZ + llllllllllllIlIllIllIlIIIIllllIl * this.attachedEntity.width / 4.0;
                this.worldObj.spawnParticle(this.particleTypes, false, llllllllllllIlIllIllIlIIIIllllII, llllllllllllIlIllIllIlIIIIlllIll, llllllllllllIlIllIllIlIIIIlllIlI, llllllllllllIlIllIllIlIIIIllllll, llllllllllllIlIllIllIlIIIIlllllI + 0.2, llllllllllllIlIllIllIlIIIIllllIl, new int[0]);
            }
        }
        ++this.age;
        if (this.age >= this.lifetime) {
            this.setExpired();
        }
    }
    
    @Override
    public void renderParticle(final BufferBuilder llllllllllllIlIllIllIlIIIlIlIIIl, final Entity llllllllllllIlIllIllIlIIIlIlIIII, final float llllllllllllIlIllIllIlIIIlIIllll, final float llllllllllllIlIllIllIlIIIlIIlllI, final float llllllllllllIlIllIllIlIIIlIIllIl, final float llllllllllllIlIllIllIlIIIlIIllII, final float llllllllllllIlIllIllIlIIIlIIlIll, final float llllllllllllIlIllIllIlIIIlIIlIlI) {
    }
}
