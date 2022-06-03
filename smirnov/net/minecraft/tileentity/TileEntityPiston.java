// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.tileentity;

import net.minecraft.block.material.EnumPushReaction;
import com.google.common.collect.Lists;
import javax.annotation.Nullable;
import net.minecraft.world.World;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockPistonExtension;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.nbt.NBTTagCompound;
import java.util.List;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.entity.MoverType;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;

public class TileEntityPiston extends TileEntity implements ITickable
{
    private static final /* synthetic */ ThreadLocal<EnumFacing> field_190613_i;
    private /* synthetic */ boolean extending;
    private /* synthetic */ boolean shouldHeadBeRendered;
    private /* synthetic */ float lastProgress;
    private /* synthetic */ float progress;
    private /* synthetic */ IBlockState pistonState;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing;
    private /* synthetic */ EnumFacing pistonFacing;
    
    public float getOffsetX(final float lllllllllllIllIlIIlIlIlIlIIIlIII) {
        return this.pistonFacing.getFrontOffsetX() * this.getExtendedProgress(this.getProgress(lllllllllllIllIlIIlIlIlIlIIIlIII));
    }
    
    public TileEntityPiston(final IBlockState lllllllllllIllIlIIlIlIlIlIlIllII, final EnumFacing lllllllllllIllIlIIlIlIlIlIlIlIll, final boolean lllllllllllIllIlIIlIlIlIlIlIlIlI, final boolean lllllllllllIllIlIIlIlIlIlIlIlIIl) {
        this.pistonState = lllllllllllIllIlIIlIlIlIlIlIllII;
        this.pistonFacing = lllllllllllIllIlIIlIlIlIlIlIlIll;
        this.extending = lllllllllllIllIlIIlIlIlIlIlIlIlI;
        this.shouldHeadBeRendered = lllllllllllIllIlIIlIlIlIlIlIlIIl;
    }
    
    private void func_190605_a(final Entity lllllllllllIllIlIIlIlIIllllIIlIl, final EnumFacing lllllllllllIllIlIIlIlIIllllIIlII, final double lllllllllllIllIlIIlIlIIlllIllIlI) {
        final AxisAlignedBB lllllllllllIllIlIIlIlIIllllIIIlI = lllllllllllIllIlIIlIlIIllllIIlIl.getEntityBoundingBox();
        final AxisAlignedBB lllllllllllIllIlIIlIlIIllllIIIIl = Block.FULL_BLOCK_AABB.offset(this.pos);
        if (lllllllllllIllIlIIlIlIIllllIIIlI.intersectsWith(lllllllllllIllIlIIlIlIIllllIIIIl)) {
            final EnumFacing lllllllllllIllIlIIlIlIIllllIIIII = lllllllllllIllIlIIlIlIIllllIIlII.getOpposite();
            double lllllllllllIllIlIIlIlIIlllIlllll = this.func_190612_a(lllllllllllIllIlIIlIlIIllllIIIIl, lllllllllllIllIlIIlIlIIllllIIIII, lllllllllllIllIlIIlIlIIllllIIIlI) + 0.01;
            final double lllllllllllIllIlIIlIlIIlllIllllI = this.func_190612_a(lllllllllllIllIlIIlIlIIllllIIIIl, lllllllllllIllIlIIlIlIIllllIIIII, lllllllllllIllIlIIlIlIIllllIIIlI.func_191500_a(lllllllllllIllIlIIlIlIIllllIIIIl)) + 0.01;
            if (Math.abs(lllllllllllIllIlIIlIlIIlllIlllll - lllllllllllIllIlIIlIlIIlllIllllI) < 0.01) {
                lllllllllllIllIlIIlIlIIlllIlllll = Math.min(lllllllllllIllIlIIlIlIIlllIlllll, lllllllllllIllIlIIlIlIIlllIllIlI) + 0.01;
                TileEntityPiston.field_190613_i.set(lllllllllllIllIlIIlIlIIllllIIlII);
                lllllllllllIllIlIIlIlIIllllIIlIl.moveEntity(MoverType.PISTON, lllllllllllIllIlIIlIlIIlllIlllll * lllllllllllIllIlIIlIlIIllllIIIII.getFrontOffsetX(), lllllllllllIllIlIIlIlIIlllIlllll * lllllllllllIllIlIIlIlIIllllIIIII.getFrontOffsetY(), lllllllllllIllIlIIlIlIIlllIlllll * lllllllllllIllIlIIlIlIIllllIIIII.getFrontOffsetZ());
                TileEntityPiston.field_190613_i.set(null);
            }
        }
    }
    
    static {
        field_190613_i = new ThreadLocal<EnumFacing>() {
            @Override
            protected EnumFacing initialValue() {
                return null;
            }
        };
    }
    
    private static double func_190608_c(final AxisAlignedBB lllllllllllIllIlIIlIlIIlllIIlIII, final EnumFacing lllllllllllIllIlIIlIlIIlllIIIlII, final AxisAlignedBB lllllllllllIllIlIIlIlIIlllIIIllI) {
        return (lllllllllllIllIlIIlIlIIlllIIIlII.getAxisDirection() == EnumFacing.AxisDirection.POSITIVE) ? (lllllllllllIllIlIIlIlIIlllIIlIII.maxY - lllllllllllIllIlIIlIlIIlllIIIllI.minY) : (lllllllllllIllIlIIlIlIIlllIIIllI.maxY - lllllllllllIllIlIIlIlIIlllIIlIII.minY);
    }
    
    private AxisAlignedBB func_191515_a(final List<AxisAlignedBB> lllllllllllIllIlIIlIlIlIIIlIIllI) {
        double lllllllllllIllIlIIlIlIlIIIlIIlIl = 0.0;
        double lllllllllllIllIlIIlIlIlIIIlIIlII = 0.0;
        double lllllllllllIllIlIIlIlIlIIIlIIIll = 0.0;
        double lllllllllllIllIlIIlIlIlIIIlIIIlI = 1.0;
        double lllllllllllIllIlIIlIlIlIIIlIIIIl = 1.0;
        double lllllllllllIllIlIIlIlIlIIIlIIIII = 1.0;
        for (final AxisAlignedBB lllllllllllIllIlIIlIlIlIIIIlllll : lllllllllllIllIlIIlIlIlIIIlIIllI) {
            lllllllllllIllIlIIlIlIlIIIlIIlIl = Math.min(lllllllllllIllIlIIlIlIlIIIIlllll.minX, lllllllllllIllIlIIlIlIlIIIlIIlIl);
            lllllllllllIllIlIIlIlIlIIIlIIlII = Math.min(lllllllllllIllIlIIlIlIlIIIIlllll.minY, lllllllllllIllIlIIlIlIlIIIlIIlII);
            lllllllllllIllIlIIlIlIlIIIlIIIll = Math.min(lllllllllllIllIlIIlIlIlIIIIlllll.minZ, lllllllllllIllIlIIlIlIlIIIlIIIll);
            lllllllllllIllIlIIlIlIlIIIlIIIlI = Math.max(lllllllllllIllIlIIlIlIlIIIIlllll.maxX, lllllllllllIllIlIIlIlIlIIIlIIIlI);
            lllllllllllIllIlIIlIlIlIIIlIIIIl = Math.max(lllllllllllIllIlIIlIlIlIIIIlllll.maxY, lllllllllllIllIlIIlIlIlIIIlIIIIl);
            lllllllllllIllIlIIlIlIlIIIlIIIII = Math.max(lllllllllllIllIlIIlIlIlIIIIlllll.maxZ, lllllllllllIllIlIIlIlIlIIIlIIIII);
        }
        return new AxisAlignedBB(lllllllllllIllIlIIlIlIlIIIlIIlIl, lllllllllllIllIlIIlIlIlIIIlIIlII, lllllllllllIllIlIIlIlIlIIIlIIIll, lllllllllllIllIlIIlIlIlIIIlIIIlI, lllllllllllIllIlIIlIlIlIIIlIIIIl, lllllllllllIllIlIIlIlIlIIIlIIIII);
    }
    
    @Override
    public NBTTagCompound writeToNBT(final NBTTagCompound lllllllllllIllIlIIlIlIIllIlIIlII) {
        super.writeToNBT(lllllllllllIllIlIIlIlIIllIlIIlII);
        lllllllllllIllIlIIlIlIIllIlIIlII.setInteger("blockId", Block.getIdFromBlock(this.pistonState.getBlock()));
        lllllllllllIllIlIIlIlIIllIlIIlII.setInteger("blockData", this.pistonState.getBlock().getMetaFromState(this.pistonState));
        lllllllllllIllIlIIlIlIIllIlIIlII.setInteger("facing", this.pistonFacing.getIndex());
        lllllllllllIllIlIIlIlIIllIlIIlII.setFloat("progress", this.lastProgress);
        lllllllllllIllIlIIlIlIIllIlIIlII.setBoolean("extending", this.extending);
        lllllllllllIllIlIIlIlIIllIlIIlII.setBoolean("source", this.shouldHeadBeRendered);
        return lllllllllllIllIlIIlIlIIllIlIIlII;
    }
    
    public AxisAlignedBB getAABB(final IBlockAccess lllllllllllIllIlIIlIlIlIIllIlllI, final BlockPos lllllllllllIllIlIIlIlIlIIlllIIII) {
        return this.getAABB(lllllllllllIllIlIIlIlIlIIllIlllI, lllllllllllIllIlIIlIlIlIIlllIIII, this.progress).union(this.getAABB(lllllllllllIllIlIIlIlIlIIllIlllI, lllllllllllIllIlIIlIlIlIIlllIIII, this.lastProgress));
    }
    
    private IBlockState func_190606_j() {
        return (!this.isExtending() && this.shouldPistonHeadBeRendered()) ? Blocks.PISTON_HEAD.getDefaultState().withProperty(BlockPistonExtension.TYPE, (this.pistonState.getBlock() == Blocks.STICKY_PISTON) ? BlockPistonExtension.EnumPistonType.STICKY : BlockPistonExtension.EnumPistonType.DEFAULT).withProperty((IProperty<Comparable>)BlockPistonExtension.FACING, (EnumFacing)this.pistonState.getValue((IProperty<V>)BlockPistonBase.FACING)) : this.pistonState;
    }
    
    private static double func_190611_b(final AxisAlignedBB lllllllllllIllIlIIlIlIIlllIIlllI, final EnumFacing lllllllllllIllIlIIlIlIIlllIIllIl, final AxisAlignedBB lllllllllllIllIlIIlIlIIlllIIllll) {
        return (lllllllllllIllIlIIlIlIIlllIIllIl.getAxisDirection() == EnumFacing.AxisDirection.POSITIVE) ? (lllllllllllIllIlIIlIlIIlllIIlllI.maxX - lllllllllllIllIlIIlIlIIlllIIllll.minX) : (lllllllllllIllIlIIlIlIIlllIIllll.maxX - lllllllllllIllIlIIlIlIIlllIIlllI.minX);
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing$Axis = TileEntityPiston.$SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis;
        if ($switch_TABLE$net$minecraft$util$EnumFacing$Axis != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing$Axis;
        }
        final double lllllllllllIllIlIIlIlIIlIlllIlll = (Object)new int[EnumFacing.Axis.values().length];
        try {
            lllllllllllIllIlIIlIlIIlIlllIlll[EnumFacing.Axis.X.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllIllIlIIlIlIIlIlllIlll[EnumFacing.Axis.Y.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllIllIlIIlIlIIlIlllIlll[EnumFacing.Axis.Z.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return TileEntityPiston.$SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis = (int[])(Object)lllllllllllIllIlIIlIlIIlIlllIlll;
    }
    
    private AxisAlignedBB func_190610_a(final AxisAlignedBB lllllllllllIllIlIIlIlIIllllllIll, final EnumFacing lllllllllllIllIlIIlIlIIlllllIlII, final double lllllllllllIllIlIIlIlIIlllllIIll) {
        final double lllllllllllIllIlIIlIlIIllllllIII = lllllllllllIllIlIIlIlIIlllllIIll * lllllllllllIllIlIIlIlIIlllllIlII.getAxisDirection().getOffset();
        final double lllllllllllIllIlIIlIlIIlllllIlll = Math.min(lllllllllllIllIlIIlIlIIllllllIII, 0.0);
        final double lllllllllllIllIlIIlIlIIlllllIllI = Math.max(lllllllllllIllIlIIlIlIIllllllIII, 0.0);
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllIllIlIIlIlIIlllllIlII.ordinal()]) {
            case 5: {
                return new AxisAlignedBB(lllllllllllIllIlIIlIlIIllllllIll.minX + lllllllllllIllIlIIlIlIIlllllIlll, lllllllllllIllIlIIlIlIIllllllIll.minY, lllllllllllIllIlIIlIlIIllllllIll.minZ, lllllllllllIllIlIIlIlIIllllllIll.minX + lllllllllllIllIlIIlIlIIlllllIllI, lllllllllllIllIlIIlIlIIllllllIll.maxY, lllllllllllIllIlIIlIlIIllllllIll.maxZ);
            }
            case 6: {
                return new AxisAlignedBB(lllllllllllIllIlIIlIlIIllllllIll.maxX + lllllllllllIllIlIIlIlIIlllllIlll, lllllllllllIllIlIIlIlIIllllllIll.minY, lllllllllllIllIlIIlIlIIllllllIll.minZ, lllllllllllIllIlIIlIlIIllllllIll.maxX + lllllllllllIllIlIIlIlIIlllllIllI, lllllllllllIllIlIIlIlIIllllllIll.maxY, lllllllllllIllIlIIlIlIIllllllIll.maxZ);
            }
            case 1: {
                return new AxisAlignedBB(lllllllllllIllIlIIlIlIIllllllIll.minX, lllllllllllIllIlIIlIlIIllllllIll.minY + lllllllllllIllIlIIlIlIIlllllIlll, lllllllllllIllIlIIlIlIIllllllIll.minZ, lllllllllllIllIlIIlIlIIllllllIll.maxX, lllllllllllIllIlIIlIlIIllllllIll.minY + lllllllllllIllIlIIlIlIIlllllIllI, lllllllllllIllIlIIlIlIIllllllIll.maxZ);
            }
            default: {
                return new AxisAlignedBB(lllllllllllIllIlIIlIlIIllllllIll.minX, lllllllllllIllIlIIlIlIIllllllIll.maxY + lllllllllllIllIlIIlIlIIlllllIlll, lllllllllllIllIlIIlIlIIllllllIll.minZ, lllllllllllIllIlIIlIlIIllllllIll.maxX, lllllllllllIllIlIIlIlIIllllllIll.maxY + lllllllllllIllIlIIlIlIIlllllIllI, lllllllllllIllIlIIlIlIIllllllIll.maxZ);
            }
            case 3: {
                return new AxisAlignedBB(lllllllllllIllIlIIlIlIIllllllIll.minX, lllllllllllIllIlIIlIlIIllllllIll.minY, lllllllllllIllIlIIlIlIIllllllIll.minZ + lllllllllllIllIlIIlIlIIlllllIlll, lllllllllllIllIlIIlIlIIllllllIll.maxX, lllllllllllIllIlIIlIlIIllllllIll.maxY, lllllllllllIllIlIIlIlIIllllllIll.minZ + lllllllllllIllIlIIlIlIIlllllIllI);
            }
            case 4: {
                return new AxisAlignedBB(lllllllllllIllIlIIlIlIIllllllIll.minX, lllllllllllIllIlIIlIlIIllllllIll.minY, lllllllllllIllIlIIlIlIIllllllIll.maxZ + lllllllllllIllIlIIlIlIIlllllIlll, lllllllllllIllIlIIlIlIIllllllIll.maxX, lllllllllllIllIlIIlIlIIllllllIll.maxY, lllllllllllIllIlIIlIlIIllllllIll.maxZ + lllllllllllIllIlIIlIlIIlllllIllI);
            }
        }
    }
    
    public float getOffsetZ(final float lllllllllllIllIlIIlIlIlIIlllllII) {
        return this.pistonFacing.getFrontOffsetZ() * this.getExtendedProgress(this.getProgress(lllllllllllIllIlIIlIlIlIIlllllII));
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound lllllllllllIllIlIIlIlIIllIlIllII) {
        super.readFromNBT(lllllllllllIllIlIIlIlIIllIlIllII);
        this.pistonState = Block.getBlockById(lllllllllllIllIlIIlIlIIllIlIllII.getInteger("blockId")).getStateFromMeta(lllllllllllIllIlIIlIlIIllIlIllII.getInteger("blockData"));
        this.pistonFacing = EnumFacing.getFront(lllllllllllIllIlIIlIlIIllIlIllII.getInteger("facing"));
        this.progress = lllllllllllIllIlIIlIlIIllIlIllII.getFloat("progress");
        this.lastProgress = this.progress;
        this.extending = lllllllllllIllIlIIlIlIIllIlIllII.getBoolean("extending");
        this.shouldHeadBeRendered = lllllllllllIllIlIIlIlIIllIlIllII.getBoolean("source");
    }
    
    @Override
    public NBTTagCompound getUpdateTag() {
        return this.writeToNBT(new NBTTagCompound());
    }
    
    public void clearPistonTileEntity() {
        if (this.lastProgress < 1.0f && this.world != null) {
            this.progress = 1.0f;
            this.lastProgress = this.progress;
            this.world.removeTileEntity(this.pos);
            this.invalidate();
            if (this.world.getBlockState(this.pos).getBlock() == Blocks.PISTON_EXTENSION) {
                this.world.setBlockState(this.pos, this.pistonState, 3);
                this.world.func_190524_a(this.pos, this.pistonState.getBlock(), this.pos);
            }
        }
    }
    
    public float getProgress(float lllllllllllIllIlIIlIlIlIlIIlIIII) {
        if (lllllllllllIllIlIIlIlIlIlIIlIIII > 1.0f) {
            lllllllllllIllIlIIlIlIlIlIIlIIII = 1.0f;
        }
        return this.lastProgress + (this.progress - this.lastProgress) * lllllllllllIllIlIIlIlIlIlIIlIIII;
    }
    
    private float getExtendedProgress(final float lllllllllllIllIlIIlIlIlIIllllIII) {
        return this.extending ? (lllllllllllIllIlIIlIlIlIIllllIII - 1.0f) : (1.0f - lllllllllllIllIlIIlIlIlIIllllIII);
    }
    
    public boolean isExtending() {
        return this.extending;
    }
    
    public EnumFacing getFacing() {
        return this.pistonFacing;
    }
    
    @Override
    public void update() {
        this.lastProgress = this.progress;
        if (this.lastProgress >= 1.0f) {
            this.world.removeTileEntity(this.pos);
            this.invalidate();
            if (this.world.getBlockState(this.pos).getBlock() == Blocks.PISTON_EXTENSION) {
                this.world.setBlockState(this.pos, this.pistonState, 3);
                this.world.func_190524_a(this.pos, this.pistonState.getBlock(), this.pos);
            }
        }
        else {
            final float lllllllllllIllIlIIlIlIIllIllIIll = this.progress + 0.5f;
            this.moveCollidedEntities(lllllllllllIllIlIIlIlIIllIllIIll);
            this.progress = lllllllllllIllIlIIlIlIIllIllIIll;
            if (this.progress >= 1.0f) {
                this.progress = 1.0f;
            }
        }
    }
    
    @Override
    public int getBlockMetadata() {
        return 0;
    }
    
    private static double func_190604_d(final AxisAlignedBB lllllllllllIllIlIIlIlIIllIllllll, final EnumFacing lllllllllllIllIlIIlIlIIllIlllIll, final AxisAlignedBB lllllllllllIllIlIIlIlIIllIllllIl) {
        return (lllllllllllIllIlIIlIlIIllIlllIll.getAxisDirection() == EnumFacing.AxisDirection.POSITIVE) ? (lllllllllllIllIlIIlIlIIllIllllll.maxZ - lllllllllllIllIlIIlIlIIllIllllIl.minZ) : (lllllllllllIllIlIIlIlIIllIllllIl.maxZ - lllllllllllIllIlIIlIlIIllIllllll.minZ);
    }
    
    public AxisAlignedBB getAABB(final IBlockAccess lllllllllllIllIlIIlIlIlIIllIIllI, final BlockPos lllllllllllIllIlIIlIlIlIIllIIIII, float lllllllllllIllIlIIlIlIlIIlIlllll) {
        lllllllllllIllIlIIlIlIlIIlIlllll = this.getExtendedProgress(lllllllllllIllIlIIlIlIlIIlIlllll);
        final IBlockState lllllllllllIllIlIIlIlIlIIllIIIll = this.func_190606_j();
        return lllllllllllIllIlIIlIlIlIIllIIIll.getBoundingBox(lllllllllllIllIlIIlIlIlIIllIIllI, lllllllllllIllIlIIlIlIlIIllIIIII).offset(lllllllllllIllIlIIlIlIlIIlIlllll * this.pistonFacing.getFrontOffsetX(), lllllllllllIllIlIIlIlIlIIlIlllll * this.pistonFacing.getFrontOffsetY(), lllllllllllIllIlIIlIlIlIIlIlllll * this.pistonFacing.getFrontOffsetZ());
    }
    
    private double func_190612_a(final AxisAlignedBB lllllllllllIllIlIIlIlIlIIIIIlllI, final EnumFacing lllllllllllIllIlIIlIlIlIIIIIllIl, final AxisAlignedBB lllllllllllIllIlIIlIlIlIIIIIllII) {
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis()[lllllllllllIllIlIIlIlIlIIIIIllIl.getAxis().ordinal()]) {
            case 1: {
                return func_190611_b(lllllllllllIllIlIIlIlIlIIIIIlllI, lllllllllllIllIlIIlIlIlIIIIIllIl, lllllllllllIllIlIIlIlIlIIIIIllII);
            }
            default: {
                return func_190608_c(lllllllllllIllIlIIlIlIlIIIIIlllI, lllllllllllIllIlIIlIlIlIIIIIllIl, lllllllllllIllIlIIlIlIlIIIIIllII);
            }
            case 3: {
                return func_190604_d(lllllllllllIllIlIIlIlIlIIIIIlllI, lllllllllllIllIlIIlIlIlIIIIIllIl, lllllllllllIllIlIIlIlIlIIIIIllII);
            }
        }
    }
    
    public static void registerFixesPiston(final DataFixer lllllllllllIllIlIIlIlIIllIllIIII) {
    }
    
    public IBlockState getPistonState() {
        return this.pistonState;
    }
    
    public void func_190609_a(final World lllllllllllIllIlIIlIlIIllIIIIlIl, final BlockPos lllllllllllIllIlIIlIlIIllIIIIlII, final AxisAlignedBB lllllllllllIllIlIIlIlIIllIIlIIlI, final List<AxisAlignedBB> lllllllllllIllIlIIlIlIIllIIlIIIl, @Nullable final Entity lllllllllllIllIlIIlIlIIllIIlIIII) {
        if (!this.extending && this.shouldHeadBeRendered) {
            this.pistonState.withProperty((IProperty<Comparable>)BlockPistonBase.EXTENDED, true).addCollisionBoxToList(lllllllllllIllIlIIlIlIIllIIIIlIl, lllllllllllIllIlIIlIlIIllIIIIlII, lllllllllllIllIlIIlIlIIllIIlIIlI, lllllllllllIllIlIIlIlIIllIIlIIIl, lllllllllllIllIlIIlIlIIllIIlIIII, false);
        }
        final EnumFacing lllllllllllIllIlIIlIlIIllIIIllll = TileEntityPiston.field_190613_i.get();
        if (this.progress >= 1.0 || lllllllllllIllIlIIlIlIIllIIIllll != (this.extending ? this.pistonFacing : this.pistonFacing.getOpposite())) {
            final int lllllllllllIllIlIIlIlIIllIIIlllI = lllllllllllIllIlIIlIlIIllIIlIIIl.size();
            IBlockState lllllllllllIllIlIIlIlIIllIIIllII = null;
            if (this.shouldPistonHeadBeRendered()) {
                final IBlockState lllllllllllIllIlIIlIlIIllIIIllIl = Blocks.PISTON_HEAD.getDefaultState().withProperty((IProperty<Comparable>)BlockPistonExtension.FACING, this.pistonFacing).withProperty((IProperty<Comparable>)BlockPistonExtension.SHORT, this.extending ^ 1.0f - this.progress < 0.25f);
            }
            else {
                lllllllllllIllIlIIlIlIIllIIIllII = this.pistonState;
            }
            final float lllllllllllIllIlIIlIlIIllIIIlIll = this.getExtendedProgress(this.progress);
            final double lllllllllllIllIlIIlIlIIllIIIlIlI = this.pistonFacing.getFrontOffsetX() * lllllllllllIllIlIIlIlIIllIIIlIll;
            final double lllllllllllIllIlIIlIlIIllIIIlIIl = this.pistonFacing.getFrontOffsetY() * lllllllllllIllIlIIlIlIIllIIIlIll;
            final double lllllllllllIllIlIIlIlIIllIIIlIII = this.pistonFacing.getFrontOffsetZ() * lllllllllllIllIlIIlIlIIllIIIlIll;
            lllllllllllIllIlIIlIlIIllIIIllII.addCollisionBoxToList(lllllllllllIllIlIIlIlIIllIIIIlIl, lllllllllllIllIlIIlIlIIllIIIIlII, lllllllllllIllIlIIlIlIIllIIlIIlI.offset(-lllllllllllIllIlIIlIlIIllIIIlIlI, -lllllllllllIllIlIIlIlIIllIIIlIIl, -lllllllllllIllIlIIlIlIIllIIIlIII), lllllllllllIllIlIIlIlIIllIIlIIIl, lllllllllllIllIlIIlIlIIllIIlIIII, true);
            for (int lllllllllllIllIlIIlIlIIllIIIIlll = lllllllllllIllIlIIlIlIIllIIIlllI; lllllllllllIllIlIIlIlIIllIIIIlll < lllllllllllIllIlIIlIlIIllIIlIIIl.size(); ++lllllllllllIllIlIIlIlIIllIIIIlll) {
                lllllllllllIllIlIIlIlIIllIIlIIIl.set(lllllllllllIllIlIIlIlIIllIIIIlll, lllllllllllIllIlIIlIlIIllIIlIIIl.get(lllllllllllIllIlIIlIlIIllIIIIlll).offset(lllllllllllIllIlIIlIlIIllIIIlIlI, lllllllllllIllIlIIlIlIIllIIIlIIl, lllllllllllIllIlIIlIlIIllIIIlIII));
            }
        }
    }
    
    public TileEntityPiston() {
    }
    
    private void moveCollidedEntities(final float lllllllllllIllIlIIlIlIlIIIllllIl) {
        final EnumFacing lllllllllllIllIlIIlIlIlIIlIIlIlI = this.extending ? this.pistonFacing : this.pistonFacing.getOpposite();
        final double lllllllllllIllIlIIlIlIlIIlIIlIIl = lllllllllllIllIlIIlIlIlIIIllllIl - this.progress;
        final List<AxisAlignedBB> lllllllllllIllIlIIlIlIlIIlIIlIII = (List<AxisAlignedBB>)Lists.newArrayList();
        this.func_190606_j().addCollisionBoxToList(this.world, BlockPos.ORIGIN, new AxisAlignedBB(BlockPos.ORIGIN), lllllllllllIllIlIIlIlIlIIlIIlIII, null, true);
        if (!lllllllllllIllIlIIlIlIlIIlIIlIII.isEmpty()) {
            final AxisAlignedBB lllllllllllIllIlIIlIlIlIIlIIIlll = this.func_190607_a(this.func_191515_a(lllllllllllIllIlIIlIlIlIIlIIlIII));
            final List<Entity> lllllllllllIllIlIIlIlIlIIlIIIllI = this.world.getEntitiesWithinAABBExcludingEntity(null, this.func_190610_a(lllllllllllIllIlIIlIlIlIIlIIIlll, lllllllllllIllIlIIlIlIlIIlIIlIlI, lllllllllllIllIlIIlIlIlIIlIIlIIl).union(lllllllllllIllIlIIlIlIlIIlIIIlll));
            if (!lllllllllllIllIlIIlIlIlIIlIIIllI.isEmpty()) {
                final boolean lllllllllllIllIlIIlIlIlIIlIIIlIl = this.pistonState.getBlock() == Blocks.SLIME_BLOCK;
                for (int lllllllllllIllIlIIlIlIlIIlIIIlII = 0; lllllllllllIllIlIIlIlIlIIlIIIlII < lllllllllllIllIlIIlIlIlIIlIIIllI.size(); ++lllllllllllIllIlIIlIlIlIIlIIIlII) {
                    final Entity lllllllllllIllIlIIlIlIlIIlIIIIll = lllllllllllIllIlIIlIlIlIIlIIIllI.get(lllllllllllIllIlIIlIlIlIIlIIIlII);
                    if (lllllllllllIllIlIIlIlIlIIlIIIIll.getPushReaction() != EnumPushReaction.IGNORE) {
                        if (lllllllllllIllIlIIlIlIlIIlIIIlIl) {
                            switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis()[lllllllllllIllIlIIlIlIlIIlIIlIlI.getAxis().ordinal()]) {
                                case 1: {
                                    lllllllllllIllIlIIlIlIlIIlIIIIll.motionX = lllllllllllIllIlIIlIlIlIIlIIlIlI.getFrontOffsetX();
                                    break;
                                }
                                case 2: {
                                    lllllllllllIllIlIIlIlIlIIlIIIIll.motionY = lllllllllllIllIlIIlIlIlIIlIIlIlI.getFrontOffsetY();
                                    break;
                                }
                                case 3: {
                                    lllllllllllIllIlIIlIlIlIIlIIIIll.motionZ = lllllllllllIllIlIIlIlIlIIlIIlIlI.getFrontOffsetZ();
                                    break;
                                }
                            }
                        }
                        double lllllllllllIllIlIIlIlIlIIlIIIIlI = 0.0;
                        for (int lllllllllllIllIlIIlIlIlIIlIIIIIl = 0; lllllllllllIllIlIIlIlIlIIlIIIIIl < lllllllllllIllIlIIlIlIlIIlIIlIII.size(); ++lllllllllllIllIlIIlIlIlIIlIIIIIl) {
                            final AxisAlignedBB lllllllllllIllIlIIlIlIlIIlIIIIII = this.func_190610_a(this.func_190607_a(lllllllllllIllIlIIlIlIlIIlIIlIII.get(lllllllllllIllIlIIlIlIlIIlIIIIIl)), lllllllllllIllIlIIlIlIlIIlIIlIlI, lllllllllllIllIlIIlIlIlIIlIIlIIl);
                            final AxisAlignedBB lllllllllllIllIlIIlIlIlIIIllllll = lllllllllllIllIlIIlIlIlIIlIIIIll.getEntityBoundingBox();
                            if (lllllllllllIllIlIIlIlIlIIlIIIIII.intersectsWith(lllllllllllIllIlIIlIlIlIIIllllll)) {
                                lllllllllllIllIlIIlIlIlIIlIIIIlI = Math.max(lllllllllllIllIlIIlIlIlIIlIIIIlI, this.func_190612_a(lllllllllllIllIlIIlIlIlIIlIIIIII, lllllllllllIllIlIIlIlIlIIlIIlIlI, lllllllllllIllIlIIlIlIlIIIllllll));
                                if (lllllllllllIllIlIIlIlIlIIlIIIIlI >= lllllllllllIllIlIIlIlIlIIlIIlIIl) {
                                    break;
                                }
                            }
                        }
                        if (lllllllllllIllIlIIlIlIlIIlIIIIlI > 0.0) {
                            lllllllllllIllIlIIlIlIlIIlIIIIlI = Math.min(lllllllllllIllIlIIlIlIlIIlIIIIlI, lllllllllllIllIlIIlIlIlIIlIIlIIl) + 0.01;
                            TileEntityPiston.field_190613_i.set(lllllllllllIllIlIIlIlIlIIlIIlIlI);
                            lllllllllllIllIlIIlIlIlIIlIIIIll.moveEntity(MoverType.PISTON, lllllllllllIllIlIIlIlIlIIlIIIIlI * lllllllllllIllIlIIlIlIlIIlIIlIlI.getFrontOffsetX(), lllllllllllIllIlIIlIlIlIIlIIIIlI * lllllllllllIllIlIIlIlIlIIlIIlIlI.getFrontOffsetY(), lllllllllllIllIlIIlIlIlIIlIIIIlI * lllllllllllIllIlIIlIlIlIIlIIlIlI.getFrontOffsetZ());
                            TileEntityPiston.field_190613_i.set(null);
                            if (!this.extending && this.shouldHeadBeRendered) {
                                this.func_190605_a(lllllllllllIllIlIIlIlIlIIlIIIIll, lllllllllllIllIlIIlIlIlIIlIIlIlI, lllllllllllIllIlIIlIlIlIIlIIlIIl);
                            }
                        }
                    }
                }
            }
        }
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = TileEntityPiston.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final double lllllllllllIllIlIIlIlIIlIlllIlIl = (Object)new int[EnumFacing.values().length];
        try {
            lllllllllllIllIlIIlIlIIlIlllIlIl[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllIllIlIIlIlIIlIlllIlIl[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllIllIlIIlIlIIlIlllIlIl[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllIllIlIIlIlIIlIlllIlIl[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllIllIlIIlIlIIlIlllIlIl[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllIllIlIIlIlIIlIlllIlIl[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return TileEntityPiston.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)lllllllllllIllIlIIlIlIIlIlllIlIl;
    }
    
    public float getOffsetY(final float lllllllllllIllIlIIlIlIlIlIIIIlII) {
        return this.pistonFacing.getFrontOffsetY() * this.getExtendedProgress(this.getProgress(lllllllllllIllIlIIlIlIlIlIIIIlII));
    }
    
    public boolean shouldPistonHeadBeRendered() {
        return this.shouldHeadBeRendered;
    }
    
    private AxisAlignedBB func_190607_a(final AxisAlignedBB lllllllllllIllIlIIlIlIlIIIIIIlll) {
        final double lllllllllllIllIlIIlIlIlIIIIIIllI = this.getExtendedProgress(this.progress);
        return lllllllllllIllIlIIlIlIlIIIIIIlll.offset(this.pos.getX() + lllllllllllIllIlIIlIlIlIIIIIIllI * this.pistonFacing.getFrontOffsetX(), this.pos.getY() + lllllllllllIllIlIIlIlIlIIIIIIllI * this.pistonFacing.getFrontOffsetY(), this.pos.getZ() + lllllllllllIllIlIIlIlIlIIIIIIllI * this.pistonFacing.getFrontOffsetZ());
    }
}
