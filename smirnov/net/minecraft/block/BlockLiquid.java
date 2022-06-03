// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.block;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import java.util.Random;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundCategory;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.math.MathHelper;
import java.util.Iterator;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.Vec3d;
import net.minecraft.init.Blocks;
import javax.annotation.Nullable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.PropertyInteger;

public abstract class BlockLiquid extends Block
{
    public static final /* synthetic */ PropertyInteger LEVEL;
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllIllIIIlIIIllIIIllIll) {
        return llllllllllllIllIIIlIIIllIIIllIll.getValue((IProperty<Integer>)BlockLiquid.LEVEL);
    }
    
    @Override
    public boolean isPassable(final IBlockAccess llllllllllllIllIIIlIIlIIIlIllllI, final BlockPos llllllllllllIllIIIlIIlIIIlIlllIl) {
        return this.blockMaterial != Material.LAVA;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllIllIIIlIIIllIIIllllI) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockLiquid.LEVEL, llllllllllllIllIIIlIIIllIIIllllI);
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockLiquid.LEVEL });
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return (this.blockMaterial == Material.WATER) ? BlockRenderLayer.TRANSLUCENT : BlockRenderLayer.SOLID;
    }
    
    public static float getLiquidHeightPercent(int llllllllllllIllIIIlIIlIIIlIllIIl) {
        if (llllllllllllIllIIIlIIlIIIlIllIIl >= 8) {
            llllllllllllIllIIIlIIlIIIlIllIIl = 0;
        }
        return (llllllllllllIllIIIlIIlIIIlIllIIl + 1) / 9.0f;
    }
    
    @Override
    public boolean canCollideCheck(final IBlockState llllllllllllIllIIIlIIlIIIlIIIIlI, final boolean llllllllllllIllIIIlIIlIIIIllllll) {
        return llllllllllllIllIIIlIIlIIIIllllll && llllllllllllIllIIIlIIlIIIlIIIIlI.getValue((IProperty<Integer>)BlockLiquid.LEVEL) == 0;
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState llllllllllllIllIIIlIIlIIIlIIIllI) {
        return false;
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess llllllllllllIllIIIlIIIlIlllllIlI, final IBlockState llllllllllllIllIIIlIIIlIlllllIIl, final BlockPos llllllllllllIllIIIlIIIlIlllllIII, final EnumFacing llllllllllllIllIIIlIIIlIllllIlll) {
        return BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public int tickRate(final World llllllllllllIllIIIlIIIllllIIIlII) {
        if (this.blockMaterial == Material.WATER) {
            return 5;
        }
        if (this.blockMaterial == Material.LAVA) {
            return llllllllllllIllIIIlIIIllllIIIlII.provider.getHasNoSky() ? 10 : 30;
        }
        return 0;
    }
    
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final IBlockState llllllllllllIllIIIlIIlIIIllIIIll, final IBlockAccess llllllllllllIllIIIlIIlIIIllIIIlI, final BlockPos llllllllllllIllIIIlIIlIIIllIIIIl) {
        return BlockLiquid.NULL_AABB;
    }
    
    protected int getRenderedDepth(final IBlockState llllllllllllIllIIIlIIlIIIlIIlIll) {
        final int llllllllllllIllIIIlIIlIIIlIIllIl = this.getDepth(llllllllllllIllIIIlIIlIIIlIIlIll);
        return (llllllllllllIllIIIlIIlIIIlIIllIl >= 8) ? 0 : llllllllllllIllIIIlIIlIIIlIIllIl;
    }
    
    protected BlockLiquid(final Material llllllllllllIllIIIlIIlIIIllIlIll) {
        super(llllllllllllIllIIIlIIlIIIllIlIll);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockLiquid.LEVEL, 0));
        this.setTickRandomly(true);
    }
    
    public boolean checkForMixing(final World llllllllllllIllIIIlIIIllIIlllllI, final BlockPos llllllllllllIllIIIlIIIllIlIIIlII, final IBlockState llllllllllllIllIIIlIIIllIlIIIIll) {
        if (this.blockMaterial == Material.LAVA) {
            boolean llllllllllllIllIIIlIIIllIlIIIIlI = false;
            final float llllllllllllIllIIIlIIIllIIllIlll;
            final byte llllllllllllIllIIIlIIIllIIlllIII = (byte)((EnumFacing[])(Object)(llllllllllllIllIIIlIIIllIIllIlll = (float)(Object)EnumFacing.values())).length;
            for (double llllllllllllIllIIIlIIIllIIlllIIl = 0; llllllllllllIllIIIlIIIllIIlllIIl < llllllllllllIllIIIlIIIllIIlllIII; ++llllllllllllIllIIIlIIIllIIlllIIl) {
                final EnumFacing llllllllllllIllIIIlIIIllIlIIIIIl = llllllllllllIllIIIlIIIllIIllIlll[llllllllllllIllIIIlIIIllIIlllIIl];
                if (llllllllllllIllIIIlIIIllIlIIIIIl != EnumFacing.DOWN && llllllllllllIllIIIlIIIllIIlllllI.getBlockState(llllllllllllIllIIIlIIIllIlIIIlII.offset(llllllllllllIllIIIlIIIllIlIIIIIl)).getMaterial() == Material.WATER) {
                    llllllllllllIllIIIlIIIllIlIIIIlI = true;
                    break;
                }
            }
            if (llllllllllllIllIIIlIIIllIlIIIIlI) {
                final Integer llllllllllllIllIIIlIIIllIlIIIIII = llllllllllllIllIIIlIIIllIlIIIIll.getValue((IProperty<Integer>)BlockLiquid.LEVEL);
                if (llllllllllllIllIIIlIIIllIlIIIIII == 0) {
                    llllllllllllIllIIIlIIIllIIlllllI.setBlockState(llllllllllllIllIIIlIIIllIlIIIlII, Blocks.OBSIDIAN.getDefaultState());
                    this.triggerMixEffects(llllllllllllIllIIIlIIIllIIlllllI, llllllllllllIllIIIlIIIllIlIIIlII);
                    return true;
                }
                if (llllllllllllIllIIIlIIIllIlIIIIII <= 4) {
                    llllllllllllIllIIIlIIIllIIlllllI.setBlockState(llllllllllllIllIIIlIIIllIlIIIlII, Blocks.COBBLESTONE.getDefaultState());
                    this.triggerMixEffects(llllllllllllIllIIIlIIIllIIlllllI, llllllllllllIllIIIlIIIllIlIIIlII);
                    return true;
                }
            }
        }
        return false;
    }
    
    protected Vec3d getFlow(final IBlockAccess llllllllllllIllIIIlIIIlllllIllll, final BlockPos llllllllllllIllIIIlIIIllllIlllll, final IBlockState llllllllllllIllIIIlIIIlllllIllIl) {
        double llllllllllllIllIIIlIIIlllllIllII = 0.0;
        double llllllllllllIllIIIlIIIlllllIlIll = 0.0;
        double llllllllllllIllIIIlIIIlllllIlIlI = 0.0;
        final int llllllllllllIllIIIlIIIlllllIlIIl = this.getRenderedDepth(llllllllllllIllIIIlIIIlllllIllIl);
        final BlockPos.PooledMutableBlockPos llllllllllllIllIIIlIIIlllllIlIII = BlockPos.PooledMutableBlockPos.retain();
        for (final EnumFacing llllllllllllIllIIIlIIIlllllIIlll : EnumFacing.Plane.HORIZONTAL) {
            llllllllllllIllIIIlIIIlllllIlIII.setPos(llllllllllllIllIIIlIIIllllIlllll).move(llllllllllllIllIIIlIIIlllllIIlll);
            int llllllllllllIllIIIlIIIlllllIIllI = this.getRenderedDepth(llllllllllllIllIIIlIIIlllllIllll.getBlockState(llllllllllllIllIIIlIIIlllllIlIII));
            if (llllllllllllIllIIIlIIIlllllIIllI < 0) {
                if (llllllllllllIllIIIlIIIlllllIllll.getBlockState(llllllllllllIllIIIlIIIlllllIlIII).getMaterial().blocksMovement()) {
                    continue;
                }
                llllllllllllIllIIIlIIIlllllIIllI = this.getRenderedDepth(llllllllllllIllIIIlIIIlllllIllll.getBlockState(llllllllllllIllIIIlIIIlllllIlIII.down()));
                if (llllllllllllIllIIIlIIIlllllIIllI < 0) {
                    continue;
                }
                final int llllllllllllIllIIIlIIIlllllIIlIl = llllllllllllIllIIIlIIIlllllIIllI - (llllllllllllIllIIIlIIIlllllIlIIl - 8);
                llllllllllllIllIIIlIIIlllllIllII += llllllllllllIllIIIlIIIlllllIIlll.getFrontOffsetX() * llllllllllllIllIIIlIIIlllllIIlIl;
                llllllllllllIllIIIlIIIlllllIlIll += llllllllllllIllIIIlIIIlllllIIlll.getFrontOffsetY() * llllllllllllIllIIIlIIIlllllIIlIl;
                llllllllllllIllIIIlIIIlllllIlIlI += llllllllllllIllIIIlIIIlllllIIlll.getFrontOffsetZ() * llllllllllllIllIIIlIIIlllllIIlIl;
            }
            else {
                if (llllllllllllIllIIIlIIIlllllIIllI < 0) {
                    continue;
                }
                final int llllllllllllIllIIIlIIIlllllIIlII = llllllllllllIllIIIlIIIlllllIIllI - llllllllllllIllIIIlIIIlllllIlIIl;
                llllllllllllIllIIIlIIIlllllIllII += llllllllllllIllIIIlIIIlllllIIlll.getFrontOffsetX() * llllllllllllIllIIIlIIIlllllIIlII;
                llllllllllllIllIIIlIIIlllllIlIll += llllllllllllIllIIIlIIIlllllIIlll.getFrontOffsetY() * llllllllllllIllIIIlIIIlllllIIlII;
                llllllllllllIllIIIlIIIlllllIlIlI += llllllllllllIllIIIlIIIlllllIIlll.getFrontOffsetZ() * llllllllllllIllIIIlIIIlllllIIlII;
            }
        }
        Vec3d llllllllllllIllIIIlIIIlllllIIIll = new Vec3d(llllllllllllIllIIIlIIIlllllIllII, llllllllllllIllIIIlIIIlllllIlIll, llllllllllllIllIIIlIIIlllllIlIlI);
        if (llllllllllllIllIIIlIIIlllllIllIl.getValue((IProperty<Integer>)BlockLiquid.LEVEL) >= 8) {
            for (final EnumFacing llllllllllllIllIIIlIIIlllllIIIlI : EnumFacing.Plane.HORIZONTAL) {
                llllllllllllIllIIIlIIIlllllIlIII.setPos(llllllllllllIllIIIlIIIllllIlllll).move(llllllllllllIllIIIlIIIlllllIIIlI);
                if (this.isBlockSolid(llllllllllllIllIIIlIIIlllllIllll, llllllllllllIllIIIlIIIlllllIlIII, llllllllllllIllIIIlIIIlllllIIIlI) || this.isBlockSolid(llllllllllllIllIIIlIIIlllllIllll, llllllllllllIllIIIlIIIlllllIlIII.up(), llllllllllllIllIIIlIIIlllllIIIlI)) {
                    llllllllllllIllIIIlIIIlllllIIIll = llllllllllllIllIIIlIIIlllllIIIll.normalize().addVector(0.0, -6.0, 0.0);
                    break;
                }
            }
        }
        llllllllllllIllIIIlIIIlllllIlIII.release();
        return llllllllllllIllIIIlIIIlllllIIIll.normalize();
    }
    
    public static BlockDynamicLiquid getFlowingBlock(final Material llllllllllllIllIIIlIIIllIIIlIlIl) {
        if (llllllllllllIllIIIlIIIllIIIlIlIl == Material.WATER) {
            return Blocks.FLOWING_WATER;
        }
        if (llllllllllllIllIIIlIIIllIIIlIlIl == Material.LAVA) {
            return Blocks.FLOWING_LAVA;
        }
        throw new IllegalArgumentException("Invalid material");
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState llllllllllllIllIIIlIIlIIIllIIlll, final IBlockAccess llllllllllllIllIIIlIIlIIIllIIllI, final BlockPos llllllllllllIllIIIlIIlIIIllIIlIl) {
        return BlockLiquid.FULL_BLOCK_AABB;
    }
    
    @Override
    public void neighborChanged(final IBlockState llllllllllllIllIIIlIIIllIlIllIII, final World llllllllllllIllIIIlIIIllIlIlIIIl, final BlockPos llllllllllllIllIIIlIIIllIlIlIIII, final Block llllllllllllIllIIIlIIIllIlIlIlIl, final BlockPos llllllllllllIllIIIlIIIllIlIlIlII) {
        this.checkForMixing(llllllllllllIllIIIlIIIllIlIlIIIl, llllllllllllIllIIIlIIIllIlIlIIII, llllllllllllIllIIIlIIIllIlIllIII);
    }
    
    public static float func_190973_f(final IBlockState llllllllllllIllIIIlIIIllIIIIlIII, final IBlockAccess llllllllllllIllIIIlIIIllIIIIIlll, final BlockPos llllllllllllIllIIIlIIIllIIIIIllI) {
        final int llllllllllllIllIIIlIIIllIIIIlIIl = llllllllllllIllIIIlIIIllIIIIlIII.getValue((IProperty<Integer>)BlockLiquid.LEVEL);
        return ((llllllllllllIllIIIlIIIllIIIIlIIl & 0x7) == 0x0 && llllllllllllIllIIIlIIIllIIIIIlll.getBlockState(llllllllllllIllIIIlIIIllIIIIIllI.up()).getMaterial() == Material.WATER) ? 1.0f : (1.0f - getLiquidHeightPercent(llllllllllllIllIIIlIIIllIIIIlIIl));
    }
    
    @Override
    public void onBlockAdded(final World llllllllllllIllIIIlIIIllIllIIIII, final BlockPos llllllllllllIllIIIlIIIllIllIIIll, final IBlockState llllllllllllIllIIIlIIIllIlIllllI) {
        this.checkForMixing(llllllllllllIllIIIlIIIllIllIIIII, llllllllllllIllIIIlIIIllIllIIIll, llllllllllllIllIIIlIIIllIlIllllI);
    }
    
    @Override
    public boolean isFullCube(final IBlockState llllllllllllIllIIIlIIlIIIlIIlIII) {
        return false;
    }
    
    public static float getSlopeAngle(final IBlockAccess llllllllllllIllIIIlIIIllIlllIIll, final BlockPos llllllllllllIllIIIlIIIllIllIllIl, final Material llllllllllllIllIIIlIIIllIlllIIIl, final IBlockState llllllllllllIllIIIlIIIllIlllIIII) {
        final Vec3d llllllllllllIllIIIlIIIllIllIllll = getFlowingBlock(llllllllllllIllIIIlIIIllIlllIIIl).getFlow(llllllllllllIllIIIlIIIllIlllIIll, llllllllllllIllIIIlIIIllIllIllIl, llllllllllllIllIIIlIIIllIlllIIII);
        return (llllllllllllIllIIIlIIIllIllIllll.xCoord == 0.0 && llllllllllllIllIIIlIIIllIllIllll.zCoord == 0.0) ? -1000.0f : ((float)MathHelper.atan2(llllllllllllIllIIIlIIIllIllIllll.zCoord, llllllllllllIllIIIlIIIllIllIllll.xCoord) - 1.5707964f);
    }
    
    protected void triggerMixEffects(final World llllllllllllIllIIIlIIIllIIlIlIIl, final BlockPos llllllllllllIllIIIlIIIllIIlIlIII) {
        final double llllllllllllIllIIIlIIIllIIlIllIl = llllllllllllIllIIIlIIIllIIlIlIII.getX();
        final double llllllllllllIllIIIlIIIllIIlIllII = llllllllllllIllIIIlIIIllIIlIlIII.getY();
        final double llllllllllllIllIIIlIIIllIIlIlIll = llllllllllllIllIIIlIIIllIIlIlIII.getZ();
        llllllllllllIllIIIlIIIllIIlIlIIl.playSound(null, llllllllllllIllIIIlIIIllIIlIlIII, SoundEvents.BLOCK_LAVA_EXTINGUISH, SoundCategory.BLOCKS, 0.5f, 2.6f + (llllllllllllIllIIIlIIIllIIlIlIIl.rand.nextFloat() - llllllllllllIllIIIlIIIllIIlIlIIl.rand.nextFloat()) * 0.8f);
        for (int llllllllllllIllIIIlIIIllIIlIlIlI = 0; llllllllllllIllIIIlIIIllIIlIlIlI < 8; ++llllllllllllIllIIIlIIIllIIlIlIlI) {
            llllllllllllIllIIIlIIIllIIlIlIIl.spawnParticle(EnumParticleTypes.SMOKE_LARGE, llllllllllllIllIIIlIIIllIIlIllIl + Math.random(), llllllllllllIllIIIlIIIllIIlIllII + 1.2, llllllllllllIllIIIlIIIllIIlIlIll + Math.random(), 0.0, 0.0, 0.0, new int[0]);
        }
    }
    
    @Override
    public EnumBlockRenderType getRenderType(final IBlockState llllllllllllIllIIIlIIlIIIIIIIlII) {
        return EnumBlockRenderType.LIQUID;
    }
    
    @Override
    public Vec3d modifyAcceleration(final World llllllllllllIllIIIlIIIllllIIllll, final BlockPos llllllllllllIllIIIlIIIllllIIlIIl, final Entity llllllllllllIllIIIlIIIllllIIllIl, final Vec3d llllllllllllIllIIIlIIIllllIIllII) {
        return llllllllllllIllIIIlIIIllllIIllII.add(this.getFlow(llllllllllllIllIIIlIIIllllIIllll, llllllllllllIllIIIlIIIllllIIlIIl, llllllllllllIllIIIlIIIllllIIllll.getBlockState(llllllllllllIllIIIlIIIllllIIlIIl)));
    }
    
    static {
        LEVEL = PropertyInteger.create("level", 0, 15);
    }
    
    @Override
    public int quantityDropped(final Random llllllllllllIllIIIlIIIlllllllllI) {
        return 0;
    }
    
    protected int getDepth(final IBlockState llllllllllllIllIIIlIIlIIIlIlIIll) {
        return (llllllllllllIllIIIlIIlIIIlIlIIll.getMaterial() == this.blockMaterial) ? llllllllllllIllIIIlIIlIIIlIlIIll.getValue((IProperty<Integer>)BlockLiquid.LEVEL) : -1;
    }
    
    public boolean shouldRenderSides(final IBlockAccess llllllllllllIllIIIlIIlIIIIIIlIlI, final BlockPos llllllllllllIllIIIlIIlIIIIIIllll) {
        for (int llllllllllllIllIIIlIIlIIIIIIlllI = -1; llllllllllllIllIIIlIIlIIIIIIlllI <= 1; ++llllllllllllIllIIIlIIlIIIIIIlllI) {
            for (int llllllllllllIllIIIlIIlIIIIIIllIl = -1; llllllllllllIllIIIlIIlIIIIIIllIl <= 1; ++llllllllllllIllIIIlIIlIIIIIIllIl) {
                final IBlockState llllllllllllIllIIIlIIlIIIIIIllII = llllllllllllIllIIIlIIlIIIIIIlIlI.getBlockState(llllllllllllIllIIIlIIlIIIIIIllll.add(llllllllllllIllIIIlIIlIIIIIIlllI, 0, llllllllllllIllIIIlIIlIIIIIIllIl));
                if (llllllllllllIllIIIlIIlIIIIIIllII.getMaterial() != this.blockMaterial && !llllllllllllIllIIIlIIlIIIIIIllII.isFullBlock()) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static float func_190972_g(final IBlockState llllllllllllIllIIIlIIIllIIIIIIIl, final IBlockAccess llllllllllllIllIIIlIIIlIllllllIl, final BlockPos llllllllllllIllIIIlIIIlIllllllll) {
        return llllllllllllIllIIIlIIIlIllllllll.getY() + func_190973_f(llllllllllllIllIIIlIIIllIIIIIIIl, llllllllllllIllIIIlIIIlIllllllIl, llllllllllllIllIIIlIIIlIllllllll);
    }
    
    @Override
    public boolean shouldSideBeRendered(final IBlockState llllllllllllIllIIIlIIlIIIIlIIIII, final IBlockAccess llllllllllllIllIIIlIIlIIIIIlllll, final BlockPos llllllllllllIllIIIlIIlIIIIIllllI, final EnumFacing llllllllllllIllIIIlIIlIIIIIllIII) {
        return llllllllllllIllIIIlIIlIIIIIlllll.getBlockState(llllllllllllIllIIIlIIlIIIIIllllI.offset(llllllllllllIllIIIlIIlIIIIIllIII)).getMaterial() != this.blockMaterial && (llllllllllllIllIIIlIIlIIIIIllIII == EnumFacing.UP || super.shouldSideBeRendered(llllllllllllIllIIIlIIlIIIIlIIIII, llllllllllllIllIIIlIIlIIIIIlllll, llllllllllllIllIIIlIIlIIIIIllllI, llllllllllllIllIIIlIIlIIIIIllIII));
    }
    
    private boolean isBlockSolid(final IBlockAccess llllllllllllIllIIIlIIlIIIIlIllIl, final BlockPos llllllllllllIllIIIlIIlIIIIllIlII, final EnumFacing llllllllllllIllIIIlIIlIIIIllIIll) {
        final IBlockState llllllllllllIllIIIlIIlIIIIllIIlI = llllllllllllIllIIIlIIlIIIIlIllIl.getBlockState(llllllllllllIllIIIlIIlIIIIllIlII);
        final Block llllllllllllIllIIIlIIlIIIIllIIIl = llllllllllllIllIIIlIIlIIIIllIIlI.getBlock();
        final Material llllllllllllIllIIIlIIlIIIIllIIII = llllllllllllIllIIIlIIlIIIIllIIlI.getMaterial();
        if (llllllllllllIllIIIlIIlIIIIllIIII == this.blockMaterial) {
            return false;
        }
        if (llllllllllllIllIIIlIIlIIIIllIIll == EnumFacing.UP) {
            return true;
        }
        if (llllllllllllIllIIIlIIlIIIIllIIII == Material.ICE) {
            return false;
        }
        final boolean llllllllllllIllIIIlIIlIIIIlIllll = Block.func_193382_c(llllllllllllIllIIIlIIlIIIIllIIIl) || llllllllllllIllIIIlIIlIIIIllIIIl instanceof BlockStairs;
        return !llllllllllllIllIIIlIIlIIIIlIllll && llllllllllllIllIIIlIIlIIIIllIIlI.func_193401_d(llllllllllllIllIIIlIIlIIIIlIllIl, llllllllllllIllIIIlIIlIIIIllIlII, llllllllllllIllIIIlIIlIIIIllIIll) == BlockFaceShape.SOLID;
    }
    
    public static BlockStaticLiquid getStaticBlock(final Material llllllllllllIllIIIlIIIllIIIlIIlI) {
        if (llllllllllllIllIIIlIIIllIIIlIIlI == Material.WATER) {
            return Blocks.WATER;
        }
        if (llllllllllllIllIIIlIIIllIIIlIIlI == Material.LAVA) {
            return Blocks.LAVA;
        }
        throw new IllegalArgumentException("Invalid material");
    }
    
    @Override
    public int getPackedLightmapCoords(final IBlockState llllllllllllIllIIIlIIIlllIlllIII, final IBlockAccess llllllllllllIllIIIlIIIlllIlIllll, final BlockPos llllllllllllIllIIIlIIIlllIllIllI) {
        final int llllllllllllIllIIIlIIIlllIllIlIl = llllllllllllIllIIIlIIIlllIlIllll.getCombinedLight(llllllllllllIllIIIlIIIlllIllIllI, 0);
        final int llllllllllllIllIIIlIIIlllIllIlII = llllllllllllIllIIIlIIIlllIlIllll.getCombinedLight(llllllllllllIllIIIlIIIlllIllIllI.up(), 0);
        final int llllllllllllIllIIIlIIIlllIllIIll = llllllllllllIllIIIlIIIlllIllIlIl & 0xFF;
        final int llllllllllllIllIIIlIIIlllIllIIlI = llllllllllllIllIIIlIIIlllIllIlII & 0xFF;
        final int llllllllllllIllIIIlIIIlllIllIIIl = llllllllllllIllIIIlIIIlllIllIlIl >> 16 & 0xFF;
        final int llllllllllllIllIIIlIIIlllIllIIII = llllllllllllIllIIIlIIIlllIllIlII >> 16 & 0xFF;
        return ((llllllllllllIllIIIlIIIlllIllIIll > llllllllllllIllIIIlIIIlllIllIIlI) ? llllllllllllIllIIIlIIIlllIllIIll : llllllllllllIllIIIlIIIlllIllIIlI) | ((llllllllllllIllIIIlIIIlllIllIIIl > llllllllllllIllIIIlIIIlllIllIIII) ? llllllllllllIllIIIlIIIlllIllIIIl : llllllllllllIllIIIlIIIlllIllIIII) << 16;
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllIllIIIlIIlIIIIIIIIlI, final Random llllllllllllIllIIIlIIlIIIIIIIIIl, final int llllllllllllIllIIIlIIlIIIIIIIIII) {
        return Items.field_190931_a;
    }
    
    @Override
    public void randomDisplayTick(final IBlockState llllllllllllIllIIIlIIIlllIIIIlIl, final World llllllllllllIllIIIlIIIlllIIlIlII, final BlockPos llllllllllllIllIIIlIIIlllIIlIIll, final Random llllllllllllIllIIIlIIIlllIIIIIlI) {
        final double llllllllllllIllIIIlIIIlllIIlIIIl = llllllllllllIllIIIlIIIlllIIlIIll.getX();
        final double llllllllllllIllIIIlIIIlllIIlIIII = llllllllllllIllIIIlIIIlllIIlIIll.getY();
        final double llllllllllllIllIIIlIIIlllIIIllll = llllllllllllIllIIIlIIIlllIIlIIll.getZ();
        if (this.blockMaterial == Material.WATER) {
            final int llllllllllllIllIIIlIIIlllIIIlllI = llllllllllllIllIIIlIIIlllIIIIlIl.getValue((IProperty<Integer>)BlockLiquid.LEVEL);
            if (llllllllllllIllIIIlIIIlllIIIlllI > 0 && llllllllllllIllIIIlIIIlllIIIlllI < 8) {
                if (llllllllllllIllIIIlIIIlllIIIIIlI.nextInt(64) == 0) {
                    llllllllllllIllIIIlIIIlllIIlIlII.playSound(llllllllllllIllIIIlIIIlllIIlIIIl + 0.5, llllllllllllIllIIIlIIIlllIIlIIII + 0.5, llllllllllllIllIIIlIIIlllIIIllll + 0.5, SoundEvents.BLOCK_WATER_AMBIENT, SoundCategory.BLOCKS, llllllllllllIllIIIlIIIlllIIIIIlI.nextFloat() * 0.25f + 0.75f, llllllllllllIllIIIlIIIlllIIIIIlI.nextFloat() + 0.5f, false);
                }
            }
            else if (llllllllllllIllIIIlIIIlllIIIIIlI.nextInt(10) == 0) {
                llllllllllllIllIIIlIIIlllIIlIlII.spawnParticle(EnumParticleTypes.SUSPENDED, llllllllllllIllIIIlIIIlllIIlIIIl + llllllllllllIllIIIlIIIlllIIIIIlI.nextFloat(), llllllllllllIllIIIlIIIlllIIlIIII + llllllllllllIllIIIlIIIlllIIIIIlI.nextFloat(), llllllllllllIllIIIlIIIlllIIIllll + llllllllllllIllIIIlIIIlllIIIIIlI.nextFloat(), 0.0, 0.0, 0.0, new int[0]);
            }
        }
        if (this.blockMaterial == Material.LAVA && llllllllllllIllIIIlIIIlllIIlIlII.getBlockState(llllllllllllIllIIIlIIIlllIIlIIll.up()).getMaterial() == Material.AIR && !llllllllllllIllIIIlIIIlllIIlIlII.getBlockState(llllllllllllIllIIIlIIIlllIIlIIll.up()).isOpaqueCube()) {
            if (llllllllllllIllIIIlIIIlllIIIIIlI.nextInt(100) == 0) {
                final double llllllllllllIllIIIlIIIlllIIIllIl = llllllllllllIllIIIlIIIlllIIlIIIl + llllllllllllIllIIIlIIIlllIIIIIlI.nextFloat();
                final double llllllllllllIllIIIlIIIlllIIIllII = llllllllllllIllIIIlIIIlllIIlIIII + llllllllllllIllIIIlIIIlllIIIIlIl.getBoundingBox(llllllllllllIllIIIlIIIlllIIlIlII, llllllllllllIllIIIlIIIlllIIlIIll).maxY;
                final double llllllllllllIllIIIlIIIlllIIIlIll = llllllllllllIllIIIlIIIlllIIIllll + llllllllllllIllIIIlIIIlllIIIIIlI.nextFloat();
                llllllllllllIllIIIlIIIlllIIlIlII.spawnParticle(EnumParticleTypes.LAVA, llllllllllllIllIIIlIIIlllIIIllIl, llllllllllllIllIIIlIIIlllIIIllII, llllllllllllIllIIIlIIIlllIIIlIll, 0.0, 0.0, 0.0, new int[0]);
                llllllllllllIllIIIlIIIlllIIlIlII.playSound(llllllllllllIllIIIlIIIlllIIIllIl, llllllllllllIllIIIlIIIlllIIIllII, llllllllllllIllIIIlIIIlllIIIlIll, SoundEvents.BLOCK_LAVA_POP, SoundCategory.BLOCKS, 0.2f + llllllllllllIllIIIlIIIlllIIIIIlI.nextFloat() * 0.2f, 0.9f + llllllllllllIllIIIlIIIlllIIIIIlI.nextFloat() * 0.15f, false);
            }
            if (llllllllllllIllIIIlIIIlllIIIIIlI.nextInt(200) == 0) {
                llllllllllllIllIIIlIIIlllIIlIlII.playSound(llllllllllllIllIIIlIIIlllIIlIIIl, llllllllllllIllIIIlIIIlllIIlIIII, llllllllllllIllIIIlIIIlllIIIllll, SoundEvents.BLOCK_LAVA_AMBIENT, SoundCategory.BLOCKS, 0.2f + llllllllllllIllIIIlIIIlllIIIIIlI.nextFloat() * 0.2f, 0.9f + llllllllllllIllIIIlIIIlllIIIIIlI.nextFloat() * 0.15f, false);
            }
        }
        if (llllllllllllIllIIIlIIIlllIIIIIlI.nextInt(10) == 0 && llllllllllllIllIIIlIIIlllIIlIlII.getBlockState(llllllllllllIllIIIlIIIlllIIlIIll.down()).isFullyOpaque()) {
            final Material llllllllllllIllIIIlIIIlllIIIlIlI = llllllllllllIllIIIlIIIlllIIlIlII.getBlockState(llllllllllllIllIIIlIIIlllIIlIIll.down(2)).getMaterial();
            if (!llllllllllllIllIIIlIIIlllIIIlIlI.blocksMovement() && !llllllllllllIllIIIlIIIlllIIIlIlI.isLiquid()) {
                final double llllllllllllIllIIIlIIIlllIIIlIIl = llllllllllllIllIIIlIIIlllIIlIIIl + llllllllllllIllIIIlIIIlllIIIIIlI.nextFloat();
                final double llllllllllllIllIIIlIIIlllIIIlIII = llllllllllllIllIIIlIIIlllIIlIIII - 1.05;
                final double llllllllllllIllIIIlIIIlllIIIIlll = llllllllllllIllIIIlIIIlllIIIllll + llllllllllllIllIIIlIIIlllIIIIIlI.nextFloat();
                if (this.blockMaterial == Material.WATER) {
                    llllllllllllIllIIIlIIIlllIIlIlII.spawnParticle(EnumParticleTypes.DRIP_WATER, llllllllllllIllIIIlIIIlllIIIlIIl, llllllllllllIllIIIlIIIlllIIIlIII, llllllllllllIllIIIlIIIlllIIIIlll, 0.0, 0.0, 0.0, new int[0]);
                }
                else {
                    llllllllllllIllIIIlIIIlllIIlIlII.spawnParticle(EnumParticleTypes.DRIP_LAVA, llllllllllllIllIIIlIIIlllIIIlIIl, llllllllllllIllIIIlIIIlllIIIlIII, llllllllllllIllIIIlIIIlllIIIIlll, 0.0, 0.0, 0.0, new int[0]);
                }
            }
        }
    }
}
