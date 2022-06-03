// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.world.gen.feature;

import net.minecraft.util.math.AxisAlignedBB;
import javax.annotation.Nullable;
import java.util.Iterator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.util.math.MathHelper;
import net.minecraft.init.Blocks;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;

public class WorldGenSpikes extends WorldGenerator
{
    private /* synthetic */ EndSpike spike;
    private /* synthetic */ boolean crystalInvulnerable;
    private /* synthetic */ BlockPos beamTarget;
    
    @Override
    public boolean generate(final World llllllllllllllllllIlIllllIIIIIII, final Random llllllllllllllllllIlIlllIlllllll, final BlockPos llllllllllllllllllIlIlllIllllllI) {
        if (this.spike == null) {
            throw new IllegalStateException("Decoration requires priming with a spike");
        }
        final int llllllllllllllllllIlIlllIlllllIl = this.spike.getRadius();
        for (final BlockPos.MutableBlockPos llllllllllllllllllIlIlllIlllllII : BlockPos.getAllInBoxMutable(new BlockPos(llllllllllllllllllIlIlllIllllllI.getX() - llllllllllllllllllIlIlllIlllllIl, 0, llllllllllllllllllIlIlllIllllllI.getZ() - llllllllllllllllllIlIlllIlllllIl), new BlockPos(llllllllllllllllllIlIlllIllllllI.getX() + llllllllllllllllllIlIlllIlllllIl, this.spike.getHeight() + 10, llllllllllllllllllIlIlllIllllllI.getZ() + llllllllllllllllllIlIlllIlllllIl))) {
            if (llllllllllllllllllIlIlllIlllllII.distanceSq(llllllllllllllllllIlIlllIllllllI.getX(), llllllllllllllllllIlIlllIlllllII.getY(), llllllllllllllllllIlIlllIllllllI.getZ()) <= llllllllllllllllllIlIlllIlllllIl * llllllllllllllllllIlIlllIlllllIl + 1 && llllllllllllllllllIlIlllIlllllII.getY() < this.spike.getHeight()) {
                this.setBlockAndNotifyAdequately(llllllllllllllllllIlIllllIIIIIII, llllllllllllllllllIlIlllIlllllII, Blocks.OBSIDIAN.getDefaultState());
            }
            else {
                if (llllllllllllllllllIlIlllIlllllII.getY() <= 65) {
                    continue;
                }
                this.setBlockAndNotifyAdequately(llllllllllllllllllIlIllllIIIIIII, llllllllllllllllllIlIlllIlllllII, Blocks.AIR.getDefaultState());
            }
        }
        if (this.spike.isGuarded()) {
            for (int llllllllllllllllllIlIlllIllllIll = -2; llllllllllllllllllIlIlllIllllIll <= 2; ++llllllllllllllllllIlIlllIllllIll) {
                for (int llllllllllllllllllIlIlllIllllIlI = -2; llllllllllllllllllIlIlllIllllIlI <= 2; ++llllllllllllllllllIlIlllIllllIlI) {
                    if (MathHelper.abs(llllllllllllllllllIlIlllIllllIll) == 2 || MathHelper.abs(llllllllllllllllllIlIlllIllllIlI) == 2) {
                        this.setBlockAndNotifyAdequately(llllllllllllllllllIlIllllIIIIIII, new BlockPos(llllllllllllllllllIlIlllIllllllI.getX() + llllllllllllllllllIlIlllIllllIll, this.spike.getHeight(), llllllllllllllllllIlIlllIllllllI.getZ() + llllllllllllllllllIlIlllIllllIlI), Blocks.IRON_BARS.getDefaultState());
                        this.setBlockAndNotifyAdequately(llllllllllllllllllIlIllllIIIIIII, new BlockPos(llllllllllllllllllIlIlllIllllllI.getX() + llllllllllllllllllIlIlllIllllIll, this.spike.getHeight() + 1, llllllllllllllllllIlIlllIllllllI.getZ() + llllllllllllllllllIlIlllIllllIlI), Blocks.IRON_BARS.getDefaultState());
                        this.setBlockAndNotifyAdequately(llllllllllllllllllIlIllllIIIIIII, new BlockPos(llllllllllllllllllIlIlllIllllllI.getX() + llllllllllllllllllIlIlllIllllIll, this.spike.getHeight() + 2, llllllllllllllllllIlIlllIllllllI.getZ() + llllllllllllllllllIlIlllIllllIlI), Blocks.IRON_BARS.getDefaultState());
                    }
                    this.setBlockAndNotifyAdequately(llllllllllllllllllIlIllllIIIIIII, new BlockPos(llllllllllllllllllIlIlllIllllllI.getX() + llllllllllllllllllIlIlllIllllIll, this.spike.getHeight() + 3, llllllllllllllllllIlIlllIllllllI.getZ() + llllllllllllllllllIlIlllIllllIlI), Blocks.IRON_BARS.getDefaultState());
                }
            }
        }
        final EntityEnderCrystal llllllllllllllllllIlIlllIllllIIl = new EntityEnderCrystal(llllllllllllllllllIlIllllIIIIIII);
        llllllllllllllllllIlIlllIllllIIl.setBeamTarget(this.beamTarget);
        llllllllllllllllllIlIlllIllllIIl.setEntityInvulnerable(this.crystalInvulnerable);
        llllllllllllllllllIlIlllIllllIIl.setLocationAndAngles(llllllllllllllllllIlIlllIllllllI.getX() + 0.5f, this.spike.getHeight() + 1, llllllllllllllllllIlIlllIllllllI.getZ() + 0.5f, llllllllllllllllllIlIlllIlllllll.nextFloat() * 360.0f, 0.0f);
        llllllllllllllllllIlIllllIIIIIII.spawnEntityInWorld(llllllllllllllllllIlIlllIllllIIl);
        this.setBlockAndNotifyAdequately(llllllllllllllllllIlIllllIIIIIII, new BlockPos(llllllllllllllllllIlIlllIllllllI.getX(), this.spike.getHeight(), llllllllllllllllllIlIlllIllllllI.getZ()), Blocks.BEDROCK.getDefaultState());
        return true;
    }
    
    public void setBeamTarget(@Nullable final BlockPos llllllllllllllllllIlIlllIllIlllI) {
        this.beamTarget = llllllllllllllllllIlIlllIllIlllI;
    }
    
    public void setCrystalInvulnerable(final boolean llllllllllllllllllIlIllllIIIlIIl) {
        this.crystalInvulnerable = llllllllllllllllllIlIllllIIIlIIl;
    }
    
    public void setSpike(final EndSpike llllllllllllllllllIlIllllIIlIIIl) {
        this.spike = llllllllllllllllllIlIllllIIlIIIl;
    }
    
    public static class EndSpike
    {
        private final /* synthetic */ AxisAlignedBB topBoundingBox;
        private final /* synthetic */ boolean guarded;
        private final /* synthetic */ int centerX;
        private final /* synthetic */ int radius;
        private final /* synthetic */ int centerZ;
        private final /* synthetic */ int height;
        
        public boolean doesStartInChunk(final BlockPos lllllllllllllIlIllIlIIIIllIIlIIl) {
            final int lllllllllllllIlIllIlIIIIllIIlIII = this.centerX - this.radius;
            final int lllllllllllllIlIllIlIIIIllIIIlll = this.centerZ - this.radius;
            return lllllllllllllIlIllIlIIIIllIIlIIl.getX() == (lllllllllllllIlIllIlIIIIllIIlIII & 0xFFFFFFF0) && lllllllllllllIlIllIlIIIIllIIlIIl.getZ() == (lllllllllllllIlIllIlIIIIllIIIlll & 0xFFFFFFF0);
        }
        
        public int getCenterX() {
            return this.centerX;
        }
        
        public AxisAlignedBB getTopBoundingBox() {
            return this.topBoundingBox;
        }
        
        public int getRadius() {
            return this.radius;
        }
        
        public boolean isGuarded() {
            return this.guarded;
        }
        
        public int getCenterZ() {
            return this.centerZ;
        }
        
        public EndSpike(final int lllllllllllllIlIllIlIIIIllIlIIll, final int lllllllllllllIlIllIlIIIIllIlIIlI, final int lllllllllllllIlIllIlIIIIllIlIlll, final int lllllllllllllIlIllIlIIIIllIlIIII, final boolean lllllllllllllIlIllIlIIIIllIIllll) {
            this.centerX = lllllllllllllIlIllIlIIIIllIlIIll;
            this.centerZ = lllllllllllllIlIllIlIIIIllIlIIlI;
            this.radius = lllllllllllllIlIllIlIIIIllIlIlll;
            this.height = lllllllllllllIlIllIlIIIIllIlIIII;
            this.guarded = lllllllllllllIlIllIlIIIIllIIllll;
            this.topBoundingBox = new AxisAlignedBB(lllllllllllllIlIllIlIIIIllIlIIll - lllllllllllllIlIllIlIIIIllIlIlll, 0.0, lllllllllllllIlIllIlIIIIllIlIIlI - lllllllllllllIlIllIlIIIIllIlIlll, lllllllllllllIlIllIlIIIIllIlIIll + lllllllllllllIlIllIlIIIIllIlIlll, 256.0, lllllllllllllIlIllIlIIIIllIlIIlI + lllllllllllllIlIllIlIIIIllIlIlll);
        }
        
        public int getHeight() {
            return this.height;
        }
    }
}
