// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.particle;

import javax.annotation.Nullable;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.World;

public class ParticleBlockDust extends ParticleDigging
{
    protected ParticleBlockDust(final World lllllllllllIIlIIlIIllIIllIlllIII, final double lllllllllllIIlIIlIIllIIllIlIlllI, final double lllllllllllIIlIIlIIllIIllIlIllIl, final double lllllllllllIIlIIlIIllIIllIllIlIl, final double lllllllllllIIlIIlIIllIIllIlIlIll, final double lllllllllllIIlIIlIIllIIllIllIIll, final double lllllllllllIIlIIlIIllIIllIllIIlI, final IBlockState lllllllllllIIlIIlIIllIIllIlIlIII) {
        super(lllllllllllIIlIIlIIllIIllIlllIII, lllllllllllIIlIIlIIllIIllIlIlllI, lllllllllllIIlIIlIIllIIllIlIllIl, lllllllllllIIlIIlIIllIIllIllIlIl, lllllllllllIIlIIlIIllIIllIlIlIll, lllllllllllIIlIIlIIllIIllIllIIll, lllllllllllIIlIIlIIllIIllIllIIlI, lllllllllllIIlIIlIIllIIllIlIlIII);
        this.motionX = lllllllllllIIlIIlIIllIIllIlIlIll;
        this.motionY = lllllllllllIIlIIlIIllIIllIllIIll;
        this.motionZ = lllllllllllIIlIIlIIllIIllIllIIlI;
    }
    
    public static class Factory implements IParticleFactory
    {
        @Nullable
        @Override
        public Particle createParticle(final int lllllllllllIlIllIIIIlIIlIIlllIll, final World lllllllllllIlIllIIIIlIIlIIlllIlI, final double lllllllllllIlIllIIIIlIIlIIlllIIl, final double lllllllllllIlIllIIIIlIIlIIlllIII, final double lllllllllllIlIllIIIIlIIlIIllIlll, final double lllllllllllIlIllIIIIlIIlIIllIllI, final double lllllllllllIlIllIIIIlIIlIIlIlIll, final double lllllllllllIlIllIIIIlIIlIIllIlII, final int... lllllllllllIlIllIIIIlIIlIIllIIll) {
            final IBlockState lllllllllllIlIllIIIIlIIlIIllIIlI = Block.getStateById(lllllllllllIlIllIIIIlIIlIIllIIll[0]);
            return (lllllllllllIlIllIIIIlIIlIIllIIlI.getRenderType() == EnumBlockRenderType.INVISIBLE) ? null : new ParticleBlockDust(lllllllllllIlIllIIIIlIIlIIlllIlI, lllllllllllIlIllIIIIlIIlIIlllIIl, lllllllllllIlIllIIIIlIIlIIlllIII, lllllllllllIlIllIIIIlIIlIIllIlll, lllllllllllIlIllIIIIlIIlIIllIllI, lllllllllllIlIllIIIIlIIlIIlIlIll, lllllllllllIlIllIIIIlIIlIIllIlII, lllllllllllIlIllIIIIlIIlIIllIIlI).init();
        }
    }
}
