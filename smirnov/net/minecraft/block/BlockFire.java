// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import javax.annotation.Nullable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.block.material.MapColor;
import com.google.common.collect.Maps;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.util.EnumFacing;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.block.properties.IProperty;
import net.minecraft.world.WorldProviderEnd;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.IBlockAccess;
import net.minecraft.init.Blocks;
import net.minecraft.util.SoundCategory;
import net.minecraft.init.SoundEvents;
import java.util.Random;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.World;
import net.minecraft.block.properties.PropertyInteger;
import java.util.Map;
import net.minecraft.block.properties.PropertyBool;

public class BlockFire extends Block
{
    public static final /* synthetic */ PropertyBool UPPER;
    public static final /* synthetic */ PropertyBool WEST;
    public static final /* synthetic */ PropertyBool EAST;
    public static final /* synthetic */ PropertyBool NORTH;
    private final /* synthetic */ Map<Block, Integer> flammabilities;
    private final /* synthetic */ Map<Block, Integer> encouragements;
    public static final /* synthetic */ PropertyBool SOUTH;
    public static final /* synthetic */ PropertyInteger AGE;
    
    @Override
    public int tickRate(final World lllllllllllIIIlIlllIlIlIIIlIllIl) {
        return 30;
    }
    
    @Override
    public void randomDisplayTick(final IBlockState lllllllllllIIIlIlllIlIIlIllIlIIl, final World lllllllllllIIIlIlllIlIIlIlIIllIl, final BlockPos lllllllllllIIIlIlllIlIIlIlIIllII, final Random lllllllllllIIIlIlllIlIIlIlIIlIll) {
        if (lllllllllllIIIlIlllIlIIlIlIIlIll.nextInt(24) == 0) {
            lllllllllllIIIlIlllIlIIlIlIIllIl.playSound(lllllllllllIIIlIlllIlIIlIlIIllII.getX() + 0.5f, lllllllllllIIIlIlllIlIIlIlIIllII.getY() + 0.5f, lllllllllllIIIlIlllIlIIlIlIIllII.getZ() + 0.5f, SoundEvents.BLOCK_FIRE_AMBIENT, SoundCategory.BLOCKS, 1.0f + lllllllllllIIIlIlllIlIIlIlIIlIll.nextFloat(), lllllllllllIIIlIlllIlIIlIlIIlIll.nextFloat() * 0.7f + 0.3f, false);
        }
        if (!lllllllllllIIIlIlllIlIIlIlIIllIl.getBlockState(lllllllllllIIIlIlllIlIIlIlIIllII.down()).isFullyOpaque() && !Blocks.FIRE.canCatchFire(lllllllllllIIIlIlllIlIIlIlIIllIl, lllllllllllIIIlIlllIlIIlIlIIllII.down())) {
            if (Blocks.FIRE.canCatchFire(lllllllllllIIIlIlllIlIIlIlIIllIl, lllllllllllIIIlIlllIlIIlIlIIllII.west())) {
                for (int lllllllllllIIIlIlllIlIIlIllIIlIl = 0; lllllllllllIIIlIlllIlIIlIllIIlIl < 2; ++lllllllllllIIIlIlllIlIIlIllIIlIl) {
                    final double lllllllllllIIIlIlllIlIIlIllIIlII = lllllllllllIIIlIlllIlIIlIlIIllII.getX() + lllllllllllIIIlIlllIlIIlIlIIlIll.nextDouble() * 0.10000000149011612;
                    final double lllllllllllIIIlIlllIlIIlIllIIIll = lllllllllllIIIlIlllIlIIlIlIIllII.getY() + lllllllllllIIIlIlllIlIIlIlIIlIll.nextDouble();
                    final double lllllllllllIIIlIlllIlIIlIllIIIlI = lllllllllllIIIlIlllIlIIlIlIIllII.getZ() + lllllllllllIIIlIlllIlIIlIlIIlIll.nextDouble();
                    lllllllllllIIIlIlllIlIIlIlIIllIl.spawnParticle(EnumParticleTypes.SMOKE_LARGE, lllllllllllIIIlIlllIlIIlIllIIlII, lllllllllllIIIlIlllIlIIlIllIIIll, lllllllllllIIIlIlllIlIIlIllIIIlI, 0.0, 0.0, 0.0, new int[0]);
                }
            }
            if (Blocks.FIRE.canCatchFire(lllllllllllIIIlIlllIlIIlIlIIllIl, lllllllllllIIIlIlllIlIIlIlIIllII.east())) {
                for (int lllllllllllIIIlIlllIlIIlIllIIIIl = 0; lllllllllllIIIlIlllIlIIlIllIIIIl < 2; ++lllllllllllIIIlIlllIlIIlIllIIIIl) {
                    final double lllllllllllIIIlIlllIlIIlIllIIIII = lllllllllllIIIlIlllIlIIlIlIIllII.getX() + 1 - lllllllllllIIIlIlllIlIIlIlIIlIll.nextDouble() * 0.10000000149011612;
                    final double lllllllllllIIIlIlllIlIIlIlIlllll = lllllllllllIIIlIlllIlIIlIlIIllII.getY() + lllllllllllIIIlIlllIlIIlIlIIlIll.nextDouble();
                    final double lllllllllllIIIlIlllIlIIlIlIllllI = lllllllllllIIIlIlllIlIIlIlIIllII.getZ() + lllllllllllIIIlIlllIlIIlIlIIlIll.nextDouble();
                    lllllllllllIIIlIlllIlIIlIlIIllIl.spawnParticle(EnumParticleTypes.SMOKE_LARGE, lllllllllllIIIlIlllIlIIlIllIIIII, lllllllllllIIIlIlllIlIIlIlIlllll, lllllllllllIIIlIlllIlIIlIlIllllI, 0.0, 0.0, 0.0, new int[0]);
                }
            }
            if (Blocks.FIRE.canCatchFire(lllllllllllIIIlIlllIlIIlIlIIllIl, lllllllllllIIIlIlllIlIIlIlIIllII.north())) {
                for (int lllllllllllIIIlIlllIlIIlIlIlllIl = 0; lllllllllllIIIlIlllIlIIlIlIlllIl < 2; ++lllllllllllIIIlIlllIlIIlIlIlllIl) {
                    final double lllllllllllIIIlIlllIlIIlIlIlllII = lllllllllllIIIlIlllIlIIlIlIIllII.getX() + lllllllllllIIIlIlllIlIIlIlIIlIll.nextDouble();
                    final double lllllllllllIIIlIlllIlIIlIlIllIll = lllllllllllIIIlIlllIlIIlIlIIllII.getY() + lllllllllllIIIlIlllIlIIlIlIIlIll.nextDouble();
                    final double lllllllllllIIIlIlllIlIIlIlIllIlI = lllllllllllIIIlIlllIlIIlIlIIllII.getZ() + lllllllllllIIIlIlllIlIIlIlIIlIll.nextDouble() * 0.10000000149011612;
                    lllllllllllIIIlIlllIlIIlIlIIllIl.spawnParticle(EnumParticleTypes.SMOKE_LARGE, lllllllllllIIIlIlllIlIIlIlIlllII, lllllllllllIIIlIlllIlIIlIlIllIll, lllllllllllIIIlIlllIlIIlIlIllIlI, 0.0, 0.0, 0.0, new int[0]);
                }
            }
            if (Blocks.FIRE.canCatchFire(lllllllllllIIIlIlllIlIIlIlIIllIl, lllllllllllIIIlIlllIlIIlIlIIllII.south())) {
                for (int lllllllllllIIIlIlllIlIIlIlIllIIl = 0; lllllllllllIIIlIlllIlIIlIlIllIIl < 2; ++lllllllllllIIIlIlllIlIIlIlIllIIl) {
                    final double lllllllllllIIIlIlllIlIIlIlIllIII = lllllllllllIIIlIlllIlIIlIlIIllII.getX() + lllllllllllIIIlIlllIlIIlIlIIlIll.nextDouble();
                    final double lllllllllllIIIlIlllIlIIlIlIlIlll = lllllllllllIIIlIlllIlIIlIlIIllII.getY() + lllllllllllIIIlIlllIlIIlIlIIlIll.nextDouble();
                    final double lllllllllllIIIlIlllIlIIlIlIlIllI = lllllllllllIIIlIlllIlIIlIlIIllII.getZ() + 1 - lllllllllllIIIlIlllIlIIlIlIIlIll.nextDouble() * 0.10000000149011612;
                    lllllllllllIIIlIlllIlIIlIlIIllIl.spawnParticle(EnumParticleTypes.SMOKE_LARGE, lllllllllllIIIlIlllIlIIlIlIllIII, lllllllllllIIIlIlllIlIIlIlIlIlll, lllllllllllIIIlIlllIlIIlIlIlIllI, 0.0, 0.0, 0.0, new int[0]);
                }
            }
            if (Blocks.FIRE.canCatchFire(lllllllllllIIIlIlllIlIIlIlIIllIl, lllllllllllIIIlIlllIlIIlIlIIllII.up())) {
                for (int lllllllllllIIIlIlllIlIIlIlIlIlIl = 0; lllllllllllIIIlIlllIlIIlIlIlIlIl < 2; ++lllllllllllIIIlIlllIlIIlIlIlIlIl) {
                    final double lllllllllllIIIlIlllIlIIlIlIlIlII = lllllllllllIIIlIlllIlIIlIlIIllII.getX() + lllllllllllIIIlIlllIlIIlIlIIlIll.nextDouble();
                    final double lllllllllllIIIlIlllIlIIlIlIlIIll = lllllllllllIIIlIlllIlIIlIlIIllII.getY() + 1 - lllllllllllIIIlIlllIlIIlIlIIlIll.nextDouble() * 0.10000000149011612;
                    final double lllllllllllIIIlIlllIlIIlIlIlIIlI = lllllllllllIIIlIlllIlIIlIlIIllII.getZ() + lllllllllllIIIlIlllIlIIlIlIIlIll.nextDouble();
                    lllllllllllIIIlIlllIlIIlIlIIllIl.spawnParticle(EnumParticleTypes.SMOKE_LARGE, lllllllllllIIIlIlllIlIIlIlIlIlII, lllllllllllIIIlIlllIlIIlIlIlIIll, lllllllllllIIIlIlllIlIIlIlIlIIlI, 0.0, 0.0, 0.0, new int[0]);
                }
            }
        }
        else {
            for (int lllllllllllIIIlIlllIlIIlIlIlIIIl = 0; lllllllllllIIIlIlllIlIIlIlIlIIIl < 3; ++lllllllllllIIIlIlllIlIIlIlIlIIIl) {
                final double lllllllllllIIIlIlllIlIIlIlIlIIII = lllllllllllIIIlIlllIlIIlIlIIllII.getX() + lllllllllllIIIlIlllIlIIlIlIIlIll.nextDouble();
                final double lllllllllllIIIlIlllIlIIlIlIIllll = lllllllllllIIIlIlllIlIIlIlIIllII.getY() + lllllllllllIIIlIlllIlIIlIlIIlIll.nextDouble() * 0.5 + 0.5;
                final double lllllllllllIIIlIlllIlIIlIlIIlllI = lllllllllllIIIlIlllIlIIlIlIIllII.getZ() + lllllllllllIIIlIlllIlIIlIlIIlIll.nextDouble();
                lllllllllllIIIlIlllIlIIlIlIIllIl.spawnParticle(EnumParticleTypes.SMOKE_LARGE, lllllllllllIIIlIlllIlIIlIlIlIIII, lllllllllllIIIlIlllIlIIlIlIIllll, lllllllllllIIIlIlllIlIIlIlIIlllI, 0.0, 0.0, 0.0, new int[0]);
            }
        }
    }
    
    @Override
    public void updateTick(final World lllllllllllIIIlIlllIlIlIIIIllIIl, final BlockPos lllllllllllIIIlIlllIlIlIIIIIIllI, IBlockState lllllllllllIIIlIlllIlIlIIIIIIlIl, final Random lllllllllllIIIlIlllIlIlIIIIlIllI) {
        if (lllllllllllIIIlIlllIlIlIIIIllIIl.getGameRules().getBoolean("doFireTick")) {
            if (!this.canPlaceBlockAt(lllllllllllIIIlIlllIlIlIIIIllIIl, lllllllllllIIIlIlllIlIlIIIIIIllI)) {
                lllllllllllIIIlIlllIlIlIIIIllIIl.setBlockToAir(lllllllllllIIIlIlllIlIlIIIIIIllI);
            }
            final Block lllllllllllIIIlIlllIlIlIIIIlIlIl = lllllllllllIIIlIlllIlIlIIIIllIIl.getBlockState(lllllllllllIIIlIlllIlIlIIIIIIllI.down()).getBlock();
            boolean lllllllllllIIIlIlllIlIlIIIIlIlII = lllllllllllIIIlIlllIlIlIIIIlIlIl == Blocks.NETHERRACK || lllllllllllIIIlIlllIlIlIIIIlIlIl == Blocks.MAGMA;
            if (lllllllllllIIIlIlllIlIlIIIIllIIl.provider instanceof WorldProviderEnd && lllllllllllIIIlIlllIlIlIIIIlIlIl == Blocks.BEDROCK) {
                lllllllllllIIIlIlllIlIlIIIIlIlII = true;
            }
            final int lllllllllllIIIlIlllIlIlIIIIlIIll = lllllllllllIIIlIlllIlIlIIIIIIlIl.getValue((IProperty<Integer>)BlockFire.AGE);
            if (!lllllllllllIIIlIlllIlIlIIIIlIlII && lllllllllllIIIlIlllIlIlIIIIllIIl.isRaining() && this.canDie(lllllllllllIIIlIlllIlIlIIIIllIIl, lllllllllllIIIlIlllIlIlIIIIIIllI) && lllllllllllIIIlIlllIlIlIIIIlIllI.nextFloat() < 0.2f + lllllllllllIIIlIlllIlIlIIIIlIIll * 0.03f) {
                lllllllllllIIIlIlllIlIlIIIIllIIl.setBlockToAir(lllllllllllIIIlIlllIlIlIIIIIIllI);
            }
            else {
                if (lllllllllllIIIlIlllIlIlIIIIlIIll < 15) {
                    lllllllllllIIIlIlllIlIlIIIIIIlIl = lllllllllllIIIlIlllIlIlIIIIIIlIl.withProperty((IProperty<Comparable>)BlockFire.AGE, lllllllllllIIIlIlllIlIlIIIIlIIll + lllllllllllIIIlIlllIlIlIIIIlIllI.nextInt(3) / 2);
                    lllllllllllIIIlIlllIlIlIIIIllIIl.setBlockState(lllllllllllIIIlIlllIlIlIIIIIIllI, lllllllllllIIIlIlllIlIlIIIIIIlIl, 4);
                }
                lllllllllllIIIlIlllIlIlIIIIllIIl.scheduleUpdate(lllllllllllIIIlIlllIlIlIIIIIIllI, this, this.tickRate(lllllllllllIIIlIlllIlIlIIIIllIIl) + lllllllllllIIIlIlllIlIlIIIIlIllI.nextInt(10));
                if (!lllllllllllIIIlIlllIlIlIIIIlIlII) {
                    if (!this.canNeighborCatchFire(lllllllllllIIIlIlllIlIlIIIIllIIl, lllllllllllIIIlIlllIlIlIIIIIIllI)) {
                        if (!lllllllllllIIIlIlllIlIlIIIIllIIl.getBlockState(lllllllllllIIIlIlllIlIlIIIIIIllI.down()).isFullyOpaque() || lllllllllllIIIlIlllIlIlIIIIlIIll > 3) {
                            lllllllllllIIIlIlllIlIlIIIIllIIl.setBlockToAir(lllllllllllIIIlIlllIlIlIIIIIIllI);
                        }
                        return;
                    }
                    if (!this.canCatchFire(lllllllllllIIIlIlllIlIlIIIIllIIl, lllllllllllIIIlIlllIlIlIIIIIIllI.down()) && lllllllllllIIIlIlllIlIlIIIIlIIll == 15 && lllllllllllIIIlIlllIlIlIIIIlIllI.nextInt(4) == 0) {
                        lllllllllllIIIlIlllIlIlIIIIllIIl.setBlockToAir(lllllllllllIIIlIlllIlIlIIIIIIllI);
                        return;
                    }
                }
                final boolean lllllllllllIIIlIlllIlIlIIIIlIIlI = lllllllllllIIIlIlllIlIlIIIIllIIl.isBlockinHighHumidity(lllllllllllIIIlIlllIlIlIIIIIIllI);
                int lllllllllllIIIlIlllIlIlIIIIlIIIl = 0;
                if (lllllllllllIIIlIlllIlIlIIIIlIIlI) {
                    lllllllllllIIIlIlllIlIlIIIIlIIIl = -50;
                }
                this.catchOnFire(lllllllllllIIIlIlllIlIlIIIIllIIl, lllllllllllIIIlIlllIlIlIIIIIIllI.east(), 300 + lllllllllllIIIlIlllIlIlIIIIlIIIl, lllllllllllIIIlIlllIlIlIIIIlIllI, lllllllllllIIIlIlllIlIlIIIIlIIll);
                this.catchOnFire(lllllllllllIIIlIlllIlIlIIIIllIIl, lllllllllllIIIlIlllIlIlIIIIIIllI.west(), 300 + lllllllllllIIIlIlllIlIlIIIIlIIIl, lllllllllllIIIlIlllIlIlIIIIlIllI, lllllllllllIIIlIlllIlIlIIIIlIIll);
                this.catchOnFire(lllllllllllIIIlIlllIlIlIIIIllIIl, lllllllllllIIIlIlllIlIlIIIIIIllI.down(), 250 + lllllllllllIIIlIlllIlIlIIIIlIIIl, lllllllllllIIIlIlllIlIlIIIIlIllI, lllllllllllIIIlIlllIlIlIIIIlIIll);
                this.catchOnFire(lllllllllllIIIlIlllIlIlIIIIllIIl, lllllllllllIIIlIlllIlIlIIIIIIllI.up(), 250 + lllllllllllIIIlIlllIlIlIIIIlIIIl, lllllllllllIIIlIlllIlIlIIIIlIllI, lllllllllllIIIlIlllIlIlIIIIlIIll);
                this.catchOnFire(lllllllllllIIIlIlllIlIlIIIIllIIl, lllllllllllIIIlIlllIlIlIIIIIIllI.north(), 300 + lllllllllllIIIlIlllIlIlIIIIlIIIl, lllllllllllIIIlIlllIlIlIIIIlIllI, lllllllllllIIIlIlllIlIlIIIIlIIll);
                this.catchOnFire(lllllllllllIIIlIlllIlIlIIIIllIIl, lllllllllllIIIlIlllIlIlIIIIIIllI.south(), 300 + lllllllllllIIIlIlllIlIlIIIIlIIIl, lllllllllllIIIlIlllIlIlIIIIlIllI, lllllllllllIIIlIlllIlIlIIIIlIIll);
                for (int lllllllllllIIIlIlllIlIlIIIIlIIII = -1; lllllllllllIIIlIlllIlIlIIIIlIIII <= 1; ++lllllllllllIIIlIlllIlIlIIIIlIIII) {
                    for (int lllllllllllIIIlIlllIlIlIIIIIllll = -1; lllllllllllIIIlIlllIlIlIIIIIllll <= 1; ++lllllllllllIIIlIlllIlIlIIIIIllll) {
                        for (int lllllllllllIIIlIlllIlIlIIIIIlllI = -1; lllllllllllIIIlIlllIlIlIIIIIlllI <= 4; ++lllllllllllIIIlIlllIlIlIIIIIlllI) {
                            if (lllllllllllIIIlIlllIlIlIIIIlIIII != 0 || lllllllllllIIIlIlllIlIlIIIIIlllI != 0 || lllllllllllIIIlIlllIlIlIIIIIllll != 0) {
                                int lllllllllllIIIlIlllIlIlIIIIIllIl = 100;
                                if (lllllllllllIIIlIlllIlIlIIIIIlllI > 1) {
                                    lllllllllllIIIlIlllIlIlIIIIIllIl += (lllllllllllIIIlIlllIlIlIIIIIlllI - 1) * 100;
                                }
                                final BlockPos lllllllllllIIIlIlllIlIlIIIIIllII = lllllllllllIIIlIlllIlIlIIIIIIllI.add(lllllllllllIIIlIlllIlIlIIIIlIIII, lllllllllllIIIlIlllIlIlIIIIIlllI, lllllllllllIIIlIlllIlIlIIIIIllll);
                                final int lllllllllllIIIlIlllIlIlIIIIIlIll = this.getNeighborEncouragement(lllllllllllIIIlIlllIlIlIIIIllIIl, lllllllllllIIIlIlllIlIlIIIIIllII);
                                if (lllllllllllIIIlIlllIlIlIIIIIlIll > 0) {
                                    int lllllllllllIIIlIlllIlIlIIIIIlIlI = (lllllllllllIIIlIlllIlIlIIIIIlIll + 40 + lllllllllllIIIlIlllIlIlIIIIllIIl.getDifficulty().getDifficultyId() * 7) / (lllllllllllIIIlIlllIlIlIIIIlIIll + 30);
                                    if (lllllllllllIIIlIlllIlIlIIIIlIIlI) {
                                        lllllllllllIIIlIlllIlIlIIIIIlIlI /= 2;
                                    }
                                    if (lllllllllllIIIlIlllIlIlIIIIIlIlI > 0 && lllllllllllIIIlIlllIlIlIIIIlIllI.nextInt(lllllllllllIIIlIlllIlIlIIIIIllIl) <= lllllllllllIIIlIlllIlIlIIIIIlIlI && (!lllllllllllIIIlIlllIlIlIIIIllIIl.isRaining() || !this.canDie(lllllllllllIIIlIlllIlIlIIIIllIIl, lllllllllllIIIlIlllIlIlIIIIIllII))) {
                                        int lllllllllllIIIlIlllIlIlIIIIIlIIl = lllllllllllIIIlIlllIlIlIIIIlIIll + lllllllllllIIIlIlllIlIlIIIIlIllI.nextInt(5) / 4;
                                        if (lllllllllllIIIlIlllIlIlIIIIIlIIl > 15) {
                                            lllllllllllIIIlIlllIlIlIIIIIlIIl = 15;
                                        }
                                        lllllllllllIIIlIlllIlIlIIIIllIIl.setBlockState(lllllllllllIIIlIlllIlIlIIIIIllII, lllllllllllIIIlIlllIlIlIIIIIIlIl.withProperty((IProperty<Comparable>)BlockFire.AGE, lllllllllllIIIlIlllIlIlIIIIIlIIl), 3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllIIIlIlllIlIlIIIllIIIl) {
        return false;
    }
    
    @Override
    public int quantityDropped(final Random lllllllllllIIIlIlllIlIlIIIlIllll) {
        return 0;
    }
    
    private int getEncouragement(final Block lllllllllllIIIlIlllIlIIlllIllllI) {
        final Integer lllllllllllIIIlIlllIlIIllllIIIII = this.encouragements.get(lllllllllllIIIlIlllIlIIlllIllllI);
        return (lllllllllllIIIlIlllIlIIllllIIIII == null) ? 0 : lllllllllllIIIlIlllIlIIllllIIIII;
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockFire.AGE, BlockFire.NORTH, BlockFire.EAST, BlockFire.SOUTH, BlockFire.WEST, BlockFire.UPPER });
    }
    
    protected boolean canDie(final World lllllllllllIIIlIlllIlIIlllllIIll, final BlockPos lllllllllllIIIlIlllIlIIlllllIIII) {
        return lllllllllllIIIlIlllIlIIlllllIIll.isRainingAt(lllllllllllIIIlIlllIlIIlllllIIII) || lllllllllllIIIlIlllIlIIlllllIIll.isRainingAt(lllllllllllIIIlIlllIlIIlllllIIII.west()) || lllllllllllIIIlIlllIlIIlllllIIll.isRainingAt(lllllllllllIIIlIlllIlIIlllllIIII.east()) || lllllllllllIIIlIlllIlIIlllllIIll.isRainingAt(lllllllllllIIIlIlllIlIIlllllIIII.north()) || lllllllllllIIIlIlllIlIIlllllIIll.isRainingAt(lllllllllllIIIlIlllIlIIlllllIIII.south());
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllIIIlIlllIlIIlIIlllIIl) {
        return lllllllllllIIIlIlllIlIIlIIlllIIl.getValue((IProperty<Integer>)BlockFire.AGE);
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllIIIlIlllIlIIlIIllIIll, final IBlockState lllllllllllIIIlIlllIlIIlIIllIIlI, final BlockPos lllllllllllIIIlIlllIlIIlIIllIIIl, final EnumFacing lllllllllllIIIlIlllIlIIlIIllIIII) {
        return BlockFaceShape.UNDEFINED;
    }
    
    private int getFlammability(final Block lllllllllllIIIlIlllIlIIllllIIlll) {
        final Integer lllllllllllIIIlIlllIlIIllllIlIIl = this.flammabilities.get(lllllllllllIIIlIlllIlIIllllIIlll);
        return (lllllllllllIIIlIlllIlIIllllIlIIl == null) ? 0 : lllllllllllIIIlIlllIlIIllllIlIIl;
    }
    
    static {
        AGE = PropertyInteger.create("age", 0, 15);
        NORTH = PropertyBool.create("north");
        EAST = PropertyBool.create("east");
        SOUTH = PropertyBool.create("south");
        WEST = PropertyBool.create("west");
        UPPER = PropertyBool.create("up");
    }
    
    public void setFireInfo(final Block lllllllllllIIIlIlllIlIlIIIlllIll, final int lllllllllllIIIlIlllIlIlIIIlllIlI, final int lllllllllllIIIlIlllIlIlIIIllllIl) {
        this.encouragements.put(lllllllllllIIIlIlllIlIlIIIlllIll, lllllllllllIIIlIlllIlIlIIIlllIlI);
        this.flammabilities.put(lllllllllllIIIlIlllIlIlIIIlllIll, lllllllllllIIIlIlllIlIlIIIllllIl);
    }
    
    @Override
    public void neighborChanged(final IBlockState lllllllllllIIIlIlllIlIIllIIIIIll, final World lllllllllllIIIlIlllIlIIllIIIIIlI, final BlockPos lllllllllllIIIlIlllIlIIllIIIIIIl, final Block lllllllllllIIIlIlllIlIIllIIIIIII, final BlockPos lllllllllllIIIlIlllIlIIlIlllllll) {
        if (!lllllllllllIIIlIlllIlIIllIIIIIlI.getBlockState(lllllllllllIIIlIlllIlIIllIIIIIIl.down()).isFullyOpaque() && !this.canNeighborCatchFire(lllllllllllIIIlIlllIlIIllIIIIIlI, lllllllllllIIIlIlllIlIIllIIIIIIl)) {
            lllllllllllIIIlIlllIlIIllIIIIIlI.setBlockToAir(lllllllllllIIIlIlllIlIIllIIIIIIl);
        }
    }
    
    private void catchOnFire(final World lllllllllllIIIlIlllIlIIlllIlIIlI, final BlockPos lllllllllllIIIlIlllIlIIlllIlIIIl, final int lllllllllllIIIlIlllIlIIlllIIIlll, final Random lllllllllllIIIlIlllIlIIlllIIllll, final int lllllllllllIIIlIlllIlIIlllIIlllI) {
        final int lllllllllllIIIlIlllIlIIlllIIllIl = this.getFlammability(lllllllllllIIIlIlllIlIIlllIlIIlI.getBlockState(lllllllllllIIIlIlllIlIIlllIlIIIl).getBlock());
        if (lllllllllllIIIlIlllIlIIlllIIllll.nextInt(lllllllllllIIIlIlllIlIIlllIIIlll) < lllllllllllIIIlIlllIlIIlllIIllIl) {
            final IBlockState lllllllllllIIIlIlllIlIIlllIIllII = lllllllllllIIIlIlllIlIIlllIlIIlI.getBlockState(lllllllllllIIIlIlllIlIIlllIlIIIl);
            if (lllllllllllIIIlIlllIlIIlllIIllll.nextInt(lllllllllllIIIlIlllIlIIlllIIlllI + 10) < 5 && !lllllllllllIIIlIlllIlIIlllIlIIlI.isRainingAt(lllllllllllIIIlIlllIlIIlllIlIIIl)) {
                int lllllllllllIIIlIlllIlIIlllIIlIll = lllllllllllIIIlIlllIlIIlllIIlllI + lllllllllllIIIlIlllIlIIlllIIllll.nextInt(5) / 4;
                if (lllllllllllIIIlIlllIlIIlllIIlIll > 15) {
                    lllllllllllIIIlIlllIlIIlllIIlIll = 15;
                }
                lllllllllllIIIlIlllIlIIlllIlIIlI.setBlockState(lllllllllllIIIlIlllIlIIlllIlIIIl, this.getDefaultState().withProperty((IProperty<Comparable>)BlockFire.AGE, lllllllllllIIIlIlllIlIIlllIIlIll), 3);
            }
            else {
                lllllllllllIIIlIlllIlIIlllIlIIlI.setBlockToAir(lllllllllllIIIlIlllIlIIlllIlIIIl);
            }
            if (lllllllllllIIIlIlllIlIIlllIIllII.getBlock() == Blocks.TNT) {
                Blocks.TNT.onBlockDestroyedByPlayer(lllllllllllIIIlIlllIlIIlllIlIIlI, lllllllllllIIIlIlllIlIIlllIlIIIl, lllllllllllIIIlIlllIlIIlllIIllII.withProperty((IProperty<Comparable>)BlockTNT.EXPLODE, true));
            }
        }
    }
    
    @Override
    public boolean requiresUpdates() {
        return false;
    }
    
    protected BlockFire() {
        super(Material.FIRE);
        this.encouragements = (Map<Block, Integer>)Maps.newIdentityHashMap();
        this.flammabilities = (Map<Block, Integer>)Maps.newIdentityHashMap();
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockFire.AGE, 0).withProperty((IProperty<Comparable>)BlockFire.NORTH, false).withProperty((IProperty<Comparable>)BlockFire.EAST, false).withProperty((IProperty<Comparable>)BlockFire.SOUTH, false).withProperty((IProperty<Comparable>)BlockFire.WEST, false).withProperty((IProperty<Comparable>)BlockFire.UPPER, false));
        this.setTickRandomly(true);
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllIIIlIlllIlIIlIIlllllI) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockFire.AGE, lllllllllllIIIlIlllIlIIlIIlllllI);
    }
    
    @Override
    public boolean canPlaceBlockAt(final World lllllllllllIIIlIlllIlIIllIIIllII, final BlockPos lllllllllllIIIlIlllIlIIllIIIlIll) {
        return lllllllllllIIIlIlllIlIIllIIIllII.getBlockState(lllllllllllIIIlIlllIlIIllIIIlIll.down()).isFullyOpaque() || this.canNeighborCatchFire(lllllllllllIIIlIlllIlIIllIIIllII, lllllllllllIIIlIlllIlIIllIIIlIll);
    }
    
    @Override
    public boolean isCollidable() {
        return false;
    }
    
    private int getNeighborEncouragement(final World lllllllllllIIIlIlllIlIIllIlIIllI, final BlockPos lllllllllllIIIlIlllIlIIllIlIIIII) {
        if (!lllllllllllIIIlIlllIlIIllIlIIllI.isAirBlock(lllllllllllIIIlIlllIlIIllIlIIIII)) {
            return 0;
        }
        int lllllllllllIIIlIlllIlIIllIlIIlII = 0;
        final double lllllllllllIIIlIlllIlIIllIIllIll;
        final String lllllllllllIIIlIlllIlIIllIIlllII = (String)((EnumFacing[])(Object)(lllllllllllIIIlIlllIlIIllIIllIll = (double)(Object)EnumFacing.values())).length;
        for (short lllllllllllIIIlIlllIlIIllIIlllIl = 0; lllllllllllIIIlIlllIlIIllIIlllIl < lllllllllllIIIlIlllIlIIllIIlllII; ++lllllllllllIIIlIlllIlIIllIIlllIl) {
            final EnumFacing lllllllllllIIIlIlllIlIIllIlIIIll = lllllllllllIIIlIlllIlIIllIIllIll[lllllllllllIIIlIlllIlIIllIIlllIl];
            lllllllllllIIIlIlllIlIIllIlIIlII = Math.max(this.getEncouragement(lllllllllllIIIlIlllIlIIllIlIIllI.getBlockState(lllllllllllIIIlIlllIlIIllIlIIIII.offset(lllllllllllIIIlIlllIlIIllIlIIIll)).getBlock()), lllllllllllIIIlIlllIlIIllIlIIlII);
        }
        return lllllllllllIIIlIlllIlIIllIlIIlII;
    }
    
    @Override
    public MapColor getMapColor(final IBlockState lllllllllllIIIlIlllIlIIlIlIIIlIl, final IBlockAccess lllllllllllIIIlIlllIlIIlIlIIIlII, final BlockPos lllllllllllIIIlIlllIlIIlIlIIIIll) {
        return MapColor.TNT;
    }
    
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final IBlockState lllllllllllIIIlIlllIlIlIIIllIlll, final IBlockAccess lllllllllllIIIlIlllIlIlIIIllIllI, final BlockPos lllllllllllIIIlIlllIlIlIIIllIlIl) {
        return BlockFire.NULL_AABB;
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllIIIlIlllIlIlIIIllIIll) {
        return false;
    }
    
    public static void init() {
        Blocks.FIRE.setFireInfo(Blocks.PLANKS, 5, 20);
        Blocks.FIRE.setFireInfo(Blocks.DOUBLE_WOODEN_SLAB, 5, 20);
        Blocks.FIRE.setFireInfo(Blocks.WOODEN_SLAB, 5, 20);
        Blocks.FIRE.setFireInfo(Blocks.OAK_FENCE_GATE, 5, 20);
        Blocks.FIRE.setFireInfo(Blocks.SPRUCE_FENCE_GATE, 5, 20);
        Blocks.FIRE.setFireInfo(Blocks.BIRCH_FENCE_GATE, 5, 20);
        Blocks.FIRE.setFireInfo(Blocks.JUNGLE_FENCE_GATE, 5, 20);
        Blocks.FIRE.setFireInfo(Blocks.DARK_OAK_FENCE_GATE, 5, 20);
        Blocks.FIRE.setFireInfo(Blocks.ACACIA_FENCE_GATE, 5, 20);
        Blocks.FIRE.setFireInfo(Blocks.OAK_FENCE, 5, 20);
        Blocks.FIRE.setFireInfo(Blocks.SPRUCE_FENCE, 5, 20);
        Blocks.FIRE.setFireInfo(Blocks.BIRCH_FENCE, 5, 20);
        Blocks.FIRE.setFireInfo(Blocks.JUNGLE_FENCE, 5, 20);
        Blocks.FIRE.setFireInfo(Blocks.DARK_OAK_FENCE, 5, 20);
        Blocks.FIRE.setFireInfo(Blocks.ACACIA_FENCE, 5, 20);
        Blocks.FIRE.setFireInfo(Blocks.OAK_STAIRS, 5, 20);
        Blocks.FIRE.setFireInfo(Blocks.BIRCH_STAIRS, 5, 20);
        Blocks.FIRE.setFireInfo(Blocks.SPRUCE_STAIRS, 5, 20);
        Blocks.FIRE.setFireInfo(Blocks.JUNGLE_STAIRS, 5, 20);
        Blocks.FIRE.setFireInfo(Blocks.ACACIA_STAIRS, 5, 20);
        Blocks.FIRE.setFireInfo(Blocks.DARK_OAK_STAIRS, 5, 20);
        Blocks.FIRE.setFireInfo(Blocks.LOG, 5, 5);
        Blocks.FIRE.setFireInfo(Blocks.LOG2, 5, 5);
        Blocks.FIRE.setFireInfo(Blocks.LEAVES, 30, 60);
        Blocks.FIRE.setFireInfo(Blocks.LEAVES2, 30, 60);
        Blocks.FIRE.setFireInfo(Blocks.BOOKSHELF, 30, 20);
        Blocks.FIRE.setFireInfo(Blocks.TNT, 15, 100);
        Blocks.FIRE.setFireInfo(Blocks.TALLGRASS, 60, 100);
        Blocks.FIRE.setFireInfo(Blocks.DOUBLE_PLANT, 60, 100);
        Blocks.FIRE.setFireInfo(Blocks.YELLOW_FLOWER, 60, 100);
        Blocks.FIRE.setFireInfo(Blocks.RED_FLOWER, 60, 100);
        Blocks.FIRE.setFireInfo(Blocks.DEADBUSH, 60, 100);
        Blocks.FIRE.setFireInfo(Blocks.WOOL, 30, 60);
        Blocks.FIRE.setFireInfo(Blocks.VINE, 15, 100);
        Blocks.FIRE.setFireInfo(Blocks.COAL_BLOCK, 5, 5);
        Blocks.FIRE.setFireInfo(Blocks.HAY_BLOCK, 60, 20);
        Blocks.FIRE.setFireInfo(Blocks.CARPET, 60, 20);
    }
    
    private boolean canNeighborCatchFire(final World lllllllllllIIIlIlllIlIIllIlllIIl, final BlockPos lllllllllllIIIlIlllIlIIllIlllIII) {
        final byte lllllllllllIIIlIlllIlIIllIllIIII;
        final Exception lllllllllllIIIlIlllIlIIllIllIIIl = (Exception)((EnumFacing[])(Object)(lllllllllllIIIlIlllIlIIllIllIIII = (byte)(Object)EnumFacing.values())).length;
        for (char lllllllllllIIIlIlllIlIIllIllIIlI = '\0'; lllllllllllIIIlIlllIlIIllIllIIlI < lllllllllllIIIlIlllIlIIllIllIIIl; ++lllllllllllIIIlIlllIlIIllIllIIlI) {
            final EnumFacing lllllllllllIIIlIlllIlIIllIllIlll = lllllllllllIIIlIlllIlIIllIllIIII[lllllllllllIIIlIlllIlIIllIllIIlI];
            if (this.canCatchFire(lllllllllllIIIlIlllIlIIllIlllIIl, lllllllllllIIIlIlllIlIIllIlllIII.offset(lllllllllllIIIlIlllIlIIllIllIlll))) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void onBlockAdded(final World lllllllllllIIIlIlllIlIIlIlllIlll, final BlockPos lllllllllllIIIlIlllIlIIlIlllIIlI, final IBlockState lllllllllllIIIlIlllIlIIlIlllIlIl) {
        if (lllllllllllIIIlIlllIlIIlIlllIlll.provider.getDimensionType().getId() > 0 || !Blocks.PORTAL.trySpawnPortal(lllllllllllIIIlIlllIlIIlIlllIlll, lllllllllllIIIlIlllIlIIlIlllIIlI)) {
            if (!lllllllllllIIIlIlllIlIIlIlllIlll.getBlockState(lllllllllllIIIlIlllIlIIlIlllIIlI.down()).isFullyOpaque() && !this.canNeighborCatchFire(lllllllllllIIIlIlllIlIIlIlllIlll, lllllllllllIIIlIlllIlIIlIlllIIlI)) {
                lllllllllllIIIlIlllIlIIlIlllIlll.setBlockToAir(lllllllllllIIIlIlllIlIIlIlllIIlI);
            }
            else {
                lllllllllllIIIlIlllIlIIlIlllIlll.scheduleUpdate(lllllllllllIIIlIlllIlIIlIlllIIlI, this, this.tickRate(lllllllllllIIIlIlllIlIIlIlllIlll) + lllllllllllIIIlIlllIlIIlIlllIlll.rand.nextInt(10));
            }
        }
    }
    
    @Override
    public IBlockState getActualState(final IBlockState lllllllllllIIIlIlllIlIlIIlIIlllI, final IBlockAccess lllllllllllIIIlIlllIlIlIIlIIllIl, final BlockPos lllllllllllIIIlIlllIlIlIIlIIlIII) {
        return (!lllllllllllIIIlIlllIlIlIIlIIllIl.getBlockState(lllllllllllIIIlIlllIlIlIIlIIlIII.down()).isFullyOpaque() && !Blocks.FIRE.canCatchFire(lllllllllllIIIlIlllIlIlIIlIIllIl, lllllllllllIIIlIlllIlIlIIlIIlIII.down())) ? lllllllllllIIIlIlllIlIlIIlIIlllI.withProperty((IProperty<Comparable>)BlockFire.NORTH, this.canCatchFire(lllllllllllIIIlIlllIlIlIIlIIllIl, lllllllllllIIIlIlllIlIlIIlIIlIII.north())).withProperty((IProperty<Comparable>)BlockFire.EAST, this.canCatchFire(lllllllllllIIIlIlllIlIlIIlIIllIl, lllllllllllIIIlIlllIlIlIIlIIlIII.east())).withProperty((IProperty<Comparable>)BlockFire.SOUTH, this.canCatchFire(lllllllllllIIIlIlllIlIlIIlIIllIl, lllllllllllIIIlIlllIlIlIIlIIlIII.south())).withProperty((IProperty<Comparable>)BlockFire.WEST, this.canCatchFire(lllllllllllIIIlIlllIlIlIIlIIllIl, lllllllllllIIIlIlllIlIlIIlIIlIII.west())).withProperty((IProperty<Comparable>)BlockFire.UPPER, this.canCatchFire(lllllllllllIIIlIlllIlIlIIlIIllIl, lllllllllllIIIlIlllIlIlIIlIIlIII.up())) : this.getDefaultState();
    }
    
    public boolean canCatchFire(final IBlockAccess lllllllllllIIIlIlllIlIIllIIlIlIl, final BlockPos lllllllllllIIIlIlllIlIIllIIlIIIl) {
        return this.getEncouragement(lllllllllllIIIlIlllIlIIllIIlIlIl.getBlockState(lllllllllllIIIlIlllIlIIllIIlIIIl).getBlock()) > 0;
    }
}
